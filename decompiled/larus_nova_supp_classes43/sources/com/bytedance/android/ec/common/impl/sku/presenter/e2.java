package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.view.SpecItemGroupLayout;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e2<T> implements Observer {
    public final /* synthetic */ f2 a;

    public e2(f2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r13) {
        rg.a r14 = (rg.a) r13;
        f2 r15 = this.a;
        SkuViewModel r0 = r15.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuRestoreState r10 = r0.getSkuPanelState();
        if (r10 == null) goto L18;
        SpecItemGroupLayout r1 = r15.h;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("specItemGroupLayout");
    L10:
        String[] r11 = r1.getCheckedIdArray();
        SkuViewModel r12 = r15.f;
        if (r12 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        Long r16 = Long.valueOf(r12.getCurrentCount());
        SkuViewModel r17 = r15.f;
        if (r17 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        SkuRestoreState.saveSelectedSpec$default(r10, r11, r16, r17.getSelectedSkuId(), null, null, null, 0, 120, null);
        return;
    }
}
