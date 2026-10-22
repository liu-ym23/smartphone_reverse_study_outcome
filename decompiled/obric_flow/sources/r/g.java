package r;

import ai.j0;
import com.airbnb.lottie.model.layer.Layer$LayerType;
import com.airbnb.lottie.model.layer.Layer$MatteType;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f21606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.airbnb.lottie.h f21607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f21608c;
    public final long d;
    public final Layer$LayerType e;
    public final long f;
    public final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f21609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p.d f21610i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f21611j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f21612k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f21613l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f21614m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f21615n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f21616o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f21617p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final p.a f21618q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ja.d f21619r;
    public final p.b s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List f21620t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Layer$MatteType f21621u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f21622v;

    public g(List r5, com.airbnb.lottie.h r10, String r11, long r12, Layer$LayerType r13, long r14, String r15, List r16, p.d r17, int r18, int r19, int r110, float r111, float r112, int r20, int r21, p.a r22, ja.d r23, List r24, Layer$MatteType r25, p.b r26, boolean r27) {
        this.f21606a = r5;
        this.f21607b = r10;
        this.f21608c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f21609h = r16;
        this.f21610i = r17;
        this.f21611j = r18;
        this.f21612k = r19;
        this.f21613l = r110;
        this.f21614m = r111;
        this.f21615n = r112;
        this.f21616o = r20;
        this.f21617p = r21;
        this.f21618q = r22;
        this.f21619r = r23;
        this.f21620t = r24;
        this.f21621u = r25;
        this.s = r26;
        this.f21622v = r27;
    }

    public final String a(String r10) {
        StringBuilder r5 = j0.u(r10);
        r5.append(this.f21608c);
        r5.append("\n");
        com.airbnb.lottie.h r11 = this.f21607b;
        g r12 = (g) r11.f1263h.get(this.f);
        if (r12 == null) goto L8;
        r5.append("\t\tParents: ");
        r5.append(r12.f21608c);
        g r13 = (g) r11.f1263h.get(r12.f);
    L5:
        if (r13 == null) goto L7;
        r5.append("->");
        r5.append(r13.f21608c);
        r13 = (g) r11.f1263h.get(r13.f);
        goto L5
    L7:
        r5.append(r10);
        r5.append("\n");
    L8:
        List r14 = this.f21609h;
        if (r14.isEmpty() == true) goto L11;
        r5.append(r10);
        r5.append("\tMasks: ");
        r5.append(r14.size());
        r5.append("\n");
    L11:
        int r15 = this.f21611j;
        if (r15 == 0) goto L16;
        int r16 = this.f21612k;
        if (r16 == 0) goto L16;
        r5.append(r10);
        r5.append("\tBackground: ");
        r5.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(r15), Integer.valueOf(r16), Integer.valueOf(this.f21613l)}));
    L16:
        List r17 = this.f21606a;
        if (r17.isEmpty() == true) goto L23;
        r5.append(r10);
        r5.append("\tShapes:\n");
        Iterator r18 = r17.iterator();
    L20:
        if (r18.hasNext() == false) goto L23;
        Object r19 = r18.next();
        r5.append(r10);
        r5.append("\t\t");
        r5.append(r19);
        r5.append("\n");
    L23:
        return r5.toString();
    }

    public final String toString() {
        return a("");
    }
}
