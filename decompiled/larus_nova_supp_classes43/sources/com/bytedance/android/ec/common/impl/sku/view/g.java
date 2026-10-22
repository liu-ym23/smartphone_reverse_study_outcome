package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuInstallmentItemInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuTermInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuTermInfoItem;
import com.bytedance.android.ec.common.impl.sku.presenter.s1;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g extends FrameLayout {
    public final View a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final View e;
    public SkuViewModel f;
    public SkuTermInfoItem g;
    public List<Integer> h;
    public final SkuViewModel i;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ g a;
        public final /* synthetic */ int b;
        public final /* synthetic */ s1 c;

        public b(g r1, int r10, s1 r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            this.a.b(this.b, this.c);
            SkuViewModel.doSkuEventAction$default(this.a.i, "click_fxh_button_sku", new Pair[0], null, null, null, 28, null);
        }
    }

    static {
    }

    public final boolean getSelectedStatus() {
        return this.e.isSelected();
    }

    private final void setItemSelectBackground(boolean r10) {
        if (r10 == false) goto L4;
        this.e.setBackgroundResource(2131247932);
    L5:
        this.e.setSelected(r10);
        return;
    L4:
        this.e.setBackgroundResource(2131247933);
        goto L5
    }

    public final void setSelectedStatus(boolean r10) {
        if (r10 == true) goto L4;
        this.b.setTextColor(th.a.a(getContext(), 2131106227));
        this.c.setTextColor(th.a.a(getContext(), 2131106227));
    L5:
        setItemSelectBackground(r10);
        return;
    L4:
        this.b.setTextColor(th.a.a(getContext(), 2131106181));
        this.c.setTextColor(th.a.a(getContext(), 2131106181));
        goto L5
    }

    public g(SkuViewModel r10, Context r11) {
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, null, 0);
        this.i = r10;
        View r12 = th.a.c(r11, 2131564783, this, true);
        this.a = r12;
        this.b = (TextView) r12.findViewById(2131391455);
        this.c = (TextView) r12.findViewById(2131391456);
        this.d = (TextView) r12.findViewById(2131391452);
        this.e = r12.findViewById(2131366898);
        new ArrayList();
    }

    public final void b(int r13, s1 r14) {
        setSelectedStatus(!this.e.isSelected());
        String r10 = null;
        if (this.e.isSelected() == false) goto L67;
        LinearLayout r0 = r14.g;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L7:
        int r1 = r0.getChildCount();
        int r11 = 0;
    L8:
        if (r11 >= r1) goto L19;
        if (r13 == r11) goto L18;
        LinearLayout r12 = r14.g;
        if (r12 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L13:
        View r15 = r12.getChildAt(r11);
        if ((r15 instanceof g) == false) goto L18;
        g r16 = (g) r15;
        if (r16.getSelectedStatus() == false) goto L18;
        r16.setSelectedStatus(false);
    L18:
        r11 = r11 + 1;
        goto L8
    L19:
        SkuViewModel r17 = r14.f;
        if (r17 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        long r18 = r17.getCurrentPrice();
        SkuViewModel r19 = r14.f;
        if (r19 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L26:
        if (r19.getCurrentCount() > 0) goto L28;
    L29:
        SkuViewModel r20 = r14.f;
        if (r20 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L32:
        QLiveData<SkuInfoVO> r21 = r20.getSkuInfo();
        if (r21 == null) goto L43;
        SkuInfoVO r22 = (SkuInfoVO) r21.a();
        if (r22 == null) goto L43;
        SkuInstallmentItemInfo r23 = r22.getInstallmentInfo();
        if (r23 == null) goto L43;
        SkuTermInfo r24 = r23.getTermInfo();
        if (r24 == null) goto L43;
        String r25 = r24.getSelectionTip();
        if (r25 == null) goto L43;
        TextView r26 = (TextView) r14.Z().b(2131391454).f();
        r26.setText(r25);
        r26.setVisibility(0);
    L43:
        SkuViewModel r27 = r14.f;
        if (r27 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L47:
        if (r13 == r27.getCurrentInstallmentIndex()) goto L63;
        SkuViewModel r28 = r14.f;
        if (r28 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L51:
        SkuInstallmentItemInfo r29 = (SkuInstallmentItemInfo) r28.getValidInstallmentInfo().a();
        if (r29 == null) goto L58;
        SkuTermInfo r30 = r29.getTermInfo();
        if (r30 == null) goto L58;
        List<SkuTermInfoItem> r31 = r30.getItemList();
        if (r31 == null) goto L58;
        SkuTermInfoItem r32 = (SkuTermInfoItem) CollectionsKt.getOrNull(r31, r13);
    L59:
        SkuViewModel r33 = r14.f;
        if (r33 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L62:
        r33.getCurrentDouInstallmentItem().g(r32);
    L58:
        r32 = null;
    L63:
        SkuViewModel r110 = r14.f;
        if (r110 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L66:
        r110.setCurrentInstallmentIndex(r13);
    L75:
        if (this.e.isSelected() == false) goto L84;
        SkuViewModel r111 = this.f;
        if (r111 == null) goto L93;
        SkuTermInfoItem r112 = this.g;
        if (r112 == null) goto L83;
        Integer r113 = r112.getTermCount();
        if (r113 == null) goto L83;
        r10 = String.valueOf(r113.intValue());
    L83:
        r111.setSelectFxhMethod(r10);
        return;
    L93:
        return;
    L84:
        SkuViewModel r114 = this.f;
        if (r114 == null) goto L95;
        r114.setSelectFxhMethod(null);
        return;
    L95:
        return;
    L28:
        if (r18 > 0) goto L43;
    L67:
        SkuViewModel r115 = r14.f;
        if (r115 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L70:
        r115.getCurrentDouInstallmentItem().g(null);
        r14.Z().b(2131391454).c();
        SkuViewModel r116 = r14.f;
        if (r116 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L73:
        r116.setCurrentInstallmentIndex(-1);
        goto L75
    }

    public final void a(SkuTermInfoItem r10, int r11, List<Integer> r12, SkuViewModel r13) {
        Intrinsics.checkNotNullParameter(r10, "termInfo");
        Intrinsics.checkNotNullParameter(r12, "termCountList");
        Intrinsics.checkNotNullParameter(r13, "viewModel");
        int r0 = r12.size();
        String r1 = r10.getTermDetail();
        if (r1 == null) goto L5;
        this.b.setText(r1);
    L5:
        String r14 = r10.getServiceLabel();
        if (r14 == null) goto L8;
        this.c.setText(r14);
    L8:
        String r15 = r10.getTopTag();
        if (r15 == null) goto L11;
        this.d.setText(r15);
    L11:
        jg.g.d(this.c, jg.g.a(r10.getServiceLabel()));
        jg.g.d(this.d, Intrinsics.areEqual(r10.getShowTopTag(), Boolean.TRUE));
        if (jg.g.a(r10.getTermDetail()) == false) goto L26;
        String r16 = r10.getServiceLabel();
        if (r16 != null) goto L16;
    L19:
        boolean r17 = true;
    L20:
        if (r17 == false) goto L26;
        TextView r18 = this.b;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        if (r19 == null) goto L25;
        ConstraintLayout.LayoutParams r20 = (ConstraintLayout.LayoutParams) r19;
        r20.topToTop = 0;
        r20.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r20).topMargin = 0;
        Unit r21 = Unit.INSTANCE;
        r18.setLayoutParams(r20);
        goto L26
    L25:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L16:
        if (r16.length() == 0) goto L19;
        r17 = false;
    L26:
        ViewGroup.LayoutParams r22 = null;
        if (r11 != 0) goto L36;
        ViewGroup.LayoutParams r23 = this.e.getLayoutParams();
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == false) goto L32;
        r22 = r23;
    L32:
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r22;
        if (r24 == null) goto L44;
        r24.leftMargin = 0;
    L44:
        this.f = r13;
        this.g = r10;
        this.h = r12;
        return;
    L36:
        if (r11 != (r0 - 1)) goto L44;
        ViewGroup.LayoutParams r25 = this.e.getLayoutParams();
        if ((r25 instanceof ViewGroup.MarginLayoutParams) == false) goto L41;
        r22 = r25;
    L41:
        ViewGroup.MarginLayoutParams r26 = (ViewGroup.MarginLayoutParams) r22;
        if (r26 == null) goto L44;
        r26.rightMargin = 0;
        goto L44
    }

    public final void c(boolean r10, int r11, int r12, s1 r13) {
        Intrinsics.checkNotNullParameter(r13, "installmentInfoPresenter");
        if (r10 == false) goto L8;
        setSelectedStatus(false);
        this.e.setOnClickListener(new b(this, r11, r13));
        this.d.setTextColor(th.a.a(getContext(), 2131106181));
        this.d.setBackgroundResource(2131247928);
        if (r12 <= (-1)) goto L12;
        if (r12 != r11) goto L13;
        b(r11, r13);
        return;
    L13:
        return;
    L12:
        return;
    L8:
        this.e.setSelected(false);
        this.b.setTextColor(th.a.a(getContext(), 2131106189));
        this.c.setTextColor(th.a.a(getContext(), 2131106189));
        this.e.setOnClickListener(null);
        setItemSelectBackground(false);
        SkuViewModel r14 = this.f;
        if (r14 == null) goto L15;
        r14.setSelectFxhMethod(null);
        return;
    }
}
