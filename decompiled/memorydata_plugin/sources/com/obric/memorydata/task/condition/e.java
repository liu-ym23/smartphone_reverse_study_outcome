package com.obric.memorydata.task.condition;

import com.bytedance.crash.Ensure;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\fJ\u0014\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016J\u0016\u0010\u0017\u001a\u00020\u000f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u000e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0005J$\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u00052\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0!J\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0005J\b\u0010$\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/memorydata/task/condition/ConditionValidator;", "Lcom/obric/memorydata/task/condition/ConditionChangeListener;", "<init>", "()V", "TAG", "", "conditionMaps", "", "Lcom/obric/memorydata/task/condition/Condition;", "Lcom/obric/memorydata/task/condition/BaseCondition;", "conditionPendingList", "Ljava/util/LinkedHashSet;", "Lcom/obric/memorydata/task/AbsTaskRequest;", "Lkotlin/collections/LinkedHashSet;", "commonPowerSatisfied", "", "Ljava/lang/Boolean;", "strictlyPowerSatisfied", "isSatisfiedOrPending", "taskRequest", "isSatisfiedByConditionName", "conditionName", "", "isSatisfied", "conditions", "seedPowerConditionState", "", "onConditionChange", "condition", "hasTask", "taskName", "removeTask", "retainPredicate", "Lkotlin/Function1;", "removeTaskId", "taskId", "observePowerMetrics", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Condition, b> f12880b;
    private final LinkedHashSet<AbsTaskRequest> c;
    private volatile Boolean d;
    private volatile Boolean e;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12881a = null;

        static {
            int[] r0 = new int[Condition.values().length];
            r0[Condition.COMMON_POWER_CONTROL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Condition.STRICTLY_POWER_CONTROL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f12881a = r0;
        }
    }

    public e() {
        this.f12879a = "ConditionValidator";
        Map<Condition, b> r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(Condition.NETWORK_AVAILABLE, new g()), TuplesKt.to(Condition.NETWORK_WINDOW, new h()), TuplesKt.to(Condition.SCREEN_ON, new j()), TuplesKt.to(Condition.WIFI_CONNECTED, new m()), TuplesKt.to(Condition.SCREEN_OFF, new i()), TuplesKt.to(Condition.TEMPERATURE_LOW_RANGE, AbilityConditionManager.INSTANCE.createTemperatureStateCondition()), TuplesKt.to(Condition.TEMPERATURE_SEVERE_RANGE, AbilityConditionManager.INSTANCE.createTemperatureSevereRangeCondition()), TuplesKt.to(Condition.NOT_IN_POWER_SAVE_MODE, AbilityConditionManager.INSTANCE.createNotInPowerSaveModeCondition()), TuplesKt.to(Condition.POWER_CONNECTED, AbilityConditionManager.INSTANCE.createPowerConnectedCondition()), TuplesKt.to(Condition.BATTERY_MEETS_REQUIREMENT, AbilityConditionManager.INSTANCE.createBatteryMeetsRequirementCondition()), TuplesKt.to(Condition.LIGHT_POWER_CONTROL, com.obric.memorydata.task.condition.vendor.b.f12898a.a(Condition.LIGHT_POWER_CONTROL)), TuplesKt.to(Condition.COMMON_POWER_CONTROL, com.obric.memorydata.task.condition.vendor.b.f12898a.a(Condition.COMMON_POWER_CONTROL)), TuplesKt.to(Condition.MEMORY_EXTRACT_POWER_CONTROL, com.obric.memorydata.task.condition.vendor.b.f12898a.a(Condition.MEMORY_EXTRACT_POWER_CONTROL)), TuplesKt.to(Condition.STRICTLY_POWER_CONTROL, com.obric.memorydata.task.condition.vendor.b.f12898a.a(Condition.STRICTLY_POWER_CONTROL)), TuplesKt.to(Condition.SCREEN_ON_OR_CHARGE, new k()), TuplesKt.to(Condition.BATTERY_BELOW_80_CHARGING_10_MIN, AbilityConditionManager.INSTANCE.createBatteryCharge10MinCondition())});
        this.f12880b = r0;
        this.c = new LinkedHashSet();
        Iterator<Map.Entry<Condition, b>> r1 = r0.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Condition r3 = (Condition) ZeusTransformUtils.preCheckCast(r2.getKey(), Condition.class, "com.obric.memorydata.plugin");
        b r4 = (b) ZeusTransformUtils.preCheckCast(r2.getValue(), b.class, "com.obric.memorydata.plugin");
        r4.b((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin"));
        if (r3 == Condition.MEMORY_EXTRACT_POWER_CONTROL) goto L4;
        r4.b();
        goto L4
    L8:
        a();
        b();
    }

    private final void a() {
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.f12880b.get(Condition.COMMON_POWER_CONTROL), b.class, "com.obric.memorydata.plugin");
        Boolean r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r0.c());
    L6:
        this.d = r2;
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.f12880b.get(Condition.STRICTLY_POWER_CONTROL), b.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r1 = Boolean.valueOf(r3.c());
    L9:
        this.e = r1;
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static /* synthetic */ void a(e r1, String r2, Function1 r3, int r4, Object r5) {
        Function1<? super AbsTaskRequest, Boolean> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = $$Lambda$e$KcqUFSpe6pE9Vb2wsjEXqE9Y8.INSTANCE;
    L5:
        r1.a(r2, r6);
    }

    private static final boolean a(String r0, AbsTaskRequest r1) {
        return Intrinsics.areEqual(r1.getTaskParameter().getUuid().toString(), r0);
    }

    private static final boolean a(String r2, Function1 r3, AbsTaskRequest r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r4.getTaskParameter().getName(), r2) == false) goto L7;
        Intrinsics.checkNotNull(r4);
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5.invoke(r4), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L7;
        return true;
    L7:
        return false;
    }

    private static final boolean a(Function1 r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private final void b() {
        LinkedHashSet<AbsTaskRequest> r0 = this.c;     // Catch: RuntimeException -> L14
        monitor-enter(r0);     // Catch: RuntimeException -> L14
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        Iterator r3 = r1.iterator();     // Catch: Throwable -> L11
    L6:
        if (r3.hasNext() == false) goto L8;
        r2.add(((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r3.next(), AbsTaskRequest.class, "com.obric.memorydata.plugin")).getTaskParameter().getName());     // Catch: Throwable -> L11
        goto L6
    L8:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: RuntimeException -> L14
        com.obric.memorydata.task.metrics.b.f12939a.a(this.d, this.e, (Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin"));     // Catch: RuntimeException -> L14
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L14
    L14:
        e = move-exception;
        RunLog.INSTANCE.error(this.f12879a, "observe power metrics failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private static final boolean b(AbsTaskRequest r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return false;
    }

    private final boolean b(List<? extends Condition> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Map<Condition, b> r0 = this.f12880b;
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<Map.Entry<Condition, b>> r1 = r0.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r11.contains((Condition) ZeusTransformUtils.preCheckCast(r3.getKey(), Condition.class, "com.obric.memorydata.plugin")) == false) goto L4;
        r2.put(r3.getKey(), r3.getValue());
        goto L4
    L8:
        Iterator r12 = ((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L15;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Condition r5 = (Condition) ZeusTransformUtils.preCheckCast(r4.getKey(), Condition.class, "com.obric.memorydata.plugin");
        b r6 = (b) ZeusTransformUtils.preCheckCast(r4.getValue(), b.class, "com.obric.memorydata.plugin");
        if (r6.c() == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12879a, "condition not satisfied: " + r5.name() + ' ' + r5.getValue() + ", unsatisfied detail: " + r6.g(), false, 4, null);
        return false;
    L15:
        return true;
    }

    private static final boolean b(Function1 r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    /* JADX INFO: renamed from: lambda$5_5_ttYL-3xc_ugQCO3PBxRQ0lk, reason: not valid java name */
    public static /* synthetic */ boolean m1186lambda$5_5_ttYL3xc_ugQCO3PBxRQ0lk(String r0, Function1 r1, AbsTaskRequest r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$KcqUFSp-e6p-E9Vb2wsjEXqE9Y8, reason: not valid java name */
    public static /* synthetic */ boolean m1187lambda$KcqUFSpe6pE9Vb2wsjEXqE9Y8(AbsTaskRequest r0) {
        return b(r0);
    }

    public static /* synthetic */ boolean lambda$P5SQP_Nlavqp2T0BmqPrEGEqUEQ(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$YB4qsYzVGKokCbkQmSjaS8NOF9E(Function1 r0, Object r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ boolean lambda$oCF5iQNRCQVAJwKuWgGhtfI3DBs(String r0, AbsTaskRequest r1) {
        return a(r0, r1);
    }

    public final void a(final String r8, Function1<? super AbsTaskRequest, Boolean> r9) {
        final Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "taskName");
        Intrinsics.checkNotNullParameter(r10, "retainPredicate");
        LinkedHashSet<AbsTaskRequest> r0 = this.c;
        monitor-enter(r0);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        Iterator r3 = r1.iterator();     // Catch: Throwable -> L23
    L6:
        if (r3.hasNext() == false) goto L15;
        Object r4 = r3.next();     // Catch: Throwable -> L23
        AbsTaskRequest r5 = (AbsTaskRequest) ZeusTransformUtils.preCheckCast(r4, AbsTaskRequest.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (Intrinsics.areEqual(r5.getTaskParameter().getName(), r8) == true) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == false) goto L6;
        r2.add(r4);     // Catch: Throwable -> L23
        goto L6
    L10:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r10.invoke(r5), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L12;
        r6 = true;
        goto L13
    L15:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L23
    L17:
        if (r7.hasNext() == false) goto L19;
        ((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r7.next(), AbsTaskRequest.class, "com.obric.memorydata.plugin")).setCancelled();     // Catch: Throwable -> L23
        goto L17
    L19:
        LinkedHashSet<AbsTaskRequest> r11 = this.c;     // Catch: Throwable -> L23
        final Function1 r12 = new $$Lambda$e$5_5_ttYL3xc_ugQCO3PBxRQ0lk(r8, r10);     // Catch: Throwable -> L23
        r11.removeIf(new $$Lambda$e$P5SQP_Nlavqp2T0BmqPrEGEqUEQ(r12));     // Catch: Throwable -> L23
        monitor-exit(r0);
        b();
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final boolean a(AbsTaskRequest r10) {
        Intrinsics.checkNotNullParameter(r10, "taskRequest");
        if (b(r10.getTaskParameter().getConditions()) == true) goto L45;
        LinkedHashSet<AbsTaskRequest> r0 = this.c;
        monitor-enter(r0);
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L42
    L7:
        Object r3 = null;
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();     // Catch: Throwable -> L42
        if (Intrinsics.areEqual(((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r2, AbsTaskRequest.class, "com.obric.memorydata.plugin")).getTaskParameter().getName(), r10.getTaskParameter().getName()) == false) goto L7;
    L13:
        AbsTaskRequest r4 = (AbsTaskRequest) ZeusTransformUtils.preCheckCast(r2, AbsTaskRequest.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        if (r4 != null) goto L16;
    L28:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L42
    L30:
        if (r5.hasNext() == false) goto L35;
        Object r6 = r5.next();     // Catch: Throwable -> L42
        if (Intrinsics.areEqual(((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r6, AbsTaskRequest.class, "com.obric.memorydata.plugin")).getTaskParameter().getUuid().toString(), r10.getTaskParameter().getUuid().toString()) == false) goto L30;
        r3 = r6;
    L35:
        if (((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r3, AbsTaskRequest.class, "com.obric.memorydata.plugin")) == null) goto L37;
        RunLog.INSTANCE.warn(this.f12879a, "ignore duplicate " + r10, new Throwable());     // Catch: Throwable -> L42
        Ensure.ensureNotReachHere(new Throwable(), "ConditionValidator: duplicate task id");     // Catch: Throwable -> L42
    L26:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L42
    L39:
        monitor-exit(r0);
        b();
        return false;
    L37:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12879a, "add pending " + r10 + " , total pending size: " + this.c.size(), false, 4, null);     // Catch: Throwable -> L42
        boolean r12 = this.c.add(r10);     // Catch: Throwable -> L42
    L25:
        Boolean.valueOf(r12);     // Catch: Throwable -> L42
        goto L39
    L16:
        if (r10.getTaskParameter().getExistingTaskPolicy() == null) goto L28;
        if (r10.getTaskParameter().getExistingTaskPolicy() != ExistingTaskPolicy.REPLACE_IN_QUEUE) goto L20;
    L27:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12879a, "replace pending " + r10, false, 4, null);     // Catch: Throwable -> L42
        this.c.remove(r4);     // Catch: Throwable -> L42
        r4.cancel();     // Catch: Throwable -> L42
        r12 = this.c.add(r10);     // Catch: Throwable -> L42
        goto L25
    L20:
        if (r10.getTaskParameter().getExistingTaskPolicy() == ExistingTaskPolicy.CANCEL_EXISTING) goto L27;
        if (r10.getTaskParameter().getExistingTaskPolicy() != ExistingTaskPolicy.SINGLE_QUEUE) goto L26;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12879a, "add pending " + r10 + " , total pending size: " + this.c.size(), false, 4, null);     // Catch: Throwable -> L42
        r12 = this.c.add(r10);     // Catch: Throwable -> L42
        goto L25
    L12:
        r2 = null;
    L42:
        th = move-exception;
        throw th;
    L45:
        b();
        return true;
    }

    public final boolean a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "taskName");
        LinkedHashSet<AbsTaskRequest> r0 = this.c;
        monitor-enter(r0);
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        boolean r2 = false;
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L7;
    L9:
        Iterator r7 = r5.iterator();     // Catch: Throwable -> L17
    L10:
        if (r7.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r7.next(), AbsTaskRequest.class, "com.obric.memorydata.plugin")).getTaskParameter().getName(), r6) == false) goto L10;
        r2 = true;
    L15:
        monitor-exit(r0);
        return r2;
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    L17:
        th = move-exception;
        throw th;
    }

    public final boolean a(List<String> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "conditionName");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.f12880b.keySet(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r3 = r1.next();
        if (r9.contains(((Condition) ZeusTransformUtils.preCheckCast(r3, Condition.class, "com.obric.memorydata.plugin")).getValue()) == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        List<? extends Condition> r4 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        if (r4.size() == r9.size()) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12879a, "invalid condition name: " + r9, false, 4, null);
        return false;
    L13:
        return b(r4);
    }

    public final boolean b(final String r7) {
        Intrinsics.checkNotNullParameter(r7, "taskId");
        LinkedHashSet<AbsTaskRequest> r0 = this.c;
        monitor-enter(r0);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Iterator r3 = r1.iterator();     // Catch: Throwable -> L19
    L6:
        if (r3.hasNext() == false) goto L10;
        Object r4 = r3.next();     // Catch: Throwable -> L19
        if (Intrinsics.areEqual(((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r4, AbsTaskRequest.class, "com.obric.memorydata.plugin")).getTaskParameter().getUuid().toString(), r7) == false) goto L6;
        r2.add(r4);     // Catch: Throwable -> L19
        goto L6
    L10:
        List r5 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L19
    L12:
        if (r6.hasNext() == false) goto L14;
        ((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r6.next(), AbsTaskRequest.class, "com.obric.memorydata.plugin")).setCancelled();     // Catch: Throwable -> L19
        goto L12
    L14:
        LinkedHashSet<AbsTaskRequest> r8 = this.c;     // Catch: Throwable -> L19
        final Function1 r9 = new $$Lambda$e$oCF5iQNRCQVAJwKuWgGhtfI3DBs(r7);     // Catch: Throwable -> L19
        r8.removeIf(new $$Lambda$e$YB4qsYzVGKokCbkQmSjaS8NOF9E(r9));     // Catch: Throwable -> L19
        boolean r10 = !((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
        monitor-exit(r0);
        b();
        return r10;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.task.condition.d
    public void onConditionChange(Condition r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "condition");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12879a, "onConditionChange " + r10.name() + " => " + r11, false, 4, null);
        int r12 = a.f12881a[r10.ordinal()];
        if (r12 != 1) goto L5;
        this.d = Boolean.valueOf(r11);
    L9:
        b();
        if (r11 == false) goto L28;
        List r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        LinkedHashSet<AbsTaskRequest> r14 = this.c;
        monitor-enter(r14);
        Iterator<AbsTaskRequest> r0 = this.c.iterator();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r0, "iterator(...)");     // Catch: Throwable -> L25
    L15:
        if (r0.hasNext() == false) goto L19;
        AbsTaskRequest r1 = r0.next();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r1, "next(...)");     // Catch: Throwable -> L25
        AbsTaskRequest r2 = (AbsTaskRequest) ZeusTransformUtils.preCheckCast(r1, AbsTaskRequest.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (b(r2.getTaskParameter().getConditions()) == false) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12879a, "condition satisfied, execute " + r2, false, 4, null);     // Catch: Throwable -> L25
        r0.remove();     // Catch: Throwable -> L25
        r13.add(r2);     // Catch: Throwable -> L25
        goto L15
    L19:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r14);
        b();
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L23:
        if (r9.hasNext() == false) goto L37;
        AbsTaskRequest r15 = (AbsTaskRequest) ZeusTransformUtils.preCheckCast(r9.next(), AbsTaskRequest.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.task.scheduler.b r16 = com.obric.memorydata.task.scheduler.impl.c.f12961a.d();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.obric.memorydata.task.scheduler.impl.TaskManager");
        ((com.obric.memorydata.task.scheduler.impl.c) ZeusTransformUtils.preCheckCast(r16, com.obric.memorydata.task.scheduler.impl.c.class, "com.obric.memorydata.plugin")).e(r15);
        goto L23
    L37:
        return;
    L25:
        th = move-exception;
        throw th;
    L28:
        return;
    L5:
        if (r12 != 2) goto L9;
        this.e = Boolean.valueOf(r11);
        goto L9
    }
}
