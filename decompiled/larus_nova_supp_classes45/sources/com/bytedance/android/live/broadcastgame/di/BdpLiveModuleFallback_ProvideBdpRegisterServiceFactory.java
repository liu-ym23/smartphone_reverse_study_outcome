package com.bytedance.android.live.broadcastgame.di;

import com.bytedance.android.live.broadcastgame.api.d;
import dagger.internal.Factory;
import i10.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class BdpLiveModuleFallback_ProvideBdpRegisterServiceFactory implements Factory<d> {
    private final a module;

    public d get() {
        return provideBdpRegisterService(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m151get() {
        return get();
    }

    public BdpLiveModuleFallback_ProvideBdpRegisterServiceFactory(a r1) {
        this.module = r1;
    }

    public static BdpLiveModuleFallback_ProvideBdpRegisterServiceFactory create(a r1) {
        return new BdpLiveModuleFallback_ProvideBdpRegisterServiceFactory(r1);
    }

    public static d provideBdpRegisterService(a r0) {
        r0.getClass();
        return null;
    }
}
