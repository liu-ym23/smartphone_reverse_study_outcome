package com.ss.android.lark.framework.assembly.rust.component.task;

import com.bytedance.lark.rustclient.internal.l;
import com.bytedance.lark.rustclient.internal.m;
import com.bytedance.lark.sdk.refactor.n;
import com.ss.android.lark.framework.assembly.rust.d;
import com.ss.android.lark.framework.assembly.rust.p;
import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import dagger.internal.Factory;
import javax.inject.Provider;
import jjb.h;
import jzb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MakeRustOnlineTask_Factory implements Factory<h> {
    private final Provider<IAppStateSyncService> appStateServiceProvider;
    private final Provider<a> deviceServiceProvider;
    private final Provider<l> dispatcherProvider;
    private final Provider<p> makeOnlineRequestFactoryProvider;
    private final Provider<d> onlineRequestParamsFactoryProvider;
    private final Provider<m> registryProvider;
    private final Provider<com.bytedance.lark.rustclient.api.l> rustClientProvider;
    private final Provider<n> rustSdkProvider;
    private final Provider<yzb.a> userApiProvider;
    private final Provider<k3c.a> userStoreServiceProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public h m698get() {
        h r0 = newInstance((com.bytedance.lark.rustclient.api.l) this.rustClientProvider.get(), (l) this.dispatcherProvider.get(), (m) this.registryProvider.get(), (yzb.a) this.userApiProvider.get(), (a) this.deviceServiceProvider.get(), (n) this.rustSdkProvider.get(), (k3c.a) this.userStoreServiceProvider.get(), (IAppStateSyncService) this.appStateServiceProvider.get());
        r0.i = (p) this.makeOnlineRequestFactoryProvider.get();
        r0.j = (d) this.onlineRequestParamsFactoryProvider.get();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m698get();
    }

    public static h newInstance(com.bytedance.lark.rustclient.api.l r10, l r11, m r12, yzb.a r13, a r14, n r15, k3c.a r16, IAppStateSyncService r17) {
        return new h(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public MakeRustOnlineTask_Factory(Provider<com.bytedance.lark.rustclient.api.l> r1, Provider<l> r2, Provider<m> r3, Provider<yzb.a> r4, Provider<a> r5, Provider<n> r6, Provider<k3c.a> r7, Provider<IAppStateSyncService> r8, Provider<p> r9, Provider<d> r10) {
        this.rustClientProvider = r1;
        this.dispatcherProvider = r2;
        this.registryProvider = r3;
        this.userApiProvider = r4;
        this.deviceServiceProvider = r5;
        this.rustSdkProvider = r6;
        this.userStoreServiceProvider = r7;
        this.appStateServiceProvider = r8;
        this.makeOnlineRequestFactoryProvider = r9;
        this.onlineRequestParamsFactoryProvider = r10;
    }

    public static MakeRustOnlineTask_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r12, Provider<l> r13, Provider<m> r14, Provider<yzb.a> r15, Provider<a> r16, Provider<n> r17, Provider<k3c.a> r18, Provider<IAppStateSyncService> r19, Provider<p> r20, Provider<d> r21) {
        return new MakeRustOnlineTask_Factory(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }
}
