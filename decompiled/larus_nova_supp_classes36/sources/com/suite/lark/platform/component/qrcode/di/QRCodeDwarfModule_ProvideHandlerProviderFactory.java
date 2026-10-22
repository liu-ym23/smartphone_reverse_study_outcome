package com.suite.lark.platform.component.qrcode.di;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import soc.a;
import soc.b;
import soc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class QRCodeDwarfModule_ProvideHandlerProviderFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final b module;
    private final Provider<j> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m1734get() {
        return provideHandlerProvider(this.module, (j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1734get();
    }

    public QRCodeDwarfModule_ProvideHandlerProviderFactory(b r1, Provider<j> r2, Provider<v> r3) {
        this.module = r1;
        this.passportProvider = r2;
        this.accessorProvider = r3;
    }

    public static QRCodeDwarfModule_ProvideHandlerProviderFactory create(b r1, Provider<j> r2, Provider<v> r3) {
        return new QRCodeDwarfModule_ProvideHandlerProviderFactory(r1, r2, r3);
    }

    public static a provideHandlerProvider(b r0, j r1, v r2) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        d r3 = new d(r1, r2);
        h.a(r3);
        return (a) Preconditions.checkNotNullFromProvides(r3);
    }
}
