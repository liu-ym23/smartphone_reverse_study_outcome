package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revlink.impl.pk.ui.PKRankUnlockView;
import com.bytedance.android.live.revlink.impl.pk.ui.PkRandomView;
import com.bytedance.android.livesdk.link.model.s8;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/s8;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/s8;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class RevLinkAnchorListFragment$handleRankSeasonUpdate$render$2 extends FunctionReferenceImpl implements Function1<s8, Unit> {
    public RevLinkAnchorListFragment$handleRankSeasonUpdate$render$2(RevLinkAnchorListFragment r8) {
        super(1, r8, RevLinkAnchorListFragment.class, "updateForRankUserList", "updateForRankUserList(Lcom/bytedance/android/livesdk/link/model/IRivalRankSeasonInfo;)V", 0);
    }

    public final void invoke(s8 r8) {
        RevLinkAnchorListFragment r0 = (RevLinkAnchorListFragment) ((CallableReference) this).receiver;
        int r1 = RevLinkAnchorListFragment.F;
        LinearLayout r2 = (LinearLayout) r0.S90(2131362585);
        if (r2 == null) goto L5;
        UtilityKotlinExtentionsKt.z(r2, true);
    L5:
        PKRankUnlockView r3 = (PKRankUnlockView) r0.S90(2131362602);
        if (r3 == null) goto L8;
        UtilityKotlinExtentionsKt.z(r3, false);
    L8:
        ConstraintLayout r4 = (PkRandomView) r0.S90(2131382360);
        if (r4 == null) goto L11;
        UtilityKotlinExtentionsKt.z(r4, false);
    L11:
        FrameLayout r5 = (FrameLayout) r0.S90(2131382361);
        r5.removeAllViews();
        r5.setVisibility(0);
        Context r6 = r0.getContext();
        if (r6 == null) goto L28;
        b51.b r7 = b51.b.c0;
        r7.getClass();
        final String r9 = (String) b51.b.f.getValue(r7, b51.b.a[4]);
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r10 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(r6, null, new RevLinkAnchorListFragment$loadRankRandomMatch$1(r9));
        if (r10 == null) goto L26;
        zy0.b r12 = r0.l;
        if (r12 == null) goto L19;
        r12.dispose();
    L19:
        r0.l = r10;
        r5.removeAllViews();
        r5.addView(r10.d, new ViewGroup.LayoutParams(-1, -1));
        HashMap r13 = new HashMap();
        if (r8 == null) goto L22;
        r13.put("rank_season_info", com.bytedance.android.annie.api.data.subscribe.d.c(r8));
    L22:
        xy0.a<?> r14 = r10.g();
        if (r14 == null) goto L27;
        ((com.bytedance.android.live.revenue.platform.hybrid.impl.component.b) r14).load(r9, r13);
        return;
    L27:
        return;
    L26:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((s8) r1);
        return Unit.INSTANCE;
    }
}
