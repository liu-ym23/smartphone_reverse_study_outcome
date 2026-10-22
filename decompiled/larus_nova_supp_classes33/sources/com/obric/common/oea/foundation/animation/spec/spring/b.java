package com.obric.common.oea.foundation.animation.spec.spring;

import cja.e;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b implements gja.a<Float> {
    public final e a;
    public float b;
    public final float c;
    public final float d;
    public final int e;
    public final float f;

    @Override // gja.a
    public final String dump() {
        return "FloatSpringSpec(dampingRatio: " + this.c + ", stiffness: " + this.d + ", delay: " + this.e + ", visibilityThreshold: " + this.f + ", delta: " + this.b + ')';
    }

    @Override // gja.a
    public final boolean a(long r5, long r7) {
        if (r5 < (r7 + (((long) this.e) * 1000000))) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // gja.a
    public final long b(Float r4, Float r5, float r6) {
        float r7 = r4.floatValue();
        float r8 = r5.floatValue();
        e r0 = this.a;
        double r1 = r0.a;
        float r2 = r0.f;
        float r9 = r7 - r8;
        float r10 = this.f;
        float r11 = r6 / r10;
        return c.b((float) (r1 * r1), r2, r11, r9 / r10, this.b) * 1000000;
    }

    public b(float r4, float r5, int r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r4 = 1.0f;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r5 = 1.0f;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r6 = 0;
    L12:
        if ((r7 & 8) == 0) goto L14;
        float r8 = 0.01f;
    L15:
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        e r9 = new e();
        if (r4 < 0) goto L20;
        r9.f = r4;
        r9.b = false;
        r9.a(r5);
        Unit r10 = Unit.INSTANCE;
        this.a = r9;
        this.b = 1.0f;
        return;
    L20:
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    L14:
        r8 = 0.0f;
        goto L15
    }

    @Override // gja.a
    public final Float c(long r7, Float r9, Float r10, float r11) {
        float r12 = r9.floatValue();
        float r13 = r10.floatValue();
        long r8 = e(r7, r12, r13, r11) / 1000000;
        e r0 = this.a;
        r0.g = r13;
        return Float.valueOf(r0.b(r12, r11, r8).a());
    }

    @Override // gja.a
    public final float d(long r7, Float r9, Float r10, float r11) {
        float r12 = r9.floatValue();
        float r13 = r10.floatValue();
        long r8 = e(r7, r12, r13, r11) / 1000000;
        e r0 = this.a;
        r0.g = r13;
        return r0.b(r12, r11, r8).b();
    }

    public final long e(long r11, float r13, float r14, float r15) {
        e r0 = this.a;
        double r1 = r0.a;
        float r2 = r0.f;
        float r16 = r13 - r14;
        float r17 = this.f;
        long r18 = c.b((float) (r1 * r1), r2, r15 / r17, r16 / r17, this.b) * 1000000;
        long r4 = r11 - (((long) this.e) * 1000000);
        if (r18 < 0) goto L5;
        long r8 = r18;
    L7:
        return RangesKt.coerceIn(r4, 0, r8);
    L5:
        r8 = 0;
        goto L7
    }
}
