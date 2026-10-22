package com.ss.android.lark.message.lynxcard.monitor;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LynxCardMonitorModule_ProvideLynxCardMonitorServiceFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    public a get() {
        return provideLynxCardMonitorService((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1457get() {
        return get();
    }

    public LynxCardMonitorModule_ProvideLynxCardMonitorServiceFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static LynxCardMonitorModule_ProvideLynxCardMonitorServiceFactory create(Provider<j> r1, Provider<v> r2) {
        return new LynxCardMonitorModule_ProvideLynxCardMonitorServiceFactory(r1, r2);
    }

    public static a provideLynxCardMonitorService(j r1, v r2) {
        int r0 = c.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        d r3 = new d(r1, r2);
        h.a(r3);
        return (a) Preconditions.checkNotNullFromProvides(r3);
    }
}
