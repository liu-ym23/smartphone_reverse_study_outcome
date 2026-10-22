package com.bytedance.ai.bridge.method.floating;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.utils.g;
import e3.d;
import f3.h;
import i2.f;
import i2.i;
import i2.j;
import k2.s;
import k3.c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/floating/DisplayFloatingMaskMethod;", "Lcom/bytedance/ai/bridge/method/floating/AbsDisplayFloatingMaskMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/floating/AbsDisplayFloatingMaskMethodIDL$DisplayFloatingMaskParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/floating/AbsDisplayFloatingMaskMethodIDL$DisplayFloatingMaskResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DisplayFloatingMaskMethod extends AbsDisplayFloatingMaskMethodIDL {
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public DisplayFloatingMaskMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsDisplayFloatingMaskMethodIDL.a r13 = (AbsDisplayFloatingMaskMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r14 = g.a;
        String r0 = r13.getViewId();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r14.i("DisplayFloatingMaskMethod", "display floating mask method ".concat(r0));
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
        i r19 = i.a.a();
        boolean r20 = r13.getShow();
        r19.getClass();
        Intrinsics.checkNotNullParameter(r15, "viewId");
        Lazy<f> r21 = f.i;
        if (f.a.a().n(r15, r20) == false) goto L16;
        Intrinsics.checkNotNullParameter(AbsDisplayFloatingMaskMethodIDL.b.class, "<this>");
        r12.b((ResultModel) c.a(AbsDisplayFloatingMaskMethodIDL.b.class), "");
        return;
    L16:
        h.a.a(r12, "displayFloatingMask failed", null, null, 14);
        return;
    L17:
        h.a.a(r12, "viewId or current floating is null", null, null, 14);
    }
}
