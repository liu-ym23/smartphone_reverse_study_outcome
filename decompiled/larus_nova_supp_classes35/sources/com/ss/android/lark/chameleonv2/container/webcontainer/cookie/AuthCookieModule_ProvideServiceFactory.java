package com.ss.android.lark.chameleonv2.container.webcontainer.cookie;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import o0b.b;
import o0b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class AuthCookieModule_ProvideServiceFactory implements Factory<c> {

    public static final class a {
        public static final AuthCookieModule_ProvideServiceFactory a = null;

        static {
            a = new AuthCookieModule_ProvideServiceFactory();
        }
    }

    public AuthCookieModule_ProvideServiceFactory() {
    }

    public static c provideService() {
        int r0 = b.a;
        Object r1 = (c) OfficeSDKManager.getHostGlobalService(c.class);
        if (r1 != null) goto L6;
        r1 = new o0b.a();
    L6:
        return (c) Preconditions.checkNotNullFromProvides(r1);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m51get();
    }

    public static AuthCookieModule_ProvideServiceFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public c m51get() {
        return provideService();
    }
}
