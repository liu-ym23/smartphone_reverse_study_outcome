package com.larksuite.framework.http.v2.internal.main;

import com.bytedance.lark.rustclient.api.h;
import com.larksuite.framework.http.v2.internal.rust.GlobalClientProvider;
import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LarkHttpGlobalModule_ProvideLarkHttpFactory implements Factory<com.larksuite.framework.http.v2.b> {
    private final Provider<com.larksuite.framework.http.v2.a> larkCookiesProvider;
    private final Provider<j> passportProvider;
    private final Provider<h> rustClientProvider;
    private final Provider<e28.c> uaSupporterProvider;

    public com.larksuite.framework.http.v2.b get() {
        return provideLarkHttp((com.larksuite.framework.http.v2.a) this.larkCookiesProvider.get(), (e28.c) this.uaSupporterProvider.get(), (j) this.passportProvider.get(), (h) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m319get() {
        return get();
    }

    public LarkHttpGlobalModule_ProvideLarkHttpFactory(Provider<com.larksuite.framework.http.v2.a> r1, Provider<e28.c> r2, Provider<j> r3, Provider<h> r4) {
        this.larkCookiesProvider = r1;
        this.uaSupporterProvider = r2;
        this.passportProvider = r3;
        this.rustClientProvider = r4;
    }

    public static LarkHttpGlobalModule_ProvideLarkHttpFactory create(Provider<com.larksuite.framework.http.v2.a> r1, Provider<e28.c> r2, Provider<j> r3, Provider<h> r4) {
        return new LarkHttpGlobalModule_ProvideLarkHttpFactory(r1, r2, r3, r4);
    }

    public static com.larksuite.framework.http.v2.b provideLarkHttp(com.larksuite.framework.http.v2.a r3, e28.c r4, final j r5, h r6) {
        int r0 = c.a;
        Intrinsics.checkNotNullParameter(r3, "larkCookies");
        Intrinsics.checkNotNullParameter(r4, "uaSupporter");
        Intrinsics.checkNotNullParameter(r5, "passport");
        Intrinsics.checkNotNullParameter(r6, "rustClient");
        return (com.larksuite.framework.http.v2.b) Preconditions.checkNotNullFromProvides(new LarkHttpImpl(new GlobalClientProvider(r6, new LarkHttpGlobalModule$provideLarkHttp$1(r5)), r3, r4));
    }
}
