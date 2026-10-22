package com.bytedance.android.live.pkaudience.api;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerBattleConnectContent;
import com.bytedance.revenue.platform.api.core.rx.h;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.x;
import hh1.v0;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bl\u0010mJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0010\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001fH\u0016J\u001a\u0010$\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010%\u001a\u00020\u000eH\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0012H\u0016J(\u0010,\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0012H\u0016J\b\u0010-\u001a\u00020\u0006H\u0016J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0016H\u0016J\b\u00100\u001a\u00020\u0006H\u0016J\"\u00103\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00162\b\u00101\u001a\u0004\u0018\u00010\u00162\u0006\u00102\u001a\u00020\u0016H\u0016J\u0010\u00104\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0016H\u0016J\b\u00105\u001a\u00020\u000eH\u0016J\n\u00107\u001a\u0004\u0018\u000106H\u0016J\n\u00109\u001a\u0004\u0018\u000108H\u0016J\u001a\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u0002062\b\u0010\u0011\u001a\u0004\u0018\u000108H\u0016J\b\u0010<\u001a\u00020\u0006H\u0016J2\u0010B\u001a\u00020\u00062\u0006\u0010>\u001a\u00020=2\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010?\u001a\u0004\u0018\u00010\u00162\u0006\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020=H\u0016J\b\u0010C\u001a\u00020\u000eH\u0016J\n\u0010D\u001a\u0004\u0018\u000108H\u0016J\u0010\u0010F\u001a\u00020\u00062\u0006\u0010#\u001a\u00020EH\u0016J\u0010\u0010G\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010I\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000eH\u0016J\b\u0010J\u001a\u00020\u0006H\u0016J\b\u0010K\u001a\u00020\u0006H\u0016J\n\u0010M\u001a\u0004\u0018\u00010LH\u0016J\b\u0010N\u001a\u00020\u000eH\u0016J\b\u0010O\u001a\u00020\u0016H\u0016J\u0016\u0010R\u001a\u00020\u00062\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00160PH\u0016J\u0016\u0010S\u001a\u00020\u00062\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00160PH\u0016J\b\u0010T\u001a\u00020\u0006H\u0016J\b\u0010U\u001a\u00020\u0016H\u0016J\b\u0010V\u001a\u00020\u0016H\u0016J<\u0010_\u001a\u00020\u00062\u0006\u0010W\u001a\u00020\u000e2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0X2\u0006\u0010[\u001a\u00020=2\u0014\u0010^\u001a\u0010\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020]\u0018\u00010\\H\u0016J\b\u0010`\u001a\u00020\u0006H\u0016J\b\u0010a\u001a\u00020\u0006H\u0016J\u0016\u0010c\u001a\b\u0012\u0004\u0012\u00020E0\u001f2\u0006\u0010b\u001a\u00020\u000eH\u0016J5\u0010k\u001a\u00060ij\u0002`j2'\u0010h\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020E0\u001f¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(g\u0012\u0004\u0012\u00020\u00060dH\u0016¨\u0006n"}, d2 = {"Lcom/bytedance/android/live/pkaudience/api/PkAudienceLinkOutServiceDummy;", "Lcom/bytedance/android/live/pkaudience/api/IPkAudienceLinkOutService;", "Lcom/bytedance/android/live/pkaudience/api/a;", "getPkLinkUserInfoCenter", "Lcom/bytedance/android/live/pkaudience/api/b;", "listener", "", "addPkGuestListener", "Lei6/a;", "getGuestRtcClient", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerBattleConnectContent;", "content", "setLinkerContentMap", "showInviteAndPermitDialog", "", "isLinkAudience", "Lhh1/v0;", "videoClientFactory", "", "containerId", "Lcom/bytedance/android/live/pkaudience/api/BasePkInteractControlWidget;", "createRevPkAudienceControlWidget", "", "interactId", "isNotSelfGuestByIId", "userId", "isNotSelfGuestByUid", "isSelfGuestByIId", "uid", "isSelfGuestByUid", "kickOutAllGuest", "", "getAllOwnGuestUidList", "isAnchor", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "isUserInInteractAudience", "handleInteractClick", "mode", "unLoadOtherWidget", "linkType", "applySource", "fromSource", "applyType", "apply", "cancelApply", "reason", "disconnect", "hideInteractDialog", "revSecUid", "reqFrom", "kickOut", "finishInteract", "isRtcEngineOn", "Lgd0/x;", "createRevRtcData", "", "getLiveVideoClientFactory", "revRtcData", "setRevGuestManagerData", "onFirstRemoteVideoSend", "", "roomId", "secUid", "layout", "msgBoardItemId", "invite", "isRealHasAudienceBeforePk", "getGuestLinkViewNew", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "permit", "isMuteRemoteAudio", "isSwitching", "markSwitchToMulti", "tryLoadPkAudienceWidget", "tryUnLoadPkAudienceWidget", "Lcom/bytedance/android/live/pkaudience/api/d;", "getPkAudienceLogData", "isInSelfAnchorLink", "getPkGuestLynxData", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "newObserver", "registerPkGuestLynxDataObserver", "unRegisterPkGuestLynxDataObserver", "resetLinkData", "getSelfAnchorLinkMicId", "getGuestAnchorLinkMicId", "isSilence", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "data", "version", "", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "linkerContentMap", "switchAudioByClient", "onPKInteractBizStart", "onPKInteractBizEnd", "isLeft", "getSelfOnlineUserList", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onlineList", "onChange", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/revenue/platform/api/core/rx/Disposable;", "registerOnlineListChange", "<init>", "()V", "livepkaudience-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkAudienceLinkOutServiceDummy implements IPkAudienceLinkOutService {
    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void addPkGuestListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void apply(int r1, int r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "fromSource");
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void cancelApply() {
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public BasePkInteractControlWidget createRevPkAudienceControlWidget(v0 r1, int r2) {
        return null;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public x createRevRtcData() {
        return null;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void disconnect(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void finishInteract(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reqFrom");
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public List<String> getAllOwnGuestUidList() {
        return null;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public String getGuestAnchorLinkMicId() {
        return "";
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public Object getGuestLinkViewNew() {
        return null;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public ei6.a getGuestRtcClient() {
        return null;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public Object getLiveVideoClientFactory() {
        return null;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public d getPkAudienceLogData() {
        return null;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public String getPkGuestLynxData() {
        return "";
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public a getPkLinkUserInfoCenter() {
        return null;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public String getSelfAnchorLinkMicId() {
        return "";
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean handleInteractClick() {
        return false;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void hideInteractDialog() {
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void invite(long r1, String r3, String r4, int r5, long r6) {
        Intrinsics.checkNotNullParameter(r3, "uid");
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isInSelfAnchorLink() {
        return false;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isLinkAudience() {
        return false;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isMuteRemoteAudio(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        return false;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isNotSelfGuestByIId(String r1) {
        return false;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isNotSelfGuestByUid(String r1) {
        return false;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isRealHasAudienceBeforePk() {
        return false;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isRtcEngineOn() {
        return false;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isSelfGuestByIId(String r1) {
        return false;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isSelfGuestByUid(String r1) {
        return false;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isUserInInteractAudience(boolean r1, IBaseUser r2) {
        return false;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void kickOut(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "uid");
        Intrinsics.checkNotNullParameter(r3, "reqFrom");
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void kickOutAllGuest() {
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void markSwitchToMulti(boolean r1) {
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void onFirstRemoteVideoSend() {
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void onPKInteractBizEnd() {
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void onPKInteractBizStart() {
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void permit(ILinkPlayerInfoBridge r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void registerPkGuestLynxDataObserver(Observer<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void resetLinkData() {
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void setLinkerContentMap(ILinkerBattleConnectContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void setRevGuestManagerData(x r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "revRtcData");
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void showInviteAndPermitDialog() {
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void switchAudioByClient(boolean r1, List<k> r2, long r3, Map<Long, ? extends g2> r5) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void tryLoadPkAudienceWidget() {
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void tryUnLoadPkAudienceWidget() {
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void unLoadOtherWidget(int r1) {
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void unRegisterPkGuestLynxDataObserver(Observer<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
    }

    public PkAudienceLinkOutServiceDummy() {
        jc1.k.l(IPkAudienceLinkOutService.class, this);
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public List<ILinkPlayerInfoBridge> getSelfOnlineUserList(boolean r1) {
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public Disposable registerOnlineListChange(Function1<? super List<? extends ILinkPlayerInfoBridge>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onChange");
        int r3 = h.a;
        return h.a(AnonymousClass1.INSTANCE);
    }
}
