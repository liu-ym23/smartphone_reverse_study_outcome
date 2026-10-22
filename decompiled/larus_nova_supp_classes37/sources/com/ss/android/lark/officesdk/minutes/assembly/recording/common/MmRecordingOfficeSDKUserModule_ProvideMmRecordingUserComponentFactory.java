package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingOfficeSDKUserModule_ProvideMmRecordingUserComponentFactory implements Factory<com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a> {
    private final Provider<jdb.g> featureGatingServiceProvider;
    private final Provider<m> passportServiceProvider;
    private final Provider<l> rustClientProvider;
    private final Provider<String> uidProvider;
    private final Provider<mcb.c> userDomainConfigProvider;

    public com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a get() {
        return provideMmRecordingUserComponent((String) this.uidProvider.get(), (mcb.c) this.userDomainConfigProvider.get(), (m) this.passportServiceProvider.get(), (jdb.g) this.featureGatingServiceProvider.get(), (l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m172get() {
        return get();
    }

    public MmRecordingOfficeSDKUserModule_ProvideMmRecordingUserComponentFactory(Provider<String> r1, Provider<mcb.c> r2, Provider<m> r3, Provider<jdb.g> r4, Provider<l> r5) {
        this.uidProvider = r1;
        this.userDomainConfigProvider = r2;
        this.passportServiceProvider = r3;
        this.featureGatingServiceProvider = r4;
        this.rustClientProvider = r5;
    }

    public static MmRecordingOfficeSDKUserModule_ProvideMmRecordingUserComponentFactory create(Provider<String> r7, Provider<mcb.c> r8, Provider<m> r9, Provider<jdb.g> r10, Provider<l> r11) {
        return new MmRecordingOfficeSDKUserModule_ProvideMmRecordingUserComponentFactory(r7, r8, r9, r10, r11);
    }

    public static com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a provideMmRecordingUserComponent(String r7, mcb.c r8, m r9, jdb.g r10, l r11) {
        int r0 = h.a;
        Intrinsics.checkNotNullParameter(r7, "uid");
        Intrinsics.checkNotNullParameter(r8, "userDomainConfig");
        Intrinsics.checkNotNullParameter(r9, "passportService");
        Intrinsics.checkNotNullParameter(r10, "featureGatingService");
        Intrinsics.checkNotNullParameter(r11, "rustClient");
        MinutesUCCImpl r1 = new MinutesUCCImpl(r7, r8, r10, r11, r9);
        r9.d(r1);
        return (com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a) Preconditions.checkNotNullFromProvides(r1);
    }
}
