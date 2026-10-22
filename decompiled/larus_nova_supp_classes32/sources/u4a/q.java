package u4a;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q implements j {
    public final Bitmap a;

    @Override // u4a.j
    public final void close() {
        this.a.recycle();
    }

    @Override // u4a.j
    public final boolean isValid() {
        return !this.a.isRecycled();
    }

    @Override // u4a.j
    public final Bitmap get() {
        if (isValid() == true) goto L5;
        return null;
    L5:
        return this.a;
    }

    public q(Bitmap r1) {
        this.a = r1;
    }
}
