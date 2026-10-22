package com.bytedance.ai.bridge.method.device;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.accessibility.AbsCheckIsOpenAccessibilityMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import e3.e;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/CheckIsOpenAccessibilityMethod;", "Lcom/bytedance/ai/bridge/device/accessibility/AbsCheckIsOpenAccessibilityMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/accessibility/AbsCheckIsOpenAccessibilityMethodIDL$EmptyMessageModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/accessibility/AbsCheckIsOpenAccessibilityMethodIDL$CheckIsOpenAccessibilityResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckIsOpenAccessibilityMethod extends AbsCheckIsOpenAccessibilityMethodIDL {

    public static final class a {
    }

    static {
    }

    public CheckIsOpenAccessibilityMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsCheckIsOpenAccessibilityMethodIDL.b) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r13 = g.a;
        StringBuilder r0 = new StringBuilder("call start, appletId=");
        a0 r1 = r10.getContainerContext();
        if (r1 == null) goto L5;
        String r14 = r1.getAppletId();
    L6:
        r0.append(r14);
        r13.i("AISDK_JSB_CheckIsOpenAccessibilityMethod", r0.toString());
        Context r15 = e.b(r10);
        if (r15 != null) goto L9;
        StringBuilder r16 = new StringBuilder("call failed, errNo=");
        f3.a r17 = f3.a.f;
        r16.append(r17.a);
        r16.append(", msg=context is null");
        r13.e("AISDK_JSB_CheckIsOpenAccessibilityMethod", r16.toString());
        h.a.a(r12, "context is null", r17, null, 10);
        return;
    L9:
        Object r18 = r15.getSystemService("accessibility");
        if ((r18 instanceof AccessibilityManager) == false) goto L12;
        AccessibilityManager r19 = (AccessibilityManager) r18;
    L13:
        if (r19 != null) goto L15;
        StringBuilder r20 = new StringBuilder("call failed, errNo=");
        f3.a r21 = f3.a.g;
        r20.append(r21.a);
        r20.append(", msg=accessibility service is unavailable");
        r13.e("AISDK_JSB_CheckIsOpenAccessibilityMethod", r20.toString());
        h.a.a(r12, "accessibility service is unavailable", r21, null, 10);
        return;
    L15:
        r13.i("AISDK_JSB_CheckIsOpenAccessibilityMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsCheckIsOpenAccessibilityMethodIDL.a.class, "<this>");
        BaseModel r22 = c.a(AbsCheckIsOpenAccessibilityMethodIDL.a.class);
        AbsCheckIsOpenAccessibilityMethodIDL.a r23 = (AbsCheckIsOpenAccessibilityMethodIDL.a) r22;
        if (r19.isEnabled() == true) goto L18;
    L20:
        boolean r24 = false;
    L21:
        r23.setOpen(r24);
        r12.b((ResultModel) r22, "");
        return;
    L18:
        if (r19.isTouchExplorationEnabled() == false) goto L20;
        r24 = true;
        goto L21
    L12:
        r19 = null;
        goto L13
    L5:
        r14 = null;
        goto L6
    }
}
