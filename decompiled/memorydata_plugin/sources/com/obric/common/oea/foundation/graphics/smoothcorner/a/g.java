package com.obric.common.oea.foundation.graphics.smoothcorner.a;

import android.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/QuadraticSmoothCornerImpl;", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/ISmoothCornerImpl;", "safeRadiusFactor", "", "(F)V", "CORNER_CORRECTION_FACTOR", "type", "", "getType", "()Ljava/lang/String;", "buildPath", "Landroid/graphics/Path;", "left", "top", "right", "bottom", "radius", "canDraw", "", "minDimension", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class g extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f7767b;
    private final String c;
    private final float d;

    public g() {
        this(0.0f, 1, null);
    }

    public g(float r1) {
        this.d = r1;
        this.f7767b = 1.175f;
        this.c = "QuadraticSmoothCornerImpl";
    }

    public /* synthetic */ g(float r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0.375f;
    L5:
        this(r1);
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.a.d
    public Path a(float r10, float r11, float r12, float r13, float r14) {
        float r0 = Math.min(r12 - r10, r13 - r11);
        if (r14 == 0.0f) goto L10;
        if (r14 >= (this.d * r0)) goto L10;
        float r9 = Math.min(r0 / 2.0f, r14 * this.f7767b);
        float r1 = r11 + r9;
        e r15 = new e(r12, r1);
        float r2 = r13 - r9;
        e r3 = new e(r12, r2);
        e r4 = new e(r12, r13);
        float r5 = r12 - r9;
        e r6 = new e(r5, r13);
        float r16 = r9 + r10;
        e r7 = new e(r16, r13);
        e r8 = new e(r10, r13);
        e r17 = new e(r10, r2);
        e r18 = new e(r10, r1);
        e r19 = new e(r10, r11);
        e r110 = new e(r16, r11);
        e r20 = new e(r5, r11);
        e r21 = new e(r12, r11);
        e r111 = new e(r12, r1);
        Path r112 = new Path();
        r112.moveTo(r15.a(), r15.b());
        r112.lineTo(r3.a(), r3.b());
        r112.quadTo(r4.a(), r4.b(), r6.a(), r6.b());
        r112.lineTo(r7.a(), r7.b());
        r112.quadTo(r8.a(), r8.b(), r17.a(), r17.b());
        r112.lineTo(r18.a(), r18.b());
        r112.quadTo(r19.a(), r19.b(), r110.a(), r110.b());
        r112.lineTo(r20.a(), r20.b());
        r112.quadTo(r21.a(), r21.b(), r111.a(), r111.b());
        r112.close();
        return r112;
    L10:
        return b(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.a.d
    public boolean a(float r1, float r2) {
        if (r1 >= (this.d * r2)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.a.d
    public String getType() {
        return this.c;
    }
}
