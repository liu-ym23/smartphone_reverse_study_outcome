package com.ss.android.lark.flow.chat.page;

import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ChatFragment_Factory implements Factory<ChatFragment> {
    private final Provider<oya.a> chatFragmentFactoryProvider;
    private final Provider<d> dataPreLoaderV2Provider;
    private final Provider<g> fgServiceProvider;

    public static ChatFragment newInstance() {
        return new ChatFragment();
    }

    public ChatFragment get() {
        ChatFragment r0 = newInstance();
        r0.g = (oya.a) this.chatFragmentFactoryProvider.get();
        r0.h = (g) this.fgServiceProvider.get();
        r0.i = (d) this.dataPreLoaderV2Provider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m115get() {
        return get();
    }

    public ChatFragment_Factory(Provider<oya.a> r1, Provider<g> r2, Provider<d> r3) {
        this.chatFragmentFactoryProvider = r1;
        this.fgServiceProvider = r2;
        this.dataPreLoaderV2Provider = r3;
    }

    public static ChatFragment_Factory create(Provider<oya.a> r1, Provider<g> r2, Provider<d> r3) {
        return new ChatFragment_Factory(r1, r2, r3);
    }
}
