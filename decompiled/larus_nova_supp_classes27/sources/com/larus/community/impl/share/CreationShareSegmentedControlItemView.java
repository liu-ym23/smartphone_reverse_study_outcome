package com.larus.community.impl.share;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.community.impl.databinding.LarusCommunitySegmentedControlItemViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u0007J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/community/impl/share/CreationShareSegmentedControlItemView;", "Lcom/larus/common_ui/widget/roundlayout/RoundLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunitySegmentedControlItemViewBinding;", "bindData", "", "icoResId", "textResId", "setSelected", "selected", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationShareSegmentedControlItemView extends RoundLinearLayout {
    public final LarusCommunitySegmentedControlItemViewBinding b;

    public CreationShareSegmentedControlItemView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CreationShareSegmentedControlItemView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public void setSelected(boolean r6) {
        super.setSelected(r6);
        c29.a r0 = getDelegate();
        if (r6 == false) goto L5;
        int r7 = ContextCompat.getColor(getContext(), 2131102551);
    L6:
        r0.a(r7);
        LarusCommunitySegmentedControlItemViewBinding r8 = this.b;
        if (r8 == null) goto L18;
        AppCompatImageView r1 = r8.b;
        Context r2 = getContext();
        int r3 = 2131103136;
        if (isSelected() == false) goto L11;
        int r4 = 2131103136;
    L12:
        r1.setImageTintList(ContextCompat.getColorStateList(r2, r4));
        AppCompatTextView r9 = r8.c;
        Context r5 = getContext();
        if (isSelected() == true) goto L16;
        r3 = 2131103143;
    L16:
        r9.setTextColor(ContextCompat.getColorStateList(r5, r3));
        return;
    L11:
        r4 = 2131103143;
        goto L12
    L18:
        return;
    L5:
        r7 = ContextCompat.getColor(getContext(), R.color.transparent);
        goto L6
    }

    public CreationShareSegmentedControlItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131561977, this);
        int r5 = 2131376297;
        AppCompatImageView r6 = ViewBindings.findChildViewById(this, 2131376297);
        if (r6 == null) goto L9;
        r5 = 2131391606;
        AppCompatTextView r7 = ViewBindings.findChildViewById(this, 2131391606);
        if (r7 == null) goto L9;
        this.b = new LarusCommunitySegmentedControlItemViewBinding(this, r6, r7);
        getDelegate().d(6);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public /* synthetic */ CreationShareSegmentedControlItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
