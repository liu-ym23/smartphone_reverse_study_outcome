package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherRecordFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class PPDrawingGroup extends RecordAtom {
    private final byte[] _header;
    private final EscherContainerRecord dggContainer;

    PPDrawingGroup(byte[] r2, int r3, int r4) {
        this._header = Arrays.copyOfRange(r2, r3, r3 + 8);
        byte[] r5 = IOUtils.safelyClone(r2, r3, r4, 10485760);
        EscherRecordFactory r6 = new HSLFEscherRecordFactory();
        EscherRecord r0 = r6.createRecord(r5, 0);
        r0.fillFields(r5, 0, r6);
        this.dggContainer = (EscherContainerRecord) ZeusTransformUtils.preCheckCast(r0.getChild(0), EscherContainerRecord.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.hslf.record.RecordAtom, org.apache.poi.hslf.record.Record
    public Record[] getChildRecords() {
        return null;
    }

    public EscherContainerRecord getDggContainer() {
        return this.dggContainer;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("dggContainer", new $$Lambda$gzltDtW3lRLGob5HIU8REjR_3c(this));
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.PPDrawingGroup.typeID;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r15) {
        byte[] r2 = new byte[8];
        byte[] r3 = new byte[44];
        UnsynchronizedByteArrayOutputStream r4 = new UnsynchronizedByteArrayOutputStream();
        UnsynchronizedByteArrayOutputStream r5 = new UnsynchronizedByteArrayOutputStream();     // Catch: Throwable -> L27
        Iterator<EscherRecord> r6 = this.dggContainer.iterator();     // Catch: Throwable -> L19
    L6:
        if (r6.hasNext() == false) goto L15;
        EscherRecord r7 = (EscherRecord) ZeusTransformUtils.preCheckCast(r6.next(), EscherRecord.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r7.getRecordId() == EscherContainerRecord.BSTORE_CONTAINER) goto L9;
        r4.write(r7.serialize());     // Catch: Throwable -> L19
        goto L6
    L9:
        EscherContainerRecord r8 = (EscherContainerRecord) ZeusTransformUtils.preCheckCast(r7, EscherContainerRecord.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        r5.reset();     // Catch: Throwable -> L19
        Iterator<EscherRecord> r11 = r8.iterator();     // Catch: Throwable -> L19
    L11:
        if (r11.hasNext() == false) goto L13;
        ((EscherRecord) ZeusTransformUtils.preCheckCast(r11.next(), EscherRecord.class, "com.obric.memorydata.plugin")).serialize(0, r3);     // Catch: Throwable -> L19
        r5.write(r3);     // Catch: Throwable -> L19
        goto L11
    L13:
        LittleEndian.putShort(r2, 0, r8.getOptions());     // Catch: Throwable -> L19
        LittleEndian.putShort(r2, 2, r8.getRecordId());     // Catch: Throwable -> L19
        LittleEndian.putInt(r2, 4, r5.size());     // Catch: Throwable -> L19
        r4.write(r2);     // Catch: Throwable -> L19
        r5.writeTo(r4);     // Catch: Throwable -> L19
        goto L6
    L15:
        int r0 = r4.size();     // Catch: Throwable -> L19
        LittleEndian.putInt(this._header, 4, r0 + 8);     // Catch: Throwable -> L19
        r15.write(this._header);     // Catch: Throwable -> L19
        byte[] r1 = new byte[8];     // Catch: Throwable -> L19
        LittleEndian.putShort(r1, 0, this.dggContainer.getOptions());     // Catch: Throwable -> L19
        LittleEndian.putShort(r1, 2, this.dggContainer.getRecordId());     // Catch: Throwable -> L19
        LittleEndian.putInt(r1, 4, r0);     // Catch: Throwable -> L19
        r15.write(r1);     // Catch: Throwable -> L19
        r4.writeTo(r15);     // Catch: Throwable -> L19
        r5.close();     // Catch: Throwable -> L27
        r4.close();
        return;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: Throwable -> L27
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        r4.close();     // Catch: Throwable -> L32
    L34:
        throw th;
    L32:
        th = move-exception;
        th.addSuppressed(th);
        goto L34
    }
}
