package com.obric.common.oea.foundation.animation.spec.spring;

import android.graphics.Color;
import cja.e;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d implements gja.a<Integer> {
    public final e a;
    public float b;
    public final float c;
    public final float d;
    public final int e;
    public final float f;
    public final boolean g;

    @Override // gja.a
    public final String dump() {
        return "IntSpringSpec(dampingRatio: " + this.c + ", stiffness: " + this.d + ", delay: " + this.e + ", visibilityThreshold: " + this.f + ", delta: " + this.b + ')';
    }

    @Override // gja.a
    public final boolean a(long r5, long r7) {
        if (r5 < (r7 + (((long) this.e) * 1000000))) goto L5;
        return true;
    L5:
        return false;
    }

    public d(float r3, float r4, int r5) {
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = 0.01f;
        this.g = false;
        e r0 = new e();
        if (r3 < 0) goto L7;
        r0.f = r3;
        r0.b = false;
        r0.a(r4);
        Unit r6 = Unit.INSTANCE;
        this.a = r0;
        this.b = 1.0f;
        return;
    L7:
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    @Override // gja.a
    public final /* bridge */ /* synthetic */ long b(Integer r1, Integer r2, float r3) {
        return f(r1.intValue(), r2.intValue(), r3);
    }

    public final long f(int r10, int r11, float r12) {
        float r0 = Color.alpha(r10);
        float r1 = Color.alpha(r11);
        float r2 = Color.red(r10);
        float r3 = Color.red(r11);
        float r4 = Color.green(r10);
        float r5 = Color.green(r11);
        float r13 = Color.blue(r10);
        float r14 = Color.blue(r11);
        e r6 = this.a;
        double r7 = r6.a;
        float r8 = r6.f;
        float r9 = r0 - r1;
        float r15 = this.f;
        long r16 = c.b((float) (r7 * r7), r8, r12 / r15, r9 / r15, this.b);
        e r17 = this.a;
        double r18 = r17.a;
        float r19 = r17.f;
        float r20 = r2 - r3;
        float r21 = this.f;
        long r22 = c.b((float) (r18 * r18), r19, r12 / r21, r20 / r21, this.b);
        e r23 = this.a;
        double r24 = r23.a;
        float r25 = r23.f;
        float r26 = r4 - r5;
        float r27 = this.f;
        long r28 = c.b((float) (r24 * r24), r25, r12 / r27, r26 / r27, this.b);
        e r29 = this.a;
        double r30 = r29.a;
        float r31 = r29.f;
        float r110 = r13 - r14;
        float r111 = this.f;
        return ComparisonsKt.maxOf(r16, new long[]{r22, r28, c.b((float) (r30 * r30), r31, r12 / r111, r110 / r111, this.b)}) * 1000000;
    }

    @Override // gja.a
    public final Integer c(long r8, Integer r10, Integer r11, float r12) {
        int r13 = r10.intValue();
        int r14 = r11.intValue();
        long r9 = e(r8, r13, r14, r12) / 1000000;
        if (this.g == false) goto L5;
        int r0 = Color.alpha(r13);
        int r1 = Color.red(r13);
        int r2 = Color.green(r13);
        int r15 = Color.blue(r13);
        int r3 = Color.alpha(r14);
        int r4 = Color.red(r14);
        int r5 = Color.green(r14);
        int r16 = Color.blue(r14);
        e r6 = this.a;
        r6.g = r3;
        int r7 = (int) r6.b(r0, r12, r9).a();
        e r17 = this.a;
        r17.g = r4;
        int r18 = (int) r17.b(r1, r12, r9).a();
        e r19 = this.a;
        r19.g = r5;
        int r20 = (int) r19.b(r2, r12, r9).a();
        e r21 = this.a;
        r21.g = r16;
        int r22 = Color.argb(r7, r18, r20, (int) r21.b(r15, r12, r9).a());
    L7:
        return Integer.valueOf(r22);
    L5:
        e r23 = this.a;
        r23.g = r14;
        r22 = (int) r23.b(r13, r12, r9).a();
        goto L7
    }

    @Override // gja.a
    public final float d(long r8, Integer r10, Integer r11, float r12) {
        int r13 = r10.intValue();
        int r14 = r11.intValue();
        long r9 = e(r8, r13, r14, r12) / 1000000;
        if (this.g == false) goto L5;
        float r0 = Color.alpha(r13);
        float r1 = Color.red(r13);
        float r2 = Color.green(r13);
        float r15 = Color.blue(r13);
        float r3 = Color.alpha(r14);
        float r4 = Color.red(r14);
        float r5 = Color.green(r14);
        float r16 = Color.blue(r14);
        e r6 = this.a;
        r6.g = r3;
        float r7 = r6.b(r0, r12, r9).b();
        e r17 = this.a;
        r17.g = r4;
        float r18 = r17.b(r1, r12, r9).b();
        e r19 = this.a;
        r19.g = r5;
        float r20 = r19.b(r2, r12, r9).b();
        e r21 = this.a;
        r21.g = r16;
        float r22 = r21.b(r15, r12, r9).b();
        return (float) Math.sqrt((((r7 * r7) + (r18 * r18)) + (r20 * r20)) + (r22 * r22));
    L5:
        e r23 = this.a;
        r23.g = r14;
        return r23.b(r13, r12, r9).b();
    }

    public final long e(long r9, int r11, int r12, float r13) {
        long r14 = f(r11, r12, r13);
        long r2 = r9 - (((long) this.e) * 1000000);
        if (r14 < 0) goto L5;
        long r6 = r14;
    L7:
        return RangesKt.coerceIn(r2, 0, r6);
    L5:
        r6 = 0;
        goto L7
    }
}
