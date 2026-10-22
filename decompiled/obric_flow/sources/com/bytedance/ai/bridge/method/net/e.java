package com.bytedance.ai.bridge.method.net;

import android.app.Application;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import b3.p;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.uiu.UIUInternalDebugBroadcastReceiver;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.lynx.jsbridge.r;
import com.lynx.tasm.l0;
import com.obric.feature.miniapp.widget.jsb.AppletOpenPageMethod;
import com.obric.flow.cardlistpage.data.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import m1.i;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1880b;

    public /* synthetic */ e(Object r5, int r10) {
        this.f1879a = r10;
        this.f1880b = r5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r13) {
        String r5 = null;
        i r10 = null;
        Object r11 = this.f1880b;
        switch(this.f1879a) {
            case 0: goto L78;
            case 1: goto L31;
            case 2: goto L29;
            case 3: goto L23;
            case 4: goto L18;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L9;
            default: goto L4;
        };
    L4:
        AppletRuntime r14 = (AppletRuntime) r13;
        if (r14 == null) goto L7;
        r10 = r14.r();
    L7:
        ((com.bytedance.ai.bridge.method.sqlite.b) r11).invoke(r10);
        return Unit.INSTANCE;
    L9:
        h r12 = (h) r11;
        r12.getClass();
        return com.obric.flow.cardlistpage.data.a.a(r12, (Continuation) r13);
    L13:
        z2.a r15 = (z2.a) r13;
        Intrinsics.checkNotNullParameter(r15, "error");
        com.bytedance.ai.widget.contianer.h r16 = ((WidgetContainer) r11).f;
        if (r16 == null) goto L16;
        r15.f = r16.f3047a;
        r15.g = r16.f3048b;
        r15.c("botId", r16.d);
        r15.c("message_id", r16.e);
    L16:
        r15.getClass();
        Intrinsics.checkNotNullParameter("isPreload", STGroup.DICT_KEY);
        r15.b("isPreload", Boolean.FALSE);
        return Unit.INSTANCE;
    L18:
        boolean r17 = ((Boolean) r13).booleanValue();
        String r18 = ((UIUInternalDebugBroadcastReceiver) r11).f2821a;
        String r19 = "Perform result=" + r17;
        Intrinsics.checkNotNullParameter(r18, "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L22;
        r20.d(r18, r19);
    L22:
        return Unit.INSTANCE;
    L23:
        l0 r110 = (l0) r13;
        Intrinsics.checkNotNullParameter(r110, "$this$createLynxView");
        Iterator r111 = ((ArrayList) r11).iterator();
    L25:
        if (r111.hasNext() == false) goto L27;
        r r21 = (r) r111.next();
        r110.a(r21.f9940b, r21.f9941c, r21.f9939a);
        goto L25
    L27:
        AtomicBoolean r112 = s0.a.f21798a;
        return Unit.INSTANCE;
    L29:
        com.bytedance.ai.model.widgets.a r113 = (com.bytedance.ai.model.widgets.a) r13;
        Intrinsics.checkNotNullParameter(r113, ST.IMPLICIT_ARG_NAME);
        return Boolean.valueOf(Intrinsics.areEqual(r113.d(), (View) r11));
    L31:
        boolean r114 = ((Boolean) r13).booleanValue();
        int r115 = AppletRuntime.f2196x;
        if (r114 == false) goto L80;
        AppletRuntime r22 = (AppletRuntime) r11;
        r22.u();
        Map r116 = r22.f2198i;
        if (r116 == null) goto L37;
        Object r117 = r116.get("trace_id");
    L39:
        if ((r117 instanceof String) == false) goto L41;
        String r118 = (String) r117;
    L42:
        if (r116 == null) goto L44;
        Object r119 = r116.get("eventName");
    L46:
        if ((r119 instanceof String) == false) goto L48;
        r5 = (String) r119;
    L48:
        String r120 = com.lynx.tasm.utils.b.j("init AppletRuntime. ", r118, ", ", r5);
        Intrinsics.checkNotNullParameter("WidgetEventMonitor", "tag");
        t0.d r23 = com.bytedance.ai.utils.c.f2846a;
        if (r23 == null) goto L52;
        r23.d("WidgetEventMonitor", r120);
    L52:
        if (r118 == null) goto L63;
        if (r5 == null) goto L63;
        p r24 = b3.h.f841a;
        Intrinsics.checkNotNullParameter(r118, "traceId");
        Intrinsics.checkNotNullParameter(r5, "eventType");
        long r25 = System.currentTimeMillis();
        String r121 = com.lynx.tasm.utils.b.j("onInitJSWorkerStart: ", r118, ", ", r5);
        Intrinsics.checkNotNullParameter("AppletEventMonitorManager", "tag");
        t0.d r122 = com.bytedance.ai.utils.c.f2846a;
        if (r122 == null) goto L58;
        r122.d("AppletEventMonitorManager", r121);
    L58:
        if (Intrinsics.areEqual(r5, "applet_widget_timeline_full") == false) goto L61;
        b3.h.c(new a3.b(r118, r25, 20));
        goto L63
    L61:
        if (Intrinsics.areEqual(r5, "applet_page_timeline_full") == false) goto L63;
        b3.h.c(new a3.b(r118, r25, 21));
    L63:
        z2.d.e("applet_init_js_worker_end", new ug.e(r22, 2));
        if (r118 == null) goto L75;
        if (r5 == null) goto L75;
        p r26 = b3.h.f841a;
        Intrinsics.checkNotNullParameter(r118, "traceId");
        Intrinsics.checkNotNullParameter(r5, "eventType");
        long r27 = System.currentTimeMillis();
        String r28 = com.lynx.tasm.utils.b.j("onInitJSWorkerEnd: ", r118, ", ", r5);
        Intrinsics.checkNotNullParameter("AppletEventMonitorManager", "tag");
        t0.d r29 = com.bytedance.ai.utils.c.f2846a;
        if (r29 == null) goto L70;
        r29.d("AppletEventMonitorManager", r28);
    L70:
        if (Intrinsics.areEqual(r5, "applet_widget_timeline_full") == false) goto L73;
        b3.h.c(new a3.b(r118, r27, 17));
        goto L75
    L73:
        if (Intrinsics.areEqual(r5, "applet_page_timeline_full") == false) goto L75;
        b3.h.c(new a3.b(r118, r27, 18));
    L75:
        r22.p(r118, r5);
        HashSet r123 = com.bytedance.ai.model.i.f2247a;
        Intrinsics.checkNotNullParameter(r22, "runtime");
        com.bytedance.ai.model.i.f2247a.add(r22);
        com.bytedance.ai.utils.c.g(r22.f2204o, Lifecycle.Event.ON_CREATE);
        return Unit.INSTANCE;
    L44:
        r119 = null;
        goto L46
    L41:
        r118 = null;
        goto L42
    L37:
        r117 = null;
        goto L39
    L80:
        return Unit.INSTANCE;
    L12:
        return AppletOpenPageMethod.c((Ref.ObjectRef) r11, (String) r13);
    L78:
        return RequestMethod.b((RequestMethod) r11, (Pair) r13);
    }

    public /* synthetic */ e(ArrayList r5, Application r10) {
        this.f1879a = 3;
        this.f1880b = r5;
    }
}
