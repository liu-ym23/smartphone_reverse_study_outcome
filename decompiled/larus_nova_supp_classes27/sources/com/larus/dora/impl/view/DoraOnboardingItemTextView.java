package com.larus.dora.impl.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bmhome.view.item.ItemTextView;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import q69.g;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/view/DoraOnboardingItemTextView;", "Lcom/larus/bmhome/view/item/ItemTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setEnabled", "", "enabled", "", "onboardingView", "Landroid/widget/TextView;", "getOnboardingView", "()Landroid/widget/TextView;", "init", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraOnboardingItemTextView extends ItemTextView {
    public static final /* synthetic */ int d = 0;
    public final TextView c;

    /* JADX WARN: Multi-variable type inference failed */
    private final void T5() {
        TextView r0 = this.c;
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(-2, i5.C());
        r1.topToTop = 0;
        r1.bottomToBottom = 0;
        r1.endToEnd = 0;
        Unit r4 = Unit.INSTANCE;
        addView(r0, r1);
        TextView r2 = getTextView();
        ConstraintLayout.LayoutParams r3 = new ConstraintLayout.LayoutParams(0, -2);
        r3.topToTop = 0;
        r3.bottomToBottom = 0;
        r3.startToEnd = getImageView().getId();
        boolean r5 = true;
        if (getImageView().getVisibility() != 0) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L8;
        r3.setMarginStart(i5.q());
        r3.setMarginEnd(0);
    L10:
        if (this.c.getVisibility() != 0) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L15;
        r3.endToStart = this.c.getId();
    L16:
        r2.setLayoutParams(r3);
        e1.d(this, new g(this));
        ConstraintLayout.LayoutParams r8 = getTextView().getLayoutParams();
        if ((r8 instanceof ConstraintLayout.LayoutParams) == false) goto L19;
        ConstraintLayout.LayoutParams r9 = r8;
    L20:
        if (r9 == null) goto L30;
        ((ViewGroup.MarginLayoutParams) r9).width = 0;
        r9.topToTop = 0;
        r9.bottomToBottom = 0;
        r9.startToEnd = getImageView().getId();
        r9.endToStart = this.c.getId();
        if (getImageView().getVisibility() == 0) goto L25;
        r5 = false;
    L25:
        if (r5 == false) goto L27;
        r9.setMarginStart(i5.q());
        r9.setMarginEnd(i5.q());
        r9.setMarginEnd(0);
    L28:
        getTextView().setGravity(8388611);
        return;
    L27:
        r9.setMarginStart(0);
        r9.setMarginEnd(0);
        goto L28
    L30:
        return;
    L19:
        r9 = null;
        goto L20
    L15:
        r3.endToEnd = 0;
        goto L16
    L12:
        r7 = false;
        goto L13
    L8:
        r3.setMarginStart(0);
        r3.setMarginEnd(0);
        goto L10
    L5:
        r6 = false;
        goto L6
    }

    public final TextView getOnboardingView() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DoraOnboardingItemTextView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        TextView r6 = new TextView(getContext());
        r6.setId(2131392535);
        r6.setText(2131902054);
        r6.setTextColor(ColorProtector.parseColor("#0066FF"));
        r6.setTextSize(0, i5.q());
        Drawable r0 = ContextCompat.getDrawable(r6.getContext(), 2131240530);
        if (r0 == null) goto L5;
        r0.setBounds(0, 0, i5.q(), i5.q());
    L5:
        r6.setCompoundDrawables(r0, null, null, null);
        r6.setCompoundDrawablePadding(i5.Y());
        r6.setGravity(16);
        this.c = r6;
        T5();
    }

    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        this.c.setEnabled(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DoraOnboardingItemTextView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "attrs");
        super(r4, r5);
        TextView r6 = new TextView(getContext());
        r6.setId(2131392535);
        r6.setText(2131902054);
        r6.setTextColor(ColorProtector.parseColor("#0066FF"));
        r6.setTextSize(0, i5.q());
        Drawable r7 = ContextCompat.getDrawable(r6.getContext(), 2131240530);
        if (r7 == null) goto L5;
        r7.setBounds(0, 0, i5.q(), i5.q());
    L5:
        r6.setCompoundDrawables(r7, null, null, null);
        r6.setCompoundDrawablePadding(i5.Y());
        r6.setGravity(16);
        this.c = r6;
        T5();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DoraOnboardingItemTextView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "attrs");
        super(r3, r4, r5);
        TextView r6 = new TextView(getContext());
        r6.setId(2131392535);
        r6.setText(2131902054);
        r6.setTextColor(ColorProtector.parseColor("#0066FF"));
        r6.setTextSize(0, i5.q());
        Drawable r7 = ContextCompat.getDrawable(r6.getContext(), 2131240530);
        if (r7 == null) goto L5;
        r7.setBounds(0, 0, i5.q(), i5.q());
    L5:
        r6.setCompoundDrawables(r7, null, null, null);
        r6.setCompoundDrawablePadding(i5.Y());
        r6.setGravity(16);
        this.c = r6;
        T5();
    }
}
