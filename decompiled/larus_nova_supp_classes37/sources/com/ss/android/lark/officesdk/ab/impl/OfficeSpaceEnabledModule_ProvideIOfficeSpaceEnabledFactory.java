package com.ss.android.lark.officesdk.ab.impl;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import etb.d;
import ftb.e;
import ftb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSpaceEnabledModule_ProvideIOfficeSpaceEnabledFactory implements Factory<d> {
    private final e module;

    public d get() {
        return provideIOfficeSpaceEnabled(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m10get() {
        return get();
    }

    public OfficeSpaceEnabledModule_ProvideIOfficeSpaceEnabledFactory(e r1) {
        this.module = r1;
    }

    public static OfficeSpaceEnabledModule_ProvideIOfficeSpaceEnabledFactory create(e r1) {
        return new OfficeSpaceEnabledModule_ProvideIOfficeSpaceEnabledFactory(r1);
    }

    public static d provideIOfficeSpaceEnabled(e r2) {
        r2.getClass();
        Object r3 = (d) OfficeSDKManager.getHostGlobalService(d.class);
        StringBuilder r0 = new StringBuilder("provideIOfficeMiniAppEnabled, is null ? ");
        if (r3 != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(' ');
        Log.i("OfficeSpaceEnabledModule", r0.toString());
        if (r3 != null) goto L10;
        r3 = new f();
    L10:
        return (d) Preconditions.checkNotNullFromProvides(r3);
    L5:
        r1 = false;
        goto L6
    }
}
