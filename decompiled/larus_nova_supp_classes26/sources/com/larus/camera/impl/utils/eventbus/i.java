package com.larus.camera.impl.utils.eventbus;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i implements g {
    public final op8.i.a a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof i) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((i) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "InputStopped(inputType=" + this.a + ')';
    }

    public i(op8.i.a r2) {
        Intrinsics.checkNotNullParameter(r2, "inputType");
        this.a = r2;
    }
}
