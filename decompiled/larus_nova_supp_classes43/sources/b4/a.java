package b4;

import com.bytedance.ai.bridge.service.IAppletRetrofit;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.ttnet.retrofit.SsInterceptor;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements IHostNetworkDepend {

    /* JADX INFO: renamed from: b4.a$a, reason: collision with other inner class name */
    public final class C0003a implements IAppletRetrofit {
        public final Retrofit a;

        public C0003a(Retrofit r10) {
            Intrinsics.checkNotNullParameter(r10, "retrofit");
            this.a = r10;
        }

        @Override // com.bytedance.ai.bridge.service.IAppletRetrofit
        public final <T> T create(Class<T> r10) {
            Intrinsics.checkNotNullParameter(r10, "service");
            return (T) this.a.create(r10);
        }
    }

    public a() {
    }

    @Override // com.bytedance.ai.bridge.service.IHostNetworkDepend
    public final IAppletRetrofit createRetrofit(String r10, boolean r11, Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r10, "baseUrl");
        int r1 = j.a;
        Intrinsics.checkNotNullParameter(r10, "baseUrl");
        Retrofit.Builder r13 = new Retrofit.Builder().setEndpoint(r10).addConverterFactory(rx5.a.a()).httpExecutor(new SsHttpExecutor()).addInterceptor(new SsInterceptor());
        if (r11 == false) goto L5;
        Client.Provider r14 = new i();
    L7:
        return new C0003a(r13.client(r14).build());
    L5:
        r14 = new l();
        goto L7
    }
}
