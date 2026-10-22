package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.hssf.record.cont.ContinuableRecord;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IntMapper;

/* JADX INFO: loaded from: classes7.dex */
public final class SSTRecord extends ContinuableRecord {
    private static final UnicodeString EMPTY_STRING = null;
    private int[] bucketAbsoluteOffsets;
    private int[] bucketRelativeOffsets;
    private final SSTDeserializer deserializer;
    private int field_1_num_strings;
    private int field_2_num_unique_strings;
    private final IntMapper<UnicodeString> field_3_strings;

    static {
        EMPTY_STRING = new UnicodeString("");
    }

    public SSTRecord() {
        this.field_1_num_strings = 0;
        this.field_2_num_unique_strings = 0;
        IntMapper<UnicodeString> r0 = new IntMapper();
        this.field_3_strings = r0;
        this.deserializer = new SSTDeserializer(r0);
    }

    public SSTRecord(RecordInputStream r3) {
        this.field_1_num_strings = r3.readInt();
        this.field_2_num_unique_strings = r3.readInt();
        IntMapper<UnicodeString> r0 = new IntMapper();
        this.field_3_strings = r0;
        SSTDeserializer r1 = new SSTDeserializer(r0);
        this.deserializer = r1;
        if (this.field_1_num_strings != 0) goto L6;
        this.field_2_num_unique_strings = 0;
        return;
    L6:
        r1.manufactureStrings(this.field_2_num_unique_strings, r3);
    }

    public int addString(UnicodeString r3) {
        this.field_1_num_strings++;
        if (r3 != null) goto L5;
        r3 = EMPTY_STRING;
    L5:
        int r0 = this.field_3_strings.getIndex(r3);
        if (r0 != (-1)) goto L10;
        int r1 = this.field_3_strings.size();
        this.field_2_num_unique_strings++;
        SSTDeserializer.addToStringTable(this.field_3_strings, r3);
        return r1;
    L10:
        return r0;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        Supplier r1 = new $$Lambda$VYkwPdcPlz68mc7OdgsF8xEtG8Y(this);
        Supplier r3 = new $$Lambda$RoUwRNMcfnEjCbHdaRZM_udkpjE(this);
        final IntMapper<UnicodeString> r0 = this.field_3_strings;
        r0.getClass();
        return GenericRecordUtil.getGenericProperties("numStrings", r1, "numUniqueStrings", r3, "strings", new $$Lambda$cTZC1dsCNi2YL6h9wPNFw2DMEY(r0), "bucketAbsoluteOffsets", new $$Lambda$SSTRecord$YeDNvlEJULcQ_gVH82lTYDKTBo(this), "bucketRelativeOffsets", new $$Lambda$SSTRecord$_16xzYrFYcKB1gUlKqG2rKrU8AM(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SST;
    }

    public int getNumStrings() {
        return this.field_1_num_strings;
    }

    public int getNumUniqueStrings() {
        return this.field_2_num_unique_strings;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 252;
    }

    public UnicodeString getString(int r2) {
        return (UnicodeString) ZeusTransformUtils.preCheckCast(this.field_3_strings.get(r2), UnicodeString.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$SSTRecord() {
        return this.bucketAbsoluteOffsets;
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$SSTRecord() {
        return this.bucketRelativeOffsets;
    }

    @Override // org.apache.poi.hssf.record.cont.ContinuableRecord
    public void serialize(ContinuableRecordOutput r5) {
        SSTSerializer r0 = new SSTSerializer(this.field_3_strings, getNumStrings(), getNumUniqueStrings());
        r0.serialize(r5);
        this.bucketAbsoluteOffsets = r0.getBucketAbsoluteOffsets();
        this.bucketRelativeOffsets = r0.getBucketRelativeOffsets();
    }
}
