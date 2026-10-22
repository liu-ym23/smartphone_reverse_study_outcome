package com.bytedance.android.live.pk.audience;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerBattleConnectContent;
import gd0.x;
import kotlin.Metadata;
import yr0.b;
import yr0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H&J\b\u0010\r\u001a\u00020\fH&J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\fH&J\b\u0010\u0011\u001a\u00020\nH&J\"\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0004H&J\b\u0010\u0015\u001a\u00020\fH&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH&J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH&J\u001a\u0010\"\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\u0018H&J\u0010\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020#H&J\b\u0010&\u001a\u00020\nH&J\n\u0010'\u001a\u0004\u0018\u00010\u0018H&J\n\u0010)\u001a\u0004\u0018\u00010(H&¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/pk/audience/IMultiPkAudienceLinkOutService;", "Lcom/bytedance/android/live/base/IService;", "", "roomId", "", "uid", "secUid", "", "layout", "msgBoardItemId", "", "invite", "", "handleInteractClick", "mode", "unLoadOtherWidget", "isRealHasAudienceBeforePk", "showInviteAndPermitDialog", "revSecUid", "reqFrom", "kickOut", "isRtcEngineOn", "Lgd0/x;", "createRtcData", "", "getLiveVideoClientFactory", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "user", "permit", "Lyr0/e;", "listener", "addPkGuestListener", "revRtcData", "videoClientFactory", "setRevGuestManagerData", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerBattleConnectContent;", "content", "setLinkerContentMap", "onFirstRemoteVideoSend", "getGuestLinkViewNew", "Lyr0/b;", "getPkLinkUserInfoCenter", "multilink-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IMultiPkAudienceLinkOutService extends IService {
    void addPkGuestListener(e r1);

    x createRtcData();

    Object getGuestLinkViewNew();

    Object getLiveVideoClientFactory();

    b getPkLinkUserInfoCenter();

    boolean handleInteractClick();

    void invite(long r1, String r3, String r4, int r5, long r6);

    boolean isRealHasAudienceBeforePk();

    boolean isRtcEngineOn();

    void kickOut(String r1, String r2, String r3);

    void onFirstRemoteVideoSend();

    void permit(ILinkPlayerInfoBridge r1);

    void setLinkerContentMap(ILinkerBattleConnectContent r1);

    void setRevGuestManagerData(x r1, Object r2);

    void showInviteAndPermitDialog();

    void unLoadOtherWidget(int r1);
}
