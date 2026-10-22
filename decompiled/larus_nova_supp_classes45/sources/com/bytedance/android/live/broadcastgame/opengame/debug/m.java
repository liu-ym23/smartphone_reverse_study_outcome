package com.bytedance.android.live.broadcastgame.opengame.debug;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ OpenPlatformMiniAppDebugger a;

    public m(OpenPlatformMiniAppDebugger r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        OpenPlatformMiniAppDebugger r5 = this.a;
        if (r5.c == true) goto L6;
        r5.g(r5.getContextWeakRef().get());
        this.a.f(false, new Throwable("OpenPlatformMiniAppDebugger 初始化失败。原因：未收到校验消息通知"));
        return;
    }
}
