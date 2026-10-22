package com.obric.memorydata.task.utils;

import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskParameter;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"toLogSummary", "", "Lcom/obric/memorydata/task/AbsTaskRequest;", "Lcom/obric/memorydata/task/impl/TaskParameter;", "toResultSummary", "Lcom/obric/memorydata/task/impl/TaskInfo;", "task_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class d {
    private static final CharSequence a(Condition r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.getValue(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static final String a(AbsTaskRequest r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        AbsTaskRequest r0 = r3.getParentTaskRequest();
        if (r0 == null) goto L8;
        TaskParameter r1 = r0.getTaskParameter();
        if (r1 == null) goto L8;
        String r2 = r1.getName() + '/' + r1.getUuid();
        if (r2 == null) goto L8;
    L10:
        return a(r3.getTaskParameter()) + ", state=" + r3.getTaskInfo().c() + ", parent=" + r2;
    L8:
        r2 = "-";
        goto L10
    }

    public static final String a(TaskInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = "task=" + r2.b() + ", taskId=" + r2.a() + ", state=" + r2.c() + ", resultCode=" + r2.e().getCode();
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
        return r3;
    }

    public static final String a(TaskParameter r13) {
        Intrinsics.checkNotNullParameter(r13, "<this>");
        String r1 = "-";
        if (r13.getConditions().isEmpty() == false) goto L5;
        String r0 = "-";
    L6:
        ExistingTaskPolicy r2 = r13.getExistingTaskPolicy();
        if (r2 == null) goto L12;
        String r3 = r2.name();
        if (r3 == null) goto L12;
        r1 = r3;
    L12:
        String r14 = "task=" + r13.getName() + ", taskId=" + r13.getUuid() + ", policy=" + r1 + ", conditions=" + r0;
        Intrinsics.checkNotNullExpressionValue(r14, "toString(...)");
        return r14;
    L5:
        r0 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r13.getConditions(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$d$kUF7T5Dgsn9pmrQ3XPrt0501dhE.INSTANCE, 30, null);
        goto L6
    }

    public static /* synthetic */ CharSequence lambda$kUF7T5Dgsn9pmrQ3XPrt0501dhE(Condition r0) {
        return a(r0);
    }
}
