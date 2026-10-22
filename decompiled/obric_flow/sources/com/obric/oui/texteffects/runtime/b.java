package com.obric.oui.texteffects.runtime;

import java.util.Map;
import js.r;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14743c;
    public final long d;
    public final float e;
    public final float f;
    public final float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f14744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final r f14745i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f14746j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f8.b f14747k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f8.b f14748l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f8.b f14749m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map f14750n;

    public b(String r5, String r10, String r11, long r12, float r13, float r14, float r15, r r16, float r17, f8.b r18, f8.b r19, f8.b r110) {
        Map r20 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r5, "stageId");
        Intrinsics.checkNotNullParameter(r10, "layerId");
        Intrinsics.checkNotNullParameter(r20, "properties");
        this.f14741a = r5;
        this.f14742b = r10;
        this.f14743c = r11;
        this.d = r12;
        this.e = r13;
        this.f = Float.NaN;
        this.g = r14;
        this.f14744h = r15;
        this.f14745i = r16;
        this.f14746j = r17;
        this.f14747k = r18;
        this.f14748l = r19;
        this.f14749m = r110;
        this.f14750n = r20;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        String r5 = r11.f14741a;
        if (Intrinsics.areEqual(this.f14741a, r5) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f14742b, r11.f14742b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f14743c, r11.f14743c) == true) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(Float.valueOf(this.e), Float.valueOf(r11.e)) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(Float.valueOf(this.f), Float.valueOf(r11.f)) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(Float.valueOf(this.g), Float.valueOf(r11.g)) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(Float.valueOf(this.f14744h), Float.valueOf(r11.f14744h)) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f14745i, r11.f14745i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(Float.valueOf(this.f14746j), Float.valueOf(r11.f14746j)) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f14747k, r11.f14747k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f14748l, r11.f14748l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f14749m, r11.f14749m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f14750n, r11.f14750n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(this.f14741a.hashCode() * 31, 31, this.f14742b);
        int r10 = 0;
        String r11 = this.f14743c;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = androidx.constraintlayout.motion.widget.a.b(this.f14744h, androidx.constraintlayout.motion.widget.a.b(this.g, androidx.constraintlayout.motion.widget.a.b(this.f, androidx.constraintlayout.motion.widget.a.b(this.e, androidx.room.jarjarred.org.antlr.runtime.a.e((r5 + r12) * 31, this.d, 31), 31), 31), 31), 31);
        r r14 = this.f14745i;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = androidx.constraintlayout.motion.widget.a.b(this.f14746j, (r13 + r15) * 31, 31);
        f8.b r17 = this.f14747k;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        f8.b r20 = this.f14748l;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        f8.b r23 = this.f14749m;
        if (r23 == null) goto L23;
        r10 = r23.hashCode();
    L23:
        return this.f14750n.hashCode() + ((r22 + r10) * 31);
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        return "LayerFrame(stageId=" + this.f14741a + ", layerId=" + this.f14742b + ", bindingKey=" + this.f14743c + ", stagePlayTimeMs=" + this.d + ", alpha=" + this.e + ", gradientAlpha=" + this.f + ", scanProgress=" + this.g + ", tracking=" + this.f14744h + ", scanSelector=" + this.f14745i + ", visibility=" + this.f14746j + ", blurRadius=" + this.f14747k + ", translationX=" + this.f14748l + ", translationY=" + this.f14749m + ", properties=" + this.f14750n + ')';
    }
}
