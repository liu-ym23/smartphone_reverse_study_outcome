package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
    private boolean mHasTickMarkTint;
    private boolean mHasTickMarkTintMode;
    private Drawable mTickMark;
    private ColorStateList mTickMarkTintList;
    private PorterDuff.Mode mTickMarkTintMode;
    private final SeekBar mView;

    public AppCompatSeekBarHelper(SeekBar r5) {
        super(r5);
        this.mTickMarkTintList = null;
        this.mTickMarkTintMode = null;
        this.mHasTickMarkTint = false;
        this.mHasTickMarkTintMode = false;
        this.mView = r5;
    }

    private void applyTickMarkTint() {
        Drawable r5 = this.mTickMark;
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.mHasTickMarkTint == false) goto L7;
    L8:
        Drawable r10 = DrawableCompat.wrap(r5.mutate());
        this.mTickMark = r10;
        if (this.mHasTickMarkTint == false) goto L12;
        DrawableCompat.setTintList(r10, this.mTickMarkTintList);
    L12:
        if (this.mHasTickMarkTintMode == false) goto L15;
        DrawableCompat.setTintMode(this.mTickMark, this.mTickMarkTintMode);
    L15:
        if (this.mTickMark.isStateful() == false) goto L20;
        this.mTickMark.setState(this.mView.getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.mHasTickMarkTintMode == true) goto L8;
    }

    public void drawTickMarks(Canvas r10) {
        if (this.mTickMark == null) goto L18;
        int r5 = this.mView.getMax();
        int r11 = 1;
        if (r5 <= 1) goto L19;
        int r12 = this.mTickMark.getIntrinsicWidth();
        int r13 = this.mTickMark.getIntrinsicHeight();
        if (r12 < 0) goto L9;
        int r14 = r12 / 2;
    L10:
        if (r13 < 0) goto L12;
        r11 = r13 / 2;
    L12:
        this.mTickMark.setBounds(-r14, -r11, r14, r11);
        float r15 = ((this.mView.getWidth() - this.mView.getPaddingLeft()) - this.mView.getPaddingRight()) / r5;
        int r16 = r10.save();
        r10.translate(this.mView.getPaddingLeft(), this.mView.getHeight() / 2);
        int r17 = 0;
    L13:
        if (r17 > r5) goto L15;
        this.mTickMark.draw(r10);
        r10.translate(r15, 0.0f);
        r17 = r17 + 1;
        goto L13
    L15:
        r10.restoreToCount(r16);
        return;
    L9:
        r14 = 1;
        goto L10
    L19:
        return;
    }

    public void drawableStateChanged() {
        Drawable r5 = this.mTickMark;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isStateful() == true) goto L7;
        return;
    L7:
        if (r5.setState(this.mView.getDrawableState()) == false) goto L12;
        this.mView.invalidateDrawable(r5);
        return;
    }

    @Nullable
    public Drawable getTickMark() {
        return this.mTickMark;
    }

    @Nullable
    public ColorStateList getTickMarkTintList() {
        return this.mTickMarkTintList;
    }

    @Nullable
    public PorterDuff.Mode getTickMarkTintMode() {
        return this.mTickMarkTintMode;
    }

    public void jumpDrawablesToCurrentState() {
        Drawable r5 = this.mTickMark;
        if (r5 == null) goto L6;
        r5.jumpToCurrentState();
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatProgressBarHelper
    public void loadFromAttributes(AttributeSet r10, int r11) {
        super.loadFromAttributes(r10, r11);
        TintTypedArray r5 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), r10, R.styleable.AppCompatSeekBar, r11, 0);
        SeekBar r12 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r12, r12.getContext(), R.styleable.AppCompatSeekBar, r10, r5.getWrappedTypeArray(), r11, 0);
        Drawable r13 = r5.getDrawableIfKnown(R.styleable.AppCompatSeekBar_android_thumb);
        if (r13 == null) goto L5;
        this.mView.setThumb(r13);
    L5:
        setTickMark(r5.getDrawable(R.styleable.AppCompatSeekBar_tickMark));
        if (r5.hasValue(R.styleable.AppCompatSeekBar_tickMarkTintMode) == false) goto L9;
        this.mTickMarkTintMode = DrawableUtils.parseTintMode(r5.getInt(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.mTickMarkTintMode);
        this.mHasTickMarkTintMode = true;
    L9:
        if (r5.hasValue(R.styleable.AppCompatSeekBar_tickMarkTint) == false) goto L11;
        this.mTickMarkTintList = r5.getColorStateList(R.styleable.AppCompatSeekBar_tickMarkTint);
        this.mHasTickMarkTint = true;
    L11:
        r5.recycle();
        applyTickMarkTint();
    }

    public void setTickMark(@Nullable Drawable r5) {
        Drawable r10 = this.mTickMark;
        if (r10 == null) goto L5;
        r10.setCallback(null);
    L5:
        this.mTickMark = r5;
        if (r5 == null) goto L11;
        r5.setCallback(this.mView);
        DrawableCompat.setLayoutDirection(r5, ViewCompat.getLayoutDirection(this.mView));
        if (r5.isStateful() == false) goto L10;
        r5.setState(this.mView.getDrawableState());
    L10:
        applyTickMarkTint();
    L11:
        this.mView.invalidate();
    }

    public void setTickMarkTintList(@Nullable ColorStateList r5) {
        this.mTickMarkTintList = r5;
        this.mHasTickMarkTint = true;
        applyTickMarkTint();
    }

    public void setTickMarkTintMode(@Nullable PorterDuff.Mode r5) {
        this.mTickMarkTintMode = r5;
        this.mHasTickMarkTintMode = true;
        applyTickMarkTint();
    }
}
