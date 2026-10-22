package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/view/SkuBenefitLabelGroupOptimizeLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuBenefitLabelGroupOptimizeLayout extends LinearLayout {
    public final List<PromotionBenefitLabel> a;
    public final List<PromotionBenefitLabel> b;
    public SkuViewModel c;

    public SkuBenefitLabelGroupOptimizeLayout(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public SkuBenefitLabelGroupOptimizeLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    public final void a() {
        removeAllViews();
        Iterator r0 = ((ArrayList) this.b).iterator();
        int r1 = 0;
        int r10 = 0;
    L4:
        if (r0.hasNext() == false) goto L13;
        PromotionBenefitLabel r11 = (PromotionBenefitLabel) r0.next();
        ECBenefitLabelOptimizeView r12 = new ECBenefitLabelOptimizeView(getContext(), null, 6, r1);
        if (r10 != 0) goto L8;
        r12.d.setVisibility(8);
    L9:
        r12.a(r11, this.c);
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r12.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r13 = getMeasuredWidth() + r12.getMeasuredWidth();
        Resources r14 = Resources.getSystem();
        if (r13 > MathKt.roundToInt(TypedValue.applyDimension(1, 245, WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics())))) goto L16;
        addView(r12);
        r10 = r10 + 1;
        goto L4
    L16:
        return;
    L8:
        r12.d.setVisibility(0);
        goto L9
    }

    public SkuBenefitLabelGroupOptimizeLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public /* synthetic */ SkuBenefitLabelGroupOptimizeLayout(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
