package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.content.Context;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.y0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements com.ss.android.lark.movable.selection.h {
    public final /* synthetic */ com.ss.android.lark.movable.selection.a a;
    public final /* synthetic */ Chat b;

    public k(com.ss.android.lark.movable.selection.a r1, Chat r2) {
        this.a = r1;
        this.b = r2;
    }

    public final boolean a(String r2, String r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "markdownStr");
        Intrinsics.checkNotNullParameter(r4, "context");
        int r5 = y0.a;
        if (y0.a(this.b) == false) goto L6;
        return false;
    L6:
        y0.f(r4);
        return true;
    }

    public final void b(String r2, String r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "markdownStr");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.a.b(r2, r3, r4);
    }
}
