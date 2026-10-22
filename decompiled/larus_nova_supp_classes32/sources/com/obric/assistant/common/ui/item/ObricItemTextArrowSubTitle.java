package com.obric.assistant.common.ui.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.view.item.ItemTextView;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\u0015\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/common/ui/item/ObricItemTextArrowSubTitle;", "Lcom/larus/bmhome/view/item/ItemTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arrowView", "Landroid/widget/ImageView;", "getArrowView", "()Landroid/widget/ImageView;", "subTitle", "Landroid/widget/TextView;", "getSubTitle", "()Landroid/widget/TextView;", "init", NameKeys.UnloadStrategy_No_Strategy, "setSubTitle", "subTitleText", NameKeys.UnloadStrategy_No_Strategy, "setSubTitleTextColor", "textColor", "(Ljava/lang/Integer;)V", "utils_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricItemTextArrowSubTitle extends ItemTextView {
    public final ImageView c;
    public final TextView d;

    public final ImageView getArrowView() {
        return this.c;
    }

    public final TextView getSubTitle() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObricItemTextArrowSubTitle(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7);
        ImageView r0 = new ImageView(getContext());
        r0.setId(2131392521);
        r0.setImageResource(c.b(2130971641, r0.getContext(), 2131240848));
        r0.setVisibility(0);
        this.c = r0;
        TextView r1 = new TextView(getContext());
        r1.setId(2131392532);
        r1.setTextColor(ContextCompat.getColor(r1.getContext(), c.b(2130972081, r1.getContext(), 2131103143)));
        r1.setTextSize(0, i5.h());
        r1.setGravity(16);
        this.d = r1;
        R5(r7, null);
    }

    public final void setSubTitle(String r2) {
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
    public ObricItemTextArrowSubTitle(Context r7, AttributeSet r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "attrs");
        super(r7, r8);
        ImageView r0 = new ImageView(getContext());
        r0.setId(2131392521);
        r0.setImageResource(c.b(2130971641, r0.getContext(), 2131240848));
        r0.setVisibility(0);
        this.c = r0;
        TextView r1 = new TextView(getContext());
        r1.setId(2131392532);
        r1.setTextColor(ContextCompat.getColor(r1.getContext(), c.b(2130972081, r1.getContext(), 2131103143)));
        r1.setTextSize(0, i5.h());
        r1.setGravity(16);
        this.d = r1;
        R5(r7, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void R5(Context r6, AttributeSet r7) {
        TypedArray r8 = r6.obtainStyledAttributes(r7, new int[]{2130972928, 2130972929});
        ImageView r9 = this.c;
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(-2, -2);
        r1.topToTop = 0;
        r1.bottomToBottom = 0;
        r1.endToEnd = 0;
        Unit r4 = Unit.INSTANCE;
        addView(r9, r1);
        TextView r10 = this.d;
        ConstraintLayout.LayoutParams r2 = new ConstraintLayout.LayoutParams(0, -2);
        ((ViewGroup.MarginLayoutParams) r2).width = 0;
        r2.topToBottom = getTextView().getId();
        r2.bottomToBottom = 0;
        r2.leftToLeft = getTextView().getId();
        r2.rightToLeft = this.c.getId();
        r2.verticalChainStyle = 2;
        ((ViewGroup.MarginLayoutParams) r2).topMargin = i5.z();
        ((ViewGroup.MarginLayoutParams) r2).bottomMargin = i5.z();
        ((ViewGroup.MarginLayoutParams) r2).rightMargin = i5.r0();
        addView(r10, r2);
        TextView r11 = this.d;
        String r3 = r8.getString(0);
        if (r3 != null) goto L5;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        r11.setText(r3);
        ConstraintLayout.LayoutParams r12 = getTextView().getLayoutParams();
        if ((r12 instanceof ConstraintLayout.LayoutParams) == false) goto L8;
        ConstraintLayout.LayoutParams r13 = r12;
    L9:
        if (r13 == null) goto L18;
        ((ViewGroup.MarginLayoutParams) r13).width = 0;
        r13.topToTop = 0;
        r13.bottomToTop = this.d.getId();
        r13.startToEnd = getImageView().getId();
        r13.endToEnd = 0;
        r13.verticalChainStyle = 2;
        if (getImageView().getVisibility() != 0) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == false) goto L16;
        r13.setMarginStart(i5.q());
        r13.setMarginEnd(0);
    L17:
        getTextView().setGravity(8388611);
        goto L18
    L16:
        r13.setMarginStart(0);
        r13.setMarginEnd(0);
        goto L17
    L13:
        r0 = false;
    L18:
        int r14 = r8.getResources().getDimensionPixelSize(c.b(2130971208, null, 2131166786));
        int r5 = r8.getResources().getDimensionPixelSize(c.b(2130971546, null, 2131167462));
        FLogger.a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:,start:" + r14 + ",top:" + r5 + ",end:" + r14 + ",bottom:" + r5);
        setPaddingRelative(r14, r5, r14, r5);
        setMinHeight(i5.h0());
        r8.recycle();
        return;
    L8:
        r13 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObricItemTextArrowSubTitle(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "attrs");
        super(r6, r7, r8);
        ImageView r9 = new ImageView(getContext());
        r9.setId(2131392521);
        r9.setImageResource(c.b(2130971641, r9.getContext(), 2131240848));
        r9.setVisibility(0);
        this.c = r9;
        TextView r10 = new TextView(getContext());
        r10.setId(2131392532);
        r10.setTextColor(ContextCompat.getColor(r10.getContext(), c.b(2130972081, r10.getContext(), 2131103143)));
        r10.setTextSize(0, i5.h());
        r10.setGravity(16);
        this.d = r10;
        R5(r6, r7);
    }
}
