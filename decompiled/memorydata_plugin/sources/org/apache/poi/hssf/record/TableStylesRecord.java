package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class TableStylesRecord extends StandardRecord {
    private int cts;
    private int grbitFrt;
    private String rgchDefListStyle;
    private String rgchDefPivotStyle;
    private int rt;
    private final byte[] unused;

    public TableStylesRecord(RecordInputStream r3) {
        byte[] r0 = new byte[8];
        this.unused = r0;
        this.rt = r3.readUShort();
        this.grbitFrt = r3.readUShort();
        r3.readFully(r0);
        this.cts = r3.readInt();
        int r1 = r3.readUShort();
        int r2 = r3.readUShort();
        this.rgchDefListStyle = r3.readUnicodeLEString(r1);
        this.rgchDefPivotStyle = r3.readUnicodeLEString(r2);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return ((this.rgchDefListStyle.length() * 2) + 20) + (this.rgchDefPivotStyle.length() * 2);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("rt", new $$Lambda$TableStylesRecord$LJSM65tVCNiSCmuq2d58ec76bkY(this), "grbitFrt", new $$Lambda$TableStylesRecord$TftIuJtqdwdOHJMF1X5ZImOfiAM(this), "unused", new $$Lambda$TableStylesRecord$f_S9xmJbUdiP0rkkz44Lq0vG4o(this), "cts", new $$Lambda$TableStylesRecord$7BhtcRap3jrh5gQkfdz6CNLaeXw(this), "rgchDefListStyle", new $$Lambda$TableStylesRecord$duqltNsVUDPKELCXyT7ZLmimwc8(this), "rgchDefPivotStyle", new $$Lambda$TableStylesRecord$9Xsyd1WrZEZGKfd32wNlMGMIw(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.TABLE_STYLES;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 2190;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$TableStylesRecord() {
        return Integer.valueOf(this.rt);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$TableStylesRecord() {
        return Integer.valueOf(this.grbitFrt);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$TableStylesRecord() {
        return this.unused;
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$TableStylesRecord() {
        return Integer.valueOf(this.cts);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$TableStylesRecord() {
        return this.rgchDefListStyle;
    }

    public /* synthetic */ Object lambda$getGenericProperties$5$TableStylesRecord() {
        return this.rgchDefPivotStyle;
    }
}
