package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    public static final int A = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0012a f1704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AccelerateInterpolator f1705b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f1706m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f1707n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float[] f1708o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float[] f1709p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1710q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1711r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float[] f1712s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float[] f1713t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float[] f1714u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1715v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1716w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1717x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1718y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1719z;

    /* JADX INFO: renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    public static class C0012a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1721b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1722c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f1723d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f1724e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f1725f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f1726g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f1727h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f1728i;

        public C0012a() {
            this.f1724e = Long.MIN_VALUE;
            this.f1726g = -1;
            this.f1725f = 0;
        }

        public final float a(long r10) {
            long r8 = this.f1724e;
            if (r10 >= r8) goto L5;
            return 0.0f;
        L5:
            long r11 = this.f1726g;
            if (r11 < 0) goto L13;
            if (r10 < r11) goto L13;
            float r12 = this.f1727h;
            return (a.b((r10 - r11) / this.f1728i, 0.0f, 1.0f) * r12) + (1.0f - r12);
        L13:
            return a.b((r10 - r8) / this.f1720a, 0.0f, 1.0f) * 0.5f;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f1729a;

        public b(a r8) {
            this.f1729a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r8 = this.f1729a;
            if (r8.f1718y == true) goto L5;
            return;
        L5:
            boolean r10 = r8.f1716w;
            C0012a r11 = r8.f1704a;
            if (r10 == false) goto L9;
            r8.f1716w = false;
            r11.getClass();
            long r12 = AnimationUtils.currentAnimationTimeMillis();
            r11.f1724e = r12;
            r11.f1726g = -1;
            r11.f1725f = r12;
            r11.f1727h = 0.5f;
        L9:
            if (r11.f1726g > 0) goto L11;
        L13:
            boolean r13 = false;
        L14:
            if (r13 == false) goto L16;
        L27:
            r8.f1718y = false;
            return;
        L16:
            if (r8.e() == false) goto L27;
            boolean r14 = r8.f1717x;
            View r15 = r8.f1706m;
            if (r14 == false) goto L22;
            r8.f1717x = false;
            long r16 = SystemClock.uptimeMillis();
            MotionEvent r17 = MotionEvent.obtain(r16, r16, 3, 0.0f, 0.0f, 0);
            r15.onTouchEvent(r17);
            r17.recycle();
        L22:
            if (r11.f1725f == 0) goto L26;
            long r18 = AnimationUtils.currentAnimationTimeMillis();
            float r19 = r11.a(r18);
            long r20 = r18 - r11.f1725f;
            r11.f1725f = r18;
            h.b(((g) r8).B, (int) ((r20 * ((r19 * 4.0f) + (((-4.0f) * r19) * r19))) * r11.f1723d));
            WeakHashMap<View, h0> r21 = w.f8437a;
            w.d.m(r15, this);
            return;
        L26:
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        L11:
            if (AnimationUtils.currentAnimationTimeMillis() <= (r11.f1726g + ((long) r11.f1728i))) goto L13;
            r13 = true;
            goto L14
        }
    }

    static {
        A = ViewConfiguration.getTapTimeout();
    }

    public a(View r10) {
        C0012a r8 = new C0012a();
        this.f1704a = r8;
        this.f1705b = new AccelerateInterpolator();
        float[] r11 = {0.0f, 0.0f};
        this.f1708o = r11;
        float[] r12 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1709p = r12;
        float[] r13 = {0.0f, 0.0f};
        this.f1712s = r13;
        float[] r14 = {0.0f, 0.0f};
        this.f1713t = r14;
        float[] r15 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1714u = r15;
        this.f1706m = r10;
        float r16 = Resources.getSystem().getDisplayMetrics().density;
        r15[0] = ((int) ((1575.0f * r16) + 0.5f)) / 1000.0f;
        r14[0] = ((int) ((r16 * 315.0f) + 0.5f)) / 1000.0f;
        this.f1710q = 1;
        r12[0] = Float.MAX_VALUE;
        r11[0] = 0.2f;
        r13[0] = 0.001f;
        this.f1711r = A;
        r8.f1720a = 500;
        r8.f1721b = 500;
    }

    public static float b(float r8, float r10, float r11) {
        if (r8 <= r11) goto L6;
        return r11;
    L6:
        if (r8 >= r10) goto L8;
        return r10;
    L8:
        return r8;
    }

    public final float a(float r8, float r10, float r11, int r12) {
        float r13 = b(this.f1708o[r12] * r10, 0.0f, this.f1709p[r12]);
        float r14 = c(r10 - r8, r13) - c(r8, r13);
        AccelerateInterpolator r15 = this.f1705b;
        if (r14 >= 0.0f) goto L6;
        float r16 = -r15.getInterpolation(-r14);
    L8:
        float r17 = b(r16, -1.0f, 1.0f);
    L11:
        if (r17 != 0.0f) goto L13;
        return 0.0f;
    L13:
        float r18 = this.f1712s[r12];
        float r19 = this.f1713t[r12];
        float r20 = this.f1714u[r12];
        float r21 = r18 * r11;
        if (r17 <= 0.0f) goto L18;
        return b(r17 * r21, r19, r20);
    L18:
        return -b((-r17) * r21, r19, r20);
    L6:
        if (r14 <= 0.0f) goto L9;
        r16 = r15.getInterpolation(r14);
        goto L8
    L9:
        r17 = 0.0f;
        goto L11
    }

    public final float c(float r8, float r10) {
        if (r10 != 0.0f) goto L5;
        return 0.0f;
    L5:
        int r11 = this.f1710q;
        if (r11 == 0) goto L16;
        if (r11 == 1) goto L16;
        if (r11 == 2) goto L12;
    L25:
        return 0.0f;
    L12:
        if (r8 >= 0.0f) goto L25;
        return r8 / (-r10);
    L16:
        if (r8 >= r10) goto L25;
        if (r8 < 0.0f) goto L22;
        return 1.0f - (r8 / r10);
    L22:
        if (this.f1718y == false) goto L25;
        if (r11 != 1) goto L25;
        return 1.0f;
    }

    public final void d() {
        int r8 = 0;
        if (this.f1716w == false) goto L5;
        this.f1718y = false;
        return;
    L5:
        C0012a r10 = this.f1704a;
        r10.getClass();
        long r11 = AnimationUtils.currentAnimationTimeMillis();
        int r12 = (int) (r11 - r10.f1724e);
        int r13 = r10.f1721b;
        if (r12 <= r13) goto L8;
        r8 = r13;
    L11:
        r10.f1728i = r8;
        r10.f1727h = r10.a(r11);
        r10.f1726g = r11;
        return;
    L8:
        if (r12 < 0) goto L11;
        r8 = r12;
        goto L11
    }

    public final boolean e() {
        C0012a r8 = this.f1704a;
        float r10 = r8.f1723d;
        int r11 = (int) (r10 / Math.abs(r10));
        float r12 = r8.f1722c;
        int r13 = (int) (r12 / Math.abs(r12));
        if (r11 == 0) goto L23;
        ListView r14 = ((g) this).B;
        int r15 = r14.getCount();
        if (r15 != 0) goto L7;
    L6:
        boolean r16 = false;
    L19:
        if (r16 == true) goto L22;
        return false;
    L22:
        return true;
    L7:
        int r17 = r14.getChildCount();
        int r18 = r14.getFirstVisiblePosition();
        int r19 = r18 + r17;
        if (r11 <= 0) goto L13;
        if (r19 >= r15) goto L11;
    L18:
        r16 = true;
        goto L19
    L11:
        if (r14.getChildAt(r17 - 1).getBottom() > r14.getHeight()) goto L18;
    L13:
        if (r11 >= 0) goto L6;
        if (r18 > 0) goto L18;
        if (r14.getChildAt(0).getTop() < 0) goto L18;
    L23:
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r8, MotionEvent r10) {
        if (this.f1719z == true) goto L5;
        return false;
    L5:
        int r11 = r10.getActionMasked();
        if (r11 == 0) goto L14;
        if (r11 != 1) goto L9;
    L13:
        d();
    L29:
        return false;
    L9:
        if (r11 != 2) goto L11;
    L15:
        float r12 = r10.getX();
        float r13 = r8.getWidth();
        View r14 = this.f1706m;
        float r15 = a(r12, r13, r14.getWidth(), 0);
        float r16 = a(r10.getY(), r8.getHeight(), r14.getHeight(), 1);
        C0012a r17 = this.f1704a;
        r17.f1722c = r15;
        r17.f1723d = r16;
        if (this.f1718y == true) goto L29;
        if (e() == false) goto L29;
        if (this.f1707n != null) goto L22;
        this.f1707n = new b(this);
    L22:
        this.f1718y = true;
        this.f1716w = true;
        if (this.f1715v == true) goto L27;
        int r18 = this.f1711r;
        if (r18 <= 0) goto L27;
        b r19 = this.f1707n;
        long r20 = r18;
        WeakHashMap<View, h0> r21 = w.f8437a;
        w.d.n(r14, r19, r20);
    L28:
        this.f1715v = true;
    L27:
        this.f1707n.run();
        goto L28
    L11:
        if (r11 == 3) goto L13;
    L14:
        this.f1717x = true;
        this.f1715v = false;
        goto L15
    }
}
