package com.bytedance.ai.bridge.method.device.Compass;

import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.sensor.AbsStartCompassMethodIDL;
import com.bytedance.ai.bridge.method.device.DeviceSensorInterval;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t3.r0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/Compass/StartCompassMethod;", "Lcom/bytedance/ai/bridge/device/sensor/AbsStartCompassMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/sensor/AbsStartCompassMethodIDL$SensorStartParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/sensor/AbsStartCompassMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartCompassMethod extends AbsStartCompassMethodIDL {

    public static final class a {
    }

    static {
    }

    public StartCompassMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsStartCompassMethodIDL.b r13 = (AbsStartCompassMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        DeviceSensorInterval.a r0 = DeviceSensorInterval.Companion;
        AbsStartCompassMethodIDL.SensorInterval r14 = r13.getInterval();
        if (r14 == null) goto L5;
        String r15 = r14.name();
    L6:
        r0.getClass();
        DeviceSensorInterval r16 = DeviceSensorInterval.a.a(r15);
        a0 r1 = r10.getContainerContext();
        g r17 = g.a;
        StringBuilder r18 = new StringBuilder("call start, interval=");
        r18.append(r16);
        r18.append(", appletId=");
        if (r1 == null) goto L9;
        String r19 = r1.getAppletId();
    L10:
        r18.append(r19);
        r18.append(", containerId=");
        if (r1 == null) goto L13;
        String r20 = r1.getContainerId();
    L14:
        r18.append(r20);
        r17.i("AISDK_JSB_StartCompassMethod", r18.toString());
        Intrinsics.checkNotNullParameter(r10, "<this>");
        RefType r21 = RefType.NORMAL;
        Object r22 = r10.d(u3.a.class);
        if (r22 != null) goto L17;
        r22 = new u3.a(r10);
        r10.b(u3.a.class, r22, r21);
    L17:
        r0 r23 = ((u3.a) r22).e(r16, this.a);
        if (r23 != null) goto L20;
        r17.i("AISDK_JSB_StartCompassMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsStartCompassMethodIDL.a.class, "<this>");
        r12.b((ResultModel) c.a(AbsStartCompassMethodIDL.a.class), "");
        return;
    L20:
        r17.e("AISDK_JSB_StartCompassMethod", "call failed, errNo=" + r23.b.a + ", msg=" + r23.a);
        h.a.a(r12, r23.a, r23.b, null, 10);
        return;
    L13:
        r20 = null;
        goto L14
    L9:
        r19 = null;
        goto L10
    L5:
        r15 = null;
        goto L6
    }
}
