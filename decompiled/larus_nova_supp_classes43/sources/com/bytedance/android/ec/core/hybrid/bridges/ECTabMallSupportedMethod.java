package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECTabMallSupportedMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabMallSupportedMethod extends ECBaseBridgeMethod {
    public final String getName() {
        return "ecTabMallSupported";
    }

    public ECTabMallSupportedMethod() {
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        JSONObject r12 = new JSONObject();
        r12.put("code", 1);
        int r0 = ECSdk.a;
        s83.g r1 = (s83.g) ECSdk.a(s83.g.class);
        if (r1 == null) goto L5;
        Boolean r13 = Boolean.valueOf(r1.a0());
    L6:
        r12.put("isSupported", r13);
        Unit r14 = Unit.INSTANCE;
        r11.a(r12);
        return;
    L5:
        r13 = null;
        goto L6
    }
}
