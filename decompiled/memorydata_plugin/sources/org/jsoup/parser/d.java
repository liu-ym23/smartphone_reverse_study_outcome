package org.jsoup.parser;

/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f18288a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f18289b = null;
    private final boolean c;
    private final boolean d;

    static {
        f18288a = new d(false, false);
        f18289b = new d(true, true);
    }

    public d(boolean r1, boolean r2) {
        this.c = r1;
        this.d = r2;
    }

    static String c(String r0) {
        return org.jsoup.a.a.a(r0.trim());
    }

    public String a(String r1) {
        String r2 = r1.trim();
        if (this.c == false) goto L5;
        return r2;
    L5:
        return org.jsoup.a.a.a(r2);
    }

    org.jsoup.nodes.b a(org.jsoup.nodes.b r1) {
        if (r1 != null) goto L4;
    L6:
        return r1;
    L4:
        if (this.d == true) goto L6;
        r1.f();
        goto L6
    }

    public boolean a() {
        return this.c;
    }

    public String b(String r1) {
        String r2 = r1.trim();
        if (this.d == false) goto L5;
        return r2;
    L5:
        return org.jsoup.a.a.a(r2);
    }

    public boolean b() {
        return this.d;
    }
}
