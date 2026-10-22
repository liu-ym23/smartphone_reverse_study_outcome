package u01;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.layer.api.ILiveRevLinkLayerService;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.revenue.service.base.RevenueExposedWrapperBase;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.link.model.bridge.f0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.feed.IInteractFeedView;
import com.bytedance.android.livesdkapi.feed.ImCacheUnit;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.link.LiveDynamicLayoutInit;
import com.bytedance.android.livesdkapi.service.IFeedRevenueContext;
import com.bytedance.android.livesdkapi.service.RevImCacheUnit;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kc0.r;
import kc0.s;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import nc0.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class g extends RevenueExposedWrapperBase<ILinkService> implements ILinkServiceExternal {
    public g() {
        super(ILinkService.class);
        LiveDynamicLayoutInit.INSTANCE.initLiveDynamicLayout();
    }

    public Class<? extends Widget> getAnchorLinkWidget() {
        boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;
        return com.bytedance.android.live.revenue.core.util.h.d(ILiveRevLinkLayerService.class).getAnchorLinkWidget();
    }

    public lc0.a getControlService() {
        return new nc0.f(getReal().getRevLinkControlService());
    }

    public lc0.b getMultiAnchorService() {
        return new nc0.l(getReal().getMultiAnchorService());
    }

    public lc0.c getMultiDataHolder() {
        return new nc0.m(getReal().getRevenueLinkDataHolder());
    }

    public lc0.d getPkService() {
        return new p(getRealInstance().mo470getPkService());
    }

    private final kc0.j getReal() {
        return getRealInstance();
    }

    public pc0.e createRevRtcData() {
        return getReal().createRevRtcData();
    }

    public int currentRoomLayoutType() {
        return getReal().getMultiAnchorService().currentRoomLayoutType();
    }

    public String getAnchorCount() {
        return getReal().getLinkAnchorCount();
    }

    @Deprecated(message = "ticketWidgetClass")
    public Class<? extends Widget> getAnchorTicketWidgetClass() {
        return getTicketWidgetClass();
    }

    public s getAudioDetectService() {
        return getReal().getRevLinkAudioDetectExternal();
    }

    public com.bytedance.android.live.revenuelink.connect.f getConnectService() {
        return getReal().getConnectService();
    }

    @Deprecated(message = "controlService")
    public lc0.a getControlServiceExternal() {
        return getControlService();
    }

    public int getEnterRoomLinkmicScene() {
        return getReal().getEnterRoomLinkmicScene();
    }

    public List<ImCacheUnit> getInteractFeedViewImCaches() {
        List r0 = getReal().getInteractFeedViewImCaches();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        RevImCacheUnit r3 = (RevImCacheUnit) r2.next();
        Intrinsics.checkNotNull(r3);
        r1.add(new d(r3));
        goto L4
    L6:
        return r1;
    }

    @Deprecated(message = "linkAnchorCount")
    public String getLinkAnchorCount() {
        return getAnchorCount();
    }

    @Deprecated(message = "multiAnchorService")
    public lc0.b getMultiAnchorServiceExternal() {
        return getMultiAnchorService();
    }

    @Deprecated(message = "multiDataHolder")
    public lc0.c getMultiDataHolderExternal() {
        return getMultiDataHolder();
    }

    public kc0.g getPanelService() {
        return getReal().getPanelServiceExternal();
    }

    @Deprecated(message = "panelService")
    public kc0.g getPanelServiceExternal() {
        return getPanelService();
    }

    public kc0.h getPerfManager() {
        return getReal().getPerfManager();
    }

    @Deprecated(message = "perfManager")
    public kc0.h getPerfManagerExternal() {
        return getPerfManager();
    }

    @Deprecated(message = "pkService")
    public lc0.d getPkServiceExternal() {
        return getPkService();
    }

    @Deprecated(message = "profitWidgetClass")
    public Class<? extends Widget> getProfitInteractionWidgetClass() {
        return getProfitWidgetClass();
    }

    public Class<? extends Widget> getProfitWidgetClass() {
        return getReal().getProfitInteractionWidgetClass();
    }

    public kc0.i getRegionService() {
        return getReal().getLinkRegionServiceExternal();
    }

    public long getRevLinkControlLoadTs() {
        return getReal().getRevLinkControlLoadTs();
    }

    public gy.c getRtcService() {
        com.bytedance.android.live.revenuelink.rtc.f r0 = getReal().getRtcService();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new nc0.c(r0);
    }

    public Class<? extends Widget> getTicketWidgetClass() {
        return getReal().getAnchorTicketWidgetClass();
    }

    public void notifyAudienceSelfLeave() {
        getReal().notifyAudienceSelfLeave();
    }

    public void notifyPkAudienceUnload() {
        getReal().notifyPkAudienceUnload();
    }

    public void notifyStartAudioDiagnosis() {
        getReal().notifyStartAudioDiagnosis();
    }

    public void notifyUserClose() {
        getReal().notifyUserClose();
    }

    public cy0.a enterLivePlay(DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        kc0.j r0 = getReal();
        Intrinsics.checkNotNullParameter(r4, "$this$asPlatform");
        ld.f r2 = (ld.f) r4.get("data_platform_ref", null);
        if (r2 != null) goto L7;
        r2 = new ld.f(r4);
        r4.put("data_platform_ref", r2);
    L7:
        return r0.enterLivePlay(r2);
    }

    public boolean isSpatialAudioEnable(int r2) {
        return getReal().isSpatialAudioEnable(r2);
    }

    public void leaveLivePlay(cy0.a r2) {
        getReal().leaveLivePlay(r2);
    }

    public void loadAnchorLinkContextWidget(WidgetManager r2) {
        boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(ILiveRevLinkLayerService.class).loadAnchorLinkContextWidget(r2);
    }

    public void notifyAudienceSelfJoin(boolean r2) {
        getReal().notifyAudienceSelfJoin(r2);
    }

    public void notifyCleanModeChanged(int r2) {
        getReal().notifyCleanModeChanged(r2);
    }

    public void notifyIsCleanModeChanged(boolean r2) {
        getReal().notifyIsCleanModeChanged(r2);
    }

    public void notifyPauseStatus(int r2) {
        getReal().notifyPauseStatus(r2);
    }

    public void notifyPkAnchorSilenceStatus(boolean r2) {
        getReal().notifyPkAnchorSilenceStatus(r2);
    }

    public void notifyPkRenderWidth(int r2) {
        getReal().notifyPkRenderWidth(r2);
    }

    public void notifyRtcData(String r2) {
        getReal().notifyRtcData(r2);
    }

    public void notifyStopLive(int r2) {
        getReal().notifyStopLive(r2);
    }

    public void onAudienceJoinGuestLink(boolean r2) {
        getReal().onAudienceJoinGuestLink(r2);
    }

    public void onAudienceJoinSelfLink(boolean r2) {
        getReal().onAudienceJoinSelfLink(r2);
    }

    public void onMultiAnchorStateChange(int r2) {
        getReal().onMultiAnchorStateChange(r2);
    }

    public void receiveChorusMessage(f0 r2) {
        getReal().receiveChorusMessage(r2);
    }

    public void setEnterRoomTime(long r2) {
        getReal().setEnterRoomTime(r2);
    }

    public void setSkipRoomStatsSync(boolean r2) {
        getReal().setSkipRoomStatsSync(r2);
    }

    public void updateAudienceMemberCount(long r2) {
        getReal().updateAudienceMemberCount(r2);
    }

    public void updateEnterRoomViewMock(boolean r2) {
        getReal().updateEnterRoomViewMock(r2);
    }

    public void updateFirstFrameSei(String r2) {
        getReal().updateFirstFrameSei(r2);
    }

    public void updateInteractAnchorParam(String r2) {
        getReal().updateInteractAnchorParam(r2);
    }

    public void updateInteractLayoutShow(boolean r2) {
        getReal().updateInteractLayoutShow(r2);
    }

    public void updateKeyboardStatus(boolean r2) {
        getReal().updateKeyboardStatus(r2);
    }

    public void updateLiveMode(LiveMode r2) {
        Intrinsics.checkNotNullParameter(r2, "liveMode");
        getReal().updateLiveMode(r2);
    }

    public void updateLoad0Ts(long r2) {
        getReal().updateLoad0Ts(r2);
    }

    public void updateLoad1Ts(long r2) {
        getReal().updateLoad1Ts(r2);
    }

    public void updateMicRoomAnchorStatus(int r2) {
        getReal().updateMicRoomAnchorStatus(r2);
    }

    public void updatePortrait(boolean r2) {
        getReal().updatePortrait(r2);
    }

    public void updateStableMode(boolean r2) {
        getReal().updateStableMode(r2);
    }

    public void markAddPkBackground(cy0.a r2, boolean r3) {
        getReal().markAddPkBackground(r2, r3);
    }

    public void notifyRenderSizeChanged(int r2, int r3) {
        getReal().notifyRenderSizeChanged(r2, r3);
    }

    public void updateEnterParams(cy0.a r2, long r3) {
        getReal().updateEnterParams(r2, r3);
    }

    public void updateInteractMarginTop(cy0.a r2, int r3) {
        getReal().updateInteractMarginTop(r2, r3);
    }

    public void updatePkLeftMargin(cy0.a r2, int r3) {
        getReal().updatePkLeftMargin(r2, r3);
    }

    public void updatePkMovedMarginTop(cy0.a r2, int r3) {
        getReal().updatePkMovedMarginTop(r2, r3);
    }

    public void updatePushStreamInfo(double r8, double r10, double r12) {
        getReal().updatePushStreamInfo(r8, r10, r12);
    }

    public void updateVideoHeight(cy0.a r2, int r3, int r4) {
        getReal().updateVideoHeight(r2, r3, r4);
    }

    public r createRevMultiControlWidget(r.a r2, ViewGroup r3, Boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        return getReal().createRevMultiControlWidget(r2, r3, r4, r5);
    }

    public IInteractFeedView getInteractFeedView(Context r4, SeiAppData r5, int r6, IFeedRevenueContext r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "seiAppData");
        kc0.j r0 = getReal();
        m r1 = new m(r5);
        if (r7 == null) goto L5;
        b r2 = new b(r7);
    L6:
        qc0.f r8 = r0.getInteractFeedView(r4, r1, r6, r2);
        if (r8 != null) goto L9;
        return null;
    L9:
        return new c(r8);
    L5:
        r2 = null;
        goto L6
    }

    public void updateFeedParams(cy0.a r8, int r9, int r10, int r12, long r13) {
        getReal().updateFeedParams(r8, r9, r10, r12, r13);
    }
}
