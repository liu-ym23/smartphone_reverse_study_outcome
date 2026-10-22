package com.ss.android.lark.passportc.internal;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DummyUserDataSource_Factory implements Factory<j> {

    public static final class a {
        public static final DummyUserDataSource_Factory a = null;

        static {
            a = new DummyUserDataSource_Factory();
        }
    }

    public DummyUserDataSource_Factory() {
    }

    public static j newInstance() {
        return new j();
    }

    public j get() {
        return newInstance();
    }

    public static DummyUserDataSource_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m721get() {
        return get();
    }
}
