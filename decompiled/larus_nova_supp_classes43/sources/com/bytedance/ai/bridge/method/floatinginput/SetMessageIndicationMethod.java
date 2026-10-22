package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.utils.g;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/SetMessageIndicationMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetMessageIndicationMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetMessageIndicationMethodIDL$SetMessageIndicationParamModal;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetMessageIndicationMethodIDL$SetMessageIndicationResultModal;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetMessageIndicationMethod extends AbsSetMessageIndicationMethodIDL {
    public SetMessageIndicationMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, h r12) {
        AbsSetMessageIndicationMethodIDL.a r13 = (AbsSetMessageIndicationMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g.a.d("FloatingSpeaker", this.a + "  " + r13.getBotId() + ' ' + r13.getSend() + ' ' + r13.getReceive());
        r4.h r0 = r4.a.l;
        if (r0 != null) goto L5;
        h.a.a(r12, "host message service is unavailable", null, null, 14);
        return;
    L5:
        RefType r1 = RefType.NORMAL;
        Object r14 = r10.d(e.class);
        if (r14 != null) goto L8;
        r14 = new e(r10);
        r10.b(e.class, r14, r1);
    L8:
        ((e) r14).update(r13.getBotId(), r13.getSend(), r13.getReceive());
        r0.k(r13.getBotId(), r13.getConversationId());
        Intrinsics.checkNotNullParameter(AbsSetMessageIndicationMethodIDL.b.class, "<this>");
        r12.b((ResultModel) k3.c.a(AbsSetMessageIndicationMethodIDL.b.class), "");
    }
}
