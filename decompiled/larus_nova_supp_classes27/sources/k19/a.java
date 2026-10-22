package k19;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.larus.common_ui.photoviewer.ZoomableControllerImp;
import j19.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public class a extends GestureDetector.SimpleOnGestureListener {
    public final ZoomableControllerImp a;
    public final PointF b;
    public l c;
    public boolean d;

    public a(ZoomableControllerImp r2) {
        Intrinsics.checkNotNullParameter(r2, "zoomableControllerImp");
        this.a = r2;
        this.b = new PointF();
        this.d = true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "e");
        if (this.d == true) goto L5;
        return false;
    L5:
        l r0 = this.c;
        if (r0 != null) goto L8;
        return false;
    L8:
        ZoomableControllerImp r2 = this.a;
        PointF r3 = new PointF(r7.getX(), r7.getY());
        int r8 = r7.getActionMasked();
        if (r8 == 0) goto L13;
        if (r8 != 1) goto L14;
        r2.l.getValues(r2.n);
        r2.y(r0.nextFactor(r2.n[0]), r3, null, null);
    L14:
        return true;
    L13:
        this.b.set(r3);
        goto L14
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        super.onLongPress(r2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        return super.onSingleTapConfirmed(r2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent r11, MotionEvent r12, float r13, float r14) {
        Intrinsics.checkNotNullParameter(r12, "e2");
        ZoomableControllerImp r15 = this.a;
        r15.l.getValues(r15.n);
        if (r15.n[0] < r15.f) goto L15;
        int r4 = (int) r13;
        int r5 = (int) r14;
        if (r15.w.isRunning() == true) goto L15;
        if (r15.e == false) goto L15;
        if (r15.z.computeScrollOffset() == true) goto L12;
    L14:
        r15.z.fling(0, 0, r4, r5, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        r15.t.set(r15.l);
        Matrix r16 = r15.l;
        r16.set(r16);
        r15.d();
        goto L15
    L12:
        if (r15.z.computeScrollOffset() == false) goto L14;
        r15.z.forceFinished(true);
    L15:
        return false;
    }
}
