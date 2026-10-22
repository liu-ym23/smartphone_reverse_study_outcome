package org.apache.poi.hssf.record.pivottable;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class PageItemRecord extends StandardRecord {
    private final FieldInfo[] _fieldInfos;

    private static final class FieldInfo implements GenericRecord {
        private int _idObj;
        private int _isxvd;
        private int _isxvi;

        public FieldInfo(RecordInputStream r2) {
            this._isxvi = r2.readShort();
            this._isxvd = r2.readShort();
            this._idObj = r2.readShort();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("isxvi", new $$Lambda$PageItemRecord$FieldInfo$sVrXLEgqguOuU8_tnVtyqzVmwA(this), "isxvd", new $$Lambda$PageItemRecord$FieldInfo$4nDhyry3zR3PQPFqj6Ec0kaIgrA(this), "idObj", new $$Lambda$PageItemRecord$FieldInfo$cv8F9ecQfImqFpCruWOZakKkakU(this));
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$PageItemRecord$FieldInfo() {
            return Integer.valueOf(this._isxvi);
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$PageItemRecord$FieldInfo() {
            return Integer.valueOf(this._isxvd);
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$PageItemRecord$FieldInfo() {
            return Integer.valueOf(this._idObj);
        }
    }

    public PageItemRecord(RecordInputStream r5) {
        int r0 = r5.remaining();
        if ((r0 % 6) != 0) goto L10;
        int r1 = r0 / 6;
        FieldInfo[] r2 = new FieldInfo[r1];
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L7;
        r2[r3] = new FieldInfo(r5);
        r3 = r3 + 1;
        goto L5
    L7:
        this._fieldInfos = r2;
        return;
    L10:
        throw new RecordFormatException("Bad data size " + r0);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this._fieldInfos.length * 6;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("fieldInfos", new $$Lambda$PageItemRecord$Dm4hYydGL9Za3IqHYTUqNg0Ca0(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.PAGE_ITEM;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 182;
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$PageItemRecord() {
        return this._fieldInfos;
    }
}
