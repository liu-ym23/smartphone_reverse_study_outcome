package com.larus.bmhome.chat.list.cell.spacer;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SpacerCell$a {
    public final String a;
    public final ValueAnimator b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SpacerCell$a) == true) goto L8;
        return false;
    L8:
        SpacerCell$a r6 = (SpacerCell$a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "AnimationTag(key=" + this.a + ", animator=" + this.b + ')';
    }

    public SpacerCell$a(String r2, ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "animator");
        this.a = r2;
        this.b = r3;
    }
}
