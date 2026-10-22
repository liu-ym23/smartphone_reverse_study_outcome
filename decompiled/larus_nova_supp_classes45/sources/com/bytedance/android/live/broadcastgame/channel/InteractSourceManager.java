package com.bytedance.android.live.broadcastgame.channel;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractSourceManager;
import com.bytedance.android.livesdk.gecko.j;
import com.bytedance.android.livesdk.gecko.o;
import io.reactivex.Observable;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class InteractSourceManager implements IInteractSourceManager {
    private o client;

    public InteractSourceManager() {
        k.l(IInteractSourceManager.class, this);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractSourceManager
    public void setTC21GeckoClient(o r1) {
        this.client = r1;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractSourceManager
    public Observable<j.b> updateOpenPlatformJsSdk(String r2, String r3, String r4, String r5) {
        o.a r0 = new o.a(r2, r3, r4, r5);
        o r6 = this.client;
        if (r6 != null) goto L5;
        return null;
    L5:
        return r6.a(r0);
    }
}
