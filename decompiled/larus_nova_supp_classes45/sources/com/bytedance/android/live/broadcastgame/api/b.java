package com.bytedance.android.live.broadcastgame.api;

import com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService;
import com.bytedance.android.live.broadcastgame.api.model.i;
import com.bytedance.android.live.broadcastgame.api.model.i0;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayExternalContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class b implements IGameDataService {
    public b() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService
    public m<Boolean> getClearScreen() {
        XplayExternalContext r0 = XplayExternalContext.Companion.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getClearScreen();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService
    public i getGameOpenInfo() {
        InteractGameContext r0 = InteractGameContext.Companion.getContext();
        if (r0 == null) goto L7;
        n<i> r1 = r0.getGameOpenInfo();
        if (r1 == null) goto L7;
        return (i) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService
    public i0 getOpenPlatformAppInfo() {
        InteractGameContext r0 = InteractGameContext.Companion.getContext();
        if (r0 == null) goto L7;
        n<i0> r1 = r0.getCurrentOpenPlatformAppInfo();
        if (r1 == null) goto L7;
        return (i0) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService
    public m<Boolean> getXplayRunning() {
        XplayExternalContext r0 = XplayExternalContext.Companion.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getXplayRunning();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService
    public boolean isAnchorPlayingGame() {
        return InteractGameContext.Companion.b();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService
    public boolean isGameFullPanelShowing() {
        InteractGameContext r0 = InteractGameContext.Companion.getContext();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getGameFullPanelIsShowing();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService
    public m<Boolean> isPlayingGame() {
        InteractGameContext r0 = InteractGameContext.Companion.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.isPlayingGame();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService
    public boolean isRunningPlugin() {
        return InteractGameContext.Companion.g();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService
    public String isRunningPluginName() {
        return InteractGameContext.Companion.i();
    }
}
