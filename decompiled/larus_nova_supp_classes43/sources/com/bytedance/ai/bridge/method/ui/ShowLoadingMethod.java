package com.bytedance.ai.bridge.method.ui;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.bridge.system.ui.AbsShowLoadingMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import e3.e;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/ShowLoadingMethod;", "Lcom/bytedance/ai/bridge/system/ui/AbsShowLoadingMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/ui/AbsShowLoadingMethodIDL$ShowLoadingParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/ui/AbsShowLoadingMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowLoadingMethod extends AbsShowLoadingMethodIDL {

    public static final class a {
    }

    static {
    }

    public ShowLoadingMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsShowLoadingMethodIDL.b) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r13 = r10.getContainerContext();
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call start, appletId=");
        if (r13 == null) goto L5;
        String r14 = r13.getAppletId();
    L6:
        r1.append(r14);
        r1.append(", containerId=");
        if (r13 == null) goto L9;
        String r15 = r13.getContainerId();
    L10:
        r1.append(r15);
        r0.i("AISDK_JSB_ShowLoadingMethod", r1.toString());
        if (e.b(r10) != null) goto L14;
        StringBuilder r16 = new StringBuilder("call failed, errNo=");
        f3.a r17 = f3.a.f;
        r16.append(r17.a);
        r16.append(", msg=context not provided in host");
        r0.e("AISDK_JSB_ShowLoadingMethod", r16.toString());
        h.a.a(r12, "context not provided in host", r17, null, 10);
        return;
    L14:
        if ((r10 instanceof e3.a) == false) goto L16;
        e3.a r18 = (e3.a) r10;
    L17:
        IHostStyleUIDepend r19 = r4.a.e;
        if (r19 == null) goto L20;
        Boolean r20 = r19.showLoading(r18);
    L21:
        Boolean r21 = Boolean.TRUE;
        if (Intrinsics.areEqual(r20, r21) == false) goto L24;
        Boolean r22 = r21;
    L26:
        if (Intrinsics.areEqual(r22, r21) == false) goto L28;
        r0.i("AISDK_JSB_ShowLoadingMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsShowLoadingMethodIDL.a.class, "<this>");
        r12.b((ResultModel) c.a(AbsShowLoadingMethodIDL.a.class), "");
        return;
    L28:
        StringBuilder r23 = new StringBuilder("call failed, errNo=");
        f3.a r24 = f3.a.f;
        r23.append(r24.a);
        r23.append(", msg=failed to show loading");
        r0.e("AISDK_JSB_ShowLoadingMethod", r23.toString());
        h.a.a(r12, "failed to show loading", r24, null, 10);
        return;
    L24:
        r0.w("AISDK_JSB_ShowLoadingMethod", "fallback used, reason=host unavailable");
        r22 = null;
        goto L26
    L20:
        r20 = null;
        goto L21
    L16:
        r18 = null;
        goto L17
    L9:
        r15 = null;
        goto L10
    L5:
        r14 = null;
        goto L6
    }
}
