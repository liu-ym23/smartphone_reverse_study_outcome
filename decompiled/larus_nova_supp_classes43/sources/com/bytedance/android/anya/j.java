package com.bytedance.android.anya;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j<T> {
    public final T a;
    public final T b;
    public final boolean c;

    public final T a() {
        if (Intrinsics.areEqual(this.b, g0.a) == false) goto L6;
        return null;
    L6:
        return this.b;
    }

    public final T b() {
        if (Intrinsics.areEqual(this.a, g0.a) == false) goto L6;
        return null;
    L6:
        return this.a;
    }

    public j(T r1, T r10, boolean r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
