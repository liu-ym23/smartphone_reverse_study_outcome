package se;

import ge.p;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b<T> implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ae.f f12113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12114b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final re.a f12115m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final p<re.e<? super T>, ae.d<? super xd.j>, Object> f12116n;

    public b(ta.a r8, ae.f r10, int r11, re.a r12) {
        this.f12113a = r10;
        this.f12114b = r11;
        this.f12115m = r12;
        this.f12116n = r8;
    }

    public final String c() {
        ArrayList r8 = new ArrayList(4);
        ae.g r10 = ae.g.f354a;
        ae.f r11 = this.f12113a;
        if (r11 == r10) goto L5;
        r8.add("context=" + r11);
    L5:
        int r12 = this.f12114b;
        if (r12 == (-3)) goto L8;
        r8.add("capacity=" + r12);
    L8:
        re.a r13 = re.a.f11802a;
        re.a r14 = this.f12115m;
        if (r14 == r13) goto L12;
        r8.add("onBufferOverflow=" + r14);
    L12:
        return getClass().getSimpleName() + '[' + yd.i.j1(r8, ", ", null, 62) + ']';
    }

    public final String toString() {
        return "block[" + this.f12116n + "] -> " + c();
    }
}
