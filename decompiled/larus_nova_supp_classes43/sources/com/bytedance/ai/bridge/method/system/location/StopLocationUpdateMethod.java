package com.bytedance.ai.bridge.method.system.location;

import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.system.location.AbsStopLocationUpdateMethodIDL;
import d3.a0;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import r4.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/location/StopLocationUpdateMethod;", "Lcom/bytedance/ai/bridge/system/location/AbsStopLocationUpdateMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/location/AbsStopLocationUpdateMethodIDL$StopLocationUpdateParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/location/AbsStopLocationUpdateMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StopLocationUpdateMethod extends AbsStopLocationUpdateMethodIDL {

    public static final class a {
    }

    static {
    }

    public StopLocationUpdateMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, f3.h r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsStopLocationUpdateMethodIDL.b) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r13 = r10.getContainerContext();
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        StringBuilder r14 = new StringBuilder("call start, appletId=");
        if (r13 == null) goto L5;
        String r15 = r13.getAppletId();
    L6:
        r14.append(r15);
        r14.append(", containerId=");
        if (r13 == null) goto L9;
        String r16 = r13.getContainerId();
    L10:
        r14.append(r16);
        r0.i("AISDK_JSB_StopLocationUpdateMethod", r14.toString());
        Intrinsics.checkNotNullParameter(r10, "<this>");
        RefType r17 = RefType.NORMAL;
        Object r1 = r10.d(LocationUpdateManager.class);
        if (r1 != null) goto L13;
        r1 = new LocationUpdateManager(r10);
        r10.b(LocationUpdateManager.class, r1, r17);
    L13:
        LocationUpdateManager r18 = (LocationUpdateManager) r1;
        String r19 = this.a;
        k r20 = new k(r12);
        Intrinsics.checkNotNullParameter(r19, "bridgeName");
        Intrinsics.checkNotNullParameter(r20, "callback");
        e3.d r110 = r18.a.get();
        if (r110 != null) goto L16;
        f3.h.a.a(r20, "context is null", f3.a.f, null, 10);
        return;
    L16:
        Object r21 = r18.c;
        monitor-enter(r21);
        int r22 = LocationUpdateManager.a.a[r18.d.ordinal()];     // Catch: Throwable -> L57
        boolean r23 = true;
        if (r22 == 1) goto L27;
        if (r22 != 2) goto L22;
        r18.d = LocationUpdateManager.UpdateState.IDLE;     // Catch: Throwable -> L57
        goto L27
    L22:
        if (r22 != 3) goto L25;
        boolean r24 = true;
    L28:
        monitor-exit(r21);
        if (r24 == true) goto L31;
        Intrinsics.checkNotNullParameter(AbsStopLocationUpdateMethodIDL.a.class, "<this>");
        r20.b((ResultModel) k3.c.a(AbsStopLocationUpdateMethodIDL.a.class), "");
        return;
    L31:
        r4.e r25 = r4.a.h;
        if (r25 != null) goto L34;
        f3.a r111 = f3.a.g;
        int r26 = LocationAuthorization.a;
        f3.h.a.a(r20, "location service is not registered", r111, LocationAuthorization.b("location service is not registered", 0), 2);
        return;
    L34:
        l r27 = r25.c(r110, r19, r18.b);
        String r112 = r27.a;
        if (r112 == null) goto L38;
        r23 = false;
    L38:
        if (r23 == false) goto L50;
        Object r28 = r18.c;
        monitor-enter(r28);
    L47:
        th = move-exception;
        throw th;
    L42:
        if (r18.d != LocationUpdateManager.UpdateState.STARTED) goto L44;
        r18.d = LocationUpdateManager.UpdateState.IDLE;     // Catch: Throwable -> L47
    L44:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L47
        monitor-exit(r28);
        Intrinsics.checkNotNullParameter(AbsStopLocationUpdateMethodIDL.a.class, "<this>");
        r20.b((ResultModel) k3.c.a(AbsStopLocationUpdateMethodIDL.a.class), "");
        return;
    L50:
        if (r112 != null) goto L52;
        r112 = "stopLocationUpdate failed";
    L52:
        f3.a r29 = r27.b;
        if (r29 != null) goto L55;
        r29 = f3.a.f;
    L55:
        int r30 = LocationAuthorization.a;
        f3.h.a.a(r20, r112, r29, LocationAuthorization.b(r112, 0), 2);
        return;
    L25:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L57
    L27:
        r24 = false;
    L57:
        th = move-exception;
        throw th;
    L9:
        r16 = null;
        goto L10
    L5:
        r15 = null;
        goto L6
    }
}
