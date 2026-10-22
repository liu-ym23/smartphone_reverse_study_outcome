package com.obric.oui.segmentedtab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0007J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J0\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\u001aH\u0002J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u0007H\u0002J \u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u000e\u0010*\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010+\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010,\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0007J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u000e\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u0007J\u0010\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0014H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/oui/segmentedtab/UnReadMsgView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundColor", "cornerRadius", "gdBackground", "Landroid/graphics/drawable/GradientDrawable;", "isRadiusHalfHeight", "", "isWidthHeightEqual", "strokeColor", "strokeWidth", "dp2px", "dp", "", "getBackgroundColor", "getCornerRadius", "getStrokeColor", "getStrokeWidth", "obtainAttributes", "", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setBackgroundColor", "setBgSelector", "setCornerRadius", "setDrawable", "gd", TypedValues.Custom.S_COLOR, "setIsRadiusHalfHeight", "setIsWidthHeightEqual", "setStrokeColor", "setStrokeWidth", "show", "num", "sp2px", "sp", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnReadMsgView extends AppCompatTextView {
    private int backgroundColor;
    private int cornerRadius;
    private final GradientDrawable gdBackground;
    private boolean isRadiusHalfHeight;
    private boolean isWidthHeightEqual;
    private int strokeColor;
    private int strokeWidth;

    public UnReadMsgView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public UnReadMsgView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public UnReadMsgView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.gdBackground = new GradientDrawable();
        obtainAttributes(r6, r7);
    }

    public /* synthetic */ UnReadMsgView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final int dp2px(float r3) {
        return (int) ((r3 * ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics().density) + 0.5f);
    }

    private final boolean isRadiusHalfHeight() {
        return this.isRadiusHalfHeight;
    }

    private final boolean isWidthHeightEqual() {
        return this.isWidthHeightEqual;
    }

    private final void obtainAttributes(Context r4, AttributeSet r5) {
        TypedArray r6 = ((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.MsgView);
        Intrinsics.checkNotNullExpressionValue(r6, "context.obtainStyledAttr…trs, R.styleable.MsgView)");
        this.backgroundColor = r6.getColor(ZeusTransformUtils.mapRes(R.styleable.MsgView_mv_backgroundColor, "styleable", "MsgView_mv_backgroundColor"), 0);
        this.cornerRadius = r6.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MsgView_mv_cornerRadius, "styleable", "MsgView_mv_cornerRadius"), 0);
        this.strokeWidth = r6.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MsgView_mv_strokeWidth, "styleable", "MsgView_mv_strokeWidth"), 0);
        this.strokeColor = r6.getColor(ZeusTransformUtils.mapRes(R.styleable.MsgView_mv_strokeColor, "styleable", "MsgView_mv_strokeColor"), 0);
        this.isRadiusHalfHeight = r6.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MsgView_mv_isRadiusHalfHeight, "styleable", "MsgView_mv_isRadiusHalfHeight"), false);
        this.isWidthHeightEqual = r6.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MsgView_mv_isWidthHeightEqual, "styleable", "MsgView_mv_isWidthHeightEqual"), false);
        r6.recycle();
    }

    private final void setBgSelector() {
        StateListDrawable r0 = new StateListDrawable();
        setDrawable(this.gdBackground, this.backgroundColor, this.strokeColor);
        r0.addState(new int[]{-16842919}, (Drawable) ZeusTransformUtils.preCheckCast(this.gdBackground, Drawable.class, "com.obric.memorydata.plugin"));
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r0, Drawable.class, "com.obric.memorydata.plugin"));
    }

    private final void setCornerRadius(int r1) {
        this.cornerRadius = dp2px(r1);
        setBgSelector();
    }

    private final void setDrawable(GradientDrawable r1, int r2, int r3) {
        r1.setColor(r2);
        r1.setCornerRadius(this.cornerRadius);
        r1.setStroke(this.strokeWidth, r3);
    }

    private final void setStrokeWidth(int r1) {
        this.strokeWidth = dp2px(r1);
        setBgSelector();
    }

    private final int sp2px(float r3) {
        return (int) ((r3 * ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics().scaledDensity) + 0.5f);
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
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (isRadiusHalfHeight() == false) goto L5;
        setCornerRadius(getHeight() / 2);
        return;
    L5:
        setBgSelector();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r2, int r3) {
        if (isWidthHeightEqual() == true) goto L5;
    L10:
        super.onMeasure(r2, r3);
        return;
    L5:
        if (getWidth() <= 0) goto L10;
        if (getHeight() <= 0) goto L10;
        int r4 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(getWidth(), getHeight()), 1073741824);
        super.onMeasure(r4, r4);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        this.backgroundColor = r1;
        setBgSelector();
    }

    public final void setIsRadiusHalfHeight(boolean r1) {
        this.isRadiusHalfHeight = r1;
        setBgSelector();
    }

    public final void setIsWidthHeightEqual(boolean r1) {
        this.isWidthHeightEqual = r1;
        setBgSelector();
    }

    public final void setStrokeColor(int r1) {
        this.strokeColor = r1;
        setBgSelector();
    }

    public final void show(int r9) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, RelativeLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        DisplayMetrics r2 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(r2, "resources.displayMetrics");
        setVisibility(0);
        if (r9 > 0) goto L6;
        setStrokeWidth(0);
        setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
        float r10 = 5;
        r1.width = (int) (r2.density * r10);
        r1.height = (int) (r10 * r2.density);
    L5:
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        float r4 = 18;
        r1.height = (int) (r2.density * r4);
        boolean r6 = true;
        if (1 > r9) goto L10;
        if (r9 >= 10) goto L10;
        boolean r7 = true;
    L11:
        if (r7 == false) goto L15;
        r1.width = (int) (r4 * r2.density);
    L13:
        Object r11 = ZeusTransformUtils.preCheckCast(String.valueOf(r9), CharSequence.class, "com.obric.memorydata.plugin");
    L14:
        setText((CharSequence) r11);
        goto L5
    L15:
        if (10 <= r9) goto L17;
    L19:
        r6 = false;
    L20:
        r1.width = -2;
        if (r6 == false) goto L23;
        float r5 = 6;
        setPadding((int) (r2.density * r5), 0, (int) (r5 * r2.density), 0);
        goto L13
    L23:
        float r12 = 6;
        setPadding((int) (r2.density * r12), 0, (int) (r12 * r2.density), 0);
        r11 = ZeusTransformUtils.preCheckCast("99+", CharSequence.class, "com.obric.memorydata.plugin");
        goto L14
    L17:
        if (r9 >= 100) goto L19;
    L10:
        r7 = false;
        goto L11
    }
}
