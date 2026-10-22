package com.bytedance.android.live.gift;

import am2.f0;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import ca0.b;
import ca0.g;
import ca0.i;
import ca0.j;
import ca0.l;
import ca0.o;
import ca0.q;
import ca0.r;
import ca0.s;
import ca0.w;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.m1;
import com.bytedance.android.livesdk.gift.model.m2;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.f;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.gift.platform.core.model.t;
import com.bytedance.android.livesdk.log.model.WishComboDataLog;
import com.bytedance.android.livesdk.message.model.n6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdkapi.depend.live.gift.ILiveGiftPlayControllerManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.IRevenueFeedGameEffectServiceContainer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.lynx.tasm.LynxView;
import dy0.c;
import ga0.a;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.livesdk.gift.platform.core.GiftServiceKt")
public interface IGiftService extends j, IService, c {
    @Override // ca0.j
    /* synthetic */ void addGiftSendResultListener(s r1);

    /* synthetic */ boolean allowSendToGuest();

    /* synthetic */ void autoPlayMP4(String r1, Long r2, String r3);

    /* synthetic */ boolean checkGroupContainerType(int r1);

    /* synthetic */ void cleanGiftDishCache();

    /* synthetic */ Long clearAppAssetDir(Boolean r1);

    /* synthetic */ void clearAssets(String r1);

    @Override // ca0.j
    /* synthetic */ void clearBattlePropCardMessageQueue();

    /* synthetic */ void clearGiftExposureCache();

    /* synthetic */ void clearGiftMemoryCache();

    /* synthetic */ void clearMarkResource();

    /* synthetic */ Bundle clearOverdueResource();

    /* synthetic */ void clearSensitiveLRUAsset();

    /* synthetic */ void closeGiftDialog();

    @Override // ca0.j
    /* synthetic */ void convertHonorImageModel(k r1);

    @Override // ca0.j
    /* synthetic */ List<String> convertRichContentImageUrls(List<String> r1);

    View createView(String r1, Context r2, AttributeSet r3);

    @Override // ca0.j
    /* synthetic */ void downloadAssets(String r1, long r2, f r4, int r5);

    @Override // ca0.j
    /* synthetic */ void downloadAssets(String r1, long r2, f r4, int r5, AssetDownloadPriority r6);

    @Override // ca0.j
    /* synthetic */ h1 findGiftById(long r1);

    /* synthetic */ m1 findGiftExtraInfo(long r1);

    @Override // ca0.j
    /* synthetic */ h2 findLiteGiftById(long r1);

    /* synthetic */ e getAssets(String r1, long r2);

    @Override // ca0.j
    /* synthetic */ IAssetsManager getAssetsManager();

    @Override // ca0.j
    /* synthetic */ String getAssetsPath(String r1, long r2);

    @Override // ca0.j
    /* synthetic */ BaseCommentGiftGuideView getCommentGiftGuideView(Context r1);

    /* synthetic */ ca0.c getCommonPlayerControllerManager();

    /* synthetic */ IBaseUser getDefaultUserToSendGift();

    /* synthetic */ View.OnClickListener getEffectGameToolbarBehavior(Context r1, String r2);

    /* synthetic */ Map<String, String> getEventCenterCommonParams();

    @Override // ca0.j
    /* synthetic */ h1 getFastGift();

    /* synthetic */ LiveRecyclableWidget getGestureGiftGuideWidget();

    /* synthetic */ b getGiftAnimationEngine(GiftType r1);

    /* synthetic */ LiveRecyclableWidget getGiftEffectInfoLynxWidget();

    /* synthetic */ LiveRecyclableWidget getGiftFourthLineWidget();

    /* synthetic */ LiveRecyclableWidget getGiftFrontSeatLayerEffectWidget();

    /* synthetic */ Dialog getGiftGuideDialog(Context r1, IRoom r2, IBaseUser r3, ga0.b r4, long r5, String r7, long r8, String r11, DataCenter r12);

    /* synthetic */ a getGiftGuidePresenter(DataCenter r1);

    o7 getGiftMessage(long r1, p2 r3, IBaseUser r4);

    /* synthetic */ List<zo2.a> getGiftNitaViewList();

    /* synthetic */ List<zo2.a> getGiftPanelNitaViewList();

    /* synthetic */ Class<? extends LiveRecyclableWidget> getGiftPreviewDebugWidget();

    @Override // ca0.j
    /* synthetic */ i getGiftRenderFilterWrapper();

    @Override // ca0.j
    /* synthetic */ BehaviorSubject<Long> getGiftSelectObservable();

    /* synthetic */ LiveRecyclableWidget getGiftTouchReceiveWidget();

    /* synthetic */ uu0.a getGiftTrayPreviewView(Context r1, uu0.b r2);

    @Override // ca0.j
    /* synthetic */ boolean getGiftTraySwitch();

    /* synthetic */ r getGiftUIStrategy();

    /* synthetic */ int getGiftUseDiskCacheSize();

    @Override // ca0.j
    /* synthetic */ l getGiftWallPreRequestManager();

    /* synthetic */ f6.c getGiftWidget(Context r1, LifecycleOwner r2, DataCenter r3, int r4);

    /* synthetic */ Class<? extends Widget> getGiftWidgetClass();

    @Override // ca0.j
    /* synthetic */ List<IBaseUser> getGroupMemberList();

    @Override // ca0.j
    /* synthetic */ int getGroupMemberNum();

    /* synthetic */ boolean getIsNewGiftPanel();

    /* synthetic */ long getLastEnterRoomTime();

    /* synthetic */ o getLiveRevenueEventCenter();

    @Override // ca0.j
    /* synthetic */ Widget getMatchRoomGiftTrayWidget();

    /* synthetic */ Class<? extends Widget> getMultiPlayerClass();

    @Override // ca0.j
    /* synthetic */ boolean getNeedShowGiftEffectSwitch();

    /* synthetic */ LiveRecyclableWidget getPKBattlePropEffectWidget();

    /* synthetic */ LiveRecyclableWidget getPKTrayWidget();

    /* synthetic */ IRevenueFeedGameEffectServiceContainer getRevenueFeedGameEffectServiceContainer(ViewGroup r1);

    /* synthetic */ long getSendGiftMoney();

    f0 getSendGiftResultLog(p2 r1);

    /* synthetic */ long getSendGiftTime();

    /* synthetic */ long getSensitiveClearAssetSize();

    /* synthetic */ List<h1> getStickerGifts();

    /* synthetic */ LiveRecyclableWidget getTopAtmosphereEffectWidget();

    @Override // ca0.j
    /* synthetic */ q getUICanvasMonitor();

    /* synthetic */ int getUserConsumeLevel();

    WishComboDataLog getWishComboDataMap();

    /* synthetic */ ILiveGiftPlayControllerManager giftPlayControllerManager();

    /* synthetic */ boolean hasExpiredPKPropCard();

    @Override // ca0.j
    /* synthetic */ boolean hasPKPropCard();

    /* synthetic */ void initGiftEffectDialog();

    /* synthetic */ void initGiftModule(Context r1, LifecycleOwner r2, DataCenter r3);

    /* synthetic */ void initGiftResourceCache();

    /* synthetic */ void initGiftResourceManager(Context r1);

    void injectLiveLynxCanvasTTPlayer(LynxView r1, Context r2, String r3);

    @Override // ca0.j
    /* synthetic */ boolean isAssetsDownloaded(String r1, long r2);

    /* synthetic */ boolean isGiftListLoaded();

    /* synthetic */ boolean isVSGiftIconShow(DataCenter r1);

    void monitorEffectPlayEvent(EffectMessage r1, String r2, int r3, String r4, JSONObject r5);

    void monitorEffectPlayEvent(o7 r1, String r2, int r3, String r4, JSONObject r5);

    /* synthetic */ boolean needFrequencyRoomNotifyMessage();

    @Override // ca0.j
    /* synthetic */ void notifyLowPriorityDownloadTask(Boolean r1);

    /* synthetic */ Observable<JSONObject> observeGiftMsgContent();

    Observable onDialogHide();

    void openGiftDialog(int r1);

    /* synthetic */ void openGiftDialog(int r1, long r2, Bundle r4, String r5, long r6);

    /* synthetic */ void openGiftDialog(int r1, long r2, Bundle r4, List<String> r5, boolean r6, String r7);

    /* synthetic */ void openGiftDialog(int r1, long r2, String r4, Bundle r5, int r6, JSONObject r7);

    /* synthetic */ void openGiftDialog(int r1, long r2, String r4, Bundle r5, int r6, JSONObject r7, String r8);

    /* synthetic */ void openGiftDialog(int r1, long r2, String r4, Bundle r5, JSONObject r6);

    /* synthetic */ void openGiftDialog(int r1, IBaseUser r2);

    /* synthetic */ void openGiftDialog(IBaseUser r1);

    @Override // ca0.j
    /* synthetic */ void openGiftDialog(IBaseUser r1, Bundle r2);

    /* synthetic */ void openGiftDialog(String r1);

    /* synthetic */ void openGiftDialog(String r1, IBaseUser r2);

    /* synthetic */ void openGiftDialog(String r1, IBaseUser r2, Bundle r3);

    /* synthetic */ void openGiftEffectConfigurationDialog(Context r1, Boolean r2, Boolean r3);

    /* synthetic */ void openGroupLiveDialog(String r1);

    /* synthetic */ void openInteractGiftDialog(Context r1, int r2, Long r3, String r4, Function0<Unit> r5, DialogInterface.OnDismissListener r6);

    /* synthetic */ void playUsePropCardAnimation(k r1, Pair<Integer, Integer> r2);

    /* synthetic */ void playUsePropCardAnimationOnLeftCount(k r1, View r2);

    @Override // ca0.j
    /* synthetic */ void processRevenueApiResponse(String r1, JSONObject r2);

    /* synthetic */ void receiveBattleDrawPropCardMessage(n6 r1);

    void receiveStickGiftMSgEvent(o7 r1);

    @Override // ca0.j
    /* synthetic */ void registerGiftPreviewDebugWidgetInstance(LiveRecyclableWidget r1);

    /* synthetic */ void registerInRoomService(g r1);

    /* synthetic */ void registerMonkeyGameEngine(ea0.a r1);

    /* synthetic */ void registerRecommendReceiver(long r1, String r3, Map<String, String> r4, Map<String, String> r5);

    /* synthetic */ void registerRecommendReceiver(String r1, String r2, Map<String, String> r3, Map<String, String> r4);

    /* synthetic */ void removeAnimationEngine(GiftType r1);

    /* synthetic */ void removeFastGiftFromMap(long r1);

    @Override // ca0.j
    /* synthetic */ void removeGiftSendResultListener(s r1);

    /* synthetic */ void removeMonkeyGameEngine();

    /* synthetic */ void removeTemporaryFastGift(long r1);

    void reportStickEffectRenderResult(HashMap<String, String> r1);

    void reportStickResourceLoadResult(HashMap<String, String> r1);

    @Override // ca0.j
    /* synthetic */ Observable<ExtraResponse<p2, ? extends Extra>> sendGift(b0 r1, int r2);

    /* synthetic */ void sendPlayAlphaVideoEvent(zg1.h2 r1);

    /* synthetic */ Observable<ExtraResponse<m2, Extra>> sendProp(b0 r1, int r2);

    @Override // ca0.j
    /* synthetic */ void setAllowSendToGuest(boolean r1);

    /* synthetic */ void setDefaultUserToSendGift(IBaseUser r1);

    /* synthetic */ void setGiftAnimationEngine(GiftType r1, b r2) throws Exception;

    /* synthetic */ void setGiftTraySwitch(boolean r1);

    @Override // ca0.j
    /* synthetic */ void setNeedShowGiftEffectSwitch(boolean r1);

    /* synthetic */ void setTemporaryFastGift(long r1);

    t startSendMultiGift(b0 r1);

    void stickFirstFrameEvent(String r1, String r2, JSONObject r3, HashMap<String, String> r4);

    Observable<Boolean> subscribeOnBanner();

    @Override // ca0.j
    void syncAssetsList(String r1, int r2);

    /* synthetic */ void syncGiftList();

    @Override // ca0.j
    void syncGiftList(int r1);

    /* synthetic */ void syncGiftList(w r1, long r2, int r4, boolean r5, String r6);

    /* synthetic */ void syncGiftListById(w r1, long r2, int r4, boolean r5, String r6, Long r7, boolean r8);

    @Override // ca0.j
    /* synthetic */ void syncGiftPanel();

    @Override // ca0.j
    /* synthetic */ void syncMultiAnchorList();

    /* synthetic */ void toggleVideoGiftView(boolean r1);

    @Override // ca0.j
    /* synthetic */ void triggerGiftAsyncSort(JSONObject r1);

    /* synthetic */ void unRegisterInRoomService();

    /* synthetic */ void unRegisterRecommendReceiver(String r1, Map<String, String> r2);

    @Override // ca0.j
    void updateGiftTrayPosition(zg1.f0 r1);

    /* synthetic */ void updateHotRoomInfo(float r1, double r2, double r4);
}
