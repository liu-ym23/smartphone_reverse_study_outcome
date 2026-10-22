package com.obric.assistant.complex_task;

import com.larus.multitask_management.api.data.TaskPriority;
import com.larus.multitask_management.api.spi.IMultiTaskSortComparator;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kl9.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/complex_task/ComplexTaskSortComparator;", "Lcom/larus/multitask_management/api/spi/IMultiTaskSortComparator;", "<init>", "()V", "getTaskPriority", NameKeys.UnloadStrategy_No_Strategy, "task", "Lcom/larus/multitask_management/api/data/TaskBasicInfo;", "compareTasks", "task1", "task2", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComplexTaskSortComparator implements IMultiTaskSortComparator {
    public ComplexTaskSortComparator() {
    }

    public final int x(u r5) {
        Intrinsics.checkNotNullParameter(r5, "task");
        if (Intrinsics.areEqual(r5.u, "omni") == true) goto L6;
        return -1;
    L6:
        Map r0 = r5.s;
        String r2 = null;
        if (r0 == null) goto L9;
        String r1 = (String) r0.get("biz_scene");
    L11:
        if (Intrinsics.areEqual(r1, "clarify") == true) goto L21;
        Map r6 = r5.s;
        if (r6 == null) goto L16;
        r2 = (String) r6.get("biz_scene");
    L16:
        if (Intrinsics.areEqual(r2, "call_user") == true) goto L21;
        return TaskPriority.RUNNING_OMNI.getValue();
    L21:
        return TaskPriority.CALLING_OMNI.getValue();
    L9:
        r1 = null;
        goto L11
    }

    public final int u1(u r3, u r4) {
        Intrinsics.checkNotNullParameter(r3, "task1");
        Intrinsics.checkNotNullParameter(r4, "task2");
        return Intrinsics.compare(r3.n, r4.n);
    }
}
