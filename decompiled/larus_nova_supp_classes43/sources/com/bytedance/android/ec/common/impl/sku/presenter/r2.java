package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.View;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r2 implements View.OnClickListener {
    public final /* synthetic */ t2 a;

    public r2(t2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        t2.d0(this.a).setLastBehaviorBeforeDismiss("click");
        SkuViewModel.closeDialogFragment$default(t2.d0(this.a), null, 1, null);
    }
}
