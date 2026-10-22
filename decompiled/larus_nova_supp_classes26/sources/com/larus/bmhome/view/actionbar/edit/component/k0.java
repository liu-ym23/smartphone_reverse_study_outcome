package com.larus.bmhome.view.actionbar.edit.component;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k0 {
    public final List<l0> a;
    public final com.larus.bmhome.actionbar.model.z1 b;
    public final uz8.b c;
    public final List<uz8.b.C0138b> d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r6 = (k0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        com.larus.bmhome.actionbar.model.z1 r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "CollaboratedParamSubscribeRequest(selections=" + this.a + ", subscribeConfig=" + this.b + ", trackingExtra=" + this.c + ", featureDetails=" + this.d + ')';
    }

    public final String a() {
        com.larus.bmhome.actionbar.model.z1 r0 = this.b;
        if (r0 == null) goto L10;
        String r1 = r0.a;
        if (r1 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r1)) == true) goto L9;
        return null;
    L9:
        return r1;
    L10:
        return null;
    }

    public k0(List<l0> r2, com.larus.bmhome.actionbar.model.z1 r3, uz8.b r4, List<uz8.b.C0138b> r5) {
        Intrinsics.checkNotNullParameter(r2, "selections");
        Intrinsics.checkNotNullParameter(r4, "trackingExtra");
        Intrinsics.checkNotNullParameter(r5, "featureDetails");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
