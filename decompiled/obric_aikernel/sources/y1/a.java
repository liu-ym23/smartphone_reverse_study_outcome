package y1;

import androidx.annotation.Nullable;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.l;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.w;
import okhttp3.x;
import okhttp3.z;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public class a implements y1.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final List<Protocol> f13632s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private y1.c f13633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x f13634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Random f13635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f13636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Runnable f13637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayDeque<ByteString> f13638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayDeque<Object> f13639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f13640h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private okhttp3.e f13641i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ScheduledExecutorService f13642j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private rc.a f13643k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f13644l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f13645m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ScheduledFuture<?> f13646n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f13647o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f13648p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f13649q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f13650r;

    /* JADX INFO: renamed from: y1.a$a, reason: collision with other inner class name */
    class RunnableC0320a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f13651c;

        RunnableC0320a(a r10) {
            this.f13651c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
        L8:
            if (this.f13651c.o() == true) goto L8;
            return;
        L5:
            e = move-exception;
            this.f13651c.i(e, null);
        }
    }

    final class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f13652c;

        b(a r10) {
            this.f13652c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13652c.c();
        }
    }

    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f13653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ByteString f13654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f13655c;

        c(int r10, ByteString r11, long r12) {
            this.f13653a = r10;
            this.f13654b = r11;
            this.f13655c = r12;
        }
    }

    static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f13656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ByteString f13657b;

        d(int r10, ByteString r11) {
            this.f13656a = r10;
            this.f13657b = r11;
        }
    }

    private final class e implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f13658c;

        e(a r10) {
            this.f13658c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13658c.p(ByteString.EMPTY);
        }
    }

    static {
        f13632s = Collections.singletonList(Protocol.HTTP_1_1);
    }

    public a(x r10, long r11, y1.c r12, Random r13) {
        this.f13638f = new ArrayDeque();
        this.f13639g = new ArrayDeque();
        this.f13647o = -1;
        if ("GET".equals(r10.g()) == false) goto L7;
        this.f13634b = r10;
        this.f13633a = r12;
        this.f13635c = r13;
        this.f13640h = r11;
        byte[] r14 = new byte[16];
        r13.nextBytes(r14);
        this.f13636d = ByteString.of(r14).base64();
        this.f13637e = new RunnableC0320a(this);
        return;
    L7:
        throw new IllegalArgumentException("Request must be GET: " + r10.g());
    }

    public static a h(x r10, long r11, y1.c r12) {
        return new a(r10, r11, r12, new Random());
    }

    private void j() {
        ScheduledExecutorService r10 = this.f13642j;
        if (r10 == null) goto L6;
        r10.execute(this.f13637e);
        return;
    }

    private synchronized boolean m(ByteString r10, int r11) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.f13648p == false) goto L6;
    L17:
        monitor-exit(this);
        return false;
    L6:
        if (this.f13645m == true) goto L17;
        if ((this.f13644l + ((long) r10.size())) <= 16777216) goto L13;
        d(1001, null);     // Catch: Throwable -> L19
        monitor-exit(this);
        return false;
    L13:
        this.f13644l += (long) r10.size();     // Catch: Throwable -> L19
        this.f13639g.add(new d(r11, r10));     // Catch: Throwable -> L19
        j();     // Catch: Throwable -> L19
        monitor-exit(this);
        return true;
    }

    private x n(x r10) {
        l.a r11 = l.b();
        if (r11 != null) goto L17;
        return r10;
    L17:
        Map<String, String> r12 = r11.a(r10.l().toString(), r10.e().h());     // Catch: Exception -> L14
        if (r12 != null) goto L8;
        return r10;
    L8:
        x.a r13 = r10.h();     // Catch: Exception -> L14
        Iterator<Map.Entry<String, String>> r14 = r12.entrySet().iterator();     // Catch: Exception -> L14
    L10:
        if (r14.hasNext() == false) goto L12;
        Map.Entry<String, String> r15 = r14.next();     // Catch: Exception -> L14
        r13.a(r15.getKey(), r15.getValue());     // Catch: Exception -> L14
        goto L10
    L12:
        return r13.b();
    L14:
        e = move-exception;
        Logger.w("tryAddOkWsRequestOpaque failed with exception" + e);
        return r10;
    }

    @Override // okhttp3.c0
    public x a() {
        return this.f13634b;
    }

    @Override // y1.b
    public void b() {
        ScheduledExecutorService r10 = this.f13642j;
        if (r10 == null) goto L6;
        r10.execute(new e(this));
        return;
    }

    public void c() {
        this.f13641i.cancel();
    }

    public boolean d(int r10, String r11) {
        return e(r10, r11, VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER);
    }

    synchronized boolean e(int r10, String r11, long r12) {
        monitor-enter(this);
        y1.d.b(r10);     // Catch: Throwable -> L21
        ByteString r13 = null;
        if (r11 == null) goto L11;
        r13 = ByteString.encodeUtf8(r11);     // Catch: Throwable -> L21
        if (r13.size() <= 123) goto L11;
        throw new IllegalArgumentException("reason.size() > 123: " + r11);     // Catch: Throwable -> L21
    L11:
        if (this.f13648p == true) goto L19;
        if (this.f13645m == true) goto L19;
        this.f13645m = true;     // Catch: Throwable -> L21
        this.f13639g.add(new c(r10, r13, r12));     // Catch: Throwable -> L21
        j();     // Catch: Throwable -> L21
        monitor-exit(this);
        return true;
    L19:
        monitor-exit(this);
        return false;
    L21:
        th = move-exception;
        throw th;
    }

    public void f(int r10, String r11) {
        this.f13633a = null;
        d(r10, r11);     // Catch: Throwable -> L5
        return;
    }

    public void g(w r10) {
        x r11 = n(this.f13634b.h().d("Upgrade", "websocket").d("Connection", "Upgrade").d("Sec-WebSocket-Key", this.f13636d).d("Sec-WebSocket-Version", "13").b());
        hc.b.instance.newWebSocketCall(r10, r11);
        throw null;
    }

    public void i(Exception r10, @Nullable z r11) {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.f13648p == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L7:
        this.f13648p = true;     // Catch: Throwable -> L22
        rc.a r12 = this.f13643k;     // Catch: Throwable -> L22
        ScheduledFuture<?> r13 = this.f13646n;     // Catch: Throwable -> L22
        if (r13 == null) goto L10;
        r13.cancel(false);     // Catch: Throwable -> L22
    L10:
        ScheduledExecutorService r14 = this.f13642j;     // Catch: Throwable -> L22
        if (r14 == null) goto L13;
        r14.shutdown();     // Catch: Throwable -> L22
    L13:
        monitor-exit(this);     // Catch: Throwable -> L22
        y1.c r15 = this.f13633a;     // Catch: Throwable -> L19
        if (r15 == null) goto L17;
        r15.a(this, r10, r11);     // Catch: Throwable -> L19
    L17:
        hc.e.m(r12);
        return;
    L19:
        th = move-exception;
        hc.e.m(r12);
        throw th;
    }

    public boolean k(String r10) {
        Objects.requireNonNull(r10, "text == null");
        return m(ByteString.encodeUtf8(r10), 1);
    }

    public boolean l(ByteString r10) {
        Objects.requireNonNull(r10, "bytes == null");
        return m(r10, 2);
    }

    boolean o() {
        monitor-enter(this);
    L37:
        th = move-exception;
        throw th;
    L4:
        if (this.f13648p == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L37
        return false;
    L7:
        ByteString r10 = this.f13638f.poll();     // Catch: Throwable -> L37
        if (r10 != null) goto L19;
        Object r11 = this.f13639g.poll();     // Catch: Throwable -> L37
        if ((r11 instanceof c) == true) goto L12;
        if (r11 != null) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L37
        return false;
    L18:
        rc.a r12 = null;
    L20:
        monitor-exit(this);     // Catch: Throwable -> L37
        if (r10 == null) goto L23;
        throw null;     // Catch: Throwable -> L32
    L23:
        if ((r11 instanceof d) == false) goto L25;
        ByteString r13 = ((d) r11).f13657b;     // Catch: Throwable -> L32
        int r14 = ((d) r11).f13656a;     // Catch: Throwable -> L32
        r13.size();     // Catch: Throwable -> L32
        throw null;     // Catch: Throwable -> L32
    L25:
        if ((r11 instanceof c) == false) goto L29;
        int r15 = ((c) r11).f13653a;     // Catch: Throwable -> L32
        throw null;     // Catch: Throwable -> L32
    L29:
        throw new AssertionError();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        hc.e.m(r12);
        throw th;
    L12:
        if (this.f13647o == (-1)) goto L14;
        r12 = this.f13643k;     // Catch: Throwable -> L37
        this.f13642j.shutdown();     // Catch: Throwable -> L37
        goto L20
    L14:
        this.f13646n = this.f13642j.schedule(new b(this), ((c) r11).f13655c, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L37
        goto L18
    L19:
        r12 = null;
        r11 = null;
        goto L20
    }

    void p(ByteString r10) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f13648p == false) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L8:
        if (this.f13650r == false) goto L10;
        int r11 = this.f13649q;     // Catch: Throwable -> L16
    L11:
        this.f13649q++;     // Catch: Throwable -> L16
        this.f13650r = true;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        if (r11 == (-1)) goto L20;
        i(new SocketTimeoutException(WsConstants.PING_NOT_RECEIVE_PONG_MSG), null);
        return;
    L20:
        return;
    L10:
        r11 = -1;
        goto L11
    }
}
