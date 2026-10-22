package com.bytedance.android.live.broadcastgame.di;

import com.bytedance.android.live.broadcastgame.api.e;
import com.bytedance.android.live.broadcastgame.x;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import i10.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class BroadcastGameAnchorModule_ProvideGameAnchorServiceFactory implements Factory<e> {
    private final b module;

    public e get() {
        return provideGameAnchorService(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m152get() {
        return get();
    }

    public BroadcastGameAnchorModule_ProvideGameAnchorServiceFactory(b r1) {
        this.module = r1;
    }

    public static BroadcastGameAnchorModule_ProvideGameAnchorServiceFactory create(b r1) {
        return new BroadcastGameAnchorModule_ProvideGameAnchorServiceFactory(r1);
    }

    public static e provideGameAnchorService(b r0) {
        r0.getClass();
        return (e) Preconditions.checkNotNullFromProvides(new x());
    }
}
