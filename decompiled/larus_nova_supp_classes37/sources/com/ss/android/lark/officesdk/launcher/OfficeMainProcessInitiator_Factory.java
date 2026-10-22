package com.ss.android.lark.officesdk.launcher;

import com.ss.android.lark.app.router.InitRouterTask;
import com.ss.android.lark.framework.assembly.appcontext.InitAppLifecycleTask;
import com.ss.android.lark.framework.assembly.logger.InitLogTask;
import com.ss.android.lark.framework.assembly.rust.InitImSdkTask;
import com.ss.android.lark.framework.assembly.rust.InitRustSdkTask;
import com.ss.android.lark.framework.assembly.sp.InitUniStoreTask;
import com.ss.android.lark.passport_user.container.CreateUserComponentTask;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeMainProcessInitiator_Factory implements Factory<e> {
    private final Provider<CreateUserComponentTask> createUserComponentTaskProvider;
    private final Provider<InitAppLifecycleTask> initAppLifecycleTaskProvider;
    private final Provider<InitImSdkTask> initImSdkTaskProvider;
    private final Provider<InitLogTask> initLogTaskProvider;
    private final Provider<InitRouterTask> initRouterTaskProvider;
    private final Provider<InitRustSdkTask> initRustSdkTaskProvider;
    private final Provider<InitUniStoreTask> initUniStoreTaskProvider;
    private final Provider<eva.a> launchPerfDispatcherProvider;
    private final Provider<Set<b>> launchTaskInjectorsProvider;

    public e get() {
        e r0 = newInstance((InitLogTask) this.initLogTaskProvider.get(), (InitUniStoreTask) this.initUniStoreTaskProvider.get(), (InitAppLifecycleTask) this.initAppLifecycleTaskProvider.get(), (CreateUserComponentTask) this.createUserComponentTaskProvider.get(), (InitRustSdkTask) this.initRustSdkTaskProvider.get(), (eva.a) this.launchPerfDispatcherProvider.get(), (InitRouterTask) this.initRouterTaskProvider.get(), (InitImSdkTask) this.initImSdkTaskProvider.get());
        r0.h = (Set) this.launchTaskInjectorsProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m136get() {
        return get();
    }

    public static e newInstance(InitLogTask r10, InitUniStoreTask r11, InitAppLifecycleTask r12, CreateUserComponentTask r13, InitRustSdkTask r14, eva.a r15, InitRouterTask r16, InitImSdkTask r17) {
        return new e(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public OfficeMainProcessInitiator_Factory(Provider<InitLogTask> r1, Provider<InitUniStoreTask> r2, Provider<InitAppLifecycleTask> r3, Provider<CreateUserComponentTask> r4, Provider<InitRustSdkTask> r5, Provider<eva.a> r6, Provider<InitRouterTask> r7, Provider<InitImSdkTask> r8, Provider<Set<b>> r9) {
        this.initLogTaskProvider = r1;
        this.initUniStoreTaskProvider = r2;
        this.initAppLifecycleTaskProvider = r3;
        this.createUserComponentTaskProvider = r4;
        this.initRustSdkTaskProvider = r5;
        this.launchPerfDispatcherProvider = r6;
        this.initRouterTaskProvider = r7;
        this.initImSdkTaskProvider = r8;
        this.launchTaskInjectorsProvider = r9;
    }

    public static OfficeMainProcessInitiator_Factory create(Provider<InitLogTask> r11, Provider<InitUniStoreTask> r12, Provider<InitAppLifecycleTask> r13, Provider<CreateUserComponentTask> r14, Provider<InitRustSdkTask> r15, Provider<eva.a> r16, Provider<InitRouterTask> r17, Provider<InitImSdkTask> r18, Provider<Set<b>> r19) {
        return new OfficeMainProcessInitiator_Factory(r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }
}
