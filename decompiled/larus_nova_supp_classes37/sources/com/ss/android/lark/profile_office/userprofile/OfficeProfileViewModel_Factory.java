package com.ss.android.lark.profile_office.userprofile;

import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeProfileViewModel_Factory implements Factory<OfficeProfileViewModel> {
    private final Provider<OfficeProfileModel> modelProvider;
    private final Provider<x1c.d> officeProfileProtocolProvider;
    private final Provider<IOfficeSDKTokenProvider> officeSDKTokenProvider;

    public OfficeProfileViewModel get() {
        return newInstance((OfficeProfileModel) this.modelProvider.get(), (x1c.d) this.officeProfileProtocolProvider.get(), (IOfficeSDKTokenProvider) this.officeSDKTokenProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3441get() {
        return get();
    }

    public OfficeProfileViewModel_Factory(Provider<OfficeProfileModel> r1, Provider<x1c.d> r2, Provider<IOfficeSDKTokenProvider> r3) {
        this.modelProvider = r1;
        this.officeProfileProtocolProvider = r2;
        this.officeSDKTokenProvider = r3;
    }

    public static OfficeProfileViewModel_Factory create(Provider<OfficeProfileModel> r1, Provider<x1c.d> r2, Provider<IOfficeSDKTokenProvider> r3) {
        return new OfficeProfileViewModel_Factory(r1, r2, r3);
    }

    public static OfficeProfileViewModel newInstance(OfficeProfileModel r1, x1c.d r2, IOfficeSDKTokenProvider r3) {
        return new OfficeProfileViewModel(r1, r2, r3);
    }
}
