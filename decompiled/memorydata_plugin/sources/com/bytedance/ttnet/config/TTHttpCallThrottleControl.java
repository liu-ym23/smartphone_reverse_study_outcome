package com.bytedance.ttnet.config;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.http.exception.DroppedByThrottleControlException;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsRunnable;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl;
import com.bytedance.ttnet.TTNetInit;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
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

/* JADX INFO: loaded from: classes2.dex */
public class TTHttpCallThrottleControl implements IHttpCallThrottleControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile TTHttpCallThrottleControl f3225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f3226b;
    private final Map<String, a> c;
    private volatile a d;
    private final ReadWriteLock e;
    private final Lock f;
    private final Lock g;
    private final Set<Request> h;
    private final Set<Request> i;
    private final AtomicLong j;
    private final Set<Request> k;
    private final Map<Runnable, Executor> l;
    private final ReadWriteLock m;
    private final Lock n;
    private final Lock o;
    private final Condition p;

    public static final enum DelayMode extends Enum<DelayMode> {
        private static final /* synthetic */ DelayMode[] $VALUES = null;
        public static final DelayMode BLACK_LIST = null;
        public static final DelayMode NOT_REACHED = null;
        public static final DelayMode NO_DELAY = null;
        public static final DelayMode RUNTIME = null;
        public static final DelayMode WHITE_LIST = null;

        static {
            DelayMode r0 = new DelayMode("NO_DELAY", 0);
            NO_DELAY = r0;
            DelayMode r1 = new DelayMode("BLACK_LIST", 1);
            BLACK_LIST = r1;
            DelayMode r3 = new DelayMode("WHITE_LIST", 2);
            WHITE_LIST = r3;
            DelayMode r5 = new DelayMode("RUNTIME", 3);
            RUNTIME = r5;
            DelayMode r7 = new DelayMode("NOT_REACHED", 4);
            NOT_REACHED = r7;
            $VALUES = new DelayMode[]{r0, r1, r3, r5, r7};
        }

        private DelayMode(String r1, int r2) {
            super(r1, r2);
        }

        public static DelayMode valueOf(String r2) {
            return (DelayMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(DelayMode.class, r2), DelayMode.class, "com.obric.memorydata.plugin");
        }

        public static DelayMode[] values() {
            return (DelayMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DelayMode[].class, "com.obric.memorydata.plugin");
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        DelayMode f3236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3237b;
        String c;
        int d;
        int e;
        int f;
        Set<String> g;
        Map<String, Integer> h;
        Set<String> i;
        int j;
        Set<String> k;
        Set<String> l;
        Set<String> m;
        int n;
        int o;
        int p;
        int q;

        private a() {
            this.f3236a = DelayMode.NO_DELAY;
            this.f3237b = -1;
            this.c = "";
            this.d = 1000;
            this.e = 5;
            this.f = 5;
            this.g = new CopyOnWriteArraySet();
            this.h = new ConcurrentHashMap();
            this.i = new CopyOnWriteArraySet();
            this.j = 100;
            this.k = new CopyOnWriteArraySet();
            this.l = new CopyOnWriteArraySet();
            this.m = new CopyOnWriteArraySet();
            this.n = 5000;
            this.o = 5000;
            this.p = 3000;
            this.q = 500;
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }
    }

    public TTHttpCallThrottleControl() {
        this.f3226b = new AtomicBoolean(false);
        this.c = new ConcurrentHashMap();
        this.d = new a(null);
        ReentrantReadWriteLock r0 = new ReentrantReadWriteLock();
        this.e = r0;
        this.f = r0.readLock();
        this.g = r0.writeLock();
        this.h = new CopyOnWriteArraySet();
        this.i = new CopyOnWriteArraySet();
        this.j = new AtomicLong(0);
        this.k = new CopyOnWriteArraySet();
        this.l = new ConcurrentHashMap();
        ReentrantReadWriteLock r1 = new ReentrantReadWriteLock();
        this.m = r1;
        this.n = r1.writeLock();
        ReentrantLock r2 = new ReentrantLock();
        this.o = r2;
        this.p = r2.newCondition();
    }

    private int a(boolean r4, int r5, int r6) {
        if (r4 == true) goto L5;
    L7:
        if (r4 == true) goto L12;
        if (this.i.size() > 5) goto L12;
        return 0;
    L12:
        return new SecureRandom().nextInt((r6 - r5) + 1) + r5;
    L5:
        if (this.h.size() > 5) goto L7;
        return 0;
    }

    private int a(boolean r4, a r5, Request r6) {
        r6.getMetrics().delayState = r5.f3237b;
        r6.getMetrics().syncDelayCount = this.i.size();
        r6.getMetrics().asyncDelayCount = this.h.size();
        if (a(r5.g, r6.getPath()) == true) goto L29;
        if (r4 == true) goto L7;
    L9:
        if (r4 == true) goto L14;
        if (this.i.size() < r5.e) goto L14;
        return 0;
    L14:
        if (r5.f3236a != DelayMode.BLACK_LIST) goto L20;
        Integer r3 = a(r5.h, r6.getPath());
        if (r3 != null) goto L18;
        return 0;
    L18:
        return r3.intValue();
    L20:
        if (r5.f3236a == DelayMode.WHITE_LIST) goto L22;
        return -1;
    L22:
        if (a(r5.i, r6.getPath()) == false) goto L24;
        return 0;
    L24:
        return r5.j;
    L7:
        if (this.h.size() < r5.f) goto L9;
        return 0;
    L29:
        throw new DroppedByThrottleControlException();
    }

    public static TTHttpCallThrottleControl a() {
        if (f3225a != null) goto L15;
        monitor-enter(TTHttpCallThrottleControl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3225a != null) goto L9;
        f3225a = new TTHttpCallThrottleControl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTHttpCallThrottleControl.class);     // Catch: Throwable -> L11
    L15:
        return f3225a;
    }

    private Integer a(Map<String, Integer> r5, String r6) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return null;
    L5:
        Iterator r1 = r4.keySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (r6.startsWith(r2) == false) goto L7;
        return (Integer) ZeusTransformUtils.preCheckCast(r4.get(r2), Integer.class, "com.obric.memorydata.plugin");
    L12:
        return null;
    }

    static /* synthetic */ Lock a(TTHttpCallThrottleControl r0) {
        return r0.n;
    }

    private void a(int r5, Request r6) {
        if (r5 > 0) goto L4;
        return;
    L4:
        this.i.add(r6);
        r6.getMetrics().delayStartTimeStamp = System.currentTimeMillis();
        r6.getMetrics().delayedWithState = true;
        Thread.sleep(r5);     // Catch: Throwable -> L8 InterruptedException -> L10
        r6.getMetrics().stateDelayTime = System.currentTimeMillis() - r6.getMetrics().delayStartTimeStamp;
        return;
    L10:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r6.getMetrics().stateDelayTime = System.currentTimeMillis() - r6.getMetrics().delayStartTimeStamp;
        throw th;
    }

    private void a(final int r9, Executor r10, Runnable r11, final Request r12) {
        final Executor r13 = (Executor) ZeusTransformUtils.wrapperContextForParams(r10, Executor.class, "com.obric.memorydata.plugin");
        final Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r11, Runnable.class, "com.obric.memorydata.plugin");
        if (r9 > 0) goto L5;
        return;
    L5:
        RetrofitMetrics r14 = r12.getMetrics();
        r14.delayStartTimeStamp = System.currentTimeMillis();
        r12.getMetrics().delayedWithState = true;
        SsRunnable r15 = new AnonymousClass3(this, r12, r13, r6, r9);
        this.h.add(r12);
        r13.execute(r15);
    }

    private boolean a(a r3, Request r4) {
        if (a(r3.k, r4.getPath()) == false) goto L10;
        this.j.set(System.currentTimeMillis());
        this.k.add(r4);
        if (Logger.debug() == false) goto L18;
        Logger.d("delayrefine", "p0 add request " + r4.getPath() + " size " + this.k.size());
        return false;
    L18:
        return false;
    L10:
        if (r3.l.size() <= 0) goto L14;
        return a(r3.l, r4.getPath());
    L14:
        if (r3.m.size() > 0) goto L16;
        return true;
    L16:
        return !a(r3.m, r4.getPath());
    }

    private boolean a(Set<String> r4, String r5) {
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return false;
    L5:
        Iterator r6 = r3.iterator();
    L7:
        if (r6.hasNext() == false) goto L12;
        if (r5.startsWith((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L7;
        return true;
    L12:
        return false;
    }

    static /* synthetic */ Map b(TTHttpCallThrottleControl r0) {
        return r0.l;
    }

    private boolean b() {
        if ((System.currentTimeMillis() - this.j.get()) <= this.d.n) goto L6;
        return true;
    L6:
        if (this.k.size() <= 0) goto L10;
        return false;
    L10:
        return true;
    }

    static /* synthetic */ Set c(TTHttpCallThrottleControl r0) {
        return r0.k;
    }

    private void c() {
        if (Logger.debug() == false) goto L5;
        Logger.d("delayrefine", "releaseAllP1Request, " + this.i.size() + " " + this.h.size());
    L5:
        this.o.lock();
        this.p.signalAll();     // Catch: Throwable -> L23
        this.o.unlock();
        this.f.lock();
        int r1 = this.d.q;     // Catch: Throwable -> L20
        int r2 = this.d.p;     // Catch: Throwable -> L20
        this.f.unlock();
        this.n.lock();
        Iterator<Map.Entry<Runnable, Executor>> r3 = this.l.entrySet().iterator();     // Catch: Throwable -> L17
    L12:
        if (r3.hasNext() == false) goto L15;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        final Runnable r12 = (Runnable) ZeusTransformUtils.preCheckCast(r4.getKey(), Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        final Executor r14 = (Executor) ZeusTransformUtils.preCheckCast(r4.getValue(), Executor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        final int r13 = a(true, r1, r2);     // Catch: Throwable -> L17
        final long r8 = r13;
        final long r10 = 0;
        com.bytedance.frameworks.baselib.network.asynctask.b.a(NetworkAsyncTaskType.NETWORK).a(new AnonymousClass5(this, r8, r10, r12, r13, r14));     // Catch: Throwable -> L17
        goto L12
    L15:
        this.n.unlock();
        this.h.clear();
        this.i.clear();
        return;
    L17:
        th = move-exception;
        this.n.unlock();
        throw th;
    L20:
        th = move-exception;
        this.f.unlock();
        throw th;
    L23:
        th = move-exception;
        this.o.unlock();
        throw th;
    }

    static /* synthetic */ Set d(TTHttpCallThrottleControl r0) {
        return r0.h;
    }

    static /* synthetic */ Set e(TTHttpCallThrottleControl r0) {
        return r0.i;
    }

    static /* synthetic */ void f(TTHttpCallThrottleControl r0) {
        r0.c();
    }

    public void a(String r8) {
        c();
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.c.get(r8), a.class, "com.obric.memorydata.plugin");
        this.g.lock();
    L17:
        th = move-exception;
        this.g.unlock();
        throw th;
    L4:
        if (Logger.debug() == false) goto L7;
        Logger.d("delayrefine", "setAppState " + r8);     // Catch: Throwable -> L17
    L7:
        if (r0 != this.d) goto L10;
        this.g.unlock();
        return;
    L10:
        if (r0 != null) goto L12;
        r0 = new a(null);     // Catch: Throwable -> L17
    L12:
        this.d = r0;     // Catch: Throwable -> L17
        if (this.d.f3236a == DelayMode.NO_DELAY) goto L15;
        com.bytedance.frameworks.baselib.network.asynctask.b r9 = com.bytedance.frameworks.baselib.network.asynctask.b.a(NetworkAsyncTaskType.NETWORK);     // Catch: Throwable -> L17
        final long r2 = this.d.d;     // Catch: Throwable -> L17
        final long r4 = 0;
        r9.a(new AnonymousClass1(this, r2, r4));     // Catch: Throwable -> L17
    L15:
        this.g.unlock();
    }

    public void a(JSONObject r14) {
        JSONArray r0 = r14.optJSONArray("tt_req_delay_config");
        boolean r3 = true;
        if (r14.optInt("state_delay_enabled") <= 0) goto L5;
        boolean r1 = true;
    L7:
        if (r14.optInt("state_new_strategy_enabled", 1) <= 0) goto L9;
        boolean r15 = true;
    L11:
        if (TTNetInit.getStateDelayNewStrategyEnabled() == false) goto L14;
        if (r15 == false) goto L14;
    L15:
        if (r1 == false) goto L90;
        if (r0 == null) goto L90;
        if (r3 == true) goto L90;
        ConcurrentHashMap r16 = new ConcurrentHashMap();
        int r4 = 0;
    L21:
        if (r4 >= r0.length()) goto L87;
        a r5 = new a(null);
        JSONObject r6 = r0.optJSONObject(r4);
        if (r6 == null) goto L86;
        r5.c = r6.optString("state_name", "");
        if (r6.isNull("bl_with_delay_ms") == true) goto L34;
        r5.f3236a = DelayMode.BLACK_LIST;
        JSONObject r7 = r6.optJSONObject("bl_with_delay_ms");
        if (r7 == null) goto L66;
        Iterator<String> r8 = r7.keys();
    L31:
        if (r8.hasNext() == false) goto L66;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        r5.h.put(r10, Integer.valueOf(r7.optInt(r10)));
    L66:
        if (r5.h.size() > 0) goto L72;
        if (r5.i.size() > 0) goto L72;
        if (r5.k.size() <= 0) goto L86;
    L72:
        if (TextUtils.isEmpty(r5.c) == true) goto L86;
        r5.d = r6.optInt("delay_disable_time_ms", 1000);
        if (r5.d > 0) goto L78;
        r5.d = 1000;
    L78:
        if (r6.isNull("dl") == true) goto L85;
        JSONArray r9 = r6.optJSONArray("dl");
        if (r9 == null) goto L85;
        int r11 = 0;
    L83:
        if (r11 >= r9.length()) goto L85;
        r5.g.add((String) ZeusTransformUtils.preCheckCast(r9.opt(r11), String.class, "com.obric.memorydata.plugin"));
        r11 = r11 + 1;
    L85:
        r5.f3237b = r6.optInt("state", -1);
        r5.e = r6.optInt("sync_req_delay_max_count", 10);
        r5.f = r6.optInt("async_req_delay_max_count", 10);
        r16.put(r5.c, r5);
        goto L86
    L34:
        if (r6.isNull("wl") == true) goto L45;
        r5.f3236a = DelayMode.WHITE_LIST;
        JSONArray r12 = r6.optJSONArray("wl");
        if (r12 == null) goto L41;
        int r13 = 0;
    L39:
        if (r13 >= r12.length()) goto L41;
        r5.i.add((String) ZeusTransformUtils.preCheckCast(r12.opt(r13), String.class, "com.obric.memorydata.plugin"));
        r13 = r13 + 1;
    L41:
        r5.j = r6.optInt("delay_time_ms", 1000);
        if (r5.j > 0) goto L66;
        r5.j = 1000;
        goto L66
    L45:
        if (r6.isNull("p0") == true) goto L66;
        r5.f3236a = DelayMode.RUNTIME;
        JSONArray r17 = r6.optJSONArray("p0");
        if (r17 == null) goto L52;
        int r18 = 0;
    L50:
        if (r18 >= r17.length()) goto L52;
        r5.k.add((String) ZeusTransformUtils.preCheckCast(r17.opt(r18), String.class, "com.obric.memorydata.plugin"));
        r18 = r18 + 1;
    L52:
        JSONArray r19 = r6.optJSONArray("bl_for_runtime");
        if (r19 == null) goto L58;
        int r20 = 0;
    L56:
        if (r20 >= r19.length()) goto L58;
        r5.l.add((String) ZeusTransformUtils.preCheckCast(r19.opt(r20), String.class, "com.obric.memorydata.plugin"));
        r20 = r20 + 1;
    L58:
        JSONArray r21 = r6.optJSONArray("wl_for_runtime");
        if (r21 == null) goto L64;
        int r22 = 0;
    L62:
        if (r22 >= r21.length()) goto L64;
        r5.m.add((String) ZeusTransformUtils.preCheckCast(r21.opt(r22), String.class, "com.obric.memorydata.plugin"));
        r22 = r22 + 1;
    L64:
        r5.n = r6.optInt("p0_check_max_ms", 5000);
        r5.o = r6.optInt("p1_wait_max_ms", 5000);
        r5.p = r6.optInt("random_send_ubound_ms", 3000);
        r5.q = r6.optInt("random_send_lbound_ms", 500);
    L86:
        r4 = r4 + 1;
        goto L21
    L87:
        this.c.clear();
        this.c.putAll(r16);
    L88:
        this.f3226b.set(r1);
        return;
    L90:
        this.c.clear();
    L14:
        r3 = false;
        goto L15
    L9:
        r15 = false;
        goto L11
    L5:
        r1 = false;
        goto L7
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(final Request r12, Executor r13, Runnable r14) {
        final Executor r10 = (Executor) ZeusTransformUtils.wrapperContextForParams(r13, Executor.class, "com.obric.memorydata.plugin");
        final Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r14, Runnable.class, "com.obric.memorydata.plugin");
        if (this.f3226b.get() == true) goto L5;
        return false;
    L5:
        if (r12 != null) goto L7;
    L48:
        return false;
    L7:
        if (r12.getPath() == null) goto L48;
        if (r12.getMetrics() == null) goto L48;
        this.f.lock();
        int r15 = this.d.o;
        int r0 = a(true, this.d, r12);     // Catch: Throwable -> L42 Exception -> L44
        if (Logger.debug() == false) goto L16;
        Logger.d("delayrefine", "get sleep time " + r0 + " path is " + r12.getPath());     // Catch: Throwable -> L42 Exception -> L44
    L16:
        if (r0 <= 0) goto L21;
        a(r0, r10, r8, r12);     // Catch: Throwable -> L42 Exception -> L44
        Lock r11 = this.f;
    L19:
        r11.unlock();
        return true;
    L21:
        if (r0 != 0) goto L25;
    L22:
        this.f.unlock();
        return false;
    L25:
        if (this.d.f3236a != DelayMode.RUNTIME) goto L22;
        if (a(this.d, r12) == false) goto L22;
        if (b() == true) goto L22;
        this.f.unlock();
        this.n.lock();
        this.h.add(r12);     // Catch: Throwable -> L39
        if (Logger.debug() == false) goto L37;
        Logger.d("delayrefine", "enqueue p1 add request " + r12.getPath() + " after added me, async size is " + this.h.size());     // Catch: Throwable -> L39
    L37:
        r12.getMetrics().delayStartTimeStamp = System.currentTimeMillis();     // Catch: Throwable -> L39
        this.l.put(r8, r10);     // Catch: Throwable -> L39
        r12.getMetrics().delayedWithState = true;     // Catch: Throwable -> L39
        final long r4 = r15;
        final long r6 = 0;
        com.bytedance.frameworks.baselib.network.asynctask.b.a(NetworkAsyncTaskType.NETWORK).a(new AnonymousClass2(this, r4, r6, r8, r12, r10));     // Catch: Throwable -> L39
        r11 = this.n;
    L39:
        th = move-exception;
        this.n.unlock();
        throw th;
    L44:
        e = move-exception;
        throw e;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        this.f.unlock();
        throw th;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request r9) {
        if (this.f3226b.get() == true) goto L5;
        return;
    L5:
        if (r9 != null) goto L7;
        return;
    L7:
        if (r9.getPath() != null) goto L9;
        return;
    L9:
        if (r9.getMetrics() == null) goto L73;
        this.f.lock();
        int r0 = a(false, this.d, r9);     // Catch: Throwable -> L58 Exception -> L60
        if (Logger.debug() == false) goto L16;
        Logger.d("delayrefine", "get sleep time " + r0 + " path is " + r9.getPath());     // Catch: Throwable -> L58 Exception -> L60
    L16:
        this.f.unlock();
        if (r0 <= 0) goto L20;
        a(r0, r9);
        return;
    L20:
        if (r0 != 0) goto L22;
        return;
    L22:
        this.f.lock();
        int r1 = this.d.q;
        int r2 = this.d.p;
        int r4 = this.d.o;
    L52:
        th = move-exception;
        this.f.unlock();
        throw th;
    L54:
        e = move-exception;
        throw e;     // Catch: Throwable -> L52
    L24:
        if (this.d.f3236a == DelayMode.RUNTIME) goto L28;
    L25:
        this.f.unlock();
        return;
    L28:
        if (a(this.d, r9) == false) goto L25;
        if (b() == true) goto L25;
        this.f.unlock();
        this.o.lock();
        r9.getMetrics().delayStartTimeStamp = SystemClock.uptimeMillis();     // Catch: Throwable -> L45 Exception -> L47
        this.i.add(r9);     // Catch: Throwable -> L45 Exception -> L47
        if (Logger.debug() == false) goto L37;
        Logger.d("delayrefine", "execute p1 add request " + r9.getPath() + " after added me, sync size is " + this.i.size());     // Catch: Throwable -> L45 Exception -> L47
    L37:
        this.p.await(r4, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L45 Exception -> L47
        int r3 = a(false, r1, r2);     // Catch: Throwable -> L45 Exception -> L47
        long r5 = r3;
        r9.getMetrics().randomSendTime = r5;     // Catch: Throwable -> L45 Exception -> L47
        if (r3 <= 0) goto L41;
        Thread.sleep(r5);     // Catch: Throwable -> L45 Exception -> L47
    L41:
        if (Logger.debug() == false) goto L43;
        Logger.d("delayrefine", "execute p1 release now " + r9.getPath() + " random is " + r3);     // Catch: Throwable -> L45 Exception -> L47
    L43:
        r9.getMetrics().stateDelayTime = SystemClock.uptimeMillis() - r9.getMetrics().delayStartTimeStamp;     // Catch: Throwable -> L45 Exception -> L47
        r9.getMetrics().delayedWithState = true;     // Catch: Throwable -> L45 Exception -> L47
    L48:
        this.o.unlock();
        return;
    L45:
        th = move-exception;
        this.o.unlock();
        throw th;
    L47:
        Logger.e("sleeping interrupted");     // Catch: Throwable -> L45
        goto L48
    L60:
        e = move-exception;
        throw e;     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        this.f.unlock();
        throw th;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void notifyRequestCompleted(final Request r3) {
        if (this.f3226b.get() == false) goto L5;
    L7:
        if (r3 != null) goto L9;
        return;
    L9:
        com.bytedance.frameworks.baselib.network.asynctask.b.a(NetworkAsyncTaskType.NETWORK).a(new AnonymousClass4(this, r3));
        return;
    L5:
        if (this.k.size() > 0) goto L7;
    }
}
