package com.larus.bmhome.chat.bubble.floating.component;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class BubbleBannerComponent$c {
    public final ViewGroup a;
    public final ViewGroup b;
    public final BubbleBannerComponent$b c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BubbleBannerComponent$c) == true) goto L8;
        return false;
    L8:
        BubbleBannerComponent$c r6 = (BubbleBannerComponent$c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "FloatingHost(root=" + this.a + ", anchorRoot=" + this.b + ", anchors=" + this.c + ')';
    }

    public BubbleBannerComponent$c(ViewGroup r2, ViewGroup r3, BubbleBannerComponent$b r4) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "anchorRoot");
        Intrinsics.checkNotNullParameter(r4, "anchors");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
