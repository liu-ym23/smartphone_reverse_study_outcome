package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class ExternSheetRecord extends StandardRecord {
    private final List<RefSubRecord> _list;

    private static final class RefSubRecord implements GenericRecord {
        private final int _extBookIndex;
        private int _firstSheetIndex;
        private int _lastSheetIndex;

        public RefSubRecord(int r1, int r2, int r3) {
            this._extBookIndex = r1;
            this._firstSheetIndex = r2;
            this._lastSheetIndex = r3;
        }

        public RefSubRecord(RecordInputStream r3) {
            this(r3.readShort(), r3.readShort(), r3.readShort());
        }

        public int getExtBookIndex() {
            return this._extBookIndex;
        }

        public int getFirstSheetIndex() {
            return this._firstSheetIndex;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("extBookIndex", new $$Lambda$kF8Pt4AcnnZdHr1OqspvK6xPkPM(this), "firstSheetIndex", new $$Lambda$YdXkqcNhhwO4N73Uylz5EQhtMI(this), "lastSheetIndex", new $$Lambda$P5rZNj74nRm2tNalG7GOqlm_C4(this));
        }

        public int getLastSheetIndex() {
            return this._lastSheetIndex;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public ExternSheetRecord() {
        this._list = new ArrayList();
    }

    public ExternSheetRecord(RecordInputStream r5) {
        this._list = new ArrayList();
        short r0 = r5.readShort();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        RefSubRecord r2 = new RefSubRecord(r5);
        this._list.add(r2);
        r1 = r1 + 1;
        goto L3
    }

    public static ExternSheetRecord combine(ExternSheetRecord[] r8) {
        ExternSheetRecord r0 = new ExternSheetRecord();
        int r1 = r8.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        ExternSheetRecord r4 = r8[r3];
        int r5 = r4.getNumOfREFRecords();
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L7;
        r0.addREFRecord(r4.getRef(r6));
        r6 = r6 + 1;
        goto L5
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        return r0;
    }

    private RefSubRecord getRef(int r2) {
        return (RefSubRecord) ZeusTransformUtils.preCheckCast(this._list.get(r2), RefSubRecord.class, "com.obric.memorydata.plugin");
    }

    public void addREFRecord(RefSubRecord r1) {
        this._list.add(r1);
    }

    public int addRef(int r3, int r4, int r5) {
        this._list.add(new RefSubRecord(r3, r4, r5));
        return this._list.size() - 1;
    }

    public int findRefIndexFromExtBookIndex(int r4) {
        int r0 = this._list.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (getRef(r1).getExtBookIndex() == r4) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this._list.size() * 6) + 2;
    }

    public int getExtbookIndexFromRefIndex(int r1) {
        return getRef(r1).getExtBookIndex();
    }

    public int getFirstSheetIndexFromRefIndex(int r1) {
        return getRef(r1).getFirstSheetIndex();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("refrec", new $$Lambda$ExternSheetRecord$J5dm98lZItW8q8vSYECz5eQKpk(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.EXTERN_SHEET;
    }

    public int getLastSheetIndexFromRefIndex(int r1) {
        return getRef(r1).getLastSheetIndex();
    }

    public int getNumOfREFRecords() {
        return this._list.size();
    }

    public int getNumOfRefs() {
        return this._list.size();
    }

    public int getRefIxForSheet(int r5, int r6, int r7) {
        int r0 = this._list.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        RefSubRecord r2 = getRef(r1);
        if (r2.getExtBookIndex() != r5) goto L12;
        if (r2.getFirstSheetIndex() != r6) goto L12;
        if (r2.getLastSheetIndex() != r7) goto L12;
        return r1;
    L12:
        r1 = r1 + 1;
        goto L3
    L13:
        return -1;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 23;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$ExternSheetRecord() {
        return this._list;
    }
}
