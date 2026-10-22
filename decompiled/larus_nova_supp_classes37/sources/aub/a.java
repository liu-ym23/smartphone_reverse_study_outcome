package aub;

import android.content.Context;
import com.ss.android.lark.app.router.InitRouterTask;
import com.ss.android.lark.app.task.scheduler.AppLauncherTaskScheduler;
import com.ss.android.lark.app.task.scheduler.TaskConsumeType;
import com.ss.android.lark.callback.InitCallbackTask;
import com.ss.android.lark.framework.assembly.appconfig.InitSettingsTask;
import com.ss.android.lark.framework.assembly.appcontext.InitAppLifecycleTask;
import com.ss.android.lark.framework.assembly.batterymonitor.InitOfficeSdkDozeTask;
import com.ss.android.lark.framework.assembly.displaystore.OfficeInitDisplayStoreTask;
import com.ss.android.lark.framework.assembly.dynamicconfig.UpdateDynamicConfigTask;
import com.ss.android.lark.framework.assembly.eventbus.InitThreadPoolEventBusTask;
import com.ss.android.lark.framework.assembly.floating.InitFloatTask;
import com.ss.android.lark.framework.assembly.librarian.InitLibrarianTask;
import com.ss.android.lark.framework.assembly.lkui.InitLKUIToastTask;
import com.ss.android.lark.framework.assembly.logger.InitLogTask;
import com.ss.android.lark.framework.assembly.manis.InitManisTask;
import com.ss.android.lark.framework.assembly.navigation.InitNavigationTask;
import com.ss.android.lark.framework.assembly.network.InitNetworkTask;
import com.ss.android.lark.framework.assembly.rust.InitImSdkTask;
import com.ss.android.lark.framework.assembly.rust.InitRustSdkTask;
import com.ss.android.lark.framework.assembly.soloader.InitSoLoaderTask;
import com.ss.android.lark.framework.assembly.sp.InitUniStoreTask;
import com.ss.android.lark.framework.assembly.utils.InitPadConfigTask;
import com.ss.android.lark.framework.assembly.watermark.InitWaterMarkTask;
import com.ss.android.lark.integrator.security.compliance.InitSecurityComplianceTask;
import com.ss.android.lark.jack.InitJackTask;
import com.ss.android.lark.officesdk.chameleon.assembly.doubao.ChameleonSdkInitTask;
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
    public final InitLogTask b;
    public final InitUniStoreTask c;
    public final CreateUserComponentTask d;
    public final InitRustSdkTask e;
    public final InitRouterTask f;
    public final InitImSdkTask g;
    public final InitAppLifecycleTask h;
    public final Set<b> i;

    @Override // ztb.a
    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        AppLauncherTaskScheduler r0 = this.a;
        r0.getClass();
        r0.b(r3, TaskConsumeType.ALL);
    }

    @Override // ztb.a
    public final void b(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        AppLauncherTaskScheduler r0 = this.a;
        r0.a(this.b);
        r0.a(this.c);
        InitKmpTask r1 = new InitKmpTask();
        r1.h(InitLogTask.class);
        r1.h(InitUniStoreTask.class);
        r0.a(r1);
        CreateUserComponentTask r2 = this.d;
        r2.h(InitLogTask.class);
        r2.h(InitUniStoreTask.class);
        r0.a(r2);
        r0.a(new InitNetworkTask());
        r0.a(new InitNavigationTask());
        r0.a(new InitLKUIToastTask());
        InitLibrarianTask r3 = new InitLibrarianTask();
        r3.h(InitLogTask.class);
        r0.a(r3);
        r0.a(this.e);
        InitWaterMarkTask r4 = new InitWaterMarkTask();
        r4.h(CreateUserComponentTask.class);
        r0.a(r4);
        r0.a(new InitFloatTask());
        r0.a(this.h);
        r0.d(r5, TaskConsumeType.ONLY_SYNC);
        Iterator<b> r6 = this.i.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r6.next().b(this.a);
        goto L4
    L6:
        AppLauncherTaskScheduler r7 = this.a;
        TaskConsumeType r8 = TaskConsumeType.ONLY_SYNC;
        r7.d(r5, r8);
        AppLauncherTaskScheduler r9 = this.a;
        r9.a(new InitSoLoaderTask());
        r9.a(new UpdateDynamicConfigTask());
        r9.a(new InitCallbackTask());
        r9.a(new InitThreadPoolEventBusTask());
        r9.a(new InitPadConfigTask());
        r9.a(new InitJackTask());
        InitImSdkTask r10 = this.g;
        r10.h(InitRustSdkTask.class);
        r9.a(r10);
        r9.b(r5, TaskConsumeType.ONLY_ASYNC);
        AppLauncherTaskScheduler r11 = this.a;
        OfficeInitDisplayStoreTask r12 = new OfficeInitDisplayStoreTask();
        r12.h(InitUniStoreTask.class);
        r11.a(r12);
        InitRouterTask r13 = this.f;
        r13.h(InitLogTask.class);
        r11.a(r13);
        r11.d(r5, r8);
        AppLauncherTaskScheduler r14 = this.a;
        r14.a(new InitOfficeSdkDozeTask());
        r14.a(new InitManisTask());
        r14.a(new InitOfficeSdkBdTuringTask());
        r14.a(new InitSettingsTask());
        r14.a(new InitSecurityComplianceTask(0));
        r14.a(new ChameleonSdkInitTask());
        Iterator<b> r15 = this.i.iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        r15.next().a(this.a);
        goto L8
    }

    public a(AppLauncherTaskScheduler r2, InitLogTask r3, InitUniStoreTask r4, CreateUserComponentTask r5, InitRustSdkTask r6, InitRouterTask r7, InitImSdkTask r8, InitAppLifecycleTask r9, Set<b> r10) {
        Intrinsics.checkNotNullParameter(r2, "taskScheduler");
        Intrinsics.checkNotNullParameter(r3, "initLogTask");
        Intrinsics.checkNotNullParameter(r4, "initUniStoreTask");
        Intrinsics.checkNotNullParameter(r5, "createUserComponentTask");
        Intrinsics.checkNotNullParameter(r6, "initRustSdkTask");
        Intrinsics.checkNotNullParameter(r7, "initRouterTask");
        Intrinsics.checkNotNullParameter(r8, "initImSdkTask");
        Intrinsics.checkNotNullParameter(r9, "initAppLifecycleTask");
        Intrinsics.checkNotNullParameter(r10, "launchTaskInjectors");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
