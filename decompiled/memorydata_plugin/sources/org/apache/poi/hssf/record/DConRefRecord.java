package org.apache.poi.hssf.record;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public class DConRefRecord extends StandardRecord {
    private byte[] _unused;
    private final int charCount;
    private final int charType;
    private final int firstCol;
    private final int firstRow;
    private final int lastCol;
    private final int lastRow;
    private final byte[] path;

    public DConRefRecord(RecordInputStream r4) {
        if (r4.getSid() != 81) goto L9;
        this.firstRow = r4.readUShort();
        this.lastRow = r4.readUShort();
        this.firstCol = r4.readUByte();
        this.lastCol = r4.readUByte();
        int r0 = r4.readUShort();
        this.charCount = r0;
        int r1 = r4.readUByte() & 1;
        this.charType = r1;
        byte[] r2 = IOUtils.safelyAllocate(r0 * (r1 + 1), HSSFWorkbook.getMaxRecordLength());
        this.path = r2;
        r4.readFully(r2);
        if (r2[0] != 2) goto L10;
        this._unused = r4.readRemainder();
        return;
    L10:
        return;
    L9:
        throw new RecordFormatException("Wrong sid: " + r4.getSid());
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        byte[] r0 = this.path;
        int r1 = r0.length + 9;
        if (r0[0] == 2) goto L5;
        return r1;
    L5:
        return r1 + this._unused.length;
    }

    public int getFirstColumn() {
        return this.firstCol;
    }

    public int getFirstRow() {
        return this.firstRow;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("firstRow", new $$Lambda$QrD6OJrvFK1A70CMpPJ0uzAtVU(this), "lastRow", new $$Lambda$MxktVKu7bBBK_M83B3MMwVPyI(this), "firstColumn", new $$Lambda$gUsCmsna2vejP3EKcDvqw5LIJRo(this), "lastColumn", new $$Lambda$kfKjuTtR_AEIFgFiWXo6khogU(this), "charCount", new $$Lambda$DConRefRecord$_d5pbpziXiii3EajTPoMGwKQzSU(this), "charType", new $$Lambda$DConRefRecord$n6ZexaAfWEULFSFNN7iVzjBjs(this), "path", new $$Lambda$jXRd2FD6KnhuEVRHhZWC4YpdJOI(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DCON_REF;
    }

    public int getLastColumn() {
        return this.lastCol;
    }

    public int getLastRow() {
        return this.lastRow;
    }

    public String getReadablePath() {
        if (this.path == null) goto L12;
        int r0 = 1;
    L5:
        byte[] r1 = this.path;
        if (r0 >= r1.length) goto L10;
        if (r1[r0] >= 32) goto L10;
        r0 = r0 + 1;
    L10:
        byte[] r3 = this.path;
        return new String(Arrays.copyOfRange(r3, r0, r3.length), StringUtil.UTF8).replace("\u0003", "/");
    L12:
        return null;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 81;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$DConRefRecord() {
        return Integer.valueOf(this.charCount);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$DConRefRecord() {
        return Integer.valueOf(this.charType);
    }
}
