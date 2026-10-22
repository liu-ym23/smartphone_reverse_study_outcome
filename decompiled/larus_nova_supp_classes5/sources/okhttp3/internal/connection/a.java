package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a implements Interceptor {
    public final OkHttpClient a;

    public a(OkHttpClient r1) {
        this.a = r1;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain r6) throws IOException {
        RealInterceptorChain r0 = (RealInterceptorChain) r6;
        Request r1 = r0.request();
        StreamAllocation r2 = r0.streamAllocation();
        return r0.proceed(r1, r2, r2.newStream(this.a, r6, !r1.method().equals("GET")), r2.connection());
    }
}
