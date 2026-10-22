package ba2;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.bytedance.android.livesdk.interactivity.publicscreen.preview.ZoomableControllerImp;
import com.bytedance.android.livesdk.interactivity.publicscreen.preview.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class a extends GestureDetector.SimpleOnGestureListener {
    public final PointF a;
    public com.bytedance.android.livesdk.interactivity.publicscreen.preview.e b;
    public boolean c;
    public final ZoomableControllerImp d;

    public a(ZoomableControllerImp r2) {
        Intrinsics.checkNotNullParameter(r2, "zoomableControllerImp");
        this.d = r2;
        this.a = new PointF();
        this.c = true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent r18) {
        Intrinsics.checkNotNullParameter(r18, "e");
        if (this.c == true) goto L5;
        return false;
    L5:
        com.bytedance.android.livesdk.interactivity.publicscreen.preview.e r1 = this.b;
        if (r1 != null) goto L8;
        return false;
    L8:
        final ZoomableControllerImp r4 = this.d;
        PointF r5 = new PointF(r18.getX(), r18.getY());
        int r2 = r18.getActionMasked();
        if (r2 == 0) goto L19;
        if (r2 != 1) goto L20;
        r4.h.getValues(r4.j);
        float r3 = r1.nextFactor(r4.j[0]);
        if (r4.q.isRunning() == false) goto L15;
        r4.j();
    L15:
        r4.v = true;
        Runnable r8 = new h(r4);
        r4.n.reset();
        Matrix r6 = r4.n;
        float[] r7 = r4.j;
        r7[0] = r5.x;
        r7[1] = r5.y;
        r4.h.invert(r4.i);
        r4.i.mapPoints(r7, 0, r7, 0, 1);
        PointF r9 = new PointF(r7[0], r7[1]);
        r6.setScale(r3, r3, r9.x, r9.y);
        float r10 = r9.x;
        float r11 = r9.y;
        r6.getValues(r4.j);
        float r13 = r4.j[0];
        float r14 = Math.min(Math.max(1.0f, r13), r4.d);
        if (r14 == r13) goto L18;
        float r15 = r14 / r13;
        r6.postScale(r15, r15, r10, r11);
    L18:
        r4.e(r6);
        r4.i(r4.n, r4.r, r8, null);
    L20:
        return true;
    L19:
        this.a.set(r5);
        goto L20
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
    public boolean onFling(MotionEvent r11, MotionEvent r13, float r14, float r15) {
        Intrinsics.checkNotNullParameter(r13, "e2");
        ZoomableControllerImp r16 = this.d;
        r16.h.getValues(r16.j);
        if (r16.j[0] <= 1.0f) goto L12;
        int r4 = (int) r14;
        int r5 = (int) r15;
        if (r16.q.isRunning() == true) goto L12;
        if (r16.t.computeScrollOffset() == true) goto L9;
    L11:
        r16.t.fling(0, 0, r4, r5, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        r16.p.set(r16.h);
        Matrix r17 = r16.h;
        r17.set(r17);
        r16.a();
        goto L12
    L9:
        if (r16.t.computeScrollOffset() == false) goto L11;
        r16.t.forceFinished(true);
    L12:
        return false;
    }
}
