package com.ss.android.lark.passport.mfa;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class EmptyPassportMFAService_Factory implements Factory<yyb.a> {

    public static final class a {
        public static final EmptyPassportMFAService_Factory a = null;

        static {
            a = new EmptyPassportMFAService_Factory();
        }
    }

    public EmptyPassportMFAService_Factory() {
    }

    public static yyb.a newInstance() {
        return new yyb.a();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m680get();
    }

    public static EmptyPassportMFAService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public yyb.a m680get() {
        return newInstance();
    }
}
