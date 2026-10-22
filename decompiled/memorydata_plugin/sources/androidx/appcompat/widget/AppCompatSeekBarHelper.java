package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
    private boolean mHasTickMarkTint;
    private boolean mHasTickMarkTintMode;
    private Drawable mTickMark;
    private ColorStateList mTickMarkTintList;
    private PorterDuff.Mode mTickMarkTintMode;
    private final SeekBar mView;

    AppCompatSeekBarHelper(SeekBar r2) {
        super(r2);
        this.mTickMarkTintList = null;
        this.mTickMarkTintMode = null;
        this.mHasTickMarkTint = false;
        this.mHasTickMarkTintMode = false;
        this.mView = r2;
    }

    private void applyTickMarkTint() {
        Drawable r0 = this.mTickMark;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mHasTickMarkTint == false) goto L7;
    L8:
        Drawable r1 = DrawableCompat.wrap(r0.mutate());
        this.mTickMark = r1;
        if (this.mHasTickMarkTint == false) goto L12;
        DrawableCompat.setTintList(r1, this.mTickMarkTintList);
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

    void drawTickMarks(Canvas r7) {
        if (this.mTickMark == null) goto L18;
        int r0 = this.mView.getMax();
        int r1 = 1;
        if (r0 <= 1) goto L19;
        int r2 = this.mTickMark.getIntrinsicWidth();
        int r3 = this.mTickMark.getIntrinsicHeight();
        if (r2 < 0) goto L9;
        int r4 = r2 / 2;
    L10:
        if (r3 < 0) goto L12;
        r1 = r3 / 2;
    L12:
        this.mTickMark.setBounds(-r4, -r1, r4, r1);
        float r5 = ((this.mView.getWidth() - this.mView.getPaddingLeft()) - this.mView.getPaddingRight()) / r0;
        int r6 = r7.save();
        r7.translate(this.mView.getPaddingLeft(), this.mView.getHeight() / 2);
        int r8 = 0;
    L13:
        if (r8 > r0) goto L15;
        this.mTickMark.draw(r7);
        r7.translate(r5, 0.0f);
        r8 = r8 + 1;
        goto L13
    L15:
        r7.restoreToCount(r6);
        return;
    L9:
        r4 = 1;
        goto L10
    L19:
        return;
    }

    void drawableStateChanged() {
        Drawable r0 = this.mTickMark;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isStateful() == true) goto L7;
        return;
    L7:
        if (r0.setState(this.mView.getDrawableState()) == false) goto L12;
        this.mView.invalidateDrawable(r0);
        return;
    }

    Drawable getTickMark() {
        return this.mTickMark;
    }

    ColorStateList getTickMarkTintList() {
        return this.mTickMarkTintList;
    }

    PorterDuff.Mode getTickMarkTintMode() {
        return this.mTickMarkTintMode;
    }

    void jumpDrawablesToCurrentState() {
        Drawable r0 = this.mTickMark;
        if (r0 == null) goto L6;
        r0.jumpToCurrentState();
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatProgressBarHelper
    void loadFromAttributes(AttributeSet r10, int r11) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        super.loadFromAttributes(r5, r11);
        TintTypedArray r12 = TintTypedArray.obtainStyledAttributes((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5, R.styleable.AppCompatSeekBar, r11, 0);
        SeekBar r2 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r2, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), R.styleable.AppCompatSeekBar, r5, r12.getWrappedTypeArray(), r11, 0);
        Drawable r13 = r12.getDrawableIfKnown(ZeusTransformUtils.mapRes(R.styleable.AppCompatSeekBar_android_thumb, "styleable", "AppCompatSeekBar_android_thumb"));
        if (r13 == null) goto L5;
        this.mView.setThumb(r13);
    L5:
        setTickMark(r12.getDrawable(ZeusTransformUtils.mapRes(R.styleable.AppCompatSeekBar_tickMark, "styleable", "AppCompatSeekBar_tickMark")));
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatSeekBar_tickMarkTintMode, "styleable", "AppCompatSeekBar_tickMarkTintMode")) == false) goto L9;
        this.mTickMarkTintMode = DrawableUtils.parseTintMode(r12.getInt(ZeusTransformUtils.mapRes(R.styleable.AppCompatSeekBar_tickMarkTintMode, "styleable", "AppCompatSeekBar_tickMarkTintMode"), -1), this.mTickMarkTintMode);
        this.mHasTickMarkTintMode = true;
    L9:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatSeekBar_tickMarkTint, "styleable", "AppCompatSeekBar_tickMarkTint")) == false) goto L11;
        this.mTickMarkTintList = r12.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.AppCompatSeekBar_tickMarkTint, "styleable", "AppCompatSeekBar_tickMarkTint"));
        this.mHasTickMarkTint = true;
    L11:
        r12.recycle();
        applyTickMarkTint();
    }

    void setTickMark(Drawable r3) {
        Drawable r0 = this.mTickMark;
        if (r0 == null) goto L5;
        r0.setCallback(null);
    L5:
        this.mTickMark = r3;
        if (r3 == null) goto L11;
        r3.setCallback(this.mView);
        DrawableCompat.setLayoutDirection(r3, ViewCompat.getLayoutDirection(this.mView));
        if (r3.isStateful() == false) goto L10;
        r3.setState(this.mView.getDrawableState());
    L10:
        applyTickMarkTint();
    L11:
        this.mView.invalidate();
    }

    void setTickMarkTintList(ColorStateList r1) {
        this.mTickMarkTintList = r1;
        this.mHasTickMarkTint = true;
        applyTickMarkTint();
    }

    void setTickMarkTintMode(PorterDuff.Mode r1) {
        this.mTickMarkTintMode = r1;
        this.mHasTickMarkTintMode = true;
        applyTickMarkTint();
    }
}
