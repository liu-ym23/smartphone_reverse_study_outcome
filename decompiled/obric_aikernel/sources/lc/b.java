package lc;

import com.bytedance.common.wschannel.WsConstants;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kc.i;
import kc.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import okhttp3.internal.connection.RealConnection;
import okhttp3.r;
import okhttp3.s;
import okhttp3.w;
import okhttp3.x;
import okhttp3.z;
import okio.d0;
import okio.f0;
import okio.g0;
import okio.m;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nHttp1ExchangeCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http1ExchangeCodec.kt\nokhttp3/internal/http1/Http1ExchangeCodec\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,505:1\n1#2:506\n*E\n"})
public final class b implements kc.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f10927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RealConnection f10928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final okio.f f10929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final okio.e f10930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final lc.a f10932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private r f10933g;

    private abstract class a implements f0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final m f10934c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f10935g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ b f10936h;

        public a(b r10) {
            this.f10936h = r10;
            this.f10934c = new m(b.m(r10).timeout());
        }

        @Override // okio.f0
        public long S(okio.d r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "sink");
            return b.m(this.f10936h).S(r10, r11);
        L5:
            e = move-exception;
            this.f10936h.e().A();
            c();
            throw e;
        }

        protected final boolean a() {
            return this.f10935g;
        }

        public final void c() {
            if (b.n(this.f10936h) != 6) goto L6;
            return;
        L6:
            if (b.n(this.f10936h) != 5) goto L10;
            b.i(this.f10936h, this.f10934c);
            b.p(this.f10936h, 6);
            return;
        L10:
            throw new IllegalStateException("state: " + b.n(this.f10936h));
        }

        protected final void f(boolean r10) {
            this.f10935g = r10;
        }

        @Override // okio.f0
        public g0 timeout() {
            return this.f10934c;
        }
    }

    /* JADX INFO: renamed from: lc.b$b, reason: collision with other inner class name */
    @SourceDebugExtension({"SMAP\nHttp1ExchangeCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http1ExchangeCodec.kt\nokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSink\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,505:1\n1#2:506\n*E\n"})
    private final class C0236b implements d0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final m f10937c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f10938g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ b f10939h;

        public C0236b(b r10) {
            this.f10939h = r10;
            this.f10937c = new m(b.l(r10).timeout());
        }

        @Override // okio.d0, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.f10938g == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.f10938g = true;     // Catch: Throwable -> L11
            b.l(this.f10939h).t("0\r\n\r\n");     // Catch: Throwable -> L11
            b.i(this.f10939h, this.f10937c);     // Catch: Throwable -> L11
            b.p(this.f10939h, 3);     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        @Override // okio.d0, java.io.Flushable
        public synchronized void flush() {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.f10938g == false) goto L7;
            monitor-exit(this);
            return;
        L7:
            b.l(this.f10939h).flush();     // Catch: Throwable -> L10
            monitor-exit(this);
        }

        @Override // okio.d0
        public g0 timeout() {
            return this.f10937c;
        }

        @Override // okio.d0
        public void x(okio.d r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "source");
            if ((!this.f10938g) == false) goto L10;
            if (r11 != 0) goto L7;
            return;
        L7:
            b.l(this.f10939h).z(r11);
            b.l(this.f10939h).t("\r\n");
            b.l(this.f10939h).x(r10, r11);
            b.l(this.f10939h).t("\r\n");
            return;
        L10:
            throw new IllegalStateException("closed".toString());
        }
    }

    @SourceDebugExtension({"SMAP\nHttp1ExchangeCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http1ExchangeCodec.kt\nokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,505:1\n1#2:506\n*E\n"})
    private final class c extends a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final s f10940i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f10941j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f10942k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ b f10943l;

        public c(b r10, s r11) {
            Intrinsics.checkNotNullParameter(r11, "url");
            this.f10943l = r10;
            super(r10);
            this.f10940i = r11;
            this.f10941j = -1;
            this.f10942k = true;
        }

        private final void i() {
            if (this.f10941j == (-1)) goto L23;
            b.m(this.f10943l).E();
        L23:
            this.f10941j = b.m(this.f10943l).Z();     // Catch: NumberFormatException -> L20
            String r10 = StringsKt.trim(b.m(this.f10943l).E()).toString();     // Catch: NumberFormatException -> L20
            if (this.f10941j < 0) goto L19;
            if (r10.length() <= 0) goto L10;
            boolean r11 = true;
        L11:
            if (r11 == false) goto L15;
            if (StringsKt.startsWith$default(r10, ";", false, 2, null) == false) goto L19;
        L15:
            if (this.f10941j != 0) goto L25;
            this.f10942k = false;
            b r12 = this.f10943l;
            b.q(r12, b.k(r12).a());
            w r13 = b.j(this.f10943l);
            Intrinsics.checkNotNull(r13);
            okhttp3.m r14 = r13.n();
            s r15 = this.f10940i;
            r r16 = b.o(this.f10943l);
            Intrinsics.checkNotNull(r16);
            kc.e.f(r14, r15, r16);
            c();
            return;
        L25:
            return;
        L10:
            r11 = false;
        L19:
            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f10941j + r10 + Typography.quote);     // Catch: NumberFormatException -> L20
        L20:
            e = move-exception;
            throw new ProtocolException(e.getMessage());
        }

        @Override // lc.b.a, okio.f0
        public long S(okio.d r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "sink");
            if (r11 < 0) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L28;
            if ((!a()) == false) goto L26;
            if (this.f10942k == true) goto L12;
            return -1;
        L12:
            long r13 = this.f10941j;
            if (r13 != 0) goto L15;
        L16:
            i();
            if (this.f10942k == true) goto L19;
            return -1;
        L19:
            long r14 = super.S(r10, Math.min(r11, this.f10941j));
            if (r14 == (-1)) goto L23;
            this.f10941j -= r14;
            return r14;
        L23:
            this.f10943l.e().A();
            ProtocolException r15 = new ProtocolException("unexpected end of stream");
            c();
            throw r15;
        L15:
            if (r13 != (-1)) goto L19;
        L26:
            throw new IllegalStateException("closed".toString());
        L28:
            throw new IllegalArgumentException(("byteCount < 0: " + r11).toString());
        L5:
            r12 = false;
            goto L6
        }

        @Override // okio.f0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (a() == false) goto L6;
            return;
        L6:
            if (this.f10942k == true) goto L8;
        L10:
            f(true);
            return;
        L8:
            if (hc.e.s(this, 100, TimeUnit.MILLISECONDS) == true) goto L10;
            this.f10943l.e().A();
            c();
            goto L10
        }
    }

    public static final class d {
        private d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker r10) {
            this();
        }
    }

    @SourceDebugExtension({"SMAP\nHttp1ExchangeCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http1ExchangeCodec.kt\nokhttp3/internal/http1/Http1ExchangeCodec$FixedLengthSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,505:1\n1#2:506\n*E\n"})
    private final class e extends a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f10944i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ b f10945j;

        public e(b r10, long r11) {
            this.f10945j = r10;
            super(r10);
            this.f10944i = r11;
            if (r11 != 0) goto L6;
            c();
            return;
        }

        @Override // lc.b.a, okio.f0
        public long S(okio.d r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "sink");
            if (r11 < 0) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L23;
            if ((!a()) == false) goto L21;
            long r13 = this.f10944i;
            if (r13 != 0) goto L12;
            return -1;
        L12:
            long r14 = super.S(r10, Math.min(r13, r11));
            if (r14 == (-1)) goto L18;
            long r15 = this.f10944i - r14;
            this.f10944i = r15;
            if (r15 != 0) goto L17;
            c();
        L17:
            return r14;
        L18:
            this.f10945j.e().A();
            ProtocolException r16 = new ProtocolException("unexpected end of stream");
            c();
            throw r16;
        L21:
            throw new IllegalStateException("closed".toString());
        L23:
            throw new IllegalArgumentException(("byteCount < 0: " + r11).toString());
        L5:
            r12 = false;
            goto L6
        }

        @Override // okio.f0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (a() == false) goto L6;
            return;
        L6:
            if (this.f10944i != 0) goto L8;
        L10:
            f(true);
            return;
        L8:
            if (hc.e.s(this, 100, TimeUnit.MILLISECONDS) == true) goto L10;
            this.f10945j.e().A();
            c();
            goto L10
        }
    }

    @SourceDebugExtension({"SMAP\nHttp1ExchangeCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http1ExchangeCodec.kt\nokhttp3/internal/http1/Http1ExchangeCodec$KnownLengthSink\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,505:1\n1#2:506\n*E\n"})
    private final class f implements d0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final m f10946c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f10947g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ b f10948h;

        public f(b r10) {
            this.f10948h = r10;
            this.f10946c = new m(b.l(r10).timeout());
        }

        @Override // okio.d0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f10947g == false) goto L5;
            return;
        L5:
            this.f10947g = true;
            b.i(this.f10948h, this.f10946c);
            b.p(this.f10948h, 3);
        }

        @Override // okio.d0, java.io.Flushable
        public void flush() {
            if (this.f10947g == false) goto L5;
            return;
        L5:
            b.l(this.f10948h).flush();
        }

        @Override // okio.d0
        public g0 timeout() {
            return this.f10946c;
        }

        @Override // okio.d0
        public void x(okio.d r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "source");
            if ((!this.f10947g) == false) goto L7;
            hc.e.l(r10.M(), 0, r11);
            b.l(this.f10948h).x(r10, r11);
            return;
        L7:
            throw new IllegalStateException("closed".toString());
        }
    }

    @SourceDebugExtension({"SMAP\nHttp1ExchangeCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http1ExchangeCodec.kt\nokhttp3/internal/http1/Http1ExchangeCodec$UnknownLengthSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,505:1\n1#2:506\n*E\n"})
    private final class g extends a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f10949i;

        public g(b r10) {
            super(r10);
        }

        @Override // lc.b.a, okio.f0
        public long S(okio.d r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "sink");
            if (r11 < 0) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L20;
            if ((!a()) == false) goto L18;
            if (this.f10949i == false) goto L12;
            return -1;
        L12:
            long r13 = super.S(r10, r11);
            if (r13 != (-1)) goto L16;
            this.f10949i = true;
            c();
            return -1;
        L16:
            return r13;
        L18:
            throw new IllegalStateException("closed".toString());
        L20:
            throw new IllegalArgumentException(("byteCount < 0: " + r11).toString());
        L5:
            r12 = false;
            goto L6
        }

        @Override // okio.f0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (a() == false) goto L6;
            return;
        L6:
            if (this.f10949i == true) goto L8;
            c();
        L8:
            f(true);
        }
    }

    static {
        new d(null);
    }

    public b(w r10, RealConnection r11, okio.f r12, okio.e r13) {
        Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION);
        Intrinsics.checkNotNullParameter(r12, "source");
        Intrinsics.checkNotNullParameter(r13, "sink");
        this.f10927a = r10;
        this.f10928b = r11;
        this.f10929c = r12;
        this.f10930d = r13;
        this.f10932f = new lc.a(r12);
    }

    public static final /* synthetic */ void i(b r10, m r11) {
        r10.r(r11);
    }

    public static final /* synthetic */ w j(b r10) {
        return r10.f10927a;
    }

    public static final /* synthetic */ lc.a k(b r10) {
        return r10.f10932f;
    }

    public static final /* synthetic */ okio.e l(b r10) {
        return r10.f10930d;
    }

    public static final /* synthetic */ okio.f m(b r10) {
        return r10.f10929c;
    }

    public static final /* synthetic */ int n(b r10) {
        return r10.f10931e;
    }

    public static final /* synthetic */ r o(b r10) {
        return r10.f10933g;
    }

    public static final /* synthetic */ void p(b r10, int r11) {
        r10.f10931e = r11;
    }

    public static final /* synthetic */ void q(b r10, r r11) {
        r10.f10933g = r11;
    }

    private final void r(m r10) {
        g0 r11 = r10.i();
        r10.j(g0.f12214d);
        r11.a();
        r11.b();
    }

    private final boolean s(x r10) {
        return StringsKt.equals("chunked", r10.d("Transfer-Encoding"), true);
    }

    private final boolean t(z r10) {
        return StringsKt.equals("chunked", z.s(r10, "Transfer-Encoding", null, 2, null), true);
    }

    private final d0 u() {
        boolean r10 = true;
        if (this.f10931e == 1) goto L6;
        r10 = false;
    L6:
        if (r10 == false) goto L10;
        this.f10931e = 2;
        return new C0236b(this);
    L10:
        throw new IllegalStateException(("state: " + this.f10931e).toString());
    }

    private final f0 v(s r10) {
        if (this.f10931e != 4) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L10;
        this.f10931e = 5;
        return new c(this, r10);
    L10:
        throw new IllegalStateException(("state: " + this.f10931e).toString());
    L5:
        r11 = false;
        goto L6
    }

    private final f0 w(long r10) {
        if (this.f10931e != 4) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L10;
        this.f10931e = 5;
        return new e(this, r10);
    L10:
        throw new IllegalStateException(("state: " + this.f10931e).toString());
    L5:
        r11 = false;
        goto L6
    }

    private final d0 x() {
        boolean r10 = true;
        if (this.f10931e == 1) goto L6;
        r10 = false;
    L6:
        if (r10 == false) goto L10;
        this.f10931e = 2;
        return new f(this);
    L10:
        throw new IllegalStateException(("state: " + this.f10931e).toString());
    }

    private final f0 y() {
        if (this.f10931e != 4) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L10;
        this.f10931e = 5;
        e().A();
        return new g(this);
    L10:
        throw new IllegalStateException(("state: " + this.f10931e).toString());
    L5:
        r10 = false;
        goto L6
    }

    public final void A(r r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "headers");
        Intrinsics.checkNotNullParameter(r11, "requestLine");
        int r12 = 0;
        if (this.f10931e != 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L13;
        this.f10930d.t(r11).t("\r\n");
        int r14 = r10.size();
    L8:
        if (r12 >= r14) goto L10;
        this.f10930d.t(r10.c(r12)).t(": ").t(r10.i(r12)).t("\r\n");
        r12 = r12 + 1;
        goto L8
    L10:
        this.f10930d.t("\r\n");
        this.f10931e = 1;
        return;
    L13:
        throw new IllegalStateException(("state: " + this.f10931e).toString());
    L5:
        r13 = false;
        goto L6
    }

    @Override // kc.d
    public void a() {
        this.f10930d.flush();
    }

    @Override // kc.d
    public void b(x r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        i r11 = i.f10179a;
        Proxy.Type r12 = e().a().c().type();
        Intrinsics.checkNotNullExpressionValue(r12, "connection.route().proxy.type()");
        String r13 = r11.a(r10, r12);
        A(r10.e(), r13);
    }

    @Override // kc.d
    public f0 c(z r10) {
        Intrinsics.checkNotNullParameter(r10, "response");
        if (kc.e.b(r10) == true) goto L7;
        long r11 = 0;
    L14:
        return w(r11);
    L7:
        if (t(r10) == true) goto L15;
        r11 = hc.e.v(r10);
        if (r11 != (-1)) goto L14;
        return y();
    L15:
        return v(r10.K().l());
    }

    @Override // kc.d
    public void cancel() {
        e().f();
    }

    @Override // kc.d
    public z.a d(boolean r10) {
        int r11 = this.f10931e;
        boolean r12 = false;
        if (r11 != 1) goto L5;
    L9:
        boolean r13 = true;
    L10:
        if (r13 == false) goto L32;
        k r14 = k.f10188d.a(this.f10932f.b());     // Catch: EOFException -> L28
        z.a r15 = new z.a().p(r14.f10189a).g(r14.f10190b).m(r14.f10191c).k(this.f10932f.a());     // Catch: EOFException -> L28
        if (r10 == true) goto L14;
    L16:
        int r16 = r14.f10190b;     // Catch: EOFException -> L28
        if (r16 != 100) goto L20;
    L18:
        this.f10931e = 3;     // Catch: EOFException -> L28
        return r15;
    L20:
        if (102 <= r16) goto L22;
    L24:
        if (r12 == true) goto L18;
        this.f10931e = 4;     // Catch: EOFException -> L28
        return r15;
    L22:
        if (r16 >= 200) goto L24;
        r12 = true;
        goto L24
    L14:
        if (r14.f10190b != 100) goto L16;
        return null;
    L28:
        e = move-exception;
        throw new IOException("unexpected end of stream on " + e().a().a().m().p(), e);
    L32:
        throw new IllegalStateException(("state: " + this.f10931e).toString());
    L5:
        if (r11 == 2) goto L9;
        if (r11 == 3) goto L9;
        r13 = false;
        goto L10
    }

    @Override // kc.d
    public RealConnection e() {
        return this.f10928b;
    }

    @Override // kc.d
    public void f() {
        this.f10930d.flush();
    }

    @Override // kc.d
    public long g(z r10) {
        Intrinsics.checkNotNullParameter(r10, "response");
        if (kc.e.b(r10) == true) goto L6;
        return 0;
    L6:
        if (t(r10) == false) goto L9;
        return -1;
    L9:
        return hc.e.v(r10);
    }

    @Override // kc.d
    public d0 h(x r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "request");
        if (r10.a() == null) goto L10;
        if (r10.a().e() == false) goto L10;
        throw new ProtocolException("Duplex connections are not supported for HTTP/1");
    L10:
        if (s(r10) == false) goto L13;
        return u();
    L13:
        if (r11 == (-1)) goto L17;
        return x();
    L17:
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public final void z(z r10) {
        Intrinsics.checkNotNullParameter(r10, "response");
        long r11 = hc.e.v(r10);
        if (r11 != (-1)) goto L5;
        return;
    L5:
        f0 r12 = w(r11);
        hc.e.M(r12, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        r12.close();
    }
}
