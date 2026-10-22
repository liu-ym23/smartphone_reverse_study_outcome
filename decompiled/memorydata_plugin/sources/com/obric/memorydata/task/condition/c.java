package com.obric.memorydata.task.condition;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.api.PersonalContextAPI;
import com.obric.memorydata.utils.handler.GlobalMainHandler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/task/condition/CommonPowerControlCondition;", "Lcom/obric/memorydata/task/condition/BaseCondition;", "Lcom/obric/memorydata/task/condition/ConditionChangeListener;", "conditionEnum", "Lcom/obric/memorydata/task/condition/Condition;", LocationMonitorConst.TAG, "", "<init>", "(Lcom/obric/memorydata/task/condition/Condition;Ljava/lang/String;)V", "getConditionEnum", "()Lcom/obric/memorydata/task/condition/Condition;", "getTag", "()Ljava/lang/String;", "subConditions", "", "isInit", "", "refreshStateRunnable", "Ljava/lang/Runnable;", "register", "", "isSatisfied", "getUnsatisfiedReason", "generateSubConditions", "refreshState", "initSubConditions", "onConditionChange", "condition", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class c extends b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Condition f12877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12878b;
    private final List<b> c;
    private boolean d;
    private final Runnable e;

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public c(Condition r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "conditionEnum");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
        this.f12877a = r2;
        this.f12878b = r3;
        this.c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.e = new $$Lambda$c$pv6THIGBaKhMmFQKKVQeaCBxBeM(this);
    }

    public /* synthetic */ c(Condition r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Condition.COMMON_POWER_CONTROL;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = "CommonPowerControlCondition";
    L8:
        this(r1, r2);
    }

    private static final CharSequence a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.g(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final void a(c r0) {
        r0.d();
    }

    private static final Unit b(c r0) {
        r0.e.run();
        return Unit.INSTANCE;
    }

    private final void d() {
        boolean r0 = c();
        if (r0 == i()) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f12878b, "refreshState: " + r0, false, 4, null);
        b(r0);
        d r1 = h();
        if (r1 == null) goto L9;
        r1.onConditionChange(this.f12877a, r0);
        return;
    L9:
        return;
    }

    private final void e() {
        if (this.d == false) goto L5;
        return;
    L5:
        this.d = true;
        if (this.c.isEmpty() == false) goto L8;
        this.c.addAll((Collection) ZeusTransformUtils.preCheckCast(a(), Collection.class, "com.obric.memorydata.plugin"));
    L8:
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r0.hasNext() == false) goto L12;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin");
        r2.b((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin"));
        r2.b();
        goto L10
    L12:
        PersonalContextAPI.INSTANCE.addForceIndexStateChangeListener(new $$Lambda$c$l7TKuBUT65X2wtAbLC2iaKyLaNY(this));
        d();
    }

    public static /* synthetic */ CharSequence lambda$VKSvSs3fDQHXeYaTWsD0JKa9YEA(b r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$l7TKuBUT65X2wtAbLC2iaKyLaNY(c r0) {
        return b(r0);
    }

    public static /* synthetic */ void lambda$pv6THIGBaKhMmFQKKVQeaCBxBeM(c r0) {
        a(r0);
    }

    public List<b> a() {
        return CollectionsKt.mutableListOf(new b[]{AbilityConditionManager.INSTANCE.createBatteryMeetsRequirementCondition(), AbilityConditionManager.INSTANCE.createNotInPowerSaveModeCondition(), AbilityConditionManager.INSTANCE.createTemperatureStateCondition()});
    }

    @Override // com.obric.memorydata.task.condition.b
    public void b() {
        e();
    }

    @Override // com.obric.memorydata.task.condition.b
    public boolean c() {
        e();
        IStore r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        if (r0.getBoolean("is_instant_entity_index_switch_on", false) == false) goto L6;
        return true;
    L6:
        if (r0.getBoolean("is_screen_observation_evaluation_enable", false) == false) goto L8;
        return true;
    L8:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L11;
    L13:
        Iterator r7 = r6.iterator();
    L15:
        if (r7.hasNext() == false) goto L18;
        if (((b) ZeusTransformUtils.preCheckCast(r7.next(), b.class, "com.obric.memorydata.plugin")).c() == true) goto L15;
        return false;
    L18:
        return true;
    L11:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L13;
        goto L13
    }

    @Override // com.obric.memorydata.task.condition.b
    public String g() {
        e();
        boolean r3 = false;
        IStore r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        if (r0.getBoolean("is_instant_entity_index_switch_on", false) == false) goto L6;
        return "";
    L6:
        if (r0.getBoolean("is_screen_observation_evaluation_enable", false) == false) goto L8;
        return "";
    L8:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        Object r5 = r4.next();
        if ((true ^ ((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin")).c()) == false) goto L10;
        r2.add(r5);
        goto L10
    L14:
        String r6 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$c$VKSvSs3fDQHXeYaTWsD0JKa9YEA.INSTANCE, 30, null);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L17;
        r3 = true;
    L17:
        if (r3 == true) goto L26;
        String r15 = getClass().getSimpleName();
        Intrinsics.checkNotNull(r15);
        return r15;
    L26:
        return getClass().getSimpleName() + "(unsatisfied subConditions: [" + r6 + "])";
    }

    @Override // com.obric.memorydata.task.condition.d
    public void onConditionChange(Condition r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "condition");
        GlobalMainHandler.Companion.getInstance().removeCallbacks(this.e);
        GlobalMainHandler.Companion.getInstance().post(this.e);
    }
}
