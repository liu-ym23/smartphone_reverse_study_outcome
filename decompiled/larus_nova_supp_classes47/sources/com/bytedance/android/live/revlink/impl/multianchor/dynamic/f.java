package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> {
    public final T a;

    public final String toString() {
        T r0 = this.a;
        if (Intrinsics.areEqual(r0, Boolean.valueOf(r0 instanceof vh7.c)) == false) goto L6;
        return e.e((vh7.c) this.a);
    L6:
        return String.valueOf(this.a);
    }

    public f(T r1) {
        this.a = r1;
    }
}
