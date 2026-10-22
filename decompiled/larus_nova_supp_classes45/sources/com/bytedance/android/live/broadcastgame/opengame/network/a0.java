package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.live.network.impl.utils.RetrofitProvider;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a0 extends RetrofitProvider {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static String a() {
            if (jc1.k.n(IHostContext.class).isBoe() == true) goto L7;
            return "webcast-open.amemv.com";
        L7:
            return "webcast-open.amemv.com.boe-gateway.byted.org";
        }
    }

    static {
    }

    public final List<Interceptor> getCustomInterceptors() {
        return new ArrayList();
    }

    public final Retrofit getRetrofitInstance() {
        return getRetrofitInstance("https://".concat(a.a()));
    }

    public a0() {
    }
}
