package com.bytedance.android.ec.common.impl.sku.presenter;

import android.widget.TextView;
import com.bytedance.android.ec.common.impl.sku.model.SkuDiscountDescText;
import com.bytedance.android.ec.common.impl.sku.model.SkuDiscountInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuInstallmentItemInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuTermInfoItem;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u0<T> implements Observer {
    public final /* synthetic */ f1 a;

    public u0(f1 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        SkuTermInfoItem r11 = (SkuTermInfoItem) r10;
        String r12 = null;
        if (r11 != null) goto L31;
        QLiveData<SkuInfoVO> r13 = f1.e0(this.a).getSkuInfo();
        if (r13 == null) goto L11;
        SkuInfoVO r14 = (SkuInfoVO) r13.a();
        if (r14 == null) goto L11;
        SkuInstallmentItemInfo r15 = r14.getInstallmentInfo();
        if (r15 == null) goto L11;
        SkuDiscountInfo r16 = r15.getDiscountInfo();
    L12:
        if (r16 == null) goto L14;
        Boolean r17 = r16.getShowFlag();
    L16:
        if (Intrinsics.areEqual(r17, Boolean.TRUE) == false) goto L24;
        if (r16 == null) goto L22;
        SkuDiscountDescText r18 = r16.getDescText();
        if (r18 == null) goto L22;
        r12 = r18.getText();
    L22:
        if (cg4.a.a(r12) == false) goto L24;
        TextView r19 = (TextView) this.a.Z().b(2131391453).f();
        r19.setText(f1.h0(this.a, r16.getDescText()));
        r19.setVisibility(0);
        this.a.Z().b(2131391470).f().setVisibility(4);
        return;
    L24:
        QLiveData<SkuInfoVO> r20 = f1.e0(this.a).getSkuInfo();
        if (r20 == null) goto L39;
        SkuInfoVO r21 = (SkuInfoVO) r20.a();
        if (r21 != null) goto L29;
        return;
    L29:
        if (r21.getShowStock() != true) goto L41;
        TextView r22 = (TextView) this.a.Z().b(2131391470).f();
        r22.setText(this.a.i);
        r22.setVisibility(0);
        this.a.Z().b(2131391453).f().setVisibility(8);
        return;
    L41:
        return;
    L39:
        return;
    L14:
        r17 = null;
    L11:
        r16 = null;
        goto L12
    L31:
        SkuDiscountDescText r23 = r11.getDescText();
        if (r23 == null) goto L35;
        r12 = r23.getText();
    L35:
        if (cg4.a.a(r12) == false) goto L43;
        TextView r24 = (TextView) this.a.Z().b(2131391453).f();
        r24.setVisibility(0);
        r24.setText(f1.h0(this.a, r11.getDescText()));
        this.a.Z().b(2131391470).f().setVisibility(4);
        return;
    }
}
