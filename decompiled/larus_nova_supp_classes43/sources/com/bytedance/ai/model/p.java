package com.bytedance.ai.model;

import android.app.Activity;
import android.app.AlertDialog;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceErrorCode;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import m5.i1;
import m5.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class p implements Function1 {
    public final /* synthetic */ com.bytedance.ai.applet.app.foundation.performance.n a;
    public final /* synthetic */ AppletRuntime b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public /* synthetic */ p(com.bytedance.ai.applet.app.foundation.performance.n r1, AppletRuntime r10, String r11, String r12, String r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final Object invoke(Object r10) {
        com.bytedance.ai.applet.app.foundation.performance.n r0 = this.a;
        final AppletRuntime r1 = this.b;
        String r11 = this.c;
        String r12 = this.d;
        final String r13 = this.e;
        String r14 = (String) r10;
        AtomicInteger r15 = AppletRuntime.x;
        Intrinsics.checkNotNullParameter(r14, "errorMsg");
        if (r0 == null) goto L5;
        r0.c(AppletPerformanceErrorCode.SCRIPT_EVALUATION_ERROR, r14);
    L5:
        r1.n = "evaluate Mainjs error --> " + r14;
        int r16 = com.bytedance.ai.utils.e.a;
        Intrinsics.checkNotNullParameter(r14, MessageIndication.MESSAGE_TYPE_MSG);
        Regex r17 = new Regex("Message:\\s(.*?)(?=,\\sStack:|$)");
        Regex r18 = new Regex("(?s)Stack:\\s(.*)");
        String r19 = null;
        MatchResult r20 = Regex.find$default(r17, r14, 0, 2, null);
        MatchResult r110 = Regex.find$default(r18, r14, 0, 2, null);
        if (r20 == null) goto L10;
        List r21 = r20.getGroupValues();
        if (r21 == null) goto L10;
        String r22 = (String) ListProtector.get(r21, 1);
    L11:
        if (r110 == null) goto L15;
        List r111 = r110.getGroupValues();
        if (r111 == null) goto L15;
        r19 = (String) ListProtector.get(r111, 1);
    L15:
        Pair r112 = new Pair(r22, r19);
        String r23 = (String) r112.component1();
        String r113 = (String) r112.component2();
        com.bytedance.ai.utils.f.j(r1.n);
        AtomicBoolean r24 = com.bytedance.ai.monitor.b.a;
        AppletErrorCode r25 = AppletErrorCode.JS_ERROR;
        if (r23 != null) goto L18;
        String r26 = "";
    L19:
        com.bytedance.ai.monitor.b.a(r25, r26, r113, new d(r1, r13));
        if (r11 == null) goto L27;
        if (r12 == null) goto L27;
        i1 r114 = y0.a;
        if (r23 != null) goto L25;
        r23 = "";
    L25:
        y0.b(r11, r23, r25.getType(), r12);
    L27:
        if (f2.k.b == false) goto L32;
        Activity r115 = f2.k.b();
        if (r115 == null) goto L32;
        final AlertDialog.Builder r27 = new AlertDialog.Builder(r115);
        r27.setTitle("MainJS evaluate Error");
        r27.setMessage(r1.n);
        r27.setPositiveButton("Retry", new e(r1));
        r27.setNegativeButton("Cancel", new f());
        r115.runOnUiThread(new g(r27));
    L32:
        return Unit.INSTANCE;
    L18:
        r26 = r23;
    L10:
        r22 = null;
        goto L11
    }
}
