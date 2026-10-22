package com.bytedance.ai.bridge.method.payment;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.h0;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/GetOrderPaymentMethod;", "Lcom/bytedance/ai/bridge/method/payment/AbsGetOrderPaymentMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/payment/AbsGetOrderPaymentMethodIDL$GetOrderPaymentParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/payment/AbsGetOrderPaymentMethodIDL$GetOrderPaymentParamModel;Lo1/f;)V", "Companion", "com/bytedance/ai/bridge/method/payment/c", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGetOrderPaymentMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GetOrderPaymentMethod.kt\ncom/bytedance/ai/bridge/method/payment/GetOrderPaymentMethod\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,96:1\n1#2:97\n*E\n"})
public final class GetOrderPaymentMethod extends AbsGetOrderPaymentMethodIDL {
    public static final c Companion = null;
    private static final String TAG = "GetOrderPaymentMethod";
    private static final CoroutineScope scope = null;

    static {
        Companion = new c();
        scope = h0.a(t2.b.f22089a);
    }

    public GetOrderPaymentMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, f r11) {
        handle(r5, (AbsGetOrderPaymentMethodIDL.GetOrderPaymentParamModel) r10, r11);
    }

    public void handle(n1.c r5, AbsGetOrderPaymentMethodIDL.GetOrderPaymentParamModel r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        r11.a("HostPaymentDepend is null");
    }
}
