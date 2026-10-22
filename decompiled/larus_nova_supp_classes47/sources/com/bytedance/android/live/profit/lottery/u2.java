package com.bytedance.android.live.profit.lottery;

import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u2<T> implements Consumer {
    public final /* synthetic */ m2 a;

    public u2(m2 r1) {
        this.a = r1;
    }

    public final void accept(Object r17) {
        LotteryState.e r2 = (LotteryState.e) r17;
        if (this.a.h.isAnchor() == false) goto L49;
        Context r0 = m2.a(this.a);
        i1 r3 = r2.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r3, "rejectInfo");
        int r5 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.a("ttlive_lottery", "showRejectedDialog");
        Ref.ObjectRef r10 = new Ref.ObjectRef();     // Catch: Throwable -> L29
        r10.element = LotteryUtilsKt$showLotteryRejectedDialog$dismissFunc$1.INSTANCE;     // Catch: Throwable -> L29
        cs2.b r12 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.ui.d.class).yn(r0, 4);     // Catch: Throwable -> L29
        String r13 = w2.e().rejectedTitleString;     // Catch: Throwable -> L29
        String r14 = "";
        if (r13 != null) goto L9;
        r13 = "";
    L9:
        r12.g(r13);     // Catch: Throwable -> L29
        String r15 = r3.b;     // Catch: Throwable -> L29
        int r16 = 0;
        if (r15.length() <= 0) goto L12;
        boolean r18 = true;
    L13:
        if (r18 == true) goto L16;
        r15 = null;
    L16:
        if (r15 != null) goto L18;
        r15 = w2.e().rejectedMessageString;     // Catch: Throwable -> L29
    L18:
        if (r15 == null) goto L21;
        r14 = r15;
    L21:
        r12.e(r14);     // Catch: Throwable -> L29
        r12.c(false);     // Catch: Throwable -> L29
        if (r3.a.length() <= 0) goto L24;
        boolean r19 = true;
    L25:
        if (r19 == false) goto L27;
        SpannableString r110 = new SpannableString(r0.getString(2131920150));     // Catch: Throwable -> L29
        r110.setSpan(new ForegroundColorSpan(-16777216), 0, r110.length(), 33);     // Catch: Throwable -> L29
        r12.b(r110, new c3(r3, r0, r10));     // Catch: Throwable -> L29
        r16 = 1;
    L27:
        r12.a(r16, 2131920149, new d3(r10));     // Catch: Throwable -> L29
        r12.d();     // Catch: Throwable -> L29
        final Dialog r1 = r12.h();     // Catch: Throwable -> L29
        r10.element = new LotteryUtilsKt$showLotteryRejectedDialog$1(r1);     // Catch: Throwable -> L29
    L31:
        t r4 = r2.b;
        i1 r6 = r2.a;
        Intrinsics.checkNotNullParameter(r6, "rejectInfo");
        mz0.n r7 = new mz0.n();
        Map<String, String> r8 = r7.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        if (r4 == null) goto L45;
        int r9 = r4.d;
        if (r9 == 1) goto L43;
        if (r9 != 2) goto L37;
    L42:
        String r20 = "gift";
    L44:
        Intrinsics.checkNotNullParameter("lottery_type", "key");
        Intrinsics.checkNotNullParameter(r20, "value");
        r8.put("lottery_type", r20);
        goto L45
    L37:
        if (r9 != 3) goto L39;
        r20 = "game";
        goto L44
    L39:
        if (r9 == 4) goto L42;
        r20 = "unknown";
        goto L44
    L43:
        r20 = "money";
    L45:
        String r22 = r6.b;
        Intrinsics.checkNotNullParameter("reason", "key");
        Intrinsics.checkNotNullParameter(r22, "value");
        r8.put("reason", r22);
        mz0.m r23 = new mz0.m();
        r23.b(LogCommon.ROOM);
        r23.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r7.b).addAll(r23.a);
        cy0.e.a.getClass();
        cy0.j r24 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r25 = com.bytedance.android.scope.m.b(r24).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r25);
        ((mz0.i) ((f80.a) r25)).w3("lottery_password_check_feedback_show", r7.a, r7.b);
        return;
    L24:
        r19 = false;
        goto L25
    L12:
        r18 = false;
    L29:
        th = move-exception;
        int r26 = com.bytedance.android.live.revenue.common.v.a;
        Intrinsics.checkNotNullParameter("ttlive_lottery", "tag");
        Intrinsics.checkNotNullParameter(th, "throwable");
        jy0.b.f("ttlive_lottery", null, th, 2);
        goto L31
    }
}
