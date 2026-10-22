package com.bytedance.ttnet.config;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.http.exception.DroppedByThrottleControlException;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.b0;
import com.bytedance.ttnet.TTNetInit;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTHttpCallThrottleControl implements s4.b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static volatile TTHttpCallThrottleControl f2804o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f2805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, e> f2806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile e f2807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReadWriteLock f2808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Lock f2809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<n4.c> f2810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set<n4.c> f2811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicLong f2812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Set<n4.c> f2813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map<Runnable, Executor> f2814j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ReadWriteLock f2815k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lock f2816l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lock f2817m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Condition f2818n;

    public static final enum DelayMode extends Enum<DelayMode> {
        private static final /* synthetic */ DelayMode[] $VALUES = null;
        public static final DelayMode BLACK_LIST = null;
        public static final DelayMode NOT_REACHED = null;
        public static final DelayMode NO_DELAY = null;
        public static final DelayMode RUNTIME = null;
        public static final DelayMode WHITE_LIST = null;

        static {
            DelayMode r10 = new DelayMode("NO_DELAY", 0);
            NO_DELAY = r10;
            DelayMode r11 = new DelayMode("BLACK_LIST", 1);
            BLACK_LIST = r11;
            DelayMode r12 = new DelayMode("WHITE_LIST", 2);
            WHITE_LIST = r12;
            DelayMode r13 = new DelayMode("RUNTIME", 3);
            RUNTIME = r13;
            DelayMode r14 = new DelayMode("NOT_REACHED", 4);
            NOT_REACHED = r14;
            $VALUES = new DelayMode[]{r10, r11, r12, r13, r14};
        }

        private DelayMode(String r10, int r11) {
            super(r10, r11);
        }

        public static DelayMode valueOf(String r10) {
            return (DelayMode) Enum.valueOf(DelayMode.class, r10);
        }

        public static DelayMode[] values() {
            return (DelayMode[]) $VALUES.clone();
        }
    }

    class a extends j2.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Runnable f2819c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ n4.c f2820g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ RetrofitMetrics f2821h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Executor f2822i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ TTHttpCallThrottleControl f2823j;

        a(TTHttpCallThrottleControl r10, long r11, long r12, Runnable r13, n4.c r14, RetrofitMetrics r15, Executor r16) {
            this.f2823j = r10;
            this.f2819c = r13;
            this.f2820g = r14;
            this.f2821h = r15;
            this.f2822i = r16;
            super(r11, r12);
        }

        @Override // java.lang.Runnable
        public void run() {
            TTHttpCallThrottleControl.e(this.f2823j).lock();
        L11:
            th = move-exception;
            TTHttpCallThrottleControl.e(this.f2823j).unlock();
            throw th;
        L4:
            if (TTHttpCallThrottleControl.f(this.f2823j).containsKey(this.f2819c) == true) goto L6;
        L9:
            TTHttpCallThrottleControl.e(this.f2823j).unlock();
            return;
        L6:
            if (Logger.debug() == false) goto L8;
            Logger.d("delayrefine", "release p1 from auto max time " + this.f2820g.A());     // Catch: Throwable -> L11
        L8:
            this.f2821h.E = System.currentTimeMillis() - this.f2821h.H;     // Catch: Throwable -> L11
            this.f2822i.execute(this.f2819c);     // Catch: Throwable -> L11
            TTHttpCallThrottleControl.f(this.f2823j).remove(this.f2819c);     // Catch: Throwable -> L11
            goto L9
        }
    }

    class b implements b0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ RetrofitMetrics f2824c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Executor f2825g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Runnable f2826h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ n4.c f2827i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f2828j;

        b(TTHttpCallThrottleControl r10, RetrofitMetrics r11, Executor r12, Runnable r13, n4.c r14, int r15) {
            this.f2824c = r11;
            this.f2825g = r12;
            this.f2826h = r13;
            this.f2827i = r14;
            this.f2828j = r15;
        }

        @Override // com.bytedance.retrofit2.b0
        public int D() {
            return this.f2827i.B();
        }

        @Override // com.bytedance.retrofit2.b0
        public boolean M() {
            return this.f2827i.N();
        }

        @Override // java.lang.Runnable
        public void run() {
            RetrofitMetrics r10 = this.f2824c;
            r10.E = System.currentTimeMillis() - this.f2824c.H;
            this.f2825g.execute(this.f2826h);
        }

        @Override // com.bytedance.retrofit2.b0
        public RetrofitMetrics u() {
            return this.f2827i.z();
        }

        @Override // com.bytedance.retrofit2.b0
        public int v() {
            return this.f2828j;
        }
    }

    class c extends j2.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ n4.c f2829c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ TTHttpCallThrottleControl f2830g;

        c(TTHttpCallThrottleControl r10, n4.c r11) {
            this.f2830g = r10;
            this.f2829c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean r10 = TTHttpCallThrottleControl.g(this.f2830g).remove(this.f2829c);
            if (Logger.debug() == true) goto L5;
        L7:
            TTHttpCallThrottleControl.h(this.f2830g).remove(this.f2829c);
            TTHttpCallThrottleControl.i(this.f2830g).remove(this.f2829c);
            if (r10 == true) goto L10;
            return;
        L10:
            if (TTHttpCallThrottleControl.g(this.f2830g).size() == 0) goto L12;
            return;
        L12:
            if (Logger.debug() == false) goto L14;
            Logger.d("delayrefine", "release when all p0 done");
        L14:
            TTHttpCallThrottleControl.j(this.f2830g);
            return;
        L5:
            if (this.f2829c.z() == null) goto L7;
            Logger.d("delayrefine", "notifyRequestCompleted " + this.f2829c.A() + " after remove p0 set size is " + TTHttpCallThrottleControl.g(this.f2830g).size() + " sync size when send is " + this.f2829c.z().F + " async size when send is " + this.f2829c.z().G + " is delay? " + this.f2829c.z().D + " delay time is " + this.f2829c.z().E + " random time is " + this.f2829c.z().I + " delay state is " + this.f2829c.z().B);
            goto L7
        }
    }

    class d extends j2.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Runnable f2831c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f2832g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Executor f2833h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ TTHttpCallThrottleControl f2834i;

        d(TTHttpCallThrottleControl r10, long r11, long r12, Runnable r13, int r14, Executor r15) {
            this.f2834i = r10;
            this.f2831c = r13;
            this.f2832g = r14;
            this.f2833h = r15;
            super(r11, r12);
        }

        @Override // java.lang.Runnable
        public void run() {
            TTHttpCallThrottleControl.e(this.f2834i).lock();
        L14:
            th = move-exception;
            TTHttpCallThrottleControl.e(this.f2834i).unlock();
            throw th;
        L4:
            if (TTHttpCallThrottleControl.f(this.f2834i).containsKey(this.f2831c) == false) goto L12;
            Runnable r10 = this.f2831c;     // Catch: Throwable -> L14
            if ((r10 instanceof b0) == false) goto L9;
            RetrofitMetrics r11 = ((b0) r10).u();     // Catch: Throwable -> L14
            r11.E = System.currentTimeMillis() - r11.H;     // Catch: Throwable -> L14
            r11.I = this.f2832g;     // Catch: Throwable -> L14
        L9:
            if (Logger.debug() == false) goto L11;
            Logger.d("delayrefine", "release p1 from all p0 done, random is " + this.f2832g);     // Catch: Throwable -> L14
        L11:
            this.f2833h.execute(this.f2831c);     // Catch: Throwable -> L14
            TTHttpCallThrottleControl.f(this.f2834i).remove(this.f2831c);     // Catch: Throwable -> L14
        L12:
            TTHttpCallThrottleControl.e(this.f2834i).unlock();
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        DelayMode f2835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f2837c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2838d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f2839e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f2840f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Set<String> f2841g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Map<String, Integer> f2842h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Set<String> f2843i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f2844j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Set<String> f2845k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Set<String> f2846l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Set<String> f2847m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f2848n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f2849o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f2850p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f2851q;

        private e() {
            this.f2835a = DelayMode.NO_DELAY;
            this.f2836b = -1;
            this.f2837c = "";
            this.f2838d = 1000;
            this.f2839e = 5;
            this.f2840f = 5;
            this.f2841g = new CopyOnWriteArraySet();
            this.f2842h = new ConcurrentHashMap();
            this.f2843i = new CopyOnWriteArraySet();
            this.f2844j = 100;
            this.f2845k = new CopyOnWriteArraySet();
            this.f2846l = new CopyOnWriteArraySet();
            this.f2847m = new CopyOnWriteArraySet();
            this.f2848n = 5000;
            this.f2849o = 5000;
            this.f2850p = 3000;
            this.f2851q = 500;
        }

        /* synthetic */ e(com.bytedance.ttnet.config.a r10) {
            this();
        }
    }

    public TTHttpCallThrottleControl() {
        this.f2805a = new AtomicBoolean(false);
        this.f2806b = new ConcurrentHashMap();
        this.f2807c = new e(null);
        ReentrantReadWriteLock r10 = new ReentrantReadWriteLock();
        this.f2808d = r10;
        this.f2809e = r10.readLock();
        r10.writeLock();
        this.f2810f = new CopyOnWriteArraySet();
        this.f2811g = new CopyOnWriteArraySet();
        this.f2812h = new AtomicLong(0);
        this.f2813i = new CopyOnWriteArraySet();
        this.f2814j = new ConcurrentHashMap();
        ReentrantReadWriteLock r11 = new ReentrantReadWriteLock();
        this.f2815k = r11;
        this.f2816l = r11.writeLock();
        ReentrantLock r12 = new ReentrantLock();
        this.f2817m = r12;
        this.f2818n = r12.newCondition();
    }

    static /* synthetic */ Lock e(TTHttpCallThrottleControl r10) {
        return r10.f2816l;
    }

    static /* synthetic */ Map f(TTHttpCallThrottleControl r10) {
        return r10.f2814j;
    }

    static /* synthetic */ Set g(TTHttpCallThrottleControl r10) {
        return r10.f2813i;
    }

    static /* synthetic */ Set h(TTHttpCallThrottleControl r10) {
        return r10.f2810f;
    }

    static /* synthetic */ Set i(TTHttpCallThrottleControl r10) {
        return r10.f2811g;
    }

    static /* synthetic */ void j(TTHttpCallThrottleControl r10) {
        r10.s();
    }

    private boolean k(e r10, n4.c r11) {
        if (p(r10.f2845k, r11.A()) == false) goto L10;
        this.f2812h.set(System.currentTimeMillis());
        this.f2813i.add(r11);
        if (Logger.debug() == false) goto L18;
        Logger.d("delayrefine", "p0 add request " + r11.A() + " size " + this.f2813i.size());
        return false;
    L18:
        return false;
    L10:
        if (r10.f2846l.size() <= 0) goto L14;
        return p(r10.f2846l, r11.A());
    L14:
        if (r10.f2847m.size() > 0) goto L16;
        return true;
    L16:
        return !p(r10.f2847m, r11.A());
    }

    public static TTHttpCallThrottleControl l() {
        if (f2804o != null) goto L15;
        monitor-enter(TTHttpCallThrottleControl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2804o != null) goto L9;
        f2804o = new TTHttpCallThrottleControl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTHttpCallThrottleControl.class);     // Catch: Throwable -> L11
    L15:
        return f2804o;
    }

    private Integer m(Map<String, Integer> r10, String r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        Iterator<String> r12 = r10.keySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L15;
        String r13 = r12.next();
        if (r11.startsWith(r13) == false) goto L7;
        return r10.get(r13);
    L15:
        return null;
    }

    private int n(boolean r10, e r11, RetrofitMetrics r12, n4.c r13) {
        if (r13.z() != null) goto L5;
        r13.S(r12);
    L5:
        r12.B = r11.f2836b;
        r12.F = this.f2811g.size();
        r12.G = this.f2810f.size();
        if (p(r11.f2841g, r13.A()) == true) goto L32;
        if (r10 == true) goto L10;
    L12:
        if (r10 == false) goto L14;
    L16:
        DelayMode r14 = r11.f2835a;
        if (r14 != DelayMode.BLACK_LIST) goto L23;
        Integer r15 = m(r11.f2842h, r13.A());
        if (r15 != null) goto L21;
        return 0;
    L21:
        return r15.intValue();
    L23:
        if (r14 == DelayMode.WHITE_LIST) goto L25;
        return -1;
    L25:
        if (p(r11.f2843i, r13.A()) == false) goto L27;
        return 0;
    L27:
        return r11.f2844j;
    L14:
        if (this.f2811g.size() < r11.f2839e) goto L16;
        return 0;
    L10:
        if (this.f2810f.size() < r11.f2840f) goto L12;
        return 0;
    L32:
        throw new DroppedByThrottleControlException();
    }

    private int o(boolean r10, int r11, int r12) {
        if (r10 == true) goto L5;
    L7:
        if (r10 == true) goto L12;
        if (this.f2811g.size() > 5) goto L12;
        return 0;
    L12:
        return new Random().nextInt((r12 - r11) + 1) + r11;
    L5:
        if (this.f2810f.size() > 5) goto L7;
        return 0;
    }

    private boolean p(Set<String> r10, String r11) {
        if (r11 != null) goto L5;
        return false;
    L5:
        Iterator<String> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L15;
        if (r11.startsWith(r12.next()) == false) goto L7;
        return true;
    L15:
        return false;
    }

    private boolean r() {
        if ((System.currentTimeMillis() - this.f2812h.get()) <= this.f2807c.f2848n) goto L6;
        return true;
    L6:
        if (this.f2813i.size() <= 0) goto L10;
        return false;
    L10:
        return true;
    }

    private void s() {
        if (Logger.debug() == false) goto L5;
        Logger.d("delayrefine", "releaseAllP1Request, " + this.f2811g.size() + " " + this.f2810f.size());
    L5:
        this.f2817m.lock();
        this.f2818n.signalAll();     // Catch: Throwable -> L23
        this.f2817m.unlock();
        this.f2809e.lock();
        int r10 = this.f2807c.f2851q;     // Catch: Throwable -> L20
        int r11 = this.f2807c.f2850p;     // Catch: Throwable -> L20
        this.f2809e.unlock();
        this.f2816l.lock();
        Iterator<Map.Entry<Runnable, Executor>> r12 = this.f2814j.entrySet().iterator();     // Catch: Throwable -> L17
    L12:
        if (r12.hasNext() == false) goto L15;
        Map.Entry<Runnable, Executor> r13 = r12.next();     // Catch: Throwable -> L17
        Runnable r14 = r13.getKey();     // Catch: Throwable -> L17
        Executor r15 = r13.getValue();     // Catch: Throwable -> L17
        int r16 = o(true, r10, r11);     // Catch: Throwable -> L17
        j2.b.d(NetworkAsyncTaskType.NETWORK).e(new d(this, r16, 0, r14, r16, r15));     // Catch: Throwable -> L17
        goto L12
    L15:
        this.f2816l.unlock();
        this.f2810f.clear();
        this.f2811g.clear();
        return;
    L17:
        th = move-exception;
        this.f2816l.unlock();
        throw th;
    L20:
        th = move-exception;
        this.f2809e.unlock();
        throw th;
    L23:
        th = move-exception;
        this.f2817m.unlock();
        throw th;
    }

    private void t(int r10, n4.c r11, RetrofitMetrics r12) {
        if (r10 > 0) goto L4;
        return;
    L4:
        this.f2811g.add(r11);
        r12.H = System.currentTimeMillis();
        r12.D = true;
        Thread.sleep(r10);     // Catch: Throwable -> L8 InterruptedException -> L10
        r12.E = System.currentTimeMillis() - r12.H;
        return;
    L10:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r12.E = System.currentTimeMillis() - r12.H;
        throw th;
    }

    private void u(int r10, Executor r11, Runnable r12, n4.c r13, RetrofitMetrics r14) {
        if (r10 > 0) goto L4;
        return;
    L4:
        r14.H = System.currentTimeMillis();
        r14.D = true;
        b r15 = new b(this, r14, r11, r12, r13, r10);
        this.f2810f.add(r13);
        r11.execute(r15);
    }

    @Override // s4.b
    public void a(n4.c r10, RetrofitMetrics r11) {
        if (this.f2805a.get() == true) goto L5;
        return;
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.A() == null) goto L72;
        if (r11 == null) goto L73;
        this.f2809e.lock();
        int r12 = n(false, this.f2807c, r11, r10);     // Catch: Throwable -> L57 Exception -> L59
        if (Logger.debug() == false) goto L15;
        Logger.d("delayrefine", "get sleep time " + r12 + " path is " + r10.A());     // Catch: Throwable -> L57 Exception -> L59
    L15:
        this.f2809e.unlock();
        if (r12 <= 0) goto L19;
        t(r12, r10, r11);
        return;
    L19:
        if (r12 != 0) goto L21;
        return;
    L21:
        this.f2809e.lock();
        int r13 = this.f2807c.f2851q;
        int r14 = this.f2807c.f2850p;
        int r15 = this.f2807c.f2849o;
    L51:
        th = move-exception;
        this.f2809e.unlock();
        throw th;
    L53:
        e = move-exception;
        throw e;     // Catch: Throwable -> L51
    L23:
        if (this.f2807c.f2835a == DelayMode.RUNTIME) goto L27;
    L24:
        this.f2809e.unlock();
        return;
    L27:
        if (k(this.f2807c, r10) == false) goto L24;
        if (r() == true) goto L24;
        this.f2809e.unlock();
        this.f2817m.lock();
        r11.H = SystemClock.uptimeMillis();     // Catch: Throwable -> L44 Exception -> L46
        this.f2811g.add(r10);     // Catch: Throwable -> L44 Exception -> L46
        if (Logger.debug() == false) goto L36;
        Logger.d("delayrefine", "execute p1 add request " + r10.A() + " after added me, sync size is " + this.f2811g.size());     // Catch: Throwable -> L44 Exception -> L46
    L36:
        this.f2818n.await(r15, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L44 Exception -> L46
        int r16 = o(false, r13, r14);     // Catch: Throwable -> L44 Exception -> L46
        long r17 = r16;
        r11.I = r17;     // Catch: Throwable -> L44 Exception -> L46
        if (r16 <= 0) goto L40;
        Thread.sleep(r17);     // Catch: Throwable -> L44 Exception -> L46
    L40:
        if (Logger.debug() == false) goto L42;
        Logger.d("delayrefine", "execute p1 release now " + r10.A() + " random is " + r16);     // Catch: Throwable -> L44 Exception -> L46
    L42:
        r11.E = SystemClock.uptimeMillis() - r11.H;     // Catch: Throwable -> L44 Exception -> L46
        r11.D = true;     // Catch: Throwable -> L44 Exception -> L46
    L47:
        this.f2817m.unlock();
        return;
    L46:
        Logger.e("sleeping interrupted");     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        this.f2817m.unlock();
        throw th;
    L59:
        e = move-exception;
        throw e;     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        this.f2809e.unlock();
        throw th;
    L73:
        return;
    }

    @Override // s4.b
    public void b(n4.c r10) {
        if (this.f2805a.get() == false) goto L5;
    L7:
        if (r10 != null) goto L9;
        return;
    L9:
        j2.b.d(NetworkAsyncTaskType.NETWORK).e(new c(this, r10));
        return;
    L5:
        if (this.f2813i.size() > 0) goto L7;
    }

    @Override // s4.b
    public boolean d(n4.c r16, RetrofitMetrics r17, Executor r18, Runnable r19) {
        if (this.f2805a.get() == true) goto L5;
        return false;
    L5:
        if (r16 != null) goto L7;
    L47:
        return false;
    L7:
        if (r16.A() == null) goto L47;
        if (r17 == null) goto L47;
        this.f2809e.lock();
        int r10 = this.f2807c.f2849o;
        int r11 = n(true, this.f2807c, r17, r16);     // Catch: Throwable -> L41 Exception -> L43
        if (Logger.debug() == false) goto L15;
        Logger.d("delayrefine", "get sleep time " + r11 + " path is " + r16.A());     // Catch: Throwable -> L41 Exception -> L43
    L15:
        if (r11 <= 0) goto L20;
        u(r11, r18, r19, r16, r17);     // Catch: Throwable -> L41 Exception -> L43
        Lock r12 = this.f2809e;
    L18:
        r12.unlock();
        return true;
    L20:
        if (r11 != 0) goto L24;
    L21:
        this.f2809e.unlock();
        return false;
    L24:
        if (this.f2807c.f2835a != DelayMode.RUNTIME) goto L21;
        if (k(this.f2807c, r16) == false) goto L21;
        if (r() == true) goto L21;
        this.f2809e.unlock();
        this.f2816l.lock();
        this.f2810f.add(r16);     // Catch: Throwable -> L38
        if (Logger.debug() == false) goto L36;
        Logger.d("delayrefine", "enqueue p1 add request " + r16.A() + " after added me, async size is " + this.f2810f.size());     // Catch: Throwable -> L38
    L36:
        r17.H = System.currentTimeMillis();     // Catch: Throwable -> L38
        this.f2814j.put(r19, r18);     // Catch: Throwable -> L38
        r17.D = true;     // Catch: Throwable -> L38
        j2.b.d(NetworkAsyncTaskType.NETWORK).e(new a(this, r10, 0, r19, r16, r17, r18));     // Catch: Throwable -> L38
        r12 = this.f2816l;
    L38:
        th = move-exception;
        this.f2816l.unlock();
        throw th;
    L43:
        e = move-exception;
        throw e;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        this.f2809e.unlock();
        throw th;
    }

    public void q(JSONObject r13) {
        JSONArray r10 = r13.optJSONArray("tt_req_delay_config");
        boolean r11 = true;
        if (r13.optInt("state_delay_enabled") <= 0) goto L5;
        boolean r12 = true;
    L7:
        if (r13.optInt("state_new_strategy_enabled", 1) <= 0) goto L9;
        boolean r14 = true;
    L11:
        if (TTNetInit.getStateDelayNewStrategyEnabled() == false) goto L14;
        if (r14 == false) goto L14;
    L15:
        if (r12 == false) goto L90;
        if (r10 == null) goto L90;
        if (r11 == true) goto L90;
        ConcurrentHashMap r15 = new ConcurrentHashMap();
        int r16 = 0;
    L21:
        if (r16 >= r10.length()) goto L87;
        e r17 = new e(null);
        JSONObject r18 = r10.optJSONObject(r16);
        if (r18 == null) goto L86;
        r17.f2837c = r18.optString("state_name", "");
        if (r18.isNull("bl_with_delay_ms") == true) goto L34;
        r17.f2835a = DelayMode.BLACK_LIST;
        JSONObject r19 = r18.optJSONObject("bl_with_delay_ms");
        if (r19 == null) goto L66;
        Iterator<String> r20 = r19.keys();
    L31:
        if (r20.hasNext() == false) goto L66;
        String r21 = r20.next();
        r17.f2842h.put(r21, Integer.valueOf(r19.optInt(r21)));
    L66:
        if (r17.f2842h.size() > 0) goto L72;
        if (r17.f2843i.size() > 0) goto L72;
        if (r17.f2845k.size() <= 0) goto L86;
    L72:
        if (TextUtils.isEmpty(r17.f2837c) == true) goto L86;
        int r22 = r18.optInt("delay_disable_time_ms", 1000);
        r17.f2838d = r22;
        if (r22 > 0) goto L78;
        r17.f2838d = 1000;
    L78:
        if (r18.isNull("dl") == true) goto L85;
        JSONArray r23 = r18.optJSONArray("dl");
        if (r23 == null) goto L85;
        int r24 = 0;
    L83:
        if (r24 >= r23.length()) goto L85;
        r17.f2841g.add((String) r23.opt(r24));
        r24 = r24 + 1;
    L85:
        r17.f2836b = r18.optInt("state", -1);
        r17.f2839e = r18.optInt("sync_req_delay_max_count", 10);
        r17.f2840f = r18.optInt("async_req_delay_max_count", 10);
        r15.put(r17.f2837c, r17);
        goto L86
    L34:
        if (r18.isNull("wl") == true) goto L45;
        r17.f2835a = DelayMode.WHITE_LIST;
        JSONArray r25 = r18.optJSONArray("wl");
        if (r25 == null) goto L41;
        int r26 = 0;
    L39:
        if (r26 >= r25.length()) goto L41;
        r17.f2843i.add((String) r25.opt(r26));
        r26 = r26 + 1;
    L41:
        int r27 = r18.optInt("delay_time_ms", 1000);
        r17.f2844j = r27;
        if (r27 > 0) goto L66;
        r17.f2844j = 1000;
        goto L66
    L45:
        if (r18.isNull("p0") == true) goto L66;
        r17.f2835a = DelayMode.RUNTIME;
        JSONArray r28 = r18.optJSONArray("p0");
        if (r28 == null) goto L52;
        int r29 = 0;
    L50:
        if (r29 >= r28.length()) goto L52;
        r17.f2845k.add((String) r28.opt(r29));
        r29 = r29 + 1;
    L52:
        JSONArray r30 = r18.optJSONArray("bl_for_runtime");
        if (r30 == null) goto L58;
        int r31 = 0;
    L56:
        if (r31 >= r30.length()) goto L58;
        r17.f2846l.add((String) r30.opt(r31));
        r31 = r31 + 1;
    L58:
        JSONArray r32 = r18.optJSONArray("wl_for_runtime");
        if (r32 == null) goto L64;
        int r33 = 0;
    L62:
        if (r33 >= r32.length()) goto L64;
        r17.f2847m.add((String) r32.opt(r33));
        r33 = r33 + 1;
    L64:
        r17.f2848n = r18.optInt("p0_check_max_ms", 5000);
        r17.f2849o = r18.optInt("p1_wait_max_ms", 5000);
        r17.f2850p = r18.optInt("random_send_ubound_ms", 3000);
        r17.f2851q = r18.optInt("random_send_lbound_ms", 500);
    L86:
        r16 = r16 + 1;
        goto L21
    L87:
        this.f2806b.clear();
        this.f2806b.putAll(r15);
    L88:
        this.f2805a.set(r12);
        return;
    L90:
        this.f2806b.clear();
    L14:
        r11 = false;
        goto L15
    L9:
        r14 = false;
        goto L11
    L5:
        r12 = false;
        goto L7
    }
}
