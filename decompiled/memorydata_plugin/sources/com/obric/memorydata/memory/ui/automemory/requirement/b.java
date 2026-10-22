package com.obric.memorydata.memory.ui.automemory.requirement;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.entity.MemoryBaseRequirementEntity;
import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel;
import com.obric.memorydata.memory.ui.automemory.settings.e;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\u0014\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016J\u0091\u0001\u0010\u0014\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u001626\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u00182\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\f0\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\"2\u001a\b\u0002\u0010#\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\"\u0012\u0004\u0012\u00020\u00120\u001fH\u0000¢\u0006\u0002\b$J!\u0010%\u001a\u0004\u0018\u00010 2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010&\u001a\u00020\u000eH\u0000¢\u0006\u0002\b'J\b\u0010!\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/requirement/MemoryRuleRequirementSync;", "", "<init>", "()V", "TAG", "", "SOURCE", "SCENE_ID", "STATUS_PENDING", "SOURCE_AI_PROACTIVE", "requirementId", "ruleId", "", "shouldSync", "", "rule", "Lcom/obric/memorydata/database/entity/MemoryRuleEntity;", "syncUpsert", "", "syncDelete", "rebuildAllFromRules", "rules", "", "markDeleteBySource", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, AILabCheckPermissionTask.KEY_SOURCE, "updateTime", "", "upsertRequirement", "Lkotlin/Function1;", "Lcom/obric/memorydata/database/entity/MemoryBaseRequirementEntity;", "enqueueSceneBuild", "Lkotlin/Function0;", "runInTransaction", "rebuildAllFromRules$memory_obricRelease", "buildEntity", "logInvalidRule", "buildEntity$memory_obricRelease", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10717a = null;

    static {
        f10717a = new b();
    }

    private b() {
    }

    private static final int a(String r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, AILabCheckPermissionTask.KEY_SOURCE);
        return MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryBaseRequirementDao().markDeleteBySource(r1, r2);
    }

    private static final long a(MemoryBaseRequirementEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        return MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryBaseRequirementDao().upsert(r2);
    }

    public static /* synthetic */ MemoryBaseRequirementEntity a(b r0, MemoryRuleEntity r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.a(r1, r2);
    }

    private static final Unit a(Ref.BooleanRef r4, Function2 r5, List r6, Function1 r7) {
        Function2 r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        if (((Number) ZeusTransformUtils.preCheckCast(r8.invoke("auto_memory_rule", Long.valueOf(System.currentTimeMillis())), Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L5;
        boolean r11 = true;
    L6:
        r4.element = r11;
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r12.hasNext() == false) goto L14;
        MemoryBaseRequirementEntity r13 = f10717a.a((MemoryRuleEntity) ZeusTransformUtils.preCheckCast(r12.next(), MemoryRuleEntity.class, "com.obric.memorydata.plugin"), false);
        if (r13 == null) goto L8;
        r10.invoke(r13);
        r4.element = true;
        goto L8
    L14:
        return Unit.INSTANCE;
    L5:
        r11 = false;
        goto L6
    }

    private final void a() {
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("memory_scene_build").setConditions(new Condition[]{Condition.NETWORK_AVAILABLE, Condition.SCREEN_ON_OR_CHARGE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.SINGLE_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    public static final /* synthetic */ void a(b r0) {
        r0.a();
    }

    private static final void a(Function0 r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    private static final Unit b(Function0 r2) {
        final Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "block");
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().runInTransaction(new $$Lambda$b$8K0A3abymIR_QHNsYu7vq85dlHk(r3));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ int lambda$7PiYKAyCTnqvBu4wzFomOSh27O8(String r0, long r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$8K0A3abymIR_QHNsYu7vq85dlHk(Function0 r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$AXSKl-_IwmLYRAZpilUHHcQtNKs, reason: not valid java name */
    public static /* synthetic */ Unit m817lambda$AXSKl_IwmLYRAZpilUHHcQtNKs(Function0 r0) {
        return b(r0);
    }

    public static /* synthetic */ long lambda$VRul4jUCCfre4LqBvPXX9J4ziCs(MemoryBaseRequirementEntity r2) {
        return a(r2);
    }

    public static /* synthetic */ Unit lambda$ar8vhdmTPS2qV2ycMY1bXN4aYlY(Ref.BooleanRef r0, Function2 r1, List r2, Function1 r3) {
        return a(r0, r1, r2, r3);
    }

    public final MemoryBaseRequirementEntity a(MemoryRuleEntity r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "rule");
        if (r12.getCanDisplay() == true) goto L5;
    L23:
        return null;
    L5:
        if (Intrinsics.areEqual(r12.getSource(), AutoMemoryViewModel.SOURCE_AI_PROACTIVE) == true) goto L23;
        if (r12.getUseClientModel() == true) goto L23;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12.getMemoryInfoJson(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L14;
        if (r13 == false) goto L13;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryRuleRequirementSync", "rule " + r12.getId() + " missing memoryInfoJson, skip requirement sync", null, 4, null);
    L13:
        return null;
    L14:
        e r0 = e.f10753a.a(r12.getMemoryInfoJson());
        if (a.f10716a.a(r0) == false) goto L18;
        String r14 = a.f10716a.a(r12.getId(), r0);
    L17:
        String r2 = r14;
        long r9 = System.currentTimeMillis();
        return new MemoryBaseRequirementEntity(a(r12.getId()), r2, "auto_memory_rule", "PENDING", "user_defined_memory_requirements", "", r9, r9);
    L18:
        if (r13 == false) goto L20;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryRuleRequirementSync", "rule " + r12.getId() + " illegal memoryInfoJson, fallback to legacy content", null, 4, null);
    L20:
        r14 = a.f10716a.a(r12.getId(), r12.getTitle(), r12.getContent());
        goto L17
    }

    public final String a(long r2) {
        return "auto_memory_rule_" + r2;
    }

    public final void a(MemoryRuleEntity r4) {
        Intrinsics.checkNotNullParameter(r4, "rule");
        MemoryBaseRequirementEntity r0 = a(this, r4, false, 2, null);
        if (r0 != null) goto L6;
        b(r4.getId());
        return;
    L6:
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryBaseRequirementDao().upsert(r0);
        a();
    }

    public final void a(List<MemoryRuleEntity> r9) {
        List<MemoryRuleEntity> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "rules");
        a(r3, $$Lambda$b$7PiYKAyCTnqvBu4wzFomOSh27O8.INSTANCE, $$Lambda$b$VRul4jUCCfre4LqBvPXX9J4ziCs.INSTANCE, (Function0) ZeusTransformUtils.preCheckCast(new MemoryRuleRequirementSync$rebuildAllFromRules$3(this), Function0.class, "com.obric.memorydata.plugin"), $$Lambda$b$AXSKl_IwmLYRAZpilUHHcQtNKs.INSTANCE);
    }

    public final void a(List<MemoryRuleEntity> r2, Function2<? super String, ? super Long, Integer> r3, Function1<? super MemoryBaseRequirementEntity, Long> r4, Function0<Unit> r5, Function1<? super Function0<Unit>, Unit> r6) {
        final List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        final Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        final Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "rules");
        Intrinsics.checkNotNullParameter(r7, "markDeleteBySource");
        Intrinsics.checkNotNullParameter(r8, "upsertRequirement");
        Intrinsics.checkNotNullParameter(r9, "enqueueSceneBuild");
        Intrinsics.checkNotNullParameter(r10, "runInTransaction");
        final Ref.BooleanRef r11 = new Ref.BooleanRef();
        r10.invoke(new $$Lambda$b$ar8vhdmTPS2qV2ycMY1bXN4aYlY(r11, r7, r1, r8));
        if (r11.element == false) goto L6;
        r9.invoke();
        return;
    }

    public final void b(long r4) {
        if (MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryBaseRequirementDao().markDelete(a(r4), System.currentTimeMillis()) <= 0) goto L6;
        a();
        return;
    }
}
