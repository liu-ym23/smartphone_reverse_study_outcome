package com.obric.memorydata.recommend.screenshotupload;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0015\u001a\u00020\u0016J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J#\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u000eHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/RawObservationImageUploadTask;", "", "conditions", "", "Lcom/obric/memorydata/task/condition/Condition;", "existingTaskPolicy", "Lcom/obric/memorydata/task/scheduler/impl/ExistingTaskPolicy;", "<init>", "(Ljava/util/List;Lcom/obric/memorydata/task/scheduler/impl/ExistingTaskPolicy;)V", "getConditions", "()Ljava/util/List;", "getExistingTaskPolicy", "()Lcom/obric/memorydata/task/scheduler/impl/ExistingTaskPolicy;", ActivityLifecycle.NAME, "", "getName", "()Ljava/lang/String;", "delayMillis", "", "getDelayMillis", "()J", "enqueue", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Condition> f12554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExistingTaskPolicy f12555b;
    private final String c;
    private final long d;

    public d(List<? extends Condition> r3, ExistingTaskPolicy r4) {
        List<Condition> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "conditions");
        Intrinsics.checkNotNullParameter(r4, "existingTaskPolicy");
        this.f12554a = r5;
        this.f12555b = r4;
        this.c = "raw_observation_image_upload";
        this.d = TimeUnit.SECONDS.toMillis(10);
    }

    public final void a() {
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(this.c).setConditions(this.f12554a), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(this.f12555b), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setDelay(new com.obric.memorydata.task.impl.g(this.d, TimeUnit.MILLISECONDS)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12554a, r6.f12554a) == true) goto L12;
        return false;
    L12:
        if (this.f12555b == r6.f12555b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f12554a.hashCode() * 31) + this.f12555b.hashCode();
    }

    public String toString() {
        return "RawObservationImageUploadTask(conditions=" + this.f12554a + ", existingTaskPolicy=" + this.f12555b + ')';
    }
}
