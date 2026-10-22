package com.ss.android.lark.officesdk.launcher;

import com.ss.android.lark.app.task.scheduler.AppLauncherTaskScheduler;
import com.ss.android.lark.integrator.im.card.InitCardTemplateServiceTask;
import com.ss.android.lark.officesdk.integrator.core.corrupt.InitDbCorruptPushTask;
import com.ss.android.lark.officesdk.integrator.im.InitFullImSdkTask;
import com.ss.android.lark.officesdk.integrator.im.sdk.service.InitImSdkServiceTask;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class ImLaunchTaskInjectorV2 implements b {
    public final OfficeLaunchSchedulerType a;
    public final Lazy b;

    @Inject
    public ImLaunchTaskInjectorV2() {
        this.a = OfficeLaunchSchedulerType.V2;
        this.b = LazyKt.lazy(ImLaunchTaskInjectorV2$isIMEnabled$2.INSTANCE);
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final OfficeLaunchSchedulerType c() {
        return this.a;
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final void a(AppLauncherTaskScheduler r2) {
        Intrinsics.checkNotNullParameter(r2, "launcherTaskScheduler");
        if (((Boolean) this.b.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        r2.a(new InitImSdkServiceTask());
        r2.a(new InitFullImSdkTask());
        r2.a(new InitCardTemplateServiceTask());
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final void b(AppLauncherTaskScheduler r2) {
        Intrinsics.checkNotNullParameter(r2, "launcherTaskScheduler");
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L6;
        r2.a(new InitDbCorruptPushTask());
        return;
    }
}
