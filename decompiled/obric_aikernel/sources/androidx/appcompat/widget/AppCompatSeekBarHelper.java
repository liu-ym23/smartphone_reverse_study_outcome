package androidx.appcompat.widget;

import android.content.Context;
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

    AppCompatSeekBarHelper(SeekBar r10) {
        super(r10);
        this.mTickMarkTintList = null;
        this.mTickMarkTintMode = null;
        this.mHasTickMarkTint = false;
        this.mHasTickMarkTintMode = false;
        this.mView = r10;
    }

    private void applyTickMarkTint() {
        Drawable r10 = this.mTickMark;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mHasTickMarkTint == false) goto L7;
    L8:
        Drawable r11 = DrawableCompat.wrap(r10.mutate());
        this.mTickMark = r11;
        if (this.mHasTickMarkTint == false) goto L12;
        DrawableCompat.setTintList(r11, this.mTickMarkTintList);
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

    void drawTickMarks(Canvas r10) {
        if (this.mTickMark == null) goto L18;
        int r11 = this.mView.getMax();
        int r12 = 1;
        if (r11 <= 1) goto L19;
        int r13 = this.mTickMark.getIntrinsicWidth();
        int r14 = this.mTickMark.getIntrinsicHeight();
        if (r13 < 0) goto L9;
        int r15 = r13 / 2;
    L10:
        if (r14 < 0) goto L12;
        r12 = r14 / 2;
    L12:
        this.mTickMark.setBounds(-r15, -r12, r15, r12);
        float r16 = ((this.mView.getWidth() - this.mView.getPaddingLeft()) - this.mView.getPaddingRight()) / r11;
        int r17 = r10.save();
        r10.translate(this.mView.getPaddingLeft(), this.mView.getHeight() / 2);
        int r18 = 0;
    L13:
        if (r18 > r11) goto L15;
        this.mTickMark.draw(r10);
        r10.translate(r16, 0.0f);
        r18 = r18 + 1;
        goto L13
    L15:
        r10.restoreToCount(r17);
        return;
    L9:
        r15 = 1;
        goto L10
    L19:
        return;
    }

    void drawableStateChanged() {
        Drawable r10 = this.mTickMark;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isStateful() == true) goto L7;
        return;
    L7:
        if (r10.setState(this.mView.getDrawableState()) == false) goto L12;
        this.mView.invalidateDrawable(r10);
        return;
    }

    @Nullable
    Drawable getTickMark() {
        return this.mTickMark;
    }

    @Nullable
    ColorStateList getTickMarkTintList() {
        return this.mTickMarkTintList;
    }

    @Nullable
    PorterDuff.Mode getTickMarkTintMode() {
        return this.mTickMarkTintMode;
    }

    void jumpDrawablesToCurrentState() {
        Drawable r10 = this.mTickMark;
        if (r10 == null) goto L6;
        r10.jumpToCurrentState();
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatProgressBarHelper
    void loadFromAttributes(AttributeSet r10, int r11) {
        super.loadFromAttributes(r10, r11);
        Context r12 = this.mView.getContext();
        int[] r13 = R.styleable.AppCompatSeekBar;
        TintTypedArray r14 = TintTypedArray.obtainStyledAttributes(r12, r10, r13, r11, 0);
        SeekBar r15 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r15, r15.getContext(), r13, r10, r14.getWrappedTypeArray(), r11, 0);
        Drawable r16 = r14.getDrawableIfKnown(R.styleable.AppCompatSeekBar_android_thumb);
        if (r16 == null) goto L5;
        this.mView.setThumb(r16);
    L5:
        setTickMark(r14.getDrawable(R.styleable.AppCompatSeekBar_tickMark));
        int r17 = R.styleable.AppCompatSeekBar_tickMarkTintMode;
        if (r14.hasValue(r17) == false) goto L8;
        this.mTickMarkTintMode = DrawableUtils.parseTintMode(r14.getInt(r17, -1), this.mTickMarkTintMode);
        this.mHasTickMarkTintMode = true;
    L8:
        int r18 = R.styleable.AppCompatSeekBar_tickMarkTint;
        if (r14.hasValue(r18) == false) goto L11;
        this.mTickMarkTintList = r14.getColorStateList(r18);
        this.mHasTickMarkTint = true;
    L11:
        r14.recycle();
        applyTickMarkTint();
    }

    void setTickMark(@Nullable Drawable r10) {
        Drawable r11 = this.mTickMark;
        if (r11 == null) goto L5;
        r11.setCallback(null);
    L5:
        this.mTickMark = r10;
        if (r10 == null) goto L11;
        r10.setCallback(this.mView);
        DrawableCompat.setLayoutDirection(r10, ViewCompat.getLayoutDirection(this.mView));
        if (r10.isStateful() == false) goto L10;
        r10.setState(this.mView.getDrawableState());
    L10:
        applyTickMarkTint();
    L11:
        this.mView.invalidate();
    }

    void setTickMarkTintList(@Nullable ColorStateList r10) {
        this.mTickMarkTintList = r10;
        this.mHasTickMarkTint = true;
        applyTickMarkTint();
    }

    void setTickMarkTintMode(@Nullable PorterDuff.Mode r10) {
        this.mTickMarkTintMode = r10;
        this.mHasTickMarkTintMode = true;
        applyTickMarkTint();
    }
}
