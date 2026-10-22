package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class DSFRecord extends StandardRecord {
    private static final BitField biff5BookStreamFlag = null;
    private int _options;

    static {
        biff5BookStreamFlag = BitFieldFactory.getInstance(1);
    }

    private DSFRecord(int r1) {
        this._options = r1;
    }

    public DSFRecord(RecordInputStream r1) {
        this(r1.readShort());
    }

    public DSFRecord(boolean r3) {
        this(0);
        this._options = biff5BookStreamFlag.setBoolean(0, r3);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("options", new $$Lambda$DSFRecord$e6pMh8WQ66L2yqcCbX9APHGTOo(this), "biff5BookStreamPresent", new $$Lambda$Prh69qVImn9iOv8ujVds2W3lraE(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DSF;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 353;
    }

    public boolean isBiff5BookStreamPresent() {
        return biff5BookStreamFlag.isSet(this._options);
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$DSFRecord() {
        return Integer.valueOf(this._options);
    }
}
