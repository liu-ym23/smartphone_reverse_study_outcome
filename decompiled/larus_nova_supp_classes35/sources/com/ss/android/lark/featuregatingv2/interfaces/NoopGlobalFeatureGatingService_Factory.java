package com.ss.android.lark.featuregatingv2.interfaces;

import dagger.internal.Factory;
import jdb.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class NoopGlobalFeatureGatingService_Factory implements Factory<h> {

    public static final class a {
        public static final NoopGlobalFeatureGatingService_Factory a = null;

        static {
            a = new NoopGlobalFeatureGatingService_Factory();
        }
    }

    public NoopGlobalFeatureGatingService_Factory() {
    }

    public static h newInstance() {
        return new h();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1162get();
    }

    public static NoopGlobalFeatureGatingService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public h m1162get() {
        return newInstance();
    }
}
