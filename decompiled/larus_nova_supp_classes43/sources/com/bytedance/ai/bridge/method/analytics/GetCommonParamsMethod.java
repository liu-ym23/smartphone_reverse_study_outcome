package com.bytedance.ai.bridge.method.analytics;

import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.foundation.j;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.analytics.AbsGetCommonParamsMethodIDL;
import com.bytedance.ai.bridge.core.b;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import java.util.HashMap;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/analytics/GetCommonParamsMethod;", "Lcom/bytedance/ai/bridge/analytics/AbsGetCommonParamsMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/analytics/AbsGetCommonParamsMethodIDL$GetCommonParamsResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/analytics/AbsGetCommonParamsMethodIDL$EmptyMessageModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetCommonParamsMethod extends AbsGetCommonParamsMethodIDL {
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public GetCommonParamsMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(d r10, AbsGetCommonParamsMethodIDL.a r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        a0 r12 = r10.getContainerContext();
        if (r12 == null) goto L5;
        String r13 = r12.getAppletId();
    L6:
        g r14 = g.a;
        r14.i("AISDK_JSB_GetCommonParamsMethod", "call start, appletId=" + r13);
        if (r13 != null) goto L9;
    L12:
        boolean r0 = true;
    L14:
        if (r0 == false) goto L17;
        StringBuilder r15 = new StringBuilder("call failed, errNo=");
        f3.a r16 = f3.a.f;
        r15.append(r16.a);
        r15.append(", msg=appletId is null");
        r14.e("AISDK_JSB_GetCommonParamsMethod", r15.toString());
        return new com.bytedance.ai.bridge.core.a.b(0, "appletId is null", null, r16, 21);
    L17:
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r1 = AppletAppManagerService.b(r13);
        if (r1 != null) goto L21;
        StringBuilder r17 = new StringBuilder("call failed, errNo=");
        f3.a r18 = f3.a.f;
        r17.append(r18.a);
        r17.append(", msg=app ");
        r17.append(r13);
        r17.append(" not found");
        r14.e("AISDK_JSB_GetCommonParamsMethod", r17.toString());
        return new com.bytedance.ai.bridge.core.a.b(0, "app " + r13 + " not found", null, r18, 21);
    L21:
        j r19 = r1.h().e();
        r19.getClass();
        HashMap r20 = new HashMap(r19.h);
        r20.putAll(r19.c());
        r14.i("AISDK_JSB_GetCommonParamsMethod", "call success, appletId=" + r13 + ", paramsCount=" + r20.size());
        Intrinsics.checkNotNullParameter(AbsGetCommonParamsMethodIDL.b.class, "<this>");
        BaseModel r21 = c.a(AbsGetCommonParamsMethodIDL.b.class);
        ((AbsGetCommonParamsMethodIDL.b) r21).setParams(r20);
        return new com.bytedance.ai.bridge.core.a.c(r21);
    L9:
        if (r13.length() == 0) goto L12;
        r0 = false;
        goto L14
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsGetCommonParamsMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsGetCommonParamsMethodIDL.a r13 = (AbsGetCommonParamsMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        b.a(b(r10, r13), r12);
    }
}
