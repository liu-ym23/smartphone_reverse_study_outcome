package okhttp3;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.io.Closeable;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nResponse.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Response.kt\nokhttp3/Response\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,455:1\n1#2:456\n*E\n"})
public final class z implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x f12137c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Protocol f12138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f12139h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f12140i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Handshake f12141j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final r f12142k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final a0 f12143l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final z f12144m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final z f12145n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final z f12146o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final long f12147p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final long f12148q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final okhttp3.internal.connection.c f12149r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private d f12150s;

    @SourceDebugExtension({"SMAP\nResponse.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Response.kt\nokhttp3/Response$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,455:1\n1#2:456\n*E\n"})
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private x f12151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Protocol f12152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f12153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f12154d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Handshake f12155e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private r.a f12156f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private a0 f12157g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private z f12158h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private z f12159i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private z f12160j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f12161k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f12162l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private okhttp3.internal.connection.c f12163m;

        public a() {
            this.f12153c = -1;
            this.f12156f = new r.a();
        }

        public a(z r10) {
            Intrinsics.checkNotNullParameter(r10, "response");
            this.f12153c = -1;
            this.f12151a = r10.K();
            this.f12152b = r10.I();
            this.f12153c = r10.k();
            this.f12154d = r10.C();
            this.f12155e = r10.o();
            this.f12156f = r10.v().e();
            this.f12157g = r10.a();
            this.f12158h = r10.D();
            this.f12159i = r10.f();
            this.f12160j = r10.G();
            this.f12161k = r10.M();
            this.f12162l = r10.J();
            this.f12163m = r10.l();
        }

        private final void e(z r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r10.a() != null) goto L6;
            boolean r11 = true;
        L7:
            if (r11 == false) goto L10;
            return;
        L10:
            throw new IllegalArgumentException("priorResponse.body != null".toString());
        L6:
            r11 = false;
            goto L7
        }

        private final void f(String r10, z r11) {
            if (r11 == null) goto L32;
            boolean r12 = true;
            if (r11.a() != null) goto L6;
            boolean r13 = true;
        L7:
            if (r13 == false) goto L31;
            if (r11.D() != null) goto L11;
            boolean r14 = true;
        L12:
            if (r14 == false) goto L29;
            if (r11.f() != null) goto L16;
            boolean r15 = true;
        L17:
            if (r15 == false) goto L27;
            if (r11.G() == null) goto L22;
            r12 = false;
        L22:
            if (r12 == false) goto L25;
            return;
        L25:
            throw new IllegalArgumentException((r10 + ".priorResponse != null").toString());
        L27:
            throw new IllegalArgumentException((r10 + ".cacheResponse != null").toString());
        L16:
            r15 = false;
            goto L17
        L29:
            throw new IllegalArgumentException((r10 + ".networkResponse != null").toString());
        L11:
            r14 = false;
            goto L12
        L31:
            throw new IllegalArgumentException((r10 + ".body != null").toString());
        L6:
            r13 = false;
            goto L7
        }

        public a a(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
            this.f12156f.a(r10, r11);
            return this;
        }

        public a b(a0 r10) {
            this.f12157g = r10;
            return this;
        }

        public z c() {
            int r10 = this.f12153c;
            if (r10 < 0) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L22;
            x r12 = this.f12151a;
            if (r12 == null) goto L20;
            Protocol r13 = this.f12152b;
            if (r13 == null) goto L18;
            String r14 = this.f12154d;
            if (r14 == null) goto L16;
            return new z(r12, r13, r14, r10, this.f12155e, this.f12156f.e(), this.f12157g, this.f12158h, this.f12159i, this.f12160j, this.f12161k, this.f12162l, this.f12163m);
        L16:
            throw new IllegalStateException("message == null".toString());
        L18:
            throw new IllegalStateException("protocol == null".toString());
        L20:
            throw new IllegalStateException("request == null".toString());
        L22:
            throw new IllegalStateException(("code < 0: " + this.f12153c).toString());
        L5:
            r11 = false;
            goto L6
        }

        public a d(z r10) {
            f("cacheResponse", r10);
            this.f12159i = r10;
            return this;
        }

        public a g(int r10) {
            this.f12153c = r10;
            return this;
        }

        public final int h() {
            return this.f12153c;
        }

        public a i(Handshake r10) {
            this.f12155e = r10;
            return this;
        }

        public a j(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
            this.f12156f.h(r10, r11);
            return this;
        }

        public a k(r r10) {
            Intrinsics.checkNotNullParameter(r10, "headers");
            this.f12156f = r10.e();
            return this;
        }

        public final void l(okhttp3.internal.connection.c r10) {
            Intrinsics.checkNotNullParameter(r10, "deferredTrailers");
            this.f12163m = r10;
        }

        public a m(String r10) {
            Intrinsics.checkNotNullParameter(r10, "message");
            this.f12154d = r10;
            return this;
        }

        public a n(z r10) {
            f("networkResponse", r10);
            this.f12158h = r10;
            return this;
        }

        public a o(z r10) {
            e(r10);
            this.f12160j = r10;
            return this;
        }

        public a p(Protocol r10) {
            Intrinsics.checkNotNullParameter(r10, "protocol");
            this.f12152b = r10;
            return this;
        }

        public a q(long r10) {
            this.f12162l = r10;
            return this;
        }

        public a r(x r10) {
            Intrinsics.checkNotNullParameter(r10, "request");
            this.f12151a = r10;
            return this;
        }

        public a s(long r10) {
            this.f12161k = r10;
            return this;
        }
    }

    public z(x r10, Protocol r11, String r12, int r13, Handshake r14, r r15, a0 r16, z r17, z r18, z r19, long r110, long r111, okhttp3.internal.connection.c r21) {
        Intrinsics.checkNotNullParameter(r10, "request");
        Intrinsics.checkNotNullParameter(r11, "protocol");
        Intrinsics.checkNotNullParameter(r12, "message");
        Intrinsics.checkNotNullParameter(r15, "headers");
        this.f12137c = r10;
        this.f12138g = r11;
        this.f12139h = r12;
        this.f12140i = r13;
        this.f12141j = r14;
        this.f12142k = r15;
        this.f12143l = r16;
        this.f12144m = r17;
        this.f12145n = r18;
        this.f12146o = r19;
        this.f12147p = r110;
        this.f12148q = r111;
        this.f12149r = r21;
    }

    public static /* synthetic */ String s(z r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = null;
    L6:
        return r10.r(r11, r12);
    }

    public final boolean A() {
        int r10 = this.f12140i;
        if (r10 != 307) goto L5;
    L8:
        return true;
    L5:
        if (r10 == 308) goto L8;
        switch(r10) {
            case 300: goto L8;
            case 301: goto L8;
            case 302: goto L8;
            case 303: goto L8;
            default: goto L7;
        };
    L7:
        return false;
    }

    public final boolean B() {
        int r10 = this.f12140i;
        if (200 <= r10) goto L5;
        return false;
    L5:
        if (r10 >= 300) goto L9;
        return true;
    L9:
        return false;
    }

    @JvmName(name = "message")
    public final String C() {
        return this.f12139h;
    }

    @JvmName(name = "networkResponse")
    public final z D() {
        return this.f12144m;
    }

    public final a F() {
        return new a(this);
    }

    @JvmName(name = "priorResponse")
    public final z G() {
        return this.f12146o;
    }

    @JvmName(name = "protocol")
    public final Protocol I() {
        return this.f12138g;
    }

    @JvmName(name = "receivedResponseAtMillis")
    public final long J() {
        return this.f12148q;
    }

    @JvmName(name = "request")
    public final x K() {
        return this.f12137c;
    }

    @JvmName(name = "sentRequestAtMillis")
    public final long M() {
        return this.f12147p;
    }

    @JvmName(name = "body")
    public final a0 a() {
        return this.f12143l;
    }

    @JvmName(name = "cacheControl")
    public final d c() {
        d r10 = this.f12150s;
        if (r10 != null) goto L6;
        d r11 = d.f11688n.b(this.f12142k);
        this.f12150s = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a0 r10 = this.f12143l;
        if (r10 == null) goto L7;
        r10.close();
        return;
    L7:
        throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
    }

    @JvmName(name = "cacheResponse")
    public final z f() {
        return this.f12145n;
    }

    public final List<g> i() {
        r r10 = this.f12142k;
        int r11 = this.f12140i;
        if (r11 != 401) goto L5;
        String r12 = "WWW-Authenticate";
    L11:
        return kc.e.a(r10, r12);
    L5:
        if (r11 != 407) goto L7;
        r12 = "Proxy-Authenticate";
        goto L11
    L7:
        return CollectionsKt.emptyList();
    }

    @JvmName(name = "code")
    public final int k() {
        return this.f12140i;
    }

    @JvmName(name = "exchange")
    public final okhttp3.internal.connection.c l() {
        return this.f12149r;
    }

    @JvmName(name = "handshake")
    public final Handshake o() {
        return this.f12141j;
    }

    @JvmOverloads
    public final String p(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return s(this, r10, null, 2, null);
    }

    @JvmOverloads
    public final String r(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        String r12 = this.f12142k.b(r10);
        if (r12 != null) goto L6;
        return r11;
    L6:
        return r12;
    }

    public String toString() {
        return "Response{protocol=" + this.f12138g + ", code=" + this.f12140i + ", message=" + this.f12139h + ", url=" + this.f12137c.l() + '}';
    }

    public final List<String> u(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return this.f12142k.j(r10);
    }

    @JvmName(name = "headers")
    public final r v() {
        return this.f12142k;
    }
}
