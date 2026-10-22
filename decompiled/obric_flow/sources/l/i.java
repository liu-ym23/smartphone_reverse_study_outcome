package l;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public final class i extends v.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Path f19489o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final v.a f19490p;

    public i(com.airbnb.lottie.h r10, v.a r11) {
        super(r10, r11.f22471b, r11.f22472c, r11.d, r11.e, r11.f);
        this.f19490p = r11;
        d();
    }

    public final void d() {
        Object r5 = this.f22472c;
        Object r10 = this.f22471b;
        if (r5 == null) goto L8;
        if (r10 == null) goto L8;
        if (((PointF) r10).equals(((PointF) r5).x, ((PointF) r5).y) == false) goto L8;
        boolean r11 = true;
    L9:
        Object r12 = this.f22472c;
        if (r12 == null) goto L23;
        if (r11 == true) goto L24;
        PointF r13 = (PointF) r10;
        PointF r14 = (PointF) r12;
        v.a r15 = this.f19490p;
        PointF r16 = r15.f22478m;
        PointF r17 = r15.f22479n;
        PathMeasure r18 = u.f.f22191a;
        Path r19 = new Path();
        r19.moveTo(r13.x, r13.y);
        if (r16 == null) goto L20;
        if (r17 == null) goto L20;
        if (r16.length() == 0.0f) goto L18;
    L19:
        float r20 = r13.x;
        float r21 = r16.x + r20;
        float r22 = r13.y + r16.y;
        float r110 = r14.x;
        float r23 = r110 + r17.x;
        float r111 = r14.y;
        r19.cubicTo(r21, r22, r23, r111 + r17.y, r110, r111);
    L21:
        this.f19489o = r19;
        return;
    L18:
        if (r17.length() != 0.0f) goto L19;
    L20:
        r19.lineTo(r14.x, r14.y);
        goto L21
    L24:
        return;
    L23:
        return;
    L8:
        r11 = false;
        goto L9
    }
}
