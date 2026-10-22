package com.obric.oui.texteffects.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJD\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0015\u0010!\u001a\u0004\u0018\u00010\u00032\u0006\u0010\"\u001a\u00020\u0003¢\u0006\u0002\u0010#J\t\u0010$\u001a\u00020%HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006&"}, d2 = {"Lcom/obric/oui/texteffects/core/GradientBlurLayerSpec;", "", "blurRadius", "", "direction", "Lcom/obric/oui/texteffects/core/Direction;", "curveType", "Lcom/obric/oui/texteffects/core/GradientBlurCurveType;", "endPoint", "blurRadiusPercent", "(Ljava/lang/Float;Lcom/obric/oui/texteffects/core/Direction;Lcom/obric/oui/texteffects/core/GradientBlurCurveType;FLjava/lang/Float;)V", "getBlurRadius", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getBlurRadiusPercent", "getCurveType", "()Lcom/obric/oui/texteffects/core/GradientBlurCurveType;", "getDirection", "()Lcom/obric/oui/texteffects/core/Direction;", "getEndPoint", "()F", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Float;Lcom/obric/oui/texteffects/core/Direction;Lcom/obric/oui/texteffects/core/GradientBlurCurveType;FLjava/lang/Float;)Lcom/obric/oui/texteffects/core/GradientBlurLayerSpec;", "equals", "", "other", "hashCode", "", "resolveBlurRadiusPx", "textSizePx", "(F)Ljava/lang/Float;", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Float f14627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Direction f14628b;
    private final GradientBlurCurveType c;
    private final float d;
    private final Float e;

    public o(Float r2, Direction r3, GradientBlurCurveType r4, float r5, Float r6) {
        Intrinsics.checkNotNullParameter(r3, "direction");
        Intrinsics.checkNotNullParameter(r4, "curveType");
        this.f14627a = r2;
        this.f14628b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public /* synthetic */ o(Float r8, Direction r9, GradientBlurCurveType r10, float r11, Float r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L5;
        Float r2 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        r10 = GradientBlurCurveType.Linear;
    L9:
        GradientBlurCurveType r4 = r10;
        if ((r13 & 8) == 0) goto L12;
        r11 = 1.0f;
    L12:
        float r5 = r11;
        if ((r13 & 16) == 0) goto L15;
        Float r6 = null;
    L16:
        this(r2, r9, r4, r5, r6);
        return;
    L15:
        r6 = r12;
        goto L16
    L5:
        r2 = r8;
        goto L7
    }

    public final Direction a() {
        return this.f14628b;
    }

    public final Float a(float r4) {
        Float r0 = this.e;
        if (r0 != null) goto L5;
        Float r5 = null;
    L6:
        if (r5 == null) goto L8;
        return r5;
    L8:
        return this.f14627a;
    L5:
        r5 = Float.valueOf(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).floatValue() * r4);
        goto L6
    }

    public final GradientBlurCurveType b() {
        return this.c;
    }

    public final float c() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, o.class) == true) goto L8;
        return false;
    L8:
        o r6 = (o) ZeusTransformUtils.preCheckCast(r5, o.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f14627a, r6.f14627a) == true) goto L12;
        return false;
    L12:
        if (this.f14628b == r6.f14628b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(Float.valueOf(this.d), Float.valueOf(r6.d)) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Float r0 = this.f14627a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((((r2 * 31) + this.f14628b.hashCode()) * 31) + this.c.hashCode()) * 31) + Float.hashCode(this.d)) * 31;
        Float r4 = this.e;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "GradientBlurLayerSpec(blurRadius=" + this.f14627a + ", direction=" + this.f14628b + ", curveType=" + this.c + ", endPoint=" + this.d + ", blurRadiusPercent=" + this.e + ')';
    }
}
