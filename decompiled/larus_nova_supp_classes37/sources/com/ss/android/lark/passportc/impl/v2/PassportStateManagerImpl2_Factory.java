package com.ss.android.lark.passportc.impl.v2;

import com.ss.android.lark.passportc.api.f;
import com.ss.android.lark.passportc.api.i;
import com.ss.android.lark.passportc.internal.p;
import com.ss.android.lark.passportc.internal.t;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PassportStateManagerImpl2_Factory implements Factory<PassportStateManagerImpl2> {
    private final Provider<f> backgroundUserServiceProvider;
    private final Provider<t> executorsProvider;
    private final Provider<i> multiOnlineFGProvider;
    private final Provider<com.ss.android.lark.passportc.impl.v2.state.a> stateMachineFactoryProvider;
    private final Provider<d> updateVisitorProvider;
    private final Provider<p> userDataSourceProvider;

    public PassportStateManagerImpl2 get() {
        return newInstance((p) this.userDataSourceProvider.get(), (t) this.executorsProvider.get(), (i) this.multiOnlineFGProvider.get(), (f) this.backgroundUserServiceProvider.get(), (com.ss.android.lark.passportc.impl.v2.state.a) this.stateMachineFactoryProvider.get(), (d) this.updateVisitorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m709get() {
        return get();
    }

    public PassportStateManagerImpl2_Factory(Provider<p> r1, Provider<t> r2, Provider<i> r3, Provider<f> r4, Provider<com.ss.android.lark.passportc.impl.v2.state.a> r5, Provider<d> r6) {
        this.userDataSourceProvider = r1;
        this.executorsProvider = r2;
        this.multiOnlineFGProvider = r3;
        this.backgroundUserServiceProvider = r4;
        this.stateMachineFactoryProvider = r5;
        this.updateVisitorProvider = r6;
    }

    public static PassportStateManagerImpl2_Factory create(Provider<p> r8, Provider<t> r9, Provider<i> r10, Provider<f> r11, Provider<com.ss.android.lark.passportc.impl.v2.state.a> r12, Provider<d> r13) {
        return new PassportStateManagerImpl2_Factory(r8, r9, r10, r11, r12, r13);
    }

    public static PassportStateManagerImpl2 newInstance(p r8, t r9, i r10, f r11, com.ss.android.lark.passportc.impl.v2.state.a r12, d r13) {
        return new PassportStateManagerImpl2(r8, r9, r10, r11, r12, r13);
    }
}
