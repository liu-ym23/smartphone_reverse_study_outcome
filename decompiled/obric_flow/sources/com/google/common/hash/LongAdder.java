package com.google.common.hash;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class LongAdder extends Striped64 implements Serializable, r {
    private static final long serialVersionUID = 7249069246863182397L;

    public LongAdder() {
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = r5.readLong();
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        r5.writeLong(sum());
    }

    @Override // com.google.common.hash.r
    public void add(long r10) {
        c0[] r5 = this.cells;
        if (r5 != null) goto L6;
        long r11 = this.base;
        if (casBase(r11, r11 + r10) == false) goto L6;
        return;
    L6:
        int[] r12 = Striped64.threadHashCode.get();
        boolean r13 = true;
        if (r12 == null) goto L15;
        if (r5 == null) goto L15;
        int r14 = r5.length;
        if (r14 < 1) goto L15;
        c0 r15 = r5[(r14 - 1) & r12[0]];
        if (r15 == null) goto L15;
        long r16 = r15.f9281a;
        r13 = r15.a(r16, r16 + r10);
        if (r13 == false) goto L15;
        return;
    L15:
        retryUpdate(r10, r12, r13);
    }

    public void decrement() {
        add(-1);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return sum();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return sum();
    }

    @Override // com.google.common.hash.Striped64
    public final long fn(long r5, long r10) {
        return r5 + r10;
    }

    @Override // com.google.common.hash.r
    public void increment() {
        add(1);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) sum();
    }

    @Override // java.lang.Number
    public long longValue() {
        return sum();
    }

    public void reset() {
        internalReset(0);
    }

    @Override // com.google.common.hash.r
    public long sum() {
        long r5 = this.base;
        c0[] r10 = this.cells;
        if (r10 == null) goto L10;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L10;
        c0 r13 = r10[r12];
        if (r13 == null) goto L9;
        r5 = r5 + r13.f9281a;
    L9:
        r12 = r12 + 1;
    L10:
        return r5;
    }

    public long sumThenReset() {
        long r5 = this.base;
        c0[] r10 = this.cells;
        this.base = 0;
        if (r10 == null) goto L10;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L10;
        c0 r13 = r10[r12];
        if (r13 == null) goto L9;
        r5 = r5 + r13.f9281a;
        r13.f9281a = 0;
    L9:
        r12 = r12 + 1;
    L10:
        return r5;
    }

    public String toString() {
        return Long.toString(sum());
    }
}
