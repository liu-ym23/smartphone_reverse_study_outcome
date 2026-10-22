package com.bytedance.android.live.revlink.link.biz.component.switchscenecompact;

import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAnchorDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.b;
import com.bytedance.android.live.revlink.impl.pk.utils.l;
import com.bytedance.android.live.revlink.impl.pk.vm.pk.a;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.d4;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J1\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003H\u0096\u0001J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J3\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0015\u001a\u00020\tH\u0096\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0096\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0096\u0001J'\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0096\u0001J%\u0010!\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0001J=\u0010%\u001a\u00020\t2\b\b\u0002\u0010\"\u001a\u00020\u00102\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0096\u0001¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/revlink/link/biz/component/switchscenecompact/PKDoubleAnchorProxyDataContext;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/b;", "Lcom/bytedance/live/datacontext/DataContext;", "", "isCutShort", "", "reason", "isFinisher", "isRoomClose", "", "finishBattle", "Lcom/bytedance/android/livesdk/link/model/p0;", "getLaunchBattleAttachedInfo", "inviteType", "Lcom/bytedance/android/livesdk/link/model/w2;", "battleShellConfig", "", "stayDuration", "Lcom/bytedance/android/live/revlink/impl/pk/utils/l;", "pageSource", "inviteBattle", "logGameConnectionSuccess", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleAnchorDataContext$BattleOpenSource;", "requestSource", "pkBizOptOpenBattle", "pkOptOpenBattle", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/a;", "battleInviteParam", "startBattleInvite", "isOnceMore", "startBreakThroughInvite", "Lcom/bytedance/android/livesdk/link/model/d4;", "customConfig", "startCustomizePlay", "durationTime", "Lcom/bytedance/android/livesdk/link/model/aa;", "voteData", "startVoteBattleInvite", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleAnchorDataContext;", "anchorDoubleDataContext", "<init>", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleAnchorDataContext;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKDoubleAnchorProxyDataContext extends DataContext implements b {
    private final /* synthetic */ PkDoubleAnchorDataContext $$delegate_0;

    public void finishBattle(boolean r2, int r3, boolean r4, boolean r5) {
        this.$$delegate_0.finishBattle(r2, r3, r4, r5);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.b
    public p0 getLaunchBattleAttachedInfo() {
        return this.$$delegate_0.getLaunchBattleAttachedInfo();
    }

    public void inviteBattle(int r8, w2 r9, long r10, l r12) {
        Intrinsics.checkNotNullParameter(r12, "pageSource");
        this.$$delegate_0.inviteBattle(r8, r9, r10, r12);
    }

    public void logGameConnectionSuccess() {
        this.$$delegate_0.logGameConnectionSuccess();
    }

    public void pkBizOptOpenBattle(PkDoubleAnchorDataContext.BattleOpenSource r2) {
        Intrinsics.checkNotNullParameter(r2, "requestSource");
        this.$$delegate_0.pkBizOptOpenBattle(r2);
    }

    public void pkOptOpenBattle(PkDoubleAnchorDataContext.BattleOpenSource r2) {
        Intrinsics.checkNotNullParameter(r2, "requestSource");
        this.$$delegate_0.pkOptOpenBattle(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.b
    public void startBattleInvite(a r2) {
        Intrinsics.checkNotNullParameter(r2, "battleInviteParam");
        this.$$delegate_0.startBattleInvite(r2);
    }

    public void startBreakThroughInvite(boolean r2, long r3, l r5) {
        Intrinsics.checkNotNullParameter(r5, "pageSource");
        this.$$delegate_0.startBreakThroughInvite(r2, r3, r5);
    }

    public void startCustomizePlay(d4 r2, long r3, l r5) {
        Intrinsics.checkNotNullParameter(r5, "pageSource");
        this.$$delegate_0.startCustomizePlay(r2, r3, r5);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.b
    public void startVoteBattleInvite(long r10, aa r12, boolean r13, long r14, l r16) {
        Intrinsics.checkNotNullParameter(r16, "pageSource");
        this.$$delegate_0.startVoteBattleInvite(r10, r12, r13, r14, r16);
    }

    public PKDoubleAnchorProxyDataContext(PkDoubleAnchorDataContext r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorDoubleDataContext");
        this.$$delegate_0 = r2;
    }
}
