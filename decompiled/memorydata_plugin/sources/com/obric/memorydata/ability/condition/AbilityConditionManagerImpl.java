package com.obric.memorydata.ability.condition;

import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.condition.IAbilityConditionManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/ability/condition/AbilityConditionManagerImpl;", "Lcom/obric/memorydata/task/condition/IAbilityConditionManager;", "<init>", "()V", "getInst", "createTemperatureStateCondition", "Lcom/obric/memorydata/task/condition/BaseCondition;", "createTemperatureSevereRangeCondition", "createNotInPowerSaveModeCondition", "createPowerConnectedCondition", "createBatteryMeetsRequirementCondition", "createBatteryCharge10MinCondition", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AbilityConditionManagerImpl implements IAbilityConditionManager {
    public static final AbilityConditionManagerImpl INSTANCE = null;

    static {
        INSTANCE = new AbilityConditionManagerImpl();
    }

    private AbilityConditionManagerImpl() {
    }

    @JvmStatic
    public static final AbilityConditionManagerImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.task.condition.IAbilityConditionManager
    public com.obric.memorydata.task.condition.b createBatteryCharge10MinCondition() {
        return (com.obric.memorydata.task.condition.b) ZeusTransformUtils.preCheckCast(new b(Condition.BATTERY_BELOW_80_CHARGING_10_MIN), com.obric.memorydata.task.condition.b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.task.condition.IAbilityConditionManager
    public com.obric.memorydata.task.condition.b createBatteryMeetsRequirementCondition() {
        return (com.obric.memorydata.task.condition.b) ZeusTransformUtils.preCheckCast(new c(Condition.BATTERY_MEETS_REQUIREMENT), com.obric.memorydata.task.condition.b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.task.condition.IAbilityConditionManager
    public com.obric.memorydata.task.condition.b createNotInPowerSaveModeCondition() {
        return (com.obric.memorydata.task.condition.b) ZeusTransformUtils.preCheckCast(new d(Condition.NOT_IN_POWER_SAVE_MODE), com.obric.memorydata.task.condition.b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.task.condition.IAbilityConditionManager
    public com.obric.memorydata.task.condition.b createPowerConnectedCondition() {
        return (com.obric.memorydata.task.condition.b) ZeusTransformUtils.preCheckCast(new e(Condition.POWER_CONNECTED), com.obric.memorydata.task.condition.b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.task.condition.IAbilityConditionManager
    public com.obric.memorydata.task.condition.b createTemperatureSevereRangeCondition() {
        return (com.obric.memorydata.task.condition.b) ZeusTransformUtils.preCheckCast(new f(Condition.TEMPERATURE_SEVERE_RANGE, 3, 3), com.obric.memorydata.task.condition.b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.task.condition.IAbilityConditionManager
    public com.obric.memorydata.task.condition.b createTemperatureStateCondition() {
        return (com.obric.memorydata.task.condition.b) ZeusTransformUtils.preCheckCast(new f(Condition.TEMPERATURE_LOW_RANGE, 2, 2), com.obric.memorydata.task.condition.b.class, "com.obric.memorydata.plugin");
    }
}
