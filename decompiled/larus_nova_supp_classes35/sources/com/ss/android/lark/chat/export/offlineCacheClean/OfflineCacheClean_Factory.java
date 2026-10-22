package com.ss.android.lark.chat.export.offlineCacheClean;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class OfflineCacheClean_Factory implements Factory<OfflineCacheClean> {
    private final Provider<g> fgServiceProvider;
    private final Provider<m> passportProvider;
    private final Provider<b38.b> rucketProvider;

    public OfflineCacheClean get() {
        return newInstance((m) this.passportProvider.get(), (g) this.fgServiceProvider.get(), (b38.b) this.rucketProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m535get() {
        return get();
    }

    public OfflineCacheClean_Factory(Provider<m> r1, Provider<g> r2, Provider<b38.b> r3) {
        this.passportProvider = r1;
        this.fgServiceProvider = r2;
        this.rucketProvider = r3;
    }

    public static OfflineCacheClean_Factory create(Provider<m> r1, Provider<g> r2, Provider<b38.b> r3) {
        return new OfflineCacheClean_Factory(r1, r2, r3);
    }

    public static OfflineCacheClean newInstance(m r1, g r2, b38.b r3) {
        return new OfflineCacheClean(r1, r2, r3);
    }
}
