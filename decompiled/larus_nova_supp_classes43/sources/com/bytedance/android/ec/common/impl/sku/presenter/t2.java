package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.core.data.ActionObserver;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.widget.StatusView;
import com.bytedance.android.shopping.api.accessibility.AccessibilityDelegateCompatImpl;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t2 extends QFragmentPresenter {
    public SkuViewModel f;

    public t2(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
    }

    public static final /* synthetic */ SkuViewModel d0(t2 r1) {
        SkuViewModel r10 = r1.f;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r10;
    }

    public final void b0(QModel r10) {
        this.f = (SkuViewModel) Y().g(SkuViewModel.class);
        View r11 = Z().b(2131376612).f();
        AccessibilityDelegateCompatImpl r1 = new AccessibilityDelegateCompatImpl(r11);
        r1.b = "关闭";
        ViewCompat.setAccessibilityDelegate(r11, r1);
        Z().b(2131376612).f().setOnClickListener(new r2(this));
        SkuViewModel r12 = this.f;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r12.getDisplayToast().b(ECQuickUtilKt.a(Y()), new ActionObserver(new SkuPanelGroupPresenter$initSubscribe$1(this)));
        SkuViewModel r13 = this.f;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r13.getSkuInfo().b(ECQuickUtilKt.a(Y()), new q2(this));
        StatusView r14 = (StatusView) Z().b(2131387797).f();
        View r15 = th.a.c(Y().c(), 2131564775, r14, false);
        r15.findViewById(2131391461).setOnClickListener(new o2(this));
        ImageView r16 = new ImageView(r14.getContext());
        r16.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r16.setBackgroundResource(2131248078);
        r14.b(r16, r15, false);
        SkuViewModel r17 = this.f;
        if (r17 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        r17.getLoadStatus().b(ECQuickUtilKt.a(Y()), new p2(this));
        int r18 = jg.f.a;
        SkuViewModel r19 = this.f;
        if (r19 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L15:
        if (jg.f.a(r19) == false) goto L22;
        SkuViewModel r20 = this.f;
        if (r20 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L20:
        r20.getLoadStatus().b(Y().e(), new s2(this));
        return;
    }
}
