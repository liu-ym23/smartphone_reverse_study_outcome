package com.bytedance.ai.bridge.method.log;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import d3.a0;
import e3.d;
import java.util.HashMap;
import java.util.Map;
import k5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements j {
    public final /* synthetic */ d a;
    public final /* synthetic */ AbsReportAppLogMethodIDL.a b;

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.log.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0025a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContainerType.values().length];
            r0[ContainerType.WORKER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ContainerType.WIDGET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ContainerType.PAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        a0 r0 = this.a.getContainerContext();
        HashMap<String, Object> r1 = null;
        if (r0 == null) goto L5;
        ContainerType r11 = r0.getContainerType();
    L6:
        if (r11 != null) goto L8;
        int r12 = -1;
    L10:
        if (r12 != 1) goto L12;
        r10.m(AppletMonitorableEvent.EventOrigin.MainJS);
        AppletRuntime r13 = (AppletRuntime) this.a.d(AppletRuntime.class);
        if (r13 == null) goto L47;
        r1 = r13.j;
    L47:
        if (r13 == null) goto L54;
        Applet r14 = r13.h;
        if (r14 == null) goto L54;
        String r15 = r14.N;
        if (r15 == null) goto L54;
        if (r1 == null) goto L54;
        int r16 = ReportAppLogMethod.b;
        r1.put("bot_id", r15);
    L54:
        if (r1 == null) goto L56;
        r10.h(r1);
    L56:
        AppletRuntimeManager.INSTANCE.getClass();
        r10.d("is_background", AppletRuntimeManager.f ? 1 : 0);
        Map<String, ? extends Object> r17 = this.b.getParams();
        if (r17 == null) goto L60;
        r10.h(r17);
        return;
    L60:
        return;
    L12:
        if (r12 != 2) goto L14;
        r10.m(AppletMonitorableEvent.EventOrigin.UI);
        WidgetContainer r18 = (WidgetContainer) this.a.d(WidgetContainer.class);
        if (r18 == null) goto L34;
        r1 = r18.a;
    L34:
        if (r18 == null) goto L39;
        String r19 = r18.l();
        if (r19 == null) goto L39;
        if (r1 == null) goto L39;
        int r20 = ReportAppLogMethod.b;
        r1.put("message_id", r19);
    L39:
        if (r18 == null) goto L54;
        String r21 = r18.getBotId();
        if (r21 == null) goto L54;
        if (r1 == null) goto L54;
        int r22 = ReportAppLogMethod.b;
        r1.put("bot_id", r21);
        goto L54
    L14:
        if (r12 != 3) goto L54;
        r10.m(AppletMonitorableEvent.EventOrigin.UI);
        k2.j r23 = (k2.j) this.a.d(k2.j.class);
        if (r23 == null) goto L19;
        r1 = r23.getEventCommonParams();
    L19:
        if (r23 == null) goto L24;
        String r24 = r23.getBotId();
        if (r24 == null) goto L24;
        if (r1 == null) goto L24;
        int r25 = ReportAppLogMethod.b;
        r1.put("bot_id", r24);
    L24:
        if (r23 == null) goto L54;
        PageInfo r26 = r23.getPageInfo();
        if (r26 == null) goto L54;
        String r27 = r26.getMessageId();
        if (r27 == null) goto L54;
        if (r1 == null) goto L54;
        int r28 = ReportAppLogMethod.b;
        r1.put("message_id", r27);
        goto L54
    L8:
        r12 = C0025a.a[r11.ordinal()];
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public a(d r1, AbsReportAppLogMethodIDL.a r10) {
        this.a = r1;
        this.b = r10;
    }
}
