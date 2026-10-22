package com.bytedance.android.live.broadcastgame;

import android.os.SystemClock;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ AudienceMagicBoxBehavior a;
    public final /* synthetic */ long b;
    public final /* synthetic */ com.bytedance.android.live.broadcastgame.opengame.message.f0 c;
    public final /* synthetic */ Function0 d;

    public m(AudienceMagicBoxBehavior r1, long r2, com.bytedance.android.live.broadcastgame.opengame.message.f0 r4, Function0 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }

    public final void accept(Object r18) {
        Throwable r1 = (Throwable) r18;
        int r2 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.k("MagicBoxBehavior", new Object[]{"check entrance visible failed, " + r1});
        long r11 = SystemClock.elapsedRealtime() - this.b;
        OpenPlatformMonitorUtils r3 = OpenPlatformMonitorUtils.c;
        OpenPlatformMonitorUtils.f(this.a.c(this.c), this.a.d(), 1, false, false, r11, Integer.valueOf(com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r1)), "入口可见性请求失败，不展示入口", null, 272);
        this.d.invoke();
    }
}
