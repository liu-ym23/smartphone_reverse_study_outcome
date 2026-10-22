package com.tom_roush.pdfbox.pdmodel.a.d;

/* JADX INFO: loaded from: classes6.dex */
public class f extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16170a = "PrintField";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16171b = "rb";
    public static final String c = "cb";
    public static final String d = "pb";
    public static final String e = "tv";
    public static final String f = "on";
    public static final String g = "off";
    public static final String h = "neutral";
    private static final String i = "Role";
    private static final String j = "checked";
    private static final String k = "Desc";

    public f() {
        a(f16170a);
    }

    public f(com.tom_roush.pdfbox.a.d r1) {
        super(r1);
    }

    public void b(String r2) {
        d(i, r2);
    }

    public void c(String r2) {
        d(j, r2);
    }

    public void d(String r2) {
        a(k, r2);
    }

    public String f() {
        return s(i);
    }

    public String g() {
        return b(j, g);
    }

    public String h() {
        return q(k);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.a.a.a
    public String toString() {
        StringBuilder r0 = new StringBuilder().append(super.toString());
        if (p(i) == false) goto L6;
        r0.append(", Role=").append(f());
    L6:
        if (p(j) == false) goto L9;
        r0.append(", Checked=").append(g());
    L9:
        if (p(k) == false) goto L12;
        r0.append(", Desc=").append(h());
    L12:
        return r0.toString();
    }
}
