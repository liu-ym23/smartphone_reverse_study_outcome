package com.ctc.wstx.io;

import com.ctc.wstx.exc.WstxException;
import com.ctc.wstx.exc.WstxParsingException;
import com.ctc.wstx.exc.WstxUnexpectedCharException;
import com.tencent.wcdb.BuildConfig;
import java.io.Reader;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f3533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final r f3534b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected String g;
    protected String h;
    protected boolean i;
    protected final char[] j;

    public k(String r3, r r4) {
        this.c = 0;
        this.d = 1;
        this.e = 0;
        this.f = 0;
        this.i = false;
        this.j = new char[60];
        this.f3533a = r3;
        this.f3534b = r4;
    }

    private final int a(int r4) {
        int r0 = j();
        if (r0 != r4) goto L6;
        return r0;
    L6:
        if (r0 <= 32) goto L9;
        a(r0, "; expected either '" + ((char) r4) + "' or white space");
    L9:
        if (r0 != 10) goto L11;
    L12:
        i();
    L14:
        return a(false);
    L11:
        if (r0 != 13) goto L14;
        goto L12
    }

    private final void a(String r3, String r4, String r5, String r6) {
        if (r5 != null) goto L4;
        String r7 = "";
    L5:
        if (r4 == null) goto L12;
        if (r4.length() == 0) goto L12;
        throw new WstxParsingException("Invalid XML pseudo-attribute '" + r3 + "' value " + r4 + r7, k());
    L12:
        throw new WstxParsingException("Missing XML pseudo-attribute '" + r3 + "' value" + r7, k());
    L4:
        r7 = "; expected \"" + r5 + "\" or \"" + r6 + "\"";
        goto L5
    }

    private final int c(String r6) {
        int r1 = a(false);
        if (r1 == 61) goto L5;
        a(r1, "; expected '=' after '" + r6 + "'");
    L5:
        int r0 = a(false);
        if (r0 != 34) goto L8;
    L10:
        return r0;
    L8:
        if (r0 == 39) goto L10;
        a(r0, "; expected a quote character enclosing value for '" + r6 + "'");
        goto L10
    }

    private final int m() {
        int r1 = a("version");
        if (r1 == 0) goto L5;
        a(r1, "version");
    L5:
        int r2 = c("version");
        int r3 = a(this.j, r2);
        if (r3 != 3) goto L18;
        char[] r4 = this.j;
        if (r4[0] != '1') goto L18;
        if (r4[1] != '.') goto L18;
        char r5 = r4[2];
        if (r5 != '0') goto L15;
        return 256;
    L15:
        if (r5 != '1') goto L18;
        return 272;
    L18:
        String r6 = "'";
        if (r3 >= 0) goto L22;
        StringBuilder r7 = new StringBuilder().append("'").append(new String(this.j));
        r6 = "[..]'";
    L21:
        String r8 = r7.append(r6).toString();
    L25:
        a("version", r8, "1.0", BuildConfig.VERSION_NAME);
        return 0;
    L22:
        if (r3 != 0) goto L24;
        r8 = "<empty>";
        goto L25
    L24:
        r7 = new StringBuilder().append("'").append(new String(this.j, 0, r3));
        goto L21
    }

    private final String n() {
        int r1 = a("encoding");
        if (r1 == 0) goto L5;
        a(r1, "encoding");
    L5:
        int r2 = c("encoding");
        int r3 = a(this.j, r2);
        if (r3 != 0) goto L8;
        a("encoding", null, null, null);
    L8:
        char[] r4 = this.j;
        if (r3 >= 0) goto L13;
        return new String(r4);
    L13:
        return new String(r4, 0, r3);
    }

    private final String o() {
        int r1 = a("standalone");
        if (r1 == 0) goto L5;
        a(r1, "standalone");
    L5:
        int r2 = c("standalone");
        int r3 = a(this.j, r2);
        if (r3 != 2) goto L13;
        char[] r5 = this.j;
        if (r5[0] == 'n') goto L10;
    L21:
        String r4 = "'";
        if (r3 >= 0) goto L25;
        StringBuilder r6 = new StringBuilder().append("'").append(new String(this.j));
        r4 = "[..]'";
    L24:
        String r7 = r6.append(r4).toString();
    L28:
        a("standalone", r7, "yes", "no");
        return r7;
    L25:
        if (r3 != 0) goto L27;
        r7 = "<empty>";
        goto L28
    L27:
        r6 = new StringBuilder().append("'").append(new String(this.j, 0, r3));
        goto L24
    L10:
        if (r5[1] != 'o') goto L21;
        return "no";
    L13:
        if (r3 != 3) goto L21;
        char[] r8 = this.j;
        if (r8[0] != 'y') goto L21;
        if (r8[1] != 'e') goto L21;
        if (r8[2] != 's') goto L21;
        return "yes";
    }

    public int a() {
        return this.f;
    }

    public abstract int a(String r1);

    public abstract int a(boolean r1);

    public abstract int a(char[] r1, int r2);

    public abstract Reader a(com.ctc.wstx.a.b r1, boolean r2, int r3);

    public void a(int r5, String r6) {
        char r0 = (char) r5;
        if (Character.isISOControl(r0) == false) goto L5;
        StringBuilder r1 = new StringBuilder();
        String r3 = "Unexpected character (CTRL-CHAR, code ";
    L7:
        throw new WstxUnexpectedCharException(r1.append(r3).append(r5).append(")").append(r6).toString(), k(), r0);
    L5:
        r1 = new StringBuilder().append("Unexpected character '").append(r0);
        r3 = "' (code ";
        goto L7
    }

    public void a(boolean r7, int r8) {
        boolean r0 = false;
        int r1 = a(false);
        if (r1 == 118) goto L6;
        if (r7 == false) goto L8;
        a(r1, "; expected keyword 'version'");
    L8:
        if (this.f != 272) goto L10;
        boolean r3 = true;
    L11:
        if (r8 == 0) goto L18;
        if (272 != r8) goto L14;
        r0 = true;
    L14:
        this.i = r0;
        if (r3 == false) goto L20;
        if (r0 == true) goto L20;
        b(com.ctc.wstx.b.a.t);
    L20:
        if (r1 == 101) goto L23;
        if (r7 == true) goto L24;
        a(r1, "; expected keyword 'encoding'");
    L24:
        if (r7 == false) goto L29;
        if (r1 != 115) goto L29;
        this.h = o();
        r1 = a(63);
    L29:
        if (r1 == 63) goto L31;
        a(r1, "; expected \"?>\" end marker");
    L31:
        int r9 = j();
        if (r9 == 62) goto L35;
        a(r9, "; expected \"?>\" end marker");
        return;
    L35:
        return;
    L23:
        this.g = n();
        r1 = a(63);
        goto L24
    L18:
        this.i = r3;
        goto L20
    L10:
        r3 = false;
        goto L11
    L6:
        this.f = m();
        r1 = a(63);
        goto L8
    }

    public void b(String r2) {
        throw new WstxParsingException(r2, k());
    }

    public boolean b() {
        if (this.f != 272) goto L5;
        return true;
    L5:
        return false;
    }

    public String c() {
        return this.h;
    }

    public String d() {
        return this.g;
    }

    public abstract int e();

    public int f() {
        return this.d;
    }

    public abstract int g();

    public abstract String h();

    public abstract void i();

    public abstract int j();

    public abstract javax.xml.stream.a k();

    public void l() {
        throw new WstxException("Illegal null byte in input stream", k());
    }
}
