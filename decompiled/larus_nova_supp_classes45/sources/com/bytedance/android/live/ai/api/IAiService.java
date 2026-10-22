package com.bytedance.android.live.ai.api;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ai.api.engine.IPitayaKVStore;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.ai.callback.IAiCallback;
import com.bytedance.android.livesdkapi.ai.game.IAiPredictCallback;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;
import ox.a;
import ox.b;
import ox.c;
import ox.d;
import ox.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.live.ai.impl.AiService")
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH&J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\bH&J\b\u0010\u000e\u001a\u00020\rH&J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J$\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\b\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001b\u001a\u00020\u0002H&J\b\u0010\u001c\u001a\u00020\u0004H&J\u001e\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH&J\b\u0010\"\u001a\u00020!H&J\n\u0010#\u001a\u0004\u0018\u00010\u0012H&J\b\u0010$\u001a\u00020\u0002H&J\u0018\u0010)\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H&J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H&J\u0010\u0010-\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H&J\u0012\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010.H&J\u0018\u00101\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u000200H&J\b\u00102\u001a\u00020\u0002H&J\u0018\u00103\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u000200H&J\b\u00104\u001a\u00020\u0002H&J\u0010\u00105\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u00106\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u00108\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u000207H&J\b\u00109\u001a\u00020\u0002H&J\u0010\u0010:\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u000207H&J\b\u0010;\u001a\u00020\u0002H&J\u0010\u0010<\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u000207H&J\b\u0010=\u001a\u00020\u0002H&J\u0010\u0010>\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u000207H&J\n\u0010?\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010B\u001a\u0004\u0018\u00010A2\u0006\u0010@\u001a\u00020\u0012H&J\b\u0010C\u001a\u00020\u0002H&J\u0010\u0010D\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010E\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u000207H&J\u0010\u0010F\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u000207H&J\u0010\u0010G\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H&J\b\u0010H\u001a\u00020\u0002H&J\u0010\u0010I\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010J\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&J\u001c\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\u001c\u0010L\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\b\u0010N\u001a\u00020MH&J\b\u0010P\u001a\u00020OH&J\u0010\u0010S\u001a\u00020\u00022\u0006\u0010R\u001a\u00020QH&J\b\u0010U\u001a\u00020TH&J\b\u0010V\u001a\u00020\u0004H&J\b\u0010W\u001a\u00020\u0004H&J\b\u0010X\u001a\u00020\u0004H&J\b\u0010Y\u001a\u00020\u0004H&J\u0010\u0010\\\u001a\u00020\u00042\u0006\u0010[\u001a\u00020ZH&J\u0010\u0010^\u001a\u00020\u00022\u0006\u0010]\u001a\u00020\u0014H&J$\u0010a\u001a\u00020\u00022\u0006\u0010_\u001a\u00020'2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010`\u001a\u0004\u0018\u00010\u0016H&J\u0010\u0010c\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020bH&J\u0012\u0010d\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010bH&J\u001c\u0010g\u001a\u00020\u00022\b\u0010e\u001a\u0004\u0018\u00010\u00122\b\u0010f\u001a\u0004\u0018\u00010\u0014H&J\b\u0010i\u001a\u00020hH&J\u001c\u0010m\u001a\u0004\u0018\u00010l2\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010k\u001a\u00020jH&J\u0012\u0010o\u001a\u0004\u0018\u00010\u00122\u0006\u0010n\u001a\u00020\u0004H&¨\u0006p"}, d2 = {"Lcom/bytedance/android/live/ai/api/IAiService;", "Lcom/bytedance/android/live/base/IService;", "", "preInit", "", "isAiEngineReady", "Lnx/a;", "roomLifecycleObserver", "Lox/c;", "broadcastLifecycleListener", "listener", "registerbroadcastLifecycleListener", "unregisterBroadcastLifecycleListener", "Lox/d;", "broadcastPreviewLifecycleListener", "Lnx/c;", "request", "predict", "", "businessName", "Lorg/json/JSONObject;", "params", "Lcom/bytedance/android/livesdkapi/ai/callback/IAiCallback;", "callback", "runPredict", "Lyx/a;", "getHarService", "triggerSRPredict", "isDynamicSREnable", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "playerClient", "", "findDynamicSRRecord", "Lay/a;", "getOhrService", "predictResolution", "triggerResolutionPredict", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", NewBroadcastMonitor.PAGE.ROOM, "", "flag", "setResolutionStrategyInput", "Ljava/util/LinkedList;", "", "getRoomListNotToPredictResolution", "setRoomListNotToPredictResolution", "", "getRoomLifecycleObserverList", "Lcom/bytedance/android/livesdkapi/ai/game/IAiPredictCallback;", "triggerGamePredict", "stopGamePredict", "triggerGameDetailPreloadPredict", "stopGameDetailPreloadPredict", "triggerDrawerPredict", "triggerPreviewWormholePreloadPredict", "Lxx/a;", "registerGiftAsyncSortCallback", "removeGiftAsyncSortCallback", "registerGiftListPreloadCallback", "removeGiftListPreloadCallback", "registerGiftAssetDownloadCallback", "removeGiftAssetDownloadCallback", "registerFastGiftRecommendMessageHandler", "getRawPMFeature", "string", "", "getPMFeature", "removeFastGiftRecommendCallback", "triggerLinkPanelPredict", "registerLinkPanelPreloadCallback", "registerAnchorShareCallback", "removeAnchorShareCallback", "removeLinkPanelPreloadCallback", "triggerGiftAsyncSort", "triggerFastGiftAsyncSort", "triggerSkylightPreloadPredict", "triggerInnerPredict", "Lox/e;", "videoCallback", "Lox/b;", "audioCallback", "Landroidx/fragment/app/FragmentActivity;", "activity", "showDebugDialog", "Lox/a;", "anchorAiService", "isAnchorAsrEnable", "isAnchorOcrEnable", "isAnchorPornDetectEnable", "isAnchorQrCodeDetectEnable", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "liveMode", "enableAnchorContentDetect", "msgInfo", "handleMessage", "action", "aiCallback", "handleAction", "Lpx/a;", "registerRecognizeListener", "unRegisterRecognizeListener", "eventName", "eventParams", "onPitayaAppLogEvent", "Lcy/a;", "getLiveRevenueAiService", "Lcom/bytedance/android/live/ai/api/engine/IPitayaKVStore$ServiceType;", "serviceType", "Lcom/bytedance/android/live/ai/api/engine/IPitayaKVStore;", "getPitayaKVStore", "enableCacheOpt", "getLiveRecommendFeatures", "liveai-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAiService extends IService {
    a anchorAiService();

    b audioCallback();

    c broadcastLifecycleListener();

    d broadcastPreviewLifecycleListener();

    boolean enableAnchorContentDetect(LiveMode r1);

    Map<String, String> findDynamicSRRecord(ILivePlayerClient r1);

    yx.a getHarService();

    String getLiveRecommendFeatures(boolean r1);

    cy.a getLiveRevenueAiService();

    ay.a getOhrService();

    Object getPMFeature(String r1);

    IPitayaKVStore getPitayaKVStore(String r1, IPitayaKVStore.ServiceType r2);

    JSONObject getRawPMFeature();

    List<nx.a> getRoomLifecycleObserverList();

    LinkedList<Long> getRoomListNotToPredictResolution();

    void handleAction(int r1, JSONObject r2, IAiCallback r3);

    void handleMessage(JSONObject r1);

    boolean isAiEngineReady();

    boolean isAnchorAsrEnable();

    boolean isAnchorOcrEnable();

    boolean isAnchorPornDetectEnable();

    boolean isAnchorQrCodeDetectEnable();

    boolean isDynamicSREnable();

    void onPitayaAppLogEvent(String r1, JSONObject r2);

    void preInit();

    boolean predict(nx.c r1);

    String predictResolution();

    void registerAnchorShareCallback(xx.a r1);

    void registerFastGiftRecommendMessageHandler(xx.a r1);

    void registerGiftAssetDownloadCallback(xx.a r1);

    void registerGiftAsyncSortCallback(xx.a r1);

    void registerGiftListPreloadCallback(xx.a r1);

    void registerLinkPanelPreloadCallback(xx.a r1);

    void registerRecognizeListener(px.a r1);

    void registerbroadcastLifecycleListener(c r1);

    void removeAnchorShareCallback(String r1);

    void removeFastGiftRecommendCallback();

    void removeGiftAssetDownloadCallback();

    void removeGiftAsyncSortCallback();

    void removeGiftListPreloadCallback();

    void removeLinkPanelPreloadCallback();

    nx.a roomLifecycleObserver();

    boolean runPredict(String r1, JSONObject r2, IAiCallback r3);

    void setResolutionStrategyInput(IRoom r1, int r2);

    void setRoomListNotToPredictResolution(IRoom r1);

    void showDebugDialog(FragmentActivity r1);

    void stopGameDetailPreloadPredict();

    void stopGamePredict();

    void triggerDrawerPredict(JSONObject r1);

    void triggerFastGiftAsyncSort(JSONObject r1);

    void triggerGameDetailPreloadPredict(JSONObject r1, IAiPredictCallback r2);

    void triggerGamePredict(JSONObject r1, IAiPredictCallback r2);

    void triggerGiftAsyncSort(JSONObject r1);

    boolean triggerInnerPredict(JSONObject r1, IAiCallback r2);

    void triggerLinkPanelPredict(JSONObject r1);

    void triggerPreviewWormholePreloadPredict(JSONObject r1);

    void triggerResolutionPredict();

    void triggerSRPredict();

    void triggerSkylightPreloadPredict(JSONObject r1, IAiCallback r2);

    void unRegisterRecognizeListener(px.a r1);

    void unregisterBroadcastLifecycleListener(c r1);

    e videoCallback();
}
