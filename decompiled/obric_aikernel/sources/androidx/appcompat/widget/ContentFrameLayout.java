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

    public ContentFrameLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public ContentFrameLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ContentFrameLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mDecorPadding = new Rect();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void dispatchFitSystemWindows(Rect r10) {
        fitSystemWindows(r10);
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
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        OnAttachListener r10 = this.mAttachListener;
        if (r10 == null) goto L6;
        r10.onAttachedFromWindow();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnAttachListener r10 = this.mAttachListener;
        if (r10 == null) goto L6;
        r10.onDetachedFromWindow();
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r14, int r15) {
        DisplayMetrics r10 = getContext().getResources().getDisplayMetrics();
        boolean r11 = true;
        if (r10.widthPixels >= r10.heightPixels) goto L5;
        boolean r12 = true;
    L6:
        int r13 = View.MeasureSpec.getMode(r14);
        int r16 = View.MeasureSpec.getMode(r15);
        if (r13 != Integer.MIN_VALUE) goto L22;
        if (r12 == false) goto L10;
        TypedValue r17 = this.mFixedWidthMinor;
    L11:
        if (r17 == null) goto L22;
        int r18 = r17.type;
        if (r18 == 0) goto L22;
        if (r18 != 5) goto L17;
        float r19 = r17.getDimension(r10);
    L16:
        int r110 = (int) r19;
    L20:
        if (r110 <= 0) goto L22;
        Rect r111 = this.mDecorPadding;
        r14 = View.MeasureSpec.makeMeasureSpec(Math.min(r110 - (r111.left + r111.right), View.MeasureSpec.getSize(r14)), 1073741824);
        boolean r112 = true;
    L23:
        if (r16 != Integer.MIN_VALUE) goto L38;
        if (r12 == false) goto L26;
        TypedValue r20 = this.mFixedHeightMajor;
    L27:
        if (r20 == null) goto L38;
        int r113 = r20.type;
        if (r113 == 0) goto L38;
        if (r113 != 5) goto L33;
        float r21 = r20.getDimension(r10);
    L32:
        int r22 = (int) r21;
    L36:
        if (r22 <= 0) goto L38;
        Rect r114 = this.mDecorPadding;
        r15 = View.MeasureSpec.makeMeasureSpec(Math.min(r22 - (r114.top + r114.bottom), View.MeasureSpec.getSize(r15)), 1073741824);
        goto L38
    L33:
        if (r113 != 6) goto L35;
        int r115 = r10.heightPixels;
        r21 = r20.getFraction(r115, r115);
        goto L32
    L35:
        r22 = 0;
        goto L36
    L26:
        r20 = this.mFixedHeightMinor;
    L38:
        super.onMeasure(r14, r15);
        int r116 = getMeasuredWidth();
        int r23 = View.MeasureSpec.makeMeasureSpec(r116, 1073741824);
        if (r112 == true) goto L57;
        if (r13 != Integer.MIN_VALUE) goto L57;
        if (r12 == false) goto L43;
        TypedValue r24 = this.mMinWidthMinor;
    L44:
        if (r24 == null) goto L57;
        int r25 = r24.type;
        if (r25 == 0) goto L57;
        if (r25 != 5) goto L50;
        float r26 = r24.getDimension(r10);
    L49:
        int r27 = (int) r26;
    L53:
        if (r27 <= 0) goto L55;
        Rect r28 = this.mDecorPadding;
        r27 = r27 - (r28.left + r28.right);
    L55:
        if (r116 >= r27) goto L57;
        r23 = View.MeasureSpec.makeMeasureSpec(r27, 1073741824);
    L58:
        if (r11 == false) goto L61;
        super.onMeasure(r23, r15);
        return;
    L61:
        return;
    L50:
        if (r25 != 6) goto L52;
        int r29 = r10.widthPixels;
        r26 = r24.getFraction(r29, r29);
        goto L49
    L52:
        r27 = 0;
        goto L53
    L43:
        r24 = this.mMinWidthMajor;
    L57:
        r11 = false;
        goto L58
    L17:
        if (r18 != 6) goto L19;
        int r117 = r10.widthPixels;
        r19 = r17.getFraction(r117, r117);
        goto L16
    L19:
        r110 = 0;
        goto L20
    L10:
        r17 = this.mFixedWidthMajor;
    L22:
        r112 = false;
        goto L23
    L5:
        r12 = false;
        goto L6
    }

    public void setAttachListener(OnAttachListener r10) {
        this.mAttachListener = r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setDecorPadding(int r10, int r11, int r12, int r13) {
        this.mDecorPadding.set(r10, r11, r12, r13);
        if (ViewCompat.isLaidOut(this) == false) goto L6;
        requestLayout();
        return;
    }
}
