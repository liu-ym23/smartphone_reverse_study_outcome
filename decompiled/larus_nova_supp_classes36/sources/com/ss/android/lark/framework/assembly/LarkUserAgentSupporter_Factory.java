package com.ss.android.lark.framework.assembly;

import android.content.Context;
import bjb.f;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LarkUserAgentSupporter_Factory implements Factory<f> {
    private final Provider<Context> contextProvider;

    public f get() {
        return newInstance((Context) this.contextProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m650get() {
        return get();
    }

    public LarkUserAgentSupporter_Factory(Provider<Context> r1) {
        this.contextProvider = r1;
    }

    public static LarkUserAgentSupporter_Factory create(Provider<Context> r1) {
        return new LarkUserAgentSupporter_Factory(r1);
    }

    public static f newInstance(Context r1) {
        return new f(r1);
    }
}
