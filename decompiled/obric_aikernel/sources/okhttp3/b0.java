package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f11684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Proxy f11685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InetSocketAddress f11686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f11687d;

    public b0(a r10, Proxy r11, InetSocketAddress r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "address");
        Intrinsics.checkNotNullParameter(r11, "proxy");
        Intrinsics.checkNotNullParameter(r12, "socketAddress");
        this.f11684a = r10;
        this.f11685b = r11;
        this.f11686c = r12;
        this.f11687d = r13;
    }

    @JvmName(name = "address")
    public final a a() {
        return this.f11684a;
    }

    @JvmName(name = "dnsInfoJson")
    public final String b() {
        return this.f11687d;
    }

    @JvmName(name = "proxy")
    public final Proxy c() {
        return this.f11685b;
    }

    public final boolean d() {
        if (this.f11684a.k() != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f11685b.type() != Proxy.Type.HTTP) goto L7;
        return true;
    }

    @JvmName(name = "socketAddress")
    public final InetSocketAddress e() {
        return this.f11686c;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof b0) == false) goto L11;
        b0 r11 = (b0) r10;
        if (Intrinsics.areEqual(r11.f11684a, this.f11684a) == false) goto L11;
        if (Intrinsics.areEqual(r11.f11685b, this.f11685b) == false) goto L11;
        if (Intrinsics.areEqual(r11.f11686c, this.f11686c) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f11684a.hashCode()) * 31) + this.f11685b.hashCode()) * 31) + this.f11686c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f11686c + '}';
    }
}
