package com.bytedance.ai.bridge.method.ui;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m1.j;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/HandleContentSizeChangeMethod;", "Lcom/bytedance/ai/bridge/method/ui/AbsHandleContextSizeChangeMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/ui/AbsHandleContextSizeChangeMethodIDL$HandleContextSizeChangedParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/ui/AbsHandleContextSizeChangeMethodIDL$HandleContextSizeChangedResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/ui/AbsHandleContextSizeChangeMethodIDL$HandleContextSizeChangedParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HandleContentSizeChangeMethod extends AbsHandleContextSizeChangeMethodIDL {
    public HandleContentSizeChangeMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsHandleContextSizeChangeMethodIDL.HandleContextSizeChangedParamModel) r10, r11);
    }

    public void handle(c r10, AbsHandleContextSizeChangeMethodIDL.HandleContextSizeChangedParamModel r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        n1.a r13 = (n1.a) r10;
        j r5 = (j) r13.b(j.class);
        ContainerType r14 = null;
        if (r5 == null) goto L5;
        ContainerType r15 = r5.d();
    L7:
        if (r15 != ContainerType.f1800b) goto L14;
        WidgetContainer r16 = (WidgetContainer) r13.b(WidgetContainer.class);
        if (r16 == null) goto L12;
        r16.c(r11.getWidth(), r11.getHeight());
        Intrinsics.checkNotNullParameter(AbsHandleContextSizeChangeMethodIDL.HandleContextSizeChangedResultModel.class, "<this>");
        r12.b((ResultModel) e.c(AbsHandleContextSizeChangeMethodIDL.HandleContextSizeChangedResultModel.class), "");
        return;
    L12:
        r12.a("can not find the widget container");
        return;
    L14:
        j r17 = (j) r13.b(j.class);
        if (r17 == null) goto L18;
        r14 = r17.d();
    L18:
        if (r14 != ContainerType.f1801c) goto L25;
        w0.f r18 = (w0.f) r13.b(w0.f.class);
        if (r18 == null) goto L23;
        r18.c(r11.getWidth(), r11.getHeight());
        Intrinsics.checkNotNullParameter(AbsHandleContextSizeChangeMethodIDL.HandleContextSizeChangedResultModel.class, "<this>");
        r12.b((ResultModel) e.c(AbsHandleContextSizeChangeMethodIDL.HandleContextSizeChangedResultModel.class), "");
        return;
    L23:
        r12.a("can not find the container");
        return;
    L25:
        r12.a("can not handle this container type");
        return;
    L5:
        r15 = null;
        goto L7
    }
}
