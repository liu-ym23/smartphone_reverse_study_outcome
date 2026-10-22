package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import d3.a0;
import f3.h;
import k2.j;
import k2.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/RedirectInputMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsRedirectInputMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsRedirectInputMethodIDL$RedirectInputParamModal;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsRedirectInputMethodIDL$RedirectInputResultModal;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RedirectInputMethod extends AbsRedirectInputMethodIDL {
    public RedirectInputMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, h r12) {
        AbsRedirectInputMethodIDL.a r13 = (AbsRedirectInputMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        boolean r14 = r13.getEnabled();
        a0 r0 = r10.getContainerContext();
        if (r0 == null) goto L5;
        ContainerType r1 = r0.getContainerType();
    L7:
        if (r1 != ContainerType.PAGE) goto L35;
        j r15 = (j) r10.d(j.class);
        if (r15 == null) goto L13;
        PageInfo r16 = r15.getPageInfo();
        if (r16 == null) goto L13;
        PageType r17 = r16.getPageType();
    L15:
        if (r17 == PageType.FULL_PAGE) goto L31;
        if (r15 == null) goto L20;
        PageInfo r18 = r15.getPageInfo();
        if (r18 == null) goto L20;
        PageType r19 = r18.getPageType();
    L22:
        if (r19 == PageType.POPUP_PAGE) goto L31;
        StringBuilder r20 = new StringBuilder("unsupported page type ");
        if (r15 == null) goto L29;
        PageInfo r21 = r15.getPageInfo();
        if (r21 == null) goto L29;
        PageType r22 = r21.getPageType();
    L30:
        r20.append(r22);
        h.a.a(r12, r20.toString(), null, null, 14);
        return;
    L29:
        r22 = null;
    L20:
        r19 = null;
    L31:
        t r23 = r15.getFloatingSpeakerController();
        if (r23 == null) goto L34;
        r23.m(r14);
    L34:
        Intrinsics.checkNotNullParameter(AbsRedirectInputMethodIDL.b.class, "<this>");
        r12.b((ResultModel) k3.c.a(AbsRedirectInputMethodIDL.b.class), "");
        return;
    L13:
        r17 = null;
        goto L15
    L35:
        StringBuilder r24 = new StringBuilder("unsupported container type ");
        a0 r25 = r10.getContainerContext();
        if (r25 == null) goto L38;
        ContainerType r26 = r25.getContainerType();
    L39:
        r24.append(r26);
        h.a.a(r12, r24.toString(), null, null, 14);
        return;
    L38:
        r26 = null;
        goto L39
    L5:
        r1 = null;
        goto L7
    }
}
