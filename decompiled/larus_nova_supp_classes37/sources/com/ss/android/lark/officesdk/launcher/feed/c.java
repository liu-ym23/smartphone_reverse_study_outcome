package com.ss.android.lark.officesdk.launcher.feed;

import android.content.Context;
import com.ss.android.lark.app.task.scheduler.AppLauncherTaskScheduler;
import com.ss.android.lark.app.task.scheduler.LaunchTaskExecutor;
import com.ss.android.lark.app.task.scheduler.TaskConsumeType;
import com.ss.android.lark.framework.assembly.appconfig.InitSettingsTask;
import com.ss.android.lark.framework.assembly.appreciable.InitAppreciableTask;
import com.ss.android.lark.framework.assembly.displaystore.OfficeInitDisplayStoreTask;
import com.ss.android.lark.framework.assembly.navigation.InitNavigationTask;
import com.ss.android.lark.framework.assembly.network.InitNetworkTask;
import com.ss.android.lark.framework.assembly.rust.InitImSdkTask;
import com.ss.android.lark.framework.assembly.watermark.InitWaterMarkTask;
import com.ss.android.lark.integrator.security.compliance.InitSecurityComplianceTask;
import com.ss.android.lark.officesdk.OfficeSDK;
import com.ss.android.lark.officesdk.experiment.LaunchExperiment;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class c implements b {
    public final InitImSdkTask a;

    @Inject
    public Set<a> b;
    public final AppLauncherTaskScheduler c;

    @Override // com.ss.android.lark.officesdk.launcher.feed.b
    public final void a(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        LaunchTaskExecutor r0 = LaunchTaskExecutor.b();
        r0.a = false;
        r0.b.clear();
        AtomicBoolean r1 = OfficeSDK.a;
        LaunchExperiment r2 = OfficeSDK.b.a;
        AppLauncherTaskScheduler r3 = this.c;
        r3.a(new InitNetworkTask());
        r3.a(new InitNavigationTask());
        r3.a(new OfficeInitDisplayStoreTask());
        r3.a(new InitAppreciableTask());
        r3.d(r8, TaskConsumeType.ONLY_SYNC);
        Set<a> r4 = this.b;
        Set<a> r5 = null;
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("launchTaskInjectors");
        r4 = null;
    L6:
        Iterator<a> r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r6.next().b(this.c);
        goto L8
    L10:
        this.c.d(r8, TaskConsumeType.ONLY_SYNC);
        AppLauncherTaskScheduler r7 = this.c;
        r7.a(new InitSettingsTask());
        if (r2 != LaunchExperiment.LAUNCH_ONLY_OFFICE_SDK) goto L13;
        r7.a(this.a);
    L13:
        r7.a(new InitWaterMarkTask());
        r7.a(new InitSecurityComplianceTask(0));
        Set<a> r9 = this.b;
        if (r9 == null) goto L16;
        r5 = r9;
    L17:
        Iterator<a> r10 = r5.iterator();
    L19:
        if (r10.hasNext() == false) goto L21;
        r10.next().a(this.c);
        goto L19
    L21:
        AppLauncherTaskScheduler r11 = this.c;
        r11.getClass();
        r11.b(r8, TaskConsumeType.ALL);
        LaunchTaskExecutor.b().a(this.c);
        return;
    L16:
        Intrinsics.throwUninitializedPropertyAccessException("launchTaskInjectors");
        goto L17
    }

    @Inject
    public c(InitImSdkTask r2, eva.a r3) {
        Intrinsics.checkNotNullParameter(r2, "initImSdkTask");
        Intrinsics.checkNotNullParameter(r3, "launchPerfDispatcher");
        this.a = r2;
        this.c = new AppLauncherTaskScheduler(r3);
    }
}
