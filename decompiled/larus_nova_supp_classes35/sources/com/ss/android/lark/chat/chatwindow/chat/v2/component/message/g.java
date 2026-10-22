package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.messengesender.IMessageSenderComponent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements IMessageListComponent.e {
    public final /* synthetic */ IMessageSenderComponent a;
    public final /* synthetic */ d.a b;

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.e
    public final d.b a() {
        IKeyboardComponent r0 = (IKeyboardComponent) this.b.a(IKeyboardComponent.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return new d.b(r0);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.e
    public final e b() {
        return new e(this.b);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.e
    public final f c() {
        return new f(this.b);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.e
    public final q4b.a getMessageSender() {
        IMessageSenderComponent r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMessageSender();
    }

    public g(IMessageSenderComponent r1, d.C0062d r2) {
        this.a = r1;
        this.b = r2;
    }
}
