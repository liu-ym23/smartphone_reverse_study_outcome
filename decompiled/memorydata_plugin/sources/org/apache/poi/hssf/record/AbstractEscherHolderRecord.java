package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherRecordFactory;
import org.apache.poi.hssf.util.LazilyConcatenatedByteArray;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractEscherHolderRecord extends Record {
    private static boolean DESERIALIZE;
    private final List<EscherRecord> escherRecords;
    private final LazilyConcatenatedByteArray rawDataContainer;

    static {
    L9:
        DESERIALIZE = false;
        return;
    L4:
        if (System.getProperty("poi.deserialize.escher") == null) goto L6;
        boolean r1 = true;
    L7:
        DESERIALIZE = r1;     // Catch: SecurityException -> L9
        return;
    L6:
        r1 = false;
        goto L7
    }

    public AbstractEscherHolderRecord() {
        this.escherRecords = new ArrayList();
        this.rawDataContainer = new LazilyConcatenatedByteArray();
    }

    public AbstractEscherHolderRecord(RecordInputStream r3) {
        this.escherRecords = new ArrayList();
        LazilyConcatenatedByteArray r0 = new LazilyConcatenatedByteArray();
        this.rawDataContainer = r0;
        if (DESERIALIZE == true) goto L5;
        r0.concatenate(r3.readRemainder());
        return;
    L5:
        byte[] r4 = r3.readAllContinuedRemainder();
        convertToEscherRecords(0, r4.length, r4);
    }

    private void convertToEscherRecords(int r6, int r7, byte[] r8) {
        this.escherRecords.clear();
        EscherRecordFactory r0 = new DefaultEscherRecordFactory();
        int r1 = r6;
    L4:
        if (r1 >= (r6 + r7)) goto L6;
        EscherRecord r2 = r0.createRecord(r8, r1);
        int r3 = r2.fillFields(r8, r1, r0);
        this.escherRecords.add(r2);
        r1 = r1 + r3;
        goto L4
    }

    private EscherRecord findFirstWithId(short r5, List<EscherRecord> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Iterator r0 = r7.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        EscherRecord r2 = (EscherRecord) ZeusTransformUtils.preCheckCast(r0.next(), EscherRecord.class, "com.obric.memorydata.plugin");
        if (r2.getRecordId() != r5) goto L4;
        return r2;
    L8:
        Iterator r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L16;
        EscherRecord r1 = (EscherRecord) ZeusTransformUtils.preCheckCast(r8.next(), EscherRecord.class, "com.obric.memorydata.plugin");
        if (r1.isContainerRecord() == false) goto L10;
        EscherRecord r3 = findFirstWithId(r5, r1.getChildRecords());
        if (r3 == null) goto L10;
        return r3;
    L16:
        return null;
    }

    public boolean addEscherRecord(EscherRecord r1) {
        return this.escherRecords.add(r1);
    }

    public void decode() {
        if (this.escherRecords.isEmpty() == false) goto L6;
        byte[] r0 = getRawData();
        convertToEscherRecords(0, r0.length, r0);
        return;
    }

    public EscherRecord findFirstWithId(short r2) {
        return findFirstWithId(r2, getEscherRecords());
    }

    public EscherContainerRecord getEscherContainer() {
        Iterator<EscherRecord> r3 = this.escherRecords.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        EscherRecord r0 = (EscherRecord) ZeusTransformUtils.preCheckCast(r3.next(), EscherRecord.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, EscherContainerRecord.class) == false) goto L4;
        return (EscherContainerRecord) ZeusTransformUtils.preCheckCast(r0, EscherContainerRecord.class, "com.obric.memorydata.plugin");
    L9:
        return null;
    }

    public List<EscherRecord> getEscherRecords() {
        return this.escherRecords;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public List<EscherRecord> getGenericChildren() {
        return this.escherRecords;
    }

    public byte[] getRawData() {
        return this.rawDataContainer.toArray();
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        byte[] r0 = getRawData();
        if (this.escherRecords.isEmpty() == false) goto L7;
        if (r0 == null) goto L7;
        return r0.length;
    L7:
        int r1 = 0;
        Iterator<EscherRecord> r4 = this.escherRecords.iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        r1 = r1 + ((EscherRecord) ZeusTransformUtils.preCheckCast(r4.next(), EscherRecord.class, "com.obric.memorydata.plugin")).getRecordSize();
        goto L9
    L11:
        return r1;
    }

    public void join(AbstractEscherHolderRecord r1) {
        this.rawDataContainer.concatenate(r1.getRawData());
    }

    public void processContinueRecord(byte[] r1) {
        this.rawDataContainer.concatenate(r1);
    }
}
