package xnb;

import android.content.Context;
import com.ss.android.lark.keyboard.keyboard2.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements com.ss.android.lark.biz.im.api.extension.chat_window.d<m> {
    public final boolean a;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b b;
    public d c;

    public final String getName() {
        return "photo";
    }

    public final void isEnable() {
    }

    public final Object getPlugin() {
        if (this.c != null) goto L9;
        Context r0 = this.b.a.requireContext();
        boolean r1 = this.b.c.isSecret();
        d r2 = new d(this.a, new b(r0, this, r1));
        if (this.b.b == null) goto L7;
        com.ss.android.lark.keyboard.plugin.tool.photo.c r3 = new com.ss.android.lark.keyboard.plugin.tool.photo.c(r2);
        Intrinsics.checkNotNullParameter(r3, "listener");
        r2.v = r3;
    L7:
        this.c = r2;
    L9:
        return this.c;
    }

    public c(com.ss.android.lark.biz.im.api.extension.chat_window.b r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        this.a = false;
        this.b = r2;
    }
}
