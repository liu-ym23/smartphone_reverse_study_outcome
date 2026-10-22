package com.google.common.util.concurrent;

import com.google.common.primitives.ImmutableLongArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public class AtomicDoubleArray implements Serializable {
    private static final long serialVersionUID = 0;
    private transient AtomicLongArray longs;

    public AtomicDoubleArray(int r2) {
        this.longs = new AtomicLongArray(r2);
    }

    public AtomicDoubleArray(double[] r6) {
        int r0 = r6.length;
        long[] r1 = new long[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = Double.doubleToRawLongBits(r6[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        this.longs = new AtomicLongArray(r1);
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

    private void readObject(ObjectInputStream r6) {
        r6.defaultReadObject();
        int r0 = r6.readInt();
        ImmutableLongArray.a r1 = ImmutableLongArray.builder();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1.a(Double.doubleToRawLongBits(r6.readDouble()));
        r2 = r2 + 1;
        goto L3
    L5:
        this.longs = new AtomicLongArray(r1.a().toArray());
    }

    private void writeObject(ObjectOutputStream r5) {
        r5.defaultWriteObject();
        int r0 = length();
        r5.writeInt(r0);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.writeDouble(get(r1));
        r1 = r1 + 1;
        goto L3
    }

    public final double accumulateAndGet(int r3, final double r4, DoubleBinaryOperator r6) {
        final DoubleBinaryOperator r7 = (DoubleBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r6, DoubleBinaryOperator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r7);
        return updateAndGet(r3, new $$Lambda$AtomicDoubleArray$yyCuo_Avry5mZ7H8W6YCuUVtLb4(r7, r4));
    }

    public double addAndGet(int r2, double r3) {
        return accumulateAndGet(r2, r3, $$Lambda$AtomicDoubleArray$ytgBZSGCnGuHasEdcFi7uVvVrew.INSTANCE);
    }

    public final boolean compareAndSet(int r7, double r8, double r10) {
        return this.longs.compareAndSet(r7, Double.doubleToRawLongBits(r8), Double.doubleToRawLongBits(r10));
    }

    public final double get(int r1) {
        return Double.longBitsToDouble(this.longs.get(r1));
    }

    public final double getAndAccumulate(int r3, final double r4, DoubleBinaryOperator r6) {
        final DoubleBinaryOperator r7 = (DoubleBinaryOperator) ZeusTransformUtils.wrapperContextForParams(r6, DoubleBinaryOperator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r7);
        return getAndUpdate(r3, new $$Lambda$AtomicDoubleArray$qQncCu6OH5GrC139uAi5GYzuBLM(r7, r4));
    }

    public final double getAndAdd(int r2, double r3) {
        return getAndAccumulate(r2, r3, $$Lambda$AtomicDoubleArray$ytgBZSGCnGuHasEdcFi7uVvVrew.INSTANCE);
    }

    public final double getAndSet(int r1, double r2) {
        long r3 = Double.doubleToRawLongBits(r2);
        return Double.longBitsToDouble(this.longs.getAndSet(r1, r3));
    }

    public final double getAndUpdate(int r10, DoubleUnaryOperator r11) {
        DoubleUnaryOperator r12 = (DoubleUnaryOperator) ZeusTransformUtils.wrapperContextForParams(r11, DoubleUnaryOperator.class, "com.obric.memorydata.plugin");
    L3:
        long r3 = this.longs.get(r10);
        double r7 = Double.longBitsToDouble(r3);
        long r5 = Double.doubleToRawLongBits(r12.applyAsDouble(r7));
        if (this.longs.compareAndSet(r10, r3, r5) == false) goto L3;
        return r7;
    }

    public final void lazySet(int r1, double r2) {
        long r3 = Double.doubleToRawLongBits(r2);
        this.longs.lazySet(r1, r3);
    }

    public final int length() {
        return this.longs.length();
    }

    public final void set(int r1, double r2) {
        long r3 = Double.doubleToRawLongBits(r2);
        this.longs.set(r1, r3);
    }

    public String toString() {
        int r0 = length() - 1;
        if (r0 != (-1)) goto L6;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L6:
        StringBuilder r1 = new StringBuilder((r0 + 1) * 19);
        r1.append('[');
        int r2 = 0;
    L7:
        r1.append(Double.longBitsToDouble(this.longs.get(r2)));
        if (r2 == r0) goto L10;
        r1.append(',').append(' ');
        r2 = r2 + 1;
        goto L7
    L10:
        return r1.append(']').toString();
    }

    public final double updateAndGet(int r10, DoubleUnaryOperator r11) {
        DoubleUnaryOperator r12 = (DoubleUnaryOperator) ZeusTransformUtils.wrapperContextForParams(r11, DoubleUnaryOperator.class, "com.obric.memorydata.plugin");
    L3:
        long r3 = this.longs.get(r10);
        double r7 = r12.applyAsDouble(Double.longBitsToDouble(r3));
        long r5 = Double.doubleToRawLongBits(r7);
        if (this.longs.compareAndSet(r10, r3, r5) == false) goto L3;
        return r7;
    }

    public final boolean weakCompareAndSet(int r7, double r8, double r10) {
        return this.longs.weakCompareAndSet(r7, Double.doubleToRawLongBits(r8), Double.doubleToRawLongBits(r10));
    }
}
