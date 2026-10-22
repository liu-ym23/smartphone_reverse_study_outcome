package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class TintResources extends ResourcesWrapper {
    private final WeakReference<Context> mContextRef;

    public TintResources(Context r3, Resources r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r4);
        this.mContextRef = new WeakReference(r5);
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int r4) {
        Drawable r0 = getDrawableCanonical(r4);
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(this.mContextRef.get(), Context.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        if (r3 == null) goto L6;
        ResourceManagerInternal.get().tintDrawableUsingColorFilter(r3, r4, r0);
    L6:
        return r0;
    }
}
