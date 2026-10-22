package com.ss.android.lark.chat.api.service.impl.secret;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SecretChatDataCorruptPush_Factory implements Factory<SecretChatDataCorruptPush> {
    private final Provider<String> currentUserIdProvider;
    private final Provider<l> userClientProvider;

    public SecretChatDataCorruptPush get() {
        return newInstance((String) this.currentUserIdProvider.get(), (l) this.userClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m98get() {
        return get();
    }

    public SecretChatDataCorruptPush_Factory(Provider<String> r1, Provider<l> r2) {
        this.currentUserIdProvider = r1;
        this.userClientProvider = r2;
    }

    public static SecretChatDataCorruptPush_Factory create(Provider<String> r1, Provider<l> r2) {
        return new SecretChatDataCorruptPush_Factory(r1, r2);
    }

    public static SecretChatDataCorruptPush newInstance(String r1, l r2) {
        return new SecretChatDataCorruptPush(r1, r2);
    }
}
