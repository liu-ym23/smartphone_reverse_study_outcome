package com.bytedance.ai.bridge.method.system.location;

import com.bytedance.ai.applet.permission.Scope;
import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.system.location.AbsStartLocationUpdateMethodIDL;
import d3.a0;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/location/StartLocationUpdateMethod;", "Lcom/bytedance/ai/bridge/system/location/AbsStartLocationUpdateMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/location/AbsStartLocationUpdateMethodIDL$StartLocationUpdateParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/location/AbsStartLocationUpdateMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartLocationUpdateMethod extends AbsStartLocationUpdateMethodIDL {

    public static final class a {
    }

    static {
    }

    public StartLocationUpdateMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r11, ParamModel r12, f3.h r13) {
        AbsStartLocationUpdateMethodIDL.b r14 = (AbsStartLocationUpdateMethodIDL.b) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        final String r10 = r14.getType().name().toLowerCase(Locale.US);
        a0 r15 = r11.getContainerContext();
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        StringBuilder r16 = new StringBuilder("call start, type=");
        r16.append(r10);
        r16.append(", appletId=");
        if (r15 == null) goto L5;
        String r17 = r15.getAppletId();
    L6:
        r16.append(r17);
        r16.append(", containerId=");
        if (r15 == null) goto L9;
        String r18 = r15.getContainerId();
    L10:
        r16.append(r18);
        r0.i("AISDK_JSB_StartLocationUpdateMethod", r16.toString());
        Intrinsics.checkNotNullParameter(r11, "<this>");
        RefType r19 = RefType.NORMAL;
        Object r1 = r11.d(LocationUpdateManager.class);
        if (r1 != null) goto L13;
        r1 = new LocationUpdateManager(r11);
        r11.b(LocationUpdateManager.class, r1, r19);
    L13:
        final LocationUpdateManager r110 = (LocationUpdateManager) r1;
        final String r20 = this.a;
        final j r21 = new j(r13);
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r20, "bridgeName");
        Intrinsics.checkNotNullParameter(r21, "callback");
        if (r110.b() == false) goto L16;
        f3.h.a.a(r21, "context is null", f3.a.f, null, 10);
        return;
    L16:
        final e3.d r111 = r110.a.get();
        if (r111 != null) goto L19;
        f3.h.a.a(r21, "context is null", f3.a.f, null, 10);
        return;
    L19:
        Object r112 = r110.c;
        monitor-enter(r112);
    L30:
        th = move-exception;
        throw th;
    L22:
        if (r110.d == LocationUpdateManager.UpdateState.IDLE) goto L26;
        f3.a r113 = f3.a.r;     // Catch: Throwable -> L30
        int r22 = LocationAuthorization.a;     // Catch: Throwable -> L30
        f3.h.a.a(r21, "locationUpdate has started", r113, LocationAuthorization.b("locationUpdate has started", 0), 2);     // Catch: Throwable -> L30
        monitor-exit(r112);
    L33:
        return;
    L26:
        r110.d = LocationUpdateManager.UpdateState.STARTING;     // Catch: Throwable -> L30
        final int r23 = r110.e + 1;     // Catch: Throwable -> L30
        r110.e = r23;     // Catch: Throwable -> L30
        monitor-exit(r112);
        int r114 = LocationAuthorization.a;
        LocationAuthorization.a(r111, new f(r21, r110, r23), Scope.userLocation, "doubao.startLocationUpdate.permission_check.call", new d(r111, r110, r23, r21, r20, r10));
        goto L33
    L9:
        r18 = null;
        goto L10
    L5:
        r17 = null;
        goto L6
    }
}
