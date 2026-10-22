package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.live.core.launch.WorkThreadTask;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@WorkThreadTask
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0014¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/init/MessageZstdInitTask;", "Lcom/bytedance/android/live/core/launch/AbsTask;", "()V", "preTasks", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "run", BuildConfig.FLAVOR, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
@Task(businessInfo = "WTO_MessageZstdInitTask", value = 11)
public final class MessageZstdInitTask extends AbsTask {
    public List<Integer> preTasks() {
        return CollectionsKt.arrayListOf(new Integer[]{6});
    }

    public void run() {
        im2.m r0 = im2.m.e;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (im2.m.d == false) goto L9;
        monitor-exit(r0);
        return;
    L9:
        im2.m.d = true;     // Catch: Throwable -> L16
        bc2.c.b("message zstd manager init");     // Catch: Throwable -> L16
        im2.m.a();     // Catch: Throwable -> L12
    L14:
        monitor-exit(r0);
        return;
    L12:
        th = move-exception;
        im2.m.d("exception", th);     // Catch: Throwable -> L16
        goto L14
    }

    public MessageZstdInitTask() {
    }
}
