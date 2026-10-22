package com.bytedance.android.anya.internal;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.anya.q0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Maybe;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends j {
    public final ReentrantLock b;
    public final ExecutorService c;
    public final Handler d;
    public final LinkedList<a> e;
    public final CompositeDisposable f;
    public volatile boolean g;
    public volatile Boolean h;
    public volatile boolean i;
    public volatile boolean j;
    public long k;
    public final Lazy l;
    public final Scheduler m;
    public final String n;
    public final int o;
    public final int p;
    public final mb.b q;

    public static final class a {
        public final Function0<Unit> a;
        public final boolean b;
        public final int c;

        public a(Function0<Unit> r1, boolean r10, int r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.anya.internal.b$b, reason: collision with other inner class name */
    public static final class C0101b {
    }

    public final class c {
        public final LinkedList<Function0<Unit>> a;
        public Function0<Unit> b;
        public final /* synthetic */ b c;

        public final void a() {
            final Function0<Unit> r0 = this.b;
            if (r0 == null) goto L28;
            LinkedList<Function0<Unit>> r10 = this.a;
            final ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
            Iterator<T> r12 = r10.iterator();
        L6:
            if (r12.hasNext() == false) goto L8;
            r11.add(new a((Function0) r12.next(), false, 0));
            goto L6
        L8:
            final b r13 = this.c;
            LinkedList<a> r14 = r13.e;
            monitor-enter(r14);
        L25:
            th = move-exception;
            throw th;
        L11:
            if (r13.i == false) goto L13;
            r13.e.addAll(r11);     // Catch: Throwable -> L25
            r13.I("commit " + r11.size() + " actions within init barrier");     // Catch: Throwable -> L25
        L22:
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L25
            monitor-exit(r14);
            return;
        L13:
            Function0<Unit> r15 = new AnyaExecutor$commitBatchAction$$inlined$synchronized$lambda$1(r13, r11, r0);     // Catch: Throwable -> L25
            if (r13.g == false) goto L16;
        L21:
            r13.e.add(new a(r15, false, 1));     // Catch: Throwable -> L25
            r13.e.addAll(r11);     // Catch: Throwable -> L25
            r13.e.add(new a(AnyaExecutor$commitBatchAction$1$1.INSTANCE, false, 2));     // Catch: Throwable -> L25
            r13.F("commit " + r11.size() + " actions to queue, " + r13.E(), null);     // Catch: Throwable -> L25
            goto L22
        L16:
            if ((!r13.e.isEmpty()) == true) goto L21;
            if (Intrinsics.areEqual(r13.h, Boolean.TRUE) == true) goto L21;
            r13.e.addAll(r11);     // Catch: Throwable -> L25
            r13.e.add(new a(AnyaExecutor$commitBatchAction$1$2.INSTANCE, false, 2));     // Catch: Throwable -> L25
            r13.F("commit consume " + r11.size() + " actions immediately, " + r13.E(), null);     // Catch: Throwable -> L25
            r13.q(r15, false);     // Catch: Throwable -> L25
            goto L22
        L28:
            this.c.F("diff callback is null", null);
        }

        public c(b r1) {
            this.c = r1;
            this.a = new LinkedList();
        }
    }

    public final class d implements Runnable {
        public Disposable a;
        public final Function0<Unit> b;
        public final /* synthetic */ b c;

        public final void a() {
            System.currentTimeMillis();
            b r0 = this.c;
            long r1 = r0.k;
            String r10 = r0.n;
            r0.k = 0;
            long r11 = System.currentTimeMillis();
        L4:
            if (this.c.b.tryLock() == false) goto L4;
            this.b.invoke();     // Catch: Throwable -> L23 Exception -> L25
            mb.b r12 = this.c.q;     // Catch: Throwable -> L23 Exception -> L25
            if (r12 == null) goto L10;
            r12.a(r11);     // Catch: Throwable -> L23 Exception -> L25
        L10:
            LinkedList<a> r13 = this.c.e;
            monitor-enter(r13);
        L20:
            th = move-exception;
            throw th;
        L13:
            if (q0.b == false) goto L17;
            Disposable r14 = this.a;     // Catch: Throwable -> L20
            if (r14 == null) goto L17;
            this.c.f.remove(r14);     // Catch: Throwable -> L20
        L17:
            b r15 = this.c;     // Catch: Throwable -> L20
            r15.h = Boolean.FALSE;     // Catch: Throwable -> L20
            this.c.g = false;     // Catch: Throwable -> L20
            this.c.b.unlock();     // Catch: Throwable -> L20
            b.n(this.c);     // Catch: Throwable -> L20
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L20
            monitor-exit(r13);
        L19:
            String r17 = this.c.n;
            return;
        L23:
            th = move-exception;
            monitor-enter(this.c.e);
        L52:
            th = move-exception;
            throw th;
        L44:
            if (q0.b == false) goto L48;
            Disposable r18 = this.a;     // Catch: Throwable -> L52
            if (r18 == null) goto L48;
            this.c.f.remove(r18);     // Catch: Throwable -> L52
        L48:
            b r19 = this.c;     // Catch: Throwable -> L52
            r19.h = Boolean.FALSE;     // Catch: Throwable -> L52
            this.c.g = false;     // Catch: Throwable -> L52
            this.c.b.unlock();     // Catch: Throwable -> L52
            b.n(this.c);     // Catch: Throwable -> L52
            Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L52
            String r21 = this.c.n;
            throw th;
        L25:
            e = move-exception;
            this.c.F("ui action exception", e);     // Catch: Throwable -> L23
            monitor-enter(this.c.e);
        L38:
            th = move-exception;
            throw th;
        L30:
            if (q0.b == false) goto L34;
            Disposable r22 = this.a;     // Catch: Throwable -> L38
            if (r22 == null) goto L34;
            this.c.f.remove(r22);     // Catch: Throwable -> L38
        L34:
            b r23 = this.c;     // Catch: Throwable -> L38
            r23.h = Boolean.FALSE;     // Catch: Throwable -> L38
            this.c.g = false;     // Catch: Throwable -> L38
            this.c.b.unlock();     // Catch: Throwable -> L38
            b.n(this.c);     // Catch: Throwable -> L38
            Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L38
            goto L19
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(b r1, Function0<Unit> r10) {
            this.c = r1;
            this.b = r10;
        }
    }

    public final class e implements Callable<Unit> {
        public Disposable a;
        public final Function0<Unit> b;
        public final /* synthetic */ b c;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public void call2() {
            long r0 = System.currentTimeMillis();
        L4:
            if (this.c.b.tryLock() == false) goto L4;
            Objects.toString(ThreadMethodProxy.currentThread());     // Catch: Throwable -> L24 Exception -> L26
            String r10 = this.c.n;     // Catch: Throwable -> L24 Exception -> L26
            this.b.invoke();     // Catch: Throwable -> L24 Exception -> L26
            mb.b r11 = this.c.q;     // Catch: Throwable -> L24 Exception -> L26
            if (r11 == null) goto L10;
            r11.b(r0);     // Catch: Throwable -> L24 Exception -> L26
        L10:
            LinkedList<a> r1 = this.c.e;
            monitor-enter(r1);
        L21:
            th = move-exception;
            throw th;
        L13:
            if (q0.b == false) goto L17;
            Disposable r12 = this.a;     // Catch: Throwable -> L21
            if (r12 == null) goto L17;
            this.c.f.remove(r12);     // Catch: Throwable -> L21
        L17:
            b r13 = this.c;     // Catch: Throwable -> L21
            r13.h = Boolean.TRUE;     // Catch: Throwable -> L21
            this.c.g = false;     // Catch: Throwable -> L21
            this.c.b.unlock();     // Catch: Throwable -> L21
            b.n(this.c);     // Catch: Throwable -> L21
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L21
            monitor-exit(r1);
            b r15 = this.c;
            String r16 = r15.n;
        L20:
            r15.k = System.currentTimeMillis();
            return;
        L26:
            e = move-exception;
            this.c.F("worker action exception", e);     // Catch: Throwable -> L24
            monitor-enter(this.c.e);
        L39:
            th = move-exception;
            throw th;
        L31:
            if (q0.b == false) goto L35;
            Disposable r17 = this.a;     // Catch: Throwable -> L39
            if (r17 == null) goto L35;
            this.c.f.remove(r17);     // Catch: Throwable -> L39
        L35:
            b r18 = this.c;     // Catch: Throwable -> L39
            r18.h = Boolean.TRUE;     // Catch: Throwable -> L39
            this.c.g = false;     // Catch: Throwable -> L39
            this.c.b.unlock();     // Catch: Throwable -> L39
            b.n(this.c);     // Catch: Throwable -> L39
            Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L39
            r15 = this.c;
            String r20 = r15.n;
        L24:
            th = move-exception;
            monitor-enter(this.c.e);
        L53:
            th = move-exception;
            throw th;
        L45:
            if (q0.b == false) goto L49;
            Disposable r21 = this.a;     // Catch: Throwable -> L53
            if (r21 == null) goto L49;
            this.c.f.remove(r21);     // Catch: Throwable -> L53
        L49:
            b r22 = this.c;     // Catch: Throwable -> L53
            r22.h = Boolean.TRUE;     // Catch: Throwable -> L53
            this.c.g = false;     // Catch: Throwable -> L53
            this.c.b.unlock();     // Catch: Throwable -> L53
            b.n(this.c);     // Catch: Throwable -> L53
            Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L53
            b r24 = this.c;
            String r25 = r24.n;
            r24.k = System.currentTimeMillis();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Unit call() {
            call2();
            return Unit.INSTANCE;
        }

        public e(b r1, Function0<Unit> r10) {
            this.c = r1;
            this.b = r10;
        }
    }

    public static final class f implements Action {
        public final /* synthetic */ b a;
        public final /* synthetic */ d b;

        public f(b r1, d r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void run() {
            this.a.d.removeCallbacks(this.b);
        }
    }

    static {
    }

    public final String E() {
        StringBuilder r0 = new StringBuilder("Executor" + ((String) this.l.getValue()) + '{');
        if (this.i == false) goto L6;
        r0.append("initBarrier=" + this.i + ',');
    L6:
        if (this.j == false) goto L8;
        r0.append("batchReducing=" + this.j + ',');
    L8:
        r0.append("consuming=" + this.g + ',');
        r0.append("nextJobShouldBeOnUI=" + this.h + ',');
        StringBuilder r1 = new StringBuilder("actionQueue=");
        r1.append(this.e.size());
        r0.append(r1.toString());
        if (this.b.isLocked() == false) goto L11;
        r0.append(",lock=" + this.b);
    L11:
        r0.append("}");
        return r0.toString();
    }

    @Override // com.bytedance.android.anya.internal.j
    public final void k() {
        I("dispose " + E());
    L4:
        if (this.b.tryLock() == false) goto L4;
        this.f.clear();     // Catch: Throwable -> L19
        ExecutorService r0 = this.c;     // Catch: Throwable -> L19
        if (r0 == null) goto L9;
        r0.shutdown();     // Catch: Throwable -> L19
    L9:
        this.d.removeCallbacksAndMessages(null);     // Catch: Throwable -> L19
        LinkedList<a> r1 = this.e;     // Catch: Throwable -> L19
        monitor-enter(r1);     // Catch: Throwable -> L19
        this.e.clear();     // Catch: Throwable -> L16
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L19
        this.g = false;     // Catch: Throwable -> L19
        this.h = null;     // Catch: Throwable -> L19
        this.b.unlock();
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.b.unlock();
        throw th;
    }

    public static final void n(b r10) {
        if (r10.g == false) goto L5;
        return;
    L5:
        if (r10.e.isEmpty() == false) goto L8;
        return;
    L8:
        if (r10.h != null) goto L10;
        a r0 = r10.e.pollFirst();
        r10.q(r0.a, r0.b);
        return;
    L10:
        Iterator<a> r1 = r10.e.iterator();
    L12:
        if (r1.hasNext() == false) goto L16;
        a r11 = r1.next();
        if (Intrinsics.areEqual(Boolean.valueOf(r11.b), r10.h) == false) goto L12;
        r1.remove();
    L17:
        if (r11 == null) goto L27;
        r10.q(r11.a, r11.b);
        return;
    L27:
        return;
    L16:
        r11 = null;
        goto L17
    }

    public final void I(String r10) {
        mb.c r0 = mb.a.a;
        String r11 = this.n + ' ' + r10;
        mb.c r1 = mb.a.a;
        if (r1 == null) goto L6;
        r1.logW("ttlive_anya_executor", r11);
        return;
    }

    public final void R(Function0<Unit> r10) {
        if (this.i == false) goto L12;
        LinkedList<a> r0 = this.e;
        monitor-enter(r0);
        this.e.add(new a(r10, false, 0));     // Catch: Throwable -> L9
        monitor-exit(r0);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        L(r10, false);
    }

    public final void F(String r10, Exception r11) {
        mb.c r0 = mb.a.a;
        String r12 = this.n + ' ' + r10;
        mb.c r1 = mb.a.a;
        if (r1 == null) goto L6;
        r1.a(r12, r11);
        return;
    }

    public final void K(boolean r10, Function0<Unit> r11) {
        I("batch reduce start, " + E());
        LinkedList<a> r0 = this.e;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L43
        Iterator<a> r12 = this.e.iterator();     // Catch: Throwable -> L43
    L6:
        if (r12.hasNext() == false) goto L13;
        a r13 = r12.next();     // Catch: Throwable -> L43
        if (r13.b == false) goto L10;
        F("unexpected ui action in batch", null);     // Catch: Throwable -> L43
    L12:
        if (r13.c != 2) goto L6;
    L10:
        r1.add(r13);     // Catch: Throwable -> L43
    L13:
        r1.size();     // Catch: Throwable -> L43
        Iterator r14 = r1.iterator();     // Catch: Throwable -> L43
    L15:
        if (r14.hasNext() == false) goto L17;
        ((a) r14.next()).a.invoke();     // Catch: Throwable -> L43
        goto L15
    L17:
        this.e.removeAll(r1);     // Catch: Throwable -> L43
        monitor-exit(r0);
        boolean r15 = true;
        if (r10 == true) goto L22;
    L35:
        StringBuilder r16 = new StringBuilder("batch reduce finished, notify diff ");
        if (r11 != null) goto L39;
        r15 = false;
    L39:
        r16.append(r15);
        r16.append(", ");
        r16.append(E());
        F(r16.toString(), null);
        if (r11 == null) goto L60;
        Unit r17 = (Unit) r11.invoke();
        return;
    L60:
        return;
    L22:
        if ((!this.e.isEmpty()) == false) goto L35;
    L23:
        LinkedList<a> r18 = this.e;
        ArrayList r19 = new ArrayList();
        Iterator<T> r20 = r18.iterator();
    L25:
        if (r20.hasNext() == false) goto L29;
        Object r21 = r20.next();
        if ((!((a) r21).b) == false) goto L25;
        r19.add(r21);
        goto L25
    L29:
        I("handle extra init barrier actions, size=" + r19.size());
        Iterator r22 = r19.iterator();
    L31:
        if (r22.hasNext() == false) goto L33;
        ((a) r22.next()).a.invoke();
        goto L31
    L33:
        this.e.removeAll(r19);
        F("handle extra init barrier actions done, currentQueueSize=" + this.e.size(), null);
        CollectionsKt.removeAll(this.e, AnyaExecutor$handleInitBarrierActions$2.INSTANCE);
        if ((!this.e.isEmpty()) == true) goto L23;
    L43:
        th = move-exception;
        throw th;
    }

    public final void L(Function0 r10, boolean r11) {
        LinkedList<a> r1 = this.e;
        monitor-enter(r1);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.g == false) goto L7;
    L15:
        this.e.add(new a(r10, r11, 0));     // Catch: Throwable -> L18
        StringBuilder r12 = new StringBuilder("append action ui=");     // Catch: Throwable -> L18
        r12.append(r11);     // Catch: Throwable -> L18
        r12.append(' ');     // Catch: Throwable -> L18
        r12.append(E());     // Catch: Throwable -> L18
    L16:
        monitor-exit(r1);
        return;
    L7:
        if (this.e.isEmpty() == false) goto L15;
        Boolean r13 = this.h;     // Catch: Throwable -> L18
        if (r11 == true) goto L11;
        boolean r14 = true;
    L13:
        if ((!Intrinsics.areEqual(r13, Boolean.valueOf(r14))) == false) goto L15;
        q(r10, r11);     // Catch: Throwable -> L18
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L18
        goto L16
    L11:
        r14 = false;
        goto L13
    }

    public final void q(Function0<Unit> r10, boolean r11) {
        this.g = true;
        if (r11 == false) goto L8;
        d r12 = new d(this, r10);
        CompositeDisposable r13 = this.f;
        Disposable r1 = Disposables.fromAction(new f(this, r12));
        r12.a = r1;
        r13.add(r1);
        if (this.p == 1) goto L7;
        this.d.post(r12);
        return;
    L7:
        this.d.postAtTime(r12, 2);
        return;
    L8:
        e r14 = new e(this, r10);
        if (this.o != 1) goto L13;
        ExecutorService r15 = this.c;
        if (r15 == null) goto L17;
        r15.submit(r14);
        return;
    L17:
        return;
    L13:
        Disposable r16 = Maybe.fromCallable(r14).subscribeOn(this.m).subscribe();
        r14.a = r16;
        CompositeDisposable r17 = this.f;
        Handler r0 = v.a;
        r17.add(r16);
    }

    public b(Scheduler r1, String r10, int r11, mb.b r12) {
        this.m = r1;
        this.n = r10;
        this.o = 0;
        this.p = r11;
        this.q = r12;
        this.b = new ReentrantLock(true);
        this.c = null;
        this.d = new Handler(Looper.getMainLooper());
        this.e = new LinkedList();
        this.f = new CompositeDisposable();
        this.l = LazyKt.lazy(new AnyaExecutor$objLabel$2(this));
    }
}
