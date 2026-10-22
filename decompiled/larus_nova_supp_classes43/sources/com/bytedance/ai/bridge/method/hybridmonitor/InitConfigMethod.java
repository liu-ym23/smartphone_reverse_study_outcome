package com.bytedance.ai.bridge.method.hybridmonitor;

import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.hybridMonitor.AbsInitConfigMethodIDL;
import com.ivy.ivykit.api.plugin.IIvyHybridMonitorService;
import d3.a0;
import e3.d;
import f3.h;
import java.util.Map;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/hybridmonitor/InitConfigMethod;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsInitConfigMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsInitConfigMethodIDL$SlardarConfigModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsInitConfigMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitConfigMethod extends AbsInitConfigMethodIDL {

    public static final class a {
    }

    static {
    }

    public InitConfigMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        String r0 = "";
        AbsInitConfigMethodIDL.b r13 = (AbsInitConfigMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        com.bytedance.ai.applet.base.log.a.c("HybridMonitor", "init config");     // Catch: Exception -> L30
        IIvyHybridMonitorService.Companion r14 = IIvyHybridMonitorService.a;     // Catch: Exception -> L30
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L30
        String r16 = r13.getBid();     // Catch: Exception -> L30
        if (r16 == null) goto L6;
        r15.put("bid", r16);     // Catch: Exception -> L30
    L6:
        String r17 = r13.getPid();     // Catch: Exception -> L30
        if (r17 == null) goto L9;
        r15.put("pid", r17);     // Catch: Exception -> L30
    L9:
        String r18 = r13.getEnv();     // Catch: Exception -> L30
        if (r18 == null) goto L12;
        r15.put("env", r18);     // Catch: Exception -> L30
    L12:
        String r19 = r13.getRelease();     // Catch: Exception -> L30
        if (r19 == null) goto L15;
        r15.put("release", r19);     // Catch: Exception -> L30
    L15:
        Map<String, Object> r20 = r13.getContext();     // Catch: Exception -> L30
        if (r20 == null) goto L18;
        r15.put("context", r20);     // Catch: Exception -> L30
    L18:
        JSONObject r21 = r14.b(r15);     // Catch: Exception -> L30
        RefType r22 = RefType.NORMAL;     // Catch: Exception -> L30
        Object r23 = r10.d(y3.a.class);     // Catch: Exception -> L30
        if (r23 != null) goto L25;
        com.bytedance.ai.applet.base.log.a.c("HybridMonitor", "creating event reporter");     // Catch: Exception -> L30
        a0 r24 = r10.getContainerContext();     // Catch: Exception -> L30
        if (r24 == null) goto L23;
        String r25 = r24.getUrl();     // Catch: Exception -> L30
    L24:
        r23 = new y3.a(r25);     // Catch: Exception -> L30
        r10.b(y3.a.class, r23, r22);     // Catch: Exception -> L30
        goto L25
    L23:
        r25 = null;
    L25:
        Intrinsics.checkNotNullParameter(r21, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);     // Catch: Exception -> L30
        com.ivy.ivykit.api.plugin.a r26 = ((y3.a) r23).b;     // Catch: Exception -> L30
        if (r26 == null) goto L28;
        r26.updateConfig(r21);     // Catch: Exception -> L30
    L28:
        Intrinsics.checkNotNullParameter(AbsInitConfigMethodIDL.a.class, "<this>");     // Catch: Exception -> L30
        r12.b((ResultModel) c.a(AbsInitConfigMethodIDL.a.class), "");     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        com.bytedance.ai.applet.base.log.a.b("HybridMonitor", "init config failed", e);
        String r27 = e.getMessage();
        if (r27 == null) goto L35;
        r0 = r27;
    L35:
        h.a.a(r12, r0, null, null, 14);
    }
}
