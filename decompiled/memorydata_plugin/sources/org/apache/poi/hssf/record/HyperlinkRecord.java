package org.apache.poi.hssf.record;

import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.hpsf.ClassIDPredefined;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.HexRead;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.StringUtil;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes7.dex */
public final class HyperlinkRecord extends StandardRecord {
    private static final byte[] FILE_TAIL = null;
    private static final c LOG = null;
    private static final int TAIL_SIZE = 0;
    private static final byte[] URL_TAIL = null;
    private String _address;
    private int _fileOpts;
    private ClassID _guid;
    private String _label;
    private int _linkOpts;
    private ClassID _moniker;
    private CellRangeAddress _range;
    private String _shortFilename;
    private String _targetFrame;
    private String _textMark;
    private byte[] _uninterpretedTail;

    static {
        LOG = b.a(HyperlinkRecord.class);
        URL_TAIL = HexRead.readFromString("79 58 81 F4  3B 1D 7F 48   AF 2C 82 5D  C4 85 27 63   00 00 00 00  A5 AB 00 00");
        byte[] r0 = HexRead.readFromString("FF FF AD DE  00 00 00 00   00 00 00 00  00 00 00 00   00 00 00 00  00 00 00 00");
        FILE_TAIL = r0;
        TAIL_SIZE = r0.length;
    }

    public HyperlinkRecord() {
    }

    public HyperlinkRecord(RecordInputStream r5) {
        this._range = new CellRangeAddress(r5);
        this._guid = new ClassID(r5);
        int r0 = r5.readInt();
        if (r0 != 2) goto L43;
        int r1 = r5.readInt();
        this._linkOpts = r1;
        if ((r1 & 20) == 0) goto L8;
        this._label = r5.readUnicodeLEString(r5.readInt());
    L8:
        if ((this._linkOpts & 128) == 0) goto L10;
        this._targetFrame = r5.readUnicodeLEString(r5.readInt());
    L10:
        int r2 = this._linkOpts;
        if ((r2 & 1) != 0) goto L13;
    L15:
        int r3 = this._linkOpts;
        if ((r3 & 1) == 0) goto L36;
        if ((r3 & 256) != 0) goto L36;
        this._moniker = new ClassID(r5);
        if (ClassIDPredefined.URL_MONIKER.equals(this._moniker) == false) goto L27;
        int r4 = r5.readInt();
        if (r4 != r5.remaining()) goto L25;
        String r6 = r5.readUnicodeLEString(r4 / 2);
    L24:
        this._address = r6;
        goto L36
    L25:
        this._address = r5.readUnicodeLEString((r4 - TAIL_SIZE) / 2);
        this._uninterpretedTail = readTail(URL_TAIL, r5);
        goto L36
    L27:
        if (ClassIDPredefined.FILE_MONIKER.equals(this._moniker) == false) goto L33;
        this._fileOpts = r5.readShort();
        this._shortFilename = StringUtil.readCompressedUnicode(r5, r5.readInt());
        this._uninterpretedTail = readTail(FILE_TAIL, r5);
        if (r5.readInt() <= 0) goto L31;
        int r7 = r5.readInt();
        r5.readUShort();
        r6 = StringUtil.readUnicodeLE(r5, r7 / 2);
        goto L24
    L31:
        this._address = null;
        goto L36
    L33:
        if (ClassIDPredefined.STD_MONIKER.equals(this._moniker) == false) goto L36;
        this._fileOpts = r5.readShort();
        byte[] r8 = IOUtils.safelyAllocate(r5.readInt(), HSSFWorkbook.getMaxRecordLength());
        r5.readFully(r8);
        this._address = new String(r8, StringUtil.UTF8);
    L36:
        if ((this._linkOpts & 8) == 0) goto L39;
        this._textMark = r5.readUnicodeLEString(r5.readInt());
    L39:
        if (r5.remaining() <= 0) goto L44;
        LOG.atWarn().a("Hyperlink data remains: {} : {}", v.a(r5.remaining()), HexDump.toHex(r5.readRemainder()));
        return;
    L44:
        return;
    L13:
        if ((r2 & 256) == 0) goto L15;
        this._moniker = null;
        this._address = r5.readUnicodeLEString(r5.readInt());
        goto L15
    L43:
        throw new RecordFormatException("Stream Version must be 0x2 but found " + r0);
    }

    private static String cleanString(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r1 = r2.indexOf(0);
        if (r1 >= 0) goto L9;
        return r2;
    L9:
        return r2.substring(0, r1);
    }

    private static byte[] readTail(byte[] r1, LittleEndianInput r2) {
        LittleEndianInput r3 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r2, LittleEndianInput.class, "com.obric.memorydata.plugin");
        byte[] r4 = new byte[TAIL_SIZE];
        r3.readFully(r4);
        return r4;
    }

    public String getAddress() {
        if ((this._linkOpts & 1) == 0) goto L13;
        if (ClassIDPredefined.FILE_MONIKER.equals(this._moniker) == false) goto L13;
        String r0 = this._address;
        if (r0 != null) goto L11;
        r0 = this._shortFilename;
    L11:
        return cleanString(r0);
    L13:
        if ((this._linkOpts & 8) == 0) goto L17;
        String r2 = this._textMark;
    L16:
        return cleanString(r2);
    L17:
        r2 = this._address;
        goto L16
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        if ((this._linkOpts & 20) == 0) goto L5;
        int r0 = 36 + (this._label.length() * 2);
    L7:
        if ((this._linkOpts & 128) == 0) goto L9;
        r0 = (r0 + 4) + (this._targetFrame.length() * 2);
    L9:
        int r1 = this._linkOpts;
        if ((r1 & 1) != 0) goto L12;
    L14:
        int r2 = this._linkOpts;
        if ((r2 & 1) == 0) goto L30;
        if ((r2 & 256) != 0) goto L30;
        r0 = r0 + 16;
        if (ClassIDPredefined.URL_MONIKER.equals(this._moniker) == false) goto L25;
        r0 = (r0 + 4) + (this._address.length() * 2);
        if (this._uninterpretedTail == null) goto L30;
        int r3 = TAIL_SIZE;
    L23:
        r0 = r0 + r3;
        goto L30
    L25:
        if (ClassIDPredefined.FILE_MONIKER.equals(this._moniker) == false) goto L30;
        r0 = ((((r0 + 2) + 4) + this._shortFilename.length()) + TAIL_SIZE) + 4;
        String r4 = this._address;
        if (r4 == null) goto L30;
        r0 = r0 + 6;
        r3 = r4.length() * 2;
    L30:
        if ((this._linkOpts & 8) != 0) goto L32;
        return r0;
    L32:
        return (r0 + 4) + (this._textMark.length() * 2);
    L12:
        if ((r1 & 256) == 0) goto L14;
        r0 = (r0 + 4) + (this._address.length() * 2);
        goto L14
    L5:
        r0 = 32;
        goto L7
    }

    public int getFirstColumn() {
        return this._range.getFirstColumn();
    }

    public int getFirstRow() {
        return this._range.getFirstRow();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("range", new $$Lambda$HyperlinkRecord$Udim6FNoILUvC1M9TG5W0roUr7w(this), "guid", new $$Lambda$2t_BtTVnTiN8ZzWuiPBZNDtShBc(this), "linkOpts", new $$Lambda$HyperlinkRecord$MFtJx7fUhs773lDgBMLE5XMnF1Y(this), AnnotatedPrivateKey.LABEL, new $$Lambda$wN24AUSIaT2o9W0hqE8SMnvEID8(this), "targetFrame", new $$Lambda$aRpBTTbsUu8NgkKu6ZaI22o2rvo(this), "moniker", new $$Lambda$O5KJGwipgSpSvUtFDTgsHWx7vg(this), "textMark", new $$Lambda$DNRHwsx5TzrDJlyOlKqXXSx4zUQ(this), MemoryKeyInfoEntity.KEY_ADDRESS, new $$Lambda$0NpqfQnXBHa3zWJlR7XWw8DqawY(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.HYPERLINK;
    }

    ClassID getGuid() {
        return this._guid;
    }

    public String getLabel() {
        return cleanString(this._label);
    }

    public int getLastColumn() {
        return this._range.getLastColumn();
    }

    public int getLastRow() {
        return this._range.getLastRow();
    }

    int getLinkOptions() {
        return this._linkOpts;
    }

    ClassID getMoniker() {
        return this._moniker;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 440;
    }

    public String getTargetFrame() {
        return cleanString(this._targetFrame);
    }

    public String getTextMark() {
        return cleanString(this._textMark);
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$HyperlinkRecord() {
        return this._range;
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$HyperlinkRecord() {
        return GenericRecordUtil.getBitsAsString(new $$Lambda$STf2nJrLv1fIn0N6zzUVCuHA57Q(this), new int[]{1, 2, 8, 20, 128, 256}, new String[]{"URL", "ABS", "PLACE", "LABEL", "TARGET_FRAME", "UNC_PATH"});
    }
}
