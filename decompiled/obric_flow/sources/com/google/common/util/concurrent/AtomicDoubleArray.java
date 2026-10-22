package com.google.common.util.concurrent;

import com.google.common.primitives.ImmutableLongArray;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public class AtomicDoubleArray implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient AtomicLongArray f9384a;

    public AtomicDoubleArray(int r5) {
        this.f9384a = new AtomicLongArray(r5);
    }

    private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
        r10.defaultReadObject();
        int r5 = r10.readInt();
        com.google.common.primitives.g r11 = ImmutableLongArray.builder();
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L5;
        long r13 = Double.doubleToRawLongBits(r10.readDouble());
        r11.a(1);
        long[] r14 = r11.f9338a;
        int r15 = r11.f9339b;
        r14[r15] = r13;
        r11.f9339b = r15 + 1;
        r12 = r12 + 1;
        goto L3
    L5:
        int r16 = r11.f9339b;
        if (r16 != 0) goto L8;
        ImmutableLongArray r17 = ImmutableLongArray.access$200();
    L9:
        this.f9384a = new AtomicLongArray(r17.toArray());
        return;
    L8:
        r17 = new ImmutableLongArray(r11.f9338a, 0, r16, null);
        goto L9
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        int r10 = length();
        r5.writeInt(r10);
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5.writeDouble(get(r11));
        r11 = r11 + 1;
        goto L3
    }

    public final double accumulateAndGet(int r5, double r10, DoubleBinaryOperator r11) {
        r11.getClass();
        return updateAndGet(r5, new t(2, r10, r11));
    }

    public double addAndGet(int r5, double r10) {
        return accumulateAndGet(r5, r10, new s());
    }

    public final boolean compareAndSet(int r10, double r11, double r12) {
        return this.f9384a.compareAndSet(r10, Double.doubleToRawLongBits(r11), Double.doubleToRawLongBits(r12));
    }

    public final double get(int r5) {
        return Double.longBitsToDouble(this.f9384a.get(r5));
    }

    public final double getAndAccumulate(int r5, double r10, DoubleBinaryOperator r11) {
        r11.getClass();
        return getAndUpdate(r5, new t(3, r10, r11));
    }

    public final double getAndAdd(int r5, double r10) {
        return getAndAccumulate(r5, r10, new s());
    }

    public final double getAndSet(int r5, double r10) {
        long r11 = Double.doubleToRawLongBits(r10);
        return Double.longBitsToDouble(this.f9384a.getAndSet(r5, r11));
    }

    public final double getAndUpdate(int r10, DoubleUnaryOperator r11) {
    L2:
        long r5 = this.f9384a.get(r10);
        double r12 = Double.longBitsToDouble(r5);
        long r13 = Double.doubleToRawLongBits(r11.applyAsDouble(r12));
        if (this.f9384a.compareAndSet(r10, r5, r13) == false) goto L2;
        return r12;
    }

    public final void lazySet(int r5, double r10) {
        long r11 = Double.doubleToRawLongBits(r10);
        this.f9384a.lazySet(r5, r11);
    }

    public final int length() {
        return this.f9384a.length();
    }

    public final void set(int r5, double r10) {
        long r11 = Double.doubleToRawLongBits(r10);
        this.f9384a.set(r5, r11);
    }

    public String toString() {
        int r5 = length();
        int r10 = r5 - 1;
        if (r10 != (-1)) goto L6;
        return "[]";
    L6:
        StringBuilder r11 = new StringBuilder(r5 * 19);
        r11.append('[');
        int r12 = 0;
    L7:
        r11.append(Double.longBitsToDouble(this.f9384a.get(r12)));
        if (r12 == r10) goto L9;
        r11.append(", ");
        r12 = r12 + 1;
        goto L7
    L9:
        r11.append(']');
        return r11.toString();
    }

    public final double updateAndGet(int r10, DoubleUnaryOperator r11) {
    L2:
        long r5 = this.f9384a.get(r10);
        double r12 = r11.applyAsDouble(Double.longBitsToDouble(r5));
        long r13 = Double.doubleToRawLongBits(r12);
        if (this.f9384a.compareAndSet(r10, r5, r13) == false) goto L2;
        return r12;
    }

    public final boolean weakCompareAndSet(int r10, double r11, double r12) {
        return this.f9384a.weakCompareAndSet(r10, Double.doubleToRawLongBits(r11), Double.doubleToRawLongBits(r12));
    }

    public AtomicDoubleArray(double[] r10) {
        int r5 = r10.length;
        long[] r11 = new long[r5];
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L5;
        r11[r12] = Double.doubleToRawLongBits(r10[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        this.f9384a = new AtomicLongArray(r11);
    }
}
