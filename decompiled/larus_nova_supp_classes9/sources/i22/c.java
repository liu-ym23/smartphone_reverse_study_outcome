package i22;

import com.bytedance.android.live.annotation.AutoRegisterTask;
import com.bytedance.android.live.initialize.IWTOSingleTask;
import com.bytedance.android.live.initialize.WTOPriorityType;
import com.bytedance.android.live.initialize.WTOThreadType;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@AutoRegisterTask(name = "LivePerfPopupServiceInjectTask")
public final class c implements IWTOSingleTask {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public final boolean cancelable() {
        return true;
    }

    public final boolean isEffective() {
        return true;
    }

    public final String taskBusinessInfo() {
        return "WTO_LivePerfPopupServiceInjectTask";
    }

    public final int taskID() {
        return 23;
    }

    public final void run() {
        TTLiveSDKContext.safeNewEmptyInstance("com.bytedance.android.live.performance.PerfToolsService");
    }

    public final List<Integer> taskCategoryList() {
        return new ArrayList();
    }

    public final List<Integer> taskDependencies() {
        return CollectionsKt.emptyList();
    }

    public final com.bytedance.android.live.initialize.a taskExecutePeriod() {
        return com.bytedance.android.live.initialize.a.i.c;
    }

    public final WTOPriorityType taskPriorityType() {
        return WTOPriorityType.SCHEDULE;
    }

    public final WTOThreadType taskThreadType() {
        return WTOThreadType.WorkerThread;
    }
}
