package com.bytedance.android.live.liveinteract.multiscene;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u000f\bg\u0018\u0000 S2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001TR\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u001a\u0010\r\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\f\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\u001b\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\f\u001a\u0004\b\u0019\u0010\nR\u001a\u0010\u001e\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\f\u001a\u0004\b\u001c\u0010\nR\u001a\u0010!\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\f\u001a\u0004\b\u001f\u0010\nR\u001a\u0010$\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\f\u001a\u0004\b\"\u0010\nR,\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010%8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u00100\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b/\u0010\f\u001a\u0004\b-\u0010.R\u001c\u00103\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b2\u0010\f\u001a\u0004\b1\u0010\u0004R\u001a\u00106\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b5\u0010\f\u001a\u0004\b4\u0010\nR\u001a\u00109\u001a\u00020\u00118&X§\u0004¢\u0006\f\u0012\u0004\b8\u0010\f\u001a\u0004\b7\u0010\u0013R\u001a\u0010<\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b;\u0010\f\u001a\u0004\b:\u0010\nR\u001a\u0010?\u001a\u00020\u00118&X§\u0004¢\u0006\f\u0012\u0004\b>\u0010\f\u001a\u0004\b=\u0010\u0013R\u001a\u0010B\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\bA\u0010\f\u001a\u0004\b@\u0010\nR\u001c\u0010E\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\bD\u0010\f\u001a\u0004\bC\u0010\u0004R\u001c\u0010J\u001a\u0004\u0018\u00010F8&X§\u0004¢\u0006\f\u0012\u0004\bI\u0010\f\u001a\u0004\bG\u0010HR\"\u0010O\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\bN\u0010\f\u001a\u0004\bK\u0010\u0013\"\u0004\bL\u0010MR\u001c\u0010R\u001a\u00020\u00118&@&X¦\u000e¢\u0006\f\u001a\u0004\bP\u0010\u0013\"\u0004\bQ\u0010M¨\u0006U"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multiscene/a;", "Lvh7/c;", "", "getInitiatorUserId", "()Ljava/lang/String;", "initiatorUserId", "getInitiatorAnchorId", "initiatorAnchorId", "", "getTeamFightId", "()J", "getTeamFightId$annotations", "()V", "teamFightId", "getTeamFightIdStr", "getTeamFightIdStr$annotations", "teamFightIdStr", "", "getFightType", "()I", "getFightType$annotations", "fightType", "getFightStatus", "getFightStatus$annotations", "fightStatus", "getStartTime", "getStartTime$annotations", "startTime", "getDuration", "getDuration$annotations", "duration", "getPunishStartTime", "getPunishStartTime$annotations", "punishStartTime", "getPunishDuration", "getPunishDuration$annotations", "punishDuration", "", "Lcom/bytedance/android/live/liveinteract/multiscene/j;", "getTeamInfos", "()Ljava/util/List;", "setTeamInfos", "(Ljava/util/List;)V", "getTeamInfos$annotations", "teamInfos", "getWinTeamId", "()Ljava/lang/Long;", "getWinTeamId$annotations", "winTeamId", "getWinTeamIdStr", "getWinTeamIdStr$annotations", "winTeamIdStr", "getCurrentTime", "getCurrentTime$annotations", "currentTime", "getPkBarStyle", "getPkBarStyle$annotations", "pkBarStyle", "getShowStartTime", "getShowStartTime$annotations", "showStartTime", "getScoreType", "getScoreType$annotations", "scoreType", "getShowDuration", "getShowDuration$annotations", "showDuration", "getDressId", "getDressId$annotations", "dressId", "Lcom/bytedance/android/live/liveinteract/multiscene/g;", "getRoomBattleContent", "()Lcom/bytedance/android/live/liveinteract/multiscene/g;", "getRoomBattleContent$annotations", "roomBattleContent", "getTeamBattleType", "setTeamBattleType", "(I)V", "getTeamBattleType$annotations", "teamBattleType", "getFinishReason", "setFinishReason", "finishReason", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends vh7.c<a> {
    public static final C0046a Companion = null;
    public static final int FIGHT_TYPE_FOR_LINK_ROOM = 2;
    public static final int FIGHT_TYPE_FOR_TEAM = 1;
    public static final int TEAM_FIGHT_TYPE_CLASSICS = 1;
    public static final int TEAM_FIGHT_TYPE_FLEXIBLE = 2;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.multiscene.a$a, reason: collision with other inner class name */
    public static final class C0046a {
        public static final /* synthetic */ C0046a a = null;

        public C0046a() {
        }

        static {
            a = new C0046a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = C0046a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "current_time_ms")
    long getCurrentTime();

    @FieldName(name = "dress_id")
    String getDressId();

    @FieldName(name = "duration")
    long getDuration();

    @FieldName(name = "status")
    int getFightStatus();

    @FieldName(name = "type")
    int getFightType();

    int getFinishReason();

    String getInitiatorAnchorId();

    String getInitiatorUserId();

    @FieldName(name = "pk_bar_style")
    int getPkBarStyle();

    @FieldName(name = "punish_duration")
    long getPunishDuration();

    @FieldName(name = "punish_start_time")
    long getPunishStartTime();

    @FieldName(name = "room_battle_content")
    g getRoomBattleContent();

    @FieldName(name = "score_type")
    int getScoreType();

    @FieldName(name = "show_duration")
    long getShowDuration();

    @FieldName(name = "show_start_time")
    long getShowStartTime();

    @FieldName(name = "start_time")
    long getStartTime();

    @FieldName(name = "TeamBattleTeamType")
    int getTeamBattleType();

    @FieldName(name = "teamfight_id")
    long getTeamFightId();

    @FieldName(name = "teamfight_id_str")
    String getTeamFightIdStr();

    @FieldName(name = "team_infos")
    List<j> getTeamInfos();

    @FieldName(name = "win_team_id")
    Long getWinTeamId();

    @FieldName(name = "win_team_id_str")
    String getWinTeamIdStr();

    void setFinishReason(int r1);

    @FieldName(name = "TeamBattleTeamType#setter")
    void setTeamBattleType(int r1);

    @FieldName(name = "team_infos#setter")
    void setTeamInfos(List<? extends j> r1);
}
