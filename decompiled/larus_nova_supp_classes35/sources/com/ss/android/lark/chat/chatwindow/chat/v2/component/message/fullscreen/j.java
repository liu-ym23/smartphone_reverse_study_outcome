package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen;

import androidx.lifecycle.Observer;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.ChatResolveOrRemovePlugin;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.MessageClearEventPlugin;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.MessageFullScreenPluginAdapter$observer$2;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.RecallThreadPlugin;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.RestrictScreenPlugin;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ MessageFullScreenFragment a;

    public j(MessageFullScreenFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        if (Intrinsics.areEqual((Boolean) r6, Boolean.TRUE) == false) goto L14;
        MessageFullScreenFragment r7 = this.a;
        int r0 = MessageFullScreenFragment.t;
        r7.T90().setup();
        MessageFullScreenFragment r8 = this.a;
        r8.getClass();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.b r1 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.b(r8, r8.T90());
        r1.a(new RestrictScreenPlugin());
        v r2 = r8.f;
        v r3 = null;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("chatContainer");
        r2 = null;
    L8:
        r1.a(new MessageClearEventPlugin(r2));
        v r4 = r8.f;
        if (r4 == null) goto L11;
        r3 = r4;
    L12:
        r1.a(new ChatResolveOrRemovePlugin(r3));
        r1.a(new RecallThreadPlugin());
        r1.a.getLifecycle().addObserver((MessageFullScreenPluginAdapter$observer$2.AnonymousClass1) r1.d.getValue());
        r8.q = r1;
        return;
    L11:
        Intrinsics.throwUninitializedPropertyAccessException("chatContainer");
        goto L12
    }
}
