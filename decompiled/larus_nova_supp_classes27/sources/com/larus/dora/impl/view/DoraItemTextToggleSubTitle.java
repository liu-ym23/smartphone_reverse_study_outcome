package com.larus.dora.impl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemTextView;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/larus/dora/impl/view/DoraItemTextToggleSubTitle;", "Lcom/larus/bmhome/view/item/ItemTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setEnabled", "", "enabled", "", "toggleView", "Lcom/larus/bmhome/view/item/CustomSwitchCompat;", "getToggleView", "()Lcom/larus/bmhome/view/item/CustomSwitchCompat;", "subTitle", "Landroid/widget/TextView;", "getSubTitle", "()Landroid/widget/TextView;", "init", "setSubTitle", "subTitleText", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraItemTextToggleSubTitle extends ItemTextView {
    public final CustomSwitchCompat c;
    public final TextView d;

    public final TextView getSubTitle() {
        return this.d;
    }

    public final CustomSwitchCompat getToggleView() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DoraItemTextToggleSubTitle(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6);
        CustomSwitchCompat r0 = new CustomSwitchCompat(getContext(), null);
        r0.setId(2131392535);
        r0.setChecked(true);
        r0.setThumbResource(2131239770);
        r0.setTrackResource(2131239772);
        this.c = r0;
        TextView r1 = new TextView(getContext());
        r1.setId(2131387517);
        r1.setTextColor(c.a(2130972081, r1.getContext(), 2131103143));
        r1.setTextSize(0, i5.h());
        r1.setGravity(16);
        this.d = r1;
        R5(r6, null);
    }

    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        this.c.setEnabled(r2);
    }

    public final void setSubTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "subTitleText");
        this.d.setText(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DoraItemTextToggleSubTitle(Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "attrs");
        super(r5, r6);
        CustomSwitchCompat r0 = new CustomSwitchCompat(getContext(), null);
        r0.setId(2131392535);
        r0.setChecked(true);
        r0.setThumbResource(2131239770);
        r0.setTrackResource(2131239772);
        this.c = r0;
        TextView r1 = new TextView(getContext());
        r1.setId(2131387517);
        r1.setTextColor(c.a(2130972081, r1.getContext(), 2131103143));
        r1.setTextSize(0, i5.h());
        r1.setGravity(16);
        this.d = r1;
        R5(r5, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void R5(Context r6, AttributeSet r7) {
        boolean r0 = true;
        TypedArray r8 = r6.obtainStyledAttributes(r7, new int[]{2130972317});
        CustomSwitchCompat r9 = this.c;
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(-2, i5.C());
        r1.topToTop = 0;
        r1.bottomToBottom = 0;
        r1.endToEnd = 0;
        Unit r2 = Unit.INSTANCE;
        addView(r9, r1);
        TextView r10 = this.d;
        ConstraintLayout.LayoutParams r3 = new ConstraintLayout.LayoutParams(0, -2);
        ((ViewGroup.MarginLayoutParams) r3).width = 0;
        r3.topToBottom = getTextView().getId();
        r3.bottomToBottom = 0;
        r3.startToStart = getTextView().getId();
        r3.endToEnd = getTextView().getId();
        r3.verticalChainStyle = 2;
        ((ViewGroup.MarginLayoutParams) r3).topMargin = i5.z();
        addView(r10, r3);
        TextView r11 = this.d;
        String r4 = r8.getString(0);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r11.setText(r4);
        ConstraintLayout.LayoutParams r12 = getTextView().getLayoutParams();
        if ((r12 instanceof ConstraintLayout.LayoutParams) == false) goto L8;
        ConstraintLayout.LayoutParams r13 = r12;
    L9:
        if (r13 == null) goto L18;
        ((ViewGroup.MarginLayoutParams) r13).width = 0;
        r13.topToTop = 0;
        r13.bottomToTop = this.d.getId();
        r13.startToEnd = getImageView().getId();
        r13.endToStart = this.c.getId();
        r13.verticalChainStyle = 2;
        if (getImageView().getVisibility() == 0) goto L14;
        r0 = false;
    L14:
        if (r0 == false) goto L16;
        r13.setMarginStart(i5.q());
        r13.setMarginEnd(i5.q());
        r13.setMarginEnd(0);
    L17:
        getTextView().setGravity(8388611);
        goto L18
    L16:
        r13.setMarginStart(0);
        r13.setMarginEnd(0);
    L18:
        int r14 = r8.getResources().getDimensionPixelSize(c.b(2130971208, null, 2131166786));
        FLogger.a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:,start:" + r14 + ",top:" + r14 + ",end:" + r14 + ",bottom:" + r14);
        setPaddingRelative(r14, r14, r14, r14);
        setMinHeight(i5.h0());
        r8.recycle();
        return;
    L8:
        r13 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DoraItemTextToggleSubTitle(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "attrs");
        super(r4, r5, r6);
        CustomSwitchCompat r7 = new CustomSwitchCompat(getContext(), null);
        r7.setId(2131392535);
        r7.setChecked(true);
        r7.setThumbResource(2131239770);
        r7.setTrackResource(2131239772);
        this.c = r7;
        TextView r8 = new TextView(getContext());
        r8.setId(2131387517);
        r8.setTextColor(c.a(2130972081, r8.getContext(), 2131103143));
        r8.setTextSize(0, i5.h());
        r8.setGravity(16);
        this.d = r8;
        R5(r4, r5);
    }
}
