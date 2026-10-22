package com.bytedance.android.live.broadcastgame;

import android.os.SystemClock;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r<T, R> implements Function {
    public final /* synthetic */ AudienceMagicBoxBehavior a;
    public final /* synthetic */ long b;

    public r(AudienceMagicBoxBehavior r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r15) {
        com.bytedance.android.live.network.response.e r16 = (com.bytedance.android.live.network.response.e) r15;
        Intrinsics.checkNotNullParameter(r16, "resp");
        long r8 = SystemClock.elapsedRealtime() - this.b;
        List<com.bytedance.android.live.broadcastgame.api.model.response.a.C0053a> r0 = ((com.bytedance.android.live.broadcastgame.api.model.response.a) ((ExtraResponse) r16).data).a();
        Intrinsics.checkNotNull(r0);
        com.bytedance.android.live.broadcastgame.api.model.response.a.C0053a r1 = (com.bytedance.android.live.broadcastgame.api.model.response.a.C0053a) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L10;
        com.bytedance.android.livesdk.message.model.e0 r2 = r1.b();
        if (r2 == null) goto L7;
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r3 = com.bytedance.android.live.broadcastgame.opengame.message.l.a(r2, 1);
    L8:
        Pair r4 = TuplesKt.to(r3, Boolean.valueOf(r1.a()));
        if (r4 == null) goto L10;
    L11:
        OpenPlatformMonitorUtils r5 = OpenPlatformMonitorUtils.c;
        AudienceMagicBoxBehavior r6 = this.a;
        OpenPlatformMonitorUtils.i(r6.c(r6.c), this.a.d(), 0, ((Boolean) r4.getSecond()).booleanValue(), r8, null, null, ((ExtraResponse) r16).logId, 96);
        return r4;
    L7:
        r3 = null;
    L10:
        r4 = TuplesKt.to(null, Boolean.TRUE);
        goto L11
    }
}
