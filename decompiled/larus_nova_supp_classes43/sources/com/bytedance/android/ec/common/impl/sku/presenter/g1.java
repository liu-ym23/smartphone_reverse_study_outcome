package com.bytedance.android.ec.common.impl.sku.presenter;

import android.widget.TextView;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuInstallmentItemInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuTermInfo;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g1<T> implements Observer {
    public final /* synthetic */ l1 a;

    public g1(l1 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        SkuInstallmentItemInfo r11 = (SkuInstallmentItemInfo) r10;
        l1 r0 = this.a;
        if (r11 == null) goto L9;
        SkuTermInfo r1 = r11.getTermInfo();
        if (r1 == null) goto L9;
        Boolean r12 = r1.getSelectable();
        if (r12 == null) goto L9;
        boolean r13 = r12.booleanValue();
    L10:
        r0.e0(r11, r13);
        Boolean r14 = null;
        if (r11 == null) goto L15;
        SkuTermInfo r15 = r11.getTermInfo();
        if (r15 == null) goto L15;
        Boolean r16 = r15.getSelectable();
    L17:
        if (Intrinsics.areEqual(r16, Boolean.FALSE) == false) goto L30;
        SkuViewModel r17 = this.a.f;
        if (r17 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L21:
        SkuInfoVO r18 = (SkuInfoVO) r17.getSkuInfo().a();
        if (r18 == null) goto L38;
        SkuInstallmentItemInfo r19 = r18.getInstallmentInfo();
        if (r19 == null) goto L39;
        SkuTermInfo r20 = r19.getTermInfo();
        if (r20 == null) goto L40;
        String r21 = r20.getCreditTip();
        if (r21 == null) goto L41;
        TextView r22 = (TextView) this.a.Z().b(2131391454).f();
        r22.setText(r21);
        r22.setVisibility(0);
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L30:
        if (r11 == null) goto L35;
        SkuTermInfo r23 = r11.getTermInfo();
        if (r23 == null) goto L35;
        r14 = r23.getSelectable();
    L35:
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == false) goto L43;
        this.a.Z().b(2131391454).f().setVisibility(8);
        return;
    L43:
        return;
    L15:
        r16 = null;
    L9:
        r13 = true;
        goto L10
    }
}
