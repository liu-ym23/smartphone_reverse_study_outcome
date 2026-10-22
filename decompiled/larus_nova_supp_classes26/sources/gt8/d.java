package gt8;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public final RectF a;
    public final z b;
    public final RectF c;
    public final c d;
    public final e e;
    public final InterfaceC0110d f;
    public PointF g;
    public final b0 h;
    public final j i;
    public b j;
    public boolean k;
    public final float l;
    public final float m;
    public boolean n;
    public final gt8.e o;
    public final f p;
    public final g q;

    public static final class a {
    }

    public interface b {
        void a(MotionEvent r1);

        int getType();
    }

    public interface c {
        void a();

        void b();

        void c(RectF r1, RectF r2, float r3);

        void d(z r1);

        void e();

        void f(RectF r1);
    }

    /* JADX INFO: renamed from: gt8.d$d, reason: collision with other inner class name */
    public interface InterfaceC0110d {
        boolean a(MotionEvent r1);

        void onTouchEvent(MotionEvent r1);
    }

    public interface e {
        RectF a();

        RectF b();
    }

    static {
    }

    public static void a(RectF r4, RectF r5) {
        Intrinsics.checkNotNullParameter(r4, "rect");
        Intrinsics.checkNotNullParameter(r5, "screen");
        float r0 = r4.centerX();
        float r1 = r4.centerY();
        float r6 = RangesKt.coerceAtMost(r5.height() / r4.height(), r5.width() / r4.width());
        r4.left = (int) (((r4.left - r0) * r6) + r0);
        r4.right = (int) (((r4.right - r0) * r6) + r0);
        r4.top = (int) (((r4.top - r1) * r6) + r1);
        r4.bottom = (int) (((r4.bottom - r1) * r6) + r1);
    }

    public d(RectF r2, z r3, RectF r4, com.larus.bmhome.view.crop.a.C0050a r5, com.larus.bmhome.view.crop.a.b r6, com.larus.bmhome.view.crop.a.c r7) {
        Intrinsics.checkNotNullParameter(r2, "mImageRect");
        Intrinsics.checkNotNullParameter(r3, "mImageShowLocationHelper");
        Intrinsics.checkNotNullParameter(r4, "referenceLocation");
        Intrinsics.checkNotNullParameter(r5, "onActionCallback");
        Intrinsics.checkNotNullParameter(r6, "dependency");
        Intrinsics.checkNotNullParameter(r7, "unInterceptMotionEventCallback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = new PointF();
        this.l = r3.e() * 0.4f;
        this.m = r3.e() * 10.0f;
        this.o = new gt8.e(this);
        this.p = new f(this);
        this.q = new g(this);
        this.k = true;
        this.i = new j(new gt8.b(this));
        this.h = new b0(new gt8.c(this));
    }
}
