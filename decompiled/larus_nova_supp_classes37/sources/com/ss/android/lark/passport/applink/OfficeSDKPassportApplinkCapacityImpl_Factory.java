package com.ss.android.lark.passport.applink;

import com.ss.android.lark.passport.flow.mfa.FlowMfaEngine;
import dagger.internal.Factory;
import javax.inject.Provider;
import pyb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKPassportApplinkCapacityImpl_Factory implements Factory<a> {
    private final Provider<FlowMfaEngine> engineProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m589get() {
        return newInstance((FlowMfaEngine) this.engineProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m589get();
    }

    public OfficeSDKPassportApplinkCapacityImpl_Factory(Provider<FlowMfaEngine> r1) {
        this.engineProvider = r1;
    }

    public static OfficeSDKPassportApplinkCapacityImpl_Factory create(Provider<FlowMfaEngine> r1) {
        return new OfficeSDKPassportApplinkCapacityImpl_Factory(r1);
    }

    public static a newInstance(FlowMfaEngine r1) {
        return new a(r1);
    }
}
