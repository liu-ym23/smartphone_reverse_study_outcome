package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.annotation.AutoRegisterTask;
import com.bytedance.android.live.initialize.IWTOSingleTask;
import com.bytedance.android.live.initialize.WTOPriorityType;
import com.bytedance.android.live.initialize.WTOThreadType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@AutoRegisterTask(name = "LiveFeatureServiceTask")
public final class h implements IWTOSingleTask {
    public final /* synthetic */ l a;

    public final boolean cancelable() {
        this.a.getClass();
        return true;
    }

    public final boolean isEffective() {
        this.a.getClass();
        return true;
    }

    public final void run() {
        this.a.run();
    }

    public final String taskBusinessInfo() {
        return this.a.taskBusinessInfo();
    }

    public final int taskID() {
        return this.a.taskID();
    }

    public final List<Integer> taskCategoryList() {
        this.a.getClass();
        return new ArrayList();
    }

    public final List<Integer> taskDependencies() {
        return this.a.e;
    }

    public final com.bytedance.android.live.initialize.a taskExecutePeriod() {
        return this.a.b;
    }

    public final WTOPriorityType taskPriorityType() {
        return this.a.c;
    }

    public final WTOThreadType taskThreadType() {
        return this.a.d;
    }

    public h() {
        FeatureServiceTask r1 = new FeatureServiceTask();
        com.bytedance.android.live.initialize.a.i r2 = com.bytedance.android.live.initialize.a.i.c;
        this.a = new l(r1, WTOPriorityType.SCHEDULE, WTOThreadType.WorkerThread);
    }
}
