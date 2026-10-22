package com.bytedance.android.live.saas.middleware.baselib;

import android.app.Application;
import com.bytedance.android.live.saas.middleware.base.ISdkInitTask;
import com.bytedance.common.utility.concurrent.TTExecutors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/baselib/BaseLibInitTask;", "Lcom/bytedance/android/live/saas/middleware/base/ISdkInitTask;", "Lcom/bytedance/android/live/saas/middleware/baselib/BaseLibConfig;", "()V", "init", "", "app", "Landroid/app/Application;", "params", "unInit", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class BaseLibInitTask implements ISdkInitTask<BaseLibConfig> {
    public BaseLibInitTask() {
    }

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public void unInit() {
    }

    /* JADX INFO: renamed from: init, reason: avoid collision after fix types in other method */
    public void init2(Application r2, BaseLibConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "app");
        Intrinsics.checkNotNullParameter(r3, "params");
        ITTExecutors r4 = r3.getTtExecutors();
        if (r4 == null) goto L23;
        ExecutorService r5 = r4.getNormalThreadPool();
        if (r5 == null) goto L7;
        TTExecutors.setNormalThreadPool(r5);
        r5.toString();
    L7:
        ScheduledExecutorService r6 = r4.getScheduledThreadPool();
        if (r6 == null) goto L10;
        TTExecutors.setScheduledThreadPool(r6);
        r6.toString();
    L10:
        ExecutorService r7 = r4.getCpuThreadPool();
        if (r7 == null) goto L13;
        TTExecutors.setCPUThreadPool(r7);
        r7.toString();
    L13:
        ExecutorService r8 = r4.getIoThreadPool();
        if (r8 == null) goto L16;
        TTExecutors.setIOThreadPool(r8);
        r8.toString();
    L16:
        ExecutorService r9 = r4.getSerialThreadPool();
        if (r9 == null) goto L19;
        TTExecutors.setSerialThreadPool(r9);
        r9.toString();
    L19:
        ExecutorService r10 = r4.getBackgroundThreadPool();
        if (r10 == null) goto L24;
        TTExecutors.setBackgroundThreadPool(r10);
        r10.toString();
        return;
    L24:
        return;
    }

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public /* bridge */ /* synthetic */ void init(Application r1, BaseLibConfig r2) {
        init2(r1, r2);
    }
}
