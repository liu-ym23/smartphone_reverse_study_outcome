package rp9;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;
import qp9.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c extends rp9.a {
    public static final PointF j = null;
    public final b f;
    public PointF g;
    public PointF h;
    public final PointF i;

    public static final class a {
    }

    public interface b {
        void a(c r1);

        void b(c r1);

        void c(c r1);
    }

    static {
        j = new PointF();
    }

    public static PointF c(MotionEvent r5) {
        int r0 = r5.getPointerCount();
        float r1 = 0.0f;
        float r2 = 0.0f;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1 = r1 + r5.getX(r3);
        r2 = r2 + r5.getY(r3);
        r3 = r3 + 1;
        goto L3
    L5:
        float r4 = r0;
        return new PointF(r1 / r4, r2 / r4);
    }

    public final void d(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "curr");
        Intrinsics.checkNotNullParameter(r4, "curr");
        MotionEvent r0 = this.a;
        MotionEvent r1 = this.b;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        r1.recycle();
        this.b = null;
    L5:
        this.b = MotionEvent.obtain(r4);
        r4.getEventTime();
        Intrinsics.checkNotNull(r0);
        r0.getEventTime();
        this.c = r4.getPressure(r4.getActionIndex());
        this.d = r0.getPressure(r0.getActionIndex());
        MotionEvent r2 = this.a;
        this.g = c(r4);
        Intrinsics.checkNotNull(r2);
        this.h = c(r2);
        if (r2.getPointerCount() == r4.getPointerCount()) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
        PointF r6 = j;
    L12:
        PointF r3 = this.i;
        r3.x += r6.x;
        r3.y += r6.y;
        return;
    L11:
        PointF r7 = this.g;
        Intrinsics.checkNotNull(r7);
        float r8 = r7.x;
        PointF r9 = this.h;
        Intrinsics.checkNotNull(r9);
        float r10 = r8 - r9.x;
        PointF r11 = this.g;
        Intrinsics.checkNotNull(r11);
        float r12 = r11.y;
        PointF r13 = this.h;
        Intrinsics.checkNotNull(r13);
        r6 = new PointF(r10, r12 - r13.y);
        goto L12
    L8:
        r5 = false;
        goto L9
    }

    public c(Context r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "mListener");
        super(r2);
        this.f = r3;
        this.i = new PointF();
        new PointF();
    }
}
