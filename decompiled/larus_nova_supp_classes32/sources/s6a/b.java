package s6a;

import android.util.SparseArray;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BaseInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final a a = null;

    public static class a extends SparseArray<BaseInterpolator> {
        public a() {
            put(0, new LinearInterpolator());
            put(1, new AccelerateInterpolator());
            put(2, new DecelerateInterpolator());
            put(3, new AccelerateDecelerateInterpolator());
        }
    }

    /* JADX INFO: renamed from: s6a.b$b, reason: collision with other inner class name */
    public static class InterpolatorC0109b implements Interpolator {
        public final int a;
        public final int b;

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r4) {
            int r0 = this.b;
            if (r0 != 1) goto L5;
            int r1 = this.a;
            int r5 = ((int) (r4 * r1)) + 1;
            if (r5 > r1) goto L28;
        L25:
            float r6 = r5;
        L17:
            return r6 / r1;
        L28:
            r5 = r1;
            goto L25
        L5:
            if (r0 != 2) goto L7;
            r1 = this.a;
            r5 = (int) (r4 * r1);
            if (r5 != r1) goto L25;
            r5 = r5 - 1;
            goto L25
        L7:
            if (r0 != 3) goto L9;
            int r2 = this.a;
            int r7 = (int) (r4 * r2);
            if (r7 != r2) goto L21;
            r7 = r7 - 1;
        L21:
            r6 = r7;
            r1 = r2 - 1;
            goto L17
        L9:
            if (r0 == 4) goto L12;
            return 0.0f;
        L12:
            int r3 = this.a;
            int r8 = ((int) (r4 * r3)) + 1;
            if (r8 <= r3) goto L15;
            r8 = r3;
        L15:
            r6 = r8;
            r1 = r3 + 1;
            goto L17
        }

        public InterpolatorC0109b(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public b() {
    }

    static {
        a = new a();
    }

    public static Interpolator a(s6a.a r5) {
        int r0 = r5.e;
        switch(r0) {
            case 0: goto L24;
            case 1: goto L24;
            case 2: goto L24;
            case 3: goto L24;
            case 4: goto L18;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L4;
        };
    L4:
        LLog.DTHROW(new RuntimeException("layout animation don't support interpolator:" + r0));
        return a.get(0);
    L7:
        return new InterpolatorC0109b((int) r5.f, r5.j);
    L9:
        if (b(r5.f) == true) goto L11;
    L15:
        LLog.w("InterpolatorFactory", "Invalid cubic-bezier control points x1=" + r5.f + ", x2=" + r5.h + ", fallback to linear.");
        return a.get(0);
    L11:
        if (b(r5.h) == false) goto L15;
        return PathInterpolatorCompat.create(r5.f, r5.g, r5.h, r5.i);
    L18:
        if (b(r5.f) == true) goto L22;
        LLog.w("InterpolatorFactory", "Invalid square-bezier control point x=" + r5.f + ", fallback to linear.");
        return a.get(0);
    L22:
        return PathInterpolatorCompat.create(r5.f, r5.g);
    L24:
        return a.get(r0);
    }

    public static boolean b(float r1) {
        if (Float.isNaN(r1) == false) goto L5;
    L11:
        return false;
    L5:
        if (Float.isInfinite(r1) == true) goto L11;
        if (r1 < 0.0f) goto L11;
        if (r1 > 1.0f) goto L11;
        return true;
    }
}
