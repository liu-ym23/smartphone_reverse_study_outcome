package com.bytedance.android.live.liveinteract.multiscene;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.liveinteract.plantform.model.LinkMicQuickInteract;
import com.bytedance.android.live.liveinteract.plantform.model.l;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.LinkmicTeamfightPlayer")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 j2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002klB\u0007¢\u0006\u0004\bh\u0010iJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u00109\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=R\"\u0010A\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u00109\u001a\u0004\bB\u0010;\"\u0004\bC\u0010=R\"\u0010D\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010\u0007\u001a\u0004\bE\u0010\t\"\u0004\bF\u0010\u000bR$\u0010J\u001a\u00020\"2\u0006\u0010G\u001a\u00020\"8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bH\u0010&\"\u0004\bI\u0010(R$\u0010P\u001a\u00020K2\u0006\u0010G\u001a\u00020K8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010Q\u001a\u0002072\u0006\u0010G\u001a\u0002078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bQ\u0010;\"\u0004\bR\u0010=R$\u0010S\u001a\u0002072\u0006\u0010G\u001a\u0002078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bS\u0010;\"\u0004\bT\u0010=R$\u0010U\u001a\u0002072\u0006\u0010G\u001a\u0002078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bU\u0010;\"\u0004\bV\u0010=R$\u0010Y\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bW\u0010\t\"\u0004\bX\u0010\u000bR\u0016\u0010[\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010\u000fR\u0016\u0010]\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010\u000fR\u0016\u0010a\u001a\u0004\u0018\u00010^8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R$\u0010d\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bb\u0010\u000f\"\u0004\bc\u0010\u0011R$\u0010g\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\be\u0010\t\"\u0004\bf\u0010\u000b¨\u0006m"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multiscene/TeamFightPlayer;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/multiscene/f;", "", "toString", "", "userId", "J", "getUserId", "()J", "setUserId", "(J)V", "userOpenId", "Ljava/lang/String;", "getUserOpenId", "()Ljava/lang/String;", "setUserOpenId", "(Ljava/lang/String;)V", "score", "getScore", "setScore", "scoreStr", "getScoreStr", "setScoreStr", "scoreFuzzy", "getScoreFuzzy", "setScoreFuzzy", "Lcom/bytedance/android/live/liveinteract/multiscene/TeamFightPlayer$TeamFightContributors;", "contributors", "Lcom/bytedance/android/live/liveinteract/multiscene/TeamFightPlayer$TeamFightContributors;", "getContributors", "()Lcom/bytedance/android/live/liveinteract/multiscene/TeamFightPlayer$TeamFightContributors;", "setContributors", "(Lcom/bytedance/android/live/liveinteract/multiscene/TeamFightPlayer$TeamFightContributors;)V", "", "_role", "I", "get_role", "()I", "set_role", "(I)V", "Lcom/bytedance/android/live/base/model/user/User;", "titleSponsor", "Lcom/bytedance/android/live/base/model/user/User;", "getTitleSponsor", "()Lcom/bytedance/android/live/base/model/user/User;", "setTitleSponsor", "(Lcom/bytedance/android/live/base/model/user/User;)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkMicQuickInteract;", "_quickInteract", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkMicQuickInteract;", "get_quickInteract", "()Lcom/bytedance/android/live/liveinteract/plantform/model/LinkMicQuickInteract;", "set_quickInteract", "(Lcom/bytedance/android/live/liveinteract/plantform/model/LinkMicQuickInteract;)V", "", "_isGrownUpgrade", "Z", "get_isGrownUpgrade", "()Z", "set_isGrownUpgrade", "(Z)V", "_isGrownDowngrade", "get_isGrownDowngrade", "set_isGrownDowngrade", "_isDressUpdated", "get_isDressUpdated", "set_isDressUpdated", "_serverTeamId", "get_serverTeamId", "set_serverTeamId", "value", "getRole", "setRole", "role", "Lcom/bytedance/android/live/liveinteract/plantform/model/l;", "getQuickInteract", "()Lcom/bytedance/android/live/liveinteract/plantform/model/l;", "setQuickInteract", "(Lcom/bytedance/android/live/liveinteract/plantform/model/l;)V", "quickInteract", "isGrownUpgrade", "setGrownUpgrade", "isGrownDowngrade", "setGrownDowngrade", "isDressUpdated", "setDressUpdated", "getScoreFlex", "setScoreFlex", "scoreFlex", "getScoreStrFlex", "scoreStrFlex", "getScoreFuzzyFlex", "scoreFuzzyFlex", "Lcom/bytedance/android/live/liveinteract/multiscene/f$b;", "getContributorsFlex", "()Lcom/bytedance/android/live/liveinteract/multiscene/f$b;", "contributorsFlex", "getUserIdString", "setUserIdString", "userIdString", "getServerTeamId", "setServerTeamId", "serverTeamId", "<init>", "()V", "Companion", "a", "TeamFightContributors", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TeamFightPlayer extends FlexModelBase<f> implements f, vh7.h {
    public static final a Companion = null;
    public static final int TEAMFIGHT_LAGGING_ROLE_MVP = 2;
    public static final int TEAMFIGHT_LEADING_ROLE_MVP = 1;
    public static final int TEAMFIGHT_ROLE_NONE = 0;
    private boolean _isDressUpdated;
    private boolean _isGrownDowngrade;
    private boolean _isGrownUpgrade;
    private LinkMicQuickInteract _quickInteract;

    @SerializedName("role")
    protected int _role;
    private long _serverTeamId;

    @SerializedName("contributors")
    protected TeamFightContributors contributors;

    @SerializedName("score")
    protected long score;

    @SerializedName("score_fuzzy")
    protected String scoreFuzzy;

    @SerializedName("score_str")
    protected String scoreStr;

    @SerializedName("title_sponsor")
    protected User titleSponsor;

    @SerializedName("user_id")
    protected long userId;

    @SerializedName("open_id")
    protected String userOpenId;

    @ProtoMessage("webcast.data.LinkmicTeamfightContributors")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0010\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\u0002J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H\u0096\u0002R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multiscene/TeamFightPlayer$TeamFightContributors;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/multiscene/f$b;", "", "userId", "", "contains", "", "", "_userIds", "Ljava/util/List;", "get_userIds", "()Ljava/util/List;", "set_userIds", "(Ljava/util/List;)V", "userOpenIds", "getUserOpenIds", "setUserOpenIds", "getUserIdsFlex", "userIdsFlex", "getUserIds", "userIds", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TeamFightContributors extends FlexModelBase<f.b> implements f.b, vh7.h {

        @SerializedName("user_ids")
        protected List<Long> _userIds;

        @SerializedName("open_ids")
        protected List<String> userOpenIds;

        public TeamFightContributors() {
            super(f.b.class);
        }

        @Override // com.bytedance.android.live.liveinteract.multiscene.f.b
        public List<String> getUserIds() {
            o0.a r0 = o0.a;
            List<String> r1 = this.userOpenIds;
            r0.getClass();
            return o0.a.h(r1);
        }

        @Override // com.bytedance.android.live.liveinteract.multiscene.f.b
        public List<Long> getUserIdsFlex() {
            return this._userIds;
        }

        public final List<String> getUserOpenIds() {
            return this.userOpenIds;
        }

        public final List<Long> get_userIds() {
            return this._userIds;
        }

        public TeamFightContributors(am3.g r6) {
            super(f.b.class);
            this._userIds = new ArrayList();
            this.userOpenIds = new ArrayList();
            setThreadSafe(false);
            long r0 = r6.c();
        L3:
            int r2 = r6.f();
            if (r2 == (-1)) goto L13;
            am3.g.a r3 = decodeExtensionFields(r2, r6);
            if (r2 == 1) goto L11;
            if (r2 != 5000) goto L9;
            List r4 = this.userOpenIds;
            Object r5 = am3.h.c(r6);
        L12:
            r4.add(r5);
            goto L3
        L9:
            am3.h.d(r3, r6);
            goto L3
        L11:
            r4 = this._userIds;
            r5 = Long.valueOf(r6.j());
            goto L12
        L13:
            r6.d(r0);
            setThreadSafe(true);
        }

        public final boolean contains(long r2) {
            List<Long> r0 = this._userIds;
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.contains(Long.valueOf(r2));
        }

        public final void setUserOpenIds(List<String> r1) {
            this.userOpenIds = r1;
        }

        public final void set_userIds(List<Long> r1) {
            this._userIds = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.multiscene.f.b
        public boolean contains(String r2) {
            List<String> r0 = getUserIds();
            if (r0 != null) goto L7;
            return false;
        L7:
            return CollectionsKt.contains(r0, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public TeamFightPlayer() {
        super(f.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public l getQuickInteract() {
        LinkMicQuickInteract r0 = this._quickInteract;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.model.LinkMicQuickInteract");
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public String getUserIdString() {
        o0.a r0 = o0.a;
        Long r1 = Long.valueOf(this.userId);
        String r2 = this.userOpenId;
        r0.getClass();
        return o0.a.g(r1, r2);
    }

    public String toString() {
        return "FightPlayer{uid=" + getUserIdString() + ", score='" + this.scoreStr + "', role=" + getRole() + '}';
    }

    public final TeamFightContributors getContributors() {
        return this.contributors;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public f.b getContributorsFlex() {
        return this.contributors;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public int getRole() {
        return this._role;
    }

    public final long getScore() {
        return this.score;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public long getScoreFlex() {
        return this.score;
    }

    public final String getScoreFuzzy() {
        return this.scoreFuzzy;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public String getScoreFuzzyFlex() {
        return this.scoreFuzzy;
    }

    public final String getScoreStr() {
        return this.scoreStr;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public String getScoreStrFlex() {
        return this.scoreStr;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public long getServerTeamId() {
        return this._serverTeamId;
    }

    public final User getTitleSponsor() {
        return this.titleSponsor;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final String getUserOpenId() {
        return this.userOpenId;
    }

    public final boolean get_isDressUpdated() {
        return this._isDressUpdated;
    }

    public final boolean get_isGrownDowngrade() {
        return this._isGrownDowngrade;
    }

    public final boolean get_isGrownUpgrade() {
        return this._isGrownUpgrade;
    }

    public final LinkMicQuickInteract get_quickInteract() {
        return this._quickInteract;
    }

    public final int get_role() {
        return this._role;
    }

    public final long get_serverTeamId() {
        return this._serverTeamId;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public boolean isDressUpdated() {
        return this._isDressUpdated;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public boolean isGrownDowngrade() {
        return this._isGrownDowngrade;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public boolean isGrownUpgrade() {
        return this._isGrownUpgrade;
    }

    public TeamFightPlayer(am3.g r6) {
        super(f.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L17;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 5000) goto L7;
        this.userOpenId = am3.h.c(r6);
        goto L3
    L7:
        switch(r2) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L8;
        };
    L9:
        this.titleSponsor = new User(r6);
        goto L3
    L10:
        this._role = r6.i();
        goto L3
    L11:
        this.contributors = new TeamFightContributors(r6);
        goto L3
    L12:
        this.scoreFuzzy = am3.h.c(r6);
        goto L3
    L13:
        this.scoreStr = am3.h.c(r6);
        goto L3
    L14:
        this.score = r6.j();
        goto L3
    L15:
        this.userId = r6.j();
        goto L3
    L8:
        am3.h.d(r3, r6);
        goto L3
    L17:
        r6.d(r0);
        setThreadSafe(true);
    }

    public final void setContributors(TeamFightContributors r1) {
        this.contributors = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public void setDressUpdated(boolean r1) {
        this._isDressUpdated = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public void setGrownDowngrade(boolean r1) {
        this._isGrownDowngrade = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public void setGrownUpgrade(boolean r1) {
        this._isGrownUpgrade = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public void setQuickInteract(l r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        if ((r2 instanceof LinkMicQuickInteract) == true) goto L5;
        r2 = null;
    L5:
        this._quickInteract = (LinkMicQuickInteract) r2;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public void setRole(int r1) {
        this._role = r1;
    }

    public final void setScore(long r1) {
        this.score = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public void setScoreFlex(long r1) {
        this.score = r1;
    }

    public final void setScoreFuzzy(String r1) {
        this.scoreFuzzy = r1;
    }

    public final void setScoreStr(String r1) {
        this.scoreStr = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public void setServerTeamId(long r1) {
        this._serverTeamId = r1;
    }

    public final void setTitleSponsor(User r1) {
        this.titleSponsor = r1;
    }

    public final void setUserId(long r1) {
        this.userId = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.f
    public void setUserIdString(String r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        this.userId = d5.c(r3);
        this.userOpenId = r3;
    }

    public final void setUserOpenId(String r1) {
        this.userOpenId = r1;
    }

    public final void set_isDressUpdated(boolean r1) {
        this._isDressUpdated = r1;
    }

    public final void set_isGrownDowngrade(boolean r1) {
        this._isGrownDowngrade = r1;
    }

    public final void set_isGrownUpgrade(boolean r1) {
        this._isGrownUpgrade = r1;
    }

    public final void set_quickInteract(LinkMicQuickInteract r1) {
        this._quickInteract = r1;
    }

    public final void set_role(int r1) {
        this._role = r1;
    }

    public final void set_serverTeamId(long r1) {
        this._serverTeamId = r1;
    }
}
