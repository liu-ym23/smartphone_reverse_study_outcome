package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
final class WrappedDrawableState extends Drawable.ConstantState {
    int mChangingConfigurations;
    Drawable.ConstantState mDrawableState;
    ColorStateList mTint;
    PorterDuff.Mode mTintMode;

    public WrappedDrawableState(@Nullable WrappedDrawableState r5) {
        this.mTint = null;
        this.mTintMode = WrappedDrawableApi14.DEFAULT_TINT_MODE;
        if (r5 == null) goto L6;
        this.mChangingConfigurations = r5.mChangingConfigurations;
        this.mDrawableState = r5.mDrawableState;
        this.mTint = r5.mTint;
        this.mTintMode = r5.mTintMode;
        return;
    }

    public boolean canConstantState() {
        if (this.mDrawableState == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int r5 = this.mChangingConfigurations;
        Drawable.ConstantState r10 = this.mDrawableState;
        if (r10 == null) goto L5;
        int r11 = r10.getChangingConfigurations();
    L7:
        return r11 | r5;
    L5:
        r11 = 0;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable(@Nullable Resources r5) {
        return new WrappedDrawableApi21(this, r5);
    }
}
