package com.ss.android.lark.chat.chatwindow.chat.preloaderv2;

import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.DataPreLoaderType;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DataPreloadEngineV2_Factory implements Factory<DataPreloadEngineV2> {
    private final Provider<Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>>> loadersProvider;
    private final Provider<m> passportProvider;

    public DataPreloadEngineV2 get() {
        return newInstance((m) this.passportProvider.get(), (Map) this.loadersProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m322get() {
        return get();
    }

    public DataPreloadEngineV2_Factory(Provider<m> r1, Provider<Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>>> r2) {
        this.passportProvider = r1;
        this.loadersProvider = r2;
    }

    public static DataPreloadEngineV2_Factory create(Provider<m> r1, Provider<Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>>> r2) {
        return new DataPreloadEngineV2_Factory(r1, r2);
    }

    public static DataPreloadEngineV2 newInstance(m r1, Map<DataPreLoaderType, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<? extends w3b.d<?>, ?>>> r2) {
        return new DataPreloadEngineV2(r1, r2);
    }
}
