package com.larus.dora.impl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.view.item.ItemTextView;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\u0015\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0017R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/dora/impl/view/DoraItemTextArrowSubTitle;", "Lcom/larus/bmhome/view/item/ItemTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arrowView", "Landroid/widget/ImageView;", "subTitle", "Landroid/widget/TextView;", "init", "", "setSubTitle", "subTitleText", "", "setSubTitleTextColor", "textColor", "(Ljava/lang/Integer;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraItemTextArrowSubTitle extends ItemTextView {
    public final ImageView c;
    public final TextView d;

    /* JADX WARN: Multi-variable type inference failed */
    public DoraItemTextArrowSubTitle(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7);
        ImageView r0 = new ImageView(getContext());
        r0.setId(2131392521);
        r0.setImageResource(c.b(2130971641, r0.getContext(), 2131240848));
        r0.setVisibility(0);
        this.c = r0;
        TextView r1 = new TextView(getContext());
        r1.setId(View.generateViewId());
        r1.setTextColor(ContextCompat.getColor(r1.getContext(), c.b(2130972081, r1.getContext(), 2131103143)));
        r1.setTextSize(0, r1.getResources().getDimension(c.b(2130972270, null, 2131167610)));
        r1.setGravity(16);
        this.d = r1;
        R5(r7, null);
    }

    public final void setSubTitle(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "subTitleText");
        this.d.setText(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setSubTitleTextColor(Integer r5) {
        TextView r0 = this.d;
        if (r5 == null) goto L5;
        int r6 = r5.intValue();
    L6:
        r0.setTextColor(r6);
        return;
    L5:
        r6 = ContextCompat.getColor(getContext(), c.b(2130972081, getContext(), 2131103143));
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DoraItemTextArrowSubTitle(Context r7, AttributeSet r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "attrs");
        super(r7, r8);
        ImageView r0 = new ImageView(getContext());
        r0.setId(2131392521);
        r0.setImageResource(c.b(2130971641, r0.getContext(), 2131240848));
        r0.setVisibility(0);
        this.c = r0;
        TextView r1 = new TextView(getContext());
        r1.setId(View.generateViewId());
        r1.setTextColor(ContextCompat.getColor(r1.getContext(), c.b(2130972081, r1.getContext(), 2131103143)));
        r1.setTextSize(0, r1.getResources().getDimension(c.b(2130972270, null, 2131167610)));
        r1.setGravity(16);
        this.d = r1;
        R5(r7, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void R5(Context r7, AttributeSet r8) {
        boolean r0 = true;
        TypedArray r9 = r7.obtainStyledAttributes(r8, new int[]{2130970506});
        ImageView r10 = this.c;
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(-2, -2);
        r1.topToTop = 0;
        r1.bottomToBottom = 0;
        r1.endToEnd = 0;
        Unit r4 = Unit.INSTANCE;
        addView(r10, r1);
        TextView r11 = this.d;
        ConstraintLayout.LayoutParams r2 = new ConstraintLayout.LayoutParams(0, -2);
        r2.topToBottom = getTextView().getId();
        r2.bottomToBottom = 0;
        r2.startToStart = getTextView().getId();
        r2.endToStart = this.c.getId();
        ((ViewGroup.MarginLayoutParams) r2).topMargin = i5.z();
        r2.setMarginEnd(i5.r0());
        r2.verticalChainStyle = 2;
        addView(r11, r2);
        TextView r12 = this.d;
        String r3 = r9.getString(0);
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r12.setText(r3);
        ConstraintLayout.LayoutParams r13 = getTextView().getLayoutParams();
        if ((r13 instanceof ConstraintLayout.LayoutParams) == false) goto L8;
        ConstraintLayout.LayoutParams r14 = r13;
    L9:
        if (r14 == null) goto L18;
        ((ViewGroup.MarginLayoutParams) r14).width = 0;
        r14.topToTop = 0;
        r14.bottomToTop = this.d.getId();
        r14.startToEnd = getImageView().getId();
        r14.endToStart = this.c.getId();
        r14.setMarginEnd(i5.r0());
        r14.verticalChainStyle = 2;
        if (getImageView().getVisibility() == 0) goto L14;
        r0 = false;
    L14:
        if (r0 == false) goto L16;
        r14.setMarginStart(i5.q());
    L17:
        getTextView().setGravity(8388611);
        goto L18
    L16:
        r14.setMarginStart(0);
    L18:
        int r15 = i5.q();
        int r5 = i5.r0();
        int r6 = i5.q();
        int r16 = i5.r0();
        FLogger.a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:,start:" + r15 + ",top:" + r5 + ",end:" + r6 + ",bottom:" + r16);
        setPaddingRelative(r15, r5, r6, r16);
        setMinHeight(i5.h0());
        r9.recycle();
        return;
    L8:
        r14 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DoraItemTextArrowSubTitle(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "attrs");
        super(r6, r7, r8);
        ImageView r9 = new ImageView(getContext());
        r9.setId(2131392521);
        r9.setImageResource(c.b(2130971641, r9.getContext(), 2131240848));
        r9.setVisibility(0);
        this.c = r9;
        TextView r10 = new TextView(getContext());
        r10.setId(View.generateViewId());
        r10.setTextColor(ContextCompat.getColor(r10.getContext(), c.b(2130972081, r10.getContext(), 2131103143)));
        r10.setTextSize(0, r10.getResources().getDimension(c.b(2130972270, null, 2131167610)));
        r10.setGravity(16);
        this.d = r10;
        R5(r6, r7);
    }
}
