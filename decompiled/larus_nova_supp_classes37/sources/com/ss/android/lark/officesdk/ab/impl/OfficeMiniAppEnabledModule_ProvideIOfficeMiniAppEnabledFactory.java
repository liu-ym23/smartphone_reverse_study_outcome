package com.ss.android.lark.officesdk.ab.impl;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import etb.a;
import ftb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeMiniAppEnabledModule_ProvideIOfficeMiniAppEnabledFactory implements Factory<a> {
    private final ftb.a module;

    public a get() {
        return provideIOfficeMiniAppEnabled(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8get() {
        return get();
    }

    public OfficeMiniAppEnabledModule_ProvideIOfficeMiniAppEnabledFactory(ftb.a r1) {
        this.module = r1;
    }

    public static OfficeMiniAppEnabledModule_ProvideIOfficeMiniAppEnabledFactory create(ftb.a r1) {
        return new OfficeMiniAppEnabledModule_ProvideIOfficeMiniAppEnabledFactory(r1);
    }

    public static a provideIOfficeMiniAppEnabled(ftb.a r2) {
        r2.getClass();
        Object r3 = (a) OfficeSDKManager.getHostGlobalService(a.class);
        StringBuilder r0 = new StringBuilder("provideIOfficeMiniAppEnabled, is null ? ");
        if (r3 != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(' ');
        Log.i("OfficeMiniAppEnabledModule", r0.toString());
        if (r3 != null) goto L10;
        r3 = new b();
    L10:
        return (a) Preconditions.checkNotNullFromProvides(r3);
    L5:
        r1 = false;
        goto L6
    }
}
