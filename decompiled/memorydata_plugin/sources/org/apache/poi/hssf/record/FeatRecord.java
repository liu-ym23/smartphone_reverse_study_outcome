package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hssf.record.common.FeatFormulaErr2;
import org.apache.poi.hssf.record.common.FeatProtection;
import org.apache.poi.hssf.record.common.FeatSmartTag;
import org.apache.poi.hssf.record.common.FtrHeader;
import org.apache.poi.hssf.record.common.SharedFeature;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class FeatRecord extends StandardRecord {
    private static final c LOG = null;
    private long cbFeatData;
    private CellRangeAddress[] cellRefs;
    private final FtrHeader futureHeader;
    private int isf_sharedFeatureType;
    private byte reserved1;
    private long reserved2;
    private int reserved3;
    private SharedFeature sharedFeature;

    static {
        LOG = b.a(FeatRecord.class);
    }

    public FeatRecord() {
        FtrHeader r0 = new FtrHeader();
        this.futureHeader = r0;
        r0.setRecordType(2152);
    }

    public FeatRecord(RecordInputStream r4) {
        this.futureHeader = new FtrHeader(r4);
        this.isf_sharedFeatureType = r4.readShort();
        this.reserved1 = r4.readByte();
        this.reserved2 = r4.readInt();
        int r0 = r4.readUShort();
        this.cbFeatData = r4.readInt();
        this.reserved3 = r4.readShort();
        this.cellRefs = new CellRangeAddress[r0];
        int r1 = 0;
    L3:
        CellRangeAddress[] r2 = this.cellRefs;
        if (r1 >= r2.length) goto L6;
        r2[r1] = new CellRangeAddress(r4);
        r1 = r1 + 1;
        goto L3
    L6:
        int r3 = this.isf_sharedFeatureType;
        if (r3 != 2) goto L9;
        SharedFeature r5 = new FeatProtection(r4);
    L16:
        this.sharedFeature = r5;
        return;
    L9:
        if (r3 != 3) goto L11;
        r5 = new FeatFormulaErr2(r4);
        goto L16
    L11:
        if (r3 == 4) goto L13;
        LOG.atError().a("Unknown Shared Feature {} found!", v.a(this.isf_sharedFeatureType));
        return;
    L13:
        r5 = new FeatSmartTag(r4);
        goto L16
    }

    public long getCbFeatData() {
        return this.cbFeatData;
    }

    public CellRangeAddress[] getCellRefs() {
        return this.cellRefs;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return ((this.cellRefs.length * 8) + 27) + this.sharedFeature.getDataSize();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("futureHeader", new $$Lambda$FeatRecord$woHBjxUFv0xkWGW4iC6DP11B51k(this), "isf_sharedFeatureType", new $$Lambda$u_djHoxlej_5gkkWRGTTq2cfi0(this), "reserved1", new $$Lambda$FeatRecord$3IYvo1a7m8EXeJ2Pt8StLRLm8SM(this), "reserved2", new $$Lambda$FeatRecord$OxP8K4bOhvubUPCV4uZv7QNWs0I(this), "cbFeatData", new $$Lambda$aGrOUULd9VJo4eECytlUupiBlg(this), "reserved3", new $$Lambda$FeatRecord$Sl1mo4lVF_FPXV5BiS9G_da5hQ(this), "cellRefs", new $$Lambda$PRsHltwUzEi8z4CADdnJJSRancI(this), "sharedFeature", new $$Lambda$Stm587qCAJUulpOhrFX1R_YXa4Y(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FEAT;
    }

    public int getIsf_sharedFeatureType() {
        return this.isf_sharedFeatureType;
    }

    public SharedFeature getSharedFeature() {
        return this.sharedFeature;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 2152;
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$FeatRecord() {
        return this.futureHeader;
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$FeatRecord() {
        return Byte.valueOf(this.reserved1);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$FeatRecord() {
        return Long.valueOf(this.reserved2);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$FeatRecord() {
        return Integer.valueOf(this.reserved3);
    }
}
