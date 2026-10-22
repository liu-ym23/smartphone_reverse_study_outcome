package i9;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import i9.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T extends b<T>> implements i9.a.b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final r f9412m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final r f9413n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final r f9414o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final r f9415p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final r f9416q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final r f9417r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final r f9418s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f9419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f9420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f9421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Object f9422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final i9.c f9423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f9424f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f9425g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f9426h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f9427i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f9428j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ArrayList<p> f9429k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ArrayList<q> f9430l;

    class a extends r {
        a(String r10) {
            super(r10, null);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ float a(View r10) {
            return c(r10);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ void b(View r10, float r11) {
            d(r10, r11);
        }

        public float c(View r10) {
            return r10.getY();
        }

        public void d(View r10, float r11) {
            r10.setY(r11);
        }
    }

    /* JADX INFO: renamed from: i9.b$b, reason: collision with other inner class name */
    class C0186b extends r {
        C0186b(String r10) {
            super(r10, null);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ float a(View r10) {
            return c(r10);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ void b(View r10, float r11) {
            d(r10, r11);
        }

        public float c(View r10) {
            return r10.getZ();
        }

        public void d(View r10, float r11) {
            r10.setZ(r11);
        }
    }

    class c extends r {
        c(String r10) {
            super(r10, null);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ float a(View r10) {
            return c(r10);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ void b(View r10, float r11) {
            d(r10, r11);
        }

        public float c(View r10) {
            return r10.getAlpha();
        }

        public void d(View r10, float r11) {
            r10.setAlpha(r11);
        }
    }

    class d extends r {
        d(String r10) {
            super(r10, null);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ float a(View r10) {
            return c(r10);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ void b(View r10, float r11) {
            d(r10, r11);
        }

        public float c(View r10) {
            return r10.getScrollX();
        }

        public void d(View r10, float r11) {
            r10.setScrollX((int) r11);
        }
    }

    class e extends r {
        e(String r10) {
            super(r10, null);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ float a(View r10) {
            return c(r10);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ void b(View r10, float r11) {
            d(r10, r11);
        }

        public float c(View r10) {
            return r10.getScrollY();
        }

        public void d(View r10, float r11) {
            r10.setScrollY((int) r11);
        }
    }

    class f extends r {
        f(String r10) {
            super(r10, null);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ float a(View r10) {
            return c(r10);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ void b(View r10, float r11) {
            d(r10, r11);
        }

        public float c(View r10) {
            return r10.getTranslationX();
        }

        public void d(View r10, float r11) {
            r10.setTranslationX(r11);
        }
    }

    class g extends r {
        g(String r10) {
            super(r10, null);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ float a(View r10) {
            return c(r10);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ void b(View r10, float r11) {
            d(r10, r11);
        }

        public float c(View r10) {
            return r10.getTranslationY();
        }

        public void d(View r10, float r11) {
            r10.setTranslationY(r11);
        }
    }

    class h extends r {
        h(String r10) {
            super(r10, null);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ float a(View r10) {
            return c(r10);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ void b(View r10, float r11) {
            d(r10, r11);
        }

        public float c(View r10) {
            return r10.getTranslationZ();
        }

        public void d(View r10, float r11) {
            r10.setTranslationZ(r11);
        }
    }

    class i extends r {
        i(String r10) {
            super(r10, null);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ float a(View r10) {
            return c(r10);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ void b(View r10, float r11) {
            d(r10, r11);
        }

        public float c(View r10) {
            return r10.getScaleX();
        }

        public void d(View r10, float r11) {
            r10.setScaleX(r11);
        }
    }

    class j extends r {
        j(String r10) {
            super(r10, null);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ float a(View r10) {
            return c(r10);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ void b(View r10, float r11) {
            d(r10, r11);
        }

        public float c(View r10) {
            return r10.getScaleY();
        }

        public void d(View r10, float r11) {
            r10.setScaleY(r11);
        }
    }

    class k extends r {
        k(String r10) {
            super(r10, null);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ float a(View r10) {
            return c(r10);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ void b(View r10, float r11) {
            d(r10, r11);
        }

        public float c(View r10) {
            return r10.getRotation();
        }

        public void d(View r10, float r11) {
            r10.setRotation(r11);
        }
    }

    class l extends r {
        l(String r10) {
            super(r10, null);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ float a(View r10) {
            return c(r10);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ void b(View r10, float r11) {
            d(r10, r11);
        }

        public float c(View r10) {
            return r10.getRotationX();
        }

        public void d(View r10, float r11) {
            r10.setRotationX(r11);
        }
    }

    class m extends r {
        m(String r10) {
            super(r10, null);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ float a(View r10) {
            return c(r10);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ void b(View r10, float r11) {
            d(r10, r11);
        }

        public float c(View r10) {
            return r10.getRotationY();
        }

        public void d(View r10, float r11) {
            r10.setRotationY(r11);
        }
    }

    class n extends r {
        n(String r10) {
            super(r10, null);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ float a(View r10) {
            return c(r10);
        }

        @Override // i9.c
        public /* bridge */ /* synthetic */ void b(View r10, float r11) {
            d(r10, r11);
        }

        public float c(View r10) {
            return r10.getX();
        }

        public void d(View r10, float r11) {
            r10.setX(r11);
        }
    }

    static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f9431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f9432b;

        o() {
        }
    }

    public interface p {
        void a(b r10, boolean r11, float r12, float r13);
    }

    public interface q {
        void a(b r10, float r11, float r12);
    }

    public static abstract class r extends i9.c<View> {
        private r(String r10) {
            super(r10);
        }

        /* synthetic */ r(String r10, f r11) {
            this(r10);
        }
    }

    static {
        new f("translationX");
        f9412m = new g("translationY");
        new h("translationZ");
        f9413n = new i("scaleX");
        f9414o = new j("scaleY");
        f9415p = new k(Key.ROTATION);
        f9416q = new l("rotationX");
        f9417r = new m("rotationY");
        new n("x");
        new a("y");
        new C0186b("z");
        f9418s = new c("alpha");
        new d("scrollX");
        new e("scrollY");
    }

    <K> b(K r10, i9.c<K> r11) {
        this.f9419a = 0.0f;
        this.f9420b = Float.MAX_VALUE;
        this.f9421c = false;
        this.f9424f = false;
        this.f9425g = Float.MAX_VALUE;
        this.f9426h = -Float.MAX_VALUE;
        this.f9427i = 0;
        this.f9429k = new ArrayList();
        this.f9430l = new ArrayList();
        this.f9422d = r10;
        this.f9423e = r11;
        if (r11 != f9415p) goto L5;
    L18:
        float r12 = 0.1f;
    L19:
        this.f9428j = r12;
        return;
    L5:
        if (r11 == f9416q) goto L18;
        if (r11 == f9417r) goto L18;
        if (r11 != f9418s) goto L13;
    L11:
        this.f9428j = 0.00390625f;
        return;
    L13:
        if (r11 == f9413n) goto L11;
        if (r11 == f9414o) goto L11;
        r12 = 1.0f;
        goto L19
    }

    private void d(boolean r10) {
        int r11 = 0;
        this.f9424f = false;
        i9.a.d().g(this);
        this.f9427i = 0;
        this.f9421c = false;
    L4:
        if (r11 >= this.f9429k.size()) goto L9;
        if (this.f9429k.get(r11) == null) goto L8;
        this.f9429k.get(r11).a(this, r10, this.f9420b, this.f9419a);
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        j(this.f9429k);
    }

    private float e() {
        return this.f9423e.a(this.f9422d);
    }

    private static <T> void i(ArrayList<T> r10, T r11) {
        int r12 = r10.indexOf(r11);
        if (r12 < 0) goto L6;
        r10.set(r12, null);
        return;
    }

    private static <T> void j(ArrayList<T> r10) {
        int r11 = r10.size() - 1;
    L3:
        if (r11 < 0) goto L8;
        if (r10.get(r11) != null) goto L7;
        r10.remove(r11);
    L7:
        r11 = r11 - 1;
        goto L3
    }

    private void r() {
        if (this.f9424f == true) goto L14;
        this.f9424f = true;
        if (this.f9421c == true) goto L7;
        this.f9420b = e();
    L7:
        float r10 = this.f9420b;
        if (r10 > this.f9425g) goto L13;
        if (r10 < this.f9426h) goto L13;
        i9.a.d().a(this, 0);
        return;
    L13:
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    }

    public T a(p r10) {
        if (this.f9429k.contains(r10) == true) goto L5;
        this.f9429k.add(r10);
    L5:
        return this;
    }

    public T b(q r10) {
        if (g() == true) goto L9;
        if (this.f9430l.contains(r10) == true) goto L7;
        this.f9430l.add(r10);
    L7:
        return this;
    L9:
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    public void c() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        if (this.f9424f == false) goto L10;
        d(true);
        return;
    L10:
        return;
    L9:
        throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
    }

    @Override // i9.a.b
    public boolean doAnimationFrame(long r10) {
        long r11 = this.f9427i;
        if (r11 != 0) goto L6;
        this.f9427i = r10;
        n(this.f9420b);
        return false;
    L6:
        this.f9427i = r10;
        boolean r12 = s(r10 - r11);
        float r13 = Math.min(this.f9420b, this.f9425g);
        this.f9420b = r13;
        float r14 = Math.max(r13, this.f9426h);
        this.f9420b = r14;
        n(r14);
        if (r12 == false) goto L9;
        d(false);
    L9:
        return r12;
    }

    float f() {
        return this.f9428j * 0.75f;
    }

    public boolean g() {
        return this.f9424f;
    }

    public void h(p r10) {
        i(this.f9429k, r10);
    }

    public void k(q r10) {
        i(this.f9430l, r10);
    }

    public T l(float r10) {
        this.f9425g = r10;
        return this;
    }

    public T m(float r10) {
        this.f9426h = r10;
        return this;
    }

    void n(float r10) {
        this.f9423e.b(this.f9422d, r10);
        int r11 = 0;
    L4:
        if (r11 >= this.f9430l.size()) goto L9;
        if (this.f9430l.get(r11) == null) goto L8;
        this.f9430l.get(r11).a(this, this.f9420b, this.f9419a);
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        j(this.f9430l);
    }

    public T o(float r10) {
        this.f9420b = r10;
        this.f9421c = true;
        return this;
    }

    public T p(float r10) {
        this.f9419a = r10;
        return this;
    }

    public void q() {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L5;
        Log.e("DynamicAnimation", "Current Thread Id + " + Thread.currentThread().getId() + " Main Thread Id + " + Looper.getMainLooper().getThread().getId());
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    L5:
        if (this.f9424f == true) goto L10;
        r();
        return;
    }

    abstract boolean s(long r10);
}
