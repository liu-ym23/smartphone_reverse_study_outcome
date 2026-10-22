package com.bytedance.android.ec.common.impl.sku.presenter;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.ec.common.impl.sku.view.SkuBenefitLabelGroupOptimizeLayout;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p0<T> implements Observer {
    public final /* synthetic */ s0 a;

    public p0(s0 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        List r11 = (List) r10;
        LinearLayout r0 = (LinearLayout) this.a.Z().b(2131368095).f();
        SkuBenefitLabelGroupOptimizeLayout r1 = (SkuBenefitLabelGroupOptimizeLayout) this.a.Z().b(2131378864).f();
        ImageView r12 = (ImageView) this.a.Z().b(2131376610).f();
        ((ArrayList) r1.b).clear();
        boolean r13 = true;
        if (r11 != null) goto L9;
        Iterator r14 = ((ArrayList) r1.a).iterator();
    L6:
        if (r14.hasNext() == false) goto L32;
        ((ArrayList) r1.b).add((PromotionBenefitLabel) r14.next());
    L32:
        r1.a();
        if (((ArrayList) r1.b).size() > 0) goto L36;
        r13 = false;
    L36:
        if (r13 == true) goto L38;
    L42:
        r0.setVisibility(8);
        r1.setVisibility(8);
        r12.setVisibility(8);
        return;
    L38:
        if (s0.e0(this.a).getSkuParams().isLiveSkuCheck() == false) goto L42;
        r0.setVisibility(0);
        r1.setVisibility(0);
        if (com.bytedance.android.ec.core.abtest.d.F() != 5) goto L55;
        r12.setVisibility(0);
        return;
    L55:
        return;
    L9:
        if (r11.isEmpty() == false) goto L20;
        Iterator r15 = ((ArrayList) r1.a).iterator();
    L12:
        if (r15.hasNext() == false) goto L32;
        PromotionBenefitLabel r16 = (PromotionBenefitLabel) r15.next();
        Map r17 = r16.getExtra();
        if (r17 == null) goto L16;
        String r18 = (String) r17.get("stickiness");
    L18:
        if ((!Intrinsics.areEqual(r18, "0")) == false) goto L12;
        ((ArrayList) r1.b).add(r16);
        goto L12
    L16:
        r18 = null;
        goto L18
    L20:
        List r19 = r11;
        if (r19.isEmpty() == true) goto L32;
        ((ArrayList) r1.b).addAll(r19);
        Iterator r110 = ((ArrayList) r1.a).iterator();
    L24:
        if (r110.hasNext() == false) goto L32;
        PromotionBenefitLabel r20 = (PromotionBenefitLabel) r110.next();
        Map r21 = r20.getExtra();
        if (r21 == null) goto L28;
        String r22 = (String) r21.get("stickiness");
    L30:
        if ((!Intrinsics.areEqual(r22, "0")) == false) goto L24;
        ((ArrayList) r1.b).add(r20);
        goto L24
    L28:
        r22 = null;
        goto L30
    }
}
