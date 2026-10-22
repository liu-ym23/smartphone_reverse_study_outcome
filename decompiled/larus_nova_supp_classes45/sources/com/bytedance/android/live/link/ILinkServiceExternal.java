package com.bytedance.android.live.link;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.revenuelink.connect.f;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.link.model.bridge.f0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.feed.IInteractFeedView;
import com.bytedance.android.livesdkapi.feed.ImCacheUnit;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.service.IFeedRevenueContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import cy0.a;
import java.util.List;
import kc0.g;
import kc0.h;
import kc0.i;
import kc0.r;
import kc0.s;
import kotlin.Deprecated;
import kotlin.Metadata;
import lc0.b;
import lc0.c;
import lc0.d;
import pc0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.live.revenue.service.link.LinkServiceWrapper")
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J5\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b\f\u0010\rJ,\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H&J\u0012\u0010 \u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0012H&J\b\u0010$\u001a\u00020#H\u0017J\b\u0010&\u001a\u00020%H\u0017J\b\u0010(\u001a\u00020'H\u0017J\b\u0010*\u001a\u00020)H\u0017J\b\u0010,\u001a\u00020+H\u0017J\b\u0010.\u001a\u00020-H\u0017J\b\u00100\u001a\u00020/H\u0017J\u0010\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u00020201H\u0017J\u0010\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u00020201H\u0017J\u0012\u00107\u001a\u00020\u001c2\b\u00106\u001a\u0004\u0018\u000105H&J\u0014\u00108\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000102\u0018\u000101H&J\u0010\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u00020\u0012H&J\u0010\u0010;\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u0012H&J\u0010\u0010=\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\bH&J\b\u0010>\u001a\u00020\u001cH&J\u0010\u0010A\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020?H&J\u0010\u0010C\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\bH&J\u0010\u0010D\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\bH&J\u0010\u0010F\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020\u0012H&J\u0010\u0010H\u001a\u00020\u001c2\u0006\u0010G\u001a\u00020\bH&J\u0010\u0010J\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\bH&J\u0010\u0010L\u001a\u00020\u001c2\u0006\u0010K\u001a\u00020\u0012H&J\u0010\u0010N\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020\bH&J\u0010\u0010O\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020\bH&J\b\u0010P\u001a\u00020\u001cH&J\u0010\u0010Q\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020\bH&J\u0010\u0010R\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020\bH&J\u0010\u0010S\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020\bH&J\b\u0010T\u001a\u00020\u001cH&J\u0012\u0010V\u001a\u00020\u001c2\b\u0010U\u001a\u0004\u0018\u00010'H&J2\u0010]\u001a\u00020\u001c2\b\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u00122\u0006\u0010[\u001a\u00020\u00122\u0006\u0010\\\u001a\u00020?H&J\u001a\u0010_\u001a\u00020\u001c2\b\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010^\u001a\u00020?H&J\u0010\u0010a\u001a\u00020\u001c2\u0006\u0010`\u001a\u00020?H&J\u0010\u0010b\u001a\u00020\u001c2\u0006\u0010`\u001a\u00020?H&J\u0010\u0010d\u001a\u00020\u001c2\u0006\u0010c\u001a\u00020?H&J\u0010\u0010g\u001a\u00020\u001c2\u0006\u0010f\u001a\u00020eH&J\u0010\u0010i\u001a\u00020\u001c2\u0006\u0010h\u001a\u00020\bH&J\u0018\u0010k\u001a\u00020\u001c2\u0006\u0010K\u001a\u00020\u00122\u0006\u0010j\u001a\u00020\u0012H&J\u0010\u0010m\u001a\u00020\u001c2\u0006\u0010l\u001a\u00020\u0012H&J\u0012\u0010n\u001a\u00020\u001c2\b\u0010U\u001a\u0004\u0018\u00010'H&J\u001a\u0010p\u001a\u00020\u001c2\b\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010o\u001a\u00020\u0012H&J\"\u0010r\u001a\u00020\u001c2\b\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010j\u001a\u00020\u00122\u0006\u0010q\u001a\u00020\u0012H&J\u001a\u0010t\u001a\u00020\u001c2\b\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010s\u001a\u00020\u0012H&J\u001a\u0010v\u001a\u00020\u001c2\b\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010u\u001a\u00020\u0012H&J\u0012\u0010y\u001a\u0004\u0018\u00010W2\u0006\u0010x\u001a\u00020wH&J\u0012\u0010z\u001a\u00020\u001c2\b\u0010X\u001a\u0004\u0018\u00010WH&J\u001a\u0010{\u001a\u00020\u001c2\b\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010B\u001a\u00020\bH&J\b\u0010|\u001a\u00020\u0012H&J\u0012\u0010~\u001a\u00020\u001c2\b\u0010}\u001a\u0004\u0018\u00010'H&J\u0011\u0010\u0080\u0001\u001a\u00020\u001c2\u0006\u0010\u007f\u001a\u00020\u0012H&J\t\u0010\u0081\u0001\u001a\u00020\u001cH&R\u0017\u0010\u0084\u0001\u001a\u00020#8&X¦\u0004¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0017\u0010\u0087\u0001\u001a\u00020%8&X¦\u0004¢\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0017\u0010\u008a\u0001\u001a\u00020'8&X¦\u0004¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0017\u0010\u008d\u0001\u001a\u00020)8&X¦\u0004¢\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0017\u0010\u0090\u0001\u001a\u00020+8&X¦\u0004¢\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0017\u0010\u0093\u0001\u001a\u00020-8&X¦\u0004¢\u0006\b\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001f\u0010\u0096\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u000202018&X¦\u0004¢\u0006\b\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R!\u0010\u009b\u0001\u001a\f\u0012\u0005\u0012\u00030\u0098\u0001\u0018\u00010\u0097\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0017\u0010\u009e\u0001\u001a\u00020/8&X¦\u0004¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001f\u0010 \u0001\u001a\n\u0012\u0006\b\u0001\u0012\u000202018&X¦\u0004¢\u0006\b\u001a\u0006\b\u009f\u0001\u0010\u0095\u0001R\u001a\u0010¤\u0001\u001a\u0005\u0018\u00010¡\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b¢\u0001\u0010£\u0001R\u001a\u0010¨\u0001\u001a\u0005\u0018\u00010¥\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b¦\u0001\u0010§\u0001R\u001a\u0010¬\u0001\u001a\u0005\u0018\u00010©\u00018&X¦\u0004¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001R\u0018\u0010°\u0001\u001a\u00030\u00ad\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b®\u0001\u0010¯\u0001R\u0017\u0010³\u0001\u001a\u00020\u00128&X¦\u0004¢\u0006\b\u001a\u0006\b±\u0001\u0010²\u0001R\u0017\u0010¶\u0001\u001a\u00020?8&X¦\u0004¢\u0006\b\u001a\u0006\b´\u0001\u0010µ\u0001¨\u0006·\u0001"}, d2 = {"Lcom/bytedance/android/live/link/ILinkServiceExternal;", "Lcom/bytedance/android/live/base/IService;", "Lpc0/e;", "createRevRtcData", "Lkc0/r$a;", "callback", "Landroid/view/ViewGroup;", "parentView", "", "continueRoomLinkMic", "loadInP0", "Lkc0/r;", "createRevMultiControlWidget", "(Lkc0/r$a;Landroid/view/ViewGroup;Ljava/lang/Boolean;Z)Lkc0/r;", "Landroid/content/Context;", "context", "Lcom/bytedance/android/livesdkapi/model/SeiAppData;", "seiAppData", "", "showFrom", "Lcom/bytedance/android/livesdkapi/service/IFeedRevenueContext;", "feedRevenueContext", "Lcom/bytedance/android/livesdkapi/feed/IInteractFeedView;", "getInteractFeedView", "", "videoCaptureFps", "streamFps", "previewFps", "", "updatePushStreamInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/f0;", "chorusMessage", "receiveChorusMessage", "state", "onMultiAnchorStateChange", "Llc0/d;", "getPkServiceExternal", "Lkc0/h;", "getPerfManagerExternal", "", "getLinkAnchorCount", "Llc0/c;", "getMultiDataHolderExternal", "Llc0/b;", "getMultiAnchorServiceExternal", "Llc0/a;", "getControlServiceExternal", "Lkc0/g;", "getPanelServiceExternal", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getProfitInteractionWidgetClass", "getAnchorTicketWidgetClass", "Lcom/bytedance/ies/sdk/widgets/WidgetManager;", "widgetManager", "loadAnchorLinkContextWidget", "getAnchorLinkWidget", "id", "isSpatialAudioEnable", "notifyCleanModeChanged", "isCleanMode", "notifyIsCleanModeChanged", "notifyUserClose", "", "time", "setEnterRoomTime", "flag", "setSkipRoomStatsSync", "updateStableMode", "status", "updateMicRoomAnchorStatus", "isHideInteractLayout", "updateInteractLayoutShow", "shown", "updateKeyboardStatus", "width", "notifyPkRenderWidth", "join", "notifyAudienceSelfJoin", "notifyPkAnchorSilenceStatus", "notifyPkAudienceUnload", "onAudienceJoinSelfLink", "onAudienceJoinGuestLink", "updateEnterRoomViewMock", "notifyAudienceSelfLeave", "sei", "updateFirstFrameSei", "Lcy0/a;", "livePlayScope", "currentInnerFeedLength", "feedRoomRevLinkScene", "feedRoomRevLinkPkState", "feedRoomBuildTs", "updateFeedParams", "playFragmentStartTs", "updateEnterParams", "timeMills", "updateLoad0Ts", "updateLoad1Ts", "total", "updateAudienceMemberCount", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "liveMode", "updateLiveMode", "isPortrait", "updatePortrait", "height", "notifyRenderSizeChanged", "action", "notifyPauseStatus", "notifyRtcData", "marginTop", "updateInteractMarginTop", "y", "updateVideoHeight", "pkMovedMarginTop", "updatePkMovedMarginTop", "leftMargin", "updatePkLeftMargin", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "enterLivePlay", "leaveLivePlay", "markAddPkBackground", "currentRoomLayoutType", "param", "updateInteractAnchorParam", "code", "notifyStopLive", "notifyStartAudioDiagnosis", "getPkService", "()Llc0/d;", "pkService", "getPerfManager", "()Lkc0/h;", "perfManager", "getAnchorCount", "()Ljava/lang/String;", "anchorCount", "getMultiDataHolder", "()Llc0/c;", "multiDataHolder", "getMultiAnchorService", "()Llc0/b;", "multiAnchorService", "getControlService", "()Llc0/a;", "controlService", "getProfitWidgetClass", "()Ljava/lang/Class;", "profitWidgetClass", "", "Lcom/bytedance/android/livesdkapi/feed/ImCacheUnit;", "getInteractFeedViewImCaches", "()Ljava/util/List;", "interactFeedViewImCaches", "getPanelService", "()Lkc0/g;", "panelService", "getTicketWidgetClass", "ticketWidgetClass", "Lcom/bytedance/android/live/revenuelink/connect/f;", "getConnectService", "()Lcom/bytedance/android/live/revenuelink/connect/f;", "connectService", "Lgy/c;", "getRtcService", "()Lgy/c;", "rtcService", "Lkc0/i;", "getRegionService", "()Lkc0/i;", "regionService", "Lkc0/s;", "getAudioDetectService", "()Lkc0/s;", "audioDetectService", "getEnterRoomLinkmicScene", "()I", "enterRoomLinkmicScene", "getRevLinkControlLoadTs", "()J", "revLinkControlLoadTs", "liverevenue-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILinkServiceExternal extends IService {
    r createRevMultiControlWidget(r.a r1, ViewGroup r2, Boolean r3, boolean r4);

    e createRevRtcData();

    int currentRoomLayoutType();

    a enterLivePlay(DataCenter r1);

    String getAnchorCount();

    Class<? extends Widget> getAnchorLinkWidget();

    @Deprecated(message = "ticketWidgetClass")
    Class<? extends Widget> getAnchorTicketWidgetClass();

    s getAudioDetectService();

    f getConnectService();

    lc0.a getControlService();

    @Deprecated(message = "controlService")
    lc0.a getControlServiceExternal();

    int getEnterRoomLinkmicScene();

    IInteractFeedView getInteractFeedView(Context r1, SeiAppData r2, int r3, IFeedRevenueContext r4);

    List<ImCacheUnit> getInteractFeedViewImCaches();

    @Deprecated(message = "linkAnchorCount")
    String getLinkAnchorCount();

    b getMultiAnchorService();

    @Deprecated(message = "multiAnchorService")
    b getMultiAnchorServiceExternal();

    c getMultiDataHolder();

    @Deprecated(message = "multiDataHolder")
    c getMultiDataHolderExternal();

    g getPanelService();

    @Deprecated(message = "panelService")
    g getPanelServiceExternal();

    h getPerfManager();

    @Deprecated(message = "perfManager")
    h getPerfManagerExternal();

    d getPkService();

    @Deprecated(message = "pkService")
    d getPkServiceExternal();

    @Deprecated(message = "profitWidgetClass")
    Class<? extends Widget> getProfitInteractionWidgetClass();

    Class<? extends Widget> getProfitWidgetClass();

    i getRegionService();

    long getRevLinkControlLoadTs();

    gy.c getRtcService();

    Class<? extends Widget> getTicketWidgetClass();

    boolean isSpatialAudioEnable(int r1);

    void leaveLivePlay(a r1);

    void loadAnchorLinkContextWidget(WidgetManager r1);

    void markAddPkBackground(a r1, boolean r2);

    void notifyAudienceSelfJoin(boolean r1);

    void notifyAudienceSelfLeave();

    void notifyCleanModeChanged(int r1);

    void notifyIsCleanModeChanged(boolean r1);

    void notifyPauseStatus(int r1);

    void notifyPkAnchorSilenceStatus(boolean r1);

    void notifyPkAudienceUnload();

    void notifyPkRenderWidth(int r1);

    void notifyRenderSizeChanged(int r1, int r2);

    void notifyRtcData(String r1);

    void notifyStartAudioDiagnosis();

    void notifyStopLive(int r1);

    void notifyUserClose();

    void onAudienceJoinGuestLink(boolean r1);

    void onAudienceJoinSelfLink(boolean r1);

    void onMultiAnchorStateChange(int r1);

    void receiveChorusMessage(f0 r1);

    void setEnterRoomTime(long r1);

    void setSkipRoomStatsSync(boolean r1);

    void updateAudienceMemberCount(long r1);

    void updateEnterParams(a r1, long r2);

    void updateEnterRoomViewMock(boolean r1);

    void updateFeedParams(a r1, int r2, int r3, int r4, long r5);

    void updateFirstFrameSei(String r1);

    void updateInteractAnchorParam(String r1);

    void updateInteractLayoutShow(boolean r1);

    void updateInteractMarginTop(a r1, int r2);

    void updateKeyboardStatus(boolean r1);

    void updateLiveMode(LiveMode r1);

    void updateLoad0Ts(long r1);

    void updateLoad1Ts(long r1);

    void updateMicRoomAnchorStatus(int r1);

    void updatePkLeftMargin(a r1, int r2);

    void updatePkMovedMarginTop(a r1, int r2);

    void updatePortrait(boolean r1);

    void updatePushStreamInfo(double r1, double r3, double r5);

    void updateStableMode(boolean r1);

    void updateVideoHeight(a r1, int r2, int r3);
}
