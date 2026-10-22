package com.ss.android.lark.flow.notification.online;

import com.ss.android.lark.flow.notification.online.proxy.FlowNotificationPushManagerProxy;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ohb.b;
import zsb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowNotificationInstancesProxy_ProvideNotificationPushManagerFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m463get() {
        return provideNotificationPushManager((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m463get();
    }

    public FlowNotificationInstancesProxy_ProvideNotificationPushManagerFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static FlowNotificationInstancesProxy_ProvideNotificationPushManagerFactory create(Provider<j> r1, Provider<v> r2) {
        return new FlowNotificationInstancesProxy_ProvideNotificationPushManagerFactory(r1, r2);
    }

    public static a provideNotificationPushManager(j r1, v r2) {
        int r0 = b.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        FlowNotificationPushManagerProxy r3 = new FlowNotificationPushManagerProxy(r1, r2);
        h.a(r3);
        return (a) Preconditions.checkNotNullFromProvides(r3);
    }
}
