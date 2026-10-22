package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.e0;
import com.bytedance.android.live.liveinteract.plantform.model.j0;
import com.bytedance.android.live.liveinteract.plantform.model.q0;
import com.bytedance.android.livesdk.chatroom.model.t;
import com.bytedance.android.livesdk.chatroom.model.v;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.j1;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.link.model.c6;
import com.bytedance.android.livesdk.message.model.c8;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u0000 w2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004:\u0001xR\u001a\u0010\n\u001a\u00020\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0017\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\t\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\t\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001d\u001a\u00020\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\t\u001a\u0004\b\u001b\u0010\u0007R\"\u0010\"\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\t\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\u0004\u0018\u00010\u00058&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\t\u001a\u0004\b#\u0010\u0007R\"\u0010*\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\t\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010(R\u001a\u0010-\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b,\u0010\t\u001a\u0004\b+\u0010\rR\u001c\u00102\u001a\u0004\u0018\u00010.8&X§\u0004¢\u0006\f\u0012\u0004\b1\u0010\t\u001a\u0004\b/\u00100R\u001a\u00107\u001a\u0002038&X§\u0004¢\u0006\f\u0012\u0004\b6\u0010\t\u001a\u0004\b4\u00105R\u001a\u0010:\u001a\u00020\u00058&X§\u0004¢\u0006\f\u0012\u0004\b9\u0010\t\u001a\u0004\b8\u0010\u0007R\u001c\u0010?\u001a\u0004\u0018\u00010;8&X§\u0004¢\u0006\f\u0012\u0004\b>\u0010\t\u001a\u0004\b<\u0010=R\u001c\u0010D\u001a\u0004\u0018\u00010@8&X§\u0004¢\u0006\f\u0012\u0004\bC\u0010\t\u001a\u0004\bA\u0010BR\u001a\u0010G\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\bF\u0010\t\u001a\u0004\bE\u0010\u0015R\u001a\u0010J\u001a\u00020\u00058&X§\u0004¢\u0006\f\u0012\u0004\bI\u0010\t\u001a\u0004\bH\u0010\u0007R$\u0010O\u001a\u0004\u0018\u00010\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\bN\u0010\t\u001a\u0004\bK\u0010\u0007\"\u0004\bL\u0010MR$\u0010S\u001a\u0004\u0018\u00010\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\bR\u0010\t\u001a\u0004\bP\u0010\u0007\"\u0004\bQ\u0010MR$\u0010W\u001a\u0004\u0018\u00010\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\bV\u0010\t\u001a\u0004\bT\u0010\u0007\"\u0004\bU\u0010MR\u001c\u0010\\\u001a\u0004\u0018\u00010X8&X§\u0004¢\u0006\f\u0012\u0004\b[\u0010\t\u001a\u0004\bY\u0010ZR$\u0010`\u001a\u0004\u0018\u00010\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\b_\u0010\t\u001a\u0004\b]\u0010\u0007\"\u0004\b^\u0010MR$\u0010d\u001a\u0004\u0018\u00010\u00058&@&X§\u000e¢\u0006\u0012\u0012\u0004\bc\u0010\t\u001a\u0004\ba\u0010\u0007\"\u0004\bb\u0010MR$\u0010k\u001a\u0004\u0018\u00010e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bj\u0010\t\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR$\u0010r\u001a\u0004\u0018\u00010l8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bq\u0010\t\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010v\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bu\u0010\t\u001a\u0004\bs\u0010\r\"\u0004\bt\u0010 ¨\u0006y"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/b;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/z0;", "Lyh6/c;", "Lcom/bytedance/android/live/multilink/common/message/MultiLinkImMessage;", "", "getScoreUpdateLogId", "()Ljava/lang/String;", "getScoreUpdateLogId$annotations", "()V", "scoreUpdateLogId", "", "getUpdateMessageFrom", "()I", "getUpdateMessageFrom$annotations", "updateMessageFrom", "getSwitchPlayMode", "getSwitchPlayMode$annotations", "switchPlayMode", "", "getMatchType", "()J", "getMatchType$annotations", "matchType", "getAnchorLinkMicId", "getAnchorLinkMicId$annotations", "anchorLinkMicId", "getLiveCoreExtInfo", "getLiveCoreExtInfo$annotations", "liveCoreExtInfo", "getUiLayout", "setUiLayout", "(I)V", "getUiLayout$annotations", "uiLayout", "getReplyPrompts", "getReplyPrompts$annotations", "replyPrompts", "getScene", "setScene", "(J)V", "getScene$annotations", "scene", "getReplyType", "getReplyType$annotations", "replyType", "Lcom/bytedance/android/live/liveinteract/plantform/model/e0;", "getMcuContent", "()Lcom/bytedance/android/live/liveinteract/plantform/model/e0;", "getMcuContent$annotations", "mcuContent", "Lcom/bytedance/android/livesdk/chatroom/model/interact/z0;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/z0;", "getMultiRtcInfo$annotations", "multiRtcInfo", "getRtcExtInfo", "getRtcExtInfo$annotations", "rtcExtInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "getGuestLinkMicInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "getGuestLinkMicInfo$annotations", "guestLinkMicInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "getMultiLiveCoreInfo$annotations", "multiLiveCoreInfo", "getVersion", "getVersion$annotations", "version", "getFunctionType2", "getFunctionType2$annotations", "functionType2", "getRivalLinkmicIdStr", "setRivalLinkmicIdStr", "(Ljava/lang/String;)V", "getRivalLinkmicIdStr$annotations", "rivalLinkmicIdStr", "getLinkerSessionId", "setLinkerSessionId", "getLinkerSessionId$annotations", "linkerSessionId", "getRemoteLinkerSessionId", "setRemoteLinkerSessionId", "getRemoteLinkerSessionId$annotations", "remoteLinkerSessionId", "Lcom/bytedance/android/livesdk/link/model/c6;", "getLinkGameInfo", "()Lcom/bytedance/android/livesdk/link/model/c6;", "getLinkGameInfo$annotations", "linkGameInfo", "getInvitePrompt", "setInvitePrompt", "getInvitePrompt$annotations", "invitePrompt", "getInviteSubtitle", "setInviteSubtitle", "getInviteSubtitle$annotations", "inviteSubtitle", "Lcom/bytedance/android/live/liveinteract/plantform/model/q0;", "getJoinChannelData", "()Lcom/bytedance/android/live/liveinteract/plantform/model/q0;", "setJoinChannelData", "(Lcom/bytedance/android/live/liveinteract/plantform/model/q0;)V", "getJoinChannelData$annotations", "joinChannelData", "Lcom/bytedance/android/livesdk/chatroom/model/v;", "getChorusCDNInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/v;", "setChorusCDNInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/v;)V", "getChorusCDNInfo$annotations", "chorusCDNInfo", "getPushRtcType", "setPushRtcType", "getPushRtcType$annotations", "pushRtcType", "Companion", "a", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b extends vh7.e<z0>, z0, yh6.c {
    public static final int BattleScoreUpdateFromType_AUDIENCE_P2P = 1;
    public static final int BattleScoreUpdateFromType_DEFAULT = 0;
    public static final a Companion = null;
    public static final int TYPE_AGREE_ADMIN_FIRST_INVITE = 15;
    public static final int TYPE_ALL_LIST_CHANGED = 7;
    public static final int TYPE_ANCHOR_INTERACT_TURN_ON = 100;
    public static final int TYPE_AUDIENCE_INVITED = 12;
    public static final int TYPE_AUDIENCE_REPLY = 13;
    public static final int TYPE_AUTO_JOIN = 14;
    public static final int TYPE_BATTLE_DATA = 202;
    public static final int TYPE_CANCELED_BY_SERVER = 105;
    public static final int TYPE_FAN_TICKET_CHANGED = 8;
    public static final int TYPE_FINISH = 4;
    public static final int TYPE_JOIN_GAME_BARRAGE_RTC = 18;
    public static final int TYPE_KICKED_OUT = 3;
    public static final int TYPE_LEAVE_GAME_BARRAGE_RTC = 19;
    public static final int TYPE_LINKED_LIST_CHANGED = 6;
    public static final int TYPE_PERMIT = 2;
    public static final int TYPE_SILENCE = 10;
    public static final int TYPE_SILENCE_PASSIVE = 16;
    public static final int TYPE_SWITCH_SCENE = 17;
    public static final int TYPE_TURN_ON = 1;
    public static final int TYPE_UNSILENCE = 11;
    public static final int TYPE_WAITING_LIST_CHANGED = 5;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.multianchor.model.b$b, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C0045b {
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ String getAckMessage();

    /* synthetic */ com.bytedance.android.live.liveinteract.plantform.model.f getActionSource();

    @FieldName(name = "anchor_linkmic_id")
    long getAnchorLinkMicId();

    /* synthetic */ String getAnchorLinkMicIdStr();

    /* synthetic */ com.bytedance.android.livesdk.message.linker.b getBackupInfo();

    /* synthetic */ IBanUser getBanAnchorInfo();

    /* synthetic */ m0 getBaseMessage2();

    /* synthetic */ String getBizTag();

    /* synthetic */ long getChannelId();

    /* synthetic */ t getChorusAccompanimentInfo();

    @FieldName(name = "chorus_cdn_info")
    v getChorusCDNInfo();

    /* synthetic */ ClientUIInfo getClientUIInfo();

    /* synthetic */ m0 getCommonData();

    /* synthetic */ int getControlType();

    /* synthetic */ Object getFlexInstance();

    /* synthetic */ String getFromUserIdStr();

    @FieldName(name = "function_type")
    String getFunctionType2();

    /* synthetic */ String getGameBarrageLinkerFinishReason();

    /* synthetic */ com.bytedance.android.live.liveinteract.plantform.model.e getGameInviteInfo();

    /* synthetic */ String getGetFromUserId();

    @FieldName(name = "guest_linkmic_info")
    j1 getGuestLinkMicInfo();

    /* synthetic */ int getInitSource();

    /* synthetic */ py.k getInviteImage();

    /* synthetic */ a5 getInviteMsg();

    @FieldName(name = "invite_prompt")
    String getInvitePrompt();

    @FieldName(name = "invite_subtitle")
    String getInviteSubtitle();

    /* synthetic */ c8 getInvitorInfo();

    @FieldName(name = "join_channel_data")
    q0 getJoinChannelData();

    /* synthetic */ j0 getJoinTeamFightInfo();

    /* synthetic */ int getKickOutSource();

    /* synthetic */ int getLayout();

    /* synthetic */ long getLinkDuration();

    @FieldName(name = "link_game_info")
    c6 getLinkGameInfo();

    /* synthetic */ int getLinkType();

    /* synthetic */ List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkedListUsers();

    /* synthetic */ com.bytedance.android.live.liveinteract.plantform.model.q getLinkerBaseInfo();

    /* synthetic */ Map<Long, g2> getLinkerContentMap();

    @FieldName(name = "linker_session_id")
    String getLinkerSessionId();

    @FieldName(name = "live_core_ext_info")
    String getLiveCoreExtInfo();

    /* synthetic */ List<LinkmicPositionItem> getLockedPositions();

    @FieldName(name = "match_type")
    long getMatchType();

    @FieldName(name = "mcu_content")
    e0 getMcuContent();

    /* synthetic */ IMessageBoardInfo getMessageBoardInfo();

    /* synthetic */ long getMessageId2();

    @FieldName(name = "multi_live_core_info")
    u1 getMultiLiveCoreInfo();

    @FieldName(name = "multi_rtc_info")
    com.bytedance.android.livesdk.chatroom.model.interact.z0 getMultiRtcInfo();

    /* JADX INFO: renamed from: getMultiRtcInfo */
    /* synthetic */ v1 mo198getMultiRtcInfo();

    /* synthetic */ String getOpenSource();

    /* synthetic */ long getPaidCount();

    /* synthetic */ List<Integer> getPlayModes();

    /* synthetic */ String getPrompts();

    @FieldName(name = "push_rtc_type")
    int getPushRtcType();

    @FieldName(name = "remote_linker_session_id")
    String getRemoteLinkerSessionId();

    @FieldName(name = "reply_prompts")
    String getReplyPrompts();

    @FieldName(name = "reply_type")
    int getReplyType();

    @FieldName(name = "rival_linkmic_id_str")
    String getRivalLinkmicIdStr();

    @FieldName(name = "rtc_ext_info")
    String getRtcExtInfo();

    @FieldName(name = "scene")
    long getScene();

    /* synthetic */ String getSceneLayoutInfo();

    @FieldName(name = "score_update_log_id")
    String getScoreUpdateLogId();

    /* synthetic */ String getSecFromUserId();

    @FieldName(name = "switch_play_mode")
    int getSwitchPlayMode();

    /* synthetic */ boolean getSwitchToSilence();

    /* synthetic */ String getToUserId();

    /* synthetic */ String getTrackingData();

    /* synthetic */ long getType2();

    @FieldName(name = "ui_layout")
    int getUiLayout();

    @FieldName(name = "update_message_from")
    int getUpdateMessageFrom();

    /* synthetic */ int getValidScene();

    @FieldName(name = "version")
    long getVersion();

    /* synthetic */ String get_fromUserId();

    /* synthetic */ String get_guestId();

    /* synthetic */ boolean isFromUser(String r1);

    /* synthetic */ boolean isSupportCamera();

    /* synthetic */ boolean isToUser(String r1);

    /* synthetic */ void setChorusAccompanimentInfo(t r1);

    @FieldName(name = "chorus_cdn_info#setter")
    void setChorusCDNInfo(v r1);

    /* synthetic */ void setClientUIInfo(ClientUIInfo r1);

    /* synthetic */ void setCommonData(m0 r1);

    /* synthetic */ void setInitSource(int r1);

    @FieldName(name = "invite_prompt#setter")
    void setInvitePrompt(String r1);

    @FieldName(name = "invite_subtitle#setter")
    void setInviteSubtitle(String r1);

    @FieldName(name = "join_channel_data#setter")
    void setJoinChannelData(q0 r1);

    /* synthetic */ void setLayout(int r1);

    @FieldName(name = "linker_session_id#setter")
    void setLinkerSessionId(String r1);

    @FieldName(name = "push_rtc_type#setter")
    void setPushRtcType(int r1);

    @FieldName(name = "remote_linker_session_id#setter")
    void setRemoteLinkerSessionId(String r1);

    @FieldName(name = "rival_linkmic_id_str#setter")
    void setRivalLinkmicIdStr(String r1);

    @FieldName(name = "scene#setter")
    void setScene(long r1);

    /* synthetic */ void setSupportCamera(boolean r1);

    /* synthetic */ void setTrackingData(String r1);

    @FieldName(name = "ui_layout#setter")
    void setUiLayout(int r1);
}
