package com.bytedance.android.live.liveinteract.multiscene;

import com.bytedance.android.livesdk.chatroom.model.interact.v0;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.LinkmicTeamfightTeamInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bV\u0010WR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR\u001b\u0010\u0019\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\u000fR+\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR/\u0010!\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R/\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0006\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011R/\u0010,\u001a\u0004\u0018\u00010&2\b\u0010\u0004\u001a\u0004\u0018\u00010&8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0006\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R;\u00103\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010-2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010-8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0006\u001a\u0004\b/\u00100\"\u0004\b1\u00102R;\u00108\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010-2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010-8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010\u0006\u001a\u0004\b6\u00100\"\u0004\b7\u00102R/\u0010?\u001a\u0004\u0018\u0001092\b\u0010\u0004\u001a\u0004\u0018\u0001098V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b:\u0010\u0006\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R+\u0010B\u001a\u00020@2\u0006\u0010\u0004\u001a\u00020@8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bA\u0010\u0006\u001a\u0004\bB\u0010C\"\u0004\b$\u0010DR/\u0010H\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010\u0006\u001a\u0004\bF\u0010\u000f\"\u0004\bG\u0010\u0011R/\u0010O\u001a\u0004\u0018\u00010I2\b\u0010\u0004\u001a\u0004\u0018\u00010I8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bJ\u0010\u0006\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR/\u0010U\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bP\u0010\u0006\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T¨\u0006X"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multiscene/TeamFightTeamInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/multiscene/j;", "", "<set-?>", "teamId$delegate", "Ljava/lang/Object;", "getTeamId", "()J", "setTeamId", "(J)V", "teamId", "", "teamIdStr$delegate", "getTeamIdStr", "()Ljava/lang/String;", "setTeamIdStr", "(Ljava/lang/String;)V", "teamIdStr", "_ownerId$delegate", "get_ownerId", "set_ownerId", "_ownerId", "_ownerOpenId$delegate", "get_ownerOpenId", "_ownerOpenId", "score$delegate", "getScore", "setScore", "score", "scoreStr$delegate", "getScoreStr", "setScoreStr", "scoreStr", "scoreFuzzy$delegate", "getScoreFuzzy", "setScoreFuzzy", "scoreFuzzy", "Lcom/bytedance/android/live/liveinteract/multiscene/f$b;", "contributors$delegate", "getContributors", "()Lcom/bytedance/android/live/liveinteract/multiscene/f$b;", "setContributors", "(Lcom/bytedance/android/live/liveinteract/multiscene/f$b;)V", "contributors", "", "positionList$delegate", "getPositionList", "()Ljava/util/List;", "setPositionList", "(Ljava/util/List;)V", "positionList", "Lcom/bytedance/android/live/liveinteract/multiscene/f;", "players$delegate", "getPlayers", "setPlayers", "players", "Lcom/bytedance/android/livesdk/chatroom/model/interact/v0;", "bonusInfo$delegate", "getBonusInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/v0;", "setBonusInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/v0;)V", "bonusInfo", "", "isScoreFuzzy$delegate", "isScoreFuzzy", "()Z", "(Z)V", "bonusScore$delegate", "getBonusScore", "setBonusScore", "bonusScore", "Lcom/bytedance/android/live/liveinteract/multiscene/e;", "teamContributorTopList$delegate", "getTeamContributorTopList", "()Lcom/bytedance/android/live/liveinteract/multiscene/e;", "setTeamContributorTopList", "(Lcom/bytedance/android/live/liveinteract/multiscene/e;)V", "teamContributorTopList", "maxMember$delegate", "getMaxMember", "()Ljava/lang/Long;", "setMaxMember", "(Ljava/lang/Long;)V", "maxMember", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TeamFightTeamInfoFlexImpl extends FlexModelBase<j> implements j, vh7.h {

    @SerializedName("owner_id")
    protected long _$$_ownerId;

    @SerializedName("owner_open_id")
    protected String _$$_ownerOpenId;

    @SerializedName("bonus_info")
    protected v0 _$$bonusInfo;

    @SerializedName("bonus_score")
    protected String _$$bonusScore;

    @SerializedName("contributors")
    protected f.b _$$contributors;

    @SerializedName("is_score_fuzzy")
    protected boolean _$$isScoreFuzzy;

    @SerializedName("max_member")
    protected Long _$$maxMember;

    @SerializedName("players")
    protected List<? extends f> _$$players;

    @SerializedName("position_list")
    protected List<Long> _$$positionList;

    @SerializedName("score")
    protected long _$$score;

    @SerializedName("score_fuzzy")
    protected String _$$scoreFuzzy;

    @SerializedName("score_str")
    protected String _$$scoreStr;

    @SerializedName("team_contributor_top_list")
    protected e _$$teamContributorTopList;

    @SerializedName("team_id")
    protected long _$$teamId;

    @SerializedName("team_id_str")
    protected String _$$teamIdStr;

    public TeamFightTeamInfoFlexImpl() {
        super(j.class);
        this._$$_ownerOpenId = "";
        this._$$isScoreFuzzy = false;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final v0 getBonusInfo() {
        return this._$$bonusInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final String getBonusScore() {
        return this._$$bonusScore;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final f.b getContributors() {
        return this._$$contributors;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final Long getMaxMember() {
        return this._$$maxMember;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final List<f> getPlayers() {
        return this._$$players;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final List<Long> getPositionList() {
        return this._$$positionList;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final long getScore() {
        return this._$$score;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final String getScoreFuzzy() {
        return this._$$scoreFuzzy;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final String getScoreStr() {
        return this._$$scoreStr;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final e getTeamContributorTopList() {
        return this._$$teamContributorTopList;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final long getTeamId() {
        return this._$$teamId;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final String getTeamIdStr() {
        return this._$$teamIdStr;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final long get_ownerId() {
        return this._$$_ownerId;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final String get_ownerOpenId() {
        return this._$$_ownerOpenId;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final boolean isScoreFuzzy() {
        return this._$$isScoreFuzzy;
    }

    /* JADX WARN: Type inference failed for: r4v12, types: [com.bytedance.android.livesdk.chatroom.model.interact.v0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v15, types: [com.bytedance.android.live.liveinteract.multiscene.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.live.liveinteract.multiscene.f$b, java.lang.Object] */
    public TeamFightTeamInfoFlexImpl(am3.g r8) {
        super(j.class);
        this._$$positionList = new ArrayList();
        this._$$players = new ArrayList();
        setThreadSafe(false);
        long r1 = r8.c();
        int r3 = 0;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L25;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        if (r4 != 5000) goto L7;
        this._$$_ownerOpenId = am3.h.c(r8);
        goto L3
    L7:
        switch(r4) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L11;
            case 13: goto L10;
            case 14: goto L9;
            default: goto L8;
        };
    L9:
        this._$$maxMember = Long.valueOf(r8.j());
        goto L3
    L10:
        List r6 = this._$$positionList;
        Object r7 = Long.valueOf(r8.j());
    L18:
        r6.add(r7);
        goto L3
    L11:
        this._$$teamContributorTopList = vh7.f.a(r8, e.class);
        goto L3
    L12:
        this._$$bonusScore = am3.h.c(r8);
        goto L3
    L13:
        this._$$bonusInfo = vh7.f.a(r8, v0.class);
        goto L3
    L14:
        this._$$teamIdStr = am3.h.c(r8);
        goto L3
    L15:
        this._$$_ownerId = r8.j();
        r3 = r3 | 2;
        goto L3
    L16:
        this._$$isScoreFuzzy = am3.h.a(r8);
        r3 = r3 | 8;
        goto L3
    L17:
        r6 = this._$$players;
        r7 = vh7.f.a(r8, f.class);
        goto L18
    L19:
        this._$$contributors = vh7.f.a(r8, f.b.class);
        goto L3
    L20:
        this._$$scoreFuzzy = am3.h.c(r8);
        goto L3
    L21:
        this._$$scoreStr = am3.h.c(r8);
        goto L3
    L22:
        this._$$score = r8.j();
        r3 = r3 | 4;
        goto L3
    L23:
        this._$$teamId = r8.j();
        r3 = r3 | 1;
        goto L3
    L8:
        am3.h.d(r5, r8);
        goto L3
    L25:
        r8.d(r1);
        setThreadSafe(true);
        if (this._$$_ownerOpenId != null) goto L29;
        this._$$_ownerOpenId = "";
    L29:
        if ((r3 & 8) != 0) goto L66;
        this._$$isScoreFuzzy = false;
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final void setBonusInfo(v0 r1) {
        this._$$bonusInfo = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final void setBonusScore(String r1) {
        this._$$bonusScore = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final void setContributors(f.b r1) {
        this._$$contributors = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final void setMaxMember(Long r1) {
        this._$$maxMember = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final void setPlayers(List<? extends f> r1) {
        this._$$players = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final void setPositionList(List<Long> r1) {
        this._$$positionList = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final void setScore(long r1) {
        this._$$score = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final void setScoreFuzzy(String r1) {
        this._$$scoreFuzzy = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final void setScoreStr(String r1) {
        this._$$scoreStr = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final void setTeamContributorTopList(e r1) {
        this._$$teamContributorTopList = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final void setTeamId(long r1) {
        this._$$teamId = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final void setTeamIdStr(String r1) {
        this._$$teamIdStr = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final void set_ownerId(long r1) {
        this._$$_ownerId = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.j
    public final void setScoreFuzzy(boolean r1) {
        this._$$isScoreFuzzy = r1;
    }
}
