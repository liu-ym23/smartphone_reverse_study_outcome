package com.ss.android.lark.passport.assemble;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PassportUserDependency_Factory implements Factory<j> {

    public static final class a {
        public static final PassportUserDependency_Factory a = null;

        static {
            a = new PassportUserDependency_Factory();
        }
    }

    public PassportUserDependency_Factory() {
    }

    public static j newInstance() {
        return new j();
    }

    public j get() {
        return newInstance();
    }

    public static PassportUserDependency_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m595get() {
        return get();
    }
}
