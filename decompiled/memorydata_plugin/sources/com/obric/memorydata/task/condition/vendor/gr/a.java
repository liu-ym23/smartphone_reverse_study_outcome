package com.obric.memorydata.task.condition.vendor.gr;

import com.obric.memorydata.task.condition.Condition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/task/condition/vendor/gr/GRHeavyTaskWindowCondition;", "Lcom/obric/memorydata/task/condition/vendor/gr/GRTaskWindowCondition;", "<init>", "()V", "_availabilitySet", "", "Lcom/obric/memorydata/task/condition/vendor/gr/GRAiTaskApi$Availability;", "getCurrentRunLevel", "getCurrentCondition", "Lcom/obric/memorydata/task/condition/Condition;", "getAvailabilities", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<GRAiTaskApi.Availability> f12904b;

    public a() {
        this.f12904b = SetsKt.setOf(GRAiTaskApi.Availability.STATUS_HEAVY_RUN);
    }

    @Override // com.obric.memorydata.task.condition.vendor.gr.d
    public GRAiTaskApi.Availability a() {
        return GRAiTaskApi.Availability.STATUS_HEAVY_RUN;
    }

    @Override // com.obric.memorydata.task.condition.vendor.gr.d
    public Condition d() {
        return Condition.STRICTLY_POWER_CONTROL;
    }

    @Override // com.obric.memorydata.task.condition.vendor.gr.d
    public Collection<GRAiTaskApi.Availability> e() {
        return (Collection) ZeusTransformUtils.preCheckCast(this.f12904b, Collection.class, "com.obric.memorydata.plugin");
    }
}
