package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.obric.miniapp.utils.k0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/miniapp/aibridge/IsSleepModeMethod;", "Lcom/obric/miniapp/aibridge/AbsIsSleepModeMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsIsSleepModeMethodIDL$SleepModeParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsIsSleepModeMethodIDL$SleepModeResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IsSleepModeMethod extends AbsIsSleepModeMethodIDL {
    public final boolean mustRunInMain() {
        return true;
    }

    public IsSleepModeMethod() {
    }

    public final void handle(e3.d r2, ParamModel r3, f3.h r4) {
        Intrinsics.checkNotNullParameter(r2, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsIsSleepModeMethodIDL.a) r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(AbsIsSleepModeMethodIDL.b.class, "<this>");     // Catch: Exception -> L5
        AbsIsSleepModeMethodIDL.b r5 = k3.c.a(AbsIsSleepModeMethodIDL.b.class);     // Catch: Exception -> L5
        boolean r0 = k0.a;     // Catch: Exception -> L5
        r5.setResult(k0.a);     // Catch: Exception -> L5
        r4.b(r5, "");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        f3.h.a.a(r4, "Failed to check sleep mode: " + e.getMessage(), null, null, 14);
    }
}
