package com.bytedance.ai.bridge.method.hybridmonitor;

import com.bytedance.ai.applet.base.log.b;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.hybridMonitor.AbsReportErrorMethodIDL;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/hybridmonitor/ReportErrorMethod;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsReportErrorMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsReportErrorMethodIDL$ErrorInfoModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsReportErrorMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReportErrorMethod extends AbsReportErrorMethodIDL {

    public static final class a {
    }

    static {
    }

    public ReportErrorMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        String r0 = "";
        AbsReportErrorMethodIDL.b r13 = (AbsReportErrorMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        y3.a r14 = (y3.a) r10.d(y3.a.class);
        if (r14 != null) goto L17;
        h.a.a(r12, "hybrid monitor not initialized", null, null, 14);
        return;
    L17:
        JSONObject r15 = new JSONObject(r13.toJson().toString());     // Catch: Exception -> L10
        Intrinsics.checkNotNullParameter(r15, "data");     // Catch: Exception -> L10
        b r16 = com.bytedance.ai.applet.base.log.a.a;     // Catch: Exception -> L10
        com.bytedance.ai.applet.base.log.a.c("EventReporter", "reportError: data = " + r15);     // Catch: Exception -> L10
        com.ivy.ivykit.api.plugin.a r17 = r14.b;     // Catch: Exception -> L10
        if (r17 == null) goto L8;
        r17.b(r15, r14.a);     // Catch: Exception -> L10
    L8:
        Intrinsics.checkNotNullParameter(AbsReportErrorMethodIDL.a.class, "<this>");     // Catch: Exception -> L10
        r12.b((ResultModel) c.a(AbsReportErrorMethodIDL.a.class), "");     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.bytedance.ai.applet.base.log.a.b("HybridMonitor", "custom report failed", e);
        String r18 = e.getMessage();
        if (r18 == null) goto L15;
        r0 = r18;
    L15:
        h.a.a(r12, r0, null, null, 14);
    }
}
