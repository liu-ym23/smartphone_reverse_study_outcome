package com.bytedance.ai.bridge.method.analytics;

import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.analytics.AbsReportEventMethodIDL;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.contianer.m;
import d3.a0;
import e3.d;
import f3.h;
import java.util.Map;
import k3.c;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/analytics/ReportEventMethod;", "Lcom/bytedance/ai/bridge/analytics/AbsReportEventMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/analytics/AbsReportEventMethodIDL$ReportEventParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/analytics/AbsReportEventMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReportEventMethod extends AbsReportEventMethodIDL {

    public static final class a {
    }

    static {
    }

    public ReportEventMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsReportEventMethodIDL.b r13 = (AbsReportEventMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call start, eventName=");
        r1.append(r13.getEventName());
        r1.append(", hasData=");
        if (r13.getData() == null) goto L5;
        boolean r14 = true;
    L6:
        r1.append(r14);
        r0.d("AISDK_JSB_ReportEventMethod", r1.toString());
        a0 r15 = r10.getContainerContext();
        ContainerType r16 = null;
        if (r15 == null) goto L30;
        String r17 = r15.getAppletId();
        if (r17 == null) goto L30;
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r18 = AppletAppManagerService.b(r17);
        if (r18 == null) goto L29;
        Map<String, ? extends Object> r19 = MapsKt.toMutableMap(r13.getData());
        a0 r20 = r10.getContainerContext();
        if (r20 == null) goto L17;
        r16 = r20.getContainerType();
    L17:
        if (r16 != ContainerType.WIDGET) goto L28;
        WidgetContainer r21 = (WidgetContainer) r10.d(WidgetContainer.class);
        if (r21 == null) goto L28;
        m r22 = r21.g;
        if (r22 == null) goto L28;
        if (r19.containsKey("message_id") == true) goto L26;
        r19.put("message_id", r22.e);
    L26:
        if (r19.containsKey("widget_id") == true) goto L28;
        r19.put("widget_id", r22.b);
    L28:
        r18.h().e().i(r13.getEventName(), r19);
        r0.d("AISDK_JSB_ReportEventMethod", "call success, eventName=" + r13.getEventName());
        Intrinsics.checkNotNullParameter(AbsReportEventMethodIDL.a.class, "<this>");
        r12.b((ResultModel) c.a(AbsReportEventMethodIDL.a.class), "");
        return;
    L29:
        StringBuilder r23 = new StringBuilder("call failed, errNo=");
        f3.a r24 = f3.a.f;
        r23.append(r24.a);
        r23.append(", msg=app ");
        r23.append(r17);
        r23.append(" not found");
        r0.e("AISDK_JSB_ReportEventMethod", r23.toString());
        h.a.a(r12, "app " + r17 + " not found", r24, null, 10);
        return;
    L30:
        StringBuilder r25 = new StringBuilder("call failed, errNo=");
        f3.a r26 = f3.a.f;
        r25.append(r26.a);
        r25.append(", msg=appId is null");
        r0.e("AISDK_JSB_ReportEventMethod", r25.toString());
        h.a.a(r12, "appId is null", r26, null, 10);
        return;
    L5:
        r14 = false;
        goto L6
    }
}
