package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class r implements q {
    public final com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b a;
    public final Function0<Integer> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Function0<Integer> r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ProcessConfigV1(params=" + this.a + ", widthProvider=" + this.b + ')';
    }

    public r(com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r2, Function0<Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a = r2;
        this.b = r3;
    }
}
