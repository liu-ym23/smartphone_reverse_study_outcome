package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatAppContainerUserModule_ProvideChatAppContainerFactory implements Factory<v> {
    private final Provider<ChatAppContainerV2> chatAppContainerV2Provider;
    private final b module;

    public v get() {
        return provideChatAppContainer(this.module, (ChatAppContainerV2) this.chatAppContainerV2Provider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m479get() {
        return get();
    }

    public ChatAppContainerUserModule_ProvideChatAppContainerFactory(b r1, Provider<ChatAppContainerV2> r2) {
        this.module = r1;
        this.chatAppContainerV2Provider = r2;
    }

    public static ChatAppContainerUserModule_ProvideChatAppContainerFactory create(b r1, Provider<ChatAppContainerV2> r2) {
        return new ChatAppContainerUserModule_ProvideChatAppContainerFactory(r1, r2);
    }

    public static v provideChatAppContainer(b r0, ChatAppContainerV2 r1) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "chatAppContainerV2");
        return (v) Preconditions.checkNotNullFromProvides(r1);
    }
}
