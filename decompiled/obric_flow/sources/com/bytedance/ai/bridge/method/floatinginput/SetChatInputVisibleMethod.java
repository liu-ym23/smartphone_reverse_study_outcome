package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m1.j;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/SetChatInputVisibleMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsChatInputVisibleMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsChatInputVisibleMethodIDL$SetChatInputVisibleParamModal;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsChatInputVisibleMethodIDL$SetChatInputVisibleResultModal;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/floatinginput/AbsChatInputVisibleMethodIDL$SetChatInputVisibleParamModal;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SetChatInputVisibleMethod extends AbsChatInputVisibleMethodIDL {
    public SetChatInputVisibleMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, f r11) {
        handle(r5, (AbsChatInputVisibleMethodIDL.SetChatInputVisibleParamModal) r10, r11);
    }

    public void handle(n1.c r5, AbsChatInputVisibleMethodIDL.SetChatInputVisibleParamModal r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        fj.a.d(this, r5);
        StringBuilder r12 = new StringBuilder("unsupported container type ");
        j r13 = (j) ((n1.a) r5).b(j.class);
        if (r13 == null) goto L5;
        ContainerType r14 = r13.d();
    L6:
        r12.append(r14);
        r11.a(r12.toString());
        return;
    L5:
        r14 = null;
        goto L6
    }
}
