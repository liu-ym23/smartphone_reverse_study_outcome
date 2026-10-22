package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.NetConst;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.a0;
import okhttp3.q;
import okhttp3.x;
import okhttp3.y;
import okhttp3.z;
import okio.d0;
import okio.f0;
import okio.k;
import okio.l;
import okio.t;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f11771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f11772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f11773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kc.d f11774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f11775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final RealConnection f11777g;

    @SourceDebugExtension({"SMAP\nExchange.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Exchange.kt\nokhttp3/internal/connection/Exchange$RequestBodySink\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,333:1\n1#2:334\n*E\n"})
    private final class a extends k {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f11778g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f11779h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f11780i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f11781j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ c f11782k;

        public a(c r10, d0 r11, long r12) {
            Intrinsics.checkNotNullParameter(r11, "delegate");
            this.f11782k = r10;
            super(r11);
            this.f11778g = r12;
        }

        private final <E extends IOException> E a(E r10) {
            if (this.f11779h == false) goto L5;
            return r10;
        L5:
            this.f11779h = true;
            return (E) this.f11782k.a(this.f11780i, false, true, r10);
        }

        @Override // okio.k, okio.d0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f11781j == false) goto L5;
            return;
        L5:
            this.f11781j = true;
            long r10 = this.f11778g;
            if (r10 != (-1)) goto L8;
        L17:
            super.close();     // Catch: IOException -> L14
            a(null);     // Catch: IOException -> L14
            return;
        L14:
            e = move-exception;
            throw a(e);
        L8:
            if (this.f11780i == r10) goto L17;
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // okio.k, okio.d0, java.io.Flushable
        public void flush() {
            super.flush();     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw a(e);
        }

        @Override // okio.k, okio.d0
        public void x(okio.d r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "source");
            if ((!this.f11781j) == false) goto L17;
            long r12 = this.f11778g;
            if (r12 != (-1)) goto L7;
        L18:
            super.x(r10, r11);     // Catch: IOException -> L13
            this.f11780i += r11;     // Catch: IOException -> L13
            return;
        L13:
            e = move-exception;
            throw a(e);
        L7:
            if ((this.f11780i + r11) <= r12) goto L18;
            throw new ProtocolException("expected " + this.f11778g + " bytes but received " + (this.f11780i + r11));
        L17:
            throw new IllegalStateException("closed".toString());
        }
    }

    @SourceDebugExtension({"SMAP\nExchange.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Exchange.kt\nokhttp3/internal/connection/Exchange$ResponseBodySource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,333:1\n1#2:334\n*E\n"})
    public final class b extends l {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f11783g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f11784h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f11785i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f11786j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f11787k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ c f11788l;

        public b(c r10, f0 r11, long r12) {
            Intrinsics.checkNotNullParameter(r11, "delegate");
            this.f11788l = r10;
            super(r11);
            this.f11783g = r12;
            this.f11785i = true;
            if (r12 != 0) goto L6;
            c(null);
            return;
        }

        @Override // okio.f0
        public long S(okio.d r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "sink");
            if ((!this.f11787k) == false) goto L26;
            long r12 = a().S(r10, r11);     // Catch: IOException -> L22
            if (this.f11785i == false) goto L8;
            this.f11785i = false;     // Catch: IOException -> L22
            this.f11788l.i().z(this.f11788l.g());     // Catch: IOException -> L22
        L8:
            if (r12 != (-1)) goto L11;
            c(null);     // Catch: IOException -> L22
            return -1;
        L11:
            long r13 = this.f11784h + r12;     // Catch: IOException -> L22
            long r14 = this.f11783g;     // Catch: IOException -> L22
            if (r14 != (-1)) goto L14;
        L18:
            this.f11784h = r13;     // Catch: IOException -> L22
            if (r13 != r14) goto L21;
            c(null);     // Catch: IOException -> L22
        L21:
            return r12;
        L14:
            if (r13 <= r14) goto L18;
            throw new ProtocolException("expected " + this.f11783g + " bytes but received " + r13);     // Catch: IOException -> L22
        L22:
            e = move-exception;
            throw c(e);
        L26:
            throw new IllegalStateException("closed".toString());
        }

        public final <E extends IOException> E c(E r10) {
            if (this.f11786j == false) goto L5;
            return r10;
        L5:
            this.f11786j = true;
            if (r10 != null) goto L11;
            if (this.f11785i == false) goto L11;
            this.f11785i = false;
            this.f11788l.i().z(this.f11788l.g());
        L11:
            return (E) this.f11788l.a(this.f11784h, true, false, r10);
        }

        @Override // okio.l, okio.f0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f11787k == false) goto L5;
            return;
        L5:
            this.f11787k = true;
            super.close();     // Catch: IOException -> L8
            c(null);     // Catch: IOException -> L8
            return;
        L8:
            e = move-exception;
            throw c(e);
        }
    }

    public c(e r10, q r11, d r12, kc.d r13) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "eventListener");
        Intrinsics.checkNotNullParameter(r12, "finder");
        Intrinsics.checkNotNullParameter(r13, "codec");
        this.f11771a = r10;
        this.f11772b = r11;
        this.f11773c = r12;
        this.f11774d = r13;
        this.f11777g = r13.e();
    }

    private final void t(IOException r10) {
        this.f11776f = true;
        this.f11773c.i(r10);
        this.f11774d.e().G(this.f11771a, r10);
    }

    public final <E extends IOException> E a(long r10, boolean r11, boolean r12, E r13) {
        if (r13 == null) goto L4;
        t(r13);
    L4:
        if (r12 == false) goto L9;
        q r14 = this.f11772b;
        e r15 = this.f11771a;
        if (r13 == null) goto L8;
        r14.v(r15, r13);
        goto L9
    L8:
        r14.t(r15, r10);
    L9:
        if (r11 == false) goto L14;
        if (r13 == null) goto L12;
        this.f11772b.A(this.f11771a, r13);
        goto L14
    L12:
        this.f11772b.y(this.f11771a, r10);
    L14:
        return (E) this.f11771a.r(this, r12, r11, r13);
    }

    public final void b() {
        this.f11774d.cancel();
    }

    public final d0 c(x r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "request");
        this.f11775e = r11;
        y r12 = r10.a();
        Intrinsics.checkNotNull(r12);
        long r13 = r12.a();
        this.f11772b.u(this.f11771a);
        return new a(this, this.f11774d.h(r10, r13), r13);
    }

    public final void d() {
        this.f11774d.cancel();
        this.f11771a.r(this, true, true, null);
    }

    public final void e() {
        this.f11774d.a();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.f11772b.v(this.f11771a, e);
        t(e);
        throw e;
    }

    public final void f() {
        this.f11774d.f();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.f11772b.v(this.f11771a, e);
        t(e);
        throw e;
    }

    public final e g() {
        return this.f11771a;
    }

    public final RealConnection h() {
        return this.f11777g;
    }

    public final q i() {
        return this.f11772b;
    }

    public final d j() {
        return this.f11773c;
    }

    public final boolean k() {
        return this.f11776f;
    }

    public final boolean l() {
        return !Intrinsics.areEqual(this.f11773c.d().m().h(), this.f11777g.a().a().m().h());
    }

    public final boolean m() {
        return this.f11775e;
    }

    public final void n() {
        this.f11774d.e().A();
    }

    public final void o() {
        this.f11771a.r(this, true, false, null);
    }

    public final a0 p(z r10) {
        Intrinsics.checkNotNullParameter(r10, "response");
        String r11 = z.s(r10, NetConst.KEY_CONTENT_TYPE, null, 2, null);     // Catch: IOException -> L5
        long r12 = this.f11774d.g(r10);     // Catch: IOException -> L5
        return new kc.h(r11, r12, t.b(new b(this, this.f11774d.c(r10), r12)));
    L5:
        e = move-exception;
        this.f11772b.A(this.f11771a, e);
        t(e);
        throw e;
    }

    public final z.a q(boolean r10) {
        z.a r11 = this.f11774d.d(r10);     // Catch: IOException -> L6
        if (r11 == null) goto L5;
        r11.l(this);     // Catch: IOException -> L6
    L5:
        return r11;
    L6:
        e = move-exception;
        this.f11772b.A(this.f11771a, e);
        t(e);
        throw e;
    }

    public final void r(z r10) {
        Intrinsics.checkNotNullParameter(r10, "response");
        this.f11772b.B(this.f11771a, r10);
    }

    public final void s() {
        this.f11772b.C(this.f11771a);
    }

    public final void u(x r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        this.f11772b.x(this.f11771a);     // Catch: IOException -> L5
        this.f11774d.b(r10);     // Catch: IOException -> L5
        this.f11772b.w(this.f11771a, r10);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        this.f11772b.v(this.f11771a, e);
        t(e);
        throw e;
    }
}
