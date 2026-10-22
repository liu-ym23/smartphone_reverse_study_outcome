package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0<T> implements Consumer {
    public final /* synthetic */ dv0.h a;
    public final /* synthetic */ ScoreboardEventTracker.f b;

    public d0(dv0.h r1, ScoreboardEventTracker.f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        dv0.h r9 = (dv0.h) r8;
        if (this.a.isFinished() == false) goto L9;
        ScoreboardEventTracker r10 = this.b.a;
        dv0.h r0 = this.a;
        r10.getClass();
        mz0.n r1 = new mz0.n();
        r10.a(r1);
        mz0.o r2 = new mz0.o(r1.a);
        r10.g(r2);
        r10.c(r2, r0);
        r2.a("game_app_id", r0.getMiniAppId());
        r10.d(r2, r0.getMiniAppId());
        ScoreboardEventTracker.h(r2, r0);
        if (r0.getActualFinishTime() <= 0) goto L7;
        r2.a(Constants.Keys.duration, String.valueOf(r0.getActualFinishTime() - r0.getStartTime()));
    L7:
        r2.a("tool_recording_id", String.valueOf(r0.getRoundId()));
        cy0.e.a.getClass();
        cy0.j r12 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r13);
        ((mz0.i) ((f80.a) r13)).w3("livesdk_live_game_record_tool_end", r1.a, r1.b);
        return;
    }
}
