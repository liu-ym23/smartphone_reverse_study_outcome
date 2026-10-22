package com.bytedance.ai.resource;

import android.app.ActivityManager;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import cn.nubia.neopush.commons.Constant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.j0;

/* JADX INFO: loaded from: classes2.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f2766a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.c f2767b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f2768c = null;
    public static final AtomicBoolean d = null;
    public static w e;
    public static final AtomicReference f = null;
    public static final ConcurrentHashMap g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConcurrentHashMap f2769h = null;

    static {
        f2766a = new y();
        f2767b = h0.a(CoroutineContext.Element.DefaultImpls.plus(j0.b(), t2.b.f22089a));
        f2768c = new Object();
        d = new AtomicBoolean(false);
        f = new AtomicReference(new x("NOT_STARTED", null, 14));
        g = new ConcurrentHashMap();
        f2769h = new ConcurrentHashMap();
    }

    public static String b(x r5) {
        StringBuilder r10 = new StringBuilder();
        r10.append(r5.f2763a);
        r10.append(", elapsedMs=");
        r10.append(RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r5.f2764b, 0));
        r10.append(", thread=");
        r10.append(r5.f2765c);
        String r11 = r5.d;
        if (r11 == null) goto L6;
        r10.append(", detail=");
        r10.append(StringsKt.E(r11, '\n', ' '));
    L6:
        return r10.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.bytedance.ai.resource.AppletInitSyncHelper$AppletInitializationTimeoutException, java.lang.Throwable] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void c(int r18, boolean r19) {
        boolean r5 = j.g.isCompleted();
        boolean r10 = j.f.isCompleted();
        boolean r11 = j.f2737h.isCompleted();
        boolean r12 = j.f2738i;
        boolean r13 = j.f2739j;
        StringBuilder r14 = ai.j0.s(r18, "Applet initialization timed out after 10000ms, timeoutCount=", ", pid=");
        r14.append(Process.myPid());
        r14.append(", processName=");
        r14.append(Application.getProcessName());
        r14.append(", geckoCompleted=");
        r14.append(r5);
        r14.append(", initializedCompleted=");
        r14.append(r10);
        r14.append(", restoreRefCountCompleted=");
        r14.append(r11);
        r14.append(", enableGecko=");
        r14.append(r12);
        r14.append(", enableCustom=");
        r14.append(r13);
        if (r19 == false) goto L5;
        r14.append(", clearApplicationUserData failed");
    L5:
        r14.append("\n\n");
        StringBuilder r15 = new StringBuilder("=== Applet initialization chain ===\n");
        StringBuilder r16 = new StringBuilder("current=");
        AtomicReference r17 = f;
        r16.append(b((x) r17.get()));
        r15.append(r16.toString());
        r15.append('\n');
        ConcurrentHashMap r20 = f2769h;
        LinkedHashMap r21 = new LinkedHashMap();
        Iterator r22 = r20.entrySet().iterator();
    L7:
        if (r22.hasNext() == false) goto L14;
        Map.Entry r23 = (Map.Entry) r22.next();
        x r24 = (x) r23.getValue();
        if (Intrinsics.areEqual(r24.f2763a, "ALREADY_INSTALLED") == true) goto L7;
        if (Intrinsics.areEqual(r24.f2763a, "CALLBACK_SUCCEEDED") == true) goto L7;
        r21.put(r23.getKey(), r23.getValue());
        goto L7
    L14:
        r15.append("builtInPackages(total=" + r20.size() + ", succeeded=" + (r20.size() - r21.size()) + ", incompleteOrFailed=" + r21.size() + "):");
        r15.append('\n');
        if (r21.isEmpty() == false) goto L17;
        r15.append("  <none>\n");
    L22:
        ConcurrentHashMap r25 = g;
        LinkedHashMap r110 = new LinkedHashMap();
        Iterator r111 = r25.entrySet().iterator();
    L24:
        if (r111.hasNext() == false) goto L52;
        Map.Entry r112 = (Map.Entry) r111.next();
        String r113 = (String) r112.getKey();
        x r26 = (x) r112.getValue();
        Iterator r114 = r111;
        String r115 = StringsKt.U(r113, ':');
        int r116 = r115.hashCode();
        StringBuilder r117 = r14;
        if (r116 == 130625071) goto L46;
        if (r116 == 1427818632) goto L43;
        if (r116 == 1662702951) goto L39;
        if (r116 == 1957569947) goto L35;
    L47:
        boolean r118 = false;
    L49:
        if (r118 == true) goto L51;
        r110.put(r112.getKey(), r112.getValue());
    L51:
        r111 = r114;
        r14 = r117;
        goto L24
    L35:
        if (r115.equals("install") == false) goto L47;
        r118 = Intrinsics.areEqual(r26.f2763a, "INSERT_PACKAGE_TO_DB_COMPLETE");
        goto L49
    L39:
        if (r115.equals("operation") == false) goto L47;
        r118 = Intrinsics.areEqual(r26.f2763a, "SUCCEEDED");
        goto L49
    L43:
        if (r115.equals("download") == false) goto L47;
    L48:
        r118 = Intrinsics.areEqual(r26.f2763a, "READY");
        goto L49
    L46:
        if (r115.equals("manifest") == true) goto L48;
    L52:
        StringBuilder r119 = r14;
        r15.append("packageTasks(total=" + r25.size() + ", succeeded=" + (r25.size() - r110.size()) + ", incompleteOrFailed=" + r110.size() + "):");
        r15.append('\n');
        if (r110.isEmpty() == false) goto L55;
        r15.append("  <none>\n");
    L60:
        r15.append("packageManager:\n");
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L63
        Object r28 = Result.m124constructorimpl(r.i());     // Catch: Throwable -> L63
    L65:
        Throwable r29 = Result.m127exceptionOrNullimpl(r28);
        if (r29 == null) goto L69;
        r28 = "  <snapshot failed: " + r29.getClass().getSimpleName() + ": " + r29.getMessage() + Typography.greater;
    L69:
        r15.append((String) r28);
        r15.append('\n');
        Map<Thread, StackTraceElement[]> r30 = Thread.getAllStackTraces();
        String r31 = ((x) r17.get()).f2765c;
        Iterator<T> r32 = r30.entrySet().iterator();
    L71:
        if (r32.hasNext() == false) goto L75;
        Object r33 = r32.next();
        if (Intrinsics.areEqual(((Thread) ((Map.Entry) r33).getKey()).getName(), r31) == false) goto L71;
    L76:
        Map.Entry r34 = (Map.Entry) r33;
        Set r35 = SetsKt.createSetBuilder();
        Iterator r36 = r21.values().iterator();
    L78:
        if (r36.hasNext() == false) goto L80;
        r35.add(((x) r36.next()).f2765c);
        goto L78
    L80:
        Iterator r37 = r110.values().iterator();
    L82:
        if (r37.hasNext() == false) goto L84;
        r35.add(((x) r37.next()).f2765c);
        goto L82
    L84:
        Set r38 = SetsKt.build(r35);
        Set<Map.Entry<Thread, StackTraceElement[]>> r39 = r30.entrySet();
        ArrayList r40 = new ArrayList();
        Iterator<T> r41 = r39.iterator();
    L86:
        if (r41.hasNext() == false) goto L117;
        Object r42 = r41.next();
        Map.Entry r43 = (Map.Entry) r42;
        Thread r44 = (Thread) r43.getKey();
        StackTraceElement[] r45 = (StackTraceElement[]) r43.getValue();
        if (Intrinsics.areEqual(r44.getName(), r31) == true) goto L86;
        Intrinsics.checkNotNull(r44);
        Intrinsics.checkNotNull(r45);
        if (StringsKt.P(r44.getName(), "APPLET-IO-") == false) goto L105;
        int r120 = r45.length;
        int r121 = 0;
    L92:
        if (r121 >= r120) goto L105;
        StackTraceElement r122 = r45[r121];
        if (Intrinsics.areEqual(r122.getClassName(), "java.util.concurrent.ThreadPoolExecutor") == false) goto L103;
        if (Intrinsics.areEqual(r122.getMethodName(), "getTask") == false) goto L103;
        int r123 = r45.length;
        int r124 = 0;
    L98:
        if (r124 >= r123) goto L86;
        if (StringsKt.P(r45[r124].getClassName(), "com.bytedance.ai.resource") == true) goto L105;
        r124 = r124 + 1;
    L103:
        r121 = r121 + 1;
    L105:
        if (r38.contains(r44.getName()) == true) goto L116;
        if (r44 == Looper.getMainLooper().getThread()) goto L116;
        int r46 = r45.length;
        int r125 = 0;
    L109:
        if (r125 >= r46) goto L86;
        StackTraceElement r126 = r45[r125];
        if (StringsKt.P(r126.getClassName(), "com.bytedance.ai.resource") == true) goto L116;
        if (StringsKt.P(r126.getClassName(), "com.bytedance.ai.infra.thread_pool") == true) goto L116;
        r125 = r125 + 1;
    L116:
        r40.add(r42);
        goto L86
    L117:
        List r47 = CollectionsKt.E(CollectionsKt.sortedWith(r40, new ca.d(2)));
        StringBuilder r48 = ai.j0.u("initializationThread:\n");
        if (r34 != null) goto L120;
        r48.append("  <" + r31 + " not found>");
        r48.append('\n');
    L121:
        r48.append("additionalRelevantThreads(count=" + r47.size() + "):");
        r48.append('\n');
        Iterator r49 = r47.iterator();
    L123:
        if (r49.hasNext() == false) goto L125;
        Map.Entry r50 = (Map.Entry) r49.next();
        Thread r51 = (Thread) r50.getKey();
        StackTraceElement[] r52 = (StackTraceElement[]) r50.getValue();
        Intrinsics.checkNotNull(r51);
        Intrinsics.checkNotNull(r52);
        f(r48, r51, (StackTraceElement[]) ArraysKt.o(r52).toArray(new StackTraceElement[0]));
        goto L123
    L125:
        r15.append(r48.toString());
        r119.append(r15.toString());
        final String r53 = r119.toString();
        final ?? r54 = new AppletInitSyncHelper$AppletInitializationTimeoutException(r53);
        Intrinsics.checkNotNullParameter("AppletInitSyncHelper", "tag");
        t0.d r55 = com.bytedance.ai.utils.c.f2846a;
        if (r55 == 0) goto L128;
        r55.e("AppletInitSyncHelper", "Applet initialization timeout", r54);
    L128:
        new Handler(Looper.getMainLooper()).post(new v(r54));
        ThreadsKt.thread$default(false, true, null, "applet-init-crash-fallback", 0, new a3.f(13), 21, null);
        return;
    L120:
        f(r48, (Thread) r34.getKey(), (StackTraceElement[]) r34.getValue());
        Unit r56 = Unit.INSTANCE;
        goto L121
    L75:
        r33 = null;
    L63:
        th = move-exception;
        Result.Companion r57 = Result.Companion;
        r28 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L65
    L55:
        Iterator r58 = MapsKt.toSortedMap(r110).entrySet().iterator();
    L57:
        if (r58.hasNext() == false) goto L59;
        Map.Entry r59 = (Map.Entry) r58.next();
        String r60 = (String) r59.getKey();
        x r61 = (x) r59.getValue();
        StringBuilder r62 = new StringBuilder("  ");
        r62.append(r60);
        r62.append(" -> ");
        Intrinsics.checkNotNull(r61);
        r62.append(b(r61));
        r15.append(r62.toString());
        r15.append('\n');
        goto L57
    L59:
        Unit r63 = Unit.INSTANCE;
        goto L60
    L17:
        Iterator r64 = MapsKt.toSortedMap(r21).entrySet().iterator();
    L19:
        if (r64.hasNext() == false) goto L21;
        Map.Entry r127 = (Map.Entry) r64.next();
        String r128 = (String) r127.getKey();
        x r129 = (x) r127.getValue();
        StringBuilder r130 = new StringBuilder("  ");
        r130.append(r128);
        r130.append(" -> ");
        Intrinsics.checkNotNull(r129);
        r130.append(b(r129));
        r15.append(r130.toString());
        r15.append('\n');
        goto L19
    L21:
        Unit r65 = Unit.INSTANCE;
        goto L22
    }

    public static void d(String r5, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        Intrinsics.checkNotNullParameter(r10, Constant.APPID);
        Intrinsics.checkNotNullParameter(r11, "stage");
        f2769h.put(androidx.constraintlayout.motion.widget.a.m(r5, '/', r10), new x(r11, r12, 6));
    }

    public static void e(String r5, String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        Intrinsics.checkNotNullParameter(r10, Constant.APPID);
        Intrinsics.checkNotNullParameter(r11, "task");
        Intrinsics.checkNotNullParameter(r12, "stage");
        g.put(r5 + '/' + r10 + ':' + r11, new x(r12, r13, 6));
    }

    public static void f(StringBuilder r5, Thread r10, StackTraceElement[] r11) {
        r5.append(Typography.quote);
        r5.append(r10.getName());
        r5.append("\" id=");
        r5.append(r10.getId());
        r5.append(" state=");
        r5.append(r10.getState());
        r5.append('\n');
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r5.append("  at " + r11[r13]);
        r5.append('\n');
        r13 = r13 + 1;
        goto L3
    }

    public final Object a(ContinuationImpl r15) {
        if ((r15 instanceof AppletInitSyncHelper$ensureInitialize$1) == false) goto L7;
        AppletInitSyncHelper$ensureInitialize$1 r5 = (AppletInitSyncHelper$ensureInitialize$1) r15;
        int r10 = r5.e;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.e = r10 - Integer.MIN_VALUE;
    L8:
        Object r16 = r5.f2542c;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r5.e;
        if (r12 == 0) goto L16;
        if (r12 == 1) goto L15;
        if (r12 != 2) goto L13;
        ResultKt.throwOnFailure(r16);
    L77:
        throw new KotlinNothingValueException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        w r14 = (w) r5.f2541b;
        y r13 = r5.f2540a;
        ResultKt.throwOnFailure(r16);
    L41:
        if (Intrinsics.areEqual(r16, Boxing.boxBoolean(true)) == false) goto L60;
        r13.getClass();
        Object r17 = f2768c;
        monitor-enter(r17);
    L47:
        th = move-exception;
        throw th;
    L45:
        if (e != r14) goto L49;
        e = null;     // Catch: Throwable -> L47
    L49:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L47
        monitor-exit(r17);
        if (d.compareAndSet(false, true) == false) goto L56;
        s0.c.a().createDeviceProtectedStorageContext().getSharedPreferences("applet_init_sync_helper", 0).edit().remove("init_timeout_exit_count").remove("last_exit_due_to_init_timeout").apply();
    L56:
        return Unit.INSTANCE;
    L60:
        if (r14.f2762b.compareAndSet(false, true) == false) goto L73;
        r13.getClass();
        SharedPreferences r19 = s0.c.a().createDeviceProtectedStorageContext().getSharedPreferences("applet_init_sync_helper", 0);
        int r110 = r19.getInt("init_timeout_exit_count", 0) + 1;
        String r111 = "Applet initialization timed out. timeoutCount=" + r110 + ", persisted=" + r19.edit().putInt("init_timeout_exit_count", r110).putBoolean("last_exit_due_to_init_timeout", true).commit();
        Intrinsics.checkNotNullParameter("AppletInitSyncHelper", "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L65;
        r20.e("AppletInitSyncHelper", r111);
    L65:
        if (r110 < 3) goto L72;
        ActivityManager r112 = (ActivityManager) s0.c.a().getSystemService(ActivityManager.class);
        if (r112 != null) goto L69;
    L71:
        c(r110, true);
        goto L73
    L69:
        if (r112.clearApplicationUserData() != true) goto L71;
    L72:
        c(r110, false);
    L73:
        r5.f2540a = null;
        r5.f2541b = null;
        r5.e = 2;
        if (DelayKt.awaitCancellation(r5) != r11) goto L77;
    L75:
        return r11;
    L16:
        ResultKt.throwOnFailure(r16);
        if (j.g.isCompleted() == true) goto L19;
    L28:
        Object r113 = f2768c;
        monitor-enter(r113);
        w r21 = e;     // Catch: Throwable -> L78
        if (r21 == null) goto L34;
        monitor-exit(r113);
    L36:
        Duration.Companion r114 = Duration.Companion;
        long r22 = DurationKt.toDuration(10000, DurationUnit.MILLISECONDS);
        AppletInitSyncHelper$ensureInitialize$completed$1 r115 = new AppletInitSyncHelper$ensureInitialize$completed$1(r21, null);
        r5.f2540a = this;
        r5.f2541b = r21;
        r5.e = 1;
        r16 = e2.b(DelayKt.m1627toDelayMillisLRDsOJo(r22), r115, r5);
        if (r16 == r11) goto L75;
        w r116 = r21;
        r13 = this;
        r14 = r116;
        goto L41
    L34:
        r21 = new w(BuildersKt.async$default(f2767b, null, null, new AppletInitSyncHelper$getOrCreateAttempt$1$2(null), 3, null));     // Catch: Throwable -> L78
        e = r21;     // Catch: Throwable -> L78
        monitor-exit(r113);
    L78:
        th = move-exception;
        throw th;
    L19:
        if (j.f.isCompleted() == false) goto L28;
        if (j.f2737h.isCompleted() == false) goto L28;
        if (d.compareAndSet(false, true) == false) goto L27;
        s0.c.a().createDeviceProtectedStorageContext().getSharedPreferences("applet_init_sync_helper", 0).edit().remove("init_timeout_exit_count").remove("last_exit_due_to_init_timeout").apply();
    L27:
        return Unit.INSTANCE;
    L7:
        r5 = new AppletInitSyncHelper$ensureInitialize$1(this, r15);
        goto L8
    }
}
