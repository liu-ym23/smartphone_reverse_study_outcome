package com.bytedance.android.live.broadcastgame.api;

import android.content.Context;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.interactgame.JsFuncInjector;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.e0;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.api.model.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import mh1.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class InteractGameServiceDummy implements IInteractGameService {
    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void addItemToDataCacheHelper(String r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService, com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public void anchorLaunchGame(String r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService, com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public void audienceLaunchGame() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void cacheEntranceVisibility(String r1, int r2) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public void cacheOpenPlatformMessage(String r1, t r2) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void clearCache() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void closeOpenPlatformGame(String r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void confirmGameException(Context r1, DataCenter r2, u r3, boolean r4, Throwable r5) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void confirmGameStartFailed(Context r1, DataCenter r2, u r3, int r4, Throwable r5, Function0<Unit> r6) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void consumeCacheOpenPlatformMessage(String r1, DataCenter r2) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public c0.b createOpenGameBehaivor() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public JsFuncInjector createOpenJsFuncInject(IJsBridgeManager r1, DataCenter r2, Context r3) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public Object createOpenToolbarEntBehavior() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public a0 createToolbarComponentConfig(DataCenter r1, Context r2) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public String decryptUserInfo(String r1) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void deleteData(String r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void executeEnterRoomTask(boolean r1, Room r2) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public com.bytedance.android.live.broadcastgame.api.model.h fetchGameIconInfo(String r1, boolean r2) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public IAnchorGameWidget getAnchorGameWidget(com.bytedance.android.live.pushstream.d r1, Room r2, Fragment r3, FragmentManager r4) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public IAudienceGameWidget getAudienceGameWidget(boolean r1) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public String getCurrentGameName() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public u getCurrentPlayingGame() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public int getCurrentPlayingGameId() {
        return 0;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public String getCurrentSonicGameAppId() {
        return "";
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public int getEntranceVisibility(String r1) {
        return 0;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public String getGameCategory(boolean r1) {
        return "";
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.live.broadcastgame.api.interactgame.h getGameExitConformDialog(Context r1, String r2) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.live.broadcastgame.api.interactgame.d getGameGuideHelper() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public e10.b<u, e10.a.C0226a> getLiveOpenFeatureSceneFilter(DataCenter r1) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.live.broadcastgame.api.openplatform.c getOpenGameClient() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public c0.b getOpenPlatformBehavior(Context r1, DataCenter r2, Function2<? super InteractEntranceCell, ? super z, ? extends c0.b> r3, com.bytedance.android.live.broadcastgame.api.interactgame.g r4) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public c0.b getOpenPlatformItemBehavior(u r1, p r2) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService, com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public com.bytedance.android.live.broadcastgame.api.xplay.e getXplayGlobalService() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void handleAnchorPanelJSBInvoke(String r1, JsonObject r2, Function1<? super JsonObject, Unit> r3) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void hidePlugin(boolean r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void initGameContext(Fragment r1, boolean r2) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public boolean isGameCasting() {
        return false;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public boolean isInteractPlayRunning() {
        return false;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public boolean isPlayingGame() {
        return false;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public boolean isPlayingGame(InteractID r1) {
        return false;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public Observable<com.bytedance.android.live.network.response.e<e0>> notifyServerGameStart(long r1, long r3, String r5, long r6) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public Observable<com.bytedance.android.live.network.response.e<Object>> notifyServerGameStop(long r1, long r3, long r5, String r7, boolean r8, int r9, long r11) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService, com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public void notifyStartLinkCastResult(boolean r1, Surface r2, int r3) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService, com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public void notifyStopLinkCastResult(boolean r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void onSei(String r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public boolean openMiniApp(Context r1, String r2, Map<String, String> r3) {
        return false;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void openOpenPlatformGame(String r1, Map<String, ?> r2) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void preloadOpenPlatformGame(String r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void sendGameCastStatusSEI(boolean r1, JSONObject r2) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void sendGameSeiData(String r1, String r2) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void sendServerMergeCastStatusSEI(boolean r1, JSONObject r2) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void setAnchorInteractPlayContainer(ViewGroup r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void setAudienceMiniAppReady(boolean r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void setAudienceMiniAppSchema(String r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void setGameCasting(boolean r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void setGameGuideHelper(String r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void showPlugin(boolean r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void startOpenPlatformSonicPlugin(Context r1, String r2, com.bytedance.android.live.broadcastgame.api.interactgame.p r3) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void stopGameCastToAudience() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void stopRunningPlugin() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService, com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public void stopRunningPlugin(String r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void tryGetSwitchGameConfirmDialog(u r1, Context r2, DataCenter r3, Function0<Unit> r4, Function0<Unit> r5) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public List<Class<?>> getAllOpenPlatformActivity() {
        return new ArrayList();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public Map<String, String> getOpenPlatformGameCommonLogMap() {
        return new HashMap();
    }

    public InteractGameServiceDummy() {
        k.l(IInteractGameService.class, this);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public Boolean isOpenPlatformGameOpeningLynxPanelInGame() {
        return Boolean.FALSE;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public Single<Boolean> showOpenGameAuthDialog(Context r1, DataCenter r2, u r3) {
        return Single.just(Boolean.FALSE);
    }
}
