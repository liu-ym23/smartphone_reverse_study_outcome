package we;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f13158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Proxy f13159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f13160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13161d;

    public d0(a r8, Proxy r10, InetSocketAddress r11) {
        if (r8 == null) goto L10;
        if (r11 == null) goto L8;
        this.f13158a = r8;
        this.f13159b = r10;
        this.f13160c = r11;
        this.f13161d = null;
        return;
    L8:
        throw new NullPointerException("inetSocketAddress == null");
    L10:
        throw new NullPointerException("address == null");
    }

    public final a a() {
        return this.f13158a;
    }

    public final boolean equals(@Nullable Object r8) {
        if ((r8 instanceof d0) == false) goto L11;
        d0 r10 = (d0) r8;
        if (r10.f13158a.equals(this.f13158a) == false) goto L11;
        if (r10.f13159b.equals(this.f13159b) == false) goto L11;
        if (r10.f13160c.equals(this.f13160c) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public final int hashCode() {
        int r8 = (this.f13158a.hashCode() + 527) * 31;
        int r10 = (this.f13159b.hashCode() + r8) * 31;
        return this.f13160c.hashCode() + r10;
    }

    public final String toString() {
        return "Route{" + this.f13160c + "}";
    }
}
