package com.bytedance.android.live.revlink.link.biz.component.switchscenecompact;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.jsb.h0;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.f;
import com.bytedance.android.live.revlink.impl.pk.vm.pk.e;
import com.bytedance.android.livesdk.link.model.bridge.a0;
import com.bytedance.android.livesdk.link.model.h7;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.t2;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010w\u001a\u00020v¢\u0006\u0004\bx\u0010yJ\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u0013\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0096\u0001J\t\u0010\n\u001a\u00020\u0006H\u0096\u0001J!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0004H\u0096\u0001J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0006H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0006H\u0096\u0001R\u0014\u0010\u0018\u001a\u00020\r8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\r8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R$\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\u00020\u001c8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u001c8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010\"R\u0014\u0010)\u001a\u00020\r8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b(\u0010\u0017R\u0016\u0010,\u001a\u0004\u0018\u00010\u001c8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R,\u00103\u001a\u001a\u0012\b\u0012\u00060.j\u0002`/0-j\f\u0012\b\u0012\u00060.j\u0002`/`08\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00102R$\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u000604j\b\u0012\u0004\u0012\u00020\u0006`58\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010:\u001a\u00020\u001c8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b9\u0010\"R\u0014\u0010;\u001a\u00020\u001c8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b;\u0010\"R\u0014\u0010<\u001a\u00020\u00068\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020\u00068\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b>\u0010=R\u0016\u0010?\u001a\u0004\u0018\u00010\r8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b?\u0010\u0017R\u0014\u0010@\u001a\u00020\u00068\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b@\u0010=R\u0014\u0010A\u001a\u00020\u00068\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bA\u0010=R\u0014\u0010B\u001a\u00020\u00068\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bB\u0010=R$\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u001bj\b\u0012\u0004\u0012\u00020\u0006`\u001d8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bC\u0010\u001fR0\u0010G\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\f0-j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\f`08\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bF\u00102R<\u0010K\u001a*\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0H0\f0-j\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0H0\f`08\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bJ\u00102R\u0014\u0010O\u001a\u00020L8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0014\u0010Q\u001a\u00020\u001c8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bP\u0010\"R,\u0010U\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u001bj\b\u0012\u0004\u0012\u00020\u0006`\u001d8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bR\u0010\u001f\"\u0004\bS\u0010TR$\u0010W\u001a\u0012\u0012\u0004\u0012\u00020\r0-j\b\u0012\u0004\u0012\u00020\r`08\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bV\u00102R$\u0010Y\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u001bj\b\u0012\u0004\u0012\u00020\u0006`\u001d8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bX\u0010\u001fR,\u0010\\\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u001bj\b\u0012\u0004\u0012\u00020\u0006`\u001d8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bZ\u0010\u001f\"\u0004\b[\u0010TR,\u0010_\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u001bj\b\u0012\u0004\u0012\u00020\u0006`\u001d8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b]\u0010\u001f\"\u0004\b^\u0010TR$\u0010a\u001a\u0012\u0012\u0004\u0012\u00020\u00060-j\b\u0012\u0004\u0012\u00020\u0006`08\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b`\u00102R$\u0010d\u001a\u0012\u0012\u0004\u0012\u00020b0-j\b\u0012\u0004\u0012\u00020b`08\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bc\u00102R$\u0010f\u001a\u0012\u0012\u0004\u0012\u00020L0-j\b\u0012\u0004\u0012\u00020L`08\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\be\u00102R0\u0010h\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\f0-j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\f`08\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bg\u00102R$\u0010j\u001a\u0012\u0012\u0004\u0012\u00020\u00060-j\b\u0012\u0004\u0012\u00020\u0006`08\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bi\u00102R,\u0010m\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u001bj\b\u0012\u0004\u0012\u00020\u0006`\u001d8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bk\u0010\u001f\"\u0004\bl\u0010TR,\u0010q\u001a\u0012\u0012\u0004\u0012\u00020n0\u001bj\b\u0012\u0004\u0012\u00020n`\u001d8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bo\u0010\u001f\"\u0004\bp\u0010TR\u0014\u0010u\u001a\u00020r8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bs\u0010t¨\u0006z"}, d2 = {"Lcom/bytedance/android/live/revlink/link/biz/component/switchscenecompact/PKDoubleProxyDataContext;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/c;", "", "Lcom/bytedance/live/datacontext/DataContext;", "", "attach", "", "canSwitchMulti", "isCloseRoom", "handlePkEnd", "isInContributor", "isFeedBack", "", "", "selectTag", "onFeedBackInfoUpdate", "recordGuestRtcLeave", "reportUiFirstLoad", "Lcom/bytedance/android/livesdk/link/model/bridge/a0;", "getShellConfig", "isInBreakThrough", "isInVote", "getAudienceConnectCnt", "()Ljava/lang/String;", "audienceConnectCnt", "getConnectionType", "connectionType", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "getContributionListAlphaEvent", "()Landroidx/lifecycle/MutableLiveData;", "contributionListAlphaEvent", "getCurAuraType", "()I", "setCurAuraType", "(I)V", "curAuraType", "getCurrentMatchType", "currentMatchType", "getEndReason", "endReason", "getEndType", "()Ljava/lang/Integer;", "endType", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "getGuestUser", "()Landroidx/lifecycle/LiveData;", "guestUser", "Lio/reactivex/subjects/PublishSubject;", "Lcom/bytedance/revenue/platform/api/core/rx/PublishSubject;", "getInstallKillMsgEvent", "()Lio/reactivex/subjects/PublishSubject;", "installKillMsgEvent", "getInviteType", "inviteType", "isBattleStatsObtained", "isFinisher", "()Z", "isGuestRtcLeave", "isManager", "isPlayModeInviter", "isRealOrgnizer", "isRoomCloser", "getLastBattleResultShow", "lastBattleResultShow", "Lcom/bytedance/android/livesdk/link/model/h7$b;", "getLeftMvpRankList", "leftMvpRankList", "Lcom/bytedance/android/live/revlink/impl/multianchor/dynamic/f;", "Lcom/bytedance/android/livesdk/link/model/p;", "getLinkAnchorInfo", "linkAnchorInfo", "", "getLinkStartTime", "()J", "linkStartTime", "getMatchTypeField", "matchTypeField", "getOppoIsUsingPropCard", "setOppoIsUsingPropCard", "(Landroidx/lifecycle/MutableLiveData;)V", "oppoIsUsingPropCard", "getPkGuestListStr", "pkGuestListStr", "getPkLynxInfoIsShowing", "pkLynxInfoIsShowing", "getPkProgressBarAdditionAnim", "setPkProgressBarAdditionAnim", "pkProgressBarAdditionAnim", "getPkProgressBarSecKillLine", "setPkProgressBarSecKillLine", "pkProgressBarSecKillLine", "getPkScoreForceUpdateEvent", "pkScoreForceUpdateEvent", "Lcom/bytedance/android/livesdk/link/model/t2;", "getPkSeasonResult", "pkSeasonResult", "getPkStarCount", "pkStarCount", "getRightMvpRankList", "rightMvpRankList", "getScoreFirstUpdateEvent", "scoreFirstUpdateEvent", "getSelfIsUsingPropCard", "setSelfIsUsingPropCard", "selfIsUsingPropCard", "Lcom/bytedance/android/live/revlink/impl/jsb/h0;", "getTeamTaskOptAddition", "setTeamTaskOptAddition", "teamTaskOptAddition", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/e;", "getTeamTaskService", "()Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/e;", "teamTaskService", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleDataContext;", "doubleDataContext", "<init>", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleDataContext;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKDoubleProxyDataContext extends DataContext implements c {
    private final /* synthetic */ PkDoubleDataContext $$delegate_0;
    private final /* synthetic */ PkDoubleDataContext $$delegate_1;

    public void attach() {
        this.$$delegate_0.attach();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public boolean canSwitchMulti() {
        return this.$$delegate_0.canSwitchMulti();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public String getAudienceConnectCnt() {
        return this.$$delegate_0.getAudienceConnectCnt();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public String getConnectionType() {
        return this.$$delegate_0.getConnectionType();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public MutableLiveData<Integer> getContributionListAlphaEvent() {
        return this.$$delegate_0.getContributionListAlphaEvent();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public int getCurAuraType() {
        return this.$$delegate_0.getCurAuraType();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public int getCurrentMatchType() {
        return this.$$delegate_0.getCurrentMatchType();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public String getEndReason() {
        return this.$$delegate_0.getEndReason();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public Integer getEndType() {
        return this.$$delegate_0.getEndType();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public LiveData<IBaseUser> getGuestUser() {
        return this.$$delegate_0.m605getGuestUser();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public PublishSubject<Boolean> getInstallKillMsgEvent() {
        return this.$$delegate_0.getInstallKillMsgEvent();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public int getInviteType() {
        return this.$$delegate_0.getInviteType();
    }

    public MutableLiveData<Boolean> getLastBattleResultShow() {
        return this.$$delegate_0.getLastBattleResultShow();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public LiveData<List<h7.b>> getLeftMvpRankList() {
        return this.$$delegate_0.getLeftMvpRankList();
    }

    public LiveData<List<f<p>>> getLinkAnchorInfo() {
        return this.$$delegate_0.m606getLinkAnchorInfo();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public long getLinkStartTime() {
        return this.$$delegate_0.getLinkStartTime();
    }

    public int getMatchTypeField() {
        return this.$$delegate_0.getMatchTypeField();
    }

    public MutableLiveData<Boolean> getOppoIsUsingPropCard() {
        return this.$$delegate_0.getOppoIsUsingPropCard();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public LiveData<String> getPkGuestListStr() {
        return this.$$delegate_0.m607getPkGuestListStr();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public MutableLiveData<Boolean> getPkLynxInfoIsShowing() {
        return this.$$delegate_0.getPkLynxInfoIsShowing();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public MutableLiveData<Boolean> getPkProgressBarAdditionAnim() {
        return this.$$delegate_0.getPkProgressBarAdditionAnim();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public MutableLiveData<Boolean> getPkProgressBarSecKillLine() {
        return this.$$delegate_0.getPkProgressBarSecKillLine();
    }

    public LiveData<Boolean> getPkScoreForceUpdateEvent() {
        return this.$$delegate_0.getPkScoreForceUpdateEvent();
    }

    public LiveData<t2> getPkSeasonResult() {
        return this.$$delegate_0.m608getPkSeasonResult();
    }

    public LiveData<Long> getPkStarCount() {
        return this.$$delegate_0.getPkStarCount();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public LiveData<List<h7.b>> getRightMvpRankList() {
        return this.$$delegate_0.getRightMvpRankList();
    }

    public LiveData<Boolean> getScoreFirstUpdateEvent() {
        return this.$$delegate_0.m609getScoreFirstUpdateEvent();
    }

    public MutableLiveData<Boolean> getSelfIsUsingPropCard() {
        return this.$$delegate_0.getSelfIsUsingPropCard();
    }

    public a0 getShellConfig() {
        return this.$$delegate_1.getShellConfig();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public MutableLiveData<h0> getTeamTaskOptAddition() {
        return this.$$delegate_0.getTeamTaskOptAddition();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public e getTeamTaskService() {
        return this.$$delegate_0.getTeamTaskService();
    }

    public void handlePkEnd(boolean r2) {
        this.$$delegate_0.handlePkEnd(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public int isBattleStatsObtained() {
        return this.$$delegate_0.isBattleStatsObtained();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public boolean isFinisher() {
        return this.$$delegate_0.isFinisher();
    }

    public boolean isGuestRtcLeave() {
        return this.$$delegate_0.isGuestRtcLeave();
    }

    public boolean isInBreakThrough() {
        return this.$$delegate_1.isInBreakThrough();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public boolean isInContributor() {
        return this.$$delegate_0.isInContributor();
    }

    public boolean isInVote() {
        return this.$$delegate_1.isInVote();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public String isManager() {
        return this.$$delegate_0.isManager();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public boolean isPlayModeInviter() {
        return this.$$delegate_0.isPlayModeInviter();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public boolean isRealOrgnizer() {
        return this.$$delegate_0.isRealOrgnizer();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public boolean isRoomCloser() {
        return this.$$delegate_0.isRoomCloser();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c
    public void onFeedBackInfoUpdate(boolean r2, List<String> r3) {
        this.$$delegate_0.onFeedBackInfoUpdate(r2, r3);
    }

    public void recordGuestRtcLeave() {
        this.$$delegate_0.recordGuestRtcLeave();
    }

    public void reportUiFirstLoad() {
        this.$$delegate_0.reportUiFirstLoad();
    }

    public void setCurAuraType(int r2) {
        this.$$delegate_0.setCurAuraType(r2);
    }

    public void setOppoIsUsingPropCard(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setOppoIsUsingPropCard(r2);
    }

    public void setPkProgressBarAdditionAnim(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setPkProgressBarAdditionAnim(r2);
    }

    public void setPkProgressBarSecKillLine(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setPkProgressBarSecKillLine(r2);
    }

    public void setSelfIsUsingPropCard(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setSelfIsUsingPropCard(r2);
    }

    public void setTeamTaskOptAddition(MutableLiveData<h0> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setTeamTaskOptAddition(r2);
    }

    public PKDoubleProxyDataContext(PkDoubleDataContext r2) {
        Intrinsics.checkNotNullParameter(r2, "doubleDataContext");
        this.$$delegate_0 = r2;
        this.$$delegate_1 = r2;
    }
}
