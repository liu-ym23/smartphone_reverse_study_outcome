package com.bytedance.android.live.liveinteract.voicechat;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerClientUIInfoChangeContent;
import com.bytedance.live.datacontext.DataContext;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 ]2\u00020\u0001:\u0001^J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H&J\b\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0014\u001a\u00020\u0013H&JR\u0010!\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00112\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u0006H&J\u0012\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H&J\b\u0010%\u001a\u00020\u0004H\u0016J \u0010*\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(H&J(\u0010*\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020\u0006H&J\u0018\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006H&J\u0012\u00100\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010.H&J\u0012\u00103\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u000101H&J\u0010\u00106\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104H&J\u0010\u00107\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\u0016H&J\u000e\u00108\u001a\b\u0012\u0004\u0012\u0002050\u0016H&J\u000e\u00109\u001a\b\u0012\u0004\u0012\u0002050\u0016H&J\b\u0010:\u001a\u00020\u0011H&J\b\u0010;\u001a\u00020\u0011H&J\b\u0010<\u001a\u00020\u0011H&J\n\u0010>\u001a\u0004\u0018\u00010=H&J\b\u0010?\u001a\u00020\u0011H&J\n\u0010A\u001a\u0004\u0018\u00010@H&J\n\u0010C\u001a\u0004\u0018\u00010BH&J\u0018\u0010F\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u0011H&J\b\u0010H\u001a\u00020GH&J\n\u0010J\u001a\u0004\u0018\u00010IH&J(\u0010O\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\u0006H&J(\u0010R\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u001b2\u0006\u0010N\u001a\u00020\u0006H&J\u001e\u0010T\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u001b2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016H&J\u0018\u0010X\u001a\u00020\u00042\u0006\u0010V\u001a\u00020U2\u0006\u0010W\u001a\u00020(H&J\b\u0010Y\u001a\u00020\u0011H&J\u0018\u0010\\\u001a\u00020\u00042\u000e\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010ZH&¨\u0006_"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/IVoiceChatAdminService;", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "", "accept", "", "id", "secUid", "Lcom/bytedance/android/live/liveinteract/videolink/a;", "params", "invite", "Luf0/c;", "inviteCallback", "setInviteCallback", "targetUser", "kickOut", "", "canSilenceSelf", "Lcom/bytedance/android/live/liveinteract/voicechat/b;", "muteManager", "isSilence", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "data", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "clientUIInfo", "", "version", "", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "linkerContentMap", "reason", "switchAudioByClient", "Luf0/d;", "callback", "setPermitCallback", "removePermitCallback", "fromGuide", "requestPage", "", "position", "showInviteAndPermitDialog", "taskName", "toUserId", "openEmojiDialog", "Lcom/bytedance/android/livesdk/link/model/bridge/z0;", MultiLinkOpenSource.MESSAGE, "onSwitchSceneMessage", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerClientUIInfoChangeContent;", "content", "onClientUIInfoChangeMessage", "Lcom/bytedance/android/live/liveinteract/plantform/base/i;", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "getLinkUserInfoCenter", "getCrossRoomFightLinkUserInfoList", "getLinkWaitingList", "getOnlineUserList", "isAnchor", "isEngineOn", "isKtvOn", "Lkk0/g;", "getLinkMicSeatCallback", "ktvWillAutoSilenceSelf", "Ljg6/a;", "getAdminStatusCenter", "Lhg6/g;", "rtcManger", "clickType", "isOpen", "logKtvCameraOperation", "Lcom/bytedance/android/live/liveinteract/voicechat/MuteStateChecker;", "muteChecker", "Ltf0/h;", "getInteractAnimationService", "roomId", "toUid", "enlarge", "enlargeTypeForLog", "setCPosition", "targetUserId", "toEnlargePosition", "updateMultiEnlargePosition", "kickOutUserIdList", "closeMultiEnlargePosition", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerChangeMediaInfoContent;", "info", "lastAudioBitRate", "onChangeMediaInfo", "isDynamicAnimating", "Lkotlin/Function0;", "listener", "setDynamicAnimatorListener", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IVoiceChatAdminService {
    public static final a Companion = null;
    public static final String TAG = "voice_chat_admin_context";

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static IVoiceChatAdminService a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(IVoiceChatAdminService.TAG);
            if ((r0 instanceof VoiceChatGlobalDataContext) == true) goto L5;
            r0 = null;
        L5:
            VoiceChatGlobalDataContext r1 = (VoiceChatGlobalDataContext) r0;
            if (r1 == null) goto L11;
            com.bytedance.live.datacontext.j<IVoiceChatAdminService> r2 = r1.getVoiceChatAdminService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (IVoiceChatAdminService) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        Companion = a.a;
    }

    void accept(IBaseUser r1);

    void accept(String r1, String r2);

    boolean canSilenceSelf();

    void closeMultiEnlargePosition(long r1, List<String> r3);

    jg6.a getAdminStatusCenter();

    List<ILinkPlayerInfoBridge> getCrossRoomFightLinkUserInfoList();

    tf0.h getInteractAnimationService();

    kk0.g getLinkMicSeatCallback();

    com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getLinkUserInfoCenter();

    List<ILinkPlayerInfoBridge> getLinkWaitingList();

    List<ILinkPlayerInfoBridge> getOnlineUserList();

    void invite(com.bytedance.android.live.liveinteract.videolink.a r1);

    boolean isAnchor();

    boolean isDynamicAnimating();

    boolean isEngineOn();

    boolean isKtvOn();

    void kickOut(IBaseUser r1);

    boolean ktvWillAutoSilenceSelf();

    void logKtvCameraOperation(String r1, boolean r2);

    MuteStateChecker muteChecker();

    b muteManager();

    void onChangeMediaInfo(ILinkerChangeMediaInfoContent r1, int r2);

    void onClientUIInfoChangeMessage(ILinkerClientUIInfoChangeContent r1);

    void onSwitchSceneMessage(z0 r1);

    void openEmojiDialog(String r1, String r2);

    void removePermitCallback();

    hg6.g rtcManger();

    void setCPosition(long r1, String r3, boolean r4, String r5);

    void setDynamicAnimatorListener(Function0<Unit> r1);

    void setInviteCallback(uf0.c r1);

    void setPermitCallback(uf0.d r1);

    void showInviteAndPermitDialog(boolean r1, String r2, int r3);

    void showInviteAndPermitDialog(boolean r1, String r2, int r3, String r4);

    void switchAudioByClient(boolean r1, List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r2, ClientUIInfo r3, long r4, Map<Long, ? extends g2> r6, String r7);

    void updateMultiEnlargePosition(long r1, String r3, long r4, String r6);
}
