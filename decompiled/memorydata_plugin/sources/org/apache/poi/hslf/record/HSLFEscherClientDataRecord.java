package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherRecordFactory;
import org.apache.poi.ddf.EscherSerializationListener;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class HSLFEscherClientDataRecord extends EscherClientDataRecord {
    private final List<Record> _childRecords;

    public HSLFEscherClientDataRecord() {
        this._childRecords = new ArrayList();
    }

    @Override // org.apache.poi.ddf.EscherClientDataRecord, org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] r3, int r4, EscherRecordFactory r5) {
        EscherRecordFactory r6 = (EscherRecordFactory) ZeusTransformUtils.wrapperContextForParams(r5, EscherRecordFactory.class, "com.obric.memorydata.plugin");
        int r7 = readHeader(r3, r4);
        setRemainingData(IOUtils.safelyClone(r3, r4 + 8, r7, RecordAtom.getMaxRecordLength()));
        return r7 + 8;
    }

    public List<? extends Record> getHSLFChildRecords() {
        return this._childRecords;
    }

    @Override // org.apache.poi.ddf.EscherClientDataRecord, org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return getRemainingData().length + 8;
    }

    @Override // org.apache.poi.ddf.EscherClientDataRecord
    public byte[] getRemainingData() {
        UnsynchronizedByteArrayOutputStream r0 = new UnsynchronizedByteArrayOutputStream();     // Catch: IOException -> L18
        Iterator<Record> r4 = this._childRecords.iterator();     // Catch: Throwable -> L10
    L5:
        if (r4.hasNext() == false) goto L7;
        ((Record) ZeusTransformUtils.preCheckCast(r4.next(), Record.class, "com.obric.memorydata.plugin")).writeOut(r0);     // Catch: Throwable -> L10
        goto L5
    L7:
        byte[] r5 = r0.toByteArray();     // Catch: Throwable -> L10
        r0.close();     // Catch: IOException -> L18
        return r5;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: IOException -> L18
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L18
    L18:
        e = move-exception;
        throw new HSLFException(e);
    }

    @Override // org.apache.poi.ddf.EscherClientDataRecord, org.apache.poi.ddf.EscherRecord
    public int serialize(int r5, byte[] r6, EscherSerializationListener r7) {
        EscherSerializationListener r8 = (EscherSerializationListener) ZeusTransformUtils.wrapperContextForParams(r7, EscherSerializationListener.class, "com.obric.memorydata.plugin");
        r8.beforeRecordSerialize(r5, getRecordId(), this);
        LittleEndian.putShort(r6, r5, getOptions());
        LittleEndian.putShort(r6, r5 + 2, getRecordId());
        byte[] r0 = getRemainingData();
        LittleEndian.putInt(r6, r5 + 4, r0.length);
        System.arraycopy(r0, 0, r6, r5 + 8, r0.length);
        int r9 = r0.length + 8;
        r8.afterRecordSerialize(r5 + r9, getRecordId(), r9, this);
        return r9;
    }

    @Override // org.apache.poi.ddf.EscherClientDataRecord
    public void setRemainingData(byte[] r6) {
        this._childRecords.clear();
        int r0 = 0;
    L4:
        if (r0 >= r6.length) goto L9;
        Record r1 = Record.buildRecordAtOffset(r6, r0);
        if (r1 == null) goto L8;
        this._childRecords.add(r1);
    L8:
        long r2 = LittleEndian.getUInt(r6, r0 + 4);
        r0 = Math.toIntExact(((long) (r0 + 8)) + r2);
        goto L4
    }
}
