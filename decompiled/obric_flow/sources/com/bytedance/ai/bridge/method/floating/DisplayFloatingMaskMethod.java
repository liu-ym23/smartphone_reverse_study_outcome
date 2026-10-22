package com.bytedance.ai.bridge.method.floating;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.widgets.a;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n1.c;
import o1.f;
import t0.d;
import v0.e;
import w0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/floating/DisplayFloatingMaskMethod;", "Lcom/bytedance/ai/bridge/method/floating/AbsDisplayFloatingMaskMethodIDL;", "<init>", "()V", "", "mustRunInMain", "()Z", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/floating/AbsDisplayFloatingMaskMethodIDL$DisplayFloatingMaskParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/floating/AbsDisplayFloatingMaskMethodIDL$DisplayFloatingMaskResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/floating/AbsDisplayFloatingMaskMethodIDL$DisplayFloatingMaskParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DisplayFloatingMaskMethod extends AbsDisplayFloatingMaskMethodIDL {
    public DisplayFloatingMaskMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsDisplayFloatingMaskMethodIDL.DisplayFloatingMaskParamModel) r10, r11);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public boolean mustRunInMain() {
        return true;
    }

    public void handle(c r5, AbsDisplayFloatingMaskMethodIDL.DisplayFloatingMaskParamModel r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        String r12 = r10.getViewId();
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        String r13 = "display floating mask method ".concat(r12);
        Intrinsics.checkNotNullParameter("DisplayFloatingMaskMethod", "tag");
        d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L8;
        r14.i("DisplayFloatingMaskMethod", r13);
    L8:
        String r15 = r10.getViewId();
        if (r15 != null) goto L14;
        Lazy r16 = e.f;
        com.bytedance.android.anniex.base.service.f.g().getClass();
        k r17 = e.n();
        if (r17 == null) goto L13;
        r15 = ((a) r17).f2331c;
        goto L14
    L13:
        r15 = null;
    L14:
        if (r15 == null) goto L21;
        Lazy r18 = e.f;
        e r19 = com.bytedance.android.anniex.base.service.f.g();
        boolean r20 = r10.getShow();
        r19.getClass();
        Intrinsics.checkNotNullParameter(r15, "viewId");
        Lazy r21 = v0.d.f22502n;
        if (cl.a.h().r(r15, r20) == false) goto L19;
        Intrinsics.checkNotNullParameter(AbsDisplayFloatingMaskMethodIDL.DisplayFloatingMaskResultModel.class, "<this>");
        r11.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsDisplayFloatingMaskMethodIDL.DisplayFloatingMaskResultModel.class), "");
        return;
    L19:
        r11.a("displayFloatingMask failed");
        return;
    L21:
        r11.a("viewId or current floating is null");
    }
}
