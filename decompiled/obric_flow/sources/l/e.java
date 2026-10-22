package l;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e extends h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f19486i;

    public /* synthetic */ e(List r5, int r10) {
        this.f19486i = r10;
        super(r5);
    }

    @Override // l.d
    public final Object g(v.a r5, float r10) {
        switch(this.f19486i) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return (o.b) r5.f22471b;
    L7:
        return Integer.valueOf(k(r5, r10));
    L9:
        return Integer.valueOf(k(r5, r10));
    }

    public int k(v.a r10, float r11) {
        switch(this.f19486i) {
            case 0: goto L21;
            default: goto L4;
        };
    L4:
        Object r5 = r10.f22471b;
        if (r5 == null) goto L20;
        if (r10.f22472c == null) goto L20;
        v.c r12 = this.e;
        if (r12 == null) goto L12;
        r10.f.getClass();
        Object r13 = r10.f22472c;
        e();
        return ((Integer) r12.a(r10.f22471b, r13)).intValue();
    L12:
        if (r10.f22474i != 784923401) goto L14;
        r10.f22474i = ((Integer) r5).intValue();
    L14:
        int r14 = r10.f22474i;
        if (r10.f22475j != 784923401) goto L17;
        r10.f22475j = ((Integer) r10.f22472c).intValue();
    L17:
        int r15 = r10.f22475j;
        PointF r16 = u.e.f22190a;
        return (int) ((r11 * (r15 - r14)) + r14);
    L20:
        throw new IllegalStateException("Missing values for keyframe.");
    L21:
        Object r17 = r10.f22471b;
        if (r17 == null) goto L31;
        if (r10.f22472c == null) goto L31;
        Integer r18 = (Integer) r17;
        int r19 = r18.intValue();
        Integer r20 = (Integer) r10.f22472c;
        int r21 = r20.intValue();
        v.c r22 = this.e;
        if (r22 == null) goto L29;
        r10.f.getClass();
        e();
        return ((Integer) r22.a(r18, r20)).intValue();
    L29:
        return wn.h.j(u.e.b(r11, 0.0f, 1.0f), r19, r21);
    L31:
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
