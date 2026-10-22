package com.bytedance.android.live.broadcastgame.api.interactgame;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.live.broadcastgame.channel.InteractSourceManager")
@ServiceDummyLookup("com.bytedance.android.live.broadcastgame.api.dummy.InteractSourceManagerDummy")
public interface IInteractSourceManager extends IService {
    void setTC21GeckoClient(com.bytedance.android.livesdk.gecko.o r1);

    Observable<com.bytedance.android.livesdk.gecko.j.b> updateOpenPlatformJsSdk(String r1, String r2, String r3, String r4);
}
