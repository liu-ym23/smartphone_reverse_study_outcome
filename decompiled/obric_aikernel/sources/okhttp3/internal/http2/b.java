package okhttp3.internal.http2;

import androidx.core.internal.view.SupportMenu;
import com.bytedance.common.wschannel.WsConstants;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nHttp2Connection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n+ 2 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue\n+ 3 Util.kt\nokhttp3/internal/Util\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,1006:1\n84#2,4:1007\n90#2,13:1014\n90#2,13:1027\n90#2,13:1069\n90#2,13:1082\n90#2,13:1095\n90#2,13:1108\n90#2,13:1121\n90#2,13:1134\n563#3:1011\n557#3:1013\n557#3:1040\n615#3,4:1041\n402#3,5:1045\n402#3,5:1053\n402#3,5:1059\n402#3,5:1064\n1#4:1012\n37#5,2:1050\n13309#6:1052\n13310#6:1058\n*S KotlinDebug\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n*L\n152#1:1007,4\n340#1:1014,13\n361#1:1027,13\n506#1:1069,13\n554#1:1082,13\n893#1:1095,13\n911#1:1108,13\n938#1:1121,13\n952#1:1134,13\n183#1:1011\n319#1:1013\n402#1:1040\n446#1:1041,4\n448#1:1045,5\n461#1:1053,5\n467#1:1059,5\n472#1:1064,5\n455#1:1050,2\n460#1:1052\n460#1:1058\n*E\n"})
public final class b implements Closeable {
    public static final C0262b H = null;
    private static final mc.g I = null;
    private long A;
    private long B;
    private long C;
    private final Socket D;
    private final okhttp3.internal.http2.d E;
    private final d F;
    private final Set<Integer> G;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f11863c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c f11864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<Integer, mc.d> f11865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f11866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f11867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f11868k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f11869l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final jc.e f11870m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final jc.d f11871n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final jc.d f11872o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final jc.d f11873p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final mc.f f11874q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f11875r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f11876s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f11877t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f11878u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f11879v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f11880w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final mc.g f11881x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private mc.g f11882y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f11883z;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f11884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final jc.e f11885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Socket f11886c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f11887d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public okio.f f11888e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public okio.e f11889f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private c f11890g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private mc.f f11891h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f11892i;

        public a(boolean r10, jc.e r11) {
            Intrinsics.checkNotNullParameter(r11, "taskRunner");
            this.f11884a = r10;
            this.f11885b = r11;
            this.f11890g = c.f11893a;
            this.f11891h = mc.f.f11150a;
        }

        public final b a() {
            return new b(this);
        }

        public final boolean b() {
            return this.f11884a;
        }

        public final String c() {
            String r10 = this.f11887d;
            if (r10 == null) goto L5;
            return r10;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("connectionName");
            return null;
        }

        public final c d() {
            return this.f11890g;
        }

        public final int e() {
            return this.f11892i;
        }

        public final mc.f f() {
            return this.f11891h;
        }

        public final okio.e g() {
            okio.e r10 = this.f11889f;
            if (r10 == null) goto L5;
            return r10;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("sink");
            return null;
        }

        public final Socket h() {
            Socket r10 = this.f11886c;
            if (r10 == null) goto L5;
            return r10;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("socket");
            return null;
        }

        public final okio.f i() {
            okio.f r10 = this.f11888e;
            if (r10 == null) goto L5;
            return r10;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("source");
            return null;
        }

        public final jc.e j() {
            return this.f11885b;
        }

        public final a k(c r10) {
            Intrinsics.checkNotNullParameter(r10, "listener");
            this.f11890g = r10;
            return this;
        }

        public final a l(int r10) {
            this.f11892i = r10;
            return this;
        }

        public final void m(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.f11887d = r10;
        }

        public final void n(okio.e r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.f11889f = r10;
        }

        public final void o(Socket r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.f11886c = r10;
        }

        public final void p(okio.f r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.f11888e = r10;
        }

        @JvmOverloads
        public final a q(Socket r10, String r11, okio.f r12, okio.e r13) {
            Intrinsics.checkNotNullParameter(r10, "socket");
            Intrinsics.checkNotNullParameter(r11, "peerName");
            Intrinsics.checkNotNullParameter(r12, "source");
            Intrinsics.checkNotNullParameter(r13, "sink");
            o(r10);
            if (this.f11884a == false) goto L5;
            StringBuilder r14 = new StringBuilder();
            r14.append(hc.e.f9284h);
            r14.append(' ');
        L6:
            r14.append(r11);
            m(r14.toString());
            p(r12);
            n(r13);
            return this;
        L5:
            r14 = new StringBuilder();
            r14.append("MockWebServer ");
            goto L6
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.http2.b$b, reason: collision with other inner class name */
    public static final class C0262b {
        private C0262b() {
        }

        public /* synthetic */ C0262b(DefaultConstructorMarker r10) {
            this();
        }

        public final mc.g a() {
            return b.i();
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public static final c f11893a = null;

        public static final class a extends c {
            a() {
            }

            @Override // okhttp3.internal.http2.b.c
            public void d(mc.d r10) {
                Intrinsics.checkNotNullParameter(r10, "stream");
                r10.d(ErrorCode.REFUSED_STREAM, null);
            }
        }

        /* JADX INFO: renamed from: okhttp3.internal.http2.b$c$b, reason: collision with other inner class name */
        public static final class C0263b {
            private C0263b() {
            }

            public /* synthetic */ C0263b(DefaultConstructorMarker r10) {
                this();
            }
        }

        static {
            new C0263b(null);
            f11893a = new a();
        }

        public c() {
        }

        public void c(b r10, mc.g r11) {
            Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION);
            Intrinsics.checkNotNullParameter(r11, "settings");
        }

        public abstract void d(mc.d r10);
    }

    @SourceDebugExtension({"SMAP\nHttp2Connection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection$ReaderRunnable\n+ 2 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 Util.kt\nokhttp3/internal/Util\n*L\n1#1,1006:1\n90#2,13:1007\n90#2,13:1020\n90#2,13:1035\n90#2,13:1049\n37#3,2:1033\n37#3,2:1062\n563#4:1048\n563#4:1064\n*S KotlinDebug\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection$ReaderRunnable\n*L\n687#1:1007,13\n715#1:1020,13\n758#1:1035,13\n806#1:1049,13\n753#1:1033,2\n824#1:1062,2\n797#1:1048\n841#1:1064\n*E\n"})
    public final class d implements okhttp3.internal.http2.c.InterfaceC0266c, Function0<Unit> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final okhttp3.internal.http2.c f11894c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f11895g;

        @SourceDebugExtension({"SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue$execute$1\n+ 2 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection$ReaderRunnable\n*L\n1#1,218:1\n759#2,2:219\n*E\n"})
        public static final class a extends jc.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f11896e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef f11897f;

            public a(String r10, boolean r11, b r12, Ref.ObjectRef r13) {
                this.f11896e = r12;
                this.f11897f = r13;
                super(r10, r11);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // jc.a
            public long f() {
                this.f11896e.P().c(this.f11896e, (mc.g) this.f11897f.element);
                return -1;
            }
        }

        /* JADX INFO: renamed from: okhttp3.internal.http2.b$d$b, reason: collision with other inner class name */
        @SourceDebugExtension({"SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue$execute$1\n+ 2 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection$ReaderRunnable\n+ 3 Util.kt\nokhttp3/internal/Util\n*L\n1#1,218:1\n688#2,5:219\n693#2,2:226\n696#2:231\n402#3,2:224\n404#3,3:228\n*S KotlinDebug\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection$ReaderRunnable\n*L\n692#1:224,2\n692#1:228,3\n*E\n"})
        public static final class C0264b extends jc.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f11898e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ mc.d f11899f;

            public C0264b(String r10, boolean r11, b r12, mc.d r13) {
                this.f11898e = r12;
                this.f11899f = r13;
                super(r10, r11);
            }

            @Override // jc.a
            public long f() {
                this.f11898e.P().d(this.f11899f);     // Catch: IOException -> L4
                return -1;
            L4:
                e = move-exception;
                okhttp3.internal.platform.h.f11979a.g().j("Http2Connection.Listener failure for " + this.f11898e.M(), 4, e);
                this.f11899f.d(ErrorCode.PROTOCOL_ERROR, e);     // Catch: IOException -> L9
                return -1;
            L15:
                return -1;
            }
        }

        @SourceDebugExtension({"SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue$execute$1\n+ 2 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection$ReaderRunnable\n*L\n1#1,218:1\n807#2,2:219\n*E\n"})
        public static final class c extends jc.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f11900e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f11901f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f11902g;

            public c(String r10, boolean r11, b r12, int r13, int r14) {
                this.f11900e = r12;
                this.f11901f = r13;
                this.f11902g = r14;
                super(r10, r11);
            }

            @Override // jc.a
            public long f() {
                this.f11900e.x0(true, this.f11901f, this.f11902g);
                return -1;
            }
        }

        /* JADX INFO: renamed from: okhttp3.internal.http2.b$d$d, reason: collision with other inner class name */
        @SourceDebugExtension({"SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue$execute$1\n+ 2 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection$ReaderRunnable\n*L\n1#1,218:1\n716#2,2:219\n*E\n"})
        public static final class C0265d extends jc.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ d f11903e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f11904f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ mc.g f11905g;

            public C0265d(String r10, boolean r11, d r12, boolean r13, mc.g r14) {
                this.f11903e = r12;
                this.f11904f = r13;
                this.f11905g = r14;
                super(r10, r11);
            }

            @Override // jc.a
            public long f() {
                this.f11903e.k(this.f11904f, this.f11905g);
                return -1;
            }
        }

        public d(b r10, okhttp3.internal.http2.c r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            this.f11895g = r10;
            this.f11894c = r11;
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0266c
        public void a() {
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0266c
        public void b(boolean r10, mc.g r11) {
            Intrinsics.checkNotNullParameter(r11, "settings");
            b.u(this.f11895g).i(new C0265d(this.f11895g.M() + " applyAndAckSettings", true, this, r10, r11), 0);
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0266c
        public void c(boolean r10, int r11, int r12, List<mc.a> r13) {
            Intrinsics.checkNotNullParameter(r13, "headerBlock");
            boolean r14 = this.f11895g.m0(r11);
            b r15 = this.f11895g;
            if (r14 == false) goto L6;
            r15.j0(r11, r13, r10);
            return;
        L6:
            monitor-enter(r15);
            mc.d r16 = r15.a0(r11);     // Catch: Throwable -> L28
            if (r16 == null) goto L10;
            Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L28
            monitor-exit(r15);
            r16.x(hc.e.Q(r13), r10);
            return;
        L10:
            if (b.v(r15) == false) goto L14;
            monitor-exit(r15);
            return;
        L14:
            if (r11 > r15.N()) goto L18;
            monitor-exit(r15);
            return;
        L18:
            if ((r11 % 2) != (r15.Q() % 2)) goto L21;
            monitor-exit(r15);
            return;
        L21:
            mc.d r18 = new mc.d(r11, r15, false, r10, hc.e.Q(r13));     // Catch: Throwable -> L28
            r15.p0(r11);     // Catch: Throwable -> L28
            r15.c0().put(Integer.valueOf(r11), r18);     // Catch: Throwable -> L28
            b.s(r15).i().i(new C0264b(r15.M() + '[' + r11 + "] onStream", true, r15, r18), 0);     // Catch: Throwable -> L28
            monitor-exit(r15);
            return;
        L28:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // okhttp3.internal.http2.c.InterfaceC0266c
        public void d(int r10, long r11) {
            b r12 = this.f11895g;
            if (r10 != 0) goto L10;
            monitor-enter(r12);
            b.G(r12, r12.d0() + r11);     // Catch: Throwable -> L7
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L7
            r12.notifyAll();     // Catch: Throwable -> L7
            Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L7
            b r14 = r12;
        L14:
            monitor-exit(r14);
            return;
        L7:
            th = move-exception;
            throw th;
        L10:
            mc.d r15 = r12.a0(r10);
            if (r15 == null) goto L19;
            monitor-enter(r15);
            r15.a(r11);     // Catch: Throwable -> L16
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L16
            r14 = r15;
        L16:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0266c
        public void e(boolean r10, int r11, okio.f r12, int r13) {
            Intrinsics.checkNotNullParameter(r12, "source");
            if (this.f11895g.m0(r11) == false) goto L6;
            this.f11895g.i0(r11, r12, r13, r10);
            return;
        L6:
            mc.d r14 = this.f11895g.a0(r11);
            if (r14 != null) goto L10;
            this.f11895g.z0(r11, ErrorCode.PROTOCOL_ERROR);
            long r15 = r13;
            this.f11895g.u0(r15);
            r12.skip(r15);
            return;
        L10:
            r14.w(r12, r13);
            if (r10 == false) goto L14;
            r14.x(hc.e.f9278b, true);
            return;
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0266c
        public void f(boolean r10, int r11, int r12) {
            if (r10 == false) goto L20;
            b r13 = this.f11895g;
            monitor-enter(r13);
            if (r11 != 1) goto L8;
            b.D(r13, b.o(r13) + 1);     // Catch: Throwable -> L17
        L15:
            monitor-exit(r13);
            return;
        L8:
            if (r11 != 2) goto L10;
            b.B(r13, b.k(r13) + 1);     // Catch: Throwable -> L17
            goto L15
        L10:
            if (r11 == 3) goto L12;
        L11:
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L17
            goto L15
        L12:
            b.A(r13, b.c(r13) + 1);     // Catch: Throwable -> L17
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L17
            r13.notifyAll();     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;
        L20:
            b.u(this.f11895g).i(new c(this.f11895g.M() + " ping", true, this.f11895g, r11, r12), 0);
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0266c
        public void g(int r10, int r11, int r12, boolean r13) {
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0266c
        public void h(int r10, ErrorCode r11) {
            Intrinsics.checkNotNullParameter(r11, "errorCode");
            boolean r12 = this.f11895g.m0(r10);
            b r13 = this.f11895g;
            if (r12 == false) goto L6;
            r13.l0(r10, r11);
            return;
        L6:
            mc.d r14 = r13.n0(r10);
            if (r14 == null) goto L10;
            r14.y(r11);
            return;
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0266c
        public void i(int r10, int r11, List<mc.a> r12) {
            Intrinsics.checkNotNullParameter(r12, "requestHeaders");
            this.f11895g.k0(r11, r12);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            l();
            return Unit.INSTANCE;
        }

        @Override // okhttp3.internal.http2.c.InterfaceC0266c
        public void j(int r10, ErrorCode r11, ByteString r12) {
            Intrinsics.checkNotNullParameter(r11, "errorCode");
            Intrinsics.checkNotNullParameter(r12, "debugData");
            r12.size();
            b r13 = this.f11895g;
            monitor-enter(r13);
            int r14 = 0;
            Object[] r15 = r13.c0().values().toArray(new mc.d[0]);     // Catch: Throwable -> L15
            b.F(r13, true);     // Catch: Throwable -> L15
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L15
            monitor-exit(r13);
            mc.d[] r17 = (mc.d[]) r15;
            int r18 = r17.length;
        L7:
            if (r14 >= r18) goto L14;
            mc.d r19 = r17[r14];
            if (r19.j() <= r10) goto L13;
            if (r19.t() == false) goto L13;
            r19.y(ErrorCode.REFUSED_STREAM);
            this.f11895g.n0(r19.j());
        L13:
            r14 = r14 + 1;
            goto L7
        L14:
            return;
        L15:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void k(boolean r11, mc.g r12) {
            Intrinsics.checkNotNullParameter(r12, "settings");
            Ref.ObjectRef r10 = new Ref.ObjectRef();
            okhttp3.internal.http2.d r13 = this.f11895g.e0();
            b r14 = this.f11895g;
            monitor-enter(r13);
            monitor-enter(r14);     // Catch: Throwable -> L39
            mc.g r15 = r14.X();     // Catch: Throwable -> L36
            if (r11 == false) goto L8;
            T r16 = r12;
        L9:
            r10.element = r16;     // Catch: Throwable -> L36
            long r17 = ((long) ((mc.g) r16).c()) - ((long) r15.c());     // Catch: Throwable -> L36
            int r18 = 0;
            if (r17 != 0) goto L12;
        L15:
            mc.d[] r19 = null;
        L16:
            r14.q0((mc.g) r10.element);     // Catch: Throwable -> L36
            b.r(r14).i(new a(r14.M() + " onSettings", true, r14, r10), 0);     // Catch: Throwable -> L36
            Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L36
            monitor-exit(r14);     // Catch: Throwable -> L39
            r14.e0().a((mc.g) r10.element);     // Catch: IOException -> L20 Throwable -> L39
        L22:
            Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L39
            monitor-exit(r13);
            if (r19 == null) goto L35;
            int r111 = r19.length;
        L26:
            if (r18 >= r111) goto L50;
            mc.d r21 = r19[r18];
            monitor-enter(r21);
            r21.a(r17);     // Catch: Throwable -> L32
            Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L32
            monitor-exit(r21);
            r18 = r18 + 1;
        L32:
            th = move-exception;
            throw th;
        L50:
            return;
        L35:
            return;
        L20:
            e = move-exception;
            b.a(r14, e);     // Catch: Throwable -> L39
            goto L22
        L12:
            if (r14.c0().isEmpty() == true) goto L15;
            r19 = (mc.d[]) r14.c0().values().toArray(new mc.d[0]);     // Catch: Throwable -> L36
            goto L16
        L8:
            mc.g r112 = new mc.g();     // Catch: Throwable -> L36
            r112.g(r15);     // Catch: Throwable -> L36
            r112.g(r12);     // Catch: Throwable -> L36
            r16 = r112;
        L36:
            th = move-exception;
            throw th;     // Catch: Throwable -> L39
        L39:
            th = move-exception;
            throw th;
        }

        public void l() {
            ErrorCode r10 = ErrorCode.INTERNAL_ERROR;
            IOException e10 = null;
            this.f11894c.f(this);     // Catch: Throwable -> L11 IOException -> L13
        L5:
            if (this.f11894c.c(false, this) == true) goto L5;
            ErrorCode r11 = ErrorCode.NO_ERROR;     // Catch: Throwable -> L11 IOException -> L13
            ErrorCode r12 = ErrorCode.CANCEL;     // Catch: IOException -> L9 Throwable -> L19
            this.f11895g.I(r11, r12, null);
        L17:
            hc.e.m(this.f11894c);
            return;
        L9:
            e10 = e;
        L15:
            ErrorCode r13 = ErrorCode.PROTOCOL_ERROR;     // Catch: Throwable -> L19
            this.f11895g.I(r13, r13, e10);
        L19:
            th = th;
        L20:
            this.f11895g.I(r11, r10, e10);
            hc.e.m(this.f11894c);
            throw th;
        L13:
            e10 = e;
            r11 = r10;
        L11:
            th = th;
            r11 = r10;
            goto L20
        }
    }

    @SourceDebugExtension({"SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue$execute$1\n+ 2 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n+ 3 Util.kt\nokhttp3/internal/Util\n*L\n1#1,218:1\n939#2:219\n940#2,8:222\n948#2:233\n402#3,2:220\n404#3,3:230\n*S KotlinDebug\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n*L\n939#1:220,2\n939#1:230,3\n*E\n"})
    public static final class e extends jc.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f11906e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f11907f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ okio.d f11908g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f11909h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f11910i;

        public e(String r10, boolean r11, b r12, int r13, okio.d r14, int r15, boolean r16) {
            this.f11906e = r12;
            this.f11907f = r13;
            this.f11908g = r14;
            this.f11909h = r15;
            this.f11910i = r16;
            super(r10, r11);
        }

        @Override // jc.a
        public long f() {
            boolean r10 = b.p(this.f11906e).d(this.f11907f, this.f11908g, this.f11909h, this.f11910i);     // Catch: IOException -> L18
            if (r10 == false) goto L5;
            this.f11906e.e0().u(this.f11907f, ErrorCode.CANCEL);     // Catch: IOException -> L18
        L5:
            if (r10 == false) goto L7;
        L8:
            b r11 = this.f11906e;     // Catch: IOException -> L18
            monitor-enter(r11);     // Catch: IOException -> L18
            b.f(this.f11906e).remove(Integer.valueOf(this.f11907f));     // Catch: Throwable -> L13
            monitor-exit(r11);     // Catch: IOException -> L18
            return -1;
        L13:
            th = move-exception;
            throw th;     // Catch: IOException -> L18
        L7:
            if (this.f11910i == true) goto L8;
            return -1;
        L23:
            return -1;
        }
    }

    @SourceDebugExtension({"SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue$execute$1\n+ 2 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n+ 3 Util.kt\nokhttp3/internal/Util\n*L\n1#1,218:1\n912#2,2:219\n914#2,7:223\n921#2:233\n402#3,2:221\n404#3,3:230\n*S KotlinDebug\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n*L\n913#1:221,2\n913#1:230,3\n*E\n"})
    public static final class f extends jc.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f11911e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f11912f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f11913g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f11914h;

        public f(String r10, boolean r11, b r12, int r13, List r14, boolean r15) {
            this.f11911e = r12;
            this.f11912f = r13;
            this.f11913g = r14;
            this.f11914h = r15;
            super(r10, r11);
        }

        @Override // jc.a
        public long f() {
            boolean r10 = b.p(this.f11911e).b(this.f11912f, this.f11913g, this.f11914h);
            if (r10 == true) goto L21;
        L5:
            if (r10 == false) goto L7;
        L8:
            b r11 = this.f11911e;     // Catch: IOException -> L18
            monitor-enter(r11);     // Catch: IOException -> L18
            b.f(this.f11911e).remove(Integer.valueOf(this.f11912f));     // Catch: Throwable -> L13
            monitor-exit(r11);     // Catch: IOException -> L18
            return -1;
        L13:
            th = move-exception;
            throw th;     // Catch: IOException -> L18
        L23:
            return -1;
        L7:
            if (this.f11914h == true) goto L8;
            return -1;
        L21:
            this.f11911e.e0().u(this.f11912f, ErrorCode.CANCEL);     // Catch: IOException -> L18
            goto L5
        }
    }

    @SourceDebugExtension({"SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue$execute$1\n+ 2 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n+ 3 Util.kt\nokhttp3/internal/Util\n*L\n1#1,218:1\n894#2,2:219\n896#2,7:223\n903#2:233\n402#3,2:221\n404#3,3:230\n*S KotlinDebug\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n*L\n895#1:221,2\n895#1:230,3\n*E\n"})
    public static final class g extends jc.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f11915e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f11916f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f11917g;

        public g(String r10, boolean r11, b r12, int r13, List r14) {
            this.f11915e = r12;
            this.f11916f = r13;
            this.f11917g = r14;
            super(r10, r11);
        }

        @Override // jc.a
        public long f() {
            if (b.p(this.f11915e).a(this.f11916f, this.f11917g) == true) goto L17;
            return -1;
        L17:
            this.f11915e.e0().u(this.f11916f, ErrorCode.CANCEL);     // Catch: IOException -> L14
            b r10 = this.f11915e;     // Catch: IOException -> L14
            monitor-enter(r10);     // Catch: IOException -> L14
            b.f(this.f11915e).remove(Integer.valueOf(this.f11916f));     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: IOException -> L14
            return -1;
        L9:
            th = move-exception;
            throw th;     // Catch: IOException -> L14
        L19:
            return -1;
        }
    }

    @SourceDebugExtension({"SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue$execute$1\n+ 2 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n*L\n1#1,218:1\n953#2,5:219\n*E\n"})
    public static final class h extends jc.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f11918e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f11919f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ErrorCode f11920g;

        public h(String r10, boolean r11, b r12, int r13, ErrorCode r14) {
            this.f11918e = r12;
            this.f11919f = r13;
            this.f11920g = r14;
            super(r10, r11);
        }

        @Override // jc.a
        public long f() {
            b.p(this.f11918e).c(this.f11919f, this.f11920g);
            b r10 = this.f11918e;
            monitor-enter(r10);
            b.f(this.f11918e).remove(Integer.valueOf(this.f11919f));     // Catch: Throwable -> L8
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L8
            monitor-exit(r10);
            return -1;
        L8:
            th = move-exception;
            throw th;
        }
    }

    @SourceDebugExtension({"SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue$execute$1\n+ 2 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n*L\n1#1,218:1\n555#2,2:219\n*E\n"})
    public static final class i extends jc.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f11921e;

        public i(String r10, boolean r11, b r12) {
            this.f11921e = r12;
            super(r10, r11);
        }

        @Override // jc.a
        public long f() {
            this.f11921e.x0(false, 2, 0);
            return -1;
        }
    }

    @SourceDebugExtension({"SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue$schedule$2\n+ 2 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n*L\n1#1,218:1\n153#2,14:219\n*E\n"})
    public static final class j extends jc.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f11922e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f11923f;

        public j(String r10, b r11, long r12) {
            this.f11922e = r11;
            this.f11923f = r12;
            super(r10, false, 2, null);
        }

        @Override // jc.a
        public long f() {
            b r10 = this.f11922e;
            monitor-enter(r10);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (b.o(this.f11922e) >= b.l(this.f11922e)) goto L7;
            boolean r11 = true;
        L9:
            monitor-exit(r10);
            if (r11 == false) goto L12;
            b.a(this.f11922e, null);
            return -1;
        L12:
            this.f11922e.x0(false, 1, 0);
            return this.f11923f;
        L7:
            b.C(this.f11922e, b.l(this.f11922e) + 1);     // Catch: Throwable -> L14
            r11 = false;
            goto L9
        }
    }

    @SourceDebugExtension({"SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue$execute$1\n+ 2 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n*L\n1#1,218:1\n341#2,6:219\n*E\n"})
    public static final class k extends jc.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f11924e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f11925f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ErrorCode f11926g;

        public k(String r10, boolean r11, b r12, int r13, ErrorCode r14) {
            this.f11924e = r12;
            this.f11925f = r13;
            this.f11926g = r14;
            super(r10, r11);
        }

        @Override // jc.a
        public long f() {
            this.f11924e.y0(this.f11925f, this.f11926g);     // Catch: IOException -> L4
            return -1;
        L4:
            e = move-exception;
            b.a(this.f11924e, e);
            return -1;
        }
    }

    @SourceDebugExtension({"SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue$execute$1\n+ 2 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n*L\n1#1,218:1\n362#2,6:219\n*E\n"})
    public static final class l extends jc.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f11927e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f11928f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f11929g;

        public l(String r10, boolean r11, b r12, int r13, long r14) {
            this.f11927e = r12;
            this.f11928f = r13;
            this.f11929g = r14;
            super(r10, r11);
        }

        @Override // jc.a
        public long f() {
            this.f11927e.e0().A(this.f11928f, this.f11929g);     // Catch: IOException -> L4
            return -1;
        L4:
            e = move-exception;
            b.a(this.f11927e, e);
            return -1;
        }
    }

    static {
        H = new C0262b(null);
        mc.g r10 = new mc.g();
        r10.h(7, SupportMenu.USER_MASK);
        r10.h(5, 16384);
        I = r10;
    }

    public b(a r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        boolean r11 = r10.b();
        this.f11863c = r11;
        this.f11864g = r10.d();
        this.f11865h = new LinkedHashMap();
        String r12 = r10.c();
        this.f11866i = r12;
        if (r10.b() == false) goto L5;
        int r13 = 3;
    L6:
        this.f11868k = r13;
        jc.e r14 = r10.j();
        this.f11870m = r14;
        jc.d r15 = r14.i();
        this.f11871n = r15;
        this.f11872o = r14.i();
        this.f11873p = r14.i();
        this.f11874q = r10.f();
        mc.g r16 = new mc.g();
        if (r10.b() == false) goto L9;
        r16.h(7, 16777216);
    L9:
        this.f11881x = r16;
        mc.g r17 = I;
        this.f11882y = r17;
        this.C = r17.c();
        this.D = r10.h();
        this.E = new okhttp3.internal.http2.d(r10.g(), r11);
        this.F = new d(this, new okhttp3.internal.http2.c(r10.i(), r11));
        this.G = new LinkedHashSet();
        if (r10.e() == 0) goto L13;
        long r18 = TimeUnit.MILLISECONDS.toNanos(r10.e());
        r15.i(new j(r12 + " ping", this, r18), r18);
        return;
    L13:
        return;
    L5:
        r13 = 2;
        goto L6
    }

    public static final /* synthetic */ void A(b r10, long r11) {
        r10.f11879v = r11;
    }

    public static final /* synthetic */ void B(b r10, long r11) {
        r10.f11878u = r11;
    }

    public static final /* synthetic */ void C(b r10, long r11) {
        r10.f11875r = r11;
    }

    public static final /* synthetic */ void D(b r10, long r11) {
        r10.f11876s = r11;
    }

    public static final /* synthetic */ void F(b r10, boolean r11) {
        r10.f11869l = r11;
    }

    public static final /* synthetic */ void G(b r10, long r11) {
        r10.C = r11;
    }

    private final void J(IOException r10) {
        ErrorCode r11 = ErrorCode.PROTOCOL_ERROR;
        I(r11, r11, r10);
    }

    public static final /* synthetic */ void a(b r10, IOException r11) {
        r10.J(r11);
    }

    public static final /* synthetic */ long c(b r10) {
        return r10.f11879v;
    }

    public static final /* synthetic */ Set f(b r10) {
        return r10.G;
    }

    private final mc.d g0(int r11, List<mc.a> r12, boolean r13) {
        boolean r10 = !r13;
        okhttp3.internal.http2.d r14 = this.E;
        monitor-enter(r14);
        monitor-enter(this);     // Catch: Throwable -> L40
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L6:
        if (this.f11868k <= 1073741823) goto L9;
        r0(ErrorCode.REFUSED_STREAM);     // Catch: Throwable -> L37
    L9:
        if (this.f11869l == true) goto L36;
        int r15 = this.f11868k;     // Catch: Throwable -> L37
        this.f11868k = r15 + 2;     // Catch: Throwable -> L37
        mc.d r16 = new mc.d(r15, this, r10, false, null);     // Catch: Throwable -> L37
        if (r13 == true) goto L13;
    L18:
        boolean r17 = true;
    L20:
        if (r16.u() == false) goto L22;
        this.f11865h.put(Integer.valueOf(r15), r16);     // Catch: Throwable -> L37
    L22:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L40
        if (r11 != 0) goto L27;
        this.E.o(r10, r15, r12);     // Catch: Throwable -> L40
    L29:
        monitor-exit(r14);
        if (r17 == false) goto L32;
        this.E.flush();
    L32:
        return r16;
    L27:
        if ((true ^ this.f11863c) == false) goto L34;
        this.E.s(r11, r15, r12);     // Catch: Throwable -> L40
        goto L29
    L34:
        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());     // Catch: Throwable -> L40
    L13:
        if (this.B >= this.C) goto L18;
        if (r16.r() >= r16.q()) goto L18;
        r17 = false;
        goto L20
    L36:
        throw new ConnectionShutdownException();     // Catch: Throwable -> L37
    L40:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ mc.g i() {
        return I;
    }

    public static final /* synthetic */ long k(b r10) {
        return r10.f11878u;
    }

    public static final /* synthetic */ long l(b r10) {
        return r10.f11875r;
    }

    public static final /* synthetic */ long o(b r10) {
        return r10.f11876s;
    }

    public static final /* synthetic */ mc.f p(b r10) {
        return r10.f11874q;
    }

    public static final /* synthetic */ jc.d r(b r10) {
        return r10.f11873p;
    }

    public static final /* synthetic */ jc.e s(b r10) {
        return r10.f11870m;
    }

    public static /* synthetic */ void t0(b r10, boolean r11, jc.e r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = true;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = jc.e.f9926i;
    L8:
        r10.s0(r11, r12);
    }

    public static final /* synthetic */ jc.d u(b r10) {
        return r10.f11871n;
    }

    public static final /* synthetic */ boolean v(b r10) {
        return r10.f11869l;
    }

    public final void A0(int r11, long r12) {
        this.f11871n.i(new l(this.f11866i + '[' + r11 + "] windowUpdate", true, this, r11, r12), 0);
    }

    public final void I(ErrorCode r10, ErrorCode r11, IOException r12) {
        Intrinsics.checkNotNullParameter(r10, "connectionCode");
        Intrinsics.checkNotNullParameter(r11, "streamCode");
        if (hc.e.f9283g == true) goto L5;
    L41:
        r0(r10);     // Catch: IOException -> L31
    L10:
        Object[] r13 = null;
        monitor-enter(this);
        int r14 = 0;
        if ((!this.f11865h.isEmpty()) == false) goto L15;
        r13 = this.f11865h.values().toArray(new mc.d[0]);     // Catch: Throwable -> L28
        this.f11865h.clear();     // Catch: Throwable -> L28
    L15:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(this);
        mc.d[] r16 = (mc.d[]) r13;
        if (r16 == null) goto L37;
        int r17 = r16.length;
    L20:
        if (r14 >= r17) goto L37;
        r16[r14].d(r11, r12);     // Catch: IOException -> L32
    L23:
        r14 = r14 + 1;
    L37:
        this.E.close();     // Catch: IOException -> L33
    L35:
        this.D.close();     // Catch: IOException -> L34
    L26:
        this.f11871n.n();
        this.f11872o.n();
        this.f11873p.n();
        return;
    L28:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L41;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final boolean K() {
        return this.f11863c;
    }

    public final String M() {
        return this.f11866i;
    }

    public final int N() {
        return this.f11867j;
    }

    public final c P() {
        return this.f11864g;
    }

    public final int Q() {
        return this.f11868k;
    }

    public final mc.g V() {
        return this.f11881x;
    }

    public final mc.g X() {
        return this.f11882y;
    }

    public final synchronized mc.d a0(int r10) {
        monitor-enter(this);
        mc.d r11 = this.f11865h.get(Integer.valueOf(r10));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    public final Map<Integer, mc.d> c0() {
        return this.f11865h;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        I(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final long d0() {
        return this.C;
    }

    public final okhttp3.internal.http2.d e0() {
        return this.E;
    }

    public final synchronized boolean f0(long r10) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.f11869l == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (this.f11878u >= this.f11877t) goto L16;
        if (r10 < this.f11880w) goto L16;
        monitor-exit(this);
        return false;
    L16:
        monitor-exit(this);
        return true;
    }

    public final void flush() {
        this.E.flush();
    }

    public final mc.d h0(List<mc.a> r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "requestHeaders");
        return g0(0, r10, r11);
    }

    public final void i0(int r10, okio.f r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "source");
        okio.d r14 = new okio.d();
        long r15 = r12;
        r11.U(r15);
        r11.S(r14, r15);
        this.f11872o.i(new e(this.f11866i + '[' + r10 + "] onData", true, this, r10, r14, r12, r13), 0);
    }

    public final void j0(int r11, List<mc.a> r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "requestHeaders");
        this.f11872o.i(new f(this.f11866i + '[' + r11 + "] onHeaders", true, this, r11, r12, r13), 0);
    }

    public final void k0(int r11, List<mc.a> r12) {
        Intrinsics.checkNotNullParameter(r12, "requestHeaders");
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.G.contains(Integer.valueOf(r11)) == false) goto L9;
        z0(r11, ErrorCode.PROTOCOL_ERROR);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L9:
        this.G.add(Integer.valueOf(r11));     // Catch: Throwable -> L13
        monitor-exit(this);
        this.f11872o.i(new g(this.f11866i + '[' + r11 + "] onRequest", true, this, r11, r12), 0);
    }

    public final void l0(int r10, ErrorCode r11) {
        Intrinsics.checkNotNullParameter(r11, "errorCode");
        this.f11872o.i(new h(this.f11866i + '[' + r10 + "] onReset", true, this, r10, r11), 0);
    }

    public final boolean m0(int r10) {
        if (r10 != 0) goto L5;
    L7:
        return false;
    L5:
        if ((r10 & 1) != 0) goto L7;
        return true;
    }

    public final synchronized mc.d n0(int r10) {
        monitor-enter(this);
        mc.d r11 = this.f11865h.remove(Integer.valueOf(r10));     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L6
        notifyAll();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    public final void o0() {
        monitor-enter(this);
        long r10 = this.f11878u;     // Catch: Throwable -> L13
        long r11 = this.f11877t;     // Catch: Throwable -> L13
        if (r10 >= r11) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.f11877t = r11 + 1;     // Catch: Throwable -> L13
        this.f11880w = System.nanoTime() + ((long) 1000000000);     // Catch: Throwable -> L13
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
        this.f11871n.i(new i(this.f11866i + " ping", true, this), 0);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void p0(int r10) {
        this.f11867j = r10;
    }

    public final void q0(mc.g r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f11882y = r10;
    }

    public final void r0(ErrorCode r10) {
        Intrinsics.checkNotNullParameter(r10, "statusCode");
        okhttp3.internal.http2.d r11 = this.E;
        monitor-enter(r11);
        Ref.IntRef r12 = new Ref.IntRef();     // Catch: Throwable -> L20
        monitor-enter(this);     // Catch: Throwable -> L20
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L7:
        if (this.f11869l == false) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L20
        monitor-exit(r11);
        return;
    L12:
        this.f11869l = true;     // Catch: Throwable -> L17
        int r13 = this.f11867j;     // Catch: Throwable -> L17
        r12.element = r13;     // Catch: Throwable -> L17
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L20
        this.E.l(r13, r10, hc.e.f9277a);     // Catch: Throwable -> L20
        monitor-exit(r11);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @JvmOverloads
    public final void s0(boolean r10, jc.e r11) {
        Intrinsics.checkNotNullParameter(r11, "taskRunner");
        if (r10 == false) goto L7;
        this.E.c();
        this.E.v(this.f11881x);
        int r12 = this.f11881x.c();
        if (r12 == 65535) goto L7;
        this.E.A(0, r12 - SupportMenu.USER_MASK);
    L7:
        r11.i().i(new jc.c(this.f11866i, true, this.F), 0);
    }

    public final synchronized void u0(long r10) {
        monitor-enter(this);
        long r11 = this.f11883z + r10;     // Catch: Throwable -> L8
        this.f11883z = r11;     // Catch: Throwable -> L8
        long r12 = r11 - this.A;     // Catch: Throwable -> L8
        if (r12 < (this.f11881x.c() / 2)) goto L6;
        A0(0, r12);     // Catch: Throwable -> L8
        this.A += r12;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void v0(int r10, boolean r11, okio.d r12, long r13) {
        if (r13 != 0) goto L7;
        this.E.f(r11, r10, r12, 0);
        return;
    L7:
        if (r13 <= 0) goto L32;
        monitor-enter(this);
    L33:
        long r14 = this.B;     // Catch: Throwable -> L26 InterruptedException -> L28
        long r15 = this.C;     // Catch: Throwable -> L26 InterruptedException -> L28
        if (r14 < r15) goto L17;
        if (this.f11865h.containsKey(Integer.valueOf(r10)) == false) goto L15;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L26 InterruptedException -> L28
        wait();     // Catch: Throwable -> L26 InterruptedException -> L28
        goto L33
    L15:
        throw new IOException("stream closed");     // Catch: Throwable -> L26 InterruptedException -> L28
    L17:
        int r16 = Math.min((int) Math.min(r13, r15 - r14), this.E.p());     // Catch: Throwable -> L26
        long r17 = r16;
        this.B += r17;     // Catch: Throwable -> L26
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(this);
        r13 = r13 - r17;
        okhttp3.internal.http2.d r19 = this.E;
        if (r11 == true) goto L22;
    L24:
        boolean r20 = false;
    L25:
        r19.f(r20, r10, r12, r16);
        goto L7
    L22:
        if (r13 != 0) goto L24;
        r20 = true;
    L26:
        th = move-exception;
        throw th;
    L28:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L26
        throw new InterruptedIOException();     // Catch: Throwable -> L26
    }

    public final void w0(int r10, boolean r11, List<mc.a> r12) {
        Intrinsics.checkNotNullParameter(r12, "alternating");
        this.E.o(r11, r10, r12);
    }

    public final void x0(boolean r10, int r11, int r12) {
        this.E.r(r10, r11, r12);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        J(e);
    }

    public final void y0(int r10, ErrorCode r11) {
        Intrinsics.checkNotNullParameter(r11, "statusCode");
        this.E.u(r10, r11);
    }

    public final void z0(int r10, ErrorCode r11) {
        Intrinsics.checkNotNullParameter(r11, "errorCode");
        this.f11871n.i(new k(this.f11866i + '[' + r10 + "] writeSynReset", true, this, r10, r11), 0);
    }
}
