package ba2;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends GestureDetector.SimpleOnGestureListener {
    public final a a;

    public c(a r2) {
        Intrinsics.checkNotNullParameter(r2, "defaultGestureHandler");
        this.a = r2;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        return this.a.onDoubleTap(r2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        return this.a.onDoubleTapEvent(r2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        return this.a.onDown(r2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        this.a.onLongPress(r2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        this.a.onShowPress(r2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        return this.a.onSingleTapConfirmed(r2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        return this.a.onSingleTapUp(r2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r2, MotionEvent r3, float r4, float r5) {
        Intrinsics.checkNotNullParameter(r3, "e2");
        return this.a.onFling(r2, r3, r4, r5);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r2, MotionEvent r3, float r4, float r5) {
        Intrinsics.checkNotNullParameter(r3, "e2");
        return this.a.onScroll(r2, r3, r4, r5);
    }
}
