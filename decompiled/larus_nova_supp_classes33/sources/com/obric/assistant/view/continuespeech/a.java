package com.obric.assistant.view.continuespeech;

import android.animation.Animator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final Animator a;
    public final boolean b;
    public final RealtimeCallLifeState c;
    public final Function0<Unit> d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        RealtimeCallLifeState r3 = this.c;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        Function0<Unit> r7 = this.d;
        if (r7 == null) goto L15;
        r4 = r7.hashCode();
    L15:
        return r6 + r4;
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "AnimationRequest(animator=" + this.a + ", interruptible=" + this.b + ", targetState=" + this.c + ", onCompleted=" + this.d + ')';
    }

    public a(Animator r2, boolean r3, RealtimeCallLifeState r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "animator");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
