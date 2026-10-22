package com.bytedance.android.live.liveinteract.multiscene;

import com.bytedance.android.livesdk.chatroom.model.interact.v0;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0015\u0010\fR\"\u0010\u001b\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u0006R$\u0010\u001f\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR$\u0010#\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\b\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR$\u0010*\u001a\u0004\u0018\u00010$8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\b\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R*\u00101\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010+8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b0\u0010\b\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R*\u00106\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010+8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b5\u0010\b\u001a\u0004\b3\u0010-\"\u0004\b4\u0010/R$\u0010=\u001a\u0004\u0018\u0001078&@&X§\u000e¢\u0006\u0012\u0012\u0004\b<\u0010\b\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010?\u001a\u00020>8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bB\u0010\b\u001a\u0004\b?\u0010@\"\u0004\b!\u0010AR$\u0010F\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bE\u0010\b\u001a\u0004\bC\u0010\f\"\u0004\bD\u0010\u000eR$\u0010M\u001a\u0004\u0018\u00010G8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bL\u0010\b\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010S\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\bR\u0010\b\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q¨\u0006T"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multiscene/j;", "Lvh7/c;", "", "getTeamId", "()J", "setTeamId", "(J)V", "getTeamId$annotations", "()V", "teamId", "", "getTeamIdStr", "()Ljava/lang/String;", "setTeamIdStr", "(Ljava/lang/String;)V", "getTeamIdStr$annotations", "teamIdStr", "get_ownerId", "set_ownerId", "get_ownerId$annotations", "_ownerId", "get_ownerOpenId", "get_ownerOpenId$annotations", "_ownerOpenId", "getScore", "setScore", "getScore$annotations", "score", "getScoreStr", "setScoreStr", "getScoreStr$annotations", "scoreStr", "getScoreFuzzy", "setScoreFuzzy", "getScoreFuzzy$annotations", "scoreFuzzy", "Lcom/bytedance/android/live/liveinteract/multiscene/f$b;", "getContributors", "()Lcom/bytedance/android/live/liveinteract/multiscene/f$b;", "setContributors", "(Lcom/bytedance/android/live/liveinteract/multiscene/f$b;)V", "getContributors$annotations", "contributors", "", "getPositionList", "()Ljava/util/List;", "setPositionList", "(Ljava/util/List;)V", "getPositionList$annotations", "positionList", "Lcom/bytedance/android/live/liveinteract/multiscene/f;", "getPlayers", "setPlayers", "getPlayers$annotations", "players", "Lcom/bytedance/android/livesdk/chatroom/model/interact/v0;", "getBonusInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/v0;", "setBonusInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/v0;)V", "getBonusInfo$annotations", "bonusInfo", "", "isScoreFuzzy", "()Z", "(Z)V", "isScoreFuzzy$annotations", "getBonusScore", "setBonusScore", "getBonusScore$annotations", "bonusScore", "Lcom/bytedance/android/live/liveinteract/multiscene/e;", "getTeamContributorTopList", "()Lcom/bytedance/android/live/liveinteract/multiscene/e;", "setTeamContributorTopList", "(Lcom/bytedance/android/live/liveinteract/multiscene/e;)V", "getTeamContributorTopList$annotations", "teamContributorTopList", "getMaxMember", "()Ljava/lang/Long;", "setMaxMember", "(Ljava/lang/Long;)V", "getMaxMember$annotations", "maxMember", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface j extends vh7.c<j> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "bonus_info")
    v0 getBonusInfo();

    @FieldName(name = "bonus_score")
    String getBonusScore();

    @FieldName(name = "contributors")
    f.b getContributors();

    @FieldName(name = "max_member")
    Long getMaxMember();

    @FieldName(name = "players")
    List<f> getPlayers();

    @FieldName(name = "position_list")
    List<Long> getPositionList();

    @FieldName(name = "score")
    long getScore();

    @FieldName(name = "score_fuzzy")
    String getScoreFuzzy();

    @FieldName(name = "score_str")
    String getScoreStr();

    @FieldName(name = "team_contributor_top_list")
    e getTeamContributorTopList();

    @FieldName(name = "team_id")
    long getTeamId();

    @FieldName(name = "team_id_str")
    String getTeamIdStr();

    @FieldName(name = "owner_id")
    long get_ownerId();

    @FieldName(name = "owner_open_id")
    String get_ownerOpenId();

    @FieldName(name = "is_score_fuzzy")
    boolean isScoreFuzzy();

    @FieldName(name = "bonus_info#setter")
    void setBonusInfo(v0 r1);

    @FieldName(name = "bonus_score#setter")
    void setBonusScore(String r1);

    @FieldName(name = "contributors#setter")
    void setContributors(f.b r1);

    @FieldName(name = "max_member#setter")
    void setMaxMember(Long r1);

    @FieldName(name = "players#setter")
    void setPlayers(List<? extends f> r1);

    @FieldName(name = "position_list#setter")
    void setPositionList(List<Long> r1);

    @FieldName(name = "score#setter")
    void setScore(long r1);

    @FieldName(name = "score_fuzzy#setter")
    void setScoreFuzzy(String r1);

    @FieldName(name = "is_score_fuzzy#setter")
    void setScoreFuzzy(boolean r1);

    @FieldName(name = "score_str#setter")
    void setScoreStr(String r1);

    @FieldName(name = "team_contributor_top_list#setter")
    void setTeamContributorTopList(e r1);

    @FieldName(name = "team_id#setter")
    void setTeamId(long r1);

    @FieldName(name = "team_id_str#setter")
    void setTeamIdStr(String r1);

    @FieldName(name = "owner_id#setter")
    void set_ownerId(long r1);
}
