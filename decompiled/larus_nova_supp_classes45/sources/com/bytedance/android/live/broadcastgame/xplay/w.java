package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ u a;

    public w(u r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        InteractGameContext r0 = InteractGameContext.Companion.getContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.h0.c> r1 = r0.getOpenGameLaunchResult();
        if (r1 == null) goto L7;
        r1.setValue(new com.bytedance.android.live.broadcastgame.api.model.h0.a(null));
    L7:
        ExceptionUtils.handleException(this.a.b.getContext(), r5, "该场景暂不支持此玩法");
    }
}
