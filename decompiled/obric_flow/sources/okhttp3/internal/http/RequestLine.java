package okhttp3.internal.http;

import androidx.constraintlayout.motion.widget.a;
import java.net.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.e0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/http/RequestLine;", "", "<init>", "()V", "Lokhttp3/Request;", "request", "Ljava/net/Proxy$Type;", "proxyType", "", "includeAuthorityInRequestLine", "(Lokhttp3/Request;Ljava/net/Proxy$Type;)Z", "", "get", "(Lokhttp3/Request;Ljava/net/Proxy$Type;)Ljava/lang/String;", "Lokhttp3/e0;", "url", "requestPath", "(Lokhttp3/e0;)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RequestLine {
    public static final RequestLine INSTANCE = null;

    static {
        INSTANCE = new RequestLine();
    }

    private RequestLine() {
    }

    private final boolean includeAuthorityInRequestLine(Request r5, Proxy.Type r10) {
        if (r5.isHttps() == false) goto L5;
    L7:
        return false;
    L5:
        if (r10 != Proxy.Type.HTTP) goto L7;
        return true;
    }

    public final String get(Request r5, Proxy.Type r10) {
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r10, "proxyType");
        StringBuilder r11 = new StringBuilder();
        r11.append(r5.method());
        r11.append(' ');
        RequestLine r12 = INSTANCE;
        if (r12.includeAuthorityInRequestLine(r5, r10) == false) goto L5;
        r11.append(r5.url());
    L6:
        r11.append(" HTTP/1.1");
        return r11.toString();
    L5:
        r11.append(r12.requestPath(r5.url()));
        goto L6
    }

    public final String requestPath(e0 r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        String r10 = r5.b();
        String r11 = r5.d();
        if (r11 != null) goto L5;
        return r10;
    L5:
        return a.m(r10, '?', r11);
    }
}
