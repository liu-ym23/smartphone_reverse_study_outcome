package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.b0;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.q;
import okhttp3.s;
import okhttp3.w;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f11789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final okhttp3.a f11790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f11791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final q f11792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h.b f11793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private h f11794f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11795g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11796h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11797i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private b0 f11798j;

    public d(f r10, okhttp3.a r11, e r12, q r13) {
        Intrinsics.checkNotNullParameter(r10, "connectionPool");
        Intrinsics.checkNotNullParameter(r11, "address");
        Intrinsics.checkNotNullParameter(r12, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r13, "eventListener");
        this.f11789a = r10;
        this.f11790b = r11;
        this.f11791c = r12;
        this.f11792d = r13;
    }

    private final RealConnection b(int r15, int r16, int r17, int r18, boolean r19) {
        if (this.f11791c.isCanceled() == true) goto L73;
        RealConnection r10 = this.f11791c.m();
        boolean r11 = true;
        if (r10 == null) goto L31;
        monitor-enter(r10);
    L28:
        th = move-exception;
        throw th;
    L8:
        if (r10.r() == false) goto L10;
    L13:
        Socket r12 = this.f11791c.u();     // Catch: Throwable -> L28
    L14:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r10);
        if (this.f11791c.m() == null) goto L25;
        if (r12 == null) goto L21;
        r11 = false;
    L21:
        if (r11 == false) goto L24;
        return r10;
    L24:
        throw new IllegalStateException("Check failed.".toString());
    L25:
        if (r12 == null) goto L27;
        hc.e.n(r12);
    L27:
        this.f11792d.n(this.f11791c, r10);
        goto L31
    L10:
        if (h(r10.a().a().m()) == false) goto L13;
        r12 = null;
    L31:
        this.f11795g = 0;
        this.f11796h = 0;
        this.f11797i = 0;
        if (this.f11789a.a(this.f11790b, this.f11791c, null, false) == false) goto L36;
    L33:
        RealConnection r14 = this.f11791c.m();
        Intrinsics.checkNotNull(r14);
    L34:
        this.f11792d.m(this.f11791c, r14);
        return r14;
    L36:
        b0 r20 = this.f11798j;
        if (r20 == null) goto L40;
        Intrinsics.checkNotNull(r20);
        this.f11798j = null;
    L39:
        List<b0> r21 = null;
    L54:
        RealConnection r22 = new RealConnection(this.f11789a, r20);
        this.f11791c.x(r22);
        r22.h(r15, r16, r17, r18, r19, this.f11791c, this.f11792d);     // Catch: Throwable -> L67
        this.f11791c.x(null);
        this.f11791c.l().u().a(r22.a());
        if (this.f11789a.a(this.f11790b, this.f11791c, r21, true) == false) goto L59;
        r14 = this.f11791c.m();
        Intrinsics.checkNotNull(r14);
        this.f11798j = r20;
        hc.e.n(r22.b());
        goto L34
    L59:
        monitor-enter(r22);
        this.f11789a.e(r22);     // Catch: Throwable -> L64
        this.f11791c.e(r22);     // Catch: Throwable -> L64
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L64
        monitor-exit(r22);
        this.f11792d.m(this.f11791c, r22);
        return r22;
    L64:
        th = move-exception;
        throw th;
    L67:
        th = move-exception;
        this.f11791c.x(null);
        throw th;
    L40:
        h.b r24 = this.f11793e;
        if (r24 == null) goto L45;
        Intrinsics.checkNotNull(r24);
        if (r24.b() == false) goto L45;
        h.b r25 = this.f11793e;
        Intrinsics.checkNotNull(r25);
        r20 = r25.c();
    L45:
        h r26 = this.f11794f;
        if (r26 != null) goto L48;
        r26 = new h(this.f11790b, this.f11791c.l().u(), this.f11791c, this.f11792d);
        this.f11794f = r26;
    L48:
        h.b r27 = r26.c();
        this.f11793e = r27;
        r21 = r27.a();
        if (this.f11791c.isCanceled() == true) goto L71;
        if (this.f11789a.a(this.f11790b, this.f11791c, r21, false) == true) goto L33;
        r20 = r27.c();
        goto L54
    L71:
        throw new IOException("Canceled");
    L73:
        throw new IOException("Canceled");
    }

    private final RealConnection c(int r10, int r11, int r12, int r13, boolean r14, boolean r15) {
    L2:
        RealConnection r16 = b(r10, r11, r12, r13, r14);
        if (r16.w(r15) == true) goto L4;
        r16.A();
        if (this.f11798j != null) goto L2;
        h.b r17 = this.f11793e;
        boolean r18 = true;
        if (r17 == null) goto L10;
        boolean r19 = r17.b();
    L11:
        if (r19 == true) goto L2;
        h r20 = this.f11794f;
        if (r20 == null) goto L15;
        r18 = r20.a();
    L15:
        if (r18 == true) goto L2;
        throw new IOException("exhausted all routes");
    L10:
        r19 = true;
        goto L11
    L4:
        return r16;
    }

    private final b0 g() {
        if (this.f11795g <= 1) goto L5;
    L27:
        return null;
    L5:
        if (this.f11796h > 1) goto L27;
        if (this.f11797i > 0) goto L27;
        RealConnection r10 = this.f11791c.m();
        if (r10 != null) goto L12;
        return null;
    L12:
        monitor-enter(r10);
    L24:
        th = move-exception;
        throw th;
    L14:
        if (r10.s() == 0) goto L18;
        monitor-exit(r10);
        return null;
    L18:
        if (hc.e.j(r10.a().a().m(), this.f11790b.m()) == true) goto L21;
        monitor-exit(r10);
        return null;
    L21:
        b0 r11 = r10.a();     // Catch: Throwable -> L24
        monitor-exit(r10);
        return r11;
    }

    public final kc.d a(w r10, kc.g r11) {
        Intrinsics.checkNotNullParameter(r10, "client");
        Intrinsics.checkNotNullParameter(r11, "chain");
        int r12 = r11.g();     // Catch: IOException -> L9 RouteException -> L12
        int r13 = r11.i();     // Catch: IOException -> L9 RouteException -> L12
        int r14 = r11.k();     // Catch: IOException -> L9 RouteException -> L12
        int r15 = r10.B();     // Catch: IOException -> L9 RouteException -> L12
        boolean r16 = r10.H();     // Catch: IOException -> L9 RouteException -> L12
        if (Intrinsics.areEqual(r11.j().g(), "GET") == true) goto L6;
        boolean r17 = true;
    L7:
        return c(r12, r13, r14, r15, r16, r17).y(r10, r11);
    L6:
        r17 = false;
    L9:
        e = move-exception;
        i(e);
        throw new RouteException(e);
    L12:
        e = move-exception;
        i(e.getLastConnectException());
        throw e;
    }

    public final okhttp3.a d() {
        return this.f11790b;
    }

    public final void e(int r10) {
        h r11 = this.f11794f;
        if (r11 == null) goto L5;
        r11.f(r10);
    L5:
        this.f11793e = null;
    }

    public final boolean f() {
        boolean r10 = false;
        if (this.f11795g != 0) goto L10;
        if (this.f11796h != 0) goto L10;
        if (this.f11797i != 0) goto L10;
        return false;
    L10:
        if (this.f11798j == null) goto L12;
        return true;
    L12:
        b0 r11 = g();
        if (r11 == null) goto L16;
        this.f11798j = r11;
        return true;
    L16:
        h.b r12 = this.f11793e;
        if (r12 != null) goto L19;
    L21:
        if (r10 == false) goto L23;
        return true;
    L23:
        h r13 = this.f11794f;
        if (r13 != null) goto L27;
        return true;
    L27:
        return r13.a();
    L19:
        if (r12.b() != true) goto L21;
        r10 = true;
        goto L21
    }

    public final boolean h(s r10) {
        Intrinsics.checkNotNullParameter(r10, "url");
        s r11 = this.f11790b.m();
        if (r10.n() == r11.n()) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r10.h(), r11.h()) == false) goto L7;
        return true;
    }

    public final void i(IOException r10) {
        Intrinsics.checkNotNullParameter(r10, "e");
        this.f11798j = null;
        if ((r10 instanceof StreamResetException) == false) goto L8;
        if (((StreamResetException) r10).errorCode != ErrorCode.REFUSED_STREAM) goto L8;
        this.f11795g++;
        return;
    L8:
        if ((r10 instanceof ConnectionShutdownException) == false) goto L10;
        this.f11796h++;
        return;
    L10:
        this.f11797i++;
    }
}
