package kc0;

import com.bytedance.android.livesdk.link.model.bridge.f0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.service.RevImCacheUnit;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface k {
    pc0.e createRevRtcData();

    cy0.a enterLivePlay(ld.f r1);

    com.bytedance.android.live.revenuelink.connect.f getConnectService();

    int getEnterRoomLinkmicScene();

    List<RevImCacheUnit> getInteractFeedViewImCaches();

    String getLinkAnchorCount();

    i getLinkRegionServiceExternal();

    m getMultiAnchorService();

    g getPanelServiceExternal();

    h getPerfManager();

    q getPkService();

    s getRevLinkAudioDetectExternal();

    long getRevLinkControlLoadTs();

    e getRevLinkControlService();

    o getRevenueLinkDataHolder();

    com.bytedance.android.live.revenuelink.rtc.f getRtcService();

    boolean isSpatialAudioEnable(int r1);

    void leaveLivePlay(cy0.a r1);

    void markAddPkBackground(cy0.a r1, boolean r2);

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

    void updateEnterParams(cy0.a r1, long r2);

    void updateEnterRoomViewMock(boolean r1);

    void updateFeedParams(cy0.a r1, int r2, int r3, int r4, long r5);

    void updateFirstFrameSei(String r1);

    void updateInteractAnchorParam(String r1);

    void updateInteractLayoutShow(boolean r1);

    void updateInteractMarginTop(cy0.a r1, int r2);

    void updateKeyboardStatus(boolean r1);

    void updateLiveMode(LiveMode r1);

    void updateLoad0Ts(long r1);

    void updateLoad1Ts(long r1);

    void updateMicRoomAnchorStatus(int r1);

    void updatePkLeftMargin(cy0.a r1, int r2);

    void updatePkMovedMarginTop(cy0.a r1, int r2);

    void updatePortrait(boolean r1);

    void updatePushStreamInfo(double r1, double r3, double r5);

    void updateStableMode(boolean r1);

    void updateVideoHeight(cy0.a r1, int r2, int r3);
}
