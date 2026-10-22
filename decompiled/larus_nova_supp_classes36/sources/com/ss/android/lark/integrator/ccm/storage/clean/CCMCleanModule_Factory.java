package com.ss.android.lark.integrator.ccm.storage.clean;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CCMCleanModule_Factory implements Factory<CCMCleanModule> {

    public static final class a {
        public static final CCMCleanModule_Factory a = null;

        static {
            a = new CCMCleanModule_Factory();
        }
    }

    public CCMCleanModule_Factory() {
    }

    public static CCMCleanModule newInstance() {
        return new CCMCleanModule();
    }

    public CCMCleanModule get() {
        return newInstance();
    }

    public static CCMCleanModule_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m890get() {
        return get();
    }
}
