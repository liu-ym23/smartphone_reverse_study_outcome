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
@AutoRegisterTask(name = "LiveHybridImplInjectTask")
public final class a implements IWTOSingleTask {

    /* JADX INFO: renamed from: i22.a$a, reason: collision with other inner class name */
    public static final class C0235a {
    }

    static {
    }

    public a() {
    }

    public final boolean cancelable() {
        return true;
    }

    public final boolean isEffective() {
        return true;
    }

    public final void run() {
        TTLiveSDKContext.safeCallStaticMethod("com.bytedance.android.live.misc.LiveService$$livehybridimpl", "registerService", new Object[0]);
    }

    public final String taskBusinessInfo() {
        return "WTO_LiveHybridImplInjectTask";
    }

    public final int taskID() {
        return 26;
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
