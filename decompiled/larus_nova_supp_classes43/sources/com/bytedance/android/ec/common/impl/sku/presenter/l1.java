package com.bytedance.android.ec.common.impl.sku.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuInstallmentItemInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuTermInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuTermInfoItem;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l1 extends QFragmentPresenter {
    public SkuViewModel f;
    public LinearLayout g;
    public boolean h;

    public l1(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
    }

    public static final void d0(l1 r10) {
        SkuViewModel r0 = r10.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        long r11 = r0.getCurrentPrice();
        SkuViewModel r1 = r10.f;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        long r12 = r1.getCurrentCount();
        if (r11 > 0) goto L11;
    L16:
        SkuViewModel r13 = r10.f;
        if (r13 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        SkuInfoVO r14 = (SkuInfoVO) r13.getSkuInfo().a();
        if (r14 == null) goto L22;
        SkuInstallmentItemInfo r15 = r14.getInstallmentInfo();
    L23:
        r10.e0(r15, true);
        return;
    L22:
        r15 = null;
        goto L23
    L11:
        if (r12 <= 0) goto L16;
        SkuViewModel r16 = r10.f;
        if (r16 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L15:
        r16.getSkuInstallmentInfo();
    }

    public final void b0(QModel r10) {
        this.f = (SkuViewModel) Y().g(SkuViewModel.class);
        this.g = (LinearLayout) Z().b(2131378872).f();
        SkuViewModel r11 = this.f;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r12 = (SkuInfoVO) r11.getSkuInfo().a();
        Boolean r1 = null;
        if (r12 == null) goto L8;
        SkuInstallmentItemInfo r13 = r12.getInstallmentInfo();
    L10:
        if (r13 == null) goto L31;
        SkuTermInfo r14 = r13.getTermInfo();
        if (r14 == null) goto L31;
        List<SkuTermInfoItem> r15 = r14.getItemList();
        if (r15 == null) goto L31;
        Iterator<T> r16 = r15.iterator();
        int r17 = 0;
    L17:
        if (r16.hasNext() == false) goto L31;
        Object r18 = r16.next();
        int r19 = r17 + 1;
        if (r17 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        SkuTermInfoItem r20 = (SkuTermInfoItem) r18;
        SkuViewModel r21 = this.f;
        if (r21 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        if (Intrinsics.areEqual(r21.getSkuParams().getTermCount(), r20.getTermCount()) == false) goto L30;
        SkuViewModel r22 = this.f;
        if (r22 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L29:
        r22.setCurrentInstallmentIndex(r17);
    L30:
        r17 = r19;
    L31:
        if (r13 == null) goto L37;
        SkuTermInfo r23 = r13.getTermInfo();
        if (r23 == null) goto L37;
        Boolean r24 = r23.getSelectable();
        if (r24 == null) goto L37;
        boolean r25 = r24.booleanValue();
    L38:
        e0(r13, r25);
        if (r13 == null) goto L44;
        SkuTermInfo r26 = r13.getTermInfo();
        if (r26 == null) goto L44;
        r1 = r26.getSelectable();
    L44:
        if (Intrinsics.areEqual(r1, Boolean.FALSE) == false) goto L51;
        if (r13 == null) goto L51;
        SkuTermInfo r27 = r13.getTermInfo();
        if (r27 == null) goto L51;
        String r28 = r27.getCreditTip();
        if (r28 == null) goto L51;
        TextView r29 = (TextView) Z().b(2131391454).f();
        r29.setText(r28);
        r29.setVisibility(0);
    L51:
        SkuViewModel r30 = this.f;
        if (r30 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L54:
        r30.getValidInstallmentInfo().b(ECQuickUtilKt.a(Y()), new g1(this));
        SkuViewModel r31 = this.f;
        if (r31 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L57:
        r31.getSkuInfo().b(ECQuickUtilKt.a(Y()), new h1(this));
        SkuViewModel r32 = this.f;
        if (r32 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L60:
        r32.m1028getCurrentPrice().b(ECQuickUtilKt.a(Y()), new i1(this));
        SkuViewModel r33 = this.f;
        if (r33 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L63:
        r33.m1027getCurrentCount().b(ECQuickUtilKt.a(Y()), new j1(this));
        SkuViewModel r34 = this.f;
        if (r34 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L66:
        r34.getCurrentAtmosphereStyle().b(ECQuickUtilKt.a(Y()), new k1(this));
        return;
    L37:
        r25 = true;
        goto L38
    L8:
        r13 = null;
        goto L10
    }

    public final void e0(SkuInstallmentItemInfo r14, boolean r15) {
        if (r14 == null) goto L72;
        SkuTermInfo r16 = r14.getTermInfo();
        if (r16 == null) goto L72;
        List<SkuTermInfoItem> r1 = r16.getItemList();
        SkuViewModel r10 = this.f;
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L10:
        if (Intrinsics.areEqual(r10.getInstallmentOriginalVisibility(), Boolean.TRUE) == false) goto L71;
        Y().d().q(dg.l.class, 0);
        if (TextUtils.isEmpty(r16.getTitle()) == true) goto L14;
        ((TextView) Z().b(2131391457).f()).setText(r16.getTitle());
    L14:
        if (r1 != null) goto L16;
        r1 = CollectionsKt.emptyList();
    L16:
        SkuViewModel r17 = this.f;
        if (r17 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        int r18 = r17.getCurrentInstallmentIndex();
        if (r1.isEmpty() == false) goto L22;
        h0(false, -1);
    L66:
        if (this.h == true) goto L80;
        this.h = true;
        SkuViewModel r11 = this.f;
        if (r11 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L70:
        SkuViewModel.doSkuEventAction$default(r11, "show_fxh_button_sku", new Pair[0], null, null, null, 28, null);
        return;
    L80:
        return;
    L22:
        int r0 = r1.size();
        LinearLayout r12 = this.g;
        if (r12 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L26:
        if (r0 != r12.getChildCount()) goto L48;
        LinearLayout r13 = this.g;
        if (r13 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L30:
        int r19 = r13.getChildCount();
        int r20 = 0;
    L31:
        if (r20 >= r19) goto L64;
        LinearLayout r21 = this.g;
        if (r21 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L35:
        View r22 = r21.getChildAt(r20);
        if ((r22 instanceof com.bytedance.android.ec.common.impl.sku.view.h) == true) goto L38;
        r22 = null;
    L38:
        com.bytedance.android.ec.common.impl.sku.view.h r23 = (com.bytedance.android.ec.common.impl.sku.view.h) r22;
        if (r23 == null) goto L47;
        SkuTermInfoItem r24 = (SkuTermInfoItem) ListProtector.get(r1, r20);
        SkuViewModel r25 = this.f;
        if (r25 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L43:
        List<Integer> r26 = r25.getTermCountList();
        SkuViewModel r27 = this.f;
        if (r27 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L46:
        r23.a(r24, r20, r26, r27);
    L47:
        r20 = r20 + 1;
    L64:
        h0(r15, r18);
        goto L66
    L48:
        Iterator<T> r28 = r1.iterator();
    L50:
        if (r28.hasNext() == false) goto L64;
        SkuTermInfoItem r29 = (SkuTermInfoItem) r28.next();
        LinearLayout r30 = this.g;
        if (r30 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L54:
        SkuViewModel r31 = this.f;
        if (r31 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L57:
        com.bytedance.android.ec.common.impl.sku.view.h r32 = new com.bytedance.android.ec.common.impl.sku.view.h(r31, Y().c());
        int r33 = r1.indexOf(r29);
        SkuViewModel r34 = this.f;
        if (r34 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L60:
        List<Integer> r35 = r34.getTermCountList();
        SkuViewModel r110 = this.f;
        if (r110 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L63:
        r32.a(r29, r33, r35, r110);
        Unit r36 = Unit.INSTANCE;
        r30.addView(r32);
        goto L50
    L71:
        Y().d().q(dg.l.class, 8);
        return;
    L72:
        Y().d().q(dg.l.class, 8);
    }

    public final void h0(boolean r10, int r11) {
        LinearLayout r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L5:
        int r1 = r0.getChildCount();
        int r12 = 0;
    L6:
        if (r12 >= r1) goto L14;
        LinearLayout r13 = this.g;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L10:
        View r14 = r13.getChildAt(r12);
        if ((r14 instanceof com.bytedance.android.ec.common.impl.sku.view.h) == false) goto L13;
        ((com.bytedance.android.ec.common.impl.sku.view.h) r14).c(r10, r12, r11, this);
    L13:
        r12 = r12 + 1;
        goto L6
    }
}
