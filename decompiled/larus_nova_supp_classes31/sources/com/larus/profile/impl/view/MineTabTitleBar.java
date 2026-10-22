package com.larus.profile.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.profile.impl.databinding.LarusCommonRedDotImageViewBinding;
import com.larus.profile.impl.databinding.LarusWidgetMineTabTitleBarBinding;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\nJ\"\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0018\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\nJ\u001c\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%J\u001c\u0010&\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006'"}, d2 = {"Lcom/larus/profile/impl/view/MineTabTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larus/profile/impl/databinding/LarusWidgetMineTabTitleBarBinding;", "binding", "getBinding", "()Lcom/larus/profile/impl/databinding/LarusWidgetMineTabTitleBarBinding;", "init", "", "setTitle", "title", "", "listener", "Landroid/view/View$OnClickListener;", "updateTitleVisibility", "visibility", "showRightImg", "resId", "accessibilityContent", "showLeftImg", "showRedDotImg", "updateRedDotUnreadCount", "count", "setLeftCustomView", "view", "Landroid/view/View;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "setRightCustomView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MineTabTitleBar extends ConstraintLayout {
    public static final /* synthetic */ int b = 0;
    public LarusWidgetMineTabTitleBarBinding a;

    public final LarusWidgetMineTabTitleBarBinding getBinding() {
        LarusWidgetMineTabTitleBarBinding r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public MineTabTitleBar(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        R5(r2, null);
    }

    public final void V5(int r3) {
        LarusWidgetMineTabTitleBarBinding r0 = getBinding();
        if (r3 == 0) goto L5;
    L10:
        r0.g.setVisibility(r3);
        return;
    L5:
        if (getBinding().c.getVisibility() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
        r3 = 8;
        goto L10
    L7:
        r1 = false;
        goto L8
    }

    public MineTabTitleBar(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        R5(r2, r3);
    }

    public static void S5(MineTabTitleBar r2, String r3) {
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "title");
        LarusWidgetMineTabTitleBarBinding r0 = r2.getBinding();
        if (r2.getBinding().c.getVisibility() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        r0.g.setVisibility(8);
        return;
    L8:
        r0.g.setVisibility(0);
        r0.g.setText(r3);
        return;
    L5:
        r4 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(Context r9, AttributeSet r10) {
        LayoutInflater.from(r9).inflate(2131563260, this);
        int r11 = 2131377637;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(this, 2131377637);
        if (r2 == null) goto L17;
        r11 = 2131377638;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(this, 2131377638);
        if (r3 == null) goto L17;
        r11 = 2131377782;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(this, 2131377782);
        if (r4 == null) goto L17;
        r11 = 2131384099;
        CommonRedDotImageView r5 = (CommonRedDotImageView) ViewBindings.findChildViewById(this, 2131384099);
        if (r5 == null) goto L17;
        r11 = 2131384596;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(this, 2131384596);
        if (r6 == null) goto L17;
        r11 = 2131388915;
        TextView r7 = (TextView) ViewBindings.findChildViewById(this, 2131388915);
        if (r7 == null) goto L17;
        this.a = new LarusWidgetMineTabTitleBarBinding(this, r2, r3, r4, r5, r6, r7);
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r11)));
    }

    public final void T5(int r4, View.OnClickListener r5) {
        LarusWidgetMineTabTitleBarBinding r0 = getBinding();
        r0.e.setVisibility(0);
        LarusCommonRedDotImageViewBinding r1 = r0.e.a;
        if (r1 == null) goto L5;
        r1.b.setImageResource(r4);
    L5:
        e1.c(r0.e, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U5(String r5, View.OnClickListener r6) {
        Intrinsics.checkNotNullParameter(r5, "accessibilityContent");
        LarusWidgetMineTabTitleBarBinding r0 = getBinding();
        r0.f.setVisibility(0);
        r0.f.setImageResource(2131241354);
        r0.f.setColorFilter(ContextCompat.getColor(getContext(), 2131103136));
        r0.f.setContentDescription(r5);
        e1.c(r0.f, r6);
    }

    public MineTabTitleBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        R5(r2, r3);
    }
}
