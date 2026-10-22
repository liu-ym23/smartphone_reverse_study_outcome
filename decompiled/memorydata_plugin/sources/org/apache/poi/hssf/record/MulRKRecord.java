package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.util.RKUtil;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class MulRKRecord extends StandardRecord {
    private final int field_1_row;
    private final short field_2_first_col;
    private final RkRec[] field_3_rks;
    private final short field_4_last_col;

    private static final class RkRec implements GenericRecord {
        public final int rk;
        public final short xf;

        private RkRec(RecordInputStream r2) {
            this.xf = r2.readShort();
            this.rk = r2.readInt();
        }

        public static RkRec[] parseRKs(RecordInputStream r4) {
            int r0 = (r4.remaining() - 2) / 6;
            RkRec[] r1 = new RkRec[r0];
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            r1[r2] = new RkRec(r4);
            r2 = r2 + 1;
            goto L3
        L5:
            return r1;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("xf", new $$Lambda$MulRKRecord$RkRec$3ftuXknasu1IBHyeJyfwYfaoKbg(this), "rk", new $$Lambda$MulRKRecord$RkRec$6DQ5CL4ZiU0x9HFtytCQl5xhXDY(this));
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$MulRKRecord$RkRec() {
            return Short.valueOf(this.xf);
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$MulRKRecord$RkRec() {
            return Integer.valueOf(this.rk);
        }
    }

    public MulRKRecord(RecordInputStream r2) {
        this.field_1_row = r2.readUShort();
        this.field_2_first_col = r2.readShort();
        this.field_3_rks = RkRec.parseRKs(r2);
        this.field_4_last_col = r2.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        throw new RecordFormatException("Sorry, you can't serialize MulRK in this release");
    }

    public short getFirstColumn() {
        return this.field_2_first_col;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("row", new $$Lambda$nhuj9BL76Dx013COqeWFwRFPMsc(this), "firstColumn", new $$Lambda$IwlFzPrHrFzwFbBV4MID8XvY4yE(this), "lastColumn", new $$Lambda$S_x3phy1CAYwbxASzgABDFs8ems(this), "rk", new $$Lambda$MulRKRecord$4zyg67FloawK1SYl74X5WQiU1hU(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.MUL_RK;
    }

    public short getLastColumn() {
        return this.field_4_last_col;
    }

    public int getNumColumns() {
        return (this.field_4_last_col - this.field_2_first_col) + 1;
    }

    public double getRKNumberAt(int r1) {
        return RKUtil.decodeNumber(this.field_3_rks[r1].rk);
    }

    public int getRow() {
        return this.field_1_row;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 189;
    }

    public short getXFAt(int r1) {
        return this.field_3_rks[r1].xf;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$MulRKRecord() {
        return this.field_3_rks;
    }
}
