package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.live.network.impl.utils.RetrofitProvider;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z extends RetrofitProvider {
    public final List<Interceptor> getCustomInterceptors() {
        return CollectionsKt.mutableListOf(new Interceptor[]{new y()});
    }

    public z() {
    }
}
