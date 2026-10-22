package com.bytedance.ai.bridge.method.ui;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/AIBridgeSetTitleMethod;", "Lcom/bytedance/ai/bridge/method/ui/AbsAIBridgeSetTitleMethodIDL;", "<init>", "()V", "", "mustRunInMain", "()Z", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/ui/AbsAIBridgeSetTitleMethodIDL$SetTitleParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/ui/AbsAIBridgeSetTitleMethodIDL$SetTitleResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/ui/AbsAIBridgeSetTitleMethodIDL$SetTitleParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIBridgeSetTitleMethod extends AbsAIBridgeSetTitleMethodIDL {
    public AIBridgeSetTitleMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsAIBridgeSetTitleMethodIDL.SetTitleParamModel) r10, r11);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public boolean mustRunInMain() {
        return true;
    }

    public void handle(c r5, AbsAIBridgeSetTitleMethodIDL.SetTitleParamModel r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        w0.f r12 = (w0.f) ((n1.a) r5).b(w0.f.class);
        if (r12 == null) goto L6;
        r12.b();
        r11.a("Failed to get View");
        Intrinsics.checkNotNullParameter(AbsAIBridgeSetTitleMethodIDL.SetTitleResultModel.class, "<this>");
        r11.b((ResultModel) e.c(AbsAIBridgeSetTitleMethodIDL.SetTitleResultModel.class), "");
        return;
    L6:
        r11.a("Failed to get View");
    }
}
