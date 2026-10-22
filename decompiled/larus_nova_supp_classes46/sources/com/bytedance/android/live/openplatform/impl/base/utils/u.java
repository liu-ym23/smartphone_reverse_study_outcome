package com.bytedance.android.live.openplatform.impl.base.utils;

import com.bytedance.android.live.network.impl.utils.RetrofitProvider;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u extends RetrofitProvider {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.network.impl.utils.RetrofitProvider
    public final List<Interceptor> getCustomInterceptors() {
        return CollectionsKt.mutableListOf(new Interceptor[]{new q()});
    }

    @Override // com.bytedance.android.live.network.impl.utils.RetrofitProvider
    public final Retrofit getRetrofitInstance() {
        StringBuilder r0 = new StringBuilder("https://");
        String r2 = "webcast-open.amemv.com";
        if (jc1.k.n(IHostContext.class).isBoe() == false) goto L5;
        r2 = "webcast-open.amemv.com".concat(".boe-gateway.byted.org");
    L5:
        r0.append(r2);
        return getRetrofitInstance(r0.toString());
    }

    public u() {
    }
}
