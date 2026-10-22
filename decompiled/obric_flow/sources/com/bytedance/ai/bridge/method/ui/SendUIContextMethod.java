package com.bytedance.ai.bridge.method.ui;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.p;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m1.j;
import n1.c;
import o1.f;
import t0.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/SendUIContextMethod;", "Lcom/bytedance/ai/bridge/method/ui/AbsSendUIContextMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/ui/AbsSendUIContextMethodIDL$SendUIContextParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/ui/AbsSendUIContextMethodIDL$SendUIContextResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/ui/AbsSendUIContextMethodIDL$SendUIContextParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SendUIContextMethod extends AbsSendUIContextMethodIDL {
    public SendUIContextMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsSendUIContextMethodIDL.SendUIContextParamModel) r10, r11);
    }

    public void handle(c r10, AbsSendUIContextMethodIDL.SendUIContextParamModel r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        n1.a r13 = (n1.a) r10;
        j r5 = (j) r13.b(j.class);
        String r14 = null;
        if (r5 == null) goto L5;
        ContainerType r15 = r5.d();
    L6:
        if (r15 != null) goto L8;
        int r16 = -1;
    L10:
        if (r16 == 1) goto L31;
        if (r16 == 2) goto L15;
        r12.a("MUST invoke " + getName() + " in page and widget.");
        return;
    L15:
        w0.f r17 = (w0.f) r13.b(w0.f.class);
        if (r17 == null) goto L28;
        r11.getUiContext();
        com.bytedance.ai.model.widgets.a r18 = (com.bytedance.ai.model.widgets.a) r17;
        r18.f2330b.getMessageId();
        b r19 = p.f2294c;
        if (r19 == null) goto L26;
        AppletRuntime r20 = r18.f2329a;
        String r21 = r20.f2197h.I;
        if (r21 == null) goto L25;
        ConcurrentHashMap r22 = o2.a.f20402a;
        Intrinsics.checkNotNullParameter(r21, "<this>");
        if (r21.length() == 0) goto L25;
        r14 = (String) o2.a.f20402a.get(r21);
    L25:
        r19.onAppletPayloadChanged(r14, r20.f2197h.I);
    L26:
        Intrinsics.checkNotNullParameter(AbsSendUIContextMethodIDL.SendUIContextResultModel.class, "<this>");
        r12.b((ResultModel) e.c(AbsSendUIContextMethodIDL.SendUIContextResultModel.class), "");
        return;
    L28:
        r12.a("can not find the page view");
        return;
    L31:
        if (((WidgetContainer) r13.b(WidgetContainer.class)) == null) goto L34;
        r11.getUiContext();
        Intrinsics.checkNotNullParameter(AbsSendUIContextMethodIDL.SendUIContextResultModel.class, "<this>");
        r12.b((ResultModel) e.c(AbsSendUIContextMethodIDL.SendUIContextResultModel.class), "");
        return;
    L34:
        r12.a("can not find the widget");
        return;
    L8:
        r16 = g2.b.f17018a[r15.ordinal()];
        goto L10
    L5:
        r15 = null;
        goto L6
    }
}
