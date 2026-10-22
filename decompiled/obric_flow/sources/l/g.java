package l;

import ai.j0;
import android.graphics.PointF;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class g extends h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f19487i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f19488j;

    public g(ArrayList r5, int r10) {
        this.f19487i = r10;
        switch(r10) {
            case 1: goto L12;
            case 2: goto L10;
            default: goto L4;
        };
    L4:
        super(r5);
        int r11 = 0;
        q.c r12 = (q.c) ((v.a) r5.get(0)).f22471b;
        if (r12 == null) goto L8;
        r11 = r12.f21395b.length;
    L8:
        this.f19488j = new q.c(new float[r11], new int[r11]);
        return;
    L10:
        super(r5);
        this.f19488j = new v.d();
        return;
    L12:
        super(r5);
        this.f19488j = new PointF();
    }

    @Override // l.d
    public final Object g(v.a r10, float r11) {
        switch(this.f19487i) {
            case 0: goto L26;
            case 1: goto L15;
            default: goto L4;
        };
    L4:
        Object r5 = r10.f22471b;
        if (r5 == null) goto L14;
        Object r12 = r10.f22472c;
        if (r12 == null) goto L14;
        v.d r13 = (v.d) r5;
        v.d r14 = (v.d) r12;
        v.c r15 = this.e;
        if (r15 == null) goto L11;
        r10.f.getClass();
        e();
        return (v.d) r15.a(r13, r14);
    L11:
        float r16 = u.e.d(r13.f22484a, r14.f22484a, r11);
        float r17 = u.e.d(r13.f22485b, r14.f22485b, r11);
        v.d r18 = (v.d) this.f19488j;
        r18.f22484a = r16;
        r18.f22485b = r17;
        return r18;
    L14:
        throw new IllegalStateException("Missing values for keyframe.");
    L15:
        Object r19 = r10.f22471b;
        if (r19 == null) goto L25;
        Object r20 = r10.f22472c;
        if (r20 == null) goto L25;
        PointF r21 = (PointF) r19;
        PointF r22 = (PointF) r20;
        v.c r23 = this.e;
        if (r23 == null) goto L22;
        r10.f.getClass();
        e();
        return (PointF) r23.a(r21, r22);
    L22:
        PointF r24 = (PointF) this.f19488j;
        float r25 = r21.x;
        float r26 = j0.b(r22.x, r25, r11, r25);
        float r27 = r21.y;
        r24.set(r26, j0.b(r22.y, r27, r11, r27));
        return r24;
    L25:
        throw new IllegalStateException("Missing values for keyframe.");
    L26:
        q.c r28 = (q.c) r10.f22471b;
        q.c r29 = (q.c) r10.f22472c;
        q.c r30 = (q.c) this.f19488j;
        r30.getClass();
        int[] r31 = r28.f21395b;
        int r32 = r31.length;
        int[] r33 = r29.f21395b;
        if (r32 != r33.length) goto L33;
        int r34 = 0;
    L30:
        if (r34 >= r31.length) goto L32;
        float r35 = u.e.d(r28.f21394a[r34], r29.f21394a[r34], r11);
        r30.f21394a[r34] = r35;
        int r36 = wn.h.j(r11, r31[r34], r33[r34]);
        r30.f21395b[r34] = r36;
        r34 = r34 + 1;
        goto L30
    L32:
        return r30;
    L33:
        StringBuilder r37 = new StringBuilder("Cannot interpolate between gradients. Lengths vary (");
        r37.append(r31.length);
        r37.append(" vs ");
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.s(r37, r33.length, ")"));
    }
}
