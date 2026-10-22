package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/view/ECBenefitLabelOptimizeView;", "Landroid/widget/FrameLayout;", "", "getAtmosphereColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECBenefitLabelOptimizeView extends FrameLayout {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final ConstraintLayout d;
    public final View e;
    public SkuViewModel f;

    public ECBenefitLabelOptimizeView(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public ECBenefitLabelOptimizeView(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    private final int getAtmosphereColor() {
        SkuViewModel r0 = this.f;
        if (r0 == null) goto L13;
        QLiveData<Integer> r1 = r0.getCurrentAtmosphereStyle();
        if (r1 == null) goto L13;
        Integer r10 = (Integer) r1.a();
        if (r10 == null) goto L13;
        if (r10.intValue() == 2) goto L15;
        return ColorProtector.parseColor("#FF3B52");
    L15:
        return ColorProtector.parseColor("#9E2DF5");
    L13:
        return ColorProtector.parseColor("#FF3B52");
    }

    public final void a(PromotionBenefitLabel r10, SkuViewModel r11) {
        Intrinsics.checkNotNullParameter(r10, "label");
        String r0 = r10.getLeftText();
        if (r0 != null) goto L5;
    L13:
        this.a.setVisibility(8);
        this.c.setVisibility(8);
    L14:
        this.b.setText(r10.getRightText());
        this.f = r11;
        int r12 = getAtmosphereColor();
        this.a.setTextColor(r12);
        this.b.setTextColor(r12);
        this.c.setTextColor(r12);
        GradientDrawable r13 = new GradientDrawable();
        r13.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(2));
        r13.setColor(com.bytedance.android.ec.common.impl.sku.utils.m.a(r12, 0.12f));
        this.e.setBackgroundDrawable(r13);
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        this.a.setText(r0);
        this.a.setVisibility(0);
        this.c.setVisibility(0);
        goto L14
    L7:
        r1 = false;
        goto L8
    }

    public ECBenefitLabelOptimizeView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        ShoppingAsyncInflater.e.getClass();
        View r13 = ShoppingAsyncInflater.a.a(r10).aU(2131564707, this, false);
        addView(r13);
        this.a = (TextView) r13.findViewById(2131377104);
        this.b = (TextView) r13.findViewById(2131377105);
        this.c = (TextView) r13.findViewById(2131377099);
        this.d = r13.findViewById(2131366869);
        this.e = r13.findViewById(2131377103);
        com.bytedance.android.ec.core.utils.a.f(this);
    }

    public /* synthetic */ ECBenefitLabelOptimizeView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
