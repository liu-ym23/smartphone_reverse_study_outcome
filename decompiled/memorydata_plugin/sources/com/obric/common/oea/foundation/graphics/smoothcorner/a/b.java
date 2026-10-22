package com.obric.common.oea.foundation.graphics.smoothcorner.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/ControlPoint;", "", "handleLarge", "", "distanceOuter", "distanceInner", "handleMedium", "curveInner", "curveOuter", "(FFFFFF)V", "getCurveInner", "()F", "getCurveOuter", "getDistanceInner", "getDistanceOuter", "getHandleLarge", "getHandleMedium", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f7759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f7760b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;

    public b(float r1, float r2, float r3, float r4, float r5, float r6) {
        this.f7759a = r1;
        this.f7760b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final float a() {
        return this.f7759a;
    }

    public final float b() {
        return this.f7760b;
    }

    public final float c() {
        return this.c;
    }

    public final float d() {
        return this.d;
    }

    public final float e() {
        return this.e;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L19;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin");
        if (Float.compare(this.f7759a, r4.f7759a) == 0) goto L9;
        return false;
    L9:
        if (Float.compare(this.f7760b, r4.f7760b) == 0) goto L11;
        return false;
    L11:
        if (Float.compare(this.c, r4.c) == 0) goto L13;
        return false;
    L13:
        if (Float.compare(this.d, r4.d) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.e, r4.e) == 0) goto L17;
        return false;
    L17:
        if (Float.compare(this.f, r4.f) == 0) goto L29;
        return false;
    L29:
        return true;
    L19:
        return false;
    }

    public final float f() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((Float.hashCode(this.f7759a) * 31) + Float.hashCode(this.f7760b)) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + Float.hashCode(this.f);
    }

    public String toString() {
        return "ControlPoint(handleLarge=" + this.f7759a + ", distanceOuter=" + this.f7760b + ", distanceInner=" + this.c + ", handleMedium=" + this.d + ", curveInner=" + this.e + ", curveOuter=" + this.f + ")";
    }
}
