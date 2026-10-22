package com.obric.memorydata.task.condition;

import com.obric.memorydata.middleware.api.settings.AppSettingsManager;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/task/condition/StrictlyPowerControlCondition;", "Lcom/obric/memorydata/task/condition/CommonPowerControlCondition;", "<init>", "()V", "generateSubConditions", "", "Lcom/obric/memorydata/task/condition/BaseCondition;", "getUnsatisfiedReason", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l extends c {
    public l() {
        super(Condition.STRICTLY_POWER_CONTROL, "StrictlyPowerControlCondition");
    }

    @Override // com.obric.memorydata.task.condition.c
    public List<b> a() {
        List<b> r1 = super.a();
        if (AppSettingsManager.INSTANCE.getCommonFeatureSettings().getEnableStrictBatteryCharge10Min() == false) goto L5;
        b r0 = AbilityConditionManager.INSTANCE.createBatteryCharge10MinCondition();
    L6:
        r1.add(r0);
        r1.add(new i());
        return r1;
    L5:
        r0 = AbilityConditionManager.INSTANCE.createPowerConnectedCondition();
        goto L6
    }

    @Override // com.obric.memorydata.task.condition.c, com.obric.memorydata.task.condition.b
    public String g() {
        return "";
    }
}
