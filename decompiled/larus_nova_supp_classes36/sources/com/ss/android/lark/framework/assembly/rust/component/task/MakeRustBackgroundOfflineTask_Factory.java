package com.ss.android.lark.framework.assembly.rust.component.task;

import com.bytedance.lark.rustclient.internal.l;
import com.bytedance.lark.rustclient.internal.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import jjb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MakeRustBackgroundOfflineTask_Factory implements Factory<a> {
    private final Provider<l> dispatcherProvider;
    private final Provider<m> registryProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m695get() {
        return newInstance((m) this.registryProvider.get(), (l) this.dispatcherProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m695get();
    }

    public MakeRustBackgroundOfflineTask_Factory(Provider<m> r1, Provider<l> r2) {
        this.registryProvider = r1;
        this.dispatcherProvider = r2;
    }

    public static MakeRustBackgroundOfflineTask_Factory create(Provider<m> r1, Provider<l> r2) {
        return new MakeRustBackgroundOfflineTask_Factory(r1, r2);
    }

    public static a newInstance(m r1, l r2) {
        return new a(r1, r2);
    }
}
