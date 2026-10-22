package com.obric.common.oea.foundation.animation.token;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/common/oea/foundation/animation/token/CubicBezierEasing;", "Lcom/obric/common/oea/foundation/animation/token/Easing;", "a", "", "b", "c", "d", "(FFFF)V", "max", "min", "equals", "", "other", "", "hashCode", "", "throwNoSolution", "", "fraction", "toString", "", "transform", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f7724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f7725b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;

    public a(float r7, float r8, float r9, float r10) {
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        com.obric.common.oea.foundation.animation.e.a r11 = c.a(0.0f, r8, r10, 1.0f, new float[5], 0);
        this.f7724a = Float.intBitsToFloat((int) (r11.f7714a >> 32));
        this.f7725b = Float.intBitsToFloat((int) (r11.f7714a & 4294967295L));
    }

    private final void b(float r5) {
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("The cubic curve with parameters (" + this.c + ", " + this.d + ", " + this.e + ", " + this.f + ") has no solution at " + r5), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.common.oea.foundation.animation.token.b
    public float a(float r5) {
        if (r5 > 0.0f) goto L5;
        return r5;
    L5:
        if (r5 >= 1.0f) goto L17;
        float r0 = c.a(0.0f - r5, this.c - r5, this.e - r5, 1.0f - r5);
        if (Float.isNaN(r0) == false) goto L9;
        b(r5);
    L9:
        float r6 = c.a(this.d, this.f, r0);
        float r1 = this.f7724a;
        float r4 = this.f7725b;
        if (r6 >= r1) goto L13;
        r6 = r1;
    L13:
        if (r6 > r4) goto L15;
        return r6;
    L15:
        return r4;
    L17:
        return r5;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L5;
    L13:
        return false;
    L5:
        if (this.c != ((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin")).c) goto L13;
        if (this.d != ((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin")).d) goto L13;
        if (this.e != ((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin")).e) goto L13;
        if (this.f != ((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin")).f) goto L13;
        return true;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.c) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + Float.hashCode(this.f);
    }

    public String toString() {
        return "CubicBezierEasing(a=" + this.c + ", b=" + this.d + ", c=" + this.e + ", d=" + this.f + ')';
    }
}
