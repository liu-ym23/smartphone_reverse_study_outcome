package com.bytedance.android.live.broadcastgame;

import android.os.SystemClock;
import com.bytedance.android.live.broadcastgame.opengame.network.AudienceGameNetApi;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.message.model.hn;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T, R> implements Function {
    public final /* synthetic */ a a;
    public final /* synthetic */ boolean b;

    public e(a r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r6) {
        com.bytedance.android.livesdk.message.model.e0 r7 = (com.bytedance.android.livesdk.message.model.e0) r6;
        Intrinsics.checkNotNullParameter(r7, "it");
        int r0 = r7.visibleType;
        int r1 = hn.a;
        if (r0 != 1) goto L8;
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r2 = com.bytedance.android.live.broadcastgame.opengame.message.l.a(r7, this.b ? 1 : 0);
        if (r2 == null) goto L10;
        com.bytedance.revenue.platform.api.core.rx.l r8 = com.bytedance.revenue.platform.api.core.rx.l.a;
        return Observable.just(r2);
    L10:
        int r3 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehaviorV2", new Object[]{"request entrance visible v2, entranceExtra: " + r7.entranceExtra + ", extra: " + r7.extra});
        long r4 = SystemClock.elapsedRealtime();
        AudienceGameNetApi r5 = (AudienceGameNetApi) com.bytedance.android.live.network.c.b().e(AudienceGameNetApi.class);
        Room r9 = this.a.a;
        if (r9 == null) goto L13;
        long r11 = r9.getRoomId();
    L14:
        String r12 = r7.appId;
        if (r12 != null) goto L18;
        r12 = "";
    L18:
        return r5.getEntranceVisibleV2(r11, r12).compose(RxUtil.rxSchedulerHelper()).map(new c(this, r4)).doOnError(new d(this, r4));
    L13:
        r11 = 0;
        goto L14
    L8:
        if (r0 != 3) goto L10;
        com.bytedance.revenue.platform.api.core.rx.l r13 = com.bytedance.revenue.platform.api.core.rx.l.a;
        return Observable.error(new Exception("name: " + r7.name + ", visible type: " + r7.visibleType));
    }
}
