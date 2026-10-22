package com.obric.memorydata.task.condition;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001J\t\u0010\b\u001a\u00020\u0005H\u0096\u0001J\t\u0010\t\u001a\u00020\u0005H\u0096\u0001J\t\u0010\n\u001a\u00020\u0005H\u0096\u0001¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/task/condition/AbilityConditionManager;", "Lcom/obric/memorydata/task/condition/IAbilityConditionManager;", "<init>", "()V", "createBatteryCharge10MinCondition", "Lcom/obric/memorydata/task/condition/BaseCondition;", "createBatteryMeetsRequirementCondition", "createNotInPowerSaveModeCondition", "createPowerConnectedCondition", "createTemperatureSevereRangeCondition", "createTemperatureStateCondition", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AbilityConditionManager implements IAbilityConditionManager {
    public static final AbilityConditionManager INSTANCE = null;
    private final /* synthetic */ IAbilityConditionManager $$delegate_0;

    static {
        INSTANCE = new AbilityConditionManager();
    }

    private AbilityConditionManager() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IAbilityConditionManager.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IAbilityConditionManager) ZeusTransformUtils.preCheckCast(r0, IAbilityConditionManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.task.condition.IAbilityConditionManager
    public b createBatteryCharge10MinCondition() {
        return this.$$delegate_0.createBatteryCharge10MinCondition();
    }

    @Override // com.obric.memorydata.task.condition.IAbilityConditionManager
    public b createBatteryMeetsRequirementCondition() {
        return this.$$delegate_0.createBatteryMeetsRequirementCondition();
    }

    @Override // com.obric.memorydata.task.condition.IAbilityConditionManager
    public b createNotInPowerSaveModeCondition() {
        return this.$$delegate_0.createNotInPowerSaveModeCondition();
    }

    @Override // com.obric.memorydata.task.condition.IAbilityConditionManager
    public b createPowerConnectedCondition() {
        return this.$$delegate_0.createPowerConnectedCondition();
    }

    @Override // com.obric.memorydata.task.condition.IAbilityConditionManager
    public b createTemperatureSevereRangeCondition() {
        return this.$$delegate_0.createTemperatureSevereRangeCondition();
    }

    @Override // com.obric.memorydata.task.condition.IAbilityConditionManager
    public b createTemperatureStateCondition() {
        return this.$$delegate_0.createTemperatureStateCondition();
    }
}
