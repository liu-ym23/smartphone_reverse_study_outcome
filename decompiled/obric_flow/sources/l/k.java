package l;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class k extends d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q.j f19495i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f19496j;

    public k(ArrayList r5) {
        super(r5);
        this.f19495i = new q.j();
        this.f19496j = new Path();
    }

    @Override // l.d
    public final Object g(v.a r19, float r20) {
        q.j r5 = (q.j) r19.f22471b;
        q.j r10 = (q.j) r19.f22472c;
        q.j r11 = this.f19495i;
        if (r11.f21424b != null) goto L5;
        r11.f21424b = new PointF();
    L5:
        int r12 = 0;
        if (r5.f21425c == false) goto L8;
    L11:
        boolean r13 = true;
    L12:
        r11.f21425c = r13;
        ArrayList r14 = r5.f21423a;
        int r15 = r14.size();
        int r16 = r10.f21423a.size();
        ArrayList r17 = r10.f21423a;
        if (r15 == r16) goto L15;
        u.b.b("Curves must have the same number of control points. Shape 1: " + r14.size() + "\tShape 2: " + r17.size());
    L15:
        int r18 = Math.min(r14.size(), r17.size());
        ArrayList r21 = r11.f21423a;
        if (r21.size() >= r18) goto L21;
        int r110 = r21.size();
    L18:
        if (r110 >= r18) goto L25;
        r21.add(new o.a());
        r110 = r110 + 1;
    L25:
        PointF r22 = r5.f21424b;
        PointF r23 = r10.f21424b;
        float r24 = u.e.d(r22.x, r23.x, r20);
        float r25 = u.e.d(r22.y, r23.y, r20);
        if (r11.f21424b != null) goto L28;
        r11.f21424b = new PointF();
    L28:
        r11.f21424b.set(r24, r25);
        int r26 = r21.size() - 1;
    L29:
        if (r26 < 0) goto L31;
        o.a r27 = (o.a) r14.get(r26);
        o.a r28 = (o.a) r17.get(r26);
        PointF r29 = r27.f20358a;
        PointF r111 = r28.f20358a;
        o.a r112 = (o.a) r21.get(r26);
        r112.f20358a.set(u.e.d(r29.x, r111.x, r20), u.e.d(r29.y, r111.y, r20));
        o.a r30 = (o.a) r21.get(r26);
        PointF r113 = r27.f20359b;
        float r114 = r113.x;
        PointF r115 = r28.f20359b;
        r30.f20359b.set(u.e.d(r114, r115.x, r20), u.e.d(r113.y, r115.y, r20));
        o.a r31 = (o.a) r21.get(r26);
        PointF r32 = r27.f20360c;
        float r116 = r32.x;
        PointF r33 = r28.f20360c;
        r31.f20360c.set(u.e.d(r116, r33.x, r20), u.e.d(r32.y, r33.y, r20));
        r26 = r26 - 1;
        goto L29
    L31:
        Path r34 = this.f19496j;
        r34.reset();
        PointF r35 = r11.f21424b;
        r34.moveTo(r35.x, r35.y);
        PointF r36 = u.e.f22190a;
        r36.set(r35.x, r35.y);
    L33:
        if (r12 >= r21.size()) goto L42;
        o.a r37 = (o.a) r21.get(r12);
        PointF r38 = r37.f20358a;
        boolean r39 = r38.equals(r36);
        PointF r40 = r37.f20359b;
        PointF r41 = r37.f20360c;
        if (r39 == true) goto L37;
    L39:
        r34.cubicTo(r38.x, r38.y, r40.x, r40.y, r41.x, r41.y);
    L40:
        r36.set(r41.x, r41.y);
        r12 = r12 + 1;
        goto L33
    L37:
        if (r40.equals(r41) == false) goto L39;
        r34.lineTo(r41.x, r41.y);
        goto L40
    L42:
        if (r11.f21425c == false) goto L44;
        r34.close();
    L44:
        return r34;
    L21:
        if (r21.size() <= r18) goto L25;
        int r117 = r21.size() - 1;
    L23:
        if (r117 < r18) goto L25;
        r21.remove(r21.size() - 1);
        r117 = r117 - 1;
        goto L23
    L8:
        if (r10.f21425c == true) goto L11;
        r13 = false;
        goto L12
    }
}
