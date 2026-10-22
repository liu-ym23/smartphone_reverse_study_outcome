package com.ss.android.lark.passportc.internal;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.log.trace.StepTrace;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.ref.WeakReference;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class GlobalPassportServiceImpl implements com.ss.android.lark.passportc.api.j {
    public static final /* synthetic */ int m = 0;
    public final Provider<com.ss.android.lark.passportc.api.e> a;
    public final com.ss.android.lark.log.c b;
    public final t c;
    public final l0c.c d;
    public final Provider<Set<com.ss.android.lark.passportc.api.p>> e;
    public final Lazy f;
    public final Function1<f0c.b, Unit> g;
    public final Set<g> h;
    public final Set<WeakReference<Function1<f0c.b, Unit>>> i;
    public final Executor j;
    public final Executor k;
    public final Lazy l;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ GlobalPassportServiceImpl a;
        public final /* synthetic */ Function1<List<h>, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(GlobalPassportServiceImpl r1, Function1<? super List<h>, Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r3) {
            List r4 = (List) r3;
            Intrinsics.checkNotNullParameter(r4, "list");
            return Completable.fromAction(new n(this.b, r4)).subscribeOn((Scheduler) this.a.l.getValue());
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues((Long) ((Map.Entry) r2).getValue(), (Long) ((Map.Entry) r1).getValue());
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ GlobalPassportServiceImpl a;
        public final /* synthetic */ com.ss.android.lark.passportc.api.n b;

        public d(GlobalPassportServiceImpl r1, com.ss.android.lark.passportc.api.n r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            GlobalPassportServiceImpl r0 = this.a;
            r0.l(new s(f0c.c.a, r0.d(), CollectionsKt.listOf(new h(this.b))));
            GlobalPassportServiceImpl r1 = this.a;
            com.ss.android.lark.passportc.api.n r2 = this.b;
            monitor-enter(r1);
            Iterator<T> r3 = r1.h.iterator();     // Catch: Throwable -> L21
        L6:
            if (r3.hasNext() == false) goto L15;
            Object r4 = r3.next();     // Catch: Throwable -> L21
            g r5 = (g) r4;     // Catch: Throwable -> L21
            if (r5 != null) goto L10;
        L12:
            boolean r6 = false;
        L13:
            if (r6 == false) goto L6;
        L16:
            if (r4 != null) goto L18;
            r1.h.add(new g(new WeakReference(r2)));     // Catch: Throwable -> L21
        L18:
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L21
            monitor-exit(r1);
            return;
        L10:
            if (Intrinsics.areEqual(r5.a.get(), r2) == false) goto L12;
            r6 = true;
            goto L13
        L15:
            r4 = null;
        L21:
            th = move-exception;
            throw th;
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
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.j
    public final List<f0c.b> a() {
        return ((com.ss.android.lark.passportc.api.e) this.a.get()).a();
    }

    @Override // com.ss.android.lark.passportc.api.j
    public final UserSession b() {
        f0c.b r0 = (f0c.b) ((BehaviorSubject) this.f.getValue()).getValue();
        if (r0 == null) goto L7;
        f0c.g r1 = r0.a();
        if (r1 == null) goto L7;
        return r1.b;
    L7:
        return null;
    }

    @Override // com.ss.android.lark.passportc.api.j
    public final f0c.b d() {
        f0c.b r0 = (f0c.b) ((BehaviorSubject) this.f.getValue()).getValue();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return f0c.c.a;
    }

    @Override // com.ss.android.lark.passportc.api.j
    public final String g() {
        f0c.b r0 = (f0c.b) ((BehaviorSubject) this.f.getValue()).getValue();
        if (r0 == null) goto L9;
        f0c.g r1 = r0.a();
        if (r1 == null) goto L9;
        User r2 = r1.a;
        if (r2 == null) goto L9;
        return r2.userId;
    L9:
        return null;
    }

    @Override // com.ss.android.lark.passportc.api.j
    public final UserSession f() {
        UserSession r0 = b();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return ContainerConstsKt.a();
    }

    @Override // com.ss.android.lark.passportc.api.j
    public final void c(com.ss.android.lark.passportc.ffi.a.C0096a r5) {
        Intrinsics.checkNotNullParameter(r5, "observer");
        f0c.b r0 = (f0c.b) ((BehaviorSubject) this.f.getValue()).getValue();
        if (r0 != null) goto L5;
        r0 = f0c.c.a;
    L5:
        monitor-enter(this);
        Iterator<T> r1 = this.i.iterator();     // Catch: Throwable -> L18
    L8:
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();     // Catch: Throwable -> L18
        if (Intrinsics.areEqual(((WeakReference) r2).get(), r5) == false) goto L8;
    L13:
        if (r2 != null) goto L15;
        this.j.execute(new m(r5, r0));     // Catch: Throwable -> L18
        this.i.add(new WeakReference(r5));     // Catch: Throwable -> L18
    L15:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L12:
        r2 = null;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.passportc.api.j
    public final void e(com.ss.android.lark.passportc.api.n r3) {
        Intrinsics.checkNotNullParameter(r3, "convention");
        this.k.execute(new d(this, r3));
    }

    @Override // com.ss.android.lark.passportc.api.j
    public final void h(final com.ss.android.lark.passportc.api.n r3) {
        Intrinsics.checkNotNullParameter(r3, "convention");
        monitor-enter(this);
        CollectionsKt.removeAll(this.h, new GlobalPassportServiceImpl$unregisterConvention$1$1(r3));     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void l(final s r13) {
        f0c.b r0 = r13.a;
        StringBuilder r1 = new StringBuilder("notifyConventions global start，pre: uid=");
        f0c.g r2 = r0.a();
        if (r2 == null) goto L7;
        User r3 = r2.a;
        if (r3 == null) goto L7;
        String r4 = r3.userId;
    L8:
        r1.append(r4);
        r1.append(" scene=");
        r1.append(r0.b.b);
        r1.append(" state=");
        r1.append(r0.b.a);
        r1.append('}');
        Log.i("n_action_cm_global_convention_registry", r1.toString());
        f0c.b r5 = r13.b;
        StringBuilder r6 = new StringBuilder("notifyConventions global start，cur: uid=");
        f0c.g r7 = r5.a();
        if (r7 == null) goto L13;
        User r8 = r7.a;
        if (r8 == null) goto L13;
        String r9 = r8.userId;
    L14:
        r6.append(r9);
        r6.append(" scene=");
        r6.append(r5.b.b);
        r6.append(" state=");
        r6.append(r5.b.a);
        r6.append('}');
        Log.i("n_action_cm_global_convention_registry", r6.toString());
        long r10 = SystemClock.elapsedRealtimeNanos();
        final ConcurrentHashMap r11 = new ConcurrentHashMap();
        final ConcurrentHashMap r12 = new ConcurrentHashMap();
        final ConcurrentHashMap r14 = new ConcurrentHashMap();
        final Ref.LongRef r15 = new Ref.LongRef();
        Math.max(r13.c.size() / 5, 5);
        if ((r13.a instanceof f0c.f) == false) goto L29;
        f0c.b r16 = r13.b;
        if ((r16 instanceof f0c.e) == false) goto L19;
    L20:
        StepTrace r17 = m0c.d.a.a(m0c.d.i);
        r17.e(GlobalPassportServiceImpl$notifyConventions2$offlineTrace$1.INSTANCE);
        Throwable r18 = i(r13.c, new GlobalPassportServiceImpl$notifyConventions2$userOfflineResult$1(r11, r13, r15));
        if (r18 != null) goto L27;
        Throwable r19 = i(r13.c, new GlobalPassportServiceImpl$notifyConventions2$afterUserOfflineResult$1(r13, r11, r15));
        if (r19 != null) goto L25;
        StepTrace.g(r17);
        goto L29
    L25:
        k(r19, "afterUserOffline");
        throw null;
    L27:
        k(r18, "onUserOffline");
        throw null;
    L19:
        if ((r16 instanceof f0c.a) == true) goto L20;
    L29:
        f0c.g r20 = r13.a.a();
        if (r20 == null) goto L32;
        UserSession r21 = r20.b;
    L33:
        f0c.g r22 = r13.b.a();
        if (r22 == null) goto L36;
        UserSession r23 = r22.b;
    L38:
        if (com.ss.android.lark.passportc.convention.d.a(r21, r23) == false) goto L48;
        StepTrace r24 = m0c.d.a.a(m0c.d.j);
        r24.e(GlobalPassportServiceImpl$notifyConventions2$userChangeTrace$1.INSTANCE);
        Throwable r25 = i(r13.c, new GlobalPassportServiceImpl$notifyConventions2$userChangeResult$1(r12, r13, r15));
        if (r25 != null) goto L46;
        Throwable r26 = i(r13.c, new GlobalPassportServiceImpl$notifyConventions2$afterUserChangedResult$1(r13, r12, r15));
        if (r26 != null) goto L44;
        StepTrace.g(r24);
        goto L48
    L44:
        k(r26, "afterUserChanged");
        throw null;
    L46:
        k(r25, "onUserChanged");
        throw null;
    L48:
        f0c.b r27 = r13.a;
        if ((r27 instanceof f0c.e) == true) goto L53;
        if ((r27 instanceof f0c.a) == true) goto L53;
    L63:
        j("notifyConventions global cost, userOffline", r11);
        j("notifyConventions global cost, userChanged", r12);
        j("notifyConventions global cost, userOnline ", r14);
        long r28 = SystemClock.elapsedRealtimeNanos() - r10;
        StringBuilder r29 = new StringBuilder("notifyConventions global end, total cost: ");
        long r30 = 1000000;
        r29.append(r28 / r30);
        r29.append(", sumCost: ");
        r29.append(r15.element / r30);
        r29.append(", reduce=");
        r29.append((r15.element - r28) / r30);
        r29.append(", count=");
        r29.append(r13.c.size());
        Log.i("n_action_cm_global_convention_registry", r29.toString());
        return;
    L53:
        if ((r13.b instanceof f0c.f) == false) goto L63;
        StepTrace r31 = m0c.d.a.a(m0c.d.k);
        r31.e(GlobalPassportServiceImpl$notifyConventions2$userOnlineTrace$1.INSTANCE);
        Throwable r32 = i(r13.c, new GlobalPassportServiceImpl$notifyConventions2$userOnlineResult$1(r14, r13, r15));
        if (r32 != null) goto L61;
        Throwable r33 = i(r13.c, new GlobalPassportServiceImpl$notifyConventions2$afterUserOnlineResult$1(r13, r14, r15));
        if (r33 != null) goto L59;
        StepTrace.g(r31);
        goto L63
    L59:
        k(r33, "afterUserOnline");
        throw null;
    L61:
        k(r32, "onUserOnline");
        throw null;
    L36:
        r23 = null;
        goto L38
    L32:
        r21 = null;
    L13:
        r9 = null;
    L7:
        r4 = null;
        goto L8
    }

    public static void k(Throwable r3, String r4) {
        Log.e("n_action_cm_global_convention_registry", "notify global " + r4 + " error", new NotifyConventionException(r3.getMessage(), r3), true);
        throw r3;
    }

    public final Throwable i(List<h> r3, Function1<? super List<h>, Unit> r4) {
        if (r3.size() <= 5) goto L10;
        int r0 = Math.max(r3.size() / 5, 5);
        return Observable.fromIterable(r3).buffer(r0).flatMapCompletable(new b(this, r4)).blockingGet();
    L10:
        r4.invoke(r3);     // Catch: Throwable -> L6
        return null;
    L6:
        th = move-exception;
        return th;
    }

    public final void j(String r8, Map<String, Long> r9) {
        ConcurrentHashMap r10 = (ConcurrentHashMap) r9;
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        StringBuilder r0 = new StringBuilder(r8 + ", count=" + r10.size() + ':');
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator r12 = r10.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L14;
        Map.Entry r1 = (Map.Entry) r12.next();
        if (((Number) r1.getValue()).longValue() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L7;
        r11.put(r1.getKey(), r1.getValue());
        goto L7
    L11:
        r2 = false;
        goto L12
    L14:
        Iterator r13 = CollectionsKt.sortedWith(r11.entrySet(), new c()).iterator();
    L16:
        if (r13.hasNext() == false) goto L20;
        Map.Entry r14 = (Map.Entry) r13.next();
        long r3 = ((Number) r14.getValue()).longValue() / ((long) 1000000);
        r0.append("\n  cost:" + r3 + ", " + ((String) r14.getKey()));
        l0c.c r4 = this.d;
        if (r4 == null) goto L16;
        r4.c("rust_infra_user_notify_" + ((String) r14.getKey()), r3);
        goto L16
    L20:
        Log.i("n_action_cm_global_convention_registry", r0.toString());
    }

    @Inject
    public GlobalPassportServiceImpl(Provider<com.ss.android.lark.passportc.api.e> r2, com.ss.android.lark.log.c r3, t r4, l0c.c r5, Provider<Set<com.ss.android.lark.passportc.api.p>> r6) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        Intrinsics.checkNotNullParameter(r3, "logger");
        Intrinsics.checkNotNullParameter(r4, "executors");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = LazyKt.lazy(GlobalPassportServiceImpl$lastState$2.INSTANCE);
        Function1<f0c.b, Unit> r7 = new GlobalPassportServiceImpl$stateObserver$1(this);
        this.g = r7;
        this.h = new LinkedHashSet();
        this.i = new LinkedHashSet();
        this.j = r4.g();
        this.k = r4.h();
        this.l = LazyKt.lazy(new GlobalPassportServiceImpl$workSchedulerPool$2(this));
        ((com.ss.android.lark.passportc.api.e) r2.get()).d(r7);
    }
}
