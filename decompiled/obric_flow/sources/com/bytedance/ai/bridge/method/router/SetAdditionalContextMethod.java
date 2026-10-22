package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/SetAdditionalContextMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsSetAdditionalContextMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/router/AbsSetAdditionalContextMethodIDL$SetAdditionalContextParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/router/AbsSetAdditionalContextMethodIDL$SetAdditionalContextResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/router/AbsSetAdditionalContextMethodIDL$SetAdditionalContextParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SetAdditionalContextMethod extends AbsSetAdditionalContextMethodIDL {
    public SetAdditionalContextMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, o1.f r11) {
        handle(r5, (AbsSetAdditionalContextMethodIDL.SetAdditionalContextParamModel) r10, r11);
    }

    public void handle(n1.c r10, AbsSetAdditionalContextMethodIDL.SetAdditionalContextParamModel r11, o1.f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        String r13 = r11.getBotId() + ' ' + r11.getAdditionalContext();
        Intrinsics.checkNotNullParameter("SetAdditionalContextMethod", "tag");
        t0.d r5 = com.bytedance.ai.utils.c.f2846a;
        if (r5 == null) goto L5;
        r5.d("SetAdditionalContextMethod", r13);
    L5:
        n1.a r14 = (n1.a) r10;
        m1.j r15 = (m1.j) r14.b(m1.j.class);
        String r16 = null;
        if (r15 == null) goto L8;
        ContainerType r17 = r15.d();
    L9:
        if (r17 != null) goto L11;
        int r18 = -1;
    L13:
        if (r18 != 1) goto L15;
        AppletRuntime r19 = (AppletRuntime) r14.b(AppletRuntime.class);
        if (r19 == null) goto L47;
        r11.getAdditionalContext();
        r19.q(r11.getBotId());
        Intrinsics.checkNotNullParameter(AbsSetAdditionalContextMethodIDL.SetAdditionalContextResultModel.class, "<this>");
        r12.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsSetAdditionalContextMethodIDL.SetAdditionalContextResultModel.class), "");
        return;
    L47:
        r12.a("Failed to get AppletRuntime");
        return;
    L15:
        if (r18 != 2) goto L17;
        WidgetContainer r20 = (WidgetContainer) r14.b(WidgetContainer.class);
        if (r20 == null) goto L41;
        String r21 = r11.getAdditionalContext();
        String r22 = r11.getBotId();
        Intrinsics.checkNotNullParameter(r21, "ctx");
        ConcurrentHashMap r23 = r20.f3028o;
        if (r22 != null) goto L36;
        com.bytedance.ai.widget.contianer.h r24 = r20.f;
        if (r24 == null) goto L33;
        r16 = r24.d;
    L33:
        if (r16 != null) goto L35;
        r22 = r20.f3029p;
        goto L36
    L35:
        r22 = r16;
    L36:
        r23.put(r22, r21);
        Function1 r25 = r20.f3030q;
        if (r25 == null) goto L39;
        r25.invoke(r20);
    L39:
        Intrinsics.checkNotNullParameter(AbsSetAdditionalContextMethodIDL.SetAdditionalContextResultModel.class, "<this>");
        r12.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsSetAdditionalContextMethodIDL.SetAdditionalContextResultModel.class), "");
        return;
    L41:
        r12.a("Failed to get WidgetContainer");
        return;
    L17:
        if (r18 == 3) goto L20;
        r12.a("container type error");
        return;
    L20:
        w0.f r26 = (w0.f) r14.b(w0.f.class);
        if (r26 == null) goto L24;
        BuildersKt.launch$default(h0.a(t2.b.f22089a), null, null, new SetAdditionalContextMethod$handle$3$1(r26, r11, r12, null), 3, null);
        return;
    L24:
        r12.a("Failed to get AIContainerView");
        return;
    L11:
        r18 = n.f1965a[r17.ordinal()];
        goto L13
    L8:
        r17 = null;
        goto L9
    }
}
