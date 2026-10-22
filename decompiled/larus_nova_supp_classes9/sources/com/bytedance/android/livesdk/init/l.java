package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.initialize.IWTOSingleTask;
import com.bytedance.android.live.initialize.WTOPriorityType;
import com.bytedance.android.live.initialize.WTOThreadType;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements IWTOSingleTask {
    public final AbsTask a;
    public final com.bytedance.android.live.initialize.a b;
    public final WTOPriorityType c;
    public final WTOThreadType d;
    public final List<Integer> e;

    public final boolean cancelable() {
        return true;
    }

    public final boolean isEffective() {
        return true;
    }

    public final void run() {
        this.a.start();
    }

    public final String taskBusinessInfo() {
        return this.a.getTaskBusinessInfo();
    }

    public final List<Integer> taskCategoryList() {
        return new ArrayList();
    }

    public final int taskID() {
        return this.a.getTaskId();
    }

    public final List<Integer> taskDependencies() {
        return this.e;
    }

    public final com.bytedance.android.live.initialize.a taskExecutePeriod() {
        return this.b;
    }

    public final WTOPriorityType taskPriorityType() {
        return this.c;
    }

    public final WTOThreadType taskThreadType() {
        return this.d;
    }

    public l(AbsTask r4, WTOPriorityType r5, WTOThreadType r6) {
        com.bytedance.android.live.initialize.a.i r0 = com.bytedance.android.live.initialize.a.i.c;
        List<Integer> r1 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r4, "task");
        Intrinsics.checkNotNullParameter(r0, "period");
        Intrinsics.checkNotNullParameter(r5, "priorityType");
        Intrinsics.checkNotNullParameter(r6, "threadType");
        Intrinsics.checkNotNullParameter(r1, "dependencies");
        this.a = r4;
        this.b = r0;
        this.c = r5;
        this.d = r6;
        this.e = r1;
    }
}
