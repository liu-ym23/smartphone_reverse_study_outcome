package com.bytedance.android.live.revlink.api;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.link.model.bridge.f0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.service.RevImCacheUnit;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import cy0.a;
import dy0.c;
import fr2.p;
import gt1.b;
import java.util.List;
import java.util.Map;
import kc0.d;
import kc0.g;
import kc0.h;
import kc0.j;
import kc0.k;
import kc0.m;
import kc0.o;
import kc0.q;
import kc0.r;
import kc0.s;
import kotlin.Metadata;
import ld.f;
import org.json.JSONObject;
import p11.i;
import pc0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.revlink.impl.RevLinkService")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J \u0010\u000e\u001a\u00020\u00062\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH&J \u0010\u000f\u001a\u00020\u00062\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/revlink/api/ILinkService;", "", "Lkc0/j;", "Ldy0/c;", "Lorg/json/JSONObject;", "featureObj", "", "setFeatureParams", "Lgt1/b;", "getMultiAnchorStatus", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lgt1/d;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "observer", "registerPkStateChangeObserver", "unRegisterPkStateChangeObserver", "Lfr2/p;", "getLiveCore", "liverevlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkService extends k, j, c {
    /* synthetic */ r createRevMultiControlWidget(r.a r1, ViewGroup r2, Boolean r3, boolean r4);

    /* synthetic */ e createRevRtcData();

    /* synthetic */ a enterLivePlay(f r1);

    /* synthetic */ Class<? extends Widget> getAnchorTicketWidgetClass();

    /* synthetic */ com.bytedance.android.live.revenuelink.connect.f getConnectService();

    /* synthetic */ String getConnectionType();

    /* synthetic */ int getCurrentAudienceCount();

    /* synthetic */ int getEnterRoomLinkmicScene();

    /* synthetic */ qc0.f getInteractFeedView(Context r1, pc0.a r2, int r3, d r4);

    /* synthetic */ List<RevImCacheUnit> getInteractFeedViewImCaches();

    /* synthetic */ String getInviteModeStatus();

    /* synthetic */ String getLinkAnchorCount();

    /* synthetic */ i getLinkRegionService();

    /* synthetic */ kc0.i getLinkRegionServiceExternal();

    p getLiveCore();

    /* synthetic */ m getMultiAnchorService();

    /* JADX INFO: renamed from: getMultiAnchorService, reason: collision with other method in class */
    /* synthetic */ p11.e mo468getMultiAnchorService();

    b getMultiAnchorStatus();

    /* synthetic */ g getPanelServiceExternal();

    /* synthetic */ h getPerfManager();

    /* JADX INFO: renamed from: getPerfManager, reason: collision with other method in class */
    /* synthetic */ p11.d mo469getPerfManager();

    /* synthetic */ q getPkService();

    /* JADX INFO: renamed from: getPkService, reason: collision with other method in class */
    /* synthetic */ p11.h mo470getPkService();

    /* synthetic */ Class<? extends Widget> getProfitInteractionWidgetClass();

    /* synthetic */ s getRevLinkAudioDetectExternal();

    /* synthetic */ long getRevLinkControlLoadTs();

    /* synthetic */ kc0.e getRevLinkControlService();

    /* synthetic */ o getRevenueLinkDataHolder();

    /* JADX INFO: renamed from: getRevenueLinkDataHolder, reason: collision with other method in class */
    /* synthetic */ p11.j mo471getRevenueLinkDataHolder();

    /* synthetic */ com.bytedance.android.live.revenuelink.rtc.f getRtcService();

    /* synthetic */ Map<String, String> getUidToStreamRegionKeyMap();

    /* synthetic */ boolean isSpatialAudioEnable(int r1);

    /* synthetic */ void leaveLivePlay(a r1);

    /* synthetic */ void markAddPkBackground(a r1, boolean r2);

    /* synthetic */ void notifyAudienceEngineEvent();

    /* synthetic */ void notifyAudienceSelfJoin(boolean r1);

    /* synthetic */ void notifyAudienceSelfLeave();

    /* synthetic */ void notifyCleanModeChanged(int r1);

    /* synthetic */ void notifyIsCleanModeChanged(boolean r1);

    /* synthetic */ void notifyPauseStatus(int r1);

    /* synthetic */ void notifyPkAnchorSilenceStatus(boolean r1);

    /* synthetic */ void notifyPkAudienceUnload();

    /* synthetic */ void notifyPkRenderWidth(int r1);

    /* synthetic */ void notifyRenderSizeChanged(int r1, int r2);

    /* synthetic */ void notifyRtcData(String r1);

    /* synthetic */ void notifyStartAudioDiagnosis();

    /* synthetic */ void notifyStopLive(int r1);

    /* synthetic */ void notifyUserClose();

    /* synthetic */ void onAudienceJoinGuestLink(boolean r1);

    /* synthetic */ void onAudienceJoinSelfLink(boolean r1);

    /* synthetic */ void onMultiAnchorStateChange(int r1);

    /* synthetic */ void receiveChorusMessage(f0 r1);

    void registerPkStateChangeObserver(Observer<gt1.d> r1);

    /* synthetic */ void setEnterRoomTime(long r1);

    void setFeatureParams(JSONObject r1);

    /* synthetic */ void setSkipRoomStatsSync(boolean r1);

    void unRegisterPkStateChangeObserver(Observer<gt1.d> r1);

    /* synthetic */ void updateAudienceMemberCount(long r1);

    /* synthetic */ void updateEnterParams(a r1, long r2);

    /* synthetic */ void updateEnterRoomViewMock(boolean r1);

    /* synthetic */ void updateFeedParams(a r1, int r2, int r3, int r4, long r5);

    /* synthetic */ void updateFirstFrameSei(String r1);

    /* synthetic */ void updateInteractAnchorParam(String r1);

    /* synthetic */ void updateInteractLayoutShow(boolean r1);

    /* synthetic */ void updateInteractMarginTop(a r1, int r2);

    /* synthetic */ void updateKeyboardStatus(boolean r1);

    /* synthetic */ void updateLiveMode(LiveMode r1);

    /* synthetic */ void updateLoad0Ts(long r1);

    /* synthetic */ void updateLoad1Ts(long r1);

    /* synthetic */ void updateMicRoomAnchorStatus(int r1);

    /* synthetic */ void updatePkLeftMargin(a r1, int r2);

    /* synthetic */ void updatePkMovedMarginTop(a r1, int r2);

    /* synthetic */ void updatePortrait(boolean r1);

    /* synthetic */ void updatePushStreamInfo(double r1, double r3, double r5);

    /* synthetic */ void updateStableMode(boolean r1);

    /* synthetic */ void updateVideoHeight(a r1, int r2, int r3);
}
