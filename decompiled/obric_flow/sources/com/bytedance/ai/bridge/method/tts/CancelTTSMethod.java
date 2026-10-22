package com.bytedance.ai.bridge.method.tts;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.method.floatinginput.AbsCancelTTSMethodIDL;
import com.lynx.jsbridge.LynxResourceModule;
import fj.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m1.j;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/tts/CancelTTSMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsCancelTTSMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsCancelTTSMethodIDL$CancelTTSParamModal;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsCancelTTSMethodIDL$CancelTTSResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/floatinginput/AbsCancelTTSMethodIDL$CancelTTSParamModal;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CancelTTSMethod extends AbsCancelTTSMethodIDL {
    public CancelTTSMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsCancelTTSMethodIDL.CancelTTSParamModal) r10, r11);
    }

    public void handle(c r5, AbsCancelTTSMethodIDL.CancelTTSParamModal r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        a.d(this, r5);
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
