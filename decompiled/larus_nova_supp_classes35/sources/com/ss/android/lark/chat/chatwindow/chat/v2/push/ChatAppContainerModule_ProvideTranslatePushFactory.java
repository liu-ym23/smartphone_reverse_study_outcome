package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.translate.service.impl.TranslatePushProxy;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatAppContainerModule_ProvideTranslatePushFactory implements Factory<com.ss.android.lark.translate.service.impl.a> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final a module;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    public com.ss.android.lark.translate.service.impl.a get() {
        return provideTranslatePush(this.module, (com.ss.android.lark.passportc.api.j) this.passportProvider.get(), (com.ss.android.lark.passportc.internal.v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m474get() {
        return get();
    }

    public ChatAppContainerModule_ProvideTranslatePushFactory(a r1, Provider<com.ss.android.lark.passportc.api.j> r2, Provider<com.ss.android.lark.passportc.internal.v> r3) {
        this.module = r1;
        this.passportProvider = r2;
        this.accessorProvider = r3;
    }

    public static ChatAppContainerModule_ProvideTranslatePushFactory create(a r1, Provider<com.ss.android.lark.passportc.api.j> r2, Provider<com.ss.android.lark.passportc.internal.v> r3) {
        return new ChatAppContainerModule_ProvideTranslatePushFactory(r1, r2, r3);
    }

    public static com.ss.android.lark.translate.service.impl.a provideTranslatePush(a r0, com.ss.android.lark.passportc.api.j r1, com.ss.android.lark.passportc.internal.v r2) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        TranslatePushProxy r3 = new TranslatePushProxy(r1, r2);
        com.ss.android.lark.passportc.api.h.a(r3);
        return (com.ss.android.lark.translate.service.impl.a) Preconditions.checkNotNullFromProvides(r3);
    }
}
