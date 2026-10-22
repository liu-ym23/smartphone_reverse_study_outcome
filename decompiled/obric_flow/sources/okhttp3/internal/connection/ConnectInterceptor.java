package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.f0;
import okhttp3.g0;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.s0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/internal/connection/ConnectInterceptor;", "Lokhttp3/g0;", "<init>", "()V", "Lokhttp3/f0;", "chain", "Lokhttp3/s0;", "intercept", "(Lokhttp3/f0;)Lokhttp3/s0;", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class ConnectInterceptor implements g0 {
    public static final ConnectInterceptor INSTANCE = null;

    static {
        INSTANCE = new ConnectInterceptor();
    }

    private ConnectInterceptor() {
    }

    @Override // okhttp3.g0
    public s0 intercept(f0 r10) throws IOException {
        Intrinsics.checkNotNullParameter(r10, "chain");
        RealInterceptorChain r11 = (RealInterceptorChain) r10;
        return RealInterceptorChain.copy$okhttp$default(r11, 0, r11.getCall$okhttp().initExchange$okhttp(r11), null, 0, 0, 0, 61, null).proceed(r11.getRequest$okhttp());
    }
}
