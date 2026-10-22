package com.bytedance.android.live.broadcastgame.di;

import com.bytedance.android.live.broadcastgame.api.f;
import dagger.internal.Factory;
import i10.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class BroadcastGameAudienceModuleFallback_ProvideGameAudienceServiceFactory implements Factory<f> {
    private final d module;

    public f get() {
        return provideGameAudienceService(null);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m153get() {
        return get();
    }

    public BroadcastGameAudienceModuleFallback_ProvideGameAudienceServiceFactory(d r1) {
    }

    public static BroadcastGameAudienceModuleFallback_ProvideGameAudienceServiceFactory create(d r1) {
        return new BroadcastGameAudienceModuleFallback_ProvideGameAudienceServiceFactory(r1);
    }

    public static f provideGameAudienceService(d r0) {
        throw null;
    }
}
