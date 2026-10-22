package com.bytedance.ai.bridge.method.ui;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import d3.a0;
import e3.d;
import f3.h;
import k2.j;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/HandleContentSizeChangeMethod;", "Lcom/bytedance/ai/bridge/method/ui/AbsHandleContextSizeChangeMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/ui/AbsHandleContextSizeChangeMethodIDL$HandleContextSizeChangedParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/ui/AbsHandleContextSizeChangeMethodIDL$HandleContextSizeChangedResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HandleContentSizeChangeMethod extends AbsHandleContextSizeChangeMethodIDL {
    public HandleContentSizeChangeMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsHandleContextSizeChangeMethodIDL.a r13 = (AbsHandleContextSizeChangeMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r0 = r10.getContainerContext();
        if (r0 == null) goto L5;
        ContainerType r1 = r0.getContainerType();
    L7:
        if (r1 != ContainerType.WIDGET) goto L12;
        WidgetContainer r14 = (WidgetContainer) r10.d(WidgetContainer.class);
        if (r14 == null) goto L11;
        r14.handleContentSizeChange(r13.getWidth(), r13.getHeight());
        Intrinsics.checkNotNullParameter(AbsHandleContextSizeChangeMethodIDL.b.class, "<this>");
        r12.b((ResultModel) c.a(AbsHandleContextSizeChangeMethodIDL.b.class), "");
        return;
    L11:
        h.a.a(r12, "can not find the widget container", null, null, 14);
        return;
    L12:
        a0 r15 = r10.getContainerContext();
        if (r15 == null) goto L15;
        ContainerType r16 = r15.getContainerType();
    L17:
        if (r16 != ContainerType.PAGE) goto L22;
        j r17 = (j) r10.d(j.class);
        if (r17 == null) goto L21;
        r17.handleContentSizeChange(r13.getWidth(), r13.getHeight());
        Intrinsics.checkNotNullParameter(AbsHandleContextSizeChangeMethodIDL.b.class, "<this>");
        r12.b((ResultModel) c.a(AbsHandleContextSizeChangeMethodIDL.b.class), "");
        return;
    L21:
        h.a.a(r12, "can not find the container", null, null, 14);
        return;
    L22:
        h.a.a(r12, "can not handle this container type", null, null, 14);
        return;
    L15:
        r16 = null;
        goto L17
    L5:
        r1 = null;
        goto L7
    }
}
