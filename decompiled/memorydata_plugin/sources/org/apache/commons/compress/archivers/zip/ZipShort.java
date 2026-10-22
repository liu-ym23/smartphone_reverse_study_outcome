package org.apache.commons.compress.archivers.zip;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class ZipShort implements Serializable, Cloneable {
    public static final ZipShort ZERO = null;
    private static final long serialVersionUID = 1;
    private final int value;

    static {
        ZERO = new ZipShort(0);
    }

    public ZipShort(int r1) {
        this.value = r1;
    }

    public ZipShort(byte[] r2) {
        this(r2, 0);
    }

    public ZipShort(byte[] r1, int r2) {
        this.value = getValue(r1, r2);
    }

    public static byte[] getBytes(int r2) {
        byte[] r0 = new byte[2];
        putShort(r2, r0, 0);
        return r0;
    }

    public static int getValue(byte[] r1) {
        return getValue(r1, 0);
    }

    public static int getValue(byte[] r1, int r2) {
        return (int) ByteUtils.fromLittleEndian(r1, r2, 2);
    }

    public static void putShort(int r2, byte[] r3, int r4) {
        ByteUtils.toLittleEndian(r3, r2, r4, 2);
    }

    public Object clone() {
        return super.clone();
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ZipShort.class) == true) goto L6;
        return false;
    L6:
        if (this.value != ((ZipShort) ZeusTransformUtils.preCheckCast(r4, ZipShort.class, "com.obric.memorydata.plugin")).getValue()) goto L9;
        return true;
    L9:
        return false;
    }

    public byte[] getBytes() {
        byte[] r1 = new byte[2];
        ByteUtils.toLittleEndian(r1, this.value, 0, 2);
        return r1;
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }

    public String toString() {
        return "ZipShort value: " + this.value;
    }
}
