package com.ss.android.lark.chat.chatwindow.chat.preloaderv2;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DataPreloadManagerModule_ProvideChatPreloadManagerV2Factory implements Factory<d> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    public d get() {
        return provideChatPreloadManagerV2((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m323get() {
        return get();
    }

    public DataPreloadManagerModule_ProvideChatPreloadManagerV2Factory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static DataPreloadManagerModule_ProvideChatPreloadManagerV2Factory create(Provider<j> r1, Provider<v> r2) {
        return new DataPreloadManagerModule_ProvideChatPreloadManagerV2Factory(r1, r2);
    }

    public static d provideChatPreloadManagerV2(j r1, v r2) {
        int r0 = a.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        b r3 = new b(r1, r2);
        h.a(r3);
        return (d) Preconditions.checkNotNullFromProvides(r3);
    }
}
