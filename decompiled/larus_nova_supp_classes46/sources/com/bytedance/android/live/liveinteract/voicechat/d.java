package com.bytedance.android.live.liveinteract.voicechat;

import android.content.Context;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.model.interact.v1;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface d extends IVoiceChatAdminService {
    public static final a s0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static d a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("audio_talk_context");
            if ((r0 instanceof VoiceChatAnchorDataContext) == true) goto L5;
            r0 = null;
        L5:
            VoiceChatAnchorDataContext r1 = (VoiceChatAnchorDataContext) r0;
            if (r1 == null) goto L11;
            com.bytedance.live.datacontext.j<d> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (d) r2.getValue();
        L11:
            return null;
        }
    }

    public static final class b {
        public static /* synthetic */ void a(d r1) {
            r1.finishAudioTalk("link_icon");
        }
    }

    static {
        s0 = a.a;
    }

    void Gn();

    void Mi(int r1);

    com.bytedance.android.live.pushstream.d Ri();

    void Yi(v1 r1, String r2, String r3);

    tf0.o commonWindowManager();

    void continueAnchorLinkMic(int r1, com.bytedance.android.livesdk.message.linker.h r2);

    String currentCPositionChangeTrackData();

    int currentCPositionOpenSource();

    ILinkPlayerInfoBridge currentCPositionUser();

    String currentCPositionUserType();

    void finishAudioTalk(String r1);

    int getAnchorManualUiLayout();

    int getCurrentScene();

    JsonObject getLinkmicAreaFrameInfo();

    JsonObject getLinkmicSeatListInfo();

    com.bytedance.android.live.liveinteract.voicechat.util.k getLogger();

    MixStreamType getMixStreamType();

    qj0.a getMultiLinkAudioLayoutService();

    int getSelfSilenceType();

    tf0.m getSwitchLayoutStatisticsUtils();

    JsonObject getTopLeftSeatFrameInfo();

    boolean isNewWidget();

    void onVoiceAnchorAvatarClicked();

    void replyCPosition(long r1, String r3, boolean r4);

    void switchVoiceSceneWithCheck(Context r1, String r2);

    void updateFullScreenDialogShowStatus(boolean r1);

    void updateSelfMuteStatus(boolean r1, boolean r2, MediaOperation.a r3);

    boolean userIsCPosition(String r1);

    rj0.h videoStylePaidLinkManager();
}
