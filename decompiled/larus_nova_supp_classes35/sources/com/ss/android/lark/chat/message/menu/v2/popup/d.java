package com.ss.android.lark.chat.message.menu.v2.popup;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final /* synthetic */ int f = 0;
    public final yya.a a;
    public final com.ss.android.lark.chat.message.menu.d b;
    public final com.ss.android.lark.biz.im.api.message.params.m c;
    public com.ss.android.lark.chat.message.menu.v2.popup.a d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    public final com.ss.android.lark.chat.message.menu.v2.popup.a a() {
        com.ss.android.lark.chat.message.menu.v2.popup.a r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("menuControl");
        return null;
    }

    public d(yya.a r2, com.ss.android.lark.chat.message.menu.d r3, com.ss.android.lark.biz.im.api.message.params.m r4) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        Intrinsics.checkNotNullParameter(r3, "actions");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
