package com.obric.memorydata.task.condition;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/task/condition/IAbilityConditionManager;", "Lcom/bytedance/news/common/service/manager/IService;", "createTemperatureStateCondition", "Lcom/obric/memorydata/task/condition/BaseCondition;", "createTemperatureSevereRangeCondition", "createNotInPowerSaveModeCondition", "createPowerConnectedCondition", "createBatteryMeetsRequirementCondition", "createBatteryCharge10MinCondition", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IAbilityConditionManager extends IService {
    b createBatteryCharge10MinCondition();

    b createBatteryMeetsRequirementCondition();

    b createNotInPowerSaveModeCondition();

    b createPowerConnectedCondition();

    b createTemperatureSevereRangeCondition();

    b createTemperatureStateCondition();
}
