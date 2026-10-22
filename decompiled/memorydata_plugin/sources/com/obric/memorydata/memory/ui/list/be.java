package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.task.condition.AbilityConditionManager;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001#\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0018J\u000e\u0010(\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0018J%\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0000¢\u0006\u0002\b/J\u0006\u00100\u001a\u00020&J\u0006\u00101\u001a\u00020&J\b\u00102\u001a\u00020\u000eH\u0002J\b\u00103\u001a\u000204H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0018\u00010 j\u0004\u0018\u0001`!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$¨\u00066"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/ScreenObservationBuildMemoryTipsHelper;", "", "<init>", "()V", "powerSaveModeCondition", "Lcom/obric/memorydata/task/condition/BaseCondition;", "networkConnectedCondition", "Lcom/obric/memorydata/task/condition/NetAvailableCondition;", "wifiConnectedCondition", "Lcom/obric/memorydata/task/condition/WifiConnectedCondition;", "batteryMeetsRequirementCondition", "temperatureCondition", "_pendingBuildObservationMemoryState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/list/TipsData;", "pendingBuildObservationMemoryState", "Lkotlinx/coroutines/flow/StateFlow;", "getPendingBuildObservationMemoryState", "()Lkotlinx/coroutines/flow/StateFlow;", "oldestObservationMaxTimestamp", "", "lastBuildMemoryTimestamp", "Ljava/lang/Long;", "hashBuildMemoryTask", "", "isInit", "refreshOldestObservationCutoff", "bindDate", "Ljava/time/LocalDate;", "isObservationMemoryEnabled", "isCellularEnable", "autoRefreshRunner", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "conditionChangeListener", "com/obric/memorydata/memory/ui/list/ScreenObservationBuildMemoryTipsHelper$conditionChangeListener$1", "Lcom/obric/memorydata/memory/ui/list/ScreenObservationBuildMemoryTipsHelper$conditionChangeListener$1;", "setCellularEnable", "", "isEnable", "setObservationMemoryEnabled", "bind", "date", "viewModel", "Landroidx/lifecycle/ViewModel;", "scope", "Lcom/obric/memorydata/memory/ui/list/ObservationBuildMemoryTipsScope;", "bind$memory_obricRelease", "unBind", "tryRefreshBuildMemoryTips", "getBuildMemoryTips", "getTag", "", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class be {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11227a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.memorydata.task.condition.b f11228b;
    private final com.obric.memorydata.task.condition.g c;
    private final com.obric.memorydata.task.condition.m d;
    private final com.obric.memorydata.task.condition.b e;
    private final com.obric.memorydata.task.condition.b f;
    private final kotlinx.coroutines.flow.ae<bl> g;
    private final kotlinx.coroutines.flow.ar<bl> h;
    private final kotlinx.coroutines.flow.ae<Long> i;
    private Long j;
    private boolean k;
    private boolean l;
    private boolean m;
    private LocalDate n;
    private boolean o;
    private boolean p;
    private Runnable q;
    private final c r;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/ScreenObservationBuildMemoryTipsHelper$Companion;", "", "<init>", "()V", "LONG_TIME_MILLIS", "", "REFRESH_TIME_MILLIS", "", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ be f11229a;

        public b(be r1) {
            this.f11229a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (be.e(this.f11229a) == false) goto L11;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationBuildMemoryTipsHelper", "autoRefreshRunner run", false, 4, null);
            if (be.f(this.f11229a) == false) goto L7;
            be.a(this.f11229a).b(Long.valueOf(System.currentTimeMillis()));
        L7:
            this.f11229a.c();
            Runnable r7 = be.g(this.f11229a);
            if (r7 == null) goto L12;
            GlobalHandlerUtil.Companion.getInstance().postDelay(60000, r7);
            return;
        L12:
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/list/ScreenObservationBuildMemoryTipsHelper$conditionChangeListener$1", "Lcom/obric/memorydata/task/condition/ConditionChangeListener;", "onConditionChange", "", "condition", "Lcom/obric/memorydata/task/condition/Condition;", "isSatisfied", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements com.obric.memorydata.task.condition.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ be f11230a;

        c(be r1) {
            this.f11230a = r1;
        }

        @Override // com.obric.memorydata.task.condition.d
        public void onConditionChange(Condition r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "condition");
            this.f11230a.c();
        }
    }

    static {
        f11227a = new a(null);
    }

    public be() {
        this.f11228b = AbilityConditionManager.INSTANCE.createNotInPowerSaveModeCondition();
        this.c = new com.obric.memorydata.task.condition.g();
        this.d = new com.obric.memorydata.task.condition.m();
        this.e = AbilityConditionManager.INSTANCE.createBatteryMeetsRequirementCondition();
        this.f = AbilityConditionManager.INSTANCE.createTemperatureStateCondition();
        kotlinx.coroutines.flow.ae<bl> r0 = kotlinx.coroutines.flow.at.a(null);
        this.g = r0;
        this.h = (kotlinx.coroutines.flow.ar) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.flow.ar.class, "com.obric.memorydata.plugin");
        this.i = kotlinx.coroutines.flow.at.a(0L);
        this.r = new c(this);
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ae a(be r0) {
        return r0.i;
    }

    public static final /* synthetic */ void a(be r0, Long r1) {
        r0.j = r1;
    }

    public static final /* synthetic */ void a(be r0, boolean r1) {
        r0.k = r1;
    }

    public static final /* synthetic */ String b(be r0) {
        return r0.e();
    }

    public static final /* synthetic */ Long c(be r0) {
        return r0.j;
    }

    private final bl d() {
        long r0 = System.currentTimeMillis();
        Long r2 = this.j;
        LocalDate r3 = LocalDate.now();
        LocalDate r4 = this.n;
        if (r2 != null) goto L5;
    L38:
        if (r4 != null) goto L40;
    L51:
        String r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_no_data_empty_title, TypedValues.Custom.S_STRING, "recommend_memory_general_no_data_empty_title"));
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
        return new bl(r1, "", false);
    L40:
        if (r4.compareTo((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r3, ChronoLocalDate.class, "com.obric.memorydata.plugin")) <= 0) goto L44;
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_no_data_title, TypedValues.Custom.S_STRING, "recommend_memory_general_no_data_title"));
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        String r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_no_data_empty_description_in_the_feature, TypedValues.Custom.S_STRING, "recommend_memory_general_no_data_empty_description_in_the_feature"));
        Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");
        return new bl(r5, r6, false);
    L44:
        if (Intrinsics.areEqual(r4, r3) == false) goto L51;
        if (this.o == false) goto L49;
        String r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_no_data_title, TypedValues.Custom.S_STRING, "recommend_memory_general_no_data_title"));
        Intrinsics.checkNotNullExpressionValue(r7, "getString(...)");
        String r8 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_generation_queued_other, TypedValues.Custom.S_STRING, "memory_generation_queued_other"));
        Intrinsics.checkNotNullExpressionValue(r8, "getString(...)");
        return new bl(r7, r8, false);
    L49:
        String r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_no_data_title, TypedValues.Custom.S_STRING, "recommend_memory_general_no_data_title"));
        Intrinsics.checkNotNullExpressionValue(r9, "getString(...)");
        String r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_no_data_empty_description_in_the_feature, TypedValues.Custom.S_STRING, "recommend_memory_general_no_data_empty_description_in_the_feature"));
        Intrinsics.checkNotNullExpressionValue(r10, "getString(...)");
        return new bl(r9, r10, false);
    L5:
        if (this.k == false) goto L38;
        if (r4 != null) goto L9;
    L12:
        RunLog.INSTANCE.debug(e(), "tryRefreshBuildMemoryTips, currentTimeStamp: " + r0 + ", snapshotLastBuildMemoryTimestamp: " + r2 + ", diff: " + (r0 - r2.longValue()));
        if ((r0 - r2.longValue()) >= 1800000) goto L16;
        String r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_no_data_title, TypedValues.Custom.S_STRING, "recommend_memory_general_no_data_title"));
        Intrinsics.checkNotNullExpressionValue(r11, "getString(...)");
        String r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_generation_queued_other, TypedValues.Custom.S_STRING, "memory_generation_queued_other"));
        Intrinsics.checkNotNullExpressionValue(r12, "getString(...)");
        return new bl(r11, r12, false);
    L16:
        boolean r13 = this.c.c();
        boolean r14 = this.e.c();
        boolean r15 = this.f11228b.c();
        boolean r16 = !this.f.c();
        boolean r17 = this.d.c();
        boolean r18 = this.p;
        if (r18 == false) goto L21;
        if (r13 == true) goto L21;
        String r19 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_no_data_title, TypedValues.Custom.S_STRING, "recommend_memory_general_no_data_title"));
        Intrinsics.checkNotNullExpressionValue(r19, "getString(...)");
        String r20 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_generation_paused_cellular, TypedValues.Custom.S_STRING, "memory_generation_paused_cellular"));
        Intrinsics.checkNotNullExpressionValue(r20, "getString(...)");
        return new bl(r19, r20, true);
    L21:
        if (r18 == true) goto L25;
        if (r17 == true) goto L25;
        String r21 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_no_data_title, TypedValues.Custom.S_STRING, "recommend_memory_general_no_data_title"));
        Intrinsics.checkNotNullExpressionValue(r21, "getString(...)");
        String r22 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_generation_disabled_no_network, TypedValues.Custom.S_STRING, "memory_generation_disabled_no_network"));
        Intrinsics.checkNotNullExpressionValue(r22, "getString(...)");
        return new bl(r21, r22, true);
    L25:
        if (r14 == true) goto L28;
        String r23 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_no_data_title, TypedValues.Custom.S_STRING, "recommend_memory_general_no_data_title"));
        Intrinsics.checkNotNullExpressionValue(r23, "getString(...)");
        String r24 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_generation_paused_low_battery, TypedValues.Custom.S_STRING, "memory_generation_paused_low_battery"));
        Intrinsics.checkNotNullExpressionValue(r24, "getString(...)");
        return new bl(r23, r24, true);
    L28:
        String r25 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_no_data_title, TypedValues.Custom.S_STRING, "recommend_memory_general_no_data_title"));
        Intrinsics.checkNotNullExpressionValue(r25, "getString(...)");
        Context r26 = ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin");
        if (r15 == true) goto L32;
        String r27 = ((Context) ZeusTransformUtils.preCheckCast(r26, Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_generation_paused_power_saving, TypedValues.Custom.S_STRING, "memory_generation_paused_power_saving"));
        Intrinsics.checkNotNullExpressionValue(r27, "getString(...)");
        return new bl(r25, r27, true);
    L32:
        Context r28 = (Context) ZeusTransformUtils.preCheckCast(r26, Context.class, "com.obric.memorydata.plugin");
        if (r16 == false) goto L36;
        String r29 = r28.getString(ZeusTransformUtils.mapRes(R.string.memory_generation_paused_high_temperature, TypedValues.Custom.S_STRING, "memory_generation_paused_high_temperature"));
        Intrinsics.checkNotNullExpressionValue(r29, "getString(...)");
        return new bl(r25, r29, true);
    L36:
        String r30 = r28.getString(ZeusTransformUtils.mapRes(R.string.memory_generation_queued_other, TypedValues.Custom.S_STRING, "memory_generation_queued_other"));
        Intrinsics.checkNotNullExpressionValue(r30, "getString(...)");
        return new bl(r25, r30, true);
    L9:
        if (r4.compareTo((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r3, ChronoLocalDate.class, "com.obric.memorydata.plugin")) <= 0) goto L12;
        String r31 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_no_data_title, TypedValues.Custom.S_STRING, "recommend_memory_general_no_data_title"));
        Intrinsics.checkNotNullExpressionValue(r31, "getString(...)");
        String r32 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_no_data_empty_description_in_the_feature, TypedValues.Custom.S_STRING, "recommend_memory_general_no_data_empty_description_in_the_feature"));
        Intrinsics.checkNotNullExpressionValue(r32, "getString(...)");
        return new bl(r31, r32, false);
    }

    public static final /* synthetic */ boolean d(be r0) {
        return r0.k;
    }

    private final String e() {
        StringBuilder r0 = new StringBuilder().append("ScreenObservationBuildMemoryTipsHelper_");
        Object r2 = this.n;
        if (r2 != null) goto L6;
        r2 = "UNBIND";
    L6:
        return r0.append(r2).toString();
    }

    public static final /* synthetic */ boolean e(be r0) {
        return r0.l;
    }

    public static final /* synthetic */ boolean f(be r0) {
        return r0.m;
    }

    public static final /* synthetic */ Runnable g(be r0) {
        return r0.q;
    }

    public final kotlinx.coroutines.flow.ar<bl> a() {
        return this.h;
    }

    public final void a(LocalDate r20, ViewModel r21, ObservationBuildMemoryTipsScope r22) {
        Intrinsics.checkNotNullParameter(r20, "date");
        Intrinsics.checkNotNullParameter(r21, "viewModel");
        Intrinsics.checkNotNullParameter(r22, "scope");
        if (this.l == false) goto L5;
        return;
    L5:
        this.l = true;
        this.q = (Runnable) ZeusTransformUtils.preCheckCast(new b(this), Runnable.class, "com.obric.memorydata.plugin");
        this.n = r20;
        this.m = r22.getRefreshOldestObservationCutoff();
        this.i.b(Long.valueOf(System.currentTimeMillis()));
        this.f11228b.b();
        this.c.b();
        this.e.b();
        this.f.b();
        this.d.b();
        this.f11228b.b((com.obric.memorydata.task.condition.d) ZeusTransformUtils.preCheckCast(this.r, com.obric.memorydata.task.condition.d.class, "com.obric.memorydata.plugin"));
        this.c.b((com.obric.memorydata.task.condition.d) ZeusTransformUtils.preCheckCast(this.r, com.obric.memorydata.task.condition.d.class, "com.obric.memorydata.plugin"));
        this.e.b((com.obric.memorydata.task.condition.d) ZeusTransformUtils.preCheckCast(this.r, com.obric.memorydata.task.condition.d.class, "com.obric.memorydata.plugin"));
        this.f.b((com.obric.memorydata.task.condition.d) ZeusTransformUtils.preCheckCast(this.r, com.obric.memorydata.task.condition.d.class, "com.obric.memorydata.plugin"));
        this.d.b((com.obric.memorydata.task.condition.d) ZeusTransformUtils.preCheckCast(this.r, com.obric.memorydata.task.condition.d.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope(r21), (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new ScreenObservationBuildMemoryTipsHelper$bind$2(this, r22, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope(r21), (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new ScreenObservationBuildMemoryTipsHelper$bind$3(r20, r22, this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        Runnable r0 = this.q;
        if (r0 == null) goto L9;
        GlobalHandlerUtil.Companion.getInstance().postDelay(60000, r0);
        return;
    }

    public final void a(boolean r6) {
        boolean r0 = this.p;
        if (r0 != r6) goto L5;
        return;
    L5:
        RunLog.INSTANCE.debug(e(), "setCellularEnable, oldStatus: " + r0 + ", isEnable: " + r6);
        this.p = r6;
        c();
    }

    public final void b() {
        if (this.l == true) goto L5;
        return;
    L5:
        this.n = null;
        this.m = false;
        com.obric.memorydata.task.condition.b r2 = this.f11228b;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.memorydata.ability.condition.NotInPowerSaveModeCondition");
        ((com.obric.memorydata.ability.condition.d) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.ability.condition.d.class, "com.obric.memorydata.plugin")).d();
        this.c.a();
        this.d.a();
        com.obric.memorydata.task.condition.b r3 = this.e;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.memorydata.ability.condition.BatteryMeetsRequirementCondition");
        ((com.obric.memorydata.ability.condition.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.ability.condition.c.class, "com.obric.memorydata.plugin")).d();
        com.obric.memorydata.task.condition.b r4 = this.f;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.obric.memorydata.ability.condition.TemperatureStateCondition");
        ((com.obric.memorydata.ability.condition.f) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.ability.condition.f.class, "com.obric.memorydata.plugin")).d();
        this.l = false;
        Runnable r1 = this.q;
        if (r1 == null) goto L8;
        GlobalHandlerUtil.Companion.getInstance().removeCallbacks(r1);
    L8:
        this.q = null;
    }

    public final void b(boolean r1) {
        this.o = r1;
    }

    public final void c() {
        if (this.l == true) goto L5;
        return;
    L5:
        bl r0 = d();
        RunLog.INSTANCE.debug(e(), "tryRefreshBuildMemoryTips, newTips: " + r0 + ", lastTips: " + this.g.c());
        if (Intrinsics.areEqual(r0, this.g.c()) == false) goto L8;
        return;
    L8:
        this.g.b(r0);
    }
}
