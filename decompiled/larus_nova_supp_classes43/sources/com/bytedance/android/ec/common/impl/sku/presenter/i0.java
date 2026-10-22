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
public final class i0 extends QFragmentPresenter implements View.OnClickListener {
    public SkuViewModel f;

    public i0(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
    }

    public static final void d0(i0 r10) {
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
        int r16 = 2131248079;
    L40:
        r14.setImageResource(r16);
        ImageView r17 = (ImageView) r10.Z().b(2131376619).f();
        SkuViewModel r18 = r10.f;
        if (r18 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L44:
        if (r13 < r18.getUpperLimit()) goto L46;
        int r19 = 2131248080;
    L47:
        r17.setImageResource(r19);
        SkuViewModel r20 = r10.f;
        if (r20 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L51:
        if (r13 == r20.getCurrentCount()) goto L57;
        SkuViewModel r21 = r10.f;
        if (r21 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L55:
        r21.m1027getCurrentCount().g(Long.valueOf(r13));
        return;
    L57:
        return;
    L46:
        r19 = 2131248077;
        goto L47
    L39:
        r16 = 2131248076;
        goto L40
    L14:
        SkuViewModel r22 = r10.f;
        if (r22 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        long r23 = r22.getCurrentCount();
        SkuViewModel r24 = r10.f;
        if (r24 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L21:
        if (r23 <= r24.getUpperLimit()) goto L29;
        SkuViewModel r25 = r10.f;
        if (r25 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        long r26 = r25.getLowerLimit();
        SkuViewModel r27 = r10.f;
        if (r27 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L28:
        r13 = RangesKt.coerceAtLeast(r26, r27.getUpperLimit());
        goto L33
    L29:
        SkuViewModel r28 = r10.f;
        if (r28 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L32:
        r13 = r28.getCurrentCount();
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
        r13.m1027getCurrentCount().b(ECQuickUtilKt.a(Y()), new e0(this));
        SkuViewModel r14 = this.f;
        if (r14 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r14.m1031getUpperLimit().b(ECQuickUtilKt.a(Y()), new f0(this));
        SkuViewModel r15 = this.f;
        if (r15 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        r15.m1029getLowerLimit().b(ECQuickUtilKt.a(Y()), new g0(this));
        SkuViewModel r16 = this.f;
        if (r16 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r16.getLimitText().b(ECQuickUtilKt.a(Y()), new h0(this));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        int r16 = r15.getId();
        if (r16 != 2131376619) goto L70;
        SkuViewModel r17 = this.f;
        if (r17 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        long r10 = r17.getCurrentCount();
        SkuViewModel r18 = this.f;
        if (r18 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        if (r10 >= r18.getUpperLimit()) goto L47;
        SkuViewModel r19 = this.f;
        if (r19 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        QLiveData<Long> r110 = r19.m1027getCurrentCount();
        SkuViewModel r0 = this.f;
        if (r0 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L20:
        r110.g(Long.valueOf(r0.getCurrentCount() + 1));
        SkuViewModel r111 = this.f;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L23:
        SkuInfoVO r112 = (SkuInfoVO) r111.getSkuInfo().a();
        Integer r1 = null;
        if (r112 == null) goto L26;
        Boolean r113 = r112.getHasGivenProduct();
    L28:
        if (Intrinsics.areEqual(r113, Boolean.TRUE) == false) goto L99;
        SkuViewModel r114 = this.f;
        if (r114 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L32:
        Long r115 = (Long) r114.m1027getCurrentCount().a();
        if (r115 == null) goto L35;
        Integer r116 = Integer.valueOf((int) r115.longValue());
    L36:
        SkuViewModel r11 = this.f;
        if (r11 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L39:
        SkuInfoVO r12 = (SkuInfoVO) r11.getSkuInfo().a();
        if (r12 == null) goto L45;
        Integer r13 = r12.getGivenProductStock();
        if (r13 == null) goto L45;
        r1 = Integer.valueOf(r13.intValue() + 1);
    L45:
        if (Intrinsics.areEqual(r116, r1) == false) goto L100;
        UIUtils.displayToast(Y().c(), 2131914014);
        return;
    L100:
        return;
    L35:
        r116 = null;
        goto L36
    L99:
        return;
    L26:
        r113 = null;
        goto L28
    L47:
        SkuViewModel r117 = this.f;
        if (r117 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L50:
        SkuLimit r118 = (SkuLimit) r117.m1031getUpperLimit().a();
        if (r118 == null) goto L54;
        String r119 = r118.getToast();
        if (r119 == null) goto L54;
    L58:
        SkuViewModel r14 = this.f;
        if (r14 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L62:
        if (r14.getSkuParams().isFromAnchorV3() == false) goto L64;
        String r20 = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL;
    L65:
        SkuViewModel r21 = this.f;
        if (r21 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L68:
        SkuViewModel.doSkuEventAction$default(r21, "livesdk_toast_show", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r20)}, null, null, null, 28, null);
        UIUtils.displayToast(Y().c(), r119);
        return;
    L64:
        r20 = "live_room_sku";
    L54:
        Context r120 = Y().c();
        Object[] r22 = new Object[1];
        SkuViewModel r23 = this.f;
        if (r23 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L57:
        r22[0] = Long.valueOf(r23.getUpperLimit());
        r119 = th.a.h(r120, 2131914000, r22);
        goto L58
    L70:
        if (r16 != 2131376618) goto L103;
        SkuViewModel r121 = this.f;
        if (r121 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L74:
        long r24 = r121.getCurrentCount();
        SkuViewModel r122 = this.f;
        if (r122 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L78:
        if (r24 <= r122.getLowerLimit()) goto L86;
        SkuViewModel r123 = this.f;
        if (r123 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L82:
        QLiveData<Long> r124 = r123.m1027getCurrentCount();
        SkuViewModel r25 = this.f;
        if (r25 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L85:
        r124.g(Long.valueOf(r25.getCurrentCount() - 1));
        return;
    L86:
        SkuViewModel r125 = this.f;
        if (r125 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L89:
        SkuLimit r126 = (SkuLimit) r125.m1029getLowerLimit().a();
        if (r126 == null) goto L93;
        String r127 = r126.getToast();
        if (r127 == null) goto L93;
    L97:
        UIUtils.displayToast(Y().c(), r127);
        return;
    L93:
        Context r128 = Y().c();
        Object[] r26 = new Object[1];
        SkuViewModel r27 = this.f;
        if (r27 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L96:
        r26[0] = Long.valueOf(r27.getLowerLimit());
        r127 = th.a.h(r128, 2131914001, r26);
        goto L97
    }
}
