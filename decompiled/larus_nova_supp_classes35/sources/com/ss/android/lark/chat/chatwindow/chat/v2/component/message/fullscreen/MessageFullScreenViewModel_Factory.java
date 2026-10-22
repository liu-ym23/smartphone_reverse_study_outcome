package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageFullScreenViewModel_Factory implements Factory<MessageFullScreenViewModel> {
    private final Provider<jdb.g> fgServiceProvider;
    private final Provider<com.ss.android.lark.im.sdk.service.p> messageServiceProvider;

    public MessageFullScreenViewModel get() {
        return newInstance((com.ss.android.lark.im.sdk.service.p) this.messageServiceProvider.get(), (jdb.g) this.fgServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m381get() {
        return get();
    }

    public MessageFullScreenViewModel_Factory(Provider<com.ss.android.lark.im.sdk.service.p> r1, Provider<jdb.g> r2) {
        this.messageServiceProvider = r1;
        this.fgServiceProvider = r2;
    }

    public static MessageFullScreenViewModel_Factory create(Provider<com.ss.android.lark.im.sdk.service.p> r1, Provider<jdb.g> r2) {
        return new MessageFullScreenViewModel_Factory(r1, r2);
    }

    public static MessageFullScreenViewModel newInstance(com.ss.android.lark.im.sdk.service.p r1, jdb.g r2) {
        return new MessageFullScreenViewModel(r1, r2);
    }
}
