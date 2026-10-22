package com.ss.android.lark.keyboard.biz.emoji;

import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.keyboard.keyboard2.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements com.ss.android.lark.biz.im.api.extension.chat_window.d<m> {
    public final boolean a;
    public final boolean b;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b c;
    public final FragmentManager d;
    public IMFaceKBPlugin e;

    public final String getName() {
        return "face";
    }

    public final void isEnable() {
    }

    public final Object getPlugin() {
        if (this.e != null) goto L9;
        FragmentManager r0 = this.d;
        if (r0 != null) goto L7;
        r0 = this.c.a.getChildFragmentManager();
    L7:
        this.e = new IMFaceKBPlugin(this.a, this.b, r0, new b(this));
    L9:
        return this.e;
    }

    public c(boolean r2, com.ss.android.lark.biz.im.api.extension.chat_window.b r3, FragmentManager r4) {
        Intrinsics.checkNotNullParameter(r3, "pluginContext");
        this.a = r2;
        this.b = false;
        this.c = r3;
        this.d = r4;
    }
}
