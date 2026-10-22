package bub;

import android.content.Context;
import com.ss.android.lark.app.router.InitRouterTask;
import com.ss.android.lark.app.task.scheduler.AppLauncherTaskScheduler;
import com.ss.android.lark.app.task.scheduler.TaskConsumeType;
import com.ss.android.lark.callback.InitCallbackTask;
import com.ss.android.lark.framework.assembly.appcontext.InitAppLifecycleTask;
import com.ss.android.lark.framework.assembly.batterymonitor.InitOfficeSdkDozeTask;
import com.ss.android.lark.framework.assembly.dynamicconfig.UpdateDynamicConfigTask;
import com.ss.android.lark.framework.assembly.eventbus.InitThreadPoolEventBusTask;
import com.ss.android.lark.framework.assembly.lkui.InitLKUIToastTask;
import com.ss.android.lark.framework.assembly.logger.InitLogTask;
import com.ss.android.lark.framework.assembly.manis.InitManisTask;
import com.ss.android.lark.framework.assembly.rust.InitImSdkTask;
import com.ss.android.lark.framework.assembly.rust.InitRustSdkTask;
import com.ss.android.lark.framework.assembly.sp.InitUniStoreTask;
import com.ss.android.lark.jack.InitJackTask;
import com.ss.android.lark.officesdk.experiment.LaunchExperiment;
import com.ss.android.lark.officesdk.launcher.InitKmpTask;
import com.ss.android.lark.officesdk.launcher.InitOfficeSdkBdTuringTask;
import com.ss.android.lark.officesdk.launcher.b;
import com.ss.android.lark.passport_user.container.CreateUserComponentTask;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements ztb.a {
    public final AppLauncherTaskScheduler a;
    public final LaunchExperiment b;
    public final InitLogTask c;
    public final InitUniStoreTask d;
    public final CreateUserComponentTask e;
    public final InitRustSdkTask f;
    public final InitRouterTask g;
    public final InitImSdkTask h;
    public final InitAppLifecycleTask i;
    public final Set<b> j;

    @Override // ztb.a
    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        AppLauncherTaskScheduler r0 = this.a;
        r0.getClass();
        r0.b(r3, TaskConsumeType.ALL);
    }

    @Override // ztb.a
    public final void b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AppLauncherTaskScheduler r0 = this.a;
        r0.a(this.c);
        r0.a(this.d);
        InitKmpTask r1 = new InitKmpTask();
        r1.h(InitLogTask.class);
        r1.h(InitUniStoreTask.class);
        r0.a(r1);
        CreateUserComponentTask r2 = this.e;
        r2.h(InitLogTask.class);
        r2.h(InitUniStoreTask.class);
        r0.a(r2);
        r0.a(new InitLKUIToastTask());
        r0.a(this.f);
        r0.a(new InitCallbackTask());
        r0.a(new InitThreadPoolEventBusTask());
        r0.a(new InitJackTask());
        r0.a(new UpdateDynamicConfigTask());
        InitRouterTask r3 = this.g;
        r3.h(InitLogTask.class);
        r0.a(r3);
        r0.a(new InitOfficeSdkDozeTask());
        r0.a(new InitManisTask());
        r0.a(this.i);
        r0.a(new InitOfficeSdkBdTuringTask());
        r0.d(r4, TaskConsumeType.ONLY_SYNC);
        Iterator<b> r5 = this.j.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().b(this.a);
        goto L4
    L6:
        this.a.d(r4, TaskConsumeType.ONLY_SYNC);
        AppLauncherTaskScheduler r6 = this.a;
        if (this.b == LaunchExperiment.LAUNCH_ONLY_OFFICE_SDK) goto L9;
        r6.a(this.h);
    L9:
        Iterator<b> r7 = this.j.iterator();
    L11:
        if (r7.hasNext() == false) goto L13;
        r7.next().a(this.a);
        goto L11
    }

    public a(AppLauncherTaskScheduler r2, LaunchExperiment r3, InitLogTask r4, InitUniStoreTask r5, CreateUserComponentTask r6, InitRustSdkTask r7, InitRouterTask r8, InitImSdkTask r9, InitAppLifecycleTask r10, Set<b> r11) {
        Intrinsics.checkNotNullParameter(r2, "taskScheduler");
        Intrinsics.checkNotNullParameter(r3, "launchExperiment");
        Intrinsics.checkNotNullParameter(r4, "initLogTask");
        Intrinsics.checkNotNullParameter(r5, "initUniStoreTask");
        Intrinsics.checkNotNullParameter(r6, "createUserComponentTask");
        Intrinsics.checkNotNullParameter(r7, "initRustSdkTask");
        Intrinsics.checkNotNullParameter(r8, "initRouterTask");
        Intrinsics.checkNotNullParameter(r9, "initImSdkTask");
        Intrinsics.checkNotNullParameter(r10, "initAppLifecycleTask");
        Intrinsics.checkNotNullParameter(r11, "launchTaskInjectors");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }
}
