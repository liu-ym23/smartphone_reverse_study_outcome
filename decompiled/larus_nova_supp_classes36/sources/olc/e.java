package olc;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements a {
    public static final e b = null;
    public final /* synthetic */ f a;

    static {
        b = new e();
    }

    public e() {
        this.a = new f();
    }

    @Override // olc.a
    public final void a(Bitmap r2) {
        this.a.getClass();
        r2.recycle();
    }

    @Override // olc.a
    public final Bitmap obtain(int r2, int r3, Bitmap.Config r4) {
        this.a.getClass();
        return Bitmap.createBitmap(r2, r3, r4);
    }
}
