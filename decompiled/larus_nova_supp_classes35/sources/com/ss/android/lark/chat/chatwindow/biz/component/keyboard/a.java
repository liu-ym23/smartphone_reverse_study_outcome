package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import android.content.Context;
import com.ss.android.lark.chat.chatwindow.biz.component.messengesender.IMessageSenderComponent;
import com.ss.android.lark.framework.larkwidget.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a {
    public final /* synthetic */ BaseKeyboardComponentV2<mob.a> a;

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a
    public Context getContext() {
        BaseKeyboardComponentV2<mob.a> r0 = this.a;
        int r1 = BaseKeyboardComponentV2.v;
        com.ss.android.lark.framework.larkwidget.b r2 = ((Widget) r0).a;
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getContext();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a
    public final q4b.a getMessageSender() {
        BaseKeyboardComponentV2<mob.a> r0 = this.a;
        r0.getClass();
        IMessageSenderComponent r1 = (IMessageSenderComponent) r0.a(IMessageSenderComponent.class);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getMessageSender();
    }

    public a(BaseKeyboardComponentV2 r1) {
        this.a = r1;
    }
}
