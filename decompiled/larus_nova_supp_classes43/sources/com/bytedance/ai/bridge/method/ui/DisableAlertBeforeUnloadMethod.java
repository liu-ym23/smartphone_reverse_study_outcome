package com.bytedance.ai.bridge.method.ui;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.system.ui.AbsDisableAlertBeforeUnloadMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/DisableAlertBeforeUnloadMethod;", "Lcom/bytedance/ai/bridge/system/ui/AbsDisableAlertBeforeUnloadMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/ui/AbsDisableAlertBeforeUnloadMethodIDL$EmptyMessageParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/ui/AbsDisableAlertBeforeUnloadMethodIDL$EmptyMessageResultModel;", "fail", "errNo", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", com.bytedance.android.ec.core.event.a.KEY_MSG, "", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DisableAlertBeforeUnloadMethod extends AbsDisableAlertBeforeUnloadMethodIDL {

    public static final class a {
    }

    static {
    }

    public DisableAlertBeforeUnloadMethod() {
    }

    public final void b(h<AbsDisableAlertBeforeUnloadMethodIDL.b> r10, f3.a r11, String r12) {
        g.a.e("AISDK_JSB_DisableAlertBeforeUnloadMethod", "call failed, errNo=" + r11.a + ", msg=" + r12);
        h.a.a(r10, r12, r11, null, 10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsDisableAlertBeforeUnloadMethodIDL.a) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r13 = r10.getContainerContext();
        g r14 = g.a;
        StringBuilder r1 = new StringBuilder("call start, appletId=");
        if (r13 == null) goto L5;
        String r15 = r13.getAppletId();
    L6:
        r1.append(r15);
        r1.append(", containerId=");
        if (r13 == null) goto L9;
        String r16 = r13.getContainerId();
    L10:
        r1.append(r16);
        r14.i("AISDK_JSB_DisableAlertBeforeUnloadMethod", r1.toString());
        if (r13 == null) goto L13;
        ContainerType r17 = r13.getContainerType();
    L15:
        if (r17 == ContainerType.PAGE) goto L17;
        b(r12, f3.a.g, "only supported in page container");
        return;
    L17:
        Long r18 = r13.getTraceId();
        if (r18 != null) goto L20;
        b(r12, f3.a.f, "not found page");
        return;
    L20:
        String r19 = r13.getAppletId();
        if (r19 != null) goto L23;
    L26:
        boolean r20 = true;
    L27:
        if (r20 == false) goto L29;
        b(r12, f3.a.f, "appId is empty");
        return;
    L29:
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r21 = AppletAppManagerService.a(r19);
        if (r21 != null) goto L37;
        b(r12, f3.a.q, "app " + r19 + " not found");
        return;
    L37:
        r21.h().d().k(r18.longValue());     // Catch: Exception -> L34
        r14.i("AISDK_JSB_DisableAlertBeforeUnloadMethod", "call success, traceId=" + r18);     // Catch: Exception -> L34
        Intrinsics.checkNotNullParameter(AbsDisableAlertBeforeUnloadMethodIDL.b.class, "<this>");     // Catch: Exception -> L34
        r12.b((ResultModel) c.a(AbsDisableAlertBeforeUnloadMethodIDL.b.class), "");     // Catch: Exception -> L34
        return;
    L34:
        e = move-exception;
        g r22 = g.a;
        StringBuilder r0 = new StringBuilder("call failed with exception, errNo=");
        f3.a r23 = f3.a.f;
        r0.append(r23.a);
        r0.append(", exception=");
        r0.append(e.getClass().getSimpleName());
        r22.e("AISDK_JSB_DisableAlertBeforeUnloadMethod", r0.toString());
        h.a.a(r12, "failed to disable alert before unload", r23, null, 10);
        return;
    L23:
        if (r19.length() == 0) goto L26;
        r20 = false;
        goto L27
    L13:
        r17 = null;
        goto L15
    L9:
        r16 = null;
        goto L10
    L5:
        r15 = null;
        goto L6
    }
}
