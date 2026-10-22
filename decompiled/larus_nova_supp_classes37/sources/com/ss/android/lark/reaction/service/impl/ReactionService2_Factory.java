package com.ss.android.lark.reaction.service.impl;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ReactionService2_Factory implements Factory<ReactionService2> {
    private final Provider<m> passportProvider;
    private final Provider<l> rustClientProvider;

    public ReactionService2 get() {
        return newInstance((m) this.passportProvider.get(), (l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3463get() {
        return get();
    }

    public ReactionService2_Factory(Provider<m> r1, Provider<l> r2) {
        this.passportProvider = r1;
        this.rustClientProvider = r2;
    }

    public static ReactionService2_Factory create(Provider<m> r1, Provider<l> r2) {
        return new ReactionService2_Factory(r1, r2);
    }

    public static ReactionService2 newInstance(m r1, l r2) {
        return new ReactionService2(r1, r2);
    }
}
