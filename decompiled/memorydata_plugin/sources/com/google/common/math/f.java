package com.google.common.math;

import com.google.common.base.n;
import com.google.common.primitives.Doubles;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f4754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f4755b;
    private double c;
    private double d;
    private double e;

    public f() {
        this.f4754a = 0;
        this.f4755b = 0.0d;
        this.c = 0.0d;
        this.d = Double.NaN;
        this.e = Double.NaN;
    }

    static double a(double r1, double r3) {
        if (Doubles.b(r1) == false) goto L6;
        return r3;
    L6:
        if (Doubles.b(r3) == false) goto L8;
        return r1;
    L8:
        if (r1 == r3) goto L13;
        return Double.NaN;
    L13:
        return r1;
    }

    private void a(long r18, double r20, double r22, double r24, double r26) {
        long r11 = this.f4754a;
        if (r11 != 0) goto L5;
        this.f4754a = r18;
        this.f4755b = r20;
        this.c = r22;
        this.d = r24;
        this.e = r26;
        return;
    L5:
        this.f4754a = r11 + r18;
        if (Doubles.b(this.f4755b) == true) goto L8;
    L10:
        this.f4755b = a(this.f4755b, r20);
        this.c = Double.NaN;
    L11:
        this.d = Math.min(this.d, r24);
        this.e = Math.max(this.e, r26);
        return;
    L8:
        if (Doubles.b(r20) == false) goto L10;
        double r12 = this.f4755b;
        double r13 = r20 - r12;
        double r1 = r18;
        double r14 = r12 + ((r13 * r1) / this.f4754a);
        this.f4755b = r14;
        this.c += r22 + ((r13 * (r20 - r14)) * r1);
        goto L11
    }

    public Stats a() {
        return new Stats(this.f4754a, this.f4755b, this.c, this.d, this.e);
    }

    public void a(double r8) {
        long r0 = this.f4754a;
        if (r0 != 0) goto L7;
        this.f4754a = 1;
        this.f4755b = r8;
        this.d = r8;
        this.e = r8;
        if (Doubles.b(r8) == true) goto L15;
        this.c = Double.NaN;
        return;
    L15:
        return;
    L7:
        this.f4754a = r0 + 1;
        if (Doubles.b(r8) == true) goto L10;
    L12:
        this.f4755b = a(this.f4755b, r8);
        this.c = Double.NaN;
    L13:
        this.d = Math.min(this.d, r8);
        this.e = Math.max(this.e, r8);
        return;
    L10:
        if (Doubles.b(this.f4755b) == false) goto L12;
        double r1 = this.f4755b;
        double r2 = r8 - r1;
        double r3 = r1 + (r2 / this.f4754a);
        this.f4755b = r3;
        this.c += r2 * (r8 - r3);
        goto L13
    }

    public void a(f r13) {
        if (r13.b() != 0) goto L5;
        return;
    L5:
        a(r13.b(), r13.c(), r13.f(), r13.d(), r13.e());
    }

    public void a(Iterable<? extends Number> r5) {
        Iterator r6 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        a(((Number) ZeusTransformUtils.preCheckCast(r6.next(), Number.class, "com.obric.memorydata.plugin")).doubleValue());
        goto L4
    }

    public void a(Iterator<? extends Number> r5) {
        Iterator r6 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r5, Iterator.class, "com.obric.memorydata.plugin");
    L4:
        if (r6.hasNext() == false) goto L6;
        a(((Number) ZeusTransformUtils.preCheckCast(r6.next(), Number.class, "com.obric.memorydata.plugin")).doubleValue());
        goto L4
    }

    public void a(double... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        a(r5[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public void a(int... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        a(r5[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public void a(long... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        a(r5[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public long b() {
        return this.f4754a;
    }

    public double c() {
        if (this.f4754a == 0) goto L5;
        boolean r0 = true;
    L6:
        n.b(r0);
        return this.f4755b;
    L5:
        r0 = false;
        goto L6
    }

    public double d() {
        if (this.f4754a == 0) goto L5;
        boolean r0 = true;
    L6:
        n.b(r0);
        return this.d;
    L5:
        r0 = false;
        goto L6
    }

    public double e() {
        if (this.f4754a == 0) goto L5;
        boolean r0 = true;
    L6:
        n.b(r0);
        return this.e;
    L5:
        r0 = false;
        goto L6
    }

    double f() {
        return this.c;
    }
}
