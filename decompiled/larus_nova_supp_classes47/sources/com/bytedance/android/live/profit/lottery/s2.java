package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s2<T> implements Consumer {
    public final /* synthetic */ m2 a;

    public s2(m2 r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        m2 r0 = this.a;
        if (r0.c == null) goto L20;
        if (r7 != null) goto L6;
        return;
    L6:
        if ((r7 instanceof y2) == false) goto L22;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        HashMap r2 = new HashMap();     // Catch: Throwable -> L15
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L15
        r3.put("lottery_id", ((y2) r7).a);     // Catch: Throwable -> L15
        r3.put("lottery_type", ((y2) r7).b);     // Catch: Throwable -> L15
        r3.put("lucky_count", ((y2) r7).c);     // Catch: Throwable -> L15
        r3.put("prize_count", ((y2) r7).d);     // Catch: Throwable -> L15
        r3.put("candidate_total_count", ((y2) r7).e);     // Catch: Throwable -> L15
        r3.put("last_candidate_total_count_surge_timestamp", ((y2) r7).f);     // Catch: Throwable -> L15
        r3.put("start_time", ((y2) r7).g);     // Catch: Throwable -> L15
        r3.put("draw_time", ((y2) r7).h);     // Catch: Throwable -> L15
        r3.put("enabled_dilatation", ((y2) r7).i);     // Catch: Throwable -> L15
        r3.put("dilatation_config_detail", ((y2) r7).j);     // Catch: Throwable -> L15
        r3.put("dilatation_now", ((y2) r7).k);     // Catch: Throwable -> L15
        r3.put("prize_count_before_dilatation", ((y2) r7).l);     // Catch: Throwable -> L15
        r3.put("lucky_count_before_dilatation", ((y2) r7).m);     // Catch: Throwable -> L15
        r2.put("json_data", r3.toString());     // Catch: Throwable -> L15
        zy0.d r8 = r0.c;     // Catch: Throwable -> L15
        if (r8 == null) goto L12;
        xy0.a<?> r9 = r8.g();     // Catch: Throwable -> L15
        if (r9 == null) goto L12;
        r9.sendJsEvent("lotterySyncData", r2);     // Catch: Throwable -> L15
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Result.constructor-impl(r10);     // Catch: Throwable -> L15
        return;
    L12:
        r10 = null;
    L15:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L22:
        return;
    }
}
