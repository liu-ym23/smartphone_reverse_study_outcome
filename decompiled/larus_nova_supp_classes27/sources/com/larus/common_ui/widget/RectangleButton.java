package com.larus.common_ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusRectangleButtonBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/larus/common_ui/widget/RectangleButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusRectangleButtonBinding;", "getBinding", "()Lcom/larus/common_res/common_ui/databinding/LarusRectangleButtonBinding;", "updateButtonState", "", "enable", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RectangleButton extends FrameLayout {
    public final LarusRectangleButtonBinding a;

    public final LarusRectangleButtonBinding getBinding() {
        return this.a;
    }

    public RectangleButton(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void a(boolean r5) {
        setEnabled(r5);
        if (r5 == false) goto L9;
        LarusRectangleButtonBinding r6 = this.a;
        if (r6 == null) goto L15;
        LinearLayout r7 = r6.b;
        if (r7 == null) goto L16;
        r7.setBackground(getContext().getDrawable(c.b(2130970549, getContext(), 2131238581)));
        return;
    L16:
        return;
    L15:
        return;
    L9:
        LarusRectangleButtonBinding r8 = this.a;
        if (r8 == null) goto L18;
        LinearLayout r9 = r8.b;
        if (r9 == null) goto L19;
        r9.setBackground(getContext().getDrawable(c.b(2130970550, getContext(), 2131238583)));
        return;
    L19:
        return;
    }

    public RectangleButton(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        View r4 = LayoutInflater.from(r2).inflate(2131563099, this, false);
        addView(r4);
        if (((TextView) ViewBindings.findChildViewById(r4, 2131365052)) == null) goto L7;
        LinearLayout r5 = (LinearLayout) r4;
        this.a = new LarusRectangleButtonBinding(r5, r5);
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(2131365052)));
    }
}
