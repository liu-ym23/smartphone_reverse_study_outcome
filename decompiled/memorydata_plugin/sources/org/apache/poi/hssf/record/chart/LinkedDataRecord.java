package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class LinkedDataRecord extends StandardRecord {
    private static final BitField customNumberFormat = null;
    private byte field_1_linkType;
    private byte field_2_referenceType;
    private short field_3_options;
    private short field_4_indexNumberFmtRecord;
    private Formula field_5_formulaOfLink;

    static {
        customNumberFormat = BitFieldFactory.getInstance(1);
    }

    public LinkedDataRecord() {
    }

    public LinkedDataRecord(RecordInputStream r2) {
        this.field_1_linkType = r2.readByte();
        this.field_2_referenceType = r2.readByte();
        this.field_3_options = r2.readShort();
        this.field_4_indexNumberFmtRecord = r2.readShort();
        this.field_5_formulaOfLink = Formula.read(r2.readUShort(), r2);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this.field_5_formulaOfLink.getEncodedSize() + 6;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("linkType", GenericRecordUtil.getEnumBitsAsString(new $$Lambda$WTbxnu5ZzMS20KjvCu8b08lO4KU(this), new int[]{0, 1, 2, 3}, new String[]{"TITLE_OR_TEXT", "VALUES", "CATEGORIES", "SECONDARY_CATEGORIES"}), "referenceType", GenericRecordUtil.getEnumBitsAsString(new $$Lambda$XxUjvDMQ0D8phO_u9HYy8yhSrwc(this), new int[]{0, 1, 2, 3, 4}, new String[]{"DEFAULT_CATEGORIES", "DIRECT", "WORKSHEET", "NOT_USED", "ERROR_REPORTED"}), "options", new $$Lambda$1CFQE7c0qn6qEgc6WVOPUrCG4U(this), "customNumberFormat", new $$Lambda$L3JM3H_kNt9KTiulcG3jGgiFqw(this), "indexNumberFmtRecord", new $$Lambda$lunX1ySuJxavbRhd54sHnuN4fiQ(this), "formulaOfLink", new $$Lambda$LinkedDataRecord$2XKMmtmyPQpaBedjgIktCL_FaI(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.LINKED_DATA;
    }

    public short getIndexNumberFmtRecord() {
        return this.field_4_indexNumberFmtRecord;
    }

    public byte getLinkType() {
        return this.field_1_linkType;
    }

    public short getOptions() {
        return this.field_3_options;
    }

    public byte getReferenceType() {
        return this.field_2_referenceType;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4177;
    }

    public boolean isCustomNumberFormat() {
        return customNumberFormat.isSet(this.field_3_options);
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$LinkedDataRecord() {
        return this.field_5_formulaOfLink;
    }
}
