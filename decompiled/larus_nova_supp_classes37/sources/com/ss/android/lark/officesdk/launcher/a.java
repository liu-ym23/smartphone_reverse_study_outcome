package com.ss.android.lark.officesdk.launcher;

import com.ss.android.lark.app.task.scheduler.AppLauncherTaskScheduler;
import com.ss.android.lark.officesdk.chameleon.assembly.doubao.ChameleonSdkInitTask;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class a implements com.ss.android.lark.officesdk.launcher.feed.a {
    @Inject
    public a() {
    }

    @Override // com.ss.android.lark.officesdk.launcher.feed.a
    public final void a(AppLauncherTaskScheduler r2) {
        Intrinsics.checkNotNullParameter(r2, "launcherTaskScheduler");
        r2.a(new ChameleonSdkInitTask());
    }

    @Override // com.ss.android.lark.officesdk.launcher.feed.a
    public final void b(AppLauncherTaskScheduler r2) {
        Intrinsics.checkNotNullParameter(r2, "launcherTaskScheduler");
    }
}
