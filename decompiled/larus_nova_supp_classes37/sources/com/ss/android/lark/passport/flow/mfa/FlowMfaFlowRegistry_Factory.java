package com.ss.android.lark.passport.flow.mfa;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FlowMfaFlowRegistry_Factory implements Factory<h> {

    public static final class a {
        public static final FlowMfaFlowRegistry_Factory a = null;

        static {
            a = new FlowMfaFlowRegistry_Factory();
        }
    }

    public FlowMfaFlowRegistry_Factory() {
    }

    public static h newInstance() {
        return new h();
    }

    public h get() {
        return newInstance();
    }

    public static FlowMfaFlowRegistry_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m615get() {
        return get();
    }
}
