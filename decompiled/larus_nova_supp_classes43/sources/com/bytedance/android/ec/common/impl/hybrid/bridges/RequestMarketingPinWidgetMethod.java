package com.bytedance.android.ec.common.impl.hybrid.bridges;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/common/impl/hybrid/bridges/RequestMarketingPinWidgetMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RequestMarketingPinWidgetMethod extends ECBaseBridgeMethod {
    public final String getName() {
        return "requestMarketingPinWidget";
    }

    public RequestMarketingPinWidgetMethod() {
    }

    public final void c(JSONObject r10, final ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        LinkedHashMap r0 = new LinkedHashMap();
        Object r1 = r10.opt("extra");
        if (r1 != null) goto L5;
    L17:
        boolean r12 = ECServiceManager.a;
        ((g) ECServiceManager.c(g.class)).V(r10.optString("key"), r10.optInt("operation"), r0, new RequestMarketingPinWidgetMethod$handle$3(r11));
        return;
    L5:
        if ((r1 instanceof String) == false) goto L12;
        JSONObject r13 = new JSONObject((String) r1);     // Catch: Exception -> L19
        Iterator<String> r14 = r13.keys();     // Catch: Exception -> L19
    L8:
        if (r14.hasNext() == false) goto L17;
        String r15 = r14.next();     // Catch: Exception -> L19
        r0.put(r15, r13.optString(r15));     // Catch: Exception -> L19
    L12:
        if ((r1 instanceof JSONObject) == false) goto L17;
        JSONObject r16 = (JSONObject) r1;
        Iterator<String> r17 = r16.keys();
    L15:
        if (r17.hasNext() == false) goto L17;
        String r18 = r17.next();
        r0.put(r18, r16.optString(r18));
        goto L15
    }
}
