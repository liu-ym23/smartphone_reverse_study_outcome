package com.bytedance.android.live.broadcastgame.xplay.servermergecast;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.xplay.q;
import com.bytedance.android.live.broadcastgame.xplay.q1;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ XplayRTCManager a;

    public f(XplayRTCManager r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        Long r11 = (Long) r9;
        IInteractGameService r12 = (IInteractGameService) k.n(IInteractGameService.class);
        XplayRTCManager r0 = this.a;
        Pair<Integer, Integer> r1 = r0.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("xplayCanvasSize");
    L5:
        JSONObject r2 = new JSONObject();
        if (q1.c(r0.n.h.b) == false) goto L13;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        r2.put("game_ratio", ((double) ((Number) r1.getFirst()).intValue()) / ((Number) r1.getSecond()).doubleValue());     // Catch: Throwable -> L9
        r2.put("render_mode", "fill");     // Catch: Throwable -> L9
        Object r4 = Result.constructor-impl(r2);     // Catch: Throwable -> L9
    L11:
        Result.isFailure-impl(r4);
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L13:
        if (r0.e == false) goto L19;
        q r6 = r0.b;
        if (r6 == null) goto L17;
        String r7 = r6.b;
    L18:
        r2.put("wtn_push_stream", r7);
        goto L19
    L17:
        r7 = null;
    L19:
        r12.sendServerMergeCastStatusSEI(true, r2);
        if (this.a.e == false) goto L25;
        IInteractGameService r13 = (IInteractGameService) k.n(IInteractGameService.class);
        JSONObject r8 = new JSONObject();
        r8.put("ts", com.bytedance.android.livesdk.utils.ntp.e.a());
        r8.put("tt_ntp", 1);
        Unit r14 = Unit.INSTANCE;
        r13.sendGameSeiData("key_game_pod_merge_stream_sei", r8.toString());
        return;
    }
}
