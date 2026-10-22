package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MakeOnlineV2RequestFactory_Factory implements Factory<p> {
    private final Provider<jdb.e> globalFgServiceProvider;
    private final Provider<apb.a> globalLanguageServiceProvider;

    public p get() {
        return newInstance((jdb.e) this.globalFgServiceProvider.get(), (apb.a) this.globalLanguageServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m682get() {
        return get();
    }

    public MakeOnlineV2RequestFactory_Factory(Provider<jdb.e> r1, Provider<apb.a> r2) {
        this.globalFgServiceProvider = r1;
        this.globalLanguageServiceProvider = r2;
    }

    public static MakeOnlineV2RequestFactory_Factory create(Provider<jdb.e> r1, Provider<apb.a> r2) {
        return new MakeOnlineV2RequestFactory_Factory(r1, r2);
    }

    public static p newInstance(jdb.e r1, apb.a r2) {
        return new p(r1, r2);
    }
}
