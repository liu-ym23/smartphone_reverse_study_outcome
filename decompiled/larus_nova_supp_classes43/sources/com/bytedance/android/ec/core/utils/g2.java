package com.bytedance.android.ec.core.utils;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g2 {
    public final List<i> a;
    public final String b;
    public final String c;

    public final String b() {
        if (((ArrayList) this.a).isEmpty() == true) goto L5;
        String r0 = e2.b(this.a, this.c);
        String r1 = this.b;
        if (r1 != null) goto L9;
        return r0;
    L9:
        if (r1.length() == 0) goto L22;
        int r10 = this.b.indexOf(63);
        if (r10 < 0) goto L20;
        if (this.b.indexOf(61, r10) <= 0) goto L18;
        int r11 = r10 + 1;
        return this.b.substring(0, r11) + r0 + "&" + this.b.substring(r11);
    L18:
        return this.b + "&" + r0;
    L20:
        return this.b + "?" + r0;
    L22:
        return r0;
    L5:
        return this.b;
    }

    public final String toString() {
        return b();
    }

    public g2(String r10) {
        this.a = new ArrayList();
        this.c = "UTF-8";
        this.b = r10;
    }

    public final void a(String r10, String r11) {
        List<i> r0 = this.a;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new i(r10, r11));
    }
}
