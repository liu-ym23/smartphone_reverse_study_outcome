package ca2;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import ba2.e;
import com.bytedance.android.livesdk.interactivity.publicscreen.preview.ZoomableControllerImp;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends ZoomableControllerImp {
    public final Matrix A;
    public final float B;
    public final com.bytedance.android.livesdk.interactivity.publicscreen.preview.c C;
    public final b D;
    public long E;
    public boolean F;
    public boolean G;
    public final LinkedHashSet<ca2.a> w;
    public int x;
    public final Matrix y;
    public boolean z;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<T> r0 = this.a.w.iterator();     // Catch: Throwable -> L7
        L4:
            if (r0.hasNext() == false) goto L16;
            ((ca2.a) r0.next()).onTransitionEnd(this.a.x);     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public a(c r1) {
            this.a = r1;
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            Object r5 = r4.getAnimatedValue();
            if (r5 == null) goto L10;
            float r6 = ((Float) r5).floatValue();
            Iterator<T> r0 = this.a.w.iterator();
        L6:
            if (r0.hasNext() == false) goto L8;
            ((ca2.a) r0.next()).onTransitionChanged(this.a.x, r6);
            goto L6
        L8:
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.preview.ZoomableControllerImp
    public final void f(e r3) {
        Intrinsics.checkNotNullParameter(r3, "detector");
        super.f(r3);
        if (this.v == false) goto L5;
        return;
    L5:
        this.x = -1;
        if ((this.e.top - this.g.top) <= 0.001f) goto L8;
        boolean r4 = true;
    L9:
        this.z = !r4;
        return;
    L8:
        r4 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.preview.ZoomableControllerImp
    public final void g(e r7) {
        Intrinsics.checkNotNullParameter(r7, "detector");
        if (this.v == false) goto L5;
        return;
    L5:
        if (this.q.isRunning() == false) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L14;
        return;
    L14:
        if (this.F == false) goto L26;
        if (r7.l != 4) goto L26;
        if (this.z == false) goto L26;
        if (this.x != (-1)) goto L26;
        this.x = 3;
        this.A.set(this.h);
        Iterator<T> r1 = this.w.iterator();
    L23:
        if (r1.hasNext() == false) goto L26;
        ((ca2.a) r1.next()).onTransitionBegin(this.x);
    L26:
        if (this.x != 3) goto L38;
        Matrix r8 = this.h;
        RectF r2 = this.f;
        r8.set(this.A);
        float r3 = this.a.f;
        com.bytedance.android.livesdk.interactivity.publicscreen.preview.c r4 = this.C;
        float r5 = 1 - (r4.d.f / r4.a);
        if (r5 <= 1.0f) goto L31;
        r5 = 1.0f;
    L33:
        r8.postScale(r5, r5, r2.centerX(), r2.centerY());
        Iterator<T> r6 = this.w.iterator();
    L35:
        if (r6.hasNext() == false) goto L37;
        ca2.a r9 = (ca2.a) r6.next();
        int r10 = this.x;
        com.bytedance.android.livesdk.interactivity.publicscreen.preview.c r11 = this.C;
        r9.onTransitionChanged(r10, r11.d.f / r11.a);
        goto L35
    L37:
        r8.postTranslate(this.a.e, r3);
        a();
        return;
    L31:
        if (r5 >= 0.3f) goto L33;
        r5 = 0.3f;
        goto L33
    L38:
        super.g(r7);
        return;
    L7:
        if (this.t.computeScrollOffset() == true) goto L10;
        r0 = false;
        goto L11
    }

    public final void k(boolean r9) {
        this.x = 2;
        this.v = true;
        this.y.set(this.h);
        if (r9 == false) goto L5;
        this.y.postTranslate(this.f.centerX() - this.g.centerX(), this.f.centerY() - this.g.centerY());
        Matrix r10 = this.y;
        float r0 = this.B;
        r10.postScale(r0, r0, this.f.centerX(), this.f.centerY());
    L6:
        Iterator<T> r11 = this.w.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        ((ca2.a) r11.next()).onTransitionBegin(this.x);
        goto L8
    L10:
        i(this.y, this.E, new a(this), this.D);
        return;
    L5:
        Matrix r13 = this.y;
        float r1 = this.B;
        r13.postScale(r1, r1, this.g.centerX(), this.g.centerY());
        goto L6
    }

    public final void l(e r9) {
        Intrinsics.checkNotNullParameter(r9, "detector");
        if (this.v == false) goto L6;
        return;
    L6:
        if (this.x != 3) goto L25;
        Iterator<T> r10 = this.w.iterator();
    L9:
        if (r10.hasNext() == false) goto L11;
        ((ca2.a) r10.next()).onTransitionEnd(this.x);
        goto L9
    L11:
        com.bytedance.android.livesdk.interactivity.publicscreen.preview.c r11 = this.C;
        if ((r11.d.f / r11.a) <= r11.b) goto L14;
        boolean r13 = true;
    L15:
        if (r13 == false) goto L17;
        k(false);
        return;
    L17:
        this.x = 1;
        this.v = true;
        this.y.set(this.A);
        Iterator<T> r14 = this.w.iterator();
    L19:
        if (r14.hasNext() == false) goto L21;
        ((ca2.a) r14.next()).onTransitionBegin(this.x);
        goto L19
    L21:
        i(this.y, this.E, new d(this), this.D);
        return;
    L14:
        r13 = false;
        goto L15
    }

    @Override // ba2.b
    public final /* bridge */ /* synthetic */ void onGestureEnd(e r1) {
        l(r1);
    }

    public c(e r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "transformGestureDetector");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r3, r4);
        this.w = new LinkedHashSet();
        this.x = -1;
        this.y = new Matrix();
        this.z = true;
        this.A = new Matrix();
        this.B = 1.0f;
        this.C = new com.bytedance.android.livesdk.interactivity.publicscreen.preview.c(r4, r3);
        this.D = new b(this);
        this.F = true;
        this.G = true;
    }
}
