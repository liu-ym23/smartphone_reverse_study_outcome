package com.bytedance.android.live.broadcastgame;

import android.os.SystemClock;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ AudienceMagicBoxBehavior a;
    public final /* synthetic */ long b;
    public final /* synthetic */ com.bytedance.android.live.broadcastgame.opengame.message.f0 c;
    public final /* synthetic */ Function0 d;
    public final /* synthetic */ Function0 e;

    public l(AudienceMagicBoxBehavior r1, long r2, com.bytedance.android.live.broadcastgame.opengame.message.f0 r4, Function0 r5, Function0 r6) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public final void accept(Object r19) {
        com.bytedance.android.live.network.response.e r1 = (com.bytedance.android.live.network.response.e) r19;
        int r2 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehavior", new Object[]{"check entrance visible success, disableEntrance: " + ((com.bytedance.android.live.broadcastgame.opengame.network.i) ((ExtraResponse) r1).data).a() + ", startType: " + ((com.bytedance.android.live.broadcastgame.opengame.network.i) ((ExtraResponse) r1).data).c()});
        long r12 = SystemClock.elapsedRealtime() - this.b;
        if (((com.bytedance.android.live.broadcastgame.opengame.network.i) ((ExtraResponse) r1).data).a() == true) goto L5;
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r3 = this.c;
        int r4 = com.bytedance.android.live.broadcastgame.opengame.network.i.a;
        r3.y = Boolean.valueOf(true ^ "lynx".equals(((com.bytedance.android.live.broadcastgame.opengame.network.i) ((ExtraResponse) r1).data).c()));
        this.c.B = ((com.bytedance.android.live.broadcastgame.opengame.network.i) ((ExtraResponse) r1).data).b();
        OpenPlatformMonitorUtils r5 = OpenPlatformMonitorUtils.c;
        OpenPlatformMonitorUtils.f(this.a.c(this.c), this.a.d(), 0, false, false, r12, null, null, ((ExtraResponse) r1).logId, 208);
        this.d.invoke();
        return;
    L5:
        OpenPlatformMonitorUtils r6 = OpenPlatformMonitorUtils.c;
        OpenPlatformMonitorUtils.f(this.a.c(this.c), this.a.d(), 1, true, false, r12, null, "入口可见性请求成功，不展示入口", ((ExtraResponse) r1).logId, 80);
        this.e.invoke();
    }
}
