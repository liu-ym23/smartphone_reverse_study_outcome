package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SecurityComplianceDependencyImpl_Factory implements Factory<p> {

    public static final class a {
        public static final SecurityComplianceDependencyImpl_Factory a = null;

        static {
            a = new SecurityComplianceDependencyImpl_Factory();
        }
    }

    public SecurityComplianceDependencyImpl_Factory() {
    }

    public static p newInstance() {
        return new p();
    }

    public p get() {
        return newInstance();
    }

    public static SecurityComplianceDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m88get() {
        return get();
    }
}
