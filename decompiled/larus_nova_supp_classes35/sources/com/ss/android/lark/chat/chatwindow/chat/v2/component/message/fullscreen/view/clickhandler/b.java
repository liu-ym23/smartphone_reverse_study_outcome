package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.dto.chat.ProfileSource;
import kotlin.jvm.internal.Intrinsics;
import w4b.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements mcc.b {
    public final c a;

    public final boolean c(View r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r4, "userId");
        return false;
    }

    public b(c r2) {
        Intrinsics.checkNotNullParameter(r2, "clickContext");
        this.a = r2;
    }

    public final void d(View r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r4, "userId");
        b0 r5 = ChatCoreModule.a().getProfileDependency();
        Context r6 = this.a.getContext();
        ProfileSource.a r0 = new ProfileSource.a();
        r0.e = r4;
        r0.d = this.a.c.getId();
        r0.b = 1;
        r0.c = com.ss.android.lark.chat.utils.k.a(this.a.c);
        r5.e(r6, r0.a());
    }
}
