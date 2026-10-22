package com.obric.common.oea.foundation.animation.spec.spring;

import com.ttnet.org.chromium.base.TimeUtils;
import k8.e;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements o8.a<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f5623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f5624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f5625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f5626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f5627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f5628f;

    public b(float r10, float r11, int r12, float r13) {
        this.f5625c = r10;
        this.f5626d = r11;
        this.f5627e = r12;
        this.f5628f = r13;
        e r14 = new e(1.0f);
        r14.d(r10);
        r14.f(r11);
        Unit r15 = Unit.INSTANCE;
        this.f5623a = r14;
        this.f5624b = 1.0f;
    }

    public /* synthetic */ b(float r10, float r11, int r12, float r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = 1.0f;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = 1.0f;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = 0;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = 0.01f;
    L14:
        this(r10, r11, r12, r13);
    }

    private final long f(long r10, float r11, float r12, float r13) {
        long r14 = g(r11, r12, r13);
        long r15 = r10 - (((long) this.f5627e) * TimeUtils.NANOSECONDS_PER_MILLISECOND);
        if (r14 < 0) goto L5;
        long r16 = r14;
    L7:
        return RangesKt.coerceIn(r15, 0, r16);
    L5:
        r16 = 0;
        goto L7
    }

    @Override // o8.a
    public /* bridge */ /* synthetic */ Float a(long r10, Float r11, Float r12, float r13) {
        return h(r10, r11.floatValue(), r12.floatValue(), r13);
    }

    @Override // o8.a
    public String b() {
        return "FloatSpringSpec(dampingRatio: " + this.f5625c + ", stiffness: " + this.f5626d + ", delay: " + this.f5627e + ", visibilityThreshold: " + this.f5628f + ", delta: " + this.f5624b + ')';
    }

    @Override // o8.a
    public /* bridge */ /* synthetic */ float c(long r10, Float r11, Float r12, float r13) {
        return i(r10, r11.floatValue(), r12.floatValue(), r13);
    }

    @Override // o8.a
    public /* bridge */ /* synthetic */ long d(Float r10, Float r11, float r12) {
        return g(r10.floatValue(), r11.floatValue(), r12);
    }

    @Override // o8.a
    public boolean e(long r10, long r11) {
        if (r10 < (r11 + (((long) this.f5627e) * TimeUtils.NANOSECONDS_PER_MILLISECOND))) goto L5;
        return true;
    L5:
        return false;
    }

    public long g(float r10, float r11, float r12) {
        float r13 = this.f5623a.b();
        float r14 = this.f5623a.a();
        float r15 = r10 - r11;
        float r16 = this.f5628f;
        float r17 = r12 / r16;
        return FloatSpringSpecKt.c(r13, r14, r17, r15 / r16, this.f5624b) * TimeUtils.NANOSECONDS_PER_MILLISECOND;
    }

    public Float h(long r10, float r11, float r12, float r13) {
        long r14 = f(r10, r11, r12, r13) / TimeUtils.NANOSECONDS_PER_MILLISECOND;
        this.f5623a.e(r12);
        return Float.valueOf(this.f5623a.g(r11, r13, r14).a());
    }

    public float i(long r10, float r11, float r12, float r13) {
        long r14 = f(r10, r11, r12, r13) / TimeUtils.NANOSECONDS_PER_MILLISECOND;
        this.f5623a.e(r12);
        return this.f5623a.g(r11, r13, r14).b();
    }

    public final void j(float r10) {
        this.f5624b = r10;
    }
}
