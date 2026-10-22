package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.util.ArrayUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class RecordContainer extends Record {
    protected Record[] _children;

    public RecordContainer() {
    }

    private void addChildAt(Record r2, int r3) {
        appendChild(r2);
        moveChildRecords(this._children.length - 1, r3, 1);
    }

    private int appendChild(Record r4) {
        Record[] r0 = this._children;
        Record[] r1 = (Record[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r0, r0.length + 1, Record[].class), Record[].class, "com.obric.memorydata.plugin");
        r1[this._children.length] = r4;
        this._children = r1;
        return r1.length;
    }

    private int findChildLocation(Record r5) {
        Record[] r4 = this._children;
        int r0 = r4.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r4[r1].equals(r5) == true) goto L6;
        r2 = r2 + 1;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return -1;
    }

    public static void handleParentAwareRecords(RecordContainer r7) {
        Record[] r1 = r7.getChildRecords();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L11;
        Record r4 = r1[r3];
        if (ZeusTransformUtils.instanceOf(r4, ParentAwareRecord.class) == false) goto L8;
        ((ParentAwareRecord) ZeusTransformUtils.preCheckCast(r4, ParentAwareRecord.class, "com.obric.memorydata.plugin")).setParentRecord(r7);
    L8:
        if (ZeusTransformUtils.instanceOf(r4, RecordContainer.class) == false) goto L10;
        handleParentAwareRecords((RecordContainer) ZeusTransformUtils.preCheckCast(r4, RecordContainer.class, "com.obric.memorydata.plugin"));
    L10:
        r3 = r3 + 1;
        goto L3
    }

    private void moveChildRecords(int r3, int r4, int r5) {
        if (r3 != r4) goto L4;
        return;
    L4:
        if (r5 != 0) goto L6;
        return;
    L6:
        int r0 = r3 + r5;
        Record[] r2 = this._children;
        if (r0 > r2.length) goto L11;
        ArrayUtil.arrayMoveWithin(r2, r3, r4, r5);
        return;
    L11:
        throw new IllegalArgumentException("Asked to move more records than there are!");
    }

    public int addChildAfter(Record r2, Record r3) {
        int r4 = findChildLocation(r3);
        if (r4 == (-1)) goto L7;
        int r5 = r4 + 1;
        addChildAt(r2, r5);
        return r5;
    L7:
        throw new IllegalArgumentException("Asked to add a new child after another record, but that record wasn't one of our children!");
    }

    public int appendChildRecord(Record r1) {
        return appendChild(r1);
    }

    public Record findFirstOfType(long r6) {
        Record[] r5 = this._children;
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Record r2 = r5[r1];
        if (r2.getRecordType() == r6) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    @Override // org.apache.poi.hslf.record.Record
    public Record[] getChildRecords() {
        return this._children;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return null;
    }

    public void writeOut(byte r4, byte r5, long r6, Record[] r8, OutputStream r9) {
        UnsynchronizedByteArrayOutputStream r3 = new UnsynchronizedByteArrayOutputStream();
        int r2 = 0;
        r3.write(new byte[]{r4, r5});     // Catch: Throwable -> L9
        byte[] r7 = new byte[2];     // Catch: Throwable -> L9
        LittleEndian.putShort(r7, 0, (short) r6);     // Catch: Throwable -> L9
        r3.write(r7);     // Catch: Throwable -> L9
        r3.write(new byte[]{0, 0, 0, 0});     // Catch: Throwable -> L9
        int r10 = r8.length;     // Catch: Throwable -> L9
    L4:
        if (r2 >= r10) goto L6;
        r8[r2].writeOut(r3);     // Catch: Throwable -> L9
        r2 = r2 + 1;     // Catch: Throwable -> L9
        goto L4
    L6:
        byte[] r11 = r3.toByteArray();     // Catch: Throwable -> L9
        LittleEndian.putInt(r11, 4, r11.length - 8);     // Catch: Throwable -> L9
        r9.write(r11);     // Catch: Throwable -> L9
        r3.close();
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L14
    L16:
        throw th;
    L14:
        th = move-exception;
        th.addSuppressed(th);
        goto L16
    }
}
