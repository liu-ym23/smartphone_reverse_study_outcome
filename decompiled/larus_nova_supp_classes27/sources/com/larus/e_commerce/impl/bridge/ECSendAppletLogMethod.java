package com.larus.e_commerce.impl.bridge;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o89.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/larus/e_commerce/impl/bridge/ECSendAppletLogMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "handle", "", "params", "Lorg/json/JSONObject;", "iReturn", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod$IReturn;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ECSendAppletLogMethod extends ECBaseBridgeMethod {
    public final String e;

    public ECSendAppletLogMethod() {
        this.e = "flow.ecSendAppletLog";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r3, ECBaseBridgeMethod.a r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "iReturn");
        String r0 = r3.optString("name", "");
        JSONObject r5 = r3.optJSONObject("extra");
        r r1 = r.a;
        Intrinsics.checkNotNull(r0);
        r1.getClass();
        r.a(r0, r5);
        r4.onSuccess(null);
    }
}
