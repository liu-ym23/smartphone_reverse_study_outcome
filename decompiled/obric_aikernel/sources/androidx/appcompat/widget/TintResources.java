package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class TintResources extends ResourcesWrapper {
    private final WeakReference<Context> mContextRef;

    public TintResources(@NonNull Context r10, @NonNull Resources r11) {
        super(r11);
        this.mContextRef = new WeakReference(r10);
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int r10) {
        Drawable r11 = getDrawableCanonical(r10);
        Context r12 = this.mContextRef.get();
        if (r11 == null) goto L6;
        if (r12 == null) goto L6;
        ResourceManagerInternal.get().tintDrawableUsingColorFilter(r12, r10, r11);
    L6:
        return r11;
    }
}
