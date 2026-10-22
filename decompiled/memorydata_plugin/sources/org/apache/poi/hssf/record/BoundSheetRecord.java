package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class BoundSheetRecord extends StandardRecord {
    private static final BitField hiddenFlag = null;
    private static final BitField veryHiddenFlag = null;
    private int field_1_position_of_BOF;
    private int field_2_option_flags;
    private int field_4_isMultibyteUnicode;
    private String field_5_sheetname;

    static {
        hiddenFlag = BitFieldFactory.getInstance(1);
        veryHiddenFlag = BitFieldFactory.getInstance(2);
    }

    public BoundSheetRecord(String r2) {
        this.field_2_option_flags = 0;
        setSheetname(r2);
    }

    public BoundSheetRecord(RecordInputStream r4) {
        byte[] r1 = new byte[4];
        r4.readPlain(r1, 0, 4);
        this.field_1_position_of_BOF = LittleEndian.getInt(r1);
        this.field_2_option_flags = r4.readUShort();
        int r0 = r4.readUByte();
        this.field_4_isMultibyteUnicode = r4.readByte();
        if (isMultibyte() == false) goto L5;
        String r5 = r4.readUnicodeLEString(r0);
    L6:
        this.field_5_sheetname = r5;
        return;
    L5:
        r5 = r4.readCompressedUnicode(r0);
        goto L6
    }

    private static int compareRecords(BoundSheetRecord r0, BoundSheetRecord r1) {
        return r0.getPositionOfBof() - r1.getPositionOfBof();
    }

    private boolean isMultibyte() {
        if ((this.field_4_isMultibyteUnicode & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static /* synthetic */ int lambda$cRhSfgsXZTecmaEcWHtMBsTbtig(BoundSheetRecord r0, BoundSheetRecord r1) {
        return compareRecords(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$i2S3OOW8A59adOoaqH-hlCCIM8Y, reason: not valid java name */
    public static /* synthetic */ boolean m3159lambda$i2S3OOW8A59adOoaqHhlCCIM8Y(BoundSheetRecord r0) {
        return r0.isMultibyte();
    }

    public static BoundSheetRecord[] orderByBofPosition(List<BoundSheetRecord> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        BoundSheetRecord[] r0 = new BoundSheetRecord[r3.size()];
        r3.toArray(r0);
        Arrays.sort(r0, $$Lambda$BoundSheetRecord$cRhSfgsXZTecmaEcWHtMBsTbtig.INSTANCE);
        return r0;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        int r0 = this.field_5_sheetname.length();
        if (isMultibyte() == false) goto L5;
        int r1 = 2;
    L7:
        return (r0 * r1) + 8;
    L5:
        r1 = 1;
        goto L7
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("bof", new $$Lambda$lPi8VVBplxAJ0d5poZ5_FFzHw(this), "optionFlags", new $$Lambda$BoundSheetRecord$9tqt0atDBzdtaWIDu04hiiCdqUc(this), "multiByte", new $$Lambda$BoundSheetRecord$i2S3OOW8A59adOoaqHhlCCIM8Y(this), "sheetName", new $$Lambda$o2lMsu2muTPLFpA0MDmwIKITc4E(this), "hidden", new $$Lambda$OiIDuELF03uRSr0lyzdswI82Id0(this), "veryHidden", new $$Lambda$_SoAct4RJ4puLJ81yGta1PX85_0(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.BOUND_SHEET;
    }

    public int getPositionOfBof() {
        return this.field_1_position_of_BOF;
    }

    public String getSheetname() {
        return this.field_5_sheetname;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 133;
    }

    public boolean isHidden() {
        return hiddenFlag.isSet(this.field_2_option_flags);
    }

    public boolean isVeryHidden() {
        return veryHiddenFlag.isSet(this.field_2_option_flags);
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$BoundSheetRecord() {
        return Integer.valueOf(this.field_2_option_flags);
    }

    public void setSheetname(String r1) {
        WorkbookUtil.validateSheetName(r1);
        this.field_5_sheetname = r1;
        this.field_4_isMultibyteUnicode = StringUtil.hasMultibyte(r1) ? 1 : 0;
    }
}
