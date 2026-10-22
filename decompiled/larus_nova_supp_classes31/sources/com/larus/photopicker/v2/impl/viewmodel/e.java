package com.larus.photopicker.v2.impl.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public final UnSelectableToastType a;
    public final int b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        return "UnSelectableToast(type=" + this.a + ", limit=" + this.b + ')';
    }

    public final UnSelectableToastType getType() {
        return this.a;
    }

    public e(UnSelectableToastType r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.a = r2;
        this.b = r3;
    }
}
