package o9;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
public interface d {

    public static class a implements TypeEvaluator<C0130d> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f9762b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0130d f9763a;

        static {
            f9762b = new a();
        }

        public a() {
            this.f9763a = new C0130d();
        }

        @Override // android.animation.TypeEvaluator
        public final C0130d evaluate(float r8, C0130d r10, C0130d r11) {
            C0130d r12 = r10;
            C0130d r13 = r11;
            float r14 = r12.f9766a;
            float r15 = 1.0f - r8;
            float r16 = r13.f9766a * r8;
            float r17 = r16 + (r14 * r15);
            float r18 = r12.f9767b;
            float r19 = r13.f9767b * r8;
            float r20 = r19 + (r18 * r15);
            float r21 = r12.f9768c;
            float r22 = r8 * r13.f9768c;
            C0130d r23 = this.f9763a;
            r23.f9766a = r17;
            r23.f9767b = r20;
            r23.f9768c = r22 + (r15 * r21);
            return r23;
        }
    }

    public static class b extends Property<d, C0130d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9764a = null;

        static {
            f9764a = new b();
        }

        public b() {
            super(C0130d.class, "circularReveal");
        }

        @Override // android.util.Property
        public final C0130d get(d r8) {
            return r8.getRevealInfo();
        }

        @Override // android.util.Property
        public final void set(d r8, C0130d r10) {
            r8.setRevealInfo(r10);
        }
    }

    public static class c extends Property<d, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f9765a = null;

        static {
            f9765a = new c();
        }

        public c() {
            super(Integer.class, "circularRevealScrimColor");
        }

        @Override // android.util.Property
        public final Integer get(d r8) {
            return Integer.valueOf(r8.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        public final void set(d r8, Integer r10) {
            r8.setCircularRevealScrimColor(r10.intValue());
        }
    }

    /* JADX INFO: renamed from: o9.d$d, reason: collision with other inner class name */
    public static class C0130d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f9766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f9767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f9768c;

        public C0130d() {
        }

        public C0130d(float r8, float r10, float r11) {
            this.f9766a = r8;
            this.f9767b = r10;
            this.f9768c = r11;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    C0130d getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable r8);

    void setCircularRevealScrimColor(int r8);

    void setRevealInfo(C0130d r8);
}
