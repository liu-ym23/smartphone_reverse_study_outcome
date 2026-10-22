package com.bytedance.frameworks.baselib.network.http.cookie;

import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class f$b {
    public final String a;
    public final String b;
    public int c;
    public boolean d;

    public final void d() {
    L3:
        if (this.c >= this.a.length()) goto L8;
        if (" \t".indexOf(this.a.charAt(this.c)) == (-1)) goto L11;
        this.c++;
        goto L3
    L11:
        return;
    }

    public final boolean c() {
        d();
        if (this.c < this.a.length()) goto L5;
        return false;
    L5:
        if (this.a.charAt(this.c) != '=') goto L10;
        this.c++;
        return true;
    L10:
        return false;
    }

    public f$b(String r2) {
        this.c = 0;
        this.d = false;
        this.a = r2;
        this.b = r2.toLowerCase(Locale.US);
    }

    public final int a(String r4) {
        int r0 = this.c;
    L4:
        if (r0 >= this.a.length()) goto L10;
        if (r4.indexOf(this.a.charAt(r0)) != (-1)) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L10:
        return this.a.length();
    }

    public final String b(boolean r3) {
        d();
        int r0 = a(";= \t");
        if (r3 == false) goto L5;
        String r4 = this.b;
    L6:
        int r1 = this.c;
        if (r1 >= r0) goto L9;
        String r5 = r4.substring(r1, r0);
    L10:
        this.c = r0;
        return r5;
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = this.a;
        goto L6
    }
}
