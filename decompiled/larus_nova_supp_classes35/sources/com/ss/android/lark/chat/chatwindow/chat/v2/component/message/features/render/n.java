package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import androidx.lifecycle.Observer;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.chat.entity.chat.Chat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n<T> implements Observer {
    public final /* synthetic */ MessageListRendererFeature a;

    public n(MessageListRendererFeature r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Chat r5 = (Chat) r4;
        MessageListRendererFeature r6 = this.a;
        r6.getClass();
        UICallbackExecutor.executeDelayed(new b(r6), 100);
    }
}
