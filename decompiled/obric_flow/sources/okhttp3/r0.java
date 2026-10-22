package okhttp3;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.Exchange;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Request f20735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Protocol f20736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20737c;
    public String d;
    public a0 e;
    public b0 f;
    public w0 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public s0 f20738h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public s0 f20739i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public s0 f20740j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f20741k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f20742l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Exchange f20743m;

    public r0() {
        this.f20737c = -1;
        this.f = new b0();
    }

    public static void b(s0 r5, String r10) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.f20748h != null) goto L19;
        if (r5.f20749i != null) goto L17;
        if (r5.f20750j != null) goto L15;
        if (r5.f20751k != null) goto L13;
        return;
    L13:
        throw new IllegalArgumentException(r10.concat(".priorResponse != null").toString());
    L15:
        throw new IllegalArgumentException(r10.concat(".cacheResponse != null").toString());
    L17:
        throw new IllegalArgumentException(r10.concat(".networkResponse != null").toString());
    L19:
        throw new IllegalArgumentException(r10.concat(".body != null").toString());
    }

    public final s0 a() {
        int r5 = this.f20737c;
        if (r5 < 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L22;
        Request r11 = this.f20735a;
        if (r11 == null) goto L20;
        Protocol r12 = this.f20736b;
        if (r12 == null) goto L18;
        String r13 = this.d;
        if (r13 == null) goto L16;
        return new s0(r11, r12, r13, r5, this.e, this.f.d(), this.g, this.f20738h, this.f20739i, this.f20740j, this.f20741k, this.f20742l, this.f20743m);
    L16:
        throw new IllegalStateException("message == null");
    L18:
        throw new IllegalStateException("protocol == null");
    L20:
        throw new IllegalStateException("request == null");
    L22:
        throw new IllegalStateException(("code < 0: " + this.f20737c).toString());
    L5:
        r10 = false;
        goto L6
    }

    public final void c(c0 r5) {
        Intrinsics.checkNotNullParameter(r5, "headers");
        this.f = r5.d();
    }

    public final void d(Protocol r5) {
        Intrinsics.checkNotNullParameter(r5, "protocol");
        this.f20736b = r5;
    }
}
