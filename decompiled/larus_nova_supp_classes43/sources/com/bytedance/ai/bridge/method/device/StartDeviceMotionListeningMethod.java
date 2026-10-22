package com.bytedance.ai.bridge.method.device;

import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.sensor.AbsStartDeviceMotionListeningMethodIDL;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t3.q0;
import t3.r0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/StartDeviceMotionListeningMethod;", "Lcom/bytedance/ai/bridge/device/sensor/AbsStartDeviceMotionListeningMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/sensor/AbsStartDeviceMotionListeningMethodIDL$SensorStartParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/sensor/AbsStartDeviceMotionListeningMethodIDL$EmptyMessageModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartDeviceMotionListeningMethod extends AbsStartDeviceMotionListeningMethodIDL {
    public StartDeviceMotionListeningMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsStartDeviceMotionListeningMethodIDL.b r13 = (AbsStartDeviceMotionListeningMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Intrinsics.checkNotNullParameter(r10, "<this>");
        RefType r1 = RefType.NORMAL;
        Object r14 = r10.d(q0.class);
        if (r14 != null) goto L5;
        r14 = new q0(r10);
        r10.b(q0.class, r14, r1);
    L5:
        q0 r15 = (q0) r14;
        DeviceSensorInterval.a r16 = DeviceSensorInterval.Companion;
        AbsStartDeviceMotionListeningMethodIDL.SensorInterval r17 = r13.getInterval();
        if (r17 == null) goto L8;
        String r18 = r17.name();
    L9:
        r16.getClass();
        r0 r19 = r15.e(DeviceSensorInterval.a.a(r18), this.a);
        if (r19 != null) goto L12;
        Intrinsics.checkNotNullParameter(AbsStartDeviceMotionListeningMethodIDL.a.class, "<this>");
        r12.b((ResultModel) c.a(AbsStartDeviceMotionListeningMethodIDL.a.class), "");
        return;
    L12:
        h.a.a(r12, r19.a, r19.b, null, 10);
        return;
    L8:
        r18 = null;
        goto L9
    }
}
