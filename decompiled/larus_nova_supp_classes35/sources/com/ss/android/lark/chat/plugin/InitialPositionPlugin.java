package com.ss.android.lark.chat.plugin;

import com.ss.android.lark.chat.chatwindow.biz.plugin.core.c;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class InitialPositionPlugin extends c {

    public static final class a {
    }

    static {
    }

    public InitialPositionPlugin() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r9, final i7b.a r10) {
        Intrinsics.checkNotNullParameter(r9, "chatApp");
        Intrinsics.checkNotNullParameter(r10, "initData");
        super.C(r9, r10);
        int r0 = com.ss.android.lark.chat.chatwindow.chat.v2.component.c.E1;
        IMessageListComponent r1 = (IMessageListComponent) r9.a(IMessageListComponent.class);
        if (r1 != null) goto L6;
        Log.e("InitialPositionPlugin", "messageList == null");
        return;
    L6:
        r1.hg(new com.ss.android.lark.chat.configurator.a(r1, new InitialPositionPlugin$onCreate$listener$1(r10), r10.a, w.a(r9).C(), new InitialPositionPlugin$onCreate$listener$2(r10)));
    }
}
