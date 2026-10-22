package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/CloseMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsCloseMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/router/AbsCloseMethodIDL$CloseParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/router/AbsCloseMethodIDL$CloseResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CloseMethod extends AbsCloseMethodIDL {
    public CloseMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, f3.h r12) {
        AbsCloseMethodIDL.a r13 = (AbsCloseMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        String r0 = r13.getContainerID();
        List<String> r1 = r13.getContainerIDs();
        boolean r14 = r13.getAnimated();
        if (r1 == null) goto L7;
        boolean r15 = true;
        if ((!r1.isEmpty()) != true) goto L7;
    L8:
        if (r15 == false) goto L15;
        Iterator<T> r16 = r1.iterator();
    L11:
        if (r16.hasNext() == false) goto L18;
        String r17 = (String) r16.next();
        r4.j r18 = r4.a.j;
        if (r18 == null) goto L11;
        r18.closeView(r10, r17, r14);
    L18:
        Intrinsics.checkNotNullParameter(AbsCloseMethodIDL.b.class, "<this>");
        r12.b((ResultModel) k3.c.a(AbsCloseMethodIDL.b.class), "");
        return;
    L15:
        r4.j r19 = r4.a.j;
        if (r19 == null) goto L18;
        r19.closeView(r10, r0, r14);
    L7:
        r15 = false;
        goto L8
    }
}
