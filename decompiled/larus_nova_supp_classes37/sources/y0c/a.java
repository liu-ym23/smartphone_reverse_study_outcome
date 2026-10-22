package y0c;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {
    public final b a;
    public final boolean b;
    public final boolean c;

    public a(b r2) {
        this.b = true;
        this.c = true;
        this.a = r2;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r2) {
        b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onDoubleTap(r2);
    L6:
        return super.onDoubleTap(r2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r3) {
        Log.d("GestureCallbackHandler", "onDown...");
        b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onDown(r3);
    L6:
        return this.b;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r2) {
        b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onLongPress(r2);
    L5:
        super.onLongPress(r2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r2) {
        b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onSingleTapUp(r2);
    L6:
        return super.onSingleTapUp(r2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        return super.onFling(r1, r2, r3, r4);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r3, MotionEvent r4, float r5, float r6) {
        b r0 = this.a;
        if (r0 == null) goto L8;
        if (this.c == false) goto L8;
        r0.onScroll(r3, r4, r5, r6);
    L8:
        return super.onScroll(r3, r4, r5, r6);
    }
}
