package org.koin.core.definition;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1 f21009a;

    public b() {
        this.f21009a = null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f21009a, ((b) r5).f21009a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Function1 r5 = this.f21009a;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.hashCode();
    }

    public final String toString() {
        return "Callbacks(onClose=" + this.f21009a + ')';
    }
}
