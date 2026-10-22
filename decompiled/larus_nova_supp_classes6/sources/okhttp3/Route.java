package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class Route {
    final a address;
    final String dnsInfoJson;
    final InetSocketAddress inetSocketAddress;
    final Proxy proxy;

    public int hashCode() {
        return ((((527 + this.address.hashCode()) * 31) + this.proxy.hashCode()) * 31) + this.inetSocketAddress.hashCode();
    }

    public boolean requiresTunnel() {
        if (this.address.i != null) goto L5;
    L7:
        return false;
    L5:
        if (this.proxy.type() != Proxy.Type.HTTP) goto L7;
        return true;
    }

    public String toString() {
        return "Route{" + this.inetSocketAddress + "}";
    }

    public a address() {
        return this.address;
    }

    public String dnsInfoJson() {
        return this.dnsInfoJson;
    }

    public Proxy proxy() {
        return this.proxy;
    }

    public InetSocketAddress socketAddress() {
        return this.inetSocketAddress;
    }

    public boolean equals(@Nullable Object r3) {
        if ((r3 instanceof Route) == false) goto L11;
        Route r4 = (Route) r3;
        if (r4.address.equals(this.address) == false) goto L11;
        if (r4.proxy.equals(this.proxy) == false) goto L11;
        if (r4.inetSocketAddress.equals(this.inetSocketAddress) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public Route(a r1, Proxy r2, InetSocketAddress r3) {
        if (r1 == null) goto L13;
        if (r2 == null) goto L11;
        if (r3 == null) goto L9;
        this.address = r1;
        this.proxy = r2;
        this.inetSocketAddress = r3;
        this.dnsInfoJson = null;
        return;
    L9:
        throw new NullPointerException("inetSocketAddress == null");
    L11:
        throw new NullPointerException("proxy == null");
    L13:
        throw new NullPointerException("address == null");
    }

    public Route(a r1, Proxy r2, InetSocketAddress r3, String r4) {
        if (r1 == null) goto L13;
        if (r2 == null) goto L11;
        if (r3 == null) goto L9;
        this.address = r1;
        this.proxy = r2;
        this.inetSocketAddress = r3;
        this.dnsInfoJson = r4;
        return;
    L9:
        throw new NullPointerException("inetSocketAddress == null");
    L11:
        throw new NullPointerException("proxy == null");
    L13:
        throw new NullPointerException("address == null");
    }
}
