package com.bytedance.ai.bridge.method.net;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/CancelStreamRequestMethod;", "Lcom/bytedance/ai/bridge/method/net/AbsCancelStreamRequestMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/net/AbsCancelStreamRequestMethodIDL$CancelStreamRequestParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/net/AbsCancelStreamRequestMethodIDL$CancelStreamRequestResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/net/AbsCancelStreamRequestMethodIDL$CancelStreamRequestParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CancelStreamRequestMethod extends AbsCancelStreamRequestMethodIDL {
    public CancelStreamRequestMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, o1.f r11) {
        handle(r5, (AbsCancelStreamRequestMethodIDL.CancelStreamRequestParamModel) r10, r11);
    }

    public void handle(n1.c r5, AbsCancelStreamRequestMethodIDL.CancelStreamRequestParamModel r10, o1.f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        String r12 = r10.getSessionId();
        AppletRequestMethod.Companion.getClass();
        if (AppletRequestMethod.access$getStreamRequestMap$cp().containsKey(r12) == false) goto L9;
        c2.a r13 = (c2.a) AppletRequestMethod.access$getStreamRequestMap$cp().get(r12);
        if (r13 == null) goto L7;
        r13.a();
    L7:
        Intrinsics.checkNotNullParameter(AbsCancelStreamRequestMethodIDL.CancelStreamRequestResultModel.class, "<this>");
        r11.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsCancelStreamRequestMethodIDL.CancelStreamRequestResultModel.class), "");
        return;
    L9:
        r11.a("can not find stream request with sessionId:" + r12);
    }
}
