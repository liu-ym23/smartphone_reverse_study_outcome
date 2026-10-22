package qp9;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements GestureDetector.OnDoubleTapListener {
    public final /* synthetic */ h a;

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        return false;
    }

    public d(h r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        h r0 = this.a;
        if (r0.b == false) goto L7;
        i r1 = r0.a;
        if (r1 == null) goto L7;
        r1.onDoubleTap(r3);
        return true;
    L7:
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        i r0 = this.a.a;
        if (r0 == null) goto L5;
        r0.onSingleTapConfirmed(r2);
        return true;
    L5:
        return false;
    }
}
