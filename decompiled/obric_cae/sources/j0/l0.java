package j0;

import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f8394a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a0.b f8395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a0.b f8396b;

        public a(WindowInsetsAnimation.Bounds r8) {
            this.f8395a = a0.b.c(r8.getLowerBound());
            this.f8396b = a0.b.c(r8.getUpperBound());
        }

        public final String toString() {
            return "Bounds{lower=" + this.f8395a + " upper=" + this.f8396b + "}";
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8397a;

        public b() {
            this.f8397a = 0;
        }

        public abstract m0 a(m0 r8, List<l0> r10);
    }

    public static class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowInsetsAnimation f8398a;

        public static class a extends WindowInsetsAnimation.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f8399a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public List<l0> f8400b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public ArrayList<l0> f8401c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final HashMap<WindowInsetsAnimation, l0> f8402d;

            public a(k9.d r8) {
                super(r8.f8397a);
                this.f8402d = new HashMap();
                this.f8399a = r8;
            }

            public final l0 a(WindowInsetsAnimation r8) {
                HashMap<WindowInsetsAnimation, l0> r10 = this.f8402d;
                l0 r11 = r10.get(r8);
                if (r11 != null) goto L6;
                l0 r12 = new l0(r8);
                r10.put(r8, r12);
                return r12;
            L6:
                return r11;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final void onEnd(WindowInsetsAnimation r8) {
                a(r8);
                ((k9.d) this.f8399a).f8979b.setTranslationY(0.0f);
                this.f8402d.remove(r8);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final void onPrepare(WindowInsetsAnimation r8) {
                a(r8);
                k9.d r10 = (k9.d) this.f8399a;
                View r11 = r10.f8979b;
                int[] r12 = r10.f8982e;
                r11.getLocationOnScreen(r12);
                r10.f8980c = r12[1];
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final WindowInsets onProgress(WindowInsets r8, List<WindowInsetsAnimation> r10) {
                ArrayList<l0> r11 = this.f8401c;
                if (r11 != null) goto L5;
                ArrayList<l0> r12 = new ArrayList(r10.size());
                this.f8401c = r12;
                this.f8400b = Collections.unmodifiableList(r12);
            L6:
                int r13 = r10.size();
            L7:
                r13 = r13 - 1;
                if (r13 < 0) goto L10;
                WindowInsetsAnimation r14 = r10.get(r13);
                l0 r15 = a(r14);
                r15.f8394a.c(r14.getFraction());
                this.f8401c.add(r15);
                goto L7
            L10:
                m0 r16 = m0.h(null, r8);
                this.f8399a.a(r16, this.f8400b);
                return r16.g();
            L5:
                r11.clear();
                goto L6
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation r8, WindowInsetsAnimation.Bounds r10) {
                a(r8);
                a r11 = new a(r10);
                k9.d r12 = (k9.d) this.f8399a;
                View r13 = r12.f8979b;
                int[] r14 = r12.f8982e;
                r13.getLocationOnScreen(r14);
                int r15 = r12.f8980c - r14[1];
                r12.f8981d = r15;
                r13.setTranslationY(r15);
                return new WindowInsetsAnimation.Bounds(r11.f8395a.d(), r11.f8396b.d());
            }
        }

        public c(WindowInsetsAnimation r8) {
            this.f8398a = r8;
        }

        public final float a() {
            return this.f8398a.getInterpolatedFraction();
        }

        public final int b() {
            return this.f8398a.getTypeMask();
        }

        public final void c(float r8) {
            this.f8398a.setFraction(r8);
        }
    }

    public static class d {
        public d() {
        }
    }

    public l0(int r8, DecelerateInterpolator r10, long r11) {
        this.f8394a = new c(new WindowInsetsAnimation(r8, r10, r11));
    }

    public l0(WindowInsetsAnimation r8) {
        this(0, null, 0);
        this.f8394a = new c(r8);
    }
}
