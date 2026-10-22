package com.bytedance.ai.model;

import android.app.Activity;
import android.app.AlertDialog;
import com.bytedance.ai.monitor.AppletErrorCode;
import java.util.Iterator;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppletRuntime f2242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f2243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2244c;
    public final /* synthetic */ String d;

    public /* synthetic */ g(AppletRuntime r5, boolean r10, String r11, String r12) {
        this.f2242a = r5;
        this.f2243b = r10;
        this.f2244c = r11;
        this.d = r12;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object r19, Object r20, Object r21) {
        int r5 = 1;
        com.bytedance.ai.utils.h r10 = (com.bytedance.ai.utils.h) r19;
        String r11 = (String) r20;
        String r12 = (String) r21;
        int r13 = AppletRuntime.f2196x;
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "resFrom");
        StringBuilder r14 = new StringBuilder();
        AppletRuntime r15 = this.f2242a;
        r14.append(r15.f2197h.i());
        if (this.f2243b == true) goto L5;
        String r16 = "-main.js";
    L6:
        r14.append(r16);
        String r17 = r14.toString();
        r15.s = r12;
        if ((r10 instanceof com.bytedance.ai.utils.g) == false) goto L10;
        boolean r18 = com.bytedance.ai.utils.c.l(((com.bytedance.ai.utils.g) r10).f2850a);
    L18:
        String r110 = this.f2244c;
        String r22 = this.d;
        if (r18 == false) goto L40;
        y2.e r111 = r15.t();
        Intrinsics.checkNotNull(r10);
        r111.b(r10, r17, new a3.f(6), new a2.c(4, r15, r110, r22, r11));
        r15.f2199j.set(true);
        Iterator r23 = r15.f2203n.iterator();
    L22:
        if (r23.hasNext() == false) goto L24;
        ((Runnable) r23.next()).run();
        goto L22
    L24:
        r15.f2201l.N(Boolean.TRUE);
        z2.d.e("applet_init_main_js_result", new sj.e());
        if (r110 == null) goto L49;
        if (r22 == null) goto L49;
        String r24 = com.lynx.tasm.behavior.utils.d.c("mainJsFrom: ", r12, "WidgetEventMonitor");
        t0.d r25 = com.bytedance.ai.utils.c.f2846a;
        if (r25 == null) goto L30;
        r25.d("WidgetEventMonitor", r24);
    L30:
        b3.p r26 = b3.h.f841a;
        Map r27 = MapsKt.mapOf(TuplesKt.to("main_js_res_from", r12));
        Intrinsics.checkNotNullParameter(r110, "traceId");
        Intrinsics.checkNotNullParameter(r22, "eventType");
        Intrinsics.checkNotNullParameter(r27, "eventInfo");
        long r112 = System.currentTimeMillis();
        String r28 = com.lynx.tasm.utils.b.j("onLoadMainJSEnd: ", r110, ", ", r22);
        Intrinsics.checkNotNullParameter("AppletEventMonitorManager", "tag");
        t0.d r29 = com.bytedance.ai.utils.c.f2846a;
        if (r29 == null) goto L34;
        r29.d("AppletEventMonitorManager", r28);
    L34:
        if (Intrinsics.areEqual(r22, "applet_widget_timeline_full") == false) goto L37;
        b3.h.c(new b3.a(r110, r112, r27, 9));
        goto L49
    L37:
        if (Intrinsics.areEqual(r22, "applet_page_timeline_full") == false) goto L49;
        b3.h.c(new b3.a(r110, r112, r27, 10));
    L49:
        return Unit.INSTANCE;
    L40:
        if (r110 == null) goto L44;
        if (r22 == null) goto L44;
        b3.p r30 = b3.h.f841a;
        AppletErrorCode r31 = AppletErrorCode.f2378b;
        b3.h.a(102, r110, "failed to load main.js", r22);
    L44:
        if (s0.c.f21802b == false) goto L49;
        Activity r32 = s0.c.b();
        if (r32 == null) goto L49;
        AlertDialog.Builder r33 = new AlertDialog.Builder(r32);
        r33.setTitle("failed to load main.js");
        r33.setMessage("failed to load main.js");
        r33.setPositiveButton("Retry", new c(r15, r5));
        r33.setNegativeButton("Cancel", new d(r5));
        r32.runOnUiThread(new e(r33, r5));
        goto L49
    L10:
        if ((r10 instanceof com.bytedance.ai.utils.f) == false) goto L17;
        byte[] r34 = ((com.bytedance.ai.utils.f) r10).f2849a;
        if (r34 == null) goto L17;
        if (r34.length == 0) goto L17;
        r18 = true;
    L17:
        r18 = false;
        goto L18
    L5:
        r16 = "-main.rasm";
        goto L6
    }
}
