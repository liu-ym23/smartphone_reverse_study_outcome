package com.ctc.wstx.d;

/* JADX INFO: loaded from: classes2.dex */
public class ae extends com.ctc.wstx.g.j {
    final boolean G;

    private ae(com.ctc.wstx.io.v r2, com.ctc.wstx.a.b r3) {
        this(r2, r3, false);
    }

    public ae(com.ctc.wstx.io.v r2, com.ctc.wstx.a.b r3, boolean r4) {
        super(r2, r3, r3.A());
        this.G = r4;
        this.Q = true;
    }

    private void a() {
        b();
        if (this.f3547J >= this.K) goto L5;
        char[] r0 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        char r2 = r0[r1];
    L7:
        if (r2 == ';') goto L10;
        this.f3547J--;
        return;
    L10:
        return;
    L5:
        r2 = h();
        goto L7
    }

    public static void a(com.ctc.wstx.io.u r1, com.ctc.wstx.io.v r2, com.ctc.wstx.a.b r3) {
        ae r0 = new ae(r2, r3);
        r0.a(r1);
        r0.g();     // Catch: Throwable -> L6
        r1.a(r0);
        return;
    L6:
        th = move-exception;
        r1.a(r0);
        throw th;
    }

    private void b() {
        k(j(n()));
    }

    private void e(char r3) {
    L3:
        if (r3 == '>') goto L19;
        if (this.f3547J >= this.K) goto L7;
        char[] r4 = this.I;
        int r0 = this.f3547J;
        this.f3547J = r0 + 1;
        r3 = r4[r0];
    L9:
        if (r3 == '\n') goto L18;
        if (r3 == '\r') goto L18;
        if (r3 == '\'') goto L17;
        if (r3 != '\"') goto L3;
    L17:
        f(r3);
    L18:
        g(r3);
        goto L3
    L7:
        r3 = h();
        goto L9
    }

    private void f(char r4) {
    L3:
        if (this.f3547J >= this.K) goto L5;
        char[] r0 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        char r2 = r0[r1];
    L7:
        if (r2 == '\n') goto L13;
        if (r2 == '\r') goto L13;
        if (r2 != r4) goto L3;
        return;
    L13:
        g(r2);
        goto L3
    L5:
        r2 = h();
        goto L7
    }

    public com.ctc.wstx.e.a a(String r1) {
        return null;
    }

    @Override // com.ctc.wstx.g.j
    public com.ctc.wstx.e.a a(String r1, Object r2) {
        o();
        return null;
    }

    @Override // com.ctc.wstx.g.j
    public void a(com.ctc.wstx.io.v r1) {
    }

    @Override // com.ctc.wstx.g.j
    public void d(String r1) {
    }

    public void g() {
    L2:
        int r0 = x();
        if (r0 >= 0) goto L6;
        h(" in internal DTD subset");
    L6:
        if (r0 == 37) goto L7;
        if (r0 == 60) goto L10;
        if (r0 == 93) goto L29;
        a(r0, " in internal DTD subset; expected a '<' to start a directive, or \"]>\" to end internal subset.");
        goto L2
    L29:
        if (this.T == this.U) goto L53;
        e("Encountered int. subset end marker ']]>' in an expanded entity; has to be at main level.");
        return;
    L53:
        return;
    L10:
        char r1 = j();
        if (r1 == '?') goto L12;
        if (r1 == '!') goto L15;
        this.f3547J--;
        goto L2
    L15:
        char r2 = j();
        if (r2 == '[') goto L2;
        if (r2 == '-') goto L20;
        if (r2 >= 'A') goto L24;
    L24:
        e(r2);
        goto L2
    L20:
        k();
        goto L2
    L12:
        m();
        goto L2
    L7:
        a();
        goto L2
    }

    @Override // com.ctc.wstx.g.f
    public final javax.xml.stream.a getLocation() {
        return r();
    }

    public char h() {
        if (this.f3547J >= this.K) goto L6;
        char[] r0 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        return r0[r1];
    L6:
        return k(n());
    }

    public char i() {
        if (this.f3547J >= this.K) goto L6;
        char[] r0 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        return r0[r1];
    L6:
        return j(n());
    }

    public char j() {
    L3:
        if (this.f3547J >= this.K) goto L5;
        char[] r0 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        char r2 = r0[r1];
    L7:
        if (r2 != '%') goto L8;
        a();
        goto L3
    L8:
        return r2;
    L5:
        r2 = j(n());
        goto L7
    }

    public void k() {
        l();
        if (this.f3547J >= this.K) goto L5;
        char[] r0 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        char r2 = r0[r1];
    L7:
        if (r2 == '>') goto L10;
        e("String '--' not allowed in comment (missing '>'?)");
        return;
    L10:
        return;
    L5:
        r2 = h();
        goto L7
    }

    public void l() {
    L3:
        if (this.f3547J >= this.K) goto L5;
        char[] r0 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        char r2 = r0[r1];
    L7:
        if (r2 == '-') goto L9;
        if (r2 == '\n') goto L18;
        if (r2 != '\r') goto L3;
    L18:
        g(r2);
        goto L3
    L9:
        if (this.f3547J >= this.K) goto L11;
        char[] r3 = this.I;
        int r4 = this.f3547J;
        this.f3547J = r4 + 1;
        char r5 = r3[r4];
    L12:
        if (r5 != '-') goto L3;
        return;
    L11:
        r5 = h();
        goto L12
    L5:
        r2 = h();
        goto L7
    }

    public void m() {
    L3:
        if (this.f3547J >= this.K) goto L5;
        char[] r0 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        char r2 = r0[r1];
    L7:
        if (r2 != '?') goto L17;
    L9:
        if (this.f3547J >= this.K) goto L11;
        char[] r3 = this.I;
        int r4 = this.f3547J;
        this.f3547J = r4 + 1;
        r2 = r3[r4];
    L12:
        if (r2 == '?') goto L9;
        if (r2 != '>') goto L17;
        return;
    L11:
        r2 = h();
    L17:
        if (r2 == '\n') goto L20;
        if (r2 != '\r') goto L3;
    L20:
        g(r2);
        goto L3
    L5:
        r2 = h();
        goto L7
    }

    public String n() {
        if (this.G == false) goto L5;
        return " in external DTD subset";
    L5:
        return " in internal DTD subset";
    }

    public void o() {
        throw new IllegalStateException("Internal error: this method should never be called");
    }
}
