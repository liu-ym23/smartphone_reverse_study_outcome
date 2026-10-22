package com.bytedance.ai.bridge.method.device.Compass;

import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.sensor.AbsStopCompassMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/Compass/StopCompassMethod;", "Lcom/bytedance/ai/bridge/device/sensor/AbsStopCompassMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/sensor/AbsStopCompassMethodIDL$StopCompassParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/sensor/AbsStopCompassMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StopCompassMethod extends AbsStopCompassMethodIDL {

    public static final class a {
    }

    static {
    }

    public StopCompassMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsStopCompassMethodIDL.b) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r13 = r10.getContainerContext();
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call start, appletId=");
        String r14 = null;
        if (r13 == null) goto L5;
        String r15 = r13.getAppletId();
    L6:
        r1.append(r15);
        r1.append(", containerId=");
        if (r13 == null) goto L9;
        r14 = r13.getContainerId();
    L9:
        r1.append(r14);
        r0.i("AISDK_JSB_StopCompassMethod", r1.toString());
        Intrinsics.checkNotNullParameter(r10, "<this>");
        RefType r16 = RefType.NORMAL;
        Object r17 = r10.d(u3.a.class);
        if (r17 != null) goto L12;
        r17 = new u3.a(r10);
        r10.b(u3.a.class, r17, r16);
    L12:
        ((u3.a) r17).f();
        r0.i("AISDK_JSB_StopCompassMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsStopCompassMethodIDL.a.class, "<this>");
        r12.b((ResultModel) c.a(AbsStopCompassMethodIDL.a.class), "");
        return;
    L5:
        r15 = null;
        goto L6
    }
}
