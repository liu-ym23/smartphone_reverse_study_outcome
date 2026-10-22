package gt8;

import android.graphics.PointF;
import android.graphics.RectF;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends j.b {
    public final /* synthetic */ d a;

    @Override // gt8.j.b
    public final void a() {
        d r0 = this.a;
        r0.k = true;
        r0.d.e();
    }

    @Override // gt8.j.b
    public final void b() {
        d r0 = this.a;
        r0.k = true;
        r0.d.b();
    }

    @Override // gt8.j.b
    public final void c() {
        FLogger.a.d("ActionHelper", "onLocationChangeStart: " + this.a.k);
        this.a.k = false;
    }

    public b(d r1) {
        this.a = r1;
    }

    @Override // gt8.j.b
    public final void d(RectF r7) {
        d r0 = this.a;
        z r1 = r0.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r7, "rect");
        if (r1.b() == false) goto L5;
        r1.d.set(r7);
        int r2 = ht8.a.a;
        RectF r3 = r1.d;
        ht8.a.c(r3, 90, r3.centerX(), r1.d.centerY());
        r1.a.set(r1.d);
    L6:
        PointF r4 = r1.c;
        r4.x = r7.centerX();
        PointF r5 = r1.c;
        r5.y = r7.centerY();
        z.a r8 = r1.e;
        if (r8 == null) goto L9;
        Intrinsics.checkNotNull(r8);
        r8.a();
    L9:
        r0.d.d(r0.b);
        return;
    L5:
        r1.a.set(r7);
        goto L6
    }
}
