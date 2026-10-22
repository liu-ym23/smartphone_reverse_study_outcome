package com.obric.oui.badge;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.ies.xelement.input.f;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$styleable;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0011J\u0019\u0010\u0019\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/badge/OBadgeView;", "Lcom/obric/oui/text/OTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "contentDescription", "", "setContentDescription", "(Ljava/lang/CharSequence;)V", "color", "setTextColor", "(I)V", "", "enabled", "setEnableFontScale", "(Z)V", "setBackgroundColor", "Landroid/graphics/drawable/Drawable;", "background", "setBackground", "(Landroid/graphics/drawable/Drawable;)V", "maxNumber", "setMaxNumberInCount", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBadgeView extends OTextView {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f11975i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11976j;

    @JvmOverloads
    public OBadgeView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final void a() {
        b r5 = this.f11975i;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        b r10 = null;
    L6:
        CharSequence r11 = getText();
        if (r11 != null) goto L9;
        String r12 = null;
    L10:
        r10.d(r12);
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        b r13 = null;
    L14:
        int r14 = getCurrentTextColor();
        if (r13.D == r14) goto L18;
        r13.D = r14;
        r13.f11985l.setColor(r14);
        r13.invalidateSelf();
    L18:
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        b r15 = null;
    L21:
        r15.e(this.f11976j);
        e(getTextSize());
        Drawable r16 = getBackground();
        if ((r16 instanceof ColorDrawable) == false) goto L27;
        if (r5 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r5 = null;
    L25:
        r5.c(((ColorDrawable) r16).getColor());
        return;
    L27:
        return;
    L20:
        r15 = r5;
        goto L21
    L13:
        r13 = r5;
        goto L14
    L9:
        r12 = r11.toString();
        goto L10
    L5:
        r10 = r5;
        goto L6
    }

    public final void e(float r5) {
        float r10 = r5 / getResources().getDisplayMetrics().scaledDensity;
        b r11 = this.f11975i;
        if (r11 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r11 = null;
    L6:
        if (r11.F == r10) goto L14;
        r11.F = r10;
        DisplayMetrics r12 = r11.f11978a.getResources().getDisplayMetrics();
        TextPaint r13 = r11.f11985l;
        if (r11.E == false) goto L11;
        float r14 = TypedValue.applyDimension(2, r11.F, r12);
    L12:
        r13.setTextSize(r14);
        r11.a();
        return;
    L11:
        r14 = TypedValue.applyDimension(1, r11.F, r12);
        goto L12
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r5) {
        Intrinsics.checkNotNullParameter(r5, "drawable");
        b r10 = this.f11975i;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r10 = null;
    L6:
        if (Intrinsics.areEqual(r5, r10) == false) goto L8;
        invalidate();
        return;
    L8:
        super.invalidateDrawable(r5);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        b r10 = this.f11975i;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r10 = null;
    L5:
        r10.draw(r5);
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        if (r5 == true) goto L5;
        return;
    L5:
        if (getWidth() > 0) goto L7;
        return;
    L7:
        if (getHeight() <= 0) goto L15;
        b r14 = this.f11975i;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r14 = null;
    L11:
        r14.getClass();
        Intrinsics.checkNotNullParameter(this, "anchor");
        r14.f(this, null);
        return;
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r10, int r11) {
        b r5 = this.f11975i;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        b r12 = null;
    L6:
        r12.getClass();
        Intrinsics.checkNotNullParameter(this, "anchor");
        r12.f(this, null);
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r5 = null;
    L9:
        Rect r13 = r5.getBounds();
        int r14 = r13.width();
        int r15 = r13.height();
        setMeasuredDimension(View.resolveSize((getPaddingRight() + getPaddingLeft()) + r14, r10), View.resolveSize((getPaddingBottom() + getPaddingTop()) + r15, r11));
        return;
    L5:
        r12 = r5;
        goto L6
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L12;
        b r13 = this.f11975i;
        if (r13 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r13 = null;
    L9:
        r13.getClass();
        Intrinsics.checkNotNullParameter(this, "anchor");
        r13.f(this, null);
        return;
    }

    @Override // android.view.View
    public void setBackground(Drawable r5) {
        b r10 = this.f11975i;
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r5 instanceof ColorDrawable) == false) goto L7;
        ColorDrawable r11 = (ColorDrawable) r5;
    L8:
        if (r11 == null) goto L15;
        if (r10 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r10 = null;
    L12:
        r10.c(r11.getColor());
        invalidate();
        return;
    L15:
        return;
    L7:
        r11 = null;
        goto L8
    }

    @Override // android.view.View
    public void setBackgroundColor(int r5) {
        b r10 = this.f11975i;
        if (r10 == null) goto L8;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r10 = null;
    L6:
        r10.c(r5);
        invalidate();
        return;
    }

    @Override // android.view.View
    public void setContentDescription(CharSequence r5) {
        super.setContentDescription(r5);
        b r10 = this.f11975i;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r10 = null;
    L5:
        r10.getClass();
    }

    public final void setEnableFontScale(boolean r5) {
        if (this.f11976j != r5) goto L5;
        return;
    L5:
        this.f11976j = r5;
        b r10 = this.f11975i;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r10 = null;
    L8:
        r10.e(r5);
        a();
        requestLayout();
        invalidate();
    }

    @Override // com.obric.oui.text.OTextView
    public /* bridge */ /* synthetic */ void setFakePressed(boolean r5) {
    }

    public final void setMaxNumberInCount(int r5) {
        b r10 = this.f11975i;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r10 = null;
    L5:
        r10.getClass();
        if (r5 >= 1) goto L9;
        r5 = 1;
    L9:
        if (r10.f11998z == r5) goto L12;
        r10.f11998z = r5;
        r10.f11996x = r10.b(r10.f11996x);
        r10.a();
    L12:
        requestLayout();
        invalidate();
    }

    @Override // android.widget.TextView
    public void setTextColor(int r5) {
        b r10 = this.f11975i;
        if (r10 == null) goto L10;
        super.setTextColor(r5);
        int r11 = getCurrentTextColor();
        if (r10.D == r11) goto L8;
        r10.D = r11;
        r10.f11985l.setColor(r11);
        r10.invalidateSelf();
    L8:
        invalidate();
        return;
    }

    @Override // android.widget.TextView
    public final void setTextSize(int r5, float r10) {
        super.setTextSize(r5, r10);
        if (this.f11975i == null) goto L5;
        e(getTextSize());
    L5:
        requestLayout();
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable r5) {
        Intrinsics.checkNotNullParameter(r5, "who");
        if (super.verifyDrawable(r5) == true) goto L11;
        b r10 = this.f11975i;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r10 = null;
    L8:
        if (Intrinsics.areEqual(r5, r10) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @JvmOverloads
    public OBadgeView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OBadgeView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OBadgeView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11, 8);
        int r12 = 1;
        this.f11976j = true;
        int r13 = b.G;
        Intrinsics.checkNotNullParameter(r5, "context");
        b r14 = new b(r5);
        this.f11975i = r14;
        r14.setCallback(this);
        OBadgeDrawable$BadgeGravity r15 = OBadgeDrawable$BadgeGravity.CENTER;
        Intrinsics.checkNotNullParameter(r15, "value");
        if (r14.A == r15) goto L6;
        r14.A = r15;
        r14.a();
    L6:
        if (r10 != null) goto L8;
        getContentDescription();
    L43:
        a();
        addTextChangedListener(new f(this, 2));
        return;
    L8:
        TypedArray r16 = getContext().obtainStyledAttributes(r10, R$styleable.OBadgeView, r11, 0);
        boolean r17 = r16.getBoolean(R$styleable.OBadgeView_oui_widgetEnableFontScale, true);     // Catch: Throwable -> L28
        this.f11976j = r17;     // Catch: Throwable -> L28
        r14.e(r17);     // Catch: Throwable -> L28
        int r18 = r16.getInt(R$styleable.OBadgeView_o_maxNumber, r14.f11998z);     // Catch: Throwable -> L28
        if (r18 < 1) goto L14;
        r12 = r18;
    L14:
        if (r14.f11998z == r12) goto L17;
        r14.f11998z = r12;     // Catch: Throwable -> L28
        r14.f11996x = r14.b(r14.f11996x);     // Catch: Throwable -> L28
        r14.a();     // Catch: Throwable -> L28
    L17:
        Integer r19 = Integer.valueOf(r16.getColor(R$styleable.OBadgeView_oui_badgeview_ellipsis_color, 0));     // Catch: Throwable -> L28
        String r20 = null;
        if (Intrinsics.areEqual(r14.f11997y, r19) == true) goto L22;
        r14.f11997y = r19;     // Catch: Throwable -> L28
        r14.f11996x = null;     // Catch: Throwable -> L28
        r14.a();     // Catch: Throwable -> L28
    L22:
        if (r16.hasValue(R$styleable.OBadgeView_android_text) == false) goto L31;
        CharSequence r21 = r16.getText(R$styleable.OBadgeView_android_text);     // Catch: Throwable -> L28
        if (r21 == null) goto L27;
        r20 = r21.toString();     // Catch: Throwable -> L28
    L27:
        r14.d(r20);     // Catch: Throwable -> L28
    L31:
        if (r16.hasValue(R$styleable.OBadgeView_android_textColor) == false) goto L37;
        int r22 = r16.getColor(R$styleable.OBadgeView_android_textColor, getCurrentTextColor());     // Catch: Throwable -> L28
        if (r14.D == r22) goto L37;
        r14.D = r22;     // Catch: Throwable -> L28
        r14.f11985l.setColor(r22);     // Catch: Throwable -> L28
        r14.invalidateSelf();     // Catch: Throwable -> L28
    L37:
        if (r16.hasValue(R$styleable.OBadgeView_android_textSize) == false) goto L40;
        e(r16.getDimension(R$styleable.OBadgeView_android_textSize, getTextSize()));     // Catch: Throwable -> L28
    L40:
        if (r16.hasValue(R$styleable.OBadgeView_android_background) == false) goto L42;
        r14.c(r16.getColor(R$styleable.OBadgeView_android_background, ContextCompat.getColor(getContext(), R$color.oui_red_6)));     // Catch: Throwable -> L28
    L42:
        r16.recycle();
        getContentDescription();
    L28:
        th = move-exception;
        r16.recycle();
        throw th;
    }
}
