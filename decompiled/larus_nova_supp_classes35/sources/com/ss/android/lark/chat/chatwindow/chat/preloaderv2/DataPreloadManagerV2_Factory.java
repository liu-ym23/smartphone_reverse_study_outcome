package com.ss.android.lark.chat.chatwindow.chat.preloaderv2;

import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.DataPreLoaderType;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DataPreloadManagerV2_Factory implements Factory<DataPreloadManagerV2> {
    private final Provider<c> engineProvider;
    private final Provider<Map<DataPreLoaderType, Provider<v3b.d<? extends w3b.d<?>, ?>>>> keyProvidersProvider;
    private final Provider<Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>>> loadersProvider;
    private final Provider<m> passportProvider;

    public DataPreloadManagerV2 get() {
        return newInstance((c) this.engineProvider.get(), (Map) this.loadersProvider.get(), (Map) this.keyProvidersProvider.get(), (m) this.passportProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m325get() {
        return get();
    }

    public DataPreloadManagerV2_Factory(Provider<c> r1, Provider<Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>>> r2, Provider<Map<DataPreLoaderType, Provider<v3b.d<? extends w3b.d<?>, ?>>>> r3, Provider<m> r4) {
        this.engineProvider = r1;
        this.loadersProvider = r2;
        this.keyProvidersProvider = r3;
        this.passportProvider = r4;
    }

    public static DataPreloadManagerV2_Factory create(Provider<c> r1, Provider<Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>>> r2, Provider<Map<DataPreLoaderType, Provider<v3b.d<? extends w3b.d<?>, ?>>>> r3, Provider<m> r4) {
        return new DataPreloadManagerV2_Factory(r1, r2, r3, r4);
    }

    public static DataPreloadManagerV2 newInstance(c r1, Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>> r2, Map<DataPreLoaderType, Provider<v3b.d<? extends w3b.d<?>, ?>>> r3, m r4) {
        return new DataPreloadManagerV2(r1, r2, r3, r4);
    }
}
