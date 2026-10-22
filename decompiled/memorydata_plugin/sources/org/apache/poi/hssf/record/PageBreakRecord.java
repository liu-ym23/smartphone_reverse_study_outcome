package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public abstract class PageBreakRecord extends StandardRecord {
    private static final int[] EMPTY_INT_ARRAY = null;
    private final Map<Integer, Break> _breakMap;
    private final ArrayList<Break> _breaks;

    public static final class Break implements GenericRecord {
        private int main;
        private int subFrom;
        private int subTo;

        public Break(RecordInputStream r2) {
            this.main = r2.readUShort() - 1;
            this.subFrom = r2.readUShort();
            this.subTo = r2.readUShort();
        }

        static /* synthetic */ int access$000(Break r0) {
            return r0.main;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("main", new $$Lambda$PageBreakRecord$Break$Kczz9GAzNDD8AkiDdP3l4wizQpA(this), "subFrom", new $$Lambda$PageBreakRecord$Break$vQvKuIgviL5HJm9JyBrutYEbCo(this), "subTo", new $$Lambda$PageBreakRecord$Break$RyZO59ddmmXsq2CPxxOe3msiWN4(this));
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$PageBreakRecord$Break() {
            return Integer.valueOf(this.main);
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$PageBreakRecord$Break() {
            return Integer.valueOf(this.subFrom);
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$PageBreakRecord$Break() {
            return Integer.valueOf(this.subTo);
        }
    }

    static {
        EMPTY_INT_ARRAY = new int[0];
    }

    public PageBreakRecord() {
        this._breaks = new ArrayList();
        this._breakMap = new HashMap();
    }

    public PageBreakRecord(RecordInputStream r5) {
        ArrayList<Break> r0 = new ArrayList();
        this._breaks = r0;
        this._breakMap = new HashMap();
        short r1 = r5.readShort();
        r0.ensureCapacity(r1 + 2);
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        this._breaks.add(new Break(r5));
        r2 = r2 + 1;
        goto L3
    L5:
        initMap();
    }

    private void initMap() {
        this._breaks.forEach(new $$Lambda$PageBreakRecord$JCTlB2BN7sFTbUHIYKdRWImn1ng(this));
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this._breaks.size() * 6) + 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("numBreaks", new $$Lambda$LFAU145p8ODpp2XYYXMYRk2UJME(this), "breaks", new $$Lambda$PageBreakRecord$5Jgqu5cIVjjHKs1W2s4Q2siKP88(this));
    }

    public int getNumBreaks() {
        return this._breaks.size();
    }

    public boolean isEmpty() {
        return this._breaks.isEmpty();
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$PageBreakRecord() {
        return this._breaks;
    }

    public /* synthetic */ void lambda$initMap$0$PageBreakRecord(Break r2) {
        Break r1 = (Break) ZeusTransformUtils.preCheckCast(this._breakMap.put(Integer.valueOf(Break.access$000(r2)), r2), Break.class, "com.obric.memorydata.plugin");
    }
}
