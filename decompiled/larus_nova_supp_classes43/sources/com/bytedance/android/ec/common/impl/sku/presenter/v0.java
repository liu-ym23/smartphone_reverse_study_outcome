package com.bytedance.android.ec.common.impl.sku.presenter;

import android.widget.TextView;
import com.bytedance.android.ec.common.impl.sku.model.SkuDiscountDescText;
import com.bytedance.android.ec.common.impl.sku.model.SkuDiscountInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuInstallmentItemInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuTermInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuTermInfoItem;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v0<T> implements Observer {
    public final /* synthetic */ f1 a;

    public v0(f1 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        SkuInstallmentItemInfo r11 = (SkuInstallmentItemInfo) r10;
        SkuDiscountDescText r12 = null;
        String r13 = null;
        r12 = null;
        if (f1.e0(this.a).getCurrentDouInstallmentItem().a() == null) goto L18;
        if (r11 == null) goto L12;
        SkuTermInfo r14 = r11.getTermInfo();
        if (r14 == null) goto L12;
        List<SkuTermInfoItem> r15 = r14.getItemList();
        if (r15 == null) goto L12;
        SkuTermInfoItem r16 = (SkuTermInfoItem) CollectionsKt.getOrNull(r15, f1.e0(this.a).getCurrentInstallmentIndex());
        if (r16 == null) goto L12;
        SkuDiscountDescText r17 = r16.getDescText();
    L13:
        if (r17 == null) goto L16;
        r13 = r17.getText();
    L16:
        if (cg4.a.a(r13) == false) goto L34;
        ((TextView) this.a.Z().b(2131391453).f()).setText(f1.h0(this.a, r17));
        return;
    L34:
        return;
    L12:
        r17 = null;
        goto L13
    L18:
        if (r11 == null) goto L24;
        SkuDiscountInfo r0 = r11.getDiscountInfo();
        if (r0 == null) goto L24;
        SkuDiscountDescText r1 = r0.getDescText();
        if (r1 == null) goto L24;
        String r18 = r1.getText();
    L26:
        if (cg4.a.a(r18) == false) goto L36;
        TextView r19 = (TextView) this.a.Z().b(2131391453).f();
        f1 r20 = this.a;
        if (r11 == null) goto L32;
        SkuDiscountInfo r21 = r11.getDiscountInfo();
        if (r21 == null) goto L32;
        r12 = r21.getDescText();
    L32:
        r19.setText(f1.h0(r20, r12));
        return;
    L36:
        return;
    L24:
        r18 = null;
        goto L26
    }
}
