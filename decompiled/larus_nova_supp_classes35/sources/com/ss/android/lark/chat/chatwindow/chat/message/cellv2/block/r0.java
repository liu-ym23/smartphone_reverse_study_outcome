package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.ss.android.lark.chat.core.view.TextChatView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class r0 implements TextChatView.a {
    public final /* synthetic */ TextContentBlock a;
    public final /* synthetic */ y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> b;

    public r0(TextContentBlock r1, y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.ss.android.lark.chat.core.view.TextChatView.a
    public final void onClick() {
        b3b.f r0 = this.a.f();
        if (r0 == null) goto L6;
        r0.b(this.b.getId());
        return;
    }
}
