package qp9;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e implements GestureDetector.OnGestureListener {
    public final /* synthetic */ h a;

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent r1) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r1) {
        return false;
    }

    public e(h r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        i r1 = this.a.a;
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.onDown(r3);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        i r0 = this.a.a;
        if (r0 == null) goto L8;
        r0.onLongPress(r2);
        return;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r3, MotionEvent r4, float r5, float r6) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r4 != null) goto L7;
        return false;
    L7:
        i r1 = this.a.a;
        if (r1 == null) goto L11;
        r1.onFling(r3, r4, r5, r6);
        return true;
    L11:
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r3, MotionEvent r4, float r5, float r6) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r4 != null) goto L7;
        return false;
    L7:
        i r1 = this.a.a;
        if (r1 != null) goto L10;
        return false;
    L10:
        return r1.onScroll(r3, r4, r5, r6);
    }
}
