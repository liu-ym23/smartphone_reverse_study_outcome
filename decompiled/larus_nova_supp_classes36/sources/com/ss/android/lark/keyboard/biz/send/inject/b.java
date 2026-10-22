package com.ss.android.lark.keyboard.biz.send.inject;

import com.ss.android.lark.biz.im.api.extension.chat_window.d;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements d<SendInnerEndPlugin> {
    public final v a;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b b;

    public final String getName() {
        return "send_inner_end_view";
    }

    public final void isEnable() {
    }

    public final Object getPlugin() {
        return new SendInnerEndPlugin(this.b);
    }

    public b(v r2, com.ss.android.lark.biz.im.api.extension.chat_window.b r3) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        Intrinsics.checkNotNullParameter(r3, "pluginContext");
        this.a = r2;
        this.b = r3;
    }
}
