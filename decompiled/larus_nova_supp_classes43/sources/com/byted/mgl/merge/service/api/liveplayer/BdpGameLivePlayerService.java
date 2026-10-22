package com.byted.mgl.merge.service.api.liveplayer;

import android.content.Context;
import com.bytedance.bdp.bdpbase.service.IBdpService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface BdpGameLivePlayerService extends IBdpService {
    IGameTTLivePlayer createLivePlayer(Context r1);

    IGameLivePlayerDns getLivePlayerDnsOptimizer(Context r1);

    boolean isSupportNativeLivePlayer();
}
