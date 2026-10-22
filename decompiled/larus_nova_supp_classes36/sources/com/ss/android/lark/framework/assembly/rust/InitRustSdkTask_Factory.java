package com.ss.android.lark.framework.assembly.rust;

import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class InitRustSdkTask_Factory implements Factory<InitRustSdkTask> {
    private final Provider<IAppStateSyncService> appStateSyncServiceProvider;
    private final Provider<com.bytedance.lark.sdk.refactor.n> rustSDKProvider;

    public InitRustSdkTask get() {
        return newInstance(this.rustSDKProvider, this.appStateSyncServiceProvider);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m679get() {
        return get();
    }

    public InitRustSdkTask_Factory(Provider<com.bytedance.lark.sdk.refactor.n> r1, Provider<IAppStateSyncService> r2) {
        this.rustSDKProvider = r1;
        this.appStateSyncServiceProvider = r2;
    }

    public static InitRustSdkTask_Factory create(Provider<com.bytedance.lark.sdk.refactor.n> r1, Provider<IAppStateSyncService> r2) {
        return new InitRustSdkTask_Factory(r1, r2);
    }

    public static InitRustSdkTask newInstance(Provider<com.bytedance.lark.sdk.refactor.n> r1, Provider<IAppStateSyncService> r2) {
        return new InitRustSdkTask(r1, r2);
    }
}
