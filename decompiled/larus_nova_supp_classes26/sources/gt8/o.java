package gt8;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Region;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bmhome.view.crop.ImageCropView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o {
    public static final int E = 0;
    public static final int F = 0;
    public static final int G = 0;
    public static final int H = 0;
    public RectF A;
    public final boolean B;
    public final float C;
    public float D;
    public final RectF a;
    public final z b;
    public final g c;
    public final d d;
    public final e e;
    public final c f;
    public int g;
    public b h;
    public RectF i;
    public RectF j;
    public RectF k;
    public RectF l;
    public RectF m;
    public RectF n;
    public RectF o;
    public RectF p;
    public RectF q;
    public RectF r;
    public final Paint s;
    public final Paint t;
    public final int u;
    public boolean v;
    public boolean w;
    public Bitmap x;
    public Canvas y;
    public float z;

    public static final class a {
    }

    public interface b {
        void a(float r1, float r2);

        void b();

        void c(RectF r1);
    }

    public interface c {
        z a();
    }

    public interface d {
        void a();

        void b(RectF r1);
    }

    public interface e {
        void a();

        void b(RectF r1);

        void c(RectF r1);

        void d();
    }

    public static final class f {
        public static final /* synthetic */ int a = 0;

        static {
        }

        public static RectF a(boolean r4, RectF r5, float r6) {
            Intrinsics.checkNotNullParameter(r5, "imageRect");
            if (r4 == false) goto L10;
            float r7 = r5.width() * r6;
            if (r5.height() <= r7) goto L7;
            float r8 = r5.left;
            float r1 = 2;
            float r0 = (r5.top + (r5.height() / r1)) - (r7 / r1);
            float r9 = r5.right;
            float r10 = r7 + r0;
        L11:
            return new RectF(r8, r0, r9, r10);
        L7:
            float r11 = r5.height() / r6;
            float r2 = 2;
            r8 = (r5.left + (r5.width() / r2)) - (r11 / r2);
            r0 = r5.top;
            float r12 = r5.bottom;
            r9 = r11 + r8;
            r10 = r12;
            goto L11
        L10:
            return new RectF(r5);
        }
    }

    public interface g {
        void a();

        int getViewHeight();

        int getViewWidth();
    }

    static {
        E = c7.b(4);
        F = c7.b(40);
        G = c7.b(90);
        H = c7.b(20);
    }

    public final RectF f() {
        float r0 = this.q.width() / this.q.height();
        float r1 = this.a.width();
        float r2 = this.a.height();
        float r3 = r1 / r2;
        PointF r4 = new PointF(this.a.centerX(), this.a.centerY());
        if (r0 <= r3) goto L5;
        r2 = r1 / r0;
    L6:
        RectF r5 = new RectF();
        float r6 = r4.x;
        float r7 = 2;
        float r8 = r1 / r7;
        r5.left = r6 - r8;
        r5.right = r6 + r8;
        float r9 = r4.y;
        float r10 = r2 / r7;
        r5.top = r9 - r10;
        r5.bottom = r9 + r10;
        return r5;
    L5:
        r1 = r2 * r0;
        goto L6
    }

    public final void i() {
        RectF r1 = this.q;
        float r2 = r1.left;
        int r3 = H;
        float r4 = r1.top;
        this.i = new RectF(r2 - r3, r4 - r3, r2 + r3, r4 + r3);
        RectF r5 = this.q;
        float r6 = r5.right;
        float r7 = r5.top;
        this.j = new RectF(r6 - r3, r7 - r3, r6 + r3, r7 + r3);
        RectF r8 = this.q;
        float r9 = r8.left;
        float r10 = r8.bottom;
        this.k = new RectF(r9 - r3, r10 - r3, r9 + r3, r10 + r3);
        RectF r11 = this.q;
        float r12 = r11.right;
        float r13 = r11.bottom;
        this.l = new RectF(r12 - r3, r13 - r3, r12 + r3, r13 + r3);
        RectF r14 = this.q;
        float r15 = r14.left + r3;
        float r16 = r14.top;
        this.m = new RectF(r15, r16 - r3, r14.right - r3, r16 + r3);
        RectF r17 = this.q;
        float r18 = r17.left;
        this.n = new RectF(r18 - r3, r17.top + r3, r18 + r3, r17.bottom - r3);
        RectF r19 = this.q;
        float r20 = r19.left + r3;
        float r21 = r19.bottom;
        this.o = new RectF(r20, r21 - r3, r19.right - r3, r21 + r3);
        RectF r22 = this.q;
        float r23 = r22.right;
        this.p = new RectF(r23 - r3, r22.top + r3, r23 + r3, r22.bottom - r3);
    }

    public static final void b(final o r6) {
        final RectF r0 = r6.f();
        final RectF r1 = new RectF(r6.q);
        final RectF r2 = new RectF();
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(200);
        r3.addUpdateListener(new m(r6, r2, r0, r1));
        r3.addListener(new y(r6));
        r3.start();
    }

    public final void c(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        r4.save();
        if (this.w == true) goto L5;
        r4.clipRect(this.q, Region.Op.DIFFERENCE);
        r4.drawColor(this.u);
    L5:
        this.y.drawColor(0, PorterDuff.Mode.CLEAR);
        this.s.setAntiAlias(true);
        this.s.setColor(-1);
        this.s.setStyle(Paint.Style.STROKE);
        this.s.setStrokeWidth(c7.b(2));
        if (this.w == false) goto L8;
        this.y.drawRect(this.r, this.s);
        d(this.y, this.r);
        e(this.y, this.r);
        r4.rotate(this.z, this.q.centerX(), this.q.centerY());
    L9:
        r4.drawBitmap(this.x, 0.0f, 0.0f, null);
        r4.restore();
        return;
    L8:
        this.y.drawRect(this.q, this.s);
        e(this.y, this.q);
        d(this.y, this.q);
        goto L9
    }

    public final void h(RectF r6) {
        Intrinsics.checkNotNull(r6);
        float r0 = r6.centerX();
        float r1 = r6.centerY();
        float r2 = RangesKt.coerceAtMost(this.a.height() / r6.height(), this.a.width() / r6.width());
        r6.left = (int) (((r6.left - r0) * r2) + r0);
        r6.right = (int) (((r6.right - r0) * r2) + r0);
        r6.top = (int) (((r6.top - r1) * r2) + r1);
        r6.bottom = (int) (((r6.bottom - r1) * r2) + r1);
    }

    public static final void a(final o r5, RectF r6) {
        r5.getClass();
        final RectF r0 = new RectF();
        final RectF r1 = new RectF(r5.q);
        final RectF r2 = new RectF(r6);
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(200);
        r7.addUpdateListener(new n(r5, r0, r2, r1));
        r7.addListener(new t(r5));
        r7.start();
    }

    public final void d(Canvas r9, RectF r10) {
        this.s.setStyle(Paint.Style.FILL);
        float r0 = r10.left;
        int r1 = E;
        float r2 = r0 - r1;
        float r3 = r10.top - r1;
        int r4 = F;
        r9.drawRect(new RectF(r2, r3, r4 + r2, r1 + r3), this.s);
        r9.drawRect(new RectF(r2, r3, r1 + r2, r4 + r3), this.s);
        float r5 = r10.right - (r4 - r1);
        float r6 = r10.top - r1;
        r9.drawRect(new RectF(r5, r6, r4 + r5, r1 + r6), this.s);
        r9.drawRect(new RectF((r4 - r1) + r5, r6, r5 + r4, r4 + r6), this.s);
        float r7 = r10.left - r1;
        float r8 = r10.bottom - (r4 - r1);
        r9.drawRect(new RectF(r7, r8, r1 + r7, r4 + r8), this.s);
        r9.drawRect(new RectF(r7, (r4 - r1) + r8, r4 + r7, r8 + r4), this.s);
        float r11 = r10.right;
        float r12 = r10.bottom - (r4 - r1);
        r9.drawRect(new RectF(r11, r12, r1 + r11, r4 + r12), this.s);
        r9.drawRect(new RectF(r11 - (r4 - r1), (r4 - r1) + r12, r11 + r1, r12 + r4), this.s);
        float r13 = r10.left - r1;
        float r14 = 2;
        float r15 = ((r10.top + r10.bottom) / r14) - (r4 / 2);
        r9.drawRect(new RectF(r13, r15, r1 + r13, r4 + r15), this.s);
        float r16 = ((r10.left + r10.right) / r14) - (r4 / 2);
        float r17 = r10.top - r1;
        r9.drawRect(new RectF(r16, r17, r4 + r16, r1 + r17), this.s);
        float r18 = r10.right;
        float r19 = ((r10.top + r10.bottom) / r14) - (r4 / 2);
        r9.drawRect(new RectF(r18, r19, r1 + r18, r4 + r19), this.s);
        float r20 = ((r10.left + r10.right) / r14) - (r4 / 2);
        float r110 = r10.bottom;
        r9.drawRect(new RectF(r20, r110, r4 + r20, r1 + r110), this.s);
    }

    public final void e(Canvas r19, RectF r20) {
        float r2 = r20.bottom;
        float r3 = r20.top;
        float r7 = r20.right;
        float r5 = r20.left;
        float r4 = (r2 - r3) / 3.0f;
        r19.drawLine(r5, r3 + r4, r7, r3 + r4, this.t);
        float r13 = r20.left;
        float r6 = r20.top;
        float r8 = 2;
        float r9 = r4 * r8;
        r19.drawLine(r13, r6 + r9, r20.right, r6 + r9, this.t);
        float r10 = r20.left;
        float r11 = (r7 - r5) / 3.0f;
        r19.drawLine(r10 + r11, r20.top, r10 + r11, r20.bottom, this.t);
        float r12 = r20.left;
        float r14 = r11 * r8;
        r19.drawLine(r12 + r14, r20.top, r12 + r14, r20.bottom, this.t);
    }

    public static void g(PointF r8, float r9, float r10, float r11) {
        double r2 = r11 * 0.017453292f;
        float r12 = (float) (((((double) (r8.x - r9)) * Math.cos(r2)) - (((double) (r8.y - r10)) * Math.sin(r2))) + ((double) r9));
        float r13 = (float) (((((double) (r8.x - r9)) * Math.sin(r2)) + (((double) (r8.y - r10)) * Math.cos(r2))) + ((double) r10));
        r8.x = r12;
        r8.y = r13;
    }

    public o(RectF r2, z r3, com.larus.bmhome.view.crop.a.d r4, com.larus.bmhome.view.crop.a.e r5, com.larus.bmhome.view.crop.a.f r6, com.larus.bmhome.view.crop.a.g r7) {
        Intrinsics.checkNotNullParameter(r2, "mImageRect");
        Intrinsics.checkNotNullParameter(r3, "mAvailableRegion");
        Intrinsics.checkNotNullParameter(r4, "mViewDependency");
        Intrinsics.checkNotNullParameter(r5, "mClipRegionChangeListener");
        Intrinsics.checkNotNullParameter(r6, "mTransitionListener");
        Intrinsics.checkNotNullParameter(r7, "mPhotoLocationProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.i = new RectF();
        this.j = new RectF();
        this.k = new RectF();
        this.l = new RectF();
        this.m = new RectF();
        this.n = new RectF();
        this.o = new RectF();
        this.p = new RectF();
        this.q = new RectF();
        this.r = new RectF();
        this.u = ColorProtector.parseColor("#8C000000");
        float r8 = 0.42666668f;
        this.C = 0.42666668f;
        ImageCropView r9 = r4.a;
        boolean r10 = r9.m;
        this.B = r10;
        float r11 = r9.n;
        if (r11 <= 0.0f) goto L5;
        r8 = r11;
    L5:
        this.C = r8;
        int r12 = 1;
        if (r10 == false) goto L8;
        this.D = G * r8;
        this.q = f.a(true, r2, r8);
    L9:
        this.A = new RectF(this.q);
        this.s = new Paint();
        Paint r13 = new Paint();
        this.t = r13;
        r13.setColor(ColorProtector.parseColor("#99FFFFFF"));
        r13.setAntiAlias(true);
        r13.setStrokeWidth(c7.b(1));
        r13.setPathEffect(new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f));
        if (r4.getViewWidth() > 0) goto L12;
        int r14 = 1;
    L14:
        if (r4.getViewHeight() <= 0) goto L17;
        r12 = r4.getViewHeight();
    L17:
        this.x = Bitmap.createBitmap(r14, r12, Bitmap.Config.ARGB_8888);
        this.y = new Canvas(this.x);
        i();
        return;
    L12:
        r14 = r4.getViewWidth();
        goto L14
    L8:
        this.D = G;
        this.q = f.a(false, r2, r8);
        goto L9
    }
}
