package k;

import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.model.content.ShapeTrimPath$Type;
import com.airbnb.lottie.w;
import com.airbnb.lottie.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f implements n, l.a, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f18501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f18503c;
    public final l.g d;
    public final l.d e;
    public final q.a f;
    public final ym.j g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f18504h;

    public f(w r5, r.c r10, q.a r11) {
        this.f18501a = new Path();
        this.g = new ym.j(9);
        this.f18502b = r11.f21391a;
        this.f18503c = r5;
        l.d r12 = r11.f21393c.d();
        this.d = (l.g) r12;
        l.d r13 = r11.f21392b.d();
        this.e = r13;
        this.f = r11;
        r10.f(r12);
        r10.f(r13);
        r12.a(this);
        r13.a(this);
    }

    @Override // l.a
    public final void a() {
        this.f18504h = false;
        this.f18503c.invalidateSelf();
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
        ((ArrayList) this.g.f23302a).add(r14);
        r14.c(this);
    L10:
        r11 = r11 + 1;
        goto L3
    }

    @Override // o.f
    public final void c(ColorFilter r5, v.c r10) {
        if (r5 != z.f1358c) goto L6;
        this.d.j(r10);
        return;
    L6:
        if (r5 != z.f) goto L10;
        this.e.j(r10);
        return;
    }

    @Override // o.f
    public final void d(o.e r5, int r10, ArrayList r11, o.e r12) {
        u.e.e(r5, r10, r11, r12, this);
    }

    @Override // k.c
    public final String getName() {
        return this.f18502b;
    }

    @Override // k.n
    public final Path getPath() {
        boolean r5 = this.f18504h;
        Path r10 = this.f18501a;
        if (r5 == false) goto L5;
        return r10;
    L5:
        r10.reset();
        q.a r11 = this.f;
        if (r11.e == false) goto L9;
        this.f18504h = true;
        return r10;
    L9:
        PointF r12 = (PointF) this.d.f();
        float r13 = r12.x / 2.0f;
        float r14 = r12.y / 2.0f;
        float r15 = r13 * 0.55228f;
        float r16 = r14 * 0.55228f;
        r10.reset();
        if (r11.d == false) goto L12;
        float r17 = -r14;
        r10.moveTo(0.0f, r17);
        float r18 = 0.0f - r15;
        float r19 = -r13;
        float r110 = 0.0f - r16;
        r10.cubicTo(r18, r17, r19, r110, r19, 0.0f);
        float r111 = r16 + 0.0f;
        r10.cubicTo(r19, r111, r18, r14, 0.0f, r14);
        float r112 = r15 + 0.0f;
        r10.cubicTo(r112, r14, r13, r111, r13, 0.0f);
        r10.cubicTo(r13, r110, r112, r17, 0.0f, r17);
    L13:
        PointF r20 = (PointF) this.e.f();
        r10.offset(r20.x, r20.y);
        r10.close();
        this.g.c(r10);
        this.f18504h = true;
        return r10;
    L12:
        float r21 = -r14;
        r10.moveTo(0.0f, r21);
        float r113 = r15 + 0.0f;
        float r114 = 0.0f - r16;
        r10.cubicTo(r113, r21, r13, r114, r13, 0.0f);
        float r115 = r16 + 0.0f;
        r10.cubicTo(r13, r115, r113, r14, 0.0f, r14);
        float r116 = 0.0f - r15;
        float r117 = -r13;
        r10.cubicTo(r116, r14, r117, r115, r117, 0.0f);
        r10.cubicTo(r117, r114, r116, r21, 0.0f, r21);
        goto L13
    }
}
