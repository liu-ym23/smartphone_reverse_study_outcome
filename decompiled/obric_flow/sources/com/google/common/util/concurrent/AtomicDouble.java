package com.google.common.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public class AtomicDouble extends Number implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f9382b = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile transient long f9383a;

    static {
        f9382b = AtomicLongFieldUpdater.newUpdater(AtomicDouble.class, "a");
    }

    public AtomicDouble(double r5) {
        this.f9383a = Double.doubleToRawLongBits(r5);
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        set(r5.readDouble());
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        r5.writeDouble(get());
    }

    public final double accumulateAndGet(double r5, DoubleBinaryOperator r10) {
        r10.getClass();
        return updateAndGet(new t(1, r5, r10));
    }

    public final double addAndGet(double r5) {
        return accumulateAndGet(r5, new s());
    }

    public final boolean compareAndSet(double r10, double r11) {
        long r5 = Double.doubleToRawLongBits(r10);
        long r12 = Double.doubleToRawLongBits(r11);
        return f9382b.compareAndSet(this, r5, r12);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    public final double get() {
        return Double.longBitsToDouble(this.f9383a);
    }

    public final double getAndAccumulate(double r5, DoubleBinaryOperator r10) {
        r10.getClass();
        return getAndUpdate(new t(0, r5, r10));
    }

    public final double getAndAdd(double r5) {
        return getAndAccumulate(r5, new s());
    }

    public final double getAndSet(double r5) {
        long r10 = Double.doubleToRawLongBits(r5);
        return Double.longBitsToDouble(f9382b.getAndSet(this, r10));
    }

    public final double getAndUpdate(DoubleUnaryOperator r10) {
    L2:
        long r5 = this.f9383a;
        double r11 = Double.longBitsToDouble(r5);
        long r12 = Double.doubleToRawLongBits(r10.applyAsDouble(r11));
        if (f9382b.compareAndSet(this, r5, r12) == false) goto L2;
        return r11;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    public final void lazySet(double r5) {
        long r10 = Double.doubleToRawLongBits(r5);
        f9382b.lazySet(this, r10);
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    public final void set(double r5) {
        this.f9383a = Double.doubleToRawLongBits(r5);
    }

    public String toString() {
        return Double.toString(get());
    }

    public final double updateAndGet(DoubleUnaryOperator r10) {
    L2:
        long r5 = this.f9383a;
        double r11 = r10.applyAsDouble(Double.longBitsToDouble(r5));
        long r12 = Double.doubleToRawLongBits(r11);
        if (f9382b.compareAndSet(this, r5, r12) == false) goto L2;
        return r11;
    }

    public final boolean weakCompareAndSet(double r10, double r11) {
        long r5 = Double.doubleToRawLongBits(r10);
        long r12 = Double.doubleToRawLongBits(r11);
        return f9382b.weakCompareAndSet(this, r5, r12);
    }

    public AtomicDouble() {
    }
}
