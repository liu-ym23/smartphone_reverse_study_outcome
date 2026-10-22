package x18;

import com.larksuite.framework.http.request.HttpHeaders;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements Interceptor {
    public final /* synthetic */ y18.a a;

    public c(y18.a r1) {
        this.a = r1;
    }

    public final Response intercept(Interceptor.Chain r4) throws IOException {
        return r4.proceed(r4.request().newBuilder().removeHeader(HttpHeaders.HEAD_KEY_USER_AGENT).addHeader(HttpHeaders.HEAD_KEY_USER_AGENT, this.a.getUserAgent()).build());
    }
}
