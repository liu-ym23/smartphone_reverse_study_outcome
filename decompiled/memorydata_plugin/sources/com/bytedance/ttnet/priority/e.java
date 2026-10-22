package com.bytedance.ttnet.priority;

import android.os.SystemClock;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.retrofit2.client.Request;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Request> f3300b;
    private int c;
    private final Lock d;
    private final Condition e;
    private final Set<Request> f;
    private int g;
    private final ReadWriteLock h;
    private final Lock i;
    private final Map<Runnable, Executor> j;
    private int k;
    private int l;
    private int m;

    public e() {
        this.f3299a = null;
        this.f3300b = new CopyOnWriteArraySet();
        this.c = -1;
        ReentrantLock r1 = new ReentrantLock();
        this.d = r1;
        this.e = r1.newCondition();
        this.f = new CopyOnWriteArraySet();
        this.g = -1;
        ReentrantReadWriteLock r0 = new ReentrantReadWriteLock();
        this.h = r0;
        this.i = r0.writeLock();
        this.j = new ConcurrentHashMap();
        this.k = 500;
        this.l = 3000;
        this.m = 100;
    }

    static /* synthetic */ Lock a(e r0) {
        return r0.i;
    }

    static /* synthetic */ Map b(e r0) {
        return r0.j;
    }

    private boolean b() {
        if (this.m > 0) goto L5;
        return true;
    L5:
        return false;
    }

    private int c() {
        int r0 = this.k;
        if (r0 > 0) goto L6;
        r0 = 500;
    L6:
        int r2 = this.l;
        if (r2 > 0) goto L10;
        r2 = 3000;
    L10:
        if (r0 < r2) goto L14;
        return 0;
    L14:
        return new Random().nextInt((r2 - r0) + 1) + r0;
    }

    public void a() {
        this.d.lock();
        this.e.signalAll();     // Catch: Throwable -> L19
        this.d.unlock();
        this.i.lock();
        int r1 = 0;
        Iterator<Map.Entry<Runnable, Executor>> r2 = this.j.entrySet().iterator();     // Catch: Throwable -> L16
    L6:
        if (r2.hasNext() == false) goto L14;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        final Runnable r11 = (Runnable) ZeusTransformUtils.preCheckCast(r3.getKey(), Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        final Executor r13 = (Executor) ZeusTransformUtils.preCheckCast(r3.getValue(), Executor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (b() == false) goto L11;
        r1 = c();     // Catch: Throwable -> L16
    L12:
        final long r7 = r1;
        final long r9 = 0;
        final int r12 = r1;
        com.bytedance.frameworks.baselib.network.asynctask.b.a(NetworkAsyncTaskType.NETWORK).a(new AnonymousClass2(this, r7, r9, r11, r12, r13));     // Catch: Throwable -> L16
        goto L6
    L11:
        r1 = r1 + this.m;     // Catch: Throwable -> L16
        goto L12
    L14:
        this.i.unlock();
        this.f.clear();
        this.f3300b.clear();
        return;
    L16:
        th = move-exception;
        this.i.unlock();
        throw th;
    L19:
        th = move-exception;
        this.d.unlock();
        throw th;
    }

    public void a(Request r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.f3300b.remove(r2);
        this.f.remove(r2);
    }

    public void a(Request r10, boolean r11, boolean r12, long r13) {
        if (r13 > 0) goto L5;
        return;
    L5:
        if (r11 == false) goto L7;
    L9:
        long r5 = SystemClock.uptimeMillis();
        this.f3300b.add(r10);
        r10.getMetrics().syncDelayCount = this.f3300b.size();
        r10.getMetrics().delayStateName = this.f3299a;
        r10.getMetrics().delayedWithState = true;
        if (Logger.debug() == false) goto L12;
        Logger.d("RequestDelay", "Delay request before await");
    L12:
        this.d.lock();
        this.e.await(r13, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L27 Exception -> L29
        this.d.unlock();
        int r9 = c();
        if (Logger.debug() == false) goto L17;
        Logger.d("RequestDelay", "Delay request :" + r10.getPath() + " time:" + r9 + " start random now");
    L17:
        if (r9 > 0) goto L64;
    L22:
        long r14 = SystemClock.uptimeMillis();
        if (Logger.debug() == false) goto L26;
        StringBuilder r15 = new StringBuilder();
    L25:
        Logger.d("RequestDelay", r15.append("Delay request end random ").append(r9).append(" delay all ").append(r14 - r5).toString());
    L26:
        r10.getMetrics().randomSendTime = r9;
        r10.getMetrics().stateDelayTime = SystemClock.uptimeMillis() - r5;
        return;
    L64:
        Thread.sleep(r9);     // Catch: InterruptedException -> L21
    L21:
        Logger.e("sleeping interrupted");
        goto L22
    L27:
        th = move-exception;
        this.d.unlock();
        int r16 = c();
        if (Logger.debug() == false) goto L48;
        Logger.d("RequestDelay", "Delay request :" + r10.getPath() + " time:" + r16 + " start random now");
    L48:
        if (r16 > 0) goto L60;
    L53:
        long r17 = SystemClock.uptimeMillis();
        if (Logger.debug() == false) goto L56;
        Logger.d("RequestDelay", "Delay request end random " + r16 + " delay all " + (r17 - r5));
    L56:
        r10.getMetrics().randomSendTime = r16;
        r10.getMetrics().stateDelayTime = SystemClock.uptimeMillis() - r5;
        throw th;
    L60:
        Thread.sleep(r16);     // Catch: InterruptedException -> L52
    L52:
        Logger.e("sleeping interrupted");
    L29:
        e = move-exception;
        if (Logger.debug() == false) goto L33;
        Logger.d("RequestDelay", "Delay request await interrupted " + e.getMessage());     // Catch: Throwable -> L27
    L33:
        this.d.unlock();
        r9 = c();
        if (Logger.debug() == false) goto L36;
        Logger.d("RequestDelay", "Delay request :" + r10.getPath() + " time:" + r9 + " start random now");
    L36:
        if (r9 > 0) goto L58;
    L41:
        r14 = SystemClock.uptimeMillis();
        if (Logger.debug() == false) goto L26;
        r15 = new StringBuilder();
        goto L25
    L58:
        Thread.sleep(r9);     // Catch: InterruptedException -> L40
    L40:
        Logger.e("sleeping interrupted");
        goto L41
    L7:
        if (this.f3300b.size() < this.c) goto L9;
    }

    public void a(String r1) {
        this.f3299a = r1;
    }

    public void a(JSONObject r3, String r4) {
        this.c = r3.optInt("sync_req_delay_max_count", -1);
        this.g = r3.optInt("async_req_delay_max_count", -1);
        this.k = r3.optInt("random_send_lbound_ms", 500);
        this.l = r3.optInt("random_send_ubound_ms", 3000);
        this.m = r3.optInt("sparse_send_interval_ms", 100);
        a(r4);
    }

    public boolean a(final Request r13, boolean r14, final long r15, Runnable r17, Executor r18) {
        final Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r17, Runnable.class, "com.obric.memorydata.plugin");
        final Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r18, Executor.class, "com.obric.memorydata.plugin");
        if (r15 > 0) goto L5;
        return false;
    L5:
        if (r14 == false) goto L7;
    L9:
        this.j.put(r6, r7);
        this.f.add(r13);
        r13.getMetrics().delayStartTimeStamp = SystemClock.uptimeMillis();
        r13.getMetrics().delayStateName = this.f3299a;
        r13.getMetrics().asyncDelayCount = this.f.size();
        r13.getMetrics().delayedWithState = true;
        final long r4 = 0;
        com.bytedance.frameworks.baselib.network.asynctask.b.a(NetworkAsyncTaskType.NETWORK).a(new AnonymousClass1(this, r15, r4, r6, r7, r13));
        return true;
    L7:
        if (this.f.size() < this.g) goto L9;
        return false;
    }
}
