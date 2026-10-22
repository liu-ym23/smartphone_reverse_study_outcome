package com.ss.android.lark.newemoji.impl;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class EmojiService2_Factory implements Factory<EmojiService2> {
    private final Provider<rsb.a> emojiMapManagerProvider;
    private final Provider<m> passportProvider;
    private final Provider<l> rustClientProvider;

    public EmojiService2 get() {
        return newInstance((m) this.passportProvider.get(), (l) this.rustClientProvider.get(), (rsb.a) this.emojiMapManagerProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1508get() {
        return get();
    }

    public EmojiService2_Factory(Provider<m> r1, Provider<l> r2, Provider<rsb.a> r3) {
        this.passportProvider = r1;
        this.rustClientProvider = r2;
        this.emojiMapManagerProvider = r3;
    }

    public static EmojiService2_Factory create(Provider<m> r1, Provider<l> r2, Provider<rsb.a> r3) {
        return new EmojiService2_Factory(r1, r2, r3);
    }

    public static EmojiService2 newInstance(m r1, l r2, rsb.a r3) {
        return new EmojiService2(r1, r2, r3);
    }
}
