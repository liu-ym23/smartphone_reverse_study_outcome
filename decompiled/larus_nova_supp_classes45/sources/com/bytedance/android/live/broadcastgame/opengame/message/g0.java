package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g0<T, R> implements Function {
    public static final g0 a = null;

    static {
        a = new g0();
    }

    public g0() {
    }

    public final Object apply(Object r6) {
        BaseResponse r7 = (BaseResponse) r6;
        Intrinsics.checkNotNullParameter(r7, "it");
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        int r2 = 1;
        com.bytedance.android.live.broadcastgame.opengame.q.f("OpenEntranceMessageSender", new Object[]{"on app/start response", ", logId: ", r7.logId, ", status: ", Integer.valueOf(r7.statusCode)});
        if (r7.statusCode == 0) goto L13;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r1 = AnchorGameContext.a.a();
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.m<Boolean> r3 = r1.isRequsetingAppStart();
        if (r3 == null) goto L10;
        r3.setValue(Boolean.FALSE);
    L10:
        if (Intrinsics.areEqual(r7.ttStable, GamePromoteDataContext.GAME_TYPE_MOBILE) == false) goto L25;
        r2 = 2;
    L25:
        return new com.bytedance.android.live.broadcastgame.j0(r2, String.valueOf(r7.statusCode));
    L13:
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r4 = AnchorGameContext.a.a();
        if (r4 == null) goto L18;
        com.bytedance.live.datacontext.m<String> r5 = r4.getOpenGameStartId();
        if (r5 == null) goto L18;
        r5.setValue(((com.bytedance.android.live.broadcastgame.opengame.network.v) r7.data).b());
    L18:
        AnchorGameContext r8 = AnchorGameContext.a.a();
        if (r8 == null) goto L24;
        com.bytedance.live.datacontext.m<Boolean> r9 = r8.isRequsetingAppStart();
        if (r9 == null) goto L24;
        r9.setValue(Boolean.FALSE);
    L24:
        return new com.bytedance.android.live.broadcastgame.j0();
    }
}
