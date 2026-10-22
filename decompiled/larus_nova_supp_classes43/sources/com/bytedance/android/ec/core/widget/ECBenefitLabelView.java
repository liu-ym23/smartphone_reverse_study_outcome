package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.ColorPattern;
import com.bytedance.android.ec.model.DivLinePattern;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.TextPattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/core/widget/ECBenefitLabelView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "label", "", "setTextStyle", "setColorStyle", "setDivLineStyle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECBenefitLabelView extends FrameLayout {
    public final TextView a;
    public final TextView b;
    public final LinearLayout c;
    public final ECNetImageView d;
    public final VerticalDashLineView e;
    public final View f;
    public int g;
    public final int h;
    public final int i;

    public static final class a {
    }

    static {
    }

    public ECBenefitLabelView(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public ECBenefitLabelView(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    public final void setColorStyle(PromotionBenefitLabel r17) {
        Intrinsics.checkNotNullParameter(r17, "label");
        if (r17.getColorStyle() != this.h) goto L5;
        return;
    L5:
        ColorPattern r1 = r17.getColorPattern();
        if (r1 != null) goto L8;
        return;
    L8:
        int r10 = com.bytedance.android.ec.core.utils.s.a;
        Integer r11 = com.bytedance.android.ec.core.utils.s.b(r1.getLeftTextColor());
        if (r11 == null) goto L11;
        this.a.setTextColor(r11.intValue());
    L11:
        Integer r12 = com.bytedance.android.ec.core.utils.s.b(r1.getLeftBgColor());
        if (r12 == null) goto L14;
        int r13 = r12.intValue();
        TextView r14 = this.a;
        float r15 = vf4.a.b(2);
        GradientDrawable r16 = new GradientDrawable();
        r16.setColor(r13);
        r16.setCornerRadii(new float[]{r15, r15, 0.0f, 0.0f, 0.0f, 0.0f, r15, r15});
        r14.setBackgroundDrawable(r16);
    L15:
        Integer r18 = com.bytedance.android.ec.core.utils.s.b(r1.getRightTextColor());
        if (r18 == null) goto L18;
        this.b.setTextColor(r18.intValue());
    L18:
        Integer r19 = com.bytedance.android.ec.core.utils.s.b(r1.getRightBgColor());
        if (r19 == null) goto L21;
        int r20 = r19.intValue();
        LinearLayout r21 = this.c;
        float r110 = vf4.a.b(2);
        GradientDrawable r111 = new GradientDrawable();
        r111.setColor(r20);
        r111.setCornerRadii(new float[]{0.0f, 0.0f, r110, r110, r110, r110, 0.0f, 0.0f});
        r21.setBackgroundDrawable(r111);
    L22:
        Integer r22 = com.bytedance.android.ec.core.utils.s.b(r1.getBorderColor());
        if (r22 == null) goto L25;
        int r23 = r22.intValue();
        View r24 = this.f;
        float r25 = vf4.a.b(2);
        GradientDrawable r26 = new GradientDrawable();
        r26.setStroke(2, r23);
        r26.setCornerRadius(r25);
        r24.setBackgroundDrawable(r26);
        return;
    L25:
        this.f.setBackgroundDrawable(null);
        return;
    L21:
        this.c.setBackgroundDrawable(null);
        goto L22
    L14:
        this.a.setBackgroundDrawable(null);
        goto L15
    }

    public final void setDivLineStyle(PromotionBenefitLabel r10) {
        Intrinsics.checkNotNullParameter(r10, "label");
        if (r10.getDivLineStyle() != this.i) goto L5;
        return;
    L5:
        DivLinePattern r0 = r10.getDivLinePattern();
        if (r0 != null) goto L8;
        return;
    L8:
        int r11 = 0;
        boolean r12 = true;
        if (r0.getStyle() == 1) goto L12;
        r12 = false;
    L12:
        VerticalDashLineView r1 = this.e;
        float r13 = 0.0f;
        if (r12 == false) goto L15;
        float r14 = vf4.a.b(2);
    L16:
        if (r12 == false) goto L18;
        r13 = vf4.a.b(2);
    L18:
        r1.a(2.0f, r14, r13, (vf4.a.b(2) / 2) + 2);
        int r15 = com.bytedance.android.ec.core.utils.s.a;
        Integer r16 = com.bytedance.android.ec.core.utils.s.b(r0.getDivLineColor());
        if (r16 == null) goto L21;
        this.e.setDashLineColor(r16.intValue());
    L21:
        int r17 = r0.getDivLineHeight();
        TextPattern r18 = r10.getTextPattern();
        if (r18 != null) goto L24;
    L26:
        this.e.getLayoutParams().height = vf4.a.b(Integer.valueOf(r0.getDivLineHeight())) - r11;
        return;
    L24:
        if (r17 != r18.getHeight()) goto L26;
        r11 = 4;
        goto L26
    L15:
        r14 = 0.0f;
        goto L16
    }

    public final void setTextStyle(PromotionBenefitLabel r10) {
        Intrinsics.checkNotNullParameter(r10, "label");
        if (r10.getTextStyle() != this.g) goto L5;
        return;
    L5:
        TextPattern r0 = r10.getTextPattern();
        if (r0 != null) goto L8;
        return;
    L8:
        this.g = r10.getTextStyle();
        getLayoutParams().height = vf4.a.b(Integer.valueOf(r0.getHeight()));
        this.a.setTextSize(0, vf4.a.b(Integer.valueOf(r0.getTextSize())));
        this.b.setTextSize(0, vf4.a.b(Integer.valueOf(r0.getTextSize())));
        int r11 = vf4.a.b(Integer.valueOf(r0.getInnerPadding()));
        this.a.setPadding(r11, 0, r11, 0);
        this.c.setPadding(r11, 0, r11, 0);
    }

    public final void a(PromotionBenefitLabel r10, StringBuilder r11) {
        Intrinsics.checkNotNullParameter(r10, "label");
        com.bytedance.android.ec.core.utils.r.a(r10);
        if (r10.getTextPattern() != null) goto L5;
    L33:
        setVisibility(8);
        return;
    L5:
        if (r10.getColorPattern() == null) goto L33;
        if (r10.getDivLinePattern() == null) goto L33;
        String r0 = r10.getLeftText();
        if (r0 != null) goto L12;
    L23:
        this.a.setVisibility(8);
        this.e.setVisibility(8);
    L24:
        this.b.setText(r10.getRightText());
        if (r11 == null) goto L27;
        r11.append(r10.getRightText());
    L27:
        ECUrlModel r12 = r10.getRightIcon();
        if (r12 == null) goto L30;
        com.bytedance.android.ec.core.utils.y.a(this.d, r12);
        ViewGroup.LayoutParams r1 = this.d.getLayoutParams();
        r1.width = vf4.a.b(Integer.valueOf(r12.getWidth()));
        ViewGroup.LayoutParams r13 = this.d.getLayoutParams();
        r13.height = vf4.a.b(Integer.valueOf(r12.getHeight()));
        this.d.setVisibility(0);
    L31:
        setTextStyle(r10);
        setColorStyle(r10);
        setDivLineStyle(r10);
        return;
    L30:
        this.d.setVisibility(8);
        goto L31
    L12:
        if (r0.length() <= 0) goto L14;
        boolean r14 = true;
    L15:
        if (r14 == true) goto L18;
        r0 = null;
    L18:
        if (r0 == null) goto L23;
        this.a.setText(r0);
        if (r11 == null) goto L22;
        r11.append(r0);
    L22:
        this.a.setVisibility(0);
        this.e.setVisibility(0);
        goto L24
    L14:
        r14 = false;
        goto L15
    }

    public ECBenefitLabelView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.g = -1;
        this.h = -1;
        this.i = -1;
        ShoppingAsyncInflater.e.getClass();
        View r13 = ShoppingAsyncInflater.a.a(r10).aU(2131564706, this, false);
        addView(r13);
        this.a = (TextView) r13.findViewById(2131377104);
        this.b = (TextView) r13.findViewById(2131377105);
        this.c = (LinearLayout) r13.findViewById(2131368105);
        this.d = (ECNetImageView) r13.findViewById(2131377100);
        this.e = (VerticalDashLineView) r13.findViewById(2131377099);
        this.f = r13.findViewById(2131377106);
        com.bytedance.android.ec.core.utils.a.f(this);
    }

    public /* synthetic */ ECBenefitLabelView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
