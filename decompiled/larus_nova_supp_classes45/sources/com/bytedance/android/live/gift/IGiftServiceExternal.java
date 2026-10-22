package com.bytedance.android.live.gift;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import ca0.b;
import ca0.c;
import ca0.g;
import ca0.o;
import ca0.r;
import ca0.w;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.resources.AssetsModel;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.Gift;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.m1;
import com.bytedance.android.livesdk.gift.model.m2;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.f;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdkapi.depend.live.gift.ILiveGiftPlayControllerManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.IRevenueFeedGameEffectServiceContainer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import ga0.a;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.live.revenue.service.gift.GiftServiceWrapper")
public interface IGiftServiceExternal extends IService {
    void autoPlayMP4(String r1, Long r2, String r3);

    void cleanGiftDishCache();

    Long clearAppAssetDir(Boolean r1);

    void clearAssets(String r1);

    void clearGiftExposureCache();

    void clearGiftMemoryCache();

    void clearMarkResource();

    Bundle clearOverdueResource();

    void clearSensitiveLRUAsset();

    void downloadAssets(String r1, long r2, f r4, int r5);

    Gift findGiftById(long r1);

    m1 findGiftExtraInfo(long r1);

    h2 findLiteGiftById(long r1);

    AssetsModel getAssets(String r1, long r2);

    IAssetsManager getAssetsManager();

    String getAssetsPath(String r1, long r2);

    BaseCommentGiftGuideView getCommentGiftGuideView(Context r1);

    c getCommonPlayerControllerManager();

    c0.b getEffectGameToolbarBehavior(Context r1, String r2);

    Gift getFastGift();

    LiveRecyclableWidget getGestureGiftGuideWidget();

    b getGiftAnimationEngine(GiftType r1);

    LiveRecyclableWidget getGiftEffectInfoLynxWidget();

    LiveRecyclableWidget getGiftFourthLineWidget();

    LiveRecyclableWidget getGiftFrontSeatLayerEffectWidget();

    Dialog getGiftGuideDialog(Context r1, Room r2, IUser r3, ga0.b r4, long r5, String r7, long r8, String r11, DataCenter r12);

    a getGiftGuidePresenter(DataCenter r1);

    List<zo2.a> getGiftNitaViewList();

    List<zo2.a> getGiftPanelNitaViewList();

    Class<? extends LiveRecyclableWidget> getGiftPreviewDebugWidget();

    LiveRecyclableWidget getGiftTouchReceiveWidget();

    ca0.a getGiftTrayHeightInfo();

    uu0.a getGiftTrayPreviewView(Context r1, uu0.b r2);

    r getGiftUIStrategy();

    int getGiftUseDiskCacheSize();

    f6.c getGiftWidget(Context r1, LifecycleOwner r2, DataCenter r3, int r4);

    Class<? extends Widget> getGiftWidgetClass();

    long getLastEnterRoomTime();

    Widget getMatchRoomGiftTrayWidget();

    Class<? extends Widget> getMultiPlayerClass();

    LiveRecyclableWidget getPKBattlePropEffectWidget();

    LiveRecyclableWidget getPKTrayWidget();

    o getRevenueEventCenter();

    IRevenueFeedGameEffectServiceContainer getRevenueFeedGameEffectServiceContainer(ViewGroup r1);

    long getSendGiftMoney();

    long getSendGiftTime();

    long getSensitiveClearAssetSize();

    List<Gift> getStickerGifts();

    LiveRecyclableWidget getTopAtmosphereEffectWidget();

    int getUserConsumeLevel();

    ILiveGiftPlayControllerManager giftPlayControllerManager();

    void initGiftModule(Context r1, LifecycleOwner r2, DataCenter r3);

    void initGiftResourceCache();

    void initGiftResourceManager(Context r1);

    boolean isAssetsDownloaded(String r1, long r2);

    boolean isGiftListLoaded();

    void monitorEffectPlayEvent(EffectMessage r1, String r2, int r3, String r4, JSONObject r5);

    void monitorEffectPlayEvent(o7 r1, String r2, int r3, String r4, JSONObject r5);

    Observable<JSONObject> observeGiftMsgContent();

    void openGiftEffectConfigurationDialog(Context r1, Boolean r2, Boolean r3);

    void openGroupLiveDialog(String r1);

    void receiveStickGiftMSgEvent(o7 r1);

    void registerInRoomService(g r1);

    void registerMonkeyGameEngine(ea0.a r1);

    void removeAnimationEngine(GiftType r1);

    void removeFastGiftFromMap(long r1);

    void removeMonkeyGameEngine();

    void removeTemporaryFastGift(long r1);

    void reportStickEffectRenderResult(HashMap<String, String> r1);

    void reportStickResourceLoadResult(HashMap<String, String> r1);

    Observable<ExtraResponse<p2, ? extends Extra>> sendGift(b0 r1, int r2);

    void sendPlayAlphaVideoEvent(zg1.h2 r1);

    Observable<ExtraResponse<m2, Extra>> sendProp(b0 r1, int r2);

    void setAllowSendToGuest(boolean r1);

    void setGiftAnimationEngine(GiftType r1, b r2) throws Exception;

    void setTemporaryFastGift(long r1);

    void stickFirstFrameEvent(String r1, String r2, JSONObject r3, HashMap<String, String> r4);

    void syncAssetsList(String r1, int r2);

    void syncGiftList();

    void syncGiftList(int r1);

    void syncGiftList(w r1, long r2, int r4, boolean r5, String r6);

    void syncGiftPanel();

    void syncMultiAnchorList();

    void toggleVideoGiftView(boolean r1);

    void triggerGiftAsyncSort(JSONObject r1);

    void unRegisterInRoomService();

    void updateHotRoomInfo(float r1, double r2, double r4);
}
