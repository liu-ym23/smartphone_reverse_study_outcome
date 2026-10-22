package com.bytedance.ai.bridge.method.context;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.foundation.AppletModelContextProvider;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.doubao.context.AbsSetPageModelContextMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/method/context/SetPageModelContextMethod;", "Lcom/bytedance/ai/bridge/doubao/context/AbsSetPageModelContextMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/doubao/context/AbsSetPageModelContextMethodIDL$SetPageModelContextParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/doubao/context/AbsSetPageModelContextMethodIDL$EmptyMessageModel;", "fail", "errNo", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", com.bytedance.android.ec.core.event.a.KEY_MSG, "", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetPageModelContextMethod extends AbsSetPageModelContextMethodIDL {

    public static final class a {
    }

    static {
    }

    public SetPageModelContextMethod() {
    }

    public final void b(h<AbsSetPageModelContextMethodIDL.a> r10, f3.a r11, String r12) {
        g.a.e("AISDK_JSB_SetPageModelContextMethod", "call failed, errNo=" + r11.a + ", msg=" + r12);
        h.a.a(r10, r12, r11, null, 10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsSetPageModelContextMethodIDL.b r13 = (AbsSetPageModelContextMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r14 = r10.getContainerContext();
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call start, containerType=");
        String r15 = null;
        if (r14 == null) goto L5;
        ContainerType r16 = r14.getContainerType();
    L6:
        r1.append(r16);
        r1.append(", traceId=");
        if (r14 == null) goto L9;
        Long r17 = r14.getTraceId();
    L10:
        r1.append(r17);
        r1.append(", appletId=");
        if (r14 == null) goto L13;
        String r18 = r14.getAppletId();
    L14:
        r1.append(r18);
        r1.append(", pageInfoSize=");
        r1.append(r13.getPageInfo().size());
        r0.i("AISDK_JSB_SetPageModelContextMethod", r1.toString());
        if (r14 == null) goto L17;
        ContainerType r19 = r14.getContainerType();
    L19:
        if (r19 == ContainerType.PAGE) goto L21;
        b(r12, f3.a.g, "not called in page");
        return;
    L21:
        boolean r20 = true;
        if (r13.getTaskId().length() != 0) goto L24;
        boolean r21 = true;
    L25:
        if (r21 == false) goto L27;
        b(r12, f3.a.h, "taskId is empty");
        return;
    L27:
        Long r22 = r14.getTraceId();
        if (r22 != null) goto L30;
        b(r12, f3.a.f, "not found page");
        return;
    L30:
        String r110 = r14.getAppletId();
        if (r110 != null) goto L33;
    L36:
        boolean r23 = true;
    L37:
        if (r23 == false) goto L39;
        b(r12, f3.a.f, "appId is empty");
        return;
    L39:
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r24 = AppletAppManagerService.a(r110);
        if (r24 != null) goto L42;
        b(r12, f3.a.q, "app " + r110 + " not found");
        return;
    L42:
        String r25 = r13.getPageName();
        if (r25 != null) goto L45;
    L50:
        AppletModelContextProvider r26 = (AppletModelContextProvider) r24.h().n.getValue();
        long r27 = r22.longValue();
        AppletModelContextProvider.PageContext r28 = new AppletModelContextProvider.PageContext(r13.getTaskId(), r110, r15, r13.getPageInfo());
        r26.getClass();
        Intrinsics.checkNotNullParameter(r28, "pageContext");
        r26.b.put(Long.valueOf(r27), r28);
        r0.i("AppletModelContextProvider", "setPageContext, traceId=" + r27 + ", bizTaskId=" + r28.getBizTaskId() + ", totalPages=" + r26.b.size());
        StringBuilder r111 = new StringBuilder("call success, traceId=");
        r111.append(r22);
        r111.append(", pagePath=");
        r111.append(r15);
        r0.i("AISDK_JSB_SetPageModelContextMethod", r111.toString());
        Intrinsics.checkNotNullParameter(AbsSetPageModelContextMethodIDL.a.class, "<this>");
        r12.b((ResultModel) c.a(AbsSetPageModelContextMethodIDL.a.class), "");
        return;
    L45:
        if (r25.length() > 0) goto L48;
        r20 = false;
    L48:
        if (r20 == false) goto L50;
        r15 = r25;
        goto L50
    L33:
        if (r110.length() == 0) goto L36;
        r23 = false;
        goto L37
    L24:
        r21 = false;
        goto L25
    L17:
        r19 = null;
        goto L19
    L13:
        r18 = null;
        goto L14
    L9:
        r17 = null;
        goto L10
    L5:
        r16 = null;
        goto L6
    }
}
