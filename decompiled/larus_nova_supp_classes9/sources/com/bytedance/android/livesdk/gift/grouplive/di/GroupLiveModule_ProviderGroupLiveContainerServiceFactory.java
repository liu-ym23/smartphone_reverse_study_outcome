package com.bytedance.android.livesdk.gift.grouplive.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import h12.b;
import wy1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GroupLiveModule_ProviderGroupLiveContainerServiceFactory implements Factory<b> {
    private final c module;

    public b get() {
        return providerGroupLiveContainerService(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m37get() {
        return get();
    }

    public GroupLiveModule_ProviderGroupLiveContainerServiceFactory(c r1) {
        this.module = r1;
    }

    public static GroupLiveModule_ProviderGroupLiveContainerServiceFactory create(c r1) {
        return new GroupLiveModule_ProviderGroupLiveContainerServiceFactory(r1);
    }

    public static b providerGroupLiveContainerService(c r0) {
        r0.getClass();
        return (b) Preconditions.checkNotNullFromProvides(new wy1.b());
    }
}
