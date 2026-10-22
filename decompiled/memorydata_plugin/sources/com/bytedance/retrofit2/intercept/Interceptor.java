package com.bytedance.retrofit2.intercept;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;

/* JADX INFO: loaded from: classes2.dex */
public interface Interceptor {

    public interface Chain {
        Call call();

        RetrofitMetrics metrics();

        SsResponse proceed(Request r1);

        SsResponse proceedWithoutHook(Request r1);

        Request request();
    }

    SsResponse intercept(Chain r1);
}
