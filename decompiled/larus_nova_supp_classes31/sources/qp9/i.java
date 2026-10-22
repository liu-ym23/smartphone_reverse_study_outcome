package qp9;

import android.view.MotionEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface i {
    void a(rp9.c r1);

    void b(j r1);

    boolean c(j r1);

    boolean d(j r1);

    void onDoubleTap(MotionEvent r1);

    boolean onDown(MotionEvent r1);

    void onFling(MotionEvent r1, MotionEvent r2, float r3, float r4);

    void onLongPress(MotionEvent r1);

    boolean onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4);

    void onSingleTapConfirmed(MotionEvent r1);
}
