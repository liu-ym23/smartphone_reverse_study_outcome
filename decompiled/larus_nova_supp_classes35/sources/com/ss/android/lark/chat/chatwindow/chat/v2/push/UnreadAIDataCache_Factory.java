package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UnreadAIDataCache_Factory implements Factory<n0> {
    private final Provider<com.ss.android.lark.passportc.api.m> passportProvider;

    public n0 get() {
        return newInstance((com.ss.android.lark.passportc.api.m) this.passportProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m489get() {
        return get();
    }

    public UnreadAIDataCache_Factory(Provider<com.ss.android.lark.passportc.api.m> r1) {
        this.passportProvider = r1;
    }

    public static UnreadAIDataCache_Factory create(Provider<com.ss.android.lark.passportc.api.m> r1) {
        return new UnreadAIDataCache_Factory(r1);
    }

    public static n0 newInstance(com.ss.android.lark.passportc.api.m r1) {
        return new n0(r1);
    }
}
