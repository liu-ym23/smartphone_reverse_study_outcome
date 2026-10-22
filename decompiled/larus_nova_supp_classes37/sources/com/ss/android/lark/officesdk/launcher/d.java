package com.ss.android.lark.officesdk.launcher;

import com.ss.android.lark.app.task.scheduler.AppLauncherTaskScheduler;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class d implements b {
    public final OfficeLaunchSchedulerType a;

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final void a(AppLauncherTaskScheduler r2) {
        Intrinsics.checkNotNullParameter(r2, "launcherTaskScheduler");
    }

    @Inject
    public d() {
        this.a = OfficeLaunchSchedulerType.V1;
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final OfficeLaunchSchedulerType c() {
        return this.a;
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final void b(AppLauncherTaskScheduler r2) {
        Intrinsics.checkNotNullParameter(r2, "launcherTaskScheduler");
    }
}
