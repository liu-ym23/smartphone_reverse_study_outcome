package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherDgRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherSerializationListener;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.ddf.EscherSpgrRecord;
import org.apache.poi.ddf.EscherTextboxRecord;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
public final class EscherAggregate extends AbstractEscherHolderRecord {
    private static int MAX_RECORD_LENGTH = 100000000;
    private final Map<EscherRecord, Record> shapeToObj;
    private final Map<Integer, NoteRecord> tailRec;

    /* JADX INFO: renamed from: org.apache.poi.hssf.record.EscherAggregate$1, reason: invalid class name */
    class AnonymousClass1 implements EscherSerializationListener {
        final /* synthetic */ List val$shapes;
        final /* synthetic */ List val$spEndingOffsets;

        @Override // org.apache.poi.ddf.EscherSerializationListener
        public void afterRecordSerialize(int r1, short r2, int r3, EscherRecord r4) {
            if (r2 != EscherClientDataRecord.RECORD_ID) goto L5;
        L6:
            this.val$spEndingOffsets.add(Integer.valueOf(r1));
            this.val$shapes.add(r4);
            return;
        L5:
            if (r2 == EscherTextboxRecord.RECORD_ID) goto L6;
        }

        @Override // org.apache.poi.ddf.EscherSerializationListener
        public void beforeRecordSerialize(int r1, short r2, EscherRecord r3) {
        }
    }

    private static class ShapeCollector extends DefaultEscherRecordFactory {
        final UnsynchronizedByteArrayOutputStream buffer;
        final List<EscherRecord> objShapes;

        private ShapeCollector() {
            this.objShapes = new ArrayList();
            this.buffer = new UnsynchronizedByteArrayOutputStream();
        }

        /* synthetic */ ShapeCollector(AnonymousClass1 r1) {
            this();
        }

        void addBytes(byte[] r2) {
            this.buffer.write(r2);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new RuntimeException("Couldn't get data from drawing/continue records", e);
        }

        @Override // org.apache.poi.ddf.DefaultEscherRecordFactory, org.apache.poi.ddf.EscherRecordFactory
        public EscherRecord createRecord(byte[] r2, int r3) {
            EscherRecord r4 = super.createRecord(r2, r3);
            short r5 = r4.getRecordId();
            if (r5 != EscherClientDataRecord.RECORD_ID) goto L5;
        L6:
            this.objShapes.add(r4);
        L7:
            return r4;
        L5:
            if (r5 != EscherTextboxRecord.RECORD_ID) goto L7;
            goto L6
        }

        List<EscherRecord> parse(EscherAggregate r5) {
            byte[] r0 = this.buffer.toByteArray();
            int r1 = 0;
        L4:
            if (r1 >= r0.length) goto L7;
            EscherRecord r2 = createRecord(r0, r1);
            r1 = r1 + r2.fillFields(r0, r1, this);
            r5.addEscherRecord(r2);
            goto L4
        L7:
            return this.objShapes;
        }
    }

    static {
    }

    public EscherAggregate(boolean r2) {
        this.shapeToObj = new HashMap();
        this.tailRec = new LinkedHashMap();
        if (r2 == false) goto L6;
        buildBaseTree();
        return;
    }

    private void buildBaseTree() {
        EscherContainerRecord r0 = new EscherContainerRecord();
        EscherContainerRecord r1 = new EscherContainerRecord();
        EscherContainerRecord r2 = new EscherContainerRecord();
        EscherSpgrRecord r3 = new EscherSpgrRecord();
        EscherSpRecord r4 = new EscherSpRecord();
        r0.setRecordId(EscherContainerRecord.DG_CONTAINER);
        r0.setOptions(15);
        EscherDgRecord r6 = new EscherDgRecord();
        r6.setRecordId(EscherDgRecord.RECORD_ID);
        r6.setOptions((short) 16);
        r6.setNumShapes(0);
        r6.setLastMSOSPID(1024);
        r1.setRecordId(EscherContainerRecord.SPGR_CONTAINER);
        r1.setOptions(15);
        r2.setRecordId(EscherContainerRecord.SP_CONTAINER);
        r2.setOptions(15);
        r3.setRecordId(EscherSpgrRecord.RECORD_ID);
        r3.setOptions(1);
        r3.setRectX1(0);
        r3.setRectY1(0);
        r3.setRectX2(1023);
        r3.setRectY2(255);
        r4.setRecordId(EscherSpRecord.RECORD_ID);
        r4.setOptions(2);
        r4.setVersion(2);
        r4.setShapeId(-1);
        r4.setFlags(5);
        r0.addChildRecord(r6);
        r0.addChildRecord(r1);
        r1.addChildRecord(r2);
        r2.addChildRecord(r3);
        r2.addChildRecord(r4);
        addEscherRecord(r0);
    }

    public static EscherAggregate createAggregate(List<RecordBase> r9, int r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        final EscherAggregate r0 = new EscherAggregate(false);
        ShapeCollector r2 = new ShapeCollector(null);
        ArrayList r3 = new ArrayList();
        Iterator r4 = r11.subList(r10, r11.size()).iterator();
        int r5 = r10;
    L4:
        if (r4.hasNext() == false) goto L20;
        RecordBase r6 = (RecordBase) ZeusTransformUtils.preCheckCast(r4.next(), RecordBase.class, "com.obric.memorydata.plugin");
        r5 = r5 + 1;
        short r7 = sid(r6);
        if (r7 != 28) goto L8;
        NoteRecord r8 = (NoteRecord) ZeusTransformUtils.preCheckCast(r6, NoteRecord.class, "com.obric.memorydata.plugin");
        r0.tailRec.put(Integer.valueOf(r8.getShapeId()), r8);
        goto L4
    L8:
        if (r7 != 60) goto L10;
        r2.addBytes(((ContinueRecord) ZeusTransformUtils.preCheckCast(r6, ContinueRecord.class, "com.obric.memorydata.plugin")).getData());
        goto L4
    L10:
        if (r7 == 93) goto L17;
        if (r7 == 236) goto L16;
        if (r7 == 438) goto L17;
        r5 = r5 - 1;
        goto L20
    L16:
        r2.addBytes(((DrawingRecord) ZeusTransformUtils.preCheckCast(r6, DrawingRecord.class, "com.obric.memorydata.plugin")).getRecordData());
    L17:
        r3.add((Record) ZeusTransformUtils.preCheckCast(r6, Record.class, "com.obric.memorydata.plugin"));
    L20:
        r11.set(r10, r0);
        int r12 = r10 + 1;
        if (r12 > r5) goto L23;
        r11.subList(r12, r5).clear();
    L23:
        final Iterator<EscherRecord> r13 = r2.parse(r0).iterator();
        r3.forEach(new $$Lambda$EscherAggregate$UiPfUiZY3MpgalGYrXlJ4SopBpk(r0, r13));
        return r0;
    }

    private int getEscherRecordSize(List<EscherRecord> r4) {
        Iterator r3 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")).iterator();
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L6;
        r5 = r5 + ((EscherRecord) ZeusTransformUtils.preCheckCast(r3.next(), EscherRecord.class, "com.obric.memorydata.plugin")).getRecordSize();
        goto L4
    L6:
        return r5;
    }

    static /* synthetic */ void lambda$createAggregate$0(EscherAggregate r2, Iterator r3, Record r4) {
        Iterator r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        Record r6 = (Record) ZeusTransformUtils.preCheckCast(r2.shapeToObj.put((EscherRecord) r5.next(), r4), Record.class, "com.obric.memorydata.plugin");
    }

    private static short sid(RecordBase r2) {
        if (ZeusTransformUtils.instanceOf(r2, Record.class) == true) goto L7;
        return -1;
    L7:
        return ((Record) ZeusTransformUtils.preCheckCast(r2, Record.class, "com.obric.memorydata.plugin")).getSid();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return null;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.ESCHER_AGGREGATE;
    }

    public NoteRecord getNoteRecordByObj(ObjRecord r3) {
        CommonObjectDataSubRecord r4 = (CommonObjectDataSubRecord) ZeusTransformUtils.preCheckCast(r3.getSubRecords().get(0), CommonObjectDataSubRecord.class, "com.obric.memorydata.plugin");
        return (NoteRecord) ZeusTransformUtils.preCheckCast(this.tailRec.get(Integer.valueOf(r4.getObjectId())), NoteRecord.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        List<EscherRecord> r0 = getEscherRecords();
        int r1 = getEscherRecordSize(r0);
        byte[] r2 = IOUtils.safelyAllocate(r1, MAX_RECORD_LENGTH);
        final ArrayList r3 = new ArrayList();
        Iterator<EscherRecord> r4 = r0.iterator();
        int r5 = 0;
        int r6 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r6 = r6 + ((EscherRecord) ZeusTransformUtils.preCheckCast(r4.next(), EscherRecord.class, "com.obric.memorydata.plugin")).serialize(r6, r2, new AnonymousClass2(this, r3));
        goto L4
    L6:
        r3.add(0, 0);
        int r7 = 1;
        int r8 = 0;
    L8:
        if (r7 >= r3.size()) goto L19;
        if (r7 == (r3.size() - 1)) goto L12;
    L14:
        int r9 = r7 - 1;
        if ((((Integer) ZeusTransformUtils.preCheckCast(r3.get(r7), Integer.class, "com.obric.memorydata.plugin")).intValue() - ((Integer) ZeusTransformUtils.preCheckCast(r3.get(r9), Integer.class, "com.obric.memorydata.plugin")).intValue()) <= 8224) goto L18;
        r8 = r8 + (((((Integer) ZeusTransformUtils.preCheckCast(r3.get(r7), Integer.class, "com.obric.memorydata.plugin")).intValue() - ((Integer) ZeusTransformUtils.preCheckCast(r3.get(r9), Integer.class, "com.obric.memorydata.plugin")).intValue()) / 8224) * 4);
    L18:
        r7 = r7 + 1;
        goto L8
    L12:
        if (((Integer) ZeusTransformUtils.preCheckCast(r3.get(r7), Integer.class, "com.obric.memorydata.plugin")).intValue() >= r6) goto L14;
        r8 = r8 + 4;
        goto L14
    L19:
        int r10 = (this.shapeToObj.size() * 4) + r1;
        if (r1 != 0) goto L22;
    L24:
        Iterator<Record> r11 = this.shapeToObj.values().iterator();
        int r12 = 0;
    L26:
        if (r11.hasNext() == false) goto L28;
        r12 = r12 + ((Record) ZeusTransformUtils.preCheckCast(r11.next(), Record.class, "com.obric.memorydata.plugin")).getRecordSize();
        goto L26
    L28:
        Iterator<NoteRecord> r13 = this.tailRec.values().iterator();
    L30:
        if (r13.hasNext() == false) goto L33;
        r5 = r5 + ((NoteRecord) ZeusTransformUtils.preCheckCast(r13.next(), NoteRecord.class, "com.obric.memorydata.plugin")).getRecordSize();
        goto L30
    L33:
        return ((r10 + r12) + r5) + r8;
    L22:
        if (r3.size() != 1) goto L24;
        r8 = r8 + 4;
        goto L24
    }

    public Map<EscherRecord, Record> getShapeToObjMapping() {
        return Collections.unmodifiableMap(this.shapeToObj);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 9876;
    }

    public void setDgId(short r3) {
        EscherDgRecord r2 = (EscherDgRecord) ZeusTransformUtils.preCheckCast(getEscherContainer().getChildById(EscherDgRecord.RECORD_ID), EscherDgRecord.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r2.setOptions((short) (r3 << 4));
        return;
    }

    public void setMainSpRecordId(int r3) {
        EscherContainerRecord r2 = (EscherContainerRecord) ZeusTransformUtils.preCheckCast(getEscherContainer().getChildById(EscherContainerRecord.SPGR_CONTAINER), EscherContainerRecord.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        EscherSpRecord r4 = (EscherSpRecord) ZeusTransformUtils.preCheckCast(((EscherContainerRecord) ZeusTransformUtils.preCheckCast(r2.getChild(0), EscherContainerRecord.class, "com.obric.memorydata.plugin")).getChildById(EscherSpRecord.RECORD_ID), EscherSpRecord.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L9;
        r4.setShapeId(r3);
        return;
    L9:
        return;
    }
}
