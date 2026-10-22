package com.ss.android.lark.passportc.impl.v2.state;

import com.ss.android.lark.passportc.api.f;
import com.ss.android.lark.passportc.impl.v2.action.g;
import com.ss.android.lark.passportc.internal.p;
import com.ss.android.lark.passportc.internal.t;
import com.ss.android.lark.passportc.task.d;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
import l0c.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserStateMachineFactory_Factory implements Factory<a> {
    private final Provider<com.ss.android.lark.passportc.impl.v2.action.a> backgroundComponentDelegateProvider;
    private final Provider<f> backgroundUserServiceProvider;
    private final Provider<t> executorsProvider;
    private final Provider<g> foregroundComponentDelegateProvider;
    private final Provider<Set<d>> globalOnlineTasksProvider;
    private final Provider<l0c.d> taskMonitorProvider;
    private final Provider<p> userDataSourceProvider;
    private final Provider<c> userFlowMonitorProvider;

    public a get() {
        return newInstance((g) this.foregroundComponentDelegateProvider.get(), (com.ss.android.lark.passportc.impl.v2.action.a) this.backgroundComponentDelegateProvider.get(), (f) this.backgroundUserServiceProvider.get(), (Set) this.globalOnlineTasksProvider.get(), (p) this.userDataSourceProvider.get(), (l0c.d) this.taskMonitorProvider.get(), (t) this.executorsProvider.get(), (c) this.userFlowMonitorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m713get() {
        return get();
    }

    public UserStateMachineFactory_Factory(Provider<g> r1, Provider<com.ss.android.lark.passportc.impl.v2.action.a> r2, Provider<f> r3, Provider<Set<d>> r4, Provider<p> r5, Provider<l0c.d> r6, Provider<t> r7, Provider<c> r8) {
        this.foregroundComponentDelegateProvider = r1;
        this.backgroundComponentDelegateProvider = r2;
        this.backgroundUserServiceProvider = r3;
        this.globalOnlineTasksProvider = r4;
        this.userDataSourceProvider = r5;
        this.taskMonitorProvider = r6;
        this.executorsProvider = r7;
        this.userFlowMonitorProvider = r8;
    }

    public static UserStateMachineFactory_Factory create(Provider<g> r10, Provider<com.ss.android.lark.passportc.impl.v2.action.a> r11, Provider<f> r12, Provider<Set<d>> r13, Provider<p> r14, Provider<l0c.d> r15, Provider<t> r16, Provider<c> r17) {
        return new UserStateMachineFactory_Factory(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static a newInstance(g r10, com.ss.android.lark.passportc.impl.v2.action.a r11, f r12, Set<d> r13, p r14, l0c.d r15, t r16, c r17) {
        return new a(r10, r11, r12, r13, r14, r15, r16, r17);
    }
}
