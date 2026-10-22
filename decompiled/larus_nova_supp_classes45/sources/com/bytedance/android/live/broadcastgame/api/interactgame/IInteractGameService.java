package com.bytedance.android.live.broadcastgame.api.interactgame;

import android.content.Context;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget;
import com.bytedance.android.live.broadcastgame.api.IAudienceGameWidget;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.e0;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.api.model.z;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.live.broadcastgame.InteractGameService")
@Metadata(d1 = {"\u0000Æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 ¤\u00012\u00020\u00012\u00020\u0002:\u0002¥\u0001J\b\u0010\u0004\u001a\u00020\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J,\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0005H&J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0013H&J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0005H&J<\u0010#\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030 H&J\u001a\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010)\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00132\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'H&J\u001c\u0010*\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00132\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'H&J\n\u0010+\u001a\u0004\u0018\u00010\u001cH&J\n\u0010-\u001a\u0004\u0018\u00010,H&J\n\u0010/\u001a\u0004\u0018\u00010.H&J\u0010\u00101\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0005H&J\n\u00103\u001a\u0004\u0018\u000102H&J\u0018\u00105\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u0013H&J6\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<0;2\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u0002062\b\u00109\u001a\u0004\u0018\u00010\u00052\u0006\u0010:\u001a\u000206H&JN\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0<0;2\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u0002062\u0006\u0010?\u001a\u0002062\b\u0010@\u001a\u0004\u0018\u00010\u00052\u0006\u0010A\u001a\u00020\u00132\u0006\u0010C\u001a\u00020B2\u0006\u0010:\u001a\u000206H&J\u0010\u0010F\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u0005H&J\b\u0010G\u001a\u00020\u0003H&J\u0010\u0010I\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u0005H&J&\u0010L\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u00052\u0014\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010,0JH&J\u0016\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010JH&J\u0011\u0010N\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\bN\u0010OJ\u0010\u0010P\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u0005H&J \u0010T\u001a\u00020S2\u0006\u0010R\u001a\u00020Q2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0017H&J@\u0010Z\u001a\u00020\u00032\u0006\u0010U\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020B2\u0006\u0010X\u001a\u00020W2\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010 H&J0\u0010\\\u001a\u00020\u00032\u0006\u0010U\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010[\u001a\u00020\u00132\u0006\u0010X\u001a\u00020WH&J\u001a\u0010]\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0012\u0010_\u001a\u0004\u0018\u00010\u00052\u0006\u0010^\u001a\u00020\u0005H&Jb\u0010j\u001a\u0004\u0018\u00010.2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001e2>\u0010g\u001a:\u0012\u0013\u0012\u00110a¢\u0006\f\bb\u0012\b\bc\u0012\u0004\b\b(d\u0012\u0015\u0012\u0013\u0018\u00010e¢\u0006\f\bb\u0012\b\bc\u0012\u0004\b\b((\u0012\u0006\u0012\u0004\u0018\u00010.0`j\u0002`f2\u0006\u0010i\u001a\u00020hH&J\u001c\u0010n\u001a\u0004\u0018\u00010.2\u0006\u0010k\u001a\u00020\u001c2\b\u0010m\u001a\u0004\u0018\u00010lH&J,\u0010q\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010o\u001a\u00020\u00052\u0012\u0010p\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050JH&J \u0010t\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020s\u0018\u00010r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&J\u0010\u0010v\u001a\u00020\u00032\u0006\u0010u\u001a\u00020\u0013H&J\u0012\u0010w\u001a\u00020\u00032\b\u0010H\u001a\u0004\u0018\u00010\u0005H&J\b\u0010x\u001a\u00020\u0003H&J\u0012\u0010{\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030z0yH&J#\u0010\u0080\u0001\u001a\u00020\u00032\u0006\u0010|\u001a\u00020\u00132\b\u0010~\u001a\u0004\u0018\u00010}2\u0006\u0010\u007f\u001a\u00020BH&J\u0011\u0010\u0081\u0001\u001a\u00020\u00032\u0006\u0010|\u001a\u00020\u0013H&J\u0011\u0010\u0082\u0001\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u0005H&J\u0011\u0010\u0083\u0001\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u0005H&J\u001a\u0010\u0085\u0001\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u00052\u0007\u0010\u0084\u0001\u001a\u00020BH&J\u001b\u0010\u0086\u0001\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&J\t\u0010\u0087\u0001\u001a\u00020\u0003H&J\t\u0010\u0088\u0001\u001a\u00020\u0013H&J\u0012\u0010\u0089\u0001\u001a\u00020\u00032\u0007\u0010\u0088\u0001\u001a\u00020\u0013H&J\u0011\u0010\u008a\u0001\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0013H&J\u0011\u0010\u008b\u0001\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0013H&J%\u0010\u008e\u0001\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\u00052\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u0001H&J(\u0010\u0090\u0001\u001a\t\u0012\u0004\u0012\u00020\u00130\u008f\u00012\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH&J\f\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u0001H&J\t\u0010\u0093\u0001\u001a\u00020\u0005H&J\u0011\u0010\u0094\u0001\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0013H&J\t\u0010\u0095\u0001\u001a\u00020\u0005H&J\f\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0096\u0001H&J\u0013\u0010\u009a\u0001\u001a\u00020\u00032\b\u0010\u0099\u0001\u001a\u00030\u0098\u0001H&J\t\u0010\u009b\u0001\u001a\u00020\u0013H&J7\u0010¡\u0001\u001a\u00020\u00032\u0007\u0010\u009c\u0001\u001a\u00020\u00052\b\u0010\u009e\u0001\u001a\u00030\u009d\u00012\u0019\b\u0002\u0010 \u0001\u001a\u0012\u0012\u0005\u0012\u00030\u009d\u0001\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u009f\u0001H&J\u001c\u0010£\u0001\u001a\u0005\u0018\u00010¢\u00012\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0017H&¨\u0006¦\u0001"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/interactgame/IInteractGameService;", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/IMiddlewareInteractGameService;", "Lcom/bytedance/android/live/base/IService;", "", "stopRunningPlugin", "", "reason", "Lcom/bytedance/android/live/pushstream/d;", "liveStream", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", NewBroadcastMonitor.PAGE.ROOM, "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/bytedance/android/live/broadcastgame/api/IAnchorGameWidget;", "getAnchorGameWidget", "seiMsg", "onSei", "", "isDegrade", "Lcom/bytedance/android/live/broadcastgame/api/IAudienceGameWidget;", "getAudienceGameWidget", "Landroid/content/Context;", "context", "from", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/h;", "getGameExitConformDialog", "Lcom/bytedance/android/live/broadcastgame/api/model/u;", "gameItem", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lkotlin/Function0;", "onSuccess", "onFail", "tryGetSwitchGameConfirmDialog", "key", "sendGameSeiData", "inCast", "Lorg/json/JSONObject;", "extra", "sendGameCastStatusSEI", "sendServerMergeCastStatusSEI", "getCurrentPlayingGame", "", "createOpenToolbarEntBehavior", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "createOpenGameBehaivor", "guideParams", "setGameGuideHelper", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/d;", "getGameGuideHelper", "isAnchor", "initGameContext", "", "gameId", "roomId", "openType", "gameToken", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/broadcastgame/api/model/e0;", "notifyServerGameStart", "playId", "gameData", "isCutShort", "", "stopReason", "notifyServerGameStop", "appId", "anchorLaunchGame", "audienceLaunchGame", "schema", "preloadOpenPlatformGame", "", "startParmaMap", "openOpenPlatformGame", "getOpenPlatformGameCommonLogMap", "isOpenPlatformGameOpeningLynxPanelInGame", "()Ljava/lang/Boolean;", "closeOpenPlatformGame", "Lcom/bytedance/android/livesdkapi/hybridapi/IJsBridgeManager;", "jsBridgeManager", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/JsFuncInjector;", "createOpenJsFuncInject", "ctx", "code", "", "e", "retry", "confirmGameStartFailed", "anchor", "confirmGameException", "executeEnterRoomTask", "cipherText", "decryptUserInfo", "Lkotlin/Function2;", "Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell;", "Lkotlin/ParameterName;", "name", "data", "Lcom/bytedance/android/live/broadcastgame/api/model/z;", "Lcom/bytedance/android/live/broadcastgame/api/model/LiveOpenFeatureBehaviorFactory;", "behaviorFactory", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/g;", "createFactory", "getOpenPlatformBehavior", "item", "Lmh1/p;", "miniAppHelper", "getOpenPlatformItemBehavior", "location", "liveParams", "openMiniApp", "Le10/b;", "Le10/a$a;", "getLiveOpenFeatureSceneFilter", "isReady", "setAudienceMiniAppReady", "setAudienceMiniAppSchema", "stopGameCastToAudience", "", "Ljava/lang/Class;", "getAllOpenPlatformActivity", "success", "Landroid/view/Surface;", "surface", "fps", "notifyStartLinkCastResult", "notifyStopLinkCastResult", "addItemToDataCacheHelper", "deleteData", "visibility", "cacheEntranceVisibility", "consumeCacheOpenPlatformMessage", "clearCache", "isGameCasting", "setGameCasting", "hidePlugin", "showPlugin", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/p;", "sonicPluginListener", "startOpenPlatformSonicPlugin", "Lio/reactivex/Single;", "showOpenGameAuthDialog", "Lcom/bytedance/android/live/broadcastgame/api/openplatform/c;", "getOpenGameClient", "getCurrentSonicGameAppId", "getGameCategory", "getCurrentGameName", "Lcom/bytedance/android/live/broadcastgame/api/xplay/e;", "getXplayGlobalService", "Landroid/view/ViewGroup;", "view", "setAnchorInteractPlayContainer", "isInteractPlayRunning", "method", "Lcom/google/gson/JsonObject;", "param", "Lkotlin/Function1;", "callback", "handleAnchorPanelJSBInvoke", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/a0;", "createToolbarComponentConfig", "Companion", "a", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@ServiceDummyLookup("com.bytedance.android.live.broadcastgame.api.InteractGameServiceDummy")
public interface IInteractGameService extends IMiddlewareInteractGameService, IService {
    public static final a Companion = null;
    public static final int ENTRANCE_INVISIBLE = 0;
    public static final int ENTRANCE_VISIBLE = 1;
    public static final int ENTRANCE_VISIBLE_UNKNOWED = -1;
    public static final String EXIT_FROM_EFFECT_SINGLE = "effect-single";
    public static final String EXIT_FROM_WMINI_GAME_TYPE = "wmini-game-type";
    public static final int FORCE_TO_STOP_GAME = 1000;
    public static final String TAG = "InteractGameService";
    public static final int TYPE_FOLD_MANAGER_DEFAULT = 0;
    public static final int TYPE_FOLD_MANAGER_INTERACT = 1;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }

    void addItemToDataCacheHelper(String r1);

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    void anchorLaunchGame(String r1);

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    void audienceLaunchGame();

    void cacheEntranceVisibility(String r1, int r2);

    void clearCache();

    void closeOpenPlatformGame(String r1);

    void confirmGameException(Context r1, DataCenter r2, u r3, boolean r4, Throwable r5);

    void confirmGameStartFailed(Context r1, DataCenter r2, u r3, int r4, Throwable r5, Function0<Unit> r6);

    void consumeCacheOpenPlatformMessage(String r1, DataCenter r2);

    c0.b createOpenGameBehaivor();

    JsFuncInjector createOpenJsFuncInject(IJsBridgeManager r1, DataCenter r2, Context r3);

    Object createOpenToolbarEntBehavior();

    a0 createToolbarComponentConfig(DataCenter r1, Context r2);

    String decryptUserInfo(String r1);

    void deleteData(String r1);

    void executeEnterRoomTask(boolean r1, Room r2);

    List<Class<?>> getAllOpenPlatformActivity();

    IAnchorGameWidget getAnchorGameWidget(com.bytedance.android.live.pushstream.d r1, Room r2, Fragment r3, FragmentManager r4);

    IAudienceGameWidget getAudienceGameWidget(boolean r1);

    String getCurrentGameName();

    u getCurrentPlayingGame();

    String getCurrentSonicGameAppId();

    String getGameCategory(boolean r1);

    h getGameExitConformDialog(Context r1, String r2);

    d getGameGuideHelper();

    e10.b<u, e10.a.C0226a> getLiveOpenFeatureSceneFilter(DataCenter r1);

    com.bytedance.android.live.broadcastgame.api.openplatform.c getOpenGameClient();

    c0.b getOpenPlatformBehavior(Context r1, DataCenter r2, Function2<? super InteractEntranceCell, ? super z, ? extends c0.b> r3, g r4);

    Map<String, String> getOpenPlatformGameCommonLogMap();

    c0.b getOpenPlatformItemBehavior(u r1, mh1.p r2);

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    com.bytedance.android.live.broadcastgame.api.xplay.e getXplayGlobalService();

    void handleAnchorPanelJSBInvoke(String r1, JsonObject r2, Function1<? super JsonObject, Unit> r3);

    void hidePlugin(boolean r1);

    void initGameContext(Fragment r1, boolean r2);

    boolean isGameCasting();

    boolean isInteractPlayRunning();

    Boolean isOpenPlatformGameOpeningLynxPanelInGame();

    Observable<com.bytedance.android.live.network.response.e<e0>> notifyServerGameStart(long r1, long r3, String r5, long r6);

    Observable<com.bytedance.android.live.network.response.e<Object>> notifyServerGameStop(long r1, long r3, long r5, String r7, boolean r8, int r9, long r11);

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    void notifyStartLinkCastResult(boolean r1, Surface r2, int r3);

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    void notifyStopLinkCastResult(boolean r1);

    void onSei(String r1);

    boolean openMiniApp(Context r1, String r2, Map<String, String> r3);

    void openOpenPlatformGame(String r1, Map<String, ? extends Object> r2);

    void preloadOpenPlatformGame(String r1);

    void sendGameCastStatusSEI(boolean r1, JSONObject r2);

    void sendGameSeiData(String r1, String r2);

    void sendServerMergeCastStatusSEI(boolean r1, JSONObject r2);

    void setAnchorInteractPlayContainer(ViewGroup r1);

    void setAudienceMiniAppReady(boolean r1);

    void setAudienceMiniAppSchema(String r1);

    void setGameCasting(boolean r1);

    void setGameGuideHelper(String r1);

    Single<Boolean> showOpenGameAuthDialog(Context r1, DataCenter r2, u r3);

    void showPlugin(boolean r1);

    void startOpenPlatformSonicPlugin(Context r1, String r2, p r3);

    void stopGameCastToAudience();

    @Deprecated(message = "", replaceWith = @ReplaceWith(expression = "stopRunningPlugin(String)", imports = {}))
    void stopRunningPlugin();

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    void stopRunningPlugin(String r1);

    void tryGetSwitchGameConfirmDialog(u r1, Context r2, DataCenter r3, Function0<Unit> r4, Function0<Unit> r5);
}
