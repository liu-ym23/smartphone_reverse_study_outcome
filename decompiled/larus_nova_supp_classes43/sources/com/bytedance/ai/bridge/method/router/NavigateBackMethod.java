package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.router.AbsNavigateBackMethodIDL;
import d3.a0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/NavigateBackMethod;", "Lcom/bytedance/ai/bridge/router/AbsNavigateBackMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/router/AbsNavigateBackMethodIDL$NavigateBackRequestModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/router/AbsNavigateBackMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NavigateBackMethod extends AbsNavigateBackMethodIDL {

    public static final class a {
    }

    static {
    }

    public NavigateBackMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, f3.h r12) {
        AbsNavigateBackMethodIDL.b r13 = (AbsNavigateBackMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        StringBuilder r1 = new StringBuilder("call start, delta=");
        Integer r14 = r13.getDelta();
        int r15 = 1;
        if (r14 == null) goto L5;
        int r16 = r14.intValue();
    L6:
        r1.append(r16);
        r0.i("AISDK_JSB_NavigateBackMethod", r1.toString());
        a0 r17 = r10.getContainerContext();
        if (r17 == null) goto L31;
        String r18 = r17.getAppletId();
        if (r18 == null) goto L31;
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r19 = AppletAppManagerService.b(r18);
        if (r19 == null) goto L30;
        ApplicationRouter r20 = r19.h().d();
        Integer r21 = r13.getDelta();
        if (r21 == null) goto L16;
        r15 = r21.intValue();
    L16:
        Object r22 = r20.m(r15);
        if (Result.isSuccess-impl(r22) == false) goto L19;
        Unit r23 = (Unit) r22;
        r0.i("AISDK_JSB_NavigateBackMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsNavigateBackMethodIDL.a.class, "<this>");
        r12.b((ResultModel) k3.c.a(AbsNavigateBackMethodIDL.a.class), "");
    L19:
        Throwable r24 = Result.exceptionOrNull-impl(r22);
        if (r24 != null) goto L22;
    L29:
        Result.box-impl(r22);
        return;
    L22:
        if ((r24 instanceof IllegalArgumentException) == false) goto L24;
        f3.a r25 = f3.a.h;
    L25:
        r0.e("AISDK_JSB_NavigateBackMethod", "call failed, errNo=" + r25.a + ", msg=" + r24.getMessage());
        String r26 = r24.getMessage();
        if (r26 != null) goto L28;
        r26 = "navigateBack failed";
    L28:
        f3.h.a.a(r12, r26, r25, null, 10);
        goto L29
    L24:
        r25 = f3.a.f;
        goto L25
    L30:
        StringBuilder r27 = new StringBuilder("call failed, errNo=");
        f3.a r28 = f3.a.f;
        r27.append(r28.a);
        r27.append(", msg=app ");
        r27.append(r18);
        r27.append(" not found");
        r0.e("AISDK_JSB_NavigateBackMethod", r27.toString());
        f3.h.a.a(r12, "app " + r18 + " not found", r28, null, 10);
        return;
    L31:
        StringBuilder r29 = new StringBuilder("call failed, errNo=");
        f3.a r30 = f3.a.f;
        r29.append(r30.a);
        r29.append(", msg=appId is null");
        r0.e("AISDK_JSB_NavigateBackMethod", r29.toString());
        f3.h.a.a(r12, "appId is null", r30, null, 10);
        return;
    L5:
        r16 = 1;
        goto L6
    }
}
