package com.larus.api.serviceimpl;

import c54.c;
import com.bytedance.awemeopen.servicesapi.storage.AoKVStorageService;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class AosConfigServiceImpl$a implements c {
    public AosConfigServiceImpl$a() {
    }

    public final void a() {
    }

    public final int b() {
        return 5;
    }

    public final void d() {
    }

    public final void showAutoPlaySwitch() {
    }

    public final long timeOnLiveRoom() {
        return 6000;
    }

    public final boolean getAutoPlayState() {
        return BdpManager.getInst().getService(AoKVStorageService.class).h(AppHost.a.getApplication(), "recommend_feed_autoplay_config").getBoolean("state", false);
    }

    public final void c(boolean r4) {
        BdpManager.getInst().getService(AoKVStorageService.class).h(AppHost.a.getApplication(), "recommend_feed_autoplay_config").edit().putBoolean("state", r4).apply();
    }
}
