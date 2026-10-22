package com.google.common.primitives;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class Bytes {

    private static class ByteArrayAsList extends AbstractList<Byte> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final byte[] array;
        final int end;
        final int start;

        ByteArrayAsList(byte[] r3) {
            this(r3, 0, r3.length);
        }

        ByteArrayAsList(byte[] r1, int r2, int r3) {
            this.array = r1;
            this.start = r2;
            this.end = r3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Byte.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (Bytes.a(this.array, ((Byte) ZeusTransformUtils.preCheckCast(r4, Byte.class, "com.obric.memorydata.plugin")).byteValue(), this.start, this.end) == (-1)) goto L7;
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r8, ByteArrayAsList.class) == false) goto L18;
            ByteArrayAsList r9 = (ByteArrayAsList) ZeusTransformUtils.preCheckCast(r8, ByteArrayAsList.class, "com.obric.memorydata.plugin");
            int r0 = size();
            if (r9.size() == r0) goto L10;
            return false;
        L10:
            int r2 = 0;
        L11:
            if (r2 >= r0) goto L16;
            if (this.array[this.start + r2] != r9.array[r9.start + r2]) goto L14;
            r2 = r2 + 1;
            goto L11
        L14:
            return false;
        L16:
            return true;
        L18:
            return super.equals(r8);
        }

        @Override // java.util.AbstractList, java.util.List
        public Byte get(int r2) {
            n.a(r2, size());
            return Byte.valueOf(this.array[this.start + r2]);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int r0 = this.start;
            int r1 = 1;
        L4:
            if (r0 >= this.end) goto L6;
            r1 = (r1 * 31) + Bytes.a(this.array[r0]);
            r0 = r0 + 1;
            goto L4
        L6:
            return r1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Byte.class) == false) goto L8;
            int r5 = Bytes.a(this.array, ((Byte) ZeusTransformUtils.preCheckCast(r4, Byte.class, "com.obric.memorydata.plugin")).byteValue(), this.start, this.end);
            if (r5 >= 0) goto L7;
            return -1;
        L7:
            return r5 - this.start;
        L8:
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Byte.class) == false) goto L8;
            int r5 = Bytes.b(this.array, ((Byte) ZeusTransformUtils.preCheckCast(r4, Byte.class, "com.obric.memorydata.plugin")).byteValue(), this.start, this.end);
            if (r5 >= 0) goto L7;
            return -1;
        L7:
            return r5 - this.start;
        L8:
            return -1;
        }

        public Byte set(int r4, Byte r5) {
            n.a(r4, size());
            byte[] r0 = this.array;
            int r3 = this.start;
            byte r1 = r0[r3 + r4];
            r0[r3 + r4] = ((Byte) ZeusTransformUtils.preCheckCast(n.a(r5), Byte.class, "com.obric.memorydata.plugin")).byteValue();
            return Byte.valueOf(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* synthetic */ Object set(int r3, Object r4) {
            return set(r3, (Byte) ZeusTransformUtils.preCheckCast(r4, Byte.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Byte> subList(int r3, int r4) {
            n.a(r3, r4, size());
            if (r3 == r4) goto L5;
            byte[] r1 = this.array;
            int r2 = this.start;
            return new ByteArrayAsList(r1, r3 + r2, r2 + r4);
        L5:
            return Collections.emptyList();
        }

        byte[] toByteArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r0 = new StringBuilder(size() * 5);
            r0.append('[').append(this.array[this.start]);
            int r1 = this.start;
        L3:
            r1 = r1 + 1;
            if (r1 >= this.end) goto L7;
            r0.append(", ").append(this.array[r1]);
            goto L3
        L7:
            return r0.append(']').toString();
        }
    }

    public static int a(byte r0) {
        return r0;
    }

    static /* synthetic */ int a(byte[] r0, byte r1, int r2, int r3) {
        return c(r0, r1, r2, r3);
    }

    static /* synthetic */ int b(byte[] r0, byte r1, int r2, int r3) {
        return d(r0, r1, r2, r3);
    }

    private static int c(byte[] r1, byte r2, int r3, int r4) {
    L2:
        if (r3 >= r4) goto L7;
        if (r1[r3] == r2) goto L5;
        r3 = r3 + 1;
        goto L2
    L5:
        return r3;
    L7:
        return -1;
    }

    private static int d(byte[] r1, byte r2, int r3, int r4) {
        int r5 = r4 - 1;
    L3:
        if (r5 < r3) goto L8;
        if (r1[r5] == r2) goto L6;
        r5 = r5 - 1;
        goto L3
    L6:
        return r5;
    L8:
        return -1;
    }
}
