package d5;

import android.os.SystemClock;
import android.util.Log;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.b0;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<n4.c> f8475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lock f8477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Condition f8478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<n4.c> f8479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ReadWriteLock f8481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lock f8482i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map<Runnable, Executor> f8483j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f8484k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f8485l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f8486m;

    /* JADX INFO: renamed from: d5.a$a, reason: collision with other inner class name */
    class C0157a extends j2.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Runnable f8487c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f8488g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Executor f8489h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ RetrofitMetrics f8490i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ a f8491j;

        C0157a(a r10, long r11, long r12, Runnable r13, long r14, Executor r15, RetrofitMetrics r16) {
            this.f8491j = r10;
            this.f8487c = r13;
            this.f8488g = r14;
            this.f8489h = r15;
            this.f8490i = r16;
            super(r11, r12);
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f8491j).lock();
        L11:
            th = move-exception;
            a.a(this.f8491j).unlock();
            throw th;
        L4:
            if (a.b(this.f8491j).containsKey(this.f8487c) == true) goto L6;
        L9:
            a.a(this.f8491j).unlock();
            return;
        L6:
            if (Logger.debug() == false) goto L8;
            Logger.e("RequestDelay", "Release request error maxDelay:" + this.f8488g);     // Catch: Throwable -> L11
        L8:
            this.f8489h.execute(this.f8487c);     // Catch: Throwable -> L11
            a.b(this.f8491j).remove(this.f8487c);     // Catch: Throwable -> L11
            this.f8490i.E = SystemClock.uptimeMillis() - this.f8490i.H;     // Catch: Throwable -> L11
            goto L9
        }
    }

    class b extends j2.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Runnable f8492c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f8493g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Executor f8494h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f8495i;

        b(a r10, long r11, long r12, Runnable r13, int r14, Executor r15) {
            this.f8495i = r10;
            this.f8492c = r13;
            this.f8493g = r14;
            this.f8494h = r15;
            super(r11, r12);
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f8495i).lock();
        L11:
            th = move-exception;
            a.a(this.f8495i).unlock();
            throw th;
        L4:
            if (a.b(this.f8495i).containsKey(this.f8492c) == false) goto L9;
            Runnable r10 = this.f8492c;     // Catch: Throwable -> L11
            if ((r10 instanceof b0) == false) goto L8;
            RetrofitMetrics r11 = ((b0) r10).u();     // Catch: Throwable -> L11
            r11.E = SystemClock.uptimeMillis() - r11.H;     // Catch: Throwable -> L11
            r11.I = this.f8493g;     // Catch: Throwable -> L11
        L8:
            this.f8494h.execute(this.f8492c);     // Catch: Throwable -> L11
            a.b(this.f8495i).remove(this.f8492c);     // Catch: Throwable -> L11
        L9:
            a.a(this.f8495i).unlock();
        }
    }

    public a() {
        this.f8474a = null;
        this.f8475b = new CopyOnWriteArraySet();
        this.f8476c = -1;
        ReentrantLock r10 = new ReentrantLock();
        this.f8477d = r10;
        this.f8478e = r10.newCondition();
        this.f8479f = new CopyOnWriteArraySet();
        this.f8480g = -1;
        ReentrantReadWriteLock r11 = new ReentrantReadWriteLock();
        this.f8481h = r11;
        this.f8482i = r11.writeLock();
        this.f8483j = new ConcurrentHashMap();
        this.f8484k = 500;
        this.f8485l = 3000;
        this.f8486m = -1;
    }

    static /* synthetic */ Lock a(a r10) {
        return r10.f8482i;
    }

    static /* synthetic */ Map b(a r10) {
        return r10.f8483j;
    }

    private int c() {
        int r10 = this.f8484k;
        if (r10 > 0) goto L6;
        r10 = 500;
    L6:
        int r11 = this.f8485l;
        if (r11 > 0) goto L10;
        r11 = 3000;
    L10:
        if (r10 < r11) goto L14;
        return 0;
    L14:
        return new Random().nextInt((r11 - r10) + 1) + r10;
    }

    private boolean j() {
        if (this.f8486m > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void d(JSONObject r10, String r11) {
        this.f8476c = r10.optInt("sync_req_delay_max_count", -1);
        this.f8480g = r10.optInt("async_req_delay_max_count", -1);
        this.f8484k = r10.optInt("random_send_lbound_ms", 500);
        this.f8485l = r10.optInt("random_send_ubound_ms", 3000);
        this.f8486m = r10.optInt("sparse_send_interval_ms", -1);
        i(r11);
    }

    public void e(n4.c r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f8475b.remove(r10);
        this.f8479f.remove(r10);
    }

    public void f() {
        if (Logger.debug() == false) goto L5;
        Logger.d("RequestDelay", "releaseAllDelayedRequests");
    L5:
        this.f8477d.lock();
        this.f8478e.signalAll();     // Catch: Throwable -> L25
        this.f8477d.unlock();
        this.f8482i.lock();
        int r10 = 0;
        Iterator<Map.Entry<Runnable, Executor>> r11 = this.f8483j.entrySet().iterator();     // Catch: Throwable -> L22
    L9:
        if (r11.hasNext() == false) goto L20;
        Map.Entry<Runnable, Executor> r12 = r11.next();     // Catch: Throwable -> L22
        Runnable r13 = r12.getKey();     // Catch: Throwable -> L22
        Executor r14 = r12.getValue();     // Catch: Throwable -> L22
        if (j() == false) goto L14;
        r10 = c();     // Catch: Throwable -> L22
    L16:
        if (Logger.debug() == false) goto L18;
        Logger.d("RequestDelay", "Delay request time:" + r10);     // Catch: Throwable -> L22
    L18:
        j2.b.d(NetworkAsyncTaskType.NETWORK).e(new b(this, r10, 0, r13, r10, r14));     // Catch: Throwable -> L22
        goto L9
    L14:
        r10 = r10 + this.f8486m;     // Catch: Throwable -> L22
        goto L16
    L20:
        this.f8482i.unlock();
        this.f8479f.clear();
        this.f8475b.clear();
        return;
    L22:
        th = move-exception;
        this.f8482i.unlock();
        throw th;
    L25:
        th = move-exception;
        this.f8477d.unlock();
        throw th;
    }

    public boolean g(n4.c r15, boolean r16, long r17, Runnable r19, Executor r20, RetrofitMetrics r21) {
        if (r17 > 0) goto L5;
        return false;
    L5:
        if (r16 == false) goto L7;
    L9:
        this.f8483j.put(r19, r20);
        this.f8479f.add(r15);
        r21.H = SystemClock.uptimeMillis();
        r21.C = this.f8474a;
        r21.G = this.f8479f.size();
        r21.D = true;
        long r10 = r17 + ((long) this.f8485l);
        if (Logger.debug() == false) goto L12;
        Logger.d("RequestDelay", "Async Release request maxDelay:" + r10);
    L12:
        j2.b.d(NetworkAsyncTaskType.NETWORK).e(new C0157a(this, r10, 0, r19, r10, r20, r21));
        return true;
    L7:
        if (this.f8479f.size() < this.f8480g) goto L9;
        return false;
    }

    public void h(n4.c r10, boolean r11, boolean r12, long r13, RetrofitMetrics r15) {
        if (r13 > 0) goto L5;
        return;
    L5:
        if (r11 == false) goto L7;
    L9:
        long r14 = SystemClock.uptimeMillis();
        this.f8475b.add(r10);
        r15.F = this.f8475b.size();
        r15.C = this.f8474a;
        r15.D = true;
        if (Logger.debug() == false) goto L12;
        Log.d("RequestDelay", "Delay request before await");
    L12:
        this.f8477d.lock();
        this.f8478e.await(r13, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L27 Exception -> L29
        this.f8477d.unlock();
        int r16 = c();
        if (Logger.debug() == false) goto L17;
        Logger.d("RequestDelay", "Delay request :" + r10.A() + " time:" + r16 + " start random now");
    L17:
        if (r16 > 0) goto L65;
    L22:
        long r17 = SystemClock.uptimeMillis();
        if (Logger.debug() == false) goto L26;
        StringBuilder r18 = new StringBuilder();
    L25:
        r18.append("Delay request end random ");
        r18.append(r16);
        r18.append(" delay all ");
        r18.append(r17 - r14);
        Log.d("RequestDelay", r18.toString());
    L26:
        r10.z().I = r16;
        r15.E = SystemClock.uptimeMillis() - r14;
        return;
    L65:
        Thread.sleep(r16);     // Catch: InterruptedException -> L21
    L21:
        Logger.e("sleeping interrupted");
        goto L22
    L29:
        e = move-exception;
        if (Logger.debug() == false) goto L33;
        Log.d("RequestDelay", "Delay request await interrupted " + e.getMessage());     // Catch: Throwable -> L27
    L33:
        this.f8477d.unlock();
        r16 = c();
        if (Logger.debug() == false) goto L36;
        Logger.d("RequestDelay", "Delay request :" + r10.A() + " time:" + r16 + " start random now");
    L36:
        if (r16 > 0) goto L60;
    L41:
        r17 = SystemClock.uptimeMillis();
        if (Logger.debug() == false) goto L26;
        r18 = new StringBuilder();
        goto L25
    L60:
        Thread.sleep(r16);     // Catch: InterruptedException -> L40
    L40:
        Logger.e("sleeping interrupted");
    L27:
        th = move-exception;
        this.f8477d.unlock();
        int r19 = c();
        if (Logger.debug() == false) goto L48;
        Logger.d("RequestDelay", "Delay request :" + r10.A() + " time:" + r19 + " start random now");
    L48:
        if (r19 > 0) goto L62;
    L53:
        long r110 = SystemClock.uptimeMillis();
        if (Logger.debug() == false) goto L56;
        Log.d("RequestDelay", "Delay request end random " + r19 + " delay all " + (r110 - r14));
    L56:
        r10.z().I = r19;
        r15.E = SystemClock.uptimeMillis() - r14;
        throw th;
    L62:
        Thread.sleep(r19);     // Catch: InterruptedException -> L52
    L52:
        Logger.e("sleeping interrupted");
        goto L53
    L7:
        if (this.f8475b.size() < this.f8476c) goto L9;
    }

    public void i(String r10) {
        this.f8474a = r10;
    }
}
