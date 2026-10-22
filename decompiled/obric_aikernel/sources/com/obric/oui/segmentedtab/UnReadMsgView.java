package com.obric.oui.segmentedtab;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u00103\u001a\u00020\b¢\u0006\u0004\b4\u00105J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J \u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0014J0\u0010#\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0014J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\bH\u0016J\u000e\u0010&\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010'\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010(\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010)\u001a\u00020\bJ\u0006\u0010*\u001a\u00020\bJ\u0006\u0010+\u001a\u00020\bJ\u0006\u0010,\u001a\u00020\bJ\u000e\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\bR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010/R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010/R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010/R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u00100R\u0016\u00101\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u0010$\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010/R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u00100¨\u00066"}, d2 = {"Lcom/obric/oui/segmentedtab/UnReadMsgView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "obtainAttributes", "", "cornerRadius", "setCornerRadius", "strokeWidth", "setStrokeWidth", "", "isRadiusHalfHeight", "isWidthHeightEqual", "", "dp", "dp2px", "sp", "sp2px", "Landroid/graphics/drawable/GradientDrawable;", "gd", TypedValues.Custom.S_COLOR, "strokeColor", "setDrawable", "setBgSelector", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "left", "top", "right", "bottom", "onLayout", "backgroundColor", "setBackgroundColor", "setStrokeColor", "setIsRadiusHalfHeight", "setIsWidthHeightEqual", "getBackgroundColor", "getCornerRadius", "getStrokeWidth", "getStrokeColor", "num", "show", "I", "Z", "gdBackground", "Landroid/graphics/drawable/GradientDrawable;", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class UnReadMsgView extends AppCompatTextView {
    private int backgroundColor;
    private int cornerRadius;
    private final GradientDrawable gdBackground;
    private boolean isRadiusHalfHeight;
    private boolean isWidthHeightEqual;
    private int strokeColor;
    private int strokeWidth;

    @JvmOverloads
    public UnReadMsgView(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public UnReadMsgView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public UnReadMsgView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.gdBackground = new GradientDrawable();
        obtainAttributes(r10, r11);
    }

    public /* synthetic */ UnReadMsgView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final int dp2px(float r10) {
        Context r11 = getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        Resources r12 = r11.getResources();
        Intrinsics.checkNotNullExpressionValue(r12, "context.resources");
        return (int) ((r10 * r12.getDisplayMetrics().density) + 0.5f);
    }

    private final boolean isRadiusHalfHeight() {
        return this.isRadiusHalfHeight;
    }

    private final boolean isWidthHeightEqual() {
        return this.isWidthHeightEqual;
    }

    private final void obtainAttributes(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, l.MsgView);
        Intrinsics.checkNotNullExpressionValue(r12, "context.obtainStyledAttr…trs, R.styleable.MsgView)");
        this.backgroundColor = r12.getColor(l.MsgView_mv_backgroundColor, 0);
        this.cornerRadius = r12.getDimensionPixelSize(l.MsgView_mv_cornerRadius, 0);
        this.strokeWidth = r12.getDimensionPixelSize(l.MsgView_mv_strokeWidth, 0);
        this.strokeColor = r12.getColor(l.MsgView_mv_strokeColor, 0);
        this.isRadiusHalfHeight = r12.getBoolean(l.MsgView_mv_isRadiusHalfHeight, false);
        this.isWidthHeightEqual = r12.getBoolean(l.MsgView_mv_isWidthHeightEqual, false);
        r12.recycle();
    }

    private final void setBgSelector() {
        StateListDrawable r10 = new StateListDrawable();
        setDrawable(this.gdBackground, this.backgroundColor, this.strokeColor);
        r10.addState(new int[]{-16842919}, this.gdBackground);
        setBackground(r10);
    }

    private final void setCornerRadius(int r10) {
        this.cornerRadius = dp2px(r10);
        setBgSelector();
    }

    private final void setDrawable(GradientDrawable r10, int r11, int r12) {
        r10.setColor(r11);
        r10.setCornerRadius(this.cornerRadius);
        r10.setStroke(this.strokeWidth, r12);
    }

    private final void setStrokeWidth(int r10) {
        this.strokeWidth = dp2px(r10);
        setBgSelector();
    }

    private final int sp2px(float r10) {
        Context r11 = getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        Resources r12 = r11.getResources();
        Intrinsics.checkNotNullExpressionValue(r12, "context.resources");
        return (int) ((r10 * r12.getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getCornerRadius() {
        return this.cornerRadius;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final int getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        if (isRadiusHalfHeight() == false) goto L5;
        setCornerRadius(getHeight() / 2);
        return;
    L5:
        setBgSelector();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int r10, int r11) {
        if (isWidthHeightEqual() == true) goto L5;
    L10:
        super.onMeasure(r10, r11);
        return;
    L5:
        if (getWidth() <= 0) goto L10;
        if (getHeight() <= 0) goto L10;
        int r12 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(getWidth(), getHeight()), 1073741824);
        super.onMeasure(r12, r12);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r10) {
        this.backgroundColor = r10;
        setBgSelector();
    }

    public final void setIsRadiusHalfHeight(boolean r10) {
        this.isRadiusHalfHeight = r10;
        setBgSelector();
    }

    public final void setIsWidthHeightEqual(boolean r10) {
        this.isWidthHeightEqual = r10;
        setBgSelector();
    }

    public final void setStrokeColor(int r10) {
        this.strokeColor = r10;
        setBgSelector();
    }

    public final void show(int r10) {
        ViewGroup.LayoutParams r11 = getLayoutParams();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) r11;
        Resources r13 = getResources();
        Intrinsics.checkNotNullExpressionValue(r13, "resources");
        DisplayMetrics r14 = r13.getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(r14, "resources.displayMetrics");
        setVisibility(0);
        if (r10 > 0) goto L6;
        setStrokeWidth(0);
        setText("");
        float r15 = 5;
        float r16 = r14.density;
        r12.width = (int) (r15 * r16);
        r12.height = (int) (r15 * r16);
    L5:
        setLayoutParams(r12);
        return;
    L6:
        float r17 = 18;
        float r18 = r14.density;
        r12.height = (int) (r17 * r18);
        if (1 > r10) goto L14;
        if (9 < r10) goto L14;
        r12.width = (int) (r17 * r18);
    L11:
        CharSequence r19 = String.valueOf(r10);
    L12:
        setText(r19);
    L14:
        if (10 > r10) goto L18;
        if (99 < r10) goto L18;
        r12.width = -2;
        float r20 = 6;
        setPadding((int) (r20 * r18), 0, (int) (r20 * r18), 0);
    L18:
        r12.width = -2;
        float r21 = 6;
        setPadding((int) (r21 * r18), 0, (int) (r21 * r18), 0);
        r19 = "99+";
        goto L12
    }
}
