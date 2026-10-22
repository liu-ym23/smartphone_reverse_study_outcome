package com.larus.e_commerce.api;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public final FragmentActivity a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final boolean f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.e == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.f == true) goto L15;
        r2 = 1237;
    L15:
        return r5 + r2;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ECBindDouYinParams(activity=" + this.a + ", sourcePage=" + this.b + ", sourceMethod=" + this.c + ", bindPanelCancelButtonVisible=" + this.d + ", ignoreNotifyPopup=" + this.e + ", isMiniApplication=" + this.f + ')';
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    public /* synthetic */ b(FragmentActivity r8, String r9, String r10, boolean r11) {
        this(r8, r9, r10, r11, false, false);
    }

    public b(FragmentActivity r2, String r3, String r4, boolean r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "sourcePage");
        Intrinsics.checkNotNullParameter(r4, "sourceMethod");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
