package com.ss.android.lark.keyboard.biz.mention.inject;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements com.ss.android.lark.biz.im.api.extension.chat_window.d<e> {
    public final v a;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b b;

    public final String getName() {
        return "at_group_member_top_view";
    }

    public final void isEnable() {
    }

    public final Object getPlugin() {
        e r0 = new e(this.b);
        r0.b = this.b.c.isGroup();
        return r0;
    }

    public g(v r2, com.ss.android.lark.biz.im.api.extension.chat_window.b r3) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        Intrinsics.checkNotNullParameter(r3, "pluginContext");
        this.a = r2;
        this.b = r3;
    }
}
