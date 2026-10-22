package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECGetHomePageMallSource;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECGetHomePageMallSource extends ECBaseBridgeMethod {
    public final String getName() {
        return "ec.getHomePageMallSource";
    }

    public ECGetHomePageMallSource() {
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        JSONObject r12 = new JSONObject();
        r12.put("code", 1);     // Catch: JSONException -> L9
        int r13 = ECSdk.a;     // Catch: JSONException -> L9
        s83.g r14 = (s83.g) ECSdk.a(s83.g.class);     // Catch: JSONException -> L9
        if (r14 == null) goto L6;
        Integer r15 = Integer.valueOf(r14.getHomePageMallSource());     // Catch: JSONException -> L9
    L7:
        r12.put("mallSourceType", r15);     // Catch: JSONException -> L9
        r11.a(r12);     // Catch: JSONException -> L9
        return;
    L6:
        r15 = null;
    L9:
        e = move-exception;
        r12.put("code", 0);
        r12.put(MessageIndication.MESSAGE_TYPE_MSG, e.getMessage());
        r11.a(r12);
        ECExceptionMonitor.e(e);
    }
}
