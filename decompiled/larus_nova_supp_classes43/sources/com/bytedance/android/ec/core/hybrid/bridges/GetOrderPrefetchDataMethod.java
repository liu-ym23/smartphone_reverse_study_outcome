package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.core.hybrid.utils.p;
import com.bytedance.android.ec.core.hybrid.utils.q;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/GetOrderPrefetchDataMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GetOrderPrefetchDataMethod extends ECBaseBridgeMethod {
    public final String getName() {
        return "getOrderPrefetchData";
    }

    public GetOrderPrefetchDataMethod() {
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        String r12 = r10.optString("requestId");
        JSONObject r1 = p.a;
        Intrinsics.checkNotNullParameter(r12, "requestId");
        Intrinsics.checkNotNullParameter(r11, "callback");
        Map<String, q> r0 = p.j;
        if (r0.containsKey(r12) == false) goto L11;
        q r13 = r0.remove(r12);
        if (r13 != null) goto L7;
        p.k.put(r12, r11);
        return;
    L7:
        int r14 = r13.b;
        if (r14 != 1) goto L10;
        p.f(r13, r11);
        return;
    L10:
        p.b(r14, r11);
        return;
    L11:
        p.b(3, r11);
    }
}
