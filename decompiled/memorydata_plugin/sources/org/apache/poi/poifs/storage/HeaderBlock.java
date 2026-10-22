package org.apache.poi.poifs.storage;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.apache.poi.hssf.OldExcelFormatException;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.common.POIFSConstants;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.NotOLE2FileException;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.IntegerField;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LongField;
import org.apache.poi.util.ShortField;

/* JADX INFO: loaded from: classes7.dex */
public final class HeaderBlock {
    private int _bat_count;
    private final byte[] _data;
    private int _property_start;
    private int _sbat_count;
    private int _sbat_start;
    private int _xbat_count;
    private int _xbat_start;
    private final POIFSBigBlockSize bigBlockSize;

    /* JADX INFO: renamed from: org.apache.poi.poifs.storage.HeaderBlock$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic = null;

        static {
            int[] r0 = new int[FileMagic.values().length];
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic = r0;
            r0[FileMagic.OLE2.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.OOXML.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.XML.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.MSWRITE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.WORD2.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.BIFF2.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.BIFF3.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.BIFF4.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public HeaderBlock(ByteBuffer r2) {
        this(IOUtils.toByteArray(r2, 512));
    }

    public HeaderBlock(POIFSBigBlockSize r6) {
        this.bigBlockSize = r6;
        byte[] r0 = new byte[512];
        this._data = r0;
        Arrays.fill(r0, (byte) -1);
        new LongField(0, -2226271756974174256L, r0);
        new IntegerField(8, 0, r0);
        new IntegerField(12, 0, r0);
        new IntegerField(16, 0, r0);
        new IntegerField(20, 0, r0);
        new ShortField(24, 59, r0);
        new ShortField(26, 3, r0);
        new ShortField(28, -2, r0);
        new ShortField(30, r6.getHeaderValue(), r0);
        new IntegerField(32, 6, r0);
        new IntegerField(36, 0, r0);
        new IntegerField(40, 0, r0);
        new IntegerField(52, 0, r0);
        new IntegerField(56, 4096, r0);
        this._bat_count = 0;
        this._sbat_count = 0;
        this._xbat_count = 0;
        this._property_start = -2;
        this._sbat_start = -2;
        this._xbat_start = -2;
    }

    private HeaderBlock(byte[] r5) {
        byte[] r0 = (byte[]) ZeusTransformUtils.preCheckCast(r5.clone(), byte[].class, "com.obric.memorydata.plugin");
        this._data = r0;
        FileMagic r1 = FileMagic.valueOf(r5);
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[r1.ordinal()]) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            default: goto L4;
        };
    L4:
        String r4 = HexDump.longToHex(-2226271756974174256L);
        throw new NotOLE2FileException("Invalid header signature; read " + HexDump.longToHex(LittleEndian.getLong(r5, 0)) + ", expected " + r4 + " - Your file appears not to be a valid OLE2 document");
    L7:
        throw new OldExcelFormatException("The supplied data appears to be in " + r1 + " format. HSSF only supports the BIFF8 format, try OldExcelExtractor");
    L9:
        throw new NotOLE2FileException("The supplied data appears to be an old Word version 2 file. Apache POI doesn't currently support this format");
    L11:
        throw new NotOLE2FileException("The supplied data appears to be in the old MS Write format. Apache POI doesn't currently support this format");
    L13:
        throw new NotOLE2FileException("The supplied data appears to be a raw XML file. Formats such as Office 2003 XML are not supported");
    L15:
        throw new OfficeXmlFileException("The supplied data appears to be in the Office 2007+ XML. You are calling the part of POI that deals with OLE2 Office Documents. You need to call a different part of POI to process this data (eg XSSF instead of HSSF)");
    L17:
        if (r0[30] != 12) goto L21;
        POIFSBigBlockSize r2 = POIFSConstants.LARGER_BIG_BLOCK_SIZE_DETAILS;
    L19:
        this.bigBlockSize = r2;
        this._bat_count = new IntegerField(44, r5).get();
        this._property_start = new IntegerField(48, r0).get();
        this._sbat_start = new IntegerField(60, r0).get();
        this._sbat_count = new IntegerField(64, r0).get();
        this._xbat_start = new IntegerField(68, r0).get();
        this._xbat_count = new IntegerField(72, r0).get();
        return;
    L21:
        if (r0[30] != 9) goto L26;
        r2 = POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS;
        goto L19
    L26:
        throw new IOException("Unsupported blocksize  (2^" + r0[30] + "). Expected 2^9 or 2^12.");
    }

    public int[] getBATArray() {
        int r0 = Math.min(this._bat_count, 109);
        int[] r1 = new int[r0];
        int r2 = 76;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = LittleEndian.getInt(this._data, r2);
        r2 = r2 + 4;
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public int getBATCount() {
        return this._bat_count;
    }

    public POIFSBigBlockSize getBigBlockSize() {
        return this.bigBlockSize;
    }

    public int getPropertyStart() {
        return this._property_start;
    }

    public int getSBATCount() {
        return this._sbat_count;
    }

    public int getSBATStart() {
        return this._sbat_start;
    }

    public int getXBATCount() {
        return this._xbat_count;
    }

    public int getXBATIndex() {
        return this._xbat_start;
    }

    public void setBATArray(int[] r8) {
        int r0 = Math.min(r8.length, 109);
        int r1 = 109 - r0;
        int r2 = 0;
        int r3 = 76;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L5;
        LittleEndian.putInt(this._data, r3, r8[r4]);
        r3 = r3 + 4;
        r4 = r4 + 1;
    L5:
        if (r2 >= r1) goto L7;
        LittleEndian.putInt(this._data, r3, -1);
        r3 = r3 + 4;
        r2 = r2 + 1;
        goto L5
    }

    public void setBATCount(int r1) {
        this._bat_count = r1;
    }

    public void setPropertyStart(int r1) {
        this._property_start = r1;
    }

    public void setSBATBlockCount(int r1) {
        this._sbat_count = r1;
    }

    public void setSBATStart(int r1) {
        this._sbat_start = r1;
    }

    public void setXBATCount(int r1) {
        this._xbat_count = r1;
    }

    public void setXBATStart(int r1) {
        this._xbat_start = r1;
    }
}
