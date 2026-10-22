package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.content.Context;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.dto.chat.ProfileSource;
import kotlin.jvm.internal.Intrinsics;
import w4b.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements com.ss.android.lark.coremd.base.parse.n.b<eab.a> {
    public final /* synthetic */ i a;

    public b(i r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.b
    public final void a(com.ss.android.lark.coremd.impl.parse.f r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        b0 r0 = ChatCoreModule.a().getProfileDependency();
        Context r1 = this.a.a.getContext();
        ProfileSource.a r2 = new ProfileSource.a();
        r2.e = ((eab.a) r4.d).k;
        r2.d = this.a.a.c.getId();
        r2.b = 1;
        r2.c = com.ss.android.lark.chat.utils.k.a(this.a.a.c);
        r0.e(r1, new ProfileSource(r2));
    }
}
