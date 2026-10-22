package org.apache.commons.math3.complex;

import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class RootsOfUnity implements Serializable {
    private static final long serialVersionUID = 20120201;
    private boolean isCounterClockWise;
    private int omegaCount;
    private double[] omegaImaginaryClockwise;
    private double[] omegaImaginaryCounterClockwise;
    private double[] omegaReal;

    public RootsOfUnity() {
        this.omegaCount = 0;
        this.omegaReal = null;
        this.omegaImaginaryCounterClockwise = null;
        this.omegaImaginaryClockwise = null;
        this.isCounterClockWise = true;
    }

    public synchronized void computeRoots(int r13) {
        monitor-enter(this);
        if (r13 == 0) goto L21;
        int r1 = 1;
        if (r13 <= 0) goto L8;
        boolean r2 = true;
    L9:
        this.isCounterClockWise = r2;     // Catch: Throwable -> L22
        int r14 = FastMath.abs(r13);     // Catch: Throwable -> L22
        if (r14 != this.omegaCount) goto L13;
        monitor-exit(this);
        return;
    L13:
        double r3 = 6.283185307179586d / ((double) r14);
        double r4 = FastMath.cos(r3);     // Catch: Throwable -> L22
        double r5 = FastMath.sin(r3);     // Catch: Throwable -> L22
        double[] r6 = new double[r14];     // Catch: Throwable -> L22
        this.omegaReal = r6;     // Catch: Throwable -> L22
        double[] r7 = new double[r14];     // Catch: Throwable -> L22
        this.omegaImaginaryCounterClockwise = r7;     // Catch: Throwable -> L22
        double[] r8 = new double[r14];     // Catch: Throwable -> L22
        this.omegaImaginaryClockwise = r8;     // Catch: Throwable -> L22
        r6[0] = 1.0d;     // Catch: Throwable -> L22
        r7[0] = 0.0d;     // Catch: Throwable -> L22
        r8[0] = 0.0d;     // Catch: Throwable -> L22
    L15:
        if (r1 >= r14) goto L17;
        double[] r0 = this.omegaReal;     // Catch: Throwable -> L22
        int r9 = r1 - 1;     // Catch: Throwable -> L22
        double r10 = r0[r9] * r4;     // Catch: Throwable -> L22
        double[] r11 = this.omegaImaginaryCounterClockwise;     // Catch: Throwable -> L22
        r0[r1] = r10 - (r11[r9] * r5);     // Catch: Throwable -> L22
        r11[r1] = (r0[r9] * r5) + (r11[r9] * r4);     // Catch: Throwable -> L22
        this.omegaImaginaryClockwise[r1] = -r11[r1];     // Catch: Throwable -> L22
        r1 = r1 + 1;     // Catch: Throwable -> L22
        goto L15
    L17:
        this.omegaCount = r14;     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L8:
        r2 = false;
        goto L9
    L21:
        throw new ZeroException(LocalizedFormats.CANNOT_COMPUTE_0TH_ROOT_OF_UNITY, new Object[0]);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public synchronized double getImaginary(int r5) {
        monitor-enter(this);
        int r0 = this.omegaCount;     // Catch: Throwable -> L17
        if (r0 == 0) goto L16;
        if (r5 < 0) goto L14;
        if (r5 >= r0) goto L14;
        if (this.isCounterClockWise == false) goto L10;
        double r1 = this.omegaImaginaryCounterClockwise[r5];     // Catch: Throwable -> L17
    L11:
        monitor-exit(this);
        return r1;
    L10:
        r1 = this.omegaImaginaryClockwise[r5];     // Catch: Throwable -> L17
    L14:
        throw new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE_ROOT_OF_UNITY_INDEX, Integer.valueOf(r5), 0, Integer.valueOf(this.omegaCount - 1));     // Catch: Throwable -> L17
    L16:
        throw new MathIllegalStateException(LocalizedFormats.ROOTS_OF_UNITY_NOT_COMPUTED_YET, new Object[0]);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public synchronized int getNumberOfRoots() {
        monitor-enter(this);
        int r0 = this.omegaCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized double getReal(int r5) {
        monitor-enter(this);
        int r0 = this.omegaCount;     // Catch: Throwable -> L14
        if (r0 == 0) goto L13;
        if (r5 < 0) goto L11;
        if (r5 >= r0) goto L11;
        double r1 = this.omegaReal[r5];     // Catch: Throwable -> L14
        monitor-exit(this);
        return r1;
    L11:
        throw new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE_ROOT_OF_UNITY_INDEX, Integer.valueOf(r5), 0, Integer.valueOf(this.omegaCount - 1));     // Catch: Throwable -> L14
    L13:
        throw new MathIllegalStateException(LocalizedFormats.ROOTS_OF_UNITY_NOT_COMPUTED_YET, new Object[0]);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isCounterClockWise() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.omegaCount == 0) goto L9;
        boolean r0 = this.isCounterClockWise;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r0;
    L9:
        throw new MathIllegalStateException(LocalizedFormats.ROOTS_OF_UNITY_NOT_COMPUTED_YET, new Object[0]);     // Catch: Throwable -> L10
    }
}
