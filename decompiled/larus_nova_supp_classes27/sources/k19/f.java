package k19;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;
import l19.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f extends a {
    public final l e;

    public f(l r2) {
        Intrinsics.checkNotNullParameter(r2, "transitionZoomableControllerImp");
        super(r2);
        this.e = r2;
    }

    @Override // k19.a, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        if (this.e.isSingleTagDismissEnabled() == false) goto L5;
        l r5 = this.e;
        r5.H.set(r5.l);
        r5.z(true);
    L5:
        return true;
    }

    @Override // k19.a, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r4, MotionEvent r5, float r6, float r7) {
        Intrinsics.checkNotNullParameter(r5, "e2");
        if (this.e.E != 3) goto L5;
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
