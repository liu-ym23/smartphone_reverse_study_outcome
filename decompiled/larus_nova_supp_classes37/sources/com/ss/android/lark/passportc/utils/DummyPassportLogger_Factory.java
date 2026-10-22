package com.ss.android.lark.passportc.utils;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DummyPassportLogger_Factory implements Factory<m0c.a> {

    public static final class a {
        public static final DummyPassportLogger_Factory a = null;

        static {
            a = new DummyPassportLogger_Factory();
        }
    }

    public DummyPassportLogger_Factory() {
    }

    public static m0c.a newInstance() {
        return new m0c.a();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m756get();
    }

    public static DummyPassportLogger_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public m0c.a m756get() {
        return newInstance();
    }
}
