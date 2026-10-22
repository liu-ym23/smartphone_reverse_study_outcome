package com.obric.memorydata.task.condition;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/task/condition/MemoryExtractPowerControlCondition;", "Lcom/obric/memorydata/task/condition/CommonPowerControlCondition;", "<init>", "()V", "generateSubConditions", "", "Lcom/obric/memorydata/task/condition/BaseCondition;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f extends c {
    public f() {
        super(Condition.MEMORY_EXTRACT_POWER_CONTROL, "MemoryExtractPowerControlCondition");
    }

    @Override // com.obric.memorydata.task.condition.c
    public List<b> a() {
        return CollectionsKt.mutableListOf(new b[]{AbilityConditionManager.INSTANCE.createBatteryMeetsRequirementCondition(), AbilityConditionManager.INSTANCE.createNotInPowerSaveModeCondition(), AbilityConditionManager.INSTANCE.createTemperatureSevereRangeCondition()});
    }
}
