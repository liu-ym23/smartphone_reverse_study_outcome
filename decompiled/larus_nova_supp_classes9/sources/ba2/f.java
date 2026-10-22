package ba2;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends a {
    public final ca2.c e;

    public f(ca2.c r2) {
        Intrinsics.checkNotNullParameter(r2, "transitionZoomableControllerImp");
        super(r2);
        this.e = r2;
    }

    @Override // ba2.a, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        ca2.c r5 = this.e;
        if (r5.G == false) goto L5;
        r5.A.set(r5.h);
        r5.k(true);
    L5:
        return true;
    }

    @Override // ba2.a, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r4, MotionEvent r5, float r6, float r7) {
        Intrinsics.checkNotNullParameter(r5, "e2");
        if (this.e.x != 3) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        super.onFling(r4, r5, r6, r7);
    L9:
        return false;
    L5:
        r0 = false;
        goto L6
    }
}
