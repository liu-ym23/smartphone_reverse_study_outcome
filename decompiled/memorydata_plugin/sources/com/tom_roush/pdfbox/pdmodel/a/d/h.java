package com.tom_roush.pdfbox.pdmodel.a.d;

/* JADX INFO: loaded from: classes6.dex */
public class h extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16172a = "Table";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final String f16173b = "RowSpan";
    protected static final String c = "ColSpan";
    protected static final String d = "Headers";
    protected static final String e = "Scope";
    protected static final String f = "Summary";
    public static final String g = "Both";
    public static final String h = "Column";
    public static final String i = "Row";

    public h() {
        a("Table");
    }

    public h(com.tom_roush.pdfbox.a.d r1) {
        super(r1);
    }

    public void a(int r2) {
        b(f16173b, r2);
    }

    public void a(String[] r2) {
        a(d, r2);
    }

    public void b(int r2) {
        b(c, r2);
    }

    public void b(String r2) {
        d(e, r2);
    }

    public void c(String r2) {
        a(f, r2);
    }

    public int f() {
        return a(f16173b, 1);
    }

    public int g() {
        return a(c, 1);
    }

    public String[] h() {
        return r(d);
    }

    public String i() {
        return s(e);
    }

    public String j() {
        return q(f);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.a.a.a
    public String toString() {
        StringBuilder r0 = new StringBuilder().append(super.toString());
        if (p(f16173b) == false) goto L6;
        r0.append(", RowSpan=").append(f());
    L6:
        if (p(c) == false) goto L9;
        r0.append(", ColSpan=").append(g());
    L9:
        if (p(d) == false) goto L12;
        r0.append(", Headers=").append(a(h()));
    L12:
        if (p(e) == false) goto L15;
        r0.append(", Scope=").append(i());
    L15:
        if (p(f) == false) goto L18;
        r0.append(", Summary=").append(j());
    L18:
        return r0.toString();
    }
}
