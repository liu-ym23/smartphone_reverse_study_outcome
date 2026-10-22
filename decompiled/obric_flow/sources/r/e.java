package r;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.w;
import com.airbnb.lottie.z;
import java.util.ArrayList;
import java.util.List;
import l.n;

/* JADX INFO: loaded from: classes.dex */
public final class e extends c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public l.d f21597v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f21598w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final RectF f21599x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RectF f21600y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Paint f21601z;

    public e(w r10, g r11, List r12, com.airbnb.lottie.h r13) {
        super(r10, r11);
        this.f21598w = new ArrayList();
        this.f21599x = new RectF();
        this.f21600y = new RectF();
        this.f21601z = new Paint();
        p.b r14 = r11.s;
        if (r14 == null) goto L5;
        l.d r15 = r14.d();
        this.f21597v = r15;
        f(r15);
        this.f21597v.a(this);
    L6:
        LongSparseArray r16 = new LongSparseArray(r13.f1264i.size());
        int r5 = r12.size() - 1;
        c r17 = null;
    L7:
        int r18 = 0;
        if (r5 < 0) goto L31;
        g r19 = (g) r12.get(r5);
        switch(b.f21578a[r19.e.ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L11:
        u.b.b("Unknown layer type " + r19.e);
        c r20 = null;
    L18:
        if (r20 == null) goto L29;
        r16.put(r20.f21589n.d, r20);
        if (r17 == null) goto L23;
        r17.f21591p = r20;
        r17 = null;
        goto L29
    L23:
        this.f21598w.add(0, r20);
        int r21 = d.f21596a[r19.f21621u.ordinal()];
        if (r21 != 1) goto L26;
    L28:
        r17 = r20;
        goto L29
    L26:
        if (r21 == 2) goto L28;
    L29:
        r5 = r5 - 1;
        goto L7
    L12:
        r20 = new l(r10, r19);
        goto L18
    L13:
        r20 = new h(r10, r19);
        goto L18
    L14:
        r20 = new f(r10, r19);
        goto L18
    L15:
        r20 = new j(r10, r19);
        goto L18
    L16:
        r20 = new e(r10, r19, (List) r13.f1262c.get(r19.g), r13);
        goto L18
    L17:
        r20 = new i(r10, r19);
    L31:
        if (r18 >= r16.size()) goto L39;
        c r22 = (c) r16.get(r16.keyAt(r18));
        if (r22 == null) goto L38;
        c r110 = (c) r16.get(r22.f21589n.f);
        if (r110 == null) goto L38;
        r22.f21592q = r110;
    L38:
        r18 = r18 + 1;
        goto L31
    L39:
        return;
    L5:
        this.f21597v = null;
        goto L6
    }

    @Override // r.c, o.f
    public final void c(ColorFilter r5, v.c r10) {
        super.c(r5, r10);
        if (r5 != z.f1373w) goto L6;
        n r11 = new n(r10, null);
        this.f21597v = r11;
        f(r11);
        return;
    }

    @Override // r.c, k.e
    public final void e(RectF r5, Matrix r10, boolean r11) {
        super.e(r5, r10, r11);
        ArrayList r12 = this.f21598w;
        int r13 = r12.size() - 1;
    L3:
        if (r13 < 0) goto L5;
        RectF r14 = this.f21599x;
        r14.set(0.0f, 0.0f, 0.0f, 0.0f);
        ((c) r12.get(r13)).e(r14, this.f21587l, true);
        r5.union(r14);
        r13 = r13 - 1;
        goto L3
    }

    @Override // r.c
    public final void j(Canvas r10, Matrix r11, int r12) {
        RectF r5 = this.f21600y;
        g r13 = this.f21589n;
        r5.set(0.0f, 0.0f, r13.f21616o, r13.f21617p);
        r11.mapRect(r5);
        boolean r14 = this.f21588m.f1350p;
        ArrayList r15 = this.f21598w;
        if (r14 == true) goto L5;
    L8:
        boolean r16 = false;
    L9:
        if (r16 == false) goto L11;
        Paint r17 = this.f21601z;
        r17.setAlpha(r12);
        u.f.e(r10, r5, r17);
    L12:
        if (r16 == false) goto L14;
        r12 = 255;
    L14:
        int r18 = r15.size() - 1;
    L15:
        if (r18 < 0) goto L23;
        if (r5.isEmpty() == true) goto L19;
        boolean r19 = r10.clipRect(r5);
    L20:
        if (r19 == false) goto L22;
        ((c) r15.get(r18)).g(r10, r11, r12);
    L22:
        r18 = r18 - 1;
        goto L15
    L19:
        r19 = true;
        goto L20
    L23:
        r10.restore();
        com.airbnb.lottie.c.a();
        return;
    L11:
        r10.save();
        goto L12
    L5:
        if (r15.size() <= 1) goto L8;
        if (r12 == 255) goto L8;
        r16 = true;
        goto L9
    }

    @Override // r.c
    public final void m(o.e r5, int r10, ArrayList r11, o.e r12) {
        int r13 = 0;
    L3:
        ArrayList r14 = this.f21598w;
        if (r13 >= r14.size()) goto L6;
        ((c) r14.get(r13)).d(r5, r10, r11, r12);
        r13 = r13 + 1;
        goto L3
    }

    @Override // r.c
    public final void n(float r5) {
        super.n(r5);
        l.d r10 = this.f21597v;
        g r11 = this.f21589n;
        if (r10 == null) goto L5;
        com.airbnb.lottie.h r12 = this.f21588m.f1340b;
        r5 = ((((Float) r10.f()).floatValue() * r11.f21607b.f1268m) - r11.f21607b.f1266k) / ((r12.f1267l - r12.f1266k) + 0.01f);
    L5:
        float r13 = r11.f21614m;
        if (r13 == 0.0f) goto L9;
        r5 = r5 / r13;
    L9:
        if (this.f21597v != null) goto L11;
        com.airbnb.lottie.h r14 = r11.f21607b;
        r5 = r5 - (r11.f21615n / (r14.f1267l - r14.f1266k));
    L11:
        ArrayList r15 = this.f21598w;
        int r16 = r15.size() - 1;
    L12:
        if (r16 < 0) goto L14;
        ((c) r15.get(r16)).n(r5);
        r16 = r16 - 1;
        goto L12
    }
}
