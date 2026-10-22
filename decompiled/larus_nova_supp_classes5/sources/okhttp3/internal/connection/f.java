package okhttp3.internal.connection;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import cvc.c;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.i;
import okhttp3.ttnet.TTNetDns;
import okhttp3.ttnet.TTNetDnsResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f {
    public final okhttp3.a a;
    public final e b;
    public final Call c;
    public final i d;
    public int e;
    public String f;
    public List<Proxy> g;
    public int h;
    public List<InetSocketAddress> i;
    public final List<Route> j;

    public final boolean b() {
        if (this.h >= this.g.size()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        if (((ArrayList) this.j).isEmpty() == false) goto L13;
        return false;
    L13:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public final a c() throws IOException {
        if (b() == false) goto L80;
        ArrayList r0 = new ArrayList();
    L5:
        int r3 = 0;
        if (this.h >= this.g.size()) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L75;
        if (this.h >= this.g.size()) goto L13;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L73;
        List<Proxy> r4 = this.g;
        int r5 = this.h;
        this.h = r5 + 1;
        Proxy r6 = (Proxy) ListProtector.get(r4, r5);
        this.i = new ArrayList();
        if (r6.type() != Proxy.Type.DIRECT) goto L19;
    L30:
        String r7 = this.a.a.host();
        int r8 = this.a.a.port();
    L31:
        if (r8 < 1) goto L71;
        if (r8 > 65535) goto L71;
        if (r6.type() != Proxy.Type.SOCKS) goto L37;
        this.i.add(InetSocketAddress.createUnresolved(r7, r8));
    L52:
        int r9 = this.i.size();
    L53:
        if (r3 >= r9) goto L66;
        Route r10 = new Route(this.a, r6, (InetSocketAddress) ListProtector.get(this.i, r3), this.f);
        e r11 = this.b;
        monitor-enter(r11);
        boolean r12 = r11.a.contains(r10);     // Catch: Throwable -> L62
        monitor-exit(r11);
        if (r12 == false) goto L60;
        ((ArrayList) this.j).add(r10);
    L61:
        r3 = r3 + 1;
        goto L53
    L60:
        r0.add(r10);
    L62:
        th = move-exception;
        throw th;
    L66:
        if (r0.isEmpty() == true) goto L5;
    L37:
        this.d.dnsStart(this.c, r7);
        List<InetAddress> r13 = new ArrayList();
        okhttp3.a r14 = this.a;
        TTNetDns r15 = r14.l;
        String r16 = null;
        if (r15 == null) goto L47;
        TTNetDnsResult r17 = r15.lookup(r7, this.e);
        if (r17 == null) goto L42;
        r13 = r17.getInetAddressList();
        r16 = r17.getDnsInfoJson();
    L42:
        this.d.dnsEnd(this.c, r7, r13, r16);
        this.f = r16;
        if (r13.isEmpty() == true) goto L46;
    L49:
        this.d.dnsEnd(this.c, r7, r13);
        int r18 = r13.size();
        int r19 = 0;
    L50:
        if (r19 >= r18) goto L52;
        this.i.add(new InetSocketAddress((InetAddress) ListProtector.get(r13, r19), r8));
        r19 = r19 + 1;
        goto L50
    L46:
        throw new UnknownHostException(this.a.l + " returned no addresses for " + r7);
    L47:
        r13 = r14.b.lookup(r7);
        this.d.dnsEnd(this.c, r7, r13, null);
        if (r13.isEmpty() == false) goto L49;
        throw new UnknownHostException(this.a.b + " returned no addresses for " + r7);
    L71:
        throw new SocketException("No route to " + r7 + ":" + r8 + "; port is out of range");
    L19:
        if (r6.type() == Proxy.Type.SOCKS) goto L30;
        SocketAddress r20 = r6.address();
        if ((r20 instanceof InetSocketAddress) == false) goto L29;
        InetSocketAddress r21 = (InetSocketAddress) r20;
        InetAddress r22 = r21.getAddress();
        if (r22 != null) goto L26;
        r7 = r21.getHostName();
    L27:
        r8 = r21.getPort();
        goto L31
    L26:
        r7 = r22.getHostAddress();
        goto L27
    L29:
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + r20.getClass());
    L73:
        throw new SocketException("No route to " + this.a.a.host() + "; exhausted proxy configurations: " + this.g);
    L13:
        r2 = false;
    L75:
        if (r0.isEmpty() == false) goto L78;
        r0.addAll(this.j);
        ((ArrayList) this.j).clear();
    L78:
        return new a(r0);
    L8:
        r1 = false;
        goto L9
    L80:
        throw new NoSuchElementException();
    }

    public final void a(Route r4, IOException r5) {
        if (r4.proxy().type() == Proxy.Type.DIRECT) goto L7;
        okhttp3.a r0 = this.a;
        ProxySelector r1 = r0.g;
        if (r1 == null) goto L7;
        r1.connectFailed(r0.a.uri(), r4.proxy().address(), r5);
    L7:
        e r6 = this.b;
        monitor-enter(r6);
        r6.a.add(r4);     // Catch: Throwable -> L12
        monitor-exit(r6);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void d(HttpUrl r2, Proxy r3) {
        if (r3 == null) goto L5;
        this.g = Collections.singletonList(r3);
    L12:
        this.h = 0;
        return;
    L5:
        List<Proxy> r4 = this.a.g.select(r2.uri());
        if (r4 != null) goto L8;
    L10:
        List<Proxy> r5 = c.o(new Proxy[]{Proxy.NO_PROXY});
    L11:
        this.g = r5;
        goto L12
    L8:
        if (r4.isEmpty() == true) goto L10;
        r5 = c.n(r4);
        goto L11
    }

    public f(okhttp3.a r2, e r3, Call r4, i r5) {
        this.e = 0;
        this.f = null;
        this.g = Collections.emptyList();
        this.i = Collections.emptyList();
        this.j = new ArrayList();
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        d(r2.a, r2.h);
    }
}
