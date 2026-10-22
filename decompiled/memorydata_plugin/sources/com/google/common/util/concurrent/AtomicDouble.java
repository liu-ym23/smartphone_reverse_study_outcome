package com.google.common.util.concurrent;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public class AtomicDouble extends Number implements Serializable {
    private static final long serialVersionUID = 0;
    private static final AtomicLongFieldUpdater<AtomicDouble> updater = null;
    private volatile transient long value;

    static {
        updater = AtomicLongFieldUpdater.newUpdater(AtomicDouble.class, EventBody.KEY_VALUE);
    }

    public AtomicDouble() {
    }

    public AtomicDouble(double r1) {
        this.value = Double.doubleToRawLongBits(r1);
    }

    static /* synthetic */ double lambda$accumulateAndGet$1(DoubleBinaryOperator r2, double r3, double r5) {
        return ((DoubleBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r2, DoubleBinaryOperator.class, "com.obric.memorydata.plugin")).applyAsDouble(r5, r3);
    }

    static /* synthetic */ double lambda$getAndAccumulate$0(DoubleBinaryOperator r2, double r3, double r5) {
        return ((DoubleBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r2, DoubleBinaryOperator.class, "com.obric.memorydata.plugin")).applyAsDouble(r5, r3);
    }

    public static /* synthetic */ double lambda$ytgBZSGCnGuHasEdcFi7uVvVrew(double r0, double r2) {
        return Double.sum(r0, r2);
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        set(r3.readDouble());
    }

    private void writeObject(ObjectOutputStream r3) {
        r3.defaultWriteObject();
        r3.writeDouble(get());
    }

    public final double accumulateAndGet(final double r3, DoubleBinaryOperator r5) {
        final DoubleBinaryOperator r6 = (DoubleBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r5, DoubleBinaryOperator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r6);
        return updateAndGet(new $$Lambda$AtomicDouble$oHNNHdVtCDy2fYcoRj55pHibkIk(r6, r3));
    }

    public final double addAndGet(double r2) {
        return accumulateAndGet(r2, $$Lambda$AtomicDouble$ytgBZSGCnGuHasEdcFi7uVvVrew.INSTANCE);
    }

    public final boolean compareAndSet(double r7, double r9) {
        return updater.compareAndSet(this, Double.doubleToRawLongBits(r7), Double.doubleToRawLongBits(r9));
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
        return Double.longBitsToDouble(this.value);
    }

    public final double getAndAccumulate(final double r3, DoubleBinaryOperator r5) {
        final DoubleBinaryOperator r6 = (DoubleBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r5, DoubleBinaryOperator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r6);
        return getAndUpdate(new $$Lambda$AtomicDouble$Bn5EyevyRBQkst_fyxEt_3DII0A(r6, r3));
    }

    public final double getAndAdd(double r2) {
        return getAndAccumulate(r2, $$Lambda$AtomicDouble$ytgBZSGCnGuHasEdcFi7uVvVrew.INSTANCE);
    }

    public final double getAndSet(double r2) {
        long r3 = Double.doubleToRawLongBits(r2);
        return Double.longBitsToDouble(updater.getAndSet(this, r3));
    }

    public final double getAndUpdate(DoubleUnaryOperator r9) {
        DoubleUnaryOperator r10 = (DoubleUnaryOperator) ZeusTransformUtils.wrapperContextForParams(r9, DoubleUnaryOperator.class, "com.obric.memorydata.plugin");
    L3:
        long r2 = this.value;
        double r6 = Double.longBitsToDouble(r2);
        long r4 = Double.doubleToRawLongBits(r10.applyAsDouble(r6));
        if (updater.compareAndSet(this, r2, r4) == false) goto L3;
        return r6;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    public final void lazySet(double r2) {
        long r3 = Double.doubleToRawLongBits(r2);
        updater.lazySet(this, r3);
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    public final void set(double r1) {
        this.value = Double.doubleToRawLongBits(r1);
    }

    public String toString() {
        return Double.toString(get());
    }

    public final double updateAndGet(DoubleUnaryOperator r9) {
        DoubleUnaryOperator r10 = (DoubleUnaryOperator) ZeusTransformUtils.wrapperContextForParams(r9, DoubleUnaryOperator.class, "com.obric.memorydata.plugin");
    L3:
        long r2 = this.value;
        double r6 = r10.applyAsDouble(Double.longBitsToDouble(r2));
        long r4 = Double.doubleToRawLongBits(r6);
        if (updater.compareAndSet(this, r2, r4) == false) goto L3;
        return r6;
    }

    public final boolean weakCompareAndSet(double r7, double r9) {
        return updater.weakCompareAndSet(this, Double.doubleToRawLongBits(r7), Double.doubleToRawLongBits(r9));
    }
}
