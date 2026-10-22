package com.bytedance.ai.bridge.method.payment;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.payment.payment.AbsDyPayMethodIDL;
import com.bytedance.ai.bridge.service.IHostPaymentDepend;
import com.bytedance.ai.model.AppletRuntimeManager;
import d3.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J0\u0010\r\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/DyPayMethod;", "Lcom/bytedance/ai/bridge/payment/payment/AbsDyPayMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/payment/payment/AbsDyPayMethodIDL$DyPayParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "completeFailure", "errorNo", "", "errorMessage", "apiError", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DyPayMethod extends AbsDyPayMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public DyPayMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, f3.h r12) {
        AbsDyPayMethodIDL.b r13 = (AbsDyPayMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r14 = r10.getContainerContext();
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        StringBuilder r1 = new StringBuilder("call start, appletId=");
        FragmentActivity r15 = null;
        if (r14 == null) goto L5;
        String r16 = r14.getAppletId();
    L6:
        r1.append(r16);
        r1.append(", containerId=");
        if (r14 == null) goto L9;
        String r17 = r14.getContainerId();
    L10:
        r1.append(r17);
        r0.i("AISDK_JSB_DyPayMethod", r1.toString());
        IHostPaymentDepend r18 = r4.a.m;
        if (r18 != null) goto L13;
        f3.a r19 = f3.a.g;
        b(r12, String.valueOf(r19.a), "Host payment service is unavailable", r19);
        return;
    L13:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r20 = AppletRuntimeManager.d;
        if (r20 == null) goto L16;
        Activity r21 = r20.currentActivity();
    L18:
        if ((r21 instanceof FragmentActivity) == false) goto L21;
        r15 = (FragmentActivity) r21;
    L21:
        if (AppletRuntimeManager.f == true) goto L25;
        if (r15 == null) goto L25;
        r18.openDyPay(r15, r13.getData(), new c(r12, this));
        return;
    L25:
        b(r12, "-3", "Payment is not supported in background", f3.a.f);
        return;
    L16:
        r21 = null;
        goto L18
    L9:
        r17 = null;
        goto L10
    L5:
        r16 = null;
        goto L6
    }

    public static void b(f3.h r10, String r11, String r12, f3.a r13) {
        AbsDyPayMethodIDL.a r0 = (AbsDyPayMethodIDL.a) k3.a.b(Reflection.getOrCreateKotlinClass(AbsDyPayMethodIDL.a.class));
        r0.setErrNo(r11);
        r0.setErrMsg(r12);
        com.bytedance.ai.utils.g.a.e("AISDK_JSB_DyPayMethod", "call failed, errNo=" + r13.a + ", bizErrNo=" + r11 + ", msg=" + r12);
        f3.h.a.a(r10, r12, r13, r0.toJson(), 2);
    }
}
