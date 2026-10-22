package com.bytedance.android.live.network.impl.interceptor;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.RequestError;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface q {
    boolean a(String r1, int r2, BaseResponse<?, ?> r3, String r4, RequestError r5);

    boolean b(int r1, com.bytedance.android.live.network.response.c r2, RequestError r3);

    void c(String r1, ExtraResponse r2);
}
