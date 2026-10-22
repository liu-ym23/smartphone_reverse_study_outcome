package com.larus.common_ui.toast;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J5\u0010\u0015\u001a\u00020\u000f2\u001b\b\u0002\u0010\u0016\u001a\u0015\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00192\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ$\u0010\u0015\u001a\u00020\u000f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ)\u0010\u0015\u001a\u00020\u000f2\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001fJ?\u0010 \u001a\u00020\u000f2\b\b\u0001\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0#H\u0000¢\u0006\u0002\b$J\u0012\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/common_ui/toast/ToastLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/text/TextPaint;", "setYOffsetPx", "", "yOffsetPx", "(Ljava/lang/Integer;)V", "updateText", "text", "", "setContent", "config", "Lkotlin/Function1;", "Lcom/lynx/lottieadapter/LottieAdapterView;", "Lkotlin/ExtensionFunctionType;", "isForceDarkMode", "", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "iconResId", "(Ljava/lang/Integer;Ljava/lang/CharSequence;Z)V", "setActionContent", "actionText", "onActionClick", "Lkotlin/Function0;", "setActionContent$common_ui_mainlandRelease", "adapterContentDarkMode", "shouldUseMultiLine", "hasImage", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToastLayout extends ConstraintLayout {
    public final TextPaint a;

    public ToastLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        TextPaint r5 = new TextPaint();
        r5.setTextSize(i5.x0(c.b(2130972273, null, 2131167616)));
        this.a = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(boolean r3) {
        if (r3 == false) goto L5;
        ((LinearLayout) findViewById(2131377659)).setBackgroundResource(2131243492);
        ((TextView) findViewById(2131388386)).setTextColor(ContextCompat.getColor(getContext(), 2131103298));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setYOffsetPx(Integer r7) {
        LinearLayout r0 = (LinearLayout) findViewById(2131377659);
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        int r3 = getResources().getDimensionPixelSize(c.b(2130971536, null, 2131167441));
        if (r7 == null) goto L14;
        int r8 = r7.intValue();
    L15:
        r2.topMargin = r3 + r8;
        r0.setLayoutParams(r2);
        return;
    L14:
        r8 = 0;
        goto L15
    L8:
        r2 = null;
        goto L9
    }

    public ToastLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        TextPaint r5 = new TextPaint();
        r5.setTextSize(i5.x0(c.b(2130972273, null, 2131167616)));
        this.a = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean T5(boolean r7, CharSequence r8) {
        Resources r0 = getContext().getResources();
        int r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).widthPixels;
        float r2 = 0.0f;
        if (r7 == false) goto L5;
        float r3 = i5.x0(c.b(2130971299, null, 2131166968));
    L6:
        if (r7 == false) goto L8;
        r2 = i5.x0(c.b(2130971546, null, 2131167462));
    L8:
        float r4 = 2;
        if (this.a.measureText(r8, 0, r8.length()) <= ((((r1 - (i5.x0(c.b(2130971208, null, 2131166786)) * r4)) - (r4 * i5.x0(c.b(2130971255, null, 2131166880)))) - r3) - r2)) goto L12;
        return true;
    L12:
        return false;
    L5:
        r3 = 0.0f;
        goto L6
    }

    public ToastLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        TextPaint r5 = new TextPaint();
        r5.setTextSize(i5.x0(c.b(2130972273, null, 2131167616)));
        this.a = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(Integer r3, CharSequence r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "text");
        if (r3 != null) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (T5(r0, r4) == false) goto L11;
        ViewGroup.inflate(getContext(), 2131562900, this);
    L12:
        R5(r5);
        TextView r6 = (TextView) findViewById(2131388386);
        LottieAdapterView r1 = findViewById(2131379210);
        if (r3 != null) goto L15;
    L18:
        r1.setVisibility(8);
    L19:
        r6.setText(r4);
        return;
    L15:
        if (r3.intValue() == 0) goto L18;
        r1.setImageResource(r3.intValue());
        goto L19
    L11:
        ViewGroup.inflate(getContext(), 2131562899, this);
        goto L12
    L5:
        if (r3.intValue() == 0) goto L7;
        r0 = true;
        goto L9
    }
}
