package com.ss.android.lark.reaction.service.impl;

import com.bytedance.lark.pb.im.v1.PushEmojiPanel;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.t;
import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ ReactionOrderService2 a;

    public b(ReactionOrderService2 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        s r5 = (s) r4;
        Intrinsics.checkNotNull(r5);
        PushEmojiPanel r6 = (PushEmojiPanel) t.c(r5, ReactionOrderService2$registerPush$1$1.INSTANCE);
        if (r6 == null) goto L13;
        ReactionOrderService2 r0 = this.a;
        Log.i("ReactionOrderService2", "onPushEmojiPanel");
        if (r6.emoji_panel == null) goto L16;
        monitor-enter(r0);
        r0.i = a.a(r6.emoji_panel);     // Catch: Throwable -> L10
        r0.m = ReactionOrderService2.FetchEmojiPanelState.SUCCESS;     // Catch: Throwable -> L10
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        r0.c.k0(Integer.MIN_VALUE, null);
        ReactionOrderService2.n(r0, r0.i);
        return;
    L10:
        th = move-exception;
        throw th;
    L16:
        return;
    }
}
