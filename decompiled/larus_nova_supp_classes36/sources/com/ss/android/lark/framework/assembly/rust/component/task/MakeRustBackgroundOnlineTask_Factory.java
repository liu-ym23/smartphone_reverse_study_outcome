package com.ss.android.lark.framework.assembly.rust.component.task;

import com.bytedance.lark.rustclient.internal.l;
import com.bytedance.lark.rustclient.internal.m;
import com.bytedance.lark.sdk.refactor.n;
import com.ss.android.lark.framework.assembly.rust.p;
import dagger.internal.Factory;
import javax.inject.Provider;
import jjb.c;
import jzb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MakeRustBackgroundOnlineTask_Factory implements Factory<c> {
    private final Provider<a> deviceServiceProvider;
    private final Provider<l> dispatcherProvider;
    private final Provider<p> makeOnlineRequestFactoryProvider;
    private final Provider<m> registryProvider;
    private final Provider<com.bytedance.lark.rustclient.api.l> rustClientProvider;
    private final Provider<n> rustSdkProvider;
    private final Provider<yzb.a> userApiProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public c m696get() {
        c r0 = newInstance((com.bytedance.lark.rustclient.api.l) this.rustClientProvider.get(), (l) this.dispatcherProvider.get(), (m) this.registryProvider.get(), (yzb.a) this.userApiProvider.get(), (a) this.deviceServiceProvider.get(), (n) this.rustSdkProvider.get());
        r0.g = (p) this.makeOnlineRequestFactoryProvider.get();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m696get();
    }

    public static c newInstance(com.bytedance.lark.rustclient.api.l r8, l r9, m r10, yzb.a r11, a r12, n r13) {
        return new c(r8, r9, r10, r11, r12, r13);
    }

    public MakeRustBackgroundOnlineTask_Factory(Provider<com.bytedance.lark.rustclient.api.l> r1, Provider<l> r2, Provider<m> r3, Provider<yzb.a> r4, Provider<a> r5, Provider<n> r6, Provider<p> r7) {
        this.rustClientProvider = r1;
        this.dispatcherProvider = r2;
        this.registryProvider = r3;
        this.userApiProvider = r4;
        this.deviceServiceProvider = r5;
        this.rustSdkProvider = r6;
        this.makeOnlineRequestFactoryProvider = r7;
    }

    public static MakeRustBackgroundOnlineTask_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r9, Provider<l> r10, Provider<m> r11, Provider<yzb.a> r12, Provider<a> r13, Provider<n> r14, Provider<p> r15) {
        return new MakeRustBackgroundOnlineTask_Factory(r9, r10, r11, r12, r13, r14, r15);
    }
}
