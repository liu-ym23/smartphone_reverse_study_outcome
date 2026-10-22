package okhttp3.internal;

import com.lynx.serval.svg.SVGRenderEngine;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.b0;
import okhttp3.e0;
import okhttp3.g;
import okhttp3.q;
import okhttp3.r;
import okhttp3.s0;
import okhttp3.z;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u001d\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012\u001a%\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0015\u001a\u001f\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001c\u001a%\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\n¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"", "currentTimeMillis", "Lokhttp3/e0;", "url", "", "setCookie", "Lokhttp3/r;", "parseCookie", "(JLokhttp3/e0;Ljava/lang/String;)Lokhttp3/r;", "cookie", "", "forObsoleteRfc2965", "cookieToString", "(Lokhttp3/r;Z)Ljava/lang/String;", "Lokhttp3/b0;", "builder", SVGRenderEngine.LINE, "addHeaderLenient", "(Lokhttp3/b0;Ljava/lang/String;)Lokhttp3/b0;", "name", "value", "(Lokhttp3/b0;Ljava/lang/String;Ljava/lang/String;)Lokhttp3/b0;", "Lokhttp3/g;", "cache", "Lokhttp3/Request;", "request", "Lokhttp3/s0;", "cacheGet", "(Lokhttp3/g;Lokhttp3/Request;)Lokhttp3/s0;", "Lokhttp3/q;", "connectionSpec", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "isFallback", "", "applyConnectionSpec", "(Lokhttp3/q;Ljavax/net/ssl/SSLSocket;Z)V", "okhttp"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "Internal")
public final class Internal {
    public static final b0 addHeaderLenient(b0 r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        Intrinsics.checkNotNullParameter(r10, SVGRenderEngine.LINE);
        r5.b(r10);
        return r5;
    }

    public static final void applyConnectionSpec(q r5, SSLSocket r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "connectionSpec");
        Intrinsics.checkNotNullParameter(r10, "sslSocket");
        r5.a(r10, r11);
    }

    public static final s0 cacheGet(g r5, Request r10) {
        Intrinsics.checkNotNullParameter(r5, "cache");
        Intrinsics.checkNotNullParameter(r10, "request");
        return r5.b(r10);
    }

    public static final String cookieToString(r r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "cookie");
        return r5.a(r10);
    }

    public static final r parseCookie(long r5, e0 r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r11, "setCookie");
        Pattern r12 = r.f20726j;
        return z.k(r5, r10, r11);
    }

    public static final b0 addHeaderLenient(b0 r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "value");
        r5.c(r10, r11);
        return r5;
    }
}
