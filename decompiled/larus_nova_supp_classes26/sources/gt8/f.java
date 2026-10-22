package gt8;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements d.b {
    public final /* synthetic */ d a;

    @Override // gt8.d.b
    public int getType() {
        return 1;
    }

    public f(d r1) {
        this.a = r1;
    }

    @Override // gt8.d.b
    public final void a(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        d r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "event");
        int r0 = r6.getAction();
        if (r0 != 0) goto L5;
        r1.g = new PointF(r6.getX(), r6.getY());
        return;
    L5:
        if (r0 != 1) goto L7;
        FLogger.a.d("ActionHelper", "handleSingleTouchEvent ACTION_UP");
        if (r1.i.a(r1.b.a(), r1.c) == true) goto L16;
        r1.d.b();
        return;
    L16:
        return;
    L7:
        if (r0 != 2) goto L18;
        float r2 = r6.getX() - r1.g.x;
        float r3 = r6.getY();
        PointF r4 = r1.g;
        float r5 = r3 - r4.y;
        r4.set(r6.getX(), r6.getY());
        d.c r7 = r1.d;
        z r8 = r1.b;
        r8.c.offset(r2, r5);
        r7.d(r8);
        return;
    }
}
