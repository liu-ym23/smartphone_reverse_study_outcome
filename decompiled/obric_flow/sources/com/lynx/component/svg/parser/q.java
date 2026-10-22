package com.lynx.component.svg.parser;

import com.lynx.tasm.utils.DisplayMetricsHolder;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f9857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SVG$Unit f9858b;

    public q(float r5, SVG$Unit r10) {
        this.f9857a = r5;
        this.f9858b = r10;
    }

    public final float a(float r10, float r11) {
        SVG$Unit r5 = this.f9858b;
        int r12 = r5.ordinal();
        float r13 = this.f9857a;
        switch(r12) {
            case 1: goto L16;
            case 2: goto L4;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            case 8: goto L4;
            case 9: goto L16;
            case 10: goto L16;
            default: goto L4;
        };
    L4:
        return r13;
    L6:
        return (r13 * 96.0f) / 6.0f;
    L8:
        return (r13 * 96.0f) / 72.0f;
    L10:
        return (r13 * 96.0f) / 25.4f;
    L12:
        return (r13 * 96.0f) / 2.54f;
    L14:
        return r13 * 96.0f;
    L16:
        return com.lynx.tasm.utils.k.c(r13 + r5.toString(), r10, r11, 0.0f, 0.0f, 0.0f, DisplayMetricsHolder.a());
    }

    public final float b(p0 r10) {
        if (this.f9858b != SVG$Unit.d) goto L17;
        o0 r11 = r10.e;
        e r5 = r11.g;
        if (r5 != null) goto L8;
        r5 = r11.f;
    L8:
        float r12 = this.f9857a;
        if (r5 != null) goto L11;
        return r12;
    L11:
        float r13 = r5.f9803c;
        float r14 = r5.d;
        if (r13 == r14) goto L14;
        r13 = (float) (Math.sqrt((r14 * r14) + (r13 * r13)) / 1.414213562373095d);
    L14:
        return (r12 * r13) / 100.0f;
    L17:
        return g(r10);
    }

    public final boolean c() {
        if (this.f9857a >= 0.0f) goto L6;
        return true;
    L6:
        return false;
    }

    public final float e(p0 r5) {
        if (this.f9858b != SVG$Unit.d) goto L7;
        return (this.f9857a * 1.0f) / 100.0f;
    L7:
        return g(r5);
    }

    public final boolean f() {
        if (this.f9857a != 0.0f) goto L6;
        return true;
    L6:
        return false;
    }

    public final float g(p0 r10) {
        SVG$Unit r5 = this.f9858b;
        int r11 = r5.ordinal();
        float r12 = this.f9857a;
        switch(r11) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L17;
            case 6: goto L15;
            case 7: goto L13;
            case 8: goto L5;
            case 9: goto L25;
            case 10: goto L25;
            default: goto L4;
        };
    L4:
        return r12;
    L5:
        o0 r13 = r10.e;
        e r14 = r13.g;
        if (r14 != null) goto L9;
        r14 = r13.f;
    L9:
        if (r14 != null) goto L12;
        return r12;
    L12:
        return (r12 * r14.f9803c) / 100.0f;
    L13:
        r10.getClass();
        return (r12 * 96.0f) / 6.0f;
    L15:
        r10.getClass();
        return (r12 * 96.0f) / 72.0f;
    L17:
        r10.getClass();
        return (r12 * 96.0f) / 25.4f;
    L19:
        r10.getClass();
        return (r12 * 96.0f) / 2.54f;
    L21:
        r10.getClass();
        return r12 * 96.0f;
    L25:
        String r15 = r12 + r5.toString();
        float r16 = r10.f9854b;
        return com.lynx.tasm.utils.k.c(r15, r16, r16, 0.0f, 0.0f, 0.0f, DisplayMetricsHolder.a());
    L24:
        return (r10.f9854b / 2.0f) * r12;
    }

    public final float h(p0 r5) {
        if (this.f9858b != SVG$Unit.d) goto L14;
        o0 r10 = r5.e;
        e r11 = r10.g;
        if (r11 != null) goto L8;
        r11 = r10.f;
    L8:
        float r12 = this.f9857a;
        if (r11 != null) goto L12;
        return r12;
    L12:
        return (r12 * r11.d) / 100.0f;
    L14:
        return g(r5);
    }

    public final String toString() {
        return String.valueOf(this.f9857a) + this.f9858b;
    }

    public q() {
        this.f9857a = 0.0f;
        this.f9858b = SVG$Unit.f9757a;
    }
}
