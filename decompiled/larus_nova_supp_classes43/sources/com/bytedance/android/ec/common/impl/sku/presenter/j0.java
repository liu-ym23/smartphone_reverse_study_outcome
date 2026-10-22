package com.bytedance.android.ec.common.impl.sku.presenter;

import android.widget.LinearLayout;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.view.SkuBenefitLabelGroupLayout;
import com.bytedance.android.ec.core.widget.ECBenefitLabelView;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j0<T> implements Observer {
    public final /* synthetic */ k0 a;

    public j0(k0 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r12) {
        List r13 = (List) r12;
        SkuBenefitLabelGroupLayout r0 = (SkuBenefitLabelGroupLayout) this.a.Z().b(2131378864).f();
        int r1 = qf.a.a;
        SkuViewModel r10 = this.a.f;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        boolean r11 = true;
        if (qf.a.e.a(r10.getSkuParams()) == true) goto L38;
        ((ArrayList) r0.b).clear();
        if (r13 != null) goto L14;
        Iterator r14 = ((ArrayList) r0.a).iterator();
    L11:
        if (r14.hasNext() == false) goto L37;
        ((ArrayList) r0.b).add((PromotionBenefitLabel) r14.next());
    L37:
        r0.a();
    L96:
        if (((ArrayList) r0.b).size() > 0) goto L99;
        r11 = false;
    L99:
        if (r11 == false) goto L106;
        SkuViewModel r15 = this.a.f;
        if (r15 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L104:
        if (r15.getSkuParams().isLiveSkuCheck() == false) goto L106;
        this.a.a0().setVisibility(0);
        r0.setVisibility(0);
        return;
    L106:
        this.a.a0().setVisibility(8);
        r0.setVisibility(8);
        return;
    L14:
        if (r13.isEmpty() == false) goto L25;
        Iterator r16 = ((ArrayList) r0.a).iterator();
    L17:
        if (r16.hasNext() == false) goto L37;
        PromotionBenefitLabel r17 = (PromotionBenefitLabel) r16.next();
        Map r18 = r17.getExtra();
        if (r18 == null) goto L21;
        String r19 = (String) r18.get("stickiness");
    L23:
        if ((!Intrinsics.areEqual(r19, "0")) == false) goto L17;
        ((ArrayList) r0.b).add(r17);
        goto L17
    L21:
        r19 = null;
        goto L23
    L25:
        List r110 = r13;
        if (r110.isEmpty() == true) goto L37;
        ((ArrayList) r0.b).addAll(r110);
        Iterator r111 = ((ArrayList) r0.a).iterator();
    L29:
        if (r111.hasNext() == false) goto L37;
        PromotionBenefitLabel r20 = (PromotionBenefitLabel) r111.next();
        Map r21 = r20.getExtra();
        if (r21 == null) goto L33;
        String r22 = (String) r21.get("stickiness");
    L35:
        if ((!Intrinsics.areEqual(r22, "0")) == false) goto L29;
        ((ArrayList) r0.b).add(r20);
        goto L29
    L33:
        r22 = null;
        goto L35
    L38:
        ((ArrayList) r0.b).clear();
        if (r13 != null) goto L45;
        Iterator r112 = ((ArrayList) r0.a).iterator();
    L42:
        if (r112.hasNext() == false) goto L68;
        ((ArrayList) r0.b).add((PromotionBenefitLabel) r112.next());
    L68:
        Iterator r113 = ((ArrayList) r0.b).iterator();
        int r23 = 0;
    L70:
        if (r113.hasNext() == false) goto L89;
        PromotionBenefitLabel r24 = (PromotionBenefitLabel) r113.next();
        List r25 = com.bytedance.commerce.base.view.b.a(r0);
        if (r23 >= 0) goto L74;
    L76:
        ECBenefitLabelView r26 = new ECBenefitLabelView(r0.getContext(), null, 6, 0);
        r0.addView(r26);
        Object r27 = r26;
    L77:
        boolean r28 = r27 instanceof ECBenefitLabelView;
        Object r29 = r27;
        if (r28 == true) goto L80;
        r29 = null;
    L80:
        ECBenefitLabelView r30 = (ECBenefitLabelView) r29;
        if (r30 != null) goto L84;
        r30 = new ECBenefitLabelView(r0.getContext(), null, 6, 0);
        r0.addView(r30);
    L84:
        LinearLayout.LayoutParams r31 = new LinearLayout.LayoutParams(-2, vf4.a.b(Float.valueOf(20.0f)));
        if (r23 != 0) goto L87;
        r31.setMargins(0, 0, 0, 0);
    L88:
        r30.setLayoutParams(r31);
        r30.a(r24, null);
        r23 = r23 + 1;
        goto L70
    L87:
        r31.setMargins(vf4.a.b(Float.valueOf(8.0f)), 0, 0, 0);
        goto L88
    L74:
        if (r23 > CollectionsKt.getLastIndex(r25)) goto L76;
        r27 = ListProtector.get(r25, r23);
        goto L77
    L89:
        int r114 = com.bytedance.commerce.base.view.b.a(r0).size();
        int r32 = ((ArrayList) r0.b).size();
        if (r114 < r32) goto L96;
        int r33 = r32;
    L93:
        if (r33 >= r114) goto L96;
        r0.removeViewAt(r32);
        r33 = r33 + 1;
        goto L93
    L45:
        if (r13.isEmpty() == false) goto L56;
        Iterator r115 = ((ArrayList) r0.a).iterator();
    L48:
        if (r115.hasNext() == false) goto L68;
        PromotionBenefitLabel r34 = (PromotionBenefitLabel) r115.next();
        Map r35 = r34.getExtra();
        if (r35 == null) goto L52;
        String r36 = (String) r35.get("stickiness");
    L54:
        if ((!Intrinsics.areEqual(r36, "0")) == false) goto L48;
        ((ArrayList) r0.b).add(r34);
        goto L48
    L52:
        r36 = null;
        goto L54
    L56:
        List r116 = r13;
        if (r116.isEmpty() == true) goto L68;
        ((ArrayList) r0.b).addAll(r116);
        Iterator r117 = ((ArrayList) r0.a).iterator();
    L60:
        if (r117.hasNext() == false) goto L68;
        PromotionBenefitLabel r37 = (PromotionBenefitLabel) r117.next();
        Map r38 = r37.getExtra();
        if (r38 == null) goto L64;
        String r39 = (String) r38.get("stickiness");
    L66:
        if ((!Intrinsics.areEqual(r39, "0")) == false) goto L60;
        ((ArrayList) r0.b).add(r37);
        goto L60
    L64:
        r39 = null;
        goto L66
    }
}
