package com.ss.android.lark.integrator.ccm.config.diskmanage;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CCMDiskCleanTask_Factory implements Factory<emb.a> {

    public static final class a {
        public static final CCMDiskCleanTask_Factory a = null;

        static {
            a = new CCMDiskCleanTask_Factory();
        }
    }

    public CCMDiskCleanTask_Factory() {
    }

    public static emb.a newInstance() {
        return new emb.a();
    }

    public emb.a get() {
        return newInstance();
    }

    public static CCMDiskCleanTask_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m864get() {
        return get();
    }
}
