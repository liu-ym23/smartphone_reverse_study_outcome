package qp9;

import android.view.MotionEvent;
import android.view.View;
import com.larus.photopicker.v2.impl.others.scale.Vector2D;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j {
    public final b a;
    public boolean b;
    public MotionEvent c;
    public MotionEvent d;
    public final Vector2D e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public boolean q;
    public int r;
    public int s;
    public boolean t;

    public static final class a {
    }

    public interface b {
        boolean a(View r1, j r2);

        boolean b(View r1, j r2);

        void c(View r1, j r2);
    }

    static {
    }

    public final void b() {
        MotionEvent r0 = this.c;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.recycle();
        this.c = null;
    L5:
        MotionEvent r1 = this.d;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNull(r1);
        r1.recycle();
        this.d = null;
    L8:
        this.b = false;
        this.r = -1;
        this.s = -1;
        this.q = false;
    }

    public j(g r2) {
        Intrinsics.checkNotNullParameter(r2, "mListener");
        this.a = r2;
        this.e = new Vector2D();
    }

    public final void c(View r13, MotionEvent r14) {
        MotionEvent r0 = this.d;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.recycle();
    L5:
        this.d = MotionEvent.obtain(r14);
        this.l = -1.0f;
        this.m = -1.0f;
        this.n = -1.0f;
        this.e.set(0.0f, 0.0f);
        MotionEvent r1 = this.c;
        Intrinsics.checkNotNull(r1);
        int r2 = r1.findPointerIndex(this.r);
        int r3 = r1.findPointerIndex(this.s);
        int r4 = r14.findPointerIndex(this.r);
        int r5 = r14.findPointerIndex(this.s);
        if (r2 < 0) goto L13;
        if (r3 < 0) goto L13;
        if (r4 < 0) goto L13;
        if (r5 < 0) goto L13;
        float r15 = r1.getX(r2);
        float r6 = r1.getY(r2);
        float r7 = r1.getX(r3);
        float r8 = r1.getY(r3);
        float r9 = r14.getX(r4);
        float r10 = r14.getY(r4);
        float r11 = r14.getX(r5);
        float r12 = r7 - r15;
        float r16 = r11 - r9;
        float r17 = r14.getY(r5) - r10;
        this.e.set(r16, r17);
        this.h = r12;
        this.i = r8 - r6;
        this.j = r16;
        this.k = r17;
        this.f = r9 + (r16 * 0.5f);
        this.g = r10 + (r17 * 0.5f);
        r14.getEventTime();
        r1.getEventTime();
        this.o = r14.getPressure(r4) + r14.getPressure(r5);
        this.p = r1.getPressure(r2) + r1.getPressure(r3);
        return;
    L13:
        this.q = true;
        new Throwable();
        if (this.b == false) goto L17;
        this.a.c(r13, this);
        return;
    }

    public static int a(MotionEvent r1, int r2, int r3) {
        int r0 = r1.getPointerCount();
        int r4 = r1.findPointerIndex(r2);
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L8;
        if (r5 == r3) goto L7;
        if (r5 == r4) goto L7;
        return r5;
    L7:
        r5 = r5 + 1;
        goto L3
    L8:
        return -1;
    }
}
