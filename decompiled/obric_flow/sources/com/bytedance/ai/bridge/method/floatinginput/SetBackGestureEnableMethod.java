package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m1.j;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/SetBackGestureEnableMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetBackGestureEnableMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetBackGestureEnableMethodIDL$SetBackGestureEnableParamModal;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetBackGestureEnableMethodIDL$SetBackGestureEnableResultModal;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/floatinginput/AbsSetBackGestureEnableMethodIDL$SetBackGestureEnableParamModal;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SetBackGestureEnableMethod extends AbsSetBackGestureEnableMethodIDL {
    public SetBackGestureEnableMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, f r11) {
        handle(r5, (AbsSetBackGestureEnableMethodIDL.SetBackGestureEnableParamModal) r10, r11);
    }

    public void handle(n1.c r5, AbsSetBackGestureEnableMethodIDL.SetBackGestureEnableParamModal r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        r10.getEnabled();
        n1.a r12 = (n1.a) r5;
        j r13 = (j) r12.b(j.class);
        Object r14 = null;
        if (r13 == null) goto L5;
        ContainerType r15 = r13.d();
    L7:
        if (r15 != ContainerType.f1801c) goto L33;
        w0.f r16 = (w0.f) r12.b(w0.f.class);
        if (r16 == null) goto L13;
        PageInfo r17 = ((com.bytedance.ai.model.widgets.a) r16).f2330b;
        if (r17 == null) goto L13;
        PageType r18 = r17.getPageType();
    L15:
        if (r18 == PageType.FULL_PAGE) goto L31;
        if (r16 == null) goto L20;
        PageInfo r19 = ((com.bytedance.ai.model.widgets.a) r16).f2330b;
        if (r19 == null) goto L20;
        PageType r20 = r19.getPageType();
    L22:
        if (r20 == PageType.POPUP_PAGE) goto L31;
        StringBuilder r21 = new StringBuilder("unsupported page type ");
        if (r16 == null) goto L29;
        PageInfo r22 = ((com.bytedance.ai.model.widgets.a) r16).f2330b;
        if (r22 == null) goto L29;
        r14 = r22.getPageType();
    L29:
        r21.append(r14);
        r11.a(r21.toString());
        return;
    L20:
        r20 = null;
    L31:
        r16.getClass();
        Intrinsics.checkNotNullParameter(AbsSetBackGestureEnableMethodIDL.SetBackGestureEnableResultModal.class, "<this>");
        r11.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsSetBackGestureEnableMethodIDL.SetBackGestureEnableResultModal.class), "");
        return;
    L13:
        r18 = null;
        goto L15
    L33:
        StringBuilder r23 = new StringBuilder("unsupported container type ");
        j r24 = (j) r12.b(j.class);
        if (r24 == null) goto L36;
        r14 = r24.d();
    L36:
        r23.append(r14);
        r11.a(r23.toString());
        return;
    L5:
        r15 = null;
        goto L7
    }
}
