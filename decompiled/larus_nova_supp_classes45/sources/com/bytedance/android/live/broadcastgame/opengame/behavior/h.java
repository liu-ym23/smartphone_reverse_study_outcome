package com.bytedance.android.live.broadcastgame.opengame.behavior;

import android.os.SystemClock;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.broadcastgame.opengame.message.f0;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.message.model.e0;
import com.bytedance.android.livesdk.message.model.hn;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<T, R> implements Function {
    public final /* synthetic */ g.e a;
    public final /* synthetic */ long b;

    public h(g.e r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r19) {
        com.bytedance.android.live.network.response.e r1 = (com.bytedance.android.live.network.response.e) r19;
        Intrinsics.checkNotNullParameter(r1, "resp");
        e0 r2 = ((com.bytedance.android.live.broadcastgame.opengame.network.j) ((ExtraResponse) r1).data).entranceInfo;
        if (r2 == null) goto L5;
        f0 r3 = com.bytedance.android.live.broadcastgame.opengame.message.l.a(r2, this.a.b ? 1 : 0);
    L6:
        e0 r4 = ((com.bytedance.android.live.broadcastgame.opengame.network.j) ((ExtraResponse) r1).data).entranceInfo;
        if (r4 == null) goto L11;
        int r5 = r4.visibleType;
        int r6 = hn.a;
        boolean r7 = true;
        if (r5 != 1) goto L11;
    L12:
        OpenPlatformMonitorUtils r8 = OpenPlatformMonitorUtils.c;
        g r9 = this.a.a;
        int r11 = g.m;
        OpenPlatformMonitorUtils.f(r9.u(r3), this.a.a.v(), 0, !r7, true, SystemClock.elapsedRealtime() - this.b, null, null, ((ExtraResponse) r1).logId, 192);
        if (r7 == true) goto L15;
        return null;
    L15:
        return r3;
    L11:
        r7 = false;
        goto L12
    L5:
        r3 = null;
        goto L6
    }
}
