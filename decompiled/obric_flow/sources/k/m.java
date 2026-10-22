package k;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public final class m implements n, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f18536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f18537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f18538c;
    public final ArrayList d;
    public final q.g e;

    public m(q.g r5) {
        this.f18536a = new Path();
        this.f18537b = new Path();
        this.f18538c = new Path();
        this.d = new ArrayList();
        r5.getClass();
        this.e = r5;
    }

    public final void a(Path.Op r11) {
        Path r5 = this.f18537b;
        r5.reset();
        Path r10 = this.f18536a;
        r10.reset();
        ArrayList r12 = this.d;
        int r13 = r12.size() - 1;
    L3:
        if (r13 < 1) goto L15;
        n r14 = (n) r12.get(r13);
        if ((r14 instanceof d) == false) goto L13;
        d r15 = (d) r14;
        ArrayList r16 = (ArrayList) r15.f();
        int r17 = r16.size() - 1;
    L7:
        if (r17 < 0) goto L14;
        Path r18 = ((n) r16.get(r17)).getPath();
        l.m r19 = r15.f18500k;
        if (r19 == null) goto L11;
        Matrix r20 = r19.e();
    L12:
        r18.transform(r20);
        r5.addPath(r18);
        r17 = r17 - 1;
        goto L7
    L11:
        r20 = r15.f18496c;
        r20.reset();
    L14:
        r13 = r13 - 1;
        goto L3
    L13:
        r5.addPath(r14.getPath());
        goto L14
    L15:
        int r21 = 0;
        n r22 = (n) r12.get(0);
        if ((r22 instanceof d) == false) goto L25;
        d r23 = (d) r22;
        List r24 = r23.f();
    L18:
        ArrayList r25 = (ArrayList) r24;
        if (r21 >= r25.size()) goto L26;
        Path r26 = ((n) r25.get(r21)).getPath();
        l.m r27 = r23.f18500k;
        if (r27 == null) goto L23;
        Matrix r28 = r27.e();
    L24:
        r26.transform(r28);
        r10.addPath(r26);
        r21 = r21 + 1;
        goto L18
    L23:
        r28 = r23.f18496c;
        r28.reset();
    L26:
        this.f18538c.op(r10, r5, r11);
        return;
    L25:
        r10.set(r22.getPath());
        goto L26
    }

    @Override // k.c
    public final void b(List r5, List r10) {
        int r11 = 0;
    L3:
        ArrayList r12 = this.d;
        if (r11 >= r12.size()) goto L6;
        ((n) r12.get(r11)).b(r5, r10);
        r11 = r11 + 1;
        goto L3
    }

    @Override // k.j
    public final void f(ListIterator r5) {
    L3:
        if (r5.hasPrevious() == false) goto L8;
        if (r5.previous() != this) goto L3;
    L8:
        if (r5.hasPrevious() == false) goto L12;
        c r10 = (c) r5.previous();
        if ((r10 instanceof n) == false) goto L8;
        this.d.add((n) r10);
        r5.remove();
        goto L8
    }

    @Override // k.n
    public final Path getPath() {
        Path r5 = this.f18538c;
        r5.reset();
        q.g r10 = this.e;
        if (r10.f21413b == false) goto L5;
        return r5;
    L5:
        int r11 = l.f18535a[r10.f21412a.ordinal()];
        if (r11 != 1) goto L8;
        int r12 = 0;
    L21:
        ArrayList r13 = this.d;
        if (r12 >= r13.size()) goto L24;
        r5.addPath(((n) r13.get(r12)).getPath());
        r12 = r12 + 1;
    L24:
        return r5;
    L8:
        if (r11 != 2) goto L10;
        a(Path.Op.UNION);
        goto L24
    L10:
        if (r11 != 3) goto L12;
        a(Path.Op.REVERSE_DIFFERENCE);
        goto L24
    L12:
        if (r11 != 4) goto L14;
        a(Path.Op.INTERSECT);
        goto L24
    L14:
        if (r11 != 5) goto L24;
        a(Path.Op.XOR);
        goto L24
    }
}
