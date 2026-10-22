package com.bytedance.android.livesdk.init;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.live.core.launch.WorkThreadTask;
import com.bytedance.common.utility.concurrent.SimpleThreadFactory;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@WorkThreadTask
@Task(businessInfo = "WTO_TaskManagerInitTask", value = 4)
public class TaskManagerInitTask extends AbsTask {
    public List<Integer> preTasks() {
        return Arrays.asList(new Integer[]{0});
    }

    public void run() {
        PThreadScheduledThreadPoolExecutor r0 = PThreadExecutorsUtils.newCachedThreadPool(new SimpleThreadFactory("live-work-threads", true));
        if (r0 != null) goto L5;
        r0 = l56.b.c;
    L5:
        l56.b r1 = l56.b.a();
        r1.getClass();
        r1.b = r0;
        new Handler(Looper.getMainLooper());
        r1.a = true;
    }

    public TaskManagerInitTask() {
    }
}
