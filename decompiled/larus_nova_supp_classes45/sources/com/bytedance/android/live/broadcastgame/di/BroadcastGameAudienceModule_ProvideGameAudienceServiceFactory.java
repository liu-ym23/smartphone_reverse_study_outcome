package com.bytedance.android.live.broadcastgame.di;

import com.bytedance.android.live.broadcastgame.api.f;
import com.bytedance.android.live.broadcastgame.y;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import i10.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class BroadcastGameAudienceModule_ProvideGameAudienceServiceFactory implements Factory<f> {
    private final c module;

    public f get() {
        return provideGameAudienceService(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m154get() {
        return get();
    }

    public BroadcastGameAudienceModule_ProvideGameAudienceServiceFactory(c r1) {
        this.module = r1;
    }

    public static BroadcastGameAudienceModule_ProvideGameAudienceServiceFactory create(c r1) {
        return new BroadcastGameAudienceModule_ProvideGameAudienceServiceFactory(r1);
    }

    public static f provideGameAudienceService(c r0) {
        r0.getClass();
        return (f) Preconditions.checkNotNullFromProvides(new y());
    }
}
