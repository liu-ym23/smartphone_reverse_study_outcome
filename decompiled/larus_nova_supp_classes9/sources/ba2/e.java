package ba2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
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

    @Override // ba2.b
    public final void onGestureBegin(d r2) {
        Intrinsics.checkNotNullParameter(r2, "detector");
        Iterator<T> r3 = this.a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((b) r3.next()).onGestureBegin(this);
        goto L4
    }

    @Override // ba2.b
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

    @Override // ba2.b
    public final void onGestureUpdate(d r10) {
        d r11 = r10;
        Intrinsics.checkNotNullParameter(r11, "detector");
        if (this.b.a != 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        float[] r1 = r11.d;
        float r3 = r1[1] - r1[0];
        float[] r2 = r11.e;
        float r4 = r2[1] - r2[0];
        float[] r5 = r11.f;
        float r6 = r5[1] - r5[0];
        float[] r7 = r11.g;
        float r8 = r7[1] - r7[0];
        float r9 = (float) Math.hypot(r3, r4);
        float r13 = (float) Math.hypot(r6, r8);
        float r14 = this.d;
        float r15 = r13 / r9;
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
        boolean r18 = true;
    L13:
        if (r18 == true) goto L15;
        this.l = -1;
    L39:
        Iterator<T> r19 = this.a.iterator();
    L41:
        if (r19.hasNext() == false) goto L43;
        ((b) r19.next()).onGestureUpdate(this);
        goto L41
    L43:
        return;
    L15:
        if (this.l != 0) goto L39;
        if ((Math.abs(this.e) - Math.abs(this.f)) < 0) goto L29;
        if (this.e >= (-10)) goto L24;
        if (this.c.contains(1) == true) goto L24;
        this.l = 1;
    L24:
        if (this.e <= 10) goto L39;
        if (this.c.contains(3) == true) goto L39;
        this.l = 3;
        goto L39
    L29:
        if (this.f >= (-10)) goto L34;
        if (this.c.contains(2) == true) goto L34;
        this.l = 2;
    L34:
        if (this.f <= 10) goto L39;
        if (this.c.contains(4) == true) goto L39;
        this.l = 4;
        goto L39
    L12:
        r18 = false;
        goto L13
    L8:
        this.d = 1.0f;
        this.k = 1.0f;
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public static float a(float[] r4, int r5) {
        int r1 = 0;
        float r2 = 0.0f;
    L3:
        if (r1 >= r5) goto L5;
        r2 = r2 + r4[r1];
        r1 = r1 + 1;
        goto L3
    L5:
        if (r5 > 0) goto L7;
        return 0.0f;
    L7:
        return r2 / r5;
    }
}
