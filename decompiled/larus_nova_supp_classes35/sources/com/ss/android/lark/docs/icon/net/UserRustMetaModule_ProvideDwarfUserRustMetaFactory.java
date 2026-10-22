package com.ss.android.lark.docs.icon.net;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import qbb.a;
import qbb.b;
import qbb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UserRustMetaModule_ProvideDwarfUserRustMetaFactory implements Factory<a> {
    private final Provider<l> iRustClientProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m1139get() {
        return provideDwarfUserRustMeta((l) this.iRustClientProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1139get();
    }

    public UserRustMetaModule_ProvideDwarfUserRustMetaFactory(Provider<l> r1) {
        this.iRustClientProvider = r1;
    }

    public static UserRustMetaModule_ProvideDwarfUserRustMetaFactory create(Provider<l> r1) {
        return new UserRustMetaModule_ProvideDwarfUserRustMetaFactory(r1);
    }

    public static a provideDwarfUserRustMeta(l r1) {
        int r0 = d.a;
        Intrinsics.checkNotNullParameter(r1, "iRustClient");
        return (a) Preconditions.checkNotNullFromProvides(new b(r1));
    }
}
