package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface SsHttpCall$ICustomInterceptorControl {
    List<Interceptor> getInterceptors(Request r1, List<Interceptor> r2);
}
