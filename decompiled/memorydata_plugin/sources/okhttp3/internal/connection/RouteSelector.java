package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002!\"B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0016H\u0086\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\t\u0010\u0018\u001a\u00020\u0019H\u0086\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H\u0002J\u001a\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lokhttp3/internal/connection/RouteSelector;", "", MemoryKeyInfoEntity.KEY_ADDRESS, "Lokhttp3/Address;", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "eventListener", "Lokhttp3/EventListener;", "(Lokhttp3/Address;Lokhttp3/internal/connection/RouteDatabase;Lokhttp3/Call;Lokhttp3/EventListener;)V", "inetSocketAddresses", "", "Ljava/net/InetSocketAddress;", "nextProxyIndex", "", "postponedRoutes", "", "Lokhttp3/Route;", "proxies", "Ljava/net/Proxy;", "hasNext", "", "hasNextProxy", "next", "Lokhttp3/internal/connection/RouteSelector$Selection;", "nextProxy", "resetNextInetSocketAddress", "", "proxy", "resetNextProxy", "url", "Lokhttp3/HttpUrl;", "Companion", "Selection", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class RouteSelector {
    public static final Companion Companion = null;
    private final Address address;
    private final Call call;
    private final EventListener eventListener;
    private List<? extends InetSocketAddress> inetSocketAddresses;
    private int nextProxyIndex;
    private final List<Route> postponedRoutes;
    private List<? extends Proxy> proxies;
    private final RouteDatabase routeDatabase;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lokhttp3/internal/connection/RouteSelector$Companion;", "", "()V", "socketHost", "", "Ljava/net/InetSocketAddress;", "getSocketHost", "(Ljava/net/InetSocketAddress;)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final String getSocketHost(InetSocketAddress r1) {
            Intrinsics.checkParameterIsNotNull(r1, "$this$socketHost");
            InetAddress r0 = r1.getAddress();
            if (r0 == null) goto L7;
            String r2 = r0.getHostAddress();
            String r3 = "address.hostAddress";
        L5:
            Intrinsics.checkExpressionValueIsNotNull(r2, r3);
            return r2;
        L7:
            r2 = r1.getHostName();
            r3 = "hostName";
            goto L5
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u000bH\u0086\u0002J\t\u0010\f\u001a\u00020\u0004H\u0086\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lokhttp3/internal/connection/RouteSelector$Selection;", "", "routes", "", "Lokhttp3/Route;", "(Ljava/util/List;)V", "nextRouteIndex", "", "getRoutes", "()Ljava/util/List;", "hasNext", "", "next", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Selection {
        private int nextRouteIndex;
        private final List<Route> routes;

        public Selection(List<Route> r3) {
            List<Route> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "routes");
            this.routes = r4;
        }

        public final List<Route> getRoutes() {
            return this.routes;
        }

        public final boolean hasNext() {
            if (this.nextRouteIndex >= this.routes.size()) goto L5;
            return true;
        L5:
            return false;
        }

        public final Route next() {
            if (hasNext() == false) goto L7;
            List<Route> r0 = this.routes;
            int r2 = this.nextRouteIndex;
            this.nextRouteIndex = r2 + 1;
            return (Route) ZeusTransformUtils.preCheckCast(r0.get(r2), Route.class, "com.obric.memorydata.plugin");
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new NoSuchElementException(), Throwable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RouteSelector(Address r3, RouteDatabase r4, Call r5, EventListener r6) {
        Call r7 = (Call) ZeusTransformUtils.wrapperContextForParams(r5, Call.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, MemoryKeyInfoEntity.KEY_ADDRESS);
        Intrinsics.checkParameterIsNotNull(r4, "routeDatabase");
        Intrinsics.checkParameterIsNotNull(r7, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(r6, "eventListener");
        this.address = r3;
        this.routeDatabase = r4;
        this.call = r7;
        this.eventListener = r6;
        this.proxies = CollectionsKt.emptyList();
        this.inetSocketAddresses = CollectionsKt.emptyList();
        this.postponedRoutes = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        resetNextProxy(r3.url(), r3.proxy());
    }

    private final boolean hasNextProxy() {
        if (this.nextProxyIndex >= this.proxies.size()) goto L5;
        return true;
    L5:
        return false;
    }

    private final Proxy nextProxy() {
        if (hasNextProxy() == false) goto L7;
        List<? extends Proxy> r0 = this.proxies;
        int r2 = this.nextProxyIndex;
        this.nextProxyIndex = r2 + 1;
        Proxy r1 = (Proxy) ZeusTransformUtils.preCheckCast(r0.get(r2), Proxy.class, "com.obric.memorydata.plugin");
        resetNextInetSocketAddress(r1);
        return r1;
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void resetNextInetSocketAddress(Proxy r7) {
        List<? extends InetSocketAddress> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.inetSocketAddresses = r0;
        if (r7.type() != Proxy.Type.DIRECT) goto L5;
    L12:
        String r3 = this.address.url().host();
        int r1 = this.address.url().port();
    L14:
        if (1 > r1) goto L29;
        if (65535 < r1) goto L29;
        if (r7.type() != Proxy.Type.SOCKS) goto L19;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).add(InetSocketAddress.createUnresolved(r3, r1));
        return;
    L19:
        this.eventListener.dnsStart(this.call, r3);
        List<InetAddress> r8 = this.address.dns().lookup(r3);
        if (r8.isEmpty() == true) goto L27;
        this.eventListener.dnsEnd(this.call, r3, r8);
        Iterator<InetAddress> r6 = r8.iterator();
    L23:
        if (r6.hasNext() == false) goto L31;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).add(new InetSocketAddress((InetAddress) ZeusTransformUtils.preCheckCast(r6.next(), InetAddress.class, "com.obric.memorydata.plugin"), r1));
        goto L23
    L31:
        return;
    L27:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new UnknownHostException(this.address.dns() + " returned no addresses for " + r3), Throwable.class, "com.obric.memorydata.plugin"));
    L29:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new SocketException("No route to " + r3 + ':' + r1 + "; port is out of range"), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        if (r7.type() == Proxy.Type.SOCKS) goto L12;
        SocketAddress r2 = r7.address();
        if (ZeusTransformUtils.instanceOf(r2, InetSocketAddress.class) == false) goto L11;
        r3 = Companion.getSocketHost((InetSocketAddress) ZeusTransformUtils.preCheckCast(r2, InetSocketAddress.class, "com.obric.memorydata.plugin"));
        r1 = ((InetSocketAddress) ZeusTransformUtils.preCheckCast(r2, InetSocketAddress.class, "com.obric.memorydata.plugin")).getPort();
        goto L14
    L11:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + r2.getClass()).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void resetNextProxy(HttpUrl r5, Proxy r6) {
        this.eventListener.proxySelectStart(this.call, r5);
        if (r6 == null) goto L5;
        List<Proxy> r7 = CollectionsKt.listOf(r6);
    L11:
        this.proxies = r7;
        this.nextProxyIndex = 0;
        this.eventListener.proxySelectEnd(this.call, r5, r7);
        return;
    L5:
        List<Proxy> r8 = this.address.proxySelector().select(r5.uri());
        if (r8 != null) goto L8;
    L10:
        r7 = Util.immutableListOf(new Proxy[]{Proxy.NO_PROXY});
        goto L11
    L8:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L10;
        r7 = Util.toImmutableList(r8);
        goto L11
    }

    public final boolean hasNext() {
        if (hasNextProxy() == false) goto L5;
        return true;
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.postponedRoutes, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public final Selection next() {
        if (hasNext() == false) goto L23;
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L6:
        if (hasNextProxy() == false) goto L18;
        Proxy r2 = nextProxy();
        Iterator<? extends InetSocketAddress> r3 = this.inetSocketAddresses.iterator();
    L9:
        if (r3.hasNext() == false) goto L16;
        Route r5 = new Route(this.address, r2, (InetSocketAddress) ZeusTransformUtils.preCheckCast(r3.next(), InetSocketAddress.class, "com.obric.memorydata.plugin"));
        if (this.routeDatabase.shouldPostpone(r5) == false) goto L13;
        Object r4 = ZeusTransformUtils.preCheckCast(this.postponedRoutes, Collection.class, "com.obric.memorydata.plugin");
    L14:
        ((Collection) r4).add(r5);
        goto L9
    L13:
        r4 = ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin");
        goto L14
    L16:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
    L18:
        if (r0.isEmpty() == false) goto L21;
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.postponedRoutes, Iterable.class, "com.obric.memorydata.plugin"));
        this.postponedRoutes.clear();
    L21:
        return new Selection(r0);
    L23:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new NoSuchElementException(), Throwable.class, "com.obric.memorydata.plugin"));
    }
}
