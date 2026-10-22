package com.bytedance.android.ec.common.impl.sku.presenter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuLimit;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.api.accessibility.AccessibilityDelegateCompatImpl;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d0 extends QFragmentPresenter implements View.OnClickListener {
    public SkuViewModel f;

    public d0(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
    }

    public static final void d0(d0 r10) {
        SkuViewModel r0 = r10.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        long r11 = r0.getCurrentCount();
        SkuViewModel r1 = r10.f;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        if (r11 >= r1.getLowerLimit()) goto L14;
        SkuViewModel r12 = r10.f;
        if (r12 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        long r13 = r12.getLowerLimit();
    L33:
        r10.Z().b(2131376618).f().setVisibility(0);
        r10.Z().b(2131376619).f().setVisibility(0);
        ((TextView) r10.Z().b(2131391462).f()).setText(String.valueOf(r13));
        ImageView r14 = (ImageView) r10.Z().b(2131376618).f();
        SkuViewModel r15 = r10.f;
        if (r15 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        if (r13 > r15.getLowerLimit()) goto L39;
        int r16 = 2131248181;
    L40:
        r14.setImageResource(r16);
        ImageView r17 = (ImageView) r10.Z().b(2131376619).f();
        SkuViewModel r18 = r10.f;
        if (r18 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L44:
        if (r13 < r18.getUpperLimit()) goto L46;
        int r19 = 2131248183;
    L47:
        r17.setImageResource(r19);
        SkuViewModel r20 = r10.f;
        if (r20 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L51:
        if (r13 == r20.getCurrentCount()) goto L60;
        SkuViewModel r21 = r10.f;
        if (r21 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L55:
        r21.setClickCountUnConsumed(true);
        SkuViewModel r22 = r10.f;
        if (r22 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L58:
        r22.m1027getCurrentCount().g(Long.valueOf(r13));
        return;
    L60:
        return;
    L46:
        r19 = 2131248182;
        goto L47
    L39:
        r16 = 2131248180;
        goto L40
    L14:
        SkuViewModel r23 = r10.f;
        if (r23 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        long r24 = r23.getCurrentCount();
        SkuViewModel r25 = r10.f;
        if (r25 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L21:
        if (r24 <= r25.getUpperLimit()) goto L29;
        SkuViewModel r26 = r10.f;
        if (r26 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        long r27 = r26.getLowerLimit();
        SkuViewModel r28 = r10.f;
        if (r28 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L28:
        r13 = RangesKt.coerceAtLeast(r27, r28.getUpperLimit());
        goto L33
    L29:
        SkuViewModel r29 = r10.f;
        if (r29 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L32:
        r13 = r29.getCurrentCount();
        goto L33
    }

    public final void b0(QModel r10) {
        this.f = (SkuViewModel) Y().g(SkuViewModel.class);
        Z().b(2131376619).f().setOnClickListener(this);
        View r11 = Z().b(2131376619).f();
        AccessibilityDelegateCompatImpl r0 = new AccessibilityDelegateCompatImpl(r11);
        r0.b = th.a.f(Y().c()).getString(2131896676);
        ViewCompat.setAccessibilityDelegate(r11, r0);
        Z().b(2131376618).f().setOnClickListener(this);
        View r12 = Z().b(2131376618).f();
        AccessibilityDelegateCompatImpl r1 = new AccessibilityDelegateCompatImpl(r12);
        r1.b = th.a.f(Y().c()).getString(2131896652);
        ViewCompat.setAccessibilityDelegate(r12, r1);
        SkuViewModel r13 = this.f;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r13.m1027getCurrentCount().b(ECQuickUtilKt.a(Y()), new y(this));
        SkuViewModel r14 = this.f;
        if (r14 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r14.m1031getUpperLimit().b(ECQuickUtilKt.a(Y()), new z(this));
        SkuViewModel r15 = this.f;
        if (r15 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        r15.m1029getLowerLimit().b(ECQuickUtilKt.a(Y()), new a0(this));
        SkuViewModel r16 = this.f;
        if (r16 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r16.getLimitText().b(ECQuickUtilKt.a(Y()), new b0(this));
        SkuViewModel r17 = this.f;
        if (r17 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        r17.getStockDesc().b(ECQuickUtilKt.a(Y()), new c0(this));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r25) {
        if (r25 != null) goto L5;
        return;
    L5:
        int r1 = r25.getId();
        if (r1 != 2131376619) goto L86;
        SkuViewModel r10 = this.f;
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L10:
        long r11 = r10.getCurrentCount();
        SkuViewModel r12 = this.f;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        if (r11 >= r12.getUpperLimit()) goto L54;
        SkuViewModel r13 = this.f;
        if (r13 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L18:
        r13.setClickCountUnConsumed(true);
        SkuViewModel r14 = this.f;
        if (r14 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L21:
        QLiveData<Long> r15 = r14.m1027getCurrentCount();
        SkuViewModel r16 = this.f;
        if (r16 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L24:
        r15.g(Long.valueOf(r16.getCurrentCount() + 1));
        SkuViewModel r17 = this.f;
        if (r17 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L27:
        SkuInfoVO r18 = (SkuInfoVO) r17.getSkuInfo().a();
        if (r18 == null) goto L30;
        Boolean r19 = r18.getHasGivenProduct();
    L32:
        if (Intrinsics.areEqual(r19, Boolean.TRUE) == false) goto L52;
        SkuViewModel r20 = this.f;
        if (r20 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L36:
        Long r21 = (Long) r20.m1027getCurrentCount().a();
        if (r21 == null) goto L39;
        Integer r22 = Integer.valueOf((int) r21.longValue());
    L40:
        SkuViewModel r23 = this.f;
        if (r23 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L43:
        SkuInfoVO r24 = (SkuInfoVO) r23.getSkuInfo().a();
        if (r24 == null) goto L48;
        Integer r26 = r24.getGivenProductStock();
        if (r26 == null) goto L48;
        Integer r27 = Integer.valueOf(r26.intValue() + 1);
    L50:
        if (Intrinsics.areEqual(r22, r27) == false) goto L52;
        String r28 = th.a.g(Y().c(), 2131914014);
        UIUtils.displayToast(Y().c(), r28);
    L53:
        int r29 = 1;
    L78:
        SkuViewModel r30 = this.f;
        if (r30 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L81:
        Pair[] r31 = new Pair[4];
        r31[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_NAME, "spec_num_plus");
        r31[1] = TuplesKt.to("toast_content", r28);
        r31[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_SUCCESS, String.valueOf(r29));
        SkuViewModel r32 = this.f;
        if (r32 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L84:
        r31[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r32.getComboId());
        SkuViewModel.doSkuEventAction$default(r30, "sku_panel_module_click", r31, null, null, null, 28, null);
        return;
    L48:
        r27 = null;
        goto L50
    L39:
        r22 = null;
    L52:
        r28 = null;
        goto L53
    L30:
        r19 = null;
        goto L32
    L54:
        SkuViewModel r33 = this.f;
        if (r33 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L57:
        SkuLimit r34 = (SkuLimit) r33.m1031getUpperLimit().a();
        if (r34 == null) goto L63;
        String r35 = r34.getToast();
        if (r35 == null) goto L63;
    L62:
        r28 = r35;
        SkuViewModel r36 = this.f;
        if (r36 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L71:
        if (r36.getSkuParams().isFromAnchorV3() == false) goto L73;
        String r37 = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL;
    L74:
        SkuViewModel r38 = this.f;
        if (r38 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L77:
        SkuViewModel.doSkuEventAction$default(r38, "livesdk_toast_show", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r37)}, null, null, null, 28, null);
        UIUtils.displayToast(Y().c(), r28);
        r29 = 0;
        goto L78
    L73:
        r37 = "live_room_sku";
    L63:
        Context r39 = Y().c();
        Object[] r40 = new Object[1];
        SkuViewModel r41 = this.f;
        if (r41 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L66:
        r40[0] = Long.valueOf(r41.getUpperLimit());
        r35 = th.a.h(r39, 2131914000, r40);
        goto L62
    L86:
        if (r1 != 2131376618) goto L134;
        SkuViewModel r42 = this.f;
        if (r42 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L90:
        long r43 = r42.getCurrentCount();
        SkuViewModel r44 = this.f;
        if (r44 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L94:
        if (r43 <= r44.getLowerLimit()) goto L105;
        SkuViewModel r45 = this.f;
        if (r45 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L98:
        r45.setClickCountUnConsumed(true);
        SkuViewModel r46 = this.f;
        if (r46 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L101:
        QLiveData<Long> r47 = r46.m1027getCurrentCount();
        SkuViewModel r48 = this.f;
        if (r48 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L104:
        r47.g(Long.valueOf(r48.getCurrentCount() - 1));
        int r49 = 1;
        String r50 = null;
    L125:
        SkuViewModel r51 = this.f;
        if (r51 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L128:
        Pair[] r52 = new Pair[4];
        r52[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_NAME, "spec_num_minus");
        r52[1] = TuplesKt.to("toast_content", r50);
        r52[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_SUCCESS, String.valueOf(r49));
        SkuViewModel r53 = this.f;
        if (r53 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L131:
        r52[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, r53.getComboId());
        SkuViewModel.doSkuEventAction$default(r51, "sku_panel_module_click", r52, null, null, null, 28, null);
        return;
    L105:
        SkuViewModel r54 = this.f;
        if (r54 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L108:
        SkuLimit r55 = (SkuLimit) r54.m1029getLowerLimit().a();
        if (r55 == null) goto L114;
        String r56 = r55.getToast();
        if (r56 == null) goto L114;
    L113:
        r50 = r56;
        UIUtils.displayToast(Y().c(), r50);
        r49 = 0;
    L114:
        SkuViewModel r57 = this.f;
        if (r57 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L118:
        if (r57.getLowerLimit() != 0) goto L120;
        r56 = Y().c().getString(2131914013);
        goto L113
    L120:
        Context r58 = Y().c();
        Object[] r59 = new Object[1];
        SkuViewModel r60 = this.f;
        if (r60 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L123:
        r59[0] = Long.valueOf(r60.getLowerLimit());
        r56 = th.a.h(r58, 2131914001, r59);
        goto L113
    }
}
