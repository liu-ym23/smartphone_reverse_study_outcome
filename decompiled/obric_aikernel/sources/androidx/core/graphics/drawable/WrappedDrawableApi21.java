package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class WrappedDrawableApi21 extends WrappedDrawableApi14 {
    private static final String TAG = "WrappedDrawableApi21";
    private static Method sIsProjectedDrawableMethod;

    WrappedDrawableApi21(Drawable r10) {
        super(r10);
        findAndCacheIsProjectedDrawableMethod();
    }

    WrappedDrawableApi21(WrappedDrawableState r10, Resources r11) {
        super(r10, r11);
        findAndCacheIsProjectedDrawableMethod();
    }

    private void findAndCacheIsProjectedDrawableMethod() {
        if (sIsProjectedDrawableMethod != null) goto L11;
        sIsProjectedDrawableMethod = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Log.w(TAG, "Failed to retrieve Drawable#isProjected() method", e);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Rect getDirtyBounds() {
        return this.mDrawable.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@NonNull Outline r10) {
        this.mDrawable.getOutline(r10);
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14
    protected boolean isCompatTintEnabled() {
        if (Build.VERSION.SDK_INT != 21) goto L14;
        Drawable r10 = this.mDrawable;
        if ((r10 instanceof GradientDrawable) == false) goto L7;
    L12:
        return true;
    L7:
        if ((r10 instanceof DrawableContainer) == true) goto L12;
        if ((r10 instanceof InsetDrawable) == true) goto L12;
        if ((r10 instanceof RippleDrawable) == true) goto L12;
        return false;
    L14:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Drawable r10 = this.mDrawable;
        if (r10 == null) goto L10;
        Method r11 = sIsProjectedDrawableMethod;
        if (r11 == null) goto L10;
        return ((Boolean) r11.invoke(r10, new Object[0])).booleanValue();
    L8:
        e = move-exception;
        Log.w(TAG, "Error calling Drawable#isProjected() method", e);
    L10:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float r10, float r11) {
        this.mDrawable.setHotspot(r10, r11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int r10, int r11, int r12, int r13) {
        this.mDrawable.setHotspotBounds(r10, r11, r12, r13);
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable
    public boolean setState(@NonNull int[] r10) {
        if (super.setState(r10) == false) goto L6;
        invalidateSelf();
        return true;
    L6:
        return false;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r10) {
        if (isCompatTintEnabled() == false) goto L5;
        super.setTint(r10);
        return;
    L5:
        this.mDrawable.setTint(r10);
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r10) {
        if (isCompatTintEnabled() == false) goto L5;
        super.setTintList(r10);
        return;
    L5:
        this.mDrawable.setTintList(r10);
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode r10) {
        if (isCompatTintEnabled() == false) goto L5;
        super.setTintMode(r10);
        return;
    L5:
        this.mDrawable.setTintMode(r10);
    }
}
