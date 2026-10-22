package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes6.dex */
public final class UnknownEscherRecord extends EscherRecord {
    private static int MAX_RECORD_LENGTH = 100000000;
    private static final byte[] NO_BYTES = null;
    private final List<EscherRecord> _childRecords;
    private byte[] thedata;

    static {
        NO_BYTES = new byte[0];
    }

    public UnknownEscherRecord() {
        this.thedata = NO_BYTES;
        this._childRecords = new ArrayList();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] r5, int r6, EscherRecordFactory r7) {
        EscherRecordFactory r8 = (EscherRecordFactory) ZeusTransformUtils.wrapperContextForParams(r7, EscherRecordFactory.class, "com.obric.memorydata.plugin");
        int r0 = readHeader(r5, r6);
        int r2 = 8;
        int r9 = r6 + 8;
        int r1 = r5.length - r9;
        if (r0 <= r1) goto L6;
        r0 = r1;
    L6:
        if (isContainerRecord() == false) goto L11;
        this.thedata = new byte[0];
    L8:
        if (r0 <= 0) goto L10;
        EscherRecord r3 = r8.createRecord(r5, r9);
        int r4 = r3.fillFields(r5, r9, r8);
        r2 = r2 + r4;
        r9 = r9 + r4;
        r0 = r0 - r4;
        getChildRecords().add(r3);
        goto L8
    L10:
        return r2;
    L11:
        if (r0 >= 0) goto L13;
        r0 = 0;
    L13:
        this.thedata = IOUtils.safelyClone(r5, r9, r0, MAX_RECORD_LENGTH);
        return r0 + 8;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public List<EscherRecord> getChildRecords() {
        return this._childRecords;
    }

    public byte[] getData() {
        return this.thedata;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$UnknownEscherRecord$bK0DDkVJ650Pf37cY9CDGpxbQ(this), "data", new $$Lambda$CC1AquzXQ4Ceg55FysinVaYIfI(this));
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.UNKNOWN;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return this.thedata.length + 8;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$UnknownEscherRecord() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int r6, byte[] r7, EscherSerializationListener r8) {
        EscherSerializationListener r9 = (EscherSerializationListener) ZeusTransformUtils.wrapperContextForParams(r8, EscherSerializationListener.class, "com.obric.memorydata.plugin");
        r9.beforeRecordSerialize(r6, getRecordId(), this);
        LittleEndian.putShort(r7, r6, getOptions());
        LittleEndian.putShort(r7, r6 + 2, getRecordId());
        int r0 = this.thedata.length;
        Iterator<EscherRecord> r2 = this._childRecords.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r0 = r0 + ((EscherRecord) ZeusTransformUtils.preCheckCast(r2.next(), EscherRecord.class, "com.obric.memorydata.plugin")).getRecordSize();
        goto L4
    L6:
        LittleEndian.putInt(r7, r6 + 4, r0);
        byte[] r1 = this.thedata;
        int r3 = r6 + 8;
        System.arraycopy(r1, 0, r7, r3, r1.length);
        int r4 = r3 + this.thedata.length;
        Iterator<EscherRecord> r5 = this._childRecords.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        r4 = r4 + ((EscherRecord) ZeusTransformUtils.preCheckCast(r5.next(), EscherRecord.class, "com.obric.memorydata.plugin")).serialize(r4, r7, r9);
        goto L8
    L10:
        int r10 = r4 - r6;
        r9.afterRecordSerialize(r4, getRecordId(), r10, this);
        return r10;
    }
}
