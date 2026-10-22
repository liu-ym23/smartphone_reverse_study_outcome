package com.obric.memorydata.ability.condition;

import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.data.s;
import com.obric.memorydata.task.condition.Condition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/ability/condition/TemperatureStateCondition;", "Lcom/obric/memorydata/ability/condition/AbilityStateCondition;", "condition", "Lcom/obric/memorydata/task/condition/Condition;", "openThresholdState", "", "closeThresholdState", "<init>", "(Lcom/obric/memorydata/task/condition/Condition;II)V", "getOpenThresholdState", "()I", "getCloseThresholdState", "getSubscribeAbilityParams", "", "Lcom/obric/memorydata/ability/AbilityParams;", "()[Lcom/obric/memorydata/ability/AbilityParams;", "getQueryAbilityParams", "extractState", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "(Lcom/obric/memorydata/ability/data/IStandardData;)Ljava/lang/Boolean;", "getUnsatisfiedReason", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8315b;
    private final int c;

    public f(Condition r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "condition");
        super(r2);
        this.f8315b = r3;
        this.c = r4;
    }

    @Override // com.obric.memorydata.ability.condition.a
    public Boolean a(h r5) {
        h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "data");
        if (ZeusTransformUtils.instanceOf(r6, s.class) == true) goto L6;
        return null;
    L6:
        boolean r2 = true;
        if (i() == false) goto L12;
        if (((s) ZeusTransformUtils.preCheckCast(r6, s.class, "com.obric.memorydata.plugin")).a() < this.c) goto L16;
    L14:
        r2 = false;
    L16:
        return Boolean.valueOf(r2);
    L12:
        if (((s) ZeusTransformUtils.preCheckCast(r6, s.class, "com.obric.memorydata.plugin")).a() >= this.f8315b) goto L14;
        goto L14
    }

    @Override // com.obric.memorydata.ability.condition.a
    public com.obric.memorydata.ability.f[] e() {
        return new com.obric.memorydata.ability.f[]{new com.obric.memorydata.ability.f(100000015, MapsKt.emptyMap())};
    }

    @Override // com.obric.memorydata.ability.condition.a
    public com.obric.memorydata.ability.f f() {
        return new com.obric.memorydata.ability.f(100000015, MapsKt.emptyMap());
    }

    @Override // com.obric.memorydata.task.condition.b
    public String g() {
        if (c() == false) goto L7;
        return "";
    L7:
        return "TemperatureStateCondition(isSatisfied=" + i() + ", openThreshold=" + this.f8315b + ", closeThreshold=" + this.c + ')';
    }
}
