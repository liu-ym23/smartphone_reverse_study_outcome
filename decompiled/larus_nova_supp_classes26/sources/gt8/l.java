package gt8;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l {
    public Bitmap a;
    public final z b;
    public final Matrix c;
    public final c d;
    public boolean e;

    public static final class a implements z.a {
        public final /* synthetic */ l a;

        @Override // gt8.z.a
        public final void a() {
            this.a.e = true;
        }

        public a(l r1) {
            this.a = r1;
        }
    }

    public static final class b {
    }

    public final class c {
        public float a;
        public float b;

        public c() {
        }
    }

    static {
    }

    public final Matrix a() {
        if (this.b == null) goto L5;
        this.c.reset();
        c r0 = this.d;
        boolean r2 = true;
        if (r0.a != 0.0f) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
    L17:
        r2 = false;
    L19:
        if (r2 == false) goto L21;
    L22:
        float r3 = this.b.a.width() / this.a.getWidth();
        float r4 = this.b.a.height() / this.a.getHeight();
        FLogger.a.i("DrawHelper", "scaleX = " + r3 + " ， scaleY = " + r4);
        c r5 = this.d;
        r5.a = r3;
        r5.b = r4;
        this.e = false;
    L23:
        z r6 = this.b;
        float r7 = 2;
        float r8 = r6.c.x - (r6.a.width() / r7);
        z r9 = this.b;
        float r10 = r9.c.y - (r9.a.height() / r7);
        FLogger r11 = FLogger.a;
        r11.i("DrawHelper", "size width = " + this.b.a.width() + " , height = " + this.b.a.height());
        r11.i("DrawHelper", "dx = " + r8 + " , dy = " + r10 + "centerX = " + this.b.c.x);
        Matrix r12 = this.c;
        c r13 = this.d;
        r12.postScale(r13.a, r13.b);
        this.c.postTranslate(r8, r10);
        Matrix r14 = this.c;
        z r15 = this.b;
        float r16 = r15.b;
        PointF r17 = r15.c;
        r14.postRotate(r16, r17.x, r17.y);
        return this.c;
    L21:
        if (this.e == false) goto L23;
    L12:
        if (r0.b != 0.0f) goto L14;
        boolean r18 = true;
    L15:
        if (r18 == false) goto L17;
    L14:
        r18 = false;
        goto L15
    L9:
        r1 = false;
        goto L10
    L5:
        return this.c;
    }

    public l(Bitmap r2, z r3) {
        Intrinsics.checkNotNullParameter(r2, "drawBitmap");
        this.a = r2;
        this.b = r3;
        this.c = new Matrix();
        this.d = new c();
        this.e = true;
        if (r3 == null) goto L6;
        r3.e = new a(this);
        return;
    }
}
