package t;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<s.e> f12136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f12137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s.f f12138c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public s.e.a f12139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public s.e.a f12140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12142d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12143e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12144f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f12145g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f12146h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f12147i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f12148j;
    }

    /* JADX INFO: renamed from: t.b$b, reason: collision with other inner class name */
    public interface InterfaceC0157b {
    }

    public b(s.f r8) {
        this.f12136a = new ArrayList();
        this.f12137b = new a();
        this.f12138c = r8;
    }

    public final boolean a(int r8, s.e r10, InterfaceC0157b r11) {
        s.e.a[] r12 = r10.V;
        s.e.a r13 = r12[0];
        a r14 = this.f12137b;
        r14.f12139a = r13;
        boolean r15 = true;
        r14.f12140b = r12[1];
        r14.f12141c = r10.q();
        r14.f12142d = r10.l();
        r14.f12147i = false;
        r14.f12148j = r8;
        s.e.a r16 = r14.f12139a;
        s.e.a r17 = s.e.a.f11893m;
        if (r16 != r17) goto L5;
        boolean r18 = true;
    L7:
        if (r14.f12140b != r17) goto L9;
        boolean r19 = true;
    L11:
        if (r18 == true) goto L13;
    L15:
        boolean r20 = false;
    L16:
        if (r19 == true) goto L18;
    L20:
        boolean r21 = false;
    L21:
        int[] r22 = r10.f11885u;
        if (r20 == true) goto L24;
    L26:
        if (r21 == true) goto L28;
    L30:
        ((ConstraintLayout.b) r11).b(r10, r14);
        r10.N(r14.f12143e);
        r10.K(r14.f12144f);
        r10.F = r14.f12146h;
        int r23 = r14.f12145g;
        r10.d0 = r23;
        if (r23 > 0) goto L34;
        r15 = false;
    L34:
        r10.F = r15;
        r14.f12148j = 0;
        return r14.f12147i;
    L28:
        if (r22[1] != 4) goto L30;
        r14.f12140b = s.e.a.f11891a;
        goto L30
    L24:
        if (r22[0] != 4) goto L26;
        r14.f12139a = s.e.a.f11891a;
        goto L26
    L18:
        if (r10.Z <= 0.0f) goto L20;
        r21 = true;
        goto L21
    L13:
        if (r10.Z <= 0.0f) goto L15;
        r20 = true;
        goto L16
    L9:
        r19 = false;
        goto L11
    L5:
        r18 = false;
        goto L7
    }

    public final void b(s.f r8, int r10, int r11, int r12) {
        int r13 = r8.f11856e0;
        int r14 = r8.f11858f0;
        r8.f11856e0 = 0;
        r8.f11858f0 = 0;
        r8.N(r11);
        r8.K(r12);
        if (r13 >= 0) goto L5;
        r13 = 0;
    L5:
        r8.f11856e0 = r13;
        if (r14 >= 0) goto L8;
        r14 = 0;
    L8:
        r8.f11858f0 = r14;
        s.f r15 = this.f12138c;
        r15.f11898v0 = r10;
        r15.Q();
    }

    public final void c(s.f r10) {
        ArrayList<s.e> r8 = this.f12136a;
        r8.clear();
        int r11 = r10.f11940s0.size();
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L11;
        s.e r13 = r10.f11940s0.get(r12);
        s.e.a[] r14 = r13.V;
        s.e.a r15 = r14[0];
        s.e.a r16 = s.e.a.f11893m;
        if (r15 != r16) goto L8;
    L9:
        r8.add(r13);
    L10:
        r12 = r12 + 1;
        goto L4
    L8:
        if (r14[1] != r16) goto L10;
    L11:
        r10.f11897u0.f12152b = true;
    }
}
