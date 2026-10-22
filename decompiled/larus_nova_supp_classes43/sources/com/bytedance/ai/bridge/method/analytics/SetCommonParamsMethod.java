package com.bytedance.ai.bridge.method.analytics;

import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.foundation.j;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.analytics.AbsSetCommonParamsMethodIDL;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import java.util.Map;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/analytics/SetCommonParamsMethod;", "Lcom/bytedance/ai/bridge/analytics/AbsSetCommonParamsMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/analytics/AbsSetCommonParamsMethodIDL$SetCommonParamsParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/analytics/AbsSetCommonParamsMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetCommonParamsMethod extends AbsSetCommonParamsMethodIDL {

    public static final class a {
    }

    static {
    }

    public SetCommonParamsMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsSetCommonParamsMethodIDL.b r13 = (AbsSetCommonParamsMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r14 = r10.getContainerContext();
        if (r14 == null) goto L5;
        String r15 = r14.getAppletId();
    L6:
        g r16 = g.a;
        r16.i("AISDK_JSB_SetCommonParamsMethod", "call start, appletId=" + r15 + ", paramsCount=" + r13.getParams().size());
        if (r15 != null) goto L9;
    L12:
        boolean r17 = true;
    L14:
        if (r17 == false) goto L16;
        StringBuilder r18 = new StringBuilder("call failed, errNo=");
        f3.a r19 = f3.a.f;
        r18.append(r19.a);
        r18.append(", msg=appletId is null");
        r16.e("AISDK_JSB_SetCommonParamsMethod", r18.toString());
        h.a.a(r12, "appletId is null", r19, null, 10);
        return;
    L16:
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r20 = AppletAppManagerService.b(r15);
        if (r20 != null) goto L19;
        StringBuilder r21 = new StringBuilder("call failed, errNo=");
        f3.a r0 = f3.a.f;
        r21.append(r0.a);
        r21.append(", msg=app ");
        r21.append(r15);
        r21.append(" not found");
        r16.e("AISDK_JSB_SetCommonParamsMethod", r21.toString());
        h.a.a(r12, "app " + r15 + " not found", r0, null, 10);
        return;
    L19:
        j r1 = r20.h().e();
        Map<String, Object> r22 = r13.getParams();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r22, "params");
        r1.h.putAll(r22);
        r16.i("AISDK_JSB_SetCommonParamsMethod", "call success, appletId=".concat(r15));
        Intrinsics.checkNotNullParameter(AbsSetCommonParamsMethodIDL.a.class, "<this>");
        r12.b((ResultModel) c.a(AbsSetCommonParamsMethodIDL.a.class), "");
        return;
    L9:
        if (r15.length() == 0) goto L12;
        r17 = false;
        goto L14
    L5:
        r15 = null;
        goto L6
    }
}
