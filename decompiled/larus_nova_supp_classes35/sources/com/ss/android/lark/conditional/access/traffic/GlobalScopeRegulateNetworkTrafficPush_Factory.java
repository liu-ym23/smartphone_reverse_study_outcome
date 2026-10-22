package com.ss.android.lark.conditional.access.traffic;

import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class GlobalScopeRegulateNetworkTrafficPush_Factory implements Factory<a> {
    private final Provider<jdb.e> fgServiceProvider;
    private final Provider<j> passportProvider;

    public a get() {
        return newInstance((j) this.passportProvider.get(), (jdb.e) this.fgServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m996get() {
        return get();
    }

    public GlobalScopeRegulateNetworkTrafficPush_Factory(Provider<j> r1, Provider<jdb.e> r2) {
        this.passportProvider = r1;
        this.fgServiceProvider = r2;
    }

    public static GlobalScopeRegulateNetworkTrafficPush_Factory create(Provider<j> r1, Provider<jdb.e> r2) {
        return new GlobalScopeRegulateNetworkTrafficPush_Factory(r1, r2);
    }

    public static a newInstance(j r1, jdb.e r2) {
        return new a(r1, r2);
    }
}
