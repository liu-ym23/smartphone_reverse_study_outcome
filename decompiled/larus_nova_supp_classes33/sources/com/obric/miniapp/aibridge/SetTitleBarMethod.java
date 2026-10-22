package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/miniapp/aibridge/SetTitleBarMethod;", "Lcom/obric/miniapp/aibridge/AbsSetTitleBarMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsSetTitleBarMethodIDL$SetTitleBarTitleParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsSetTitleBarMethodIDL$SetTitleBarTitleResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetTitleBarMethod extends AbsSetTitleBarMethodIDL {
    public SetTitleBarMethod() {
    }

    public final void handle(e3.d r6, ParamModel r7, f3.h r8) {
        AbsSetTitleBarMethodIDL.a r9 = (AbsSetTitleBarMethodIDL.a) r7;
        Intrinsics.checkNotNullParameter(r6, "bridgeContext");
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        k2.j r10 = (k2.j) r6.d(k2.j.class);
        if (r10 == null) goto L29;
        k2.m r11 = r10.getContainerViewService();
        if (r11 == null) goto L7;
        k2.q r12 = r11.h();
    L8:
        if (r12 == null) goto L28;
        LinkedHashMap r0 = new LinkedHashMap();
        Boolean r3 = r9.getHideTitleBar();
        if (r3 == null) goto L12;
        r0.put("hideTitleBar", Boolean.valueOf(r3.booleanValue()));
    L12:
        Boolean r4 = r9.getHideBackButton();
        if (r4 == null) goto L15;
        r0.put("hideTitleBarBackButton", Boolean.valueOf(r4.booleanValue()));
    L15:
        String r5 = r9.getTitle();
        if (r5 == null) goto L18;
        r0.put("setTitleBarTitle", r5);
    L18:
        String r13 = r9.getMode();
        if (r13 == null) goto L21;
        r0.put("setTitleBarMode", r13);
    L21:
        String r14 = r9.getBackgroundColor();
        if (r14 == null) goto L25;
        r0.put("setTitleBarBackgroundColor", r14);
    L25:
        if ((!r0.isEmpty()) == false) goto L27;
        r12.b(r0);
        Intrinsics.checkNotNullParameter(AbsSetTitleBarMethodIDL.b.class, "<this>");
        r8.b(k3.c.a(AbsSetTitleBarMethodIDL.b.class), "");
        return;
    L27:
        f3.h.a.a(r8, "settings is empty", null, null, 14);
        return;
    L28:
        f3.h.a.a(r8, "Failed to get View", null, null, 14);
        return;
    L7:
        r12 = null;
        goto L8
    L29:
        f3.h.a.a(r8, "Failed to get View", null, null, 14);
    }
}
