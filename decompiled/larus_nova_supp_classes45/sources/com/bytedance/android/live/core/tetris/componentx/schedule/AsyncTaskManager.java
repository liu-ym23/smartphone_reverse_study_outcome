package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.core.log.ALogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AsyncTaskManager {
    public final Map<String, Function1<Continuation<? super Unit>, Object>> a;
    public final Map<String, List<String>> b;
    public final Map<String, AtomicReference<a>> c;
    public final Map<String, CountDownLatch> d;
    public final Map<String, CountDownLatch> e;
    public final CoroutineScope f;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.componentx.schedule.AsyncTaskManager$a$a, reason: collision with other inner class name */
        public static final class C0151a extends a {
            public static final C0151a a = null;

            static {
                a = new C0151a();
            }

            public C0151a() {
            }
        }

        public static final class b extends a {
            public final Exception a;

            public b(Exception r2) {
                Intrinsics.checkNotNullParameter(r2, "exception");
                this.a = r2;
            }
        }

        public static final class c extends a {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public static final class d extends a {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }

        public static final class e extends a {
            public static final e a = null;

            static {
                a = new e();
            }

            public e() {
            }
        }

        public a() {
        }
    }

    public final void f() {
        Intrinsics.checkNotNullParameter("initSchedulerIntance", "taskName");
        Function1 r0 = (Function1) ((LinkedHashMap) this.a).get("initSchedulerIntance");
        if (r0 == null) goto L16;
        Object r2 = ((LinkedHashMap) this.c).get("initSchedulerIntance");
        Intrinsics.checkNotNull(r2);
        AtomicReference r3 = (AtomicReference) r2;
        a.c r4 = a.c.a;
        a.e r5 = a.e.a;
    L6:
        if (r3.compareAndSet(r4, r5) == true) goto L7;
        if (r3.get() == r4) goto L6;
        boolean r6 = false;
    L11:
        if (r6 == true) goto L13;
        return;
    L13:
        BuildersKt.launch$default(this.f, null, null, new AsyncTaskManager$startAsync$1(this, "initSchedulerIntance", r0, null), 3, null);
        return;
    L7:
        r6 = true;
        goto L11
    L16:
        throw new IllegalArgumentException("Task initSchedulerIntance not configured");
    }

    public AsyncTaskManager() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public final void b(Pair<String, ? extends Function1<? super Continuation<? super Unit>, ? extends Object>>... r7) {
        Intrinsics.checkNotNullParameter(r7, "taskPairs");
        int r0 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Pair<String, ? extends Function1<? super Continuation<? super Unit>, ? extends Object>> r2 = r7[r1];
        String r3 = (String) r2.component1();
        Function1<Continuation<? super Unit>, Object> r4 = (Function1) r2.component2();
        this.a.put(r3, r4);
        this.c.put(r3, new AtomicReference(a.c.a));
        this.d.put(r3, new CountDownLatch(1));
        this.e.put(r3, new CountDownLatch(1));
        r1 = r1 + 1;
        goto L3
    }

    public final void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskName");
        BuildersKt.runBlocking$default(null, new AsyncTaskManager$runSync$1(this, r3, null), 1, null);
    }

    public final void e(Pair<String, ? extends List<String>>... r6) {
        Intrinsics.checkNotNullParameter(r6, "dependencyPairs");
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Pair<String, ? extends List<String>> r2 = r6[r1];
        String r3 = (String) r2.component1();
        List<String> r4 = (List) r2.component2();
        this.b.put(r3, r4);
        r1 = r1 + 1;
        goto L3
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00cc -> B:52:0x0167). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0121 -> B:19:0x005b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0197 -> B:52:0x0167). Please report as a decompilation issue!!! */
    public final Object a(String r17, Continuation<? super Unit> r18) {
        if ((r18 instanceof AsyncTaskManager$checkAndWaitForDependencies$1) == false) goto L7;
        AsyncTaskManager$checkAndWaitForDependencies$1 r2 = (AsyncTaskManager$checkAndWaitForDependencies$1) r18;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        int r6 = 1;
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L18;
        if (r5 == 2) goto L17;
        if (r5 == 3) goto L18;
        if (r5 == 4) goto L18;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Iterator r7 = (Iterator) r2.L$2;
        String r9 = (String) r2.L$1;
        AsyncTaskManager r11 = (AsyncTaskManager) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L41:
        r2.L$0 = r11;
        r2.L$1 = r9;
        r2.L$2 = r7;
        r2.label = 3;
        if (r11.a(r9, r2) == r4) goto L43;
    L19:
        Iterator r8 = r7;
        String r12 = r9;
    L52:
        r6 = 1;
    L26:
        if (r8.hasNext() == false) goto L63;
        String r13 = (String) r8.next();
        Object r14 = ((LinkedHashMap) r11.c).get(r13);
        Intrinsics.checkNotNull(r14);
        a r15 = (a) ((AtomicReference) r14).get();
        if (Intrinsics.areEqual(r15, a.c.a) == false) goto L33;
        ALogger.i("AsyncTaskManager_Components", "当前检查的是 " + r12 + " ， 它的依赖task是 " + r13 + " ，依赖的task的执行状态是 TaskStatus.NOT_STARTED(未开始)");
        r2.L$0 = r11;
        r2.L$1 = r12;
        r2.L$2 = r8;
        r2.label = r6;
        if (r11.d(r13, r2) != r4) goto L52;
        return r4;
    L33:
        if (Intrinsics.areEqual(r15, a.e.a) == false) goto L45;
        ALogger.i("AsyncTaskManager_Components", "当前检查的是 " + r12 + " ， 它的依赖task是 " + r13 + " ，依赖的task的执行状态是 TaskStatus.SCHEDULED(正在调度中)");
        r2.L$0 = r11;
        r2.L$1 = r12;
        r2.L$2 = r8;
        r2.label = 2;
        Object r16 = BuildersKt.withContext(Dispatchers.getIO(), new AsyncTaskManager$waitForTaskExecutionStart$2(r11, r13, null), r2);
        if (r16 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L38;
        r16 = Unit.INSTANCE;
    L38:
        if (r16 != r4) goto L40;
        return r4;
    L40:
        r9 = r12;
        r7 = r8;
        goto L41
    L45:
        if (Intrinsics.areEqual(r15, a.d.a) == false) goto L54;
        ALogger.i("AsyncTaskManager_Components", "当前检查的是 " + r12 + " ， 它的依赖task是 " + r13 + " ，依赖的task的执行状态是 TaskStatus.RUNNING(正在执行中)");
        r2.L$0 = r11;
        r2.L$1 = r12;
        r2.L$2 = r8;
        r2.label = 4;
        Object r19 = BuildersKt.withContext(Dispatchers.getIO(), new AsyncTaskManager$waitForTaskCompletion$2(r11, r13, null), r2);
        if (r19 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L50;
        if (r19 != r4) goto L52;
        goto L52
    L50:
        if (Unit.INSTANCE != r4) goto L52;
        return r4;
    L54:
        if ((r15 instanceof a.b) == false) goto L61;
        ALogger.i("AsyncTaskManager_Components", "当前检查的是 " + r12 + " ， 它的依赖task是 " + r13 + " ，依赖的task的执行状态是 TaskStatus.FAILED(存在异常)");
        if (r15 != null) goto L60;
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.componentx.schedule.AsyncTaskManager.TaskStatus.FAILED");
    L60:
        throw ((a.b) r15).a;
    L61:
        ALogger.i("AsyncTaskManager_Components", "当前检查的是 " + r12 + " ， 它的依赖task是 " + r13 + " ，依赖的task的执行状态是 TaskStatus.COMPLETED(已完成)");
        goto L52
    L63:
        return Unit.INSTANCE;
    L43:
        return r4;
    L18:
        r7 = (Iterator) r2.L$2;
        r9 = (String) r2.L$1;
        r11 = (AsyncTaskManager) r2.L$0;
        ResultKt.throwOnFailure(r1);
        goto L19
    L20:
        ResultKt.throwOnFailure(r1);
        r12 = r17;
        List r21 = (List) ((LinkedHashMap) this.b).get(r12);
        if (r21 == null) goto L23;
        r8 = r21.iterator();
        r11 = this;
        goto L26
    L23:
        return Unit.INSTANCE;
    L7:
        r2 = new AsyncTaskManager$checkAndWaitForDependencies$1(this, r18);
        goto L8
    }

    public final Object d(String r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof AsyncTaskManager$runSyncInternal$1) == false) goto L7;
        AsyncTaskManager$runSyncInternal$1 r0 = (AsyncTaskManager$runSyncInternal$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L26;
        if (r3 == 1) goto L25;
        if (r3 == 2) goto L24;
        if (r3 == 3) goto L23;
        if (r3 == 4) goto L22;
        if (r3 != 5) goto L21;
        r11 = (String) r0.L$1;
        AsyncTaskManager r4 = (AsyncTaskManager) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L18
    L65:
        Object r14 = ((LinkedHashMap) r4.c).get(r11);     // Catch: Exception -> L18
        Intrinsics.checkNotNull(r14);     // Catch: Exception -> L18
        ((AtomicReference) r14).set(a.C0151a.a);     // Catch: Exception -> L18
        Object r15 = ((LinkedHashMap) r4.d).get(r11);     // Catch: Exception -> L18
        Intrinsics.checkNotNull(r15);     // Catch: Exception -> L18
        ((CountDownLatch) r15).countDown();     // Catch: Exception -> L18
    L79:
        return Unit.INSTANCE;
    L18:
        e = e;
        AsyncTaskManager r5 = r4;
    L69:
        Object r6 = ((LinkedHashMap) r5.c).get(r11);
        Intrinsics.checkNotNull(r6);
        ((AtomicReference) r6).set(new a.b(e));
        Object r16 = ((LinkedHashMap) r5.d).get(r11);
        Intrinsics.checkNotNull(r16);
        ((CountDownLatch) r16).countDown();
        throw e;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        Function1 r17 = (Function1) r0.L$2;
        String r7 = (String) r0.L$1;
        r5 = (AsyncTaskManager) r0.L$0;
        ResultKt.throwOnFailure(r13);
        Function1 r18 = r17;
        r11 = r7;
    L60:
        Object r8 = ((LinkedHashMap) r5.c).get(r11);
        Intrinsics.checkNotNull(r8);
        ((AtomicReference) r8).set(a.d.a);
        Object r9 = ((LinkedHashMap) r5.e).get(r11);
        Intrinsics.checkNotNull(r9);
        ((CountDownLatch) r9).countDown();
        r0.L$0 = r5;     // Catch: Exception -> L68
        r0.L$1 = r11;     // Catch: Exception -> L68
        r0.L$2 = null;     // Catch: Exception -> L68
        r0.label = 5;     // Catch: Exception -> L68
        if (r18.invoke(r0) != r2) goto L64;
        return r2;
    L64:
        r4 = r5;
    L68:
        e = e;
        goto L69
    L23:
        ResultKt.throwOnFailure(r13);
        goto L79
    L24:
        r11 = (String) r0.L$1;
        AsyncTaskManager r19 = (AsyncTaskManager) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L51:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
        if (r19.d(r11, r0) != r2) goto L79;
        return r2;
    L25:
        ResultKt.throwOnFailure(r13);
    L41:
        return Unit.INSTANCE;
    L26:
        ResultKt.throwOnFailure(r13);
        r18 = (Function1) ((LinkedHashMap) this.a).get(r11);
        if (r18 == null) goto L81;
        Object r21 = ((LinkedHashMap) this.c).get(r11);
        Intrinsics.checkNotNull(r21);
        a r22 = (a) ((AtomicReference) r21).get();
        if (Intrinsics.areEqual(r22, a.C0151a.a) == false) goto L33;
        return Unit.INSTANCE;
    L33:
        if (Intrinsics.areEqual(r22, a.d.a) == false) goto L43;
        r0.label = 1;
        Object r110 = BuildersKt.withContext(Dispatchers.getIO(), new AsyncTaskManager$waitForTaskCompletion$2(this, r11, null), r0);
        if (r110 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L38;
        r110 = Unit.INSTANCE;
    L38:
        if (r110 != r2) goto L41;
        return r2;
    L43:
        if (Intrinsics.areEqual(r22, a.e.a) == false) goto L55;
        r0.L$0 = this;
        r0.L$1 = r11;
        r0.label = 2;
        Object r111 = BuildersKt.withContext(Dispatchers.getIO(), new AsyncTaskManager$waitForTaskExecutionStart$2(this, r11, null), r0);
        if (r111 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L48;
        r111 = Unit.INSTANCE;
    L48:
        if (r111 != r2) goto L50;
        return r2;
    L50:
        r19 = this;
        goto L51
    L55:
        if (Intrinsics.areEqual(r22, a.c.a) == false) goto L72;
        r0.L$0 = this;
        r0.L$1 = r11;
        r0.L$2 = r18;
        r0.label = 4;
        if (a(r11, r0) != r2) goto L59;
        return r2;
    L59:
        r5 = this;
        goto L60
    L72:
        if ((r22 instanceof a.b) == false) goto L79;
        if (r22 != null) goto L77;
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.componentx.schedule.AsyncTaskManager.TaskStatus.FAILED");
    L77:
        throw ((a.b) r22).a;
    L81:
        throw new IllegalArgumentException("Task " + r11 + " not configured");
    L7:
        r0 = new AsyncTaskManager$runSyncInternal$1(this, r12);
        goto L8
    }
}
