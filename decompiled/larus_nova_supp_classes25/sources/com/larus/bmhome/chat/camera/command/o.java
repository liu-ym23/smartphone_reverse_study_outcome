package com.larus.bmhome.chat.camera.command;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o {
    public final Function0<Boolean> a;
    public final Function1<Boolean, iq9.e> b;

    public o() {
        this(null, 3);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L8;
        return false;
    L8:
        o r6 = (o) r5;
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
        return "CameraSuggestedActionOptions(canEnterAIBeautifyPage=" + this.a + ", draftOperationsProvider=" + this.b + ')';
    }

    public /* synthetic */ o(g r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = new zb8.c();
    L6:
        if ((r3 & 2) == 0) goto L8;
        n r4 = n.a;
    L9:
        this(r2, r4);
        return;
    L8:
        r4 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(Function0<Boolean> r2, Function1<? super Boolean, iq9.e> r3) {
        Intrinsics.checkNotNullParameter(r2, "canEnterAIBeautifyPage");
        Intrinsics.checkNotNullParameter(r3, "draftOperationsProvider");
        this.a = r2;
        this.b = r3;
    }
}
