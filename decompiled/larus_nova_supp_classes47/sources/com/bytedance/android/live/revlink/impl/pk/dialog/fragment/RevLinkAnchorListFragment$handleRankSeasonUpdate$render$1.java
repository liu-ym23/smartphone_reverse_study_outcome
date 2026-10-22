package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revlink.impl.pk.ui.PKRankUnlockView;
import com.bytedance.android.livesdk.link.model.s8;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/s8;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/s8;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class RevLinkAnchorListFragment$handleRankSeasonUpdate$render$1 extends FunctionReferenceImpl implements Function1<s8, Unit> {
    public RevLinkAnchorListFragment$handleRankSeasonUpdate$render$1(RevLinkAnchorListFragment r8) {
        super(1, r8, RevLinkAnchorListFragment.class, "updateForNoRank", "updateForNoRank(Lcom/bytedance/android/livesdk/link/model/IRivalRankSeasonInfo;)V", 0);
    }

    public final void invoke(s8 r3) {
        RevLinkAnchorListFragment r4 = (RevLinkAnchorListFragment) ((CallableReference) this).receiver;
        int r0 = RevLinkAnchorListFragment.F;
        LinearLayout r1 = (LinearLayout) r4.S90(2131362585);
        if (r1 == null) goto L5;
        UtilityKotlinExtentionsKt.z(r1, true);
    L5:
        PKRankUnlockView r2 = (PKRankUnlockView) r4.S90(2131362602);
        if (r2 == null) goto L8;
        UtilityKotlinExtentionsKt.z(r2, false);
    L8:
        FrameLayout r5 = (FrameLayout) r4.S90(2131382361);
        if (r5 == null) goto L12;
        UtilityKotlinExtentionsKt.z(r5, false);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((s8) r1);
        return Unit.INSTANCE;
    }
}
