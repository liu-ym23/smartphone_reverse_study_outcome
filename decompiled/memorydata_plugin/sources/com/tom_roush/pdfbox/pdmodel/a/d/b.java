package com.tom_roush.pdfbox.pdmodel.a.d;

/* JADX INFO: loaded from: classes6.dex */
public class b extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16162a = "XML-1.00";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16163b = "HTML-3.2";
    public static final String c = "HTML-4.01";
    public static final String d = "OEB-1.00";
    public static final String e = "RTF-1.05";
    public static final String f = "CSS-1.00";
    public static final String g = "CSS-2.00";

    public b(com.tom_roush.pdfbox.a.d r1) {
        super(r1);
    }

    public b(String r1) {
        a(r1);
    }

    public void a(int r2) {
        b("RowSpan", r2);
    }

    public void a(String[] r2) {
        a("Headers", r2);
    }

    public void b(int r2) {
        b("ColSpan", r2);
    }

    public void b(String r2) {
        d("ListNumbering", r2);
    }

    public void c(String r2) {
        d("Scope", r2);
    }

    public void d(String r2) {
        a("Summary", r2);
    }

    public String f() {
        return b("ListNumbering", "None");
    }

    public int g() {
        return a("RowSpan", 1);
    }

    public int h() {
        return a("ColSpan", 1);
    }

    public String[] i() {
        return r("Headers");
    }

    public String j() {
        return s("Scope");
    }

    public String k() {
        return q("Summary");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.a.d.d, com.tom_roush.pdfbox.pdmodel.a.a.a
    public String toString() {
        StringBuilder r0 = new StringBuilder().append(super.toString());
        if (p("ListNumbering") == false) goto L6;
        r0.append(", ListNumbering=").append(f());
    L6:
        if (p("RowSpan") == false) goto L9;
        r0.append(", RowSpan=").append(g());
    L9:
        if (p("ColSpan") == false) goto L12;
        r0.append(", ColSpan=").append(h());
    L12:
        if (p("Headers") == false) goto L15;
        r0.append(", Headers=").append(a(i()));
    L15:
        if (p("Scope") == false) goto L18;
        r0.append(", Scope=").append(j());
    L18:
        if (p("Summary") == false) goto L21;
        r0.append(", Summary=").append(k());
    L21:
        return r0.toString();
    }
}
