package com.ss.android.lark.docs.icon.net;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;
import qbb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class RustMetaFetcherImpl_Factory implements Factory<b> {
    private final Provider<l> userClientProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public b m1138get() {
        return newInstance((l) this.userClientProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1138get();
    }

    public RustMetaFetcherImpl_Factory(Provider<l> r1) {
        this.userClientProvider = r1;
    }

    public static RustMetaFetcherImpl_Factory create(Provider<l> r1) {
        return new RustMetaFetcherImpl_Factory(r1);
    }

    public static b newInstance(l r1) {
        return new b(r1);
    }
}
