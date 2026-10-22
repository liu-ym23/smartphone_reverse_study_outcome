package com.ss.android.lark.chat.cot;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CotFeatureGate_Factory implements Factory<a> {
    private final Provider<jdb.g> fgServiceProvider;

    public a get() {
        return newInstance((jdb.g) this.fgServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m500get() {
        return get();
    }

    public CotFeatureGate_Factory(Provider<jdb.g> r1) {
        this.fgServiceProvider = r1;
    }

    public static CotFeatureGate_Factory create(Provider<jdb.g> r1) {
        return new CotFeatureGate_Factory(r1);
    }

    public static a newInstance(jdb.g r1) {
        return new a(r1);
    }
}
