package com.bytedance.ai.bridge.method.ui;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import e3.d;
import f3.h;
import k2.j;
import k2.m;
import k2.q;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/AIBridgeSetTitleMethod;", "Lcom/bytedance/ai/bridge/method/ui/AbsAIBridgeSetTitleMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/ui/AbsAIBridgeSetTitleMethodIDL$SetTitleParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/ui/AbsAIBridgeSetTitleMethodIDL$SetTitleResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeSetTitleMethod extends AbsAIBridgeSetTitleMethodIDL {
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AIBridgeSetTitleMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsAIBridgeSetTitleMethodIDL.a r13 = (AbsAIBridgeSetTitleMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        j r14 = (j) r10.d(j.class);
        if (r14 == null) goto L12;
        m r15 = r14.getContainerViewService();
        if (r15 == null) goto L7;
        q r16 = r15.h();
    L8:
        if (r16 == null) goto L10;
        r16.setTitle(r13.getTitle());
    L11:
        Intrinsics.checkNotNullParameter(AbsAIBridgeSetTitleMethodIDL.b.class, "<this>");
        r12.b((ResultModel) c.a(AbsAIBridgeSetTitleMethodIDL.b.class), "");
        return;
    L10:
        h.a.a(r12, "Failed to get View", null, null, 14);
        goto L11
    L7:
        r16 = null;
        goto L8
    L12:
        h.a.a(r12, "Failed to get View", null, null, 14);
    }
}
