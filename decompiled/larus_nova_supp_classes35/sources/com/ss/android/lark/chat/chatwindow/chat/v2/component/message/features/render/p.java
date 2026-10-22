package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration.FirstMessagePaddingDecoration;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p implements FirstMessagePaddingDecoration.a {
    public final /* synthetic */ MessageListRendererFeature a;

    public p(MessageListRendererFeature r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration.FirstMessagePaddingDecoration.a
    public final boolean a() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = this.a.G();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.canLoadPre();
    }
}
