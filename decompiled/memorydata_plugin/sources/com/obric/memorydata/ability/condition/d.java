package com.obric.memorydata.ability.condition;

import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.task.condition.Condition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\bH\u0016J\u0017\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/ability/condition/NotInPowerSaveModeCondition;", "Lcom/obric/memorydata/ability/condition/AbilityStateCondition;", "condition", "Lcom/obric/memorydata/task/condition/Condition;", "<init>", "(Lcom/obric/memorydata/task/condition/Condition;)V", "getSubscribeAbilityParams", "", "Lcom/obric/memorydata/ability/AbilityParams;", "()[Lcom/obric/memorydata/ability/AbilityParams;", "getQueryAbilityParams", "extractState", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "(Lcom/obric/memorydata/ability/data/IStandardData;)Ljava/lang/Boolean;", "getUnsatisfiedReason", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d extends a {
    public d(Condition r2) {
        Intrinsics.checkNotNullParameter(r2, "condition");
        super(r2);
    }

    @Override // com.obric.memorydata.ability.condition.a
    public Boolean a(h r2) {
        h r1 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "data");
        if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.ability.data.a.class) == true) goto L5;
        return null;
    L5:
        return Boolean.valueOf(!((com.obric.memorydata.ability.data.a) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.ability.data.a.class, "com.obric.memorydata.plugin")).d());
    }

    @Override // com.obric.memorydata.ability.condition.a
    public com.obric.memorydata.ability.f[] e() {
        return new com.obric.memorydata.ability.f[]{new com.obric.memorydata.ability.f(100000010, MapsKt.mapOf(TuplesKt.to("mode", 4)))};
    }

    @Override // com.obric.memorydata.ability.condition.a
    public com.obric.memorydata.ability.f f() {
        return new com.obric.memorydata.ability.f(100000010, MapsKt.emptyMap());
    }

    @Override // com.obric.memorydata.task.condition.b
    public String g() {
        if (c() == false) goto L7;
        return "";
    L7:
        return "NotInPowerSaveModeCondition(isPowerSaveMode=" + (!i()) + ')';
    }
}
