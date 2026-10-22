package com.ss.android.lark.integrator.im.impl.notification;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import qza.a;
import ymb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeSDKOnlineNotificationModule_ProvideOfficeSDKNotificationApiFactory implements Factory<a> {
    private final c module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m915get() {
        return provideOfficeSDKNotificationApi(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m915get();
    }

    public OfficeSDKOnlineNotificationModule_ProvideOfficeSDKNotificationApiFactory(c r1) {
        this.module = r1;
    }

    public static OfficeSDKOnlineNotificationModule_ProvideOfficeSDKNotificationApiFactory create(c r1) {
        return new OfficeSDKOnlineNotificationModule_ProvideOfficeSDKNotificationApiFactory(r1);
    }

    public static a provideOfficeSDKNotificationApi(c r0) {
        r0.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new ymb.a());
    }
}
