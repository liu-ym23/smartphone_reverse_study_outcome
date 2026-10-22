package com.bytedance.ai.bridge.method.widget;

import com.bytedance.ai.utils.g;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.ttnet.utils.RetrofitUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final WidgetRemoteApi a = null;

    static {
        a = (WidgetRemoteApi) RetrofitUtils.getSsRetrofit("https://api-normal.doubao.com").create(WidgetRemoteApi.class);
    }

    public static void a(String r11, String r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r11, "appKey");
        Intrinsics.checkNotNullParameter(r12, "cardInstanceId");
        Intrinsics.checkNotNullParameter(r15, "widgetData");
        SsResponse r16 = a.updateCardInstance(new a(r11, r12, r13, r14, r15, System.currentTimeMillis())).execute();     // Catch: Exception -> L15
        if (r16.isSuccessful() == false) goto L13;
        p4.a r17 = (p4.a) r16.body();     // Catch: Exception -> L15
        if (r17 == null) goto L10;
        boolean r18 = true;
        if (r17.d() != true) goto L10;
    L11:
        if (r18 == false) goto L13;
        g.a.i("WidgetRemoteService", "updateCardInstance success");     // Catch: Exception -> L15
        return;
    L10:
        r18 = false;
    L13:
        g.a.e("WidgetRemoteService", "updateCardInstance failed, httpCode=" + r16.code() + ", response=" + r16.body());     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        g.a.e("WidgetRemoteService", "updateCardInstance ERROR: " + e.getMessage(), e);
    }
}
