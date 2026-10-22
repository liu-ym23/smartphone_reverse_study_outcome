package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public final Object a;

    public final int hashCode() {
        return System.identityHashCode(this.a);
    }

    public b(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.a = r2;
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof b) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.a != ((b) r2).a) goto L7;
        return true;
    }
}
