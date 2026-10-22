package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class RefreshAllRecord extends StandardRecord {
    private static final BitField refreshFlag = null;
    private int _options;

    static {
        refreshFlag = BitFieldFactory.getInstance(1);
    }

    private RefreshAllRecord(int r1) {
        this._options = r1;
    }

    public RefreshAllRecord(RecordInputStream r1) {
        this(r1.readUShort());
    }

    public RefreshAllRecord(boolean r2) {
        this(0);
        setRefreshAll(r2);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("options", new $$Lambda$RefreshAllRecord$dLrPfLIImw8c90_bsqA9WTsZZMA(this), "refreshAll", new $$Lambda$jehFgPprWPeWwjYfPF5haaQspM(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.REFRESH_ALL;
    }

    public boolean getRefreshAll() {
        return refreshFlag.isSet(this._options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 439;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$RefreshAllRecord() {
        return Integer.valueOf(this._options);
    }

    public void setRefreshAll(boolean r3) {
        this._options = refreshFlag.setBoolean(this._options, r3);
    }
}
