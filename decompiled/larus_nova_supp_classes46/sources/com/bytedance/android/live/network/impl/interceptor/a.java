package com.bytedance.android.live.network.impl.interceptor;

import com.bytedance.android.livesdk.config.qc0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements Interceptor {
    public static volatile a b;
    public final List<String> a;

    public a() {
        ArrayList r0 = new ArrayList();
        this.a = r0;
        r0.add("https://aweme.snssdk.com/luckycat/aweme/v1/");
        r0.add("https://webcast-open.douyin.com/webcast/stamp/micro_app_entrance_permission");
    }

    public final SsResponse intercept(Interceptor.Chain r8) throws Exception {
        Request r0 = r8.request();
        Iterator r1 = ((ArrayList) this.a).iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        if (r0.getUrl().startsWith((String) r1.next()) == false) goto L4;
        return r8.proceed(r0);
    L10:
        if (((Boolean) qc0.a.getValue()).booleanValue() == false) goto L17;
        List r2 = r0.headers("skip_url_end_check");
        if (r2 == null) goto L17;
        if ("1".equals(((Header) ListProtector.get(r2, 0)).getValue()) == false) goto L17;
        return r8.proceed(r0);
    L17:
        String r3 = r0.getPath();
        if (r3 == null) goto L29;
        if (r3.isEmpty() == true) goto L29;
        if (r3.endsWith("/") == true) goto L29;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L26;
        xs2.b r4 = xs2.b.a();
        r3.concat("/");
        r4.post(new com.bytedance.android.livesdk.event.b());
    L26:
        int r5 = r0.getUrl().indexOf(r3) + r3.length();
        return r8.proceed(r0.newBuilder().url(r0.getUrl().substring(0, r5) + "/" + r0.getUrl().substring(r5)).build());
    L29:
        return r8.proceed(r0);
    }
}
