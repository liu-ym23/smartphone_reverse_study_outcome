package com.bytedance.android.live.saas.middleware.alog;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.live.saas.middleware.base.ISdkInitTask;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0002\u0010\bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\t\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/alog/ALogInitTask;", "Lcom/bytedance/android/live/saas/middleware/base/ISdkInitTask;", "Lcom/bytedance/android/live/saas/middleware/alog/ALogConfig;", "context", "Landroid/content/Context;", "debug", "", "aLogConfig", "(Landroid/content/Context;ZLcom/bytedance/android/live/saas/middleware/alog/ALogConfig;)V", "mALogConfig", "mContext", "mDebug", "init", "", "app", "Landroid/app/Application;", "params", "unInit", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class ALogInitTask implements ISdkInitTask<ALogConfig> {
    private ALogConfig mALogConfig;
    private Context mContext;
    private boolean mDebug;

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public void unInit() {
    }

    /* JADX INFO: renamed from: init, reason: avoid collision after fix types in other method */
    public void init2(Application r3, ALogConfig r4) {
        Intrinsics.checkNotNullParameter(r3, "app");
        Intrinsics.checkNotNullParameter(r4, "params");
        BDLiveALogSDK.INSTANCE.init(this.mContext, this.mDebug, this.mALogConfig);
    }

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public /* bridge */ /* synthetic */ void init(Application r1, ALogConfig r2) {
        init2(r1, r2);
    }

    public ALogInitTask(Context r2, boolean r3, ALogConfig r4) {
        Intrinsics.checkNotNullParameter(r4, "aLogConfig");
        this.mContext = r2;
        this.mDebug = r3;
        this.mALogConfig = r4;
    }

    public /* synthetic */ ALogInitTask(Context r1, boolean r2, ALogConfig r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2, r3);
    }
}
