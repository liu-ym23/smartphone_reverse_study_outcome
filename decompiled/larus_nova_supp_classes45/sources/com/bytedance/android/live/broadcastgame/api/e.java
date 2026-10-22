package com.bytedance.android.live.broadcastgame.api;

import android.content.Context;
import android.view.Surface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.common.ui.GameExitConformDialog;
import com.bytedance.android.live.broadcastgame.h0;
import com.bytedance.android.live.broadcastgame.widget.AnchorGameWidget;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface e {
    void a();

    void b();

    AnchorGameWidget getAnchorGameWidget(com.bytedance.android.live.pushstream.d r1, Room r2, Fragment r3, FragmentManager r4);

    u getCurrentPlayingGame();

    String getGameCategory();

    GameExitConformDialog getGameExitConformDialog(Context r1, String r2);

    h0 getLiveOpenFeatureSceneFilter(DataCenter r1);

    boolean isPlayingGame();

    boolean isPlayingGame(InteractID r1);

    void notifyStartLinkCastResult(boolean r1, Surface r2, int r3);

    void notifyStopLinkCastResult(boolean r1);

    void sendGameCastStatusSEI(boolean r1, JSONObject r2);

    void sendGameSeiData(String r1, String r2);

    void sendServerMergeCastStatusSEI(boolean r1, JSONObject r2);

    void stopGameCastToAudience();

    void stopRunningPlugin(String r1);

    void tryGetSwitchGameConfirmDialog(u r1, Context r2, DataCenter r3, Function0<Unit> r4, Function0<Unit> r5);
}
