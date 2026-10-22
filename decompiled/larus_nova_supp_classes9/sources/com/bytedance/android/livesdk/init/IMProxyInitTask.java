package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.live.core.launch.WorkThreadTask;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.interactivity.api.IIMService;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@WorkThreadTask
@Task(businessInfo = "WTO_IMProxyInitTask", value = 13)
public class IMProxyInitTask extends AbsTask {
    public static /* synthetic */ void a() {
        lambda$run$0();
    }

    private static /* synthetic */ void lambda$run$0() {
        ((IIMService) jc1.k.f(IIMService.class)).initServiceProxy();
    }

    public List<Integer> preTasks() {
        LinkedList r0 = new LinkedList();
        r0.add(10);
        r0.add(0);
        r0.add(2);
        return r0;
    }

    public void run() {
        MainThreadPostUtils.b(new a());
    }

    public IMProxyInitTask() {
    }
}
