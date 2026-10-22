package com.larus.camera.impl.utils.eventbus;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h implements g {
    public final op8.i.a a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof h) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((h) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "InputStarted(inputType=" + this.a + ')';
    }

    public h(op8.i.a r2) {
        Intrinsics.checkNotNullParameter(r2, "inputType");
        this.a = r2;
    }
}
