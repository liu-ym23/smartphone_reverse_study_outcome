package com.ss.android.lark.newemoji.impl;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class EmojiMapManager2_Factory implements Factory<EmojiMapManager2> {
    private final Provider<m> passportProvider;

    public EmojiMapManager2 get() {
        return newInstance((m) this.passportProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1507get() {
        return get();
    }

    public EmojiMapManager2_Factory(Provider<m> r1) {
        this.passportProvider = r1;
    }

    public static EmojiMapManager2_Factory create(Provider<m> r1) {
        return new EmojiMapManager2_Factory(r1);
    }

    public static EmojiMapManager2 newInstance(m r1) {
        return new EmojiMapManager2(r1);
    }
}
