package i22;

import com.bytedance.android.live.annotation.AutoRegisterTask;
import com.bytedance.android.live.initialize.IWTOSingleTask;
import com.bytedance.android.live.initialize.WTOPriorityType;
import com.bytedance.android.live.initialize.WTOThreadType;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@AutoRegisterTask(name = "LiveModuleListInjectTask")
public final class b implements IWTOSingleTask {
    public b() {
    }

    public final boolean cancelable() {
        return true;
    }

    public final boolean isEffective() {
        return true;
    }

    public final String taskBusinessInfo() {
        return "WTO_LiveModuleListInjectTask";
    }

    public final List<Integer> taskDependencies() {
        return CollectionsKt.mutableListOf(new Integer[]{27});
    }

    public final int taskID() {
        return 21;
    }

    public final void run() {
        Iterator r0 = TTLiveSDKContext.moduleList.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        String r1 = (String) r0.next();
        System.currentTimeMillis();
        if (Intrinsics.areEqual(r1, "livehybridimpl") == true) goto L4;
        if (Intrinsics.areEqual(r1, "livesdk") == true) goto L4;
        TTLiveSDKContext.safeCallStaticMethod("com.bytedance.android.live.misc.LiveService$$" + r1, "registerService", new Object[0]);
        System.currentTimeMillis();
        goto L4
    }

    public final List<Integer> taskCategoryList() {
        return new ArrayList();
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
