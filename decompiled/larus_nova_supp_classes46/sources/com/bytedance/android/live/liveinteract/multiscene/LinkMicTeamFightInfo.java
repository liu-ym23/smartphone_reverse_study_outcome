package com.bytedance.android.live.liveinteract.multiscene;

import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.LinkmicTeamfightInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u009f\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002 \u0001B\t¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003J\u0006\u0010\u0006\u001a\u00020\u0003J\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\t\u001a\u00020\bJ\b\u0010\n\u001a\u00020\bH\u0016R*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\"\u0010&\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R$\u0010)\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001e\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00103\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010.\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\"\u00106\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0015\u001a\u0004\b7\u0010\u0017\"\u0004\b8\u0010\u0019R\"\u00109\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0015\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019R\"\u0010<\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0015\u001a\u0004\b=\u0010\u0017\"\u0004\b>\u0010\u0019R\"\u0010?\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0015\u001a\u0004\b@\u0010\u0017\"\u0004\bA\u0010\u0019R,\u0010C\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010B\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010\u000e\u001a\u0004\bD\u0010\u0010\"\u0004\bE\u0010\u0012R\u0018\u0010F\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bF\u0010GR$\u0010H\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010\u001e\u001a\u0004\bI\u0010 \"\u0004\bJ\u0010\"R\"\u0010K\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010\u0015\u001a\u0004\bL\u0010\u0017\"\u0004\bM\u0010\u0019R\"\u0010N\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010.\u001a\u0004\bO\u00100\"\u0004\bP\u00102R\"\u0010Q\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u0015\u001a\u0004\bR\u0010\u0017\"\u0004\bS\u0010\u0019R\"\u0010T\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010.\u001a\u0004\bU\u00100\"\u0004\bV\u00102R\"\u0010W\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010\u0015\u001a\u0004\bX\u0010\u0017\"\u0004\bY\u0010\u0019R$\u0010Z\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010\u001e\u001a\u0004\b[\u0010 \"\u0004\b\\\u0010\"R\"\u0010]\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010.\u001a\u0004\b^\u00100\"\u0004\b_\u00102R$\u0010a\u001a\u0004\u0018\u00010`8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010g\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010.\u001a\u0004\bh\u00100\"\u0004\bi\u00102R\u0014\u0010k\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bj\u0010 R\u0014\u0010m\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u0010 R\u0014\u0010o\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bn\u0010\u0017R\u0016\u0010q\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bp\u0010 R\u0014\u0010s\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\br\u00100R\u0014\u0010u\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bt\u00100R\u0014\u0010w\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bv\u0010\u0017R\u0014\u0010y\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bx\u0010\u0017R\u0014\u0010{\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bz\u0010\u0017R\u0014\u0010}\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b|\u0010\u0017R:\u0010\u0081\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010B\u0018\u00010\u000b2\u0010\u0010~\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010B\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\r\u001a\u0004\b\u007f\u0010\u0010\"\u0005\b\u0080\u0001\u0010\u0012R\u0019\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0086\u0001\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010 R\u0016\u0010\u0088\u0001\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010\u0017R\u0016\u0010\u008a\u0001\u001a\u00020,8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0089\u0001\u00100R\u0016\u0010\u008c\u0001\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008b\u0001\u0010\u0017R\u0016\u0010\u008e\u0001\u001a\u00020,8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008d\u0001\u00100R\u0016\u0010\u0090\u0001\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008f\u0001\u0010\u0017R\u0018\u0010\u0092\u0001\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0091\u0001\u0010 R'\u0010\u0095\u0001\u001a\u00020,2\u0006\u0010~\u001a\u00020,8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0093\u0001\u00100\"\u0005\b\u0094\u0001\u00102R\u001a\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0096\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R'\u0010\u009c\u0001\u001a\u00020,2\u0006\u0010~\u001a\u00020,8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u009a\u0001\u00100\"\u0005\b\u009b\u0001\u00102¨\u0006¡\u0001"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multiscene/LinkMicTeamFightInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/multiscene/a;", "", "useRelativePkBar", "canStartFight", "isTeamFightInfo", "isLinkRoomFightInfo", "", "toSimpleString", "toString", "", "Lcom/bytedance/android/live/liveinteract/multiscene/TeamFightPlayer;", "teamFightPlayers", "Ljava/util/List;", "getTeamFightPlayers", "()Ljava/util/List;", "setTeamFightPlayers", "(Ljava/util/List;)V", "", "_initiatorUserId", "J", "get_initiatorUserId", "()J", "set_initiatorUserId", "(J)V", "_initiatorAnchorId", "get_initiatorAnchorId", "set_initiatorAnchorId", "initiatorUserOpenId", "Ljava/lang/String;", "getInitiatorUserOpenId", "()Ljava/lang/String;", "setInitiatorUserOpenId", "(Ljava/lang/String;)V", "initiatorAnchorOpenId", "getInitiatorAnchorOpenId", "setInitiatorAnchorOpenId", "_teamFightId", "get_teamFightId", "set_teamFightId", "_teamFightIdStr", "get_teamFightIdStr", "set_teamFightIdStr", "", "_fightType", "I", "get_fightType", "()I", "set_fightType", "(I)V", "_fightStatus", "get_fightStatus", "set_fightStatus", "_startTime", "get_startTime", "set_startTime", "_duration", "get_duration", "set_duration", "_punishStartTime", "get_punishStartTime", "set_punishStartTime", "_punishDuration", "get_punishDuration", "set_punishDuration", "Lcom/bytedance/android/live/liveinteract/multiscene/j;", "_teamInfos", "get_teamInfos", "set_teamInfos", "_winTeamId", "Ljava/lang/Long;", "_winTeamIdStr", "get_winTeamIdStr", "set_winTeamIdStr", "_currentTime", "get_currentTime", "set_currentTime", "_pkBarStyle", "get_pkBarStyle", "set_pkBarStyle", "_showStartTime", "get_showStartTime", "set_showStartTime", "_scoreType", "get_scoreType", "set_scoreType", "_showDuration", "get_showDuration", "set_showDuration", "_dressId", "get_dressId", "set_dressId", "_teamBattleType", "get_teamBattleType", "set_teamBattleType", "Lcom/bytedance/android/live/liveinteract/multiscene/TeamfightRoomBattleContent;", "_roomBattleContent", "Lcom/bytedance/android/live/liveinteract/multiscene/TeamfightRoomBattleContent;", "get_roomBattleContent", "()Lcom/bytedance/android/live/liveinteract/multiscene/TeamfightRoomBattleContent;", "set_roomBattleContent", "(Lcom/bytedance/android/live/liveinteract/multiscene/TeamfightRoomBattleContent;)V", "_finishReason", "get_finishReason", "set_finishReason", "getInitiatorUserId", "initiatorUserId", "getInitiatorAnchorId", "initiatorAnchorId", "getTeamFightId", "teamFightId", "getTeamFightIdStr", "teamFightIdStr", "getFightType", "fightType", "getFightStatus", "fightStatus", "getStartTime", "startTime", "getDuration", "duration", "getPunishStartTime", "punishStartTime", "getPunishDuration", "punishDuration", "value", "getTeamInfos", "setTeamInfos", "teamInfos", "getWinTeamId", "()Ljava/lang/Long;", "winTeamId", "getWinTeamIdStr", "winTeamIdStr", "getCurrentTime", "currentTime", "getPkBarStyle", "pkBarStyle", "getShowStartTime", "showStartTime", "getScoreType", "scoreType", "getShowDuration", "showDuration", "getDressId", "dressId", "getTeamBattleType", "setTeamBattleType", "teamBattleType", "Lcom/bytedance/android/live/liveinteract/multiscene/g;", "getRoomBattleContent", "()Lcom/bytedance/android/live/liveinteract/multiscene/g;", "roomBattleContent", "getFinishReason", "setFinishReason", "finishReason", "<init>", "()V", "Companion", "a", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkMicTeamFightInfo extends FlexModelBase<com.bytedance.android.live.liveinteract.multiscene.a> implements com.bytedance.android.live.liveinteract.multiscene.a, vh7.h {
    public static final a Companion = null;
    public static final int FIGHT_TYPE_FOR_LINK_ROOM = 2;
    public static final int FIGHT_TYPE_FOR_TEAM = 1;
    public static final String TAG = "GuestBattleV";
    public static final int TEAM_FIGHT_TYPE_CLASSICS = 1;
    public static final int TEAM_FIGHT_TYPE_FLEXIBLE = 2;

    @SerializedName("current_time_ms")
    protected long _currentTime;

    @SerializedName("dress_id")
    protected String _dressId;

    @SerializedName("duration")
    protected long _duration;

    @SerializedName("status")
    protected int _fightStatus;

    @SerializedName("type")
    protected int _fightType;
    private transient int _finishReason;

    @SerializedName("initiator_anchor_id")
    protected long _initiatorAnchorId;

    @SerializedName("initiator_user_id")
    protected long _initiatorUserId;

    @SerializedName("pk_bar_style")
    protected int _pkBarStyle;

    @SerializedName("punish_duration")
    protected long _punishDuration;

    @SerializedName("punish_start_time")
    protected long _punishStartTime;

    @SerializedName("room_battle_content")
    protected TeamfightRoomBattleContent _roomBattleContent;

    @SerializedName("score_type")
    protected int _scoreType;

    @SerializedName("show_duration")
    protected long _showDuration;

    @SerializedName("show_start_time")
    protected long _showStartTime;

    @SerializedName("start_time")
    protected long _startTime;

    @SerializedName("TeamBattleTeamType")
    protected int _teamBattleType;

    @SerializedName("teamfight_id")
    protected long _teamFightId;

    @SerializedName("teamfight_id_str")
    protected String _teamFightIdStr;

    @SerializedName("team_infos")
    protected List<? extends j> _teamInfos;

    @SerializedName("win_team_id")
    protected Long _winTeamId;

    @SerializedName("win_team_id_str")
    protected String _winTeamIdStr;

    @SerializedName("initiator_anchor_open_id")
    protected String initiatorAnchorOpenId;

    @SerializedName("initiator_user_open_id")
    protected String initiatorUserOpenId;
    private transient List<TeamFightPlayer> teamFightPlayers;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LinkMicTeamFightInfo() {
        super(com.bytedance.android.live.liveinteract.multiscene.a.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public String getInitiatorAnchorId() {
        o0.a r0 = o0.a;
        Long r1 = Long.valueOf(this._initiatorAnchorId);
        String r2 = this.initiatorAnchorOpenId;
        r0.getClass();
        return o0.a.g(r1, r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public String getInitiatorUserId() {
        o0.a r0 = o0.a;
        Long r1 = Long.valueOf(this._initiatorUserId);
        String r2 = this.initiatorUserOpenId;
        r0.getClass();
        return o0.a.g(r1, r2);
    }

    public final String toSimpleString() {
        return "TeamFightInfo{fightId=" + getTeamFightId() + ", status=" + getFightStatus() + ", duration=" + getDuration() + '}';
    }

    public String toString() {
        return "TeamFightInfo{ id=" + getTeamFightId() + ", type=" + getFightType() + ", status=" + getFightStatus() + ", startTime=" + getStartTime() + ", duration=" + getDuration() + ", punishStartTime=" + getPunishStartTime() + ", punishDuration=" + getPunishDuration() + ", teamInfos=" + getTeamInfos() + ", winTeamId=" + getWinTeamId() + ", pkBar=" + getPkBarStyle() + ", currentTime=" + getCurrentTime() + ", room_battle_content=" + getRoomBattleContent() + '}';
    }

    public final boolean canStartFight() {
        if (getTeamInfos() == null) goto L12;
        List<j> r0 = getTeamInfos();
        Intrinsics.checkNotNull(r0);
        if (r0.size() <= 1) goto L13;
        List<j> r1 = getTeamInfos();
        Intrinsics.checkNotNull(r1);
        if (k.c((j) ListProtector.get(r1, 0)) == false) goto L14;
        List<j> r2 = getTeamInfos();
        Intrinsics.checkNotNull(r2);
        if (k.c((j) ListProtector.get(r2, 1)) == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L13:
        return false;
    L12:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public Long getWinTeamId() {
        if (getTeamInfos() == null) goto L32;
        List<j> r0 = getTeamInfos();
        Intrinsics.checkNotNull(r0);
        if (r0.isEmpty() == true) goto L34;
        List<j> r1 = getTeamInfos();
        Intrinsics.checkNotNull(r1);
        Iterator<j> r2 = r1.iterator();
        long r4 = 0;
        long r6 = 0;
    L9:
        if (r2.hasNext() == false) goto L19;
        j r8 = r2.next();
        if (r8 == null) goto L9;
        if (r8.getScore() > r4) goto L14;
        if (r8.getScore() != r4) goto L9;
        r6 = 0;
        goto L9
    L14:
        r6 = r8.getTeamId();
        r4 = r8.getScore();
        goto L9
    L19:
        if (r4 > 0) goto L21;
        return 0L;
    L21:
        return Long.valueOf(r6);
    L34:
        return 0L;
    L32:
        return 0L;
    }

    public final boolean isLinkRoomFightInfo() {
        if (getFightType() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isTeamFightInfo() {
        if (getFightType() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean useRelativePkBar() {
        if (getPkBarStyle() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public long getCurrentTime() {
        return this._currentTime;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public String getDressId() {
        return this._dressId;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public long getDuration() {
        return this._duration;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public int getFightStatus() {
        return this._fightStatus;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public int getFightType() {
        return this._fightType;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public int getFinishReason() {
        return this._finishReason;
    }

    public final String getInitiatorAnchorOpenId() {
        return this.initiatorAnchorOpenId;
    }

    public final String getInitiatorUserOpenId() {
        return this.initiatorUserOpenId;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public int getPkBarStyle() {
        return this._pkBarStyle;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public long getPunishDuration() {
        return this._punishDuration;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public long getPunishStartTime() {
        return this._punishStartTime;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public g getRoomBattleContent() {
        return this._roomBattleContent;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public int getScoreType() {
        return this._scoreType;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public long getShowDuration() {
        return this._showDuration;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public long getShowStartTime() {
        return this._showStartTime;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public long getStartTime() {
        return this._startTime;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public int getTeamBattleType() {
        return this._teamBattleType;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public long getTeamFightId() {
        return this._teamFightId;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public String getTeamFightIdStr() {
        return this._teamFightIdStr;
    }

    public final List<TeamFightPlayer> getTeamFightPlayers() {
        return this.teamFightPlayers;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public List<j> getTeamInfos() {
        return this._teamInfos;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public String getWinTeamIdStr() {
        return this._winTeamIdStr;
    }

    public final long get_currentTime() {
        return this._currentTime;
    }

    public final String get_dressId() {
        return this._dressId;
    }

    public final long get_duration() {
        return this._duration;
    }

    public final int get_fightStatus() {
        return this._fightStatus;
    }

    public final int get_fightType() {
        return this._fightType;
    }

    public final int get_finishReason() {
        return this._finishReason;
    }

    public final long get_initiatorAnchorId() {
        return this._initiatorAnchorId;
    }

    public final long get_initiatorUserId() {
        return this._initiatorUserId;
    }

    public final int get_pkBarStyle() {
        return this._pkBarStyle;
    }

    public final long get_punishDuration() {
        return this._punishDuration;
    }

    public final long get_punishStartTime() {
        return this._punishStartTime;
    }

    public final TeamfightRoomBattleContent get_roomBattleContent() {
        return this._roomBattleContent;
    }

    public final int get_scoreType() {
        return this._scoreType;
    }

    public final long get_showDuration() {
        return this._showDuration;
    }

    public final long get_showStartTime() {
        return this._showStartTime;
    }

    public final long get_startTime() {
        return this._startTime;
    }

    public final int get_teamBattleType() {
        return this._teamBattleType;
    }

    public final long get_teamFightId() {
        return this._teamFightId;
    }

    public final String get_teamFightIdStr() {
        return this._teamFightIdStr;
    }

    public final List<j> get_teamInfos() {
        return this._teamInfos;
    }

    public final String get_winTeamIdStr() {
        return this._winTeamIdStr;
    }

    public LinkMicTeamFightInfo(am3.g r6) {
        super(com.bytedance.android.live.liveinteract.multiscene.a.class);
        this._teamInfos = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L36;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 100) goto L8;
        this._roomBattleContent = new TeamfightRoomBattleContent(r6);
        goto L3
    L8:
        if (r2 != 5000) goto L10;
        this.initiatorUserOpenId = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 5001) goto L11;
        this.initiatorAnchorOpenId = am3.h.c(r6);
        goto L3
    L11:
        switch(r2) {
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L26;
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L22;
            case 12: goto L21;
            case 13: goto L20;
            case 14: goto L19;
            case 15: goto L18;
            case 16: goto L17;
            case 17: goto L16;
            case 18: goto L15;
            case 19: goto L14;
            case 20: goto L13;
            default: goto L12;
        };
    L13:
        this._teamBattleType = r6.i();
        goto L3
    L14:
        this._dressId = am3.h.c(r6);
        goto L3
    L15:
        this._winTeamIdStr = am3.h.c(r6);
        goto L3
    L16:
        this._initiatorAnchorId = r6.j();
        goto L3
    L17:
        this._showDuration = r6.j();
        goto L3
    L18:
        this._scoreType = r6.i();
        goto L3
    L19:
        this._initiatorUserId = r6.j();
        goto L3
    L20:
        this._showStartTime = r6.j();
        goto L3
    L21:
        this._pkBarStyle = r6.i();
        goto L3
    L22:
        this._currentTime = r6.j();
        goto L3
    L23:
        this._winTeamId = Long.valueOf(r6.j());
        goto L3
    L24:
        this._teamInfos.add(vh7.f.a(r6, j.class));
        goto L3
    L25:
        this._punishDuration = r6.j();
        goto L3
    L26:
        this._punishStartTime = r6.j();
        goto L3
    L27:
        this._duration = r6.j();
        goto L3
    L28:
        this._startTime = r6.j();
        goto L3
    L29:
        this._fightStatus = r6.i();
        goto L3
    L30:
        this._fightType = r6.i();
        goto L3
    L31:
        this._teamFightIdStr = am3.h.c(r6);
        goto L3
    L32:
        this._teamFightId = r6.j();
        goto L3
    L12:
        am3.h.d(r3, r6);
        goto L3
    L36:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public void setFinishReason(int r1) {
        this._finishReason = r1;
    }

    public final void setInitiatorAnchorOpenId(String r1) {
        this.initiatorAnchorOpenId = r1;
    }

    public final void setInitiatorUserOpenId(String r1) {
        this.initiatorUserOpenId = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public void setTeamBattleType(int r1) {
        this._teamBattleType = r1;
    }

    public final void setTeamFightPlayers(List<TeamFightPlayer> r1) {
        this.teamFightPlayers = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.a
    public void setTeamInfos(List<? extends j> r1) {
        this._teamInfos = r1;
    }

    public final void set_currentTime(long r1) {
        this._currentTime = r1;
    }

    public final void set_dressId(String r1) {
        this._dressId = r1;
    }

    public final void set_duration(long r1) {
        this._duration = r1;
    }

    public final void set_fightStatus(int r1) {
        this._fightStatus = r1;
    }

    public final void set_fightType(int r1) {
        this._fightType = r1;
    }

    public final void set_finishReason(int r1) {
        this._finishReason = r1;
    }

    public final void set_initiatorAnchorId(long r1) {
        this._initiatorAnchorId = r1;
    }

    public final void set_initiatorUserId(long r1) {
        this._initiatorUserId = r1;
    }

    public final void set_pkBarStyle(int r1) {
        this._pkBarStyle = r1;
    }

    public final void set_punishDuration(long r1) {
        this._punishDuration = r1;
    }

    public final void set_punishStartTime(long r1) {
        this._punishStartTime = r1;
    }

    public final void set_roomBattleContent(TeamfightRoomBattleContent r1) {
        this._roomBattleContent = r1;
    }

    public final void set_scoreType(int r1) {
        this._scoreType = r1;
    }

    public final void set_showDuration(long r1) {
        this._showDuration = r1;
    }

    public final void set_showStartTime(long r1) {
        this._showStartTime = r1;
    }

    public final void set_startTime(long r1) {
        this._startTime = r1;
    }

    public final void set_teamBattleType(int r1) {
        this._teamBattleType = r1;
    }

    public final void set_teamFightId(long r1) {
        this._teamFightId = r1;
    }

    public final void set_teamFightIdStr(String r1) {
        this._teamFightIdStr = r1;
    }

    public final void set_teamInfos(List<? extends j> r1) {
        this._teamInfos = r1;
    }

    public final void set_winTeamIdStr(String r1) {
        this._winTeamIdStr = r1;
    }
}
