package com.ss.android.lark.mention.base.impl.atselector.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.widget.quick_sidebar.QuickSideBarTipsView;
import com.ss.android.lark.widget.quick_sidebar.tipsview.QuickSideBarTipsItemView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements ydc.a {
    public final /* synthetic */ AtView a;

    public j(AtView r1) {
        this.a = r1;
    }

    public final void b(boolean r2) {
        QuickSideBarTipsView r0 = this.a.mQuickSideBarTipView;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 4;
        goto L6
    }

    public final void a(String r11, float r12) {
        AtView r0 = this.a;
        QuickSideBarTipsView r1 = r0.mQuickSideBarTipView;
        float r13 = r12 - UIUtils.dp2px(r0.b, 40.0f);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r11, "text");
        QuickSideBarTipsItemView r2 = r1.a;
        View r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTipsView");
        r2 = null;
    L5:
        r2.setText(r11);
        View r4 = r1.a;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTipsView");
        r4 = null;
    L8:
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r6 = (RelativeLayout.LayoutParams) r5;
        r6.topMargin = (int) (((double) r13) - (((double) r1.getWidth()) / 2.8d));
        View r14 = r1.a;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mTipsView");
    L12:
        r3.setLayoutParams(r6);
        if (this.a.g.containsKey(r11) == false) goto L16;
        this.a.mRecommendRecyclerView.getLayoutManager().scrollToPositionWithOffset(this.a.g.get(r11).intValue(), 0);
        return;
    L16:
        return;
    L11:
        r3 = r14;
        goto L12
    }
}
