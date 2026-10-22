package com.tom_roush.pdfbox.pdmodel.a.d;

/* JADX INFO: loaded from: classes6.dex */
public class e extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16168a = "List";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final String f16169b = "ListNumbering";
    public static final String c = "Circle";
    public static final String d = "Decimal";
    public static final String e = "Disc";
    public static final String f = "LowerAlpha";
    public static final String g = "LowerRoman";
    public static final String h = "None";
    public static final String i = "Square";
    public static final String j = "UpperAlpha";
    public static final String k = "UpperRoman";

    public e() {
        a(f16168a);
    }

    public e(com.tom_roush.pdfbox.a.d r1) {
        super(r1);
    }

    public void b(String r2) {
        d(f16169b, r2);
    }

    public String f() {
        return b(f16169b, "None");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.a.a.a
    public String toString() {
        StringBuilder r0 = new StringBuilder().append(super.toString());
        if (p(f16169b) == false) goto L6;
        r0.append(", ListNumbering=").append(f());
    L6:
        return r0.toString();
    }
}
