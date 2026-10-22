package com.ss.android.lark.diskmanage.clean;

import dagger.internal.Factory;
import ebb.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class NoopCleanFileProvider_Factory implements Factory<i> {

    public static final class a {
        public static final NoopCleanFileProvider_Factory a = null;

        static {
            a = new NoopCleanFileProvider_Factory();
        }
    }

    public NoopCleanFileProvider_Factory() {
    }

    public static i newInstance() {
        return new i();
    }

    public i get() {
        return newInstance();
    }

    public static NoopCleanFileProvider_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1129get() {
        return get();
    }
}
