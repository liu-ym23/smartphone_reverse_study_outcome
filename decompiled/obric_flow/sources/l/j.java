package l;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class j extends h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PointF f19491i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f19492j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public i f19493k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PathMeasure f19494l;

    public j(ArrayList r5) {
        super(r5);
        this.f19491i = new PointF();
        this.f19492j = new float[2];
        this.f19494l = new PathMeasure();
    }

    @Override // l.d
    public final Object g(v.a r5, float r10) {
        i r11 = (i) r5;
        Path r12 = r11.f19489o;
        if (r12 == null) goto L13;
        v.c r13 = this.e;
        if (r13 == null) goto L8;
        r11.f.getClass();
        Object r14 = r11.f22472c;
        e();
        return (PointF) r13.a(r11.f22471b, r14);
    L8:
        i r15 = this.f19493k;
        PathMeasure r16 = this.f19494l;
        if (r15 == r11) goto L11;
        r16.setPath(r12, false);
        this.f19493k = r11;
    L11:
        float r17 = r16.getLength() * r10;
        float[] r18 = this.f19492j;
        r16.getPosTan(r17, r18, null);
        PointF r19 = this.f19491i;
        r19.set(r18[0], r18[1]);
        return r19;
    L13:
        return (PointF) r5.f22471b;
    }
}
