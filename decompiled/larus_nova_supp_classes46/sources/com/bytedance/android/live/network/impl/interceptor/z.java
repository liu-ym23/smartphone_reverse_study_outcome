package com.bytedance.android.live.network.impl.interceptor;

import com.bytedance.android.livesdk.config.mc0;
import com.bytedance.android.livesdk.model.NetworkApmSetting;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z implements Interceptor {
    public eo0.b a;

    public static class a {
        public static final z a = null;

        static {
            NetworkApmSetting r1 = (NetworkApmSetting) mc0.a.getValue();
            a = new z();
        }
    }

    public z() {
        List r0 = y50.h.a;
        this.a = new eo0.b();
    }

    public final SsResponse intercept(Interceptor.Chain r2) throws Exception {
        Request r0 = r2.request();
        System.currentTimeMillis();
        SsResponse r3 = r2.proceed(r0);     // Catch: Exception -> L5
        System.currentTimeMillis();     // Catch: Exception -> L5
        this.a.getClass();     // Catch: Exception -> L5
        return r3;
    L5:
        e = move-exception;
        System.currentTimeMillis();
        this.a.getClass();
        throw e;
    }
}
