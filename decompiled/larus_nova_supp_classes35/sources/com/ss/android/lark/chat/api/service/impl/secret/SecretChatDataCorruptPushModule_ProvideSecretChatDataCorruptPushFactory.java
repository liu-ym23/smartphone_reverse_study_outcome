package com.ss.android.lark.chat.api.service.impl.secret;

import a2b.i;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SecretChatDataCorruptPushModule_ProvideSecretChatDataCorruptPushFactory implements Factory<i> {
    private final Provider<v> accessorProvider;
    private final a module;
    private final Provider<j> passportProvider;

    public i get() {
        return provideSecretChatDataCorruptPush(this.module, (j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m97get() {
        return get();
    }

    public SecretChatDataCorruptPushModule_ProvideSecretChatDataCorruptPushFactory(a r1, Provider<j> r2, Provider<v> r3) {
        this.module = r1;
        this.passportProvider = r2;
        this.accessorProvider = r3;
    }

    public static SecretChatDataCorruptPushModule_ProvideSecretChatDataCorruptPushFactory create(a r1, Provider<j> r2, Provider<v> r3) {
        return new SecretChatDataCorruptPushModule_ProvideSecretChatDataCorruptPushFactory(r1, r2, r3);
    }

    public static i provideSecretChatDataCorruptPush(a r0, j r1, v r2) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        SecretChatDataCorruptPushProxy r3 = new SecretChatDataCorruptPushProxy(r1, r2);
        h.a(r3);
        return (i) Preconditions.checkNotNullFromProvides(r3);
    }
}
