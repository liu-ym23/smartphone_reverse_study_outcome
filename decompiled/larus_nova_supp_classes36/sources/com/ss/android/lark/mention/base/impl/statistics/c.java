package com.ss.android.lark.mention.base.impl.statistics;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import z5c.l0;
import z5c.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

    public c(String r1, String r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        String r0 = this.a;
        String r1 = this.b;
        boolean r2 = this.c;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        s5c.a r4 = l0.c.a(r0);     // Catch: Throwable -> L5
        s5c.a r5 = m0.f.a("ai_qa");     // Catch: Throwable -> L5
        s5c.d.o2.getClass();     // Catch: Throwable -> L5
        s5c.a r6 = new s5c.a("conf", r1);     // Catch: Throwable -> L5
        s5c.a r7 = new s5c.a("qa_is_top", String.valueOf(r2));     // Catch: Throwable -> L5
        Statistics.sendEvent("im_mention_board_item_view", s5c.d.b.b(r5, r4).plus(r6).plus(r7).toJson());     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
