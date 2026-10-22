package rp9;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class a {
    public MotionEvent a;
    public MotionEvent b;
    public float c;
    public float d;
    public boolean e;

    /* JADX INFO: renamed from: rp9.a$a, reason: collision with other inner class name */
    public static final class C0071a {
    }

    static {
    }

    public final void b() {
        MotionEvent r0 = this.a;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.recycle();
        this.a = null;
    L5:
        MotionEvent r1 = this.b;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNull(r1);
        r1.recycle();
        this.b = null;
    L8:
        this.e = false;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
    }

    public final void a(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        int r1 = r6.getAction() & 255;
        if (this.e == true) goto L18;
        c r2 = (c) this;
        Intrinsics.checkNotNullParameter(r6, "event");
        if (r1 == 0) goto L17;
        if (r1 != 2) goto L36;
        c.b r7 = r2.f;
        MotionEvent r0 = r2.a;
        if (r0 == null) goto L12;
        r0.getX();
    L12:
        MotionEvent r3 = r2.a;
        if (r3 == null) goto L16;
        r3.getY();
    L16:
        r7.c(r2);
        r2.e = true;
        return;
    L36:
        return;
    L17:
        r2.b();
        PointF r4 = r2.i;
        r4.x = 0.0f;
        r4.y = 0.0f;
        r2.a = MotionEvent.obtain(r6);
        r2.d(r6);
        return;
    L18:
        c r5 = (c) this;
        Intrinsics.checkNotNullParameter(r6, "event");
        if (r1 == 1) goto L30;
        if (r1 == 2) goto L25;
        if (r1 == 3) goto L30;
        return;
    L25:
        if (r5.a != null) goto L27;
        r5.a = MotionEvent.obtain(r6);
    L27:
        r5.d(r6);
        if ((r5.c / r5.d) <= 0.67f) goto L34;
        r6.getPointerCount();
        r5.f.b(r5);
        MotionEvent r8 = r5.a;
        Intrinsics.checkNotNull(r8);
        r8.recycle();
        r5.a = MotionEvent.obtain(r6);
        return;
    L34:
        return;
    L30:
        r5.f.a(r5);
        r5.b();
    }
}
