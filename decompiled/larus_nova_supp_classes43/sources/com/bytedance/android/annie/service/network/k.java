package com.bytedance.android.annie.service.network;

import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.rxjava2.adapter.RxJava2CallAdapterFactory;
import com.bytedance.ttnet.retrofit.SsInterceptor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k {
    static {
    }

    public static Retrofit a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "baseUrl");
        return new Retrofit.Builder().setEndpoint(r1).addConverterFactory(rx5.a.a()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).httpExecutor(new SsHttpExecutor()).addInterceptor(new SsInterceptor()).client(new m()).build();
    }
}
