package gt8;

import android.graphics.PointF;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b0 {
    public final b a;
    public a0 b;
    public a0 c;
    public PointF d;
    public PointF e;
    public boolean f;

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e(PointF r1, float r2, float r3, float r4);

        void f();

        void g();

        void onTransformStart();
    }

    static {
    }

    public b0(c r2) {
        Intrinsics.checkNotNullParameter(r2, "touchCallback");
        this.a = r2;
    }

    public final void a(MotionEvent r6) {
        a0 r0 = this.c;
        if (r0 != null) goto L5;
        this.c = new a0(r6.getX(), r6.getY(), r6.getX(1), r6.getY(1));
        return;
    L5:
        if (r0 == null) goto L9;
        float r2 = r6.getX();
        float r3 = r6.getY();
        float r4 = r6.getX(1);
        float r7 = r6.getY(1);
        PointF r1 = r0.a;
        r1.x = r2;
        r1.y = r3;
        PointF r5 = r0.b;
        r5.x = r4;
        r5.y = r7;
        PointF r8 = r0.c;
        float r9 = 2;
        r8.x = (r1.x + r4) / r9;
        r8.y = (r1.y + r7) / r9;
        return;
    }
}
