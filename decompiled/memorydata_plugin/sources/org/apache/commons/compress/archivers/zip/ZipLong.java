package org.apache.commons.compress.archivers.zip;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class ZipLong implements Serializable, Cloneable {
    public static final ZipLong AED_SIG = null;
    public static final ZipLong CFH_SIG = null;
    public static final ZipLong DD_SIG = null;
    public static final ZipLong LFH_SIG = null;
    public static final ZipLong SINGLE_SEGMENT_SPLIT_MARKER = null;
    static final ZipLong ZIP64_MAGIC = null;
    private static final long serialVersionUID = 1;
    private final long value;

    static {
        CFH_SIG = new ZipLong(33639248);
        LFH_SIG = new ZipLong(67324752);
        DD_SIG = new ZipLong(134695760);
        ZIP64_MAGIC = new ZipLong(4294967295L);
        SINGLE_SEGMENT_SPLIT_MARKER = new ZipLong(808471376);
        AED_SIG = new ZipLong(134630224);
    }

    public ZipLong(int r3) {
        this.value = r3;
    }

    public ZipLong(long r1) {
        this.value = r1;
    }

    public ZipLong(byte[] r2) {
        this(r2, 0);
    }

    public ZipLong(byte[] r1, int r2) {
        this.value = getValue(r1, r2);
    }

    public static byte[] getBytes(long r2) {
        byte[] r0 = new byte[4];
        putLong(r2, r0, 0);
        return r0;
    }

    public static long getValue(byte[] r2) {
        return getValue(r2, 0);
    }

    public static long getValue(byte[] r1, int r2) {
        return ByteUtils.fromLittleEndian(r1, r2, 4);
    }

    public static void putLong(long r1, byte[] r3, int r4) {
        ByteUtils.toLittleEndian(r3, r1, r4, 4);
    }

    public Object clone() {
        return super.clone();
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public boolean equals(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, ZipLong.class) == true) goto L6;
        return false;
    L6:
        if (this.value != ((ZipLong) ZeusTransformUtils.preCheckCast(r6, ZipLong.class, "com.obric.memorydata.plugin")).getValue()) goto L9;
        return true;
    L9:
        return false;
    }

    public byte[] getBytes() {
        return getBytes(this.value);
    }

    public int getIntValue() {
        return (int) this.value;
    }

    public long getValue() {
        return this.value;
    }

    public int hashCode() {
        return (int) this.value;
    }

    public void putLong(byte[] r3, int r4) {
        putLong(this.value, r3, r4);
    }

    public String toString() {
        return "ZipLong value: " + this.value;
    }
}
