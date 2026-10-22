package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class e {
    public final a a;
    public final String b;

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof e) == true) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(getClass(), r3.getClass()) == false) goto L11;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == false) goto L11;
        if (Intrinsics.areEqual(this.b, r4.b) == false) goto L11;
        return true;
    }

    public e(a r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "role");
        this.a = r2;
        this.b = r3;
    }
}
