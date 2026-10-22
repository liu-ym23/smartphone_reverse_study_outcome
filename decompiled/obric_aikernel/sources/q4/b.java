package q4;

import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.a0;
import com.bytedance.retrofit2.d;
import com.bytedance.retrofit2.v;
import java.util.Iterator;
import java.util.List;
import n4.c;

/* JADX INFO: loaded from: classes.dex */
public class b implements a.InterfaceC0283a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f12472g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f12473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f12475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.retrofit2.b f12476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f12477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RetrofitMetrics f12478f;

    static {
    }

    public b(List<a> r10, int r11, c r12, com.bytedance.retrofit2.b r13, RetrofitMetrics r14) {
        this.f12473a = r10;
        this.f12474b = r11;
        this.f12475c = r12;
        this.f12476d = r13;
        this.f12478f = r14;
    }

    @Override // q4.a.InterfaceC0283a
    public c a() {
        return this.f12475c;
    }

    @Override // q4.a.InterfaceC0283a
    public RetrofitMetrics b() {
        return this.f12478f;
    }

    @Override // q4.a.InterfaceC0283a
    public a0 c(c r10) {
        if (this.f12474b >= this.f12473a.size()) goto L40;
        int r11 = this.f12477e + 1;
        this.f12477e = r11;
        if (r11 <= 1) goto L12;
        Iterator<a> r12 = this.f12473a.iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        a r13 = r12.next();
        if ((r13 instanceof d) == false) goto L8;
        ((d) r13).k();
    L12:
        b r14 = new b(this.f12473a, this.f12474b + 1, r10, this.f12476d, this.f12478f);
        a r15 = this.f12473a.get(this.f12474b);
        if (f12472g == true) goto L20;
        StringBuilder r16 = new StringBuilder();
        r16.append("interceptor = ");
        if (r15 == null) goto L17;
        String r17 = r15.toString();
    L18:
        r16.append(r17);
        r16.append(" url = ");
        r16.append(r10.G());
        v.a("RealInterceptorChain", r16.toString());
        goto L20
    L17:
        r17 = "";
    L20:
        if (r15 == null) goto L38;
        RetrofitMetrics r18 = this.f12478f;
        if (r18 == null) goto L24;
        r18.h();
        this.f12478f.i(r15);
    L24:
        a0 r19 = r15.a(r14);
        RetrofitMetrics r20 = this.f12478f;
        if (r20 == null) goto L29;
        r20.j();
        int r21 = this.f12474b;
        if (r21 <= 0) goto L29;
        this.f12478f.k(this.f12473a.get(r21 - 1));
    L29:
        if (r19 == null) goto L36;
        if (r19.h() == null) goto L34;
        return r19;
    L34:
        throw new IllegalStateException("interceptor " + r15 + " returned a ssResponse with no body");
    L36:
        throw new NullPointerException("interceptor " + r15 + " returned null");
    L38:
        throw new NullPointerException("interceptor " + this.f12474b + " is null");
    L40:
        throw new AssertionError();
    }
}
