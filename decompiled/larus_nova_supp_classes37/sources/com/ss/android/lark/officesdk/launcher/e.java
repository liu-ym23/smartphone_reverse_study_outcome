package com.ss.android.lark.officesdk.launcher;

import android.content.Context;
import com.ss.android.lark.app.router.InitRouterTask;
import com.ss.android.lark.app.task.scheduler.AppLauncherTaskScheduler;
import com.ss.android.lark.app.task.scheduler.LaunchTaskExecutor;
import com.ss.android.lark.framework.assembly.appcontext.InitAppLifecycleTask;
import com.ss.android.lark.framework.assembly.logger.InitLogTask;
import com.ss.android.lark.framework.assembly.rust.InitImSdkTask;
import com.ss.android.lark.framework.assembly.rust.InitRustSdkTask;
import com.ss.android.lark.framework.assembly.sp.InitUniStoreTask;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.OfficeSDK;
import com.ss.android.lark.officesdk.api.init.RuntimeStrategy;
import com.ss.android.lark.officesdk.executor.OfficeSDKRuntime;
import com.ss.android.lark.officesdk.experiment.LaunchExperiment;
import com.ss.android.lark.passport_user.container.CreateUserComponentTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class e implements com.ss.android.lark.app.initiator.d {
    public final InitLogTask a;
    public final InitUniStoreTask b;
    public final InitAppLifecycleTask c;
    public final CreateUserComponentTask d;
    public final InitRustSdkTask e;
    public final InitRouterTask f;
    public final InitImSdkTask g;

    @Inject
    public Set<com.ss.android.lark.officesdk.launcher.b> h;
    public final AppLauncherTaskScheduler i;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[RuntimeStrategy.values().length];
            r0[RuntimeStrategy.ASYNC_NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L4:
            a = r0;
            int[] r1 = new int[OfficeLaunchSchedulerType.values().length];
            r1[OfficeLaunchSchedulerType.V2.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L12:
            r1[OfficeLaunchSchedulerType.V1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L7:
            b = r1;
        }
    }

    static {
    }

    public final void a() {
        Log.i("MainProcessInitiatorV2", "afterOnCreate");
        LaunchTaskExecutor.b().a(this.i);
    }

    public final void b() {
        Log.i("MainProcessInitiatorV2", "beforeOnCreate");
    }

    public final void attachBaseContext(Context r20) {
        if (r20 != null) goto L5;
        return;
    L5:
        AtomicBoolean r0 = OfficeSDK.a;
        OfficeSDKRuntime r1 = OfficeSDK.c;
        Set<com.ss.android.lark.officesdk.launcher.b> r3 = null;
        if (r1 == null) goto L8;
        RuntimeStrategy r2 = r1.a;
    L9:
        LaunchExperiment r7 = OfficeSDK.b.a;
        if (r2 != null) goto L12;
        int r4 = -1;
    L14:
        if (r4 != 1) goto L16;
        OfficeLaunchSchedulerType r5 = OfficeLaunchSchedulerType.V2;
    L17:
        Set<com.ss.android.lark.officesdk.launcher.b> r6 = this.h;
        if (r6 == null) goto L20;
        r3 = r6;
    L21:
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r3.iterator();
    L23:
        if (r9.hasNext() == false) goto L30;
        Object r10 = r9.next();
        if (((com.ss.android.lark.officesdk.launcher.b) r10).c() != r5) goto L27;
        boolean r11 = true;
    L28:
        if (r11 == false) goto L23;
        r8.add(r10);
        goto L23
    L27:
        r11 = false;
        goto L28
    L30:
        Set r18 = CollectionsKt.toSet(r8);
        int r12 = b.b[r5.ordinal()];
        if (r12 != 1) goto L33;
        Log.i("MainProcessInitiatorV2", "office launch task run in async");
        ztb.a r13 = new bub.a(this.i, r7, this.a, this.b, this.d, this.e, this.f, this.g, this.c, r18);
    L38:
        ztb.a r14 = r13;
        r14.b(r20);
        AppLauncherTaskScheduler r15 = this.i;     // Catch: Throwable -> L41
        r15.getClass();     // Catch: Throwable -> L41
        ArrayList r16 = new ArrayList(r15.e);     // Catch: Throwable -> L41
        Log.i("MainProcessInitiatorV2", "OfficeSDK_Boot_Init_All_Task_Names: " + r16);     // Catch: Throwable -> L41
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r17 = com.ss.android.lark.officesdk.internal.g.a;     // Catch: Throwable -> L41
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L41
        Intrinsics.checkNotNullParameter(r16, "taskNames");     // Catch: Throwable -> L41
        new JSONObject().put("all_task_names", new JSONArray(r16));     // Catch: Throwable -> L41
    L43:
        r14.a(r20);
        Log.i("MainProcessInitiatorV2", "attachBaseContext");
        return;
    L41:
        th = move-exception;
        Log.w("MainProcessInitiatorV2", "reportAllLaunchTaskNames failed", th);
        goto L43
    L33:
        if (r12 != 2) goto L36;
        Log.i("MainProcessInitiatorV2", "office launch task run in sync");
        r13 = new aub.a(this.i, this.a, this.b, this.d, this.e, this.f, this.g, this.c, r18);
        goto L38
    L36:
        throw new NoWhenBranchMatchedException();
    L20:
        Intrinsics.throwUninitializedPropertyAccessException("launchTaskInjectors");
        goto L21
    L16:
        r5 = OfficeLaunchSchedulerType.V1;
        goto L17
    L12:
        r4 = b.a[r2.ordinal()];
        goto L14
    L8:
        r2 = null;
        goto L9
    }

    @Inject
    public e(InitLogTask r2, InitUniStoreTask r3, InitAppLifecycleTask r4, CreateUserComponentTask r5, InitRustSdkTask r6, eva.a r7, InitRouterTask r8, InitImSdkTask r9) {
        Intrinsics.checkNotNullParameter(r2, "initLogTask");
        Intrinsics.checkNotNullParameter(r3, "initUniStoreTask");
        Intrinsics.checkNotNullParameter(r4, "initAppLifecycleTask");
        Intrinsics.checkNotNullParameter(r5, "createUserComponentTask");
        Intrinsics.checkNotNullParameter(r6, "initRustSdkTask");
        Intrinsics.checkNotNullParameter(r7, "launchPerfDispatcher");
        Intrinsics.checkNotNullParameter(r8, "initRouterTask");
        Intrinsics.checkNotNullParameter(r9, "initImSdkTask");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r9;
        this.i = new AppLauncherTaskScheduler(r7);
    }
}
