package okhttp3.internal.connection;

import com.bytedance.retrofit2.HttpMethodContrants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/connection/ConnectInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class ConnectInterceptor implements Interceptor {
    public static final ConnectInterceptor INSTANCE = null;

    static {
        INSTANCE = new ConnectInterceptor();
    }

    private ConnectInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r5) {
        Interceptor.Chain r4 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r5, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "chain");
        RealInterceptorChain r6 = (RealInterceptorChain) ZeusTransformUtils.preCheckCast(r4, RealInterceptorChain.class, "com.obric.memorydata.plugin");
        Request r0 = r6.request();
        Transmitter r1 = r6.transmitter();
        return r6.proceed(r0, r1, r1.newExchange$okhttp(r4, !Intrinsics.areEqual(r0.method(), HttpMethodContrants.GET)));
    }
}
