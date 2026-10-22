package com.bytedance.android.live.impl.timer;

import android.os.Handler;
import com.bytedance.android.live.impl.strategy.Strategy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class TaskManager {
    public static final Lazy a = null;
    public static List<Long> b;
    public static Map<String, Long> c;
    public static List<Long> d;
    public static volatile boolean e;
    public static PthreadHandlerThreadV2 f;
    public static Handler g;
    public static long h;
    public static Function1<? super List<String>, Unit> i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r11) {
            Long r12 = (Long) r11;
            ArrayList r0 = new ArrayList();
            Iterator<T> r1 = TaskManager.d.iterator();
        L4:
            if (r1.hasNext() == false) goto L19;
            long r2 = ((Number) r1.next()).longValue();
            if (r12 == null) goto L4;
            if ((((r12.longValue() + 1) * TaskManager.a()) % r2) != 0) goto L4;
            Map<String, Long> r4 = TaskManager.c;
            LinkedHashMap r5 = new LinkedHashMap();
            Iterator<Map.Entry<String, Long>> r6 = r4.entrySet().iterator();
        L11:
            if (r6.hasNext() == false) goto L18;
            Map.Entry<String, Long> r7 = r6.next();
            if (r7.getValue().longValue() != r2) goto L15;
            boolean r8 = true;
        L16:
            if (r8 == false) goto L11;
            r5.put(r7.getKey(), r7.getValue());
            goto L11
        L15:
            r8 = false;
            goto L16
        L18:
            r0.addAll(CollectionsKt.toList(r5.keySet()));
            goto L4
        L19:
            this.a.invoke(r0);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Ref.ObjectRef a;

        public b(Ref.ObjectRef r1) {
            this.a = r1;
        }

        public final void a() {
            TaskManager.h++;
            ArrayList r0 = new ArrayList();
            Iterator<T> r1 = TaskManager.d.iterator();
        L4:
            if (r1.hasNext() == false) goto L18;
            long r4 = ((Number) r1.next()).longValue();
            if (((TaskManager.h * TaskManager.a()) % r4) != 0) goto L4;
            Map<String, Long> r2 = TaskManager.c;
            LinkedHashMap r6 = new LinkedHashMap();
            Iterator<Map.Entry<String, Long>> r3 = r2.entrySet().iterator();
        L9:
            if (r3.hasNext() == false) goto L16;
            Map.Entry<String, Long> r7 = r3.next();
            if (r7.getValue().longValue() != r4) goto L13;
            boolean r8 = true;
        L14:
            if (r8 == false) goto L9;
            r6.put(r7.getKey(), r7.getValue());
            goto L9
        L13:
            r8 = false;
            goto L14
        L16:
            r0.addAll(r6.keySet());
            goto L4
        L18:
            if ((!r0.isEmpty()) == false) goto L22;
            Function1<? super List<String>, Unit> r5 = TaskManager.i;
            if (r5 == null) goto L22;
            Unit r9 = (Unit) r5.invoke(r0);
        L22:
            Lazy r11 = TaskManager.a;
            if (TaskManager.e == false) goto L40;
            Runnable r12 = (Runnable) this.a.element;
            if (r12 == null) goto L41;
            Handler r13 = TaskManager.g;
            if (r13 == null) goto L42;
            r13.postDelayed(r12, TaskManager.a() * ((long) 1000));
            return;
        L42:
            return;
        L41:
            return;
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

    public static long a() {
        return ((Number) a.getValue()).longValue();
    }

    static {
        a = LazyKt.lazy(TaskManager$TIMER_CHECK_INTERVAL$2.INSTANCE);
        b = new ArrayList();
        c = new LinkedHashMap();
        d = new ArrayList();
    }

    public static void b(Strategy r1) {
        Intrinsics.checkNotNullParameter(r1, "strategy");
        Pair<List<Long>, Map<String, Long>> r2 = r1.getIntervalData();
        b = (List) r2.getFirst();
        c = (Map) r2.getSecond();
        CollectionsKt.sort(b);
    }

    public static void c(Function1 r3) {
        Intrinsics.checkNotNullParameter(r3, "update");
        List<Long> r0 = CollectionsKt.distinct(b);
        d = r0;
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        if (e == true) goto L10;
        e = true;
        du2.a.d(a(), TimeUnit.SECONDS).observeOn(Schedulers.computation()).subscribe(new a(r3));
        return;
    }

    public static void d(Function1 r5) {
        Intrinsics.checkNotNullParameter(r5, "update");
        List<Long> r0 = CollectionsKt.distinct(b);
        d = r0;
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        if (e == true) goto L17;
        e = true;
        i = r5;
        PthreadHandlerThreadV2 r6 = new PthreadHandlerThreadV2("TaskManagerHandlerThread");
        f = r6;
        ThreadMethodProxy.start(r6);
        PthreadHandlerThreadV2 r7 = f;
        if (r7 == null) goto L10;
        Handler r1 = new Handler(r7.getLooper());
    L11:
        g = r1;
        Ref.ObjectRef r8 = new Ref.ObjectRef();
        b r2 = new b(r8);
        r8.element = r2;
        Handler r9 = g;
        if (r9 == null) goto L16;
        r9.postDelayed(r2, a() * ((long) 1000));
        return;
    L16:
        return;
    L10:
        r1 = null;
        goto L11
    }
}
