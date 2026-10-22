package k;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import com.airbnb.lottie.w;
import com.airbnb.lottie.z;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class t extends b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final r.c f18565o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f18566p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f18567q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final l.e f18568r;
    public l.n s;

    public t(w r12, r.c r13, q.o r14) {
        Paint.Cap r5 = r14.g.toPaintCap();
        Paint.Join r10 = r14.f21440h.toPaintJoin();
        ArrayList r11 = r14.f21439c;
        p.b r15 = r14.f21438b;
        super(r12, r13, r5, r10, r14.f21441i, r14.e, r14.f, r11, r15);
        this.f18565o = r13;
        this.f18566p = r14.f21437a;
        this.f18567q = r14.f21442j;
        l.d r16 = r14.d.d();
        this.f18568r = (l.e) r16;
        r16.a(this);
        r13.f(r16);
    }

    @Override // k.b, o.f
    public final void c(ColorFilter r5, v.c r10) {
        super.c(r5, r10);
        PointF r11 = z.f1356a;
        l.e r12 = this.f18568r;
        if (r5 != 2) goto L6;
        r12.j(r10);
        return;
    L6:
        if (r5 != z.f1375y) goto L10;
        l.n r13 = new l.n(r10, null);
        this.s = r13;
        r13.a(this);
        this.f18565o.f(r12);
        return;
    }

    @Override // k.b, k.e
    public final void g(Canvas r5, Matrix r10, int r11) {
        if (this.f18567q == false) goto L5;
        return;
    L5:
        l.e r12 = this.f18568r;
        int r13 = r12.k(r12.b(), r12.d());
        j.a r14 = this.f18488i;
        r14.setColor(r13);
        l.n r15 = this.s;
        if (r15 == null) goto L8;
        r14.setColorFilter((ColorFilter) r15.f());
    L8:
        super.g(r5, r10, r11);
    }

    @Override // k.c
    public final String getName() {
        return this.f18566p;
    }
}
