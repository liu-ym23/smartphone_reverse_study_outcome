package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.live.core.launch.WorkThreadTask;
import com.bytedance.android.live.initialize.IWTOTask;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@WorkThreadTask
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0014R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/init/LiveMergedTask;", "Lcom/bytedance/android/live/core/launch/AbsTask;", "mergedTask", BuildConfig.FLAVOR, "Lcom/bytedance/android/live/initialize/IWTOTask;", "(Ljava/util/List;)V", "getMergedTask", "()Ljava/util/List;", "run", BuildConfig.FLAVOR, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
@Task(businessInfo = "WTO_LiveMergedTask", value = 33)
public final class LiveMergedTask extends AbsTask {
    private final List<IWTOTask> mergedTask;

    public void run() {
        Iterator<T> r0 = this.mergedTask.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IWTOTask) r0.next()).run();
        goto L4
    }

    public final List<IWTOTask> getMergedTask() {
        return this.mergedTask;
    }

    public LiveMergedTask(List<? extends IWTOTask> r2) {
        Intrinsics.checkNotNullParameter(r2, "mergedTask");
        this.mergedTask = r2;
    }
}
