package com.ss.android.lark.integrator.im.impl.notification;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import qza.b;
import ymb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeSDKOnlineNotificationModule_ProvideOfficeSDKOnlinePushNotificationFactory implements Factory<b> {
    private final c module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public b m916get() {
        return provideOfficeSDKOnlinePushNotification(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m916get();
    }

    public OfficeSDKOnlineNotificationModule_ProvideOfficeSDKOnlinePushNotificationFactory(c r1) {
        this.module = r1;
    }

    public static OfficeSDKOnlineNotificationModule_ProvideOfficeSDKOnlinePushNotificationFactory create(c r1) {
        return new OfficeSDKOnlineNotificationModule_ProvideOfficeSDKOnlinePushNotificationFactory(r1);
    }

    public static b provideOfficeSDKOnlinePushNotification(c r0) {
        r0.getClass();
        Object r1 = (b) OfficeSDKManager.getHostGlobalService(b.class);
        if (r1 != null) goto L6;
        r1 = new ymb.b();
    L6:
        return (b) Preconditions.checkNotNullFromProvides(r1);
    }
}
