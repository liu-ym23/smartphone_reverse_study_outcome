package com.ss.android.lark.chat.plugin;

import com.ss.android.lark.chat.chatwindow.biz.plugin.core.c;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.configurator.AutoScrollBottomHandler;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends c {

    /* JADX INFO: renamed from: com.ss.android.lark.chat.plugin.a$a, reason: collision with other inner class name */
    public static final class C0105a {
    }

    static {
    }

    public a() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatApp");
        Intrinsics.checkNotNullParameter(r3, "initData");
        super.C(r2, r3);
        int r4 = com.ss.android.lark.chat.chatwindow.chat.v2.component.c.E1;
        IMessageListComponent r5 = (IMessageListComponent) r2.a(IMessageListComponent.class);
        if (r5 != null) goto L7;
        Log.w("AutoScrollBottomPlugin", "messageList == null");
        return;
    L7:
        if (r5.Qv() == true) goto L10;
        Log.i("AutoScrollBottomPlugin", "New scroll disabled");
        return;
    L10:
        Log.i("AutoScrollBottomPlugin", "New auto scroll bottom");
        r5.hg(new AutoScrollBottomHandler(r5));
    }
}
