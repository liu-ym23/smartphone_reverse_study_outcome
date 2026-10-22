package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.dto.chat.ProfileSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n0 implements mcc.b {
    public final /* synthetic */ TextContentBlock a;
    public final /* synthetic */ y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> b;

    public final boolean c(View r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r4, "userId");
        return false;
    }

    public n0(TextContentBlock r1, y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void d(View r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r4, "userId");
        w4b.b0 r5 = ChatCoreModule.a().getProfileDependency();
        Context r6 = this.a.getContext();
        ProfileSource.a r0 = new ProfileSource.a();
        r0.e = r4;
        r0.d = this.b.getChatId();
        r0.b = 1;
        r0.c = com.ss.android.lark.chat.utils.k.a(this.a.g().getChat());
        r5.e(r6, new ProfileSource(r0));
        int r7 = f3b.c.a;
        f3b.c.a(this.a.g(), this.b);
    }
}
