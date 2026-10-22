package com.bytedance.android.live.saas.middleware.npth;

import android.app.Application;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.IAppInfo;
import com.bytedance.android.live.saas.middleware.base.ISdkInitTask;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/npth/NpthInitTask;", "Lcom/bytedance/android/live/saas/middleware/base/ISdkInitTask;", "Lcom/bytedance/android/live/saas/middleware/npth/NpthConfig;", "params", "Lcom/bytedance/android/live/saas/middleware/npth/NpthParam;", "(Lcom/bytedance/android/live/saas/middleware/npth/NpthParam;)V", "mParams", "getParams", "()Lcom/bytedance/android/live/saas/middleware/npth/NpthParam;", "setParams", "init", "", "app", "Landroid/app/Application;", "p", "unInit", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class NpthInitTask implements ISdkInitTask<NpthConfig> {
    private NpthParam mParams;
    private NpthParam params;

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public void unInit() {
    }

    public final NpthParam getParams() {
        return this.params;
    }

    public NpthInitTask(NpthParam r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.params = r2;
        this.mParams = r2;
    }

    public final void setParams(NpthParam r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.params = r2;
    }

    /* JADX INFO: renamed from: init, reason: avoid collision after fix types in other method */
    public void init2(Application r4, NpthConfig r5) {
        Intrinsics.checkNotNullParameter(r4, "app");
        Intrinsics.checkNotNullParameter(r5, "p");
        IAppInfo r6 = BDLiveSdk.getAppInfo();
        if (r6 == null) goto L5;
        Npth.getConfigManager().setDebugMode(r6.isDebug());
    L5:
        Npth.registerCrashCallback(this.mParams.getCrashCallback(), CrashType.ALL);
        Npth.init(r4, this.mParams.getParams(), this.mParams.getJavaCrash(), this.mParams.getNativeCrash(), this.mParams.getAnr());
    }

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public /* bridge */ /* synthetic */ void init(Application r1, NpthConfig r2) {
        init2(r1, r2);
    }
}
