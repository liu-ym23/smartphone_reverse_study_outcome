package fb0;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class k extends fb0.a {
    public static final HashMap<a, Bitmap> l = null;
    public static final a m = null;
    public boolean j;
    public Bitmap k;

    public static class a implements Cloneable {
        public boolean a;
        public Bitmap.Config b;
        public int c;

        public a() {
        }

        public final int hashCode() {
            int r0 = this.b.hashCode() ^ this.c;
            if (this.a == false) goto L6;
            return r0;
        L6:
            return -r0;
        }

        public final a a() {
            return (a) super.clone();
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return a();
        }

        public final boolean equals(Object r4) {
            if ((r4 instanceof a) == true) goto L5;
            return false;
        L5:
            a r5 = (a) r4;
            if (this.a == r5.a) goto L8;
            return false;
        L8:
            if (this.b == r5.b) goto L10;
            return false;
        L10:
            if (this.c != r5.c) goto L15;
            return true;
        L15:
            return false;
        }
    }

    public k() {
        super(0);
        this.j = true;
    }

    @Override // fb0.a
    public final int b() {
        return 3553;
    }

    @Override // fb0.j
    public final boolean isOpaque() {
        return false;
    }

    static {
        l = new HashMap();
        m = new a();
    }

    @Override // fb0.a
    public final int a() {
        if (this.c != (-1)) goto L6;
        g();
    L6:
        return this.d;
    }

    @Override // fb0.a
    public final int c() {
        if (this.c != (-1)) goto L6;
        g();
    L6:
        return this.c;
    }

    public final Bitmap g() {
        if (this.k != null) goto L8;
        Bitmap r0 = ((b) this).n;
        this.k = r0;
        int r1 = r0.getWidth() + (0 * 2);
        int r2 = this.k.getHeight() + (0 * 2);
        if (this.c != (-1)) goto L8;
        f(r1, r2);
    L8:
        return this.k;
    }

    @Override // fb0.a
    public final void e() {
        super.e();
        if (this.k == null) goto L6;
        this.k = null;
        return;
    }

    @Override // fb0.a
    public final boolean d(e r27) {
        if (this.b != 1) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L27;
        Bitmap r5 = g();
        if (r5 != null) goto L10;
    L25:
        this.b = -1;
    L35:
        if (this.b != 1) goto L37;
        boolean r0 = true;
    L38:
        if (r0 == true) goto L40;
    L42:
        return false;
    L40:
        if (this.j == false) goto L42;
        return true;
    L37:
        r0 = false;
        goto L38
    L10:
        if (r5.isRecycled() == true) goto L25;
        int r11 = r5.getWidth();     // Catch: Throwable -> L22
        int r12 = r5.getHeight();     // Catch: Throwable -> L22
        int r13 = this.e;     // Catch: Throwable -> L22
        int r14 = this.f;     // Catch: Throwable -> L22
        r27.getClass();     // Catch: Throwable -> L22
        f r2 = e.B;     // Catch: Throwable -> L22
        GLES20.glGenTextures(1, r2.a, 0);     // Catch: Throwable -> L22
        this.a = r2.a[0];     // Catch: Throwable -> L22
        r27.d(this);     // Catch: Throwable -> L22
        if (r11 != r13) goto L15;
        if (r12 != r14) goto L15;
        GLES20.glBindTexture(3553, this.a);     // Catch: Throwable -> L22
        GLUtils.texImage2D(3553, 0, r5, 0);     // Catch: Throwable -> L22
    L21:
        this.k = null;
        this.g = r27;
        this.b = 1;
        this.j = true;
    L15:
        int r24 = GLUtils.getInternalFormat(r5);     // Catch: Throwable -> L22
        int r25 = GLUtils.getType(r5);     // Catch: Throwable -> L22
        Bitmap.Config r7 = r5.getConfig();     // Catch: Throwable -> L22
        GLES20.glBindTexture(3553, this.a);     // Catch: Throwable -> L22
        GLES20.glTexImage2D(3553, 0, r24, this.e, this.f, 0, r24, r25, null);     // Catch: Throwable -> L22
        r27.e(this, 0, 0, r5, r24, r25);     // Catch: Throwable -> L22
        if ((0 + r11) >= r13) goto L19;
        int r3 = 0 + r11;     // Catch: Throwable -> L22
        r27.e(this, r3, 0, h(true, r7, r14), r24, r25);     // Catch: Throwable -> L22
    L19:
        if ((0 + r12) >= r14) goto L21;
        int r4 = 0 + r12;     // Catch: Throwable -> L22
        r27.e(this, 0, r4, h(false, r7, r13), r24, r25);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        this.k = null;
        throw th;
    L27:
        if (this.j == true) goto L35;
        Bitmap r6 = g();
        if (r6 == null) goto L35;
        if (r6.isRecycled() == true) goto L35;
        r27.e(this, 0, 0, r6, GLUtils.getInternalFormat(r6), GLUtils.getType(r6));
        this.k = null;
        this.j = true;
        goto L35
    L5:
        r1 = false;
        goto L6
    }

    public static Bitmap h(boolean r3, Bitmap.Config r4, int r5) {
        a r0 = m;
        r0.a = r3;
        r0.b = r4;
        r0.c = r5;
        HashMap<a, Bitmap> r1 = l;
        Bitmap r2 = r1.get(r0);
        if (r2 == null) goto L5;
        return r2;
    L5:
        if (r3 == false) goto L7;
        Bitmap r6 = Bitmap.createBitmap(1, r5, r4);
    L8:
        Bitmap r7 = r6;
        r1.put(r0.a(), r7);
        return r7;
    L7:
        r6 = Bitmap.createBitmap(r5, 1, r4);
        goto L8
    }
}
