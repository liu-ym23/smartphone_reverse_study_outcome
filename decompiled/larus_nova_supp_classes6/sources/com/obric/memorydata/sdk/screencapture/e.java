package com.obric.memorydata.sdk.screencapture;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e {
    public final ScreenEventReaction a;
    public final long b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        this.a.hashCode();
        throw null;
    }

    public final String toString() {
        return "PendingOperation(screenEventReaction=" + this.a + ", timeout=" + this.b + ", callback=null)";
    }

    public e(ScreenEventReaction r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "screenEventReaction");
        Intrinsics.checkNotNullParameter(null, "callback");
        this.a = r3;
        this.b = r4;
    }
}
