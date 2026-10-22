package com.bytedance.android.live.liveinteract.voicechat;

import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.live.datacontext.DataContext;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import w20.xc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u0081\u00012\u00020\u0001:\u0002\u0082\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H&J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H&JP\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H&J8\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H&J2\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&J\u001c\u0010 \u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u001cH&J0\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H&J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00112\u0006\u0010%\u001a\u00020$H&J\b\u0010'\u001a\u00020\u0004H&J0\u0010+\u001a\u00020\u00042\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010(2\b\b\u0002\u0010*\u001a\u00020\u00112\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006H&J8\u00101\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00112\b\b\u0002\u0010.\u001a\u00020\u00112\b\b\u0002\u0010/\u001a\u00020\u00112\n\b\u0002\u0010%\u001a\u0004\u0018\u000100H&J(\u00107\u001a\u00020\u00042\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\bH&J\n\u00109\u001a\u0004\u0018\u000108H&J\b\u0010:\u001a\u00020\u0011H&J\b\u0010;\u001a\u00020\bH&J\b\u0010<\u001a\u00020\bH&J\b\u0010=\u001a\u00020\bH&J\b\u0010?\u001a\u00020>H&J\n\u0010A\u001a\u0004\u0018\u00010@H&J\u0012\u0010C\u001a\u00020\u00042\b\u0010B\u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010E\u001a\u00020\u00042\b\u0010B\u001a\u0004\u0018\u00010\u00062\u0006\u0010D\u001a\u00020\u0011H&J\u0010\u0010G\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\bH&J \u0010I\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH&J(\u0010I\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H&J\u0010\u0010J\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bH&J&\u0010O\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u00112\b\b\u0002\u0010L\u001a\u00020\u00112\n\b\u0002\u0010N\u001a\u0004\u0018\u00010MH&J\u0012\u0010P\u001a\u00020\u00042\b\u0010B\u001a\u0004\u0018\u00010\u0006H&J\b\u0010Q\u001a\u00020\u0004H&J\b\u0010R\u001a\u00020\u0004H&J\n\u0010T\u001a\u0004\u0018\u00010SH&J\n\u0010V\u001a\u0004\u0018\u00010UH&J\b\u0010W\u001a\u00020\u0011H&J \u0010Y\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010X\u001a\u00020\u0006H&J \u0010\\\u001a\u00020\u00042\u0006\u00103\u001a\u0002022\u0006\u0010Z\u001a\u00020\u00062\u0006\u0010[\u001a\u00020\u0011H&J\u0010\u0010^\u001a\u00020\u00112\u0006\u0010]\u001a\u00020\u0006H&J\n\u0010`\u001a\u0004\u0018\u00010_H&J\b\u0010a\u001a\u00020\u0006H&J\b\u0010b\u001a\u00020\bH&J\b\u0010c\u001a\u00020\u0006H&J\b\u0010e\u001a\u00020dH&J\u0010\u0010g\u001a\u00020\u00042\u0006\u0010f\u001a\u00020dH&J\n\u0010i\u001a\u0004\u0018\u00010hH&J\n\u0010j\u001a\u0004\u0018\u00010hH&J\n\u0010k\u001a\u0004\u0018\u00010hH&J\u0010\u0010m\u001a\u00020\u00042\u0006\u0010l\u001a\u00020\bH&J\u0018\u0010q\u001a\u00020\u00042\u0006\u0010n\u001a\u00020\u00062\u0006\u0010p\u001a\u00020oH&J\u0018\u0010u\u001a\u00020\u00112\u0006\u0010s\u001a\u00020r2\u0006\u0010t\u001a\u00020\u0011H&J\b\u0010v\u001a\u00020\u0011H&J\n\u0010x\u001a\u0004\u0018\u00010wH&J\b\u0010z\u001a\u00020yH&J\b\u0010{\u001a\u00020\u0004H&J\b\u0010|\u001a\u00020\u0004H&J\u0010\u0010~\u001a\u00020\u00042\u0006\u0010}\u001a\u00020\u0011H&J\u000b\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007fH&¨\u0006\u0083\u0001"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/IVoiceChatGuestService;", "Lcom/bytedance/android/live/liveinteract/voicechat/IVoiceChatAdminService;", "Lsf0/a;", "applyParams", "", "apply", "", "applySource", "", "applyType", "taskName", "fromSource", "checkAndApplyFromH5", "position", "checkAndApply", "count", "limitTime", "", "isAnonymous", "useMemberBenefits", "memberDiscountAmount", "Lw20/xc$a;", "linkmicDiscountInfo", "Lcom/bytedance/android/live/liveinteract/api/chatroom/model/LinkMatchType;", "matchType", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "music", "requestType", "Lcom/bytedance/android/live/liveinteract/api/chatroom/model/LinkApplyType;", "Ltf0/b;", "applyCallback", "ktvApply", "applyVoiceTalk", "teamId", "teamFightApply", "isAddSong", "Ltf0/q;", "callback", "showFollowGuideDialog", "showCancelApplyDialog", "Lh80/a;", "consumer", "needShowSuccessToast", "cancelApply", "disconnectSource", "needSureAgain", "needToastWhenSuccess", "needShowLinkResult", "Lrj0/c;", "disconnect", "", "roomId", "secToUserId", "toUserIdString", "replyType", "checkAndReply", "Lcom/bytedance/android/live/pushstream/d;", "guestLiveStream", "isInvited", "getSelfSilenceType", "getCurrentScene", "getAnchorManualUiLayout", "Lcom/bytedance/android/live/liveinteract/voicechat/util/k;", "getLogger", "Lm00/h;", "getLinkVideoClient", "requestPage", "tryFastMatch", "fromChangeRoomWithSong", "logChatMatchShow", "scene", "logChatMatchClick", "fromGuide", "showInviteDialog", "updatePosition", "mute", "force", "Lcom/bytedance/android/live/liveinteract/linkbase/api/MediaOperation$a;", "callBack", "updateSelfMuteStatus", "showFastMatchDialog", "hideFastMatchDialog", "tryAutoFastMatch", "Lcj0/l;", "paidLinkManager", "Lrj0/h;", "videoStylePaidLinkManager", "isCurrentLinkPaid", "from", "onProfileCardClick", "toUid", "accept", "replyCPosition", "uid", "userIsCPosition", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "currentCPositionUser", "currentCPositionUserType", "currentCPositionOpenSource", "currentCPositionChangeTrackData", "Lwe0/b;", "getLinkmicReturnRoomParams", "params", "resetLinkmicReturnRoomParams", "Lcom/google/gson/JsonObject;", "getLinkmicAreaFrameInfo", "getTopLeftSeatFrameInfo", "getLinkmicSeatListInfo", "status", "onClickToolbar", "sei", "Lye1/a;", "info", "onSei", "Ljava/lang/Runnable;", "runnable", "skippingToOtherRoom", "interceptCloseRoomV2", "isNewWidget", "Ltf0/o;", "commonWindowManager", "Ltf0/m;", "getSwitchLayoutStatisticsUtils", "exitRoom", "onVoiceAnchorAvatarClicked", "isShow", "updateFullScreenDialogShowStatus", "Lqj0/a;", "getMultiLinkAudioLayoutService", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IVoiceChatGuestService extends IVoiceChatAdminService {
    public static final a Companion = null;
    public static final String TAG = "voice_chat_guest_context";

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static IVoiceChatGuestService a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(IVoiceChatGuestService.TAG);
            if ((r0 instanceof VoiceChatGuestDataContext) == true) goto L5;
            r0 = null;
        L5:
            VoiceChatGuestDataContext r1 = (VoiceChatGuestDataContext) r0;
            if (r1 == null) goto L11;
            com.bytedance.live.datacontext.j<IVoiceChatGuestService> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (IVoiceChatGuestService) r2.getValue();
        L11:
            return null;
        }
    }

    public static final class b {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(IVoiceChatGuestService r2, h80.a r3, int r4) {
            if ((r4 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            boolean r5 = true;
        L9:
            r2.cancelApply(r3, r5, null);
            return;
        L8:
            r5 = false;
            goto L9
        }

        public static /* synthetic */ void b(IVoiceChatGuestService r6, int r7, boolean r8, boolean r9, boolean r10, int r11) {
            if ((r11 & 4) == 0) goto L5;
            boolean r3 = false;
        L7:
            if ((r11 & 8) == 0) goto L9;
            boolean r4 = true;
        L10:
            r6.disconnect(r7, r8, r3, r4, null);
            return;
        L9:
            r4 = r10;
            goto L10
        L5:
            r3 = r9;
            goto L7
        }
    }

    static {
        Companion = a.a;
    }

    void apply(sf0.a r1);

    void applyVoiceTalk(String r1, LinkApplyType r2);

    void cancelApply(h80.a<Boolean> r1, boolean r2, String r3);

    void checkAndApply(int r1, int r2, String r3, int r4, int r5, boolean r6, boolean r7, int r8, xc.a r9);

    void checkAndApply(int r1, String r2, int r3, LinkMatchType r4, String r5, String r6);

    void checkAndApply(int r1, String r2, int r3, String r4);

    void checkAndApplyFromH5(String r1, int r2, String r3, String r4);

    void checkAndReply(long r1, String r3, String r4, int r5);

    tf0.o commonWindowManager();

    String currentCPositionChangeTrackData();

    int currentCPositionOpenSource();

    ILinkPlayerInfoBridge currentCPositionUser();

    String currentCPositionUserType();

    void disconnect(int r1, boolean r2, boolean r3, boolean r4, rj0.c r5);

    void exitRoom();

    int getAnchorManualUiLayout();

    int getCurrentScene();

    m00.h getLinkVideoClient();

    JsonObject getLinkmicAreaFrameInfo();

    we0.b getLinkmicReturnRoomParams();

    JsonObject getLinkmicSeatListInfo();

    com.bytedance.android.live.liveinteract.voicechat.util.k getLogger();

    qj0.a getMultiLinkAudioLayoutService();

    int getSelfSilenceType();

    tf0.m getSwitchLayoutStatisticsUtils();

    JsonObject getTopLeftSeatFrameInfo();

    com.bytedance.android.live.pushstream.d guestLiveStream();

    void hideFastMatchDialog();

    boolean interceptCloseRoomV2(Runnable r1, boolean r2);

    boolean isCurrentLinkPaid();

    boolean isInvited();

    boolean isNewWidget();

    void ktvApply(KtvMusic r1, String r2, LinkApplyType r3, int r4, tf0.b r5);

    void logChatMatchClick(int r1);

    void logChatMatchShow(String r1, boolean r2);

    void onClickToolbar(int r1);

    void onProfileCardClick(String r1, int r2, String r3);

    void onSei(String r1, ye1.a r2);

    void onVoiceAnchorAvatarClicked();

    cj0.l paidLinkManager();

    void replyCPosition(long r1, String r3, boolean r4);

    void resetLinkmicReturnRoomParams(we0.b r1);

    void showCancelApplyDialog();

    void showFastMatchDialog(String r1);

    void showFollowGuideDialog(boolean r1, tf0.q r2);

    void showInviteDialog(boolean r1, String r2, int r3);

    void showInviteDialog(boolean r1, String r2, int r3, String r4);

    void teamFightApply(int r1, int r2, String r3, int r4, String r5);

    void tryAutoFastMatch();

    void tryFastMatch(String r1);

    void updateFullScreenDialogShowStatus(boolean r1);

    void updatePosition(int r1);

    void updateSelfMuteStatus(boolean r1, boolean r2, MediaOperation.a r3);

    boolean userIsCPosition(String r1);

    rj0.h videoStylePaidLinkManager();
}
