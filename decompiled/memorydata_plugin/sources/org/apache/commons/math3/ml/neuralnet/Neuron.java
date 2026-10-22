package org.apache.commons.math3.ml.neuralnet;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class Neuron implements Serializable {
    private static final long serialVersionUID = 20130207;
    private final AtomicReference<double[]> features;
    private final long identifier;
    private final AtomicLong numberOfAttemptedUpdates;
    private final AtomicLong numberOfSuccessfulUpdates;
    private final int size;

    private static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 20130207;
        private final double[] features;
        private final long identifier;

        SerializationProxy(long r1, double[] r3) {
            this.identifier = r1;
            this.features = r3;
        }

        private Object readResolve() {
            return new Neuron(this.identifier, this.features);
        }
    }

    Neuron(long r4, double[] r6) {
        this.numberOfAttemptedUpdates = new AtomicLong(0);
        this.numberOfSuccessfulUpdates = new AtomicLong(0);
        this.identifier = r4;
        this.size = r6.length;
        this.features = new AtomicReference(r6.clone());
    }

    private boolean containSameValues(double[] r7, double[] r8) {
        if (r8.length != this.size) goto L14;
        int r1 = 0;
    L6:
        if (r1 >= this.size) goto L11;
        if (Precision.equals(r7[r1], r8[r1]) == false) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    L14:
        throw new DimensionMismatchException(r8.length, this.size);
    }

    private void readObject(ObjectInputStream r1) {
        throw new IllegalStateException();
    }

    private Object writeReplace() {
        return new SerializationProxy(this.identifier, (double[]) ZeusTransformUtils.preCheckCast(this.features.get(), double[].class, "com.obric.memorydata.plugin"));
    }

    public boolean compareAndSetFeatures(double[] r4, double[] r5) {
        if (r5.length != this.size) goto L13;
        double[] r0 = (double[]) ZeusTransformUtils.preCheckCast(this.features.get(), double[].class, "com.obric.memorydata.plugin");
        if (containSameValues(r0, r4) == true) goto L7;
        return false;
    L7:
        this.numberOfAttemptedUpdates.incrementAndGet();
        if (this.features.compareAndSet(r0, (double[]) r5.clone()) == false) goto L11;
        this.numberOfSuccessfulUpdates.incrementAndGet();
        return true;
    L11:
        return false;
    L13:
        throw new DimensionMismatchException(r5.length, this.size);
    }

    public synchronized Neuron copy() {
        monitor-enter(this);
        Neuron r0 = new Neuron(getIdentifier(), getFeatures());     // Catch: Throwable -> L6
        r0.numberOfAttemptedUpdates.set(this.numberOfAttemptedUpdates.get());     // Catch: Throwable -> L6
        r0.numberOfSuccessfulUpdates.set(this.numberOfSuccessfulUpdates.get());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public double[] getFeatures() {
        return (double[]) ZeusTransformUtils.preCheckCast(((double[]) ZeusTransformUtils.preCheckCast(this.features.get(), double[].class, "com.obric.memorydata.plugin")).clone(), double[].class, "com.obric.memorydata.plugin");
    }

    public long getIdentifier() {
        return this.identifier;
    }

    public long getNumberOfAttemptedUpdates() {
        return this.numberOfAttemptedUpdates.get();
    }

    public long getNumberOfSuccessfulUpdates() {
        return this.numberOfSuccessfulUpdates.get();
    }

    public int getSize() {
        return this.size;
    }
}
