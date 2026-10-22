package com.obric.assistant.settings.autogui;

import com.obric.assistant.RiskPreferenceSettings;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class u0 {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final int e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u0) == true) goto L8;
        return false;
    L8:
        u0 r6 = (u0) r5;
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
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.e;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "RiskPreferenceItemUiModel(value=" + this.a + ", title=" + this.b + ", subtitle=" + this.c + ", selected=" + this.d + ", cardPosition=" + this.e + ')';
    }

    public u0(@RiskPreferenceSettings String r2, String r3, String r4, boolean r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "value");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "subtitle");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
