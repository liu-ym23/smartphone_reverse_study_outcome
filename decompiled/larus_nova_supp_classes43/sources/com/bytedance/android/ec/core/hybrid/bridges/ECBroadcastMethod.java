package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECBroadcastMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECBroadcastMethod extends ECBaseBridgeMethod {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "ecBroadcast";
    }

    public ECBroadcastMethod() {
    }

    public final void c(JSONObject r12, ECBaseBridgeMethod.a r13) {
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "iReturn");
        String r0 = r12.optString("eventName");
        if ((!StringsKt.isBlank(r0)) == true) goto L7;
        r0 = null;
    L7:
        if (r0 == null) goto L28;
        JSONObject r14 = r12.optJSONObject("data");
        if (r14 != null) goto L11;
        r13.onFailed(0, "no data found");
        return;
    L11:
        EventBus.getDefault().post(new ah.c(r0, r14));
        int r1 = r0.hashCode();
        if (r1 == (-1034470971)) goto L25;
        if (r1 == (-654096686)) goto L22;
        if (r1 == (-396285131)) goto L19;
    L27:
        r13.onSuccess(null);
        return;
    L19:
        if (r0.equals("didApplyCoupon") == false) goto L27;
        EventBus.getDefault().post(new ah.b(r14));
        goto L27
    L22:
        if (r0.equals("closeHalfSku") == false) goto L27;
        ECHybridExtensionsKt.f(ECBroadcastMethod$onEvent$1.INSTANCE);
        goto L27
    L25:
        if (r0.equals("moveToState") == false) goto L27;
        EventBus.getDefault().post(new ah.f(r14.optString("state"), r14.optInt("num"), r14.optBoolean("isD3"), r14.optString("couponShowType"), r14.optBoolean("animate"), r14.optBoolean("useNative"), r14.optJSONObject("logData")));
        goto L27
    L28:
        r13.onFailed(0, "no event name found");
        Unit r15 = Unit.INSTANCE;
    }
}
