package ko1;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f extends ScaleGestureDetector {
    @Override // android.view.ScaleGestureDetector
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return super.onTouchEvent(r2);
    }

    public f(Context r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "scaleGestureListener");
        super(r2, r3);
        new ScaleGestureDetector(r2, r3);
    }
}
