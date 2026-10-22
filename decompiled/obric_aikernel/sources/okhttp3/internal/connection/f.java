package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.b0;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nRealConnectionPool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealConnectionPool.kt\nokhttp3/internal/connection/RealConnectionPool\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Util.kt\nokhttp3/internal/Util\n*L\n1#1,250:1\n1#2:251\n1774#3,4:252\n608#4,4:256\n608#4,4:260\n608#4,4:264\n*S KotlinDebug\n*F\n+ 1 RealConnectionPool.kt\nokhttp3/internal/connection/RealConnectionPool\n*L\n60#1:252,4\n95#1:256,4\n106#1:260,4\n215#1:264,4\n*E\n"})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f11822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final jc.d f11824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f11825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentLinkedQueue<RealConnection> f11826e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b extends jc.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f11827e;

        b(f r10, String r11) {
            this.f11827e = r10;
            super(r11, false, 2, null);
        }

        @Override // jc.a
        public long f() {
            return this.f11827e.b(System.nanoTime());
        }
    }

    static {
        new a(null);
    }

    public f(jc.e r10, int r11, long r12, TimeUnit r13) {
        Intrinsics.checkNotNullParameter(r10, "taskRunner");
        Intrinsics.checkNotNullParameter(r13, "timeUnit");
        this.f11822a = r11;
        this.f11823b = r13.toNanos(r12);
        this.f11824c = r10.i();
        this.f11825d = new b(this, hc.e.f9284h + " ConnectionPool");
        this.f11826e = new ConcurrentLinkedQueue();
        if (r12 <= 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("keepAliveDuration <= 0: " + r12).toString());
    L5:
        r14 = false;
        goto L6
    }

    private final int d(RealConnection r10, long r11) {
        if (hc.e.f9283g == true) goto L5;
    L9:
        List<Reference<e>> r12 = r10.p();
        int r13 = 0;
    L11:
        if (r13 >= r12.size()) goto L20;
        Reference<e> r14 = r12.get(r13);
        if (r14.get() != null) goto L14;
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type okhttp3.internal.connection.RealCall.CallReference");
        okhttp3.internal.platform.h.f11979a.g().l("A connection to " + r10.a().a().m() + " was leaked. Did you forget to close a response body?", ((e.b) r14).a());
        r12.remove(r13);
        r10.D(true);
        if (r12.isEmpty() == false) goto L11;
        r10.C(r11 - this.f11823b);
        return 0;
    L14:
        r13 = r13 + 1;
        goto L11
    L20:
        return r12.size();
    L5:
        if (Thread.holdsLock(r10) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r10);
    }

    public final boolean a(okhttp3.a r10, e r11, List<b0> r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "address");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_CALL);
        Iterator<RealConnection> r14 = this.f11826e.iterator();
    L4:
        if (r14.hasNext() == false) goto L22;
        RealConnection r15 = r14.next();
        Intrinsics.checkNotNullExpressionValue(r15, WsConstants.KEY_CONNECTION);
        monitor-enter(r15);
        if (r13 == false) goto L11;
    L19:
        th = move-exception;
        throw th;
    L9:
        if (r15.x() == true) goto L11;
    L16:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r15);
    L11:
        if (r15.v(r10, r12) == false) goto L16;
        r11.e(r15);     // Catch: Throwable -> L19
        monitor-exit(r15);
        return true;
    L22:
        return false;
    }

    public final long b(long r11) {
        Iterator<RealConnection> r10 = this.f11826e.iterator();
        int r12 = 0;
        long r13 = Long.MIN_VALUE;
        RealConnection r14 = null;
        int r15 = 0;
    L4:
        if (r10.hasNext() == false) goto L19;
        RealConnection r16 = r10.next();
        Intrinsics.checkNotNullExpressionValue(r16, WsConstants.KEY_CONNECTION);
        monitor-enter(r16);
        if (d(r16, r11) <= 0) goto L10;
        r15 = r15 + 1;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r16);
        goto L4
    L10:
        r12 = r12 + 1;     // Catch: Throwable -> L16
        long r17 = r11 - r16.q();     // Catch: Throwable -> L16
        if (r17 <= r13) goto L13;
        r14 = r16;
        r13 = r17;
    L13:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L19:
        long r19 = this.f11823b;
        if (r13 < r19) goto L22;
    L31:
        Intrinsics.checkNotNull(r14);
        monitor-enter(r14);
    L49:
        th = move-exception;
        throw th;
    L35:
        if ((!r14.p().isEmpty()) == false) goto L40;
        monitor-exit(r14);
        return 0;
    L40:
        if ((r14.q() + r13) == r11) goto L43;
        monitor-exit(r14);
        return 0;
    L43:
        r14.D(true);     // Catch: Throwable -> L49
        this.f11826e.remove(r14);     // Catch: Throwable -> L49
        monitor-exit(r14);
        hc.e.n(r14.b());
        if (this.f11826e.isEmpty() == false) goto L48;
        this.f11824c.a();
    L48:
        return 0;
    L22:
        if (r12 > this.f11822a) goto L31;
        if (r12 > 0) goto L26;
        if (r15 <= 0) goto L29;
        return r19;
    L29:
        return -1;
    L26:
        return r19 - r13;
    }

    public final boolean c(RealConnection r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION);
        if (hc.e.f9283g == false) goto L10;
        if (Thread.holdsLock(r10) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r10);
    L10:
        if (r10.r() == false) goto L12;
    L15:
        r10.D(true);
        this.f11826e.remove(r10);
        if (this.f11826e.isEmpty() == false) goto L20;
        this.f11824c.a();
        return true;
    L20:
        return true;
    L12:
        if (this.f11822a == 0) goto L15;
        jc.d.j(this.f11824c, this.f11825d, 0, 2, null);
        return false;
    }

    public final void e(RealConnection r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION);
        if (hc.e.f9283g == true) goto L5;
    L9:
        this.f11826e.add(r10);
        jc.d.j(this.f11824c, this.f11825d, 0, 2, null);
        return;
    L5:
        if (Thread.holdsLock(r10) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r10);
    }
}
