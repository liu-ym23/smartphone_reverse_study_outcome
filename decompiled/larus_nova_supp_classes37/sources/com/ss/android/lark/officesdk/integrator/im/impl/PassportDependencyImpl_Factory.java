package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PassportDependencyImpl_Factory implements Factory<o> {

    public static final class a {
        public static final PassportDependencyImpl_Factory a = null;

        static {
            a = new PassportDependencyImpl_Factory();
        }
    }

    public PassportDependencyImpl_Factory() {
    }

    public static o newInstance() {
        return new o();
    }

    public o get() {
        return newInstance();
    }

    public static PassportDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m87get() {
        return get();
    }
}
