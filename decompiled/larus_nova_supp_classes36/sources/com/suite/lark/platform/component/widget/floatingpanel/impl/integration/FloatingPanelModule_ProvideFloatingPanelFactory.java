package com.suite.lark.platform.component.widget.floatingpanel.impl.integration;

import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import yoc.h;
import zoc.a;
import zoc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FloatingPanelModule_ProvideFloatingPanelFactory implements Factory<h> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public h m1767get() {
        return provideFloatingPanel((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1767get();
    }

    public FloatingPanelModule_ProvideFloatingPanelFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static FloatingPanelModule_ProvideFloatingPanelFactory create(Provider<j> r1, Provider<v> r2) {
        return new FloatingPanelModule_ProvideFloatingPanelFactory(r1, r2);
    }

    public static h provideFloatingPanel(j r1, v r2) {
        int r0 = c.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        a r3 = new a(r1, r2);
        com.ss.android.lark.passportc.api.h.a(r3);
        return (h) Preconditions.checkNotNullFromProvides(r3);
    }
}
