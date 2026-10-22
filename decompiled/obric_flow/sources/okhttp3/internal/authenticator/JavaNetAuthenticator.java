package okhttp3.internal.authenticator;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Request;
import okhttp3.a;
import okhttp3.b;
import okhttp3.e0;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.l;
import okhttp3.n0;
import okhttp3.s0;
import okhttp3.t;
import okhttp3.x0;
import okhttp3.z;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u000b\u001a\u00020\n*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/authenticator/JavaNetAuthenticator;", "Lokhttp3/b;", "Lokhttp3/t;", "defaultDns", "<init>", "(Lokhttp3/t;)V", "Ljava/net/Proxy;", "Lokhttp3/e0;", "url", "dns", "Ljava/net/InetAddress;", "connectToInetAddress", "(Ljava/net/Proxy;Lokhttp3/e0;Lokhttp3/t;)Ljava/net/InetAddress;", "Lokhttp3/x0;", "route", "Lokhttp3/s0;", "response", "Lokhttp3/Request;", "authenticate", "(Lokhttp3/x0;Lokhttp3/s0;)Lokhttp3/Request;", "Lokhttp3/t;", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class JavaNetAuthenticator implements b {
    private final t defaultDns;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[Proxy.Type.values().length];
            $EnumSwitchMapping$0 = r5;
            r5[Proxy.Type.DIRECT.ordinal()] = 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaNetAuthenticator() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final InetAddress connectToInetAddress(Proxy r5, e0 r10, t r11) throws IOException {
        Proxy.Type r12 = r5.type();
        if (r12 != null) goto L6;
    L7:
        SocketAddress r13 = r5.address();
        if (r13 == null) goto L11;
        return ((InetSocketAddress) r13).getAddress();
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
    L6:
        if (WhenMappings.$EnumSwitchMapping$0[r12.ordinal()] != 1) goto L7;
        return (InetAddress) CollectionsKt.first(r11.lookup(r10.e));
    }

    public Request authenticate(x0 r19, s0 r20) throws IOException {
        Intrinsics.checkNotNullParameter(r20, "response");
        int r5 = r20.e;
        if (r5 == 401) goto L7;
        if (r5 == 407) goto L6;
        List<l> r10 = CollectionsKt.emptyList();
    L9:
        Request r11 = r20.f20746b;
        e0 r12 = r11.url();
        if (r20.e != 407) goto L12;
        boolean r13 = true;
    L13:
        if (r19 == null) goto L17;
        Proxy r14 = r19.f20765b;
        if (r14 == null) goto L17;
    L18:
        Iterator<l> r15 = r10.iterator();
    L20:
        if (r15.hasNext() == false) goto L60;
        l r16 = r15.next();
        if (StringsKt.l("Basic", r16.f20675b) == false) goto L20;
        if (r19 == null) goto L30;
        a r17 = r19.f20764a;
        if (r17 == null) goto L30;
        t r18 = r17.d;
        if (r18 == null) goto L30;
    L31:
        String r110 = r16.f20675b;
        Map r21 = r16.f20674a;
        if (r13 == false) goto L43;
        SocketAddress r111 = r14.address();
        if (r111 == null) goto L42;
        InetSocketAddress r112 = (InetSocketAddress) r111;
        String r113 = r112.getHostName();
        InetAddress r22 = connectToInetAddress(r14, r12, r18);
        int r114 = r112.getPort();
        String r115 = r12.f20640b;
        String r116 = (String) r21.get("realm");
        URL r23 = new URL(r12.f20644j);     // Catch: MalformedURLException -> L38
        PasswordAuthentication r24 = Authenticator.requestPasswordAuthentication(r113, r22, r114, r115, r116, r110, r23, Authenticator.RequestorType.PROXY);
    L46:
        if (r24 == null) goto L20;
        if (r13 == false) goto L49;
        String r25 = "Proxy-Authorization";
    L50:
        String r26 = r24.getUserName();
        String r27 = new String(r24.getPassword());
        String r28 = (String) r21.get("charset");
        if (r28 != null) goto L63;
    L54:
        Charset r29 = StandardCharsets.ISO_8859_1;
    L55:
        String r30 = z.a(r26, r27, r29);
        n0 r31 = r11.newBuilder();
        r31.c(r25, r30);
        return r31.b();
    L63:
        r29 = Charset.forName(r28);     // Catch: Exception -> L62
    L49:
        r25 = "Authorization";
    L38:
        e = move-exception;
        throw new RuntimeException(e);
    L42:
        throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
    L43:
        String r117 = r12.e;
        InetAddress r118 = connectToInetAddress(r14, r12, r18);
        String r119 = (String) r21.get("realm");
        URL r32 = new URL(r12.f20644j);     // Catch: MalformedURLException -> L57
        Authenticator.RequestorType r120 = Authenticator.RequestorType.SERVER;
        String r121 = r12.f20640b;
        r24 = Authenticator.requestPasswordAuthentication(r117, r118, r12.f, r121, r119, r110, r32, r120);
    L57:
        e = move-exception;
        throw new RuntimeException(e);
    L30:
        r18 = this.defaultDns;
        goto L31
    L60:
        return null;
    L17:
        r14 = Proxy.NO_PROXY;
        goto L18
    L12:
        r13 = false;
        goto L13
    L6:
        String r33 = "Proxy-Authenticate";
    L8:
        r10 = HttpHeaders.parseChallenges(r20.g, r33);
        goto L9
    L7:
        r33 = "WWW-Authenticate";
        goto L8
    }

    public JavaNetAuthenticator(t r5) {
        Intrinsics.checkNotNullParameter(r5, "defaultDns");
        this.defaultDns = r5;
    }

    public /* synthetic */ JavaNetAuthenticator(t r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = t.l1;
    L5:
        this(r5);
    }
}
