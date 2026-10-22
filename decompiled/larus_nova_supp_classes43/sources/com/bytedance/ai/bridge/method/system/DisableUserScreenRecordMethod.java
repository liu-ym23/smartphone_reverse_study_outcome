package com.bytedance.ai.bridge.method.system;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.screen.AbsDisableUserScreenRecordMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import f3.h;
import f4.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/DisableUserScreenRecordMethod;", "Lcom/bytedance/ai/bridge/screen/AbsDisableUserScreenRecordMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/screen/AbsDisableUserScreenRecordMethodIDL$DisableUserScreenRecordParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/screen/AbsDisableUserScreenRecordMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DisableUserScreenRecordMethod extends AbsDisableUserScreenRecordMethodIDL {

    public static final class a {
    }

    static {
    }

    public DisableUserScreenRecordMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, h r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsDisableUserScreenRecordMethodIDL.a) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r13 = g.a;
        StringBuilder r0 = new StringBuilder("call start, appletId=");
        a0 r1 = r10.getContainerContext();
        if (r1 == null) goto L5;
        String r14 = r1.getAppletId();
    L6:
        r0.append(r14);
        r13.i("AISDK_JSB_DisableUserScreenRecordMethod", r0.toString());
        int r15 = q.a;
        q.a(r10, false, AbsDisableUserScreenRecordMethodIDL.b.class, "AISDK_JSB_DisableUserScreenRecordMethod", r12);
        return;
    L5:
        r14 = null;
        goto L6
    }
}
