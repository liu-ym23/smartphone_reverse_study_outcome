package com.bytedance.android.live.broadcastgame.api;

import com.bytedance.android.live.broadcastgame.api.interactgame.IAudienceGameDataService;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.live.datacontext.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class a extends b implements IAudienceGameDataService {
    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IAudienceGameDataService
    public long getCurrentGameId() {
        AudienceGameContext r0 = (AudienceGameContext) com.bytedance.live.datacontext.d.e(InteractGameContext.CONTEXT_KEY, AudienceGameContext.class);
        if (r0 == null) goto L9;
        n<r> r1 = r0.getCurrentGame();
        if (r1 == null) goto L9;
        r r2 = (r) r1.getValue();
        if (r2 == null) goto L9;
        return r2.p();
    L9:
        return 0;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IAudienceGameDataService
    public String getCurrentGameName() {
        AudienceGameContext r0 = (AudienceGameContext) com.bytedance.live.datacontext.d.e(InteractGameContext.CONTEXT_KEY, AudienceGameContext.class);
        if (r0 == null) goto L10;
        n<r> r1 = r0.getCurrentGame();
        if (r1 == null) goto L10;
        r r2 = (r) r1.getValue();
        if (r2 == null) goto L10;
        String r3 = r2.q();
        if (r3 == null) goto L10;
        return r3;
    L10:
        return "";
    }

    public a() {
    }
}
