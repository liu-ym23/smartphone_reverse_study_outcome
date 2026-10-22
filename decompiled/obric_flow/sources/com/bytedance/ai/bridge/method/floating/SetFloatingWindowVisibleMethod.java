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
import v0.d;
import v0.e;
import w0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/floating/SetFloatingWindowVisibleMethod;", "Lcom/bytedance/ai/bridge/method/floating/AbsSetFloatingWindowVisibleMethodIDL;", "<init>", "()V", "", "mustRunInMain", "()Z", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/floating/AbsSetFloatingWindowVisibleMethodIDL$SetFloatingWindowVisibleParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/floating/AbsSetFloatingWindowVisibleMethodIDL$SetFloatingWindowVisibleResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/floating/AbsSetFloatingWindowVisibleMethodIDL$SetFloatingWindowVisibleParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SetFloatingWindowVisibleMethod extends AbsSetFloatingWindowVisibleMethodIDL {
    public SetFloatingWindowVisibleMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsSetFloatingWindowVisibleMethodIDL.SetFloatingWindowVisibleParamModel) r10, r11);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public boolean mustRunInMain() {
        return true;
    }

    public void handle(c r5, AbsSetFloatingWindowVisibleMethodIDL.SetFloatingWindowVisibleParamModel r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        String r12 = r10.getViewId();
        if (r12 != null) goto L8;
        Lazy r13 = e.f;
        com.bytedance.android.anniex.base.service.f.g().getClass();
        k r14 = e.n();
        if (r14 == null) goto L7;
        r12 = ((a) r14).f2331c;
        goto L8
    L7:
        r12 = null;
    L8:
        if (r12 == null) goto L11;
        Lazy r15 = e.f;
        e r16 = com.bytedance.android.anniex.base.service.f.g();
        boolean r17 = r10.getVisible();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r12, "viewId");
        Lazy r18 = d.f22502n;
        cl.a.h().u(r12, r17);
        Intrinsics.checkNotNullParameter(AbsSetFloatingWindowVisibleMethodIDL.SetFloatingWindowVisibleResultModel.class, "<this>");
        r11.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsSetFloatingWindowVisibleMethodIDL.SetFloatingWindowVisibleResultModel.class), "");
        return;
    L11:
        r11.a("viewId or current floating is null");
    }
}
