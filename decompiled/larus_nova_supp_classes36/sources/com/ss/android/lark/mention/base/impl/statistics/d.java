package com.ss.android.lark.mention.base.impl.statistics;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.GroupMemAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.SearchBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.WantAtMemBean;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import z5c.e2;
import z5c.l0;
import z5c.m0;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ BaseAtBean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;

    public d(boolean r1, BaseAtBean r2, String r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        boolean r0 = this.a;
        BaseAtBean r1 = this.b;
        String r2 = this.c;
        boolean r3 = this.d;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L29
        if (r0 == false) goto L6;
        s5c.a r5 = e2.c;     // Catch: Throwable -> L29
    L7:
        int r6 = r1.getType();     // Catch: Throwable -> L29
        if (r6 != 0) goto L10;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.ss.android.lark.mention.base.impl.atselector.bean.GroupMemAtBean");     // Catch: Throwable -> L29
        int r7 = e.a;     // Catch: Throwable -> L29
        s5c.a r8 = e.a.a(((GroupMemAtBean) r1).getChatterInfo());     // Catch: Throwable -> L29
    L17:
        s5c.a r9 = l0.c.a(r1.getId());     // Catch: Throwable -> L29
        s5c.d.a r10 = s5c.d.o2;     // Catch: Throwable -> L29
        int r11 = e.a;     // Catch: Throwable -> L29
        if ((r1 instanceof SearchBean) == false) goto L20;
    L23:
        String r12 = com.ss.android.lark.mention.base.impl.atselector.bean.c.a(r1);     // Catch: Throwable -> L29
    L24:
        r10.getClass();     // Catch: Throwable -> L29
        s5c.a r13 = new s5c.a("first_letter", r12);     // Catch: Throwable -> L29
        if (r2 != null) goto L27;
        r2 = "";
    L27:
        s5c.a r14 = new s5c.a("conf", r2);     // Catch: Throwable -> L29
        s5c.a r15 = new s5c.a("qa_is_top", String.valueOf(r3));     // Catch: Throwable -> L29
        s5c.a r16 = r.O;     // Catch: Throwable -> L29
        r5.getClass();     // Catch: Throwable -> L29
        Statistics.sendEvent("im_mention_board_click", s5c.d.b.b(r5, r16).plus(r8).plus(r9).plus(r13).plus(r14).plus(r15).toJson());     // Catch: Throwable -> L29
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
        return;
    L20:
        if ((r1 instanceof WantAtMemBean) == true) goto L23;
        r12 = String.valueOf(r1.getPinyin());     // Catch: Throwable -> L29
        goto L24
    L10:
        if (r6 != 4) goto L12;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.ss.android.lark.mention.base.impl.atselector.bean.SearchBean");     // Catch: Throwable -> L29
        int r17 = e.a;     // Catch: Throwable -> L29
        r8 = e.a.a(((SearchBean) r1).getChatterInfo());     // Catch: Throwable -> L29
        goto L17
    L12:
        if (r6 == 7) goto L14;
        r8 = m0.d;     // Catch: Throwable -> L29
        goto L17
    L14:
        r8 = m0.c;     // Catch: Throwable -> L29
        goto L17
    L6:
        r5 = e2.d;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
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
