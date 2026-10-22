package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.common.FtrHeader;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class FeatHdrRecord extends StandardRecord {
    private long cbHdrData;
    private final FtrHeader futureHeader;
    private int isf_sharedFeatureType;
    private byte reserved;
    private byte[] rgbHdrData;

    public FeatHdrRecord() {
        FtrHeader r0 = new FtrHeader();
        this.futureHeader = r0;
        r0.setRecordType(2151);
    }

    public FeatHdrRecord(RecordInputStream r3) {
        this.futureHeader = new FtrHeader(r3);
        this.isf_sharedFeatureType = r3.readShort();
        this.reserved = r3.readByte();
        this.cbHdrData = r3.readInt();
        this.rgbHdrData = r3.readRemainder();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this.rgbHdrData.length + 19;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("futureHeader", new $$Lambda$FeatHdrRecord$sTZ3nDRsXRafEjUMVfCU85bnHs(this), "isf_sharedFeatureType", new $$Lambda$FeatHdrRecord$pm4H64ia22R7R_CfT2Uh4oG6PDo(this), "reserved", new $$Lambda$FeatHdrRecord$AP_zbhx5ssVpJKxdNot28rybHFY(this), "cbHdrData", new $$Lambda$FeatHdrRecord$5l175LrCuiRoyj6VkOirS6Va3I(this), "rgbHdrData", new $$Lambda$FeatHdrRecord$pg2m8hCKJ0wWJ4RnaZ40ciUAge8(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FEAT_HDR;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 2151;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$FeatHdrRecord() {
        return this.futureHeader;
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$FeatHdrRecord() {
        return Integer.valueOf(this.isf_sharedFeatureType);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$FeatHdrRecord() {
        return Byte.valueOf(this.reserved);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$FeatHdrRecord() {
        return Long.valueOf(this.cbHdrData);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$FeatHdrRecord() {
        return this.rgbHdrData;
    }
}
