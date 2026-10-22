package n4a;

import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k3 {
    public int a;
    public int b;
    public int c;
    public int d;
    public long e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public final int l;
    public final boolean m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public int r;
    public long s;

    public k3(int r5, boolean r6) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = -113;
        this.l = 0;
        this.m = false;
        this.n = 32767;
        this.o = Integer.MAX_VALUE;
        this.p = Integer.MAX_VALUE;
        this.q = true;
        this.r = 99;
        this.s = 0;
        this.l = r5;
        this.m = r6;
    }

    public final String b() {
        String r0 = a();
        if (r0 != null) goto L5;
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        if (r0.length() > 0) goto L7;
        return NameKeys.UnloadStrategy_No_Strategy;
    L7:
        return (this.q ? 1 : 0) + "#" + r0;
    }

    public final k3 c() {
        k3 r0 = new k3(this.l, this.m);
        r0.a = this.a;
        r0.b = this.b;
        r0.c = this.c;
        r0.d = this.d;
        r0.e = this.e;
        r0.f = this.f;
        r0.g = this.g;
        r0.h = this.h;
        r0.i = this.i;
        r0.j = this.j;
        r0.k = this.k;
        r0.n = this.n;
        r0.o = this.o;
        r0.p = this.p;
        r0.q = this.q;
        r0.r = this.r;
        r0.s = this.s;
        return r0;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return c();
    }

    public final boolean equals(Object r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if ((r8 instanceof k3) == false) goto L72;
        k3 r9 = (k3) r8;
        int r1 = r9.l;
        if (r1 == 1) goto L63;
        if (r1 == 2) goto L52;
        if (r1 == 3) goto L41;
        if (r1 == 4) goto L30;
        if (r1 == 5) goto L19;
        return false;
    L19:
        if (this.l == 5) goto L22;
        return false;
    L22:
        if (r9.c == this.c) goto L24;
    L28:
        return false;
    L24:
        if (r9.e != this.e) goto L28;
        if (r9.p != this.p) goto L28;
        return true;
    L30:
        if (this.l == 4) goto L33;
        return false;
    L33:
        if (r9.c == this.c) goto L35;
    L39:
        return false;
    L35:
        if (r9.d != this.d) goto L39;
        if (r9.b != this.b) goto L39;
        return true;
    L41:
        if (this.l == 3) goto L44;
        return false;
    L44:
        if (r9.c == this.c) goto L46;
    L50:
        return false;
    L46:
        if (r9.d != this.d) goto L50;
        if (r9.b != this.b) goto L50;
        return true;
    L52:
        if (this.l == 2) goto L55;
        return false;
    L55:
        if (r9.j == this.j) goto L57;
    L61:
        return false;
    L57:
        if (r9.i != this.i) goto L61;
        if (r9.h != this.h) goto L61;
        return true;
    L63:
        if (this.l == 1) goto L66;
        return false;
    L66:
        if (r9.c != this.c) goto L72;
        if (r9.d != this.d) goto L72;
        if (r9.b != this.b) goto L72;
        return true;
    L72:
        return false;
    }

    public final int hashCode() {
        int r0 = String.valueOf(this.l).hashCode();
        if (this.l != 2) goto L5;
        int r1 = String.valueOf(this.j).hashCode() + String.valueOf(this.i).hashCode();
        int r2 = this.h;
    L7:
        return r0 + (r1 + String.valueOf(r2).hashCode());
    L5:
        r1 = String.valueOf(this.c).hashCode() + String.valueOf(this.d).hashCode();
        r2 = this.b;
        goto L7
    }

    public final String a() {
        int r0 = this.l;
        if (r0 != 1) goto L5;
    L15:
        StringBuilder r1 = new StringBuilder();
        r1.append(this.l);
        r1.append("#");
        r1.append(this.a);
        r1.append("#");
        r1.append(this.b);
        r1.append("#0#");
        if (this.l != 5) goto L18;
        long r2 = this.e;
    L19:
        r1.append(r2);
        return r1.toString();
    L18:
        r2 = this.d;
        goto L19
    L5:
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L15;
        if (r0 == 4) goto L15;
        if (r0 == 5) goto L15;
        return null;
    L14:
        return this.l + "#" + this.h + "#" + this.i + "#" + this.j;
    }
}
