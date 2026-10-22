package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f20764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Proxy f20765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f20766c;

    public x0(a r5, Proxy r10, InetSocketAddress r11) {
        Intrinsics.checkNotNullParameter(r5, "address");
        Intrinsics.checkNotNullParameter(r10, "proxy");
        Intrinsics.checkNotNullParameter(r11, "socketAddress");
        this.f20764a = r5;
        this.f20765b = r10;
        this.f20766c = r11;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof x0) == false) goto L11;
        x0 r10 = (x0) r5;
        if (Intrinsics.areEqual(r10.f20764a, this.f20764a) == false) goto L11;
        if (Intrinsics.areEqual(r10.f20765b, this.f20765b) == false) goto L11;
        if (Intrinsics.areEqual(r10.f20766c, this.f20766c) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public final int hashCode() {
        int r5 = (this.f20764a.hashCode() + 527) * 31;
        int r10 = (this.f20765b.hashCode() + r5) * 31;
        return this.f20766c.hashCode() + r10;
    }

    public final String toString() {
        return "Route{" + this.f20766c + '}';
    }
}
