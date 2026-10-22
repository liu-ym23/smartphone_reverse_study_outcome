package jc;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 TaskLogger.kt\nokhttp3/internal/concurrent/TaskLoggerKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 Util.kt\nokhttp3/internal/Util\n*L\n1#1,218:1\n1#2:219\n25#3,4:220\n25#3,4:224\n25#3,4:228\n25#3,4:232\n25#3,4:251\n350#4,7:236\n615#5,4:243\n615#5,4:247\n*S KotlinDebug\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue\n*L\n65#1:220,4\n68#1:224,4\n153#1:228,4\n159#1:232,4\n208#1:251,4\n165#1:236,7\n179#1:243,4\n189#1:247,4\n*E\n"})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f9919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f9922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<a> f9923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f9924f;

    public d(e r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "taskRunner");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        this.f9919a = r10;
        this.f9920b = r11;
        this.f9923e = new ArrayList();
    }

    public static /* synthetic */ void j(d r10, a r11, long r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = 0;
    L5:
        r10.i(r11, r12);
    }

    public final void a() {
        if (hc.e.f9283g == true) goto L5;
    L9:
        e r10 = this.f9919a;
        monitor-enter(r10);
    L17:
        th = move-exception;
        throw th;
    L12:
        if (b() == false) goto L14;
        this.f9919a.h(this);     // Catch: Throwable -> L17
    L14:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r10);
        return;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final boolean b() {
        a r10 = this.f9922d;
        if (r10 == null) goto L7;
        Intrinsics.checkNotNull(r10);
        if (r10.a() == false) goto L7;
        this.f9924f = true;
    L7:
        boolean r11 = false;
        int r12 = this.f9923e.size() - 1;
    L9:
        if ((-1) >= r12) goto L17;
        if (this.f9923e.get(r12).a() == false) goto L16;
        a r13 = this.f9923e.get(r12);
        if (e.f9925h.a().isLoggable(Level.FINE) == false) goto L15;
        b.a(r13, this, "canceled");
    L15:
        this.f9923e.remove(r12);
        r11 = true;
    L16:
        r12 = r12 - 1;
        goto L9
    L17:
        return r11;
    }

    public final a c() {
        return this.f9922d;
    }

    public final boolean d() {
        return this.f9924f;
    }

    public final List<a> e() {
        return this.f9923e;
    }

    public final String f() {
        return this.f9920b;
    }

    public final boolean g() {
        return this.f9921c;
    }

    public final e h() {
        return this.f9919a;
    }

    public final void i(a r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "task");
        e r12 = this.f9919a;
        monitor-enter(r12);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.f9921c == false) goto L19;
        if (r10.a() == false) goto L14;
        if (e.f9925h.a().isLoggable(Level.FINE) == false) goto L11;
        b.a(r10, this, "schedule canceled (queue is shutdown)");     // Catch: Throwable -> L24
    L11:
        monitor-exit(r12);
        return;
    L14:
        if (e.f9925h.a().isLoggable(Level.FINE) == false) goto L17;
        b.a(r10, this, "schedule failed (queue is shutdown)");     // Catch: Throwable -> L24
    L17:
        throw new RejectedExecutionException();     // Catch: Throwable -> L24
    L19:
        if (k(r10, r11, false) == false) goto L21;
        this.f9919a.h(this);     // Catch: Throwable -> L24
    L21:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r12);
    }

    public final boolean k(a r10, long r11, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "task");
        r10.e(this);
        long r12 = this.f9919a.g().c();
        long r14 = r12 + r11;
        int r15 = this.f9923e.indexOf(r10);
        if (r15 != (-1)) goto L5;
    L11:
        r10.g(r14);
        if (e.f9925h.a().isLoggable(Level.FINE) == false) goto L17;
        if (r13 == false) goto L15;
        StringBuilder r16 = new StringBuilder();
        String r17 = "run again after ";
    L16:
        r16.append(r17);
        r16.append(b.b(r14 - r12));
        b.a(r10, this, r16.toString());
        goto L17
    L15:
        r16 = new StringBuilder();
        r17 = "scheduled after ";
    L17:
        Iterator<a> r18 = this.f9923e.iterator();
        int r19 = 0;
    L19:
        if (r18.hasNext() == false) goto L27;
        if ((r18.next().c() - r12) <= r11) goto L23;
        boolean r20 = true;
    L24:
        if (r20 == true) goto L28;
        r19 = r19 + 1;
    L28:
        if (r19 != (-1)) goto L30;
        r19 = this.f9923e.size();
    L30:
        this.f9923e.add(r19, r10);
        if (r19 == 0) goto L33;
        return false;
    L33:
        return true;
    L23:
        r20 = false;
        goto L24
    L27:
        r19 = -1;
        goto L28
    L5:
        if (r10.c() <= r14) goto L7;
        this.f9923e.remove(r15);
        goto L11
    L7:
        if (e.f9925h.a().isLoggable(Level.FINE) == false) goto L9;
        b.a(r10, this, "already scheduled");
    L9:
        return false;
    }

    public final void l(a r10) {
        this.f9922d = r10;
    }

    public final void m(boolean r10) {
        this.f9924f = r10;
    }

    public final void n() {
        if (hc.e.f9283g == true) goto L5;
    L9:
        e r10 = this.f9919a;
        monitor-enter(r10);
        this.f9921c = true;     // Catch: Throwable -> L18
        if (b() == false) goto L15;
        this.f9919a.h(this);     // Catch: Throwable -> L18
    L15:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r10);
        return;
    L18:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public String toString() {
        return this.f9920b;
    }
}
