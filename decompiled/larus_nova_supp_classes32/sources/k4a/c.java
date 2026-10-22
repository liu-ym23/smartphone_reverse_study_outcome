package k4a;

import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.ttnet.retrofit.SsInterceptor;
import com.larus.platform.api.b2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    static {
    }

    public static Retrofit a(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "baseUrl");
        if (StringsKt.startsWith$default(r4, "http://", false, 2, null) == false) goto L5;
    L11:
        Retrofit.Builder r6 = new Retrofit.Builder().setEndpoint(r4).addConverterFactory(rx5.a.a()).httpExecutor(new SsHttpExecutor()).addInterceptor(new SsInterceptor()).addInterceptor(new a());
        if (r5 == false) goto L14;
        Client.Provider r7 = new b();
    L16:
        return r6.client(r7).build();
    L14:
        r7 = new d();
        goto L16
    L5:
        if (StringsKt.startsWith$default(r4, "https://", false, 2, null) == true) goto L11;
        b2.a r0 = b2.a;
        if (r0.d().a == false) goto L10;
        r4 = r0.k() + r4;
        goto L11
    L10:
        r4 = r0.l() + r4;
        goto L11
    }
}
