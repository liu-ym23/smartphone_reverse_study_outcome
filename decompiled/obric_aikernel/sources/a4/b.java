package a4;

import android.util.Pair;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import z3.d;
import z3.e;

/* JADX INFO: loaded from: classes.dex */
public class b extends ScheduledThreadPoolExecutor implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f87c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private e f88g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<Integer, List<ScheduledFuture<?>>> f89h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<ScheduledFuture<?>, Pair<Integer, Boolean>> f90i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ExecutorService f91j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ThreadPoolExecutor f92k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f93l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private C0002b f94m;

    class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExecutorService f95a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f96b;

        a(b r10, ExecutorService r11) {
            this.f96b = r10;
            this.f95a = r11;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r10, Method r11, Object[] r12) {
            Object r13 = r11.invoke(this.f95a, r12);
            if (b.k(this.f96b) == false) goto L12;
            String r14 = "null";
            if (r12 == null) goto L9;
            int r15 = r12.length;
            int r16 = 0;
        L7:
            if (r16 >= r15) goto L9;
            r14 = r14 + r12[r16];
            r16 = r16 + 1;
        L9:
            b.l(this.f96b, "call outer-executor " + r11.getName() + ", args: " + r14);
            if ("submit".equals(r11.getName()) == false) goto L12;
            b.l(this.f96b, "call outer-executor " + r11.getName() + ", args: " + r14);
        L12:
            return r13;
        }
    }

    /* JADX INFO: renamed from: a4.b$b, reason: collision with other inner class name */
    public class C0002b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f97a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f98b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f99c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f100d;

        public C0002b(b r10, Runnable r11, Thread r12, int r13) {
            this.f100d = r10;
            this.f97a = r11;
            this.f98b = System.currentTimeMillis();
            this.f99c = r13;
        }

        public void a() {
            Runnable r10 = this.f97a;
            if (r10 != null) goto L6;
            return;
        L6:
            if ((r10 instanceof FutureTask) == false) goto L11;
            boolean r11 = ((FutureTask) r10).cancel(true);
            if (b.k(this.f100d) == false) goto L12;
            b.l(this.f100d, "TimeSensitive + mCancelOverTimeTaskRunnable run ------------ cancel FutureTask, canceled?" + r11);
            return;
        L12:
            return;
        }

        public boolean b() {
            if ((System.currentTimeMillis() - this.f98b) <= this.f99c) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public b(int r10, ThreadFactory r11) {
        super(r10, r11);
        this.f87c = false;
        this.f89h = new ConcurrentHashMap();
        this.f90i = new ConcurrentHashMap();
    }

    static /* synthetic */ boolean k(b r10) {
        return r10.s();
    }

    static /* synthetic */ void l(b r10, String r11) {
        r10.q(r11);
    }

    private boolean m(d r10) {
        boolean r11 = false;
        if (r10 != null) goto L5;
        return false;
    L5:
        int r12 = r10.hashCode();
        List<ScheduledFuture<?>> r13 = this.f89h.get(Integer.valueOf(r12));
        StringBuilder r14 = new StringBuilder();
        r14.append("z-debug scheduledFutures in ?");
        if (r13 == null) goto L8;
        boolean r15 = true;
    L9:
        r14.append(r15);
        q(r14.toString());
        if (r13 != null) goto L12;
    L25:
        return r11;
    L12:
        if (r13.isEmpty() == true) goto L25;
        if (s() == false) goto L16;
        q("z-debug-removeTask from mTaskFutureMap" + z3.b.b(r10));
        q("z-debug scheduledFutures size:" + r13.size());
    L16:
        Iterator<ScheduledFuture<?>> r16 = r13.iterator();
    L18:
        if (r16.hasNext() == false) goto L25;
        ScheduledFuture<?> r17 = r16.next();
        if (r17.isCancelled() == true) goto L18;
        if (r17.cancel(true) == false) goto L24;
        r11 = true;
    L24:
        t(Integer.valueOf(r12), r17);
        goto L18
    L8:
        r15 = false;
        goto L9
    }

    private void n() {
        C0002b r10 = this.f94m;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.b() == false) goto L9;
        this.f94m.a();
        this.f94m = null;
        return;
    }

    private void o(boolean r10, Runnable r11, Thread r12) {
        if (r() == true) goto L5;
        return;
    L5:
        if (r10 == false) goto L7;
        C0002b r13 = new C0002b(this, r11, r12, this.f93l);
    L8:
        this.f94m = r13;
        return;
    L7:
        r13 = null;
        goto L8
    }

    private String p(Runnable r10) {
        if ((r10 instanceof d) == true) goto L5;
        if (r10 != null) goto L10;
        return "null";
    L10:
        return r10.toString();
    L5:
        return ((d) r10).P();
    }

    private void q(String r10) {
        z3.b.c(this.f88g, "ApmInnerThreadPool", r10);
    }

    private boolean r() {
        if (this.f93l <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean s() {
        if (this.f87c == false) goto L9;
        e r10 = this.f88g;
        if (r10 == null) goto L9;
        if (r10.isDebug() == false) goto L9;
        return true;
    L9:
        return false;
    }

    private void t(Integer r10, ScheduledFuture r11) {
        List<ScheduledFuture<?>> r12 = this.f89h.get(r10);
        if (r12 == null) goto L7;
        boolean r13 = r12.remove(r11);
        if (r12.isEmpty() == false) goto L8;
        this.f89h.remove(r10);
    L8:
        this.f90i.remove(r11);
        if (s() == false) goto L12;
        q("z-debug removeMapRecord: " + r11 + ", removed: " + r13);
        return;
    L12:
        return;
    L7:
        r13 = false;
        goto L8
    }

    private void u(ScheduledFuture<?> r10, int r11, boolean r12) {
        List<ScheduledFuture<?>> r13 = this.f89h.get(Integer.valueOf(r11));
        if (r13 != null) goto L5;
        r13 = new CopyOnWriteArrayList();
        this.f89h.put(Integer.valueOf(r11), r13);
    L5:
        r13.add(r10);
        this.f90i.put(r10, new Pair(Integer.valueOf(r11), Boolean.valueOf(r12)));
        if (s() == false) goto L9;
        q("z-debug saveToMap -current task count: " + getQueue().size() + ", thread-count; " + getActiveCount());
        q("z-debug saveToMap >>>>>> mTaskFutureMap size: " + this.f89h.size() + ", mFutureTaskMap size: " + this.f90i.size());
        StringBuilder r14 = new StringBuilder();
        r14.append("z-debug saveToMap >>>>>> sameHashCodeFutures size: ");
        r14.append(r13.size());
        q(r14.toString());
        return;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable r10, Throwable r11) {
        super.afterExecute(r10, r11);
        o(false, r10, null);
        if ((r10 instanceof ScheduledFuture) == false) goto L18;
        ScheduledFuture r12 = (ScheduledFuture) r10;
        Pair<Integer, Boolean> r13 = this.f90i.get(r12);
        if (r13 == null) goto L19;
        Object r14 = r13.first;
        if (r14 == null) goto L20;
        int r15 = ((Integer) r14).intValue();
        Boolean r16 = (Boolean) r13.second;
        if (r16 != null) goto L11;
        return;
    L11:
        if (r16.booleanValue() == false) goto L14;
        return;
    L14:
        if (s() == false) goto L16;
        q("z-debug postDelay or scheduled task: " + r10 + ", taskHashCode: " + r15 + ", in map? " + this.f89h.containsKey(Integer.valueOf(r15)));
    L16:
        t(Integer.valueOf(r15), r12);
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // a4.c
    public void b(d r10, long r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (s() == false) goto L7;
        q("postDelayed " + z3.b.b(r10));
    L7:
        u(schedule(r10, r11, TimeUnit.MILLISECONDS), r10.hashCode(), false);
        n();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread r10, Runnable r11) {
        o(true, r11, r10);
        super.beforeExecute(r10, r11);
    }

    @Override // a4.c
    public void d(d r10) {
        if (s() == false) goto L5;
        q("post " + z3.b.b(r10));
    L5:
        submit(r10);
        n();
        if (this.f91j == null) goto L8;
        return;
    L8:
        if (s() == false) goto L12;
        q("current task count: " + getQueue().size());
        return;
    }

    @Override // a4.c
    public void f(d r10) {
        ThreadPoolExecutor r11 = this.f92k;
        if (r11 == null) goto L6;
        r11.remove(r10);
    L6:
        if (m(r10) == false) goto L8;
        return;
    L8:
        if (s() == false) goto L12;
        q("z-debug-removeTask " + z3.b.b(r10) + ", remove failed");
        return;
    }

    @Override // a4.c
    public void g(d r10, long r11, long r12) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (s() == false) goto L7;
        q("scheduleWithFixedDelay " + z3.b.b(r10) + ", initialDelay: " + r11 + ", delayInMillis: " + r12 + "\n task count: " + getQueue().size());
    L7:
        m(r10);
        u(scheduleWithFixedDelay(r10, r11, r12, TimeUnit.MILLISECONDS), r10.hashCode(), true);
        n();
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable r10) {
        if (this.f91j == null) goto L10;
        if (s() == false) goto L8;
        q("submit task to outer-executor: " + p(r10));
    L8:
        return this.f91j.submit(r10);
    L10:
        return super.submit(r10);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable r10, T r11) {
        if (this.f91j == null) goto L10;
        if (s() == false) goto L8;
        q("submit task to outer-executor: " + p(r10));
    L8:
        return this.f91j.submit(r10, r11);
    L10:
        return super.submit(r10, r11);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> r10) {
        if (this.f91j == null) goto L10;
        if (s() == false) goto L8;
        q("submit task to outer-executor: " + r10);
    L8:
        return this.f91j.submit(r10);
    L10:
        return super.submit(r10);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void terminated() {
        super.terminated();
    }

    public void v(ExecutorService r10) {
        if (r10 != null) goto L6;
        this.f91j = null;
        this.f92k = null;
        return;
    L6:
        if ((r10 instanceof ThreadPoolExecutor) == false) goto L8;
        this.f92k = (ThreadPoolExecutor) r10;
    L8:
        this.f91j = (ExecutorService) Proxy.newProxyInstance(r10.getClass().getClassLoader(), new Class[]{ExecutorService.class}, new a(this, r10));
    }

    public void w(e r10) {
        this.f88g = r10;
    }
}
