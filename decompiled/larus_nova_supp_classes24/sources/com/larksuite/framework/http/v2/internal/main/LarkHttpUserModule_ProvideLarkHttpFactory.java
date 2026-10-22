package com.larksuite.framework.http.v2.internal.main;

import com.bytedance.lark.rustclient.api.l;
import com.larksuite.framework.http.v2.internal.rust.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LarkHttpUserModule_ProvideLarkHttpFactory implements Factory<com.larksuite.framework.http.v2.b> {
    private final Provider<com.larksuite.framework.http.v2.a> larkCookiesProvider;
    private final Provider<l> rustClientProvider;
    private final Provider<e28.c> uaSupporterProvider;

    public com.larksuite.framework.http.v2.b get() {
        return provideLarkHttp((com.larksuite.framework.http.v2.a) this.larkCookiesProvider.get(), (e28.c) this.uaSupporterProvider.get(), (l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m321get() {
        return get();
    }

    public LarkHttpUserModule_ProvideLarkHttpFactory(Provider<com.larksuite.framework.http.v2.a> r1, Provider<e28.c> r2, Provider<l> r3) {
        this.larkCookiesProvider = r1;
        this.uaSupporterProvider = r2;
        this.rustClientProvider = r3;
    }

    public static LarkHttpUserModule_ProvideLarkHttpFactory create(Provider<com.larksuite.framework.http.v2.a> r1, Provider<e28.c> r2, Provider<l> r3) {
        return new LarkHttpUserModule_ProvideLarkHttpFactory(r1, r2, r3);
    }

    public static com.larksuite.framework.http.v2.b provideLarkHttp(com.larksuite.framework.http.v2.a r2, e28.c r3, l r4) {
        int r0 = d.a;
        Intrinsics.checkNotNullParameter(r2, "larkCookies");
        Intrinsics.checkNotNullParameter(r3, "uaSupporter");
        Intrinsics.checkNotNullParameter(r4, "rustClient");
        return (com.larksuite.framework.http.v2.b) Preconditions.checkNotNullFromProvides(new LarkHttpImpl(new h(r4), r2, r3));
    }
}
