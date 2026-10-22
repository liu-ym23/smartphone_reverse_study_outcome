package androidx.appcompat.widget;

import android.content.Context;
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

    AppCompatCheckedTextViewHelper(@NonNull CheckedTextView r10) {
        this.mCheckMarkTintList = null;
        this.mCheckMarkTintMode = null;
        this.mHasCheckMarkTint = false;
        this.mHasCheckMarkTintMode = false;
        this.mView = r10;
    }

    void applyCheckMarkTint() {
        Drawable r10 = CheckedTextViewCompat.getCheckMarkDrawable(this.mView);
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mHasCheckMarkTint == false) goto L7;
    L8:
        Drawable r11 = DrawableCompat.wrap(r10).mutate();
        if (this.mHasCheckMarkTint == false) goto L12;
        DrawableCompat.setTintList(r11, this.mCheckMarkTintList);
    L12:
        if (this.mHasCheckMarkTintMode == false) goto L15;
        DrawableCompat.setTintMode(r11, this.mCheckMarkTintMode);
    L15:
        if (r11.isStateful() == false) goto L17;
        r11.setState(this.mView.getDrawableState());
    L17:
        this.mView.setCheckMarkDrawable(r11);
        return;
    L7:
        if (this.mHasCheckMarkTintMode == true) goto L8;
    }

    ColorStateList getSupportCheckMarkTintList() {
        return this.mCheckMarkTintList;
    }

    PorterDuff.Mode getSupportCheckMarkTintMode() {
        return this.mCheckMarkTintMode;
    }

    void loadFromAttributes(@Nullable AttributeSet r10, int r11) {
        Context r12 = this.mView.getContext();
        int[] r13 = R.styleable.CheckedTextView;
        TintTypedArray r14 = TintTypedArray.obtainStyledAttributes(r12, r10, r13, r11, 0);
        CheckedTextView r15 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r15, r15.getContext(), r13, r10, r14.getWrappedTypeArray(), r11, 0);
        int r16 = R.styleable.CheckedTextView_checkMarkCompat;     // Catch: Throwable -> L24
        if (r14.hasValue(r16) == false) goto L9;
        int r17 = r14.getResourceId(r16, 0);     // Catch: Throwable -> L24
        if (r17 == 0) goto L9;
        CheckedTextView r18 = this.mView;     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        r18.setCheckMarkDrawable(AppCompatResources.getDrawable(r18.getContext(), r17));     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        boolean r19 = true;
    L10:
        if (r19 == true) goto L16;
        int r110 = R.styleable.CheckedTextView_android_checkMark;     // Catch: Throwable -> L24
        if (r14.hasValue(r110) == false) goto L16;
        int r111 = r14.getResourceId(r110, 0);     // Catch: Throwable -> L24
        if (r111 == 0) goto L16;
        CheckedTextView r112 = this.mView;     // Catch: Throwable -> L24
        r112.setCheckMarkDrawable(AppCompatResources.getDrawable(r112.getContext(), r111));     // Catch: Throwable -> L24
    L16:
        int r113 = R.styleable.CheckedTextView_checkMarkTint;     // Catch: Throwable -> L24
        if (r14.hasValue(r113) == false) goto L19;
        CheckedTextViewCompat.setCheckMarkTintList(this.mView, r14.getColorStateList(r113));     // Catch: Throwable -> L24
    L19:
        int r114 = R.styleable.CheckedTextView_checkMarkTintMode;     // Catch: Throwable -> L24
        if (r14.hasValue(r114) == false) goto L22;
        CheckedTextViewCompat.setCheckMarkTintMode(this.mView, DrawableUtils.parseTintMode(r14.getInt(r114, -1), null));     // Catch: Throwable -> L24
    L22:
        r14.recycle();
        return;
    L9:
        r19 = false;
    L24:
        th = move-exception;
        r14.recycle();
        throw th;
    }

    void onSetCheckMarkDrawable() {
        if (this.mSkipNextApply == false) goto L6;
        this.mSkipNextApply = false;
        return;
    L6:
        this.mSkipNextApply = true;
        applyCheckMarkTint();
    }

    void setSupportCheckMarkTintList(ColorStateList r10) {
        this.mCheckMarkTintList = r10;
        this.mHasCheckMarkTint = true;
        applyCheckMarkTint();
    }

    void setSupportCheckMarkTintMode(@Nullable PorterDuff.Mode r10) {
        this.mCheckMarkTintMode = r10;
        this.mHasCheckMarkTintMode = true;
        applyCheckMarkTint();
    }
}
