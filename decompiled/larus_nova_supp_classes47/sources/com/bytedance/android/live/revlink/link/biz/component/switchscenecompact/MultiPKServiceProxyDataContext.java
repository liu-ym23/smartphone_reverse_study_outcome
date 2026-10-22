package com.bytedance.android.live.revlink.link.biz.component.switchscenecompact;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.c;
import com.bytedance.android.live.revlink.impl.mergepk.pkmulti.PkMultiDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b;
import com.bytedance.android.live.revlink.impl.mergepk.pkmulti.d;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.android.livesdk.link.model.z;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import i31.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kc0.n;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import p11.g;
import w20.v9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\bl\u0010mJ\"\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J \u0010\r\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0011\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J%\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0016j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0017H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0019H\u0096\u0001J!\u0010\u001b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000bH\u0096\u0001J%\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u001cj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0019`\u001dH\u0096\u0001J\u0011\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0014H\u0096\u0001J\u0015\u0010$\u001a\u00020\t2\n\u0010#\u001a\u00060!j\u0002`\"H\u0096\u0001J\u001d\u0010(\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010'\u001a\u00020\u000eH\u0096\u0001J\t\u0010)\u001a\u00020\tH\u0096\u0001J\u0011\u0010*\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J\t\u0010+\u001a\u00020\tH\u0096\u0001J\u0011\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020,H\u0096\u0001J\t\u0010/\u001a\u00020\u000eH\u0096\u0001R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R$\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u000503j\b\u0012\u0004\u0012\u00020\u0005`48\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010>\u001a\u00020\u00058\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b<\u0010=R\u001c\u0010?\u001a\u00020\u000e8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020\u000e8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bC\u0010@R\u001c\u0010D\u001a\u00020\u000e8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR$\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\u000e0Fj\b\u0012\u0004\u0012\u00020\u000e`G8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bH\u0010IR$\u0010M\u001a\u0012\u0012\u0004\u0012\u00020K03j\b\u0012\u0004\u0012\u00020K`48\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bL\u00106R\u0016\u0010Q\u001a\u0004\u0018\u00010N8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bS\u0010TR0\u0010X\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0\f03j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0\f`48\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bW\u00106R$\u0010Z\u001a\u0012\u0012\u0004\u0012\u00020\u000e03j\b\u0012\u0004\u0012\u00020\u000e`48\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bY\u00106R$\u0010\\\u001a\u0012\u0012\u0004\u0012\u00020\u000e03j\b\u0012\u0004\u0012\u00020\u000e`48\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b[\u00106R$\u0010a\u001a\u0012\u0012\u0004\u0012\u00020\u000e0]j\b\u0012\u0004\u0012\u00020\u000e`^8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0014\u0010c\u001a\u00020\u00058\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bb\u0010=R\"\u0010h\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020e\u0018\u00010d8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0014\u0010k\u001a\u00020\u00198\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bi\u0010j¨\u0006n"}, d2 = {"Lcom/bytedance/android/live/revlink/link/biz/component/switchscenecompact/MultiPKServiceProxyDataContext;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkmulti/b;", "Lp11/g;", "Lkc0/n;", "Lcom/bytedance/live/datacontext/DataContext;", "", "anchorId", "secAnchorId", "source", "", "launchVoteRulePage", "Lkotlin/Pair;", "", "getTeamPkUids", "", "isMultiPk", "isMultiBreakThrough", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkmulti/d;", "interceptor", "addRankUpdateInterceptor", "Lw20/v9;", "getBattleBgImage", "", "Lcom/bytedance/revenue/platform/api/core/KmpMutableMap;", "getCurrentSceneLogParam", "", "getPkUserCnt", "getTeamPkUids4Finish", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getUserRoleMap", "params", "handleBattleBgImage", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "leaveUser", "handleUserLeave", "Lcom/bytedance/android/livesdk/link/model/r;", "anchorLinkList", "forceUpdate", "notifyPkContext", "reCreatePkStartParam", "removeRankUpdateInterceptor", "requestUpdateRank", "Lcom/bytedance/android/livesdk/link/model/z;", "audioPunishInfo", "updateAudioPunishInfo", "isVotePk", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkmulti/PkMultiDataContext;", "pkMultiDataContext", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkmulti/PkMultiDataContext;", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "getBattlePowerInfo", "()Landroidx/lifecycle/LiveData;", "battlePowerInfo", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/c;", "getExtraPlayContextManager", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/c;", "extraPlayContextManager", "getInviteModeStatus", "()Ljava/lang/String;", "inviteModeStatus", "isAnchorLinkFinisher", "()Z", "setAnchorLinkFinisher", "(Z)V", "isOnceMore", "isPkLauncher", "setPkLauncher", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "getLastBattleResultVisible", "()Landroidx/lifecycle/MutableLiveData;", "lastBattleResultVisible", "Li31/b;", "getMultiPkFinishEvent", "multiPkFinishEvent", "Li31/a;", "getPkBeforeFinishData", "()Li31/a;", "pkBeforeFinishData", "Lj31/a;", "getPkStartParam", "()Lj31/a;", "pkStartParam", "Laf2/b;", "getScoreState", "scoreState", "getShowExtraResultAnim", "showExtraResultAnim", "getShowLastBattleResult", "showLastBattleResult", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Lcom/bytedance/android/live/revenue/common/NextLiveData;", "getTeamTaskLayoutFocused", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "teamTaskLayoutFocused", "getTeamType", "teamType", "", "", "getUserIdToTeamId", "()Ljava/util/Map;", "userIdToTeamId", "getCurrentPkMode", "()I", "currentPkMode", "<init>", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkmulti/PkMultiDataContext;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiPKServiceProxyDataContext extends DataContext implements b, g, n {
    private final PkMultiDataContext pkMultiDataContext;

    public void addRankUpdateInterceptor(d r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        this.pkMultiDataContext.addRankUpdateInterceptor(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public v9 getBattleBgImage() {
        return this.pkMultiDataContext.getBattleBgImage();
    }

    public LiveData<String> getBattlePowerInfo() {
        return this.pkMultiDataContext.m613getBattlePowerInfo();
    }

    public int getCurrentPkMode() {
        return this.pkMultiDataContext.getCurrentPkMode();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public Map<String, String> getCurrentSceneLogParam() {
        return this.pkMultiDataContext.getCurrentSceneLogParam();
    }

    public c getExtraPlayContextManager() {
        return this.pkMultiDataContext.getExtraPlayContextManager();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public String getInviteModeStatus() {
        return this.pkMultiDataContext.getInviteModeStatus();
    }

    public MutableLiveData<Boolean> getLastBattleResultVisible() {
        return this.pkMultiDataContext.getLastBattleResultVisible();
    }

    public LiveData<i31.b> getMultiPkFinishEvent() {
        return this.pkMultiDataContext.m615getMultiPkFinishEvent();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public a getPkBeforeFinishData() {
        return this.pkMultiDataContext.getPkBeforeFinishData();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public j31.a getPkStartParam() {
        return this.pkMultiDataContext.getPkStartParam();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public int getPkUserCnt() {
        return this.pkMultiDataContext.getPkUserCnt();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public LiveData<List<af2.b>> getScoreState() {
        return this.pkMultiDataContext.getScoreState();
    }

    public LiveData<Boolean> getShowExtraResultAnim() {
        return this.pkMultiDataContext.m616getShowExtraResultAnim();
    }

    public LiveData<Boolean> getShowLastBattleResult() {
        return this.pkMultiDataContext.m617getShowLastBattleResult();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public Pair<List<String>, List<String>> getTeamPkUids4Finish() {
        return this.pkMultiDataContext.getTeamPkUids4Finish();
    }

    public NextLiveData<Boolean> getTeamTaskLayoutFocused() {
        return this.pkMultiDataContext.getTeamTaskLayoutFocused();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public String getTeamType() {
        return this.pkMultiDataContext.getTeamType();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public Map<String, Long> getUserIdToTeamId() {
        return this.pkMultiDataContext.getUserIdToTeamId();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public HashMap<String, Integer> getUserRoleMap() {
        return this.pkMultiDataContext.getUserRoleMap();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public void handleBattleBgImage(v9 r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.pkMultiDataContext.handleBattleBgImage(r2);
    }

    public void handleUserLeave(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "leaveUser");
        this.pkMultiDataContext.handleUserLeave(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public boolean isAnchorLinkFinisher() {
        return this.pkMultiDataContext.isAnchorLinkFinisher();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public boolean isOnceMore() {
        return this.pkMultiDataContext.isOnceMore();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public boolean isPkLauncher() {
        return this.pkMultiDataContext.isPkLauncher();
    }

    public boolean isVotePk() {
        return this.pkMultiDataContext.isVotePk();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public void notifyPkContext(r r2, boolean r3) {
        this.pkMultiDataContext.notifyPkContext(r2, r3);
    }

    public void reCreatePkStartParam() {
        this.pkMultiDataContext.reCreatePkStartParam();
    }

    public void removeRankUpdateInterceptor(d r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        this.pkMultiDataContext.removeRankUpdateInterceptor(r2);
    }

    public void requestUpdateRank() {
        this.pkMultiDataContext.requestUpdateRank();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public void setAnchorLinkFinisher(boolean r2) {
        this.pkMultiDataContext.setAnchorLinkFinisher(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public void setPkLauncher(boolean r2) {
        this.pkMultiDataContext.setPkLauncher(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public void updateAudioPunishInfo(z r2) {
        Intrinsics.checkNotNullParameter(r2, "audioPunishInfo");
        this.pkMultiDataContext.updateAudioPunishInfo(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b
    public Pair<List<String>, List<String>> getTeamPkUids() {
        return this.pkMultiDataContext.getTeamPkUids();
    }

    public boolean isMultiBreakThrough() {
        return this.pkMultiDataContext.isMultiBreakThrough();
    }

    @Override // p11.g
    public boolean isMultiPk() {
        return this.pkMultiDataContext.isMultiPk();
    }

    public MultiPKServiceProxyDataContext(PkMultiDataContext r2) {
        Intrinsics.checkNotNullParameter(r2, "pkMultiDataContext");
        this.pkMultiDataContext = r2;
    }

    public void launchVoteRulePage(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "secAnchorId");
        Intrinsics.checkNotNullParameter(r4, "source");
        this.pkMultiDataContext.launchVoteRulePage(r2, r3, r4);
    }
}
