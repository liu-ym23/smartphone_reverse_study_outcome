package com.ss.android.lark.framework.assembly.rust.component.task;

import com.bytedance.lark.rustclient.internal.l;
import com.bytedance.lark.rustclient.internal.m;
import com.bytedance.lark.sdk.refactor.n;
import dagger.internal.Factory;
import javax.inject.Provider;
import jjb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MakeRustOfflineTask_Factory implements Factory<e> {
    private final Provider<l> dispatcherProvider;
    private final Provider<m> registryProvider;
    private final Provider<n> rustSdkProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public e m697get() {
        return newInstance((m) this.registryProvider.get(), (l) this.dispatcherProvider.get(), (n) this.rustSdkProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m697get();
    }

    public MakeRustOfflineTask_Factory(Provider<m> r1, Provider<l> r2, Provider<n> r3) {
        this.registryProvider = r1;
        this.dispatcherProvider = r2;
        this.rustSdkProvider = r3;
    }

    public static MakeRustOfflineTask_Factory create(Provider<m> r1, Provider<l> r2, Provider<n> r3) {
        return new MakeRustOfflineTask_Factory(r1, r2, r3);
    }

    public static e newInstance(m r1, l r2, n r3) {
        return new e(r1, r2, r3);
    }
}
