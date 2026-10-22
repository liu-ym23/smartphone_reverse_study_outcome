package com.ss.android.lark.passportc.internal;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DefaultPassportExecutors_Factory implements Factory<i> {

    public static final class a {
        public static final DefaultPassportExecutors_Factory a = null;

        static {
            a = new DefaultPassportExecutors_Factory();
        }
    }

    public DefaultPassportExecutors_Factory() {
    }

    public static i newInstance() {
        return new i();
    }

    public i get() {
        return newInstance();
    }

    public static DefaultPassportExecutors_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m720get() {
        return get();
    }
}
