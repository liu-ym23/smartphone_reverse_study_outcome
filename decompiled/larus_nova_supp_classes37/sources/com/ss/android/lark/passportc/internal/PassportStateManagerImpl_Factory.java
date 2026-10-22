package com.ss.android.lark.passportc.internal;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PassportStateManagerImpl_Factory implements Factory<PassportStateManagerImpl> {
    private final Provider<com.ss.android.lark.passportc.api.f> backgroundUserServiceProvider;
    private final Provider<t> executorsProvider;
    private final Provider<Set<com.ss.android.lark.passportc.task.d>> globalOnlineTasksProvider;
    private final Provider<com.ss.android.lark.log.c> loggerProvider;
    private final Provider<com.ss.android.lark.passportc.api.i> multiOnlineFgProvider;
    private final Provider<l0c.d> taskMonitorProvider;
    private final Provider<com.ss.android.lark.passportc.task.g> taskOrderProvider;
    private final Provider<z> userComponentManagerDelegateProvider;
    private final Provider<p> userDataSourceProvider;
    private final Provider<l0c.c> userFlowMonitorProvider;

    public PassportStateManagerImpl get() {
        return newInstance((z) this.userComponentManagerDelegateProvider.get(), (p) this.userDataSourceProvider.get(), (com.ss.android.lark.log.c) this.loggerProvider.get(), (Set) this.globalOnlineTasksProvider.get(), (com.ss.android.lark.passportc.task.g) this.taskOrderProvider.get(), (l0c.d) this.taskMonitorProvider.get(), (com.ss.android.lark.passportc.api.i) this.multiOnlineFgProvider.get(), (com.ss.android.lark.passportc.api.f) this.backgroundUserServiceProvider.get(), (l0c.c) this.userFlowMonitorProvider.get(), (t) this.executorsProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m738get() {
        return get();
    }

    public PassportStateManagerImpl_Factory(Provider<z> r1, Provider<p> r2, Provider<com.ss.android.lark.log.c> r3, Provider<Set<com.ss.android.lark.passportc.task.d>> r4, Provider<com.ss.android.lark.passportc.task.g> r5, Provider<l0c.d> r6, Provider<com.ss.android.lark.passportc.api.i> r7, Provider<com.ss.android.lark.passportc.api.f> r8, Provider<l0c.c> r9, Provider<t> r10) {
        this.userComponentManagerDelegateProvider = r1;
        this.userDataSourceProvider = r2;
        this.loggerProvider = r3;
        this.globalOnlineTasksProvider = r4;
        this.taskOrderProvider = r5;
        this.taskMonitorProvider = r6;
        this.multiOnlineFgProvider = r7;
        this.backgroundUserServiceProvider = r8;
        this.userFlowMonitorProvider = r9;
        this.executorsProvider = r10;
    }

    public static PassportStateManagerImpl_Factory create(Provider<z> r12, Provider<p> r13, Provider<com.ss.android.lark.log.c> r14, Provider<Set<com.ss.android.lark.passportc.task.d>> r15, Provider<com.ss.android.lark.passportc.task.g> r16, Provider<l0c.d> r17, Provider<com.ss.android.lark.passportc.api.i> r18, Provider<com.ss.android.lark.passportc.api.f> r19, Provider<l0c.c> r20, Provider<t> r21) {
        return new PassportStateManagerImpl_Factory(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    public static PassportStateManagerImpl newInstance(z r12, p r13, com.ss.android.lark.log.c r14, Set<com.ss.android.lark.passportc.task.d> r15, com.ss.android.lark.passportc.task.g r16, l0c.d r17, com.ss.android.lark.passportc.api.i r18, com.ss.android.lark.passportc.api.f r19, l0c.c r20, t r21) {
        return new PassportStateManagerImpl(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }
}
