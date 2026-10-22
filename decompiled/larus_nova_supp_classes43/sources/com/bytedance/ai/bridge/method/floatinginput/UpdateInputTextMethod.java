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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/UpdateInputTextMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateInputTextMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateInputTextMethodIDL$UpdateInputTextParamModal;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateInputTextMethodIDL$UpdateInputTextResultModal;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateInputTextMethod extends AbsUpdateInputTextMethodIDL {
    public UpdateInputTextMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, h r12) {
        AbsUpdateInputTextMethodIDL.a r13 = (AbsUpdateInputTextMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r0 = r10.getContainerContext();
        if (r0 == null) goto L5;
        ContainerType r1 = r0.getContainerType();
    L7:
        if (r1 != ContainerType.PAGE) goto L35;
        j r14 = (j) r10.d(j.class);
        if (r14 == null) goto L13;
        PageInfo r15 = r14.getPageInfo();
        if (r15 == null) goto L13;
        PageType r16 = r15.getPageType();
    L15:
        if (r16 == PageType.FULL_PAGE) goto L31;
        if (r14 == null) goto L20;
        PageInfo r17 = r14.getPageInfo();
        if (r17 == null) goto L20;
        PageType r18 = r17.getPageType();
    L22:
        if (r18 == PageType.POPUP_PAGE) goto L31;
        StringBuilder r19 = new StringBuilder("unsupported page type ");
        if (r14 == null) goto L29;
        PageInfo r20 = r14.getPageInfo();
        if (r20 == null) goto L29;
        PageType r21 = r20.getPageType();
    L30:
        r19.append(r21);
        h.a.a(r12, r19.toString(), null, null, 14);
        return;
    L29:
        r21 = null;
    L20:
        r18 = null;
    L31:
        t r22 = r14.getFloatingSpeakerController();
        if (r22 == null) goto L34;
        r22.d(r13.getText(), r13.getMode());
    L34:
        Intrinsics.checkNotNullParameter(AbsUpdateInputTextMethodIDL.b.class, "<this>");
        r12.b((ResultModel) k3.c.a(AbsUpdateInputTextMethodIDL.b.class), "");
        return;
    L13:
        r16 = null;
        goto L15
    L35:
        StringBuilder r23 = new StringBuilder("unsupported container type ");
        a0 r24 = r10.getContainerContext();
        if (r24 == null) goto L38;
        ContainerType r25 = r24.getContainerType();
    L39:
        r23.append(r25);
        h.a.a(r12, r23.toString(), null, null, 14);
        return;
    L38:
        r25 = null;
        goto L39
    L5:
        r1 = null;
        goto L7
    }
}
