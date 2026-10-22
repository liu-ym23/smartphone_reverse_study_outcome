package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.service.impl.AudioTextPushProxy;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatAppContainerModule_ProvideAudioTextPushFactory implements Factory<m6b.a> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final a module;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public m6b.a m454get() {
        return provideAudioTextPush(this.module, (com.ss.android.lark.passportc.api.j) this.passportProvider.get(), (com.ss.android.lark.passportc.internal.v) this.accessorProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m454get();
    }

    public ChatAppContainerModule_ProvideAudioTextPushFactory(a r1, Provider<com.ss.android.lark.passportc.api.j> r2, Provider<com.ss.android.lark.passportc.internal.v> r3) {
        this.module = r1;
        this.passportProvider = r2;
        this.accessorProvider = r3;
    }

    public static ChatAppContainerModule_ProvideAudioTextPushFactory create(a r1, Provider<com.ss.android.lark.passportc.api.j> r2, Provider<com.ss.android.lark.passportc.internal.v> r3) {
        return new ChatAppContainerModule_ProvideAudioTextPushFactory(r1, r2, r3);
    }

    public static m6b.a provideAudioTextPush(a r0, com.ss.android.lark.passportc.api.j r1, com.ss.android.lark.passportc.internal.v r2) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        AudioTextPushProxy r3 = new AudioTextPushProxy(r1, r2);
        com.ss.android.lark.passportc.api.h.a(r3);
        return (m6b.a) Preconditions.checkNotNullFromProvides(r3);
    }
}
