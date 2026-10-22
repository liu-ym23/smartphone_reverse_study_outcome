package com.bytedance.android.live.broadcastgame.opengame.behavior;

import android.os.SystemClock;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ g.e a;
    public final /* synthetic */ long b;

    public i(g.e r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r14) {
        OpenPlatformMonitorUtils r0 = OpenPlatformMonitorUtils.c;
        g r1 = this.a.a;
        OpenPlatformMonitorUtils.f(r1.u(r1.g), this.a.a.v(), 1, true, true, SystemClock.elapsedRealtime() - this.b, Integer.valueOf(com.bytedance.android.live.broadcastgame.api.openplatform.h.a((Throwable) r14)), "入口可见性请求失败，不展示入口", null, 256);
    }
}
