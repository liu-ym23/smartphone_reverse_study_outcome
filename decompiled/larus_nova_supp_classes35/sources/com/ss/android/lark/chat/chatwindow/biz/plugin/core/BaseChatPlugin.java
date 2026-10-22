package com.ss.android.lark.chat.chatwindow.biz.plugin.core;

import android.content.Context;
import android.os.Handler;
import com.larksuite.framework.callback.CallbackManager;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.chat.chatwindow.biz.plugin.watermark.WaterMarkPlugin;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class BaseChatPlugin implements d {
    public Context a;
    public CallbackManager b;
    public BaseFragment c;
    public v d;
    public volatile boolean e;
    public final Lazy f;

    public boolean A() {
        return this instanceof WaterMarkPlugin;
    }

    public void D() {
        this.e = true;
        ((Handler) this.f.getValue()).removeCallbacksAndMessages(null);
    }

    public void E() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.d
    public final void onPause() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.d
    public void onStart() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.d
    public final void resume() {
    }

    public abstract boolean y(i7b.a r1);

    public void z(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatApp");
        Intrinsics.checkNotNullParameter(r3, "initData");
    }

    public final BaseFragment B() {
        BaseFragment r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("hostFragment");
        return null;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.d
    public final void destroy() {
        CallbackManager r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("callBackManager");
        r0 = null;
    L6:
        r0.cancelCallbacks();
        D();
    }

    public final Context getContext() {
        Context r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    public BaseChatPlugin() {
        this.f = LazyKt.lazy(BaseChatPlugin$mainThreadHandler$2.INSTANCE);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.d
    public final void stop() {
        E();
    }

    public void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatApp");
        Intrinsics.checkNotNullParameter(r3, "initData");
        v r4 = (v) r2.get();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.d = r4;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.d
    public final void c(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatApp");
        Intrinsics.checkNotNullParameter(r3, "initData");
        int r0 = com.ss.android.lark.chat.chatwindow.biz.component.keyboard.b.a;
        Lazy r1 = ChatCoreModule.a;
        if (A() == false) goto L6;
        z(r2, r3);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.d
    public final void j(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r4, i7b.a r5) {
        Intrinsics.checkNotNullParameter(r4, "chatApp");
        Intrinsics.checkNotNullParameter(r5, "initData");
        Context r0 = r4.getContext();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.a = r0;
        v r1 = (v) r4.get();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.d = r1;
        CallbackManager r2 = new CallbackManager();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
        Object r3 = r4.getHost();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.base.fragment.BaseFragment");
        BaseFragment r6 = (BaseFragment) r3;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        this.c = r6;
        if (y(r5) == true) goto L5;
        return;
    L5:
        C(r4, r5);
        if (A() == false) goto L8;
        int r7 = com.ss.android.lark.chat.chatwindow.biz.component.keyboard.b.a;
        Lazy r8 = ChatCoreModule.a;
        return;
    L8:
        z(r4, r5);
    }
}
