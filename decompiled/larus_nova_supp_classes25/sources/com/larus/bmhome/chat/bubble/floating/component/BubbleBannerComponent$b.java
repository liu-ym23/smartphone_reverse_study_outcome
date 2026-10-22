package com.larus.bmhome.chat.bubble.floating.component;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class BubbleBannerComponent$b {
    public final View a;
    public final View b;
    public final boolean c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BubbleBannerComponent$b) == true) goto L8;
        return false;
    L8:
        BubbleBannerComponent$b r6 = (BubbleBannerComponent$b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        View r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        View r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (r3 + r1) * 31;
        if (this.c == false) goto L13;
        int r6 = 1231;
    L15:
        return r5 + r6;
    L13:
        r6 = 1237;
        goto L15
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "FloatingAnchors(bottomAnchor=" + this.a + ", widthAnchor=" + this.b + ", hostAvailable=" + this.c + ')';
    }

    public final boolean a() {
        if (this.a != null) goto L5;
    L9:
        return false;
    L5:
        if (this.b == null) goto L9;
        if (this.c == false) goto L9;
        return true;
    }

    public BubbleBannerComponent$b(View r1, View r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
