package k19;

import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e implements b<d> {
    public final LinkedList<b<e>> a;
    public final d b;
    public final ArrayList<Integer> c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public int l;

    public static final class a {
    }

    static {
    }

    public e() {
        this.a = new LinkedList();
        d r0 = new d();
        this.b = r0;
        this.c = new ArrayList();
        this.d = 1.0f;
        this.k = 1.0f;
        r0.j = this;
    }

    public final boolean b(MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        d r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "event");
        int r0 = r9.getActionMasked();
        if (r0 == 0) goto L39;
        if (r0 != 1) goto L6;
        r1.b(r9);
        if (r1.a != 0) goto L36;
        r1.a();
    L43:
        return true;
    L36:
        b<d> r10 = r1.j;
        if (r10 == null) goto L43;
        r10.onGestureUpdate(r1);
        goto L43
    L6:
        if (r0 != 2) goto L8;
        r1.b = r1.a;
        int r2 = 0;
    L25:
        if (r2 >= 2) goto L30;
        int r4 = r9.findPointerIndex(r1.c[r2]);
        if (r4 == (-1)) goto L29;
        float[] r5 = r1.h;
        float[] r6 = r1.f;
        r5[r2] = r6[r2];
        r1.i[r2] = r1.g[r2];
        r6[r2] = r9.getX(r4);
        r1.g[r2] = r9.getY(r4);
    L29:
        r2 = r2 + 1;
        goto L25
    L30:
        b<d> r11 = r1.j;
        if (r11 == null) goto L43;
        r11.onGestureUpdate(r1);
        goto L43
    L8:
        if (r0 != 3) goto L10;
        r1.a();
        goto L43
    L10:
        if (r0 != 5) goto L12;
        r1.b(r9);
        b<d> r12 = r1.j;
        if (r12 == null) goto L43;
        r12.onGestureUpdate(r1);
        goto L43
    L12:
        if (r0 != 6) goto L43;
        r1.b(r9);
        if (r1.a != 0) goto L17;
        r1.a();
        goto L43
    L17:
        b<d> r13 = r1.j;
        if (r13 == null) goto L43;
        r13.onGestureUpdate(r1);
        goto L43
    L39:
        b<d> r3 = r1.j;
        if (r3 == null) goto L42;
        r3.onGestureBegin(r1);
    L42:
        r1.b(r9);
        goto L43
    }

    @Override // k19.b
    public final void onGestureBegin(d r2) {
        Intrinsics.checkNotNullParameter(r2, "detector");
        Iterator<T> r3 = this.a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((b) r3.next()).onGestureBegin(this);
        goto L4
    }

    @Override // k19.b
    public final void onGestureEnd(d r2) {
        Intrinsics.checkNotNullParameter(r2, "detector");
        Iterator<T> r3 = this.a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((b) r3.next()).onGestureEnd(this);
        goto L4
    L6:
        this.d = 1.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 1.0f;
        this.l = 0;
    }

    @Override // k19.b
    public final void onGestureUpdate(d r10) {
        d r11 = r10;
        Intrinsics.checkNotNullParameter(r11, "detector");
        boolean r1 = false;
        if (this.b.a != 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        float[] r2 = r11.d;
        float r3 = r2[1] - r2[0];
        float[] r4 = r11.e;
        float r5 = r4[1] - r4[0];
        float[] r6 = r11.f;
        float r7 = r6[1] - r6[0];
        float[] r8 = r11.g;
        float r9 = r8[1] - r8[0];
        float r12 = (float) Math.hypot(r3, r5);
        float r13 = (float) Math.hypot(r7, r9);
        float r14 = this.d;
        float r15 = r13 / r12;
        this.d = r15;
        this.k = r15 / r14;
        this.g = a(r11.f, r11.a);
        this.h = a(r11.g, r11.a);
    L9:
        float r16 = a(r11.f, r11.a) - a(r11.h, r11.a);
        this.i = r16;
        this.e += r16;
        float r17 = a(r11.g, r11.a) - a(r11.i, r11.a);
        this.j = r17;
        this.f += r17;
        if (this.b.a != 1) goto L12;
        r1 = true;
    L12:
        if (r1 == true) goto L14;
        this.l = -1;
    L38:
        Iterator<T> r18 = this.a.iterator();
    L40:
        if (r18.hasNext() == false) goto L42;
        ((b) r18.next()).onGestureUpdate(this);
        goto L40
    L42:
        return;
    L14:
        if (this.l != 0) goto L38;
        if ((Math.abs(this.e) - Math.abs(this.f)) < 0.0f) goto L28;
        if (this.e >= (-10.0f)) goto L23;
        if (this.c.contains(1) == true) goto L23;
        this.l = 1;
    L23:
        if (this.e <= 10.0f) goto L38;
        if (this.c.contains(3) == true) goto L38;
        this.l = 3;
        goto L38
    L28:
        if (this.f >= (-10.0f)) goto L33;
        if (this.c.contains(2) == true) goto L33;
        this.l = 2;
    L33:
        if (this.f <= 10.0f) goto L38;
        if (this.c.contains(4) == true) goto L38;
        this.l = 4;
        goto L38
    L8:
        this.d = 1.0f;
        this.k = 1.0f;
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public final float a(float[] r5, int r6) {
        int r1 = 0;
        float r2 = 0.0f;
    L3:
        if (r1 >= r6) goto L5;
        r2 = r2 + r5[r1];
        r1 = r1 + 1;
        goto L3
    L5:
        if (r6 > 0) goto L7;
        return 0.0f;
    L7:
        return r2 / r6;
    }
}
