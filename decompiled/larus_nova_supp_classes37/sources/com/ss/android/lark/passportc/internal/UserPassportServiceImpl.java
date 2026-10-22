package com.ss.android.lark.passportc.internal;

import android.os.SystemClock;
import com.bytedance.ee.bear.middleground.unbundle.BenefitManagerImpl;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.log.trace.StepTrace;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import dagger.hilt.dwarf.lifecycle.ComponentLifecycleAware;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@UserScope
public final class UserPassportServiceImpl implements com.ss.android.lark.passportc.api.m, ComponentLifecycleAware {
    public static final /* synthetic */ int l = 0;
    public final f0 a;
    public final com.ss.android.lark.log.c b;
    public final t c;
    public final l0c.c d;
    public final BehaviorSubject<f0c.h> e;
    public final Function1<f0c.h, Unit> f;
    public final Set<d0> g;
    public final Set<WeakReference<Function1<f0c.h, Unit>>> h;
    public final Executor i;
    public final Executor j;
    public final Scheduler k;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Function1<f0c.h, Unit> a;
        public final /* synthetic */ f0c.h b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super f0c.h, Unit> r1, f0c.h r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
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

    public static final class d<T, R> implements Function {
        public final /* synthetic */ UserPassportServiceImpl a;
        public final /* synthetic */ h0 b;
        public final /* synthetic */ ConcurrentHashMap<String, Long> c;
        public final /* synthetic */ Ref.LongRef d;

        public d(UserPassportServiceImpl r1, h0 r2, ConcurrentHashMap<String, Long> r3, Ref.LongRef r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final Object apply(Object r5) {
            final List r6 = (List) r5;
            Intrinsics.checkNotNullParameter(r6, "list");
            final h0 r1 = this.b;
            final ConcurrentHashMap<String, Long> r2 = this.c;
            final Ref.LongRef r3 = this.d;
            return Completable.fromAction(new UserPassportServiceImpl$notifyConventions2$afterUserOfflineResult$1$1(r6, r1, r2, r3)).subscribeOn(this.a.k);
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ UserPassportServiceImpl a;
        public final /* synthetic */ h0 b;
        public final /* synthetic */ ConcurrentHashMap<String, Long> c;
        public final /* synthetic */ Ref.LongRef d;

        public e(UserPassportServiceImpl r1, h0 r2, ConcurrentHashMap<String, Long> r3, Ref.LongRef r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final Object apply(Object r5) {
            final List r6 = (List) r5;
            Intrinsics.checkNotNullParameter(r6, "list");
            final h0 r1 = this.b;
            final ConcurrentHashMap<String, Long> r2 = this.c;
            final Ref.LongRef r3 = this.d;
            return Completable.fromAction(new UserPassportServiceImpl$notifyConventions2$afterUserOnlineResult$1$1(r6, r1, r2, r3)).subscribeOn(this.a.k);
        }
    }

    public static final class f<T, R> implements Function {
        public final /* synthetic */ UserPassportServiceImpl a;
        public final /* synthetic */ ConcurrentHashMap<String, Long> b;
        public final /* synthetic */ h0 c;
        public final /* synthetic */ Ref.LongRef d;

        public f(UserPassportServiceImpl r1, ConcurrentHashMap<String, Long> r2, h0 r3, Ref.LongRef r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final Object apply(Object r5) {
            final List r6 = (List) r5;
            Intrinsics.checkNotNullParameter(r6, "list");
            final ConcurrentHashMap<String, Long> r1 = this.b;
            final h0 r2 = this.c;
            final Ref.LongRef r3 = this.d;
            return Completable.fromAction(new UserPassportServiceImpl$notifyConventions2$userOfflineResult$1$1(r6, r1, r2, r3)).subscribeOn(this.a.k);
        }
    }

    public static final class g<T, R> implements Function {
        public final /* synthetic */ UserPassportServiceImpl a;
        public final /* synthetic */ ConcurrentHashMap<String, Long> b;
        public final /* synthetic */ h0 c;
        public final /* synthetic */ Ref.LongRef d;

        public g(UserPassportServiceImpl r1, ConcurrentHashMap<String, Long> r2, h0 r3, Ref.LongRef r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final Object apply(Object r5) {
            final List r6 = (List) r5;
            Intrinsics.checkNotNullParameter(r6, "list");
            final ConcurrentHashMap<String, Long> r1 = this.b;
            final h0 r2 = this.c;
            final Ref.LongRef r3 = this.d;
            return Completable.fromAction(new UserPassportServiceImpl$notifyConventions2$userOnlineResult$1$1(r6, r1, r2, r3)).subscribeOn(this.a.k);
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ UserPassportServiceImpl a;
        public final /* synthetic */ com.ss.android.lark.passportc.api.o b;

        public h(UserPassportServiceImpl r1, com.ss.android.lark.passportc.api.o r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            this.a.g(new h0(f0c.i.a, this.a.getState(), CollectionsKt.listOf(new e0(this.b))));
            UserPassportServiceImpl r0 = this.a;
            com.ss.android.lark.passportc.api.o r1 = this.b;
            monitor-enter(r0);
            Iterator<T> r2 = r0.g.iterator();     // Catch: Throwable -> L21
        L6:
            if (r2.hasNext() == false) goto L15;
            Object r3 = r2.next();     // Catch: Throwable -> L21
            d0 r4 = (d0) r3;     // Catch: Throwable -> L21
            if (r4 != null) goto L10;
        L12:
            boolean r5 = false;
        L13:
            if (r5 == false) goto L6;
        L16:
            if (r3 != null) goto L18;
            r0.g.add(new d0(new WeakReference(r1)));     // Catch: Throwable -> L21
            m0c.b.a(r0.b, "n_action_cm_user_convention_registry", "register convention:" + r1.getClass().getName() + "，size=" + r0.g.size() + ", user= " + r0.getUser().userId + ' ');     // Catch: Throwable -> L21
        L18:
            Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L21
            monitor-exit(r0);
            return;
        L10:
            if (Intrinsics.areEqual(r4.a.get(), r1) == false) goto L12;
            r5 = true;
            goto L13
        L15:
            r3 = null;
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

    public final void onComponentCreate() {
    }

    public final void onComponentDestroy() {
    }

    @Override // com.ss.android.lark.passportc.api.m
    public final UserSession getSession() {
        return this.a.getSession();
    }

    @Override // com.ss.android.lark.passportc.api.m
    public final f0c.h getState() {
        f0c.h r0 = (f0c.h) this.e.getValue();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return f0c.i.a;
    }

    @Override // com.ss.android.lark.passportc.api.m
    public final User getUser() {
        return this.a.getUser();
    }

    @Override // com.ss.android.lark.passportc.api.m
    public final void a(Function1<? super f0c.h, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "observer");
        f0c.h r0 = (f0c.h) this.e.getValue();
        if (r0 != null) goto L5;
        r0 = f0c.i.a;
    L5:
        monitor-enter(this);
        Iterator<T> r1 = this.h.iterator();     // Catch: Throwable -> L18
    L8:
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();     // Catch: Throwable -> L18
        if (Intrinsics.areEqual(((WeakReference) r2).get(), r5) == false) goto L8;
    L13:
        if (r2 != null) goto L15;
        this.i.execute(new b(r5, r0));     // Catch: Throwable -> L18
        this.h.add(new WeakReference(r5));     // Catch: Throwable -> L18
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

    @Override // com.ss.android.lark.passportc.api.m
    public final void b(final BenefitManagerImpl.b r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        monitor-enter(this);
        CollectionsKt.removeAll(this.h, new UserPassportServiceImpl$removeUserStateObserver$1$1(r3));     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.passportc.api.m
    public final void c(final com.ss.android.lark.passportc.api.o r5) {
        Intrinsics.checkNotNullParameter(r5, "convention");
        monitor-enter(this);
        m0c.b.a(this.b, "n_action_cm_user_convention_registry", "unregister convention:" + r5.getClass().getName() + ", user= " + getUser().userId + ' ');     // Catch: Throwable -> L7
        CollectionsKt.removeAll(this.g, new UserPassportServiceImpl$unregisterConvention$1$1(r5));     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.passportc.api.m
    public final void d(com.ss.android.lark.passportc.api.o r3) {
        Intrinsics.checkNotNullParameter(r3, "convention");
        this.j.execute(new h(this, r3));
    }

    public final void g(h0 r13) {
        Log.i("UserPassportServiceImpl", "notifyConventions user start，uid:" + getUser().userId + " scene:" + r13.a.b + " pre:" + r13.a.a + " cur:" + r13.b.a + ' ');
        long r2 = SystemClock.elapsedRealtimeNanos();
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        ConcurrentHashMap r4 = new ConcurrentHashMap();
        Ref.LongRef r5 = new Ref.LongRef();
        int r6 = Math.max(r13.c.size() / 5, 5);
        UserState r7 = r13.a.a;
        UserState r8 = UserState.OFFLINE;
        if (r7 != r8) goto L16;
        if (r13.b.a != UserState.ONLINE) goto L16;
        StepTrace r9 = m0c.d.a.a(m0c.d.m);
        r9.e(UserPassportServiceImpl$notifyConventions2$userOnlineTrace$1.INSTANCE);
        Throwable r10 = Observable.fromIterable(r13.c).buffer(r6).flatMapCompletable(new g(this, r0, r13, r5)).blockingGet();
        if (r10 != null) goto L13;
        Throwable r11 = Observable.fromIterable(r13.c).buffer(r6).flatMapCompletable(new e(this, r13, r0, r5)).blockingGet();
        if (r11 != null) goto L11;
        StepTrace.g(r9);
    L28:
        e("notifyConventions user cost, online ", r0);
        e("notifyConventions user cost, offline", r4);
        long r12 = SystemClock.elapsedRealtimeNanos() - r2;
        StringBuilder r1 = new StringBuilder("notifyConventions user end, total cost: ");
        long r3 = 10000000;
        r1.append(r12 / r3);
        r1.append(", sumCost: ");
        r1.append(r5.element / r3);
        r1.append(", reduce=");
        r1.append((r5.element - r12) / r3);
        r1.append(" count=");
        r1.append(r13.c.size());
        Log.i("UserPassportServiceImpl", r1.toString());
        return;
    L11:
        f(r11, "afterUserOnline");
        throw null;
    L13:
        f(r10, "onUserOnline");
        throw null;
    L16:
        if (r7 != UserState.ONLINE) goto L28;
        if (r13.b.a != r8) goto L28;
        StepTrace r14 = m0c.d.a.a(m0c.d.l);
        r14.e(UserPassportServiceImpl$notifyConventions2$userOfflineTrace$1.INSTANCE);
        Throwable r15 = Observable.fromIterable(r13.c).buffer(r6).flatMapCompletable(new f(this, r4, r13, r5)).blockingGet();
        if (r15 != null) goto L26;
        Throwable r16 = Observable.fromIterable(r13.c).buffer(r6).flatMapCompletable(new d(this, r13, r4, r5)).blockingGet();
        if (r16 != null) goto L24;
        StepTrace.g(r14);
        goto L28
    L24:
        f(r16, "afterUserOffline");
        throw null;
    L26:
        f(r15, "onUserOffline");
        throw null;
    }

    public static void f(Throwable r3, String r4) {
        Log.e("UserPassportServiceImpl", "notify user " + r4 + " error", new NotifyConventionException(r3.getMessage(), r3), true);
        throw r3;
    }

    public final void e(String r8, Map<String, Long> r9) {
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
        Log.i("UserPassportServiceImpl", r0.toString());
    }

    @Inject
    public UserPassportServiceImpl(f0 r2, com.ss.android.lark.log.c r3, t r4, l0c.c r5) {
        Intrinsics.checkNotNullParameter(r2, "userDelegate");
        Intrinsics.checkNotNullParameter(r3, "logger");
        Intrinsics.checkNotNullParameter(r4, "passportExecutors");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = BehaviorSubject.createDefault(f0c.i.a);
        Function1<f0c.h, Unit> r6 = new UserPassportServiceImpl$stateObserver$1(this);
        this.f = r6;
        this.g = new LinkedHashSet();
        this.h = new LinkedHashSet();
        this.i = r4.g();
        this.j = r4.h();
        this.k = r4.e();
        r2.a(r6);
    }
}
