package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.cont.ContinuableRecord;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class ExtSSTRecord extends ContinuableRecord {
    private InfoSubRecord[] _sstInfos;
    private short _stringsPerBucket;

    public static final class InfoSubRecord implements GenericRecord {
        private int field_1_stream_pos;
        private int field_2_bucket_sst_offset;
        private short field_3_zero;

        public InfoSubRecord(RecordInputStream r2) {
            this.field_1_stream_pos = r2.readInt();
            this.field_2_bucket_sst_offset = r2.readShort();
            this.field_3_zero = r2.readShort();
        }

        public int getBucketSSTOffset() {
            return this.field_2_bucket_sst_offset;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("streamPos", new $$Lambda$W_PzpJFNlrne6Zply_2Uvh5sKis(this), "bucketSSTOffset", new $$Lambda$xZxlxDzDsi421sLMMpVM5SgdFnE(this));
        }

        public int getStreamPos() {
            return this.field_1_stream_pos;
        }

        public void serialize(LittleEndianOutput r3) {
            LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
            r4.writeInt(this.field_1_stream_pos);
            r4.writeShort(this.field_2_bucket_sst_offset);
            r4.writeShort(this.field_3_zero);
        }
    }

    public ExtSSTRecord() {
        this._stringsPerBucket = 8;
        this._sstInfos = new InfoSubRecord[0];
    }

    public ExtSSTRecord(RecordInputStream r4) {
        this._stringsPerBucket = r4.readShort();
        ArrayList r1 = new ArrayList(r4.remaining() / 8);
    L4:
        if (r4.available() <= 0) goto L12;
        r1.add(new InfoSubRecord(r4));
        if (r4.available() != 0) goto L4;
        if (r4.hasNextRecord() == false) goto L4;
        if (r4.getNextSid() != 60) goto L4;
        r4.nextRecord();
        goto L4
    L12:
        this._sstInfos = (InfoSubRecord[]) ZeusTransformUtils.preCheckCast(r1.toArray(new InfoSubRecord[0]), InfoSubRecord[].class, "com.obric.memorydata.plugin");
    }

    public static int getNumberOfInfoRecsForStrings(int r1) {
        int r0 = r1 / 8;
        if ((r1 % 8) == 0) goto L6;
        r0 = r0 + 1;
    L6:
        if (r0 > 128) goto L8;
        return r0;
    L8:
        return 128;
    }

    int getDataSize() {
        return (this._sstInfos.length * 8) + 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("dataSize", new $$Lambda$8QErVIVObjPvbOzH0oV78iGz3k(this), "infoSubRecords", new $$Lambda$s90qyNVOdkGdGOVKK1YSco9M5N0(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.EXT_SST;
    }

    InfoSubRecord[] getInfoSubRecords() {
        return this._sstInfos;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 255;
    }

    @Override // org.apache.poi.hssf.record.cont.ContinuableRecord
    public void serialize(ContinuableRecordOutput r4) {
        r4.writeShort(this._stringsPerBucket);
        InfoSubRecord[] r3 = this._sstInfos;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].serialize(r4);
        r1 = r1 + 1;
        goto L3
    }

    public void setNumStringsPerBucket(short r1) {
        this._stringsPerBucket = r1;
    }
}
