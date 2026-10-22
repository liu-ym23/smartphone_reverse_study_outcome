package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class WrappedDrawableApi21 extends WrappedDrawableApi14 {
    private static final String TAG = "WrappedDrawableApi21";
    private static Method sIsProjectedDrawableMethod;

    public WrappedDrawableApi21(Drawable r5) {
        super(r5);
        findAndCacheIsProjectedDrawableMethod();
    }

    private void findAndCacheIsProjectedDrawableMethod() {
        if (sIsProjectedDrawableMethod != null) goto L11;
        sIsProjectedDrawableMethod = Drawable.class.getDeclaredMethod("isProjected", null);     // Catch: Exception -> L6
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
    public void getOutline(@NonNull Outline r5) {
        this.mDrawable.getOutline(r5);
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14
    public boolean isCompatTintEnabled() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Drawable r5 = this.mDrawable;
        if (r5 == null) goto L15;
        Method r10 = sIsProjectedDrawableMethod;
        if (r10 != null) goto L13;
        return false;
    L13:
        return ((Boolean) r10.invoke(r5, null)).booleanValue();
    L9:
        e = move-exception;
        Log.w(TAG, "Error calling Drawable#isProjected() method", e);
        return false;
    L15:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float r5, float r10) {
        this.mDrawable.setHotspot(r5, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int r5, int r10, int r11, int r12) {
        this.mDrawable.setHotspotBounds(r5, r10, r11, r12);
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable
    public boolean setState(@NonNull int[] r5) {
        if (super.setState(r5) == false) goto L6;
        invalidateSelf();
        return true;
    L6:
        return false;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r5) {
        if (isCompatTintEnabled() == false) goto L5;
        super.setTint(r5);
        return;
    L5:
        this.mDrawable.setTint(r5);
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r5) {
        if (isCompatTintEnabled() == false) goto L5;
        super.setTintList(r5);
        return;
    L5:
        this.mDrawable.setTintList(r5);
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode r5) {
        if (isCompatTintEnabled() == false) goto L5;
        super.setTintMode(r5);
        return;
    L5:
        this.mDrawable.setTintMode(r5);
    }

    public WrappedDrawableApi21(WrappedDrawableState r5, Resources r10) {
        super(r5, r10);
        findAndCacheIsProjectedDrawableMethod();
    }
}
