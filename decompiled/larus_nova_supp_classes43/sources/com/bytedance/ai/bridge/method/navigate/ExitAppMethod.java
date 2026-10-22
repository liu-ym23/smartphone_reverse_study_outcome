package com.bytedance.ai.bridge.method.navigate;

import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.navigate.AbsExitAppMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/navigate/ExitAppMethod;", "Lcom/bytedance/ai/bridge/navigate/AbsExitAppMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/navigate/AbsExitAppMethodIDL$ExitAppRequestModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/navigate/AbsExitAppMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExitAppMethod extends AbsExitAppMethodIDL {

    public static final class a {
    }

    static {
    }

    public ExitAppMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsExitAppMethodIDL.b) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r13 = r10.getContainerContext();
        if (r13 == null) goto L5;
        String r0 = r13.getAppletId();
    L6:
        g r1 = g.a;
        StringBuilder r14 = new StringBuilder("call start, appletId=");
        r14.append(r0);
        r14.append(", containerId=");
        if (r13 == null) goto L9;
        String r15 = r13.getContainerId();
    L10:
        r14.append(r15);
        r1.i("AISDK_JSB_ExitAppMethod", r14.toString());
        if (r0 != null) goto L13;
    L16:
        boolean r16 = true;
    L18:
        if (r16 == false) goto L20;
        StringBuilder r17 = new StringBuilder("call failed, errNo=");
        f3.a r18 = f3.a.f;
        r17.append(r18.a);
        r17.append(", msg=appId is null");
        r1.e("AISDK_JSB_ExitAppMethod", r17.toString());
        h.a.a(r12, "appId is null", r18, null, 10);
        return;
    L20:
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r19 = AppletAppManagerService.a(r0);
        if (r19 == null) goto L26;
        AppletAppActivity r20 = r19.d;
        if (r20 == null) goto L25;
        r20.finish();
    L25:
        r1.i("AISDK_JSB_ExitAppMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsExitAppMethodIDL.a.class, "<this>");
        r12.b((ResultModel) c.a(AbsExitAppMethodIDL.a.class), "");
        return;
    L26:
        StringBuilder r21 = new StringBuilder("call failed, errNo=");
        f3.a r22 = f3.a.f;
        r21.append(r22.a);
        r21.append(", msg=app not found");
        r1.e("AISDK_JSB_ExitAppMethod", r21.toString());
        h.a.a(r12, "app " + r0 + " not found", r22, null, 10);
        return;
    L13:
        if (r0.length() == 0) goto L16;
        r16 = false;
        goto L18
    L9:
        r15 = null;
        goto L10
    L5:
        r0 = null;
        goto L6
    }
}
