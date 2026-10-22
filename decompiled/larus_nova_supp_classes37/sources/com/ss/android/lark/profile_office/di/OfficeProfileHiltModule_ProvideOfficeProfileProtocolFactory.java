package com.ss.android.lark.profile_office.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import t1c.a;
import t1c.b;
import x1c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeProfileHiltModule_ProvideOfficeProfileProtocolFactory implements Factory<d> {
    private final a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public d m3423get() {
        return provideOfficeProfileProtocol(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m3423get();
    }

    public OfficeProfileHiltModule_ProvideOfficeProfileProtocolFactory(a r1) {
        this.module = r1;
    }

    public static OfficeProfileHiltModule_ProvideOfficeProfileProtocolFactory create(a r1) {
        return new OfficeProfileHiltModule_ProvideOfficeProfileProtocolFactory(r1);
    }

    public static d provideOfficeProfileProtocol(a r0) {
        r0.getClass();
        return (d) Preconditions.checkNotNullFromProvides(new b());
    }
}
