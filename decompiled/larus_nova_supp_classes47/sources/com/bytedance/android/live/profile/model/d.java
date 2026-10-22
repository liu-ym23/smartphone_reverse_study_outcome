package com.bytedance.android.live.profile.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public final int a;
    public final int b;
    public final int c;

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        return "visitType-" + this.a + ",targetType-" + this.b + ",specialType-" + this.c;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if ((!Intrinsics.areEqual(d.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r5 == null) goto L24;
        d r6 = (d) r5;
        if (this.a == r6.a) goto L17;
        return false;
    L17:
        if (this.b == r6.b) goto L20;
        return false;
    L20:
        if (this.c == r6.c) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profile.model.NewUserPageType");
    L8:
        r2 = null;
        goto L10
    }

    public d(int r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
