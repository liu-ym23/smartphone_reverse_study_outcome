package com.bytedance.ai.model;

import androidx.lifecycle.Lifecycle;
import com.bytedance.ai.utils.LifecycleRegistryExtKt;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import m5.i1;
import m5.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class l implements Function1 {
    public final /* synthetic */ AppletRuntime a;

    public /* synthetic */ l(AppletRuntime r1) {
        this.a = r1;
    }

    public final Object invoke(Object r14) {
        AppletRuntime r0 = this.a;
        boolean r15 = ((Boolean) r14).booleanValue();
        AtomicInteger r1 = AppletRuntime.x;
        if (r15 == false) goto L40;
        r0.w();
        Map<String, Object> r16 = r0.i;
        String r10 = null;
        if (r16 == null) goto L8;
        Object r17 = r16.get("trace_id");
    L10:
        if ((r17 instanceof String) == false) goto L12;
        final String r18 = (String) r17;
    L13:
        Map<String, Object> r11 = r0.i;
        if (r11 == null) goto L16;
        Object r12 = r11.get("eventName");
    L18:
        if ((r12 instanceof String) == false) goto L20;
        r10 = (String) r12;
    L20:
        com.bytedance.ai.utils.g r13 = com.bytedance.ai.utils.g.a;
        r13.d("WidgetEventMonitor", "init AppletRuntime. " + r18 + ", " + r10);
        if (r18 == null) goto L29;
        if (r10 == null) goto L29;
        i1 r19 = y0.a;
        Intrinsics.checkNotNullParameter(r18, "traceId");
        Intrinsics.checkNotNullParameter(r10, "eventType");
        final long r20 = System.currentTimeMillis();
        r13.d("AppletEventMonitorManager", "onInitJSWorkerStart: " + r18 + ", " + r10);
        if (Intrinsics.areEqual(r10, "applet_widget_timeline_full") == false) goto L27;
        y0.r(new m5.d0(r18, r20));
        goto L29
    L27:
        if (Intrinsics.areEqual(r10, "applet_page_timeline_full") == false) goto L29;
        y0.r(new m5.e0(r18, r20));
    L29:
        com.bytedance.ai.monitor.b.d("applet_init_js_worker_end", new AppletRuntime.f(r0));
        if (r18 == null) goto L38;
        if (r10 == null) goto L38;
        i1 r21 = y0.a;
        Intrinsics.checkNotNullParameter(r18, "traceId");
        Intrinsics.checkNotNullParameter(r10, "eventType");
        final long r22 = System.currentTimeMillis();
        r13.d("AppletEventMonitorManager", "onInitJSWorkerEnd: " + r18 + ", " + r10);
        if (Intrinsics.areEqual(r10, "applet_widget_timeline_full") == false) goto L36;
        y0.r(new m5.z(r18, r22));
        goto L38
    L36:
        if (Intrinsics.areEqual(r10, "applet_page_timeline_full") == false) goto L38;
        y0.r(new m5.a0(r18, r22));
    L38:
        r0.B(r18, r10);
        HashSet<AppletRuntime> r110 = AppletRuntime.c.a;
        Intrinsics.checkNotNullParameter(r0, "runtime");
        AppletRuntime.c.a.add(r0);
        LifecycleRegistryExtKt.a(r0.p, Lifecycle.Event.ON_CREATE);
        return Unit.INSTANCE;
    L16:
        r12 = null;
        goto L18
    L12:
        r18 = null;
        goto L13
    L8:
        r17 = null;
        goto L10
    L40:
        return Unit.INSTANCE;
    }
}
