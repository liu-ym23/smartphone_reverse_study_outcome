package com.larksuite.component.universe_design.progress;

import a18.c;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000 62\u00020\u0001:\u000256B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\"\u0010\u0018\u001a\u00020\u00192\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0014J(\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0014J\b\u0010%\u001a\u00020\u0019H\u0002J\u000e\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\nJ\u000e\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\nJ\u000e\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\nJ\u000e\u0010,\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\nJ\u000e\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u000fJ\u0010\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\nH\u0016J\u0018\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\nH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/larksuite/component/universe_design/progress/UDProgress;", "Landroid/widget/ProgressBar;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "FLOAT_ZERO", "", "onChangedListener", "Lcom/larksuite/component/universe_design/progress/UDProgress$OnChangeListener;", "getOnChangedListener", "()Lcom/larksuite/component/universe_design/progress/UDProgress$OnChangeListener;", "setOnChangedListener", "(Lcom/larksuite/component/universe_design/progress/UDProgress$OnChangeListener;)V", "progressSpec", "Lcom/larksuite/component/universe_design/progress/UDProgressSpec;", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "resetDrawable", "setType", "type", "setThickness", "thickness", "setTrackColor", "color", "setIndicatorColor", "setIndicatorCornerRadius", "radius", "setProgress", "progress", "animate", "", "animateProgress", "newProgress", "OnChangeListener", "Companion", "universe-ui-progress_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UDProgress extends ProgressBar {
    public final float a;
    public final z08.b b;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public final b getOnChangedListener() {
        return null;
    }

    public final void setOnChangedListener(b r1) {
    }

    public UDProgress(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        int r0 = r6.save();
        if (getPaddingLeft() == 0) goto L5;
    L6:
        r6.translate(getPaddingLeft(), getPaddingTop());
    L8:
        if (getPaddingRight() == 0) goto L10;
    L11:
        r6.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
    L12:
        getProgressDrawable().draw(r6);
        r6.restoreToCount(r0);
        return;
    L10:
        if (getPaddingBottom() == 0) goto L12;
    L5:
        if (getPaddingTop() == 0) goto L8;
        goto L6
    }

    public final void setIndicatorColor(int r3) {
        z08.b r0 = this.b;
        if (r0.d == r3) goto L6;
        r0.d = r3;
        invalidate();
        return;
    }

    public final void setIndicatorCornerRadius(float r3) {
        if (Math.abs(this.b.e - r3) <= this.a) goto L6;
        this.b.e = r3;
        invalidate();
        return;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r2) {
        if (getProgress() == r2) goto L8;
        super.setProgress(r2);
        z08.b r0 = this.b;
        if (r0 == null) goto L9;
        r0.f = r2;
        invalidate();
        return;
    L9:
        return;
    }

    public final void setThickness(int r3) {
        z08.b r0 = this.b;
        if (r0.b == r3) goto L6;
        r0.b = r3;
        requestLayout();
        invalidate();
        return;
    }

    public final void setTrackColor(int r3) {
        z08.b r0 = this.b;
        if (r0.c == r3) goto L6;
        r0.c = r3;
        invalidate();
        return;
    }

    public final void setType(int r4) {
        if (this.b.getType() == r4) goto L17;
        z08.b r0 = this.b;
        if (r4 != 0) goto L7;
        int r2 = 0;
    L8:
        r0.a = r2;
        if (r4 != 1) goto L12;
        r0.g = Math.min(getLayoutParams().width, getLayoutParams().height);
    L12:
        if (this.b.getType() != 0) goto L14;
        Drawable r5 = new a18.b(this.b);
    L15:
        setProgressDrawable(r5);
        requestLayout();
        invalidate();
        return;
    L14:
        r5 = new a18.a(this.b);
        goto L15
    L7:
        r2 = 1;
        goto L8
    }

    public UDProgress(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        Drawable r4 = getProgressDrawable();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.larksuite.component.universe_design.progress.drawable.ProgressDrawable");
        c r5 = (c) r4;
        int r6 = r5.e();
        int r7 = r5.d();
        if (r6 > 0) goto L5;
        int r8 = getMeasuredWidth();
    L6:
        if (r7 > 0) goto L8;
        int r9 = getMeasuredHeight();
    L9:
        setMeasuredDimension(r8, r9);
        return;
    L8:
        r9 = (r7 + getPaddingTop()) + getPaddingBottom();
        goto L9
    L5:
        r8 = (r6 + getPaddingLeft()) + getPaddingRight();
        goto L6
    }

    @Override // android.widget.ProgressBar
    public final void setProgress(int r3, boolean r4) {
        if (getProgress() == r3) goto L12;
        if (r4 == false) goto L10;
        Animation r5 = getAnimation();
        if (r5 == null) goto L8;
        r5.cancel();
    L8:
        ValueAnimator r6 = ValueAnimator.ofInt(new int[]{getProgress(), r3});
        r6.addUpdateListener(new z08.a(this));
        r6.addListener(new com.larksuite.component.universe_design.progress.a(this));
        r6.setDuration(300);
        r6.start();
        return;
    L10:
        setProgress(r3);
        return;
    }

    public UDProgress(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6, 0);
        this.a = 0.1f;
        z08.b r7 = new z08.b(0);
        this.b = r7;
        TypedArray r8 = getContext().obtainStyledAttributes(r5, new int[]{R.attr.layout_width, R.attr.layout_height, 2130974930, 2130974931, 2130974932, 2130974933, 2130974934}, r6, 0);
        r7.a = r8.getInt(6, 0);
        r7.b = r8.getDimensionPixelSize(4, 0);
        r7.c = r8.getColor(5, 0);
        r7.d = r8.getColor(2, 0);
        r7.e = r8.getDimensionPixelSize(3, 0);
        r7.f = getProgress();
        r7.g = Math.min(r8.getLayoutDimension(0, 0), r8.getLayoutDimension(0, 0));
        r8.recycle();
        if (r7.getType() != 0) goto L5;
        Drawable r9 = new a18.b(r7);
    L6:
        setProgressDrawable(r9);
        return;
    L5:
        r9 = new a18.a(r7);
        goto L6
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        int r5 = Math.min(r1, r2);
        z08.b r6 = this.b;
        if (r6.g == r5) goto L8;
        r6.g = r5;
        if (r6.getType() != 1) goto L9;
        requestLayout();
        invalidate();
        return;
    L9:
        return;
    }
}
