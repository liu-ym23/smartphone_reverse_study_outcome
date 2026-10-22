package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.MessageFullScreenLaunchData;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s implements q {
    public final boolean a;
    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c b;
    public final MessageFullScreenLaunchData c;
    public final Function0<Integer> d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s) == true) goto L8;
        return false;
    L8:
        s r6 = (s) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c r2 = this.b;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (((r1 + r4) * 31) + this.c.hashCode()) * 31;
        Function0<Integer> r6 = this.d;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return r5 + r3;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ProcessConfigV2(isTranslate=" + this.a + ", clickContext=" + this.b + ", launchData=" + this.c + ", widthProvider=" + this.d + ')';
    }

    public s(boolean r2, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c r3, MessageFullScreenLaunchData r4, Function0<Integer> r5) {
        Intrinsics.checkNotNullParameter(r4, "launchData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
