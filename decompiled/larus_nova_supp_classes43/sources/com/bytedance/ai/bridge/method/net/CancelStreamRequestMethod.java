package com.bytedance.ai.bridge.method.net;

import b4.k;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/CancelStreamRequestMethod;", "Lcom/bytedance/ai/bridge/method/net/AbsCancelStreamRequestMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/net/AbsCancelStreamRequestMethodIDL$CancelStreamRequestParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/net/AbsCancelStreamRequestMethodIDL$CancelStreamRequestResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CancelStreamRequestMethod extends AbsCancelStreamRequestMethodIDL {
    public CancelStreamRequestMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, f3.h r12) {
        AbsCancelStreamRequestMethodIDL.a r13 = (AbsCancelStreamRequestMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        String r14 = r13.getSessionId();
        ConcurrentHashMap<String, k> r15 = AppletRequestMethod.b;
        if (r15.containsKey(r14) == false) goto L8;
        k r16 = r15.get(r14);
        if (r16 == null) goto L7;
        r16.a();
    L7:
        Intrinsics.checkNotNullParameter(AbsCancelStreamRequestMethodIDL.b.class, "<this>");
        r12.b((ResultModel) k3.c.a(AbsCancelStreamRequestMethodIDL.b.class), "");
        return;
    L8:
        f3.h.a.a(r12, "can not find stream request with sessionId:" + r14, null, null, 14);
    }
}
