package com.bytedance.android.live.openplatform.impl.base.utils;

import com.bytedance.android.live.network.impl.utils.RetrofitProvider;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r extends RetrofitProvider {
    @Override // com.bytedance.android.live.network.impl.utils.RetrofitProvider
    public final List<Interceptor> getCustomInterceptors() {
        return CollectionsKt.mutableListOf(new Interceptor[]{new q()});
    }

    public r() {
    }
}
