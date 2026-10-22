package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.screen.AbsSetKeepScreenOnMethodIDL;
import com.bytedance.ai.utils.g;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import d3.a0;
import e3.e;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/SetKeepScreenOnMethod;", "Lcom/bytedance/ai/bridge/screen/AbsSetKeepScreenOnMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/screen/AbsSetKeepScreenOnMethodIDL$SetKeepScreenOnParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/screen/AbsSetKeepScreenOnMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetKeepScreenOnMethod extends AbsSetKeepScreenOnMethodIDL {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public SetKeepScreenOnMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, h r12) {
        AbsSetKeepScreenOnMethodIDL.b r13 = (AbsSetKeepScreenOnMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call start, keepScreenOn=");
        r1.append(r13.getKeepScreenOn());
        r1.append(", appletId=");
        a0 r14 = r10.getContainerContext();
        if (r14 == null) goto L5;
        String r15 = r14.getAppletId();
    L6:
        r1.append(r15);
        r0.i("AISDK_JSB_SetKeepScreenOnMethod", r1.toString());
        Activity r16 = e.a(r10);
        if (r16 == null) goto L15;
        Window r17 = r16.getWindow();
        if (r17 == null) goto L15;
        View r18 = r17.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L16;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r19 = ThreadMethodProxy.currentThread();
        if (r19 == com.larus.home.impl.utils.c.a) goto L16;
        com.larus.home.impl.utils.c.a(r19, "getDecorView");
    L16:
        if (r18 != null) goto L18;
        StringBuilder r20 = new StringBuilder("call failed, errNo=");
        f3.a r21 = f3.a.f;
        r20.append(r21.a);
        r20.append(", msg=not found view");
        r0.e("AISDK_JSB_SetKeepScreenOnMethod", r20.toString());
        h.a.a(r12, "not found view", r21, null, 10);
        return;
    L18:
        r18.setKeepScreenOn(r13.getKeepScreenOn());
        r0.i("AISDK_JSB_SetKeepScreenOnMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsSetKeepScreenOnMethodIDL.a.class, "<this>");
        r12.b((ResultModel) k3.c.a(AbsSetKeepScreenOnMethodIDL.a.class), "");
        return;
    L15:
        r18 = null;
        goto L16
    L5:
        r15 = null;
        goto L6
    }
}
