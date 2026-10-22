package org.apache.poi.hwpf.sprm;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
public final class SprmBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    byte[] _buf;
    boolean _istd;
    int _offset;
    private final int _sprmsStartOffset;

    static {
    }

    public SprmBuffer(int r5) {
        this._buf = IOUtils.safelyAllocate(((long) r5) + 4, SprmUtils.MAX_RECORD_LENGTH);
        this._offset = r5;
        this._sprmsStartOffset = r5;
    }

    public SprmBuffer(SprmBuffer r4) {
        byte[] r0 = r4._buf;
        if (r0 != null) goto L5;
        byte[] r1 = null;
    L6:
        this._buf = r1;
        this._istd = r4._istd;
        this._offset = r4._offset;
        this._sprmsStartOffset = r4._sprmsStartOffset;
        return;
    L5:
        r1 = (byte[]) ZeusTransformUtils.preCheckCast(r0.clone(), byte[].class, "com.obric.memorydata.plugin");
        goto L6
    }

    public SprmBuffer(byte[] r2, int r3) {
        this(r2, false, r3);
    }

    public SprmBuffer(byte[] r2, boolean r3, int r4) {
        this._offset = r2.length;
        this._buf = r2;
        this._istd = r3;
        this._sprmsStartOffset = r4;
    }

    private void ensureCapacity(int r5) {
        int r0 = this._offset;
        if ((r0 + r5) < this._buf.length) goto L6;
        IOUtils.safelyAllocateCheck(((long) r0) + ((long) r5), SprmUtils.MAX_RECORD_LENGTH);
        this._buf = Arrays.copyOf(this._buf, this._offset + r5);
        return;
    }

    public void append(byte[] r2) {
        append(r2, 0);
    }

    public void append(byte[] r4, int r5) {
        ensureCapacity(r4.length - r5);
        System.arraycopy(r4, r5, this._buf, this._offset, r4.length - r5);
        this._offset += r4.length - r5;
    }

    public SprmBuffer copy() {
        return new SprmBuffer(this);
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, SprmBuffer.class) == true) goto L6;
        return false;
    L6:
        SprmBuffer r4 = (SprmBuffer) ZeusTransformUtils.preCheckCast(r3, SprmBuffer.class, "com.obric.memorydata.plugin");
        return Arrays.equals(this._buf, r4._buf);
    }

    public int hashCode() {
        return 42;
    }

    public SprmIterator iterator() {
        return new SprmIterator(this._buf, this._sprmsStartOffset);
    }

    public byte[] toByteArray() {
        return this._buf;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Sprms (");
        r0.append(this._buf.length);
        r0.append(" byte(s)): ");
        SprmIterator r2 = iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        r0.append(r2.next());     // Catch: Exception -> L7
    L8:
        r0.append("; ");
    L7:
        r0.append("error");
        goto L8
    L10:
        return r0.toString();
    }
}
