package com.bytedance.ai.bridge.method.resource;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import e3.d;
import f2.b;
import f3.h;
import h2.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/resource/UpdatePackageMethod;", "Lcom/bytedance/ai/bridge/method/resource/AbsUpdatePackageMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/resource/AbsUpdatePackageMethodIDL$UpdatePackageParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/resource/AbsUpdatePackageMethodIDL$UpdatePackageResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdatePackageMethod extends AbsUpdatePackageMethodIDL {
    public UpdatePackageMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsUpdatePackageMethodIDL.a r13 = (AbsUpdatePackageMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a r14 = b.c;
        if (r14 != null) goto L5;
    L13:
        h.a.a(r12, "AISDK is NOT initialized", null, null, 14);
        Unit r15 = Unit.INSTANCE;
        return;
    L5:
        if (r14.k == false) goto L7;
    L11:
        Unit r16 = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new UpdatePackageMethod$handle$1$1(r13, r12, null), 3, null);
    L12:
        if (r16 == null) goto L13;
        return;
    L7:
        if (r14.l == true) goto L11;
        if (CollectionsKt.listOf(new String[]{"inhouse", "auto_test"}).contains(r14.h) == true) goto L11;
        h.a.a(r12, "current bridge is not allowed in release mode", null, null, 14);
        r16 = Unit.INSTANCE;
        goto L12
    }
}
