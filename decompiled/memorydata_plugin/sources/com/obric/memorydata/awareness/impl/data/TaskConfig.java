package com.obric.memorydata.awareness.impl.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/awareness/impl/data/TaskConfig;", "", "conditions", "", "", "existingTaskPolicy", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getConditions", "()Ljava/util/List;", "getExistingTaskPolicy", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TaskConfig {
    private final List<String> conditions;
    private final String existingTaskPolicy;

    public TaskConfig(List<String> r3, String r4) {
        this.conditions = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.existingTaskPolicy = r4;
    }

    public static /* synthetic */ TaskConfig copy$default(TaskConfig r1, List r2, String r3, int r4, Object r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.conditions;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r1.existingTaskPolicy;
    L9:
        return r1.copy(r6, r3);
    }

    public final List<String> component1() {
        return this.conditions;
    }

    public final String component2() {
        return this.existingTaskPolicy;
    }

    public final TaskConfig copy(List<String> r2, String r3) {
        return new TaskConfig((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TaskConfig.class) == true) goto L8;
        return false;
    L8:
        TaskConfig r6 = (TaskConfig) ZeusTransformUtils.preCheckCast(r5, TaskConfig.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.conditions, r6.conditions) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.existingTaskPolicy, r6.existingTaskPolicy) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final List<String> getConditions() {
        return this.conditions;
    }

    public final String getExistingTaskPolicy() {
        return this.existingTaskPolicy;
    }

    public int hashCode() {
        List<String> r0 = this.conditions;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.existingTaskPolicy;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "TaskConfig(conditions=" + this.conditions + ", existingTaskPolicy=" + this.existingTaskPolicy + ')';
    }
}
