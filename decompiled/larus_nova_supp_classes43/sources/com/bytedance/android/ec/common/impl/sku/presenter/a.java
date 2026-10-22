package com.bytedance.android.ec.common.impl.sku.presenter;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends QFragmentPresenter {
    public SkuViewModel f;

    /* JADX INFO: renamed from: com.bytedance.android.ec.common.impl.sku.presenter.a$a, reason: collision with other inner class name */
    public static final class C0120a {
    }

    static {
    }

    public a(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
    }

    public final void b0(QModel r10) {
        SkuViewModel r11 = (SkuViewModel) Y().g(SkuViewModel.class);
        this.f = r11;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r11.getSkuInfo().b(ECQuickUtilKt.a(Y()), new c(this));
    }
}
