package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.widget.ECBenefitLabelView;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/view/SkuBenefitLabelGroupLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuBenefitLabelGroupLayout extends LinearLayout {
    public final List<PromotionBenefitLabel> a;
    public final List<PromotionBenefitLabel> b;

    public SkuBenefitLabelGroupLayout(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public SkuBenefitLabelGroupLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    public final void a() {
        removeAllViews();
        Iterator r0 = ((ArrayList) this.b).iterator();
        int r10 = 0;
    L4:
        if (r0.hasNext() == false) goto L10;
        PromotionBenefitLabel r11 = (PromotionBenefitLabel) r0.next();
        ECBenefitLabelView r12 = new ECBenefitLabelView(getContext(), null, 6, 0);
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-2, vf4.a.b(Float.valueOf(20.0f)));
        if (r10 != 0) goto L8;
        r13.setMargins(0, 0, 0, 0);
    L9:
        r12.setLayoutParams(r13);
        addView(r12);
        r12.a(r11, null);
        r10 = r10 + 1;
        goto L4
    L8:
        r13.setMargins(vf4.a.b(Float.valueOf(8.0f)), 0, 0, 0);
        goto L9
    }

    public SkuBenefitLabelGroupLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public /* synthetic */ SkuBenefitLabelGroupLayout(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r10, int r11, int r12, int r13) {
        super.onLayout(r1, r10, r11, r12, r13);
        if (getChildCount() != ((ArrayList) this.b).size()) goto L9;
        int r14 = getChildCount() - 1;
    L5:
        if (r14 < 0) goto L12;
        View r15 = getChildAt(r14);
        if ((r15.getLeft() + r15.getMeasuredWidth()) < getMeasuredWidth()) goto L13;
        removeViewInLayout(r15);
        r14 = r14 - 1;
        goto L5
    L13:
        return;
    L12:
        return;
    }
}
