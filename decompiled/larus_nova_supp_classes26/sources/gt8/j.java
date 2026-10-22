package gt8;

import android.animation.ValueAnimator;
import android.graphics.RectF;
import android.view.animation.DecelerateInterpolator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    public final b a;

    public static final class a {
    }

    public static abstract class b {
        public b() {
        }

        public abstract void a();

        public abstract void b();

        public abstract void c();

        public abstract void d(RectF r1);
    }

    static {
    }

    public j(gt8.b r2) {
        Intrinsics.checkNotNullParameter(r2, "mLocationChangedListener");
        this.a = r2;
    }

    public final boolean a(RectF r9, RectF r10) {
        Intrinsics.checkNotNullParameter(r9, "origin");
        Intrinsics.checkNotNullParameter(r10, "limit");
        boolean r2 = false;
        boolean r4 = true;
        if (Math.abs((r9.width() / r9.height()) - (r10.width() / r10.height())) >= 0.001f) goto L24;
        RectF r0 = new RectF(r9);
        RectF r1 = new RectF();
        if (r0.width() < r10.width()) goto L7;
    L9:
        r1.set(r9);
        float r11 = r1.top;
        float r5 = r10.top;
        if (r11 <= r5) goto L12;
        r1.offset(0.0f, r5 - r11);
        r2 = true;
    L12:
        float r12 = r1.left;
        float r6 = r10.left;
        if (r12 <= r6) goto L15;
        r1.offset(r6 - r12, 0.0f);
        r2 = true;
    L15:
        float r13 = r1.bottom;
        float r7 = r10.bottom;
        if (r13 >= r7) goto L18;
        r1.offset(0.0f, r7 - r13);
        r2 = true;
    L18:
        float r14 = r1.right;
        float r15 = r10.right;
        if (r14 >= r15) goto L21;
        r1.offset(r15 - r14, 0.0f);
    L22:
        if (r4 == false) goto L49;
        b(r0, r1);
    L49:
        return r4;
    L21:
        r4 = r2;
        goto L22
    L7:
        if (r0.height() >= r10.height()) goto L9;
        r1.set(r10);
        goto L22
    L24:
        RectF r3 = new RectF(r9);
        RectF r8 = new RectF();
        if (r3.width() < r10.width()) goto L43;
        if (r3.height() < r10.height()) goto L43;
        r8.set(r9);
        float r16 = r8.top;
        float r17 = r10.top;
        if (r16 <= r17) goto L32;
        r8.offset(0.0f, r17 - r16);
        r2 = true;
    L32:
        float r18 = r8.left;
        float r19 = r10.left;
        if (r18 <= r19) goto L35;
        r8.offset(r19 - r18, 0.0f);
        r2 = true;
    L35:
        float r20 = r8.bottom;
        float r21 = r10.bottom;
        if (r20 >= r21) goto L38;
        r8.offset(0.0f, r21 - r20);
        r2 = true;
    L38:
        float r22 = r8.right;
        float r110 = r10.right;
        if (r22 >= r110) goto L41;
        r8.offset(r110 - r22, 0.0f);
    L47:
        if (r4 == false) goto L49;
        b(r3, r8);
        goto L49
    L41:
        r4 = r2;
    L43:
        if ((r9.width() / r9.height()) <= (r10.width() / r10.height())) goto L45;
        float r23 = r10.height();
        float r24 = r9.width() * (r23 / r9.height());
    L46:
        float r25 = 2;
        float r26 = r24 / r25;
        float r27 = r23 / r25;
        r8.set(r10.centerX() - r26, r10.centerY() - r27, r10.centerX() + r26, r10.centerY() + r27);
        goto L47
    L45:
        float r28 = r10.width();
        r23 = r9.height() * (r28 / r9.width());
        r24 = r28;
        goto L46
    }

    public final void b(final RectF r5, final RectF r6) {
        final RectF r0 = new RectF();
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300);
        r1.addUpdateListener(new i(r0, r6, r5, this));
        r1.setInterpolator(new DecelerateInterpolator());
        r1.addListener(new k(this));
        r1.start();
    }
}
