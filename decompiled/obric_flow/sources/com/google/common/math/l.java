package com.google.common.math;

import ai.j0;
import com.google.common.base.b0;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f9311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f9312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f9313c;
    public double d;
    public double e;

    public static double c(double r5, double r10) {
        if (com.google.common.primitives.a.s(r5) == false) goto L6;
        return r10;
    L6:
        if (com.google.common.primitives.a.s(r10) == false) goto L8;
        return r5;
    L8:
        if (r5 == r10) goto L13;
        return Double.NaN;
    L13:
        return r5;
    }

    public final void a(double r11) {
        long r5 = this.f9311a;
        if (r5 != 0) goto L7;
        this.f9311a = 1;
        this.f9312b = r11;
        this.d = r11;
        this.e = r11;
        if (com.google.common.primitives.a.s(r11) == true) goto L15;
        this.f9313c = Double.NaN;
        return;
    L15:
        return;
    L7:
        this.f9311a = r5 + 1;
        if (com.google.common.primitives.a.s(r11) == true) goto L10;
    L12:
        this.f9312b = c(this.f9312b, r11);
        this.f9313c = Double.NaN;
    L13:
        this.d = Math.min(this.d, r11);
        this.e = Math.max(this.e, r11);
        return;
    L10:
        if (com.google.common.primitives.a.s(this.f9312b) == false) goto L12;
        double r10 = this.f9312b;
        double r12 = r11 - r10;
        double r13 = (r12 / this.f9311a) + r10;
        this.f9312b = r13;
        this.f9313c = j0.a(r11, r13, r12, this.f9313c);
        goto L13
    }

    public final void b(l r22) {
        long r5 = r22.f9311a;
        if (r5 != 0) goto L6;
        return;
    L6:
        if (r5 == 0) goto L8;
        boolean r10 = true;
    L9:
        b0.t(r10);
        double r11 = r22.f9312b;
        double r12 = r22.f9313c;
        if (r22.f9311a == 0) goto L12;
        boolean r13 = true;
    L13:
        b0.t(r13);
        double r14 = r22.d;
        if (r22.f9311a == 0) goto L16;
        boolean r15 = true;
    L17:
        b0.t(r15);
        double r16 = r22.e;
        long r17 = this.f9311a;
        if (r17 != 0) goto L20;
        this.f9311a = r5;
        this.f9312b = r11;
        this.f9313c = r12;
        this.d = r14;
        this.e = r16;
        return;
    L20:
        this.f9311a = r17 + r5;
        if (com.google.common.primitives.a.s(this.f9312b) == true) goto L23;
    L25:
        this.f9312b = c(this.f9312b, r11);
        this.f9313c = Double.NaN;
    L26:
        this.d = Math.min(this.d, r14);
        this.e = Math.max(this.e, r16);
        return;
    L23:
        if (com.google.common.primitives.a.s(r11) == false) goto L25;
        double r18 = this.f9312b;
        double r19 = r11 - r18;
        double r20 = r5;
        double r21 = ((r19 * r20) / this.f9311a) + r18;
        this.f9312b = r21;
        this.f9313c = ((((r11 - r21) * r19) * r20) + r12) + this.f9313c;
        goto L26
    L16:
        r15 = false;
        goto L17
    L12:
        r13 = false;
        goto L13
    L8:
        r10 = false;
        goto L9
    }

    public final Stats d() {
        return new Stats(this.f9311a, this.f9312b, this.f9313c, this.d, this.e);
    }
}
