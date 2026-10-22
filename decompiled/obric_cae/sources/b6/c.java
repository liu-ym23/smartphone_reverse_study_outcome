package b6;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.retrofit2.HttpMethodContrants;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import jf.p;
import jf.q;
import we.a0;
import we.w;
import we.x;
import we.y;

/* JADX INFO: loaded from: classes.dex */
public final class c implements d, f.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final List<w> f3075v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public android.support.v4.media.a f3076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f3077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Random f3078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b6.a f3080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayDeque<jf.g> f3081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayDeque<Object> f3082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f3083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public x f3084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f3085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g f3086k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ScheduledThreadPoolExecutor f3087l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public hf.a f3088m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f3089n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3090o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ScheduledFuture<?> f3091p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3092q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f3093r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3094s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f3095t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f3096u;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f3097a;

        public a(c r8) {
            this.f3097a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f3097a.a();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final jf.g f3099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f3100c;

        public b(int r8, jf.g r10) {
            this.f3098a = r8;
            this.f3099b = r10;
            this.f3100c = 60000;
        }
    }

    /* JADX INFO: renamed from: b6.c$c, reason: collision with other inner class name */
    public static final class C0033c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final jf.g f3102b;

        public C0033c(int r8, jf.g r10) {
            this.f3101a = r8;
            this.f3102b = r10;
        }
    }

    static {
        f3075v = Collections.singletonList(w.f13320m);
    }

    public c(y r8, long r10, z5.b.e r11, Random r12) {
        this.f3081f = new ArrayDeque();
        this.f3082g = new ArrayDeque();
        this.f3092q = -1;
        if (HttpMethodContrants.GET.equals(r8.f13339c) == false) goto L7;
        this.f3077b = r8;
        this.f3076a = r11;
        this.f3078c = r12;
        this.f3083h = r10;
        byte[] r13 = new byte[16];
        r12.nextBytes(r13);
        this.f3079d = jf.g.g(r13).a();
        this.f3080e = new b6.a(this);
        return;
    L7:
        throw new IllegalArgumentException("Request must be GET: " + r8.f13339c);
    }

    public final void a() {
        this.f3084i.b(-1);
    }

    public final void b(a0 r8) {
        if (r8.f13116m != 101) goto L17;
        String r10 = r8.n("Connection");
        if ("Upgrade".equalsIgnoreCase(r10) == false) goto L16;
        String r11 = r8.n("Upgrade");
        if ("websocket".equalsIgnoreCase(r11) == false) goto L14;
        String r12 = r8.n("Sec-WebSocket-Accept");
        String r13 = jf.g.d(this.f3079d + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").j().a();
        if (r13.equals(r12) == false) goto L12;
        return;
    L12:
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + r13 + "' but was '" + r12 + "'");
    L14:
        throw new ProtocolException(defpackage.b.d("Expected 'Upgrade' header value 'websocket' but was '", r11, "'"));
    L16:
        throw new ProtocolException(defpackage.b.d("Expected 'Connection' header value 'Upgrade' but was '", r10, "'"));
    L17:
        StringBuilder r14 = new StringBuilder("Expected HTTP 101 response but was '");
        r14.append(r8.f13116m);
        r14.append(" ");
        throw new ProtocolException(android.aimedia.a.i(r14, r8.f13117n, "'"));
    }

    public final void c(int r8, String r10) {
        monitor-enter(this);
        String r11 = e.a(r8);     // Catch: Throwable -> L12
        if (r11 != null) goto L24;
        if (r10 == null) goto L14;
        jf.g r12 = jf.g.d(r10);     // Catch: Throwable -> L12
        if (r12.f8842a.length > 123) goto L11;
    L16:
        if (this.f3094s == false) goto L18;
    L21:
        monitor-exit(this);
        return;
    L18:
        if (this.f3090o == true) goto L21;
        this.f3090o = true;     // Catch: Throwable -> L12
        this.f3082g.add(new b(r8, r12));     // Catch: Throwable -> L12
        h();     // Catch: Throwable -> L12
        goto L21
    L11:
        throw new IllegalArgumentException("reason.size() > 123: ".concat(r10));     // Catch: Throwable -> L12
    L14:
        r12 = null;
        goto L16
    L24:
        throw new IllegalArgumentException(r11);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public final void d(Exception r8, a0 r10) {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.f3094s == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L7:
        this.f3094s = true;     // Catch: Throwable -> L22
        hf.a r11 = this.f3088m;     // Catch: Throwable -> L22
        this.f3088m = null;     // Catch: Throwable -> L22
        ScheduledFuture<?> r12 = this.f3091p;     // Catch: Throwable -> L22
        if (r12 == null) goto L10;
        r12.cancel(false);     // Catch: Throwable -> L22
    L10:
        ScheduledThreadPoolExecutor r13 = this.f3087l;     // Catch: Throwable -> L22
        if (r13 == null) goto L13;
        r13.shutdown();     // Catch: Throwable -> L22
    L13:
        monitor-exit(this);     // Catch: Throwable -> L22
        android.support.v4.media.a r14 = this.f3076a;     // Catch: Throwable -> L19
        if (r14 == null) goto L17;
        r14.o(this, r8, r10);     // Catch: Throwable -> L19
    L17:
        xe.c.f(r11);
        return;
    L19:
        th = move-exception;
        xe.c.f(r11);
        throw th;
    }

    public final void e(String r8, ze.c r10) {
        monitor-enter(this);
        this.f3088m = r10;     // Catch: Throwable -> L9
        this.f3086k = new g(r10.f8067a, r10.f8069m, this.f3078c);     // Catch: Throwable -> L9
        byte[] r11 = xe.c.f13880a;     // Catch: Throwable -> L9
        this.f3087l = new ScheduledThreadPoolExecutor(1, new xe.d(r8, false));     // Catch: Throwable -> L9
        if (this.f3082g.isEmpty() == true) goto L6;
        h();     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);     // Catch: Throwable -> L9
        this.f3085j = new f(r10.f8067a, r10.f8068b, this, this.f3083h);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void f() {
    L3:
        if (this.f3092q != (-1)) goto L58;
        f r8 = this.f3085j;
        r8.b();
        long r10 = r8.f3109g;
        long r11 = r8.f3103a;
        jf.f r12 = r8.f3105c;
        if (r10 > r11) goto L6;
        if (r8.f3111i == true) goto L13;
        int r13 = r8.f3108f;
        if (r13 == 1) goto L22;
        if (r13 == 2) goto L22;
        throw new ProtocolException("Unknown opcode: " + Integer.toHexString(r13));
    L22:
        if (r8.f3107e == true) goto L57;
        long r14 = r8.f3109g;
        jf.d r15 = r8.f3113k;
        if (r14 <= 0) goto L29;
        r12.d(r15, r14);
        if (r8.f3104b == true) goto L29;
        jf.d.c r16 = r8.f3115m;
        r15.v(r16);
        r16.a(r15.f8830b - r8.f3109g);
        e.b(r16, r8.f3114l);
        r16.close();
    L29:
        if (r8.f3110h == true) goto L30;
    L39:
        if (r8.f3107e == true) goto L52;
        r8.b();
        if (r8.f3109g > r11) goto L42;
        if (r8.f3111i == false) goto L52;
        r8.a();
        goto L39
    L42:
        Logger.d("WsChannelSdk_ok", "frame too large,skip");
        r12.skip(r8.f3109g);     // Catch: Exception -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L52:
        if (r8.f3108f == 0) goto L22;
        throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(r8.f3108f));
    L30:
        f.a r17 = r8.f3106d;
        if (r13 == 1) goto L32;
        jf.g r18 = r15.x();
        android.support.v4.media.a r19 = ((c) r17).f3076a;
        if (r19 == null) goto L3;
        r19.t(r18);
        goto L3
    L32:
        String r20 = r15.A();
        android.support.v4.media.a r21 = ((c) r17).f3076a;
        if (r21 == null) goto L3;
        r21.s(r20);
        goto L3
    L57:
        throw new IOException("closed");
    L13:
        r8.a();
        goto L3
    L6:
        Logger.d("WsChannelSdk_ok", "frame too large,skip");
        r12.skip(r8.f3109g);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L3
    }

    public final void g(int r8, String r10) {
        if (r8 == (-1)) goto L34;
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L6:
        if (this.f3092q != (-1)) goto L29;
        this.f3092q = r8;     // Catch: Throwable -> L30
        this.f3093r = r10;     // Catch: Throwable -> L30
        hf.a r11 = null;
        if (this.f3090o == true) goto L10;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L30
        android.support.v4.media.a r12 = this.f3076a;     // Catch: Throwable -> L22
        if (r12 == null) goto L24;
        r12.m();     // Catch: Throwable -> L22
        if (r11 == null) goto L24;
        this.f3076a.l(this, r8, r10);     // Catch: Throwable -> L22
    L24:
        xe.c.f(r11);
        return;
    L22:
        th = move-exception;
        xe.c.f(r11);
        throw th;
    L10:
        if (this.f3082g.isEmpty() == false) goto L15;
        hf.a r13 = this.f3088m;     // Catch: Throwable -> L30
        this.f3088m = null;     // Catch: Throwable -> L30
        ScheduledFuture<?> r14 = this.f3091p;     // Catch: Throwable -> L30
        if (r14 == null) goto L14;
        r14.cancel(false);     // Catch: Throwable -> L30
    L14:
        this.f3087l.shutdown();     // Catch: Throwable -> L30
        r11 = r13;
        goto L15
    L29:
        throw new IllegalStateException("already closed");     // Catch: Throwable -> L30
    L34:
        throw new IllegalArgumentException();
    }

    public final void h() {
        ScheduledThreadPoolExecutor r8 = this.f3087l;
        if (r8 == null) goto L6;
        r8.execute(this.f3080e);
        return;
    }

    public final synchronized boolean i(int r10, jf.g r11) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.f3094s == false) goto L6;
    L17:
        monitor-exit(this);
        return false;
    L6:
        if (this.f3090o == true) goto L17;
        long r8 = this.f3089n;     // Catch: Throwable -> L19
        byte[] r12 = r11.f8842a;     // Catch: Throwable -> L19
        if ((((long) r12.length) + r8) <= 16777216) goto L13;
        c(1001, null);     // Catch: Throwable -> L19
        monitor-exit(this);
        return false;
    L13:
        this.f3089n = r8 + ((long) r12.length);     // Catch: Throwable -> L19
        this.f3082g.add(new C0033c(r10, r11));     // Catch: Throwable -> L19
        h();     // Catch: Throwable -> L19
        monitor-exit(this);
        return true;
    }

    public final void j(jf.g r8) {
        if (r8 != null) goto L4;
        r8 = jf.g.f8841o;
    L4:
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L6:
        if (this.f3094s == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L9:
        g r10 = this.f3086k;     // Catch: Throwable -> L24
        if (this.f3096u == false) goto L12;
        int r11 = this.f3095t;     // Catch: Throwable -> L24
    L13:
        this.f3095t++;     // Catch: Throwable -> L24
        this.f3096u = true;     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        if (r11 == (-1)) goto L17;
        e = new SocketTimeoutException(WsConstants.PING_NOT_RECEIVE_PONG_MSG);
    L22:
        d(e, null);
        return;
    L17:
        if (r10 != null) goto L28;
        return;
    L28:
        r10.c(9, r8);     // Catch: IOException -> L21
        return;
    L21:
        e = e;
        goto L22
    L12:
        r11 = -1;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final boolean k() {
        monitor-enter(this);
    L49:
        th = move-exception;
        throw th;
    L4:
        if (this.f3094s == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L49
        return false;
    L7:
        g r8 = this.f3086k;     // Catch: Throwable -> L49
        jf.g r10 = this.f3081f.poll();     // Catch: Throwable -> L49
        Object r11 = null;
        int r12 = -1;
        if (r10 != null) goto L21;
        Object r13 = this.f3082g.poll();     // Catch: Throwable -> L49
        if ((r13 instanceof b) == false) goto L16;
        int r14 = this.f3092q;     // Catch: Throwable -> L49
        String r15 = this.f3093r;     // Catch: Throwable -> L49
        if (r14 == (-1)) goto L15;
        hf.a r16 = this.f3088m;     // Catch: Throwable -> L49
        this.f3088m = null;     // Catch: Throwable -> L49
        this.f3087l.shutdown();     // Catch: Throwable -> L49
        r11 = r16;
    L14:
        r12 = r14;
    L20:
        ?? r17 = r11;
        r11 = r13;
    L22:
        monitor-exit(this);     // Catch: Throwable -> L49
        if (r10 == null) goto L26;
        r8.e(r10);     // Catch: Throwable -> L46
    L42:
        xe.c.f(r17);
        return true;
    L26:
        if ((r11 instanceof C0033c) == false) goto L36;
        jf.g r18 = ((C0033c) r11).f3102b;     // Catch: Throwable -> L46
        q r19 = p.a(r8.a(((C0033c) r11).f3101a, r18.l()));     // Catch: Throwable -> L46
        r19.s(r18);     // Catch: Throwable -> L46
        r19.close();     // Catch: Throwable -> L46
        monitor-enter(this);     // Catch: Throwable -> L46
        this.f3089n -= (long) r18.l();     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L36:
        if ((r11 instanceof b) == false) goto L45;
        b r20 = (b) r11;     // Catch: Throwable -> L46
        r8.b(r20.f3098a, r20.f3099b);     // Catch: Throwable -> L46
        if (r17 == 0) goto L42;
        android.support.v4.media.a r21 = this.f3076a;     // Catch: Throwable -> L46
        if (r21 == null) goto L42;
        r21.l(this, r12, r15);     // Catch: Throwable -> L46
        goto L42
    L45:
        throw new AssertionError();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        xe.c.f(r17);
        throw th;
    L15:
        this.f3091p = this.f3087l.schedule(new a(this), ((b) r13).f3100c, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L49
        goto L14
    L16:
        if (r13 != null) goto L19;
        monitor-exit(this);     // Catch: Throwable -> L49
        return false;
    L19:
        r15 = null;
        goto L20
    L21:
        r17 = 0;
        r15 = null;
        goto L22
    }
}
