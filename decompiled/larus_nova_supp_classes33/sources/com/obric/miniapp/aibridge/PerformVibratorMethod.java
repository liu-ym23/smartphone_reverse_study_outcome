package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.obric.miniapp.utils.MiniAppUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/miniapp/aibridge/PerformVibratorMethod;", "Lcom/obric/miniapp/aibridge/AbsPerformVibratorMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsPerformVibratorMethodIDL$PerformVibratorParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsPerformVibratorMethodIDL$PerformVibratorResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PerformVibratorMethod extends AbsPerformVibratorMethodIDL {
    public PerformVibratorMethod() {
    }

    public final void handle(e3.d r2, ParamModel r3, f3.h r4) {
        AbsPerformVibratorMethodIDL.a r5 = (AbsPerformVibratorMethodIDL.a) r3;
        Intrinsics.checkNotNullParameter(r2, "bridgeContext");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        String r6 = r5.getEffect();
        if (r6 != null) goto L9;
        r6 = "EFFECT_RIGID";
    L9:
        MiniAppUtils r7 = MiniAppUtils.a;     // Catch: Exception -> L8
        MiniAppUtils.f(r6);     // Catch: Exception -> L8
    L6:
        Intrinsics.checkNotNullParameter(AbsPerformVibratorMethodIDL.b.class, "<this>");
        r4.b(k3.c.a(AbsPerformVibratorMethodIDL.b.class), "");
    }
}
