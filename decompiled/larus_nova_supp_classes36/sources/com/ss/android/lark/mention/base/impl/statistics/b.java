package com.ss.android.lark.mention.base.impl.statistics;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.statistics.Statistics;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import z5c.l0;
import z5c.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ BaseAtBean a;
    public final /* synthetic */ String b;

    public b(BaseAtBean r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        BaseAtBean r1 = this.a;
        String r2 = this.b;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        Map<String, Boolean> r4 = frb.a.e;     // Catch: Throwable -> L13
        Pair r5 = frb.a.C0266a.a();     // Catch: Throwable -> L13
        boolean r6 = ((Boolean) r5.component1()).booleanValue();     // Catch: Throwable -> L13
        boolean r7 = ((Boolean) r5.component2()).booleanValue();     // Catch: Throwable -> L13
        if (r6 == false) goto L10;
        s5c.a r8 = l0.c.a(r1.getId());     // Catch: Throwable -> L13
        s5c.a r9 = m0.f.a("ai_qa");     // Catch: Throwable -> L13
        s5c.d.a r10 = s5c.d.o2;     // Catch: Throwable -> L13
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        r10.getClass();     // Catch: Throwable -> L13
        s5c.a r11 = new s5c.a("conf", r2);     // Catch: Throwable -> L13
        Statistics.sendEvent("im_mention_board_item_valid_view", s5c.d.b.b(r9, r8).plus(r11).plus(new s5c.a("qa_is_top", String.valueOf(r7))).toJson());     // Catch: Throwable -> L13
        Log.i("MessageHitPoint", "ai_knowledge is valid visible, isTop: " + r7);     // Catch: Throwable -> L13
    L11:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L10:
        Log.i("MessageHitPoint", "ai_knowledge is invisible or invalid");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
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
