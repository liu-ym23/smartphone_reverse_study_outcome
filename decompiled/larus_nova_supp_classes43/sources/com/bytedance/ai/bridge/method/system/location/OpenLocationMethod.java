package com.bytedance.ai.bridge.method.system.location;

import com.bytedance.ai.applet.permission.Scope;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.system.location.AbsOpenLocationMethodIDL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/location/OpenLocationMethod;", "Lcom/bytedance/ai/bridge/system/location/AbsOpenLocationMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/location/AbsOpenLocationMethodIDL$OpenLocationParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/location/AbsOpenLocationMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenLocationMethod extends AbsOpenLocationMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public OpenLocationMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(final e3.d r11, ParamModel r12, final f3.h r13) {
        final AbsOpenLocationMethodIDL.a r14 = (AbsOpenLocationMethodIDL.a) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        double r0 = r14.getLatitude();
        boolean r10 = true;
        if ((-90.0d) <= r0) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L11;
        int r15 = LocationAuthorization.a;
        f3.h.a.a(r13, "invalid latitude", null, LocationAuthorization.b("invalid latitude", 0), 6);
        return;
    L11:
        double r16 = r14.getLongitude();
        if ((-180.0d) <= r16) goto L14;
    L16:
        boolean r17 = false;
    L17:
        if (r17 == true) goto L19;
        int r18 = LocationAuthorization.a;
        f3.h.a.a(r13, "invalid longitude", null, LocationAuthorization.b("invalid longitude", 0), 6);
        return;
    L19:
        int r19 = r14.getScale();
        if (5 <= r19) goto L22;
    L24:
        r10 = false;
    L25:
        if (r10 == true) goto L27;
        int r110 = LocationAuthorization.a;
        f3.h.a.a(r13, "invalid scale", null, LocationAuthorization.b("invalid scale", 0), 6);
        return;
    L27:
        int r20 = LocationAuthorization.a;
        Function1 r21 = new h(this, r11, r14, r13);
        LocationAuthorization.a(r11, r13, Scope.userLocation, "doubao.getLocation.permission_check.call", r21);
        return;
    L22:
        if (r19 >= 19) goto L24;
    L14:
        if (r16 > 180.0d) goto L16;
        r17 = true;
        goto L17
    L5:
        if (r0 > 90.0d) goto L7;
        r1 = true;
        goto L9
    }
}
