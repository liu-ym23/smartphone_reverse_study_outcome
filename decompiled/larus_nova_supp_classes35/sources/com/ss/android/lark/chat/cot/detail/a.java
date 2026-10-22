package com.ss.android.lark.chat.cot.detail;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements b {
    public final com.ss.android.lark.chat.cot.c a;

    public a() {
        this(null);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        com.ss.android.lark.chat.cot.c r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "CotActionDetailExtra(iconSpec=" + this.a + ')';
    }

    public a(com.ss.android.lark.chat.cot.c r1) {
        this.a = r1;
    }
}
