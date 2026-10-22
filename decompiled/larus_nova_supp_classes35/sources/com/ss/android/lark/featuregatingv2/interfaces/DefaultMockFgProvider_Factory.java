package com.ss.android.lark.featuregatingv2.interfaces;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DefaultMockFgProvider_Factory implements Factory<jdb.a> {

    public static final class a {
        public static final DefaultMockFgProvider_Factory a = null;

        static {
            a = new DefaultMockFgProvider_Factory();
        }
    }

    public DefaultMockFgProvider_Factory() {
    }

    public static jdb.a newInstance() {
        return new jdb.a();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1161get();
    }

    public static DefaultMockFgProvider_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public jdb.a m1161get() {
        return newInstance();
    }
}
