package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Supplier;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes6.dex */
public final class EscherContainerRecord extends EscherRecord implements Iterable<EscherRecord> {
    public static final short BSTORE_CONTAINER = 0;
    public static final short DGG_CONTAINER = 0;
    public static final short DG_CONTAINER = 0;
    private static final c LOGGER = null;
    public static final short SOLVER_CONTAINER = 0;
    public static final short SPGR_CONTAINER = 0;
    public static final short SP_CONTAINER = 0;
    private final List<EscherRecord> _childRecords;
    private int _remainingLength;

    static {
        DGG_CONTAINER = EscherRecordTypes.DGG_CONTAINER.typeID;
        BSTORE_CONTAINER = EscherRecordTypes.BSTORE_CONTAINER.typeID;
        DG_CONTAINER = EscherRecordTypes.DG_CONTAINER.typeID;
        SPGR_CONTAINER = EscherRecordTypes.SPGR_CONTAINER.typeID;
        SP_CONTAINER = EscherRecordTypes.SP_CONTAINER.typeID;
        SOLVER_CONTAINER = EscherRecordTypes.SOLVER_CONTAINER.typeID;
        LOGGER = b.a(EscherContainerRecord.class);
    }

    public EscherContainerRecord() {
        this._childRecords = new ArrayList();
    }

    public void addChildBefore(EscherRecord r6, int r7) {
        Iterator<EscherRecord> r0 = iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((EscherRecord) ZeusTransformUtils.preCheckCast(r0.next(), EscherRecord.class, "com.obric.memorydata.plugin")).getRecordId() == ((short) r7)) goto L9;
        r1 = r1 + 1;
    L9:
        this._childRecords.add(r1, r6);
    }

    public void addChildRecord(EscherRecord r1) {
        this._childRecords.add(r1);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] r6, int r7, EscherRecordFactory r8) {
        EscherRecordFactory r9 = (EscherRecordFactory) ZeusTransformUtils.wrapperContextForParams(r8, EscherRecordFactory.class, "com.obric.memorydata.plugin");
        int r0 = readHeader(r6, r7);
        int r1 = 8;
        int r10 = r7 + 8;
    L3:
        if (r0 <= 0) goto L10;
        if (r10 >= r6.length) goto L10;
        EscherRecord r2 = r9.createRecord(r6, r10);
        int r3 = r2.fillFields(r6, r10, r9);
        r1 = r1 + r3;
        r10 = r10 + r3;
        r0 = r0 - r3;
        addChildRecord(r2);
        if (r10 < r6.length) goto L3;
        if (r0 <= 0) goto L3;
        this._remainingLength = r0;
        LOGGER.atWarn().a("Not enough Escher data: {} bytes remaining but no space left", v.a(r0));
    L10:
        return r1;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public EscherRecord getChild(int r2) {
        return (EscherRecord) ZeusTransformUtils.preCheckCast(this._childRecords.get(r2), EscherRecord.class, "com.obric.memorydata.plugin");
    }

    public <T extends EscherRecord> T getChildById(short r4) {
        Iterator<EscherRecord> r3 = iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        T r0 = (T) ZeusTransformUtils.preCheckCast(r3.next(), EscherRecord.class, "com.obric.memorydata.plugin");
        if (r0.getRecordId() != r4) goto L4;
        return r0;
    L8:
        return null;
    }

    public List<EscherContainerRecord> getChildContainers() {
        ArrayList r1 = new ArrayList();
        Iterator<EscherRecord> r5 = iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        EscherRecord r2 = (EscherRecord) ZeusTransformUtils.preCheckCast(r5.next(), EscherRecord.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, EscherContainerRecord.class) == false) goto L4;
        r1.add((EscherContainerRecord) ZeusTransformUtils.preCheckCast(r2, EscherContainerRecord.class, "com.obric.memorydata.plugin"));
        goto L4
    L8:
        return r1;
    }

    public int getChildCount() {
        return this._childRecords.size();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public List<EscherRecord> getChildRecords() {
        return new ArrayList(this._childRecords);
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$EscherContainerRecord$cjqFgMzD6RyOKUDkl_6oSussqW4(this), "isContainer", new $$Lambda$W5GejTqugTNuMWbxcHv4VPpRFBM(this));
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.forTypeID(getRecordId());
    }

    public String getRecordName() {
        short r2 = getRecordId();
        EscherRecordTypes r0 = EscherRecordTypes.forTypeID(r2);
        if (r0 == EscherRecordTypes.UNKNOWN) goto L6;
        return r0.recordName;
    L6:
        return "Container 0x" + HexDump.toHex(r2);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        Iterator<EscherRecord> r4 = iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L7;
        r0 = r0 + ((EscherRecord) ZeusTransformUtils.preCheckCast(r4.next(), EscherRecord.class, "com.obric.memorydata.plugin")).getRecordSize();
        goto L4
    L7:
        return r0 + 8;
    }

    @Override // java.lang.Iterable
    public Iterator<EscherRecord> iterator() {
        return Collections.unmodifiableList(this._childRecords).iterator();
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$EscherContainerRecord() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int r6, byte[] r7, EscherSerializationListener r8) {
        EscherSerializationListener r9 = (EscherSerializationListener) ZeusTransformUtils.wrapperContextForParams(r8, EscherSerializationListener.class, "com.obric.memorydata.plugin");
        r9.beforeRecordSerialize(r6, getRecordId(), this);
        LittleEndian.putShort(r7, r6, getOptions());
        LittleEndian.putShort(r7, r6 + 2, getRecordId());
        Iterator<EscherRecord> r0 = iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r2 = r2 + ((EscherRecord) ZeusTransformUtils.preCheckCast(r0.next(), EscherRecord.class, "com.obric.memorydata.plugin")).getRecordSize();
        goto L4
    L6:
        int r3 = r2 + this._remainingLength;
        LittleEndian.putInt(r7, r6 + 4, r3);
        int r1 = r6 + 8;
        Iterator<EscherRecord> r4 = iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r1 = r1 + ((EscherRecord) ZeusTransformUtils.preCheckCast(r4.next(), EscherRecord.class, "com.obric.memorydata.plugin")).serialize(r1, r7, r9);
        goto L8
    L10:
        int r10 = r1 - r6;
        r9.afterRecordSerialize(r1, getRecordId(), r10, this);
        return r10;
    }

    @Override // java.lang.Iterable
    public Spliterator<EscherRecord> spliterator() {
        return this._childRecords.spliterator();
    }
}
