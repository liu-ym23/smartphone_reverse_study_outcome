package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class RustMakeOnlineObserver_Factory implements Factory<w> {
    private final Provider<c3c.d.b> perfBoostDispatcherProvider;

    public w get() {
        return newInstance((c3c.d.b) this.perfBoostDispatcherProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m687get() {
        return get();
    }

    public RustMakeOnlineObserver_Factory(Provider<c3c.d.b> r1) {
        this.perfBoostDispatcherProvider = r1;
    }

    public static RustMakeOnlineObserver_Factory create(Provider<c3c.d.b> r1) {
        return new RustMakeOnlineObserver_Factory(r1);
    }

    public static w newInstance(c3c.d.b r1) {
        return new w(r1);
    }
}
