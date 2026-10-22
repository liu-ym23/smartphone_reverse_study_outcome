package bolts;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class g<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f102a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Executor f103b = null;
    private static final Executor c = null;
    private static volatile a d;
    private static g<?> m;
    private static g<Boolean> n;
    private static g<Boolean> o;
    private static g<?> p;
    private final Object e;
    private boolean f;
    private boolean g;
    private TResult h;
    private Exception i;
    private boolean j;
    private i k;
    private List<f<TResult, Void>> l;

    public interface a {
        void a(g<?> r1, UnobservedTaskException r2);
    }

    static {
        f102a = b.a();
        c = b.c();
        f103b = bolts.a.b();
        m = new g(null);
        n = new g(true);
        o = new g(false);
        p = new g(true);
    }

    g() {
        this.e = new Object();
        this.l = new ArrayList();
    }

    private g(TResult r2) {
        this.e = new Object();
        this.l = new ArrayList();
        b(r2);
    }

    private g(boolean r2) {
        this.e = new Object();
        this.l = new ArrayList();
        if (r2 == false) goto L5;
        e();
        return;
    L5:
        b(null);
    }

    public static a a() {
        return d;
    }

    public static g<Void> a(long r2) {
        return a(r2, b.b(), null);
    }

    static g<Void> a(long r3, ScheduledExecutorService r5, c r6) {
        ScheduledExecutorService r7 = (ScheduledExecutorService) ZeusTransformUtils.wrapperContextForParams(r5, ScheduledExecutorService.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L9;
        if (r6.a() == false) goto L9;
        return d();
    L9:
        if (r3 <= 0) goto L11;
        final h r0 = new h();
        final ScheduledFuture<?> r4 = r7.schedule(new AnonymousClass1(r0), r3, TimeUnit.MILLISECONDS);
        if (r6 == null) goto L16;
        r6.a(new AnonymousClass4(r4, r0));
    L16:
        return r0.a();
    L11:
        return a(null);
    }

    public static <TResult> g<TResult> a(TResult r2) {
        if (r2 != null) goto L6;
        return (g<TResult>) m;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == true) goto L8;
        h r0 = new h();
        r0.setResult(r2);
        return r0.a();
    L8:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L11;
        return (g<TResult>) n;
    L11:
        return (g<TResult>) o;
    }

    static /* synthetic */ void a(h r2, f r3, g r4, Executor r5, c r6) {
        b(r2, (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin"), r4, (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin"), r6);
    }

    private static <TContinuationResult, TResult> void b(final h<TContinuationResult> r2, f<TResult, TContinuationResult> r3, final g<TResult> r4, Executor r5, final c r6) {
        final f r7 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
        r8.execute(new AnonymousClass3(r6, r2, r7, r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        r2.b(new ExecutorException(e));
    }

    public static <TResult> g<TResult> call(Callable<TResult> r2) {
        return call((Callable) ZeusTransformUtils.wrapperContextForParams(r2, Callable.class, "com.obric.memorydata.plugin"), c, null);
    }

    public static <TResult> g<TResult> call(Callable<TResult> r2, c r3) {
        return call((Callable) ZeusTransformUtils.wrapperContextForParams(r2, Callable.class, "com.obric.memorydata.plugin"), c, r3);
    }

    public static <TResult> g<TResult> call(Callable<TResult> r2, Executor r3) {
        return call((Callable) ZeusTransformUtils.wrapperContextForParams(r2, Callable.class, "com.obric.memorydata.plugin"), (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin"), null);
    }

    public static <TResult> g<TResult> call(Callable<TResult> r2, Executor r3, final c r4) {
        final Callable r5 = (Callable) ZeusTransformUtils.wrapperContextForParams(r2, Callable.class, "com.obric.memorydata.plugin");
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
        final h r0 = new h();
        r6.execute(new AnonymousClass5(r4, r0, r5));     // Catch: Exception -> L5
    L8:
        return r0.a();
    L5:
        e = move-exception;
        r0.b(new ExecutorException(e));
        goto L8
    }

    public static <TResult> g<TResult> d() {
        return (g<TResult>) p;
    }

    private void f() {
        Object r0 = this.e;
        monitor-enter(r0);
        Iterator<f<TResult, Void>> r1 = this.l.iterator();     // Catch: Throwable -> L18
    L6:
        if (r1.hasNext() == false) goto L15;
        ((f) ZeusTransformUtils.preCheckCast(r1.next(), f.class, "com.obric.memorydata.plugin")).a(this);     // Catch: Exception -> L10 RuntimeException -> L13 Throwable -> L18
    L13:
        e = move-exception;
        throw e;     // Catch: Throwable -> L18
    L10:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L18
    L15:
        this.l = null;     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public <TContinuationResult> g<TContinuationResult> a(f<TResult, TContinuationResult> r3) {
        return a((f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin"), c, null);
    }

    public <TContinuationResult> g<TContinuationResult> a(f<TResult, TContinuationResult> r12, Executor r13, final c r14) {
        final f r15 = (f) ZeusTransformUtils.wrapperContextForParams(r12, f.class, "com.obric.memorydata.plugin");
        final Executor r16 = (Executor) ZeusTransformUtils.wrapperContextForParams(r13, Executor.class, "com.obric.memorydata.plugin");
        final h r6 = new h();
        Object r7 = this.e;
        monitor-enter(r7);
        boolean r8 = b();     // Catch: Throwable -> L12
        if (r8 == true) goto L7;
        this.l.add(new AnonymousClass2(this, r6, r15, r16, r14));     // Catch: Throwable -> L12
    L7:
        monitor-exit(r7);     // Catch: Throwable -> L12
        if (r8 == false) goto L11;
        b(r6, r15, this, r16, r14);
    L11:
        return r6.a();
    L12:
        th = move-exception;
        throw th;
    }

    boolean a(Exception r4) {
        Object r0 = this.e;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L8:
        this.f = true;     // Catch: Throwable -> L15
        this.i = r4;     // Catch: Throwable -> L15
        this.j = false;     // Catch: Throwable -> L15
        this.e.notifyAll();     // Catch: Throwable -> L15
        f();     // Catch: Throwable -> L15
        if (this.j == false) goto L11;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return true;
    L11:
        if (a() == null) goto L13;
        this.k = new i(this);     // Catch: Throwable -> L15
        goto L13
    }

    public boolean b() {
        Object r0 = this.e;
        monitor-enter(r0);
        boolean r1 = this.f;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean b(TResult r3) {
        Object r0 = this.e;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f == true) goto L7;
        this.f = true;     // Catch: Throwable -> L12
        this.h = r3;     // Catch: Throwable -> L12
        this.e.notifyAll();     // Catch: Throwable -> L12
        f();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    }

    public Exception c() {
        Object r0 = this.e;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.i == null) goto L9;
        this.j = true;     // Catch: Throwable -> L12
        i r1 = this.k;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        r1.a();     // Catch: Throwable -> L12
        this.k = null;     // Catch: Throwable -> L12
    L9:
        Exception r2 = this.i;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    }

    boolean e() {
        Object r0 = this.e;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f == true) goto L7;
        this.f = true;     // Catch: Throwable -> L12
        this.g = true;     // Catch: Throwable -> L12
        this.e.notifyAll();     // Catch: Throwable -> L12
        f();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    }
}
