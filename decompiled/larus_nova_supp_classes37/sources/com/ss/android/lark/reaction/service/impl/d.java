package com.ss.android.lark.reaction.service.impl;

import com.bytedance.lark.pb.im.v1.PushUserMRUReactions;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.t;
import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ ReactionOrderService2 a;

    public d(ReactionOrderService2 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        s r5 = (s) r4;
        Intrinsics.checkNotNull(r5);
        PushUserMRUReactions r6 = (PushUserMRUReactions) t.c(r5, ReactionOrderService2$registerPush$3$1.INSTANCE);
        if (r6 == null) goto L8;
        ReactionOrderService2 r0 = this.a;
        Log.i("ReactionOrderService2", "onPushMRUReaction: " + r6.user_mru_reactions);
        List r7 = r6.user_mru_reactions;
        if (r7 == null) goto L9;
        ReactionOrderService2.p(r0, r7);
        return;
    L9:
        return;
    }
}
