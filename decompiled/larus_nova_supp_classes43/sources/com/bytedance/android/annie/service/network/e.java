package com.bytedance.android.annie.service.network;

import com.bytedance.android.annie.depend.IHostNetworkDepend;
import com.bytedance.android.annie.depend.IRetrofit;
import com.bytedance.retrofit2.Retrofit;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements IHostNetworkDepend {

    public final class a implements IRetrofit {
        public final Retrofit a;

        public a(Retrofit r10) {
            Intrinsics.checkNotNullParameter(r10, "retrofit");
            this.a = r10;
        }

        @Override // com.bytedance.android.annie.depend.IRetrofit
        public final <T> T create(Class<T> r10) {
            Intrinsics.checkNotNullParameter(r10, "service");
            return (T) this.a.create(r10);
        }
    }

    public e() {
    }

    @Override // com.bytedance.android.annie.depend.IHostNetworkDepend
    public final Map<String, Object> getAPIParams() {
        return null;
    }

    @Override // com.bytedance.android.annie.depend.IHostNetworkDepend
    public final IRetrofit createRetrofit(String r1, boolean r10) {
        Intrinsics.checkNotNullParameter(r1, "baseUrl");
        return new a(k.a(r1));
    }
}
