package com.ss.android.lark.chat.chatwindow.biz.plugin;

import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends c {
    public boolean g;
    public boolean h;
    public Runnable i;
    public Runnable j;

    public final void F() {
        Runnable r0 = this.j;
        if (r0 == null) goto L5;
        UICallbackExecutor.removeCallbacks(r0);
        this.j = null;
    L5:
        Runnable r1 = this.i;
        if (r1 == null) goto L9;
        UICallbackExecutor.removeCallbacks(r1);
        this.i = null;
    L9:
        if (this.h == false) goto L12;
        this.h = false;
    L12:
        if (this.g == false) goto L15;
        this.g = false;
        return;
    }

    public b() {
        UIUtils.canShowSkeleton();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void D() {
        super.D();
        F();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatApp");
        Intrinsics.checkNotNullParameter(r3, "initData");
        super.C(r2, r3);
        F();
    }
}
