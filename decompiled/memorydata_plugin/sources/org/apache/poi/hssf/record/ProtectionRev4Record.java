package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class ProtectionRev4Record extends StandardRecord {
    private static final BitField protectedFlag = null;
    private int _options;

    static {
        protectedFlag = BitFieldFactory.getInstance(1);
    }

    private ProtectionRev4Record(int r1) {
        this._options = r1;
    }

    public ProtectionRev4Record(RecordInputStream r1) {
        this(r1.readUShort());
    }

    public ProtectionRev4Record(boolean r2) {
        this(0);
        setProtect(r2);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("options", new $$Lambda$ProtectionRev4Record$JEadJ_EMJFGNd5K3UmutzqI0Bho(this), "protect", new $$Lambda$zhMWCyqTHmYVyqdw0ItBcxT9pEs(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.PROTECTION_REV_4;
    }

    public boolean getProtect() {
        return protectedFlag.isSet(this._options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 431;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$ProtectionRev4Record() {
        return Integer.valueOf(this._options);
    }

    public void setProtect(boolean r3) {
        this._options = protectedFlag.setBoolean(this._options, r3);
    }
}
