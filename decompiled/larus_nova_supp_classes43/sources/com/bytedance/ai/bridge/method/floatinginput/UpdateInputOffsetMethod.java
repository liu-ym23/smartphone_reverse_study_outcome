package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.utils.o;
import d3.a0;
import f3.h;
import k2.j;
import k2.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/UpdateInputOffsetMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateInputOffsetMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateInputOffsetMethodIDL$UpdateInputOffsetParamModal;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateInputOffsetMethodIDL$UpdateInputOffsetResultModal;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateInputOffsetMethod extends AbsUpdateInputOffsetMethodIDL {
    public UpdateInputOffsetMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, h r12) {
        AbsUpdateInputOffsetMethodIDL.a r13 = (AbsUpdateInputOffsetMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        j r0 = a.a(this, r10);
        if (r13.getOffset() >= 0) goto L5;
        int r14 = 0;
    L6:
        if (r0 == null) goto L10;
        t r1 = r0.getFloatingSpeakerController();
        if (r1 == null) goto L10;
        r1.i(o.a(r14));
        Intrinsics.checkNotNullParameter(AbsUpdateInputOffsetMethodIDL.b.class, "<this>");
        r12.b((ResultModel) k3.c.a(AbsUpdateInputOffsetMethodIDL.b.class), "");
        return;
    L10:
        StringBuilder r15 = new StringBuilder("unsupported container type ");
        a0 r16 = r10.getContainerContext();
        if (r16 == null) goto L13;
        ContainerType r17 = r16.getContainerType();
    L14:
        r15.append(r17);
        h.a.a(r12, r15.toString(), null, null, 14);
        return;
    L13:
        r17 = null;
        goto L14
    L5:
        r14 = r13.getOffset();
        goto L6
    }
}
