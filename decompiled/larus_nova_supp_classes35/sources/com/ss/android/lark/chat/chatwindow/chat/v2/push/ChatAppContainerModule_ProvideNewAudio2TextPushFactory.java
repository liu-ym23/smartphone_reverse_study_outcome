package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.service.impl.NewAudio2TextPushProxy;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatAppContainerModule_ProvideNewAudio2TextPushFactory implements Factory<com.ss.android.lark.audio.voiceinput.service.l> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final a module;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    public com.ss.android.lark.audio.voiceinput.service.l get() {
        return provideNewAudio2TextPush(this.module, (com.ss.android.lark.passportc.api.j) this.passportProvider.get(), (com.ss.android.lark.passportc.internal.v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m463get() {
        return get();
    }

    public ChatAppContainerModule_ProvideNewAudio2TextPushFactory(a r1, Provider<com.ss.android.lark.passportc.api.j> r2, Provider<com.ss.android.lark.passportc.internal.v> r3) {
        this.module = r1;
        this.passportProvider = r2;
        this.accessorProvider = r3;
    }

    public static ChatAppContainerModule_ProvideNewAudio2TextPushFactory create(a r1, Provider<com.ss.android.lark.passportc.api.j> r2, Provider<com.ss.android.lark.passportc.internal.v> r3) {
        return new ChatAppContainerModule_ProvideNewAudio2TextPushFactory(r1, r2, r3);
    }

    public static com.ss.android.lark.audio.voiceinput.service.l provideNewAudio2TextPush(a r0, com.ss.android.lark.passportc.api.j r1, com.ss.android.lark.passportc.internal.v r2) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        NewAudio2TextPushProxy r3 = new NewAudio2TextPushProxy(r1, r2);
        com.ss.android.lark.passportc.api.h.a(r3);
        return (com.ss.android.lark.audio.voiceinput.service.l) Preconditions.checkNotNullFromProvides(r3);
    }
}
