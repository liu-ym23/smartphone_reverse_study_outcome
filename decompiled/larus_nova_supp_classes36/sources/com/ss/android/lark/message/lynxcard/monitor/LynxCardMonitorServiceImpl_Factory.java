package com.ss.android.lark.message.lynxcard.monitor;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LynxCardMonitorServiceImpl_Factory implements Factory<LynxCardMonitorServiceImpl> {
    private final Provider<l> rustClientProvider;

    public LynxCardMonitorServiceImpl get() {
        return newInstance((l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1458get() {
        return get();
    }

    public LynxCardMonitorServiceImpl_Factory(Provider<l> r1) {
        this.rustClientProvider = r1;
    }

    public static LynxCardMonitorServiceImpl_Factory create(Provider<l> r1) {
        return new LynxCardMonitorServiceImpl_Factory(r1);
    }

    public static LynxCardMonitorServiceImpl newInstance(l r1) {
        return new LynxCardMonitorServiceImpl(r1);
    }
}
