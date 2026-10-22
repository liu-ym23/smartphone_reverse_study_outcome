package com.bytedance.ai.bridge.method.datamanager;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s3.a;
import u4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/datamanager/AIStorageGetMethodV2;", "Lcom/bytedance/ai/bridge/method/datamanager/AbsGetStorageMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/datamanager/AbsGetStorageMethodIDL$GetStorageParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/datamanager/AbsGetStorageMethodIDL$GetStorageResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIStorageGetMethodV2 extends AbsGetStorageMethodIDL {
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AIStorageGetMethodV2() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsGetStorageMethodIDL.a r13 = (AbsGetStorageMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        if (r13.getGroupId().length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        h.a.a(r12, "no group id", null, null, 14);
        return;
    L9:
        b r14 = a.b(r10, r13);
        if (r14 != null) goto L12;
        h.a.a(r12, "no find AiContainer", null, null, 14);
        return;
    L12:
        String r15 = r14.c(r13.getStorageId(), r13.isPersist(), r13.getKey(), r13.getValue());
        Intrinsics.checkNotNullParameter(AbsGetStorageMethodIDL.b.class, "<this>");
        BaseModel r16 = c.a(AbsGetStorageMethodIDL.b.class);
        ((AbsGetStorageMethodIDL.b) r16).setData(r15);
        r12.b((ResultModel) r16, "");
        return;
    L5:
        r0 = false;
        goto L7
    }
}
