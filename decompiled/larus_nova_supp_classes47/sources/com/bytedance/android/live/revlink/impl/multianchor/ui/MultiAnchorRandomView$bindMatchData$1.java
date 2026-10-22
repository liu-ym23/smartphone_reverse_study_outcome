package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.revlink.impl.constants.RandomMatchCheckSource;
import com.bytedance.android.live.revlink.impl.pk.randompkcheck.RandomCheckDataContext;
import com.bytedance.android.live.revlink.impl.pk.randompkcheck.RandomPKCheckFragment;
import com.bytedance.android.livesdk.link.model.b0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 5, 1})
final class MultiAnchorRandomView$bindMatchData$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ b0 $matchInfo;
    final /* synthetic */ MultiAnchorRandomView this$0;

    public MultiAnchorRandomView$bindMatchData$1(MultiAnchorRandomView r1, b0 r2) {
        this.this$0 = r1;
        this.$matchInfo = r2;
        super(1);
    }

    public final void invoke(View r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        MultiAnchorRandomView r9 = this.this$0;
        if (r9.i == true) goto L6;
        return;
    L6:
        if (r9.U5() == false) goto L9;
        this.this$0.T5(true);
        return;
    L9:
        if (RandomCheckDataContext.Companion.b() == true) goto L16;
        int r10 = RandomPKCheckFragment.m;
        RandomPKCheckFragment r12 = RandomPKCheckFragment.a.a(RandomMatchCheckSource.MultiPKUserListFragment, null, null, null, null, 30);
        FragmentActivity r0 = ContextUtil.contextToFragmentActivity(this.this$0.a.getContext());
        if (r0 == null) goto L23;
        FragmentManager r1 = r0.getSupportFragmentManager();
        if (r1 == null) goto L24;
        INVOKEVIRTUAL_com_bytedance_android_live_revlink_impl_multianchor_ui_MultiAnchorRandomView$bindMatchData$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r12, r1, "random_pk_check_fragment");
        return;
    L24:
        return;
    L23:
        return;
    L16:
        com.bytedance.android.live.revlink.impl.multianchor.match.a r2 = MultiAnchorRandomView.R5(this.this$0);
        if (r2 == null) goto L26;
        b0 r13 = MultiAnchorRandomView.S5(this.this$0);
        if (r13 != null) goto L21;
        r13 = this.$matchInfo;
    L21:
        com.bytedance.android.live.revlink.impl.multianchor.match.a.C0145a.a(r2, r13, 0, false, 0, new AnonymousClass2(this), 30);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_revlink_impl_multianchor_ui_MultiAnchorRandomView$bindMatchData$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(RandomPKCheckFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        RandomPKCheckFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
