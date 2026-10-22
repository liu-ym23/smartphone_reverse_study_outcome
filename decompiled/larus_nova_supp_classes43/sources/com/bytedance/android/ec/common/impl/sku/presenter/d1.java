package com.bytedance.android.ec.common.impl.sku.presenter;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuDiscountDescText;
import com.bytedance.android.ec.common.impl.sku.model.SkuDiscountInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuInstallmentItemInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuTermInfo;
import com.bytedance.android.ec.core.widget.PriceView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.sku.DisplayConfig;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d1<T> implements Observer {
    public final /* synthetic */ f1 a;

    public d1(f1 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r22) {
        SkuInfoVO r0 = (SkuInfoVO) r22;
        DisplayConfig r10 = r0.getDisplayConfig();
        ECUrlModel r11 = null;
        if (r10 == null) goto L5;
        Boolean r12 = r10.getShowPrice();
    L6:
        int r13 = 4;
        if (Intrinsics.areEqual(r12, Boolean.FALSE) == false) goto L9;
        this.a.Z().b(2131384715).f().setVisibility(4);
        this.a.Z().b(2131391453).f().setVisibility(4);
    L10:
        final f1 r14 = this.a;
        DisplayConfig r15 = r0.getDisplayConfig();
        if (r15 == null) goto L13;
        Boolean r16 = r15.getShowDetailEnter();
    L14:
        Boolean r17 = Boolean.TRUE;
        if (Intrinsics.areEqual(r16, r17) == false) goto L22;
        SkuViewModel r18 = r14.f;
        if (r18 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L20:
        if (cg4.a.a(r18.getSkuParams().getDetailUrl()) == false) goto L22;
        final View r19 = r14.Z().b(2131378870).f();
        r19.setVisibility(0);
        com.bytedance.android.ec.core.widget.f.c(r19, null, null, new HeaderPresenter$showDetailEnter$$inlined$apply$lambda$1(r19, r14), 3);
    L23:
        this.a.g = r0.isInSecKillDefault();
        this.a.h = r0.isInDepositPresaleDefault();
        int r20 = qf.a.a;
        if (qf.a.e.a(f1.e0(this.a).getSkuParams()) == true) goto L26;
        this.a.l0(null);
        f1.i0(this.a);
        com.bytedance.android.ec.core.utils.y.d(this.a.Z().b(2131385283).f(), r0.getCover());
    L26:
        TextView r21 = (TextView) this.a.Z().b(2131391453).f();
        SkuInstallmentItemInfo r23 = r0.getInstallmentInfo();
        if (r23 == null) goto L75;
        SkuDiscountInfo r24 = r23.getDiscountInfo();
        if (r24 == null) goto L75;
        if (Intrinsics.areEqual(r24.getShowFlag(), r17) == false) goto L71;
        SkuDiscountDescText r110 = r24.getDescText();
        if (r110 == null) goto L35;
        String r111 = r110.getText();
    L37:
        if (cg4.a.a(r111) == false) goto L71;
        r21.setVisibility(0);
        r21.setText(f1.h0(this.a, r24.getDescText()));
        ((TextView) this.a.Z().b(2131391470).f()).setVisibility(4);
        SkuViewModel.doSkuEventAction$default(f1.e0(this.a), "show_fxh_campaign_sku", new Pair[0], null, null, null, 28, null);
        String r25 = r24.getActivityType();
        if (r25 != null) goto L41;
        String r112 = "";
    L42:
        String r26 = r24.getDiscountDesc();
        if (r26 != null) goto L45;
        String r113 = "";
    L46:
        SkuViewModel r114 = f1.e0(this.a);
        SkuInstallmentItemInfo r27 = r0.getInstallmentInfo();
        if (r27 == null) goto L51;
        SkuTermInfo r28 = r27.getTermInfo();
        if (r28 == null) goto L51;
        String r29 = r28.getPlanNo();
    L52:
        String r115 = jg.g.c(r29);
        SkuInstallmentItemInfo r30 = r0.getInstallmentInfo();
        if (r30 == null) goto L57;
        SkuTermInfo r31 = r30.getTermInfo();
        if (r31 == null) goto L57;
        String r32 = r31.getMaterialNo();
    L58:
        String r116 = jg.g.c(r32);
        SkuInstallmentItemInfo r33 = r0.getInstallmentInfo();
        if (r33 == null) goto L63;
        SkuTermInfo r34 = r33.getTermInfo();
        if (r34 == null) goto L63;
        String r35 = r34.getResourceNo();
    L64:
        String r117 = jg.g.c(r35);
        SkuInstallmentItemInfo r36 = r0.getInstallmentInfo();
        if (r36 == null) goto L69;
        SkuTermInfo r37 = r36.getTermInfo();
        if (r37 == null) goto L69;
        String r38 = r37.getBizType();
    L70:
        r114.doSkuEventActionNew("product_params_campaign_show", r113, r112, r115, r116, r117, jg.g.c(r38), new Pair[0]);
    L79:
        ECUrlModel r39 = r0.getAtmosphereBackground();
        if (r39 != null) goto L82;
    L91:
        this.a.Z().b(2131385280).f().setVisibility(8);
        this.a.a0().setPadding(0, vf4.a.b(16), 0, 0);
    L93:
        if (r0.getDiscountPriceStyleType() != 0) goto L100;
        this.a.a0().post(new b1(this));
        ((ImageView) this.a.Z().b(2131376615).f()).setVisibility(0);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L97
        ((TextView) this.a.Z().b(2131391448).f()).setTextColor(Color.parseColor("#FFFFFFFF"));     // Catch: Throwable -> L97
        ((PriceView) this.a.Z().b(2131391447).f()).setPriceTextColor(Color.parseColor("#FFFFFFFF"));     // Catch: Throwable -> L97
        ((PriceView) this.a.Z().b(2131391447).f()).setExtraTextColor(Color.parseColor("#FFFFFFFF"));     // Catch: Throwable -> L97
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L97
        return;
    L97:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L100:
        if (r0.getDiscountPriceStyleType() != 1) goto L112;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L103
        ((TextView) this.a.Z().b(2131391448).f()).setTextColor(Color.parseColor("#FFFE2C55"));     // Catch: Throwable -> L103
        ((PriceView) this.a.Z().b(2131391447).f()).setPriceTextColor(Color.parseColor("#FFFE2C55"));     // Catch: Throwable -> L103
        ((PriceView) this.a.Z().b(2131391447).f()).setExtraTextColor(Color.parseColor("#FFFE2C55"));     // Catch: Throwable -> L103
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L103
    L105:
        ((ImageView) this.a.Z().b(2131376615).f()).setVisibility(8);
        this.a.a0().post(new c1(this));
        return;
    L103:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L105
    L112:
        return;
    L82:
        if (r39.getWidth() > 0) goto L84;
    L86:
        boolean r43 = false;
    L87:
        if (r43 == false) goto L89;
        r11 = r39;
    L89:
        if (r11 == null) goto L91;
        SimpleDraweeView r44 = this.a.Z().b(2131385280).f();
        r44.setVisibility(0);
        r44.getLayoutParams().height = (this.a.a0().getWidth() * r11.getHeight()) / r11.getWidth();
        com.bytedance.android.ec.core.utils.y.a(r44, r11);
        this.a.a0().setPadding(0, 0, 0, 0);
        goto L93
    L84:
        if (r39.getHeight() <= 0) goto L86;
        r43 = true;
    L69:
        r38 = null;
    L63:
        r35 = null;
    L57:
        r32 = null;
    L51:
        r29 = null;
        goto L52
    L45:
        r113 = r26;
        goto L46
    L41:
        r112 = r25;
        goto L42
    L35:
        r111 = null;
    L71:
        r21.setVisibility(8);
        TextView r45 = (TextView) this.a.Z().b(2131391470).f();
        if (r0.getShowStock() == false) goto L74;
        r13 = 0;
    L74:
        r45.setVisibility(r13);
    L75:
        r21.setVisibility(8);
        TextView r46 = (TextView) this.a.Z().b(2131391470).f();
        if (r0.getShowStock() == false) goto L78;
        r13 = 0;
    L78:
        r46.setVisibility(r13);
    L22:
        r14.Z().b(2131378870).f().setVisibility(8);
        goto L23
    L13:
        r16 = null;
        goto L14
    L9:
        this.a.Z().b(2131384715).f().setVisibility(0);
        this.a.Z().b(2131391453).f().setVisibility(0);
        goto L10
    L5:
        r12 = null;
        goto L6
    }
}
