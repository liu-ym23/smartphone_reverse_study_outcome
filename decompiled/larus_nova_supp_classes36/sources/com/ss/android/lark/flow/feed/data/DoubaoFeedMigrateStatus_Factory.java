package com.ss.android.lark.flow.feed.data;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DoubaoFeedMigrateStatus_Factory implements Factory<DoubaoFeedMigrateStatus> {
    private final Provider<String> currentUserIdProvider;
    private final Provider<m> passportProvider;
    private final Provider<l> userRustClientProvider;

    public DoubaoFeedMigrateStatus get() {
        return newInstance((String) this.currentUserIdProvider.get(), (l) this.userRustClientProvider.get(), (m) this.passportProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m387get() {
        return get();
    }

    public DoubaoFeedMigrateStatus_Factory(Provider<String> r1, Provider<l> r2, Provider<m> r3) {
        this.currentUserIdProvider = r1;
        this.userRustClientProvider = r2;
        this.passportProvider = r3;
    }

    public static DoubaoFeedMigrateStatus_Factory create(Provider<String> r1, Provider<l> r2, Provider<m> r3) {
        return new DoubaoFeedMigrateStatus_Factory(r1, r2, r3);
    }

    public static DoubaoFeedMigrateStatus newInstance(String r1, l r2, m r3) {
        return new DoubaoFeedMigrateStatus(r1, r2, r3);
    }
}
