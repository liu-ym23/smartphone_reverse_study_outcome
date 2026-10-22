package com.obric.memorydata.sdk.screencapture;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class d {
    public final TaskOptions a;
    public final String b;
    public final Function1<ScreenData, Unit> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
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
        return "PendingCaptureOperation(taskOptions=" + this.a + ", targetPackage=" + this.b + ", callback=" + this.c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(TaskOptions r2, String r3, Function1<? super ScreenData, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "taskOptions");
        Intrinsics.checkNotNullParameter(r3, "targetPackage");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
