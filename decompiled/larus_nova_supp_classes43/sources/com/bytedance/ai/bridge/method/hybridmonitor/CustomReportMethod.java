package com.bytedance.ai.bridge.method.hybridmonitor;

import com.bytedance.ai.applet.base.log.b;
import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.hybridMonitor.AbsCustomReportMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/hybridmonitor/CustomReportMethod;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsCustomReportMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsCustomReportMethodIDL$CustomEventDataModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsCustomReportMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomReportMethod extends AbsCustomReportMethodIDL {

    public static final class a {
    }

    static {
    }

    public CustomReportMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsCustomReportMethodIDL.a r13 = (AbsCustomReportMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call start, hasBid=");
        String r14 = r13.getBid();
        if (r14 != null) goto L5;
    L8:
        boolean r15 = true;
    L9:
        r1.append(!r15);
        r0.i("AISDK_JSB_CustomReportMethod", r1.toString());
        if (StringsKt.isBlank(r13.getEventName()) == false) goto L30;
        StringBuilder r16 = new StringBuilder("call failed, errNo=");
        f3.a r17 = f3.a.h;
        r16.append(r17.a);
        r16.append(", msg=eventName is empty");
        r0.e("AISDK_JSB_CustomReportMethod", r16.toString());
        h.a.a(r12, "eventName is empty", r17, null, 10);
        return;
    L30:
        RefType r18 = RefType.NORMAL;     // Catch: Exception -> L24
        Object r19 = r10.d(y3.a.class);     // Catch: Exception -> L24
        if (r19 != null) goto L19;
        a0 r20 = r10.getContainerContext();     // Catch: Exception -> L24
        if (r20 == null) goto L17;
        String r21 = r20.getUrl();     // Catch: Exception -> L24
    L18:
        r19 = new y3.a(r21);     // Catch: Exception -> L24
        r10.b(y3.a.class, r19, r18);     // Catch: Exception -> L24
        goto L19
    L17:
        r21 = null;
    L19:
        y3.a r22 = (y3.a) r19;     // Catch: Exception -> L24
        JSONObject r23 = new JSONObject(r13.toJson().toString());     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter(r23, "data");     // Catch: Exception -> L24
        b r110 = com.bytedance.ai.applet.base.log.a.a;     // Catch: Exception -> L24
        com.bytedance.ai.applet.base.log.a.c("EventReporter", "reportCustomEvent: data = " + r23);     // Catch: Exception -> L24
        com.ivy.ivykit.api.plugin.a r111 = r22.b;     // Catch: Exception -> L24
        if (r111 == null) goto L22;
        r111.a(r23, r22.a);     // Catch: Exception -> L24
    L22:
        r0.i("AISDK_JSB_CustomReportMethod", "call success");     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter(AbsCustomReportMethodIDL.b.class, "<this>");     // Catch: Exception -> L24
        r12.b((ResultModel) c.a(AbsCustomReportMethodIDL.b.class), "");     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        g r112 = g.a;
        StringBuilder r24 = new StringBuilder("call failed, errNo=");
        f3.a r25 = f3.a.f;
        r24.append(r25.a);
        r24.append(", msg=");
        r24.append(e.getMessage());
        r112.e("AISDK_JSB_CustomReportMethod", r24.toString(), e);
        String r26 = e.getMessage();
        if (r26 != null) goto L28;
        r26 = "custom report failed";
    L28:
        h.a.a(r12, r26, r25, null, 10);
        return;
    L5:
        if (StringsKt.isBlank(r14) == true) goto L8;
        r15 = false;
        goto L9
    }
}
