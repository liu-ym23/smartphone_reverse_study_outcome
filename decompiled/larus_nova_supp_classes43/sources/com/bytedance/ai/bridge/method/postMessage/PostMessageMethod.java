package com.bytedance.ai.bridge.method.postMessage;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.postMessage.AbsPostMessageMethodIDL;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z2.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/postMessage/PostMessageMethod;", "Lcom/bytedance/ai/bridge/postMessage/AbsPostMessageMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/postMessage/AbsPostMessageMethodIDL$PostMessageParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/postMessage/AbsPostMessageMethodIDL$EmptyMessageModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PostMessageMethod extends AbsPostMessageMethodIDL {
    public PostMessageMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsPostMessageMethodIDL.b r13 = (AbsPostMessageMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r0 = r10.getContainerContext();
        if (r0 == null) goto L5;
        ContainerType r1 = r0.getContainerType();
    L7:
        if (r1 == ContainerType.EMBED_WEB_VIEW) goto L9;
        h.a.a(r12, "postMessage is only available in webview container", null, null, 14);
        return;
    L9:
        p r14 = (p) r10.d(p.class);
        if (r14 == null) goto L12;
        r14.onMessage(r13.getData());
    L12:
        Intrinsics.checkNotNullParameter(AbsPostMessageMethodIDL.a.class, "<this>");
        r12.b((ResultModel) c.a(AbsPostMessageMethodIDL.a.class), "");
        return;
    L5:
        r1 = null;
        goto L7
    }
}
