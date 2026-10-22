package com.bytedance.ai.bridge.method.tts;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.method.floatinginput.AbsCancelTTSMethodIDL;
import com.bytedance.ai.bridge.method.floatinginput.a;
import d3.a0;
import e3.d;
import f3.h;
import k2.j;
import k2.t;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/tts/CancelTTSMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsCancelTTSMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsCancelTTSMethodIDL$CancelTTSParamModal;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsCancelTTSMethodIDL$CancelTTSResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CancelTTSMethod extends AbsCancelTTSMethodIDL {
    public CancelTTSMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsCancelTTSMethodIDL.a) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        j r13 = a.a(this, r10);
        if (r13 == null) goto L7;
        t r14 = r13.getFloatingSpeakerController();
        if (r14 == null) goto L7;
        r14.b();
        Intrinsics.checkNotNullParameter(AbsCancelTTSMethodIDL.b.class, "<this>");
        r12.b((ResultModel) c.a(AbsCancelTTSMethodIDL.b.class), "");
        return;
    L7:
        StringBuilder r15 = new StringBuilder("unsupported container type ");
        a0 r16 = r10.getContainerContext();
        if (r16 == null) goto L10;
        ContainerType r17 = r16.getContainerType();
    L11:
        r15.append(r17);
        h.a.a(r12, r15.toString(), null, null, 14);
        return;
    L10:
        r17 = null;
        goto L11
    }
}
