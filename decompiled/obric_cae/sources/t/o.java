package t;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f12187f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<s.e> f12188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<a> f12191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12192e;

    public static class a {
        public a(s.e r8, p.d r10) {
            new WeakReference(r8);
            s.d r11 = r8.K;
            r10.getClass();
            p.d.o(r11);
            p.d.o(r8.L);
            p.d.o(r8.M);
            p.d.o(r8.N);
            p.d.o(r8.O);
        }
    }

    public o(int r8) {
        this.f12188a = new ArrayList();
        this.f12189b = -1;
        this.f12191d = null;
        this.f12192e = -1;
        int r10 = f12187f;
        f12187f = r10 + 1;
        this.f12189b = r10;
        this.f12190c = r8;
    }

    public final void a(ArrayList<o> r8) {
        int r10 = this.f12188a.size();
        if (this.f12192e == (-1)) goto L12;
        if (r10 <= 0) goto L12;
        int r11 = 0;
    L7:
        if (r11 >= r8.size()) goto L12;
        o r12 = r8.get(r11);
        if (this.f12192e != r12.f12189b) goto L11;
        c(this.f12190c, r12);
    L11:
        r11 = r11 + 1;
    L12:
        if (r10 != 0) goto L18;
        r8.remove(this);
        return;
    }

    public final int b(p.d r10, int r11) {
        ArrayList<s.e> r8 = this.f12188a;
        int r12 = 0;
        if (r8.size() != 0) goto L5;
        return 0;
    L5:
        s.f r13 = (s.f) r8.get(0).W;
        r10.u();
        r13.c(r10, false);
        int r14 = 0;
    L7:
        if (r14 >= r8.size()) goto L9;
        r8.get(r14).c(r10, false);
        r14 = r14 + 1;
        goto L7
    L9:
        if (r11 != 0) goto L14;
        if (r13.B0 <= 0) goto L14;
        s.b.a(r13, r10, r8, 0);
    L14:
        if (r11 == 1) goto L16;
    L31:
        r10.q();     // Catch: Exception -> L20
    L22:
        this.f12191d = new ArrayList();
    L24:
        if (r12 >= r8.size()) goto L26;
        this.f12191d.add(new a(r8.get(r12), r10));
        r12 = r12 + 1;
        goto L24
    L26:
        if (r11 != 0) goto L28;
        int r15 = p.d.o(r13.K);
        s.d r16 = r13.M;
    L29:
        int r17 = p.d.o(r16);
        r10.u();
        return r17 - r15;
    L28:
        r15 = p.d.o(r13.L);
        r16 = r13.N;
    L20:
        e = move-exception;
        System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        goto L22
    L16:
        if (r13.C0 <= 0) goto L31;
        s.b.a(r13, r10, r8, 1);
        goto L31
    }

    public final void c(int r8, o r10) {
        Iterator<s.e> r11 = this.f12188a.iterator();
    L3:
        boolean r12 = r11.hasNext();
        int r13 = r10.f12189b;
        if (r12 == false) goto L12;
        s.e r14 = r11.next();
        ArrayList<s.e> r15 = r10.f12188a;
        if (r15.contains(r14) == true) goto L9;
        r15.add(r14);
    L9:
        if (r8 == 0) goto L10;
        r14.f11882r0 = r13;
        goto L3
    L10:
        r14.f11880q0 = r13;
        goto L3
    L12:
        this.f12192e = r13;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        int r10 = this.f12190c;
        if (r10 != 0) goto L6;
        String r11 = "Horizontal";
    L12:
        r8.append(r11);
        r8.append(" [");
        String r12 = android.aimedia.a.h(r8, this.f12189b, "] <");
        Iterator<s.e> r13 = this.f12188a.iterator();
    L14:
        if (r13.hasNext() == false) goto L17;
        s.e r14 = r13.next();
        StringBuilder r15 = android.aimedia.a.k(r12, " ");
        r15.append(r14.f11868k0);
        r12 = r15.toString();
        goto L14
    L17:
        return defpackage.a.e(r12, " >");
    L6:
        if (r10 != 1) goto L9;
        r11 = "Vertical";
        goto L12
    L9:
        if (r10 != 2) goto L11;
        r11 = "Both";
        goto L12
    L11:
        r11 = "Unknown";
        goto L12
    }
}
