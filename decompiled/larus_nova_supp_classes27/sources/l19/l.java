package l19;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common_ui.photoviewer.ZoomableControllerImp;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public class l extends ZoomableControllerImp implements i {
    public final LinkedHashSet<f> D;
    public int E;
    public final Matrix F;
    public boolean G;
    public final Matrix H;
    public final j19.b I;
    public final k J;
    public long K;
    public boolean L;
    public boolean M;
    public final Rect N;
    public boolean O;
    public j19.e P;
    public int Q;
    public int R;

    public static final class a implements Runnable {
        public final /* synthetic */ l a;

        @Override // java.lang.Runnable
        public final void run() {
            l r0 = this.a;     // Catch: Throwable -> L7
            Iterator<T> r1 = r0.D.iterator();     // Catch: Throwable -> L7
        L4:
            if (r1.hasNext() == false) goto L16;
            ((f) r1.next()).onTransitionEnd(r0.E);     // Catch: Throwable -> L7
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

        public a(l r1) {
            this.a = r1;
        }
    }

    @Override // l19.i
    public final View b() {
        return null;
    }

    @Override // l19.a
    public final float getMaxDragTransitionFactor() {
        return this.I.d;
    }

    public boolean A() {
        return this.O;
    }

    @Override // l19.a
    public final int getDismissAnimationType() {
        return this.R;
    }

    @Override // l19.a
    public final Rect getEnterTransitionStartRect() {
        return this.N;
    }

    @Override // l19.a
    public final int getPos() {
        return this.Q;
    }

    @Override // l19.a
    public final j19.e getRestoreTransitionProvider() {
        return this.P;
    }

    @Override // l19.a
    public final long getTransitionAnimationDuration() {
        return this.K;
    }

    @Override // l19.a
    public final boolean isDragTransitionEnabled() {
        return this.L;
    }

    @Override // l19.a
    public boolean isSingleTagDismissEnabled() {
        return this.M;
    }

    public void B(boolean r1) {
        this.O = r1;
    }

    @Override // l19.i
    public final void c(f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.D.add(r2);
    }

    @Override // l19.i
    public final void e(f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.D.remove(r2);
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp, k19.b
    public final /* bridge */ /* synthetic */ void onGestureBegin(k19.e r1) {
        q(r1);
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp, k19.b
    public final /* bridge */ /* synthetic */ void onGestureEnd(k19.e r1) {
        r(r1);
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp, k19.b
    public final /* bridge */ /* synthetic */ void onGestureUpdate(k19.e r1) {
        s(r1);
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp
    public final void q(k19.e r3) {
        Intrinsics.checkNotNullParameter(r3, "detector");
        super.q(r3);
        if (this.C == false) goto L5;
        return;
    L5:
        this.E = -1;
        if ((this.i.top - this.k.top) <= 0.001f) goto L8;
        boolean r4 = true;
    L9:
        this.G = !r4;
        return;
    L8:
        r4 = false;
        goto L9
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp
    public final void r(k19.e r9) {
        Intrinsics.checkNotNullParameter(r9, "detector");
        if (this.C == false) goto L6;
        return;
    L6:
        if (this.E != 3) goto L28;
        Iterator<T> r10 = this.D.iterator();
    L9:
        if (r10.hasNext() == false) goto L11;
        ((f) r10.next()).onTransitionEnd(this.E);
        goto L9
    L11:
        j19.b r11 = this.I;
        if ((r11.b.f / r11.c) <= r11.d) goto L14;
        boolean r12 = true;
    L15:
        if (r12 == true) goto L17;
        this.E = 1;
        this.C = true;
        this.F.set(this.H);
        Iterator<T> r13 = this.D.iterator();
    L25:
        if (r13.hasNext() == false) goto L27;
        ((f) r13.next()).onTransitionBegin(this.E);
        goto L25
    L27:
        u(this.F, this.K, new m(this), this.J);
        return;
    L17:
        if (A() == false) goto L19;
        z(false);
        return;
    L19:
        this.E = 2;
        this.C = true;
        Iterator<T> r14 = this.D.iterator();
    L21:
        if (r14.hasNext() == false) goto L35;
        ((f) r14.next()).onTransitionEnd(this.E);
        goto L21
    L35:
        return;
    L14:
        r12 = false;
        goto L15
    L28:
        super.r(r9);
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp
    public final void s(k19.e r7) {
        Intrinsics.checkNotNullParameter(r7, "detector");
        if (this.C == false) goto L5;
        return;
    L5:
        if (l() == false) goto L8;
        return;
    L8:
        if (this.L == false) goto L20;
        if (r7.l != 4) goto L20;
        if (this.G == false) goto L20;
        if (this.E != (-1)) goto L20;
        this.E = 3;
        this.H.set(this.l);
        Iterator<T> r0 = this.D.iterator();
    L17:
        if (r0.hasNext() == false) goto L20;
        ((f) r0.next()).onTransitionBegin(this.E);
    L20:
        if (this.E != 3) goto L29;
        Matrix r8 = this.l;
        RectF r1 = this.j;
        r8.set(this.H);
        float r2 = this.a.f;
        float r3 = this.I.a();
        r8.postScale(r3, r3, r1.centerX(), r1.centerY());
        Iterator<T> r4 = this.D.iterator();
    L23:
        if (r4.hasNext() == false) goto L26;
        f r5 = (f) r4.next();
        int r6 = this.E;
        j19.b r9 = this.I;
        r5.onTransitionChanged(r6, r9.b.f / r9.c);
        goto L23
    L26:
        if (this.e == false) goto L28;
        r8.postTranslate(this.a.e, r2);
    L28:
        d();
        return;
    L29:
        super.s(r7);
    }

    @Override // l19.a
    public final void setDismissAnimationType(int r1) {
        this.R = r1;
    }

    @Override // l19.a
    public final void setDragTransitionEnabled(boolean r1) {
        this.L = r1;
    }

    @Override // l19.a
    public final void setEnterTransitionStartRect(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.N.set(r2);
    }

    @Override // l19.a
    public final void setMaxDragTransitionFactor(float r2) {
        this.I.d = r2;
    }

    @Override // l19.a
    public final void setPos(int r1) {
        this.Q = r1;
    }

    @Override // l19.a
    public final void setRestoreTransitionProvider(j19.e r1) {
        this.P = r1;
    }

    @Override // l19.a
    public void setSingleTagDismissEnabled(boolean r1) {
        this.M = r1;
    }

    @Override // l19.a
    public final void setTransitionAnimationDuration(long r1) {
        this.K = r1;
    }

    public final void z(boolean r9) {
        this.E = 2;
        boolean r0 = true;
        this.C = true;
        this.F.set(this.l);
        j19.e r1 = this.P;
        if (r1 == null) goto L7;
        View r2 = r1.d(this.Q);
        if (r2 == null) goto L7;
        Rect r3 = h.a(r2);
    L8:
        if (r3 != null) goto L10;
    L12:
        r0 = false;
    L13:
        if (r0 == false) goto L15;
        Intrinsics.checkNotNull(r3);
        float r10 = r3.width() / this.k.width();
        this.F.postScale(r10, r10, this.k.centerX(), this.k.centerY());
        this.F.postTranslate(r3.centerX() - this.k.centerX(), r3.centerY() - this.k.centerY());
    L23:
        Iterator<T> r11 = this.D.iterator();
    L25:
        if (r11.hasNext() == false) goto L27;
        ((f) r11.next()).onTransitionBegin(this.E);
        goto L25
    L27:
        u(this.F, this.K, new a(this), this.J);
        return;
    L15:
        if (r9 == false) goto L20;
        this.F.postTranslate(this.j.centerX() - this.k.centerX(), this.j.centerY() - this.k.centerY());
        if (this.R != 0) goto L23;
        this.F.postScale(0.1f, 0.1f, this.j.centerX(), this.j.centerY());
        goto L23
    L20:
        if (this.R != 0) goto L23;
        this.F.postScale(0.1f, 0.1f, this.k.centerX(), this.k.centerY());
        goto L23
    L10:
        if (r3.isEmpty() == true) goto L12;
    L7:
        r3 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [l19.k] */
    public l(k19.e r4, Context r5) {
        Intrinsics.checkNotNullParameter(r4, "transformGestureDetector");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r4, r5);
        this.D = new LinkedHashSet();
        this.E = -1;
        this.F = new Matrix();
        this.G = true;
        this.H = new Matrix();
        this.I = new j19.b(r5, r4);
        this.J = new k(this);
        this.K = 300;
        this.L = true;
        this.M = true;
        this.N = new Rect();
        this.O = true;
        this.Q = -1;
    }
}
