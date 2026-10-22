package com.google.common.primitives;

import com.google.common.base.b0;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
class Bytes$ByteArrayAsList extends AbstractList<Byte> implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0;
    final byte[] array;
    final int end;
    final int start;

    public Bytes$ByteArrayAsList(byte[] r5) {
        this(r5, 0, r5.length);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r5) {
        if ((r5 instanceof Byte) == false) goto L14;
        byte[] r10 = this.array;
        byte r11 = ((Byte) r5).byteValue();
        int r12 = this.start;
        int r13 = this.end;
    L6:
        if (r12 >= r13) goto L11;
        if (r10[r12] == r11) goto L12;
        r12 = r12 + 1;
    L12:
        if (r12 == (-1)) goto L14;
        return true;
    L11:
        r12 = -1;
    L14:
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Bytes$ByteArrayAsList) == false) goto L18;
        Bytes$ByteArrayAsList r11 = (Bytes$ByteArrayAsList) r10;
        int r5 = size();
        if (r11.size() == r5) goto L10;
        return false;
    L10:
        int r12 = 0;
    L11:
        if (r12 >= r5) goto L16;
        if (this.array[this.start + r12] != r11.array[r11.start + r12]) goto L14;
        r12 = r12 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L18:
        return super.equals(r10);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r5) {
        return get(r5);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int r5 = this.start;
        int r10 = 1;
    L4:
        if (r5 >= this.end) goto L6;
        r10 = (r10 * 31) + this.array[r5];
        r5 = r5 + 1;
        goto L4
    L6:
        return r10;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r10) {
        if ((r10 instanceof Byte) == false) goto L14;
        byte[] r5 = this.array;
        byte r11 = ((Byte) r10).byteValue();
        int r12 = this.start;
        int r13 = this.end;
    L5:
        if (r12 >= r13) goto L10;
        if (r5[r12] == r11) goto L11;
        r12 = r12 + 1;
    L11:
        if (r12 < 0) goto L14;
        return r12 - this.start;
    L10:
        r12 = -1;
    L14:
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r10) {
        if ((r10 instanceof Byte) == false) goto L14;
        byte[] r5 = this.array;
        byte r11 = ((Byte) r10).byteValue();
        int r12 = this.start;
        int r13 = this.end - 1;
    L5:
        if (r13 < r12) goto L10;
        if (r5[r13] == r11) goto L11;
        r13 = r13 - 1;
    L11:
        if (r13 < 0) goto L14;
        return r13 - this.start;
    L10:
        r13 = -1;
    L14:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r5, Object r10) {
        return set(r5, (Byte) r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.end - this.start;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<Byte> subList(int r5, int r10) {
        b0.p(r5, r10, size());
        if (r5 == r10) goto L5;
        byte[] r11 = this.array;
        int r12 = this.start;
        return new Bytes$ByteArrayAsList(r11, r5 + r12, r12 + r10);
    L5:
        return Collections.emptyList();
    }

    public byte[] toByteArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder r5 = new StringBuilder(size() * 5);
        r5.append('[');
        r5.append(this.array[this.start]);
        int r10 = this.start;
    L3:
        r10 = r10 + 1;
        if (r10 >= this.end) goto L6;
        r5.append(", ");
        r5.append(this.array[r10]);
        goto L3
    L6:
        r5.append(']');
        return r5.toString();
    }

    public Bytes$ByteArrayAsList(byte[] r5, int r10, int r11) {
        this.array = r5;
        this.start = r10;
        this.end = r11;
    }

    @Override // java.util.AbstractList, java.util.List
    public Byte get(int r5) {
        b0.l(r5, size());
        return Byte.valueOf(this.array[this.start + r5]);
    }

    public Byte set(int r5, Byte r10) {
        b0.l(r5, size());
        byte[] r11 = this.array;
        int r12 = this.start + r5;
        byte r13 = r11[r12];
        r10.getClass();
        r11[r12] = r10.byteValue();
        return Byte.valueOf(r13);
    }
}
