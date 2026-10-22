package com.ss.android.lark.flow.notification.online;

import com.ss.android.lark.flow.notification.online.proxy.a;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ohb.b;
import zsb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowNotificationInstancesProxy_ProvideNotificationControllerApiFactory implements Factory<c> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public c m462get() {
        return provideNotificationControllerApi((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m462get();
    }

    public FlowNotificationInstancesProxy_ProvideNotificationControllerApiFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static FlowNotificationInstancesProxy_ProvideNotificationControllerApiFactory create(Provider<j> r1, Provider<v> r2) {
        return new FlowNotificationInstancesProxy_ProvideNotificationControllerApiFactory(r1, r2);
    }

    public static c provideNotificationControllerApi(j r1, v r2) {
        int r0 = b.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        a r3 = new a(r1, r2);
        h.a(r3);
        return (c) Preconditions.checkNotNullFromProvides(r3);
    }
}
