package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CheckedTextViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class AppCompatCheckedTextViewHelper {
    private ColorStateList mCheckMarkTintList;
    private PorterDuff.Mode mCheckMarkTintMode;
    private boolean mHasCheckMarkTint;
    private boolean mHasCheckMarkTintMode;
    private boolean mSkipNextApply;

    @NonNull
    private final CheckedTextView mView;

    public AppCompatCheckedTextViewHelper(@NonNull CheckedTextView r5) {
        this.mCheckMarkTintList = null;
        this.mCheckMarkTintMode = null;
        this.mHasCheckMarkTint = false;
        this.mHasCheckMarkTintMode = false;
        this.mView = r5;
    }

    public void applyCheckMarkTint() {
        Drawable r5 = CheckedTextViewCompat.getCheckMarkDrawable(this.mView);
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.mHasCheckMarkTint == false) goto L7;
    L8:
        Drawable r10 = DrawableCompat.wrap(r5).mutate();
        if (this.mHasCheckMarkTint == false) goto L12;
        DrawableCompat.setTintList(r10, this.mCheckMarkTintList);
    L12:
        if (this.mHasCheckMarkTintMode == false) goto L15;
        DrawableCompat.setTintMode(r10, this.mCheckMarkTintMode);
    L15:
        if (r10.isStateful() == false) goto L17;
        r10.setState(this.mView.getDrawableState());
    L17:
        this.mView.setCheckMarkDrawable(r10);
        return;
    L7:
        if (this.mHasCheckMarkTintMode == true) goto L8;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        return this.mCheckMarkTintList;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        return this.mCheckMarkTintMode;
    }

    public void loadFromAttributes(@Nullable AttributeSet r11, int r12) {
        TintTypedArray r5 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), r11, R.styleable.CheckedTextView, r12, 0);
        CheckedTextView r10 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r10, r10.getContext(), R.styleable.CheckedTextView, r11, r5.getWrappedTypeArray(), r12, 0);
    L9:
        th = move-exception;
        r5.recycle();
        throw th;
    L4:
        if (r5.hasValue(R.styleable.CheckedTextView_checkMarkCompat) == false) goto L12;
        int r13 = r5.getResourceId(R.styleable.CheckedTextView_checkMarkCompat, 0);     // Catch: Throwable -> L9
        if (r13 == 0) goto L12;
        CheckedTextView r14 = this.mView;     // Catch: Throwable -> L9 Resources.NotFoundException -> L26
        r14.setCheckMarkDrawable(AppCompatResources.getDrawable(r14.getContext(), r13));     // Catch: Throwable -> L9 Resources.NotFoundException -> L26
    L17:
        if (r5.hasValue(R.styleable.CheckedTextView_checkMarkTint) == false) goto L20;
        CheckedTextViewCompat.setCheckMarkTintList(this.mView, r5.getColorStateList(R.styleable.CheckedTextView_checkMarkTint));     // Catch: Throwable -> L9
    L20:
        if (r5.hasValue(R.styleable.CheckedTextView_checkMarkTintMode) == false) goto L22;
        CheckedTextViewCompat.setCheckMarkTintMode(this.mView, DrawableUtils.parseTintMode(r5.getInt(R.styleable.CheckedTextView_checkMarkTintMode, -1), null));     // Catch: Throwable -> L9
    L22:
        r5.recycle();
        return;
    L12:
        if (r5.hasValue(R.styleable.CheckedTextView_android_checkMark) == false) goto L17;
        int r15 = r5.getResourceId(R.styleable.CheckedTextView_android_checkMark, 0);     // Catch: Throwable -> L9
        if (r15 == 0) goto L17;
        CheckedTextView r16 = this.mView;     // Catch: Throwable -> L9
        r16.setCheckMarkDrawable(AppCompatResources.getDrawable(r16.getContext(), r15));     // Catch: Throwable -> L9
        goto L17
    }

    public void onSetCheckMarkDrawable() {
        if (this.mSkipNextApply == false) goto L6;
        this.mSkipNextApply = false;
        return;
    L6:
        this.mSkipNextApply = true;
        applyCheckMarkTint();
    }

    public void setSupportCheckMarkTintList(ColorStateList r5) {
        this.mCheckMarkTintList = r5;
        this.mHasCheckMarkTint = true;
        applyCheckMarkTint();
    }

    public void setSupportCheckMarkTintMode(@Nullable PorterDuff.Mode r5) {
        this.mCheckMarkTintMode = r5;
        this.mHasCheckMarkTintMode = true;
        applyCheckMarkTint();
    }
}
