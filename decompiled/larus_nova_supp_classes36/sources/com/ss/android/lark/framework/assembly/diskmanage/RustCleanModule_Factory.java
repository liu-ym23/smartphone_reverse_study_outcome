package com.ss.android.lark.framework.assembly.diskmanage;

import com.bytedance.lark.rustclient.api.h;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class RustCleanModule_Factory implements Factory<RustCleanModule> {
    private final Provider<h> rustClientProvider;

    public RustCleanModule get() {
        return newInstance((h) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m656get() {
        return get();
    }

    public RustCleanModule_Factory(Provider<h> r1) {
        this.rustClientProvider = r1;
    }

    public static RustCleanModule_Factory create(Provider<h> r1) {
        return new RustCleanModule_Factory(r1);
    }

    public static RustCleanModule newInstance(h r1) {
        return new RustCleanModule(r1);
    }
}
