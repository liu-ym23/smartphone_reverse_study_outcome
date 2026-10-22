package okhttp3;

import androidx.core.app.NotificationCompat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Dispatcher.kt\nokhttp3/Dispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokhttp3/internal/Util\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,241:1\n1#2:242\n615#3,4:243\n1549#4:247\n1620#4,3:248\n1549#4:251\n1620#4,3:252\n*S KotlinDebug\n*F\n+ 1 Dispatcher.kt\nokhttp3/Dispatcher\n*L\n162#1:243,4\n222#1:247\n222#1:248,3\n227#1:251\n227#1:252,3\n*E\n"})
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f12014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ExecutorService f12015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayDeque<okhttp3.internal.connection.e.a> f12016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayDeque<okhttp3.internal.connection.e.a> f12017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayDeque<okhttp3.internal.connection.e> f12018g;

    public o() {
        this.f12012a = 64;
        this.f12013b = 5;
        this.f12016e = new ArrayDeque();
        this.f12017f = new ArrayDeque();
        this.f12018g = new ArrayDeque();
    }

    public o(ExecutorService r10) {
        Intrinsics.checkNotNullParameter(r10, "executorService");
        this();
        this.f12015d = r10;
    }

    private final <T> void c(Deque<T> r10, T r11) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (r10.remove(r11) == false) goto L13;
        Runnable r12 = this.f12014c;     // Catch: Throwable -> L14
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);
        if (f() == true) goto L18;
        if (r12 == null) goto L19;
        r12.run();
        return;
    L19:
        return;
    L18:
        return;
    L13:
        throw new AssertionError("Call wasn't in-flight!");     // Catch: Throwable -> L14
    }

    private final boolean f() {
        if (hc.e.f9283g == true) goto L5;
    L9:
        ArrayList r10 = new ArrayList();
        monitor-enter(this);
        Iterator<okhttp3.internal.connection.e.a> r11 = this.f12016e.iterator();     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r11, "readyAsyncCalls.iterator()");     // Catch: Throwable -> L29
    L13:
        if (r11.hasNext() == false) goto L19;
        okhttp3.internal.connection.e.a r12 = r11.next();     // Catch: Throwable -> L29
        if (this.f12017f.size() >= this.f12012a) goto L19;
        if (r12.b().get() >= this.f12013b) goto L13;
        r11.remove();     // Catch: Throwable -> L29
        r12.b().incrementAndGet();     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r12, "asyncCall");     // Catch: Throwable -> L29
        r10.add(r12);     // Catch: Throwable -> L29
        this.f12017f.add(r12);     // Catch: Throwable -> L29
    L19:
        int r13 = 0;
        if (g() <= 0) goto L22;
        boolean r14 = true;
    L23:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L29
        monitor-exit(this);
        int r16 = r10.size();
    L26:
        if (r13 >= r16) goto L28;
        ((okhttp3.internal.connection.e.a) r10.get(r13)).a(b());
        r13 = r13 + 1;
        goto L26
    L28:
        return r14;
    L22:
        r14 = false;
    L29:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final synchronized void a(okhttp3.internal.connection.e r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);     // Catch: Throwable -> L6
        this.f12018g.add(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @JvmName(name = "executorService")
    public final synchronized ExecutorService b() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f12015d != null) goto L6;
        this.f12015d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), hc.e.N(hc.e.f9284h + " Dispatcher", false));     // Catch: Throwable -> L9
    L6:
        ExecutorService r10 = this.f12015d;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r10;
    }

    public final void d(okhttp3.internal.connection.e.a r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        r10.b().decrementAndGet();
        c(this.f12017f, r10);
    }

    public final void e(okhttp3.internal.connection.e r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        c(this.f12018g, r10);
    }

    public final synchronized int g() {
        monitor-enter(this);
        int r10 = this.f12017f.size() + this.f12018g.size();
        monitor-exit(this);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }
}
