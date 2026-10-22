package e18;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e extends GestureDetector.SimpleOnGestureListener {
    public final WheelView a;

    public e(WheelView r2) {
        Intrinsics.checkNotNullParameter(r2, "loopView");
        this.a = r2;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "e2");
        if (r1 != null) goto L6;
        return false;
    L6:
        this.a.scrollBy(r4);
        return true;
    }
}
