package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ContentFrameLayout extends FrameLayout {
    private OnAttachListener mAttachListener;
    private final Rect mDecorPadding;
    private TypedValue mFixedHeightMajor;
    private TypedValue mFixedHeightMinor;
    private TypedValue mFixedWidthMajor;
    private TypedValue mFixedWidthMinor;
    private TypedValue mMinWidthMajor;
    private TypedValue mMinWidthMinor;

    public interface OnAttachListener {
        void onAttachedFromWindow();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(@NonNull Context r5) {
        this(r5, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void dispatchFitSystemWindows(Rect r5) {
        fitSystemWindows(r5);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.mFixedHeightMajor != null) goto L6;
        this.mFixedHeightMajor = new TypedValue();
    L6:
        return this.mFixedHeightMajor;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.mFixedHeightMinor != null) goto L6;
        this.mFixedHeightMinor = new TypedValue();
    L6:
        return this.mFixedHeightMinor;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.mFixedWidthMajor != null) goto L6;
        this.mFixedWidthMajor = new TypedValue();
    L6:
        return this.mFixedWidthMajor;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.mFixedWidthMinor != null) goto L6;
        this.mFixedWidthMinor = new TypedValue();
    L6:
        return this.mFixedWidthMinor;
    }

    public TypedValue getMinWidthMajor() {
        if (this.mMinWidthMajor != null) goto L6;
        this.mMinWidthMajor = new TypedValue();
    L6:
        return this.mMinWidthMajor;
    }

    public TypedValue getMinWidthMinor() {
        if (this.mMinWidthMinor != null) goto L6;
        this.mMinWidthMinor = new TypedValue();
    L6:
        return this.mMinWidthMinor;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OnAttachListener r5 = this.mAttachListener;
        if (r5 == null) goto L6;
        r5.onAttachedFromWindow();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnAttachListener r5 = this.mAttachListener;
        if (r5 == null) goto L6;
        r5.onDetachedFromWindow();
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r14, int r15) {
        DisplayMetrics r5 = getContext().getResources().getDisplayMetrics();
        boolean r10 = true;
        if (r5.widthPixels >= r5.heightPixels) goto L5;
        boolean r11 = true;
    L6:
        int r12 = View.MeasureSpec.getMode(r14);
        int r13 = View.MeasureSpec.getMode(r15);
        if (r12 != Integer.MIN_VALUE) goto L22;
        if (r11 == false) goto L10;
        TypedValue r16 = this.mFixedWidthMinor;
    L11:
        if (r16 == null) goto L22;
        int r17 = r16.type;
        if (r17 == 0) goto L22;
        if (r17 != 5) goto L17;
        float r18 = r16.getDimension(r5);
    L16:
        int r19 = (int) r18;
    L20:
        if (r19 <= 0) goto L22;
        Rect r110 = this.mDecorPadding;
        r14 = View.MeasureSpec.makeMeasureSpec(Math.min(r19 - (r110.left + r110.right), View.MeasureSpec.getSize(r14)), BasicMeasure.EXACTLY);
        boolean r111 = true;
    L23:
        if (r13 != Integer.MIN_VALUE) goto L38;
        if (r11 == false) goto L26;
        TypedValue r20 = this.mFixedHeightMajor;
    L27:
        if (r20 == null) goto L38;
        int r112 = r20.type;
        if (r112 == 0) goto L38;
        if (r112 != 5) goto L33;
        float r21 = r20.getDimension(r5);
    L32:
        int r22 = (int) r21;
    L36:
        if (r22 <= 0) goto L38;
        Rect r113 = this.mDecorPadding;
        r15 = View.MeasureSpec.makeMeasureSpec(Math.min(r22 - (r113.top + r113.bottom), View.MeasureSpec.getSize(r15)), BasicMeasure.EXACTLY);
        goto L38
    L33:
        if (r112 != 6) goto L35;
        int r114 = r5.heightPixels;
        r21 = r20.getFraction(r114, r114);
        goto L32
    L35:
        r22 = 0;
        goto L36
    L26:
        r20 = this.mFixedHeightMinor;
    L38:
        super.onMeasure(r14, r15);
        int r115 = getMeasuredWidth();
        int r23 = View.MeasureSpec.makeMeasureSpec(r115, BasicMeasure.EXACTLY);
        if (r111 == true) goto L57;
        if (r12 != Integer.MIN_VALUE) goto L57;
        if (r11 == false) goto L43;
        TypedValue r24 = this.mMinWidthMinor;
    L44:
        if (r24 == null) goto L57;
        int r25 = r24.type;
        if (r25 == 0) goto L57;
        if (r25 != 5) goto L50;
        float r26 = r24.getDimension(r5);
    L49:
        int r27 = (int) r26;
    L53:
        if (r27 <= 0) goto L55;
        Rect r28 = this.mDecorPadding;
        r27 = r27 - (r28.left + r28.right);
    L55:
        if (r115 >= r27) goto L57;
        r23 = View.MeasureSpec.makeMeasureSpec(r27, BasicMeasure.EXACTLY);
    L58:
        if (r10 == false) goto L61;
        super.onMeasure(r23, r15);
        return;
    L61:
        return;
    L50:
        if (r25 != 6) goto L52;
        int r29 = r5.widthPixels;
        r26 = r24.getFraction(r29, r29);
        goto L49
    L52:
        r27 = 0;
        goto L53
    L43:
        r24 = this.mMinWidthMajor;
    L57:
        r10 = false;
        goto L58
    L17:
        if (r17 != 6) goto L19;
        int r116 = r5.widthPixels;
        r18 = r16.getFraction(r116, r116);
        goto L16
    L19:
        r19 = 0;
        goto L20
    L10:
        r16 = this.mFixedWidthMajor;
    L22:
        r111 = false;
        goto L23
    L5:
        r11 = false;
        goto L6
    }

    public void setAttachListener(OnAttachListener r5) {
        this.mAttachListener = r5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setDecorPadding(int r5, int r10, int r11, int r12) {
        this.mDecorPadding.set(r5, r10, r11, r12);
        if (ViewCompat.isLaidOut(this) == false) goto L6;
        requestLayout();
        return;
    }

    public ContentFrameLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public ContentFrameLayout(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.mDecorPadding = new Rect();
    }
}
