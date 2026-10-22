package gt8;

import android.graphics.PointF;
import android.graphics.RectF;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z {
    public RectF a;
    public int b;
    public PointF c;
    public final RectF d;
    public a e;

    public interface a {
        void a();
    }

    public final RectF a() {
        RectF r0 = new RectF(this.a);
        r0.offset(this.c.x - r0.centerX(), this.c.y - r0.centerY());
        int r1 = ht8.a.a;
        int r2 = this.b;
        PointF r3 = this.c;
        ht8.a.c(r0, r2, r3.x, r3.y);
        return r0;
    }

    public final boolean b() {
        if (((this.b / 90) % 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final float e() {
        if (b() == false) goto L6;
        return this.a.height();
    L6:
        return this.a.width();
    }

    public z(z r4) {
        Intrinsics.checkNotNullParameter(r4, "imageShowLocationHelper");
        this.d = new RectF();
        this.a = new RectF(r4.a);
        PointF r1 = r4.c;
        this.c = new PointF(r1.x, r1.y);
        this.b = r4.b;
    }

    public final void d(z r4) {
        Intrinsics.checkNotNullParameter(r4, "imageShowLocation");
        this.a = new RectF(r4.a);
        PointF r1 = r4.c;
        this.c = new PointF(r1.x, r1.y);
        this.b = r4.b;
        a r5 = this.e;
        if (r5 == null) goto L6;
        Intrinsics.checkNotNull(r5);
        r5.a();
        return;
    }

    public z(RectF r2, int r3, PointF r4) {
        Intrinsics.checkNotNullParameter(r4, "center");
        this.d = new RectF();
        this.a = new RectF(r2);
        this.b = r3;
        this.c = r4;
    }

    public final void c(float r7, float r8, float r9, float r10) {
        if (((this.b / 90) % 2) != 1) goto L5;
        float r0 = r7;
        float r1 = r8;
    L6:
        FLogger r2 = FLogger.a;
        r2.d("PhotoEditScale", "Center before = " + this.c.x + ", scaleCenterX =" + r9 + ", scaleWidth = " + r7);
        PointF r3 = this.c;
        r3.x = ((r3.x - r9) * r7) + r9;
        r3.y = ((r3.y - r10) * r8) + r10;
        StringBuilder r11 = new StringBuilder("Center after = ");
        r11.append(this.c.x);
        r2.d("PhotoEditScale", r11.toString());
        RectF r12 = this.a;
        r12.bottom *= r0;
        r12.top *= r0;
        r12.left *= r1;
        r12.right *= r1;
        a r13 = this.e;
        if (r13 == null) goto L10;
        Intrinsics.checkNotNull(r13);
        r13.a();
        return;
    L10:
        return;
    L5:
        r1 = r7;
        r0 = r8;
        goto L6
    }
}
