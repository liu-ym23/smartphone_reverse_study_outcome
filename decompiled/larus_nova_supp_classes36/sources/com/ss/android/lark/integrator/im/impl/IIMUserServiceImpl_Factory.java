package com.ss.android.lark.integrator.im.impl;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class IIMUserServiceImpl_Factory implements Factory<IIMUserServiceImpl> {
    private final Provider<bza.a> auditServiceProvider;
    private final Provider<com.bytedance.lark.lark_biz_feed_android_wrapper.b> badgeServiceProvider;
    private final Provider<com.ss.android.lark.chatwindow.launcher.c> chatLauncherProvider;
    private final Provider<com.ss.android.lark.flow.feed.data.a> doubaoFeedMigrateStatusProvider;
    private final Provider<kza.h> galleryImageServiceProvider;
    private final Provider<aza.b> humansChatSettingsServiceInternalProvider;
    private final Provider<cza.a> officeAvatarServiceProvider;
    private final Provider<dza.b> officeChatServiceProvider;
    private final Provider<fza.a> officeFeedServiceProvider;
    private final Provider<nza.b> officeMessageMenuServiceProvider;
    private final Provider<m> passportProvider;

    public IIMUserServiceImpl get() {
        IIMUserServiceImpl r0 = newInstance((com.bytedance.lark.lark_biz_feed_android_wrapper.b) this.badgeServiceProvider.get(), (com.ss.android.lark.flow.feed.data.a) this.doubaoFeedMigrateStatusProvider.get(), (m) this.passportProvider.get());
        r0.d = (com.ss.android.lark.chatwindow.launcher.c) this.chatLauncherProvider.get();
        r0.e = (aza.b) this.humansChatSettingsServiceInternalProvider.get();
        r0.f = (kza.h) this.galleryImageServiceProvider.get();
        r0.g = (bza.a) this.auditServiceProvider.get();
        r0.h = (cza.a) this.officeAvatarServiceProvider.get();
        r0.i = (nza.b) this.officeMessageMenuServiceProvider.get();
        r0.j = (dza.b) this.officeChatServiceProvider.get();
        r0.k = (fza.a) this.officeFeedServiceProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m899get() {
        return get();
    }

    public static IIMUserServiceImpl newInstance(com.bytedance.lark.lark_biz_feed_android_wrapper.b r1, com.ss.android.lark.flow.feed.data.a r2, m r3) {
        return new IIMUserServiceImpl(r1, r2, r3);
    }

    public IIMUserServiceImpl_Factory(Provider<com.bytedance.lark.lark_biz_feed_android_wrapper.b> r1, Provider<com.ss.android.lark.flow.feed.data.a> r2, Provider<m> r3, Provider<com.ss.android.lark.chatwindow.launcher.c> r4, Provider<aza.b> r5, Provider<kza.h> r6, Provider<bza.a> r7, Provider<cza.a> r8, Provider<nza.b> r9, Provider<dza.b> r10, Provider<fza.a> r11) {
        this.badgeServiceProvider = r1;
        this.doubaoFeedMigrateStatusProvider = r2;
        this.passportProvider = r3;
        this.chatLauncherProvider = r4;
        this.humansChatSettingsServiceInternalProvider = r5;
        this.galleryImageServiceProvider = r6;
        this.auditServiceProvider = r7;
        this.officeAvatarServiceProvider = r8;
        this.officeMessageMenuServiceProvider = r9;
        this.officeChatServiceProvider = r10;
        this.officeFeedServiceProvider = r11;
    }

    public static IIMUserServiceImpl_Factory create(Provider<com.bytedance.lark.lark_biz_feed_android_wrapper.b> r13, Provider<com.ss.android.lark.flow.feed.data.a> r14, Provider<m> r15, Provider<com.ss.android.lark.chatwindow.launcher.c> r16, Provider<aza.b> r17, Provider<kza.h> r18, Provider<bza.a> r19, Provider<cza.a> r20, Provider<nza.b> r21, Provider<dza.b> r22, Provider<fza.a> r23) {
        return new IIMUserServiceImpl_Factory(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
    }
}
