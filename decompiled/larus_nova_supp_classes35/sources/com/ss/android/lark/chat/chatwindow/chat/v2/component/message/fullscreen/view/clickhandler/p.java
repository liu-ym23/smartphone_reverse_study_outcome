package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.view.View;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p implements mcc.l {
    public final c a;

    public final void b(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "phoneNumber");
    }

    public final c getContext() {
        return this.a;
    }

    public p(c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final void a(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "phoneNumber");
        ChatCoreModule.a().getPhoneDependency().a(this.a.getContext(), r3);
    }
}
