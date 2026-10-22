package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class CatLabRecord extends StandardRecord {
    private short at;
    private short grbit;
    private short grbitFrt;
    private short rt;
    private Short unused;
    private short wOffset;

    public CatLabRecord(RecordInputStream r2) {
        this.rt = r2.readShort();
        this.grbitFrt = r2.readShort();
        this.wOffset = r2.readShort();
        this.at = r2.readShort();
        this.grbit = r2.readShort();
        if (r2.available() != 0) goto L5;
        Short r3 = null;
    L6:
        this.unused = r3;
        return;
    L5:
        r3 = Short.valueOf(r2.readShort());
        goto L6
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        if (this.unused != null) goto L5;
        int r0 = 0;
    L7:
        return r0 + 10;
    L5:
        r0 = 2;
        goto L7
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("rt", new $$Lambda$CatLabRecord$lSxIo4RjiiqdvqY4Gq6pplejgho(this), "grbitFrt", new $$Lambda$CatLabRecord$Yo1TFH0R6DQfVOcfn5d5fEdUPA(this), "wOffset", new $$Lambda$CatLabRecord$acjXKsf8yWMNNkQOtjsoBZzWSF4(this), "at", new $$Lambda$CatLabRecord$a5Ca3uJPLGsSrehgfidR9_0O6I(this), "grbit", new $$Lambda$CatLabRecord$8o4C32z96TXnqRFsKi2WYYfy8U(this), "unused", new $$Lambda$CatLabRecord$RndcA_q0y0J3xpYRnwHNXZ2KDQY(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CAT_LAB;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 2134;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$CatLabRecord() {
        return Short.valueOf(this.rt);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$CatLabRecord() {
        return Short.valueOf(this.grbitFrt);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$CatLabRecord() {
        return Short.valueOf(this.wOffset);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$CatLabRecord() {
        return Short.valueOf(this.at);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$CatLabRecord() {
        return Short.valueOf(this.grbit);
    }

    public /* synthetic */ Object lambda$getGenericProperties$5$CatLabRecord() {
        return this.unused;
    }
}
