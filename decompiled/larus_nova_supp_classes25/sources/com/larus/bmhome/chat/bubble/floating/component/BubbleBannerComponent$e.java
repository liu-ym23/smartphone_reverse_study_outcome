package com.larus.bmhome.chat.bubble.floating.component;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class BubbleBannerComponent$e {
    public final ViewGroup a;
    public final ViewGroup b;
    public final BubbleBannerComponent$b c;
    public final View d;
    public final View e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BubbleBannerComponent$e) == true) goto L8;
        return false;
    L8:
        BubbleBannerComponent$e r6 = (BubbleBannerComponent$e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "RenderTarget(root=" + this.a + ", anchorRoot=" + this.b + ", anchors=" + this.c + ", wrapper=" + this.d + ", content=" + this.e + ')';
    }

    public BubbleBannerComponent$e(ViewGroup r2, ViewGroup r3, BubbleBannerComponent$b r4, View r5, View r6) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "anchorRoot");
        Intrinsics.checkNotNullParameter(r4, "anchors");
        Intrinsics.checkNotNullParameter(r5, "wrapper");
        Intrinsics.checkNotNullParameter(r6, "content");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
