package com.bytedance.android.live.pkaudience.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerBattleConnectContent;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.x;
import hh1.v0;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ServiceLookup("com.bytedance.android.live.livepkaudience.PkAudienceLinkServiceImp")
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\u0006H&J\b\u0010\u000f\u001a\u00020\u000eH&J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0001\u0010\u0013\u001a\u00020\u0012H&J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\u0012\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016H&J\u0012\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016H&J\u0012\u0010\u001d\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\b\u0010\u001e\u001a\u00020\u0006H&J\u0010\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001fH&J\u001a\u0010$\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\"H&J\b\u0010%\u001a\u00020\u000eH&J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0012H&J*\u0010,\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00162\b\b\u0002\u0010+\u001a\u00020\u0012H&J\b\u0010-\u001a\u00020\u0006H&J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0016H&J\b\u00100\u001a\u00020\u0006H&J\"\u00103\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00162\b\u00101\u001a\u0004\u0018\u00010\u00162\u0006\u00102\u001a\u00020\u0016H&J\u0010\u00104\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0016H&J\b\u00105\u001a\u00020\u000eH&J\n\u00107\u001a\u0004\u0018\u000106H&J\n\u00109\u001a\u0004\u0018\u000108H&J\u001a\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u0002062\b\u0010\u0011\u001a\u0004\u0018\u000108H&J\b\u0010<\u001a\u00020\u0006H&J2\u0010B\u001a\u00020\u00062\u0006\u0010>\u001a\u00020=2\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010?\u001a\u0004\u0018\u00010\u00162\u0006\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020=H&J\b\u0010C\u001a\u00020\u000eH&J\n\u0010D\u001a\u0004\u0018\u000108H&J\u0010\u0010F\u001a\u00020\u00062\u0006\u0010#\u001a\u00020EH&J\u0010\u0010G\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H&J\u0010\u0010I\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000eH&J\b\u0010J\u001a\u00020\u0006H&J\b\u0010K\u001a\u00020\u0006H&J\n\u0010M\u001a\u0004\u0018\u00010LH&J\b\u0010N\u001a\u00020\u000eH&J\b\u0010O\u001a\u00020\u0016H&J\u0016\u0010R\u001a\u00020\u00062\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00160PH&J\u0016\u0010S\u001a\u00020\u00062\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00160PH&J\b\u0010T\u001a\u00020\u0006H&J\b\u0010U\u001a\u00020\u0016H&J\b\u0010V\u001a\u00020\u0016H&J<\u0010_\u001a\u00020\u00062\u0006\u0010W\u001a\u00020\u000e2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0X2\u0006\u0010[\u001a\u00020=2\u0014\u0010^\u001a\u0010\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020]\u0018\u00010\\H&J\u0016\u0010a\u001a\b\u0012\u0004\u0012\u00020E0\u001f2\u0006\u0010`\u001a\u00020\u000eH&J5\u0010i\u001a\u00060gj\u0002`h2'\u0010f\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020E0\u001f¢\u0006\f\bc\u0012\b\bd\u0012\u0004\b\b(e\u0012\u0004\u0012\u00020\u00060bH&J\b\u0010j\u001a\u00020\u0006H&J\b\u0010k\u001a\u00020\u0006H&¨\u0006l"}, d2 = {"Lcom/bytedance/android/live/pkaudience/api/IPkAudienceLinkOutService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/live/pkaudience/api/a;", "getPkLinkUserInfoCenter", "Lcom/bytedance/android/live/pkaudience/api/b;", "listener", "", "addPkGuestListener", "Lei6/a;", "getGuestRtcClient", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerBattleConnectContent;", "content", "setLinkerContentMap", "showInviteAndPermitDialog", "", "isLinkAudience", "Lhh1/v0;", "videoClientFactory", "", "containerId", "Lcom/bytedance/android/live/pkaudience/api/BasePkInteractControlWidget;", "createRevPkAudienceControlWidget", "", "interactId", "isSelfGuestByIId", "uid", "isSelfGuestByUid", "userId", "isNotSelfGuestByUid", "isNotSelfGuestByIId", "kickOutAllGuest", "", "getAllOwnGuestUidList", "isAnchor", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "isUserInInteractAudience", "handleInteractClick", "mode", "unLoadOtherWidget", "linkType", "applySource", "fromSource", "applyType", "apply", "cancelApply", "reason", "disconnect", "hideInteractDialog", "revSecUid", "reqFrom", "kickOut", "finishInteract", "isRtcEngineOn", "Lgd0/x;", "createRevRtcData", "", "getLiveVideoClientFactory", "revRtcData", "setRevGuestManagerData", "onFirstRemoteVideoSend", "", "roomId", "secUid", "layout", "msgBoardItemId", "invite", "isRealHasAudienceBeforePk", "getGuestLinkViewNew", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "permit", "isMuteRemoteAudio", "isSwitching", "markSwitchToMulti", "tryLoadPkAudienceWidget", "tryUnLoadPkAudienceWidget", "Lcom/bytedance/android/live/pkaudience/api/d;", "getPkAudienceLogData", "isInSelfAnchorLink", "getPkGuestLynxData", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "newObserver", "registerPkGuestLynxDataObserver", "unRegisterPkGuestLynxDataObserver", "resetLinkData", "getSelfAnchorLinkMicId", "getGuestAnchorLinkMicId", "isSilence", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "data", "version", "", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "linkerContentMap", "switchAudioByClient", "isLeft", "getSelfOnlineUserList", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onlineList", "onChange", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/revenue/platform/api/core/rx/Disposable;", "registerOnlineListChange", "onPKInteractBizStart", "onPKInteractBizEnd", "livepkaudience-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@ServiceDummyLookup("com.bytedance.android.live.pkaudience.api.PkAudienceLinkOutServiceDummy")
public interface IPkAudienceLinkOutService extends IService {
    void addPkGuestListener(b r1);

    void apply(int r1, int r2, String r3, int r4);

    void cancelApply();

    BasePkInteractControlWidget createRevPkAudienceControlWidget(v0 r1, int r2);

    x createRevRtcData();

    void disconnect(String r1);

    void finishInteract(String r1);

    List<String> getAllOwnGuestUidList();

    String getGuestAnchorLinkMicId();

    Object getGuestLinkViewNew();

    ei6.a getGuestRtcClient();

    Object getLiveVideoClientFactory();

    d getPkAudienceLogData();

    String getPkGuestLynxData();

    a getPkLinkUserInfoCenter();

    String getSelfAnchorLinkMicId();

    List<ILinkPlayerInfoBridge> getSelfOnlineUserList(boolean r1);

    boolean handleInteractClick();

    void hideInteractDialog();

    void invite(long r1, String r3, String r4, int r5, long r6);

    boolean isInSelfAnchorLink();

    boolean isLinkAudience();

    boolean isMuteRemoteAudio(String r1);

    boolean isNotSelfGuestByIId(String r1);

    boolean isNotSelfGuestByUid(String r1);

    boolean isRealHasAudienceBeforePk();

    boolean isRtcEngineOn();

    boolean isSelfGuestByIId(String r1);

    boolean isSelfGuestByUid(String r1);

    boolean isUserInInteractAudience(boolean r1, IBaseUser r2);

    void kickOut(String r1, String r2, String r3);

    void kickOutAllGuest();

    void markSwitchToMulti(boolean r1);

    void onFirstRemoteVideoSend();

    void onPKInteractBizEnd();

    void onPKInteractBizStart();

    void permit(ILinkPlayerInfoBridge r1);

    Disposable registerOnlineListChange(Function1<? super List<? extends ILinkPlayerInfoBridge>, Unit> r1);

    void registerPkGuestLynxDataObserver(Observer<String> r1);

    void resetLinkData();

    void setLinkerContentMap(ILinkerBattleConnectContent r1);

    void setRevGuestManagerData(x r1, Object r2);

    void showInviteAndPermitDialog();

    void switchAudioByClient(boolean r1, List<k> r2, long r3, Map<Long, ? extends g2> r5);

    void tryLoadPkAudienceWidget();

    void tryUnLoadPkAudienceWidget();

    void unLoadOtherWidget(int r1);

    void unRegisterPkGuestLynxDataObserver(Observer<String> r1);
}
