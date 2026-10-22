package ukb;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Resource<BitmapDrawable>, Initializable {
    public final Resources a;
    public final Resource<Bitmap> b;

    public final Object get() {
        return new a(this.a, (Bitmap) this.b.get());
    }

    public final int getSize() {
        return this.b.getSize();
    }

    public final void initialize() {
        Initializable r0 = this.b;
        if ((r0 instanceof Initializable) == false) goto L6;
        r0.initialize();
        return;
    }

    public final void recycle() {
        if (((Bitmap) this.b.get()).isRecycled() == true) goto L6;
        this.b.recycle();
        return;
    }

    public final Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    public c(Resources r1, Resource<Bitmap> r2) {
        this.a = (Resources) Preconditions.checkNotNull(r1);
        this.b = (Resource) Preconditions.checkNotNull(r2);
    }
}
