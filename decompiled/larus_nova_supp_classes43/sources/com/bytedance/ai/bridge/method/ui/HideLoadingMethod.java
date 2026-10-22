package com.bytedance.ai.bridge.method.ui;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.bridge.system.ui.AbsHideLoadingMethodIDL;
import e3.a;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/HideLoadingMethod;", "Lcom/bytedance/ai/bridge/system/ui/AbsHideLoadingMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/ui/AbsHideLoadingMethodIDL$HideInteractionParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/ui/AbsHideLoadingMethodIDL$EmptyMessageModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HideLoadingMethod extends AbsHideLoadingMethodIDL {
    public HideLoadingMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsHideLoadingMethodIDL.b) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Boolean r0 = null;
        if ((r10 instanceof a) == false) goto L5;
        a r13 = (a) r10;
    L6:
        IHostStyleUIDepend r14 = r4.a.e;
        if (r14 == null) goto L10;
        r0 = r14.hideLoading(r13);
    L10:
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L12;
    L12:
        Intrinsics.checkNotNullParameter(AbsHideLoadingMethodIDL.a.class, "<this>");
        r12.b((ResultModel) c.a(AbsHideLoadingMethodIDL.a.class), "");
        return;
    L5:
        r13 = null;
        goto L6
    }
}
