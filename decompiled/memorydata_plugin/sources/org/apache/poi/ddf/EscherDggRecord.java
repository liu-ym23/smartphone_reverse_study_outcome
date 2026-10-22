package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.zaxxer.sparsebits.SparseBitSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes6.dex */
public final class EscherDggRecord extends EscherRecord {
    public static final short RECORD_ID = 0;
    private int field_1_shapeIdMax;
    private int field_3_numShapesSaved;
    private int field_4_drawingsSaved;
    private final List<FileIdCluster> field_5_fileIdClusters;
    private int maxDgId;

    public static class FileIdCluster implements GenericRecord {
        private int field_1_drawingGroupId;
        private int field_2_numShapeIdsUsed;

        public FileIdCluster(int r1, int r2) {
            this.field_1_drawingGroupId = r1;
            this.field_2_numShapeIdsUsed = r2;
        }

        static /* synthetic */ void access$000(FileIdCluster r0) {
            r0.incrementUsedShapeId();
        }

        static /* synthetic */ int access$100(FileIdCluster r0, FileIdCluster r1) {
            return compareFileIdCluster(r0, r1);
        }

        private static int compareFileIdCluster(FileIdCluster r2, FileIdCluster r3) {
            int r0 = r2.getDrawingGroupId() - r3.getDrawingGroupId();
            int r4 = r3.getNumShapeIdsUsed() - r2.getNumShapeIdsUsed();
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return r4;
        }

        private void incrementUsedShapeId() {
            this.field_2_numShapeIdsUsed++;
        }

        public int getDrawingGroupId() {
            return this.field_1_drawingGroupId;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("drawingGroupId", new $$Lambda$pq_6SZ5Tn1BDuvW7FyiqDboMxkc(this), "numShapeIdUsed", new $$Lambda$UJnRUCD_xQQNUqhkf1Xi3F31AKY(this));
        }

        public int getNumShapeIdsUsed() {
            return this.field_2_numShapeIdsUsed;
        }
    }

    static {
        RECORD_ID = EscherRecordTypes.DGG.typeID;
    }

    public EscherDggRecord() {
        this.field_5_fileIdClusters = new ArrayList();
    }

    static /* synthetic */ int lambda$sortCluster$0(FileIdCluster r0, FileIdCluster r1) {
        return FileIdCluster.access$100(r0, r1);
    }

    private void sortCluster() {
        this.field_5_fileIdClusters.sort($$Lambda$EscherDggRecord$PibL9lqAqdOMztEw_bWund3eCvU.INSTANCE);
    }

    public FileIdCluster addCluster(int r2, int r3, boolean r4) {
        FileIdCluster r0 = new FileIdCluster(r2, r3);
        this.field_5_fileIdClusters.add(r0);
        this.maxDgId = Math.min(this.maxDgId, r2);
        if (r4 == false) goto L5;
        sortCluster();
    L5:
        return r0;
    }

    public int allocateShapeId(EscherDgRecord r9, boolean r10) {
        short r0 = r9.getDrawingGroupId();
        this.field_3_numShapesSaved++;
        Iterator<FileIdCluster> r1 = this.field_5_fileIdClusters.iterator();
        int r3 = 1;
    L4:
        if (r1.hasNext() == false) goto L11;
        FileIdCluster r4 = (FileIdCluster) ZeusTransformUtils.preCheckCast(r1.next(), FileIdCluster.class, "com.obric.memorydata.plugin");
        if (r4.getDrawingGroupId() != r0) goto L10;
        if (r4.getNumShapeIdsUsed() >= 1024) goto L10;
    L12:
        if (r4 != null) goto L14;
        r4 = addCluster(r0, 0, r10);
        this.maxDgId = Math.max(this.maxDgId, r0);
    L14:
        int r5 = (r3 * 1024) + r4.getNumShapeIdsUsed();
        FileIdCluster.access$000(r4);
        r9.setNumShapes(r9.getNumShapes() + 1);
        r9.setLastMSOSPID(r5);
        this.field_1_shapeIdMax = Math.max(this.field_1_shapeIdMax, r5 + 1);
        return r5;
    L10:
        r3 = r3 + 1;
        goto L4
    L11:
        r4 = null;
        goto L12
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] r7, int r8, EscherRecordFactory r9) {
        EscherRecordFactory r10 = (EscherRecordFactory) ZeusTransformUtils.wrapperContextForParams(r9, EscherRecordFactory.class, "com.obric.memorydata.plugin");
        int r11 = readHeader(r7, r8);
        int r12 = r8 + 8;
        this.field_1_shapeIdMax = LittleEndian.getInt(r7, r12 + 0);
        this.field_3_numShapesSaved = LittleEndian.getInt(r7, r12 + 8);
        this.field_4_drawingsSaved = LittleEndian.getInt(r7, r12 + 12);
        this.field_5_fileIdClusters.clear();
        int r0 = (r11 - 16) / 8;
        int r1 = 0;
        int r2 = 16;
    L3:
        if (r1 >= r0) goto L5;
        int r3 = r12 + r2;
        int r4 = LittleEndian.getInt(r7, r3);
        this.field_5_fileIdClusters.add(new FileIdCluster(r4, LittleEndian.getInt(r7, r3 + 4)));
        this.maxDgId = Math.max(this.maxDgId, r4);
        r2 = r2 + 8;
        r1 = r1 + 1;
        goto L3
    L5:
        int r13 = r11 - r2;
        if (r13 != 0) goto L10;
        return r2 + 8;
    L10:
        throw new RecordFormatException("Expecting no remaining data but got " + r13 + " byte(s).");
    }

    public short findNewDrawingGroupId() {
        SparseBitSet r0 = new SparseBitSet();
        r0.set(0);
        Iterator<FileIdCluster> r5 = this.field_5_fileIdClusters.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        r0.set(((FileIdCluster) ZeusTransformUtils.preCheckCast(r5.next(), FileIdCluster.class, "com.obric.memorydata.plugin")).getDrawingGroupId());
        goto L4
    L7:
        return (short) r0.nextClearBit(0);
    }

    public int getDrawingsSaved() {
        return this.field_4_drawingsSaved;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$EscherDggRecord$HaFWFP85ZF6saa6kWPdFnWXL1Y(this), "fileIdClusters", new $$Lambda$EscherDggRecord$2xhYGzJx3xKmuBd1nbAboTtPwZ0(this), "shapeIdMax", new $$Lambda$aRZbLkQqKOKWfGZAwVTYIRBptWw(this), "numIdClusters", new $$Lambda$torPPFzorMd6sBW2O2RbnZqy20g(this), "numShapesSaved", new $$Lambda$9pbtCWqsSV2tPkjXQ_sk8yr9iyY(this), "drawingsSaved", new $$Lambda$VRlpHRwEPUxvvn_iz5Oh8f3krk(this));
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.DGG;
    }

    public int getNumIdClusters() {
        if (this.field_5_fileIdClusters.isEmpty() == false) goto L6;
        return 0;
    L6:
        return this.field_5_fileIdClusters.size() + 1;
    }

    public int getNumShapesSaved() {
        return this.field_3_numShapesSaved;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return (this.field_5_fileIdClusters.size() * 8) + 24;
    }

    public int getShapeIdMax() {
        return this.field_1_shapeIdMax;
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$EscherDggRecord() {
        return super.getGenericProperties();
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$EscherDggRecord() {
        return this.field_5_fileIdClusters;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int r5, byte[] r6, EscherSerializationListener r7) {
        EscherSerializationListener r8 = (EscherSerializationListener) ZeusTransformUtils.wrapperContextForParams(r7, EscherSerializationListener.class, "com.obric.memorydata.plugin");
        r8.beforeRecordSerialize(r5, getRecordId(), this);
        LittleEndian.putShort(r6, r5, getOptions());
        int r9 = r5 + 2;
        LittleEndian.putShort(r6, r9, getRecordId());
        int r10 = r9 + 2;
        LittleEndian.putInt(r6, r10, getRecordSize() - 8);
        int r11 = r10 + 4;
        LittleEndian.putInt(r6, r11, this.field_1_shapeIdMax);
        int r12 = r11 + 4;
        LittleEndian.putInt(r6, r12, getNumIdClusters());
        int r13 = r12 + 4;
        LittleEndian.putInt(r6, r13, this.field_3_numShapesSaved);
        int r14 = r13 + 4;
        LittleEndian.putInt(r6, r14, this.field_4_drawingsSaved);
        int r15 = r14 + 4;
        Iterator<FileIdCluster> r0 = this.field_5_fileIdClusters.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        FileIdCluster r2 = (FileIdCluster) ZeusTransformUtils.preCheckCast(r0.next(), FileIdCluster.class, "com.obric.memorydata.plugin");
        LittleEndian.putInt(r6, r15, r2.getDrawingGroupId());
        int r16 = r15 + 4;
        LittleEndian.putInt(r6, r16, r2.getNumShapeIdsUsed());
        r15 = r16 + 4;
        goto L4
    L6:
        r8.afterRecordSerialize(r15, getRecordId(), getRecordSize(), this);
        return getRecordSize();
    }

    public void setDrawingsSaved(int r1) {
        this.field_4_drawingsSaved = r1;
    }

    public void setFileIdClusters(FileIdCluster[] r2) {
        this.field_5_fileIdClusters.clear();
        if (r2 == null) goto L6;
        this.field_5_fileIdClusters.addAll(Arrays.asList(r2));
        return;
    }

    public void setNumShapesSaved(int r1) {
        this.field_3_numShapesSaved = r1;
    }

    public void setShapeIdMax(int r1) {
        this.field_1_shapeIdMax = r1;
    }
}
