package k;

import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.model.content.ShapeTrimPath$Type;
import com.airbnb.lottie.w;
import com.airbnb.lottie.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class q implements l.a, k, n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f18550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f18551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18552c;
    public final boolean d;
    public final w e;
    public final l.d f;
    public final l.g g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l.f f18553h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ym.j f18554i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f18555j;

    public q(w r5, r.c r10, q.i r11) {
        this.f18550a = new Path();
        this.f18551b = new RectF();
        this.f18554i = new ym.j(9);
        this.f18552c = (String) r11.f21421b;
        this.d = r11.d;
        this.e = r5;
        l.d r12 = r11.e.d();
        this.f = r12;
        l.d r13 = ((p.a) r11.f).d();
        this.g = (l.g) r13;
        l.d r14 = r11.f21422c.d();
        this.f18553h = (l.f) r14;
        r10.f(r12);
        r10.f(r13);
        r10.f(r14);
        r12.a(this);
        r13.a(this);
        r14.a(this);
    }

    @Override // l.a
    public final void a() {
        this.f18555j = false;
        this.e.invalidateSelf();
    }

    @Override // k.c
    public final void b(List r5, List r10) {
        int r11 = 0;
    L3:
        ArrayList r12 = (ArrayList) r5;
        if (r11 >= r12.size()) goto L11;
        c r13 = (c) r12.get(r11);
        if ((r13 instanceof u) == false) goto L10;
        u r14 = (u) r13;
        if (r14.f18571c != ShapeTrimPath$Type.SIMULTANEOUSLY) goto L10;
        ((ArrayList) this.f18554i.f23302a).add(r14);
        r14.c(this);
    L10:
        r11 = r11 + 1;
        goto L3
    }

    @Override // o.f
    public final void c(ColorFilter r5, v.c r10) {
        if (r5 != z.d) goto L6;
        this.g.j(r10);
        return;
    L6:
        if (r5 != z.f) goto L9;
        this.f.j(r10);
        return;
    L9:
        if (r5 != z.e) goto L14;
        this.f18553h.j(r10);
        return;
    }

    @Override // o.f
    public final void d(o.e r5, int r10, ArrayList r11, o.e r12) {
        u.e.e(r5, r10, r11, r12, this);
    }

    @Override // k.c
    public final String getName() {
        return this.f18552c;
    }

    @Override // k.n
    public final Path getPath() {
        boolean r5 = this.f18555j;
        Path r10 = this.f18550a;
        if (r5 == false) goto L5;
        return r10;
    L5:
        r10.reset();
        if (this.d == false) goto L9;
        this.f18555j = true;
        return r10;
    L9:
        PointF r11 = (PointF) this.g.f();
        float r12 = r11.x / 2.0f;
        float r13 = r11.y / 2.0f;
        l.f r14 = this.f18553h;
        if (r14 != null) goto L12;
        float r15 = 0.0f;
    L13:
        float r16 = Math.min(r12, r13);
        if (r15 <= r16) goto L16;
        r15 = r16;
    L16:
        PointF r17 = (PointF) this.f.f();
        r10.moveTo(r17.x + r12, (r17.y - r13) + r15);
        r10.lineTo(r17.x + r12, (r17.y + r13) - r15);
        RectF r18 = this.f18551b;
        if (r15 <= 0.0f) goto L19;
        float r19 = r17.x + r12;
        float r110 = r15 * 2.0f;
        float r20 = r17.y + r13;
        r18.set(r19 - r110, r20 - r110, r19, r20);
        r10.arcTo(r18, 0.0f, 90.0f, false);
    L19:
        r10.lineTo((r17.x - r12) + r15, r17.y + r13);
        if (r15 <= 0.0f) goto L22;
        float r21 = r17.x - r12;
        float r22 = r17.y + r13;
        float r111 = r15 * 2.0f;
        r18.set(r21, r22 - r111, r111 + r21, r22);
        r10.arcTo(r18, 90.0f, 90.0f, false);
    L22:
        r10.lineTo(r17.x - r12, (r17.y - r13) + r15);
        if (r15 <= 0.0f) goto L25;
        float r23 = r17.x - r12;
        float r24 = r17.y - r13;
        float r112 = r15 * 2.0f;
        r18.set(r23, r24, r23 + r112, r112 + r24);
        r10.arcTo(r18, 180.0f, 90.0f, false);
    L25:
        r10.lineTo((r17.x + r12) - r15, r17.y - r13);
        if (r15 <= 0.0f) goto L28;
        float r25 = r17.x + r12;
        float r26 = r15 * 2.0f;
        float r27 = r17.y - r13;
        r18.set(r25 - r26, r27, r25, r26 + r27);
        r10.arcTo(r18, 270.0f, 90.0f, false);
    L28:
        r10.close();
        this.f18554i.c(r10);
        this.f18555j = true;
        return r10;
    L12:
        r15 = r14.k();
        goto L13
    }
}
