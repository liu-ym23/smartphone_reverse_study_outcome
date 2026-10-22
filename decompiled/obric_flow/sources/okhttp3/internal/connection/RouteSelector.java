package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.a;
import okhttp3.e0;
import okhttp3.w;
import okhttp3.x0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0002-.B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0013H\u0086\u0002¢\u0006\u0004\b\u001a\u0010\u0015J\u0010\u0010\u001c\u001a\u00020\u001bH\u0086\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010 R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010)R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010*R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010+R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010,¨\u0006/"}, d2 = {"Lokhttp3/internal/connection/RouteSelector;", "", "Lokhttp3/a;", "address", "Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", "Lokhttp3/Call;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/w;", "eventListener", "<init>", "(Lokhttp3/a;Lokhttp3/internal/connection/RouteDatabase;Lokhttp3/Call;Lokhttp3/w;)V", "Lokhttp3/e0;", "url", "Ljava/net/Proxy;", "proxy", "", "resetNextProxy", "(Lokhttp3/e0;Ljava/net/Proxy;)V", "", "hasNextProxy", "()Z", "nextProxy", "()Ljava/net/Proxy;", "resetNextInetSocketAddress", "(Ljava/net/Proxy;)V", "hasNext", "Lokhttp3/internal/connection/RouteSelector$Selection;", "next", "()Lokhttp3/internal/connection/RouteSelector$Selection;", "", "proxies", "Ljava/util/List;", "", "nextProxyIndex", "I", "Ljava/net/InetSocketAddress;", "inetSocketAddresses", "", "Lokhttp3/x0;", "postponedRoutes", "Lokhttp3/a;", "Lokhttp3/internal/connection/RouteDatabase;", "Lokhttp3/Call;", "Lokhttp3/w;", "Companion", "Selection", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RouteSelector {
    public static final Companion Companion = null;
    private final a address;
    private final Call call;
    private final w eventListener;
    private List<? extends InetSocketAddress> inetSocketAddresses;
    private int nextProxyIndex;
    private final List<x0> postponedRoutes;
    private List<? extends Proxy> proxies;
    private final RouteDatabase routeDatabase;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lokhttp3/internal/connection/RouteSelector$Companion;", "", "()V", "socketHost", "", "Ljava/net/InetSocketAddress;", "getSocketHost", "(Ljava/net/InetSocketAddress;)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final String getSocketHost(InetSocketAddress r5) {
            Intrinsics.checkNotNullParameter(r5, "$this$socketHost");
            InetAddress r10 = r5.getAddress();
            if (r10 == null) goto L7;
            return r10.getHostAddress();
        L7:
            return r5.getHostName();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/connection/RouteSelector$Selection;", "", "", "Lokhttp3/x0;", "routes", "<init>", "(Ljava/util/List;)V", "", "hasNext", "()Z", "next", "()Lokhttp3/x0;", "", "nextRouteIndex", "I", "Ljava/util/List;", "getRoutes", "()Ljava/util/List;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Selection {
        private int nextRouteIndex;
        private final List<x0> routes;

        public Selection(List<x0> r5) {
            Intrinsics.checkNotNullParameter(r5, "routes");
            this.routes = r5;
        }

        public final List<x0> getRoutes() {
            return this.routes;
        }

        public final boolean hasNext() {
            if (this.nextRouteIndex >= this.routes.size()) goto L5;
            return true;
        L5:
            return false;
        }

        public final x0 next() {
            if (hasNext() == false) goto L7;
            List<x0> r5 = this.routes;
            int r10 = this.nextRouteIndex;
            this.nextRouteIndex = r10 + 1;
            return r5.get(r10);
        L7:
            throw new NoSuchElementException();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RouteSelector(a r5, RouteDatabase r10, Call r11, w r12) {
        Intrinsics.checkNotNullParameter(r5, "address");
        Intrinsics.checkNotNullParameter(r10, "routeDatabase");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r12, "eventListener");
        this.address = r5;
        this.routeDatabase = r10;
        this.call = r11;
        this.eventListener = r12;
        this.proxies = CollectionsKt.emptyList();
        this.inetSocketAddresses = CollectionsKt.emptyList();
        this.postponedRoutes = new ArrayList();
        resetNextProxy(r5.f20610a, null);
    }

    public static final /* synthetic */ a access$getAddress$p(RouteSelector r5) {
        return r5.address;
    }

    private final boolean hasNextProxy() {
        if (this.nextProxyIndex >= this.proxies.size()) goto L5;
        return true;
    L5:
        return false;
    }

    private final Proxy nextProxy() throws IOException {
        if (hasNextProxy() == false) goto L7;
        List<? extends Proxy> r5 = this.proxies;
        int r10 = this.nextProxyIndex;
        this.nextProxyIndex = r10 + 1;
        Proxy r11 = r5.get(r10);
        resetNextInetSocketAddress(r11);
        return r11;
    L7:
        throw new SocketException("No route to " + this.address.f20610a.e + "; exhausted proxy configurations: " + this.proxies);
    }

    private final void resetNextInetSocketAddress(Proxy r5) throws IOException {
        ArrayList r10 = new ArrayList();
        this.inetSocketAddresses = r10;
        if (r5.type() != Proxy.Type.DIRECT) goto L5;
    L12:
        e0 r11 = this.address.f20610a;
        String r12 = r11.e;
        int r13 = r11.f;
    L14:
        if (1 > r13) goto L30;
        if (65535 < r13) goto L30;
        if (r5.type() != Proxy.Type.SOCKS) goto L20;
        r10.add(InetSocketAddress.createUnresolved(r12, r13));
        return;
    L20:
        w r14 = this.eventListener;
        Call r15 = this.call;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r12, "domainName");
        List r16 = this.address.d.lookup(r12);
        if (r16.isEmpty() == true) goto L28;
        w r17 = this.eventListener;
        Call r18 = this.call;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r18, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r12, "domainName");
        Intrinsics.checkNotNullParameter(r16, "inetAddressList");
        Iterator r19 = r16.iterator();
    L24:
        if (r19.hasNext() == false) goto L32;
        r10.add(new InetSocketAddress((InetAddress) r19.next(), r13));
        goto L24
    L32:
        return;
    L28:
        throw new UnknownHostException(this.address.d + " returned no addresses for " + r12);
    L30:
        throw new SocketException("No route to " + r12 + ':' + r13 + "; port is out of range");
    L5:
        if (r5.type() == Proxy.Type.SOCKS) goto L12;
        SocketAddress r20 = r5.address();
        if ((r20 instanceof InetSocketAddress) == false) goto L11;
        InetSocketAddress r21 = (InetSocketAddress) r20;
        r12 = Companion.getSocketHost(r21);
        r13 = r21.getPort();
        goto L14
    L11:
        throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + r20.getClass()).toString());
    }

    private final void resetNextProxy(final e0 r5, final Proxy r10) {
        Function0<List<? extends Proxy>> r11 = new AnonymousClass1(this, r10, r5);
        w r12 = this.eventListener;
        Call r13 = this.call;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r5, "url");
        List<? extends Proxy> r14 = r11.invoke2();
        this.proxies = r14;
        this.nextProxyIndex = 0;
        w r15 = this.eventListener;
        Call r16 = this.call;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r14, "proxies");
    }

    public final boolean hasNext() {
        if (hasNextProxy() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.postponedRoutes.isEmpty() == false) goto L8;
        return false;
    }

    public final Selection next() throws IOException {
        if (hasNext() == false) goto L22;
        ArrayList r5 = new ArrayList();
    L6:
        if (hasNextProxy() == false) goto L17;
        Proxy r10 = nextProxy();
        Iterator<? extends InetSocketAddress> r11 = this.inetSocketAddresses.iterator();
    L9:
        if (r11.hasNext() == false) goto L15;
        InetSocketAddress r12 = r11.next();
        x0 r13 = new x0(this.address, r10, r12);
        if (this.routeDatabase.shouldPostpone(r13) == true) goto L12;
        r5.add(r13);
        goto L9
    L12:
        this.postponedRoutes.add(r13);
        goto L9
    L15:
        if (r5.isEmpty() == true) goto L6;
    L17:
        if (r5.isEmpty() == false) goto L20;
        CollectionsKt.a(r5, this.postponedRoutes);
        this.postponedRoutes.clear();
    L20:
        return new Selection(r5);
    L22:
        throw new NoSuchElementException();
    }
}
