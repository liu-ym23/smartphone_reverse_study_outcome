package olc;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements a {
    public f() {
    }

    @Override // olc.a
    public final void a(Bitmap r1) {
        r1.recycle();
    }

    @Override // olc.a
    public final Bitmap obtain(int r1, int r2, Bitmap.Config r3) {
        return Bitmap.createBitmap(r1, r2, r3);
    }
}
