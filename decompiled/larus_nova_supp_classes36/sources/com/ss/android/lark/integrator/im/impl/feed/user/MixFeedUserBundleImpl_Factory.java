package com.ss.android.lark.integrator.im.impl.feed.user;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.feed.shared.page.t;
import com.ss.android.lark.feed.shared.page.u;
import com.ss.android.lark.flow.feed.data.a;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import vmb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MixFeedUserBundleImpl_Factory implements Factory<b> {
    private final Provider<a> doubaoFeedMigrateStatusProvider;
    private final Provider<t> feedItemsViewModelFactoryProvider;
    private final Provider<u> feedSidebarItemsViewModelFactoryProvider;
    private final Provider<m> passportProvider;
    private final Provider<l> rustClientProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public b m909get() {
        return newInstance((m) this.passportProvider.get(), (l) this.rustClientProvider.get(), (t) this.feedItemsViewModelFactoryProvider.get(), (u) this.feedSidebarItemsViewModelFactoryProvider.get(), (a) this.doubaoFeedMigrateStatusProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m909get();
    }

    public MixFeedUserBundleImpl_Factory(Provider<m> r1, Provider<l> r2, Provider<t> r3, Provider<u> r4, Provider<a> r5) {
        this.passportProvider = r1;
        this.rustClientProvider = r2;
        this.feedItemsViewModelFactoryProvider = r3;
        this.feedSidebarItemsViewModelFactoryProvider = r4;
        this.doubaoFeedMigrateStatusProvider = r5;
    }

    public static MixFeedUserBundleImpl_Factory create(Provider<m> r7, Provider<l> r8, Provider<t> r9, Provider<u> r10, Provider<a> r11) {
        return new MixFeedUserBundleImpl_Factory(r7, r8, r9, r10, r11);
    }

    public static b newInstance(m r7, l r8, t r9, u r10, a r11) {
        return new b(r7, r8, r9, r10, r11);
    }
}
