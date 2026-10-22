package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class TintResources extends ResourcesWrapper {
    private final WeakReference<Context> mContextRef;

    public TintResources(@NonNull Context r5, @NonNull Resources r10) {
        super(r10);
        this.mContextRef = new WeakReference(r5);
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int r5) throws Resources.NotFoundException {
        Drawable r10 = getDrawableCanonical(r5);
        Context r11 = this.mContextRef.get();
        if (r10 == null) goto L6;
        if (r11 == null) goto L6;
        ResourceManagerInternal.get().tintDrawableUsingColorFilter(r11, r5, r10);
    L6:
        return r10;
    }
}
