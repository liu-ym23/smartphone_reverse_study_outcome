package k0c;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.log.trace.StepTrace;
import com.ss.android.lark.passportc.api.ExecuteStrategy;
import com.ss.android.lark.passportc.internal.t;
import com.ss.android.lark.passportc.task.TaskType;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public final t a;
    public final l0c.c b;
    public final Function2<d, j0c.c, Unit> c;
    public final LinkedBlockingQueue<d> d;
    public final AtomicBoolean e;
    public final b f;

    public static final class a implements Runnable {
        public final /* synthetic */ k0c.b.a a;
        public final /* synthetic */ k0c.d b;
        public final /* synthetic */ j0c.e c;
        public final /* synthetic */ ExecuteStrategy d;
        public final /* synthetic */ e e;

        /* JADX INFO: renamed from: k0c.e$a$a, reason: collision with other inner class name */
        public static final class C0159a<T> implements Consumer {
            public final /* synthetic */ k0c.b.a a;
            public final /* synthetic */ k0c.d b;

            public C0159a(k0c.b.a r1, k0c.d r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r4) {
                Disposable r5 = (Disposable) r4;
                k0c.b.a r6 = this.a;
                k0c.d r0 = this.b;
                r6.getClass();
                Intrinsics.checkNotNullParameter(r0, "task");
                Log.i("ComponentTask", "component task start run: [" + r0.getTask().F().a + ']');
                r6.g = SystemClock.elapsedRealtime();
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ k0c.b.a a;
            public final /* synthetic */ k0c.d b;

            public b(k0c.b.a r1, k0c.d r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r6) {
                j0c.c r7 = (j0c.c) r6;
                k0c.b.a r8 = this.a;
                k0c.d r0 = this.b;
                r8.getClass();
                Intrinsics.checkNotNullParameter(r0, "task");
                StepTrace r1 = r8.b;
                if (r1 == null) goto L5;
                StepTrace.d(r1);
            L5:
                r8.h = SystemClock.elapsedRealtime() - r8.g;
                Log.i("ComponentTask", "component task end run: [" + r0.getTask().F().a + ']');
            }
        }

        public static final class c<T> implements Consumer {
            public final /* synthetic */ e a;
            public final /* synthetic */ k0c.b.a b;
            public final /* synthetic */ k0c.d c;

            public c(e r1, k0c.b.a r2, k0c.d r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void accept(Object r4) {
                j0c.c r5 = (j0c.c) r4;
                k0c.b r0 = this.a.f;
                k0c.b.a r1 = this.b;
                boolean r2 = r5.b;
                r0.a(r1);
                Function2<k0c.d, j0c.c, Unit> r3 = this.a.c;
                if (r3 == null) goto L6;
                k0c.d r6 = this.c;
                Intrinsics.checkNotNull(r5);
                r3.invoke(r6, r5);
                return;
            }
        }

        public static final class d<T> implements Consumer {
            public final /* synthetic */ e a;
            public final /* synthetic */ k0c.b.a b;
            public final /* synthetic */ k0c.d c;

            public d(e r1, k0c.b.a r2, k0c.d r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void accept(Object r7) {
                Throwable r8 = (Throwable) r7;
                this.a.f.a(this.b);
                Function2<k0c.d, j0c.c, Unit> r9 = this.a.c;
                if (r9 == null) goto L6;
                k0c.d r0 = this.c;
                r9.invoke(r0, new j0c.c(r0.getTask().F(), false, null, 12));
                return;
            }
        }

        public a(k0c.b.a r1, k0c.d r2, j0c.e r3, ExecuteStrategy r4, e r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            k0c.b.a r0 = this.a;
            k0c.d r1 = this.b;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "task");
            r0.d = SystemClock.elapsedRealtime() - r0.c;
            r0.e = SystemClock.elapsedRealtime();
            Observable<j0c.c> r2 = this.b.a(this.c, this.d);
            k0c.b.a r3 = this.a;
            k0c.d r4 = this.b;
            r3.getClass();
            Intrinsics.checkNotNullParameter(r4, "task");
            r3.f = SystemClock.elapsedRealtime() - r3.e;
            Observable r5 = r2.doOnSubscribe(new C0159a(this.a, this.b)).doOnNext(new b(this.a, this.b));
            e r6 = this.e;
            k0c.b.a r7 = this.a;
            k0c.d r8 = this.b;
            r5.subscribe(new c(r6, r7, r8), new d(r6, r7, r8));
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

    public final void c() {
        Log.i("ComponentTask", "shut down current isShutDown = " + this.e.get());
        if (this.e.compareAndSet(false, true) == false) goto L6;
        this.d.clear();
        Log.i("ComponentTask", "taskExecutor shutDown , clear task queue");
        return;
    }

    public final void a(d r4) {
        Intrinsics.checkNotNullParameter(r4, "task");
        Log.i("ComponentTask", "taskQueue add task [" + r4.c() + ']');     // Catch: IllegalStateException -> L5
        this.d.offer(r4);     // Catch: IllegalStateException -> L5
        return;
    L5:
        Log.e("ComponentTask", "taskQueue is full add task [" + r4.c() + "] failed");
    }

    public final void b(j0c.e r9, ExecuteStrategy r10) {
        Intrinsics.checkNotNullParameter(r9, "userContext");
        Intrinsics.checkNotNullParameter(r10, "executeStrategy");
        b r0 = this.f;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r9, "userContext");
        Intrinsics.checkNotNullParameter(r10, "executeStrategy");
        Log.i("ComponentTask", "component task all execute start， strategy=" + r10);
        l0c.c r1 = r0.b;
        if (r1 != null) goto L5;
    L9:
        r0.e.clear();
        r0.c = SystemClock.elapsedRealtime();
        r0.d = 0;
    L11:
        if (this.e.get() == true) goto L15;
        d r3 = this.d.poll();
        if (r3 == null) goto L11;
        this.f.getClass();
        Intrinsics.checkNotNullParameter(r3, "task");
        b.a r2 = new b.a(r3);
        Intrinsics.checkNotNullParameter(r3, "task");
        Log.i("ComponentTask", "component task start execute: [" + r3.c() + ']');
        StepTrace r4 = m0c.d.a.a(r3.c().a);
        StepTrace.b(r4);
        r2.b = r4;
        r2.c = SystemClock.elapsedRealtime();
        this.a.d().execute(new a(r2, r3, r9, r10, this));
        goto L11
    L15:
        b r11 = this.f;
        l0c.c r12 = r11.b;
        if (r12 != null) goto L18;
    L22:
        ConcurrentHashMap<String, b.C0158b> r13 = r11.e;
        monitor-enter(r13);
    L44:
        th = move-exception;
        throw th;
    L25:
        if (r11.e.isEmpty() == true) goto L40;
        Set<Map.Entry<String, b.C0158b>> r5 = r11.e.entrySet();     // Catch: Throwable -> L44
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L44
        Iterator<T> r7 = r5.iterator();     // Catch: Throwable -> L44
    L28:
        if (r7.hasNext() == false) goto L35;
        Object r8 = r7.next();     // Catch: Throwable -> L44
        if (((b.C0158b) ((Map.Entry) r8).getValue()).d < 5) goto L32;
        boolean r14 = true;
    L33:
        if (r14 == false) goto L28;
        r6.add(r8);     // Catch: Throwable -> L44
        goto L28
    L32:
        r14 = false;
        goto L33
    L35:
        List r15 = CollectionsKt.sortedWith(r6, new c());     // Catch: Throwable -> L44
        StringBuilder r16 = new StringBuilder("component tasks cost:");     // Catch: Throwable -> L44
        Iterator r17 = r15.iterator();     // Catch: Throwable -> L44
    L37:
        if (r17.hasNext() == false) goto L39;
        Map.Entry r18 = (Map.Entry) r17.next();     // Catch: Throwable -> L44
        r16.append("\n  [" + ((String) r18.getKey()) + "]: totalCost=" + ((b.C0158b) r18.getValue()).d + ", exeCost=" + ((b.C0158b) r18.getValue()).a + ", runCost=" + ((b.C0158b) r18.getValue()).b + ", waitTime=" + ((b.C0158b) r18.getValue()).c);     // Catch: Throwable -> L44
        goto L37
    L39:
        Log.i("ComponentTask", r16.toString());     // Catch: Throwable -> L44
    L40:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L44
        monitor-exit(r13);
        long r20 = SystemClock.elapsedRealtime() - r11.c;
        Log.i("ComponentTask", "component task all execute finished!  realCost=" + r20 + ", sumCost=" + r11.d + ", reduce=" + (r11.d - r20));
        return;
    L18:
        if (r11.a != TaskType.OFFLINE) goto L20;
        String r21 = "rust_infra_offline_task_total";
    L21:
        r12.i(r21);
        goto L22
    L20:
        r21 = "rust_infra_online_task_total";
        goto L21
    L5:
        if (r0.a != TaskType.OFFLINE) goto L7;
        String r22 = "rust_infra_offline_task_total";
    L8:
        r1.b(r22);
        goto L9
    L7:
        r22 = "rust_infra_online_task_total";
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(int r2, TaskType r3, t r4, l0c.c r5, Function2<? super d, ? super j0c.c, Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "taskType");
        Intrinsics.checkNotNullParameter(r4, "passportExecutors");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = new LinkedBlockingQueue(r2);
        this.e = new AtomicBoolean(false);
        this.f = new b(r3, r5);
    }
}
