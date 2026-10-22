package com.bytedance.android.live.openplatform.impl.base.utils;

import com.bytedance.android.live.network.impl.utils.RetrofitProvider;
import com.bytedance.retrofit2.Retrofit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y extends RetrofitProvider {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.network.impl.utils.RetrofitProvider
    public final Retrofit getRetrofitInstance() {
        return getRetrofitInstance("https://www.xingtu.cn");
    }

    public y() {
    }
}
