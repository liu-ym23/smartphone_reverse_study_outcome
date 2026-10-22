package com.bytedance.android.live.network.impl.interceptor;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r implements Interceptor {
    public final ILiveRoomService a;

    public r() {
        this.a = jc1.k.f(ILiveRoomService.class);
    }

    public final SsResponse intercept(Interceptor.Chain r4) throws Exception {
        Request r0 = r4.request();
        this.a.interceptLinkRequest(r0.getPath());
        return r4.proceed(r0);
    }
}
