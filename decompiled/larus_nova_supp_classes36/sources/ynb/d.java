package ynb;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements com.ss.android.lark.biz.im.api.extension.chat_window.d<a> {
    public final v a;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b b;

    public final String getName() {
        return "input_state_top_expand_view";
    }

    public final void isEnable() {
    }

    public final Object getPlugin() {
        return new a(this.b);
    }

    public d(v r2, com.ss.android.lark.biz.im.api.extension.chat_window.b r3) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        Intrinsics.checkNotNullParameter(r3, "pluginContext");
        this.a = r2;
        this.b = r3;
    }
}
