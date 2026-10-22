package com.ss.android.lark.framework.assembly.rust;

import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class InitImSdkTask_Factory implements Factory<InitImSdkTask> {
    private final Provider<IAppStateSyncService> appStateSyncServiceProvider;
    private final Provider<epb.a> deviceIdApiProvider;
    private final Provider<c3c.d.b> perfBoostDispatcherProvider;
    private final Provider<c3c.d.d> preloadDependencyProvider;
    private final Provider<com.bytedance.lark.sdk.refactor.n> rustSDKProvider;

    public InitImSdkTask get() {
        return newInstance(this.appStateSyncServiceProvider, this.rustSDKProvider, this.perfBoostDispatcherProvider, this.preloadDependencyProvider, this.deviceIdApiProvider);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m677get() {
        return get();
    }

    public InitImSdkTask_Factory(Provider<IAppStateSyncService> r1, Provider<com.bytedance.lark.sdk.refactor.n> r2, Provider<c3c.d.b> r3, Provider<c3c.d.d> r4, Provider<epb.a> r5) {
        this.appStateSyncServiceProvider = r1;
        this.rustSDKProvider = r2;
        this.perfBoostDispatcherProvider = r3;
        this.preloadDependencyProvider = r4;
        this.deviceIdApiProvider = r5;
    }

    public static InitImSdkTask_Factory create(Provider<IAppStateSyncService> r7, Provider<com.bytedance.lark.sdk.refactor.n> r8, Provider<c3c.d.b> r9, Provider<c3c.d.d> r10, Provider<epb.a> r11) {
        return new InitImSdkTask_Factory(r7, r8, r9, r10, r11);
    }

    public static InitImSdkTask newInstance(Provider<IAppStateSyncService> r7, Provider<com.bytedance.lark.sdk.refactor.n> r8, Provider<c3c.d.b> r9, Provider<c3c.d.d> r10, Provider<epb.a> r11) {
        return new InitImSdkTask(r7, r8, r9, r10, r11);
    }
}
