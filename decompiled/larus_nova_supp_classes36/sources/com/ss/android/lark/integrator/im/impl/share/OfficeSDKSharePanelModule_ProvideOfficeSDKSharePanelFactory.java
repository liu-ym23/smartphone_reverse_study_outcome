package com.ss.android.lark.integrator.im.impl.share;

import cnb.c;
import cnb.d;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import uza.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeSDKSharePanelModule_ProvideOfficeSDKSharePanelFactory implements Factory<a> {
    private final d module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m924get() {
        return provideOfficeSDKSharePanel(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m924get();
    }

    public OfficeSDKSharePanelModule_ProvideOfficeSDKSharePanelFactory(d r1) {
        this.module = r1;
    }

    public static OfficeSDKSharePanelModule_ProvideOfficeSDKSharePanelFactory create(d r1) {
        return new OfficeSDKSharePanelModule_ProvideOfficeSDKSharePanelFactory(r1);
    }

    public static a provideOfficeSDKSharePanel(d r0) {
        r0.getClass();
        Object r1 = (a) OfficeSDKManager.getHostGlobalService(a.class);
        if (r1 != null) goto L6;
        r1 = new c();
    L6:
        return (a) Preconditions.checkNotNullFromProvides(r1);
    }
}
