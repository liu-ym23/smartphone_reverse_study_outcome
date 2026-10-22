package com.bytedance.ai.bridge.method.ui;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.google.gson.JsonElement;
import d3.a0;
import e3.d;
import f3.h;
import k2.j;
import k2.t;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/AIBridgeSendQueryMessageMethod;", "Lcom/bytedance/ai/bridge/method/ui/AbsSendQueryMessageMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/ui/AbsSendQueryMessageMethodIDL$SendQueryMessageParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/ui/AbsSendQueryMessageMethodIDL$SendQueryMessageResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeSendQueryMessageMethod extends AbsSendQueryMessageMethodIDL {

    public static final class a {
    }

    static {
    }

    public AIBridgeSendQueryMessageMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r11, ParamModel r12, h r13) {
        AbsSendQueryMessageMethodIDL.a r14 = (AbsSendQueryMessageMethodIDL.a) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        g.a.i("SendQueryMessageMethod", "content=" + r14.getContent() + " type=" + r14.getType() + " ext=" + r14.getExt() + " context=" + r14.getContext());
        if (Intrinsics.areEqual(r14.getType(), "text") == true) goto L5;
        h.a.a(r13, "The '" + r14.getType() + "' type is not currently supported", null, null, 14);
        return;
    L5:
        JsonElement r0 = r14.getContext().get("botId");
        if (r0 == null) goto L9;
        String r1 = r0.getAsString();
        if (r1 == null) goto L9;
    L10:
        a0 r10 = r11.getContainerContext();
        if (r10 == null) goto L13;
        ContainerType r15 = r10.getContainerType();
    L15:
        if (r15 != ContainerType.PAGE) goto L21;
        j r16 = (j) r11.d(j.class);
        if (r16 == null) goto L21;
        t r17 = r16.getFloatingSpeakerController();
        if (r17 == null) goto L21;
        r1 = r17.getBotId();
    L21:
        String r18 = r1;
        if (r18.length() != 0) goto L24;
        boolean r19 = true;
    L25:
        if (r19 == false) goto L27;
        h.a.a(r13, "botId is empty", null, null, 14);
        return;
    L27:
        a0 r20 = r11.getContainerContext();
        if (r20 == null) goto L30;
        ContainerType r21 = r20.getContainerType();
    L32:
        if (r21 != ContainerType.WIDGET) goto L39;
        WidgetContainer r110 = (WidgetContainer) r11.d(WidgetContainer.class);
        if (r110 == null) goto L39;
        String r111 = r110.b;
        if (r111 == null) goto L39;
        String r22 = r111;
    L40:
        r4.h r23 = r4.a.l;
        if (r23 == null) goto L43;
        r4.h.a.a(r23, r14.getContent(), r22, r18, r14.getExt(), 16);
        Intrinsics.checkNotNullParameter(AbsSendQueryMessageMethodIDL.b.class, "<this>");
        r13.b((ResultModel) c.a(AbsSendQueryMessageMethodIDL.b.class), "");
        return;
    L43:
        h.a.a(r13, "send query message error", null, null, 14);
        return;
    L39:
        r22 = "";
        goto L40
    L30:
        r21 = null;
        goto L32
    L24:
        r19 = false;
        goto L25
    L13:
        r15 = null;
    L9:
        r1 = "";
        goto L10
    }
}
