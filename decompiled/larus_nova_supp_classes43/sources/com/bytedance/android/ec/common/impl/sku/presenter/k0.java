package com.bytedance.android.ec.common.impl.sku.presenter;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.view.SkuBenefitLabelGroupLayout;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k0 extends QFragmentPresenter {
    public SkuViewModel f;
    public boolean g;

    public k0(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
    }

    public final void b0(QModel r10) {
        this.f = (SkuViewModel) Y().g(SkuViewModel.class);
        if (this.g == true) goto L19;
        this.g = true;
        Z().b(2131378864).f().setVisibility(0);
        SkuViewModel r1 = this.f;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L7:
        List r11 = r1.getSkuParams().getBenefitLabels();
        if (r11 == null) goto L19;
        if ((true ^ r11.isEmpty()) == true) goto L13;
        r11 = null;
    L13:
        if (r11 == null) goto L19;
        SkuBenefitLabelGroupLayout r12 = (SkuBenefitLabelGroupLayout) Z().b(2131378864).f();
        Intrinsics.checkNotNullParameter(r11, "benefitLabelList");
        ((ArrayList) r12.a).clear();
        ((ArrayList) r12.b).clear();
        Iterator r13 = r11.iterator();
    L16:
        if (r13.hasNext() == false) goto L18;
        PromotionBenefitLabel r14 = (PromotionBenefitLabel) r13.next();
        ((ArrayList) r12.a).add(r14);
        ((ArrayList) r12.b).add(r14);
        goto L16
    L18:
        r12.a();
        com.bytedance.android.ec.core.widget.f.c(a0(), null, null, new CouponPresenter$initViews$$inlined$apply$lambda$1(this), 3);
    L19:
        SkuViewModel r15 = this.f;
        if (r15 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        r15.getCurrentBenefitLabel().b(ECQuickUtilKt.a(Y()), new j0(this));
    }
}
