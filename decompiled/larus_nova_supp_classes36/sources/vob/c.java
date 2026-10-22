package vob;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class c {
    public static final b a = null;
    public static final a b = null;

    public static class a extends c {
        @Override // vob.c
        public final float a(float r1) {
            return r1;
        }

        @Override // vob.c
        public final float b(float r1) {
            return r1;
        }

        public a() {
        }
    }

    public static class b extends c {
        public final Interpolator c;
        public final Interpolator d;

        public b() {
            this.c = new AccelerateInterpolator(3.0f);
            this.d = new DecelerateInterpolator(3.0f);
        }

        @Override // vob.c
        public final float a(float r2) {
            return ((AccelerateInterpolator) this.c).getInterpolation(r2);
        }

        @Override // vob.c
        public final float b(float r2) {
            return ((DecelerateInterpolator) this.d).getInterpolation(r2);
        }

        @Override // vob.c
        public final float c(float r3) {
            return 1.0f / ((1.0f - a(r3)) + b(r3));
        }
    }

    public c() {
    }

    public abstract float a(float r1);

    public abstract float b(float r1);

    public float c(float r1) {
        return 1.0f;
    }

    static {
        a = new b();
        b = new a();
    }
}
