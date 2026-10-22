package com.larus.common_ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s extends l19.l {
    public final Lazy S;
    public Function1<? super Matrix, Unit> T;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp
    public final boolean n() {
        k19.e r0 = this.a;
        if (Math.abs(this.k.left - this.i.left) >= 0.001f) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L14;
        if (Math.abs(this.k.right - this.i.right) >= 0.001f) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
    L15:
        int r3 = r0.l;
        if (r3 == 3) goto L24;
        if (r3 == 1) goto L24;
        if (r3 != (-1)) goto L26;
        if (r0.b.a <= 1) goto L22;
        boolean r4 = true;
    L23:
        if (r4 == true) goto L26;
    L22:
        r4 = false;
    L26:
        if (Math.abs(this.k.top - this.i.top) >= 0.001f) goto L28;
        boolean r5 = true;
    L29:
        if (r5 == false) goto L36;
        if (Math.abs(this.k.bottom - this.i.bottom) >= 0.001f) goto L33;
        boolean r6 = true;
    L34:
        if (r6 == false) goto L36;
    L37:
        int r7 = r0.l;
        if (r7 != 2) goto L40;
        return true;
    L40:
        if (r7 == 4) goto L51;
        if (r7 == (-1)) goto L43;
    L48:
        return false;
    L43:
        if (r0.b.a <= 1) goto L45;
        boolean r8 = true;
    L46:
        if (r8 == true) goto L48;
        return true;
    L45:
        r8 = false;
        goto L46
    L51:
        return true;
    L33:
        r6 = false;
    L36:
        if (m() == false) goto L48;
    L28:
        r5 = false;
    L24:
        return true;
    L11:
        r2 = false;
    L14:
        if (m() == false) goto L26;
    L5:
        r1 = false;
        goto L7
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp
    public final void x() {
        super.x();
        this.T.invoke(this.l);
    }

    @Override // com.larus.common_ui.photoviewer.a
    public final void h(RectF r12) {
        Intrinsics.checkNotNullParameter(r12, "viewBounds");
        super.h(r12);
        if (((Boolean) this.S.getValue()).booleanValue() == false) goto L39;
        RectF r13 = this.j;
        RectF r0 = this.i;
        if (r13.width() > 0.0f) goto L8;
        return;
    L8:
        if (r13.height() > 0.0f) goto L10;
        return;
    L10:
        if (r0.width() > 0.0f) goto L12;
        return;
    L12:
        if (r0.height() <= 0.0f) goto L40;
        float r1 = r13.height() / r13.width();
        float r3 = r0.height() / r0.width();
        if (r1 <= r3) goto L17;
        float r8 = r0.width() / r13.width();
        FLogger.a.i("CustomZoomableControllerImpl", "[" + hashCode() + "] apply scale: " + r8 + ", imageRatio: " + r1 + " > viewRatio: " + r3);
        g(3.0f * r8);
        if (r8 >= 1.0f) goto L29;
    L32:
        PointF r2 = a(new PointF(r13.centerX(), r13.centerY()));
        Matrix r4 = new Matrix();
        r4.setScale(r8, r8, r2.x, r2.y);
        RectF r5 = new RectF(r13);
        r4.mapRect(r5);
        r4.postTranslate(0.0f, r0.top - r5.top);
        p(r4);
        v(r4);
        return;
    L29:
        if (r8 > this.g) goto L32;
        this.f = r8;
        goto L32
    L17:
        if (this.f != 1.0f) goto L19;
        boolean r14 = true;
    L20:
        if (r14 == true) goto L37;
        FLogger.a.i("CustomZoomableControllerImpl", "[" + hashCode() + "] reset scale");
        if (1.0f > this.g) goto L25;
        this.f = 1.0f;
    L25:
        g(3.0f);
        return;
    L37:
        return;
    L19:
        r14 = false;
        goto L20
    L40:
        return;
    }

    public s(k19.e r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "transformGestureDetector");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
        this.S = LazyKt.lazy(new q());
        this.T = new r();
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp
    public final void y(float r1, PointF r2, Runnable r3, ValueAnimator.AnimatorUpdateListener r4) {
        super.y(r1, r2, null, null);
        if (this.d == true) goto L5;
        return;
    L5:
        Matrix r5 = new Matrix();
        j(r5, r1, r2);
        this.T.invoke(r5);
    }
}
