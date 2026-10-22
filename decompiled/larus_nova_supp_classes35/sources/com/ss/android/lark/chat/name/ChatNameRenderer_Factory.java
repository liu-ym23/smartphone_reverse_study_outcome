package com.ss.android.lark.chat.name;

import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.api.service.ITranslateService;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatNameRenderer_Factory implements Factory<a> {
    private final Provider<IChatService> chatServiceProvider;
    private final Provider<g> fgServiceProvider;
    private final Provider<ITranslateService> translateServiceProvider;

    public a get() {
        return newInstance((IChatService) this.chatServiceProvider.get(), (ITranslateService) this.translateServiceProvider.get(), (g) this.fgServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m650get() {
        return get();
    }

    public ChatNameRenderer_Factory(Provider<IChatService> r1, Provider<ITranslateService> r2, Provider<g> r3) {
        this.chatServiceProvider = r1;
        this.translateServiceProvider = r2;
        this.fgServiceProvider = r3;
    }

    public static ChatNameRenderer_Factory create(Provider<IChatService> r1, Provider<ITranslateService> r2, Provider<g> r3) {
        return new ChatNameRenderer_Factory(r1, r2, r3);
    }

    public static a newInstance(IChatService r1, ITranslateService r2, g r3) {
        return new a(r1, r2, r3);
    }
}
