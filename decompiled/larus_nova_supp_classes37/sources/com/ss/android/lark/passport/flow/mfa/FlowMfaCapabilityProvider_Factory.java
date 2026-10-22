package com.ss.android.lark.passport.flow.mfa;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FlowMfaCapabilityProvider_Factory implements Factory<d> {

    public static final class a {
        public static final FlowMfaCapabilityProvider_Factory a = null;

        static {
            a = new FlowMfaCapabilityProvider_Factory();
        }
    }

    public FlowMfaCapabilityProvider_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    public d get() {
        return newInstance();
    }

    public static FlowMfaCapabilityProvider_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m613get() {
        return get();
    }
}
