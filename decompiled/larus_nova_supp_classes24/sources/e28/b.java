package e28;

import com.larksuite.framework.http.request.HttpHeaders;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements Interceptor {
    public final c a;

    public b(c r2) {
        Intrinsics.checkNotNullParameter(r2, "usSupporter");
        this.a = r2;
    }

    public final Response intercept(Interceptor.Chain r4) {
        Intrinsics.checkNotNullParameter(r4, "chain");
        String r0 = this.a.getUserAgent();
        if (r0 == null) goto L5;
        Response r5 = r4.proceed(r4.request().newBuilder().header(HttpHeaders.HEAD_KEY_USER_AGENT, r0).build());
        Intrinsics.checkNotNull(r5);
        return r5;
    L5:
        Response r6 = r4.proceed(r4.request());
        Intrinsics.checkNotNull(r6);
        return r6;
    }
}
