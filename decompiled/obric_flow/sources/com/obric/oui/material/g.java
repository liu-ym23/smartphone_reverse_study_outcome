package com.obric.oui.material;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f13655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f13656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f13657c;
    public final Object d;
    public final Object e;
    public final Object f;

    public g(Object r5, Object r10, Object r11, Object r12, Object r13, Object r14) {
        this.f13655a = r5;
        this.f13656b = r10;
        this.f13657c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    public final boolean a(Function2 r5) {
        Intrinsics.checkNotNullParameter(r5, "comparator");
        Object r10 = this.f13656b;
        Object r11 = this.f13655a;
        if (((Boolean) r5.mo2invoke(r11, r10)).booleanValue() == true) goto L5;
    L13:
        return false;
    L5:
        if (((Boolean) r5.mo2invoke(r11, this.f13657c)).booleanValue() == false) goto L13;
        if (((Boolean) r5.mo2invoke(r11, this.d)).booleanValue() == false) goto L13;
        if (((Boolean) r5.mo2invoke(r11, this.e)).booleanValue() == false) goto L13;
        if (((Boolean) r5.mo2invoke(r11, this.f)).booleanValue() == false) goto L13;
        return true;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r10 = (g) r5;
        Object r11 = r10.f13655a;
        if (Intrinsics.areEqual(this.f13655a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f13656b, r10.f13656b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f13657c, r10.f13657c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r5 = 0;
        Object r10 = this.f13655a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        Object r13 = this.f13656b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        Object r16 = this.f13657c;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        Object r19 = this.d;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        Object r22 = this.e;
        if (r22 != null) goto L21;
        int r23 = 0;
    L22:
        int r24 = (r21 + r23) * 31;
        Object r25 = this.f;
        if (r25 == null) goto L27;
        r5 = r25.hashCode();
    L27:
        return r24 + r5;
    L21:
        r23 = r22.hashCode();
        goto L22
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        return "ResolvedStatefulValues(normal=" + this.f13655a + ", pressed=" + this.f13656b + ", hovered=" + this.f13657c + ", checked=" + this.d + ", selected=" + this.e + ", disabled=" + this.f + ')';
    }
}
