package com.bytedance.ai.bridge.method.ui;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.system.ui.AbsEnableAlertBeforeUnloadMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/EnableAlertBeforeUnloadMethod;", "Lcom/bytedance/ai/bridge/system/ui/AbsEnableAlertBeforeUnloadMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/ui/AbsEnableAlertBeforeUnloadMethodIDL$EnableAlertBeforeUnloadParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/ui/AbsEnableAlertBeforeUnloadMethodIDL$EmptyMessageModel;", "fail", "errNo", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", com.bytedance.android.ec.core.event.a.KEY_MSG, "", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnableAlertBeforeUnloadMethod extends AbsEnableAlertBeforeUnloadMethodIDL {

    public static final class a {
    }

    static {
    }

    public EnableAlertBeforeUnloadMethod() {
    }

    public final void b(h<AbsEnableAlertBeforeUnloadMethodIDL.a> r10, f3.a r11, String r12) {
        g.a.e("AISDK_JSB_EnableAlertBeforeUnloadMethod", "call failed, errNo=" + r11.a + ", msg=" + r12);
        h.a.a(r10, r12, r11, null, 10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsEnableAlertBeforeUnloadMethodIDL.b r13 = (AbsEnableAlertBeforeUnloadMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        String r14 = r13.getMessage();
        a0 r15 = r10.getContainerContext();
        g r1 = g.a;
        StringBuilder r16 = new StringBuilder("call start, messageLen=");
        r16.append(r14.length());
        r16.append(", appletId=");
        if (r15 == null) goto L5;
        String r17 = r15.getAppletId();
    L6:
        r16.append(r17);
        r16.append(", containerId=");
        if (r15 == null) goto L9;
        String r18 = r15.getContainerId();
    L10:
        r16.append(r18);
        r1.i("AISDK_JSB_EnableAlertBeforeUnloadMethod", r16.toString());
        if (r15 == null) goto L13;
        ContainerType r19 = r15.getContainerType();
    L15:
        if (r19 == ContainerType.PAGE) goto L17;
        b(r12, f3.a.g, "only supported in page container");
        return;
    L17:
        Long r20 = r15.getTraceId();
        if (r20 != null) goto L20;
        b(r12, f3.a.f, "not found page");
        return;
    L20:
        String r21 = r15.getAppletId();
        if (r21 != null) goto L23;
    L26:
        boolean r22 = true;
    L27:
        if (r22 == false) goto L29;
        b(r12, f3.a.f, "appId is empty");
        return;
    L29:
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r23 = AppletAppManagerService.a(r21);
        if (r23 != null) goto L37;
        b(r12, f3.a.q, "app " + r21 + " not found");
        return;
    L37:
        r23.h().d().n(r20.longValue(), r14);     // Catch: Exception -> L34
        r1.i("AISDK_JSB_EnableAlertBeforeUnloadMethod", "call success, traceId=" + r20 + ", messageLen=" + r14.length());     // Catch: Exception -> L34
        Intrinsics.checkNotNullParameter(AbsEnableAlertBeforeUnloadMethodIDL.a.class, "<this>");     // Catch: Exception -> L34
        r12.b((ResultModel) c.a(AbsEnableAlertBeforeUnloadMethodIDL.a.class), "");     // Catch: Exception -> L34
        return;
    L34:
        e = move-exception;
        g r24 = g.a;
        StringBuilder r0 = new StringBuilder("call failed with exception, errNo=");
        f3.a r25 = f3.a.f;
        r0.append(r25.a);
        r0.append(", exception=");
        r0.append(e.getClass().getSimpleName());
        r24.e("AISDK_JSB_EnableAlertBeforeUnloadMethod", r0.toString());
        h.a.a(r12, "failed to enable alert before unload", r25, null, 10);
        return;
    L23:
        if (r21.length() == 0) goto L26;
        r22 = false;
        goto L27
    L13:
        r19 = null;
        goto L15
    L9:
        r18 = null;
        goto L10
    L5:
        r17 = null;
        goto L6
    }
}
