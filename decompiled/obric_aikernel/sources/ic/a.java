package ic;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.b;
import okhttp3.b0;
import okhttp3.g;
import okhttp3.n;
import okhttp3.p;
import okhttp3.s;
import okhttp3.x;
import okhttp3.z;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p f9480b;

    /* JADX INFO: renamed from: ic.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0200a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9481a = null;

        static {
            int[] r10 = new int[Proxy.Type.values().length];
            r10[Proxy.Type.DIRECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f9481a = r10;
        }
    }

    public a(p r10) {
        Intrinsics.checkNotNullParameter(r10, "defaultDns");
        this.f9480b = r10;
    }

    public /* synthetic */ a(p r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = p.f12019a;
    L5:
        this(r10);
    }

    private final InetAddress b(Proxy r10, s r11, p r12) {
        Proxy.Type r13 = r10.type();
        if (r13 != null) goto L5;
        int r14 = -1;
    L7:
        if (r14 == 1) goto L11;
        SocketAddress r15 = r10.address();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type java.net.InetSocketAddress");
        InetAddress r16 = ((InetSocketAddress) r15).getAddress();
        Intrinsics.checkNotNullExpressionValue(r16, "address() as InetSocketAddress).address");
        return r16;
    L11:
        return (InetAddress) CollectionsKt.first(r12.a(r11.h()));
    L5:
        r14 = C0200a.f9481a[r13.ordinal()];
        goto L7
    }

    @Override // okhttp3.b
    public x a(b0 r20, z r21) {
        Intrinsics.checkNotNullParameter(r21, "response");
        List<g> r10 = r21.i();
        x r11 = r21.K();
        s r12 = r11.l();
        if (r21.k() != 407) goto L5;
        boolean r13 = true;
    L6:
        if (r20 == null) goto L9;
        Proxy r14 = r20.c();
        if (r14 == null) goto L9;
    L10:
        Iterator<g> r15 = r10.iterator();
    L12:
        if (r15.hasNext() == false) goto L32;
        g r16 = r15.next();
        if (StringsKt.equals("Basic", r16.c(), true) == false) goto L12;
        if (r20 == null) goto L21;
        okhttp3.a r17 = r20.a();
        if (r17 == null) goto L21;
        p r18 = r17.c();
        if (r18 == null) goto L21;
    L23:
        if (r13 == false) goto L25;
        SocketAddress r19 = r14.address();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type java.net.InetSocketAddress");
        InetSocketAddress r110 = (InetSocketAddress) r19;
        String r111 = r110.getHostName();
        Intrinsics.checkNotNullExpressionValue(r14, "proxy");
        PasswordAuthentication r22 = Authenticator.requestPasswordAuthentication(r111, b(r14, r12, r18), r110.getPort(), r12.s(), r16.b(), r16.c(), r12.u(), Authenticator.RequestorType.PROXY);
    L26:
        if (r22 == null) goto L12;
        if (r13 == false) goto L29;
        String r23 = "Proxy-Authorization";
    L30:
        String r24 = r22.getUserName();
        Intrinsics.checkNotNullExpressionValue(r24, "auth.userName");
        char[] r25 = r22.getPassword();
        Intrinsics.checkNotNullExpressionValue(r25, "auth.password");
        return r11.h().d(r23, n.a(r24, new String(r25), r16.a())).b();
    L29:
        r23 = "Authorization";
        goto L30
    L25:
        String r112 = r12.h();
        Intrinsics.checkNotNullExpressionValue(r14, "proxy");
        r22 = Authenticator.requestPasswordAuthentication(r112, b(r14, r12, r18), r12.n(), r12.s(), r16.b(), r16.c(), r12.u(), Authenticator.RequestorType.SERVER);
    L21:
        r18 = this.f9480b;
        goto L23
    L32:
        return null;
    L9:
        r14 = Proxy.NO_PROXY;
        goto L10
    L5:
        r13 = false;
        goto L6
    }
}
