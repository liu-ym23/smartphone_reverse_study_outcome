package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader;

import com.ss.android.lark.im.sdk.service.p;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatWindowDataPreLoaderV2_Factory implements Factory<b> {
    private final Provider<p> messageServiceProvider;

    public b get() {
        return newInstance((p) this.messageServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m329get() {
        return get();
    }

    public ChatWindowDataPreLoaderV2_Factory(Provider<p> r1) {
        this.messageServiceProvider = r1;
    }

    public static ChatWindowDataPreLoaderV2_Factory create(Provider<p> r1) {
        return new ChatWindowDataPreLoaderV2_Factory(r1);
    }

    public static b newInstance(p r1) {
        return new b(r1);
    }
}
