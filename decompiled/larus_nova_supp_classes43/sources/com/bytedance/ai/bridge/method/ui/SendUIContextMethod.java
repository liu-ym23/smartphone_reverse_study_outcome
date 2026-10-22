package com.bytedance.ai.bridge.method.ui;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.contianer.m;
import d3.a0;
import e3.d;
import f3.h;
import k2.j;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/SendUIContextMethod;", "Lcom/bytedance/ai/bridge/method/ui/AbsSendUIContextMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/ui/AbsSendUIContextMethodIDL$SendUIContextParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/ui/AbsSendUIContextMethodIDL$SendUIContextResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendUIContextMethod extends AbsSendUIContextMethodIDL {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContainerType.values().length];
            r0[ContainerType.WIDGET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ContainerType.PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public SendUIContextMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsSendUIContextMethodIDL.a r13 = (AbsSendUIContextMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r0 = r10.getContainerContext();
        if (r0 == null) goto L5;
        ContainerType r1 = r0.getContainerType();
    L6:
        if (r1 != null) goto L8;
        int r14 = -1;
    L10:
        if (r14 != 1) goto L12;
        WidgetContainer r15 = (WidgetContainer) r10.d(WidgetContainer.class);
        if (r15 == null) goto L28;
        String r16 = r13.getUiContext();
        m r17 = r15.g;
        if (r17 == null) goto L27;
        String r18 = r17.e;
        if (r18 == null) goto L27;
        r4.h r19 = r4.a.l;
        if (r19 == null) goto L27;
        r19.b(r18, r16);
    L27:
        Intrinsics.checkNotNullParameter(AbsSendUIContextMethodIDL.b.class, "<this>");
        r12.b((ResultModel) c.a(AbsSendUIContextMethodIDL.b.class), "");
        return;
    L28:
        h.a.a(r12, "can not find the widget", null, null, 14);
        return;
    L12:
        if (r14 == 2) goto L14;
        h.a.a(r12, "MUST invoke applet.sendUIContext in page and widget.", null, null, 14);
        return;
    L14:
        j r20 = (j) r10.d(j.class);
        if (r20 == null) goto L17;
        r20.setUiContext(r13.getUiContext());
        Intrinsics.checkNotNullParameter(AbsSendUIContextMethodIDL.b.class, "<this>");
        r12.b((ResultModel) c.a(AbsSendUIContextMethodIDL.b.class), "");
        return;
    L17:
        h.a.a(r12, "can not find the page view", null, null, 14);
        return;
    L8:
        r14 = a.a[r1.ordinal()];
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
