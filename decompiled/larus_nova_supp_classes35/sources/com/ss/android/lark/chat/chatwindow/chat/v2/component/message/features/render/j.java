package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.MessageVisibleEntity;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.MessageVisibleManager;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.MessageVisibleHintPointParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements MessageVisibleManager.b {
    public final /* synthetic */ MessageListRendererFeature a;

    public j(MessageListRendererFeature r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.MessageVisibleManager.b
    public final void a(MessageVisibleEntity r3) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = this.a.H();
        if (r0 == null) goto L6;
        r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.k(r3));
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.MessageVisibleManager.b
    public final void b(y6b.c<?> r3, MessageVisibleHintPointParams r4) {
        Intrinsics.checkNotNullParameter(r3, "message");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r0 = this.a.H();
        if (r0 == null) goto L6;
        r0.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.e(r3, r4));
        return;
    }
}
