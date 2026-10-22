package com.larus.dora.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.databinding.LarusDoraWidgetTitlebarExBinding;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\nJ\"\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J)\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010#J,\u0010$\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\"\u0010'\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0006\u0010(\u001a\u00020\u0012J\u0006\u0010)\u001a\u00020\u0012J\u0006\u0010*\u001a\u00020+J\"\u0010,\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u000e\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u001fJ\u0006\u0010/\u001a\u00020\u0012J\u0006\u00100\u001a\u00020\u0012J\u0006\u00101\u001a\u00020\u0012R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u00062"}, d2 = {"Lcom/larus/dora/impl/view/DoraNovaTitleBarEx;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larus/dora/impl/databinding/LarusDoraWidgetTitlebarExBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraWidgetTitlebarExBinding;", "init", "", "setTitle", "title", "", "color", "listener", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Ljava/lang/Integer;Landroid/view/View$OnClickListener;)V", "updateTitleVisibility", "visibility", "showLeftImg", "resId", "staticColor", "", "showLeftText", "text", "", "(Ljava/lang/CharSequence;Ljava/lang/Integer;Landroid/view/View$OnClickListener;)V", "showRightImgSec", "alpha", "", "showRightImg", "hideRightImg", "hideLeftImg", "getRightImg", "Landroid/view/View;", "showRightText", "setRightTextEnable", "enable", "showRightLoading", "hideRightLoading", "hideRightView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraNovaTitleBarEx extends ConstraintLayout {
    public LarusDoraWidgetTitlebarExBinding a;

    public final LarusDoraWidgetTitlebarExBinding getBinding() {
        LarusDoraWidgetTitlebarExBinding r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final View getRightImg() {
        return getBinding().d;
    }

    public DoraNovaTitleBarEx(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        R5(r2, null);
    }

    public final void setRightTextEnable(boolean r3) {
        LarusDoraWidgetTitlebarExBinding r0 = getBinding();
        r0.f.setEnabled(r3);
        TextView r1 = r0.f;
        if (r3 == false) goto L5;
        float r4 = 1.0f;
    L6:
        r1.setAlpha(r4);
        return;
    L5:
        r4 = 0.3f;
        goto L6
    }

    public DoraNovaTitleBarEx(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        R5(r2, r3);
    }

    public static void S5(DoraNovaTitleBarEx r2, String r3) {
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "title");
        LarusDoraWidgetTitlebarExBinding r4 = r2.getBinding();
        r4.g.setVisibility(0);
        r4.g.setText(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void T5(DoraNovaTitleBarEx r3, View.OnClickListener r4) {
        LarusDoraWidgetTitlebarExBinding r0 = r3.getBinding();
        r0.b.setVisibility(0);
        r0.b.setColorFilter(ContextCompat.getColor(r3.getContext(), 2131103136));
        r0.c.setVisibility(8);
        r0.b.setImageResource(2131240517);
        e1.c(r0.b, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void U5(DoraNovaTitleBarEx r3, View.OnClickListener r4) {
        LarusDoraWidgetTitlebarExBinding r0 = r3.getBinding();
        r0.d.setVisibility(0);
        r0.f.setVisibility(8);
        r0.e.setVisibility(8);
        r0.d.setImageResource(2131240524);
        r0.d.setColorFilter(ContextCompat.getColor(r3.getContext(), 2131103136));
        e1.c(r0.d, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(Context r9, AttributeSet r10) {
        LayoutInflater.from(r9).inflate(2131562311, this);
        int r11 = 2131377782;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(this, 2131377782);
        if (r2 == null) goto L19;
        r11 = 2131377814;
        TextView r3 = (TextView) ViewBindings.findChildViewById(this, 2131377814);
        if (r3 == null) goto L19;
        r11 = 2131384596;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(this, 2131384596);
        if (r4 == null) goto L19;
        r11 = 2131384597;
        if (((ImageView) ViewBindings.findChildViewById(this, 2131384597)) == null) goto L19;
        r11 = 2131384605;
        ProgressBar r5 = (ProgressBar) ViewBindings.findChildViewById(this, 2131384605);
        if (r5 == null) goto L19;
        r11 = 2131384632;
        TextView r6 = (TextView) ViewBindings.findChildViewById(this, 2131384632);
        if (r6 == null) goto L19;
        r11 = 2131388915;
        TextView r7 = (TextView) ViewBindings.findChildViewById(this, 2131388915);
        if (r7 == null) goto L19;
        this.a = new LarusDoraWidgetTitlebarExBinding(this, r2, r3, r4, r5, r6, r7);
        return;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r11)));
    }

    public DoraNovaTitleBarEx(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        R5(r2, r3);
    }
}
