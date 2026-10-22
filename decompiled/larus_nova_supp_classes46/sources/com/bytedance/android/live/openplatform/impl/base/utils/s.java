package com.bytedance.android.live.openplatform.impl.base.utils;

import com.bytedance.android.live.network.impl.utils.RetrofitProvider;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.retrofit2.Retrofit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s extends RetrofitProvider {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.network.impl.utils.RetrofitProvider
    public final Retrofit getRetrofitInstance() {
        if (jc1.k.n(IHostContext.class).isBoe() == false) goto L5;
        String r0 = "minigame.zijieapi.com.boe-gateway.byted.org";
    L7:
        return getRetrofitInstance("https://".concat(r0));
    L5:
        r0 = "minigame.zijieapi.com";
        goto L7
    }

    public s() {
    }
}
