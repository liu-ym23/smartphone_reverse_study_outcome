package com.bytedance.ai.bridge.method.ui;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.google.gson.JsonElement;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m1.j;
import n1.c;
import o1.f;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/AIBridgeSendQueryMessageMethod;", "Lcom/bytedance/ai/bridge/method/ui/AbsSendQueryMessageMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/ui/AbsSendQueryMessageMethodIDL$SendQueryMessageParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/ui/AbsSendQueryMessageMethodIDL$SendQueryMessageResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/ui/AbsSendQueryMessageMethodIDL$SendQueryMessageParamModel;Lo1/f;)V", "Companion", "g2/a", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIBridgeSendQueryMessageMethod extends AbsSendQueryMessageMethodIDL {
    public static final g2.a Companion = null;
    private static final String TAG = "SendQueryMessageMethod";

    static {
        Companion = new g2.a();
    }

    public AIBridgeSendQueryMessageMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsSendQueryMessageMethodIDL.SendQueryMessageParamModel) r10, r11);
    }

    public void handle(c r5, AbsSendQueryMessageMethodIDL.SendQueryMessageParamModel r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        String r12 = "content=" + r10.getContent() + " type=" + r10.getType() + " ext=" + r10.getExt() + " context=" + r10.getContext();
        Intrinsics.checkNotNullParameter(TAG, "tag");
        d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L6;
        r13.i(TAG, r12);
    L6:
        if (Intrinsics.areEqual(r10.getType(), MessageIndication.CONTENT_TYPE_TEXT) == true) goto L9;
        r11.a("The '" + r10.getType() + "' type is not currently supported");
        return;
    L9:
        JsonElement r14 = r10.getContext().get("botId");
        if (r14 == null) goto L13;
        String r15 = r14.getAsString();
        if (r15 == null) goto L13;
    L14:
        n1.a r16 = (n1.a) r5;
        j r17 = (j) r16.b(j.class);
        ContainerType r18 = null;
        if (r17 == null) goto L17;
        ContainerType r19 = r17.d();
    L19:
        if (r19 != ContainerType.f1801c) goto L22;
        w0.f r20 = (w0.f) r16.b(w0.f.class);
    L22:
        if (r15.length() != 0) goto L25;
        r11.a("botId is empty");
        return;
    L25:
        j r21 = (j) r16.b(j.class);
        if (r21 == null) goto L29;
        r18 = r21.d();
    L29:
        if (r18 != ContainerType.f1800b) goto L31;
        WidgetContainer r22 = (WidgetContainer) r16.b(WidgetContainer.class);
    L31:
        r11.a("send query message error");
        return;
    L17:
        r19 = null;
    L13:
        r15 = "";
        goto L14
    }
}
