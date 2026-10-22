package u4a;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f implements j {
    public final CloseableReference<Bitmap> a;

    @Override // u4a.j
    public final void close() {
        this.a.close();
    }

    @Override // u4a.j
    public final Bitmap get() {
        if (this.a.isValid() == true) goto L5;
        return null;
    L5:
        return (Bitmap) this.a.get();
    }

    @Override // u4a.j
    public final boolean isValid() {
        return this.a.isValid();
    }

    public f(CloseableReference<Bitmap> r1) {
        this.a = r1.clone();
    }
}
