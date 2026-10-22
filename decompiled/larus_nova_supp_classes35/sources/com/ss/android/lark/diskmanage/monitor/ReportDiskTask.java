package com.ss.android.lark.diskmanage.monitor;

import android.content.Context;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/diskmanage/monitor/ReportDiskTask;", "Lcom/larksuite/framework/launch/task/AsyncLaunchTask;", BuildConfig.FLAVOR, "<init>", "()V", "delayDuration", BuildConfig.FLAVOR, "execute", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "Companion", "storage-monitor_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReportDiskTask extends AsyncLaunchTask<Object> {

    public static final class a {
    }

    static {
    }

    public final int c() {
        return 90;
    }

    public ReportDiskTask() {
    }

    public final void a(Context r3) {
        Log.i("ReportDiskTask", "ReportDiskTask start");
        new com.ss.android.lark.diskmanage.monitor.a().f(r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("ReportDiskTask", "call StorageMetricsHandler exception !", e);
    }
}
