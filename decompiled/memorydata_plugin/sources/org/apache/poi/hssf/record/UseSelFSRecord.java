package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class UseSelFSRecord extends StandardRecord {
    private static final BitField useNaturalLanguageFormulasFlag = null;
    private int _options;

    static {
        useNaturalLanguageFormulasFlag = BitFieldFactory.getInstance(1);
    }

    private UseSelFSRecord(int r1) {
        this._options = r1;
    }

    public UseSelFSRecord(RecordInputStream r1) {
        this(r1.readUShort());
    }

    public UseSelFSRecord(boolean r3) {
        this(0);
        this._options = useNaturalLanguageFormulasFlag.setBoolean(this._options, r3);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("options", GenericRecordUtil.getBitsAsString(new $$Lambda$UseSelFSRecord$OGZCwIfs3N753zN7sCkC6iQDfV8(this), new BitField[]{useNaturalLanguageFormulasFlag}, new String[]{"USE_NATURAL_LANGUAGE_FORMULAS_FLAG"}));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.USE_SEL_FS;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 352;
    }

    public /* synthetic */ Number lambda$getGenericProperties$0$UseSelFSRecord() {
        return Integer.valueOf(this._options);
    }
}
