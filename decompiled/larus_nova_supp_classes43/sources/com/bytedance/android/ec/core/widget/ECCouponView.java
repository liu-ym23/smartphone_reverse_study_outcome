package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.common.utility.UIUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/core/widget/ECCouponView;", "Landroid/widget/LinearLayout;", "", "padding", "", "setPaddingVertical", "setPaddingHorizontal", "uiType", "setCouponUIStyle", "(Ljava/lang/Integer;)V", "color", "setPrefixBackgroundColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCouponView extends LinearLayout {
    public TextView a;
    public TextView b;
    public ImageView c;
    public View d;

    public ECCouponView(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public ECCouponView(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    public final void setCouponUIStyle(Integer r10) {
        if (r10 != null) goto L5;
    L7:
        if (r10 != null) goto L10;
    L20:
        if (r10 != null) goto L23;
    L25:
        if (r10 != null) goto L28;
        return;
    L28:
        if (r10.intValue() != 3) goto L41;
    L29:
        TextView r11 = this.b;
        if (r11 == null) goto L32;
        r11.setTextColor(getContext().getResources().getColor(2131101703));
    L32:
        TextView r12 = this.b;
        if (r12 == null) goto L35;
        r12.setBackgroundResource(2131234472);
    L35:
        View r13 = this.d;
        if (r13 == null) goto L42;
        r13.setBackgroundResource(2131234473);
        return;
    L42:
        return;
    L41:
        return;
    L23:
        if (r10.intValue() != 2) goto L25;
    L10:
        if (r10.intValue() != 1) goto L20;
    L11:
        TextView r14 = this.b;
        if (r14 == null) goto L14;
        r14.setTextColor(getContext().getResources().getColor(2131101606));
    L14:
        TextView r15 = this.b;
        if (r15 == null) goto L17;
        r15.setBackgroundResource(2131234943);
    L17:
        View r16 = this.d;
        if (r16 == null) goto L39;
        r16.setBackgroundResource(2131234940);
        return;
    L39:
        return;
    L5:
        if (r10.intValue() != 0) goto L7;
        goto L7
    }

    public final void setPaddingHorizontal(int r10) {
        TextView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setPadding(r10, r0.getPaddingTop(), r10, r0.getPaddingBottom());
    L5:
        TextView r1 = this.a;
        if (r1 == null) goto L9;
        r1.setPadding(r10, r1.getPaddingTop(), r10, r1.getPaddingBottom());
        return;
    }

    public final void setPaddingVertical(int r10) {
        TextView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setPadding(r0.getPaddingLeft(), r10, r0.getPaddingRight(), r10);
    L5:
        TextView r1 = this.a;
        if (r1 == null) goto L9;
        r1.setPadding(r1.getPaddingLeft(), r10, r1.getPaddingRight(), r10);
        return;
    }

    public final void setPrefixBackgroundColor(int r10) {
        float r0 = UIUtils.dip2Px(getContext(), 2.0f);
        TextView r1 = this.b;
        if (r1 == null) goto L6;
        GradientDrawable r11 = new GradientDrawable();
        r11.setColor(r10);
        r11.setCornerRadii(new float[]{r0, r0, 0.0f, 0.0f, 0.0f, 0.0f, r0, r0});
        Unit r12 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r1, "$this$setBackgroundCompat");
        r1.setBackground(r11);
        return;
    }

    public ECCouponView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        ShoppingAsyncInflater.e.getClass();
        View r13 = ShoppingAsyncInflater.a.a(r10).aU(2131561060, this, true);
        this.a = (TextView) r13.findViewById(2131368117);
        this.b = (TextView) r13.findViewById(2131368099);
        this.c = (ImageView) r13.findViewById(2131368087);
        this.d = r13.findViewById(2131368115);
        ImageView r14 = (ImageView) r13.findViewById(2131368059);
    }

    public /* synthetic */ ECCouponView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }

    public static void a(ECCouponView r10, String r11, String r12, boolean r13, Integer r14, int r15) {
        boolean r1 = false;
        if ((r15 & 4) == 0) goto L6;
        r13 = false;
    L6:
        if ((r15 & 16) == 0) goto L8;
        r14 = 0;
    L8:
        TextView r16 = r10.b;
        if (r16 == null) goto L11;
        r16.setVisibility(0);
    L11:
        ImageView r17 = r10.c;
        if (r17 == null) goto L14;
        r17.setVisibility(0);
    L14:
        TextView r18 = r10.a;
        if (r18 == null) goto L17;
        r18.setVisibility(0);
    L17:
        Context r19 = r10.getContext();
        if (r19 == null) goto L26;
        if (r13 == false) goto L26;
        TextView r0 = r10.a;
        if (r0 == null) goto L23;
        r0.setBackgroundResource(2131234945);
    L23:
        TextView r20 = r10.a;
        if (r20 == null) goto L26;
        r20.setPadding((int) UIUtils.dip2Px(r19, 8.0f), 0, (int) UIUtils.dip2Px(r19, 8.0f), 0);
    L26:
        TextView r21 = r10.a;
        if (r21 == null) goto L29;
        r21.setText(r11);
    L29:
        if (r12 != null) goto L31;
    L32:
        r1 = true;
    L34:
        if (r1 == true) goto L41;
        TextView r22 = r10.b;
        if (r22 == null) goto L38;
        r22.setText(r12);
    L38:
        View r23 = r10.d;
        if (r23 == null) goto L54;
        r23.setBackgroundResource(2131234940);
    L54:
        r10.setCouponUIStyle(r14);
        r10.requestLayout();
        return;
    L41:
        TextView r24 = r10.b;
        if (r24 == null) goto L44;
        r24.setVisibility(8);
    L44:
        ImageView r25 = r10.c;
        if (r25 == null) goto L47;
        r25.setVisibility(8);
    L47:
        if (r13 == false) goto L51;
        View r26 = r10.d;
        if (r26 == null) goto L54;
        r26.setBackgroundResource(2131234942);
        goto L54
    L51:
        View r27 = r10.d;
        if (r27 == null) goto L54;
        r27.setBackgroundResource(2131234940);
        goto L54
    L31:
        if (r12.length() != 0) goto L34;
        goto L32
    }
}
