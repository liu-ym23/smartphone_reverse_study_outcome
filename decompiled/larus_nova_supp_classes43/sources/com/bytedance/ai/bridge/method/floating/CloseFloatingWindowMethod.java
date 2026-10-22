package com.bytedance.ai.bridge.method.floating;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.floating.AbsCloseFloatingWindowMethodIDL;
import com.bytedance.ai.utils.g;
import e3.d;
import f3.h;
import i2.i;
import i2.j;
import k2.s;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/floating/CloseFloatingWindowMethod;", "Lcom/bytedance/ai/bridge/floating/AbsCloseFloatingWindowMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/floating/AbsCloseFloatingWindowMethodIDL$CloseFloatingWindowParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/floating/AbsCloseFloatingWindowMethodIDL$EmptyMessageModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CloseFloatingWindowMethod extends AbsCloseFloatingWindowMethodIDL {
    public CloseFloatingWindowMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsCloseFloatingWindowMethodIDL.a r13 = (AbsCloseFloatingWindowMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r14 = g.a;
        String r0 = r13.getViewId();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r14.i("CloseFloatingWindow", "closeFloating ".concat(r0));
        String r15 = r13.getViewId();
        if (r15 != null) goto L12;
        j r16 = i.a;
        s r17 = i.a.a().j();
        if (r17 == null) goto L10;
        r15 = r17.getPageID();
        goto L12
    L10:
        r15 = null;
    L12:
        if (r15 == null) goto L17;
        j r18 = i.a;
        if (i.a.a().g(r15) == false) goto L16;
        Intrinsics.checkNotNullParameter(AbsCloseFloatingWindowMethodIDL.b.class, "<this>");
        r12.b((ResultModel) c.a(AbsCloseFloatingWindowMethodIDL.b.class), "");
        return;
    L16:
        h.a.a(r12, "closeFloatingWidget failed", null, null, 14);
        return;
    L17:
        h.a.a(r12, "viewId or current floating is null", null, null, 14);
    }
}
