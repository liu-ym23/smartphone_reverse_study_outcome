package com.bytedance.ai.bridge.method.datamanager;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import e3.d;
import f3.h;
import java.lang.ref.WeakReference;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u4.a;
import u4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/datamanager/AIStorageUnSubscribeMethodV2;", "Lcom/bytedance/ai/bridge/method/datamanager/AbsUnSubscribeStorageMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/datamanager/AbsUnSubscribeStorageMethodIDL$UnSubscribeStorageParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/datamanager/AbsUnSubscribeStorageMethodIDL$UnSubscribeStorageResultModal;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIStorageUnSubscribeMethodV2 extends AbsUnSubscribeStorageMethodIDL {
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AIStorageUnSubscribeMethodV2() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsUnSubscribeStorageMethodIDL.a r13 = (AbsUnSubscribeStorageMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        if (r13.getGroupId().length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        h.a.a(r12, "no group id", null, null, 14);
        return;
    L10:
        if (r13.isShared() == true) goto L12;
        Intrinsics.checkNotNullParameter(AbsUnSubscribeStorageMethodIDL.b.class, "<this>");
        r12.b((ResultModel) c.a(AbsUnSubscribeStorageMethodIDL.b.class), "");
        return;
    L12:
        a r1 = s3.a.a(r10);
        if (r1 != null) goto L15;
        h.a.a(r12, "no find AiContainer", null, null, 14);
        return;
    L15:
        b r14 = s3.a.b(r10, r13);
        if (r14 != null) goto L18;
        h.a.a(r12, "no find ViewModel", null, null, 14);
        return;
    L18:
        r14.b(new u4.h(r14.d(r13.getGroupId(), r13.getStorageId()), r13.getKey(), r13.isPersist(), new WeakReference(r1)));
        Intrinsics.checkNotNullParameter(AbsUnSubscribeStorageMethodIDL.b.class, "<this>");
        r12.b((ResultModel) c.a(AbsUnSubscribeStorageMethodIDL.b.class), "");
        return;
    L5:
        r0 = false;
        goto L7
    }
}
