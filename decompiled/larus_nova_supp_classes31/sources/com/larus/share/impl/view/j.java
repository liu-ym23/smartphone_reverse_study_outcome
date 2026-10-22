package com.larus.share.impl.view;

import androidx.fragment.app.FragmentActivity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j {
    public final FragmentActivity a;
    public final List<jr9.a> b;
    public final com.larus.bmhome.share.panel.b c;
    public final com.larus.bmhome.share.panel.e d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
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
        List<jr9.a> r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "LongImageShareContext(fragmentActivity=" + this.a + ", shareItems=" + this.b + ", shareContent=" + this.c + ", shareParams=" + this.d + ')';
    }

    public j(FragmentActivity r2, List<jr9.a> r3, com.larus.bmhome.share.panel.b r4, com.larus.bmhome.share.panel.e r5) {
        Intrinsics.checkNotNullParameter(r2, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r4, "shareContent");
        Intrinsics.checkNotNullParameter(r5, "shareParams");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
