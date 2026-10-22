package org.jsoup.parser;

/* JADX INFO: loaded from: classes7.dex */
public class g {
    private static final String[] c = null;
    private static final String[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f18294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18295b;

    static {
        c = new String[]{"*|", "|", "_", "-"};
        d = new String[]{"-", "_"};
    }

    public g(String r2) {
        this.f18295b = 0;
        org.jsoup.helper.b.a(r2);
        this.f18294a = r2;
    }

    private String c(String... r6) {
        int r0 = this.f18295b;
        boolean r2 = false;
    L4:
        if (a() == true) goto L13;
        if (this.f18294a.charAt(this.f18295b) != '\\') goto L11;
        if (i() <= 1) goto L11;
        this.f18295b += 2;
        r2 = true;
    L11:
        if (d(r6) == false) goto L13;
        this.f18295b++;
    L13:
        String r5 = this.f18294a.substring(r0, this.f18295b);
        if (r2 == true) goto L16;
        return r5;
    L16:
        return f(r5);
    }

    private boolean d(String... r2) {
        if (c() == false) goto L5;
    L8:
        return true;
    L5:
        if (a(r2) == true) goto L8;
        return false;
    }

    public static String f(String r7) {
        StringBuilder r0 = org.jsoup.a.b.a();
        char[] r8 = r7.toCharArray();
        int r1 = r8.length;
        int r3 = 0;
        char r4 = 0;
    L3:
        if (r3 >= r1) goto L12;
        char r5 = r8[r3];
        if (r5 != '\\') goto L8;
        if (r4 != '\\') goto L9;
        r0.append(r5);
        r4 = 0;
    L10:
        r3 = r3 + 1;
    L9:
        r4 = r5;
        goto L10
    L8:
        r0.append(r5);
        goto L9
    L12:
        return org.jsoup.a.b.a(r0);
    }

    private int i() {
        return this.f18294a.length() - this.f18295b;
    }

    public String a(char r12, char r13) {
        int r5 = -1;
        int r6 = -1;
        char r2 = 0;
        boolean r3 = false;
        boolean r4 = false;
        int r7 = 0;
        boolean r8 = false;
    L4:
        if (a() == true) goto L38;
        char r9 = d();
        if (r2 == '\\') goto L29;
        if (r9 != '\'') goto L14;
        if (r9 == r12) goto L14;
        if (r3 == true) goto L14;
        r4 = !r4;
    L18:
        if (r4 == true) goto L37;
        if (r3 == true) goto L37;
        if (r8 == true) goto L37;
        if (r9 != r12) goto L26;
        r7 = r7 + 1;
        if (r5 != (-1)) goto L34;
        r5 = this.f18295b;
    L34:
        if (r7 <= 0) goto L37;
        if (r2 == 0) goto L37;
        r6 = this.f18295b;
        goto L37
    L26:
        if (r9 != r13) goto L34;
        r7 = r7 - 1;
    L37:
        if (r7 <= 0) goto L38;
        r2 = r9;
    L14:
        if (r9 != '\"') goto L18;
        if (r9 == r12) goto L18;
        if (r4 == true) goto L18;
        r3 = !r3;
        goto L18
    L29:
        if (r9 != 'Q') goto L32;
        r8 = true;
        goto L34
    L32:
        if (r9 != 'E') goto L34;
        r8 = false;
    L38:
        if (r6 < 0) goto L40;
        String r11 = this.f18294a.substring(r5, r6);
    L41:
        if (r7 <= 0) goto L43;
        org.jsoup.helper.b.b("Did not find balanced marker at '" + r11 + "'");
    L43:
        return r11;
    L40:
        r11 = "";
        goto L41
    }

    public boolean a() {
        if (i() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean a(String r7) {
        return this.f18294a.regionMatches(true, this.f18295b, r7, 0, r7.length());
    }

    public boolean a(char... r7) {
        if (a() == false) goto L5;
        return false;
    L5:
        int r0 = r7.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L12;
        if (this.f18294a.charAt(this.f18295b) == r7[r2]) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public boolean a(String... r5) {
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (a(r5[r2]) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public String b(String... r3) {
        int r0 = this.f18295b;
    L4:
        if (a() == true) goto L9;
        if (a(r3) == true) goto L9;
        this.f18295b++;
    L9:
        return this.f18294a.substring(r0, this.f18295b);
    }

    public boolean b() {
        if (a() == false) goto L5;
    L7:
        return false;
    L5:
        if (org.jsoup.a.b.a(this.f18294a.charAt(this.f18295b)) == false) goto L7;
        return true;
    }

    public boolean b(String r2) {
        if (a(r2) == false) goto L6;
        this.f18295b += r2.length();
        return true;
    L6:
        return false;
    }

    public void c(String r2) {
        if (a(r2) == false) goto L11;
        int r3 = r2.length();
        if (r3 > i()) goto L9;
        this.f18295b += r3;
        return;
    L9:
        throw new IllegalStateException("Queue not long enough to consume sequence");
    L11:
        throw new IllegalStateException("Queue did not match expected sequence");
    }

    public boolean c() {
        if (a() == false) goto L5;
    L7:
        return false;
    L5:
        if (Character.isLetterOrDigit(this.f18294a.charAt(this.f18295b)) == false) goto L7;
        return true;
    }

    public char d() {
        String r0 = this.f18294a;
        int r1 = this.f18295b;
        this.f18295b = r1 + 1;
        return r0.charAt(r1);
    }

    public String d(String r3) {
        int r4 = this.f18294a.indexOf(r3, this.f18295b);
        if (r4 == (-1)) goto L7;
        String r5 = this.f18294a.substring(this.f18295b, r4);
        this.f18295b += r5.length();
        return r5;
    L7:
        return h();
    }

    public String e(String r2) {
        String r0 = d(r2);
        b(r2);
        return r0;
    }

    public boolean e() {
        boolean r1 = false;
    L4:
        if (b() == false) goto L6;
        this.f18295b++;
        r1 = true;
        goto L4
    L6:
        return r1;
    }

    public String f() {
        return c(c);
    }

    public String g() {
        return c(d);
    }

    public String h() {
        String r0 = this.f18294a.substring(this.f18295b);
        this.f18295b = this.f18294a.length();
        return r0;
    }

    public String toString() {
        return this.f18294a.substring(this.f18295b);
    }
}
