package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.os.Bundle;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.i0;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements com.ss.android.lark.coremd.base.parse.n.b<v7b.n> {
    public final /* synthetic */ i a;

    public c(i r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.b
    public final void a(final com.ss.android.lark.coremd.impl.parse.f r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Bundle r0 = i0.a((String) LarkLinkExtend.f.b(new MessageFullScreenClickPlugin$configureClick$1$2$previewId$1(r5)), this.a.a.d);
        boolean r1 = this.a.a.c.isGroup();
        ChatCoreModule.a().getBrowserDependency().b(this.a.a.getContext(), ((v7b.n) r5.d).j, r1 ? 1 : 0, r0);
    }
}
