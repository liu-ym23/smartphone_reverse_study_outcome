package com.obric.memorydata.init.tasks;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.SemanticMigrationPhase;
import com.obric.memorydata.database.manager.q;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.f;
import com.obric.memorydata.task.impl.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001(\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\bJ\u0010\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\bJ4\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\bH\u0002J%\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b!J\u0017\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u0019\u001a\u00020\u0005H\u0000¢\u0006\u0002\b$J\u0015\u0010%\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0000¢\u0006\u0002\b&J%\u0010'\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010)\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010*J \u0010+\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010)\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J%\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u001bH\u0000¢\u0006\u0002\b0J\u0015\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020#H\u0000¢\u0006\u0002\b3R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u00064"}, d2 = {"Lcom/obric/memorydata/init/tasks/SemanticConsolidationScheduler;", "", "<init>", "()V", "LAST_COMPLETED_DAY_KEY", "", "LAST_SCREEN_DAY_KEY", "INITIAL_DELAY_SECONDS", "", "inFlight", "", "Lkotlin/Pair;", "Lcom/obric/memorydata/middleware/api/store/IStore;", "rerunRequested", "", "businessIds", "", "getBusinessIds$memory_obricRelease", "()Ljava/util/List;", "onScreenAvailable", "", "todayEpochDay", "onMigrationUnblocked", "enqueueIfEligible", "store", "businessId", "force", "", "delaySeconds", "shouldEnqueue", "lastCompletedEpochDay", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/obric/memorydata/database/manager/SemanticMigrationPhase;", "shouldEnqueue$memory_obricRelease", "buildInputParams", "Lorg/json/JSONObject;", "buildInputParams$memory_obricRelease", "completedDayKey", "completedDayKey$memory_obricRelease", "completionCallback", "com/obric/memorydata/init/tasks/SemanticConsolidationScheduler$completionCallback$1", "epochDay", "(Lcom/obric/memorydata/middleware/api/store/IStore;JLjava/lang/String;)Lcom/obric/memorydata/init/tasks/SemanticConsolidationScheduler$completionCallback$1;", "clearInFlight", "isTerminalChainSuccess", "state", "Lcom/obric/memorydata/task/impl/TaskInfo$State;", "hasContinuation", "isTerminalChainSuccess$memory_obricRelease", "businessIdFromOutput", "output", "businessIdFromOutput$memory_obricRelease", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f9922a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Pair<IStore, Long>> f9923b = null;
    private static final Set<String> c = null;
    private static final List<String> d = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/init/tasks/SemanticConsolidationScheduler$completionCallback$1", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IStore f9925b;
        final /* synthetic */ long c;

        a(String r3, IStore r4, long r5) {
            IStore r6 = (IStore) ZeusTransformUtils.wrapperContextForParams(r4, IStore.class, "com.obric.memorydata.plugin");
            this.f9924a = r3;
            this.f9925b = r6;
            this.c = r5;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r19) {
            Intrinsics.checkNotNullParameter(r19, "taskInfo");
            if (r19.c().isFinished() == true) goto L5;
            return;
        L5:
            e r1 = e.f9922a;
            String r6 = this.f9924a;
            IStore r3 = this.f9925b;
            long r4 = this.c;
            monitor-enter(r1);
            Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r19.e().getNextTaskRequestList(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
            if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L10;
        L12:
            Iterator r2 = r0.iterator();     // Catch: Throwable -> L54
        L14:
            if (r2.hasNext() == false) goto L18;
            if (Intrinsics.areEqual(((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r2.next(), AbsTaskRequest.class, "com.obric.memorydata.plugin")).getTaskParameter().getInputParams().optString("business_id"), r6) == false) goto L14;
            boolean r5 = true;
        L19:
            String r7 = e.f9922a.a(r19.d());     // Catch: Throwable -> L54
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L22;
            boolean r10 = true;
        L23:
            if (r10 == true) goto L25;
        L28:
            if (r5 == true) goto L51;
            e.a(e.f9922a, r3, r4, r6);     // Catch: Throwable -> L54
            boolean r8 = e.b().remove(r6);     // Catch: Throwable -> L54
            if (e.f9922a.a(r19.c(), r7, false) == true) goto L32;
        L47:
            if (r8 == false) goto L49;
        L50:
            e.a(e.f9922a, r3, r4, r6, true, 60);     // Catch: Throwable -> L54
            goto L51
        L49:
            if (r19.c() != TaskInfo.State.FAILED) goto L51;
        L32:
            if (r19.d().optBoolean("scheduling_blocked") == true) goto L47;
            if (r8 == true) goto L36;
            r3.save(e.f9922a.b(r6), r4);     // Catch: Throwable -> L54
        L36:
            if (Intrinsics.areEqual(r6, "semantic_consolidation") == false) goto L47;
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(e.f9922a.a(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
            Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
            Iterator r12 = r9.iterator();     // Catch: Throwable -> L54
        L39:
            if (r12.hasNext() == false) goto L43;
            Object r13 = r12.next();     // Catch: Throwable -> L54
            if ((!Intrinsics.areEqual((String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin"), r6)) == false) goto L39;
            r11.add(r13);     // Catch: Throwable -> L54
            goto L39
        L43:
            Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L54
        L45:
            if (r17.hasNext() == false) goto L47;
            e.a(e.f9922a, r3, r4, (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin"), true, 0, 16, null);     // Catch: Throwable -> L54
        L51:
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L54
            monitor-exit(r1);
            return;
        L25:
            if (Intrinsics.areEqual(r7, r6) == true) goto L28;
            monitor-exit(r1);
            return;
        L22:
            r10 = false;
        L18:
            r5 = false;
            goto L19
        L10:
            if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L12;
        L54:
            th = move-exception;
            throw th;
        }
    }

    static {
        f9922a = new e();
        f9923b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        c = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        d = CollectionsKt.listOf(new String[]{"semantic_consolidation", "user_insight", "interest_summary"});
    }

    private e() {
    }

    private final a a(IStore r2, long r3, String r5) {
        return new a(r5, (IStore) ZeusTransformUtils.wrapperContextForParams(r2, IStore.class, "com.obric.memorydata.plugin"), r3);
    }

    public static /* synthetic */ void a(e r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = LocalDate.now().toEpochDay();
    L5:
        r0.a(r1);
    }

    public static final /* synthetic */ void a(e r2, IStore r3, long r4, String r6) {
        r2.b((IStore) ZeusTransformUtils.wrapperContextForParams(r3, IStore.class, "com.obric.memorydata.plugin"), r4, r6);
    }

    public static final /* synthetic */ void a(e r8, IStore r9, long r10, String r12, boolean r13, long r14) {
        r8.a((IStore) ZeusTransformUtils.wrapperContextForParams(r9, IStore.class, "com.obric.memorydata.plugin"), r10, r12, r13, r14);
    }

    static /* synthetic */ void a(e r9, IStore r10, long r11, String r13, boolean r14, long r15, int r17, Object r18) {
        IStore r2 = (IStore) ZeusTransformUtils.wrapperContextForParams(r10, IStore.class, "com.obric.memorydata.plugin");
        if ((r17 & 8) == 0) goto L5;
        boolean r6 = false;
    L7:
        if ((r17 & 16) == 0) goto L9;
        long r7 = 10;
    L10:
        r9.a(r2, r11, r13, r6, r7);
        return;
    L9:
        r7 = r15;
        goto L10
    L5:
        r6 = r14;
        goto L7
    }

    private final void a(IStore r15, long r16, String r18, boolean r19, long r20) {
        IStore r11 = (IStore) ZeusTransformUtils.wrapperContextForParams(r15, IStore.class, "com.obric.memorydata.plugin");
        SemanticMigrationPhase r12 = SemanticMigrationPhase.Companion.a(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticStateDao().queryText("migration_phase"));
        IStore r13 = null;
        if (r19 == false) goto L10;
        r11.save(b(r18), Long.MIN_VALUE);
        Pair r3 = (Pair) ZeusTransformUtils.preCheckCast(f9923b.get(r18), Pair.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        IStore r4 = (IStore) ZeusTransformUtils.preCheckCast(r3.getFirst(), IStore.class, "com.obric.memorydata.plugin");
    L8:
        if (r4 != r11) goto L10;
        c.add(r18);
        goto L10
    L7:
        r4 = null;
    L10:
        if (r19 == true) goto L14;
        if (a(r11.getLong(b(r18), Long.MIN_VALUE), r16, r12) == true) goto L14;
        return;
    L14:
        if (q.f9592a.a().contains(r12) == true) goto L33;
        Map<String, Pair<IStore, Long>> r1 = f9923b;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r1.get(r18), Pair.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L18;
        r13 = (IStore) ZeusTransformUtils.preCheckCast(r2.getFirst(), IStore.class, "com.obric.memorydata.plugin");
    L18:
        if (r13 == r11) goto L34;
        r1.put(r18, TuplesKt.to(r11, Long.valueOf(r16)));
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L23
        e r0 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("memory_process").setInputParam(r0.a(r18)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setConditions(new Condition[]{Condition.SCREEN_ON_OR_CHARGE, Condition.NETWORK_AVAILABLE, Condition.TEMPERATURE_SEVERE_RANGE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setDelay((g) ZeusTransformUtils.preCheckCast(new f(r20), g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(r0.a(r11, r16, r18), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();     // Catch: Throwable -> L23
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 != null) goto L28;
        return;
    L28:
        f9922a.b(r11, r16, r18);
        throw r7;
    L23:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L25
    L34:
        return;
    }

    public static final /* synthetic */ Set b() {
        return c;
    }

    public static /* synthetic */ void b(e r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = LocalDate.now().toEpochDay();
    L5:
        r0.b(r1);
    }

    private final void b(IStore r6, long r7, String r9) {
        IStore r5 = (IStore) ZeusTransformUtils.wrapperContextForParams(r6, IStore.class, "com.obric.memorydata.plugin");
        Map<String, Pair<IStore, Long>> r8 = f9923b;
        Pair r1 = (Pair) ZeusTransformUtils.preCheckCast(r8.get(r9), Pair.class, "com.obric.memorydata.plugin");
        boolean r2 = true;
        if (r1 != null) goto L5;
    L12:
        r2 = false;
    L13:
        if (r2 == false) goto L16;
        r8.remove(r9);
        return;
    L16:
        return;
    L5:
        if (r1.getFirst() == r5) goto L7;
    L9:
        boolean r10 = false;
    L10:
        if (r10 != true) goto L12;
    L7:
        if (((Number) ZeusTransformUtils.preCheckCast(r1.getSecond(), Number.class, "com.obric.memorydata.plugin")).longValue() != r7) goto L9;
        r10 = true;
        goto L10
    }

    public final String a(JSONObject r1) {
        Intrinsics.checkNotNullParameter(r1, "output");
        JSONObject r0 = r1.optJSONObject("db");
        if (r0 == null) goto L5;
        String r2 = r0.optString("business_id");
    L6:
        if (r2 != null) goto L9;
        return "";
    L9:
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    public final List<String> a() {
        return d;
    }

    public final JSONObject a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "businessId");
        JSONObject r1 = new JSONObject().put("business_id", r2);
        Intrinsics.checkNotNullExpressionValue(r1, "put(...)");
        return r1;
    }

    public final synchronized void a(long r13) {
        monitor-enter(this);
        IStore r0 = StoreManager.INSTANCE.getPersonalStore();     // Catch: Throwable -> L14
        if (r0 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        r0.save("semantic_consolidation_last_screen_epoch_day", r13);     // Catch: Throwable -> L14
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(d, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L14
    L9:
        if (r11.hasNext() == false) goto L12;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        a(f9922a, r0, r13, r5, false, 0, 24, null);     // Catch: Throwable -> L14
        goto L9
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final boolean a(long r1, long r3, SemanticMigrationPhase r5) {
        Intrinsics.checkNotNullParameter(r5, TypedValues.CycleType.S_WAVE_PHASE);
        if (r1 != r3) goto L5;
    L7:
        return false;
    L5:
        if (q.f9592a.a().contains(r5) == true) goto L7;
        return true;
    }

    public final boolean a(TaskInfo.State r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "state");
        Intrinsics.checkNotNullParameter(r2, "businessId");
        if (r1 == TaskInfo.State.SUCCEEDED) goto L5;
    L8:
        return false;
    L5:
        if (d.contains(r2) == false) goto L8;
        if (r3 == true) goto L8;
        return true;
    }

    public final String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "businessId");
        return "semantic_consolidation_last_completed_epoch_day:" + r2;
    }

    public final synchronized void b(long r13) {
        monitor-enter(this);
        IStore r0 = StoreManager.INSTANCE.getPersonalStore();     // Catch: Throwable -> L14
        if (r0 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(d, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L14
    L9:
        if (r11.hasNext() == false) goto L12;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        a(f9922a, r0, r13, r5, true, 0, 16, null);     // Catch: Throwable -> L14
        goto L9
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
