package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.model.objects.PageType;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m1.j;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/GetInputModeMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsGetInputModeMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsGetInputModeMethodIDL$GetInputModeParamModal;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsGetInputModeMethodIDL$GetInputModeResultModal;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/floatinginput/AbsGetInputModeMethodIDL$GetInputModeParamModal;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GetInputModeMethod extends AbsGetInputModeMethodIDL {
    public GetInputModeMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, f r11) {
        handle(r5, (AbsGetInputModeMethodIDL.GetInputModeParamModal) r10, r11);
    }

    public void handle(n1.c r5, AbsGetInputModeMethodIDL.GetInputModeParamModal r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        n1.a r12 = (n1.a) r5;
        j r13 = (j) r12.b(j.class);
        ContainerType r14 = null;
        if (r13 == null) goto L5;
        ContainerType r15 = r13.d();
    L7:
        if (r15 != ContainerType.f1801c) goto L21;
        w0.f r16 = (w0.f) r12.b(w0.f.class);
        if (r16 != null) goto L12;
        r11.a("aicontainer is null");
        return;
    L12:
        com.bytedance.ai.model.widgets.a r17 = (com.bytedance.ai.model.widgets.a) r16;
        if (r17.f2330b.getPageType() != PageType.FULL_PAGE) goto L15;
    L19:
        r11.a("floating speaker controller is null");
        return;
    L15:
        if (r17.f2330b.getPageType() == PageType.POPUP_PAGE) goto L19;
        r11.a("unsupported page type " + r17.f2330b.getPageType());
        return;
    L21:
        StringBuilder r18 = new StringBuilder("unsupported container type ");
        j r19 = (j) r12.b(j.class);
        if (r19 == null) goto L24;
        r14 = r19.d();
    L24:
        r18.append(r14);
        r11.a(r18.toString());
        return;
    L5:
        r15 = null;
        goto L7
    }
}
