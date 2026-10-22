package com.ss.android.lark.profile_office.userprofile;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeProfileModel_Factory implements Factory<OfficeProfileModel> {
    private final Provider<com.ss.android.lark.profile.core.di.a> netClientGetterProvider;

    public static OfficeProfileModel newInstance() {
        return new OfficeProfileModel();
    }

    public OfficeProfileModel get() {
        OfficeProfileModel r0 = newInstance();
        r0.a = (com.ss.android.lark.profile.core.di.a) this.netClientGetterProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3425get() {
        return get();
    }

    public OfficeProfileModel_Factory(Provider<com.ss.android.lark.profile.core.di.a> r1) {
        this.netClientGetterProvider = r1;
    }

    public static OfficeProfileModel_Factory create(Provider<com.ss.android.lark.profile.core.di.a> r1) {
        return new OfficeProfileModel_Factory(r1);
    }
}
