package com.ss.android.lark.passport.flow.mfa;

import com.alibaba.fastjson.JSONObject;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class y {
    public final FlowVerifyFactor a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final FlowStep j;
    public final x k;
    public final JSONObject l;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof y) == true) goto L8;
        return false;
    L8:
        y r6 = (y) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        String r3 = this.f;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((((((r2 + r5) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        FlowStep r7 = this.j;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        x r10 = this.k;
        if (r10 == null) goto L19;
        r4 = r10.hashCode();
    L19:
        return ((r9 + r4) * 31) + this.l.hashCode();
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowVerifyFactorData(factor=" + this.a + ", title=" + this.b + ", subtitle=" + this.c + ", flowType=" + this.d + ", disabled=" + this.e + ", disabledToastText=" + this.f + ", inputPlaceholder=" + this.g + ", inputLabel=" + this.h + ", buttonText=" + this.i + ", nextButtonStep=" + this.j + ", rsaInfo=" + this.k + ", raw=" + this.l + ')';
    }

    public y(FlowVerifyFactor r2, String r3, String r4, String r5, boolean r6, String r7, String r8, String r9, String r10, FlowStep r11, x r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r2, "factor");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "subtitle");
        Intrinsics.checkNotNullParameter(r5, "flowType");
        Intrinsics.checkNotNullParameter(r8, "inputPlaceholder");
        Intrinsics.checkNotNullParameter(r9, "inputLabel");
        Intrinsics.checkNotNullParameter(r10, "buttonText");
        Intrinsics.checkNotNullParameter(r13, "raw");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
    }
}
