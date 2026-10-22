package j80;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final d a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$pos");
        return new d(r2.getX(), r2.getY());
    }

    public static final e b(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$pos");
        return new e(r2.left, r2.top);
    }

    public static final d c(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$rawPos");
        return new d(r2.getRawX(), r2.getRawY());
    }

    public static final void d(Rect r1, e r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$pos");
        Intrinsics.checkNotNullParameter(r2, "value");
        r1.offsetTo(r2.a().intValue(), r2.b().intValue());
    }

    public static final void e(View r1, d r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$pos");
        Intrinsics.checkNotNullParameter(r2, "value");
        r1.setX(r2.a().floatValue());
        r1.setY(r2.b().floatValue());
    }
}
