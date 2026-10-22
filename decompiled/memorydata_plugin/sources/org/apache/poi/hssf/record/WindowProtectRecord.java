package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class WindowProtectRecord extends StandardRecord {
    private static final BitField settingsProtectedFlag = null;
    private int _options;

    static {
        settingsProtectedFlag = BitFieldFactory.getInstance(1);
    }

    public WindowProtectRecord(int r1) {
        this._options = r1;
    }

    public WindowProtectRecord(RecordInputStream r1) {
        this(r1.readUShort());
    }

    public WindowProtectRecord(boolean r2) {
        this(0);
        setProtect(r2);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("options", new $$Lambda$WindowProtectRecord$wla5GW_m6AYIfaoSP3uz9nYPc(this), "protect", new $$Lambda$0diXSQVFA0Y8CTZYpyxPVQwu3Y(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.WINDOW_PROTECT;
    }

    public boolean getProtect() {
        return settingsProtectedFlag.isSet(this._options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 25;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$WindowProtectRecord() {
        return Integer.valueOf(this._options);
    }

    public void setProtect(boolean r3) {
        this._options = settingsProtectedFlag.setBoolean(this._options, r3);
    }
}
