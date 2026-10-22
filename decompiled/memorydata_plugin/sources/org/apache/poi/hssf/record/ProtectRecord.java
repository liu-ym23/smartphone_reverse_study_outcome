package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class ProtectRecord extends StandardRecord {
    private static final BitField protectFlag = null;
    private int _options;

    static {
        protectFlag = BitFieldFactory.getInstance(1);
    }

    private ProtectRecord(int r1) {
        this._options = r1;
    }

    public ProtectRecord(RecordInputStream r1) {
        this(r1.readShort());
    }

    public ProtectRecord(boolean r2) {
        this(0);
        setProtect(r2);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("options", new $$Lambda$ProtectRecord$Kks4MbJDFMZu2HPK_caj6dR_A4(this), "protect", new $$Lambda$qOobcsU28ERyPOTuseFrLeJpXsI(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.PROTECT;
    }

    public boolean getProtect() {
        return protectFlag.isSet(this._options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 18;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$ProtectRecord() {
        return Integer.valueOf(this._options);
    }

    public void setProtect(boolean r3) {
        this._options = protectFlag.setBoolean(this._options, r3);
    }
}
