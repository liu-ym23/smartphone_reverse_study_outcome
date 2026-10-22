package com.ss.android.lark.reaction.service.impl;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ReactionOrderService2_Factory implements Factory<ReactionOrderService2> {
    private final Provider<rsb.a> emojiMapManagerProvider;
    private final Provider<rsb.b> emojiServiceProvider;
    private final Provider<m> passportProvider;
    private final Provider<m2c.b> reactionServiceProvider;
    private final Provider<l> rustClientProvider;
    private final Provider<g> userFeatureGatingServiceProvider;

    public ReactionOrderService2 get() {
        return newInstance((m) this.passportProvider.get(), (l) this.rustClientProvider.get(), (rsb.b) this.emojiServiceProvider.get(), (rsb.a) this.emojiMapManagerProvider.get(), (m2c.b) this.reactionServiceProvider.get(), (g) this.userFeatureGatingServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3462get() {
        return get();
    }

    public ReactionOrderService2_Factory(Provider<m> r1, Provider<l> r2, Provider<rsb.b> r3, Provider<rsb.a> r4, Provider<m2c.b> r5, Provider<g> r6) {
        this.passportProvider = r1;
        this.rustClientProvider = r2;
        this.emojiServiceProvider = r3;
        this.emojiMapManagerProvider = r4;
        this.reactionServiceProvider = r5;
        this.userFeatureGatingServiceProvider = r6;
    }

    public static ReactionOrderService2_Factory create(Provider<m> r8, Provider<l> r9, Provider<rsb.b> r10, Provider<rsb.a> r11, Provider<m2c.b> r12, Provider<g> r13) {
        return new ReactionOrderService2_Factory(r8, r9, r10, r11, r12, r13);
    }

    public static ReactionOrderService2 newInstance(m r8, l r9, rsb.b r10, rsb.a r11, m2c.b r12, g r13) {
        return new ReactionOrderService2(r8, r9, r10, r11, r12, r13);
    }
}
