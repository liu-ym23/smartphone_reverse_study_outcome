package u10;

import com.bytedance.android.live.network.impl.utils.RetrofitProvider;
import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Client;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k extends RetrofitProvider {
    public final ConcurrentHashMap<String, Retrofit> a;
    public final String b;
    public final String c;

    public static final class a implements Client.Provider {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        public final Client get() {
            return this.a;
        }
    }

    public final Retrofit getRetrofitInstance() {
        LocalTestManager.a(new Class[]{wy.a.class});
        return getRetrofitInstance("");
    }

    public final synchronized Retrofit getRetrofitInstance(String r6) {
        monitor-enter(this);
        if (r6 == null) goto L24;
    L6:
        if (r6 != null) goto L8;
    L12:
        j r0 = new j();     // Catch: Throwable -> L21
        Retrofit.Builder r1 = new Retrofit.Builder();     // Catch: Throwable -> L21
        if (r6 != null) goto L15;
        String r2 = "";
    L16:
        Retrofit r3 = r1.setEndpoint(r2).addConverterFactory(rx5.a.a()).addInterceptor(new u10.a(this.b, this.c)).httpExecutor(new SsHttpExecutor()).client(new a(r0)).build();     // Catch: Throwable -> L21
        if (r6 == null) goto L19;
        this.a.put(r6, r3);     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);
        return r3;
    L15:
        r2 = r6;
        goto L16
    L8:
        if (this.a.get(r6) == null) goto L12;
        Retrofit r7 = this.a.get(r6);     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L21
        Retrofit r8 = r7;     // Catch: Throwable -> L21
        monitor-exit(this);
        return r8;
    L24:
        LocalTestManager.a(new Class[]{wy.a.class});     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public k(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "appVersion");
        this.b = r2;
        this.c = r3;
        this.a = new ConcurrentHashMap();
    }
}
