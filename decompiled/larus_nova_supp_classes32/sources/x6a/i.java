package x6a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.PropBundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class i {
    public final Rect a;
    public final Point b;
    public final int c;
    public final PlatformRendererContext d;
    public c e;
    public final b f;
    public e g;
    public LynxBaseUI h;
    public int i;

    public void f() {
    }

    public void j(PropBundle r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h() {
        if (this.g != null) goto L5;
        return;
    L5:
        LynxBaseUI r0 = this.h;
        if (r0 != null) goto L8;
    L10:
        View r1 = this.g.getView();
        if ((r1 instanceof ViewGroup) == true) goto L13;
        return;
    L13:
        ViewGroup r2 = (ViewGroup) r1;
        int r3 = 0;
    L15:
        if (r3 >= r2.getChildCount()) goto L23;
        View r4 = r2.getChildAt(r3);
        if ((r4 instanceof e) == false) goto L22;
        i r5 = ((e) r4).getRenderer();
        if (r5 == null) goto L22;
        Rect r6 = r5.a;
        r4.layout(r6.left, r6.top, r6.right, r6.bottom);
    L22:
        r3 = r3 + 1;
        goto L15
    L23:
        return;
    L8:
        if (r0.isFlatten() == false) goto L10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i() {
        if (this.g != null) goto L5;
        return;
    L5:
        LynxBaseUI r0 = this.h;
        if (r0 != null) goto L8;
    L10:
        View r1 = this.g.getView();
        if ((r1 instanceof ViewGroup) == true) goto L13;
        return;
    L13:
        ViewGroup r2 = (ViewGroup) r1;
        int r3 = 0;
    L15:
        if (r3 >= r2.getChildCount()) goto L23;
        View r4 = r2.getChildAt(r3);
        if ((r4 instanceof e) == false) goto L22;
        i r5 = ((e) r4).getRenderer();
        if (r5 == null) goto L22;
        Rect r6 = r5.a;
        r4.measure(View.MeasureSpec.makeMeasureSpec(r6.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(r6.height(), 1073741824));
    L22:
        r3 = r3 + 1;
        goto L15
    L23:
        return;
    L8:
        if (r0.isFlatten() == false) goto L10;
    }

    public static Matrix d(float[] r6) {
        Matrix r0 = new Matrix();
        r0.setValues(new float[]{r6[0], r6[4], r6[12], r6[1], r6[5], r6[13], r6[3], r6[7], r6[15]});
        return r0;
    }

    public final void a(Canvas r2) {
        c r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.c(r2);
        c r3 = this.e;
        r3.q = 0;
        r3.r = 0;
        r3.s = 0;
        r3.t = 0;
        r3.v.clear();
    }

    public final void c(Canvas r2) {
        c r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.c(r2);
    }

    public final void e(int r2) {
        e r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.invalidateForRenderer();
        if ((r2 & 1) == 0) goto L13;
        if (this.g.getView() == null) goto L13;
        if ((this.g.getView().getParent() instanceof View) == false) goto L13;
        ((View) this.g.getView().getParent()).invalidate();
    L13:
        if ((r2 & 2) == 0) goto L16;
        this.i = 2;
        return;
    }

    public void g(Canvas r11) {
        if (this.i != 2) goto L18;
        PlatformRendererContext r3 = this.d;
        int r6 = this.c;
        b r12 = this.f;
        if (r12 != null) goto L7;
        r3.getClass();
        goto L18
    L7:
        if (r3.h == true) goto L18;
        long r4 = r3.f;
        if (r4 == 0) goto L18;
        int[] r5 = r3.nativeGetDisplayListLengths(r4, r6);
        if (r5 == null) goto L18;
        if (r5.length != 3) goto L18;
        int r7 = r5[0];
        int r8 = r5[1];
        int r2 = r5[2];
        int[] r9 = new int[r7];
        r12.a = r9;
        int[] r10 = new int[r8];
        r12.b = r10;
        float[] r13 = new float[r2];
        r12.c = r13;
        r3.nativeGetDisplayListData(r3.f, r6, r9, r10, r13);
    L18:
        c r14 = this.e;
        if (r14 != null) goto L21;
        this.e = new c(this.f, this.d, this.g);
    L22:
        this.i = 1;
        return;
    L21:
        b r15 = this.f;
        r14.j(r15);
        r14.a = r15;
        r14.q = 0;
        r14.r = 0;
        r14.s = 0;
        r14.t = 0;
        r14.v.clear();
        goto L22
    }

    public i(PlatformRendererContext r2, int r3) {
        this.a = new Rect();
        this.b = new Point();
        this.e = null;
        this.f = new b();
        this.i = 2;
        this.d = r2;
        this.c = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(Canvas r2, View r3) {
        c r0 = this.e;
        if (r0 != null) goto L6;
        r2.save();
        return;
    L6:
        r0.c(r2);
        r2.save();
        if ((r3 instanceof e) == false) goto L12;
        i r4 = ((e) r3).getRenderer();
        if (r4 == null) goto L13;
        Point r5 = r4.b;
        r2.translate(-r5.x, -r5.y);
        return;
    L13:
        return;
    }
}
