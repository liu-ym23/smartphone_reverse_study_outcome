package com.larus.bmhome.view.item;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\b\b\u0001\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\u0013J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\rR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/view/item/ItemTextSelector;", "Lcom/larus/bmhome/view/item/ItemTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "manualTickMode", "", "tickView", "Landroid/widget/ImageView;", "loadingView", "Landroid/widget/ProgressBar;", "init", "", "setSelected", "selected", "setManualTick", "resId", "visible", "clearManualTick", "showLoading", "hideLoading", "isLoading", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemTextSelector extends ItemTextView {
    public boolean c;
    public final ImageView d;
    public final ProgressBar e;

    /* JADX WARN: Multi-variable type inference failed */
    public final void T5() {
        int r0 = 0;
        this.c = false;
        ImageView r1 = this.d;
        if (isSelected() == true) goto L6;
        r0 = 8;
    L6:
        r1.setVisibility(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void U5() {
        ImageView r0 = this.d;
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(-2, -2);
        r1.topToTop = 0;
        r1.bottomToBottom = 0;
        r1.endToEnd = 0;
        Unit r4 = Unit.INSTANCE;
        addView(r0, r1);
        ProgressBar r2 = this.e;
        ConstraintLayout.LayoutParams r3 = new ConstraintLayout.LayoutParams(i5.m(), i5.m());
        r3.topToTop = 0;
        r3.bottomToBottom = 0;
        r3.endToEnd = 0;
        addView(r2, r3);
        TextView r5 = getTextView();
        ConstraintLayout.LayoutParams r6 = new ConstraintLayout.LayoutParams(0, -2);
        r6.topToTop = 0;
        r6.bottomToBottom = 0;
        r6.startToEnd = getImageView().getId();
        boolean r7 = true;
        if (getImageView().getVisibility() != 0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L8;
        r6.setMarginStart(i5.q());
        r6.setMarginEnd(0);
    L10:
        if (this.d.getVisibility() != 0) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L16;
        r6.endToStart = this.d.getId();
    L22:
        r5.setLayoutParams(r6);
        return;
    L16:
        if (this.e.getVisibility() == 0) goto L19;
        r7 = false;
    L19:
        if (r7 == false) goto L21;
        r6.endToStart = this.e.getId();
        goto L22
    L21:
        r6.endToEnd = 0;
        goto L22
    L12:
        r9 = false;
        goto L13
    L8:
        r6.setMarginStart(0);
        r6.setMarginEnd(0);
        goto L10
    L5:
        r8 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemTextSelector(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6);
        ImageView r7 = new ImageView(getContext());
        r7.setId(2131392534);
        r7.setImageResource(c.b(2130971838, r7.getContext(), 2131242004));
        r7.setContentDescription(r7.getResources().getString(R.string.ok));
        r7.setVisibility(8);
        this.d = r7;
        ProgressBar r8 = new ProgressBar(getContext(), null, 0, 2131954353);
        r8.setId(2131392526);
        r8.setVisibility(8);
        this.e = r8;
        U5();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSelected(boolean r2) {
        super/*android.view.ViewGroup*/.setSelected(r2);
        if (this.c == true) goto L10;
        ImageView r0 = this.d;
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        return;
    L7:
        r3 = 8;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemTextSelector(Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "attrs");
        super(r5, r6);
        ImageView r7 = new ImageView(getContext());
        r7.setId(2131392534);
        r7.setImageResource(c.b(2130971838, r7.getContext(), 2131242004));
        r7.setContentDescription(r7.getResources().getString(R.string.ok));
        r7.setVisibility(8);
        this.d = r7;
        ProgressBar r8 = new ProgressBar(getContext(), null, 0, 2131954353);
        r8.setId(2131392526);
        r8.setVisibility(8);
        this.e = r8;
        U5();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemTextSelector(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "attrs");
        super(r4, r5, r6);
        ImageView r7 = new ImageView(getContext());
        r7.setId(2131392534);
        r7.setImageResource(c.b(2130971838, r7.getContext(), 2131242004));
        r7.setContentDescription(r7.getResources().getString(R.string.ok));
        r7.setVisibility(8);
        this.d = r7;
        ProgressBar r8 = new ProgressBar(getContext(), null, 0, 2131954353);
        r8.setId(2131392526);
        r8.setVisibility(8);
        this.e = r8;
        U5();
    }
}
