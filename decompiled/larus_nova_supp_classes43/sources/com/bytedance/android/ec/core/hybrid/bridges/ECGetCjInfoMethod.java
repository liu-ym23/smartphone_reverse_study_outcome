package com.bytedance.android.ec.core.hybrid.bridges;

import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECGetCjInfoMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECGetCjInfoMethod extends ECBaseBridgeMethod {
    public final String e;

    public static final class a {
    }

    static {
    }

    public ECGetCjInfoMethod() {
        this.e = "getCjInfo";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        JSONObject r12 = new JSONObject();
        JSONObject r0 = new JSONObject();
        r0.put(com.bytedance.android.ec.core.event.a.KEY_BIOMETRIC_PARAMS, "1");
        r0.put(com.bytedance.android.ec.core.event.a.KEY_IS_JAILBREAK, "2");
        r0.put(com.bytedance.android.ec.core.event.a.KEY_CJ_SDK, TTCJPayUtils.Companion.getInstance().getSDKVersion());
        r0.put(com.bytedance.android.ec.core.event.a.KEY_BIO_TYPE, "1");
        r12.put("code", 1);
        r12.put("data", r0);
        r11.a(r12);
    }
}
