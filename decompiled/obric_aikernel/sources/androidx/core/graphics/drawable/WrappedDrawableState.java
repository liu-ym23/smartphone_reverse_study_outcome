package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
final class WrappedDrawableState extends Drawable.ConstantState {
    int mChangingConfigurations;
    Drawable.ConstantState mDrawableState;
    ColorStateList mTint;
    PorterDuff.Mode mTintMode;

    WrappedDrawableState(@Nullable WrappedDrawableState r10) {
        this.mTint = null;
        this.mTintMode = WrappedDrawableApi14.DEFAULT_TINT_MODE;
        if (r10 == null) goto L6;
        this.mChangingConfigurations = r10.mChangingConfigurations;
        this.mDrawableState = r10.mDrawableState;
        this.mTint = r10.mTint;
        this.mTintMode = r10.mTintMode;
        return;
    }

    boolean canConstantState() {
        if (this.mDrawableState == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int r10 = this.mChangingConfigurations;
        Drawable.ConstantState r11 = this.mDrawableState;
        if (r11 == null) goto L5;
        int r12 = r11.getChangingConfigurations();
    L7:
        return r12 | r10;
    L5:
        r12 = 0;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable(@Nullable Resources r10) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return new WrappedDrawableApi21(this, r10);
    L7:
        return new WrappedDrawableApi14(this, r10);
    }
}
