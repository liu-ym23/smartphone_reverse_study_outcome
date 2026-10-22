package com.obric.oui.badge;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/badge/OBadgeView;", "Lcom/obric/oui/text/OTextView;", "", "contentDescription", "", "setContentDescription", "", "color", "setTextColor", "", "enabled", "setEnableFontScale", "setBackgroundColor", "Landroid/graphics/drawable/Drawable;", "background", "setBackground", "maxNumber", "setMaxNumberInCount", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OBadgeView extends OTextView {
    public final OBadgeDrawable i;
    public boolean j;

    public static final class a implements TextWatcher {
        public final /* synthetic */ OBadgeView a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public a(OBadgeView r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            OBadgeDrawable r5 = this.a.i;
            String r6 = null;
            if (r5 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("badge");
            r5 = null;
        L5:
            if (r1 == null) goto L8;
            r6 = r1.toString();
        L8:
            r5.d(r6);
            this.a.requestLayout();
            this.a.invalidate();
        }
    }

    public static final class b {
    }

    static {
    }

    public OBadgeView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OBadgeView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r1) {
    }

    public /* bridge */ /* synthetic */ void setFakePressed(boolean r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        OBadgeDrawable r0 = this.i;
        OBadgeDrawable r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L5:
        CharSequence r3 = getText();
        if (r3 != null) goto L8;
        String r4 = null;
    L9:
        r0.d(r4);
        OBadgeDrawable r1 = this.i;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r1 = null;
    L12:
        int r5 = getCurrentTextColor();
        if (r1.D == r5) goto L16;
        r1.D = r5;
        r1.l.setColor(r5);
        r1.invalidateSelf();
    L16:
        OBadgeDrawable r6 = this.i;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r6 = null;
    L19:
        r6.e(this.j);
        c(getTextSize());
        Drawable r7 = getBackground();
        if ((r7 instanceof ColorDrawable) == false) goto L27;
        OBadgeDrawable r8 = this.i;
        if (r8 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
    L25:
        r2.c(((ColorDrawable) r7).getColor());
        return;
    L24:
        r2 = r8;
        goto L25
    L27:
        return;
    L8:
        r4 = r3.toString();
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(float r5) {
        Resources r0 = getResources();
        float r6 = r5 / WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).scaledDensity;
        OBadgeDrawable r1 = this.i;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r1 = null;
    L6:
        if (r1.F != r6) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L17;
        r1.F = r6;
        Resources r7 = r1.a.getResources();
        DisplayMetrics r8 = WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics());
        TextPaint r3 = r1.l;
        if (r1.E == false) goto L14;
        float r9 = TypedValue.applyDimension(2, r1.F, r8);
    L15:
        r3.setTextSize(r9);
        r1.a();
        return;
    L14:
        r9 = TypedValue.applyDimension(1, r1.F, r8);
        goto L15
    L17:
        return;
    L8:
        r2 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invalidateDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        OBadgeDrawable r0 = this.i;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L6:
        if (Intrinsics.areEqual(r2, r0) == false) goto L8;
        invalidate();
        return;
    L8:
        super/*android.widget.TextView*/.invalidateDrawable(r2);
    }

    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        OBadgeDrawable r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L5:
        r0.draw(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackground(Drawable r4) {
        OBadgeDrawable r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r4 instanceof ColorDrawable) == false) goto L7;
        ColorDrawable r5 = (ColorDrawable) r4;
    L8:
        if (r5 == null) goto L15;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L12:
        r0.c(r5.getColor());
        invalidate();
        return;
    L15:
        return;
    L7:
        r5 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundColor(int r2) {
        OBadgeDrawable r0 = this.i;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L6:
        r0.c(r2);
        invalidate();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setContentDescription(CharSequence r1) {
        super/*android.widget.TextView*/.setContentDescription(r1);
        OBadgeDrawable r2 = this.i;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r2 = null;
    L5:
        r2.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setEnableFontScale(boolean r2) {
        if (this.j != r2) goto L5;
        return;
    L5:
        this.j = r2;
        OBadgeDrawable r0 = this.i;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L8:
        r0.e(r2);
        b();
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setMaxNumberInCount(int r3) {
        OBadgeDrawable r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L5:
        r0.getClass();
        if (r3 >= 1) goto L9;
        r3 = 1;
    L9:
        if (r0.z == r3) goto L12;
        r0.z = r3;
        r0.x = r0.b(r0.x);
        r0.a();
    L12:
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextColor(int r3) {
        if (this.i == null) goto L13;
        super/*android.widget.TextView*/.setTextColor(r3);
        OBadgeDrawable r4 = this.i;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r4 = null;
    L7:
        int r0 = getCurrentTextColor();
        if (r4.D == r0) goto L11;
        r4.D = r0;
        r4.l.setColor(r0);
        r4.invalidateSelf();
    L11:
        invalidate();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean verifyDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "who");
        if (super/*android.widget.TextView*/.verifyDrawable(r2) == true) goto L11;
        OBadgeDrawable r0 = this.i;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L8:
        if (Intrinsics.areEqual(r2, r0) == true) goto L11;
        return false;
    L11:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r5, int r6) {
        OBadgeDrawable r0 = this.i;
        OBadgeDrawable r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "anchor");
        r0.f(this, null);
        OBadgeDrawable r2 = this.i;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
    L9:
        Rect r3 = r1.getBounds();
        int r4 = r3.width();
        int r7 = r3.height();
        setMeasuredDimension(TextView.resolveSize(r4 + (getPaddingLeft() + getPaddingRight()), r5), TextView.resolveSize(r7 + (getPaddingTop() + getPaddingBottom()), r6));
        return;
    L8:
        r1 = r2;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTextSize(int r1, float r2) {
        super/*android.widget.TextView*/.setTextSize(r1, r2);
        if (this.i == null) goto L5;
        c(getTextSize());
    L5:
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OBadgeView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7, 8);
        this.j = true;
        int r2 = OBadgeDrawable.G;
        Intrinsics.checkNotNullParameter(r5, "context");
        OBadgeDrawable r0 = new OBadgeDrawable(r5);
        this.i = r0;
        r0.setCallback(this);
        OBadgeDrawable.BadgeGravity r8 = OBadgeDrawable.BadgeGravity.CENTER;
        Intrinsics.checkNotNullParameter(r8, "value");
        if (r0.A == r8) goto L6;
        r0.A = r8;
        r0.a();
    L6:
        if (r6 != null) goto L8;
        getContentDescription();
    L40:
        b();
        addTextChangedListener(new a(this));
        return;
    L8:
        TypedArray r9 = getContext().obtainStyledAttributes(r6, new int[]{R.attr.textSize, R.attr.textColor, R.attr.background, R.attr.text, 2130972873, 2130973039, 2130973373}, r7, 0);
        boolean r10 = r9.getBoolean(6, true);     // Catch: Throwable -> L42
        this.j = r10;     // Catch: Throwable -> L42
        r0.e(r10);     // Catch: Throwable -> L42
        int r11 = r9.getInt(4, r0.z);     // Catch: Throwable -> L42
        if (r11 >= 1) goto L13;
        r11 = 1;
    L13:
        if (r0.z == r11) goto L16;
        r0.z = r11;     // Catch: Throwable -> L42
        r0.x = r0.b(r0.x);     // Catch: Throwable -> L42
        r0.a();     // Catch: Throwable -> L42
    L16:
        Integer r12 = Integer.valueOf(r9.getColor(5, 0));     // Catch: Throwable -> L42
        String r3 = null;
        if (Intrinsics.areEqual(r0.y, r12) == true) goto L21;
        r0.y = r12;     // Catch: Throwable -> L42
        r0.x = null;     // Catch: Throwable -> L42
        r0.a();     // Catch: Throwable -> L42
    L21:
        if (r9.hasValue(3) == false) goto L28;
        CharSequence r13 = r9.getText(3);     // Catch: Throwable -> L42
        if (r13 == null) goto L26;
        r3 = r13.toString();     // Catch: Throwable -> L42
    L26:
        r0.d(r3);     // Catch: Throwable -> L42
    L28:
        if (r9.hasValue(1) == false) goto L34;
        int r14 = r9.getColor(1, getCurrentTextColor());     // Catch: Throwable -> L42
        if (r0.D == r14) goto L34;
        r0.D = r14;     // Catch: Throwable -> L42
        r0.l.setColor(r14);     // Catch: Throwable -> L42
        r0.invalidateSelf();     // Catch: Throwable -> L42
    L34:
        if (r9.hasValue(0) == false) goto L37;
        c(r9.getDimension(0, getTextSize()));     // Catch: Throwable -> L42
    L37:
        if (r9.hasValue(2) == false) goto L39;
        r0.c(r9.getColor(2, ContextCompat.getColor(getContext(), 2131105369)));     // Catch: Throwable -> L42
    L39:
        r9.recycle();
        getContentDescription();
    L42:
        th = move-exception;
        r9.recycle();
        throw th;
    }

    public /* synthetic */ OBadgeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.TextView*/.onSizeChanged(r1, r2, r3, r4);
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L12;
        OBadgeDrawable r5 = this.i;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r5 = null;
    L9:
        r5.getClass();
        Intrinsics.checkNotNullParameter(this, "anchor");
        r5.f(this, null);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (r1 == true) goto L5;
        return;
    L5:
        if (getWidth() > 0) goto L7;
        return;
    L7:
        if (getHeight() <= 0) goto L15;
        OBadgeDrawable r6 = this.i;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r6 = null;
    L11:
        r6.getClass();
        Intrinsics.checkNotNullParameter(this, "anchor");
        r6.f(this, null);
        return;
    }
}
