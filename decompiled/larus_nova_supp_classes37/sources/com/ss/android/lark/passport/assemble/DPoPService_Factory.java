package com.ss.android.lark.passport.assemble;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DPoPService_Factory implements Factory<com.ss.android.lark.passport.assemble.a> {

    public static final class a {
        public static final DPoPService_Factory a = null;

        static {
            a = new DPoPService_Factory();
        }
    }

    public DPoPService_Factory() {
    }

    public static com.ss.android.lark.passport.assemble.a newInstance() {
        return new com.ss.android.lark.passport.assemble.a();
    }

    public com.ss.android.lark.passport.assemble.a get() {
        return newInstance();
    }

    public static DPoPService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m591get() {
        return get();
    }
}
